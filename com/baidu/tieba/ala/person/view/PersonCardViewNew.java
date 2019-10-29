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
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.data.AlaRelationData;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.s;
import com.baidu.live.k.a;
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
import com.baidu.live.utils.j;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
/* loaded from: classes6.dex */
public class PersonCardViewNew implements ViewPager.OnPageChangeListener, View.OnClickListener {
    private static final int ewn = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private static final int ewo = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private boolean PW;
    private boolean etx;
    private TextView ewA;
    private TextView ewB;
    private TextView ewC;
    private TextView ewD;
    private TextView ewE;
    private HeadImageView ewF;
    private LinearLayout ewG;
    private FrameLayout ewH;
    private View ewI;
    private View ewJ;
    private View ewK;
    private PersonUserData ewL;
    private boolean ewM;
    private boolean ewN;
    private a.InterfaceC0376a ewO;
    private a ewP;
    private Animation ewQ;
    private boolean ewR;
    private com.baidu.tieba.ala.person.a ewS;
    protected final PersonCardActivity ewp;
    private TextView ewq;
    private TextView ewr;
    private TextView ews;
    private TextView ewt;
    private TextView ewu;
    private TextView ewv;
    private TextView eww;
    private TextView ewx;
    private TextView ewy;
    private TextView ewz;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.ewp = personCardActivity;
        this.ewR = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = ir(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.ewP = new a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout));
    }

    private void initView() {
        this.ewI = this.mRootView.findViewById(a.g.person_card_layout);
        this.ewq = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.ewB = (TextView) this.mRootView.findViewById(a.g.report);
        this.ewr = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.ews = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.ewt = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.ewu = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.eww = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.ewv = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.ewx = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.ewy = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.ewz = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.ewE = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.ewA = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.ewD = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.ewG = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.ewJ = this.mRootView.findViewById(a.g.user_divide);
        this.ewK = this.mRootView.findViewById(a.g.user_divide2);
        this.ewH = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.ewC = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        this.ewF = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ewF.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.ewF.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.ewF.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.ewF.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.ewF.setIsRound(true);
        this.ewF.setAutoChangeStyle(false);
        this.ewF.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ewF.setBorderWidth(BdUtilHelper.getDimens(this.ewp.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.ewF.setBorderColor(872415231);
        this.ewB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.aXz();
            }
        });
        this.ewH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(view.getContext(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.ewp.finish();
                }
            }
        });
    }

    private void initListener() {
        this.ewq.setOnClickListener(this);
        this.ewC.setOnClickListener(this);
        this.ewA.setOnClickListener(this);
        a(new a.InterfaceC0376a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0376a
            public void aXp() {
                PersonCardViewNew.this.ewp.aXl();
            }
        });
    }

    public void a(a.InterfaceC0376a interfaceC0376a) {
        this.ewO = interfaceC0376a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.ewL = personUserData;
            d(personUserData);
            c(personUserData);
            b(personUserData, z);
            this.ewP.setData(personUserData.user_info);
            if (this.etx) {
                this.ewG.setVisibility(8);
            }
        }
    }

    private void c(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.PW = personUserData.user_info != null && this.ewp.ug(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.ewN = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.ewN) {
                this.ewG.setVisibility(8);
            } else {
                this.ewG.setVisibility(0);
            }
            if (!z) {
                this.ewx.setText("火星");
            } else {
                this.ewx.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.ewD.setVisibility(8);
                this.ewK.setVisibility(8);
            } else {
                this.ewD.setText(String.format(this.ewp.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.ewK.setVisibility(0);
                this.ewD.setVisibility(0);
            }
            if (z2) {
                this.ewz.setText(String.format(this.ewp.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.ewz.setVisibility(0);
                this.ewJ.setVisibility(0);
                return;
            }
            this.ewz.setVisibility(8);
            this.ewJ.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXz() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.ewp.getActivity());
            this.ewp.finish();
            return;
        }
        if (this.ewS != null && this.ewS.isShowing()) {
            this.ewS.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.ewp.getActivity(), true);
        aVar.a(new a.InterfaceC0376a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0376a
            public void aXp() {
                if (PersonCardViewNew.this.ewO != null) {
                    PersonCardViewNew.this.ewO.aXp();
                }
            }
        });
        aVar.show();
        this.ewS = aVar;
    }

    private void d(PersonUserData personUserData) {
        int i = 26;
        s sVar = personUserData.user_info;
        if (sVar != null) {
            e(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(sVar.fans_count < 0 ? 0L : sVar.fans_count);
            this.ews.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.ewu.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(sVar.follow_count < 0 ? 0L : sVar.follow_count);
            this.ewy.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.ewv.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.ewt.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.eww.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.eww.setText("");
            }
            int i2 = this.ewR ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.ewR) {
                i = 22;
            }
            this.ews.setTextSize(1, i);
            this.ewy.setTextSize(1, i);
            this.ewt.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.ewq.setVisibility(8);
                this.ewB.setVisibility(8);
            } else if (this.ewp.ug(TbadkCoreApplication.getCurrentAccount())) {
                this.ewB.setVisibility(8);
                this.ewq.setPadding(ewn, ewo, 0, 0);
                this.ewq.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.ewq.setVisibility(0);
                this.ewB.setVisibility(0);
            } else {
                this.ewB.setVisibility(0);
                this.ewq.setVisibility(8);
            }
        }
    }

    private void e(PersonUserData personUserData) {
        s sVar = personUserData.user_info;
        this.ewr.setText(sVar.getNameShow());
        j.a(this.ewF, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(sVar.description)) {
            this.ewE.setText(a.i.ala_person_desc_default_text);
        } else {
            this.ewE.setText(sVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.ewM = false;
            ip(false);
        } else if (!this.ewN && (alaRelationData = personUserData.relation_info) != null) {
            this.ewM = alaRelationData.follow_status != 0;
            if (z) {
                this.ewA.setVisibility(8);
            } else {
                ip(this.ewM);
            }
        }
    }

    private void ip(boolean z) {
        if (z) {
            this.ewA.setText("已关注");
            this.ewA.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
            this.ewA.setTextColor(this.ewp.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
        } else {
            this.ewA.setText("关注");
            this.ewA.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            this.ewA.setTextColor(this.ewp.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.ewA.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ewA) {
            aXA();
        } else if (view == this.ewC) {
            aXx();
        } else if (view == this.ewq) {
            TiebaInitialize.log("c12266");
            this.ewp.aXm();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, this.ewL));
        }
    }

    private void aXx() {
        if (this.ewL != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.ewp.getActivity());
            } else if (this.ewL.user_info == null || JavaTypesHelper.toLong(this.ewL.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.ewp.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.ewL.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.ewp.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
                cVar.ajI = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.ewL.user_info));
                this.ewp.finish();
            }
        }
    }

    private void aXA() {
        String str;
        if (this.ewL != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.ewp.getActivity());
                this.ewp.finish();
            } else if (this.ewL.user_info == null || JavaTypesHelper.toLong(this.ewL.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.ewp.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.ewM) {
                    oh(1);
                    this.ewp.aXk();
                } else {
                    oh(0);
                    this.ewp.aXj();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.ewM ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.PW) {
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

    public void oh(int i) {
        switch (i) {
            case 0:
                this.ewM = true;
                ip(true);
                if (this.ewL != null && this.ewL.user_info != null) {
                    this.ewL.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.ewL.user_info.fans_count >= 0 ? this.ewL.user_info.fans_count : 0L);
                    this.ews.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.ewu.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.ewM = false;
                ip(false);
                if (this.ewL != null && this.ewL.user_info != null) {
                    this.ewL.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.ewL.user_info.fans_count >= 0 ? this.ewL.user_info.fans_count : 0L);
                    this.ews.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.ewu.setText(formatForPersonCardBeanValue2[1]);
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

    public void iq(boolean z) {
        if (this.ewL != null && this.ewL.user_info != null) {
            if (z) {
                this.ewL.user_info.follow_count++;
            } else {
                this.ewL.user_info.follow_count--;
            }
            if (this.ewL.user_info.follow_count < 0) {
                this.ewL.user_info.follow_count = 0L;
            }
            this.ewA.setText(com.baidu.tieba.ala.person.d.a.cp(this.ewL.user_info.follow_count));
        }
    }

    private View ir(boolean z) {
        if (z) {
            return LayoutInflater.from(this.ewp.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.ewp.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void is(boolean z) {
        this.etx = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.ewQ == null) {
                        PersonCardViewNew.this.ewQ = AnimationUtils.loadAnimation(PersonCardViewNew.this.ewp.getActivity(), a.C0068a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.ewI.setAnimation(PersonCardViewNew.this.ewQ);
                    PersonCardViewNew.this.ewI.setVisibility(0);
                    PersonCardViewNew.this.ewQ.setDuration(300L);
                    PersonCardViewNew.this.ewQ.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.ewI != null) {
            this.ewI.clearAnimation();
        }
        if (this.ewS != null && this.ewS.isShowing()) {
            this.ewS.dismiss();
        }
    }

    public Animation aXB() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.ewQ != null) {
            this.ewQ.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ewp.getActivity(), a.C0068a.sdk_push_up_out);
        this.ewI.setAnimation(loadAnimation);
        this.ewI.setVisibility(8);
        return loadAnimation;
    }

    public void afE() {
        if (this.ewS != null && this.ewS.isShowing()) {
            this.ewS.resize();
        }
    }
}
