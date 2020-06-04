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
    private Animation fCN;
    private View fqi;
    private boolean gki;
    protected final PersonCardActivity gmZ;
    private ViewGroup gnA;
    private boolean gnB;
    private String gnC;
    private boolean gnD;
    private a.InterfaceC0579a gnE;
    private com.baidu.tieba.ala.person.view.a gnF;
    private boolean gnG;
    private com.baidu.tieba.ala.person.a gnH;
    private a gnI;
    private TextView gna;
    private TextView gnb;
    private TextView gnc;
    private TextView gnd;
    private TextView gne;
    private TextView gnf;
    private TextView gng;
    private TextView gnh;
    private TextView gni;
    private TextView gnj;
    private TextView gnk;
    private LinearLayout gnl;
    private ImageView gnm;
    private TextView gnn;
    private TextView gno;
    private TextView gnp;
    private TextView gnq;
    private ViewGroup gnr;
    private HeadImageView gns;
    private TbImageView gnt;
    private LinearLayout gnu;
    private View gnv;
    private View gnw;
    private View gnx;
    private View gny;
    private HeadImageView gnz;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    /* loaded from: classes3.dex */
    public interface a {
        void bHS();

        void bHT();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.gmZ = personCardActivity;
        this.gnG = z;
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
        this.gnF = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.gnI = aVar;
    }

    private void initView() {
        this.gnv = this.mRootView.findViewById(a.g.person_card_layout);
        this.gna = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.gnl = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.gnm = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.gnn = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fqi = this.mRootView.findViewById(a.g.name_layout);
        this.gnb = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.gnc = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.gnd = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.gne = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.gng = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.gnf = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.gnh = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.gni = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.gnj = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.gnq = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.gnk = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.gnp = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.gnu = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.gnw = this.mRootView.findViewById(a.g.user_divide);
        this.gnx = this.mRootView.findViewById(a.g.user_divide2);
        this.gno = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gno.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.gno.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.gnr = (ViewGroup) this.mRootView.findViewById(a.g.layout_avatar);
        this.gns = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.gns.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.gns.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.gns.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.gns.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.gns.setIsRound(true);
        this.gns.setAutoChangeStyle(false);
        this.gns.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.gns.setBorderWidth(BdUtilHelper.getDimens(this.gmZ.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.gns.setBorderColor(-1);
        this.gnl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bIi();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.gna.getLayoutParams();
        layoutParams.addRule(1, this.gnl.getId());
        this.gna.setLayoutParams(layoutParams);
        this.gnm.setVisibility(8);
        this.gnn.setText(a.i.ala_person_report);
        this.gns.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.gnC) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.gnC);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.gmZ.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.gmZ.finish();
                }
            }
        });
        this.gny = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.gnz = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.gnz.setIsRound(true);
        this.gnz.setAutoChangeStyle(false);
        this.gnz.setDrawBorder(false);
        this.gnz.setDefaultBgResource(a.f.sdk_default_avatar);
        if (!this.gnG) {
            this.gnA = (ViewGroup) this.mRootView.findViewById(a.g.anchor_tag_layout);
            this.gnA.setVisibility(8);
        }
    }

    private void initListener() {
        this.gna.setOnClickListener(this);
        this.gno.setOnClickListener(this);
        this.gnk.setOnClickListener(this);
        a(new a.InterfaceC0579a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0579a
            public void bHW() {
                PersonCardViewNew.this.gmZ.bHQ();
            }
        });
    }

    public void a(a.InterfaceC0579a interfaceC0579a) {
        this.gnE = interfaceC0579a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.aYt = personUserData;
            f(personUserData);
            e(personUserData);
            b(personUserData, z);
            h(personUserData);
            d(personUserData);
            this.gnF.setData(personUserData.user_info);
            if (this.gki) {
                this.gnu.setVisibility(8);
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (!this.gnG) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (personUserData != null && personUserData.user_info != null) {
                if (currentAccount == null || !currentAccount.equals(personUserData.user_info.user_id)) {
                    if (!z.wh() || personUserData.mAnchorTagData == null || !personUserData.mAnchorTagData.vS()) {
                        this.gnA.setVisibility(8);
                        return;
                    }
                    this.gnA.setVisibility(0);
                    this.gnA.removeAllViews();
                    int dimensionPixelSize = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds40);
                    int dimensionPixelSize2 = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds10);
                    if (!ListUtils.isEmpty(personUserData.mAnchorTagData.vR())) {
                        int min = Math.min(3, personUserData.mAnchorTagData.vR().size());
                        for (int i = 0; i < min; i++) {
                            String str = personUserData.mAnchorTagData.vR().get(i);
                            if (!StringUtils.isNull(str)) {
                                AlaPersonTagView alaPersonTagView = new AlaPersonTagView(this.gmZ.getPageContext().getPageActivity());
                                alaPersonTagView.setTagView(str, rJ(i));
                                this.gnA.addView(alaPersonTagView);
                                a(alaPersonTagView, dimensionPixelSize2, dimensionPixelSize);
                            }
                        }
                    }
                    AlaPersonTagView alaPersonTagView2 = new AlaPersonTagView(this.gmZ.getPageContext().getPageActivity());
                    alaPersonTagView2.setAddTagView();
                    alaPersonTagView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (PersonCardViewNew.this.gnI != null) {
                                PersonCardViewNew.this.gnI.bHT();
                            }
                        }
                    });
                    this.gnA.addView(alaPersonTagView2);
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

    private int rJ(int i) {
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
            this.avR = personUserData.user_info != null && this.gmZ.CS(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.gnC = personUserData.user_info != null ? personUserData.user_info.azb : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.gnD = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.gnD) {
                this.gnu.setVisibility(8);
            } else {
                this.gnu.setVisibility(0);
            }
            if (!z) {
                this.gnh.setText("火星");
            } else {
                this.gnh.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.gnp.setVisibility(8);
                this.gnx.setVisibility(8);
            } else {
                this.gnp.setText(String.format(this.gmZ.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.gnx.setVisibility(0);
                this.gnp.setVisibility(0);
            }
            if (z2) {
                this.gnj.setText(String.format(this.gmZ.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.gnj.setVisibility(0);
                this.gnw.setVisibility(0);
                return;
            }
            this.gnj.setVisibility(8);
            this.gnw.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bIi() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.gmZ.getActivity());
            this.gmZ.finish();
            return;
        }
        if (this.gnH != null && this.gnH.isShowing()) {
            this.gnH.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.gmZ.getActivity(), true);
        aVar.a(new a.InterfaceC0579a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0579a
            public void bHW() {
                if (PersonCardViewNew.this.gnE != null) {
                    PersonCardViewNew.this.gnE.bHW();
                }
            }
        });
        aVar.show();
        this.gnH = aVar;
    }

    private void f(PersonUserData personUserData) {
        int i = 26;
        ad adVar = personUserData.user_info;
        if (adVar != null) {
            g(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(adVar.fans_count < 0 ? 0L : adVar.fans_count);
            this.gnc.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.gne.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(adVar.follow_count < 0 ? 0L : adVar.follow_count);
            this.gni.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.gnf.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.gnd.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.gng.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.gng.setText("");
            }
            int i2 = this.gnG ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.gnG) {
                i = 22;
            }
            this.gnc.setTextSize(1, i);
            this.gni.setTextSize(1, i);
            this.gnd.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.gna.setVisibility(8);
                this.gnl.setVisibility(8);
            } else if (this.gmZ.CS(TbadkCoreApplication.getCurrentAccount())) {
                this.gnl.setVisibility(8);
                this.gna.setPadding(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds16), TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds32), 0, 0);
                this.gna.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.gna.setVisibility(0);
                this.gnl.setVisibility(0);
            } else {
                this.gnl.setVisibility(0);
                this.gna.setVisibility(8);
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
            this.gnb.setText(nameShow);
        }
        k.a(this.gns, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(adVar.description)) {
            this.gnq.setText(a.i.ala_person_desc_default_text);
        } else {
            this.gnq.setText(adVar.description);
        }
        CV(adVar.ayX);
    }

    private void CV(final String str) {
        if (getRootView().getVisibility() == 0 && !TextUtils.isEmpty(str)) {
            if (this.gnt == null) {
                this.gnt = new TbImageView(this.gnr.getContext());
            }
            this.gnt.setEvent(new TbImageView.ImageViewEvent() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
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
                    if (z && str.equals(str2) && PersonCardViewNew.this.gnr != null && PersonCardViewNew.this.gnt != null && PersonCardViewNew.this.gnt.getLoadedWidth() > 0 && PersonCardViewNew.this.gnt.getLoadedHeight() > 0 && (resources = TbadkCoreApplication.getInst().getResources()) != null) {
                        if (resources.getDisplayMetrics() != null) {
                            float f2 = resources.getDisplayMetrics().density;
                            if (f2 > 0.0f) {
                                f = 3.0f / f2;
                                if (!PersonCardViewNew.this.gnG) {
                                    realScreenWidth = resources.getDimensionPixelOffset(a.e.sdk_ds800);
                                } else {
                                    realScreenWidth = ScreenHelper.getRealScreenWidth(TbadkCoreApplication.getInst());
                                }
                                float loadedWidth = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gnt.getLoadedWidth();
                                layoutParams = PersonCardViewNew.this.gnr.getLayoutParams();
                                if (layoutParams != null) {
                                    layoutParams.width = -1;
                                    layoutParams.height = (int) (PersonCardViewNew.this.gnt.getLoadedHeight() * loadedWidth);
                                    if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                                        ((ViewGroup.MarginLayoutParams) layoutParams).bottomMargin = (int) ((f > 0.0f ? f : 1.0f) * (-resources.getDimensionPixelOffset(a.e.sdk_ds214)) * loadedWidth);
                                    }
                                    PersonCardViewNew.this.gnr.setLayoutParams(layoutParams);
                                }
                                if (PersonCardViewNew.this.gns != null) {
                                    RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gns.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams2.removeRule(14);
                                    } else {
                                        layoutParams2.addRule(14, 0);
                                    }
                                    layoutParams2.addRule(13);
                                    PersonCardViewNew.this.gns.setLayoutParams(layoutParams2);
                                }
                                if (PersonCardViewNew.this.gnr.indexOfChild(PersonCardViewNew.this.gnt) < 0) {
                                    PersonCardViewNew.this.gnr.addView(PersonCardViewNew.this.gnt, PersonCardViewNew.this.gnr.indexOfChild(PersonCardViewNew.this.gns) + 1, new ViewGroup.LayoutParams(-1, -1));
                                }
                                if (PersonCardViewNew.this.fqi != null) {
                                    ViewGroup.LayoutParams layoutParams3 = PersonCardViewNew.this.fqi.getLayoutParams();
                                    if (layoutParams3 instanceof ViewGroup.MarginLayoutParams) {
                                        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) PersonCardViewNew.this.fqi.getLayoutParams();
                                        float dimensionPixelOffset = resources.getDimensionPixelOffset(a.e.sdk_ds192) * loadedWidth;
                                        if (f <= 0.0f) {
                                            f = 1.0f;
                                        }
                                        marginLayoutParams.topMargin = (int) (f * dimensionPixelOffset);
                                        PersonCardViewNew.this.fqi.setLayoutParams(layoutParams3);
                                    }
                                }
                                if (PersonCardViewNew.this.gnl.getVisibility() != 0 && PersonCardViewNew.this.gna.getVisibility() == 0) {
                                    PersonCardViewNew.this.gna.setPadding(PersonCardViewNew.this.gna.getPaddingLeft(), PersonCardViewNew.this.gna.getPaddingTop(), resources.getDimensionPixelOffset(a.e.sdk_ds16), PersonCardViewNew.this.gna.getPaddingBottom());
                                    RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) PersonCardViewNew.this.gna.getLayoutParams();
                                    if (Build.VERSION.SDK_INT >= 17) {
                                        layoutParams4.removeRule(1);
                                    } else {
                                        layoutParams4.addRule(1, 0);
                                    }
                                    layoutParams4.addRule(11);
                                    PersonCardViewNew.this.gna.setLayoutParams(layoutParams4);
                                    return;
                                }
                            }
                        }
                        f = 0.0f;
                        if (!PersonCardViewNew.this.gnG) {
                        }
                        float loadedWidth2 = (realScreenWidth * 1.0f) / PersonCardViewNew.this.gnt.getLoadedWidth();
                        layoutParams = PersonCardViewNew.this.gnr.getLayoutParams();
                        if (layoutParams != null) {
                        }
                        if (PersonCardViewNew.this.gns != null) {
                        }
                        if (PersonCardViewNew.this.gnr.indexOfChild(PersonCardViewNew.this.gnt) < 0) {
                        }
                        if (PersonCardViewNew.this.fqi != null) {
                        }
                        if (PersonCardViewNew.this.gnl.getVisibility() != 0) {
                        }
                    }
                }

                @Override // com.baidu.live.tbadk.widget.TbImageView.ImageViewEvent
                public void onCancel() {
                }
            });
            this.gnt.startLoad(str, 10, false, false);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.gnB = false;
            lx(false);
        } else if (!this.gnD && (alaRelationData = personUserData.relation_info) != null) {
            this.gnB = alaRelationData.follow_status != 0;
            if (z) {
                this.gnk.setVisibility(8);
            } else {
                lx(this.gnB);
            }
        }
    }

    private void h(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.gny.setVisibility(0);
            this.gny.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.8
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.gnI != null) {
                        PersonCardViewNew.this.gnI.bHS();
                    }
                }
            });
            this.gnz.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.gny.setVisibility(4);
    }

    private void lx(boolean z) {
        if (z) {
            this.gnk.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gnk.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.gnk.setTextColor(this.gmZ.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.gnk.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.gnk.setTextColor(this.gmZ.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.gnk.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.gnk.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.gnk.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.gnk.setTextColor(this.gmZ.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.gnk.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gnk) {
            bIj();
        } else if (view == this.gno) {
            bIe();
        } else if (view == this.gna) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.gmZ, this.aYt}));
        }
    }

    private void bIe() {
        if (this.aYt != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gmZ.getActivity());
            } else if (this.aYt.user_info == null || JavaTypesHelper.toLong(this.aYt.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gmZ.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.aYt.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.gmZ.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aWd = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aYt.user_info));
                this.gmZ.finish();
            }
        }
    }

    private void bIj() {
        String str;
        if (this.aYt != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.gmZ.getActivity());
                this.gmZ.finish();
            } else if (this.aYt.user_info == null || JavaTypesHelper.toLong(this.aYt.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.gmZ.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.gnB) {
                    rK(1);
                    this.gmZ.bHP();
                } else {
                    rK(0);
                    this.gmZ.bHO();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.gnB ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
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

    public void rK(int i) {
        switch (i) {
            case 0:
                this.gnB = true;
                lx(true);
                if (this.aYt != null && this.aYt.user_info != null) {
                    this.aYt.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.aYt.user_info.fans_count >= 0 ? this.aYt.user_info.fans_count : 0L);
                    this.gnc.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.gne.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.gnB = false;
                lx(false);
                if (this.aYt != null && this.aYt.user_info != null) {
                    this.aYt.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.aYt.user_info.fans_count >= 0 ? this.aYt.user_info.fans_count : 0L);
                    this.gnc.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.gne.setText(formatForPersonCardBeanValue2[1]);
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
            this.gnk.setText(com.baidu.tieba.ala.person.d.a.dM(this.aYt.user_info.follow_count));
        }
    }

    private View kc(boolean z) {
        if (z) {
            return LayoutInflater.from(this.gmZ.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.gmZ.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void lz(boolean z) {
        this.gki = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.9
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.fCN == null) {
                        PersonCardViewNew.this.fCN = AnimationUtils.loadAnimation(PersonCardViewNew.this.gmZ.getActivity(), a.C0182a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.gnv.setAnimation(PersonCardViewNew.this.fCN);
                    PersonCardViewNew.this.gnv.setVisibility(0);
                    PersonCardViewNew.this.fCN.setDuration(300L);
                    PersonCardViewNew.this.fCN.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.gnv != null) {
            this.gnv.clearAnimation();
        }
        if (this.gnH != null && this.gnH.isShowing()) {
            this.gnH.dismiss();
        }
    }

    public Animation bvB() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.fCN != null) {
            this.fCN.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.gmZ.getActivity(), a.C0182a.sdk_push_up_out);
        this.gnv.setAnimation(loadAnimation);
        this.gnv.setVisibility(8);
        return loadAnimation;
    }

    public void aNc() {
        if (this.gnH != null && this.gnH.isShowing()) {
            this.gnH.resize();
        }
        if (this.aYt != null && this.aYt.user_info != null) {
            CV(this.aYt.user_info.ayX);
        }
    }
}
