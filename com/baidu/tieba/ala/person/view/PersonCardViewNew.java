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
import com.baidu.live.data.w;
import com.baidu.live.r.a;
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
    private boolean WF;
    private Animation eFM;
    private boolean fnm;
    private FrameLayout fqA;
    private View fqB;
    private View fqC;
    private View fqD;
    private PersonUserData fqE;
    private boolean fqF;
    private boolean fqG;
    private a.InterfaceC0464a fqH;
    private a fqI;
    private boolean fqJ;
    private com.baidu.tieba.ala.person.a fqK;
    protected final PersonCardActivity fqg;
    private TextView fqh;
    private TextView fqi;
    private TextView fqj;
    private TextView fqk;
    private TextView fql;
    private TextView fqm;
    private TextView fqn;
    private TextView fqo;
    private TextView fqp;
    private TextView fqq;
    private TextView fqr;
    private LinearLayout fqs;
    private ImageView fqt;
    private TextView fqu;
    private TextView fqv;
    private TextView fqw;
    private TextView fqx;
    private HeadImageView fqy;
    private LinearLayout fqz;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;
    private static final int fqf = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private static final int eVl = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.fqg = personCardActivity;
        this.fqJ = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = iz(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.fqI = new a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    private void initView() {
        this.fqB = this.mRootView.findViewById(a.g.person_card_layout);
        this.fqh = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.fqs = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.fqt = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.fqu = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.fqi = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.fqj = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.fqk = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.fql = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.fqn = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.fqm = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.fqo = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.fqp = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.fqq = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.fqx = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.fqr = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.fqw = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.fqz = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.fqC = this.mRootView.findViewById(a.g.user_divide);
        this.fqD = this.mRootView.findViewById(a.g.user_divide2);
        this.fqA = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.fqv = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.fqv.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.fqv.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.fqy = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.fqy.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.fqy.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.fqy.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.fqy.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.fqy.setIsRound(true);
        this.fqy.setAutoChangeStyle(false);
        this.fqy.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.fqy.setBorderWidth(BdUtilHelper.getDimens(this.fqg.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.fqy.setBorderColor(872415231);
        this.fqs.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bqx();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fqh.getLayoutParams();
        layoutParams.addRule(1, this.fqs.getId());
        this.fqh.setLayoutParams(layoutParams);
        this.fqt.setVisibility(8);
        this.fqu.setText(a.i.ala_person_report);
        this.fqA.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.fqg.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.fqg.finish();
                }
            }
        });
    }

    private void initListener() {
        this.fqh.setOnClickListener(this);
        this.fqv.setOnClickListener(this);
        this.fqr.setOnClickListener(this);
        a(new a.InterfaceC0464a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0464a
            public void bqm() {
                PersonCardViewNew.this.fqg.bqj();
            }
        });
    }

    public void a(a.InterfaceC0464a interfaceC0464a) {
        this.fqH = interfaceC0464a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.fqE = personUserData;
            d(personUserData);
            c(personUserData);
            b(personUserData, z);
            this.fqI.setData(personUserData.user_info);
            if (this.fnm) {
                this.fqz.setVisibility(8);
            }
        }
    }

    private void c(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.WF = personUserData.user_info != null && this.fqg.zi(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.fqG = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.fqG) {
                this.fqz.setVisibility(8);
            } else {
                this.fqz.setVisibility(0);
            }
            if (!z) {
                this.fqo.setText("火星");
            } else {
                this.fqo.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.fqw.setVisibility(8);
                this.fqD.setVisibility(8);
            } else {
                this.fqw.setText(String.format(this.fqg.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.fqD.setVisibility(0);
                this.fqw.setVisibility(0);
            }
            if (z2) {
                this.fqq.setText(String.format(this.fqg.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.fqq.setVisibility(0);
                this.fqC.setVisibility(0);
                return;
            }
            this.fqq.setVisibility(8);
            this.fqC.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bqx() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.fqg.getActivity());
            this.fqg.finish();
            return;
        }
        if (this.fqK != null && this.fqK.isShowing()) {
            this.fqK.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.fqg.getActivity(), true);
        aVar.a(new a.InterfaceC0464a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0464a
            public void bqm() {
                if (PersonCardViewNew.this.fqH != null) {
                    PersonCardViewNew.this.fqH.bqm();
                }
            }
        });
        aVar.show();
        this.fqK = aVar;
    }

    private void d(PersonUserData personUserData) {
        int i = 26;
        w wVar = personUserData.user_info;
        if (wVar != null) {
            e(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(wVar.fans_count < 0 ? 0L : wVar.fans_count);
            this.fqj.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.fql.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(wVar.follow_count < 0 ? 0L : wVar.follow_count);
            this.fqp.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.fqm.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.fqk.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.fqn.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.fqn.setText("");
            }
            int i2 = this.fqJ ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.fqJ) {
                i = 22;
            }
            this.fqj.setTextSize(1, i);
            this.fqp.setTextSize(1, i);
            this.fqk.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.fqh.setVisibility(8);
                this.fqs.setVisibility(8);
            } else if (this.fqg.zi(TbadkCoreApplication.getCurrentAccount())) {
                this.fqs.setVisibility(8);
                this.fqh.setPadding(fqf, eVl, 0, 0);
                this.fqh.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.fqh.setVisibility(0);
                this.fqs.setVisibility(0);
            } else {
                this.fqs.setVisibility(0);
                this.fqh.setVisibility(8);
            }
        }
    }

    private void e(PersonUserData personUserData) {
        w wVar = personUserData.user_info;
        this.fqi.setText(wVar.getNameShow());
        k.a(this.fqy, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(wVar.description)) {
            this.fqx.setText(a.i.ala_person_desc_default_text);
        } else {
            this.fqx.setText(wVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.fqF = false;
            jS(false);
        } else if (!this.fqG && (alaRelationData = personUserData.relation_info) != null) {
            this.fqF = alaRelationData.follow_status != 0;
            if (z) {
                this.fqr.setVisibility(8);
            } else {
                jS(this.fqF);
            }
        }
    }

    private void jS(boolean z) {
        if (z) {
            this.fqr.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fqr.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.fqr.setTextColor(this.fqg.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.fqr.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.fqr.setTextColor(this.fqg.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.fqr.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.fqr.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.fqr.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.fqr.setTextColor(this.fqg.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.fqr.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fqr) {
            bqy();
        } else if (view == this.fqv) {
            bqu();
        } else if (view == this.fqh) {
            TiebaInitialize.log("c12266");
            this.fqg.bdO();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, this.fqE));
        }
    }

    private void bqu() {
        if (this.fqE != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fqg.getActivity());
            } else if (this.fqE.user_info == null || JavaTypesHelper.toLong(this.fqE.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fqg.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.fqE.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.fqg.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
                cVar.arZ = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.fqE.user_info));
                this.fqg.finish();
            }
        }
    }

    private void bqy() {
        String str;
        if (this.fqE != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.fqg.getActivity());
                this.fqg.finish();
            } else if (this.fqE.user_info == null || JavaTypesHelper.toLong(this.fqE.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.fqg.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.fqF) {
                    qD(1);
                    this.fqg.bqi();
                } else {
                    qD(0);
                    this.fqg.bqh();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.fqF ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.WF) {
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

    public void qD(int i) {
        switch (i) {
            case 0:
                this.fqF = true;
                jS(true);
                if (this.fqE != null && this.fqE.user_info != null) {
                    this.fqE.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.fqE.user_info.fans_count >= 0 ? this.fqE.user_info.fans_count : 0L);
                    this.fqj.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.fql.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.fqF = false;
                jS(false);
                if (this.fqE != null && this.fqE.user_info != null) {
                    this.fqE.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.fqE.user_info.fans_count >= 0 ? this.fqE.user_info.fans_count : 0L);
                    this.fqj.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.fql.setText(formatForPersonCardBeanValue2[1]);
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

    public void jT(boolean z) {
        if (this.fqE != null && this.fqE.user_info != null) {
            if (z) {
                this.fqE.user_info.follow_count++;
            } else {
                this.fqE.user_info.follow_count--;
            }
            if (this.fqE.user_info.follow_count < 0) {
                this.fqE.user_info.follow_count = 0L;
            }
            this.fqr.setText(com.baidu.tieba.ala.person.d.a.db(this.fqE.user_info.follow_count));
        }
    }

    private View iz(boolean z) {
        if (z) {
            return LayoutInflater.from(this.fqg.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.fqg.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void jU(boolean z) {
        this.fnm = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.eFM == null) {
                        PersonCardViewNew.this.eFM = AnimationUtils.loadAnimation(PersonCardViewNew.this.fqg.getActivity(), a.C0086a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.fqB.setAnimation(PersonCardViewNew.this.eFM);
                    PersonCardViewNew.this.fqB.setVisibility(0);
                    PersonCardViewNew.this.eFM.setDuration(300L);
                    PersonCardViewNew.this.eFM.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.fqB != null) {
            this.fqB.clearAnimation();
        }
        if (this.fqK != null && this.fqK.isShowing()) {
            this.fqK.dismiss();
        }
    }

    public Animation beb() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eFM != null) {
            this.eFM.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.fqg.getActivity(), a.C0086a.sdk_push_up_out);
        this.fqB.setAnimation(loadAnimation);
        this.fqB.setVisibility(8);
        return loadAnimation;
    }

    public void awN() {
        if (this.fqK != null && this.fqK.isShowing()) {
            this.fqK.resize();
        }
    }
}
