package com.baidu.tieba.ala.person.view;

import android.graphics.drawable.GradientDrawable;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
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
import com.baidu.live.data.z;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
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
import com.baidu.live.u.a;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
/* loaded from: classes3.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private PersonUserData aRb;
    private boolean aqL;
    private boolean fUY;
    protected final PersonCardActivity fXR;
    private TextView fXS;
    private TextView fXT;
    private TextView fXU;
    private TextView fXV;
    private TextView fXW;
    private TextView fXX;
    private TextView fXY;
    private TextView fXZ;
    private TextView fYa;
    private TextView fYb;
    private TextView fYc;
    private LinearLayout fYd;
    private ImageView fYe;
    private TextView fYf;
    private TextView fYg;
    private TextView fYh;
    private TextView fYi;
    private HeadImageView fYj;
    private LinearLayout fYk;
    private FrameLayout fYl;
    private View fYm;
    private View fYn;
    private View fYo;
    private View fYp;
    private HeadImageView fYq;
    private boolean fYr;
    private String fYs;
    private boolean fYt;
    private a.InterfaceC0508a fYu;
    private com.baidu.tieba.ala.person.view.a fYv;
    private boolean fYw;
    private com.baidu.tieba.ala.person.a fYx;
    private a fYy;
    private Animation foH;
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;
    private final int fXQ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private final int fEc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private Handler mHandler = new Handler();

    /* loaded from: classes3.dex */
    public interface a {
        void bBA();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.fXR = personCardActivity;
        this.fYw = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = jJ(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.fYv = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.fYy = aVar;
    }

    private void initView() {
        this.fYm = this.mRootView.findViewById(a.g.person_card_layout);
        this.fXS = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.fYd = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.fYe = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.fYf = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fXT = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fXU = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.fXV = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.fXW = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.fXY = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.fXX = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.fXZ = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.fYa = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.fYb = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.fYi = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.fYc = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.fYh = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.fYk = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.fYn = this.mRootView.findViewById(a.g.user_divide);
        this.fYo = this.mRootView.findViewById(a.g.user_divide2);
        this.fYl = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fYg = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fYg.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.fYg.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.fYj = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fYj.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.fYj.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.fYj.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.fYj.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.fYj.setIsRound(true);
        this.fYj.setAutoChangeStyle(false);
        this.fYj.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fYj.setBorderWidth(BdUtilHelper.getDimens(this.fXR.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.fYj.setBorderColor(872415231);
        this.fYd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bBP();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fXS.getLayoutParams();
        layoutParams.addRule(1, this.fYd.getId());
        this.fXS.setLayoutParams(layoutParams);
        this.fYe.setVisibility(8);
        this.fYf.setText(a.i.ala_person_report);
        this.fYl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.fYs) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.fYs);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.fXR.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.fXR.finish();
                }
            }
        });
        this.fYp = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.fYq = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.fYq.setIsRound(true);
        this.fYq.setAutoChangeStyle(false);
        this.fYq.setDrawBorder(false);
        this.fYq.setDefaultBgResource(a.f.sdk_default_avatar);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(this.fXR.getResources().getDimensionPixelOffset(a.e.sdk_ds4), -1);
        this.mRootView.findViewById(a.g.portrait_ring).setBackgroundDrawable(gradientDrawable);
    }

    private void initListener() {
        this.fXS.setOnClickListener(this);
        this.fYg.setOnClickListener(this);
        this.fYc.setOnClickListener(this);
        a(new a.InterfaceC0508a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0508a
            public void bBD() {
                PersonCardViewNew.this.fXR.bBy();
            }
        });
    }

    public void a(a.InterfaceC0508a interfaceC0508a) {
        this.fYu = interfaceC0508a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.aRb = personUserData;
            e(personUserData);
            d(personUserData);
            b(personUserData, z);
            g(personUserData);
            this.fYv.setData(personUserData.user_info);
            if (this.fUY) {
                this.fYk.setVisibility(8);
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aqL = personUserData.user_info != null && this.fXR.Bh(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.fYs = personUserData.user_info != null ? personUserData.user_info.atR : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.fYt = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.fYt) {
                this.fYk.setVisibility(8);
            } else {
                this.fYk.setVisibility(0);
            }
            if (!z) {
                this.fXZ.setText("火星");
            } else {
                this.fXZ.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.fYh.setVisibility(8);
                this.fYo.setVisibility(8);
            } else {
                this.fYh.setText(String.format(this.fXR.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.fYo.setVisibility(0);
                this.fYh.setVisibility(0);
            }
            if (z2) {
                this.fYb.setText(String.format(this.fXR.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.fYb.setVisibility(0);
                this.fYn.setVisibility(0);
                return;
            }
            this.fYb.setVisibility(8);
            this.fYn.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBP() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.fXR.getActivity());
            this.fXR.finish();
            return;
        }
        if (this.fYx != null && this.fYx.isShowing()) {
            this.fYx.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.fXR.getActivity(), true);
        aVar.a(new a.InterfaceC0508a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0508a
            public void bBD() {
                if (PersonCardViewNew.this.fYu != null) {
                    PersonCardViewNew.this.fYu.bBD();
                }
            }
        });
        aVar.show();
        this.fYx = aVar;
    }

    private void e(PersonUserData personUserData) {
        int i = 26;
        z zVar = personUserData.user_info;
        if (zVar != null) {
            f(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(zVar.fans_count < 0 ? 0L : zVar.fans_count);
            this.fXU.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.fXW.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(zVar.follow_count < 0 ? 0L : zVar.follow_count);
            this.fYa.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.fXX.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.fXV.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.fXY.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.fXY.setText("");
            }
            int i2 = this.fYw ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.fYw) {
                i = 22;
            }
            this.fXU.setTextSize(1, i);
            this.fYa.setTextSize(1, i);
            this.fXV.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.fXS.setVisibility(8);
                this.fYd.setVisibility(8);
            } else if (this.fXR.Bh(TbadkCoreApplication.getCurrentAccount())) {
                this.fYd.setVisibility(8);
                this.fXS.setPadding(this.fXQ, this.fEc, 0, 0);
                this.fXS.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.fXS.setVisibility(0);
                this.fYd.setVisibility(0);
            } else {
                this.fYd.setVisibility(0);
                this.fXS.setVisibility(8);
            }
        }
    }

    private void f(PersonUserData personUserData) {
        z zVar = personUserData.user_info;
        this.fXT.setText(zVar.getNameShow());
        k.a(this.fYj, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(zVar.description)) {
            this.fYi.setText(a.i.ala_person_desc_default_text);
        } else {
            this.fYi.setText(zVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.fYr = false;
            la(false);
        } else if (!this.fYt && (alaRelationData = personUserData.relation_info) != null) {
            this.fYr = alaRelationData.follow_status != 0;
            if (z) {
                this.fYc.setVisibility(8);
            } else {
                la(this.fYr);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.fYp.setVisibility(0);
            this.fYp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.fYy != null) {
                        PersonCardViewNew.this.fYy.bBA();
                    }
                }
            });
            this.fYq.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.fYp.setVisibility(4);
    }

    private void la(boolean z) {
        if (z) {
            this.fYc.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fYc.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.fYc.setTextColor(this.fXR.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.fYc.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.fYc.setTextColor(this.fXR.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.fYc.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fYc.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.fYc.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.fYc.setTextColor(this.fXR.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.fYc.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fYc) {
            bBQ();
        } else if (view == this.fYg) {
            bBL();
        } else if (view == this.fXS) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.fXR, this.aRb}));
        }
    }

    private void bBL() {
        if (this.aRb != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fXR.getActivity());
            } else if (this.aRb.user_info == null || JavaTypesHelper.toLong(this.aRb.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fXR.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.aRb.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.fXR.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aPO = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aRb.user_info));
                this.fXR.finish();
            }
        }
    }

    private void bBQ() {
        String str;
        if (this.aRb != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fXR.getActivity());
                this.fXR.finish();
            } else if (this.aRb.user_info == null || JavaTypesHelper.toLong(this.aRb.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fXR.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.fYr) {
                    rf(1);
                    this.fXR.bBx();
                } else {
                    rf(0);
                    this.fXR.bBw();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.fYr ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aqL) {
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

    public void rf(int i) {
        switch (i) {
            case 0:
                this.fYr = true;
                la(true);
                if (this.aRb != null && this.aRb.user_info != null) {
                    this.aRb.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.aRb.user_info.fans_count >= 0 ? this.aRb.user_info.fans_count : 0L);
                    this.fXU.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.fXW.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.fYr = false;
                la(false);
                if (this.aRb != null && this.aRb.user_info != null) {
                    this.aRb.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.aRb.user_info.fans_count >= 0 ? this.aRb.user_info.fans_count : 0L);
                    this.fXU.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.fXW.setText(formatForPersonCardBeanValue2[1]);
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

    public void lb(boolean z) {
        if (this.aRb != null && this.aRb.user_info != null) {
            if (z) {
                this.aRb.user_info.follow_count++;
            } else {
                this.aRb.user_info.follow_count--;
            }
            if (this.aRb.user_info.follow_count < 0) {
                this.aRb.user_info.follow_count = 0L;
            }
            this.fYc.setText(com.baidu.tieba.ala.person.d.a.dL(this.aRb.user_info.follow_count));
        }
    }

    private View jJ(boolean z) {
        if (z) {
            return LayoutInflater.from(this.fXR.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.fXR.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void lc(boolean z) {
        this.fUY = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.foH == null) {
                        PersonCardViewNew.this.foH = AnimationUtils.loadAnimation(PersonCardViewNew.this.fXR.getActivity(), a.C0128a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.fYm.setAnimation(PersonCardViewNew.this.foH);
                    PersonCardViewNew.this.fYm.setVisibility(0);
                    PersonCardViewNew.this.foH.setDuration(300L);
                    PersonCardViewNew.this.foH.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.fYm != null) {
            this.fYm.clearAnimation();
        }
        if (this.fYx != null && this.fYx.isShowing()) {
            this.fYx.dismiss();
        }
    }

    public Animation bpK() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.foH != null) {
            this.foH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.fXR.getActivity(), a.C0128a.sdk_push_up_out);
        this.fYm.setAnimation(loadAnimation);
        this.fYm.setVisibility(8);
        return loadAnimation;
    }

    public void aHq() {
        if (this.fYx != null && this.fYx.isShowing()) {
            this.fYx.resize();
        }
    }
}
