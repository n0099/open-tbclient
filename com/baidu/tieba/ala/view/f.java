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
import com.baidu.live.q.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.e.i;
import com.baidu.tieba.ala.e.j;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class f implements com.baidu.live.l.c {
    private int Ws;
    private int afs;
    private AnimatorSet afx;
    private String aiO;
    private long edz;
    private long fuZ;
    private ImageView fvD;
    private ImageView fvE;
    private FrameLayout fvF;
    private BdUniqueId fvG;
    private i fvH;
    private m fvI;
    private long fvL;
    private boolean fvM;
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
    private long fvC = 5000;
    private Handler mHandler = new Handler();
    private boolean eNV = true;
    private boolean fvJ = false;
    private long fvK = 17;
    private String fvN = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    private ArrayList<String> fvO = new ArrayList<>();
    private Map<String, Long> fvP = new HashMap();
    private final Runnable eEL = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fuZ <= 0) {
                f.this.fuZ = 0L;
            } else {
                if (f.this.fuZ == 300 && f.this.fvI != null && !f.this.fvO.contains(f.this.fvI.yp())) {
                    f.this.fvO.add(f.this.fvI.yp());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.fuZ <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.fvP.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.fvG = BdUniqueId.gen();
                    f.this.fvH.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.fvG);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.zk("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.aiO, f.this.fvN, f.this.otherParams);
        }
    };
    private j evT = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m boS = alaGetHourRankListResponseMessage.boS();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.fvG) {
                    f.this.d(boS);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.anM) {
                    f.this.e(boS);
                }
                f.this.fvC = boS.bbL();
                f.this.fvK = boS.bbM();
            }
            if (!f.this.fvJ && f.this.fvQ != null) {
                f.this.mHandler.removeCallbacks(f.this.fvQ);
                f.this.mHandler.postDelayed(f.this.fvQ, f.this.fvC);
            }
        }
    };
    private Runnable fvQ = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fvH != null) {
                f.this.fvH.f(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId anM = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.fuZ;
        fVar.fuZ = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.Ws = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aiO = str4;
        this.edz = j2;
        this.otherParams = str3;
        initView();
        this.fvH = new i(this.anM, this.evT);
        this.fvH.f(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.eEL);
            this.mHandler.postDelayed(this.eEL, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).euq != null && mVar.getList().get(0).euq.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).cNX == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).euq.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aiO;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.fvP.put(mVar.yp(), Long.valueOf(mVar.bbO()));
            if (a(this.fvI, mVar)) {
                this.fvL = System.currentTimeMillis();
                cP(f(mVar), b(this.fvI, mVar));
                this.fvI = mVar;
            } else {
                this.fvI = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.afs = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.bbP() != null && !this.fvM) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.fuZ = mVar.bbN();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fvL = System.currentTimeMillis();
        this.fvI = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.fvL < this.fvK * 1000 || mVar == null || mVar.bbP() == null) {
            return false;
        }
        if (mVar.bbP().euJ > 0 || mVar2.bbP().euJ <= 0) {
            return (mVar.bbP().euJ > 0 || mVar2.bbP().euJ > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.bbP().euJ < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.bbP().euJ) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.bbP().euJ == mVar2.bbP().euJ) {
            this.fvN = "change";
            if (mVar2.bbP().euJ <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.bbP().euJ == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.bbP().euK - mVar2.bbP().euM) + "");
            } else if (mVar2.bbP().euJ <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.bbP().euL - mVar2.bbP().euK) + 1) + "");
            }
        }
        this.fvN = "up_down";
        int i = mVar2.bbP().euJ - mVar.bbP().euJ;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.fvF = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.fvD = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.fvE = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.fvF.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.l.c
    public View wr() {
        return this.mRootView;
    }

    @Override // com.baidu.live.l.c
    public com.baidu.live.l.b ws() {
        return null;
    }

    @Override // com.baidu.live.l.c
    public com.baidu.live.l.b wt() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zk(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new com.baidu.live.c.m(this.mContext, this.Ws, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aiO, this.edz, this.fvI == null ? com.baidu.live.utils.i.cF(0) : this.fvI.yp())));
    }

    @Override // com.baidu.live.l.c
    public void wu() {
        this.fvJ = false;
        if (this.fvH != null) {
            this.fvH.f(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.l.c
    public void wv() {
        this.fvJ = true;
        this.mHandler.removeCallbacks(this.fvQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zl(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.fvF.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fvF.getLayoutParams();
            layoutParams.width = this.afs + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.fvF.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.fvD.setVisibility(0);
        this.fvE.setVisibility(0);
        if (textWidth > this.afs) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.afs) * 1.0f) / this.afs), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void cP(final String str, final String str2) {
        if (this.afx == null) {
            this.afx = new AnimatorSet();
        }
        this.afx.cancel();
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
                f.this.zl(str2);
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
                f.this.fvD.setVisibility(4);
                f.this.fvE.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.afx.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.fvM = false;
                f.this.fvN = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
                f.this.fvF.setAlpha(0.7f);
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
        this.afx.playTogether(this.mAnimators);
        this.afx.start();
        this.fvM = true;
        this.fvF.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.fvF.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fvF.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.fvF.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.afs = textWidth;
        }
    }

    @Override // com.baidu.live.l.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fvH != null) {
            this.fvH.destory();
        }
    }
}
