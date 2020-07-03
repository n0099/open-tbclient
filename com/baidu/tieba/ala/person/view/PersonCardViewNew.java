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
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.aa;
import com.baidu.live.data.ae;
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
/* loaded from: classes3.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private boolean axZ;
    private PersonUserData bbm;
    private View fBt;
    private Animation fNW;
    private ImageView gAa;
    private TextView gAb;
    private TextView gAc;
    private TextView gAd;
    private TextView gAe;
    private TextView gAf;
    private ViewGroup gAg;
    private HeadImageView gAh;
    private TbImageView gAi;
    private LinearLayout gAj;
    private View gAk;
    private View gAl;
    private View gAm;
    private View gAn;
    private HeadImageView gAo;
    private ViewGroup gAp;
    private boolean gAq;
    private String gAr;
    private boolean gAs;
    private boolean gAt;
    private a.InterfaceC0588a gAu;
    private com.baidu.tieba.ala.person.view.a gAv;
    private boolean gAw;
    private com.baidu.tieba.ala.person.a gAx;
    private a gAy;
    private boolean gwV;
    protected final PersonCardActivity gzN;
    private TextView gzO;
    private TextView gzP;
    private TextView gzQ;
    private TextView gzR;
    private TextView gzS;
    private TextView gzT;
    private TextView gzU;
    private TextView gzV;
    private TextView gzW;
    private TextView gzX;
    private TextView gzY;
    private LinearLayout gzZ;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes3.dex */
    public interface a {
        void bKW();

        void bKX();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.gzN = personCardActivity;
        this.gAw = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = kq(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.gAv = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.gAy = aVar;
    }

    private void initView() {
        this.gAk = this.mRootView.findViewById(a.g.person_card_layout);
        this.gzO = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.gzZ = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.gAa = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.gAb = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fBt = this.mRootView.findViewById(a.g.name_layout);
        this.gzP = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gzQ = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.gzR = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.gzS = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.gzU = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.gzT = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.gzV = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gzW = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.gzX = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.gAf = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.gzY = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.gAe = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.gAj = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.gAl = this.mRootView.findViewById(a.g.user_divide);
        this.gAm = this.mRootView.findViewById(a.g.user_divide2);
        this.gAc = (TextView) this.mRootView.findViewById(a.g.btn_person_card_nav_liveroom);
        this.gAd = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gAc.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.gAd.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.gAc.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
            this.gAd.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.gAg = (ViewGroup) this.mRootView.findViewById(a.g.layout_avatar);
        this.gAh = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gAh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.gAh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.gAh.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gAh.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.gAh.setIsRound(true);
        this.gAh.setAutoChangeStyle(false);
        this.gAh.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gAh.setBorderWidth(BdUtilHelper.getDimens(this.gzN.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.gAh.setBorderColor(-1);
        this.gzZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bLm();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gzO.getLayoutParams();
        layoutParams.addRule(1, this.gzZ.getId());
        this.gzO.setLayoutParams(layoutParams);
        this.gAa.setVisibility(8);
        this.gAb.setText(a.i.ala_person_report);
        this.gAh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.gAr) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.gAr);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.gzN.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.gzN.finish();
                }
            }
        });
        this.gAn = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.gAo = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.gAo.setIsRound(true);
        this.gAo.setAutoChangeStyle(false);
        this.gAo.setDrawBorder(false);
        this.gAo.setDefaultBgResource(a.f.sdk_default_avatar);
        if (!this.gAw) {
            this.gAp = (ViewGroup) this.mRootView.findViewById(a.g.anchor_tag_layout);
            this.gAp.setVisibility(8);
        }
    }

    private void initListener() {
        this.gzO.setOnClickListener(this);
        this.gAc.setOnClickListener(this);
        this.gAd.setOnClickListener(this);
        this.gzY.setOnClickListener(this);
        a(new a.InterfaceC0588a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0588a
            public void bLa() {
                PersonCardViewNew.this.gzN.bKU();
            }
        });
    }

    public void a(a.InterfaceC0588a interfaceC0588a) {
        this.gAu = interfaceC0588a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bbm = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            i(personUserData);
            this.gAv.setData(personUserData.user_info);
            if (this.gwV) {
                this.gAj.setVisibility(8);
            }
            if (this.gAj != null && this.gAj.getVisibility() == 0) {
                int childCount = this.gAj.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.gAj.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.gAj.getResources().getDimensionPixelOffset(i2 >= 3 ? a.e.sdk_ds20 : a.e.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.gAj.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.gAj.setWeightSum(i2);
                this.gAj.requestLayout();
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.gAw) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!aa.wF() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.wq()) {
                        this.gAp.setVisibility(8);
                        return;
                    }
                    this.gAp.setVisibility(0);
                    this.gAp.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.wp())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.wp().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.wp().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.gzN.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, sh(i));
                                this.gAp.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.gzN.getPageContext().getPageActivity());
                    alaPersonTagView2.setAddTagView();
                    alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PersonCardViewNew.this.gAy != null) {
                                PersonCardViewNew.this.gAy.bKX();
                            }
                        }
                    });
                    this.gAp.addView(alaPersonTagView2);
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

    private int sh(int i) {
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
            this.axZ = personUserData.user_info != null && this.gzN.Dt(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.gAr = personUserData.user_info != null ? personUserData.user_info.aBs : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.gAs = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.gAs) {
                this.gAj.setVisibility(8);
            } else {
                this.gAj.setVisibility(0);
            }
            if (!z) {
                this.gzV.setText("火星");
            } else {
                this.gzV.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.gAe.setVisibility(8);
                this.gAm.setVisibility(8);
            } else {
                this.gAe.setText(String.format(this.gzN.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.gAm.setVisibility(0);
                this.gAe.setVisibility(0);
            }
            if (z2) {
                this.gzX.setText(String.format(this.gzN.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.gzX.setVisibility(0);
                this.gAl.setVisibility(0);
                return;
            }
            this.gzX.setVisibility(8);
            this.gAl.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bLm() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.gzN.getActivity());
            this.gzN.finish();
            return;
        }
        if (this.gAx != null && this.gAx.isShowing()) {
            this.gAx.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.gzN.getActivity(), true);
        aVar.a(new a.InterfaceC0588a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0588a
            public void bLa() {
                if (PersonCardViewNew.this.gAu != null) {
                    PersonCardViewNew.this.gAu.bLa();
                }
            }
        });
        aVar.show();
        this.gAx = aVar;
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        ae aeVar = personUserData.user_info;
        if (aeVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(aeVar.fans_count < 0 ? 0L : aeVar.fans_count);
            this.gzQ.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.gzS.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(aeVar.follow_count < 0 ? 0L : aeVar.follow_count);
            this.gzW.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.gzT.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.gzR.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.gzU.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.gzU.setText("");
            }
            int i2 = this.gAw ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.gAw) {
                i = 22;
            }
            this.gzQ.setTextSize(1, i);
            this.gzW.setTextSize(1, i);
            this.gzR.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.gzO.setVisibility(8);
                this.gzZ.setVisibility(8);
            } else if (this.gzN.Dt(TbadkCoreApplication.getCurrentAccount())) {
                this.gzZ.setVisibility(8);
                this.gzO.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds32), 0, 0);
                this.gzO.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.gzO.setVisibility(0);
                this.gzZ.setVisibility(0);
            } else {
                this.gzZ.setVisibility(0);
                this.gzO.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        ae aeVar = personUserData.user_info;
        if (aeVar != null && !StringUtils.isNull(aeVar.getNameShow())) {
            String nameShow = aeVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.gzP.setText(nameShow);
        }
        k.a(this.gAh, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(aeVar.description)) {
            this.gAf.setText(a.i.ala_person_desc_default_text);
        } else {
            this.gAf.setText(aeVar.description);
        }
        Dw(aeVar.aBo);
    }

    private void Dw(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.gAi == null) {
                this.gAi = new TbImageView(this.gAg.getContext());
            }
            this.gAi.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
                    if (z && str.equals(str2) && PersonCardViewNew.this.gAg != null && PersonCardViewNew.this.gAi != null && PersonCardViewNew.this.gAi.getLoadedWidth() > 0 && PersonCardViewNew.this.gAi.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f2 = resources.getDisplayMetrics().density;
                            if (f2 > 0.0f) {
                                f = 3.0f / f2;
                                if (!PersonCardViewNew.this.gAw) {
                                    realScreenWidth = resources.getDimensionPixelOffset(a.e.sdk_ds800);
                                } else {
                                    realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                                }
                                float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gAi.getLoadedWidth();
                                layoutParams = PersonCardViewNew.this.gAg.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.width = -1;
                                    layoutParams.height = (int) (PersonCardViewNew.this.gAi.getLoadedHeight() * loadedWidth);
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((f > 0.0f ? f : 1.0f) * (-resources.getDimensionPixelOffset(a.e.sdk_ds214)) * loadedWidth);
                                    }
                                    PersonCardViewNew.this.gAg.setLayoutParams(layoutParams);
                                }
                                if (PersonCardViewNew.this.gAh != null) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gAh.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams2.removeRule(14);
                                    } else {
                                        layoutParams2.addRule(14, 0);
                                    }
                                    layoutParams2.addRule(13);
                                    PersonCardViewNew.this.gAh.setLayoutParams(layoutParams2);
                                }
                                if (PersonCardViewNew.this.gAg.indexOfChild(PersonCardViewNew.this.gAi) < 0) {
                                    PersonCardViewNew.this.gAg.addView(PersonCardViewNew.this.gAi, PersonCardViewNew.this.gAg.indexOfChild(PersonCardViewNew.this.gAh) + 1, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (PersonCardViewNew.this.fBt != null) {
                                    ViewGroup.LayoutParams layoutParams3 = PersonCardViewNew.this.fBt.getLayoutParams();
                                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PersonCardViewNew.this.fBt.getLayoutParams();
                                        float dimensionPixelOffset = resources.getDimensionPixelOffset(a.e.sdk_ds192) * loadedWidth;
                                        if (f <= 0.0f) {
                                            f = 1.0f;
                                        }
                                        marginLayoutParams.topMargin = (int) (f * dimensionPixelOffset);
                                        PersonCardViewNew.this.fBt.setLayoutParams(layoutParams3);
                                    }
                                }
                                if (PersonCardViewNew.this.gzZ.getVisibility() != 0 && PersonCardViewNew.this.gzO.getVisibility() == 0) {
                                    PersonCardViewNew.this.gzO.setPadding(PersonCardViewNew.this.gzO.getPaddingLeft(), PersonCardViewNew.this.gzO.getPaddingTop(), resources.getDimensionPixelOffset(a.e.sdk_ds16), PersonCardViewNew.this.gzO.getPaddingBottom());
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gzO.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams4.removeRule(1);
                                    } else {
                                        layoutParams4.addRule(1, 0);
                                    }
                                    layoutParams4.addRule(11);
                                    PersonCardViewNew.this.gzO.setLayoutParams(layoutParams4);
                                    return;
                                }
                            }
                        }
                        f = 0.0f;
                        if (!PersonCardViewNew.this.gAw) {
                        }
                        float loadedWidth2 = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gAi.getLoadedWidth();
                        layoutParams = PersonCardViewNew.this.gAg.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        if (PersonCardViewNew.this.gAh != null) {
                        }
                        if (PersonCardViewNew.this.gAg.indexOfChild(PersonCardViewNew.this.gAi) < 0) {
                        }
                        if (PersonCardViewNew.this.fBt != null) {
                        }
                        if (PersonCardViewNew.this.gzZ.getVisibility() != 0) {
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gAi.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.gAq = false;
            lF(false);
        } else if (!this.gAs && (alaRelationData = personUserData.relation_info) != null) {
            this.gAq = alaRelationData.follow_status != 0;
            if (z) {
                this.gzY.setVisibility(8);
            } else {
                lF(this.gAq);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.gAn.setVisibility(0);
            this.gAn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.gAy != null) {
                        PersonCardViewNew.this.gAy.bKW();
                    }
                }
            });
            this.gAo.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.gAn.setVisibility(4);
    }

    private void lF(boolean z) {
        if (z) {
            this.gzY.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gzY.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.gzY.setTextColor(this.gzN.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.gzY.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.gzY.setTextColor(this.gzN.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.gzY.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gzY.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.gzY.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.gzY.setTextColor(this.gzN.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.gzY.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.gAc != null && personUserData != null && personUserData.user_info != null) {
            this.gAc.setVisibility((this.gAt && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gzY) {
            bLo();
        } else if (view == this.gAd) {
            bLi();
        } else if (view == this.gAc) {
            bLn();
        } else if (view == this.gzO) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.gzN, this.bbm}));
        }
    }

    private void bLn() {
        if (this.gzN != null && this.bbm != null && this.bbm.user_info != null && !TextUtils.isEmpty(this.bbm.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gzN.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bbm.user_info.live_id), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.gzN.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void bLi() {
        if (this.bbm != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gzN.getActivity());
            } else if (this.bbm.user_info == null || JavaTypesHelper.toLong(this.bbm.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gzN.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.bbm.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.gzN.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aYM = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bbm.user_info));
                this.gzN.finish();
            }
        }
    }

    private void bLo() {
        String str;
        if (this.bbm != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gzN.getActivity());
                this.gzN.finish();
            } else if (this.bbm.user_info == null || JavaTypesHelper.toLong(this.bbm.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gzN.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.gAq) {
                    si(1);
                    this.gzN.bKT();
                } else {
                    si(0);
                    this.gzN.bKS();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.gAq ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.axZ) {
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

    public void si(int i) {
        switch (i) {
            case 0:
                this.gAq = true;
                lF(true);
                if (this.bbm != null && this.bbm.user_info != null) {
                    this.bbm.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bbm.user_info.fans_count >= 0 ? this.bbm.user_info.fans_count : 0L);
                    this.gzQ.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.gzS.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.gAq = false;
                lF(false);
                if (this.bbm != null && this.bbm.user_info != null) {
                    this.bbm.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bbm.user_info.fans_count >= 0 ? this.bbm.user_info.fans_count : 0L);
                    this.gzQ.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.gzS.setText(formatForPersonCardBeanValue2[1]);
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

    public void lG(boolean z) {
        if (this.bbm != null && this.bbm.user_info != null) {
            if (z) {
                this.bbm.user_info.follow_count++;
            } else {
                this.bbm.user_info.follow_count--;
            }
            if (this.bbm.user_info.follow_count < 0) {
                this.bbm.user_info.follow_count = 0L;
            }
            this.gzY.setText(com.baidu.tieba.ala.person.d.a.dP(this.bbm.user_info.follow_count));
        }
    }

    private View kq(boolean z) {
        if (z) {
            return LayoutInflater.from(this.gzN.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.gzN.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void lH(boolean z) {
        this.gwV = z;
    }

    public void lI(boolean z) {
        this.gAt = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.fNW == null) {
                        PersonCardViewNew.this.fNW = AnimationUtils.loadAnimation(PersonCardViewNew.this.gzN.getActivity(), a.C0176a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.gAk.setAnimation(PersonCardViewNew.this.fNW);
                    PersonCardViewNew.this.gAk.setVisibility(0);
                    PersonCardViewNew.this.fNW.setDuration(300L);
                    PersonCardViewNew.this.fNW.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.gAk != null) {
            this.gAk.clearAnimation();
        }
        if (this.gAx != null && this.gAx.isShowing()) {
            this.gAx.dismiss();
        }
    }

    public Animation byw() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.fNW != null) {
            this.fNW.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.gzN.getActivity(), a.C0176a.sdk_push_up_out);
        this.gAk.setAnimation(loadAnimation);
        this.gAk.setVisibility(8);
        return loadAnimation;
    }

    public void aOF() {
        if (this.gAx != null && this.gAx.isShowing()) {
            this.gAx.resize();
        }
        if (this.bbm != null && this.bbm.user_info != null) {
            Dw(this.bbm.user_info.aBo);
        }
    }
}
