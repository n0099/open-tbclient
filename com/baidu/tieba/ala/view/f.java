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
    private long eUS;
    private int gbp;
    private ImageView gvS;
    private ImageView gvT;
    private FrameLayout gvU;
    private BdUniqueId gvV;
    private i gvW;
    private m gvX;
    private long gvq;
    private long gwa;
    private boolean gwb;
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
    private long gvR = 5000;
    private Handler mHandler = new Handler();
    private boolean fMS = true;
    private boolean gvY = false;
    private long gvZ = 17;
    private String gwc = "default";
    private ArrayList<String> gwd = new ArrayList<>();
    private Map<String, Long> gwe = new HashMap();
    private final Runnable fCU = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.gvq <= 0) {
                f.this.gvq = 0L;
            } else {
                if (f.this.gvq == 300 && f.this.gvX != null && !f.this.gwd.contains(f.this.gvX.HV())) {
                    f.this.gwd.add(f.this.gvX.HV());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.gvq <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.gwe.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.gvV = BdUniqueId.gen();
                    f.this.gvW.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.gvV);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.Df("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.aJO, f.this.gwc, f.this.otherParams);
        }
    };
    private j fuo = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.f.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m bHC = alaGetHourRankListResponseMessage.bHC();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.gvV) {
                    f.this.d(bHC);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.aWV) {
                    f.this.e(bHC);
                }
                f.this.gvR = bHC.btL();
                f.this.gvZ = bHC.btM();
            }
            if (!f.this.gvY && f.this.gwf != null) {
                f.this.mHandler.removeCallbacks(f.this.gwf);
                f.this.mHandler.postDelayed(f.this.gwf, f.this.gvR);
            }
        }
    };
    private Runnable gwf = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.gvW != null) {
                f.this.gvW.h(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aWV = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.gvq;
        fVar.gvq = j - 1;
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
        this.eUS = j2;
        this.otherParams = str3;
        initView();
        this.gvW = new i(this.aWV, this.fuo);
        this.gvW.h(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.fCU);
            this.mHandler.postDelayed(this.fCU, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).fsL != null && mVar.getList().get(0).fsL.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).dFH == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).fsL.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aJO;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.gwe.put(mVar.HV(), Long.valueOf(mVar.btO()));
            if (a(this.gvX, mVar)) {
                this.gwa = System.currentTimeMillis();
                dM(f(mVar), b(this.gvX, mVar));
                this.gvX = mVar;
            } else {
                this.gvX = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.gbp = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.btP() != null && !this.gwb) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.gvq = mVar.btN();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.gwa = System.currentTimeMillis();
        this.gvX = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.gwa < this.gvZ * 1000 || mVar == null || mVar.btP() == null) {
            return false;
        }
        if (mVar.btP().ftd > 0 || mVar2.btP().ftd <= 0) {
            return (mVar.btP().ftd > 0 || mVar2.btP().ftd > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.btP().ftd < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.btP().ftd) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.btP().ftd == mVar2.btP().ftd) {
            this.gwc = "change";
            if (mVar2.btP().ftd <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.btP().ftd == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.btP().fte - mVar2.btP().ftg) + "");
            } else if (mVar2.btP().ftd <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.btP().ftf - mVar2.btP().fte) + 1) + "");
            }
        }
        this.gwc = "up_down";
        int i = mVar2.btP().ftd - mVar.btP().ftd;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.gvU = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.gvS = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.gvT = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.gvU.setAlpha(0.7f);
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(this.mContext, this.avX, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aJO, this.eUS, this.gvX == null ? com.baidu.live.utils.i.ds(0) : this.gvX.HV())));
    }

    @Override // com.baidu.live.p.c
    public void FV() {
        this.gvY = false;
        if (this.gvW != null) {
            this.gvW.h(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.p.c
    public void FW() {
        this.gvY = true;
        this.mHandler.removeCallbacks(this.gwf);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Dg(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.gvU.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gvU.getLayoutParams();
            layoutParams.width = this.gbp + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.gvU.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.gvS.setVisibility(0);
        this.gvT.setVisibility(0);
        if (textWidth > this.gbp) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.gbp) * 1.0f) / this.gbp), 1, 0.0f, 1, 0.0f);
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
                f.this.gvS.setVisibility(4);
                f.this.gvT.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.aGp.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.gwb = false;
                f.this.gwc = "default";
                f.this.gvU.setAlpha(0.7f);
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
        this.gwb = true;
        this.gvU.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.gvU.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.gvU.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.gvU.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.gbp = textWidth;
        }
    }

    @Override // com.baidu.live.p.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gvW != null) {
            this.gvW.destory();
        }
    }
}
