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
    private int aEF;
    private AnimatorSet aPy;
    private String aTe;
    private long fvG;
    private int gGq;
    private long haE;
    private ImageView hbg;
    private ImageView hbh;
    private FrameLayout hbi;
    private BdUniqueId hbj;
    private j hbk;
    private n hbl;
    private long hbo;
    private boolean hbp;
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
    private long hbf = 5000;
    private Handler mHandler = new Handler();
    private boolean fOr = true;
    private boolean hbm = false;
    private long hbn = 17;
    private String hbq = "default";
    private ArrayList<String> hbr = new ArrayList<>();
    private Map<String, Long> hbs = new HashMap();
    private final Runnable gfz = new Runnable() { // from class: com.baidu.tieba.ala.view.h.1
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.haE <= 0) {
                h.this.haE = 0L;
            } else {
                if (h.this.haE == 300 && h.this.hbl != null && !h.this.hbr.contains(h.this.hbl.Ph())) {
                    h.this.hbr.add(h.this.hbl.Ph());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                h.d(h.this);
            }
            if (h.this.haE <= 1) {
                h.this.resetData();
            }
            for (Map.Entry entry : h.this.hbs.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    h.this.hbj = BdUniqueId.gen();
                    h.this.hbk.a(h.this.mUserId, (String) entry.getKey(), 1, 1, h.this.hbj);
                }
            }
            h.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.GR("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(h.this.aTe, h.this.hbq, h.this.otherParams);
        }
    };
    private k fWV = new k() { // from class: com.baidu.tieba.ala.view.h.3
        @Override // com.baidu.tieba.ala.f.k
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                n bXO = alaGetHourRankListResponseMessage.bXO();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == h.this.hbj) {
                    h.this.d(bXO);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == h.this.beX) {
                    h.this.e(bXO);
                }
                h.this.hbf = bXO.bJb();
                h.this.hbn = bXO.bJc();
            }
            if (!h.this.hbm && h.this.hbt != null) {
                h.this.mHandler.removeCallbacks(h.this.hbt);
                h.this.mHandler.postDelayed(h.this.hbt, h.this.hbf);
            }
        }
    };
    private Runnable hbt = new Runnable() { // from class: com.baidu.tieba.ala.view.h.4
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.hbk != null) {
                h.this.hbk.h(h.this.mUserId, "");
            }
        }
    };
    private BdUniqueId beX = BdUniqueId.gen();

    static /* synthetic */ long d(h hVar) {
        long j = hVar.haE;
        hVar.haE = j - 1;
        return j;
    }

    public h(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aEF = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aTe = str4;
        this.fvG = j2;
        this.otherParams = str3;
        initView();
        this.hbk = new j(this.beX, this.fWV);
        this.hbk.h(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.gfz);
            this.mHandler.postDelayed(this.gfz, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar) {
        if (nVar != null && nVar.getList() != null && nVar.getList().size() > 0 && nVar.getList().get(0).fUM != null && nVar.getList().get(0).fUM.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = nVar.getList().get(0).getName_show();
            if (nVar.getList().get(0).ecd == 1) {
                alaBroadcastGiftToastData.live_id = nVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = nVar.getList().get(0).fUM.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aTe;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        if (nVar != null) {
            this.hbs.put(nVar.Ph(), Long.valueOf(nVar.bJe()));
            if (a(this.hbl, nVar)) {
                this.hbo = System.currentTimeMillis();
                el(f(nVar), b(this.hbl, nVar));
                this.hbl = nVar;
            } else {
                this.hbl = nVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(nVar));
                    this.mRootView.setVisibility(0);
                    this.gGq = BdUtilHelper.getTextWidth(this.mPaint, f(nVar));
                } else if (nVar.bJf() != null && !this.hbp) {
                    b(this.mTextView, f(nVar));
                }
            }
            this.haE = nVar.bJd();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hbo = System.currentTimeMillis();
        this.hbl = null;
    }

    private boolean a(n nVar, n nVar2) {
        if (nVar2 == null || System.currentTimeMillis() - this.hbo < this.hbn * 1000 || nVar == null || nVar.bJf() == null) {
            return false;
        }
        if (nVar.bJf().fVe > 0 || nVar2.bJf().fVe <= 0) {
            return (nVar.bJf().fVe > 0 || nVar2.bJf().fVe > 0) ? true : true;
        }
        return false;
    }

    private String f(n nVar) {
        if (nVar.bJf().fVe < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(nVar.bJf().fVe) + "");
    }

    private String b(n nVar, n nVar2) {
        if (nVar.bJf().fVe == nVar2.bJf().fVe) {
            this.hbq = "change";
            if (nVar2.bJf().fVe <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (nVar2.bJf().fVe == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(nVar2.bJf().fVf - nVar2.bJf().fVh) + "");
            } else if (nVar2.bJf().fVe <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((nVar2.bJf().fVg - nVar2.bJf().fVf) + 1) + "");
            }
        }
        this.hbq = "up_down";
        int i = nVar2.bJf().fVe - nVar.bJf().fVe;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.hbi = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.hbg = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.hbh = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.hbi.setAlpha(0.7f);
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
    public void GR(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(this.mContext, this.aEF, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aTe, this.fvG, this.hbl == null ? i.fw(0) : this.hbl.Ph())));
    }

    @Override // com.baidu.live.q.c
    public void Mx() {
        this.hbm = false;
        if (this.hbk != null) {
            this.hbk.h(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.q.c
    public void My() {
        this.hbm = true;
        this.mHandler.removeCallbacks(this.hbt);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GS(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.hbi.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.hbi.getLayoutParams();
            layoutParams.width = this.gGq + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.hbi.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.hbg.setVisibility(0);
        this.hbh.setVisibility(0);
        if (textWidth > this.gGq) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.gGq) * 1.0f) / this.gGq), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void el(final String str, final String str2) {
        if (this.aPy == null) {
            this.aPy = new AnimatorSet();
        }
        this.aPy.cancel();
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
                h.this.GS(str2);
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
                h.this.hbg.setVisibility(4);
                h.this.hbh.setVisibility(4);
                h.this.b(h.this.mTextView, str);
                h.this.aPy.cancel();
                h.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                h.this.mTextView.clearAnimation();
                h.this.hbp = false;
                h.this.hbq = "default";
                h.this.hbi.setAlpha(0.7f);
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
        this.aPy.playTogether(this.mAnimators);
        this.aPy.start();
        this.hbp = true;
        this.hbi.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.hbi.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.hbi.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.hbi.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.gGq = textWidth;
        }
    }

    @Override // com.baidu.live.q.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hbk != null) {
            this.hbk.destory();
        }
    }
}
