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
import com.baidu.live.r.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.e.i;
import com.baidu.tieba.ala.e.j;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes2.dex */
public class f implements com.baidu.live.m.c {
    private int WL;
    private int agb;
    private AnimatorSet agh;
    private String ajy;
    private long edH;
    private ImageView fyO;
    private ImageView fyP;
    private FrameLayout fyQ;
    private BdUniqueId fyR;
    private i fyS;
    private m fyT;
    private long fyW;
    private boolean fyX;
    private long fyk;
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
    private long fyN = 5000;
    private Handler mHandler = new Handler();
    private boolean ePt = true;
    private boolean fyU = false;
    private long fyV = 17;
    private String fyY = "default";
    private ArrayList<String> fyZ = new ArrayList<>();
    private Map<String, Long> fza = new HashMap();
    private final Runnable eFV = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fyk <= 0) {
                f.this.fyk = 0L;
            } else {
                if (f.this.fyk == 300 && f.this.fyT != null && !f.this.fyZ.contains(f.this.fyT.yF())) {
                    f.this.fyZ.add(f.this.fyT.yF());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.fyk <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.fza.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.fyR = BdUniqueId.gen();
                    f.this.fyS.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.fyR);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.zu("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.ajy, f.this.fyY, f.this.otherParams);
        }
    };
    private j exe = new j() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.e.j
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                m bpT = alaGetHourRankListResponseMessage.bpT();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.fyR) {
                    f.this.d(bpT);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.aoz) {
                    f.this.e(bpT);
                }
                f.this.fyN = bpT.bcg();
                f.this.fyV = bpT.bch();
            }
            if (!f.this.fyU && f.this.fzb != null) {
                f.this.mHandler.removeCallbacks(f.this.fzb);
                f.this.mHandler.postDelayed(f.this.fzb, f.this.fyN);
            }
        }
    };
    private Runnable fzb = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.fyS != null) {
                f.this.fyS.f(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aoz = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.fyk;
        fVar.fyk = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.WL = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.ajy = str4;
        this.edH = j2;
        this.otherParams = str3;
        initView();
        this.fyS = new i(this.aoz, this.exe);
        this.fyS.f(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.eFV);
            this.mHandler.postDelayed(this.eFV, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(m mVar) {
        if (mVar != null && mVar.getList() != null && mVar.getList().size() > 0 && mVar.getList().get(0).evB != null && mVar.getList().get(0).evB.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = mVar.getList().get(0).getName_show();
            if (mVar.getList().get(0).cOh == 1) {
                alaBroadcastGiftToastData.live_id = mVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = mVar.getList().get(0).evB.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.ajy;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(m mVar) {
        if (mVar != null) {
            this.fza.put(mVar.yF(), Long.valueOf(mVar.bcj()));
            if (a(this.fyT, mVar)) {
                this.fyW = System.currentTimeMillis();
                cR(f(mVar), b(this.fyT, mVar));
                this.fyT = mVar;
            } else {
                this.fyT = mVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(mVar));
                    this.mRootView.setVisibility(0);
                    this.agb = BdUtilHelper.getTextWidth(this.mPaint, f(mVar));
                } else if (mVar.bck() != null && !this.fyX) {
                    b(this.mTextView, f(mVar));
                }
            }
            this.fyk = mVar.bci();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.fyW = System.currentTimeMillis();
        this.fyT = null;
    }

    private boolean a(m mVar, m mVar2) {
        if (mVar2 == null || System.currentTimeMillis() - this.fyW < this.fyV * 1000 || mVar == null || mVar.bck() == null) {
            return false;
        }
        if (mVar.bck().evU > 0 || mVar2.bck().evU <= 0) {
            return (mVar.bck().evU > 0 || mVar2.bck().evU > 0) ? true : true;
        }
        return false;
    }

    private String f(m mVar) {
        if (mVar.bck().evU < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(mVar.bck().evU) + "");
    }

    private String b(m mVar, m mVar2) {
        if (mVar.bck().evU == mVar2.bck().evU) {
            this.fyY = "change";
            if (mVar2.bck().evU <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (mVar2.bck().evU == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(mVar2.bck().evV - mVar2.bck().evX) + "");
            } else if (mVar2.bck().evU <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((mVar2.bck().evW - mVar2.bck().evV) + 1) + "");
            }
        }
        this.fyY = "up_down";
        int i = mVar2.bck().evU - mVar.bck().evU;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.fyQ = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.fyO = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.fyP = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.fyQ.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.m.c
    public View wI() {
        return this.mRootView;
    }

    @Override // com.baidu.live.m.c
    public com.baidu.live.m.b wJ() {
        return null;
    }

    @Override // com.baidu.live.m.c
    public com.baidu.live.m.b wK() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zu(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new n(this.mContext, this.WL, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.ajy, this.edH, this.fyT == null ? com.baidu.live.utils.i.cG(0) : this.fyT.yF())));
    }

    @Override // com.baidu.live.m.c
    public void wL() {
        this.fyU = false;
        if (this.fyS != null) {
            this.fyS.f(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.m.c
    public void wM() {
        this.fyU = true;
        this.mHandler.removeCallbacks(this.fzb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zv(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.fyQ.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.fyQ.getLayoutParams();
            layoutParams.width = this.agb + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.fyQ.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.fyO.setVisibility(0);
        this.fyP.setVisibility(0);
        if (textWidth > this.agb) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.agb) * 1.0f) / this.agb), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void cR(final String str, final String str2) {
        if (this.agh == null) {
            this.agh = new AnimatorSet();
        }
        this.agh.cancel();
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
                f.this.zv(str2);
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
                f.this.fyO.setVisibility(4);
                f.this.fyP.setVisibility(4);
                f.this.b(f.this.mTextView, str);
                f.this.agh.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.fyX = false;
                f.this.fyY = "default";
                f.this.fyQ.setAlpha(0.7f);
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
        this.agh.playTogether(this.mAnimators);
        this.agh.start();
        this.fyX = true;
        this.fyQ.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.fyQ.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.fyQ.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.fyQ.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.agb = textWidth;
        }
    }

    @Override // com.baidu.live.m.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.fyS != null) {
            this.fyS.destory();
        }
    }
}
