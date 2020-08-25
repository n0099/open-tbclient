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
import com.baidu.live.c.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.i;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.f.j;
import com.baidu.tieba.ala.f.k;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes7.dex */
public class h implements com.baidu.live.q.c {
    private int aED;
    private AnimatorSet aPw;
    private String aTc;
    private long fvC;
    private int gGm;
    private long haA;
    private ImageView hbc;
    private ImageView hbd;
    private FrameLayout hbe;
    private BdUniqueId hbf;
    private j hbg;
    private n hbh;
    private long hbk;
    private boolean hbl;
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
    private long hbb = 5000;
    private Handler mHandler = new Handler();
    private boolean fOn = true;
    private boolean hbi = false;
    private long hbj = 17;
    private String hbm = "default";
    private ArrayList<String> hbn = new ArrayList<>();
    private Map<String, Long> hbo = new HashMap();
    private final Runnable gfv = new Runnable() { // from class: com.baidu.tieba.ala.view.h.1
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.haA <= 0) {
                h.this.haA = 0L;
            } else {
                if (h.this.haA == 300 && h.this.hbh != null && !h.this.hbn.contains(h.this.hbh.Ph())) {
                    h.this.hbn.add(h.this.hbh.Ph());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                h.d(h.this);
            }
            if (h.this.haA <= 1) {
                h.this.resetData();
            }
            for (Map.Entry entry : h.this.hbo.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    h.this.hbf = BdUniqueId.gen();
                    h.this.hbg.a(h.this.mUserId, (String) entry.getKey(), 1, 1, h.this.hbf);
                }
            }
            h.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.GQ("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(h.this.aTc, h.this.hbm, h.this.otherParams);
        }
    };
    private k fWR = new k() { // from class: com.baidu.tieba.ala.view.h.3
        @Override // com.baidu.tieba.ala.f.k
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                n bXN = alaGetHourRankListResponseMessage.bXN();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == h.this.hbf) {
                    h.this.d(bXN);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == h.this.beV) {
                    h.this.e(bXN);
                }
                h.this.hbb = bXN.bJa();
                h.this.hbj = bXN.bJb();
            }
            if (!h.this.hbi && h.this.hbp != null) {
                h.this.mHandler.removeCallbacks(h.this.hbp);
                h.this.mHandler.postDelayed(h.this.hbp, h.this.hbb);
            }
        }
    };
    private Runnable hbp = new Runnable() { // from class: com.baidu.tieba.ala.view.h.4
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.hbg != null) {
                h.this.hbg.h(h.this.mUserId, "");
            }
        }
    };
    private BdUniqueId beV = BdUniqueId.gen();

    static /* synthetic */ long d(h hVar) {
        long j = hVar.haA;
        hVar.haA = j - 1;
        return j;
    }

    public h(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aED = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aTc = str4;
        this.fvC = j2;
        this.otherParams = str3;
        initView();
        this.hbg = new j(this.beV, this.fWR);
        this.hbg.h(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.gfv);
            this.mHandler.postDelayed(this.gfv, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar) {
        if (nVar != null && nVar.getList() != null && nVar.getList().size() > 0 && nVar.getList().get(0).fUI != null && nVar.getList().get(0).fUI.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = nVar.getList().get(0).getName_show();
            if (nVar.getList().get(0).ebZ == 1) {
                alaBroadcastGiftToastData.live_id = nVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = nVar.getList().get(0).fUI.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aTc;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        if (nVar != null) {
            this.hbo.put(nVar.Ph(), Long.valueOf(nVar.bJd()));
            if (a(this.hbh, nVar)) {
                this.hbk = System.currentTimeMillis();
                ek(f(nVar), b(this.hbh, nVar));
                this.hbh = nVar;
            } else {
                this.hbh = nVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(nVar));
                    this.mRootView.setVisibility(0);
                    this.gGm = BdUtilHelper.getTextWidth(this.mPaint, f(nVar));
                } else if (nVar.bJe() != null && !this.hbl) {
                    b(this.mTextView, f(nVar));
                }
            }
            this.haA = nVar.bJc();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hbk = System.currentTimeMillis();
        this.hbh = null;
    }

    private boolean a(n nVar, n nVar2) {
        if (nVar2 == null || System.currentTimeMillis() - this.hbk < this.hbj * 1000 || nVar == null || nVar.bJe() == null) {
            return false;
        }
        if (nVar.bJe().fVa > 0 || nVar2.bJe().fVa <= 0) {
            return (nVar.bJe().fVa > 0 || nVar2.bJe().fVa > 0) ? true : true;
        }
        return false;
    }

    private String f(n nVar) {
        if (nVar.bJe().fVa < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(nVar.bJe().fVa) + "");
    }

    private String b(n nVar, n nVar2) {
        if (nVar.bJe().fVa == nVar2.bJe().fVa) {
            this.hbm = "change";
            if (nVar2.bJe().fVa <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (nVar2.bJe().fVa == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(nVar2.bJe().fVb - nVar2.bJe().fVd) + "");
            } else if (nVar2.bJe().fVa <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((nVar2.bJe().fVc - nVar2.bJe().fVb) + 1) + "");
            }
        }
        this.hbm = "up_down";
        int i = nVar2.bJe().fVa - nVar.bJe().fVa;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.hbe = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.hbc = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.hbd = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.hbe.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.q.c
    public View Mu() {
        return this.mRootView;
    }

    @Override // com.baidu.live.q.c
    public com.baidu.live.q.b Mv() {
        return null;
    }

    @Override // com.baidu.live.q.c
    public com.baidu.live.q.b Mw() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GQ(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(this.mContext, this.aED, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aTc, this.fvC, this.hbh == null ? i.fw(0) : this.hbh.Ph())));
    }

    @Override // com.baidu.live.q.c
    public void Mx() {
        this.hbi = false;
        if (this.hbg != null) {
            this.hbg.h(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.q.c
    public void My() {
        this.hbi = true;
        this.mHandler.removeCallbacks(this.hbp);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GR(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.hbe.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hbe.getLayoutParams();
            layoutParams.width = this.gGm + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.hbe.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.hbc.setVisibility(0);
        this.hbd.setVisibility(0);
        if (textWidth > this.gGm) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.gGm) * 1.0f) / this.gGm), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void ek(final String str, final String str2) {
        if (this.aPw == null) {
            this.aPw = new AnimatorSet();
        }
        this.aPw.cancel();
        this.mRootView.setPivotX(0.0f);
        this.mRootView.setPivotY(0.0f);
        final ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mRootView, "scaleX", 1.0f, 1.2f);
        final ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.mRootView, "scaleY", 1.0f, 1.2f);
        ofFloat.setDuration(500L);
        ofFloat2.setDuration(500L);
        ofFloat.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.view.h.5
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                ofFloat.cancel();
                ofFloat.removeAllListeners();
                ofFloat2.cancel();
                h.this.GR(str2);
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
        ofFloat3.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.view.h.6
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                h.this.hbc.setVisibility(4);
                h.this.hbd.setVisibility(4);
                h.this.b(h.this.mTextView, str);
                h.this.aPw.cancel();
                h.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                h.this.mTextView.clearAnimation();
                h.this.hbl = false;
                h.this.hbm = "default";
                h.this.hbe.setAlpha(0.7f);
                h.this.mTextView.setAlpha(0.7f);
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
        this.aPw.playTogether(this.mAnimators);
        this.aPw.start();
        this.hbl = true;
        this.hbe.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.hbe.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.hbe.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.hbe.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.gGm = textWidth;
        }
    }

    @Override // com.baidu.live.q.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hbg != null) {
            this.hbg.destory();
        }
    }
}
