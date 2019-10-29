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
import com.baidu.live.b.g;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.live.utils.h;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class f implements com.baidu.live.h.c {
    private int Qc;
    private int XZ;
    private AnimatorSet Ye;
    private String abe;
    private boolean bci;
    private long duD;
    private ImageView eEP;
    private ImageView eEQ;
    private FrameLayout eER;
    private BdUniqueId eES;
    private com.baidu.tieba.ala.c.c eET;
    private com.baidu.tieba.ala.data.e eEU;
    private long eEX;
    private boolean eEY;
    private long eEl;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private boolean mIsHost;
    private Paint mPaint;
    private String mPortrait;
    private LinearLayout mRootView;
    private TextView mTextView;
    private long mUserId;
    private String mUserName;
    private String otherParams;
    private long eEO = 5000;
    private Handler mHandler = new Handler();
    private boolean dYO = true;
    private boolean eEV = false;
    private long eEW = 17;
    private String eEZ = "default";
    private ArrayList<String> eFa = new ArrayList<>();
    private Map<String, Long> eFb = new HashMap();
    private final Runnable eaC = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.eEl <= 0) {
                f.this.eEl = 0L;
            } else {
                if (f.this.eEl == 300 && f.this.eEU != null && !f.this.eFa.contains(f.this.eEU.wq())) {
                    f.this.eFa.add(f.this.eEU.wq());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.eEl <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.eFb.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.eES = BdUniqueId.gen();
                    f.this.eET.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.eES);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.uq("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.abe, f.this.eEZ, f.this.otherParams);
        }
    };
    private com.baidu.tieba.ala.c.d dIy = new com.baidu.tieba.ala.c.d() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.c.d
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                com.baidu.tieba.ala.data.e aXf = alaGetHourRankListResponseMessage.aXf();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.eES) {
                    f.this.d(aXf);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.agc) {
                    f.this.e(aXf);
                }
                f.this.eEO = aXf.aKB();
                f.this.eEW = aXf.aKC();
            }
            if (!f.this.eEV && f.this.eFc != null) {
                f.this.mHandler.removeCallbacks(f.this.eFc);
                f.this.mHandler.postDelayed(f.this.eFc, f.this.eEO);
            }
        }
    };
    private Runnable eFc = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.eET != null) {
                f.this.eET.e(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId agc = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.eEl;
        fVar.eEl = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.Qc = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.abe = str4;
        this.duD = j2;
        this.otherParams = str3;
        initView();
        this.eET = new com.baidu.tieba.ala.c.c(this.agc, this.dIy);
        this.eET.e(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.eaC);
            this.mHandler.postDelayed(this.eaC, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.ala.data.e eVar) {
        if (eVar != null && eVar.getList() != null && eVar.getList().size() > 0 && eVar.getList().get(0).dHd != null && eVar.getList().get(0).dHd.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = eVar.getList().get(0).getName_show();
            if (eVar.getList().get(0).cck == 1) {
                alaBroadcastGiftToastData.live_id = eVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = eVar.getList().get(0).dHd.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.abe;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.ala.data.e eVar) {
        if (eVar != null) {
            this.eFb.put(eVar.wq(), Long.valueOf(eVar.aKE()));
            if (a(this.eEU, eVar)) {
                this.eEX = System.currentTimeMillis();
                cv(f(eVar), b(this.eEU, eVar));
                this.eEU = eVar;
            } else {
                this.eEU = eVar;
                if (!this.bci) {
                    this.bci = true;
                    this.mTextView.setText(f(eVar));
                    this.mRootView.setVisibility(0);
                    this.XZ = BdUtilHelper.getTextWidth(this.mPaint, f(eVar));
                } else if (eVar.aKF() != null && !this.eEY) {
                    a(this.mTextView, f(eVar));
                }
            }
            this.eEl = eVar.aKD();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eEX = System.currentTimeMillis();
        this.eEU = null;
    }

    private boolean a(com.baidu.tieba.ala.data.e eVar, com.baidu.tieba.ala.data.e eVar2) {
        if (eVar2 == null || System.currentTimeMillis() - this.eEX < this.eEW * 1000 || eVar == null || eVar.aKF() == null) {
            return false;
        }
        if (eVar.aKF().dHs > 0 || eVar2.aKF().dHs <= 0) {
            return (eVar.aKF().dHs > 0 || eVar2.aKF().dHs > 0) ? true : true;
        }
        return false;
    }

    private String f(com.baidu.tieba.ala.data.e eVar) {
        if (eVar.aKF().dHs < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(eVar.aKF().dHs) + "");
    }

    private String b(com.baidu.tieba.ala.data.e eVar, com.baidu.tieba.ala.data.e eVar2) {
        if (eVar.aKF().dHs == eVar2.aKF().dHs) {
            this.eEZ = "change";
            if (eVar2.aKF().dHs <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (eVar2.aKF().dHs == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(eVar2.aKF().dHt - eVar2.aKF().dHv) + "");
            } else if (eVar2.aKF().dHs <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((eVar2.aKF().dHu - eVar2.aKF().dHt) + 1) + "");
            }
        }
        this.eEZ = "up_down";
        int i = eVar2.aKF().dHs - eVar.aKF().dHs;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.eER = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.eEP = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.eEQ = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.eER.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.h.c
    public View uv() {
        return this.mRootView;
    }

    @Override // com.baidu.live.h.c
    public com.baidu.live.h.b uw() {
        return null;
    }

    @Override // com.baidu.live.h.c
    public com.baidu.live.h.b ux() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new g(this.mContext, this.Qc, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.abe, this.duD, this.eEU == null ? h.cn(0) : this.eEU.wq())));
    }

    @Override // com.baidu.live.h.c
    public void uy() {
        this.eEV = false;
        if (this.eET != null) {
            this.eET.e(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.h.c
    public void uz() {
        this.eEV = true;
        this.mHandler.removeCallbacks(this.eFc);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.eER.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eER.getLayoutParams();
            layoutParams.width = this.XZ + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.eER.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.eEP.setVisibility(0);
        this.eEQ.setVisibility(0);
        if (textWidth > this.XZ) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.XZ) * 1.0f) / this.XZ), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void cv(final String str, final String str2) {
        if (this.Ye == null) {
            this.Ye = new AnimatorSet();
        }
        this.Ye.cancel();
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
                f.this.ur(str2);
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
                f.this.eEP.setVisibility(4);
                f.this.eEQ.setVisibility(4);
                f.this.a(f.this.mTextView, str);
                f.this.Ye.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.eEY = false;
                f.this.eEZ = "default";
                f.this.eER.setAlpha(0.7f);
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
        this.Ye.playTogether(this.mAnimators);
        this.Ye.start();
        this.eEY = true;
        this.eER.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.eER.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.eER.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.eER.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.XZ = textWidth;
        }
    }

    @Override // com.baidu.live.h.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.eET != null) {
            this.eET.destory();
        }
    }
}
