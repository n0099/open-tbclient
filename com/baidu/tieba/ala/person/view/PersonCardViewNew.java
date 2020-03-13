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
    private PersonUserData axm;
    private Animation eJU;
    private boolean fqe;
    protected final PersonCardActivity fsX;
    private TextView fsY;
    private TextView fsZ;
    private boolean ftA;
    private com.baidu.tieba.ala.person.a ftB;
    private TextView fta;
    private TextView ftb;
    private TextView ftc;
    private TextView ftd;
    private TextView fte;
    private TextView ftf;
    private TextView ftg;
    private TextView fth;
    private TextView fti;
    private LinearLayout ftj;
    private ImageView ftk;
    private TextView ftl;
    private TextView ftm;
    private TextView ftn;
    private TextView fto;
    private HeadImageView ftp;
    private LinearLayout ftq;
    private FrameLayout ftr;
    private View fts;
    private View ftt;
    private View ftu;
    private boolean ftw;
    private boolean ftx;
    private a.InterfaceC0472a fty;
    private a ftz;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;
    private static final int fsW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private static final int eZq = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.fsX = personCardActivity;
        this.ftA = z;
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
        this.ftz = new a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    private void initView() {
        this.fts = this.mRootView.findViewById(a.g.person_card_layout);
        this.fsY = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.ftj = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.ftk = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.ftl = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fsZ = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fta = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.ftb = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.ftc = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.fte = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.ftd = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.ftf = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.ftg = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.fth = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.fto = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.fti = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.ftn = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.ftq = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.ftt = this.mRootView.findViewById(a.g.user_divide);
        this.ftu = this.mRootView.findViewById(a.g.user_divide2);
        this.ftr = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.ftm = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ftm.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.ftm.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.ftp = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ftp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.ftp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.ftp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.ftp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.ftp.setIsRound(true);
        this.ftp.setAutoChangeStyle(false);
        this.ftp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ftp.setBorderWidth(BdUtilHelper.getDimens(this.fsX.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.ftp.setBorderColor(872415231);
        this.ftj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bse();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fsY.getLayoutParams();
        layoutParams.addRule(1, this.ftj.getId());
        this.fsY.setLayoutParams(layoutParams);
        this.ftk.setVisibility(8);
        this.ftl.setText(a.i.ala_person_report);
        this.ftr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.fsX.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.fsX.finish();
                }
            }
        });
    }

    private void initListener() {
        this.fsY.setOnClickListener(this);
        this.ftm.setOnClickListener(this);
        this.fti.setOnClickListener(this);
        a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0472a
            public void brT() {
                PersonCardViewNew.this.fsX.brQ();
            }
        });
    }

    public void a(a.InterfaceC0472a interfaceC0472a) {
        this.fty = interfaceC0472a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.axm = personUserData;
            e(personUserData);
            d(personUserData);
            b(personUserData, z);
            this.ftz.setData(personUserData.user_info);
            if (this.fqe) {
                this.ftq.setVisibility(8);
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.Yr = personUserData.user_info != null && this.fsX.zB(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.ftx = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.ftx) {
                this.ftq.setVisibility(8);
            } else {
                this.ftq.setVisibility(0);
            }
            if (!z) {
                this.ftf.setText("火星");
            } else {
                this.ftf.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.ftn.setVisibility(8);
                this.ftu.setVisibility(8);
            } else {
                this.ftn.setText(String.format(this.fsX.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.ftu.setVisibility(0);
                this.ftn.setVisibility(0);
            }
            if (z2) {
                this.fth.setText(String.format(this.fsX.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.fth.setVisibility(0);
                this.ftt.setVisibility(0);
                return;
            }
            this.fth.setVisibility(8);
            this.ftt.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bse() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.fsX.getActivity());
            this.fsX.finish();
            return;
        }
        if (this.ftB != null && this.ftB.isShowing()) {
            this.ftB.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.fsX.getActivity(), true);
        aVar.a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0472a
            public void brT() {
                if (PersonCardViewNew.this.fty != null) {
                    PersonCardViewNew.this.fty.brT();
                }
            }
        });
        aVar.show();
        this.ftB = aVar;
    }

    private void e(PersonUserData personUserData) {
        int i = 26;
        x xVar = personUserData.user_info;
        if (xVar != null) {
            f(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(xVar.fans_count < 0 ? 0L : xVar.fans_count);
            this.fta.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.ftc.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(xVar.follow_count < 0 ? 0L : xVar.follow_count);
            this.ftg.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.ftd.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.ftb.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.fte.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.fte.setText("");
            }
            int i2 = this.ftA ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.ftA) {
                i = 22;
            }
            this.fta.setTextSize(1, i);
            this.ftg.setTextSize(1, i);
            this.ftb.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.fsY.setVisibility(8);
                this.ftj.setVisibility(8);
            } else if (this.fsX.zB(TbadkCoreApplication.getCurrentAccount())) {
                this.ftj.setVisibility(8);
                this.fsY.setPadding(fsW, eZq, 0, 0);
                this.fsY.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.fsY.setVisibility(0);
                this.ftj.setVisibility(0);
            } else {
                this.ftj.setVisibility(0);
                this.fsY.setVisibility(8);
            }
        }
    }

    private void f(PersonUserData personUserData) {
        x xVar = personUserData.user_info;
        this.fsZ.setText(xVar.getNameShow());
        k.a(this.ftp, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(xVar.description)) {
            this.fto.setText(a.i.ala_person_desc_default_text);
        } else {
            this.fto.setText(xVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.ftw = false;
            jU(false);
        } else if (!this.ftx && (alaRelationData = personUserData.relation_info) != null) {
            this.ftw = alaRelationData.follow_status != 0;
            if (z) {
                this.fti.setVisibility(8);
            } else {
                jU(this.ftw);
            }
        }
    }

    private void jU(boolean z) {
        if (z) {
            this.fti.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fti.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.fti.setTextColor(this.fsX.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.fti.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.fti.setTextColor(this.fsX.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.fti.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fti.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.fti.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.fti.setTextColor(this.fsX.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.fti.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fti) {
            bsf();
        } else if (view == this.ftm) {
            bsb();
        } else if (view == this.fsY) {
            TiebaInitialize.log("c12266");
            this.fsX.bgb();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, this.axm));
        }
    }

    private void bsb() {
        if (this.axm != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fsX.getActivity());
            } else if (this.axm.user_info == null || JavaTypesHelper.toLong(this.axm.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fsX.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.axm.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.fsX.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.awb = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.axm.user_info));
                this.fsX.finish();
            }
        }
    }

    private void bsf() {
        String str;
        if (this.axm != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fsX.getActivity());
                this.fsX.finish();
            } else if (this.axm.user_info == null || JavaTypesHelper.toLong(this.axm.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fsX.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.ftw) {
                    qK(1);
                    this.fsX.brP();
                } else {
                    qK(0);
                    this.fsX.brO();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.ftw ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
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
                this.ftw = true;
                jU(true);
                if (this.axm != null && this.axm.user_info != null) {
                    this.axm.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.axm.user_info.fans_count >= 0 ? this.axm.user_info.fans_count : 0L);
                    this.fta.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.ftc.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.ftw = false;
                jU(false);
                if (this.axm != null && this.axm.user_info != null) {
                    this.axm.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.axm.user_info.fans_count >= 0 ? this.axm.user_info.fans_count : 0L);
                    this.fta.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.ftc.setText(formatForPersonCardBeanValue2[1]);
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
        if (this.axm != null && this.axm.user_info != null) {
            if (z) {
                this.axm.user_info.follow_count++;
            } else {
                this.axm.user_info.follow_count--;
            }
            if (this.axm.user_info.follow_count < 0) {
                this.axm.user_info.follow_count = 0L;
            }
            this.fti.setText(com.baidu.tieba.ala.person.d.a.dd(this.axm.user_info.follow_count));
        }
    }

    private View iG(boolean z) {
        if (z) {
            return LayoutInflater.from(this.fsX.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.fsX.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void jW(boolean z) {
        this.fqe = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.eJU == null) {
                        PersonCardViewNew.this.eJU = AnimationUtils.loadAnimation(PersonCardViewNew.this.fsX.getActivity(), a.C0102a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.fts.setAnimation(PersonCardViewNew.this.eJU);
                    PersonCardViewNew.this.fts.setVisibility(0);
                    PersonCardViewNew.this.eJU.setDuration(300L);
                    PersonCardViewNew.this.eJU.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.fts != null) {
            this.fts.clearAnimation();
        }
        if (this.ftB != null && this.ftB.isShowing()) {
            this.ftB.dismiss();
        }
    }

    public Animation bgo() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eJU != null) {
            this.eJU.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.fsX.getActivity(), a.C0102a.sdk_push_up_out);
        this.fts.setAnimation(loadAnimation);
        this.fts.setVisibility(8);
        return loadAnimation;
    }

    public void azc() {
        if (this.ftB != null && this.ftB.isShowing()) {
            this.ftB.resize();
        }
    }
}
