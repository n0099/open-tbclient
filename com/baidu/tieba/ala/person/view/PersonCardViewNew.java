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
import com.baidu.live.data.aa;
import com.baidu.live.data.af;
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
/* loaded from: classes4.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private long aZc;
    private boolean azm;
    private PersonUserData bbi;
    private View fGD;
    private Animation fTp;
    private long fjn;
    private boolean gCw;
    private TextView gFA;
    private TextView gFB;
    private TextView gFC;
    private ViewGroup gFD;
    private HeadImageView gFE;
    private TbImageView gFF;
    private LinearLayout gFG;
    private View gFH;
    private View gFI;
    private View gFJ;
    private View gFK;
    private HeadImageView gFL;
    private ViewGroup gFM;
    private boolean gFN;
    private String gFO;
    private boolean gFP;
    private boolean gFQ;
    private a.InterfaceC0597a gFR;
    private com.baidu.tieba.ala.person.view.a gFS;
    private boolean gFT;
    private com.baidu.tieba.ala.person.a gFU;
    private a gFV;
    protected final PersonCardActivity gFk;
    private TextView gFl;
    private TextView gFm;
    private TextView gFn;
    private TextView gFo;
    private TextView gFp;
    private TextView gFq;
    private TextView gFr;
    private TextView gFs;
    private TextView gFt;
    private TextView gFu;
    private TextView gFv;
    private LinearLayout gFw;
    private ImageView gFx;
    private TextView gFy;
    private TextView gFz;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes4.dex */
    public interface a {
        void bOg();

        void bOh();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.gFk = personCardActivity;
        this.gFT = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = kU(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.gFS = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.gFV = aVar;
    }

    private void initView() {
        this.gFH = this.mRootView.findViewById(a.g.person_card_layout);
        this.gFl = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.gFw = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.gFx = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.gFy = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fGD = this.mRootView.findViewById(a.g.name_layout);
        this.gFm = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gFn = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.gFo = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.gFp = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.gFr = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.gFq = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.gFs = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gFt = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.gFu = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.gFC = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.gFv = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.gFB = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.gFG = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.gFI = this.mRootView.findViewById(a.g.user_divide);
        this.gFJ = this.mRootView.findViewById(a.g.user_divide2);
        this.gFz = (TextView) this.mRootView.findViewById(a.g.btn_person_card_nav_liveroom);
        this.gFA = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gFz.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.gFA.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.gFz.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
            this.gFA.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.gFD = (ViewGroup) this.mRootView.findViewById(a.g.layout_avatar);
        this.gFE = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gFE.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.gFE.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.gFE.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gFE.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.gFE.setIsRound(true);
        this.gFE.setAutoChangeStyle(false);
        this.gFE.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gFE.setBorderWidth(BdUtilHelper.getDimens(this.gFk.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.gFE.setBorderColor(-1);
        this.gFw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bOv();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gFl.getLayoutParams();
        layoutParams.addRule(1, this.gFw.getId());
        this.gFl.setLayoutParams(layoutParams);
        this.gFx.setVisibility(8);
        this.gFy.setText(a.i.ala_person_report);
        this.gFE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.gFO) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.gFO);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.gFk.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.gFk.finish();
                }
            }
        });
        this.gFK = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.gFL = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.gFL.setIsRound(true);
        this.gFL.setAutoChangeStyle(false);
        this.gFL.setDrawBorder(false);
        this.gFL.setDefaultBgResource(a.f.sdk_default_avatar);
        if (!this.gFT) {
            this.gFM = (ViewGroup) this.mRootView.findViewById(a.g.anchor_tag_layout);
            this.gFM.setVisibility(8);
        }
    }

    private void initListener() {
        this.gFl.setOnClickListener(this);
        this.gFz.setOnClickListener(this);
        this.gFA.setOnClickListener(this);
        this.gFv.setOnClickListener(this);
        a(new a.InterfaceC0597a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0597a
            public void bOj() {
                PersonCardViewNew.this.gFk.bOe();
            }
        });
    }

    public void a(a.InterfaceC0597a interfaceC0597a) {
        this.gFR = interfaceC0597a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bbi = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            i(personUserData);
            this.gFS.setData(personUserData.user_info);
            if (this.gCw) {
                this.gFG.setVisibility(8);
            }
            if (this.gFG != null && this.gFG.getVisibility() == 0) {
                int childCount = this.gFG.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.gFG.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.gFG.getResources().getDimensionPixelOffset(i2 >= 3 ? a.e.sdk_ds20 : a.e.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.gFG.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.gFG.setWeightSum(i2);
                this.gFG.requestLayout();
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.gFT) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!aa.xh() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.wS()) {
                        this.gFM.setVisibility(8);
                        return;
                    }
                    this.gFM.setVisibility(0);
                    this.gFM.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.wR())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.wR().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.wR().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.gFk.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, sz(i));
                                this.gFM.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.gFk.getPageContext().getPageActivity());
                    alaPersonTagView2.setAddTagView();
                    alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PersonCardViewNew.this.gFV != null) {
                                PersonCardViewNew.this.gFV.bOh();
                            }
                        }
                    });
                    this.gFM.addView(alaPersonTagView2);
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

    private int sz(int i) {
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
            this.azm = personUserData.user_info != null && this.gFk.Ef(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.gFO = personUserData.user_info != null ? personUserData.user_info.aCN : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.gFP = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.gFP) {
                this.gFG.setVisibility(8);
            } else {
                this.gFG.setVisibility(0);
            }
            if (!z) {
                this.gFs.setText("火星");
            } else {
                this.gFs.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.gFB.setVisibility(8);
                this.gFJ.setVisibility(8);
            } else {
                this.gFB.setText(String.format(this.gFk.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.gFJ.setVisibility(0);
                this.gFB.setVisibility(0);
            }
            if (z2) {
                this.gFu.setText(String.format(this.gFk.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.gFu.setVisibility(0);
                this.gFI.setVisibility(0);
                return;
            }
            this.gFu.setVisibility(8);
            this.gFI.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOv() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.gFk.getActivity());
            this.gFk.finish();
        } else if (this.bbi != null && this.bbi.user_info != null && this.bbi.user_info.live_status == 1) {
            f fVar = new f(this.gFk);
            fVar.a(this.aZc, this.fjn, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bbi.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, fVar));
            this.gFk.finish();
        } else {
            if (this.gFU != null && this.gFU.isShowing()) {
                this.gFU.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.gFk.getActivity(), true);
            aVar.a(new a.InterfaceC0597a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0597a
                public void bOj() {
                    if (PersonCardViewNew.this.gFR != null) {
                        PersonCardViewNew.this.gFR.bOj();
                    }
                }
            });
            aVar.show();
            this.gFU = aVar;
        }
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        af afVar = personUserData.user_info;
        if (afVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(afVar.fans_count < 0 ? 0L : afVar.fans_count);
            this.gFn.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.gFp.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(afVar.follow_count < 0 ? 0L : afVar.follow_count);
            this.gFt.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.gFq.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.gFo.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.gFr.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.gFr.setText("");
            }
            int i2 = this.gFT ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.gFT) {
                i = 22;
            }
            this.gFn.setTextSize(1, i);
            this.gFt.setTextSize(1, i);
            this.gFo.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.gFl.setVisibility(8);
                this.gFw.setVisibility(8);
            } else if (this.gFk.Ef(TbadkCoreApplication.getCurrentAccount())) {
                this.gFw.setVisibility(8);
                this.gFl.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds32), 0, 0);
                this.gFl.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.gFl.setVisibility(0);
                this.gFw.setVisibility(0);
            } else {
                this.gFw.setVisibility(0);
                this.gFl.setVisibility(8);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        af afVar = personUserData.user_info;
        if (afVar != null && !StringUtils.isNull(afVar.getNameShow())) {
            String nameShow = afVar.getNameShow();
            if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
            }
            this.gFm.setText(nameShow);
        }
        k.a(this.gFE, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(afVar.description)) {
            this.gFC.setText(a.i.ala_person_desc_default_text);
        } else {
            this.gFC.setText(afVar.description);
        }
        Eh(afVar.aCJ);
    }

    private void Eh(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.gFF == null) {
                this.gFF = new TbImageView(this.gFD.getContext());
            }
            this.gFF.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
                    if (z && str.equals(str2) && PersonCardViewNew.this.gFD != null && PersonCardViewNew.this.gFF != null && PersonCardViewNew.this.gFF.getLoadedWidth() > 0 && PersonCardViewNew.this.gFF.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f2 = resources.getDisplayMetrics().density;
                            if (f2 > 0.0f) {
                                f = 3.0f / f2;
                                if (!PersonCardViewNew.this.gFT) {
                                    realScreenWidth = resources.getDimensionPixelOffset(a.e.sdk_ds800);
                                } else {
                                    realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                                }
                                float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gFF.getLoadedWidth();
                                layoutParams = PersonCardViewNew.this.gFD.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.width = -1;
                                    layoutParams.height = (int) (PersonCardViewNew.this.gFF.getLoadedHeight() * loadedWidth);
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((f > 0.0f ? f : 1.0f) * (-resources.getDimensionPixelOffset(a.e.sdk_ds214)) * loadedWidth);
                                    }
                                    PersonCardViewNew.this.gFD.setLayoutParams(layoutParams);
                                }
                                if (PersonCardViewNew.this.gFE != null) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gFE.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams2.removeRule(14);
                                    } else {
                                        layoutParams2.addRule(14, 0);
                                    }
                                    layoutParams2.addRule(13);
                                    PersonCardViewNew.this.gFE.setLayoutParams(layoutParams2);
                                }
                                if (PersonCardViewNew.this.gFD.indexOfChild(PersonCardViewNew.this.gFF) < 0) {
                                    PersonCardViewNew.this.gFD.addView(PersonCardViewNew.this.gFF, PersonCardViewNew.this.gFD.indexOfChild(PersonCardViewNew.this.gFE) + 1, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (PersonCardViewNew.this.fGD != null) {
                                    ViewGroup.LayoutParams layoutParams3 = PersonCardViewNew.this.fGD.getLayoutParams();
                                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PersonCardViewNew.this.fGD.getLayoutParams();
                                        float dimensionPixelOffset = resources.getDimensionPixelOffset(a.e.sdk_ds192) * loadedWidth;
                                        if (f <= 0.0f) {
                                            f = 1.0f;
                                        }
                                        marginLayoutParams.topMargin = (int) (f * dimensionPixelOffset);
                                        PersonCardViewNew.this.fGD.setLayoutParams(layoutParams3);
                                    }
                                }
                                if (PersonCardViewNew.this.gFw.getVisibility() != 0 && PersonCardViewNew.this.gFl.getVisibility() == 0) {
                                    PersonCardViewNew.this.gFl.setPadding(PersonCardViewNew.this.gFl.getPaddingLeft(), PersonCardViewNew.this.gFl.getPaddingTop(), resources.getDimensionPixelOffset(a.e.sdk_ds16), PersonCardViewNew.this.gFl.getPaddingBottom());
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gFl.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams4.removeRule(1);
                                    } else {
                                        layoutParams4.addRule(1, 0);
                                    }
                                    layoutParams4.addRule(11);
                                    PersonCardViewNew.this.gFl.setLayoutParams(layoutParams4);
                                    return;
                                }
                            }
                        }
                        f = 0.0f;
                        if (!PersonCardViewNew.this.gFT) {
                        }
                        float loadedWidth2 = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gFF.getLoadedWidth();
                        layoutParams = PersonCardViewNew.this.gFD.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        if (PersonCardViewNew.this.gFE != null) {
                        }
                        if (PersonCardViewNew.this.gFD.indexOfChild(PersonCardViewNew.this.gFF) < 0) {
                        }
                        if (PersonCardViewNew.this.fGD != null) {
                        }
                        if (PersonCardViewNew.this.gFw.getVisibility() != 0) {
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gFF.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.gFN = false;
            mj(false);
        } else if (!this.gFP && (alaRelationData = personUserData.relation_info) != null) {
            this.gFN = alaRelationData.follow_status != 0;
            if (z) {
                this.gFv.setVisibility(8);
            } else {
                mj(this.gFN);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.gFK.setVisibility(0);
            this.gFK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.gFV != null) {
                        PersonCardViewNew.this.gFV.bOg();
                    }
                }
            });
            this.gFL.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.gFK.setVisibility(4);
    }

    private void mj(boolean z) {
        if (z) {
            this.gFv.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gFv.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.gFv.setTextColor(this.gFk.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.gFv.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.gFv.setTextColor(this.gFk.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.gFv.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gFv.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.gFv.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.gFv.setTextColor(this.gFk.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.gFv.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.gFz != null && personUserData != null && personUserData.user_info != null) {
            this.gFz.setVisibility((this.gFQ && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gFv) {
            bOx();
        } else if (view == this.gFA) {
            bOr();
        } else if (view == this.gFz) {
            bOw();
        } else if (view == this.gFl) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.gFk, this.bbi}));
        }
    }

    private void bOw() {
        if (this.gFk != null && this.bbi != null && this.bbi.user_info != null && !TextUtils.isEmpty(this.bbi.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gFk.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bbi.user_info.live_id), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.gFk.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void bOr() {
        if (this.bbi != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gFk.getActivity());
            } else if (this.bbi.user_info == null || JavaTypesHelper.toLong(this.bbi.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gFk.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.bbi.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.gFk.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aYK = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bbi.user_info));
                this.gFk.finish();
            }
        }
    }

    private void bOx() {
        String str;
        if (this.bbi != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gFk.getActivity());
                this.gFk.finish();
            } else if (this.bbi.user_info == null || JavaTypesHelper.toLong(this.bbi.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gFk.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.gFN) {
                    sA(1);
                    this.gFk.bOd();
                } else {
                    sA(0);
                    this.gFk.bOc();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.gFN ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.azm) {
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

    public void sA(int i) {
        switch (i) {
            case 0:
                this.gFN = true;
                mj(true);
                if (this.bbi != null && this.bbi.user_info != null) {
                    this.bbi.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bbi.user_info.fans_count >= 0 ? this.bbi.user_info.fans_count : 0L);
                    this.gFn.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.gFp.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.gFN = false;
                mj(false);
                if (this.bbi != null && this.bbi.user_info != null) {
                    this.bbi.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bbi.user_info.fans_count >= 0 ? this.bbi.user_info.fans_count : 0L);
                    this.gFn.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.gFp.setText(formatForPersonCardBeanValue2[1]);
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

    public void mk(boolean z) {
        if (this.bbi != null && this.bbi.user_info != null) {
            if (z) {
                this.bbi.user_info.follow_count++;
            } else {
                this.bbi.user_info.follow_count--;
            }
            if (this.bbi.user_info.follow_count < 0) {
                this.bbi.user_info.follow_count = 0L;
            }
            this.gFv.setText(com.baidu.tieba.ala.person.d.a.ec(this.bbi.user_info.follow_count));
        }
    }

    private View kU(boolean z) {
        if (z) {
            return LayoutInflater.from(this.gFk.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.gFk.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void ml(boolean z) {
        this.gCw = z;
    }

    public void mm(boolean z) {
        this.gFQ = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.fTp == null) {
                        PersonCardViewNew.this.fTp = AnimationUtils.loadAnimation(PersonCardViewNew.this.gFk.getActivity(), a.C0178a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.gFH.setAnimation(PersonCardViewNew.this.fTp);
                    PersonCardViewNew.this.gFH.setVisibility(0);
                    PersonCardViewNew.this.fTp.setDuration(300L);
                    PersonCardViewNew.this.fTp.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.gFH != null) {
            this.gFH.clearAnimation();
        }
        if (this.gFU != null && this.gFU.isShowing()) {
            this.gFU.dismiss();
        }
    }

    public Animation bBL() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.fTp != null) {
            this.fTp.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.gFk.getActivity(), a.C0178a.sdk_push_up_out);
        this.gFH.setAnimation(loadAnimation);
        this.gFH.setVisibility(8);
        return loadAnimation;
    }

    public void aSA() {
        if (this.gFU != null && this.gFU.isShowing()) {
            this.gFU.resize();
        }
        if (this.bbi != null && this.bbi.user_info != null) {
            Eh(this.bbi.user_info.aCJ);
        }
    }

    public void dQ(String str, String str2) {
        this.aZc = JavaTypesHelper.toLong(str, 0L);
        this.fjn = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
