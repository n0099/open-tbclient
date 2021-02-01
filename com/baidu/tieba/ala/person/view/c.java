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
    private long goL;
    protected final PersonCardActivity hXC;
    private View hXD;
    private View hXE;
    private TextView hXF;
    private Button hXG;
    private Button hXH;
    private TextView hXI;
    private HeadImageView hXJ;
    private ImageView hXK;
    private View hXL;
    private a.InterfaceC0680a hXM;
    private boolean hXN;
    private com.baidu.tieba.ala.person.a hXO;
    private Animation hdt;
    private boolean isHost;
    private Handler mHandler = new Handler();
    protected View mRootView;
    private int screenWidth;
    private String uid;

    public c(final PersonCardActivity personCardActivity, boolean z) {
        this.hXC = personCardActivity;
        this.hXN = z;
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
            m.a(this.hXJ, str2, true, false);
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
            m.a(this.hXJ, personUserData.user_info.portrait, true, !StringUtils.isNull(personUserData.user_info.third_app_id));
            if (personUserData.user_info == null || JavaTypesHelper.toLong(personUserData.user_info.user_id, 0L) == 0 || (TbadkCoreApplication.getCurrentAccount() != null && TbadkCoreApplication.getCurrentAccount().equals(personUserData.user_info.user_id))) {
                this.hXI.setVisibility(8);
                this.hXH.setVisibility(8);
            } else if (this.hXC.Ii(TbadkCoreApplication.getCurrentAccount())) {
                this.hXH.setVisibility(8);
                this.hXI.setVisibility(0);
            } else if (personUserData.login_user_info != null && personUserData.login_user_info.is_live_admin == 1 && personUserData.user_info != null && personUserData.user_info.is_live_admin == 0) {
                this.hXI.setVisibility(0);
                this.hXH.setVisibility(0);
            } else {
                this.hXH.setVisibility(0);
                this.hXI.setVisibility(8);
            }
        }
    }

    private void initView() {
        this.hXD = this.mRootView.findViewById(a.f.mystery_person_card_frame);
        this.hXE = this.mRootView.findViewById(a.f.mystery_person_card_layout);
        this.aDM = (TextView) this.mRootView.findViewById(a.f.person_card_user_name);
        this.hXI = (TextView) this.mRootView.findViewById(a.f.ala_user_manage);
        this.hXG = (Button) this.mRootView.findViewById(a.f.person_card_at_button);
        this.hXK = (ImageView) this.mRootView.findViewById(a.f.card_decoration);
        this.hXL = this.mRootView.findViewById(a.f.user_portrait_layout);
        this.hXG.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cmC();
            }
        });
        this.hXH = (Button) this.mRootView.findViewById(a.f.mystery_person_card_report_btn);
        this.hXJ = (HeadImageView) this.mRootView.findViewById(a.f.user_portrait);
        this.hXF = (TextView) this.mRootView.findViewById(a.f.mysterious_text);
        this.hXJ.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.hXJ.setDefaultErrorResource(a.e.sdk_icon_default_avatar100);
        this.hXJ.setIsRound(true);
        this.hXJ.setAutoChangeStyle(false);
        this.hXJ.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.hXJ.setBorderWidth(BdUtilHelper.getDimens(this.hXC.getPageContext().getPageActivity(), a.d.sdk_ds4));
        this.hXH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                c.this.cmH();
            }
        });
        this.hXJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.person.view.c.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
            }
        });
    }

    private void initListener() {
        a(new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.person.view.c.5
            @Override // com.baidu.tieba.ala.person.a.InterfaceC0680a
            public void cmu() {
                c.this.hXC.cmp();
            }
        });
        this.hXI.setOnClickListener(this);
    }

    public void a(a.InterfaceC0680a interfaceC0680a) {
        this.hXM = interfaceC0680a;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmH() {
        if (!TbadkCoreApplication.isLogin()) {
            ViewHelper.skipToLoginActivity(this.hXC.getActivity());
            this.hXC.finish();
        } else if (this.bxd != null && this.bxd.user_info != null && this.bxd.user_info.live_status == 1) {
            g gVar = new g(this.hXC);
            gVar.a(this.buN, this.goL, JavaTypesHelper.toLong(this.uid, 0L), this.isHost, this.bxd.isLandScapeLive());
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, gVar));
            this.hXC.finish();
        } else {
            if (this.hXO != null && this.hXO.isShowing()) {
                this.hXO.dismiss();
            }
            com.baidu.tieba.ala.person.a aVar = new com.baidu.tieba.ala.person.a(this.hXC.getActivity(), true);
            aVar.a(new a.InterfaceC0680a() { // from class: com.baidu.tieba.ala.person.view.c.6
                @Override // com.baidu.tieba.ala.person.a.InterfaceC0680a
                public void cmu() {
                    if (c.this.hXM != null) {
                        c.this.hXM.cmu();
                    }
                }
            });
            aVar.show();
            this.hXO = aVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cmC() {
        if (this.bxd != null) {
            if (!TbadkCoreApplication.isLogin()) {
                ViewHelper.skipToLoginActivity(this.hXC.getActivity());
            } else if (this.bxd.user_info == null || JavaTypesHelper.toLong(this.bxd.user_info.user_id, 0L) == 0) {
                BdUtilHelper.showToast(this.hXC.getActivity(), a.h.ala_cannot_reply_tourist);
            } else if (this.bxd.user_info.user_id.equals(TbadkCoreApplication.getCurrentAccount())) {
                BdUtilHelper.showToast(this.hXC.getActivity(), a.h.ala_cannot_reply_self);
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913054));
                com.baidu.live.liveroom.d.c cVar = new com.baidu.live.liveroom.d.c();
                cVar.brE = (short) 1;
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913047, cVar));
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913012, this.bxd.user_info));
                this.hXC.finish();
            }
        }
    }

    private View ns(boolean z) {
        if (z) {
            return LayoutInflater.from(this.hXC.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery_hori, (ViewGroup) null);
        }
        return LayoutInflater.from(this.hXC.getPageContext().getPageActivity()).inflate(a.g.ala_view_person_card_mystery, (ViewGroup) null);
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
                    if (c.this.hdt == null) {
                        c.this.hdt = AnimationUtils.loadAnimation(c.this.hXC.getActivity(), a.C0195a.sdk_push_up_in);
                    }
                    c.this.hXD.setAnimation(c.this.hdt);
                    c.this.hXD.setVisibility(0);
                    c.this.hXE.setVisibility(0);
                    c.this.hXL.setVisibility(0);
                    c.this.hXK.setVisibility(0);
                    c.this.hdt.setDuration(300L);
                    c.this.hdt.start();
                    c.this.hdt.setAnimationListener(new Animation.AnimationListener() { // from class: com.baidu.tieba.ala.person.view.c.7.1
                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationStart(Animation animation) {
                            if (c.this.hXC.isFinishing()) {
                            }
                        }

                        @Override // android.view.animation.Animation.AnimationListener
                        public void onAnimationEnd(Animation animation) {
                            if (!c.this.hXC.isFinishing()) {
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
        if (this.hXD != null) {
            this.hXD.clearAnimation();
        }
        if (this.hXO != null && this.hXO.isShowing()) {
            this.hXO.dismiss();
        }
    }

    public Animation bWA() {
        this.mHandler.removeCallbacksAndMessages(null);
        this.mHandler = null;
        if (this.hdt != null) {
            this.hdt.cancel();
        }
        Animation loadAnimation = AnimationUtils.loadAnimation(this.hXC.getActivity(), a.C0195a.sdk_push_up_out);
        this.hXD.setAnimation(loadAnimation);
        this.hXD.setVisibility(8);
        loadAnimation.setDuration(300L);
        loadAnimation.start();
        return loadAnimation;
    }

    public void bkp() {
        if (this.hXO != null && this.hXO.isShowing()) {
            this.hXO.resize();
        }
    }

    public void E(String str, String str2, String str3) {
        this.buN = JavaTypesHelper.toLong(str, 0L);
        this.goL = JavaTypesHelper.toLong(str2, 0L);
        this.isHost = !StringUtils.isNull(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str2);
        this.hXF.setText(str3);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hXI) {
            TiebaInitialize.log("c12266");
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913025, new Object[]{this.hXC, this.bxd}));
        }
    }
}
