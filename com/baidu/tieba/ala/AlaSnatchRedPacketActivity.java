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
    private View gnS;
    private View gqd;
    private View gqe;
    private FrameLayout gqf;
    private FrameLayout gqg;
    private FrameLayout gqh;
    private RoundProgressBar gqi;
    private TextView gqj;
    private TextView gqk;
    private ImageView gql;
    private FrameLayout gqm;
    private ImageView gqn;
    private com.baidu.tieba.ala.g.h gqo;
    private String gqp;
    private ValueAnimator gqq;
    private ValueAnimator gqr;
    private FrameLayout.LayoutParams gqs;
    private com.baidu.tieba.ala.data.c gqt;
    private l gqu;
    private boolean gqv;
    private boolean gqw;
    private long gqx;
    private int gqz;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int gqy = 2;
    private CustomMessageListener awl = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener gqA = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.gqp)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.gqf.setVisibility(8);
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
    private h.a gqB = new h.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
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
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gqD);
            AlaSnatchRedPacketActivity.this.gqn.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(lVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aX(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gqD);
            AlaSnatchRedPacketActivity.this.gqn.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener gqC = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.gqx = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.fd(AlaSnatchRedPacketActivity.this.gqx);
                if (AlaSnatchRedPacketActivity.this.gqx < 1) {
                    AlaSnatchRedPacketActivity.this.bOA();
                }
            }
        }
    };
    private Runnable gqD = new Runnable() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.gqn != null) {
                AlaSnatchRedPacketActivity.this.gqn.setEnabled(true);
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
            this.gqo = new com.baidu.tieba.ala.g.h(getPageContext(), this.gqB);
            this.gqo.az(this.mRedPacketId, this.mLiveId, this.buH);
            MessageManager.getInstance().registerListener(this.awl);
            MessageManager.getInstance().registerListener(this.gqA);
            MessageManager.getInstance().registerListener(this.gqC);
            this.gqs = new FrameLayout.LayoutParams(-1, -1);
            mi(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.buH = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.gnS = findViewById(a.f.rp_root_bg);
        this.gnS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
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
        this.gqf = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.gqf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bOC();
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
        this.gqe = findViewById(a.f.rp_normal_bg);
        this.gqd = findViewById(a.f.rp_condition_guide_bg);
        this.gqg = (FrameLayout) findViewById(a.f.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        this.gqu = lVar;
        if (lVar.bUe()) {
            this.gqz = 101;
        } else {
            this.gqz = 100;
        }
        bOy();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.gSd != null) {
            this.mContentView.setVisibility(0);
            this.gqt = cVar;
            this.gqp = this.gqt.gSe.gSl;
            if (!StringUtils.isNullObject(cVar.gSd.portrait)) {
                m.a(this.blt, cVar.gSd.portrait, true, false);
            }
            if (!TextUtils.isEmpty(cVar.gSd.gSy)) {
                String str = cVar.gSd.userName;
                if (TextHelper.getTextLengthWithEmoji(str) > 10) {
                    str = TextHelper.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eIO.setText(str + cVar.gSd.gSy);
            } else {
                this.eIO.setText(cVar.gSd.userName);
            }
            if (!cVar.bUh()) {
                this.gqf.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.gqp) : true;
                if (this.gqt.gSe.gSm || equals) {
                    this.gqf.setVisibility(8);
                } else {
                    this.gqf.setVisibility(0);
                }
            }
            if (this.gqt.bUe()) {
                this.gqy = 3;
            } else if (this.gqt.isValid()) {
                if (cVar.bUg()) {
                    this.gqy = 1;
                    this.gqf.setVisibility(8);
                } else {
                    this.gqy = 2;
                }
            } else if (this.gqt.bUb()) {
                this.gqy = 5;
            } else if (this.gqt.bUc()) {
                this.gqy = 4;
            }
            bOx();
        }
    }

    private void bOx() {
        switch (this.gqy) {
            case 1:
                bOB();
                return;
            case 2:
                bOz();
                return;
            case 3:
                this.gqz = 102;
                bOy();
                return;
            case 4:
                this.gqz = 103;
                bOy();
                return;
            case 5:
                this.gqz = 104;
                bOy();
                return;
            default:
                return;
        }
    }

    private void bOy() {
        String str;
        this.gqe.setVisibility(8);
        this.gqd.setVisibility(0);
        this.gqg.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.gqg.addView(inflate, this.gqs);
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
                AlaSnatchRedPacketActivity.this.bOv();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.gqz) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.gqz == 103) {
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
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.gqu.bUf())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.gqt.bUf())));
                return;
            default:
                return;
        }
    }

    private void bOz() {
        this.gqe.setVisibility(0);
        this.gqd.setVisibility(8);
        this.gqg.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_snatch, (ViewGroup) null);
        this.gqg.addView(inflate, this.gqs);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.gqt.gSd.gSK)));
        this.gqm = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqm.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.gqm.setLayoutParams(layoutParams);
        }
        this.gqn = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.gqn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.gqn.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.gqD, 1000L);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                if (AlaSnatchRedPacketActivity.this.gqt != null && AlaSnatchRedPacketActivity.this.gqt.gSd != null) {
                    alaStatsItem.addValue("redpacketId", AlaSnatchRedPacketActivity.this.gqt.gSd.id);
                }
                AlaStatManager.getInstance().debug("redpacket_loot_before", "", "", alaStatsItem);
                AlaSnatchRedPacketActivity.this.gqo.aA(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.buH);
            }
        });
        this.gqh = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.gqi = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.gqj = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.gql = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.gql.setVisibility(8);
        this.gqk = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.gqt.bUd()) {
            this.gqn.setVisibility(0);
            this.gqh.setVisibility(8);
            mj(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOA() {
        bOD();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(long j) {
        if (this.gqt != null) {
            String[] fl = this.gqt.fl(j);
            if (j <= 60) {
                if (!this.gqw) {
                    this.gqw = true;
                    if (this.gql != null) {
                        this.gql.setVisibility(8);
                    }
                    if (this.gqk != null) {
                        this.gqk.setVisibility(8);
                    }
                    if (this.gqj != null) {
                        this.gqj.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.gqj != null) {
                    this.gqj.setText(fl[1]);
                }
            } else {
                if (this.gql != null && this.gql.getVisibility() != 0) {
                    this.gql.setVisibility(0);
                }
                if (this.gqj != null) {
                    this.gqj.setText(fl[0]);
                }
                if (this.gqk != null) {
                    this.gqk.setText(fl[1]);
                }
            }
            if (this.gqi != null) {
                this.gqi.setProgress(this.gqt.fk(j));
            }
        }
    }

    private void bOB() {
        this.gqe.setVisibility(8);
        this.gqd.setVisibility(0);
        this.gqg.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.gqg.addView(inflate, this.gqs);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.gqt.bUi()) {
            this.gqv = false;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.gqt.bUj()) {
            this.gqv = true;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.gqv) {
                    AlaSnatchRedPacketActivity.this.bOv();
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
    public void bOC() {
        String str = this.gqt.gSe.gSl;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.gqt.gSd.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Xo().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOv() {
        ao aoVar = new ao();
        aoVar.aJW = -1;
        aoVar.aJX = -1;
        aoVar.aJZ = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(boolean z) {
        this.gqr = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.gqr.setDuration(250L);
        this.gqr.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.gqn.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.gqn.setScaleY(floatValue);
            }
        });
        this.gqr.setRepeatCount(-1);
        this.gqr.setRepeatMode(2);
        this.gqr.start();
        AlaStatsItem alaStatsItem = new AlaStatsItem();
        if (this.gqt != null && this.gqt.gSd != null) {
            alaStatsItem.addValue("redpacketId", this.gqt.gSd.id);
        }
        alaStatsItem.addValue("source", z ? "countdown_finish" : "redpacket_status_3");
        AlaStatManager.getInstance().debug("redpacket_loot_enable", "", "", alaStatsItem);
    }

    private void bOD() {
        this.gqh.setVisibility(0);
        this.gqn.setVisibility(0);
        this.gqq = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gqq.setDuration(500L);
        this.gqq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.gqh.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.gqn.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.gqh.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.gqh.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.gqn.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.gqn.setScaleY((float) (f + 0.5d));
            }
        });
        this.gqq.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.mj(true);
                AlaSnatchRedPacketActivity.this.gqh.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gqq.start();
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
            if (this.gqm != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gqm.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.gqm.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        com.baidu.live.utils.i.af(this.cDI);
        this.cDI.setScaleX(1.0f);
        this.cDI.setScaleY(1.0f);
        if (this.gqm != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gqm.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.gqm.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gqo != null) {
            this.gqo.onDestroy();
        }
        if (this.gqr != null) {
            this.gqr.removeAllListeners();
            this.gqr.cancel();
            this.gqr = null;
        }
        if (this.gqq != null) {
            this.gqq.removeAllListeners();
            this.gqq.cancel();
            this.gqq = null;
        }
        if (this.gqr != null) {
            this.gqr.removeAllUpdateListeners();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gqC);
        MessageManager.getInstance().unRegisterListener(this.gqA);
        MessageManager.getInstance().unRegisterListener(this.awl);
        super.onDestroy();
    }
}
