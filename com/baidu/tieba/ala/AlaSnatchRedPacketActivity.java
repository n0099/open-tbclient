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
/* loaded from: classes10.dex */
public class AlaSnatchRedPacketActivity extends BaseFragmentActivity {
    private HeadImageView bmU;
    private String bwh;
    private FrameLayout cFi;
    private TextView eKp;
    private View gpP;
    private View gsa;
    private View gsb;
    private FrameLayout gsc;
    private FrameLayout gsd;
    private FrameLayout gse;
    private RoundProgressBar gsf;
    private TextView gsg;
    private TextView gsh;
    private ImageView gsi;
    private FrameLayout gsj;
    private ImageView gsk;
    private com.baidu.tieba.ala.g.h gsl;
    private String gsm;
    private ValueAnimator gsn;
    private ValueAnimator gso;
    private FrameLayout.LayoutParams gsp;
    private com.baidu.tieba.ala.data.c gsq;
    private l gsr;
    private boolean gss;
    private boolean gst;
    private long gsu;
    private int gsw;
    private ImageView mCloseBtn;
    private LinearLayout mContentView;
    private String mLiveId;
    private String mRedPacketId;
    private int gsv = 2;
    private CustomMessageListener axL = new CustomMessageListener(2913129) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.1
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            AlaSnatchRedPacketActivity.this.finish();
        }
    };
    private CustomMessageListener gsx = new CustomMessageListener(CmdConfigCustom.CMD_UPDATE_ATTENTION) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.8
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage instanceof UpdateAttentionMessage)) {
                UpdateAttentionMessage updateAttentionMessage = (UpdateAttentionMessage) customResponsedMessage;
                if (updateAttentionMessage.getData() != null && updateAttentionMessage.getData().toUid != null && updateAttentionMessage.getData().toUid.equals(AlaSnatchRedPacketActivity.this.gsm)) {
                    if (updateAttentionMessage.getData().isSucc) {
                        if (updateAttentionMessage.getData().isAttention) {
                            AlaSnatchRedPacketActivity.this.showToast(AlaSnatchRedPacketActivity.this.getString(a.h.sdk_attention_success_toast));
                            AlaSnatchRedPacketActivity.this.gsc.setVisibility(8);
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
    private h.a gsy = new h.a() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.9
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
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gsA);
            AlaSnatchRedPacketActivity.this.gsk.setEnabled(true);
            AlaSnatchRedPacketActivity.this.a(lVar);
        }

        @Override // com.baidu.tieba.ala.g.h.a
        public void aX(int i, String str) {
            AlaSnatchRedPacketActivity.this.mHandler.removeCallbacks(AlaSnatchRedPacketActivity.this.gsA);
            AlaSnatchRedPacketActivity.this.gsk.setEnabled(true);
            if (!BdNetTypeUtil.isNetWorkAvailable()) {
                AlaSnatchRedPacketActivity.this.showToast(a.h.sdk_net_fail_tip);
            } else if (!StringUtils.isNullObject(str)) {
                AlaSnatchRedPacketActivity.this.showToast(str);
            } else {
                AlaSnatchRedPacketActivity.this.showToast(a.h.snatch_red_packet_failed_3);
            }
        }
    };
    private CustomMessageListener gsz = new CustomMessageListener(2913133) { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.10
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage != null && (customResponsedMessage.getData() instanceof Long)) {
                AlaSnatchRedPacketActivity.this.gsu = ((Long) customResponsedMessage.getData()).longValue();
                AlaSnatchRedPacketActivity.this.fd(AlaSnatchRedPacketActivity.this.gsu);
                if (AlaSnatchRedPacketActivity.this.gsu < 1) {
                    AlaSnatchRedPacketActivity.this.bON();
                }
            }
        }
    };
    private Runnable gsA = new Runnable() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.3
        @Override // java.lang.Runnable
        public void run() {
            if (AlaSnatchRedPacketActivity.this.gsk != null) {
                AlaSnatchRedPacketActivity.this.gsk.setEnabled(true);
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
            this.gsl = new com.baidu.tieba.ala.g.h(getPageContext(), this.gsy);
            this.gsl.az(this.mRedPacketId, this.mLiveId, this.bwh);
            MessageManager.getInstance().registerListener(this.axL);
            MessageManager.getInstance().registerListener(this.gsx);
            MessageManager.getInstance().registerListener(this.gsz);
            this.gsp = new FrameLayout.LayoutParams(-1, -1);
            mi(UtilHelper.getRealScreenOrientation(this) == 2);
        }
    }

    private void parserIntent() {
        this.mRedPacketId = getIntent().getStringExtra("red_packet_id");
        this.mLiveId = getIntent().getStringExtra("live_id");
        this.bwh = getIntent().getStringExtra("anchor_id");
    }

    private void initView() {
        this.gpP = findViewById(a.f.rp_root_bg);
        this.gpP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.11
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (!TbadkCoreApplication.getInst().isMobileBaidu()) {
                    AlaSnatchRedPacketActivity.this.finish();
                }
            }
        });
        this.cFi = (FrameLayout) findViewById(a.f.rp_root_container);
        this.mContentView = (LinearLayout) findViewById(a.f.rp_content_layout);
        this.mContentView.setVisibility(8);
        this.bmU = (HeadImageView) findViewById(a.f.rp_user_icon);
        this.bmU.setBorderWidth(BdUtilHelper.getDimens(getPageContext().getPageActivity(), a.d.sdk_ds6));
        this.bmU.setBorderColor(getPageContext().getResources().getColor(a.c.ala_red_packet_main_color));
        this.bmU.setIsRound(true);
        this.bmU.setDefaultResource(a.e.sdk_icon_default_avatar100);
        this.bmU.setAutoChangeStyle(true);
        this.bmU.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.eKp = (TextView) findViewById(a.f.rp_user_name);
        this.gsc = (FrameLayout) findViewById(a.f.rp_follow_sender);
        this.gsc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.12
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bOP();
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
        this.gsb = findViewById(a.f.rp_normal_bg);
        this.gsa = findViewById(a.f.rp_condition_guide_bg);
        this.gsd = (FrameLayout) findViewById(a.f.rp_sub_content_container);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar) {
        this.gsr = lVar;
        if (lVar.bUr()) {
            this.gsw = 101;
        } else {
            this.gsw = 100;
        }
        bOL();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.ala.data.c cVar) {
        if (cVar.gUa != null) {
            this.mContentView.setVisibility(0);
            this.gsq = cVar;
            this.gsm = this.gsq.gUb.gUi;
            if (!StringUtils.isNullObject(cVar.gUa.portrait)) {
                m.a(this.bmU, cVar.gUa.portrait, true, false);
            }
            if (!TextUtils.isEmpty(cVar.gUa.gUv)) {
                String str = cVar.gUa.userName;
                if (TextHelper.getTextLengthWithEmoji(str) > 10) {
                    str = TextHelper.subStringWithEmoji(str, 10) + StringHelper.STRING_MORE;
                }
                this.eKp.setText(str + cVar.gUa.gUv);
            } else {
                this.eKp.setText(cVar.gUa.userName);
            }
            if (!cVar.bUu()) {
                this.gsc.setVisibility(8);
            } else {
                boolean equals = TbadkCoreApplication.getCurrentAccount() != null ? TbadkCoreApplication.getCurrentAccount().equals(this.gsm) : true;
                if (this.gsq.gUb.gUj || equals) {
                    this.gsc.setVisibility(8);
                } else {
                    this.gsc.setVisibility(0);
                }
            }
            if (this.gsq.bUr()) {
                this.gsv = 3;
            } else if (this.gsq.isValid()) {
                if (cVar.bUt()) {
                    this.gsv = 1;
                    this.gsc.setVisibility(8);
                } else {
                    this.gsv = 2;
                }
            } else if (this.gsq.bUo()) {
                this.gsv = 5;
            } else if (this.gsq.bUp()) {
                this.gsv = 4;
            }
            bOK();
        }
    }

    private void bOK() {
        switch (this.gsv) {
            case 1:
                bOO();
                return;
            case 2:
                bOM();
                return;
            case 3:
                this.gsw = 102;
                bOL();
                return;
            case 4:
                this.gsw = 103;
                bOL();
                return;
            case 5:
                this.gsw = 104;
                bOL();
                return;
            default:
                return;
        }
    }

    private void bOL() {
        String str;
        this.gsb.setVisibility(8);
        this.gsa.setVisibility(0);
        this.gsd.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_outcome, (ViewGroup) null);
        this.gsd.addView(inflate, this.gsp);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_show_result);
        textView.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.14
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new t(AlaSnatchRedPacketActivity.this.getPageContext().getPageActivity(), AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bwh)));
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_gift_btn);
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.15
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.bOI();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
        switch (this.gsw) {
            case 100:
            case 103:
            case 104:
                TextView textView3 = (TextView) inflate.findViewById(a.f.rp_snatch_fail);
                textView3.setVisibility(0);
                textView2.setVisibility(8);
                if (this.gsw == 103) {
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
                textView4.setText(String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.gsr.bUs())));
                textView4.setVisibility(0);
                return;
            case 102:
                textView2.setVisibility(0);
                TextView textView5 = (TextView) inflate.findViewById(a.f.rp_snatched);
                textView5.setVisibility(0);
                textView5.setText(getPageContext().getString(a.h.snatch_red_packet_loot_prefix) + String.format(getResources().getString(a.h.snatch_red_packet_t_dou_suffix), Long.valueOf(this.gsq.bUs())));
                return;
            default:
                return;
        }
    }

    private void bOM() {
        this.gsb.setVisibility(0);
        this.gsa.setVisibility(8);
        this.gsd.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_snatch, (ViewGroup) null);
        this.gsd.addView(inflate, this.gsp);
        ((TextView) inflate.findViewById(a.f.rp_follow_tip)).setVisibility(0);
        ((TextView) inflate.findViewById(a.f.rp_total_amount)).setText(String.format(getResources().getString(a.h.send_ref_packet_desc), Long.valueOf(this.gsq.gUa.gUH)));
        this.gsj = (FrameLayout) inflate.findViewById(a.f.rp_snatch_layout);
        if (UtilHelper.getRealScreenOrientation(this) == 2) {
            FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gsj.getLayoutParams();
            layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
            this.gsj.setLayoutParams(layoutParams);
        }
        this.gsk = (ImageView) inflate.findViewById(a.f.rp_snatch_btn);
        this.gsk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AlaSnatchRedPacketActivity.this.gsk.setEnabled(false);
                AlaSnatchRedPacketActivity.this.mHandler.postDelayed(AlaSnatchRedPacketActivity.this.gsA, 1000L);
                AlaStatsItem alaStatsItem = new AlaStatsItem();
                if (AlaSnatchRedPacketActivity.this.gsq != null && AlaSnatchRedPacketActivity.this.gsq.gUa != null) {
                    alaStatsItem.addValue("redpacketId", AlaSnatchRedPacketActivity.this.gsq.gUa.id);
                }
                AlaStatManager.getInstance().debug("redpacket_loot_before", "", "", alaStatsItem);
                AlaSnatchRedPacketActivity.this.gsl.aA(AlaSnatchRedPacketActivity.this.mRedPacketId, AlaSnatchRedPacketActivity.this.mLiveId, AlaSnatchRedPacketActivity.this.bwh);
            }
        });
        this.gse = (FrameLayout) inflate.findViewById(a.f.rp_count_down_layout);
        this.gsf = (RoundProgressBar) inflate.findViewById(a.f.rp_snatch_progress);
        this.gsg = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_min);
        this.gsi = (ImageView) inflate.findViewById(a.f.rp_snatch_countdown_dot);
        this.gsi.setVisibility(8);
        this.gsh = (TextView) inflate.findViewById(a.f.rp_snatch_countdown_second);
        if (!this.gsq.bUq()) {
            this.gsk.setVisibility(0);
            this.gse.setVisibility(8);
            mj(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bON() {
        bOQ();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fd(long j) {
        if (this.gsq != null) {
            String[] fl = this.gsq.fl(j);
            if (j <= 60) {
                if (!this.gst) {
                    this.gst = true;
                    if (this.gsi != null) {
                        this.gsi.setVisibility(8);
                    }
                    if (this.gsh != null) {
                        this.gsh.setVisibility(8);
                    }
                    if (this.gsg != null) {
                        this.gsg.setTextSize(0, getResources().getDimensionPixelSize(a.d.sdk_ds108));
                    }
                }
                if (this.gsg != null) {
                    this.gsg.setText(fl[1]);
                }
            } else {
                if (this.gsi != null && this.gsi.getVisibility() != 0) {
                    this.gsi.setVisibility(0);
                }
                if (this.gsg != null) {
                    this.gsg.setText(fl[0]);
                }
                if (this.gsh != null) {
                    this.gsh.setText(fl[1]);
                }
            }
            if (this.gsf != null) {
                this.gsf.setProgress(this.gsq.fk(j));
            }
        }
    }

    private void bOO() {
        this.gsb.setVisibility(8);
        this.gsa.setVisibility(0);
        this.gsd.removeAllViews();
        View inflate = LayoutInflater.from(getPageContext().getPageActivity()).inflate(a.g.ala_red_packet_condition, (ViewGroup) null);
        this.gsd.addView(inflate, this.gsp);
        TextView textView = (TextView) inflate.findViewById(a.f.rp_condition_desc);
        TextView textView2 = (TextView) inflate.findViewById(a.f.rp_condition_btn);
        if (this.gsq.bUv()) {
            this.gss = false;
            textView.setText(a.h.snatch_red_packet_cond_follow_desc);
            textView2.setText(a.h.snatch_red_packet_follow_btn);
        } else if (this.gsq.bUw()) {
            this.gss = true;
            textView.setText(a.h.snatch_red_packet_cond_gift_desc);
            textView2.setText(a.h.snatch_red_packet_gift_btn);
        }
        textView2.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.4
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (AlaSnatchRedPacketActivity.this.gss) {
                    AlaSnatchRedPacketActivity.this.bOI();
                    AlaSnatchRedPacketActivity.this.finish();
                    return;
                }
                AlaSnatchRedPacketActivity.this.bsJ();
                AlaSnatchRedPacketActivity.this.finish();
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bsJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913131, null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOP() {
        String str = this.gsq.gUb.gUi;
        com.baidu.live.data.f fVar = new com.baidu.live.data.f(this.gsq.gUa.portrait, str, true, getUniqueId());
        fVar.setFrom("source_snatch_red_packet");
        com.baidu.live.view.a.Xr().a(str, fVar);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bOI() {
        ao aoVar = new ao();
        aoVar.aLw = -1;
        aoVar.aLx = -1;
        aoVar.aLz = null;
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913055, aoVar));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void mj(boolean z) {
        this.gso = ValueAnimator.ofFloat(1.0f, 0.8f);
        this.gso.setDuration(250L);
        this.gso.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.5
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                AlaSnatchRedPacketActivity.this.gsk.setScaleX(floatValue);
                AlaSnatchRedPacketActivity.this.gsk.setScaleY(floatValue);
            }
        });
        this.gso.setRepeatCount(-1);
        this.gso.setRepeatMode(2);
        this.gso.start();
        AlaStatsItem alaStatsItem = new AlaStatsItem();
        if (this.gsq != null && this.gsq.gUa != null) {
            alaStatsItem.addValue("redpacketId", this.gsq.gUa.id);
        }
        alaStatsItem.addValue("source", z ? "countdown_finish" : "redpacket_status_3");
        AlaStatManager.getInstance().debug("redpacket_loot_enable", "", "", alaStatsItem);
    }

    private void bOQ() {
        this.gse.setVisibility(0);
        this.gsk.setVisibility(0);
        this.gsn = ValueAnimator.ofFloat(0.0f, 1.0f);
        this.gsn.setDuration(500L);
        this.gsn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.6
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedFraction = valueAnimator.getAnimatedFraction();
                AlaSnatchRedPacketActivity.this.gse.setAlpha(1.0f - animatedFraction);
                AlaSnatchRedPacketActivity.this.gsk.setAlpha(animatedFraction);
                float f = (float) (animatedFraction * 0.5d);
                AlaSnatchRedPacketActivity.this.gse.setScaleX(1.0f - f);
                AlaSnatchRedPacketActivity.this.gse.setScaleY(1.0f - f);
                AlaSnatchRedPacketActivity.this.gsk.setScaleX((float) (f + 0.5d));
                AlaSnatchRedPacketActivity.this.gsk.setScaleY((float) (f + 0.5d));
            }
        });
        this.gsn.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.AlaSnatchRedPacketActivity.7
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                AlaSnatchRedPacketActivity.this.mj(true);
                AlaSnatchRedPacketActivity.this.gse.setVisibility(8);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        this.gsn.start();
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
            com.baidu.live.utils.i.ae(this.cFi);
            this.cFi.setScaleX(0.7f);
            this.cFi.setScaleY(0.7f);
            if (this.gsj != null) {
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) this.gsj.getLayoutParams();
                layoutParams.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds126);
                this.gsj.setLayoutParams(layoutParams);
                return;
            }
            return;
        }
        com.baidu.live.utils.i.af(this.cFi);
        this.cFi.setScaleX(1.0f);
        this.cFi.setScaleY(1.0f);
        if (this.gsj != null) {
            FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.gsj.getLayoutParams();
            layoutParams2.topMargin = getResources().getDimensionPixelSize(a.d.sdk_ds146);
            this.gsj.setLayoutParams(layoutParams2);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.live.tbadk.core.BaseFragmentActivity, com.baidu.live.adp.base.BdBaseFragmentActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public void onDestroy() {
        if (this.gsl != null) {
            this.gsl.onDestroy();
        }
        if (this.gso != null) {
            this.gso.removeAllListeners();
            this.gso.cancel();
            this.gso = null;
        }
        if (this.gsn != null) {
            this.gsn.removeAllListeners();
            this.gsn.cancel();
            this.gsn = null;
        }
        if (this.gso != null) {
            this.gso.removeAllUpdateListeners();
        }
        this.mHandler.removeCallbacksAndMessages(null);
        MessageManager.getInstance().unRegisterListener(this.gsz);
        MessageManager.getInstance().unRegisterListener(this.gsx);
        MessageManager.getInstance().unRegisterListener(this.axL);
        super.onDestroy();
    }
}
