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
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ad;
import com.baidu.live.data.z;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
/* loaded from: classes3.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private PersonUserData aYt;
    private boolean avR;
    private Animation fCC;
    private View fpX;
    private boolean gjX;
    protected final PersonCardActivity gmO;
    private TextView gmP;
    private TextView gmQ;
    private TextView gmR;
    private TextView gmS;
    private TextView gmT;
    private TextView gmU;
    private TextView gmV;
    private TextView gmW;
    private TextView gmX;
    private TextView gmY;
    private TextView gmZ;
    private LinearLayout gna;
    private ImageView gnb;
    private TextView gnc;
    private TextView gnd;
    private TextView gne;
    private TextView gnf;
    private ViewGroup gng;
    private HeadImageView gnh;
    private TbImageView gni;
    private LinearLayout gnj;
    private View gnk;
    private View gnl;
    private View gnm;
    private View gnn;
    private HeadImageView gno;
    private ViewGroup gnp;
    private boolean gnq;
    private String gnr;
    private boolean gns;
    private a.InterfaceC0579a gnt;
    private com.baidu.tieba.ala.person.view.a gnu;
    private boolean gnv;
    private com.baidu.tieba.ala.person.a gnw;
    private a gnx;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes3.dex */
    public interface a {
        void bHQ();

        void bHR();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.gmO = personCardActivity;
        this.gnv = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = kc(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.gnu = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.gnx = aVar;
    }

    private void initView() {
        this.gnk = this.mRootView.findViewById(a.g.person_card_layout);
        this.gmP = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.gna = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.gnb = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.gnc = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fpX = this.mRootView.findViewById(a.g.name_layout);
        this.gmQ = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gmR = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.gmS = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.gmT = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.gmV = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.gmU = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.gmW = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gmX = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.gmY = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.gnf = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.gmZ = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.gne = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.gnj = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.gnl = this.mRootView.findViewById(a.g.user_divide);
        this.gnm = this.mRootView.findViewById(a.g.user_divide2);
        this.gnd = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gnd.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.gnd.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.gng = (ViewGroup) this.mRootView.findViewById(a.g.layout_avatar);
        this.gnh = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gnh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.gnh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.gnh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gnh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.gnh.setIsRound(true);
        this.gnh.setAutoChangeStyle(false);
        this.gnh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gnh.setBorderWidth(BdUtilHelper.getDimens(this.gmO.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.gnh.setBorderColor(-1);
        this.gna.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bIg();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gmP.getLayoutParams();
        layoutParams.addRule(1, this.gna.getId());
        this.gmP.setLayoutParams(layoutParams);
        this.gnb.setVisibility(8);
        this.gnc.setText(a.i.ala_person_report);
        this.gnh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.gnr) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.gnr);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.gmO.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.gmO.finish();
                }
            }
        });
        this.gnn = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.gno = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.gno.setIsRound(true);
        this.gno.setAutoChangeStyle(false);
        this.gno.setDrawBorder(false);
        this.gno.setDefaultBgResource(a.f.sdk_default_avatar);
        if (!this.gnv) {
            this.gnp = (ViewGroup) this.mRootView.findViewById(a.g.anchor_tag_layout);
            this.gnp.setVisibility(8);
        }
    }

    private void initListener() {
        this.gmP.setOnClickListener(this);
        this.gnd.setOnClickListener(this);
        this.gmZ.setOnClickListener(this);
        a(new a.InterfaceC0579a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0579a
            public void bHU() {
                PersonCardViewNew.this.gmO.bHO();
            }
        });
    }

    public void a(a.InterfaceC0579a interfaceC0579a) {
        this.gnt = interfaceC0579a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.aYt = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            this.gnu.setData(personUserData.user_info);
            if (this.gjX) {
                this.gnj.setVisibility(8);
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.gnv) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!z.wh() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.vS()) {
                        this.gnp.setVisibility(8);
                        return;
                    }
                    this.gnp.setVisibility(0);
                    this.gnp.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.vR())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.vR().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.vR().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.gmO.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, rH(i));
                                this.gnp.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.gmO.getPageContext().getPageActivity());
                    alaPersonTagView2.setAddTagView();
                    alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PersonCardViewNew.this.gnx != null) {
                                PersonCardViewNew.this.gnx.bHR();
                            }
                        }
                    });
                    this.gnp.addView(alaPersonTagView2);
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

    private int rH(int i) {
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
            this.avR = personUserData.user_info != null && this.gmO.CS(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.gnr = personUserData.user_info != null ? personUserData.user_info.azb : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.gns = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.gns) {
                this.gnj.setVisibility(8);
            } else {
                this.gnj.setVisibility(0);
            }
            if (!z) {
                this.gmW.setText("火星");
            } else {
                this.gmW.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.gne.setVisibility(8);
                this.gnm.setVisibility(8);
            } else {
                this.gne.setText(String.format(this.gmO.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.gnm.setVisibility(0);
                this.gne.setVisibility(0);
            }
            if (z2) {
                this.gmY.setText(String.format(this.gmO.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.gmY.setVisibility(0);
                this.gnl.setVisibility(0);
                return;
            }
            this.gmY.setVisibility(8);
            this.gnl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIg() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.gmO.getActivity());
            this.gmO.finish();
            return;
        }
        if (this.gnw != null && this.gnw.isShowing()) {
            this.gnw.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.gmO.getActivity(), true);
        aVar.a(new a.InterfaceC0579a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0579a
            public void bHU() {
                if (PersonCardViewNew.this.gnt != null) {
                    PersonCardViewNew.this.gnt.bHU();
                }
            }
        });
        aVar.show();
        this.gnw = aVar;
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        ad adVar = personUserData.user_info;
        if (adVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(adVar.fans_count < 0 ? 0L : adVar.fans_count);
            this.gmR.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.gmT.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(adVar.follow_count < 0 ? 0L : adVar.follow_count);
            this.gmX.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.gmU.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.gmS.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.gmV.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.gmV.setText("");
            }
            int i2 = this.gnv ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.gnv) {
                i = 22;
            }
            this.gmR.setTextSize(1, i);
            this.gmX.setTextSize(1, i);
            this.gmS.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.gmP.setVisibility(8);
                this.gna.setVisibility(8);
            } else if (this.gmO.CS(TbadkCoreApplication.getCurrentAccount())) {
                this.gna.setVisibility(8);
                this.gmP.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds32), 0, 0);
                this.gmP.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.gmP.setVisibility(0);
                this.gna.setVisibility(0);
            } else {
                this.gna.setVisibility(0);
                this.gmP.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        ad adVar = personUserData.user_info;
        if (adVar != null && !StringUtils.isNull(adVar.getNameShow())) {
            String nameShow = adVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.gmQ.setText(nameShow);
        }
        k.a(this.gnh, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(adVar.description)) {
            this.gnf.setText(a.i.ala_person_desc_default_text);
        } else {
            this.gnf.setText(adVar.description);
        }
        CV(adVar.ayX);
    }

    private void CV(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.gni == null) {
                this.gni = new TbImageView(this.gng.getContext());
            }
            this.gni.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
                    if (z && str.equals(str2) && PersonCardViewNew.this.gng != null && PersonCardViewNew.this.gni != null && PersonCardViewNew.this.gni.getLoadedWidth() > 0 && PersonCardViewNew.this.gni.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f2 = resources.getDisplayMetrics().density;
                            if (f2 > 0.0f) {
                                f = 3.0f / f2;
                                if (!PersonCardViewNew.this.gnv) {
                                    realScreenWidth = resources.getDimensionPixelOffset(a.e.sdk_ds800);
                                } else {
                                    realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                                }
                                float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gni.getLoadedWidth();
                                layoutParams = PersonCardViewNew.this.gng.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.width = -1;
                                    layoutParams.height = (int) (PersonCardViewNew.this.gni.getLoadedHeight() * loadedWidth);
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((f > 0.0f ? f : 1.0f) * (-resources.getDimensionPixelOffset(a.e.sdk_ds214)) * loadedWidth);
                                    }
                                    PersonCardViewNew.this.gng.setLayoutParams(layoutParams);
                                }
                                if (PersonCardViewNew.this.gnh != null) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gnh.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams2.removeRule(14);
                                    } else {
                                        layoutParams2.addRule(14, 0);
                                    }
                                    layoutParams2.addRule(13);
                                    PersonCardViewNew.this.gnh.setLayoutParams(layoutParams2);
                                }
                                if (PersonCardViewNew.this.gng.indexOfChild(PersonCardViewNew.this.gni) < 0) {
                                    PersonCardViewNew.this.gng.addView(PersonCardViewNew.this.gni, PersonCardViewNew.this.gng.indexOfChild(PersonCardViewNew.this.gnh) + 1, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (PersonCardViewNew.this.fpX != null) {
                                    ViewGroup.LayoutParams layoutParams3 = PersonCardViewNew.this.fpX.getLayoutParams();
                                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PersonCardViewNew.this.fpX.getLayoutParams();
                                        float dimensionPixelOffset = resources.getDimensionPixelOffset(a.e.sdk_ds192) * loadedWidth;
                                        if (f <= 0.0f) {
                                            f = 1.0f;
                                        }
                                        marginLayoutParams.topMargin = (int) (f * dimensionPixelOffset);
                                        PersonCardViewNew.this.fpX.setLayoutParams(layoutParams3);
                                    }
                                }
                                if (PersonCardViewNew.this.gna.getVisibility() != 0 && PersonCardViewNew.this.gmP.getVisibility() == 0) {
                                    PersonCardViewNew.this.gmP.setPadding(PersonCardViewNew.this.gmP.getPaddingLeft(), PersonCardViewNew.this.gmP.getPaddingTop(), resources.getDimensionPixelOffset(a.e.sdk_ds16), PersonCardViewNew.this.gmP.getPaddingBottom());
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gmP.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams4.removeRule(1);
                                    } else {
                                        layoutParams4.addRule(1, 0);
                                    }
                                    layoutParams4.addRule(11);
                                    PersonCardViewNew.this.gmP.setLayoutParams(layoutParams4);
                                    return;
                                }
                            }
                        }
                        f = 0.0f;
                        if (!PersonCardViewNew.this.gnv) {
                        }
                        float loadedWidth2 = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gni.getLoadedWidth();
                        layoutParams = PersonCardViewNew.this.gng.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        if (PersonCardViewNew.this.gnh != null) {
                        }
                        if (PersonCardViewNew.this.gng.indexOfChild(PersonCardViewNew.this.gni) < 0) {
                        }
                        if (PersonCardViewNew.this.fpX != null) {
                        }
                        if (PersonCardViewNew.this.gna.getVisibility() != 0) {
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gni.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.gnq = false;
            lx(false);
        } else if (!this.gns && (alaRelationData = personUserData.relation_info) != null) {
            this.gnq = alaRelationData.follow_status != 0;
            if (z) {
                this.gmZ.setVisibility(8);
            } else {
                lx(this.gnq);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.gnn.setVisibility(0);
            this.gnn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.gnx != null) {
                        PersonCardViewNew.this.gnx.bHQ();
                    }
                }
            });
            this.gno.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.gnn.setVisibility(4);
    }

    private void lx(boolean z) {
        if (z) {
            this.gmZ.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gmZ.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.gmZ.setTextColor(this.gmO.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.gmZ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.gmZ.setTextColor(this.gmO.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.gmZ.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gmZ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.gmZ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.gmZ.setTextColor(this.gmO.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.gmZ.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gmZ) {
            bIh();
        } else if (view == this.gnd) {
            bIc();
        } else if (view == this.gmP) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.gmO, this.aYt}));
        }
    }

    private void bIc() {
        if (this.aYt != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gmO.getActivity());
            } else if (this.aYt.user_info == null || JavaTypesHelper.toLong(this.aYt.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gmO.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.aYt.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.gmO.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aWd = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aYt.user_info));
                this.gmO.finish();
            }
        }
    }

    private void bIh() {
        String str;
        if (this.aYt != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gmO.getActivity());
                this.gmO.finish();
            } else if (this.aYt.user_info == null || JavaTypesHelper.toLong(this.aYt.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gmO.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.gnq) {
                    rI(1);
                    this.gmO.bHN();
                } else {
                    rI(0);
                    this.gmO.bHM();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.gnq ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.avR) {
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

    public void rI(int i) {
        switch (i) {
            case 0:
                this.gnq = true;
                lx(true);
                if (this.aYt != null && this.aYt.user_info != null) {
                    this.aYt.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.aYt.user_info.fans_count >= 0 ? this.aYt.user_info.fans_count : 0L);
                    this.gmR.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.gmT.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.gnq = false;
                lx(false);
                if (this.aYt != null && this.aYt.user_info != null) {
                    this.aYt.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.aYt.user_info.fans_count >= 0 ? this.aYt.user_info.fans_count : 0L);
                    this.gmR.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.gmT.setText(formatForPersonCardBeanValue2[1]);
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

    public void ly(boolean z) {
        if (this.aYt != null && this.aYt.user_info != null) {
            if (z) {
                this.aYt.user_info.follow_count++;
            } else {
                this.aYt.user_info.follow_count--;
            }
            if (this.aYt.user_info.follow_count < 0) {
                this.aYt.user_info.follow_count = 0L;
            }
            this.gmZ.setText(com.baidu.tieba.ala.person.d.a.dM(this.aYt.user_info.follow_count));
        }
    }

    private View kc(boolean z) {
        if (z) {
            return LayoutInflater.from(this.gmO.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.gmO.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void lz(boolean z) {
        this.gjX = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.fCC == null) {
                        PersonCardViewNew.this.fCC = AnimationUtils.loadAnimation(PersonCardViewNew.this.gmO.getActivity(), a.C0182a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.gnk.setAnimation(PersonCardViewNew.this.fCC);
                    PersonCardViewNew.this.gnk.setVisibility(0);
                    PersonCardViewNew.this.fCC.setDuration(300L);
                    PersonCardViewNew.this.fCC.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.gnk != null) {
            this.gnk.clearAnimation();
        }
        if (this.gnw != null && this.gnw.isShowing()) {
            this.gnw.dismiss();
        }
    }

    public Animation bvz() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.fCC != null) {
            this.fCC.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.gmO.getActivity(), a.C0182a.sdk_push_up_out);
        this.gnk.setAnimation(loadAnimation);
        this.gnk.setVisibility(8);
        return loadAnimation;
    }

    public void aNc() {
        if (this.gnw != null && this.gnw.isShowing()) {
            this.gnw.resize();
        }
        if (this.aYt != null && this.aYt.user_info != null) {
            CV(this.aYt.user_info.ayX);
        }
    }
}
