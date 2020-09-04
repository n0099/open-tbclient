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
    private boolean aEy;
    private long bey;
    private PersonUserData bgG;
    private View fRY;
    private long fuN;
    private boolean gOZ;
    protected final PersonCardActivity gRQ;
    private TextView gRR;
    private TextView gRS;
    private TextView gRT;
    private TextView gRU;
    private TextView gRV;
    private TextView gRW;
    private TextView gRX;
    private TextView gRY;
    private TextView gRZ;
    private com.baidu.tieba.ala.person.a gSA;
    private a gSB;
    private TextView gSa;
    private TextView gSb;
    private LinearLayout gSc;
    private ImageView gSd;
    private TextView gSe;
    private TextView gSf;
    private TextView gSg;
    private TextView gSh;
    private TextView gSi;
    private ViewGroup gSj;
    private HeadImageView gSk;
    private TbImageView gSl;
    private LinearLayout gSm;
    private View gSn;
    private View gSo;
    private View gSp;
    private View gSq;
    private HeadImageView gSr;
    private ViewGroup gSs;
    private boolean gSt;
    private String gSu;
    private boolean gSv;
    private boolean gSw;
    private a.InterfaceC0647a gSx;
    private com.baidu.tieba.ala.person.view.a gSy;
    private boolean gSz;
    private Animation gfs;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes7.dex */
    public interface a {
        void bYh();

        void bYi();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.gRQ = personCardActivity;
        this.gSz = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = lw(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.gSy = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.gSB = aVar;
    }

    private void initView() {
        this.gSn = this.mRootView.findViewById(a.g.person_card_layout);
        this.gRR = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.gSc = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.gSd = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.gSe = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fRY = this.mRootView.findViewById(a.g.name_layout);
        this.gRS = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gRT = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.gRU = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.gRV = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.gRX = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.gRW = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.gRY = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gRZ = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.gSa = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.gSi = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.gSb = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.gSh = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.gSm = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.gSo = this.mRootView.findViewById(a.g.user_divide);
        this.gSp = this.mRootView.findViewById(a.g.user_divide2);
        this.gSf = (TextView) this.mRootView.findViewById(a.g.btn_person_card_nav_liveroom);
        this.gSg = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gSf.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
            this.gSg.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.gSf.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
            this.gSg.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.gSj = (ViewGroup) this.mRootView.findViewById(a.g.layout_avatar);
        this.gSk = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gSk.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.gSk.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.gSk.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gSk.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.gSk.setIsRound(true);
        this.gSk.setAutoChangeStyle(false);
        this.gSk.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gSk.setBorderWidth(BdUtilHelper.getDimens(this.gRQ.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.gSk.setBorderColor(-1);
        this.gSc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bYw();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gRR.getLayoutParams();
        layoutParams.addRule(1, this.gSc.getId());
        this.gRR.setLayoutParams(layoutParams);
        this.gSd.setVisibility(8);
        this.gSe.setText(a.i.ala_person_report);
        this.gSk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.gSu) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.gSu);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.gRQ.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.gRQ.finish();
                }
            }
        });
        this.gSq = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.gSr = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.gSr.setIsRound(true);
        this.gSr.setAutoChangeStyle(false);
        this.gSr.setDrawBorder(false);
        this.gSr.setDefaultBgResource(a.f.sdk_default_avatar);
        if (!this.gSz) {
            this.gSs = (ViewGroup) this.mRootView.findViewById(a.g.anchor_tag_layout);
            this.gSs.setVisibility(8);
        }
    }

    private void initListener() {
        this.gRR.setOnClickListener(this);
        this.gSf.setOnClickListener(this);
        this.gSg.setOnClickListener(this);
        this.gSb.setOnClickListener(this);
        a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0647a
            public void bYk() {
                PersonCardViewNew.this.gRQ.bYf();
            }
        });
    }

    public void a(a.InterfaceC0647a interfaceC0647a) {
        this.gSx = interfaceC0647a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.bgG = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            i(personUserData);
            this.gSy.setData(personUserData.user_info);
            if (this.gOZ) {
                this.gSm.setVisibility(8);
            }
            if (this.gSm != null && this.gSm.getVisibility() == 0) {
                int childCount = this.gSm.getChildCount();
                int i = 0;
                int i2 = 0;
                while (i < childCount) {
                    int i3 = this.gSm.getChildAt(i).getVisibility() != 8 ? i2 + 1 : i2;
                    i++;
                    i2 = i3;
                }
                int dimensionPixelOffset = this.gSm.getResources().getDimensionPixelOffset(i2 >= 3 ? a.e.sdk_ds20 : a.e.sdk_ds38);
                for (int i4 = 0; i4 < childCount; i4++) {
                    ViewGroup.LayoutParams layoutParams = this.gSm.getChildAt(i4).getLayoutParams();
                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                        ((ViewGroup.MarginLayoutParams) layoutParams).rightMargin = dimensionPixelOffset;
                    }
                }
                this.gSm.setWeightSum(i2);
                this.gSm.requestLayout();
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.gSz) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!ac.CK() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.Cq()) {
                        this.gSs.setVisibility(8);
                        return;
                    }
                    this.gSs.setVisibility(0);
                    this.gSs.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.Cp())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.Cp().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.Cp().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.gRQ.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, uN(i));
                                this.gSs.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.gRQ.getPageContext().getPageActivity());
                    alaPersonTagView2.setAddTagView();
                    alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PersonCardViewNew.this.gSB != null) {
                                PersonCardViewNew.this.gSB.bYi();
                            }
                        }
                    });
                    this.gSs.addView(alaPersonTagView2);
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
            this.aEy = personUserData.user_info != null && this.gRQ.GF(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.gSu = personUserData.user_info != null ? personUserData.user_info.aHZ : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData.user_info != null) {
                this.gSv = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            }
            if (this.gSv) {
                this.gSm.setVisibility(8);
            } else {
                this.gSm.setVisibility(0);
            }
            if (!z) {
                this.gRY.setText("火星");
            } else {
                this.gRY.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.gSh.setVisibility(8);
                this.gSp.setVisibility(8);
            } else {
                this.gSh.setText(String.format(this.gRQ.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.gSp.setVisibility(0);
                this.gSh.setVisibility(0);
            }
            if (z2) {
                this.gSa.setText(String.format(this.gRQ.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.gSa.setVisibility(0);
                this.gSo.setVisibility(0);
                return;
            }
            this.gSa.setVisibility(8);
            this.gSo.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bYw() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.gRQ.getActivity());
            this.gRQ.finish();
        } else if (this.bgG != null && this.bgG.user_info != null && this.bgG.user_info.live_status == 1) {
            f fVar = new f(this.gRQ);
            fVar.a(this.bey, this.fuN, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bgG.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, fVar));
            this.gRQ.finish();
        } else {
            if (this.gSA != null && this.gSA.isShowing()) {
                this.gSA.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.gRQ.getActivity(), true);
            aVar.a(new a.InterfaceC0647a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0647a
                public void bYk() {
                    if (PersonCardViewNew.this.gSx != null) {
                        PersonCardViewNew.this.gSx.bYk();
                    }
                }
            });
            aVar.show();
            this.gSA = aVar;
        }
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        ah ahVar = personUserData.user_info;
        if (ahVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(ahVar.fans_count < 0 ? 0L : ahVar.fans_count);
            this.gRT.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.gRV.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(ahVar.follow_count < 0 ? 0L : ahVar.follow_count);
            this.gRZ.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.gRW.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.gRU.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.gRX.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.gRX.setText("");
            }
            int i2 = this.gSz ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.gSz) {
                i = 22;
            }
            this.gRT.setTextSize(1, i);
            this.gRZ.setTextSize(1, i);
            this.gRU.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.gRR.setVisibility(8);
                this.gSc.setVisibility(8);
            } else if (this.gRQ.GF(TbadkCoreApplication.getCurrentAccount())) {
                this.gSc.setVisibility(8);
                this.gRR.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds32), 0, 0);
                this.gRR.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.gRR.setVisibility(0);
                this.gSc.setVisibility(0);
            } else {
                this.gSc.setVisibility(0);
                this.gRR.setVisibility(8);
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
            this.gRS.setText(nameShow);
        }
        k.a(this.gSk, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(ahVar.description)) {
            this.gSi.setText(a.i.ala_person_desc_default_text);
        } else {
            this.gSi.setText(ahVar.description);
        }
        GH(ahVar.aHV);
    }

    private void GH(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.gSl == null) {
                this.gSl = new TbImageView(this.gSj.getContext());
            }
            this.gSl.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
                    if (z && str.equals(str2) && PersonCardViewNew.this.gSj != null && PersonCardViewNew.this.gSl != null && PersonCardViewNew.this.gSl.getLoadedWidth() > 0 && PersonCardViewNew.this.gSl.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f2 = resources.getDisplayMetrics().density;
                            if (f2 > 0.0f) {
                                f = 3.0f / f2;
                                if (!PersonCardViewNew.this.gSz) {
                                    realScreenWidth = resources.getDimensionPixelOffset(a.e.sdk_ds800);
                                } else {
                                    realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                                }
                                float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gSl.getLoadedWidth();
                                layoutParams = PersonCardViewNew.this.gSj.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.width = -1;
                                    layoutParams.height = (int) (PersonCardViewNew.this.gSl.getLoadedHeight() * loadedWidth);
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((f > 0.0f ? f : 1.0f) * (-resources.getDimensionPixelOffset(a.e.sdk_ds214)) * loadedWidth);
                                    }
                                    PersonCardViewNew.this.gSj.setLayoutParams(layoutParams);
                                }
                                if (PersonCardViewNew.this.gSk != null) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gSk.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams2.removeRule(14);
                                    } else {
                                        layoutParams2.addRule(14, 0);
                                    }
                                    layoutParams2.addRule(13);
                                    PersonCardViewNew.this.gSk.setLayoutParams(layoutParams2);
                                }
                                if (PersonCardViewNew.this.gSj.indexOfChild(PersonCardViewNew.this.gSl) < 0) {
                                    PersonCardViewNew.this.gSj.addView(PersonCardViewNew.this.gSl, PersonCardViewNew.this.gSj.indexOfChild(PersonCardViewNew.this.gSk) + 1, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (PersonCardViewNew.this.fRY != null) {
                                    ViewGroup.LayoutParams layoutParams3 = PersonCardViewNew.this.fRY.getLayoutParams();
                                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PersonCardViewNew.this.fRY.getLayoutParams();
                                        float dimensionPixelOffset = resources.getDimensionPixelOffset(a.e.sdk_ds192) * loadedWidth;
                                        if (f <= 0.0f) {
                                            f = 1.0f;
                                        }
                                        marginLayoutParams.topMargin = (int) (f * dimensionPixelOffset);
                                        PersonCardViewNew.this.fRY.setLayoutParams(layoutParams3);
                                    }
                                }
                                if (PersonCardViewNew.this.gSc.getVisibility() != 0 && PersonCardViewNew.this.gRR.getVisibility() == 0) {
                                    PersonCardViewNew.this.gRR.setPadding(PersonCardViewNew.this.gRR.getPaddingLeft(), PersonCardViewNew.this.gRR.getPaddingTop(), resources.getDimensionPixelOffset(a.e.sdk_ds16), PersonCardViewNew.this.gRR.getPaddingBottom());
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gRR.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams4.removeRule(1);
                                    } else {
                                        layoutParams4.addRule(1, 0);
                                    }
                                    layoutParams4.addRule(11);
                                    PersonCardViewNew.this.gRR.setLayoutParams(layoutParams4);
                                    return;
                                }
                            }
                        }
                        f = 0.0f;
                        if (!PersonCardViewNew.this.gSz) {
                        }
                        float loadedWidth2 = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gSl.getLoadedWidth();
                        layoutParams = PersonCardViewNew.this.gSj.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        if (PersonCardViewNew.this.gSk != null) {
                        }
                        if (PersonCardViewNew.this.gSj.indexOfChild(PersonCardViewNew.this.gSl) < 0) {
                        }
                        if (PersonCardViewNew.this.fRY != null) {
                        }
                        if (PersonCardViewNew.this.gSc.getVisibility() != 0) {
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gSl.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.gSt = false;
            mN(false);
        } else if (!this.gSv && (alaRelationData = personUserData.relation_info) != null) {
            this.gSt = alaRelationData.follow_status != 0;
            if (z) {
                this.gSb.setVisibility(8);
            } else {
                mN(this.gSt);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.gSq.setVisibility(0);
            this.gSq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.gSB != null) {
                        PersonCardViewNew.this.gSB.bYh();
                    }
                }
            });
            this.gSr.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.gSq.setVisibility(4);
    }

    private void mN(boolean z) {
        if (z) {
            this.gSb.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gSb.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.gSb.setTextColor(this.gRQ.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.gSb.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.gSb.setTextColor(this.gRQ.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.gSb.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gSb.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.gSb.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.gSb.setTextColor(this.gRQ.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.gSb.setVisibility(0);
    }

    private void i(PersonUserData personUserData) {
        if (this.gSf != null && personUserData != null && personUserData.user_info != null) {
            this.gSf.setVisibility((this.gSw && personUserData.user_info.live_status == 1) ? 0 : 8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gSb) {
            bYy();
        } else if (view == this.gSg) {
            bYs();
        } else if (view == this.gSf) {
            bYx();
        } else if (view == this.gRR) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.gRQ, this.bgG}));
        }
    }

    private void bYx() {
        if (this.gRQ != null && this.bgG != null && this.bgG.user_info != null && !TextUtils.isEmpty(this.bgG.user_info.live_id)) {
            try {
                AlaLiveRoomActivityConfig alaLiveRoomActivityConfig = new AlaLiveRoomActivityConfig(this.gRQ.getPageContext().getPageActivity());
                alaLiveRoomActivityConfig.addExtraByLiveId(Long.parseLong(this.bgG.user_info.live_id), "", AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_SDK);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_LIVE_ROOM_START, alaLiveRoomActivityConfig));
                this.gRQ.finish();
            } catch (Throwable th) {
            }
        }
    }

    private void bYs() {
        if (this.bgG != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gRQ.getActivity());
            } else if (this.bgG.user_info == null || JavaTypesHelper.toLong(this.bgG.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gRQ.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.bgG.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.gRQ.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bed = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bgG.user_info));
                this.gRQ.finish();
            }
        }
    }

    private void bYy() {
        String str;
        if (this.bgG != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gRQ.getActivity());
                this.gRQ.finish();
            } else if (this.bgG.user_info == null || JavaTypesHelper.toLong(this.bgG.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gRQ.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.gSt) {
                    uO(1);
                    this.gRQ.bYe();
                } else {
                    uO(0);
                    this.gRQ.bYd();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.gSt ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aEy) {
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
                this.gSt = true;
                mN(true);
                if (this.bgG != null && this.bgG.user_info != null) {
                    this.bgG.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.bgG.user_info.fans_count >= 0 ? this.bgG.user_info.fans_count : 0L);
                    this.gRT.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.gRV.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.gSt = false;
                mN(false);
                if (this.bgG != null && this.bgG.user_info != null) {
                    this.bgG.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.bgG.user_info.fans_count >= 0 ? this.bgG.user_info.fans_count : 0L);
                    this.gRT.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.gRV.setText(formatForPersonCardBeanValue2[1]);
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

    public void mO(boolean z) {
        if (this.bgG != null && this.bgG.user_info != null) {
            if (z) {
                this.bgG.user_info.follow_count++;
            } else {
                this.bgG.user_info.follow_count--;
            }
            if (this.bgG.user_info.follow_count < 0) {
                this.bgG.user_info.follow_count = 0L;
            }
            this.gSb.setText(com.baidu.tieba.ala.person.d.a.en(this.bgG.user_info.follow_count));
        }
    }

    private View lw(boolean z) {
        if (z) {
            return LayoutInflater.from(this.gRQ.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.gRQ.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void mP(boolean z) {
        this.gOZ = z;
    }

    public void mQ(boolean z) {
        this.gSw = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.gfs == null) {
                        PersonCardViewNew.this.gfs = AnimationUtils.loadAnimation(PersonCardViewNew.this.gRQ.getActivity(), a.C0185a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.gSn.setAnimation(PersonCardViewNew.this.gfs);
                    PersonCardViewNew.this.gSn.setVisibility(0);
                    PersonCardViewNew.this.gfs.setDuration(300L);
                    PersonCardViewNew.this.gfs.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.gSn != null) {
            this.gSn.clearAnimation();
        }
        if (this.gSA != null && this.gSA.isShowing()) {
            this.gSA.dismiss();
        }
    }

    public Animation bLg() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.gfs != null) {
            this.gfs.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.gRQ.getActivity(), a.C0185a.sdk_push_up_out);
        this.gSn.setAnimation(loadAnimation);
        this.gSn.setVisibility(8);
        return loadAnimation;
    }

    public void baR() {
        if (this.gSA != null && this.gSA.isShowing()) {
            this.gSA.resize();
        }
        if (this.bgG != null && this.bgG.user_info != null) {
            GH(this.bgG.user_info.aHV);
        }
    }

    public void ei(String str, String str2) {
        this.bey = JavaTypesHelper.toLong(str, 0L);
        this.fuN = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
    }
}
