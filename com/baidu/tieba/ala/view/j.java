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
import com.baidu.live.b.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.g.m;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class j implements com.baidu.live.s.c {
    private int aFQ;
    private AnimatorSet aRA;
    private String aVs;
    private long fyR;
    private int gJP;
    private long heY;
    private ImageView hfH;
    private ImageView hfI;
    private FrameLayout hfJ;
    private BdUniqueId hfK;
    private m hfL;
    private n hfM;
    private long hfP;
    private boolean hfQ;
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
    private long hfG = 5000;
    private Handler mHandler = new Handler();
    private boolean fRC = true;
    private boolean hfN = false;
    private long hfO = 17;
    private String hfR = "default";
    private ArrayList<String> hfS = new ArrayList<>();
    private Map<String, Long> hfT = new HashMap();
    private final Runnable giK = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.heY <= 0) {
                j.this.heY = 0L;
            } else {
                if (j.this.heY == 300 && j.this.hfM != null && !j.this.hfS.contains(j.this.hfM.PK())) {
                    j.this.hfS.add(j.this.hfM.PK());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.heY <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.hfT.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.hfK = BdUniqueId.gen();
                    j.this.hfL.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.hfK);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.Hm("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.aVs, j.this.hfR, j.this.otherParams);
        }
    };
    private com.baidu.tieba.ala.g.n gai = new com.baidu.tieba.ala.g.n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                n bZv = alaGetHourRankListResponseMessage.bZv();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.hfK) {
                    j.this.d(bZv);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.bhK) {
                    j.this.e(bZv);
                }
                j.this.hfG = bZv.bKk();
                j.this.hfO = bZv.bKl();
            }
            if (!j.this.hfN && j.this.hfU != null) {
                j.this.mHandler.removeCallbacks(j.this.hfU);
                j.this.mHandler.postDelayed(j.this.hfU, j.this.hfG);
            }
        }
    };
    private Runnable hfU = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hfL != null) {
                j.this.hfL.h(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId bhK = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.heY;
        jVar.heY = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aFQ = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aVs = str4;
        this.fyR = j2;
        this.otherParams = str3;
        initView();
        this.hfL = new m(this.bhK, this.gai);
        this.hfL.h(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.giK);
            this.mHandler.postDelayed(this.giK, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar) {
        if (nVar != null && nVar.getList() != null && nVar.getList().size() > 0 && nVar.getList().get(0).fYb != null && nVar.getList().get(0).fYb.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = nVar.getList().get(0).getName_show();
            if (nVar.getList().get(0).een == 1) {
                alaBroadcastGiftToastData.live_id = nVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = nVar.getList().get(0).fYb.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aVs;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        if (nVar != null) {
            this.hfT.put(nVar.PK(), Long.valueOf(nVar.bKn()));
            if (a(this.hfM, nVar)) {
                this.hfP = System.currentTimeMillis();
                ep(f(nVar), b(this.hfM, nVar));
                this.hfM = nVar;
            } else {
                this.hfM = nVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(nVar));
                    this.mRootView.setVisibility(0);
                    this.gJP = BdUtilHelper.getTextWidth(this.mPaint, f(nVar));
                } else if (nVar.bKo() != null && !this.hfQ) {
                    c(this.mTextView, f(nVar));
                }
            }
            this.heY = nVar.bKm();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hfP = System.currentTimeMillis();
        this.hfM = null;
    }

    private boolean a(n nVar, n nVar2) {
        if (nVar2 == null || System.currentTimeMillis() - this.hfP < this.hfO * 1000 || nVar == null || nVar.bKo() == null) {
            return false;
        }
        if (nVar.bKo().aDW > 0 || nVar2.bKo().aDW <= 0) {
            return (nVar.bKo().aDW > 0 || nVar2.bKo().aDW > 0) ? true : true;
        }
        return false;
    }

    private String f(n nVar) {
        if (nVar.bKo().aDW < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(nVar.bKo().aDW) + "");
    }

    private String b(n nVar, n nVar2) {
        if (nVar.bKo().aDW == nVar2.bKo().aDW) {
            this.hfR = "change";
            if (nVar2.bKo().aDW <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (nVar2.bKo().aDW == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(nVar2.bKo().aDX - nVar2.bKo().aDZ) + "");
            } else if (nVar2.bKo().aDW <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((nVar2.bKo().aDY - nVar2.bKo().aDX) + 1) + "");
            }
        }
        this.hfR = "up_down";
        int i = nVar2.bKo().aDW - nVar.bKo().aDW;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.hfJ = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.hfH = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.hfI = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.hfJ.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.s.c
    public View Nc() {
        return this.mRootView;
    }

    @Override // com.baidu.live.s.c
    public com.baidu.live.s.b Nd() {
        return null;
    }

    @Override // com.baidu.live.s.c
    public com.baidu.live.s.b Ne() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hm(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(this.mContext, this.aFQ, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aVs, this.fyR, this.hfM == null ? com.baidu.live.utils.j.fH(0) : this.hfM.PK())));
    }

    @Override // com.baidu.live.s.c
    public void Nf() {
        this.hfN = false;
        if (this.hfL != null) {
            this.hfL.h(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.s.c
    public void Ng() {
        this.hfN = true;
        this.mHandler.removeCallbacks(this.hfU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hn(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.hfJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hfJ.getLayoutParams();
            layoutParams.width = this.gJP + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.hfJ.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.hfH.setVisibility(0);
        this.hfI.setVisibility(0);
        if (textWidth > this.gJP) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.gJP) * 1.0f) / this.gJP), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void ep(final String str, final String str2) {
        if (this.aRA == null) {
            this.aRA = new AnimatorSet();
        }
        this.aRA.cancel();
        this.mRootView.setPivotX(0.0f);
        this.mRootView.setPivotY(0.0f);
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "scaleX", 1.0f, 1.2f);
        final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "scaleY", 1.0f, 1.2f);
        ofFloat.setDuration(500L);
        ofFloat2.setDuration(500L);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.view.j.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ofFloat.cancel();
                ofFloat.removeAllListeners();
                ofFloat2.cancel();
                j.this.Hn(str2);
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
        ofFloat3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.view.j.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                j.this.hfH.setVisibility(4);
                j.this.hfI.setVisibility(4);
                j.this.c(j.this.mTextView, str);
                j.this.aRA.cancel();
                j.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                j.this.mTextView.clearAnimation();
                j.this.hfQ = false;
                j.this.hfR = "default";
                j.this.hfJ.setAlpha(0.7f);
                j.this.mTextView.setAlpha(0.7f);
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
        this.aRA.playTogether(this.mAnimators);
        this.aRA.start();
        this.hfQ = true;
        this.hfJ.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.hfJ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.hfJ.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.hfJ.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.gJP = textWidth;
        }
    }

    @Override // com.baidu.live.s.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hfL != null) {
            this.hfL.destory();
        }
    }
}
