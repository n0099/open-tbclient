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
    private PersonUserData aRg;
    private boolean aqR;
    private boolean fVd;
    protected final PersonCardActivity fXW;
    private TextView fXX;
    private TextView fXY;
    private TextView fXZ;
    private com.baidu.tieba.ala.person.view.a fYA;
    private boolean fYB;
    private com.baidu.tieba.ala.person.a fYC;
    private a fYD;
    private TextView fYa;
    private TextView fYb;
    private TextView fYc;
    private TextView fYd;
    private TextView fYe;
    private TextView fYf;
    private TextView fYg;
    private TextView fYh;
    private LinearLayout fYi;
    private ImageView fYj;
    private TextView fYk;
    private TextView fYl;
    private TextView fYm;
    private TextView fYn;
    private HeadImageView fYo;
    private LinearLayout fYp;
    private FrameLayout fYq;
    private View fYr;
    private View fYs;
    private View fYt;
    private View fYu;
    private HeadImageView fYv;
    private boolean fYw;
    private String fYx;
    private boolean fYy;
    private a.InterfaceC0529a fYz;
    private Animation foM;
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;
    private final int fXV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private final int fEh = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private Handler mHandler = new Handler();

    /* loaded from: classes3.dex */
    public interface a {
        void bBy();
    }

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.fXW = personCardActivity;
        this.fYB = z;
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
        this.fYA = new com.baidu.tieba.ala.person.view.a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    public void a(a aVar) {
        this.fYD = aVar;
    }

    private void initView() {
        this.fYr = this.mRootView.findViewById(a.g.person_card_layout);
        this.fXX = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.fYi = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.fYj = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.fYk = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fXY = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fXZ = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.fYa = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.fYb = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.fYd = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.fYc = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.fYe = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.fYf = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.fYg = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.fYn = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.fYh = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.fYm = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.fYp = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.fYs = this.mRootView.findViewById(a.g.user_divide);
        this.fYt = this.mRootView.findViewById(a.g.user_divide2);
        this.fYq = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fYl = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fYl.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.fYl.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.fYo = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fYo.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.fYo.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.fYo.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.fYo.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.fYo.setIsRound(true);
        this.fYo.setAutoChangeStyle(false);
        this.fYo.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fYo.setBorderWidth(BdUtilHelper.getDimens(this.fXW.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.fYo.setBorderColor(872415231);
        this.fYi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bBN();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fXX.getLayoutParams();
        layoutParams.addRule(1, this.fYi.getId());
        this.fXX.setLayoutParams(layoutParams);
        this.fYj.setVisibility(8);
        this.fYk.setText(a.i.ala_person_report);
        this.fYq.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                ISchemeAbility buildSchemeAbility;
                if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                    if (!TextUtils.isEmpty(PersonCardViewNew.this.fYx) && (buildSchemeAbility = SchemeAbilityManager.getInstance().buildSchemeAbility()) != null) {
                        buildSchemeAbility.openScheme(PersonCardViewNew.this.fYx);
                        return;
                    }
                    return;
                }
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.fXW.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.fXW.finish();
                }
            }
        });
        this.fYu = this.mRootView.findViewById(a.g.layout_charm_rank);
        this.fYv = (HeadImageView) this.mRootView.findViewById(a.g.avatar_charm);
        this.fYv.setIsRound(true);
        this.fYv.setAutoChangeStyle(false);
        this.fYv.setDrawBorder(false);
        this.fYv.setDefaultBgResource(a.f.sdk_default_avatar);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(1);
        gradientDrawable.setStroke(this.fXW.getResources().getDimensionPixelOffset(a.e.sdk_ds4), -1);
        this.mRootView.findViewById(a.g.portrait_ring).setBackgroundDrawable(gradientDrawable);
    }

    private void initListener() {
        this.fXX.setOnClickListener(this);
        this.fYl.setOnClickListener(this);
        this.fYh.setOnClickListener(this);
        a(new a.InterfaceC0529a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0529a
            public void bBB() {
                PersonCardViewNew.this.fXW.bBw();
            }
        });
    }

    public void a(a.InterfaceC0529a interfaceC0529a) {
        this.fYz = interfaceC0529a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.aRg = personUserData;
            e(personUserData);
            d(personUserData);
            b(personUserData, z);
            g(personUserData);
            this.fYA.setData(personUserData.user_info);
            if (this.fVd) {
                this.fYp.setVisibility(8);
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.aqR = personUserData.user_info != null && this.fXW.Bk(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            this.fYx = personUserData.user_info != null ? personUserData.user_info.atX : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.fYy = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.fYy) {
                this.fYp.setVisibility(8);
            } else {
                this.fYp.setVisibility(0);
            }
            if (!z) {
                this.fYe.setText("火星");
            } else {
                this.fYe.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.fYm.setVisibility(8);
                this.fYt.setVisibility(8);
            } else {
                this.fYm.setText(String.format(this.fXW.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.fYt.setVisibility(0);
                this.fYm.setVisibility(0);
            }
            if (z2) {
                this.fYg.setText(String.format(this.fXW.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.fYg.setVisibility(0);
                this.fYs.setVisibility(0);
                return;
            }
            this.fYg.setVisibility(8);
            this.fYs.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bBN() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.fXW.getActivity());
            this.fXW.finish();
            return;
        }
        if (this.fYC != null && this.fYC.isShowing()) {
            this.fYC.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.fXW.getActivity(), true);
        aVar.a(new a.InterfaceC0529a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0529a
            public void bBB() {
                if (PersonCardViewNew.this.fYz != null) {
                    PersonCardViewNew.this.fYz.bBB();
                }
            }
        });
        aVar.show();
        this.fYC = aVar;
    }

    private void e(PersonUserData personUserData) {
        int i = 26;
        z zVar = personUserData.user_info;
        if (zVar != null) {
            f(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(zVar.fans_count < 0 ? 0L : zVar.fans_count);
            this.fXZ.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.fYb.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(zVar.follow_count < 0 ? 0L : zVar.follow_count);
            this.fYf.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.fYc.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.fYa.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.fYd.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.fYd.setText("");
            }
            int i2 = this.fYB ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.fYB) {
                i = 22;
            }
            this.fXZ.setTextSize(1, i);
            this.fYf.setTextSize(1, i);
            this.fYa.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.fXX.setVisibility(8);
                this.fYi.setVisibility(8);
            } else if (this.fXW.Bk(TbadkCoreApplication.getCurrentAccount())) {
                this.fYi.setVisibility(8);
                this.fXX.setPadding(this.fXV, this.fEh, 0, 0);
                this.fXX.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.fXX.setVisibility(0);
                this.fYi.setVisibility(0);
            } else {
                this.fYi.setVisibility(0);
                this.fXX.setVisibility(8);
            }
        }
    }

    private void f(PersonUserData personUserData) {
        z zVar = personUserData.user_info;
        this.fXY.setText(zVar.getNameShow());
        k.a(this.fYo, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(zVar.description)) {
            this.fYn.setText(a.i.ala_person_desc_default_text);
        } else {
            this.fYn.setText(zVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.fYw = false;
            la(false);
        } else if (!this.fYy && (alaRelationData = personUserData.relation_info) != null) {
            this.fYw = alaRelationData.follow_status != 0;
            if (z) {
                this.fYh.setVisibility(8);
            } else {
                la(this.fYw);
            }
        }
    }

    private void g(PersonUserData personUserData) {
        if (personUserData != null && personUserData.topContributionUserInfo != null && !TextUtils.isEmpty(personUserData.topContributionUserInfo.portrait)) {
            this.fYu.setVisibility(0);
            this.fYu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    if (PersonCardViewNew.this.fYD != null) {
                        PersonCardViewNew.this.fYD.bBy();
                    }
                }
            });
            this.fYv.startLoad(personUserData.topContributionUserInfo.portrait, 12, false, false);
            return;
        }
        this.fYu.setVisibility(4);
    }

    private void la(boolean z) {
        if (z) {
            this.fYh.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fYh.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.fYh.setTextColor(this.fXW.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.fYh.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.fYh.setTextColor(this.fXW.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.fYh.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fYh.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.fYh.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.fYh.setTextColor(this.fXW.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.fYh.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fYh) {
            bBO();
        } else if (view == this.fYl) {
            bBJ();
        } else if (view == this.fXX) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.fXW, this.aRg}));
        }
    }

    private void bBJ() {
        if (this.aRg != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fXW.getActivity());
            } else if (this.aRg.user_info == null || JavaTypesHelper.toLong(this.aRg.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fXW.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.aRg.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.fXW.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.aPU = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.aRg.user_info));
                this.fXW.finish();
            }
        }
    }

    private void bBO() {
        String str;
        if (this.aRg != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fXW.getActivity());
                this.fXW.finish();
            } else if (this.aRg.user_info == null || JavaTypesHelper.toLong(this.aRg.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fXW.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.fYw) {
                    rf(1);
                    this.fXW.bBv();
                } else {
                    rf(0);
                    this.fXW.bBu();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.fYw ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.aqR) {
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
                this.fYw = true;
                la(true);
                if (this.aRg != null && this.aRg.user_info != null) {
                    this.aRg.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.aRg.user_info.fans_count >= 0 ? this.aRg.user_info.fans_count : 0L);
                    this.fXZ.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.fYb.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.fYw = false;
                la(false);
                if (this.aRg != null && this.aRg.user_info != null) {
                    this.aRg.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.aRg.user_info.fans_count >= 0 ? this.aRg.user_info.fans_count : 0L);
                    this.fXZ.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.fYb.setText(formatForPersonCardBeanValue2[1]);
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
        if (this.aRg != null && this.aRg.user_info != null) {
            if (z) {
                this.aRg.user_info.follow_count++;
            } else {
                this.aRg.user_info.follow_count--;
            }
            if (this.aRg.user_info.follow_count < 0) {
                this.aRg.user_info.follow_count = 0L;
            }
            this.fYh.setText(com.baidu.tieba.ala.person.d.a.dL(this.aRg.user_info.follow_count));
        }
    }

    private View jJ(boolean z) {
        if (z) {
            return LayoutInflater.from(this.fXW.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.fXW.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void lc(boolean z) {
        this.fVd = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.7
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.foM == null) {
                        PersonCardViewNew.this.foM = AnimationUtils.loadAnimation(PersonCardViewNew.this.fXW.getActivity(), a.C0149a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.fYr.setAnimation(PersonCardViewNew.this.foM);
                    PersonCardViewNew.this.fYr.setVisibility(0);
                    PersonCardViewNew.this.foM.setDuration(300L);
                    PersonCardViewNew.this.foM.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.fYr != null) {
            this.fYr.clearAnimation();
        }
        if (this.fYC != null && this.fYC.isShowing()) {
            this.fYC.dismiss();
        }
    }

    public Animation bpI() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.foM != null) {
            this.foM.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.fXW.getActivity(), a.C0149a.sdk_push_up_out);
        this.fYr.setAnimation(loadAnimation);
        this.fYr.setVisibility(8);
        return loadAnimation;
    }

    public void aHo() {
        if (this.fYC != null && this.fYC.isShowing()) {
            this.fYC.resize();
        }
    }
}
