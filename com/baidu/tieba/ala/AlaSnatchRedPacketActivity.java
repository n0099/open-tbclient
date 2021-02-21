package com.baidu.tieba.ala;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
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
import com.baidu.live.adp.lib.stats.AlaStatManager;
import com.baidu.live.adp.lib.stats.AlaStatsItem;
import com.baidu.live.adp.lib.util.BdNetTypeUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.d.t;
import com.baidu.live.data.ao;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.live.tbadk.core.view.HeadImageView;
import com.baidu.live.tbadk.coreextra.message.UpdateAttentionMessage;
import com.baidu.live.tbadk.util.TextHelper;
import com.baidu.live.utils.m;
import com.baidu.tieba.ala.data.l;
import com.baidu.tieba.ala.g.h;
import com.baidu.tieba.ala.view.RoundProgressBar;
/* loaded from: classes11.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView blt;
    private String buH;
    private FrameLayout cDI;
    private TextView eIO;
    private View gog;
    private FrameLayout gqA;
    private ImageView gqB;
    private com.baidu.tieba.ala.g.h gqC;
    private String gqD;
    private ValueAnimator gqE;
    private ValueAnimator gqF;
    private FrameLayout.LayoutParams gqG;
    private com.baidu.tieba.ala.data.c gqH;
    private l gqI;
    private boolean gqJ;
    private boolean gqK;
    private long gqL;
    private int gqN;
    private View gqr;
    private View gqs;
    private FrameLayout gqt;
    private FrameLayout gqu;
    private FrameLayout gqv;
    private RoundProgressBar gqw;
    private TextView gqx;
    private TextView gqy;
    private ImageView gqz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int gqM = 2;
    private CustomMessageListener awl = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener gqO = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.gqD)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.gqt.setVisibility(8);
                            return;
                        }
                        AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_unfollow_success_toast));
                        return;
                    }
                    AlaSnatchRedPacketActivity.this.showToast(a.h.follow_failed_tip);
                }
            }
        }
    };
    private h.a gqP = new h.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
        @Override // com.baidu.tieba.ala.g.h.a
        public void b(com.baidu.tieba.ala.data.c cVar) {
            AlaSnatchRedPacketActivity.this.a(cVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aW(int i, String str) {
            AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void b(l lVar) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gqR);
            AlaSnatchRedPacketActivity.this.gqB.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(lVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aX(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gqR);
            AlaSnatchRedPacketActivity.this.gqB.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener gqQ = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.gqL = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.fd(AlaSnatchRedPacketActivity.this.gqL);
                if (AlaSnatchRedPacketActivity.this.gqL < 1) {
                    AlaSnatchRedPacketActivity.this.bOH();
                }
            }
        }
    };
    private Runnable gqR = new Runnable() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.gqB != null) {
                AlaSnatchRedPacketActivity.this.gqB.setEnabled(true);
            }
        }
    };

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, androidx.core.app.ComponentActivity, android.app.Activity
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
                getWindow().setBackgroundDrawable(new ColorDrawable(getResources().getColor(a.c.sdk_transparent)));
            }
            setContentView(a.g.ala_snatch_red_packet_view);
            initView();
            this.gqC = new com.baidu.tieba.ala.g.h(getPageContext(), this.gqP);
            this.gqC.az(this.mRedPacketId, this.mLiveId, this.buH);
            MessageManager.getInstance().registerListener(this.awl);
            MessageManager.getInstance().registerListener(this.gqO);
            MessageManager.getInstance().registerListener(this.gqQ);
            this.gqG = new FrameLayout.LayoutParams(-1, -1);
            mi(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.buH = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.gog = findViewById(a.f.rp_root_bg);
        this.gog.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cDI = (FrameLayout) findViewById(a.f.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.f.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.blt = (HeadImageView) findViewById(a.f.rp_user_icon);
        this.blt.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.blt.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.blt.setIsRound(true);
        this.blt.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.blt.setAutoChangeStyle(true);
        this.blt.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eIO = (TextView) findViewById(a.f.rp_user_name);
        this.gqt = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.gqt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bOJ();
            }
        });
        this.mCloseBtn = (ImageView) findViewById(a.f.rp_close_btn);
        if (TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.mCloseBtn.setVisibility(0);
            this.mCloseBtn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.13
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            });
        } else {
            this.mCloseBtn.setVisibility(8);
        }
        this.gqs = findViewById(a.f.rp_normal_bg);
        this.gqr = findViewById(a.f.rp_condition_guide_bg);
        this.gqu = (FrameLayout) findViewById(a.f.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        this.gqI = lVar;
        if (lVar.bUl()) {
            this.gqN = 101;
        } else {
            this.gqN = 100;
        }
        bOF();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.gSr != null) {
            this.mContentView.setVisibility(0);
            this.gqH = cVar;
            this.gqD = this.gqH.gSs.gSz;
            if (!StringUtils.isNullObject(cVar.gSr.portrait)) {
                m.a(this.blt, cVar.gSr.portrait, true, false);
            }
            if (!TextUtils.isEmpty(cVar.gSr.gSM)) {
                String str = cVar.gSr.userName;
                if (TextHelper.getTextLengthWithEmoji(str) > 10) {
                    str = TextHelper.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eIO.setText(str + cVar.gSr.gSM);
            } else {
                this.eIO.setText(cVar.gSr.userName);
            }
            if (!cVar.bUo()) {
                this.gqt.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.gqD) : true;
                if (this.gqH.gSs.gSA || equals) {
                    this.gqt.setVisibility(8);
                } else {
                    this.gqt.setVisibility(0);
                }
            }
            if (this.gqH.bUl()) {
                this.gqM = 3;
            } else if (this.gqH.isValid()) {
                if (cVar.bUn()) {
                    this.gqM = 1;
                    this.gqt.setVisibility(8);
                } else {
                    this.gqM = 2;
                }
            } else if (this.gqH.bUi()) {
                this.gqM = 5;
            } else if (this.gqH.bUj()) {
                this.gqM = 4;
            }
            bOE();
        }
    }

    private void bOE() {
        switch (this.gqM) {
            case 1:
                bOI();
                return;
            case 2:
                bOG();
                return;
            case 3:
                this.gqN = 102;
                bOF();
                return;
            case 4:
                this.gqN = 103;
                bOF();
                return;
            case 5:
                this.gqN = 104;
                bOF();
                return;
            default:
                return;
        }
    }

    private void bOF() {
        String str;
        this.gqs.setVisibility(8);
        this.gqr.setVisibility(0);
        this.gqu.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.gqu.addView(inflate, this.gqG);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.buH)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bOC();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.gqN) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.gqN == 103) {
                    String string = getResources().getString(a.h.snatch_red_packet_failed_4);
                    textView.setVisibility(8);
                    str = string;
                } else {
                    String string2 = getResources().getString(a.h.snatch_red_packet_failed_2);
                    textView.setVisibility(0);
                    str = string2;
                }
                textView3.setText(str);
                return;
            case 101:
                textView2.setVisibility(0);
                ((LinearLayout) inflate.findViewById(a.f.rp_snatch_succ_layout)).setVisibility(0);
                TextView textView4 = (TextView) inflate.findViewById(a.f.rp_snatch_amount);
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.gqI.bUm())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.gqH.bUm())));
                return;
            default:
                return;
        }
    }

    private void bOG() {
        this.gqs.setVisibility(0);
        this.gqr.setVisibility(8);
        this.gqu.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_snatch, (ViewGroup) null);
        this.gqu.addView(inflate, this.gqG);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.gqH.gSr.gSY)));
        this.gqA = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqA.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.gqA.setLayoutParams(layoutParams);
        }
        this.gqB = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.gqB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.gqB.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.gqR, 1000L);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                if (AlaSnatchRedPacketActivity.this.gqH != null && AlaSnatchRedPacketActivity.this.gqH.gSr != null) {
                    alaStatsItem.addValue("redpacketId", AlaSnatchRedPacketActivity.this.gqH.gSr.id);
                }
                AlaStatManager.getInstance().debug("redpacket_loot_before", "", "", alaStatsItem);
                AlaSnatchRedPacketActivity.this.gqC.aA(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.buH);
            }
        });
        this.gqv = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.gqw = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.gqx = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.gqz = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.gqz.setVisibility(8);
        this.gqy = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.gqH.bUk()) {
            this.gqB.setVisibility(0);
            this.gqv.setVisibility(8);
            mj(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOH() {
        bOK();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(long j) {
        if (this.gqH != null) {
            String[] fl = this.gqH.fl(j);
            if (j <= 60) {
                if (!this.gqK) {
                    this.gqK = true;
                    if (this.gqz != null) {
                        this.gqz.setVisibility(8);
                    }
                    if (this.gqy != null) {
                        this.gqy.setVisibility(8);
                    }
                    if (this.gqx != null) {
                        this.gqx.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.gqx != null) {
                    this.gqx.setText(fl[1]);
                }
            } else {
                if (this.gqz != null && this.gqz.getVisibility() != 0) {
                    this.gqz.setVisibility(0);
                }
                if (this.gqx != null) {
                    this.gqx.setText(fl[0]);
                }
                if (this.gqy != null) {
                    this.gqy.setText(fl[1]);
                }
            }
            if (this.gqw != null) {
                this.gqw.setProgress(this.gqH.fk(j));
            }
        }
    }

    private void bOI() {
        this.gqs.setVisibility(8);
        this.gqr.setVisibility(0);
        this.gqu.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.gqu.addView(inflate, this.gqG);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.gqH.bUp()) {
            this.gqJ = false;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.gqH.bUq()) {
            this.gqJ = true;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.gqJ) {
                    AlaSnatchRedPacketActivity.this.bOC();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.bsG();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOJ() {
        String str = this.gqH.gSs.gSz;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.gqH.gSr.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Xo().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOC() {
        ao aoVar = new ao();
        aoVar.aJW = -1;
        aoVar.aJX = -1;
        aoVar.aJZ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(boolean z) {
        this.gqF = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.gqF.setDuration(250L);
        this.gqF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.gqB.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.gqB.setScaleY(floatValue);
            }
        });
        this.gqF.setRepeatCount(-1);
        this.gqF.setRepeatMode(2);
        this.gqF.start();
        AlaStatsItem alaStatsItem = new AlaStatsItem();
        if (this.gqH != null && this.gqH.gSr != null) {
            alaStatsItem.addValue("redpacketId", this.gqH.gSr.id);
        }
        alaStatsItem.addValue("source", z ? "countdown_finish" : "redpacket_status_3");
        AlaStatManager.getInstance().debug("redpacket_loot_enable", "", "", alaStatsItem);
    }

    private void bOK() {
        this.gqv.setVisibility(0);
        this.gqB.setVisibility(0);
        this.gqE = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gqE.setDuration(500L);
        this.gqE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.gqv.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.gqB.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.gqv.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.gqv.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.gqB.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.gqB.setScaleY((float) (f + 0.5d));
            }
        });
        this.gqE.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.mj(true);
                AlaSnatchRedPacketActivity.this.gqv.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gqE.start();
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

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        mi(configuration.orientation == 2);
    }

    private void mi(boolean z) {
        if (z) {
            com.baidu.live.utils.i.ae(this.cDI);
            this.cDI.setScaleX(0.7f);
            this.cDI.setScaleY(0.7f);
            if (this.gqA != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqA.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.gqA.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        com.baidu.live.utils.i.af(this.cDI);
        this.cDI.setScaleX(1.0f);
        this.cDI.setScaleY(1.0f);
        if (this.gqA != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gqA.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.gqA.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gqC != null) {
            this.gqC.onDestroy();
        }
        if (this.gqF != null) {
            this.gqF.removeAllListeners();
            this.gqF.cancel();
            this.gqF = null;
        }
        if (this.gqE != null) {
            this.gqE.removeAllListeners();
            this.gqE.cancel();
            this.gqE = null;
        }
        if (this.gqF != null) {
            this.gqF.removeAllUpdateListeners();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gqQ);
        MessageManager.getInstance().unRegisterListener(this.gqO);
        MessageManager.getInstance().unRegisterListener(this.awl);
        super.onDestroy();
    }
}
