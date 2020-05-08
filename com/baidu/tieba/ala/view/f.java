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
    private int aAU;
    private AnimatorSet aAZ;
    private String aEn;
    private int aqX;
    private long eIi;
    private ImageView ggP;
    private ImageView ggQ;
    private FrameLayout ggR;
    private BdUniqueId ggS;
    private i ggT;
    private m ggU;
    private long ggX;
    private boolean ggY;
    private long ggm;
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
    private long ggO = 5000;
    private Handler mHandler = new Handler();
    private boolean fyG = true;
    private boolean ggV = false;
    private long ggW = 17;
    private String ggZ = "default";
    private ArrayList<String> gha = new ArrayList<>();
    private Map<String, Long> ghb = new HashMap();
    private final Runnable foV = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.ggm <= 0) {
                f.this.ggm = 0L;
            } else {
                if (f.this.ggm == 300 && f.this.ggU != null && !f.this.gha.contains(f.this.ggU.Gc())) {
                    f.this.gha.add(f.this.ggU.Gc());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.ggm <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.ghb.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.ggS = BdUniqueId.gen();
                    f.this.ggT.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.ggS);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.Bw("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.aEn, f.this.ggZ, f.this.otherParams);
        }
    };
    private j fgw = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m bBg = alaGetHourRankListResponseMessage.bBg();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.ggS) {
                    f.this.d(bBg);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.aQK) {
                    f.this.e(bBg);
                }
                f.this.ggO = bBg.bnR();
                f.this.ggW = bBg.bnS();
            }
            if (!f.this.ggV && f.this.ghc != null) {
                f.this.mHandler.removeCallbacks(f.this.ghc);
                f.this.mHandler.postDelayed(f.this.ghc, f.this.ggO);
            }
        }
    };
    private Runnable ghc = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.ggT != null) {
                f.this.ggT.h(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aQK = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.ggm;
        fVar.ggm = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aqX = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aEn = str4;
        this.eIi = j2;
        this.otherParams = str3;
        initView();
        this.ggT = new i(this.aQK, this.fgw);
        this.ggT.h(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.foV);
            this.mHandler.postDelayed(this.foV, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).feV != null && mVar.getList().get(0).feV.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).drM == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).feV.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aEn;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.ghb.put(mVar.Gc(), Long.valueOf(mVar.bnU()));
            if (a(this.ggU, mVar)) {
                this.ggX = System.currentTimeMillis();
                dm(f(mVar), b(this.ggU, mVar));
                this.ggU = mVar;
            } else {
                this.ggU = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.aAU = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.bnV() != null && !this.ggY) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.ggm = mVar.bnT();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.ggX = System.currentTimeMillis();
        this.ggU = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.ggX < this.ggW * 1000 || mVar == null || mVar.bnV() == null) {
            return false;
        }
        if (mVar.bnV().ffn > 0 || mVar2.bnV().ffn <= 0) {
            return (mVar.bnV().ffn > 0 || mVar2.bnV().ffn > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.bnV().ffn < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.bnV().ffn) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.bnV().ffn == mVar2.bnV().ffn) {
            this.ggZ = "change";
            if (mVar2.bnV().ffn <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.bnV().ffn == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.bnV().ffo - mVar2.bnV().ffq) + "");
            } else if (mVar2.bnV().ffn <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.bnV().ffp - mVar2.bnV().ffo) + 1) + "");
            }
        }
        this.ggZ = "up_down";
        int i = mVar2.bnV().ffn - mVar.bnV().ffn;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.ggR = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.ggP = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.ggQ = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.ggR.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.p.c
    public View Ec() {
        return this.mRootView;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b Ed() {
        return null;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b Ee() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bw(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(this.mContext, this.aqX, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aEn, this.eIi, this.ggU == null ? com.baidu.live.utils.i.dl(0) : this.ggU.Gc())));
    }

    @Override // com.baidu.live.p.c
    public void Ef() {
        this.ggV = false;
        if (this.ggT != null) {
            this.ggT.h(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.p.c
    public void Eg() {
        this.ggV = true;
        this.mHandler.removeCallbacks(this.ghc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bx(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.ggR.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ggR.getLayoutParams();
            layoutParams.width = this.aAU + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.ggR.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.ggP.setVisibility(0);
        this.ggQ.setVisibility(0);
        if (textWidth > this.aAU) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.aAU) * 1.0f) / this.aAU), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void dm(final String str, final String str2) {
        if (this.aAZ == null) {
            this.aAZ = new AnimatorSet();
        }
        this.aAZ.cancel();
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
                f.this.Bx(str2);
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
                f.this.ggP.setVisibility(4);
                f.this.ggQ.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.aAZ.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.ggY = false;
                f.this.ggZ = "default";
                f.this.ggR.setAlpha(0.7f);
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
        this.aAZ.playTogether(this.mAnimators);
        this.aAZ.start();
        this.ggY = true;
        this.ggR.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.ggR.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.ggR.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.ggR.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.aAU = textWidth;
        }
    }

    @Override // com.baidu.live.p.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ggT != null) {
            this.ggT.destory();
        }
    }
}
