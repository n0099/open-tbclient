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
    private boolean aFD;
    private View aSo;
    private long bhr;
    private PersonUserData bjx;
    private long fxY;
    private boolean gSH;
    private TextView gVA;
    private TextView gVB;
    private TextView gVC;
    private TextView gVD;
    private TextView gVE;
    private TextView gVF;
    private TextView gVG;
    private TextView gVH;
    private TextView gVI;
    private TextView gVJ;
    private LinearLayout gVK;
    private ImageView gVL;
    private TextView gVM;
    private TextView gVN;
    private TextView gVO;
    private TextView gVP;
    private TextView gVQ;
    private ViewGroup gVR;
    private HeadImageView gVS;
    private TbImageView gVT;
    private LinearLayout gVU;
    private View gVV;
    private View gVW;
    private View gVX;
    private View gVY;
    private HeadImageView gVZ;
    protected final PersonCardActivity gVy;
    private TextView gVz;
    private ViewGroup gWa;
    private boolean gWb;
    private String gWc;
    private boolean gWd;
    private boolean gWe;
    private a.InterfaceC0644a gWf;
    private com.baidu.tieba.ala.person.view.a gWg;
    private boolean gWh;
    private com.baidu.tieba.ala.person.a gWi;
    private a gWj;
    private Animation giD;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes4.dex */
    public interface a {
        void cad();

        void cae();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.gVy = personCardActivity;
        this.gWh = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = ly(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.gWg = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.gWj = aVar;
    }

    private void initView() {
        this.gVV = this.mRootView.findViewById(a.g.person_card_layout);
        this.gVz = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.gVK = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.gVL = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.gVM = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.aSo = this.mRootView.findViewById(a.g.name_layout);
        this.gVA = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gVB = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.gVC = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.gVD = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.gVF = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.gVE = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.gVG = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gVH = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.gVI = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.gVQ = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.gVJ = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.gVP = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.gVU = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.gVW = this.mRootView.findViewById(a.g.user_divide);
        this.gVX = this.mRootView.findViewById(a.g.user_divide2);
        this.gVN = (TextView) this.mRootView.findViewById(a.g.btn_person_card_nav_liveroom);
        this.gVO = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gVN.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.gVO.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.gVN.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
            this.gVO.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.gVR = (ViewGroup) this.mRootView.findViewById(a.g.layout_avatar);
        this.gVS = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gVS.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.gVS.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.gVS.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gVS.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.gVS.setIsRound(true);
        this.gVS.setAutoChangeStyle(false);
        this.gVS.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gVS.setBorderWidth(BdUtilHelper.getDimens(this.gVy.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.gVS.setBorderColor(-1);
        this.gVK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.cas();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gVz.getLayoutParams();
        layoutParams.addRule(1, this.gVK.getId());
        this.gVz.setLayoutParams(layoutParams);
        this.gVL.setVisibility(8);
        this.gVM.setText(a.i.ala_person_report);
        this.gVS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.gWc) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.gWc);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.gVy.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.gVy.finish();
                }
            }
        });
        this.gVY = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.gVZ = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.gVZ.setIsRound(true);
        this.gVZ.setAutoChangeStyle(false);
        this.gVZ.setDrawBorder(false);
        this.gVZ.setDefaultBgResource(a.f.sdk_default_avatar);
        if (!this.gWh) {
            this.gWa = (ViewGroup) this.mRootView.findViewById(a.g.anchor_tag_layout);
            this.gWa.setVisibility(8);
        }
    }

    private void initListener() {
        this.gVz.setOnClickListener(this);
        this.gVN.setOnClickListener(this);
        this.gVO.setOnClickListener(this);
        this.gVJ.setOnClickListener(this);
        a(new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0644a
            public void cag() {
                PersonCardViewNew.this.gVy.cab();
            }
        });
    }

    public void a(a.InterfaceC0644a interfaceC0644a) {
        this.gWf = interfaceC0644a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bjx = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            i(personUserData);
            this.gWg.setData(personUserData.user_info);
            if (this.gSH) {
                this.gVU.setVisibility(8);
            }
            if (this.gVU != null && this.gVU.getVisibility() == 0) {
                int childCount = this.gVU.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.gVU.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.gVU.getResources().getDimensionPixelOffset(i2 >= 3 ? a.e.sdk_ds20 : a.e.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.gVU.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.gVU.setWeightSum(i2);
                this.gVU.requestLayout();
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.gWh) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!ah.Da() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.CF()) {
                        this.gWa.setVisibility(8);
                        return;
                    }
                    this.gWa.setVisibility(0);
                    this.gWa.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.CE())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.CE().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.CE().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.gVy.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, vg(i));
                                this.gWa.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.gVy.getPageContext().getPageActivity());
                    alaPersonTagView2.setAddTagView();
                    alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PersonCardViewNew.this.gWj != null) {
                                PersonCardViewNew.this.gWj.cae();
                            }
                        }
                    });
                    this.gWa.addView(alaPersonTagView2);
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

    private int vg(int i) {
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
            this.aFD = personUserData.user_info != null && this.gVy.GY(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.gWc = personUserData.user_info != null ? personUserData.user_info.aJu : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.gWd = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.gWd) {
                this.gVU.setVisibility(8);
            } else {
                this.gVU.setVisibility(0);
            }
            if (!z) {
                this.gVG.setText("火星");
            } else {
                this.gVG.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.gVP.setVisibility(8);
                this.gVX.setVisibility(8);
            } else {
                this.gVP.setText(String.format(this.gVy.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.gVX.setVisibility(0);
                this.gVP.setVisibility(0);
            }
            if (z2) {
                this.gVI.setText(String.format(this.gVy.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.gVI.setVisibility(0);
                this.gVW.setVisibility(0);
                return;
            }
            this.gVI.setVisibility(8);
            this.gVW.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cas() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.gVy.getActivity());
            this.gVy.finish();
        } else if (this.bjx != null && this.bjx.user_info != null && this.bjx.user_info.live_status == 1) {
            f fVar = new f(this.gVy);
            fVar.a(this.bhr, this.fxY, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bjx.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, fVar));
            this.gVy.finish();
        } else {
            if (this.gWi != null && this.gWi.isShowing()) {
                this.gWi.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.gVy.getActivity(), true);
            aVar.a(new a.InterfaceC0644a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0644a
                public void cag() {
                    if (PersonCardViewNew.this.gWf != null) {
                        PersonCardViewNew.this.gWf.cag();
                    }
                }
            });
            aVar.show();
            this.gWi = aVar;
        }
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        am amVar = personUserData.user_info;
        if (amVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(amVar.fans_count < 0 ? 0L : amVar.fans_count);
            this.gVB.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.gVD.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(amVar.follow_count < 0 ? 0L : amVar.follow_count);
            this.gVH.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.gVE.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.gVC.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.gVF.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.gVF.setText("");
            }
            int i2 = this.gWh ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.gWh) {
                i = 22;
            }
            this.gVB.setTextSize(1, i);
            this.gVH.setTextSize(1, i);
            this.gVC.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.gVz.setVisibility(8);
                this.gVK.setVisibility(8);
            } else if (this.gVy.GY(TbadkCoreApplication.getCurrentAccount())) {
                this.gVK.setVisibility(8);
                this.gVz.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds32), 0, 0);
                this.gVz.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.gVz.setVisibility(0);
                this.gVK.setVisibility(0);
            } else {
                this.gVK.setVisibility(0);
                this.gVz.setVisibility(8);
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
            this.gVA.setText(nameShow);
        }
        l.a(this.gVS, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(amVar.description)) {
            this.gVQ.setText(a.i.ala_person_desc_default_text);
        } else {
            this.gVQ.setText(amVar.description);
        }
        Ha(amVar.aJq);
    }

    private void Ha(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.gVT == null) {
                this.gVT = new TbImageView(this.gVR.getContext());
            }
            this.gVT.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
                    if (z && str.equals(str2) && PersonCardViewNew.this.gVR != null && PersonCardViewNew.this.gVT != null && PersonCardViewNew.this.gVT.getLoadedWidth() > 0 && PersonCardViewNew.this.gVT.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f2 = resources.getDisplayMetrics().density;
                            if (f2 > 0.0f) {
                                f = 3.0f / f2;
                                if (!PersonCardViewNew.this.gWh) {
                                    realScreenWidth = resources.getDimensionPixelOffset(a.e.sdk_ds800);
                                } else {
                                    realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                                }
                                float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gVT.getLoadedWidth();
                                layoutParams = PersonCardViewNew.this.gVR.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.width = -1;
                                    layoutParams.height = (int) (PersonCardViewNew.this.gVT.getLoadedHeight() * loadedWidth);
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((f > 0.0f ? f : 1.0f) * (-resources.getDimensionPixelOffset(a.e.sdk_ds214)) * loadedWidth);
                                    }
                                    PersonCardViewNew.this.gVR.setLayoutParams(layoutParams);
                                }
                                if (PersonCardViewNew.this.gVS != null) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gVS.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams2.removeRule(14);
                                    } else {
                                        layoutParams2.addRule(14, 0);
                                    }
                                    layoutParams2.addRule(13);
                                    PersonCardViewNew.this.gVS.setLayoutParams(layoutParams2);
                                }
                                if (PersonCardViewNew.this.gVR.indexOfChild(PersonCardViewNew.this.gVT) < 0) {
                                    PersonCardViewNew.this.gVR.addView(PersonCardViewNew.this.gVT, PersonCardViewNew.this.gVR.indexOfChild(PersonCardViewNew.this.gVS) + 1, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (PersonCardViewNew.this.aSo != null) {
                                    ViewGroup.LayoutParams layoutParams3 = PersonCardViewNew.this.aSo.getLayoutParams();
                                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PersonCardViewNew.this.aSo.getLayoutParams();
                                        float dimensionPixelOffset = resources.getDimensionPixelOffset(a.e.sdk_ds192) * loadedWidth;
                                        if (f <= 0.0f) {
                                            f = 1.0f;
                                        }
                                        marginLayoutParams.topMargin = (int) (f * dimensionPixelOffset);
                                        PersonCardViewNew.this.aSo.setLayoutParams(layoutParams3);
                                    }
                                }
                                if (PersonCardViewNew.this.gVK.getVisibility() != 0 && PersonCardViewNew.this.gVz.getVisibility() == 0) {
                                    PersonCardViewNew.this.gVz.setPadding(PersonCardViewNew.this.gVz.getPaddingLeft(), PersonCardViewNew.this.gVz.getPaddingTop(), resources.getDimensionPixelOffset(a.e.sdk_ds16), PersonCardViewNew.this.gVz.getPaddingBottom());
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gVz.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams4.removeRule(1);
                                    } else {
                                        layoutParams4.addRule(1, 0);
                                    }
                                    layoutParams4.addRule(11);
                                    PersonCardViewNew.this.gVz.setLayoutParams(layoutParams4);
                                    return;
                                }
                            }
                        }
                        f = 0.0f;
                        if (!PersonCardViewNew.this.gWh) {
                        }
                        float loadedWidth2 = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gVT.getLoadedWidth();
                        layoutParams = PersonCardViewNew.this.gVR.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        if (PersonCardViewNew.this.gVS != null) {
                        }
                        if (PersonCardViewNew.this.gVR.indexOfChild(PersonCardViewNew.this.gVT) < 0) {
                        }
                        if (PersonCardViewNew.this.aSo != null) {
                        }
                        if (PersonCardViewNew.this.gVK.getVisibility() != 0) {
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gVT.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.gWb = false;
            mR(false);
        } else if (!this.gWd && (alaRelationData = personUserData.relation_info) != null) {
            this.gWb = alaRelationData.follow_status != 0;
            if (z) {
                this.gVJ.setVisibility(8);
            } else {
                mR(this.gWb);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.gVY.setVisibility(0);
            this.gVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.gWj != null) {
                        PersonCardViewNew.this.gWj.cad();
                    }
                }
            });
            this.gVZ.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.gVY.setVisibility(4);
    }

    private void mR(boolean z) {
        if (z) {
            this.gVJ.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gVJ.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.gVJ.setTextColor(this.gVy.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.gVJ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.gVJ.setTextColor(this.gVy.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.gVJ.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gVJ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.gVJ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.gVJ.setTextColor(this.gVy.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.gVJ.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.gVN != null && personUserData != null && personUserData.user_info != null) {
            this.gVN.setVisibility((this.gWe && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gVJ) {
            cau();
        } else if (view == this.gVO) {
            cao();
        } else if (view == this.gVN) {
            cat();
        } else if (view == this.gVz) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.gVy, this.bjx}));
        }
    }

    private void cat() {
        if (this.gVy != null && this.bjx != null && this.bjx.user_info != null && !TextUtils.isEmpty(this.bjx.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gVy.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bjx.user_info.live_id), "", "live_sdk");
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.gVy.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void cao() {
        if (this.bjx != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gVy.getActivity());
            } else if (this.bjx.user_info == null || JavaTypesHelper.toLong(this.bjx.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gVy.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.bjx.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.gVy.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bgU = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bjx.user_info));
                this.gVy.finish();
            }
        }
    }

    private void cau() {
        String str;
        if (this.bjx != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gVy.getActivity());
                this.gVy.finish();
            } else if (this.bjx.user_info == null || JavaTypesHelper.toLong(this.bjx.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gVy.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.gWb) {
                    vh(1);
                    this.gVy.caa();
                } else {
                    vh(0);
                    this.gVy.bZZ();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.gWb ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aFD) {
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

    public void vh(int i) {
        switch (i) {
            case 0:
                this.gWb = true;
                mR(true);
                if (this.bjx != null && this.bjx.user_info != null) {
                    this.bjx.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bjx.user_info.fans_count >= 0 ? this.bjx.user_info.fans_count : 0L);
                    this.gVB.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.gVD.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.gWb = false;
                mR(false);
                if (this.bjx != null && this.bjx.user_info != null) {
                    this.bjx.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bjx.user_info.fans_count >= 0 ? this.bjx.user_info.fans_count : 0L);
                    this.gVB.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.gVD.setText(formatForPersonCardBeanValue2[1]);
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

    public void mS(boolean z) {
        if (this.bjx != null && this.bjx.user_info != null) {
            if (z) {
                this.bjx.user_info.follow_count++;
            } else {
                this.bjx.user_info.follow_count--;
            }
            if (this.bjx.user_info.follow_count < 0) {
                this.bjx.user_info.follow_count = 0L;
            }
            this.gVJ.setText(com.baidu.tieba.ala.person.d.a.eu(this.bjx.user_info.follow_count));
        }
    }

    private View ly(boolean z) {
        if (z) {
            return LayoutInflater.from(this.gVy.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.gVy.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void mT(boolean z) {
        this.gSH = z;
    }

    public void mU(boolean z) {
        this.gWe = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.giD == null) {
                        PersonCardViewNew.this.giD = AnimationUtils.loadAnimation(PersonCardViewNew.this.gVy.getActivity(), a.C0186a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.gVV.setAnimation(PersonCardViewNew.this.giD);
                    PersonCardViewNew.this.gVV.setVisibility(0);
                    PersonCardViewNew.this.giD.setDuration(300L);
                    PersonCardViewNew.this.giD.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.gVV != null) {
            this.gVV.clearAnimation();
        }
        if (this.gWi != null && this.gWi.isShowing()) {
            this.gWi.dismiss();
        }
    }

    public Animation bMq() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.giD != null) {
            this.giD.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.gVy.getActivity(), a.C0186a.sdk_push_up_out);
        this.gVV.setAnimation(loadAnimation);
        this.gVV.setVisibility(8);
        return loadAnimation;
    }

    public void bbL() {
        if (this.gWi != null && this.gWi.isShowing()) {
            this.gWi.resize();
        }
        if (this.bjx != null && this.bjx.user_info != null) {
            Ha(this.bjx.user_info.aJq);
        }
    }

    public void em(String str, String str2) {
        this.bhr = JavaTypesHelper.toLong(str, 0L);
        this.fxY = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
