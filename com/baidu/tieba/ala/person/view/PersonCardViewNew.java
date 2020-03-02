package com.baidu.tieba.ala.person.view;

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
import com.baidu.live.data.x;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.extrajump.ExtraJumpManager;
import com.baidu.live.tbadk.extrajump.interfaces.IExtraJump;
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
    private boolean Yr;
    private PersonUserData axl;
    private Animation eJH;
    private boolean fpR;
    protected final PersonCardActivity fsK;
    private TextView fsL;
    private TextView fsM;
    private TextView fsN;
    private TextView fsO;
    private TextView fsP;
    private TextView fsQ;
    private TextView fsR;
    private TextView fsS;
    private TextView fsT;
    private TextView fsU;
    private TextView fsV;
    private LinearLayout fsW;
    private ImageView fsX;
    private TextView fsY;
    private TextView fsZ;
    private TextView fta;
    private TextView ftb;
    private HeadImageView ftc;
    private LinearLayout ftd;
    private FrameLayout fte;
    private View ftf;
    private View ftg;
    private View fth;
    private boolean fti;
    private boolean ftj;
    private a.InterfaceC0472a ftk;
    private a ftl;
    private boolean ftm;
    private com.baidu.tieba.ala.person.a ftn;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;
    private static final int fsJ = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private static final int eZd = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.fsK = personCardActivity;
        this.ftm = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = iG(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.ftl = new a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    private void initView() {
        this.ftf = this.mRootView.findViewById(a.g.person_card_layout);
        this.fsL = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.fsW = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.fsX = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.fsY = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fsM = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fsN = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.fsO = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.fsP = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.fsR = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.fsQ = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.fsS = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.fsT = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.fsU = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.ftb = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.fsV = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.fta = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.ftd = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.ftg = this.mRootView.findViewById(a.g.user_divide);
        this.fth = this.mRootView.findViewById(a.g.user_divide2);
        this.fte = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fsZ = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fsZ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.fsZ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.ftc = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ftc.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.ftc.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.ftc.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.ftc.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.ftc.setIsRound(true);
        this.ftc.setAutoChangeStyle(false);
        this.ftc.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ftc.setBorderWidth(BdUtilHelper.getDimens(this.fsK.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.ftc.setBorderColor(872415231);
        this.fsW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bsd();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fsL.getLayoutParams();
        layoutParams.addRule(1, this.fsW.getId());
        this.fsL.setLayoutParams(layoutParams);
        this.fsX.setVisibility(8);
        this.fsY.setText(a.i.ala_person_report);
        this.fte.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.fsK.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.fsK.finish();
                }
            }
        });
    }

    private void initListener() {
        this.fsL.setOnClickListener(this);
        this.fsZ.setOnClickListener(this);
        this.fsV.setOnClickListener(this);
        a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0472a
            public void brS() {
                PersonCardViewNew.this.fsK.brP();
            }
        });
    }

    public void a(a.InterfaceC0472a interfaceC0472a) {
        this.ftk = interfaceC0472a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.axl = personUserData;
            e(personUserData);
            d(personUserData);
            b(personUserData, z);
            this.ftl.setData(personUserData.user_info);
            if (this.fpR) {
                this.ftd.setVisibility(8);
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.Yr = personUserData.user_info != null && this.fsK.zA(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.ftj = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.ftj) {
                this.ftd.setVisibility(8);
            } else {
                this.ftd.setVisibility(0);
            }
            if (!z) {
                this.fsS.setText("火星");
            } else {
                this.fsS.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.fta.setVisibility(8);
                this.fth.setVisibility(8);
            } else {
                this.fta.setText(String.format(this.fsK.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.fth.setVisibility(0);
                this.fta.setVisibility(0);
            }
            if (z2) {
                this.fsU.setText(String.format(this.fsK.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.fsU.setVisibility(0);
                this.ftg.setVisibility(0);
                return;
            }
            this.fsU.setVisibility(8);
            this.ftg.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsd() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.fsK.getActivity());
            this.fsK.finish();
            return;
        }
        if (this.ftn != null && this.ftn.isShowing()) {
            this.ftn.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.fsK.getActivity(), true);
        aVar.a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0472a
            public void brS() {
                if (PersonCardViewNew.this.ftk != null) {
                    PersonCardViewNew.this.ftk.brS();
                }
            }
        });
        aVar.show();
        this.ftn = aVar;
    }

    private void e(PersonUserData personUserData) {
        int i = 26;
        x xVar = personUserData.user_info;
        if (xVar != null) {
            f(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(xVar.fans_count < 0 ? 0L : xVar.fans_count);
            this.fsN.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.fsP.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(xVar.follow_count < 0 ? 0L : xVar.follow_count);
            this.fsT.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.fsQ.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.fsO.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.fsR.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.fsR.setText("");
            }
            int i2 = this.ftm ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.ftm) {
                i = 22;
            }
            this.fsN.setTextSize(1, i);
            this.fsT.setTextSize(1, i);
            this.fsO.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.fsL.setVisibility(8);
                this.fsW.setVisibility(8);
            } else if (this.fsK.zA(TbadkCoreApplication.getCurrentAccount())) {
                this.fsW.setVisibility(8);
                this.fsL.setPadding(fsJ, eZd, 0, 0);
                this.fsL.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.fsL.setVisibility(0);
                this.fsW.setVisibility(0);
            } else {
                this.fsW.setVisibility(0);
                this.fsL.setVisibility(8);
            }
        }
    }

    private void f(PersonUserData personUserData) {
        x xVar = personUserData.user_info;
        this.fsM.setText(xVar.getNameShow());
        k.a(this.ftc, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(xVar.description)) {
            this.ftb.setText(a.i.ala_person_desc_default_text);
        } else {
            this.ftb.setText(xVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.fti = false;
            jU(false);
        } else if (!this.ftj && (alaRelationData = personUserData.relation_info) != null) {
            this.fti = alaRelationData.follow_status != 0;
            if (z) {
                this.fsV.setVisibility(8);
            } else {
                jU(this.fti);
            }
        }
    }

    private void jU(boolean z) {
        if (z) {
            this.fsV.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fsV.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.fsV.setTextColor(this.fsK.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.fsV.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.fsV.setTextColor(this.fsK.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.fsV.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fsV.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.fsV.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.fsV.setTextColor(this.fsK.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.fsV.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fsV) {
            bse();
        } else if (view == this.fsZ) {
            bsa();
        } else if (view == this.fsL) {
            TiebaInitialize.log("c12266");
            this.fsK.bga();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, this.axl));
        }
    }

    private void bsa() {
        if (this.axl != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fsK.getActivity());
            } else if (this.axl.user_info == null || JavaTypesHelper.toLong(this.axl.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fsK.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.axl.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.fsK.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.awa = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.axl.user_info));
                this.fsK.finish();
            }
        }
    }

    private void bse() {
        String str;
        if (this.axl != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fsK.getActivity());
                this.fsK.finish();
            } else if (this.axl.user_info == null || JavaTypesHelper.toLong(this.axl.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fsK.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.fti) {
                    qK(1);
                    this.fsK.brO();
                } else {
                    qK(0);
                    this.fsK.brN();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.fti ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.Yr) {
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

    public void qK(int i) {
        switch (i) {
            case 0:
                this.fti = true;
                jU(true);
                if (this.axl != null && this.axl.user_info != null) {
                    this.axl.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.axl.user_info.fans_count >= 0 ? this.axl.user_info.fans_count : 0L);
                    this.fsN.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.fsP.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.fti = false;
                jU(false);
                if (this.axl != null && this.axl.user_info != null) {
                    this.axl.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.axl.user_info.fans_count >= 0 ? this.axl.user_info.fans_count : 0L);
                    this.fsN.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.fsP.setText(formatForPersonCardBeanValue2[1]);
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

    public void jV(boolean z) {
        if (this.axl != null && this.axl.user_info != null) {
            if (z) {
                this.axl.user_info.follow_count++;
            } else {
                this.axl.user_info.follow_count--;
            }
            if (this.axl.user_info.follow_count < 0) {
                this.axl.user_info.follow_count = 0L;
            }
            this.fsV.setText(com.baidu.tieba.ala.person.d.a.dd(this.axl.user_info.follow_count));
        }
    }

    private View iG(boolean z) {
        if (z) {
            return LayoutInflater.from(this.fsK.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.fsK.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void jW(boolean z) {
        this.fpR = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.eJH == null) {
                        PersonCardViewNew.this.eJH = AnimationUtils.loadAnimation(PersonCardViewNew.this.fsK.getActivity(), a.C0102a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.ftf.setAnimation(PersonCardViewNew.this.eJH);
                    PersonCardViewNew.this.ftf.setVisibility(0);
                    PersonCardViewNew.this.eJH.setDuration(300L);
                    PersonCardViewNew.this.eJH.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.ftf != null) {
            this.ftf.clearAnimation();
        }
        if (this.ftn != null && this.ftn.isShowing()) {
            this.ftn.dismiss();
        }
    }

    public Animation bgn() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eJH != null) {
            this.eJH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.fsK.getActivity(), a.C0102a.sdk_push_up_out);
        this.ftf.setAnimation(loadAnimation);
        this.ftf.setVisibility(8);
        return loadAnimation;
    }

    public void azc() {
        if (this.ftn != null && this.ftn.isShowing()) {
            this.ftn.resize();
        }
    }
}
