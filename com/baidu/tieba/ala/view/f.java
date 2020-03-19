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
    private int YH;
    private AnimatorSet aiA;
    private int aiv;
    private String alR;
    private long eio;
    private long fBF;
    private ImageView fCj;
    private ImageView fCk;
    private FrameLayout fCl;
    private BdUniqueId fCm;
    private i fCn;
    private m fCo;
    private long fCr;
    private boolean fCs;
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
    private long fCi = 5000;
    private Handler mHandler = new Handler();
    private boolean eUh = true;
    private boolean fCp = false;
    private long fCq = 17;
    private String fCt = "default";
    private ArrayList<String> fCu = new ArrayList<>();
    private Map<String, Long> fCv = new HashMap();
    private final Runnable eKz = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fBF <= 0) {
                f.this.fBF = 0L;
            } else {
                if (f.this.fBF == 300 && f.this.fCo != null && !f.this.fCu.contains(f.this.fCo.Bf())) {
                    f.this.fCu.add(f.this.fCo.Bf());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.fBF <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.fCv.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.fCm = BdUniqueId.gen();
                    f.this.fCn.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.fCm);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.zN("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.alR, f.this.fCt, f.this.otherParams);
        }
    };
    private j eBY = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m brF = alaGetHourRankListResponseMessage.brF();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.fCm) {
                    f.this.d(brF);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.asc) {
                    f.this.e(brF);
                }
                f.this.fCi = brF.beD();
                f.this.fCq = brF.beE();
            }
            if (!f.this.fCp && f.this.fCw != null) {
                f.this.mHandler.removeCallbacks(f.this.fCw);
                f.this.mHandler.postDelayed(f.this.fCw, f.this.fCi);
            }
        }
    };
    private Runnable fCw = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fCn != null) {
                f.this.fCn.f(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId asc = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.fBF;
        fVar.fBF = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.YH = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.alR = str4;
        this.eio = j2;
        this.otherParams = str3;
        initView();
        this.fCn = new i(this.asc, this.eBY);
        this.fCn.f(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.eKz);
            this.mHandler.postDelayed(this.eKz, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).eAw != null && mVar.getList().get(0).eAw.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).cSz == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).eAw.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.alR;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.fCv.put(mVar.Bf(), Long.valueOf(mVar.beG()));
            if (a(this.fCo, mVar)) {
                this.fCr = System.currentTimeMillis();
                cY(f(mVar), b(this.fCo, mVar));
                this.fCo = mVar;
            } else {
                this.fCo = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.aiv = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.beH() != null && !this.fCs) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.fBF = mVar.beF();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fCr = System.currentTimeMillis();
        this.fCo = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.fCr < this.fCq * 1000 || mVar == null || mVar.beH() == null) {
            return false;
        }
        if (mVar.beH().eAP > 0 || mVar2.beH().eAP <= 0) {
            return (mVar.beH().eAP > 0 || mVar2.beH().eAP > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.beH().eAP < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.beH().eAP) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.beH().eAP == mVar2.beH().eAP) {
            this.fCt = "change";
            if (mVar2.beH().eAP <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.beH().eAP == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.beH().eAQ - mVar2.beH().eAS) + "");
            } else if (mVar2.beH().eAP <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.beH().eAR - mVar2.beH().eAQ) + 1) + "");
            }
        }
        this.fCt = "up_down";
        int i = mVar2.beH().eAP - mVar.beH().eAP;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.fCl = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.fCj = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.fCk = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.fCl.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.p.c
    public View zi() {
        return this.mRootView;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b zj() {
        return null;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b zk() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zN(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(this.mContext, this.YH, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.alR, this.eio, this.fCo == null ? com.baidu.live.utils.i.cW(0) : this.fCo.Bf())));
    }

    @Override // com.baidu.live.p.c
    public void zl() {
        this.fCp = false;
        if (this.fCn != null) {
            this.fCn.f(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.p.c
    public void zm() {
        this.fCp = true;
        this.mHandler.removeCallbacks(this.fCw);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zO(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.fCl.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fCl.getLayoutParams();
            layoutParams.width = this.aiv + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.fCl.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.fCj.setVisibility(0);
        this.fCk.setVisibility(0);
        if (textWidth > this.aiv) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.aiv) * 1.0f) / this.aiv), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void cY(final String str, final String str2) {
        if (this.aiA == null) {
            this.aiA = new AnimatorSet();
        }
        this.aiA.cancel();
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
                f.this.zO(str2);
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
                f.this.fCj.setVisibility(4);
                f.this.fCk.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.aiA.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.fCs = false;
                f.this.fCt = "default";
                f.this.fCl.setAlpha(0.7f);
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
        this.aiA.playTogether(this.mAnimators);
        this.aiA.start();
        this.fCs = true;
        this.fCl.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.fCl.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fCl.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.fCl.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.aiv = textWidth;
        }
    }

    @Override // com.baidu.live.p.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fCn != null) {
            this.fCn.destory();
        }
    }
}
