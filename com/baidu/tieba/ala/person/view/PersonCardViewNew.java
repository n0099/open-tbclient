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
import com.baidu.live.c.f;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ac;
import com.baidu.live.data.ah;
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
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
/* loaded from: classes7.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private boolean aEw;
    private long bew;
    private PersonUserData bgE;
    private View fRU;
    private long fuJ;
    private boolean gOV;
    protected final PersonCardActivity gRM;
    private TextView gRN;
    private TextView gRO;
    private TextView gRP;
    private TextView gRQ;
    private TextView gRR;
    private TextView gRS;
    private TextView gRT;
    private TextView gRU;
    private TextView gRV;
    private TextView gRW;
    private TextView gRX;
    private LinearLayout gRY;
    private ImageView gRZ;
    private TextView gSa;
    private TextView gSb;
    private TextView gSc;
    private TextView gSd;
    private TextView gSe;
    private ViewGroup gSf;
    private HeadImageView gSg;
    private TbImageView gSh;
    private LinearLayout gSi;
    private View gSj;
    private View gSk;
    private View gSl;
    private View gSm;
    private HeadImageView gSn;
    private ViewGroup gSo;
    private boolean gSp;
    private String gSq;
    private boolean gSr;
    private boolean gSs;
    private a.InterfaceC0647a gSt;
    private com.baidu.tieba.ala.person.view.a gSu;
    private boolean gSv;
    private com.baidu.tieba.ala.person.a gSw;
    private a gSx;
    private Animation gfo;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes7.dex */
    public interface a {
        void bYg();

        void bYh();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.gRM = personCardActivity;
        this.gSv = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = lu(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.gSu = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.gSx = aVar;
    }

    private void initView() {
        this.gSj = this.mRootView.findViewById(a.g.person_card_layout);
        this.gRN = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.gRY = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.gRZ = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.gSa = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fRU = this.mRootView.findViewById(a.g.name_layout);
        this.gRO = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gRP = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.gRQ = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.gRR = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.gRT = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.gRS = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.gRU = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gRV = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.gRW = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.gSe = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.gRX = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.gSd = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.gSi = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.gSk = this.mRootView.findViewById(a.g.user_divide);
        this.gSl = this.mRootView.findViewById(a.g.user_divide2);
        this.gSb = (TextView) this.mRootView.findViewById(a.g.btn_person_card_nav_liveroom);
        this.gSc = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gSb.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.gSc.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.gSb.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
            this.gSc.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.gSf = (ViewGroup) this.mRootView.findViewById(a.g.layout_avatar);
        this.gSg = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gSg.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.gSg.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.gSg.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gSg.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.gSg.setIsRound(true);
        this.gSg.setAutoChangeStyle(false);
        this.gSg.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gSg.setBorderWidth(BdUtilHelper.getDimens(this.gRM.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.gSg.setBorderColor(-1);
        this.gRY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bYv();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRN.getLayoutParams();
        layoutParams.addRule(1, this.gRY.getId());
        this.gRN.setLayoutParams(layoutParams);
        this.gRZ.setVisibility(8);
        this.gSa.setText(a.i.ala_person_report);
        this.gSg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.gSq) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.gSq);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.gRM.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.gRM.finish();
                }
            }
        });
        this.gSm = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.gSn = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.gSn.setIsRound(true);
        this.gSn.setAutoChangeStyle(false);
        this.gSn.setDrawBorder(false);
        this.gSn.setDefaultBgResource(a.f.sdk_default_avatar);
        if (!this.gSv) {
            this.gSo = (ViewGroup) this.mRootView.findViewById(a.g.anchor_tag_layout);
            this.gSo.setVisibility(8);
        }
    }

    private void initListener() {
        this.gRN.setOnClickListener(this);
        this.gSb.setOnClickListener(this);
        this.gSc.setOnClickListener(this);
        this.gRX.setOnClickListener(this);
        a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0647a
            public void bYj() {
                PersonCardViewNew.this.gRM.bYe();
            }
        });
    }

    public void a(a.InterfaceC0647a interfaceC0647a) {
        this.gSt = interfaceC0647a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bgE = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            i(personUserData);
            this.gSu.setData(personUserData.user_info);
            if (this.gOV) {
                this.gSi.setVisibility(8);
            }
            if (this.gSi != null && this.gSi.getVisibility() == 0) {
                int childCount = this.gSi.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.gSi.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.gSi.getResources().getDimensionPixelOffset(i2 >= 3 ? a.e.sdk_ds20 : a.e.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.gSi.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.gSi.setWeightSum(i2);
                this.gSi.requestLayout();
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.gSv) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!ac.CK() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Cq()) {
                        this.gSo.setVisibility(8);
                        return;
                    }
                    this.gSo.setVisibility(0);
                    this.gSo.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Cp())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Cp().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Cp().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.gRM.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, uN(i));
                                this.gSo.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.gRM.getPageContext().getPageActivity());
                    alaPersonTagView2.setAddTagView();
                    alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PersonCardViewNew.this.gSx != null) {
                                PersonCardViewNew.this.gSx.bYh();
                            }
                        }
                    });
                    this.gSo.addView(alaPersonTagView2);
                    a(alaPersonTagView2, dimensionPixelSize2, dimensionPixelSize);
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

    private int uN(int i) {
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
            this.aEw = personUserData.user_info != null && this.gRM.GE(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.gSq = personUserData.user_info != null ? personUserData.user_info.aHX : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.gSr = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.gSr) {
                this.gSi.setVisibility(8);
            } else {
                this.gSi.setVisibility(0);
            }
            if (!z) {
                this.gRU.setText("火星");
            } else {
                this.gRU.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.gSd.setVisibility(8);
                this.gSl.setVisibility(8);
            } else {
                this.gSd.setText(String.format(this.gRM.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.gSl.setVisibility(0);
                this.gSd.setVisibility(0);
            }
            if (z2) {
                this.gRW.setText(String.format(this.gRM.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.gRW.setVisibility(0);
                this.gSk.setVisibility(0);
                return;
            }
            this.gRW.setVisibility(8);
            this.gSk.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYv() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.gRM.getActivity());
            this.gRM.finish();
        } else if (this.bgE != null && this.bgE.user_info != null && this.bgE.user_info.live_status == 1) {
            f fVar = new f(this.gRM);
            fVar.a(this.bew, this.fuJ, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bgE.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, fVar));
            this.gRM.finish();
        } else {
            if (this.gSw != null && this.gSw.isShowing()) {
                this.gSw.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.gRM.getActivity(), true);
            aVar.a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0647a
                public void bYj() {
                    if (PersonCardViewNew.this.gSt != null) {
                        PersonCardViewNew.this.gSt.bYj();
                    }
                }
            });
            aVar.show();
            this.gSw = aVar;
        }
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        ah ahVar = personUserData.user_info;
        if (ahVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(ahVar.fans_count < 0 ? 0L : ahVar.fans_count);
            this.gRP.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.gRR.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(ahVar.follow_count < 0 ? 0L : ahVar.follow_count);
            this.gRV.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.gRS.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.gRQ.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.gRT.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.gRT.setText("");
            }
            int i2 = this.gSv ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.gSv) {
                i = 22;
            }
            this.gRP.setTextSize(1, i);
            this.gRV.setTextSize(1, i);
            this.gRQ.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.gRN.setVisibility(8);
                this.gRY.setVisibility(8);
            } else if (this.gRM.GE(TbadkCoreApplication.getCurrentAccount())) {
                this.gRY.setVisibility(8);
                this.gRN.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds32), 0, 0);
                this.gRN.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.gRN.setVisibility(0);
                this.gRY.setVisibility(0);
            } else {
                this.gRY.setVisibility(0);
                this.gRN.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        ah ahVar = personUserData.user_info;
        if (ahVar != null && !StringUtils.isNull(ahVar.getNameShow())) {
            String nameShow = ahVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.gRO.setText(nameShow);
        }
        k.a(this.gSg, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(ahVar.description)) {
            this.gSe.setText(a.i.ala_person_desc_default_text);
        } else {
            this.gSe.setText(ahVar.description);
        }
        GG(ahVar.aHT);
    }

    private void GG(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.gSh == null) {
                this.gSh = new TbImageView(this.gSf.getContext());
            }
            this.gSh.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
                    if (z && str.equals(str2) && PersonCardViewNew.this.gSf != null && PersonCardViewNew.this.gSh != null && PersonCardViewNew.this.gSh.getLoadedWidth() > 0 && PersonCardViewNew.this.gSh.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f2 = resources.getDisplayMetrics().density;
                            if (f2 > 0.0f) {
                                f = 3.0f / f2;
                                if (!PersonCardViewNew.this.gSv) {
                                    realScreenWidth = resources.getDimensionPixelOffset(a.e.sdk_ds800);
                                } else {
                                    realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                                }
                                float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gSh.getLoadedWidth();
                                layoutParams = PersonCardViewNew.this.gSf.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.width = -1;
                                    layoutParams.height = (int) (PersonCardViewNew.this.gSh.getLoadedHeight() * loadedWidth);
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((f > 0.0f ? f : 1.0f) * (-resources.getDimensionPixelOffset(a.e.sdk_ds214)) * loadedWidth);
                                    }
                                    PersonCardViewNew.this.gSf.setLayoutParams(layoutParams);
                                }
                                if (PersonCardViewNew.this.gSg != null) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gSg.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams2.removeRule(14);
                                    } else {
                                        layoutParams2.addRule(14, 0);
                                    }
                                    layoutParams2.addRule(13);
                                    PersonCardViewNew.this.gSg.setLayoutParams(layoutParams2);
                                }
                                if (PersonCardViewNew.this.gSf.indexOfChild(PersonCardViewNew.this.gSh) < 0) {
                                    PersonCardViewNew.this.gSf.addView(PersonCardViewNew.this.gSh, PersonCardViewNew.this.gSf.indexOfChild(PersonCardViewNew.this.gSg) + 1, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (PersonCardViewNew.this.fRU != null) {
                                    ViewGroup.LayoutParams layoutParams3 = PersonCardViewNew.this.fRU.getLayoutParams();
                                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PersonCardViewNew.this.fRU.getLayoutParams();
                                        float dimensionPixelOffset = resources.getDimensionPixelOffset(a.e.sdk_ds192) * loadedWidth;
                                        if (f <= 0.0f) {
                                            f = 1.0f;
                                        }
                                        marginLayoutParams.topMargin = (int) (f * dimensionPixelOffset);
                                        PersonCardViewNew.this.fRU.setLayoutParams(layoutParams3);
                                    }
                                }
                                if (PersonCardViewNew.this.gRY.getVisibility() != 0 && PersonCardViewNew.this.gRN.getVisibility() == 0) {
                                    PersonCardViewNew.this.gRN.setPadding(PersonCardViewNew.this.gRN.getPaddingLeft(), PersonCardViewNew.this.gRN.getPaddingTop(), resources.getDimensionPixelOffset(a.e.sdk_ds16), PersonCardViewNew.this.gRN.getPaddingBottom());
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gRN.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams4.removeRule(1);
                                    } else {
                                        layoutParams4.addRule(1, 0);
                                    }
                                    layoutParams4.addRule(11);
                                    PersonCardViewNew.this.gRN.setLayoutParams(layoutParams4);
                                    return;
                                }
                            }
                        }
                        f = 0.0f;
                        if (!PersonCardViewNew.this.gSv) {
                        }
                        float loadedWidth2 = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gSh.getLoadedWidth();
                        layoutParams = PersonCardViewNew.this.gSf.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        if (PersonCardViewNew.this.gSg != null) {
                        }
                        if (PersonCardViewNew.this.gSf.indexOfChild(PersonCardViewNew.this.gSh) < 0) {
                        }
                        if (PersonCardViewNew.this.fRU != null) {
                        }
                        if (PersonCardViewNew.this.gRY.getVisibility() != 0) {
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gSh.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.gSp = false;
            mL(false);
        } else if (!this.gSr && (alaRelationData = personUserData.relation_info) != null) {
            this.gSp = alaRelationData.follow_status != 0;
            if (z) {
                this.gRX.setVisibility(8);
            } else {
                mL(this.gSp);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.gSm.setVisibility(0);
            this.gSm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.gSx != null) {
                        PersonCardViewNew.this.gSx.bYg();
                    }
                }
            });
            this.gSn.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.gSm.setVisibility(4);
    }

    private void mL(boolean z) {
        if (z) {
            this.gRX.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gRX.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.gRX.setTextColor(this.gRM.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.gRX.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.gRX.setTextColor(this.gRM.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.gRX.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gRX.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.gRX.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.gRX.setTextColor(this.gRM.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.gRX.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.gSb != null && personUserData != null && personUserData.user_info != null) {
            this.gSb.setVisibility((this.gSs && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gRX) {
            bYx();
        } else if (view == this.gSc) {
            bYr();
        } else if (view == this.gSb) {
            bYw();
        } else if (view == this.gRN) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.gRM, this.bgE}));
        }
    }

    private void bYw() {
        if (this.gRM != null && this.bgE != null && this.bgE.user_info != null && !TextUtils.isEmpty(this.bgE.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gRM.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bgE.user_info.live_id), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.gRM.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void bYr() {
        if (this.bgE != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gRM.getActivity());
            } else if (this.bgE.user_info == null || JavaTypesHelper.toLong(this.bgE.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gRM.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.bgE.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.gRM.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.beb = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bgE.user_info));
                this.gRM.finish();
            }
        }
    }

    private void bYx() {
        String str;
        if (this.bgE != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gRM.getActivity());
                this.gRM.finish();
            } else if (this.bgE.user_info == null || JavaTypesHelper.toLong(this.bgE.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gRM.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.gSp) {
                    uO(1);
                    this.gRM.bYd();
                } else {
                    uO(0);
                    this.gRM.bYc();
                    if (TbadkCoreApplication.getInst().isHaokan()) {
                        AlaStaticItem alaStaticItem = new AlaStaticItem(HKStaticKeys.HK_STATIC_FOLLOW_CLICK);
                        alaStaticItem.addParams("live_id", HKStaticManager.LIVE_ID);
                        alaStaticItem.addParams("room_id", HKStaticManager.ROOM_ID);
                        alaStaticItem.addParams("feed_id", HKStaticManager.FEED_ID);
                        alaStaticItem.addParams("other_params", this.otherParams);
                        AlaStaticsManager.getInst().onStatic(alaStaticItem);
                    }
                }
                if (TbadkCoreApplication.getInst().isQuanmin()) {
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.gSp ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aEw) {
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

    public void uO(int i) {
        switch (i) {
            case 0:
                this.gSp = true;
                mL(true);
                if (this.bgE != null && this.bgE.user_info != null) {
                    this.bgE.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bgE.user_info.fans_count >= 0 ? this.bgE.user_info.fans_count : 0L);
                    this.gRP.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.gRR.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.gSp = false;
                mL(false);
                if (this.bgE != null && this.bgE.user_info != null) {
                    this.bgE.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bgE.user_info.fans_count >= 0 ? this.bgE.user_info.fans_count : 0L);
                    this.gRP.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.gRR.setText(formatForPersonCardBeanValue2[1]);
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

    public void mM(boolean z) {
        if (this.bgE != null && this.bgE.user_info != null) {
            if (z) {
                this.bgE.user_info.follow_count++;
            } else {
                this.bgE.user_info.follow_count--;
            }
            if (this.bgE.user_info.follow_count < 0) {
                this.bgE.user_info.follow_count = 0L;
            }
            this.gRX.setText(com.baidu.tieba.ala.person.d.a.en(this.bgE.user_info.follow_count));
        }
    }

    private View lu(boolean z) {
        if (z) {
            return LayoutInflater.from(this.gRM.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.gRM.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void mN(boolean z) {
        this.gOV = z;
    }

    public void mO(boolean z) {
        this.gSs = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.gfo == null) {
                        PersonCardViewNew.this.gfo = AnimationUtils.loadAnimation(PersonCardViewNew.this.gRM.getActivity(), a.C0185a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.gSj.setAnimation(PersonCardViewNew.this.gfo);
                    PersonCardViewNew.this.gSj.setVisibility(0);
                    PersonCardViewNew.this.gfo.setDuration(300L);
                    PersonCardViewNew.this.gfo.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.gSj != null) {
            this.gSj.clearAnimation();
        }
        if (this.gSw != null && this.gSw.isShowing()) {
            this.gSw.dismiss();
        }
    }

    public Animation bLf() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gfo != null) {
            this.gfo.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.gRM.getActivity(), a.C0185a.sdk_push_up_out);
        this.gSj.setAnimation(loadAnimation);
        this.gSj.setVisibility(8);
        return loadAnimation;
    }

    public void baR() {
        if (this.gSw != null && this.gSw.isShowing()) {
            this.gSw.resize();
        }
        if (this.bgE != null && this.bgE.user_info != null) {
            GG(this.bgE.user_info.aHT);
        }
    }

    public void eh(String str, String str2) {
        this.bew = JavaTypesHelper.toLong(str, 0L);
        this.fuJ = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
