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
import com.baidu.live.data.u;
import com.baidu.live.q.a;
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
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
/* loaded from: classes2.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private static final int fmV = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private static final int fmW = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private boolean Wm;
    private Animation eEC;
    private boolean fkc;
    protected final PersonCardActivity fmX;
    private TextView fmY;
    private TextView fmZ;
    private boolean fnA;
    private com.baidu.tieba.ala.person.a fnB;
    private TextView fna;
    private TextView fnb;
    private TextView fnc;
    private TextView fnd;
    private TextView fne;
    private TextView fnf;
    private TextView fng;
    private TextView fnh;
    private TextView fni;
    private LinearLayout fnj;
    private ImageView fnk;
    private TextView fnl;
    private TextView fnm;
    private TextView fnn;
    private TextView fno;
    private HeadImageView fnp;
    private LinearLayout fnq;
    private FrameLayout fnr;
    private View fns;
    private View fnt;
    private View fnu;
    private PersonUserData fnv;
    private boolean fnw;
    private boolean fnx;
    private a.InterfaceC0460a fny;
    private a fnz;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.fmX = personCardActivity;
        this.fnA = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = ip(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.fnz = new a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    private void initView() {
        this.fns = this.mRootView.findViewById(a.g.person_card_layout);
        this.fmY = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.fnj = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.fnk = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.fnl = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fmZ = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fna = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.fnb = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.fnc = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.fne = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.fnd = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.fnf = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.fng = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.fnh = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.fno = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.fni = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.fnn = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.fnq = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.fnt = this.mRootView.findViewById(a.g.user_divide);
        this.fnu = this.mRootView.findViewById(a.g.user_divide2);
        this.fnr = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fnm = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fnm.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.fnm.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.fnp = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fnp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.fnp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.fnp.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.fnp.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.fnp.setIsRound(true);
        this.fnp.setAutoChangeStyle(false);
        this.fnp.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fnp.setBorderWidth(BdUtilHelper.getDimens(this.fmX.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.fnp.setBorderColor(872415231);
        this.fnj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bpw();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fmY.getLayoutParams();
        layoutParams.addRule(1, this.fnj.getId());
        this.fmY.setLayoutParams(layoutParams);
        this.fnk.setVisibility(8);
        this.fnl.setText(a.i.ala_person_report);
        this.fnr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.fmX.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.fmX.finish();
                }
            }
        });
    }

    private void initListener() {
        this.fmY.setOnClickListener(this);
        this.fnm.setOnClickListener(this);
        this.fni.setOnClickListener(this);
        a(new a.InterfaceC0460a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0460a
            public void bpl() {
                PersonCardViewNew.this.fmX.bpi();
            }
        });
    }

    public void a(a.InterfaceC0460a interfaceC0460a) {
        this.fny = interfaceC0460a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.fnv = personUserData;
            d(personUserData);
            c(personUserData);
            b(personUserData, z);
            this.fnz.setData(personUserData.user_info);
            if (this.fkc) {
                this.fnq.setVisibility(8);
            }
        }
    }

    private void c(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.Wm = personUserData.user_info != null && this.fmX.yZ(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.fnx = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.fnx) {
                this.fnq.setVisibility(8);
            } else {
                this.fnq.setVisibility(0);
            }
            if (!z) {
                this.fnf.setText("火星");
            } else {
                this.fnf.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.fnn.setVisibility(8);
                this.fnu.setVisibility(8);
            } else {
                this.fnn.setText(String.format(this.fmX.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.fnu.setVisibility(0);
                this.fnn.setVisibility(0);
            }
            if (z2) {
                this.fnh.setText(String.format(this.fmX.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.fnh.setVisibility(0);
                this.fnt.setVisibility(0);
                return;
            }
            this.fnh.setVisibility(8);
            this.fnt.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bpw() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.fmX.getActivity());
            this.fmX.finish();
            return;
        }
        if (this.fnB != null && this.fnB.isShowing()) {
            this.fnB.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.fmX.getActivity(), true);
        aVar.a(new a.InterfaceC0460a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0460a
            public void bpl() {
                if (PersonCardViewNew.this.fny != null) {
                    PersonCardViewNew.this.fny.bpl();
                }
            }
        });
        aVar.show();
        this.fnB = aVar;
    }

    private void d(PersonUserData personUserData) {
        int i = 26;
        u uVar = personUserData.user_info;
        if (uVar != null) {
            e(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(uVar.fans_count < 0 ? 0L : uVar.fans_count);
            this.fna.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.fnc.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(uVar.follow_count < 0 ? 0L : uVar.follow_count);
            this.fng.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.fnd.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.fnb.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.fne.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.fne.setText("");
            }
            int i2 = this.fnA ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.fnA) {
                i = 22;
            }
            this.fna.setTextSize(1, i);
            this.fng.setTextSize(1, i);
            this.fnb.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.fmY.setVisibility(8);
                this.fnj.setVisibility(8);
            } else if (this.fmX.yZ(TbadkCoreApplication.getCurrentAccount())) {
                this.fnj.setVisibility(8);
                this.fmY.setPadding(fmV, fmW, 0, 0);
                this.fmY.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.fmY.setVisibility(0);
                this.fnj.setVisibility(0);
            } else {
                this.fnj.setVisibility(0);
                this.fmY.setVisibility(8);
            }
        }
    }

    private void e(PersonUserData personUserData) {
        u uVar = personUserData.user_info;
        this.fmZ.setText(uVar.getNameShow());
        k.a(this.fnp, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(uVar.description)) {
            this.fno.setText(a.i.ala_person_desc_default_text);
        } else {
            this.fno.setText(uVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.fnw = false;
            jH(false);
        } else if (!this.fnx && (alaRelationData = personUserData.relation_info) != null) {
            this.fnw = alaRelationData.follow_status != 0;
            if (z) {
                this.fni.setVisibility(8);
            } else {
                jH(this.fnw);
            }
        }
    }

    private void jH(boolean z) {
        if (z) {
            this.fni.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fni.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.fni.setTextColor(this.fmX.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.fni.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.fni.setTextColor(this.fmX.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.fni.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fni.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.fni.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.fni.setTextColor(this.fmX.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.fni.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fni) {
            bpx();
        } else if (view == this.fnm) {
            bpt();
        } else if (view == this.fmY) {
            TiebaInitialize.log("c12266");
            this.fmX.bdt();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, this.fnv));
        }
    }

    private void bpt() {
        if (this.fnv != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fmX.getActivity());
            } else if (this.fnv.user_info == null || JavaTypesHelper.toLong(this.fnv.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fmX.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.fnv.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.fmX.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
                cVar.arn = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.fnv.user_info));
                this.fmX.finish();
            }
        }
    }

    private void bpx() {
        String str;
        if (this.fnv != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fmX.getActivity());
                this.fmX.finish();
            } else if (this.fnv.user_info == null || JavaTypesHelper.toLong(this.fnv.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fmX.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.fnw) {
                    qy(1);
                    this.fmX.bph();
                } else {
                    qy(0);
                    this.fmX.bpg();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.fnw ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.Wm) {
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

    public void qy(int i) {
        switch (i) {
            case 0:
                this.fnw = true;
                jH(true);
                if (this.fnv != null && this.fnv.user_info != null) {
                    this.fnv.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.fnv.user_info.fans_count >= 0 ? this.fnv.user_info.fans_count : 0L);
                    this.fna.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.fnc.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.fnw = false;
                jH(false);
                if (this.fnv != null && this.fnv.user_info != null) {
                    this.fnv.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.fnv.user_info.fans_count >= 0 ? this.fnv.user_info.fans_count : 0L);
                    this.fna.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.fnc.setText(formatForPersonCardBeanValue2[1]);
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

    public void jI(boolean z) {
        if (this.fnv != null && this.fnv.user_info != null) {
            if (z) {
                this.fnv.user_info.follow_count++;
            } else {
                this.fnv.user_info.follow_count--;
            }
            if (this.fnv.user_info.follow_count < 0) {
                this.fnv.user_info.follow_count = 0L;
            }
            this.fni.setText(com.baidu.tieba.ala.person.d.a.cW(this.fnv.user_info.follow_count));
        }
    }

    private View ip(boolean z) {
        if (z) {
            return LayoutInflater.from(this.fmX.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.fmX.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void jJ(boolean z) {
        this.fkc = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.eEC == null) {
                        PersonCardViewNew.this.eEC = AnimationUtils.loadAnimation(PersonCardViewNew.this.fmX.getActivity(), a.C0086a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.fns.setAnimation(PersonCardViewNew.this.eEC);
                    PersonCardViewNew.this.fns.setVisibility(0);
                    PersonCardViewNew.this.eEC.setDuration(300L);
                    PersonCardViewNew.this.eEC.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.fns != null) {
            this.fns.clearAnimation();
        }
        if (this.fnB != null && this.fnB.isShowing()) {
            this.fnB.dismiss();
        }
    }

    public Animation bdG() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eEC != null) {
            this.eEC.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.fmX.getActivity(), a.C0086a.sdk_push_up_out);
        this.fns.setAnimation(loadAnimation);
        this.fns.setVisibility(8);
        return loadAnimation;
    }

    public void awu() {
        if (this.fnB != null && this.fnB.isShowing()) {
            this.fnB.resize();
        }
    }
}
