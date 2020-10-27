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
import com.baidu.live.b.g;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ak;
import com.baidu.live.data.ap;
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
    private boolean aJi;
    private View aWU;
    private long bmB;
    private PersonUserData boI;
    private long fSB;
    private Animation gEU;
    private boolean htB;
    private TextView hwA;
    private TextView hwB;
    private LinearLayout hwC;
    private ImageView hwD;
    private TextView hwE;
    private TextView hwF;
    private TextView hwG;
    private TextView hwH;
    private TextView hwI;
    private ViewGroup hwJ;
    private HeadImageView hwK;
    private TbImageView hwL;
    private LinearLayout hwM;
    private View hwN;
    private View hwO;
    private View hwP;
    private View hwQ;
    private HeadImageView hwR;
    private ViewGroup hwS;
    private boolean hwT;
    private String hwU;
    private boolean hwV;
    private boolean hwW;
    private a.InterfaceC0678a hwX;
    private com.baidu.tieba.ala.person.view.a hwY;
    private boolean hwZ;
    protected final PersonCardActivity hwq;
    private TextView hwr;
    private TextView hws;
    private TextView hwt;
    private TextView hwu;
    private TextView hwv;
    private TextView hww;
    private TextView hwx;
    private TextView hwy;
    private TextView hwz;
    private com.baidu.tieba.ala.person.a hxa;
    private a hxb;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes4.dex */
    public interface a {
        void cgD();

        void cgE();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.hwq = personCardActivity;
        this.hwZ = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = mm(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.hwY = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.hxb = aVar;
    }

    private void initView() {
        this.hwN = this.mRootView.findViewById(a.g.person_card_layout);
        this.hwr = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.hwC = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.hwD = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.hwE = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.aWU = this.mRootView.findViewById(a.g.name_layout);
        this.hws = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.hwt = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.hwu = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.hwv = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.hwx = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.hww = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.hwy = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.hwz = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.hwA = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.hwI = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.hwB = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.hwH = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.hwM = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.hwO = this.mRootView.findViewById(a.g.user_divide);
        this.hwP = this.mRootView.findViewById(a.g.user_divide2);
        this.hwF = (TextView) this.mRootView.findViewById(a.g.btn_person_card_nav_liveroom);
        this.hwG = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.hwF.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.hwG.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.hwF.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
            this.hwG.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.hwJ = (ViewGroup) this.mRootView.findViewById(a.g.layout_avatar);
        this.hwK = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.hwK.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.hwK.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.hwK.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.hwK.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.hwK.setIsRound(true);
        this.hwK.setAutoChangeStyle(false);
        this.hwK.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hwK.setBorderWidth(BdUtilHelper.getDimens(this.hwq.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.hwK.setBorderColor(872415231);
        this.hwC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cgS();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.hwr.getLayoutParams();
        layoutParams.addRule(1, this.hwC.getId());
        this.hwr.setLayoutParams(layoutParams);
        this.hwD.setVisibility(8);
        this.hwE.setText(a.i.ala_person_report);
        this.hwK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.hwU) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.hwU);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.hwq.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.hwq.finish();
                }
            }
        });
        this.hwQ = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.hwR = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.hwR.setIsRound(true);
        this.hwR.setAutoChangeStyle(false);
        this.hwR.setDrawBorder(false);
        this.hwR.setDefaultBgResource(a.f.sdk_default_avatar);
        if (!this.hwZ) {
            this.hwS = (ViewGroup) this.mRootView.findViewById(a.g.anchor_tag_layout);
            this.hwS.setVisibility(8);
        }
    }

    private void initListener() {
        this.hwr.setOnClickListener(this);
        this.hwF.setOnClickListener(this);
        this.hwG.setOnClickListener(this);
        this.hwB.setOnClickListener(this);
        a(new a.InterfaceC0678a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0678a
            public void cgG() {
                PersonCardViewNew.this.hwq.cgB();
            }
        });
    }

    public void a(a.InterfaceC0678a interfaceC0678a) {
        this.hwX = interfaceC0678a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.boI = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            i(personUserData);
            this.hwY.setData(personUserData.user_info);
            if (this.htB) {
                this.hwM.setVisibility(8);
            }
            if (this.hwM != null && this.hwM.getVisibility() == 0) {
                int childCount = this.hwM.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.hwM.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.hwM.getResources().getDimensionPixelOffset(i2 >= 3 ? a.e.sdk_ds20 : a.e.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.hwM.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        if (i4 == 0) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                        } else if (i4 == childCount - 1) {
                            ((ViewGroup.MarginLayoutParams) layoutParams).leftMargin = dimensionPixelOffset;
                        }
                    }
                }
                this.hwM.setWeightSum(i2);
                this.hwM.requestLayout();
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.hwZ) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!ak.Eg() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.DJ()) {
                        this.hwS.setVisibility(8);
                        return;
                    }
                    this.hwS.setVisibility(0);
                    this.hwS.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.DI())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.DI().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.DI().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.hwq.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, wg(i));
                                this.hwS.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    if (this.aJi && TbadkCoreApplication.isLogin()) {
                        AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.hwq.getPageContext().getPageActivity());
                        alaPersonTagView2.setAddTagView();
                        alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                            @Override // android.view.View.OnClickListener
                            public void onClick(View view) {
                                if (PersonCardViewNew.this.hxb != null) {
                                    PersonCardViewNew.this.hxb.cgE();
                                }
                            }
                        });
                        this.hwS.addView(alaPersonTagView2);
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

    private int wg(int i) {
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
            this.aJi = personUserData.user_info != null && this.hwq.Il(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.hwU = personUserData.user_info != null ? personUserData.user_info.aNe : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.hwV = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.hwV) {
                this.hwM.setVisibility(8);
            } else {
                this.hwM.setVisibility(0);
            }
            if (!z) {
                this.hwy.setText("火星");
            } else {
                this.hwy.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.hwH.setVisibility(8);
                this.hwP.setVisibility(8);
            } else {
                this.hwH.setText(String.format(this.hwq.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.hwP.setVisibility(0);
                this.hwH.setVisibility(0);
            }
            if (z2) {
                this.hwA.setText(String.format(this.hwq.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.hwA.setVisibility(0);
                this.hwO.setVisibility(0);
                return;
            }
            this.hwA.setVisibility(8);
            this.hwO.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cgS() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hwq.getActivity());
            this.hwq.finish();
        } else if (this.boI != null && this.boI.user_info != null && this.boI.user_info.live_status == 1) {
            g gVar = new g(this.hwq);
            gVar.a(this.bmB, this.fSB, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.boI.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hwq.finish();
        } else {
            if (this.hxa != null && this.hxa.isShowing()) {
                this.hxa.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hwq.getActivity(), true);
            aVar.a(new a.InterfaceC0678a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0678a
                public void cgG() {
                    if (PersonCardViewNew.this.hwX != null) {
                        PersonCardViewNew.this.hwX.cgG();
                    }
                }
            });
            aVar.show();
            this.hxa = aVar;
        }
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        ap apVar = personUserData.user_info;
        if (apVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(apVar.fans_count < 0 ? 0L : apVar.fans_count);
            this.hwt.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.hwv.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(apVar.follow_count < 0 ? 0L : apVar.follow_count);
            this.hwz.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.hww.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.hwu.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.hwx.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.hwx.setText("");
            }
            int i2 = this.hwZ ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.hwZ) {
                i = 22;
            }
            this.hwt.setTextSize(1, i);
            this.hwz.setTextSize(1, i);
            this.hwu.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hwr.setVisibility(8);
                this.hwC.setVisibility(8);
            } else if (this.hwq.Il(TbadkCoreApplication.getCurrentAccount())) {
                this.hwC.setVisibility(8);
                this.hwr.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds32), 0, 0);
                this.hwr.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hwr.setVisibility(0);
                this.hwC.setVisibility(0);
            } else {
                this.hwC.setVisibility(0);
                this.hwr.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        ap apVar = personUserData.user_info;
        if (apVar != null && !StringUtils.isNull(apVar.getNameShow())) {
            String nameShow = apVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.hws.setText(nameShow);
        }
        l.a(this.hwK, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(apVar.description)) {
            this.hwI.setText(a.i.ala_person_desc_default_text);
        } else {
            this.hwI.setText(apVar.description);
        }
        In(apVar.aNa);
    }

    private void In(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.hwL == null) {
                this.hwL = new TbImageView(this.hwJ.getContext());
            }
            this.hwL.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
                    if (z && str.equals(str2) && PersonCardViewNew.this.hwJ != null && PersonCardViewNew.this.hwL != null && PersonCardViewNew.this.hwL.getLoadedWidth() > 0 && PersonCardViewNew.this.hwL.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f2 = resources.getDisplayMetrics().density;
                            if (f2 > 0.0f) {
                                f = 3.0f / f2;
                                if (!PersonCardViewNew.this.hwZ) {
                                    realScreenWidth = resources.getDimensionPixelOffset(a.e.sdk_ds800);
                                } else {
                                    realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                                }
                                float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hwL.getLoadedWidth();
                                layoutParams = PersonCardViewNew.this.hwJ.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.width = -1;
                                    layoutParams.height = (int) (PersonCardViewNew.this.hwL.getLoadedHeight() * loadedWidth);
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((f > 0.0f ? f : 1.0f) * (-resources.getDimensionPixelOffset(a.e.sdk_ds214)) * loadedWidth);
                                    }
                                    PersonCardViewNew.this.hwJ.setLayoutParams(layoutParams);
                                }
                                if (PersonCardViewNew.this.hwK != null) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hwK.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams2.removeRule(14);
                                    } else {
                                        layoutParams2.addRule(14, 0);
                                    }
                                    layoutParams2.addRule(13);
                                    PersonCardViewNew.this.hwK.setLayoutParams(layoutParams2);
                                }
                                if (PersonCardViewNew.this.hwJ.indexOfChild(PersonCardViewNew.this.hwL) < 0) {
                                    PersonCardViewNew.this.hwJ.addView(PersonCardViewNew.this.hwL, PersonCardViewNew.this.hwJ.indexOfChild(PersonCardViewNew.this.hwK) + 1, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (PersonCardViewNew.this.aWU != null) {
                                    ViewGroup.LayoutParams layoutParams3 = PersonCardViewNew.this.aWU.getLayoutParams();
                                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PersonCardViewNew.this.aWU.getLayoutParams();
                                        float dimensionPixelOffset = resources.getDimensionPixelOffset(a.e.sdk_ds192) * loadedWidth;
                                        if (f <= 0.0f) {
                                            f = 1.0f;
                                        }
                                        marginLayoutParams.topMargin = (int) (f * dimensionPixelOffset);
                                        PersonCardViewNew.this.aWU.setLayoutParams(layoutParams3);
                                    }
                                }
                                if (PersonCardViewNew.this.hwC.getVisibility() != 0 && PersonCardViewNew.this.hwr.getVisibility() == 0) {
                                    PersonCardViewNew.this.hwr.setPadding(PersonCardViewNew.this.hwr.getPaddingLeft(), PersonCardViewNew.this.hwr.getPaddingTop(), resources.getDimensionPixelOffset(a.e.sdk_ds16), PersonCardViewNew.this.hwr.getPaddingBottom());
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.hwr.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams4.removeRule(1);
                                    } else {
                                        layoutParams4.addRule(1, 0);
                                    }
                                    layoutParams4.addRule(11);
                                    PersonCardViewNew.this.hwr.setLayoutParams(layoutParams4);
                                    return;
                                }
                            }
                        }
                        f = 0.0f;
                        if (!PersonCardViewNew.this.hwZ) {
                        }
                        float loadedWidth2 = (realScreenWidth * 1.0f) / PersonCardViewNew.this.hwL.getLoadedWidth();
                        layoutParams = PersonCardViewNew.this.hwJ.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        if (PersonCardViewNew.this.hwK != null) {
                        }
                        if (PersonCardViewNew.this.hwJ.indexOfChild(PersonCardViewNew.this.hwL) < 0) {
                        }
                        if (PersonCardViewNew.this.aWU != null) {
                        }
                        if (PersonCardViewNew.this.hwC.getVisibility() != 0) {
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.hwL.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.hwT = false;
            nL(false);
        } else if (!this.hwV && (alaRelationData = personUserData.relation_info) != null) {
            this.hwT = alaRelationData.follow_status != 0;
            if (z) {
                this.hwB.setVisibility(8);
            } else {
                nL(this.hwT);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.hwQ.setVisibility(0);
            this.hwQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.hxb != null) {
                        PersonCardViewNew.this.hxb.cgD();
                    }
                }
            });
            this.hwR.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.hwQ.setVisibility(4);
    }

    private void nL(boolean z) {
        if (z) {
            this.hwB.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hwB.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.hwB.setTextColor(this.hwq.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            } else {
                this.hwB.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.hwB.setTextColor(this.hwq.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.hwB.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.hwB.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.hwB.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.hwB.setTextColor(this.hwq.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.hwB.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.hwF != null && personUserData != null && personUserData.user_info != null) {
            this.hwF.setVisibility((this.hwW && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hwB) {
            cgU();
        } else if (view == this.hwG) {
            cgO();
        } else if (view == this.hwF) {
            cgT();
        } else if (view == this.hwr) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hwq, this.boI}));
        }
    }

    private void cgT() {
        if (this.hwq != null && this.boI != null && this.boI.user_info != null && !TextUtils.isEmpty(this.boI.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.hwq.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.boI.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.hwq.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cgO() {
        if (this.boI != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hwq.getActivity());
            } else if (this.boI.user_info == null || JavaTypesHelper.toLong(this.boI.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hwq.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.boI.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hwq.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bmf = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.boI.user_info));
                this.hwq.finish();
            }
        }
    }

    private void cgU() {
        String str;
        if (this.boI != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hwq.getActivity());
                this.hwq.finish();
            } else if (this.boI.user_info == null || JavaTypesHelper.toLong(this.boI.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hwq.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.hwT) {
                    wh(1);
                    this.hwq.cgA();
                } else {
                    wh(0);
                    this.hwq.cgz();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.hwT ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aJi) {
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

    public void wh(int i) {
        switch (i) {
            case 0:
                this.hwT = true;
                nL(true);
                if (this.boI != null && this.boI.user_info != null) {
                    this.boI.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.boI.user_info.fans_count >= 0 ? this.boI.user_info.fans_count : 0L);
                    this.hwt.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.hwv.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.hwT = false;
                nL(false);
                if (this.boI != null && this.boI.user_info != null) {
                    this.boI.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.boI.user_info.fans_count >= 0 ? this.boI.user_info.fans_count : 0L);
                    this.hwt.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.hwv.setText(formatForPersonCardBeanValue2[1]);
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

    public void nM(boolean z) {
        if (this.boI != null && this.boI.user_info != null) {
            if (z) {
                this.boI.user_info.follow_count++;
            } else {
                this.boI.user_info.follow_count--;
            }
            if (this.boI.user_info.follow_count < 0) {
                this.boI.user_info.follow_count = 0L;
            }
            this.hwB.setText(com.baidu.tieba.ala.person.d.a.as(this.boI.user_info.follow_count));
        }
    }

    private View mm(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hwq.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hwq.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void nN(boolean z) {
        this.htB = z;
    }

    public void nO(boolean z) {
        this.hwW = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.gEU == null) {
                        PersonCardViewNew.this.gEU = AnimationUtils.loadAnimation(PersonCardViewNew.this.hwq.getActivity(), a.C0195a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.hwN.setAnimation(PersonCardViewNew.this.gEU);
                    PersonCardViewNew.this.hwN.setVisibility(0);
                    PersonCardViewNew.this.gEU.setDuration(300L);
                    PersonCardViewNew.this.gEU.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hwN != null) {
            this.hwN.clearAnimation();
        }
        if (this.hxa != null && this.hxa.isShowing()) {
            this.hxa.dismiss();
        }
    }

    public Animation bRF() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gEU != null) {
            this.gEU.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hwq.getActivity(), a.C0195a.sdk_push_up_out);
        this.hwN.setAnimation(loadAnimation);
        this.hwN.setVisibility(8);
        return loadAnimation;
    }

    public void bgm() {
        if (this.hxa != null && this.hxa.isShowing()) {
            this.hxa.resize();
        }
        if (this.boI != null && this.boI.user_info != null) {
            In(this.boI.user_info.aNa);
        }
    }

    public void aP(String str, String str2) {
        this.bmB = JavaTypesHelper.toLong(str, 0L);
        this.fSB = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
