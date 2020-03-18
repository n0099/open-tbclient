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
    private HeadImageView arG;
    private String awz;
    private FrameLayout bcc;
    private TextView cbW;
    private View ehi;
    private View eiX;
    private View eiY;
    private FrameLayout eiZ;
    private FrameLayout eja;
    private FrameLayout ejb;
    private RoundProgressBar ejc;
    private TextView ejd;
    private TextView eje;
    private ImageView ejf;
    private FrameLayout ejg;
    private ImageView ejh;
    private f eji;
    private String ejj;
    private ValueAnimator ejk;
    private ValueAnimator ejl;
    private FrameLayout.LayoutParams ejm;
    private com.baidu.tieba.ala.data.b ejn;
    private i ejo;
    private boolean ejp;
    private boolean ejq;
    private long ejr;
    private int ejt;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int ejs = 2;
    private CustomMessageListener eiM = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener eju = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.ejj)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.eiZ.setVisibility(8);
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
    private f.a ejv = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
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
    private CustomMessageListener ejw = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.ejr = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.cC(AlaSnatchRedPacketActivity.this.ejr);
                if (AlaSnatchRedPacketActivity.this.ejr < 1) {
                    AlaSnatchRedPacketActivity.this.bbQ();
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
        this.eji = new f(getPageContext(), this.ejv);
        this.eji.af(this.mRedPacketId, this.mLiveId, this.awz);
        MessageManager.getInstance().registerListener(this.eiM);
        MessageManager.getInstance().registerListener(this.eju);
        MessageManager.getInstance().registerListener(this.ejw);
        this.ejm = new FrameLayout.LayoutParams(-1, -1);
        hO(UtilHelper.getRealScreenOrientation(this) == 2);
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.awz = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.ehi = findViewById(a.g.rp_root_bg);
        this.ehi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bcc = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.arG = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.arG.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.arG.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.arG.setIsRound(true);
        this.arG.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.arG.setAutoChangeStyle(true);
        this.arG.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.cbW = (TextView) findViewById(a.g.rp_user_name);
        this.eiZ = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.eiZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bbS();
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
        this.eiY = findViewById(a.g.rp_normal_bg);
        this.eiX = findViewById(a.g.rp_condition_guide_bg);
        this.eja = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.ejo = iVar;
        if (iVar.ber()) {
            this.ejt = 101;
        } else {
            this.ejt = 100;
        }
        bbO();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.ezT != null) {
            this.mContentView.setVisibility(0);
            this.ejn = bVar;
            this.ejj = this.ejn.ezU.eAb;
            if (!StringUtils.isNullObject(bVar.ezT.portrait)) {
                k.a(this.arG, bVar.ezT.portrait, true, false);
            }
            this.cbW.setText(bVar.ezT.userName);
            if (bVar.beu()) {
                this.eiZ.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.ejj) : true;
                if (this.ejn.ezU.eAc || equals) {
                    this.eiZ.setVisibility(8);
                } else {
                    this.eiZ.setVisibility(0);
                }
            }
            if (this.ejn.ber()) {
                this.ejs = 3;
            } else if (this.ejn.isValid()) {
                if (bVar.bet()) {
                    this.ejs = 1;
                    this.eiZ.setVisibility(8);
                } else {
                    this.ejs = 2;
                }
            } else if (this.ejn.beo()) {
                this.ejs = 5;
            } else if (this.ejn.bep()) {
                this.ejs = 4;
            }
            bbN();
        }
    }

    private void bbN() {
        switch (this.ejs) {
            case 1:
                bbR();
                return;
            case 2:
                bbP();
                return;
            case 3:
                this.ejt = 102;
                bbO();
                return;
            case 4:
                this.ejt = 103;
                bbO();
                return;
            case 5:
                this.ejt = 104;
                bbO();
                return;
            default:
                return;
        }
    }

    private void bbO() {
        String str;
        this.eiY.setVisibility(8);
        this.eiX.setVisibility(0);
        this.eja.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.eja.addView(inflate, this.ejm);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.awz)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bbM();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.ejt) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.ejt == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.ejo.bes())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.ejn.bes())));
                return;
            default:
                return;
        }
    }

    private void bbP() {
        this.eiY.setVisibility(0);
        this.eiX.setVisibility(8);
        this.eja.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.eja.addView(inflate, this.ejm);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.ejn.ezT.eAB)));
        this.ejg = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ejg.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.ejg.setLayoutParams(layoutParams);
        }
        this.ejh = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.ejh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.eji.ag(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.awz);
            }
        });
        this.ejb = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.ejc = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.ejd = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.ejf = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.ejf.setVisibility(8);
        this.eje = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.ejn.beq()) {
            this.ejh.setVisibility(0);
            this.ejb.setVisibility(8);
            bbT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbQ() {
        bbU();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cC(long j) {
        if (this.ejn != null) {
            String[] cG = this.ejn.cG(j);
            if (j <= 60) {
                if (!this.ejq) {
                    this.ejq = true;
                    this.ejf.setVisibility(8);
                    this.eje.setVisibility(8);
                    this.ejd.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                }
                this.ejd.setText(cG[1]);
            } else {
                if (this.ejf.getVisibility() != 0) {
                    this.ejf.setVisibility(0);
                }
                this.ejd.setText(cG[0]);
                this.eje.setText(cG[1]);
            }
            this.ejc.setProgress(this.ejn.cF(j));
        }
    }

    private void bbR() {
        this.eiY.setVisibility(8);
        this.eiX.setVisibility(0);
        this.eja.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.eja.addView(inflate, this.ejm);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.ejn.bev()) {
            this.ejp = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.ejn.bew()) {
            this.ejp = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.ejp) {
                    AlaSnatchRedPacketActivity.this.bbM();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.aGx();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aGx() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbS() {
        String str = this.ejn.ezU.eAb;
        com.baidu.live.view.a.Bq().a(str, new com.baidu.live.data.b(this.ejn.ezT.portrait, str, true, getUniqueId()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbM() {
        r rVar = new r();
        rVar.YD = -1;
        rVar.YE = -1;
        rVar.YG = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, rVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bbT() {
        this.ejl = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.ejl.setDuration(250L);
        this.ejl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.ejh.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.ejh.setScaleY(floatValue);
            }
        });
        this.ejl.setRepeatCount(-1);
        this.ejl.setRepeatMode(2);
        this.ejl.start();
    }

    private void bbU() {
        this.ejb.setVisibility(0);
        this.ejh.setVisibility(0);
        this.ejk = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ejk.setDuration(500L);
        this.ejk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.ejb.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.ejh.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.ejb.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.ejb.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.ejh.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.ejh.setScaleY((float) (f + 0.5d));
            }
        });
        this.ejk.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.bbT();
                AlaSnatchRedPacketActivity.this.ejb.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ejk.start();
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
        hO(configuration.orientation == 2);
    }

    private void hO(boolean z) {
        if (z) {
            h.S(this.bcc);
            this.bcc.setScaleX(0.7f);
            this.bcc.setScaleY(0.7f);
            if (this.ejg != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ejg.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.ejg.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.T(this.bcc);
        this.bcc.setScaleX(1.0f);
        this.bcc.setScaleY(1.0f);
        if (this.ejg != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ejg.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.ejg.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.eji != null) {
            this.eji.onDestroy();
        }
        if (this.ejl != null) {
            this.ejl.removeAllListeners();
            this.ejl.cancel();
            this.ejl = null;
        }
        if (this.ejk != null) {
            this.ejk.removeAllListeners();
            this.ejk.cancel();
            this.ejk = null;
        }
        MessageManager.getInstance().unRegisterListener(this.ejw);
        MessageManager.getInstance().unRegisterListener(this.eju);
        MessageManager.getInstance().unRegisterListener(this.eiM);
        super.onDestroy();
    }
}
