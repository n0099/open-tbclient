package com.baidu.tieba.ala;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.c.o;
import com.baidu.live.data.r;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.u.a;
import com.baidu.live.utils.h;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.i;
import com.baidu.tieba.ala.e.f;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes3.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView arw;
    private String awp;
    private FrameLayout bbP;
    private TextView cbL;
    private View egS;
    private View eiH;
    private View eiI;
    private FrameLayout eiJ;
    private FrameLayout eiK;
    private FrameLayout eiL;
    private RoundProgressBar eiM;
    private TextView eiN;
    private TextView eiO;
    private ImageView eiP;
    private FrameLayout eiQ;
    private ImageView eiR;
    private f eiS;
    private String eiT;
    private ValueAnimator eiU;
    private ValueAnimator eiV;
    private FrameLayout.LayoutParams eiW;
    private com.baidu.tieba.ala.data.b eiX;
    private i eiY;
    private boolean eiZ;
    private boolean eja;
    private long ejb;
    private int ejd;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int ejc = 2;
    private CustomMessageListener eiw = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener eje = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.eiT)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.eiJ.setVisibility(8);
                            return;
                        }
                        AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_unfollow_success_toast));
                        return;
                    }
                    AlaSnatchRedPacketActivity.this.showToast(a.i.follow_failed_tip);
                }
            }
        }
    };
    private f.a ejf = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        @Override // com.baidu.tieba.ala.e.f.a
        public void b(com.baidu.tieba.ala.data.b bVar) {
            AlaSnatchRedPacketActivity.this.a(bVar);
        }

        @Override // com.baidu.tieba.ala.e.f.a
        public void ae(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.e.f.a
        public void b(i iVar) {
            AlaSnatchRedPacketActivity.this.a(iVar);
        }

        @Override // com.baidu.tieba.ala.e.f.a
        public void af(int i, String str) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener ejg = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.ejb = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.cC(AlaSnatchRedPacketActivity.this.ejb);
                if (AlaSnatchRedPacketActivity.this.ejb < 1) {
                    AlaSnatchRedPacketActivity.this.bbM();
                }
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.support.v4.app.SupportActivity, android.app.Activity
    public void onCreate(Bundle bundle) {
        setIsAddSwipeBackLayout(false);
        setUseStyleImmersiveSticky(true);
        super.onCreate(bundle);
        if (BdBaseApplication.getInst() == null) {
            if (TbConfig.sdkInitCallback == null) {
                super.finish();
                return;
            }
            TbConfig.sdkInitCallback.initSdk();
        }
        if (getIntent() == null) {
            finish();
            return;
        }
        parserIntent();
        if (StringUtils.isNullObject(this.mRedPacketId)) {
            finish();
            return;
        }
        String str = Build.DISPLAY;
        if (str != null && str.contains("Flyme")) {
            getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.d.sdk_transparent)));
        }
        setContentView(a.h.ala_snatch_red_packet_view);
        initView();
        this.eiS = new f(getPageContext(), this.ejf);
        this.eiS.af(this.mRedPacketId, this.mLiveId, this.awp);
        MessageManager.getInstance().registerListener(this.eiw);
        MessageManager.getInstance().registerListener(this.eje);
        MessageManager.getInstance().registerListener(this.ejg);
        this.eiW = new FrameLayout.LayoutParams(-1, -1);
        hN(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.awp = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.egS = findViewById(a.g.rp_root_bg);
        this.egS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bbP = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.arw = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.arw.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.arw.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.arw.setIsRound(true);
        this.arw.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.arw.setAutoChangeStyle(true);
        this.arw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cbL = (TextView) findViewById(a.g.rp_user_name);
        this.eiJ = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.eiJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bbO();
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.g.rp_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.eiI = findViewById(a.g.rp_normal_bg);
        this.eiH = findViewById(a.g.rp_condition_guide_bg);
        this.eiK = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.eiY = iVar;
        if (iVar.bem()) {
            this.ejd = 101;
        } else {
            this.ejd = 100;
        }
        bbK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.ezx != null) {
            this.mContentView.setVisibility(0);
            this.eiX = bVar;
            this.eiT = this.eiX.ezy.ezF;
            if (!StringUtils.isNullObject(bVar.ezx.portrait)) {
                k.a(this.arw, bVar.ezx.portrait, true, false);
            }
            this.cbL.setText(bVar.ezx.userName);
            if (bVar.bep()) {
                this.eiJ.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.eiT) : true;
                if (this.eiX.ezy.ezG || equals) {
                    this.eiJ.setVisibility(8);
                } else {
                    this.eiJ.setVisibility(0);
                }
            }
            if (this.eiX.bem()) {
                this.ejc = 3;
            } else if (this.eiX.isValid()) {
                if (bVar.beo()) {
                    this.ejc = 1;
                    this.eiJ.setVisibility(8);
                } else {
                    this.ejc = 2;
                }
            } else if (this.eiX.bej()) {
                this.ejc = 5;
            } else if (this.eiX.bek()) {
                this.ejc = 4;
            }
            bbJ();
        }
    }

    private void bbJ() {
        switch (this.ejc) {
            case 1:
                bbN();
                return;
            case 2:
                bbL();
                return;
            case 3:
                this.ejd = 102;
                bbK();
                return;
            case 4:
                this.ejd = 103;
                bbK();
                return;
            case 5:
                this.ejd = 104;
                bbK();
                return;
            default:
                return;
        }
    }

    private void bbK() {
        String str;
        this.eiI.setVisibility(8);
        this.eiH.setVisibility(0);
        this.eiK.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.eiK.addView(inflate, this.eiW);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.awp)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bbI();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.ejd) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.ejd == 103) {
                    String string = getResources().getString(a.i.snatch_red_packet_failed_4);
                    textView.setVisibility(8);
                    str = string;
                } else {
                    String string2 = getResources().getString(a.i.snatch_red_packet_failed_2);
                    textView.setVisibility(0);
                    str = string2;
                }
                textView3.setText(str);
                return;
            case 101:
                textView2.setVisibility(0);
                ((LinearLayout) inflate.findViewById(a.g.rp_snatch_succ_layout)).setVisibility(0);
                TextView textView4 = (TextView) inflate.findViewById(a.g.rp_snatch_amount);
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eiY.ben())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eiX.ben())));
                return;
            default:
                return;
        }
    }

    private void bbL() {
        this.eiI.setVisibility(0);
        this.eiH.setVisibility(8);
        this.eiK.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.eiK.addView(inflate, this.eiW);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.eiX.ezx.eAf)));
        this.eiQ = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eiQ.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.eiQ.setLayoutParams(layoutParams);
        }
        this.eiR = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.eiR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.eiS.ag(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.awp);
            }
        });
        this.eiL = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.eiM = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.eiN = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.eiP = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.eiP.setVisibility(8);
        this.eiO = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.eiX.bel()) {
            this.eiR.setVisibility(0);
            this.eiL.setVisibility(8);
            bbP();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbM() {
        bbQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(long j) {
        if (this.eiX != null) {
            String[] cG = this.eiX.cG(j);
            if (j <= 60) {
                if (!this.eja) {
                    this.eja = true;
                    this.eiP.setVisibility(8);
                    this.eiO.setVisibility(8);
                    this.eiN.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                }
                this.eiN.setText(cG[1]);
            } else {
                if (this.eiP.getVisibility() != 0) {
                    this.eiP.setVisibility(0);
                }
                this.eiN.setText(cG[0]);
                this.eiO.setText(cG[1]);
            }
            this.eiM.setProgress(this.eiX.cF(j));
        }
    }

    private void bbN() {
        this.eiI.setVisibility(8);
        this.eiH.setVisibility(0);
        this.eiK.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.eiK.addView(inflate, this.eiW);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.eiX.beq()) {
            this.eiZ = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.eiX.ber()) {
            this.eiZ = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.eiZ) {
                    AlaSnatchRedPacketActivity.this.bbI();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.aGt();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGt() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbO() {
        String str = this.eiX.ezy.ezF;
        com.baidu.live.view.a.Bj().a(str, new com.baidu.live.data.b(this.eiX.ezx.portrait, str, true, getUniqueId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbI() {
        r rVar = new r();
        rVar.Yt = -1;
        rVar.Yu = -1;
        rVar.Yw = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, rVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbP() {
        this.eiV = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.eiV.setDuration(250L);
        this.eiV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.eiR.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.eiR.setScaleY(floatValue);
            }
        });
        this.eiV.setRepeatCount(-1);
        this.eiV.setRepeatMode(2);
        this.eiV.start();
    }

    private void bbQ() {
        this.eiL.setVisibility(0);
        this.eiR.setVisibility(0);
        this.eiU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.eiU.setDuration(500L);
        this.eiU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.eiL.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.eiR.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.eiL.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.eiL.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.eiR.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.eiR.setScaleY((float) (f + 0.5d));
            }
        });
        this.eiU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bbP();
                AlaSnatchRedPacketActivity.this.eiL.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eiU.start();
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void enterExitAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    public void closeAnimation() {
        overridePendingTransition(0, 0);
    }

    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity
    protected void onChangeSkinType(int i) {
    }

    @Override // android.support.v4.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        hN(configuration.orientation == 2);
    }

    private void hN(boolean z) {
        if (z) {
            h.S(this.bbP);
            this.bbP.setScaleX(0.7f);
            this.bbP.setScaleY(0.7f);
            if (this.eiQ != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eiQ.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.eiQ.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.T(this.bbP);
        this.bbP.setScaleX(1.0f);
        this.bbP.setScaleY(1.0f);
        if (this.eiQ != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eiQ.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.eiQ.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eiS != null) {
            this.eiS.onDestroy();
        }
        if (this.eiV != null) {
            this.eiV.removeAllListeners();
            this.eiV.cancel();
            this.eiV = null;
        }
        if (this.eiU != null) {
            this.eiU.removeAllListeners();
            this.eiU.cancel();
            this.eiU = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ejg);
        MessageManager.getInstance().unRegisterListener(this.eje);
        MessageManager.getInstance().unRegisterListener(this.eiw);
        super.onDestroy();
    }
}
