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
    private boolean YB;
    private PersonUserData axw;
    private Animation eKq;
    private boolean fqD;
    private TextView ftA;
    private TextView ftB;
    private TextView ftC;
    private TextView ftD;
    private TextView ftE;
    private TextView ftF;
    private TextView ftG;
    private TextView ftH;
    private TextView ftI;
    private LinearLayout ftJ;
    private ImageView ftK;
    private TextView ftL;
    private TextView ftM;
    private TextView ftN;
    private TextView ftO;
    private HeadImageView ftP;
    private LinearLayout ftQ;
    private FrameLayout ftR;
    private View ftS;
    private View ftT;
    private View ftU;
    private boolean ftV;
    private boolean ftW;
    private a.InterfaceC0472a ftX;
    private a ftY;
    private boolean ftZ;
    protected final PersonCardActivity ftx;
    private TextView fty;
    private TextView ftz;
    private com.baidu.tieba.ala.person.a fua;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private String otherParams;
    private int screenWidth;
    private String uid;
    private static final int ftw = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds34);
    private static final int eZO = TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(a.e.sdk_ds24);

    public PersonCardViewNew(final PersonCardActivity personCardActivity, boolean z) {
        this.ftx = personCardActivity;
        this.ftZ = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = iI(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
        this.ftY = new a(personCardActivity, this.mRootView.findViewById(a.g.user_icon_layout), this.mRootView);
    }

    private void initView() {
        this.ftS = this.mRootView.findViewById(a.g.person_card_layout);
        this.fty = (TextView) this.mRootView.findViewById(a.g.ala_user_manage);
        this.ftJ = (LinearLayout) this.mRootView.findViewById(a.g.report);
        this.ftK = (ImageView) this.mRootView.findViewById(a.g.report_img_view);
        this.ftL = (TextView) this.mRootView.findViewById(a.g.report_text_view);
        this.ftz = (TextView) this.mRootView.findViewById(a.g.user_name);
        this.ftA = (TextView) this.mRootView.findViewById(a.g.fans_num);
        this.ftB = (TextView) this.mRootView.findViewById(a.g.bean_num);
        this.ftC = (TextView) this.mRootView.findViewById(a.g.fans_num_unit);
        this.ftE = (TextView) this.mRootView.findViewById(a.g.bean_num_unit);
        this.ftD = (TextView) this.mRootView.findViewById(a.g.attention_num_unit);
        this.ftF = (TextView) this.mRootView.findViewById(a.g.user_location);
        this.ftG = (TextView) this.mRootView.findViewById(a.g.attention_num);
        this.ftH = (TextView) this.mRootView.findViewById(a.g.user_id);
        this.ftO = (TextView) this.mRootView.findViewById(a.g.user_desc);
        this.ftI = (TextView) this.mRootView.findViewById(a.g.btn_person_card_follow);
        this.ftN = (TextView) this.mRootView.findViewById(a.g.user_receive_charm);
        this.ftQ = (LinearLayout) this.mRootView.findViewById(a.g.bottom_layout);
        this.ftT = this.mRootView.findViewById(a.g.user_divide);
        this.ftU = this.mRootView.findViewById(a.g.user_divide2);
        this.ftR = (FrameLayout) this.mRootView.findViewById(a.g.portrait_layout);
        this.ftM = (TextView) this.mRootView.findViewById(a.g.btn_person_card_ate);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ftM.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray_bd);
        } else {
            this.ftM.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
        }
        this.ftP = (HeadImageView) this.mRootView.findViewById(a.g.user_portrait);
        if (TbadkCoreApplication.getInst().isHaokan()) {
            this.ftP.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def_hk);
            this.ftP.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def_hk);
        } else {
            this.ftP.setDefaultResource(a.f.sdk_pic_mycenter_avatar_def);
            this.ftP.setDefaultErrorResource(a.f.sdk_pic_mycenter_avatar_def);
        }
        this.ftP.setIsRound(true);
        this.ftP.setAutoChangeStyle(false);
        this.ftP.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.ftP.setBorderWidth(BdUtilHelper.getDimens(this.ftx.getPageContext().getPageActivity(), a.e.sdk_ds4));
        this.ftP.setBorderColor(872415231);
        this.ftJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                PersonCardViewNew.this.bsj();
            }
        });
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.fty.getLayoutParams();
        layoutParams.addRule(1, this.ftJ.getId());
        this.fty.setLayoutParams(layoutParams);
        this.ftK.setVisibility(8);
        this.ftL.setText(a.i.ala_person_report);
        this.ftR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                IExtraJump buildJumpExtra = ExtraJumpManager.getInstance().buildJumpExtra();
                if (buildJumpExtra != null) {
                    buildJumpExtra.jumpToPersonalCenter(PersonCardViewNew.this.ftx.getPageContext().getPageActivity(), PersonCardViewNew.this.uid);
                    PersonCardViewNew.this.ftx.finish();
                }
            }
        });
    }

    private void initListener() {
        this.fty.setOnClickListener(this);
        this.ftM.setOnClickListener(this);
        this.ftI.setOnClickListener(this);
        a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.4
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0472a
            public void brY() {
                PersonCardViewNew.this.ftx.brV();
            }
        });
    }

    public void a(a.InterfaceC0472a interfaceC0472a) {
        this.ftX = interfaceC0472a;
    }

    public void a(PersonUserData personUserData, boolean z) {
        if (personUserData != null) {
            this.axw = personUserData;
            e(personUserData);
            d(personUserData);
            b(personUserData, z);
            this.ftY.setData(personUserData.user_info);
            if (this.fqD) {
                this.ftQ.setVisibility(8);
            }
        }
    }

    private void d(PersonUserData personUserData) {
        if (personUserData != null) {
            boolean z = (personUserData.location_info == null || TextUtils.isEmpty(personUserData.location_info.location)) ? false : true;
            boolean z2 = (personUserData.user_info == null || personUserData.user_info.ala_id == 0) ? false : true;
            this.YB = personUserData.user_info != null && this.ftx.zC(personUserData.user_info.user_id);
            this.uid = personUserData.user_info != null ? personUserData.user_info.user_id : "";
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            this.ftW = (currentAccount == null || "".equals(currentAccount) || !currentAccount.equals(personUserData.user_info.user_id)) ? false : true;
            if (this.ftW) {
                this.ftQ.setVisibility(8);
            } else {
                this.ftQ.setVisibility(0);
            }
            if (!z) {
                this.ftF.setText("火星");
            } else {
                this.ftF.setText(personUserData.location_info.location);
            }
            if (personUserData.user_info == null || personUserData.user_info.charm_count == 0) {
                this.ftN.setVisibility(8);
                this.ftU.setVisibility(8);
            } else {
                this.ftN.setText(String.format(this.ftx.getString(a.i.ala_person_receive_charm), StringHelper.formatForPersonCardCharmValue(personUserData.user_info.charm_count)));
                this.ftU.setVisibility(0);
                this.ftN.setVisibility(0);
            }
            if (z2) {
                this.ftH.setText(String.format(this.ftx.getString(a.i.ala_person_id), String.valueOf(personUserData.user_info.ala_id)));
                this.ftH.setVisibility(0);
                this.ftT.setVisibility(0);
                return;
            }
            this.ftH.setVisibility(8);
            this.ftT.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsj() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.ftx.getActivity());
            this.ftx.finish();
            return;
        }
        if (this.fua != null && this.fua.isShowing()) {
            this.fua.dismiss();
        }
        com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.ftx.getActivity(), true);
        aVar.a(new a.InterfaceC0472a() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0472a
            public void brY() {
                if (PersonCardViewNew.this.ftX != null) {
                    PersonCardViewNew.this.ftX.brY();
                }
            }
        });
        aVar.show();
        this.fua = aVar;
    }

    private void e(PersonUserData personUserData) {
        int i = 26;
        x xVar = personUserData.user_info;
        if (xVar != null) {
            f(personUserData);
            String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(xVar.fans_count < 0 ? 0L : xVar.fans_count);
            this.ftA.setText(formatForPersonCardBeanValue[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                this.ftC.setText(formatForPersonCardBeanValue[1]);
            }
            String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(xVar.follow_count < 0 ? 0L : xVar.follow_count);
            this.ftG.setText(formatForPersonCardBeanValue2[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                this.ftD.setText(formatForPersonCardBeanValue2[1]);
            }
            String[] formatForPersonCardBeanValue3 = StringHelper.formatForPersonCardBeanValue(personUserData.user_info.send_count);
            this.ftB.setText(formatForPersonCardBeanValue3[0]);
            if (!TextUtils.isEmpty(formatForPersonCardBeanValue3[1])) {
                this.ftE.setText(formatForPersonCardBeanValue3[1]);
            } else {
                this.ftE.setText("");
            }
            int i2 = this.ftZ ? 26 : 30;
            if (this.screenWidth >= 360) {
                i = i2;
            } else if (this.ftZ) {
                i = 22;
            }
            this.ftA.setTextSize(1, i);
            this.ftG.setTextSize(1, i);
            this.ftB.setTextSize(1, i);
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.fty.setVisibility(8);
                this.ftJ.setVisibility(8);
            } else if (this.ftx.zC(TbadkCoreApplication.getCurrentAccount())) {
                this.ftJ.setVisibility(8);
                this.fty.setPadding(ftw, eZO, 0, 0);
                this.fty.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.fty.setVisibility(0);
                this.ftJ.setVisibility(0);
            } else {
                this.ftJ.setVisibility(0);
                this.fty.setVisibility(8);
            }
        }
    }

    private void f(PersonUserData personUserData) {
        x xVar = personUserData.user_info;
        this.ftz.setText(xVar.getNameShow());
        k.a(this.ftP, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
        if (StringUtils.isNull(xVar.description)) {
            this.ftO.setText(a.i.ala_person_desc_default_text);
        } else {
            this.ftO.setText(xVar.description);
        }
    }

    private void b(PersonUserData personUserData, boolean z) {
        AlaRelationData alaRelationData;
        if (!TbadkCoreApplication.isLogin()) {
            this.ftV = false;
            jW(false);
        } else if (!this.ftW && (alaRelationData = personUserData.relation_info) != null) {
            this.ftV = alaRelationData.follow_status != 0;
            if (z) {
                this.ftI.setVisibility(8);
            } else {
                jW(this.ftV);
            }
        }
    }

    private void jW(boolean z) {
        if (z) {
            this.ftI.setText("已关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ftI.setBackgroundResource(a.f.ala_person_card_followed_bg_bd);
                this.ftI.setTextColor(this.ftx.getPageContext().getResources().getColor(a.d.sdk_white_alpha60));
            } else {
                this.ftI.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_gray);
                this.ftI.setTextColor(this.ftx.getPageContext().getResources().getColor(a.d.sdk_white_alpha20));
            }
        } else {
            this.ftI.setText("关注");
            if (TbadkCoreApplication.getInst().isMobileBaidu()) {
                this.ftI.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_bd_selector);
            } else {
                this.ftI.setBackgroundResource(a.f.ala_person_card_bottom_tab_text_bg_red);
            }
            this.ftI.setTextColor(this.ftx.getPageContext().getResources().getColor(a.d.sdk_white_alpha100));
        }
        this.ftI.setVisibility(0);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ftI) {
            bsk();
        } else if (view == this.ftM) {
            bsg();
        } else if (view == this.fty) {
            TiebaInitialize.log("c12266");
            this.ftx.bgg();
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, this.axw));
        }
    }

    private void bsg() {
        if (this.axw != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.ftx.getActivity());
            } else if (this.axw.user_info == null || JavaTypesHelper.toLong(this.axw.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.ftx.getActivity(), a.i.ala_cannot_reply_tourist);
            } else if (this.axw.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.ftx.getActivity(), a.i.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.awl = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.axw.user_info));
                this.ftx.finish();
            }
        }
    }

    private void bsk() {
        String str;
        if (this.axw != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.ftx.getActivity());
                this.ftx.finish();
            } else if (this.axw.user_info == null || JavaTypesHelper.toLong(this.axw.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.ftx.getActivity(), a.i.ala_cannot_follow_tourist);
            } else {
                if (this.ftV) {
                    qM(1);
                    this.ftx.brU();
                } else {
                    qM(0);
                    this.ftx.brT();
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
                    AlaStaticItem alaStaticItem2 = new AlaStaticItem(!this.ftV ? QMStaticKeys.QM_STATIC_FOLLOW_CANCEL_CLICK : QMStaticKeys.QM_STATIC_FOLLOW_CLICK);
                    alaStaticItem2.addParams("live_id", QMStaticManager.LIVE_ID);
                    alaStaticItem2.addParams("room_id", QMStaticManager.ROOM_ID);
                    alaStaticItem2.addParams("feed_id", QMStaticManager.FEED_ID);
                    if (this.YB) {
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

    public void qM(int i) {
        switch (i) {
            case 0:
                this.ftV = true;
                jW(true);
                if (this.axw != null && this.axw.user_info != null) {
                    this.axw.user_info.fans_count++;
                    String[] formatForPersonCardBeanValue = StringHelper.formatForPersonCardBeanValue(this.axw.user_info.fans_count >= 0 ? this.axw.user_info.fans_count : 0L);
                    this.ftA.setText(formatForPersonCardBeanValue[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue[1])) {
                        this.ftC.setText(formatForPersonCardBeanValue[1]);
                        return;
                    }
                    return;
                }
                return;
            case 1:
                this.ftV = false;
                jW(false);
                if (this.axw != null && this.axw.user_info != null) {
                    this.axw.user_info.fans_count--;
                    String[] formatForPersonCardBeanValue2 = StringHelper.formatForPersonCardBeanValue(this.axw.user_info.fans_count >= 0 ? this.axw.user_info.fans_count : 0L);
                    this.ftA.setText(formatForPersonCardBeanValue2[0]);
                    if (!TextUtils.isEmpty(formatForPersonCardBeanValue2[1])) {
                        this.ftC.setText(formatForPersonCardBeanValue2[1]);
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

    public void jX(boolean z) {
        if (this.axw != null && this.axw.user_info != null) {
            if (z) {
                this.axw.user_info.follow_count++;
            } else {
                this.axw.user_info.follow_count--;
            }
            if (this.axw.user_info.follow_count < 0) {
                this.axw.user_info.follow_count = 0L;
            }
            this.ftI.setText(com.baidu.tieba.ala.person.d.a.dd(this.axw.user_info.follow_count));
        }
    }

    private View iI(boolean z) {
        if (z) {
            return LayoutInflater.from(this.ftx.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new_land, (ViewGroup) null);
        }
        return LayoutInflater.from(this.ftx.getPageContext().getPageActivity()).inflate(a.h.ala_activity_person_card_new, (ViewGroup) null);
    }

    public void setOtherParams(String str) {
        this.otherParams = str;
    }

    public void jY(boolean z) {
        this.fqD = z;
    }

    public View getRootView() {
        return this.mRootView;
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.PersonCardViewNew.6
                @Override // java.lang.Runnable
                public void run() {
                    if (PersonCardViewNew.this.eKq == null) {
                        PersonCardViewNew.this.eKq = AnimationUtils.loadAnimation(PersonCardViewNew.this.ftx.getActivity(), a.C0102a.sdk_push_up_in);
                    }
                    PersonCardViewNew.this.ftS.setAnimation(PersonCardViewNew.this.eKq);
                    PersonCardViewNew.this.ftS.setVisibility(0);
                    PersonCardViewNew.this.eKq.setDuration(300L);
                    PersonCardViewNew.this.eKq.start();
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.ftS != null) {
            this.ftS.clearAnimation();
        }
        if (this.fua != null && this.fua.isShowing()) {
            this.fua.dismiss();
        }
    }

    public Animation bgt() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.eKq != null) {
            this.eKq.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.ftx.getActivity(), a.C0102a.sdk_push_up_out);
        this.ftS.setAnimation(loadAnimation);
        this.ftS.setVisibility(8);
        return loadAnimation;
    }

    public void azf() {
        if (this.fua != null && this.fua.isShowing()) {
            this.fua.resize();
        }
    }
}
