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
    private static final int evw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private static final int evx = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);
    private boolean Pr;
    private boolean esF;
    private TextView evA;
    private TextView evB;
    private TextView evC;
    private TextView evD;
    private TextView evE;
    private TextView evF;
    private TextView evG;
    private TextView evH;
    private TextView evI;
    private TextView evJ;
    private TextView evK;
    private TextView evL;
    private TextView evM;
    private TextView evN;
    private HeadImageView evO;
    private LinearLayout evP;
    private FrameLayout evQ;
    private View evR;
    private View evS;
    private View evT;
    private PersonUserData evU;
    private boolean evV;
    private boolean evW;
    private a.InterfaceC0371a evX;
    private a evY;
    private Animation evZ;
    protected final PersonCardActivity evy;
    private TextView evz;
    private boolean ewa;
    private com.baidu.tieba.ala.person.a ewb;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.evy = personCardActivity;
        this.ewa = z;
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
        this.evY = new a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout));
    }

    private void initView() {
        this.evR = this.mRootView.findViewById(a.g.person_card_layout);
        this.evz = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.evK = (TextView) this.mRootView.findViewById(a.g.report);
        this.evA = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.evB = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.evC = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.evD = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.evF = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.evE = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.evG = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.evH = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.evI = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.evN = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.evJ = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.evM = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.evP = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.evS = this.mRootView.findViewById(a.g.user_divide);
        this.evT = this.mRootView.findViewById(a.g.user_divide2);
        this.evQ = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.evL = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        this.evO = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.evO.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.evO.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.evO.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.evO.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.evO.setIsRound(true);
        this.evO.setAutoChangeStyle(false);
        this.evO.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.evO.setBorderWidth(BdUtilHelper.getDimens(this.evy.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.evO.setBorderColor(872415231);
        this.evK.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.aXx();
            }
        });
        this.evQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(view.getContext(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.evy.finish();
                }
            }
        });
    }

    private void initListener() {
        this.evz.setOnClickListener(this);
        this.evL.setOnClickListener(this);
        this.evJ.setOnClickListener(this);
        a(new a.InterfaceC0371a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0371a
            public void aXn() {
                PersonCardViewNew.this.evy.aXj();
            }
        });
    }

    public void a(a.InterfaceC0371a interfaceC0371a) {
        this.evX = interfaceC0371a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.evU = personUserData;
            d(personUserData);
            c(personUserData);
            b(personUserData, z);
            this.evY.setData(personUserData.user_info);
            if (this.esF) {
                this.evP.setVisibility(8);
            }
        }
    }

    private void c(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.Pr = personUserData.user_info != null && this.evy.ug(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.evW = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.evW) {
                this.evP.setVisibility(8);
            } else {
                this.evP.setVisibility(0);
            }
            if (!z) {
                this.evG.setText("火星");
            } else {
                this.evG.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.evM.setVisibility(8);
                this.evT.setVisibility(8);
            } else {
                this.evM.setText(String.format(this.evy.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.evT.setVisibility(0);
                this.evM.setVisibility(0);
            }
            if (z2) {
                this.evI.setText(String.format(this.evy.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.evI.setVisibility(0);
                this.evS.setVisibility(0);
                return;
            }
            this.evI.setVisibility(8);
            this.evS.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aXx() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.evy.getActivity());
            this.evy.finish();
            return;
        }
        if (this.ewb != null && this.ewb.isShowing()) {
            this.ewb.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.evy.getActivity(), true);
        aVar.a(new a.InterfaceC0371a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0371a
            public void aXn() {
                if (PersonCardViewNew.this.evX != null) {
                    PersonCardViewNew.this.evX.aXn();
                }
            }
        });
        aVar.show();
        this.ewb = aVar;
    }

    private void d(PersonUserData personUserData) {
        int i = 26;
        s sVar = personUserData.user_info;
        if (sVar != null) {
            e(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(sVar.fans_count < 0 ? 0L : sVar.fans_count);
            this.evB.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.evD.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(sVar.follow_count < 0 ? 0L : sVar.follow_count);
            this.evH.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.evE.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.evC.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.evF.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.evF.setText("");
            }
            int i2 = this.ewa ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.ewa) {
                i = 22;
            }
            this.evB.setTextSize(1, i);
            this.evH.setTextSize(1, i);
            this.evC.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.evz.setVisibility(8);
                this.evK.setVisibility(8);
            } else if (this.evy.ug(TbadkCoreApplication.getCurrentAccount())) {
                this.evK.setVisibility(8);
                this.evz.setPadding(evw, evx, 0, 0);
                this.evz.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.evz.setVisibility(0);
                this.evK.setVisibility(0);
            } else {
                this.evK.setVisibility(0);
                this.evz.setVisibility(8);
            }
        }
    }

    private void e(PersonUserData personUserData) {
        s sVar = personUserData.user_info;
        this.evA.setText(sVar.getNameShow());
        j.a(this.evO, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(sVar.description)) {
            this.evN.setText(a.i.ala_person_desc_default_text);
        } else {
            this.evN.setText(sVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.evV = false;
            ip(false);
        } else if (!this.evW && (alaRelationData = personUserData.relation_info) != null) {
            this.evV = alaRelationData.follow_status != 0;
            if (z) {
                this.evJ.setVisibility(8);
            } else {
                ip(this.evV);
            }
        }
    }

    private void ip(boolean z) {
        if (z) {
            this.evJ.setText("已关注");
            this.evJ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
            this.evJ.setTextColor(this.evy.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
        } else {
            this.evJ.setText("关注");
            this.evJ.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            this.evJ.setTextColor(this.evy.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.evJ.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.evJ) {
            aXy();
        } else if (view == this.evL) {
            aXv();
        } else if (view == this.evz) {
            TiebaInitialize.log("c12266");
            this.evy.aXk();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, this.evU));
        }
    }

    private void aXv() {
        if (this.evU != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.evy.getActivity());
            } else if (this.evU.user_info == null || JavaTypesHelper.toLong(this.evU.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.evy.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.evU.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.evy.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.c.c cVar = new com.baidu.live.liveroom.c.c();
                cVar.ajq = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.evU.user_info));
                this.evy.finish();
            }
        }
    }

    private void aXy() {
        String str;
        if (this.evU != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.evy.getActivity());
                this.evy.finish();
            } else if (this.evU.user_info == null || JavaTypesHelper.toLong(this.evU.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.evy.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.evV) {
                    og(1);
                    this.evy.aXi();
                } else {
                    og(0);
                    this.evy.aXh();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.evV ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.Pr) {
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

    public void og(int i) {
        switch (i) {
            case 0:
                this.evV = true;
                ip(true);
                if (this.evU != null && this.evU.user_info != null) {
                    this.evU.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.evU.user_info.fans_count >= 0 ? this.evU.user_info.fans_count : 0L);
                    this.evB.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.evD.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.evV = false;
                ip(false);
                if (this.evU != null && this.evU.user_info != null) {
                    this.evU.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.evU.user_info.fans_count >= 0 ? this.evU.user_info.fans_count : 0L);
                    this.evB.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.evD.setText(formatForPersonCardBeanValue2[1]);
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
        if (this.evU != null && this.evU.user_info != null) {
            if (z) {
                this.evU.user_info.follow_count++;
            } else {
                this.evU.user_info.follow_count--;
            }
            if (this.evU.user_info.follow_count < 0) {
                this.evU.user_info.follow_count = 0L;
            }
            this.evJ.setText(com.baidu.tieba.ala.person.d.a.co(this.evU.user_info.follow_count));
        }
    }

    private View ir(boolean z) {
        if (z) {
            return LayoutInflater.from(this.evy.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.evy.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void is(boolean z) {
        this.esF = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.evZ == null) {
                        PersonCardViewNew.this.evZ = AnimationUtils.loadAnimation(PersonCardViewNew.this.evy.getActivity(), a.C0068a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.evR.setAnimation(PersonCardViewNew.this.evZ);
                    PersonCardViewNew.this.evR.setVisibility(0);
                    PersonCardViewNew.this.evZ.setDuration(300L);
                    PersonCardViewNew.this.evZ.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.evR != null) {
            this.evR.clearAnimation();
        }
        if (this.ewb != null && this.ewb.isShowing()) {
            this.ewb.dismiss();
        }
    }

    public Animation aXz() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.evZ != null) {
            this.evZ.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.evy.getActivity(), a.C0068a.sdk_push_up_out);
        this.evR.setAnimation(loadAnimation);
        this.evR.setVisibility(8);
        return loadAnimation;
    }

    public void afC() {
        if (this.ewb != null && this.ewb.isShowing()) {
            this.ewb.resize();
        }
    }
}
