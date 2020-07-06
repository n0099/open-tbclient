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
import com.baidu.live.c.p;
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
import com.baidu.tieba.ala.data.i;
import com.baidu.tieba.ala.f.f;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes3.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView aTd;
    private String aZa;
    private FrameLayout bMW;
    private TextView dEL;
    private View fdW;
    private View ffH;
    private View ffI;
    private FrameLayout ffJ;
    private FrameLayout ffK;
    private FrameLayout ffL;
    private RoundProgressBar ffM;
    private TextView ffN;
    private TextView ffO;
    private ImageView ffP;
    private FrameLayout ffQ;
    private ImageView ffR;
    private f ffS;
    private String ffT;
    private ValueAnimator ffU;
    private ValueAnimator ffV;
    private FrameLayout.LayoutParams ffW;
    private com.baidu.tieba.ala.data.b ffX;
    private i ffY;
    private boolean ffZ;
    private boolean fga;
    private long fgb;
    private int fgd;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int fgc = 2;
    private CustomMessageListener ffy = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener fge = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.ffT)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.i.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.ffJ.setVisibility(8);
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
    private f.a fgf = new f.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        @Override // com.baidu.tieba.ala.f.f.a
        public void b(com.baidu.tieba.ala.data.b bVar) {
            AlaSnatchRedPacketActivity.this.a(bVar);
        }

        @Override // com.baidu.tieba.ala.f.f.a
        public void aA(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.f.f.a
        public void b(i iVar) {
            AlaSnatchRedPacketActivity.this.a(iVar);
        }

        @Override // com.baidu.tieba.ala.f.f.a
        public void aB(int i, String str) {
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.i.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.i.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener fgg = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.fgb = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.dn(AlaSnatchRedPacketActivity.this.fgb);
                if (AlaSnatchRedPacketActivity.this.fgb < 1) {
                    AlaSnatchRedPacketActivity.this.brO();
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
            this.ffS = new f(getPageContext(), this.fgf);
            this.ffS.aj(this.mRedPacketId, this.mLiveId, this.aZa);
            MessageManager.getInstance().registerListener(this.ffy);
            MessageManager.getInstance().registerListener(this.fge);
            MessageManager.getInstance().registerListener(this.fgg);
            this.ffW = new FrameLayout.LayoutParams(-1, -1);
            jq(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.aZa = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.fdW = findViewById(a.g.rp_root_bg);
        this.fdW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.bMW = (FrameLayout) findViewById(a.g.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.g.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.aTd = (HeadImageView) findViewById(a.g.rp_user_icon);
        this.aTd.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.e.sdk_ds6));
        this.aTd.setBorderColor(getPageContext().getResources().getColor(a.d.ala_red_packet_main_color));
        this.aTd.setIsRound(true);
        this.aTd.setDefaultResource(a.f.sdk_icon_default_avatar100_bg);
        this.aTd.setAutoChangeStyle(true);
        this.aTd.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.dEL = (TextView) findViewById(a.g.rp_user_name);
        this.ffJ = (FrameLayout) findViewById(a.g.rp_follow_sender);
        this.ffJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.brQ();
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
        this.ffI = findViewById(a.g.rp_normal_bg);
        this.ffH = findViewById(a.g.rp_condition_guide_bg);
        this.ffK = (FrameLayout) findViewById(a.g.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(i iVar) {
        this.ffY = iVar;
        if (iVar.bwv()) {
            this.fgd = 101;
        } else {
            this.fgd = 100;
        }
        brM();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.b bVar) {
        if (bVar.fDt != null) {
            this.mContentView.setVisibility(0);
            this.ffX = bVar;
            this.ffT = this.ffX.fDu.fDB;
            if (!StringUtils.isNullObject(bVar.fDt.portrait)) {
                k.a(this.aTd, bVar.fDt.portrait, true, false);
            }
            this.dEL.setText(bVar.fDt.userName);
            if (!bVar.bwy()) {
                this.ffJ.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.ffT) : true;
                if (this.ffX.fDu.fDC || equals) {
                    this.ffJ.setVisibility(8);
                } else {
                    this.ffJ.setVisibility(0);
                }
            }
            if (this.ffX.bwv()) {
                this.fgc = 3;
            } else if (this.ffX.isValid()) {
                if (bVar.bwx()) {
                    this.fgc = 1;
                    this.ffJ.setVisibility(8);
                } else {
                    this.fgc = 2;
                }
            } else if (this.ffX.bws()) {
                this.fgc = 5;
            } else if (this.ffX.bwt()) {
                this.fgc = 4;
            }
            brL();
        }
    }

    private void brL() {
        switch (this.fgc) {
            case 1:
                brP();
                return;
            case 2:
                brN();
                return;
            case 3:
                this.fgd = 102;
                brM();
                return;
            case 4:
                this.fgd = 103;
                brM();
                return;
            case 5:
                this.fgd = 104;
                brM();
                return;
            default:
                return;
        }
    }

    private void brM() {
        String str;
        this.ffI.setVisibility(8);
        this.ffH.setVisibility(0);
        this.ffK.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_outcome, (ViewGroup) null);
        this.ffK.addView(inflate, this.ffW);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aZa)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.brK();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.fgd) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.g.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.fgd == 103) {
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
                textView4.setText(String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.ffY.bww())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.g.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.i.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.i.snatch_red_packet_t_dou_suffix), Long.valueOf(this.ffX.bww())));
                return;
            default:
                return;
        }
    }

    private void brN() {
        this.ffI.setVisibility(0);
        this.ffH.setVisibility(8);
        this.ffK.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_snatch, (ViewGroup) null);
        this.ffK.addView(inflate, this.ffW);
        ((TextView) inflate.findViewById(a.g.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.g.rp_total_amount)).setText(String.format(getResources().getString(a.i.send_ref_packet_desc), Long.valueOf(this.ffX.fDt.fEa)));
        this.ffQ = (FrameLayout) inflate.findViewById(a.g.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ffQ.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
            this.ffQ.setLayoutParams(layoutParams);
        }
        this.ffR = (ImageView) inflate.findViewById(a.g.rp_snatch_btn);
        this.ffR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.ffS.ak(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.aZa);
            }
        });
        this.ffL = (FrameLayout) inflate.findViewById(a.g.rp_count_down_layout);
        this.ffM = (RoundProgressBar) inflate.findViewById(a.g.rp_snatch_progress);
        this.ffN = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_min);
        this.ffP = (ImageView) inflate.findViewById(a.g.rp_snatch_countdown_dot);
        this.ffP.setVisibility(8);
        this.ffO = (TextView) inflate.findViewById(a.g.rp_snatch_countdown_second);
        if (!this.ffX.bwu()) {
            this.ffR.setVisibility(0);
            this.ffL.setVisibility(8);
            brR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brO() {
        brS();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dn(long j) {
        if (this.ffX != null) {
            String[] dt = this.ffX.dt(j);
            if (j <= 60) {
                if (!this.fga) {
                    this.fga = true;
                    if (this.ffP != null) {
                        this.ffP.setVisibility(8);
                    }
                    if (this.ffO != null) {
                        this.ffO.setVisibility(8);
                    }
                    if (this.ffN != null) {
                        this.ffN.setTextSize(0, getResources().getDimensionPixelSize(a.e.sdk_ds108));
                    }
                }
                if (this.ffN != null) {
                    this.ffN.setText(dt[1]);
                }
            } else {
                if (this.ffP != null && this.ffP.getVisibility() != 0) {
                    this.ffP.setVisibility(0);
                }
                if (this.ffN != null) {
                    this.ffN.setText(dt[0]);
                }
                if (this.ffO != null) {
                    this.ffO.setText(dt[1]);
                }
            }
            if (this.ffM != null) {
                this.ffM.setProgress(this.ffX.ds(j));
            }
        }
    }

    private void brP() {
        this.ffI.setVisibility(8);
        this.ffH.setVisibility(0);
        this.ffK.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.h.ala_red_packet_condition, (ViewGroup) null);
        this.ffK.addView(inflate, this.ffW);
        TextView textView = (TextView) inflate.findViewById(a.g.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.g.rp_condition_btn);
        if (this.ffX.bwz()) {
            this.ffZ = false;
            textView.setText(a.i.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.i.snatch_red_packet_follow_btn);
        } else if (this.ffX.bwA()) {
            this.ffZ = true;
            textView.setText(a.i.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.i.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.ffZ) {
                    AlaSnatchRedPacketActivity.this.brK();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.aWH();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aWH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brQ() {
        String str = this.ffX.fDu.fDB;
        com.baidu.live.data.d dVar = new com.baidu.live.data.d(this.ffX.fDt.portrait, str, true, getUniqueId());
        dVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Ky().a(str, dVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brK() {
        w wVar = new w();
        wVar.ayb = -1;
        wVar.ayc = -1;
        wVar.aye = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, wVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void brR() {
        this.ffV = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.ffV.setDuration(250L);
        this.ffV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.ffR.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.ffR.setScaleY(floatValue);
            }
        });
        this.ffV.setRepeatCount(-1);
        this.ffV.setRepeatMode(2);
        this.ffV.start();
    }

    private void brS() {
        this.ffL.setVisibility(0);
        this.ffR.setVisibility(0);
        this.ffU = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.ffU.setDuration(500L);
        this.ffU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.ffL.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.ffR.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.ffL.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.ffL.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.ffR.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.ffR.setScaleY((float) (f + 0.5d));
            }
        });
        this.ffU.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.brR();
                AlaSnatchRedPacketActivity.this.ffL.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.ffU.start();
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
        jq(configuration.orientation == 2);
    }

    private void jq(boolean z) {
        if (z) {
            h.U(this.bMW);
            this.bMW.setScaleX(0.7f);
            this.bMW.setScaleY(0.7f);
            if (this.ffQ != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.ffQ.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds126);
                this.ffQ.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        h.V(this.bMW);
        this.bMW.setScaleX(1.0f);
        this.bMW.setScaleY(1.0f);
        if (this.ffQ != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.ffQ.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.e.sdk_ds146);
            this.ffQ.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, android.support.v4.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.ffS != null) {
            this.ffS.onDestroy();
        }
        if (this.ffV != null) {
            this.ffV.removeAllListeners();
            this.ffV.cancel();
            this.ffV = null;
        }
        if (this.ffU != null) {
            this.ffU.removeAllListeners();
            this.ffU.cancel();
            this.ffU = null;
        }
        MessageManager.getInstance().unRegisterListener(this.fgg);
        MessageManager.getInstance().unRegisterListener(this.fge);
        MessageManager.getInstance().unRegisterListener(this.ffy);
        super.onDestroy();
    }
}
