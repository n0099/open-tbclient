package com.baidu.tieba.ala.person.view;

import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.safe.JavaTypesHelper;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d.g;
import com.baidu.live.data.PersonUserData;
import com.baidu.live.data.ax;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.TiebaInitialize;
import com.baidu.live.tbadk.core.util.ViewHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.person.PersonCardActivity;
import com.baidu.tieba.ala.person.a;
/* loaded from: classes11.dex */
public class c implements View.OnClickListener {
    private TextView aDM;
    private long buN;
    private PersonUserData bxd;
    private long goZ;
    protected final PersonCardActivity hXQ;
    private View hXR;
    private View hXS;
    private TextView hXT;
    private Button hXU;
    private Button hXV;
    private TextView hXW;
    private HeadImageView hXX;
    private ImageView hXY;
    private View hXZ;
    private a.InterfaceC0681a hYa;
    private boolean hYb;
    private com.baidu.tieba.ala.person.a hYc;
    private Animation hdH;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private int screenWidth;
    private String uid;

    public c(final PersonCardActivity personCardActivity, boolean z) {
        this.hXQ = personCardActivity;
        this.hYb = z;
        this.screenWidth = (int) ((1.0f * personCardActivity.getPageContext().getResources().getDisplayMetrics().widthPixels) / personCardActivity.getPageContext().getResources().getDisplayMetrics().density);
        this.mRootView = ns(z);
        this.mRootView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                personCardActivity.finish();
            }
        });
        initView();
        initListener();
    }

    public void eC(String str, String str2) {
        if (str != null && str2 != null) {
            this.aDM.setText(str);
            m.a(this.hXX, str2, true, false);
        }
    }

    public void d(PersonUserData personUserData) {
        this.bxd = personUserData;
        ax axVar = personUserData.user_info;
        if (axVar != null) {
            if (!StringUtils.isNull(axVar.getNameShow())) {
                String nameShow = axVar.getNameShow();
                if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                    nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
                }
                this.aDM.setText(nameShow);
            }
            m.a(this.hXX, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hXW.setVisibility(8);
                this.hXV.setVisibility(8);
            } else if (this.hXQ.Ij(TbadkCoreApplication.getCurrentAccount())) {
                this.hXV.setVisibility(8);
                this.hXW.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hXW.setVisibility(0);
                this.hXV.setVisibility(0);
            } else {
                this.hXV.setVisibility(0);
                this.hXW.setVisibility(8);
            }
        }
    }

    private void initView() {
        this.hXR = this.mRootView.findViewById(a.f.mystery_person_card_frame);
        this.hXS = this.mRootView.findViewById(a.f.mystery_person_card_layout);
        this.aDM = (TextView) this.mRootView.findViewById(a.f.person_card_user_name);
        this.hXW = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hXU = (Button) this.mRootView.findViewById(a.f.person_card_at_button);
        this.hXY = (ImageView) this.mRootView.findViewById(a.f.card_decoration);
        this.hXZ = this.mRootView.findViewById(a.f.user_portrait_layout);
        this.hXU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cmJ();
            }
        });
        this.hXV = (Button) this.mRootView.findViewById(a.f.mystery_person_card_report_btn);
        this.hXX = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hXT = (TextView) this.mRootView.findViewById(a.f.mysterious_text);
        this.hXX.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hXX.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hXX.setIsRound(true);
        this.hXX.setAutoChangeStyle(false);
        this.hXX.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXX.setBorderWidth(BdUtilHelper.getDimens(this.hXQ.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hXV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cmO();
            }
        });
        this.hXX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void initListener() {
        a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.person.view.c.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0681a
            public void cmB() {
                c.this.hXQ.cmw();
            }
        });
        this.hXW.setOnClickListener(this);
    }

    public void a(a.InterfaceC0681a interfaceC0681a) {
        this.hYa = interfaceC0681a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmO() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hXQ.getActivity());
            this.hXQ.finish();
        } else if (this.bxd != null && this.bxd.user_info != null && this.bxd.user_info.live_status == 1) {
            g gVar = new g(this.hXQ);
            gVar.a(this.buN, this.goZ, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bxd.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hXQ.finish();
        } else {
            if (this.hYc != null && this.hYc.isShowing()) {
                this.hYc.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hXQ.getActivity(), true);
            aVar.a(new a.InterfaceC0681a() { // from class: com.baidu.tieba.ala.person.view.c.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0681a
                public void cmB() {
                    if (c.this.hYa != null) {
                        c.this.hYa.cmB();
                    }
                }
            });
            aVar.show();
            this.hYc = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmJ() {
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hXQ.getActivity());
            } else if (this.bxd.user_info == null || JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hXQ.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.bxd.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hXQ.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.brE = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bxd.user_info));
                this.hXQ.finish();
            }
        }
    }

    private View ns(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hXQ.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery_hori, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hXQ.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery, (ViewGroup) null);
    }

    public View getRootView() {
        return this.mRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(View view) {
        ViewGroup viewGroup = (ViewGroup) view;
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            viewGroup.getChildAt(i).setVisibility(0);
        }
    }

    public void onResume() {
        if (this.mHandler != null) {
            this.mHandler.postDelayed(new Runnable() { // from class: com.baidu.tieba.ala.person.view.c.7
                @Override // java.lang.Runnable
                public void run() {
                    if (c.this.hdH == null) {
                        c.this.hdH = AnimationUtils.loadAnimation(c.this.hXQ.getActivity(), a.C0195a.sdk_push_up_in);
                    }
                    c.this.hXR.setAnimation(c.this.hdH);
                    c.this.hXR.setVisibility(0);
                    c.this.hXS.setVisibility(0);
                    c.this.hXZ.setVisibility(0);
                    c.this.hXY.setVisibility(0);
                    c.this.hdH.setDuration(300L);
                    c.this.hdH.start();
                    c.this.hdH.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (c.this.hXQ.isFinishing()) {
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (!c.this.hXQ.isFinishing()) {
                                c.this.cA(c.this.mRootView);
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationRepeat(Animation animation) {
                        }
                    });
                }
            }, 50L);
        }
    }

    public void onDestroy() {
        if (this.hXR != null) {
            this.hXR.clearAnimation();
        }
        if (this.hYc != null && this.hYc.isShowing()) {
            this.hYc.dismiss();
        }
    }

    public Animation bWH() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hdH != null) {
            this.hdH.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hXQ.getActivity(), a.C0195a.sdk_push_up_out);
        this.hXR.setAnimation(loadAnimation);
        this.hXR.setVisibility(8);
        loadAnimation.setDuration(300L);
        loadAnimation.start();
        return loadAnimation;
    }

    public void bkp() {
        if (this.hYc != null && this.hYc.isShowing()) {
            this.hYc.resize();
        }
    }

    public void E(String str, String str2, String str3) {
        this.buN = JavaTypesHelper.toLong(str, 0L);
        this.goZ = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
        this.hXT.setText(str3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hXW) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hXQ, this.bxd}));
        }
    }
}
