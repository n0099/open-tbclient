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
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.c.o;
import com.baidu.live.data.r;
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
    private HeadImageView arv;
    private String awo;
    private FrameLayout bbO;
    private TextView cbK;
    private View egF;
    private TextView eiA;
    private TextView eiB;
    private ImageView eiC;
    private FrameLayout eiD;
    private ImageView eiE;
    private f eiF;
    private String eiG;
    private ValueAnimator eiH;
    private ValueAnimator eiI;
    private FrameLayout.LayoutParams eiJ;
    private com.baidu.tieba.ala.data.b eiK;
    private i eiL;
    private boolean eiM;
    private boolean eiN;
    private long eiO;
    private int eiQ;
    private View eiu;
    private View eiv;
    private FrameLayout eiw;
    private FrameLayout eix;
    private FrameLayout eiy;
    private RoundProgressBar eiz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int eiP = 2;
    private CustomMessageListener eij = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener eiR = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.eiG)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.eiw.setVisibility(8);
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
    private f.a eiS = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
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
    private CustomMessageListener eiT = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.eiO = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.cC(AlaSnatchRedPacketActivity.this.eiO);
                if (AlaSnatchRedPacketActivity.this.eiO < 1) {
                    AlaSnatchRedPacketActivity.this.bbL();
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
        this.eiF = new f(getPageContext(), this.eiS);
        this.eiF.af(this.mRedPacketId, this.mLiveId, this.awo);
        MessageManager.getInstance().registerListener(this.eij);
        MessageManager.getInstance().registerListener(this.eiR);
        MessageManager.getInstance().registerListener(this.eiT);
        this.eiJ = new FrameLayout.LayoutParams(-1, -1);
        hN(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.awo = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.egF = findViewById(a.g.rp_root_bg);
        this.egF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bbO = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.arv = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.arv.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.arv.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.arv.setIsRound(true);
        this.arv.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.arv.setAutoChangeStyle(true);
        this.arv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cbK = (TextView) findViewById(a.g.rp_user_name);
        this.eiw = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.eiw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bbN();
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
        this.eiv = findViewById(a.g.rp_normal_bg);
        this.eiu = findViewById(a.g.rp_condition_guide_bg);
        this.eix = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.eiL = iVar;
        if (iVar.bel()) {
            this.eiQ = 101;
        } else {
            this.eiQ = 100;
        }
        bbJ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.ezk != null) {
            this.mContentView.setVisibility(0);
            this.eiK = bVar;
            this.eiG = this.eiK.ezl.ezs;
            if (!StringUtils.isNullObject(bVar.ezk.portrait)) {
                k.a(this.arv, bVar.ezk.portrait, true, false);
            }
            this.cbK.setText(bVar.ezk.userName);
            if (bVar.beo()) {
                this.eiw.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.eiG) : true;
                if (this.eiK.ezl.ezt || equals) {
                    this.eiw.setVisibility(8);
                } else {
                    this.eiw.setVisibility(0);
                }
            }
            if (this.eiK.bel()) {
                this.eiP = 3;
            } else if (this.eiK.isValid()) {
                if (bVar.ben()) {
                    this.eiP = 1;
                    this.eiw.setVisibility(8);
                } else {
                    this.eiP = 2;
                }
            } else if (this.eiK.bei()) {
                this.eiP = 5;
            } else if (this.eiK.bej()) {
                this.eiP = 4;
            }
            bbI();
        }
    }

    private void bbI() {
        switch (this.eiP) {
            case 1:
                bbM();
                return;
            case 2:
                bbK();
                return;
            case 3:
                this.eiQ = 102;
                bbJ();
                return;
            case 4:
                this.eiQ = 103;
                bbJ();
                return;
            case 5:
                this.eiQ = 104;
                bbJ();
                return;
            default:
                return;
        }
    }

    private void bbJ() {
        String str;
        this.eiv.setVisibility(8);
        this.eiu.setVisibility(0);
        this.eix.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.eix.addView(inflate, this.eiJ);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.awo)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bbH();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.eiQ) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.eiQ == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eiL.bem())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eiK.bem())));
                return;
            default:
                return;
        }
    }

    private void bbK() {
        this.eiv.setVisibility(0);
        this.eiu.setVisibility(8);
        this.eix.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.eix.addView(inflate, this.eiJ);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.eiK.ezk.ezS)));
        this.eiD = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eiD.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.eiD.setLayoutParams(layoutParams);
        }
        this.eiE = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.eiE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.eiF.ag(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.awo);
            }
        });
        this.eiy = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.eiz = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.eiA = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.eiC = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.eiC.setVisibility(8);
        this.eiB = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.eiK.bek()) {
            this.eiE.setVisibility(0);
            this.eiy.setVisibility(8);
            bbO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbL() {
        bbP();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(long j) {
        String[] cG = this.eiK.cG(j);
        if (j <= 60) {
            if (!this.eiN) {
                this.eiN = true;
                this.eiC.setVisibility(8);
                this.eiB.setVisibility(8);
                this.eiA.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
            }
            this.eiA.setText(cG[1]);
        } else {
            if (this.eiC.getVisibility() != 0) {
                this.eiC.setVisibility(0);
            }
            this.eiA.setText(cG[0]);
            this.eiB.setText(cG[1]);
        }
        this.eiz.setProgress(this.eiK.cF(j));
    }

    private void bbM() {
        this.eiv.setVisibility(8);
        this.eiu.setVisibility(0);
        this.eix.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.eix.addView(inflate, this.eiJ);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.eiK.bep()) {
            this.eiM = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.eiK.beq()) {
            this.eiM = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.eiM) {
                    AlaSnatchRedPacketActivity.this.bbH();
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
    public void bbN() {
        String str = this.eiK.ezl.ezs;
        com.baidu.live.view.a.Bj().a(str, new com.baidu.live.data.b(this.eiK.ezk.portrait, str, true, getUniqueId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbH() {
        r rVar = new r();
        rVar.Yt = -1;
        rVar.Yu = -1;
        rVar.Yw = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, rVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbO() {
        this.eiI = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.eiI.setDuration(250L);
        this.eiI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.eiE.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.eiE.setScaleY(floatValue);
            }
        });
        this.eiI.setRepeatCount(-1);
        this.eiI.setRepeatMode(2);
        this.eiI.start();
    }

    private void bbP() {
        this.eiy.setVisibility(0);
        this.eiE.setVisibility(0);
        this.eiH = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.eiH.setDuration(500L);
        this.eiH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.eiy.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.eiE.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.eiy.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.eiy.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.eiE.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.eiE.setScaleY((float) (f + 0.5d));
            }
        });
        this.eiH.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bbO();
                AlaSnatchRedPacketActivity.this.eiy.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eiH.start();
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
            h.S(this.bbO);
            this.bbO.setScaleX(0.7f);
            this.bbO.setScaleY(0.7f);
            if (this.eiD != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eiD.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.eiD.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.T(this.bbO);
        this.bbO.setScaleX(1.0f);
        this.bbO.setScaleY(1.0f);
        if (this.eiD != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eiD.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.eiD.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eiF != null) {
            this.eiF.onDestroy();
        }
        if (this.eiI != null) {
            this.eiI.removeAllListeners();
            this.eiI.cancel();
            this.eiI = null;
        }
        if (this.eiH != null) {
            this.eiH.removeAllListeners();
            this.eiH.cancel();
            this.eiH = null;
        }
        MessageManager.getInstance().unRegisterListener(this.eiT);
        MessageManager.getInstance().unRegisterListener(this.eiR);
        MessageManager.getInstance().unRegisterListener(this.eij);
        super.onDestroy();
    }
}
