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
    private long ehL;
    private long fAK;
    private ImageView fBo;
    private ImageView fBp;
    private FrameLayout fBq;
    private BdUniqueId fBr;
    private i fBs;
    private m fBt;
    private long fBw;
    private boolean fBx;
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
    private long fBn = 5000;
    private Handler mHandler = new Handler();
    private boolean eTw = true;
    private boolean fBu = false;
    private long fBv = 17;
    private String fBy = "default";
    private ArrayList<String> fBz = new ArrayList<>();
    private Map<String, Long> fBA = new HashMap();
    private final Runnable eJQ = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fAK <= 0) {
                f.this.fAK = 0L;
            } else {
                if (f.this.fAK == 300 && f.this.fBt != null && !f.this.fBz.contains(f.this.fBt.AY())) {
                    f.this.fBz.add(f.this.fBt.AY());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.fAK <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.fBA.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.fBr = BdUniqueId.gen();
                    f.this.fBs.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.fBr);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.zK("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.alG, f.this.fBy, f.this.otherParams);
        }
    };
    private j eBp = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m brz = alaGetHourRankListResponseMessage.brz();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.fBr) {
                    f.this.d(brz);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.arR) {
                    f.this.e(brz);
                }
                f.this.fBn = brz.bex();
                f.this.fBv = brz.bey();
            }
            if (!f.this.fBu && f.this.fBB != null) {
                f.this.mHandler.removeCallbacks(f.this.fBB);
                f.this.mHandler.postDelayed(f.this.fBB, f.this.fBn);
            }
        }
    };
    private Runnable fBB = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fBs != null) {
                f.this.fBs.f(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId arR = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.fAK;
        fVar.fAK = j - 1;
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
        this.ehL = j2;
        this.otherParams = str3;
        initView();
        this.fBs = new i(this.arR, this.eBp);
        this.fBs.f(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.eJQ);
            this.mHandler.postDelayed(this.eJQ, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).ezN != null && mVar.getList().get(0).ezN.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).cSl == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).ezN.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.alG;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.fBA.put(mVar.AY(), Long.valueOf(mVar.beA()));
            if (a(this.fBt, mVar)) {
                this.fBw = System.currentTimeMillis();
                cZ(f(mVar), b(this.fBt, mVar));
                this.fBt = mVar;
            } else {
                this.fBt = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.ail = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.beB() != null && !this.fBx) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.fAK = mVar.bez();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fBw = System.currentTimeMillis();
        this.fBt = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.fBw < this.fBv * 1000 || mVar == null || mVar.beB() == null) {
            return false;
        }
        if (mVar.beB().eAg > 0 || mVar2.beB().eAg <= 0) {
            return (mVar.beB().eAg > 0 || mVar2.beB().eAg > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.beB().eAg < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.beB().eAg) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.beB().eAg == mVar2.beB().eAg) {
            this.fBy = "change";
            if (mVar2.beB().eAg <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.beB().eAg == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.beB().eAh - mVar2.beB().eAj) + "");
            } else if (mVar2.beB().eAg <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.beB().eAi - mVar2.beB().eAh) + 1) + "");
            }
        }
        this.fBy = "up_down";
        int i = mVar2.beB().eAg - mVar.beB().eAg;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.fBq = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.fBo = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.fBp = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.fBq.setAlpha(0.7f);
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
    public void zK(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(this.mContext, this.Yx, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.alG, this.ehL, this.fBt == null ? com.baidu.live.utils.i.cW(0) : this.fBt.AY())));
    }

    @Override // com.baidu.live.p.c
    public void ze() {
        this.fBu = false;
        if (this.fBs != null) {
            this.fBs.f(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.p.c
    public void zf() {
        this.fBu = true;
        this.mHandler.removeCallbacks(this.fBB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zL(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.fBq.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fBq.getLayoutParams();
            layoutParams.width = this.ail + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.fBq.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.fBo.setVisibility(0);
        this.fBp.setVisibility(0);
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
                f.this.fBo.setVisibility(4);
                f.this.fBp.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.aiq.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.fBx = false;
                f.this.fBy = "default";
                f.this.fBq.setAlpha(0.7f);
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
        this.fBx = true;
        this.fBq.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.fBq.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fBq.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.fBq.setLayoutParams(layoutParams);
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
        if (this.fBs != null) {
            this.fBs.destory();
        }
    }
}
