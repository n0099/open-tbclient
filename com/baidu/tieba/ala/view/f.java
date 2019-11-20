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
    private int Pw;
    private int XH;
    private AnimatorSet XM;
    private String aaL;
    private boolean bbQ;
    private long dtM;
    private ImageView eDY;
    private ImageView eDZ;
    private long eDu;
    private FrameLayout eEa;
    private BdUniqueId eEb;
    private com.baidu.tieba.ala.c.c eEc;
    private com.baidu.tieba.ala.data.e eEd;
    private long eEg;
    private boolean eEh;
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
    private long eDX = 5000;
    private Handler mHandler = new Handler();
    private boolean dXX = true;
    private boolean eEe = false;
    private long eEf = 17;
    private String eEi = "default";
    private ArrayList<String> eEj = new ArrayList<>();
    private Map<String, Long> eEk = new HashMap();
    private final Runnable dZL = new Runnable() { // from class: com.baidu.tieba.ala.view.f.1
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.eDu <= 0) {
                f.this.eDu = 0L;
            } else {
                if (f.this.eDu == 300 && f.this.eEd != null && !f.this.eEj.contains(f.this.eEd.wr())) {
                    f.this.eEj.add(f.this.eEd.wr());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.broadcast_type = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                f.d(f.this);
            }
            if (f.this.eDu <= 1) {
                f.this.resetData();
            }
            for (Map.Entry entry : f.this.eEk.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    f.this.eEb = BdUniqueId.gen();
                    f.this.eEc.a(f.this.mUserId, (String) entry.getKey(), 1, 1, f.this.eEb);
                }
            }
            f.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.f.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            f.this.uq("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(f.this.aaL, f.this.eEi, f.this.otherParams);
        }
    };
    private com.baidu.tieba.ala.c.d dHH = new com.baidu.tieba.ala.c.d() { // from class: com.baidu.tieba.ala.view.f.3
        @Override // com.baidu.tieba.ala.c.d
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                com.baidu.tieba.ala.data.e aXd = alaGetHourRankListResponseMessage.aXd();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.eEb) {
                    f.this.d(aXd);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == f.this.afK) {
                    f.this.e(aXd);
                }
                f.this.eDX = aXd.aKz();
                f.this.eEf = aXd.aKA();
            }
            if (!f.this.eEe && f.this.eEl != null) {
                f.this.mHandler.removeCallbacks(f.this.eEl);
                f.this.mHandler.postDelayed(f.this.eEl, f.this.eDX);
            }
        }
    };
    private Runnable eEl = new Runnable() { // from class: com.baidu.tieba.ala.view.f.4
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.eEc != null) {
                f.this.eEc.e(f.this.mUserId, "");
            }
        }
    };
    private BdUniqueId afK = BdUniqueId.gen();

    static /* synthetic */ long d(f fVar) {
        long j = fVar.eDu;
        fVar.eDu = j - 1;
        return j;
    }

    public f(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.Pw = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aaL = str4;
        this.dtM = j2;
        this.otherParams = str3;
        initView();
        this.eEc = new com.baidu.tieba.ala.c.c(this.afK, this.dHH);
        this.eEc.e(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.dZL);
            this.mHandler.postDelayed(this.dZL, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(com.baidu.tieba.ala.data.e eVar) {
        if (eVar != null && eVar.getList() != null && eVar.getList().size() > 0 && eVar.getList().get(0).dGm != null && eVar.getList().get(0).dGm.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.broadcast_type = 2;
            alaBroadcastGiftToastData.receiver = eVar.getList().get(0).getName_show();
            if (eVar.getList().get(0).cbt == 1) {
                alaBroadcastGiftToastData.live_id = eVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = eVar.getList().get(0).dGm.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aaL;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(com.baidu.tieba.ala.data.e eVar) {
        if (eVar != null) {
            this.eEk.put(eVar.wr(), Long.valueOf(eVar.aKC()));
            if (a(this.eEd, eVar)) {
                this.eEg = System.currentTimeMillis();
                cv(f(eVar), b(this.eEd, eVar));
                this.eEd = eVar;
            } else {
                this.eEd = eVar;
                if (!this.bbQ) {
                    this.bbQ = true;
                    this.mTextView.setText(f(eVar));
                    this.mRootView.setVisibility(0);
                    this.XH = BdUtilHelper.getTextWidth(this.mPaint, f(eVar));
                } else if (eVar.aKD() != null && !this.eEh) {
                    a(this.mTextView, f(eVar));
                }
            }
            this.eDu = eVar.aKB();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.eEg = System.currentTimeMillis();
        this.eEd = null;
    }

    private boolean a(com.baidu.tieba.ala.data.e eVar, com.baidu.tieba.ala.data.e eVar2) {
        if (eVar2 == null || System.currentTimeMillis() - this.eEg < this.eEf * 1000 || eVar == null || eVar.aKD() == null) {
            return false;
        }
        if (eVar.aKD().dGB > 0 || eVar2.aKD().dGB <= 0) {
            return (eVar.aKD().dGB > 0 || eVar2.aKD().dGB > 0) ? true : true;
        }
        return false;
    }

    private String f(com.baidu.tieba.ala.data.e eVar) {
        if (eVar.aKD().dGB < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(eVar.aKD().dGB) + "");
    }

    private String b(com.baidu.tieba.ala.data.e eVar, com.baidu.tieba.ala.data.e eVar2) {
        if (eVar.aKD().dGB == eVar2.aKD().dGB) {
            this.eEi = "change";
            if (eVar2.aKD().dGB <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (eVar2.aKD().dGB == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(eVar2.aKD().dGC - eVar2.aKD().dGE) + "");
            } else if (eVar2.aKD().dGB <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((eVar2.aKD().dGD - eVar2.aKD().dGC) + 1) + "");
            }
        }
        this.eEi = "up_down";
        int i = eVar2.aKD().dGB - eVar.aKD().dGB;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.eEa = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.eDY = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.eDZ = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.eEa.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.h.c
    public View uw() {
        return this.mRootView;
    }

    @Override // com.baidu.live.h.c
    public com.baidu.live.h.b ux() {
        return null;
    }

    @Override // com.baidu.live.h.c
    public com.baidu.live.h.b uy() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uq(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new g(this.mContext, this.Pw, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aaL, this.dtM, this.eEd == null ? h.cn(0) : this.eEd.wr())));
    }

    @Override // com.baidu.live.h.c
    public void uz() {
        this.eEe = false;
        if (this.eEc != null) {
            this.eEc.e(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.h.c
    public void uA() {
        this.eEe = true;
        this.mHandler.removeCallbacks(this.eEl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ur(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.eEa.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.eEa.getLayoutParams();
            layoutParams.width = this.XH + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.eEa.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.eDY.setVisibility(0);
        this.eDZ.setVisibility(0);
        if (textWidth > this.XH) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.XH) * 1.0f) / this.XH), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void cv(final String str, final String str2) {
        if (this.XM == null) {
            this.XM = new AnimatorSet();
        }
        this.XM.cancel();
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
                f.this.eDY.setVisibility(4);
                f.this.eDZ.setVisibility(4);
                f.this.a(f.this.mTextView, str);
                f.this.XM.cancel();
                f.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                f.this.mTextView.clearAnimation();
                f.this.eEh = false;
                f.this.eEi = "default";
                f.this.eEa.setAlpha(0.7f);
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
        this.XM.playTogether(this.mAnimators);
        this.XM.start();
        this.eEh = true;
        this.eEa.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.eEa.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.eEa.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.eEa.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.XH = textWidth;
        }
    }

    @Override // com.baidu.live.h.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.eEc != null) {
            this.eEc.destory();
        }
    }
}
