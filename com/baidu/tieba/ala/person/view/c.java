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
/* loaded from: classes10.dex */
public class c implements View.OnClickListener {
    private TextView aFm;
    private long bwn;
    private PersonUserData byD;
    private long gqI;
    private View hZA;
    private View hZB;
    private TextView hZC;
    private Button hZD;
    private Button hZE;
    private TextView hZF;
    private HeadImageView hZG;
    private ImageView hZH;
    private View hZI;
    private a.InterfaceC0687a hZJ;
    private boolean hZK;
    private com.baidu.tieba.ala.person.a hZL;
    protected final PersonCardActivity hZz;
    private Animation hfq;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private int screenWidth;
    private String uid;

    public c(final PersonCardActivity personCardActivity, boolean z) {
        this.hZz = personCardActivity;
        this.hZK = z;
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
            this.aFm.setText(str);
            m.a(this.hZG, str2, true, false);
        }
    }

    public void d(PersonUserData personUserData) {
        this.byD = personUserData;
        ax axVar = personUserData.user_info;
        if (axVar != null) {
            if (!StringUtils.isNull(axVar.getNameShow())) {
                String nameShow = axVar.getNameShow();
                if (TextHelper.getTextLengthWithEmoji(nameShow) > 20) {
                    nameShow = TextHelper.subStringWithEmoji(nameShow, 20) + StringHelper.STRING_MORE;
                }
                this.aFm.setText(nameShow);
            }
            m.a(this.hZG, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hZF.setVisibility(8);
                this.hZE.setVisibility(8);
            } else if (this.hZz.Is(TbadkCoreApplication.getCurrentAccount())) {
                this.hZE.setVisibility(8);
                this.hZF.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hZF.setVisibility(0);
                this.hZE.setVisibility(0);
            } else {
                this.hZE.setVisibility(0);
                this.hZF.setVisibility(8);
            }
        }
    }

    private void initView() {
        this.hZA = this.mRootView.findViewById(a.f.mystery_person_card_frame);
        this.hZB = this.mRootView.findViewById(a.f.mystery_person_card_layout);
        this.aFm = (TextView) this.mRootView.findViewById(a.f.person_card_user_name);
        this.hZF = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hZD = (Button) this.mRootView.findViewById(a.f.person_card_at_button);
        this.hZH = (ImageView) this.mRootView.findViewById(a.f.card_decoration);
        this.hZI = this.mRootView.findViewById(a.f.user_portrait_layout);
        this.hZD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cmP();
            }
        });
        this.hZE = (Button) this.mRootView.findViewById(a.f.mystery_person_card_report_btn);
        this.hZG = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hZC = (TextView) this.mRootView.findViewById(a.f.mysterious_text);
        this.hZG.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hZG.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hZG.setIsRound(true);
        this.hZG.setAutoChangeStyle(false);
        this.hZG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hZG.setBorderWidth(BdUtilHelper.getDimens(this.hZz.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hZE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cmU();
            }
        });
        this.hZG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void initListener() {
        a(new a.InterfaceC0687a() { // from class: com.baidu.tieba.ala.person.view.c.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0687a
            public void cmH() {
                c.this.hZz.cmC();
            }
        });
        this.hZF.setOnClickListener(this);
    }

    public void a(a.InterfaceC0687a interfaceC0687a) {
        this.hZJ = interfaceC0687a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmU() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hZz.getActivity());
            this.hZz.finish();
        } else if (this.byD != null && this.byD.user_info != null && this.byD.user_info.live_status == 1) {
            g gVar = new g(this.hZz);
            gVar.a(this.bwn, this.gqI, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.byD.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hZz.finish();
        } else {
            if (this.hZL != null && this.hZL.isShowing()) {
                this.hZL.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hZz.getActivity(), true);
            aVar.a(new a.InterfaceC0687a() { // from class: com.baidu.tieba.ala.person.view.c.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0687a
                public void cmH() {
                    if (c.this.hZJ != null) {
                        c.this.hZJ.cmH();
                    }
                }
            });
            aVar.show();
            this.hZL = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmP() {
        if (this.byD != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hZz.getActivity());
            } else if (this.byD.user_info == null || JavaTypesHelper.toLong(this.byD.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hZz.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.byD.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hZz.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.bte = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.byD.user_info));
                this.hZz.finish();
            }
        }
    }

    private View ns(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hZz.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery_hori, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hZz.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery, (ViewGroup) null);
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
                    if (c.this.hfq == null) {
                        c.this.hfq = AnimationUtils.loadAnimation(c.this.hZz.getActivity(), a.C0201a.sdk_push_up_in);
                    }
                    c.this.hZA.setAnimation(c.this.hfq);
                    c.this.hZA.setVisibility(0);
                    c.this.hZB.setVisibility(0);
                    c.this.hZI.setVisibility(0);
                    c.this.hZH.setVisibility(0);
                    c.this.hfq.setDuration(300L);
                    c.this.hfq.start();
                    c.this.hfq.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (c.this.hZz.isFinishing()) {
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (!c.this.hZz.isFinishing()) {
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
        if (this.hZA != null) {
            this.hZA.clearAnimation();
        }
        if (this.hZL != null && this.hZL.isShowing()) {
            this.hZL.dismiss();
        }
    }

    public Animation bWN() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hfq != null) {
            this.hfq.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hZz.getActivity(), a.C0201a.sdk_push_up_out);
        this.hZA.setAnimation(loadAnimation);
        this.hZA.setVisibility(8);
        loadAnimation.setDuration(300L);
        loadAnimation.start();
        return loadAnimation;
    }

    public void bkr() {
        if (this.hZL != null && this.hZL.isShowing()) {
            this.hZL.resize();
        }
    }

    public void E(String str, String str2, String str3) {
        this.bwn = JavaTypesHelper.toLong(str, 0L);
        this.gqI = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
        this.hZC.setText(str3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hZF) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hZz, this.byD}));
        }
    }
}
