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
import com.baidu.tieba.ala.f.i;
import com.baidu.tieba.ala.f.j;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes3.dex */
public class f implements com.baidu.live.p.c {
    private AnimatorSet aGp;
    private String aJO;
    private int avX;
    private long eUH;
    private int gbe;
    private ImageView gvH;
    private ImageView gvI;
    private FrameLayout gvJ;
    private BdUniqueId gvK;
    private i gvL;
    private m gvM;
    private long gvP;
    private boolean gvQ;
    private long gvf;
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
    private long gvG = 5000;
    private Handler mHandler = new Handler();
    private boolean fMH = true;
    private boolean gvN = false;
    private long gvO = 17;
    private String gvR = "default";
    private ArrayList<String> gvS = new ArrayList<>();
    private Map<String, Long> gvT = new HashMap();
    private final Runnable fCJ = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.gvf <= 0) {
                f.this.gvf = 0L;
            } else {
                if (f.this.gvf == 300 && f.this.gvM != null && !f.this.gvS.contains(f.this.gvM.HV())) {
                    f.this.gvS.add(f.this.gvM.HV());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.gvf <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.gvT.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.gvK = BdUniqueId.gen();
                    f.this.gvL.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.gvK);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.Df("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.aJO, f.this.gvR, f.this.otherParams);
        }
    };
    private j fud = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m bHA = alaGetHourRankListResponseMessage.bHA();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.gvK) {
                    f.this.d(bHA);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.aWV) {
                    f.this.e(bHA);
                }
                f.this.gvG = bHA.btJ();
                f.this.gvO = bHA.btK();
            }
            if (!f.this.gvN && f.this.gvU != null) {
                f.this.mHandler.removeCallbacks(f.this.gvU);
                f.this.mHandler.postDelayed(f.this.gvU, f.this.gvG);
            }
        }
    };
    private Runnable gvU = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.gvL != null) {
                f.this.gvL.h(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aWV = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.gvf;
        fVar.gvf = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.avX = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aJO = str4;
        this.eUH = j2;
        this.otherParams = str3;
        initView();
        this.gvL = new i(this.aWV, this.fud);
        this.gvL.h(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.fCJ);
            this.mHandler.postDelayed(this.fCJ, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).fsA != null && mVar.getList().get(0).fsA.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).dFH == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).fsA.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aJO;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.gvT.put(mVar.HV(), Long.valueOf(mVar.btM()));
            if (a(this.gvM, mVar)) {
                this.gvP = System.currentTimeMillis();
                dM(f(mVar), b(this.gvM, mVar));
                this.gvM = mVar;
            } else {
                this.gvM = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.gbe = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.btN() != null && !this.gvQ) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.gvf = mVar.btL();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.gvP = System.currentTimeMillis();
        this.gvM = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.gvP < this.gvO * 1000 || mVar == null || mVar.btN() == null) {
            return false;
        }
        if (mVar.btN().fsS > 0 || mVar2.btN().fsS <= 0) {
            return (mVar.btN().fsS > 0 || mVar2.btN().fsS > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.btN().fsS < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.btN().fsS) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.btN().fsS == mVar2.btN().fsS) {
            this.gvR = "change";
            if (mVar2.btN().fsS <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.btN().fsS == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.btN().fsT - mVar2.btN().fsV) + "");
            } else if (mVar2.btN().fsS <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.btN().fsU - mVar2.btN().fsT) + 1) + "");
            }
        }
        this.gvR = "up_down";
        int i = mVar2.btN().fsS - mVar.btN().fsS;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.gvJ = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.gvH = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.gvI = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.gvJ.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.p.c
    public View FS() {
        return this.mRootView;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b FT() {
        return null;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b FU() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Df(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(this.mContext, this.avX, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aJO, this.eUH, this.gvM == null ? com.baidu.live.utils.i.dq(0) : this.gvM.HV())));
    }

    @Override // com.baidu.live.p.c
    public void FV() {
        this.gvN = false;
        if (this.gvL != null) {
            this.gvL.h(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.p.c
    public void FW() {
        this.gvN = true;
        this.mHandler.removeCallbacks(this.gvU);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.gvJ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gvJ.getLayoutParams();
            layoutParams.width = this.gbe + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.gvJ.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.gvH.setVisibility(0);
        this.gvI.setVisibility(0);
        if (textWidth > this.gbe) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.gbe) * 1.0f) / this.gbe), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void dM(final String str, final String str2) {
        if (this.aGp == null) {
            this.aGp = new AnimatorSet();
        }
        this.aGp.cancel();
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
                f.this.Dg(str2);
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
                f.this.gvH.setVisibility(4);
                f.this.gvI.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.aGp.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.gvQ = false;
                f.this.gvR = "default";
                f.this.gvJ.setAlpha(0.7f);
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
        this.aGp.playTogether(this.mAnimators);
        this.aGp.start();
        this.gvQ = true;
        this.gvJ.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.gvJ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.gvJ.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.gvJ.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.gbe = textWidth;
        }
    }

    @Override // com.baidu.live.p.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gvL != null) {
            this.gvL.destory();
        }
    }
}
