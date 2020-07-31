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
import com.baidu.live.c.q;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.utils.h;
import com.baidu.live.utils.k;
import com.baidu.tieba.ala.data.j;
import com.baidu.tieba.ala.f.g;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes4.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView aUw;
    private String aYY;
    private FrameLayout bNL;
    private TextView dKI;
    private View fiP;
    private View fkJ;
    private View fkK;
    private FrameLayout fkL;
    private FrameLayout fkM;
    private FrameLayout fkN;
    private RoundProgressBar fkO;
    private TextView fkP;
    private TextView fkQ;
    private ImageView fkR;
    private FrameLayout fkS;
    private ImageView fkT;
    private g fkU;
    private String fkV;
    private ValueAnimator fkW;
    private ValueAnimator fkX;
    private FrameLayout.LayoutParams fkY;
    private com.baidu.tieba.ala.data.c fkZ;
    private j fla;
    private boolean flb;
    private boolean flc;
    private long fld;
    private int flf;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int fle = 2;
    private CustomMessageListener fkB = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener flg = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.fkV)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.fkL.setVisibility(8);
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
    private g.a flh = new g.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        @Override // com.baidu.tieba.ala.f.g.a
        public void b(com.baidu.tieba.ala.data.c cVar) {
            AlaSnatchRedPacketActivity.this.a(cVar);
        }

        @Override // com.baidu.tieba.ala.f.g.a
        public void aC(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.f.g.a
        public void b(j jVar) {
            AlaSnatchRedPacketActivity.this.fkT.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(jVar);
        }

        @Override // com.baidu.tieba.ala.f.g.a
        public void aD(int i, String str) {
            AlaSnatchRedPacketActivity.this.fkT.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener fli = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.fld = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dB(AlaSnatchRedPacketActivity.this.fld);
                if (AlaSnatchRedPacketActivity.this.fld < 1) {
                    AlaSnatchRedPacketActivity.this.buU();
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
        if (!isFinishing()) {
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
            this.fkU = new g(getPageContext(), this.flh);
            this.fkU.ak(this.mRedPacketId, this.mLiveId, this.aYY);
            MessageManager.getInstance().registerListener(this.fkB);
            MessageManager.getInstance().registerListener(this.flg);
            MessageManager.getInstance().registerListener(this.fli);
            this.fkY = new FrameLayout.LayoutParams(-1, -1);
            jU(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aYY = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fiP = findViewById(a.g.rp_root_bg);
        this.fiP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bNL = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.aUw = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.aUw.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aUw.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aUw.setIsRound(true);
        this.aUw.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aUw.setAutoChangeStyle(true);
        this.aUw.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dKI = (TextView) findViewById(a.g.rp_user_name);
        this.fkL = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.fkL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.buW();
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
        this.fkK = findViewById(a.g.rp_normal_bg);
        this.fkJ = findViewById(a.g.rp_condition_guide_bg);
        this.fkM = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(j jVar) {
        this.fla = jVar;
        if (jVar.bzL()) {
            this.flf = 101;
        } else {
            this.flf = 100;
        }
        buS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.fIO != null) {
            this.mContentView.setVisibility(0);
            this.fkZ = cVar;
            this.fkV = this.fkZ.fIP.fIW;
            if (!StringUtils.isNullObject(cVar.fIO.portrait)) {
                k.a(this.aUw, cVar.fIO.portrait, true, false);
            }
            this.dKI.setText(cVar.fIO.userName);
            if (!cVar.bzO()) {
                this.fkL.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.fkV) : true;
                if (this.fkZ.fIP.fIX || equals) {
                    this.fkL.setVisibility(8);
                } else {
                    this.fkL.setVisibility(0);
                }
            }
            if (this.fkZ.bzL()) {
                this.fle = 3;
            } else if (this.fkZ.isValid()) {
                if (cVar.bzN()) {
                    this.fle = 1;
                    this.fkL.setVisibility(8);
                } else {
                    this.fle = 2;
                }
            } else if (this.fkZ.bzI()) {
                this.fle = 5;
            } else if (this.fkZ.bzJ()) {
                this.fle = 4;
            }
            buR();
        }
    }

    private void buR() {
        switch (this.fle) {
            case 1:
                buV();
                return;
            case 2:
                buT();
                return;
            case 3:
                this.flf = 102;
                buS();
                return;
            case 4:
                this.flf = 103;
                buS();
                return;
            case 5:
                this.flf = 104;
                buS();
                return;
            default:
                return;
        }
    }

    private void buS() {
        String str;
        this.fkK.setVisibility(8);
        this.fkJ.setVisibility(0);
        this.fkM.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.fkM.addView(inflate, this.fkY);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new q(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aYY)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.buQ();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.flf) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.flf == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fla.bzM())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.fkZ.bzM())));
                return;
            default:
                return;
        }
    }

    private void buT() {
        this.fkK.setVisibility(0);
        this.fkJ.setVisibility(8);
        this.fkM.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.fkM.addView(inflate, this.fkY);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.fkZ.fIO.fJv)));
        this.fkS = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fkS.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.fkS.setLayoutParams(layoutParams);
        }
        this.fkT = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.fkT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.fkT.setEnabled(false);
                AlaSnatchRedPacketActivity.this.fkU.al(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aYY);
            }
        });
        this.fkN = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.fkO = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.fkP = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.fkR = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.fkR.setVisibility(8);
        this.fkQ = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.fkZ.bzK()) {
            this.fkT.setVisibility(0);
            this.fkN.setVisibility(8);
            buX();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buU() {
        buY();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dB(long j) {
        if (this.fkZ != null) {
            String[] dH = this.fkZ.dH(j);
            if (j <= 60) {
                if (!this.flc) {
                    this.flc = true;
                    if (this.fkR != null) {
                        this.fkR.setVisibility(8);
                    }
                    if (this.fkQ != null) {
                        this.fkQ.setVisibility(8);
                    }
                    if (this.fkP != null) {
                        this.fkP.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                    }
                }
                if (this.fkP != null) {
                    this.fkP.setText(dH[1]);
                }
            } else {
                if (this.fkR != null && this.fkR.getVisibility() != 0) {
                    this.fkR.setVisibility(0);
                }
                if (this.fkP != null) {
                    this.fkP.setText(dH[0]);
                }
                if (this.fkQ != null) {
                    this.fkQ.setText(dH[1]);
                }
            }
            if (this.fkO != null) {
                this.fkO.setProgress(this.fkZ.dG(j));
            }
        }
    }

    private void buV() {
        this.fkK.setVisibility(8);
        this.fkJ.setVisibility(0);
        this.fkM.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.fkM.addView(inflate, this.fkY);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.fkZ.bzP()) {
            this.flb = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.fkZ.bzQ()) {
            this.flb = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.flb) {
                    AlaSnatchRedPacketActivity.this.buQ();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.baI();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void baI() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buW() {
        String str = this.fkZ.fIP.fIW;
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.fkZ.fIO.portrait, str, true, getUniqueId());
        dVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.KF().a(str, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buQ() {
        w wVar = new w();
        wVar.azo = -1;
        wVar.azp = -1;
        wVar.azr = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, wVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void buX() {
        this.fkX = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.fkX.setDuration(250L);
        this.fkX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.fkT.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.fkT.setScaleY(floatValue);
            }
        });
        this.fkX.setRepeatCount(-1);
        this.fkX.setRepeatMode(2);
        this.fkX.start();
    }

    private void buY() {
        this.fkN.setVisibility(0);
        this.fkT.setVisibility(0);
        this.fkW = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.fkW.setDuration(500L);
        this.fkW.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.fkN.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.fkT.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.fkN.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.fkN.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.fkT.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.fkT.setScaleY((float) (f + 0.5d));
            }
        });
        this.fkW.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.buX();
                AlaSnatchRedPacketActivity.this.fkN.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.fkW.start();
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
        jU(configuration.orientation == 2);
    }

    private void jU(boolean z) {
        if (z) {
            h.X(this.bNL);
            this.bNL.setScaleX(0.7f);
            this.bNL.setScaleY(0.7f);
            if (this.fkS != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.fkS.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.fkS.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.Y(this.bNL);
        this.bNL.setScaleX(1.0f);
        this.bNL.setScaleY(1.0f);
        if (this.fkS != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.fkS.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.fkS.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.fkU != null) {
            this.fkU.onDestroy();
        }
        if (this.fkX != null) {
            this.fkX.removeAllListeners();
            this.fkX.cancel();
            this.fkX = null;
        }
        if (this.fkW != null) {
            this.fkW.removeAllListeners();
            this.fkW.cancel();
            this.fkW = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fli);
        MessageManager.getInstance().unRegisterListener(this.flg);
        MessageManager.getInstance().unRegisterListener(this.fkB);
        super.onDestroy();
    }
}
