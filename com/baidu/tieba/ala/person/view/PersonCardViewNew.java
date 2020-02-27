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
    private PersonUserData axk;
    private Animation eJG;
    private boolean fpQ;
    protected final PersonCardActivity fsJ;
    private TextView fsK;
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
    private LinearLayout fsV;
    private ImageView fsW;
    private TextView fsX;
    private TextView fsY;
    private TextView fsZ;
    private TextView fta;
    private HeadImageView ftb;
    private LinearLayout ftc;
    private FrameLayout ftd;
    private View fte;
    private View ftf;
    private View ftg;
    private boolean fth;
    private boolean fti;
    private a.InterfaceC0472a ftj;
    private a ftk;
    private boolean ftl;
    private com.baidu.tieba.ala.person.a ftm;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;
    private static final int fsI = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private static final int eZc = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.fsJ = personCardActivity;
        this.ftl = z;
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
        this.ftk = new a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    private void initView() {
        this.fte = this.mRootView.findViewById(a.g.person_card_layout);
        this.fsK = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.fsV = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.fsW = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.fsX = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fsL = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fsM = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.fsN = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.fsO = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.fsQ = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.fsP = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.fsR = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.fsS = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.fsT = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.fta = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.fsU = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.fsZ = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.ftc = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.ftf = this.mRootView.findViewById(a.g.user_divide);
        this.ftg = this.mRootView.findViewById(a.g.user_divide2);
        this.ftd = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fsY = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fsY.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.fsY.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.ftb = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ftb.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.ftb.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.ftb.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.ftb.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.ftb.setIsRound(true);
        this.ftb.setAutoChangeStyle(false);
        this.ftb.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ftb.setBorderWidth(BdUtilHelper.getDimens(this.fsJ.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.ftb.setBorderColor(872415231);
        this.fsV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bsb();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fsK.getLayoutParams();
        layoutParams.addRule(1, this.fsV.getId());
        this.fsK.setLayoutParams(layoutParams);
        this.fsW.setVisibility(8);
        this.fsX.setText(a.i.ala_person_report);
        this.ftd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.fsJ.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.fsJ.finish();
                }
            }
        });
    }

    private void initListener() {
        this.fsK.setOnClickListener(this);
        this.fsY.setOnClickListener(this);
        this.fsU.setOnClickListener(this);
        a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0472a
            public void brQ() {
                PersonCardViewNew.this.fsJ.brN();
            }
        });
    }

    public void a(a.InterfaceC0472a interfaceC0472a) {
        this.ftj = interfaceC0472a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.axk = personUserData;
            e(personUserData);
            d(personUserData);
            b(personUserData, z);
            this.ftk.setData(personUserData.user_info);
            if (this.fpQ) {
                this.ftc.setVisibility(8);
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.Yr = personUserData.user_info != null && this.fsJ.zA(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.fti = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.fti) {
                this.ftc.setVisibility(8);
            } else {
                this.ftc.setVisibility(0);
            }
            if (!z) {
                this.fsR.setText("火星");
            } else {
                this.fsR.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.fsZ.setVisibility(8);
                this.ftg.setVisibility(8);
            } else {
                this.fsZ.setText(String.format(this.fsJ.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.ftg.setVisibility(0);
                this.fsZ.setVisibility(0);
            }
            if (z2) {
                this.fsT.setText(String.format(this.fsJ.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.fsT.setVisibility(0);
                this.ftf.setVisibility(0);
                return;
            }
            this.fsT.setVisibility(8);
            this.ftf.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsb() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.fsJ.getActivity());
            this.fsJ.finish();
            return;
        }
        if (this.ftm != null && this.ftm.isShowing()) {
            this.ftm.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.fsJ.getActivity(), true);
        aVar.a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0472a
            public void brQ() {
                if (PersonCardViewNew.this.ftj != null) {
                    PersonCardViewNew.this.ftj.brQ();
                }
            }
        });
        aVar.show();
        this.ftm = aVar;
    }

    private void e(PersonUserData personUserData) {
        int i = 26;
        x xVar = personUserData.user_info;
        if (xVar != null) {
            f(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(xVar.fans_count < 0 ? 0L : xVar.fans_count);
            this.fsM.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.fsO.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(xVar.follow_count < 0 ? 0L : xVar.follow_count);
            this.fsS.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.fsP.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.fsN.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.fsQ.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.fsQ.setText("");
            }
            int i2 = this.ftl ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.ftl) {
                i = 22;
            }
            this.fsM.setTextSize(1, i);
            this.fsS.setTextSize(1, i);
            this.fsN.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.fsK.setVisibility(8);
                this.fsV.setVisibility(8);
            } else if (this.fsJ.zA(TbadkCoreApplication.getCurrentAccount())) {
                this.fsV.setVisibility(8);
                this.fsK.setPadding(fsI, eZc, 0, 0);
                this.fsK.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.fsK.setVisibility(0);
                this.fsV.setVisibility(0);
            } else {
                this.fsV.setVisibility(0);
                this.fsK.setVisibility(8);
            }
        }
    }

    private void f(PersonUserData personUserData) {
        x xVar = personUserData.user_info;
        this.fsL.setText(xVar.getNameShow());
        k.a(this.ftb, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(xVar.description)) {
            this.fta.setText(a.i.ala_person_desc_default_text);
        } else {
            this.fta.setText(xVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.fth = false;
            jU(false);
        } else if (!this.fti && (alaRelationData = personUserData.relation_info) != null) {
            this.fth = alaRelationData.follow_status != 0;
            if (z) {
                this.fsU.setVisibility(8);
            } else {
                jU(this.fth);
            }
        }
    }

    private void jU(boolean z) {
        if (z) {
            this.fsU.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fsU.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.fsU.setTextColor(this.fsJ.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.fsU.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.fsU.setTextColor(this.fsJ.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.fsU.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fsU.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.fsU.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.fsU.setTextColor(this.fsJ.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.fsU.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fsU) {
            bsc();
        } else if (view == this.fsY) {
            brY();
        } else if (view == this.fsK) {
            TiebaInitialize.log("c12266");
            this.fsJ.bfY();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, this.axk));
        }
    }

    private void brY() {
        if (this.axk != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fsJ.getActivity());
            } else if (this.axk.user_info == null || JavaTypesHelper.toLong(this.axk.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fsJ.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.axk.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.fsJ.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.awa = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.axk.user_info));
                this.fsJ.finish();
            }
        }
    }

    private void bsc() {
        String str;
        if (this.axk != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fsJ.getActivity());
                this.fsJ.finish();
            } else if (this.axk.user_info == null || JavaTypesHelper.toLong(this.axk.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fsJ.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.fth) {
                    qK(1);
                    this.fsJ.brM();
                } else {
                    qK(0);
                    this.fsJ.brL();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.fth ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
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
                this.fth = true;
                jU(true);
                if (this.axk != null && this.axk.user_info != null) {
                    this.axk.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.axk.user_info.fans_count >= 0 ? this.axk.user_info.fans_count : 0L);
                    this.fsM.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.fsO.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.fth = false;
                jU(false);
                if (this.axk != null && this.axk.user_info != null) {
                    this.axk.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.axk.user_info.fans_count >= 0 ? this.axk.user_info.fans_count : 0L);
                    this.fsM.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.fsO.setText(formatForPersonCardBeanValue2[1]);
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
        if (this.axk != null && this.axk.user_info != null) {
            if (z) {
                this.axk.user_info.follow_count++;
            } else {
                this.axk.user_info.follow_count--;
            }
            if (this.axk.user_info.follow_count < 0) {
                this.axk.user_info.follow_count = 0L;
            }
            this.fsU.setText(com.baidu.tieba.ala.person.d.a.dd(this.axk.user_info.follow_count));
        }
    }

    private View iG(boolean z) {
        if (z) {
            return LayoutInflater.from(this.fsJ.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.fsJ.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void jW(boolean z) {
        this.fpQ = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.eJG == null) {
                        PersonCardViewNew.this.eJG = AnimationUtils.loadAnimation(PersonCardViewNew.this.fsJ.getActivity(), a.C0102a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.fte.setAnimation(PersonCardViewNew.this.eJG);
                    PersonCardViewNew.this.fte.setVisibility(0);
                    PersonCardViewNew.this.eJG.setDuration(300L);
                    PersonCardViewNew.this.eJG.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.fte != null) {
            this.fte.clearAnimation();
        }
        if (this.ftm != null && this.ftm.isShowing()) {
            this.ftm.dismiss();
        }
    }

    public Animation bgl() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eJG != null) {
            this.eJG.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.fsJ.getActivity(), a.C0102a.sdk_push_up_out);
        this.fte.setAnimation(loadAnimation);
        this.fte.setVisibility(8);
        return loadAnimation;
    }

    public void aza() {
        if (this.ftm != null && this.ftm.isShowing()) {
            this.ftm.resize();
        }
    }
}
