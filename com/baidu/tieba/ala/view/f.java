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
    private int aAO;
    private AnimatorSet aAT;
    private String aEh;
    private int aqR;
    private long eId;
    private ImageView ggJ;
    private ImageView ggK;
    private FrameLayout ggL;
    private BdUniqueId ggM;
    private i ggN;
    private m ggO;
    private long ggR;
    private boolean ggS;
    private long ggg;
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
    private long ggI = 5000;
    private Handler mHandler = new Handler();
    private boolean fyB = true;
    private boolean ggP = false;
    private long ggQ = 17;
    private String ggT = "default";
    private ArrayList<String> ggU = new ArrayList<>();
    private Map<String, Long> ggV = new HashMap();
    private final Runnable foQ = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.ggg <= 0) {
                f.this.ggg = 0L;
            } else {
                if (f.this.ggg == 300 && f.this.ggO != null && !f.this.ggU.contains(f.this.ggO.Gd())) {
                    f.this.ggU.add(f.this.ggO.Gd());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.ggg <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.ggV.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.ggM = BdUniqueId.gen();
                    f.this.ggN.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.ggM);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.Bt("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.aEh, f.this.ggT, f.this.otherParams);
        }
    };
    private j fgr = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m bBi = alaGetHourRankListResponseMessage.bBi();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.ggM) {
                    f.this.d(bBi);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.aQF) {
                    f.this.e(bBi);
                }
                f.this.ggI = bBi.bnT();
                f.this.ggQ = bBi.bnU();
            }
            if (!f.this.ggP && f.this.ggW != null) {
                f.this.mHandler.removeCallbacks(f.this.ggW);
                f.this.mHandler.postDelayed(f.this.ggW, f.this.ggI);
            }
        }
    };
    private Runnable ggW = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.ggN != null) {
                f.this.ggN.h(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aQF = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.ggg;
        fVar.ggg = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aqR = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aEh = str4;
        this.eId = j2;
        this.otherParams = str3;
        initView();
        this.ggN = new i(this.aQF, this.fgr);
        this.ggN.h(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.foQ);
            this.mHandler.postDelayed(this.foQ, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).feQ != null && mVar.getList().get(0).feQ.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).drI == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).feQ.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aEh;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.ggV.put(mVar.Gd(), Long.valueOf(mVar.bnW()));
            if (a(this.ggO, mVar)) {
                this.ggR = System.currentTimeMillis();
                dm(f(mVar), b(this.ggO, mVar));
                this.ggO = mVar;
            } else {
                this.ggO = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.aAO = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.bnX() != null && !this.ggS) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.ggg = mVar.bnV();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.ggR = System.currentTimeMillis();
        this.ggO = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.ggR < this.ggQ * 1000 || mVar == null || mVar.bnX() == null) {
            return false;
        }
        if (mVar.bnX().ffi > 0 || mVar2.bnX().ffi <= 0) {
            return (mVar.bnX().ffi > 0 || mVar2.bnX().ffi > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.bnX().ffi < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.bnX().ffi) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.bnX().ffi == mVar2.bnX().ffi) {
            this.ggT = "change";
            if (mVar2.bnX().ffi <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.bnX().ffi == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.bnX().ffj - mVar2.bnX().ffl) + "");
            } else if (mVar2.bnX().ffi <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.bnX().ffk - mVar2.bnX().ffj) + 1) + "");
            }
        }
        this.ggT = "up_down";
        int i = mVar2.bnX().ffi - mVar.bnX().ffi;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.ggL = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.ggJ = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.ggK = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.ggL.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.p.c
    public View Ed() {
        return this.mRootView;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b Ee() {
        return null;
    }

    @Override // com.baidu.live.p.c
    public com.baidu.live.p.b Ef() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bt(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(this.mContext, this.aqR, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aEh, this.eId, this.ggO == null ? com.baidu.live.utils.i.dl(0) : this.ggO.Gd())));
    }

    @Override // com.baidu.live.p.c
    public void Eg() {
        this.ggP = false;
        if (this.ggN != null) {
            this.ggN.h(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.p.c
    public void Eh() {
        this.ggP = true;
        this.mHandler.removeCallbacks(this.ggW);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Bu(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.ggL.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.ggL.getLayoutParams();
            layoutParams.width = this.aAO + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.ggL.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.ggJ.setVisibility(0);
        this.ggK.setVisibility(0);
        if (textWidth > this.aAO) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.aAO) * 1.0f) / this.aAO), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void dm(final String str, final String str2) {
        if (this.aAT == null) {
            this.aAT = new AnimatorSet();
        }
        this.aAT.cancel();
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
                f.this.Bu(str2);
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
                f.this.ggJ.setVisibility(4);
                f.this.ggK.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.aAT.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.ggS = false;
                f.this.ggT = "default";
                f.this.ggL.setAlpha(0.7f);
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
        this.aAT.playTogether(this.mAnimators);
        this.aAT.start();
        this.ggS = true;
        this.ggL.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.ggL.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.ggL.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.ggL.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.aAO = textWidth;
        }
    }

    @Override // com.baidu.live.p.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ggN != null) {
            this.ggN.destory();
        }
    }
}
