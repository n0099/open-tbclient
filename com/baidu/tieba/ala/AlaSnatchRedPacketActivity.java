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
    private String awn;
    private FrameLayout bbN;
    private TextView cbJ;
    private View egE;
    private TextView eiA;
    private ImageView eiB;
    private FrameLayout eiC;
    private ImageView eiD;
    private f eiE;
    private String eiF;
    private ValueAnimator eiG;
    private ValueAnimator eiH;
    private FrameLayout.LayoutParams eiI;
    private com.baidu.tieba.ala.data.b eiJ;
    private i eiK;
    private boolean eiL;
    private boolean eiM;
    private long eiN;
    private int eiP;
    private View eit;
    private View eiu;
    private FrameLayout eiv;
    private FrameLayout eiw;
    private FrameLayout eix;
    private RoundProgressBar eiy;
    private TextView eiz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int eiO = 2;
    private CustomMessageListener eii = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener eiQ = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.eiF)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.eiv.setVisibility(8);
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
    private f.a eiR = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
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
    private CustomMessageListener eiS = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.eiN = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.cC(AlaSnatchRedPacketActivity.this.eiN);
                if (AlaSnatchRedPacketActivity.this.eiN < 1) {
                    AlaSnatchRedPacketActivity.this.bbJ();
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
        this.eiE = new f(getPageContext(), this.eiR);
        this.eiE.af(this.mRedPacketId, this.mLiveId, this.awn);
        MessageManager.getInstance().registerListener(this.eii);
        MessageManager.getInstance().registerListener(this.eiQ);
        MessageManager.getInstance().registerListener(this.eiS);
        this.eiI = new FrameLayout.LayoutParams(-1, -1);
        hN(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.awn = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.egE = findViewById(a.g.rp_root_bg);
        this.egE.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bbN = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.arv = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.arv.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.arv.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.arv.setIsRound(true);
        this.arv.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.arv.setAutoChangeStyle(true);
        this.arv.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cbJ = (TextView) findViewById(a.g.rp_user_name);
        this.eiv = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.eiv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bbL();
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
        this.eiu = findViewById(a.g.rp_normal_bg);
        this.eit = findViewById(a.g.rp_condition_guide_bg);
        this.eiw = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.eiK = iVar;
        if (iVar.bej()) {
            this.eiP = 101;
        } else {
            this.eiP = 100;
        }
        bbH();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.ezj != null) {
            this.mContentView.setVisibility(0);
            this.eiJ = bVar;
            this.eiF = this.eiJ.ezk.ezr;
            if (!StringUtils.isNullObject(bVar.ezj.portrait)) {
                k.a(this.arv, bVar.ezj.portrait, true, false);
            }
            this.cbJ.setText(bVar.ezj.userName);
            if (bVar.bem()) {
                this.eiv.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.eiF) : true;
                if (this.eiJ.ezk.ezs || equals) {
                    this.eiv.setVisibility(8);
                } else {
                    this.eiv.setVisibility(0);
                }
            }
            if (this.eiJ.bej()) {
                this.eiO = 3;
            } else if (this.eiJ.isValid()) {
                if (bVar.bel()) {
                    this.eiO = 1;
                    this.eiv.setVisibility(8);
                } else {
                    this.eiO = 2;
                }
            } else if (this.eiJ.beg()) {
                this.eiO = 5;
            } else if (this.eiJ.beh()) {
                this.eiO = 4;
            }
            bbG();
        }
    }

    private void bbG() {
        switch (this.eiO) {
            case 1:
                bbK();
                return;
            case 2:
                bbI();
                return;
            case 3:
                this.eiP = 102;
                bbH();
                return;
            case 4:
                this.eiP = 103;
                bbH();
                return;
            case 5:
                this.eiP = 104;
                bbH();
                return;
            default:
                return;
        }
    }

    private void bbH() {
        String str;
        this.eiu.setVisibility(8);
        this.eit.setVisibility(0);
        this.eiw.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.eiw.addView(inflate, this.eiI);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.awn)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bbF();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.eiP) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.eiP == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eiK.bek())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.eiJ.bek())));
                return;
            default:
                return;
        }
    }

    private void bbI() {
        this.eiu.setVisibility(0);
        this.eit.setVisibility(8);
        this.eiw.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.eiw.addView(inflate, this.eiI);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.eiJ.ezj.ezR)));
        this.eiC = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eiC.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.eiC.setLayoutParams(layoutParams);
        }
        this.eiD = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.eiD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.eiE.ag(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.awn);
            }
        });
        this.eix = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.eiy = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.eiz = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.eiB = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.eiB.setVisibility(8);
        this.eiA = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.eiJ.bei()) {
            this.eiD.setVisibility(0);
            this.eix.setVisibility(8);
            bbM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbJ() {
        bbN();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(long j) {
        String[] cG = this.eiJ.cG(j);
        if (j <= 60) {
            if (!this.eiM) {
                this.eiM = true;
                this.eiB.setVisibility(8);
                this.eiA.setVisibility(8);
                this.eiz.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
            }
            this.eiz.setText(cG[1]);
        } else {
            if (this.eiB.getVisibility() != 0) {
                this.eiB.setVisibility(0);
            }
            this.eiz.setText(cG[0]);
            this.eiA.setText(cG[1]);
        }
        this.eiy.setProgress(this.eiJ.cF(j));
    }

    private void bbK() {
        this.eiu.setVisibility(8);
        this.eit.setVisibility(0);
        this.eiw.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.eiw.addView(inflate, this.eiI);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.eiJ.ben()) {
            this.eiL = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.eiJ.beo()) {
            this.eiL = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.eiL) {
                    AlaSnatchRedPacketActivity.this.bbF();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.aGr();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGr() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbL() {
        String str = this.eiJ.ezk.ezr;
        com.baidu.live.view.a.Bh().a(str, new com.baidu.live.data.b(this.eiJ.ezj.portrait, str, true, getUniqueId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbF() {
        r rVar = new r();
        rVar.Yt = -1;
        rVar.Yu = -1;
        rVar.Yw = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, rVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbM() {
        this.eiH = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.eiH.setDuration(250L);
        this.eiH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.eiD.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.eiD.setScaleY(floatValue);
            }
        });
        this.eiH.setRepeatCount(-1);
        this.eiH.setRepeatMode(2);
        this.eiH.start();
    }

    private void bbN() {
        this.eix.setVisibility(0);
        this.eiD.setVisibility(0);
        this.eiG = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.eiG.setDuration(500L);
        this.eiG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.eix.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.eiD.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.eix.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.eix.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.eiD.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.eiD.setScaleY((float) (f + 0.5d));
            }
        });
        this.eiG.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bbM();
                AlaSnatchRedPacketActivity.this.eix.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.eiG.start();
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
            h.S(this.bbN);
            this.bbN.setScaleX(0.7f);
            this.bbN.setScaleY(0.7f);
            if (this.eiC != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.eiC.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.eiC.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.T(this.bbN);
        this.bbN.setScaleX(1.0f);
        this.bbN.setScaleY(1.0f);
        if (this.eiC != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.eiC.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.eiC.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eiE != null) {
            this.eiE.onDestroy();
        }
        if (this.eiH != null) {
            this.eiH.removeAllListeners();
            this.eiH.cancel();
            this.eiH = null;
        }
        if (this.eiG != null) {
            this.eiG.removeAllListeners();
            this.eiG.cancel();
            this.eiG = null;
        }
        MessageManager.getInstance().unRegisterListener(this.eiS);
        MessageManager.getInstance().unRegisterListener(this.eiQ);
        MessageManager.getInstance().unRegisterListener(this.eii);
        super.onDestroy();
    }
}
