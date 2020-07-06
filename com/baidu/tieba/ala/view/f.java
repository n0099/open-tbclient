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
import com.baidu.live.c.o;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.f.i;
import com.baidu.tieba.ala.f.j;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class f implements com.baidu.live.q.c {
    private AnimatorSet aIN;
    private String aMu;
    private int ayf;
    private long ffd;
    private ImageView gIG;
    private ImageView gIH;
    private FrameLayout gII;
    private BdUniqueId gIJ;
    private i gIK;
    private m gIL;
    private long gIO;
    private boolean gIP;
    private long gIe;
    private int gom;
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
    private long gIF = 5000;
    private Handler mHandler = new Handler();
    private boolean fxP = true;
    private boolean gIM = false;
    private long gIN = 17;
    private String gIQ = "default";
    private ArrayList<String> gIR = new ArrayList<>();
    private Map<String, Long> gIS = new HashMap();
    private final Runnable fOd = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.gIe <= 0) {
                f.this.gIe = 0L;
            } else {
                if (f.this.gIe == 300 && f.this.gIL != null && !f.this.gIR.contains(f.this.gIL.Ji())) {
                    f.this.gIR.add(f.this.gIL.Ji());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.gIe <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.gIS.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.gIJ = BdUniqueId.gen();
                    f.this.gIK.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.gIJ);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.DG("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.aMu, f.this.gIQ, f.this.otherParams);
        }
    };
    private j fFy = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m bKH = alaGetHourRankListResponseMessage.bKH();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.gIJ) {
                    f.this.d(bKH);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.aZD) {
                    f.this.e(bKH);
                }
                f.this.gIF = bKH.bwH();
                f.this.gIN = bKH.bwI();
            }
            if (!f.this.gIM && f.this.gIT != null) {
                f.this.mHandler.removeCallbacks(f.this.gIT);
                f.this.mHandler.postDelayed(f.this.gIT, f.this.gIF);
            }
        }
    };
    private Runnable gIT = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.gIK != null) {
                f.this.gIK.g(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aZD = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.gIe;
        fVar.gIe = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.ayf = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aMu = str4;
        this.ffd = j2;
        this.otherParams = str3;
        initView();
        this.gIK = new i(this.aZD, this.fFy);
        this.gIK.g(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.fOd);
            this.mHandler.postDelayed(this.fOd, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).fDW != null && mVar.getList().get(0).fDW.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).dMs == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).fDW.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aMu;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.gIS.put(mVar.Ji(), Long.valueOf(mVar.bwK()));
            if (a(this.gIL, mVar)) {
                this.gIO = System.currentTimeMillis();
                dR(f(mVar), b(this.gIL, mVar));
                this.gIL = mVar;
            } else {
                this.gIL = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.gom = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.bwL() != null && !this.gIP) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.gIe = mVar.bwJ();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.gIO = System.currentTimeMillis();
        this.gIL = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.gIO < this.gIN * 1000 || mVar == null || mVar.bwL() == null) {
            return false;
        }
        if (mVar.bwL().fEo > 0 || mVar2.bwL().fEo <= 0) {
            return (mVar.bwL().fEo > 0 || mVar2.bwL().fEo > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.bwL().fEo < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.bwL().fEo) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.bwL().fEo == mVar2.bwL().fEo) {
            this.gIQ = "change";
            if (mVar2.bwL().fEo <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.bwL().fEo == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.bwL().fEp - mVar2.bwL().fEr) + "");
            } else if (mVar2.bwL().fEo <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.bwL().fEq - mVar2.bwL().fEp) + 1) + "");
            }
        }
        this.gIQ = "up_down";
        int i = mVar2.bwL().fEo - mVar.bwL().fEo;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.gII = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.gIG = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.gIH = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.gII.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.q.c
    public View GB() {
        return this.mRootView;
    }

    @Override // com.baidu.live.q.c
    public com.baidu.live.q.b GC() {
        return null;
    }

    @Override // com.baidu.live.q.c
    public com.baidu.live.q.b GD() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DG(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new o(this.mContext, this.ayf, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aMu, this.ffd, this.gIL == null ? com.baidu.live.utils.i.dC(0) : this.gIL.Ji())));
    }

    @Override // com.baidu.live.q.c
    public void GE() {
        this.gIM = false;
        if (this.gIK != null) {
            this.gIK.g(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.q.c
    public void GF() {
        this.gIM = true;
        this.mHandler.removeCallbacks(this.gIT);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void DH(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.gII.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gII.getLayoutParams();
            layoutParams.width = this.gom + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.gII.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.gIG.setVisibility(0);
        this.gIH.setVisibility(0);
        if (textWidth > this.gom) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.gom) * 1.0f) / this.gom), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void dR(final String str, final String str2) {
        if (this.aIN == null) {
            this.aIN = new AnimatorSet();
        }
        this.aIN.cancel();
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
                f.this.DH(str2);
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
                f.this.gIG.setVisibility(4);
                f.this.gIH.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.aIN.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.gIP = false;
                f.this.gIQ = "default";
                f.this.gII.setAlpha(0.7f);
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
        this.aIN.playTogether(this.mAnimators);
        this.aIN.start();
        this.gIP = true;
        this.gII.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.gII.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.gII.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.gII.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.gom = textWidth;
        }
    }

    @Override // com.baidu.live.q.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gIK != null) {
            this.gIK.destory();
        }
    }
}
