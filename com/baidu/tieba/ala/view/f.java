package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.c.n;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.u.a;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.e.i;
import com.baidu.tieba.ala.e.j;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class f implements com.baidu.live.p.c {
    private int Yx;
    private int ail;
    private AnimatorSet aiq;
    private String alH;
    private long ehY;
    private long fAX;
    private ImageView fBB;
    private ImageView fBC;
    private FrameLayout fBD;
    private BdUniqueId fBE;
    private i fBF;
    private m fBG;
    private long fBJ;
    private boolean fBK;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private boolean mHasInited;
    private boolean mIsHost;
    private Paint mPaint;
    private String mPortrait;
    private LinearLayout mRootView;
    private TextView mTextView;
    private long mUserId;
    private String mUserName;
    private String otherParams;
    private long fBA = 5000;
    private Handler mHandler = new Handler();
    private boolean eTJ = true;
    private boolean fBH = false;
    private long fBI = 17;
    private String fBL = "default";
    private ArrayList<String> fBM = new ArrayList<>();
    private Map<String, Long> fBN = new HashMap();
    private final Runnable eKd = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fAX <= 0) {
                f.this.fAX = 0L;
            } else {
                if (f.this.fAX == 300 && f.this.fBG != null && !f.this.fBM.contains(f.this.fBG.AY())) {
                    f.this.fBM.add(f.this.fBG.AY());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.fAX <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.fBN.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.fBE = BdUniqueId.gen();
                    f.this.fBF.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.fBE);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.zL("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.alH, f.this.fBL, f.this.otherParams);
        }
    };
    private j eBC = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m brA = alaGetHourRankListResponseMessage.brA();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.fBE) {
                    f.this.d(brA);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.arS) {
                    f.this.e(brA);
                }
                f.this.fBA = brA.bey();
                f.this.fBI = brA.bez();
            }
            if (!f.this.fBH && f.this.fBO != null) {
                f.this.mHandler.removeCallbacks(f.this.fBO);
                f.this.mHandler.postDelayed(f.this.fBO, f.this.fBA);
            }
        }
    };
    private Runnable fBO = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fBF != null) {
                f.this.fBF.f(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId arS = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.fAX;
        fVar.fAX = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.Yx = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.alH = str4;
        this.ehY = j2;
        this.otherParams = str3;
        initView();
        this.fBF = new i(this.arS, this.eBC);
        this.fBF.f(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.eKd);
            this.mHandler.postDelayed(this.eKd, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).eAa != null && mVar.getList().get(0).eAa.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).cSm == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).eAa.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.alH;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.fBN.put(mVar.AY(), Long.valueOf(mVar.beB()));
            if (a(this.fBG, mVar)) {
                this.fBJ = System.currentTimeMillis();
                cZ(f(mVar), b(this.fBG, mVar));
                this.fBG = mVar;
            } else {
                this.fBG = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.ail = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.beC() != null && !this.fBK) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.fAX = mVar.beA();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fBJ = System.currentTimeMillis();
        this.fBG = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.fBJ < this.fBI * 1000 || mVar == null || mVar.beC() == null) {
            return false;
        }
        if (mVar.beC().eAt > 0 || mVar2.beC().eAt <= 0) {
            return (mVar.beC().eAt > 0 || mVar2.beC().eAt > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.beC().eAt < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.beC().eAt) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.beC().eAt == mVar2.beC().eAt) {
            this.fBL = "change";
            if (mVar2.beC().eAt <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.beC().eAt == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.beC().eAu - mVar2.beC().eAw) + "");
            } else if (mVar2.beC().eAt <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.beC().eAv - mVar2.beC().eAu) + 1) + "");
            }
        }
        this.fBL = "up_down";
        int i = mVar2.beC().eAt - mVar.beC().eAt;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.fBD = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.fBB = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.fBC = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.fBD.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.p.c
    public View zb() {
        return this.mRootView;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b zc() {
        return null;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b zd() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(this.mContext, this.Yx, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.alH, this.ehY, this.fBG == null ? com.baidu.live.utils.i.cW(0) : this.fBG.AY())));
    }

    @Override // com.baidu.live.p.c
    public void ze() {
        this.fBH = false;
        if (this.fBF != null) {
            this.fBF.f(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.p.c
    public void zf() {
        this.fBH = true;
        this.mHandler.removeCallbacks(this.fBO);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zM(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.fBD.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fBD.getLayoutParams();
            layoutParams.width = this.ail + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.fBD.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.fBB.setVisibility(0);
        this.fBC.setVisibility(0);
        if (textWidth > this.ail) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.ail) * 1.0f) / this.ail), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void cZ(final String str, final String str2) {
        if (this.aiq == null) {
            this.aiq = new AnimatorSet();
        }
        this.aiq.cancel();
        this.mRootView.setPivotX(0.0f);
        this.mRootView.setPivotY(0.0f);
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "scaleX", 1.0f, 1.2f);
        final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "scaleY", 1.0f, 1.2f);
        ofFloat.setDuration(500L);
        ofFloat2.setDuration(500L);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.view.f.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ofFloat.cancel();
                ofFloat.removeAllListeners();
                ofFloat2.cancel();
                f.this.zM(str2);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        final ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.mRootView, "scaleX", 1.2f, 1.0f);
        final ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(this.mRootView, "scaleY", 1.2f, 1.0f);
        ofFloat3.setDuration(500L);
        ofFloat3.setStartDelay(3300L);
        ofFloat4.setDuration(500L);
        ofFloat4.setStartDelay(3300L);
        ofFloat3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.view.f.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                f.this.fBB.setVisibility(4);
                f.this.fBC.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.aiq.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.fBK = false;
                f.this.fBL = "default";
                f.this.fBD.setAlpha(0.7f);
                f.this.mTextView.setAlpha(0.7f);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
        if (this.mAnimators == null) {
            this.mAnimators = new ArrayList<>();
        }
        this.mAnimators.clear();
        this.mAnimators.add(ofFloat);
        this.mAnimators.add(ofFloat2);
        this.mAnimators.add(ofFloat3);
        this.mAnimators.add(ofFloat4);
        this.aiq.playTogether(this.mAnimators);
        this.aiq.start();
        this.fBK = true;
        this.fBD.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.fBD.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fBD.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.fBD.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.ail = textWidth;
        }
    }

    @Override // com.baidu.live.p.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fBF != null) {
            this.fBF.destory();
        }
    }
}
