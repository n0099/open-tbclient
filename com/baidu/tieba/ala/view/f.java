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
    private String alG;
    private long ehK;
    private long fAI;
    private ImageView fBm;
    private ImageView fBn;
    private FrameLayout fBo;
    private BdUniqueId fBp;
    private i fBq;
    private m fBr;
    private long fBu;
    private boolean fBv;
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
    private long fBl = 5000;
    private Handler mHandler = new Handler();
    private boolean eTv = true;
    private boolean fBs = false;
    private long fBt = 17;
    private String fBw = "default";
    private ArrayList<String> fBx = new ArrayList<>();
    private Map<String, Long> fBy = new HashMap();
    private final Runnable eJP = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fAI <= 0) {
                f.this.fAI = 0L;
            } else {
                if (f.this.fAI == 300 && f.this.fBr != null && !f.this.fBx.contains(f.this.fBr.AW())) {
                    f.this.fBx.add(f.this.fBr.AW());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.fAI <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.fBy.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.fBp = BdUniqueId.gen();
                    f.this.fBq.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.fBp);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.zK("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.alG, f.this.fBw, f.this.otherParams);
        }
    };
    private j eBo = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m brx = alaGetHourRankListResponseMessage.brx();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.fBp) {
                    f.this.d(brx);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.arR) {
                    f.this.e(brx);
                }
                f.this.fBl = brx.bev();
                f.this.fBt = brx.bew();
            }
            if (!f.this.fBs && f.this.fBz != null) {
                f.this.mHandler.removeCallbacks(f.this.fBz);
                f.this.mHandler.postDelayed(f.this.fBz, f.this.fBl);
            }
        }
    };
    private Runnable fBz = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fBq != null) {
                f.this.fBq.f(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId arR = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.fAI;
        fVar.fAI = j - 1;
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
        this.alG = str4;
        this.ehK = j2;
        this.otherParams = str3;
        initView();
        this.fBq = new i(this.arR, this.eBo);
        this.fBq.f(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.eJP);
            this.mHandler.postDelayed(this.eJP, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).ezM != null && mVar.getList().get(0).ezM.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).cSk == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).ezM.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.alG;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.fBy.put(mVar.AW(), Long.valueOf(mVar.bey()));
            if (a(this.fBr, mVar)) {
                this.fBu = System.currentTimeMillis();
                cZ(f(mVar), b(this.fBr, mVar));
                this.fBr = mVar;
            } else {
                this.fBr = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.ail = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.bez() != null && !this.fBv) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.fAI = mVar.bex();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fBu = System.currentTimeMillis();
        this.fBr = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.fBu < this.fBt * 1000 || mVar == null || mVar.bez() == null) {
            return false;
        }
        if (mVar.bez().eAf > 0 || mVar2.bez().eAf <= 0) {
            return (mVar.bez().eAf > 0 || mVar2.bez().eAf > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.bez().eAf < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.bez().eAf) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.bez().eAf == mVar2.bez().eAf) {
            this.fBw = "change";
            if (mVar2.bez().eAf <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.bez().eAf == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.bez().eAg - mVar2.bez().eAi) + "");
            } else if (mVar2.bez().eAf <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.bez().eAh - mVar2.bez().eAg) + 1) + "");
            }
        }
        this.fBw = "up_down";
        int i = mVar2.bez().eAf - mVar.bez().eAf;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.fBo = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.fBm = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.fBn = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.fBo.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.p.c
    public View yZ() {
        return this.mRootView;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b za() {
        return null;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b zb() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zK(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(this.mContext, this.Yx, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.alG, this.ehK, this.fBr == null ? com.baidu.live.utils.i.cW(0) : this.fBr.AW())));
    }

    @Override // com.baidu.live.p.c
    public void zc() {
        this.fBs = false;
        if (this.fBq != null) {
            this.fBq.f(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.p.c
    public void zd() {
        this.fBs = true;
        this.mHandler.removeCallbacks(this.fBz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.fBo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fBo.getLayoutParams();
            layoutParams.width = this.ail + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.fBo.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.fBm.setVisibility(0);
        this.fBn.setVisibility(0);
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
                f.this.zL(str2);
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
                f.this.fBm.setVisibility(4);
                f.this.fBn.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.aiq.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.fBv = false;
                f.this.fBw = "default";
                f.this.fBo.setAlpha(0.7f);
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
        this.fBv = true;
        this.fBo.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.fBo.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fBo.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.fBo.setLayoutParams(layoutParams);
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
        if (this.fBq != null) {
            this.fBq.destory();
        }
    }
}
