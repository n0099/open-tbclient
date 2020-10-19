package com.baidu.tieba.ala.person.view;

import android.content.res.Resources;
import android.os.Build;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.b.f;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ah;
import com.baidu.live.data.am;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaLiveRoomActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
import com.baidu.live.tbadk.schemeability.ISchemeAbility;
import com.baidu.live.tbadk.schemeability.SchemeAbilityManager;
import com.baidu.live.tbadk.statics.AlaStaticItem;
import com.baidu.live.tbadk.statics.AlaStaticsManager;
import com.baidu.live.tbadk.statics.HKStaticKeys;
import com.baidu.live.tbadk.statics.HKStaticManager;
import com.baidu.live.tbadk.statics.QMStaticKeys;
import com.baidu.live.tbadk.statics.QMStaticManager;
import com.baidu.live.tbadk.util.ScreenHelper;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.utils.l;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
/* loaded from: classes4.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private boolean aIH;
    private View aVz;
    private long blh;
    private PersonUserData bnk;
    private long fKh;
    private Animation guQ;
    private boolean hhE;
    private TextView hkA;
    private TextView hkB;
    private TextView hkC;
    private TextView hkD;
    private TextView hkE;
    private TextView hkF;
    private TextView hkG;
    private LinearLayout hkH;
    private ImageView hkI;
    private TextView hkJ;
    private TextView hkK;
    private TextView hkL;
    private TextView hkM;
    private TextView hkN;
    private ViewGroup hkO;
    private HeadImageView hkP;
    private TbImageView hkQ;
    private LinearLayout hkR;
    private View hkS;
    private View hkT;
    private View hkU;
    private View hkV;
    private HeadImageView hkW;
    private ViewGroup hkX;
    private boolean hkY;
    private String hkZ;
    protected final PersonCardActivity hkv;
    private TextView hkw;
    private TextView hkx;
    private TextView hky;
    private TextView hkz;
    private boolean hla;
    private boolean hlb;
    private a.InterfaceC0662a hlc;
    private com.baidu.tieba.ala.person.view.a hld;
    private boolean hle;
    private com.baidu.tieba.ala.person.a hlf;
    private a hlg;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes4.dex */
    public interface a {
        void cdB();

        void cdC();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.hkv = personCardActivity;
        this.hle = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = lW(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.hld = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.hlg = aVar;
    }

    private void initView() {
        this.hkS = this.mRootView.findViewById(a.g.person_card_layout);
        this.hkw = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.hkH = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.hkI = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.hkJ = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.aVz = this.mRootView.findViewById(a.g.name_layout);
        this.hkx = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.hky = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.hkz = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.hkA = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.hkC = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.hkB = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.hkD = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.hkE = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.hkF = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.hkN = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.hkG = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.hkM = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.hkR = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.hkT = this.mRootView.findViewById(a.g.user_divide);
        this.hkU = this.mRootView.findViewById(a.g.user_divide2);
        this.hkK = (TextView) this.mRootView.findViewById(a.g.btn_person_card_nav_liveroom);
        this.hkL = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hkK.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.hkL.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.hkK.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
            this.hkL.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.hkO = (ViewGroup) this.mRootView.findViewById(a.g.layout_avatar);
        this.hkP = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hkP.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.hkP.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hkP.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.hkP.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.hkP.setIsRound(true);
        this.hkP.setAutoChangeStyle(false);
        this.hkP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hkP.setBorderWidth(BdUtilHelper.getDimens(this.hkv.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.hkP.setBorderColor(872415231);
        this.hkH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cdQ();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hkw.getLayoutParams();
        layoutParams.addRule(1, this.hkH.getId());
        this.hkw.setLayoutParams(layoutParams);
        this.hkI.setVisibility(8);
        this.hkJ.setText(a.i.ala_person_report);
        this.hkP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hkZ) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hkZ);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hkv.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hkv.finish();
                }
            }
        });
        this.hkV = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.hkW = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.hkW.setIsRound(true);
        this.hkW.setAutoChangeStyle(false);
        this.hkW.setDrawBorder(false);
        this.hkW.setDefaultBgResource(a.f.sdk_default_avatar);
        if (!this.hle) {
            this.hkX = (ViewGroup) this.mRootView.findViewById(a.g.anchor_tag_layout);
            this.hkX.setVisibility(8);
        }
    }

    private void initListener() {
        this.hkw.setOnClickListener(this);
        this.hkK.setOnClickListener(this);
        this.hkL.setOnClickListener(this);
        this.hkG.setOnClickListener(this);
        a(new a.InterfaceC0662a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0662a
            public void cdE() {
                PersonCardViewNew.this.hkv.cdz();
            }
        });
    }

    public void a(a.InterfaceC0662a interfaceC0662a) {
        this.hlc = interfaceC0662a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bnk = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            i(personUserData);
            this.hld.setData(personUserData.user_info);
            if (this.hhE) {
                this.hkR.setVisibility(8);
            }
            if (this.hkR != null && this.hkR.getVisibility() == 0) {
                int childCount = this.hkR.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hkR.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hkR.getResources().getDimensionPixelOffset(i2 >= 3 ? a.e.sdk_ds20 : a.e.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hkR.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        if (i4 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                        } else if (i4 == childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = dimensionPixelOffset;
                        }
                    }
                }
                this.hkR.setWeightSum(i2);
                this.hkR.requestLayout();
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.hle) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!ah.DX() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.DC()) {
                        this.hkX.setVisibility(8);
                        return;
                    }
                    this.hkX.setVisibility(0);
                    this.hkX.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.DB())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.DB().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.DB().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hkv.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, vM(i));
                                this.hkX.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aIH && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hkv.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.hlg != null) {
                                    PersonCardViewNew.this.hlg.cdC();
                                }
                            }
                        });
                        this.hkX.addView(alaPersonTagView2);
                        a(alaPersonTagView2, dimensionPixelSize2, dimensionPixelSize);
                    }
                }
            }
        }
    }

    private void a(AlaPersonTagView alaPersonTagView, int i, int i2) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) alaPersonTagView.getLayoutParams();
        marginLayoutParams.leftMargin = i;
        marginLayoutParams.rightMargin = i;
        marginLayoutParams.height = i2;
        alaPersonTagView.setLayoutParams(marginLayoutParams);
    }

    private int vM(int i) {
        if (i == 0) {
            return a.f.bg_tag_checked1;
        }
        if (i == 1) {
            return a.f.bg_tag_checked2;
        }
        return a.f.bg_tag_checked3;
    }

    private void e(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aIH = personUserData.user_info != null && this.hkv.HM(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hkZ = personUserData.user_info != null ? personUserData.user_info.aMz : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.hla = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.hla) {
                this.hkR.setVisibility(8);
            } else {
                this.hkR.setVisibility(0);
            }
            if (!z) {
                this.hkD.setText("火星");
            } else {
                this.hkD.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hkM.setVisibility(8);
                this.hkU.setVisibility(8);
            } else {
                this.hkM.setText(String.format(this.hkv.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hkU.setVisibility(0);
                this.hkM.setVisibility(0);
            }
            if (z2) {
                this.hkF.setText(String.format(this.hkv.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hkF.setVisibility(0);
                this.hkT.setVisibility(0);
                return;
            }
            this.hkF.setVisibility(8);
            this.hkT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cdQ() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hkv.getActivity());
            this.hkv.finish();
        } else if (this.bnk != null && this.bnk.user_info != null && this.bnk.user_info.live_status == 1) {
            f fVar = new f(this.hkv);
            fVar.a(this.blh, this.fKh, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bnk.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, fVar));
            this.hkv.finish();
        } else {
            if (this.hlf != null && this.hlf.isShowing()) {
                this.hlf.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hkv.getActivity(), true);
            aVar.a(new a.InterfaceC0662a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0662a
                public void cdE() {
                    if (PersonCardViewNew.this.hlc != null) {
                        PersonCardViewNew.this.hlc.cdE();
                    }
                }
            });
            aVar.show();
            this.hlf = aVar;
        }
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        am amVar = personUserData.user_info;
        if (amVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(amVar.fans_count < 0 ? 0L : amVar.fans_count);
            this.hky.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hkA.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(amVar.follow_count < 0 ? 0L : amVar.follow_count);
            this.hkE.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hkB.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hkz.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hkC.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hkC.setText("");
            }
            int i2 = this.hle ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hle) {
                i = 22;
            }
            this.hky.setTextSize(1, i);
            this.hkE.setTextSize(1, i);
            this.hkz.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hkw.setVisibility(8);
                this.hkH.setVisibility(8);
            } else if (this.hkv.HM(TbadkCoreApplication.getCurrentAccount())) {
                this.hkH.setVisibility(8);
                this.hkw.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds32), 0, 0);
                this.hkw.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hkw.setVisibility(0);
                this.hkH.setVisibility(0);
            } else {
                this.hkH.setVisibility(0);
                this.hkw.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        am amVar = personUserData.user_info;
        if (amVar != null && !StringUtils.isNull(amVar.getNameShow())) {
            String nameShow = amVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hkx.setText(nameShow);
        }
        l.a(this.hkP, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(amVar.description)) {
            this.hkN.setText(a.i.ala_person_desc_default_text);
        } else {
            this.hkN.setText(amVar.description);
        }
        HO(amVar.aMv);
    }

    private void HO(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hkQ == null) {
                this.hkQ = new TbImageView(this.hkO.getContext());
            }
            this.hkQ.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
                /* JADX WARN: Removed duplicated region for block: B:24:0x0060  */
                /* JADX WARN: Removed duplicated region for block: B:27:0x0081  */
                /* JADX WARN: Removed duplicated region for block: B:36:0x00bd  */
                /* JADX WARN: Removed duplicated region for block: B:42:0x00f4  */
                /* JADX WARN: Removed duplicated region for block: B:45:0x0122  */
                /* JADX WARN: Removed duplicated region for block: B:58:0x01bf  */
                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onComplete(String str2, boolean z) {
                    Resources resources;
                    float f;
                    int realScreenWidth;
                    ViewGroup.LayoutParams layoutParams;
                    if (z && str.equals(str2) && PersonCardViewNew.this.hkO != null && PersonCardViewNew.this.hkQ != null && PersonCardViewNew.this.hkQ.getLoadedWidth() > 0 && PersonCardViewNew.this.hkQ.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f2 = resources.getDisplayMetrics().density;
                            if (f2 > 0.0f) {
                                f = 3.0f / f2;
                                if (!PersonCardViewNew.this.hle) {
                                    realScreenWidth = resources.getDimensionPixelOffset(a.e.sdk_ds800);
                                } else {
                                    realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                                }
                                float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hkQ.getLoadedWidth();
                                layoutParams = PersonCardViewNew.this.hkO.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.width = -1;
                                    layoutParams.height = (int) (PersonCardViewNew.this.hkQ.getLoadedHeight() * loadedWidth);
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((f > 0.0f ? f : 1.0f) * (-resources.getDimensionPixelOffset(a.e.sdk_ds214)) * loadedWidth);
                                    }
                                    PersonCardViewNew.this.hkO.setLayoutParams(layoutParams);
                                }
                                if (PersonCardViewNew.this.hkP != null) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hkP.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams2.removeRule(14);
                                    } else {
                                        layoutParams2.addRule(14, 0);
                                    }
                                    layoutParams2.addRule(13);
                                    PersonCardViewNew.this.hkP.setLayoutParams(layoutParams2);
                                }
                                if (PersonCardViewNew.this.hkO.indexOfChild(PersonCardViewNew.this.hkQ) < 0) {
                                    PersonCardViewNew.this.hkO.addView(PersonCardViewNew.this.hkQ, PersonCardViewNew.this.hkO.indexOfChild(PersonCardViewNew.this.hkP) + 1, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (PersonCardViewNew.this.aVz != null) {
                                    ViewGroup.LayoutParams layoutParams3 = PersonCardViewNew.this.aVz.getLayoutParams();
                                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PersonCardViewNew.this.aVz.getLayoutParams();
                                        float dimensionPixelOffset = resources.getDimensionPixelOffset(a.e.sdk_ds192) * loadedWidth;
                                        if (f <= 0.0f) {
                                            f = 1.0f;
                                        }
                                        marginLayoutParams.topMargin = (int) (f * dimensionPixelOffset);
                                        PersonCardViewNew.this.aVz.setLayoutParams(layoutParams3);
                                    }
                                }
                                if (PersonCardViewNew.this.hkH.getVisibility() != 0 && PersonCardViewNew.this.hkw.getVisibility() == 0) {
                                    PersonCardViewNew.this.hkw.setPadding(PersonCardViewNew.this.hkw.getPaddingLeft(), PersonCardViewNew.this.hkw.getPaddingTop(), resources.getDimensionPixelOffset(a.e.sdk_ds16), PersonCardViewNew.this.hkw.getPaddingBottom());
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hkw.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams4.removeRule(1);
                                    } else {
                                        layoutParams4.addRule(1, 0);
                                    }
                                    layoutParams4.addRule(11);
                                    PersonCardViewNew.this.hkw.setLayoutParams(layoutParams4);
                                    return;
                                }
                            }
                        }
                        f = 0.0f;
                        if (!PersonCardViewNew.this.hle) {
                        }
                        float loadedWidth2 = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hkQ.getLoadedWidth();
                        layoutParams = PersonCardViewNew.this.hkO.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        if (PersonCardViewNew.this.hkP != null) {
                        }
                        if (PersonCardViewNew.this.hkO.indexOfChild(PersonCardViewNew.this.hkQ) < 0) {
                        }
                        if (PersonCardViewNew.this.aVz != null) {
                        }
                        if (PersonCardViewNew.this.hkH.getVisibility() != 0) {
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hkQ.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hkY = false;
            nu(false);
        } else if (!this.hla && (alaRelationData = personUserData.relation_info) != null) {
            this.hkY = alaRelationData.follow_status != 0;
            if (z) {
                this.hkG.setVisibility(8);
            } else {
                nu(this.hkY);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hkV.setVisibility(0);
            this.hkV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.hlg != null) {
                        PersonCardViewNew.this.hlg.cdB();
                    }
                }
            });
            this.hkW.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hkV.setVisibility(4);
    }

    private void nu(boolean z) {
        if (z) {
            this.hkG.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hkG.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.hkG.setTextColor(this.hkv.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            } else {
                this.hkG.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.hkG.setTextColor(this.hkv.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.hkG.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hkG.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.hkG.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.hkG.setTextColor(this.hkv.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.hkG.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hkK != null && personUserData != null && personUserData.user_info != null) {
            this.hkK.setVisibility((this.hlb && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hkG) {
            cdS();
        } else if (view == this.hkL) {
            cdM();
        } else if (view == this.hkK) {
            cdR();
        } else if (view == this.hkw) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hkv, this.bnk}));
        }
    }

    private void cdR() {
        if (this.hkv != null && this.bnk != null && this.bnk.user_info != null && !TextUtils.isEmpty(this.bnk.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hkv.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bnk.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.hkv.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cdM() {
        if (this.bnk != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hkv.getActivity());
            } else if (this.bnk.user_info == null || JavaTypesHelper.toLong(this.bnk.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hkv.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.bnk.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hkv.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bkK = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bnk.user_info));
                this.hkv.finish();
            }
        }
    }

    private void cdS() {
        String str;
        if (this.bnk != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hkv.getActivity());
                this.hkv.finish();
            } else if (this.bnk.user_info == null || JavaTypesHelper.toLong(this.bnk.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hkv.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.hkY) {
                    vN(1);
                    this.hkv.cdy();
                } else {
                    vN(0);
                    this.hkv.cdx();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin() || TbadkCoreApplication.getInst().isYinbo()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hkY ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aIH) {
                        str = "author_profile";
                    } else {
                        str = "guest_profile";
                    }
                    alaStaticItem2.addParams("loc", str);
                    alaStaticItem2.addParams("other_params", this.otherParams);
                    AlaStaticsManager.getInst().onStatic(alaStaticItem2);
                }
            }
        }
    }

    public void vN(int i) {
        switch (i) {
            case 0:
                this.hkY = true;
                nu(true);
                if (this.bnk != null && this.bnk.user_info != null) {
                    this.bnk.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bnk.user_info.fans_count >= 0 ? this.bnk.user_info.fans_count : 0L);
                    this.hky.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hkA.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hkY = false;
                nu(false);
                if (this.bnk != null && this.bnk.user_info != null) {
                    this.bnk.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bnk.user_info.fans_count >= 0 ? this.bnk.user_info.fans_count : 0L);
                    this.hky.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hkA.setText(formatForPersonCardBeanValue2[1]);
                        return;
                    }
                    return;
                }
                return;
            default:
                return;
        }
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrolled(int i, float f, int i2) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageSelected(int i) {
    }

    @Override // android.support.v4.view.ViewPager.OnPageChangeListener
    public void onPageScrollStateChanged(int i) {
    }

    public void nv(boolean z) {
        if (this.bnk != null && this.bnk.user_info != null) {
            if (z) {
                this.bnk.user_info.follow_count++;
            } else {
                this.bnk.user_info.follow_count--;
            }
            if (this.bnk.user_info.follow_count < 0) {
                this.bnk.user_info.follow_count = 0L;
            }
            this.hkG.setText(com.baidu.tieba.ala.person.d.a.eL(this.bnk.user_info.follow_count));
        }
    }

    private View lW(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hkv.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hkv.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void nw(boolean z) {
        this.hhE = z;
    }

    public void nx(boolean z) {
        this.hlb = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.guQ == null) {
                        PersonCardViewNew.this.guQ = AnimationUtils.loadAnimation(PersonCardViewNew.this.hkv.getActivity(), a.C0194a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hkS.setAnimation(PersonCardViewNew.this.guQ);
                    PersonCardViewNew.this.hkS.setVisibility(0);
                    PersonCardViewNew.this.guQ.setDuration(300L);
                    PersonCardViewNew.this.guQ.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hkS != null) {
            this.hkS.clearAnimation();
        }
        if (this.hlf != null && this.hlf.isShowing()) {
            this.hlf.dismiss();
        }
    }

    public Animation bPa() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.guQ != null) {
            this.guQ.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hkv.getActivity(), a.C0194a.sdk_push_up_out);
        this.hkS.setAnimation(loadAnimation);
        this.hkS.setVisibility(8);
        return loadAnimation;
    }

    public void bet() {
        if (this.hlf != null && this.hlf.isShowing()) {
            this.hlf.resize();
        }
        if (this.bnk != null && this.bnk.user_info != null) {
            HO(this.bnk.user_info.aMv);
        }
    }

    public void et(String str, String str2) {
        this.blh = JavaTypesHelper.toLong(str, 0L);
        this.fKh = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
