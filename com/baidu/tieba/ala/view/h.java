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
/* loaded from: classes4.dex */
public class h implements com.baidu.live.q.c {
    private AnimatorSet aKj;
    private String aNP;
    private int azs;
    private long fkg;
    private long gNK;
    private ImageView gOm;
    private ImageView gOn;
    private FrameLayout gOo;
    private BdUniqueId gOp;
    private j gOq;
    private n gOr;
    private long gOu;
    private boolean gOv;
    private int gtn;
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
    private long gOl = 5000;
    private Handler mHandler = new Handler();
    private boolean fCW = true;
    private boolean gOs = false;
    private long gOt = 17;
    private String gOw = "default";
    private ArrayList<String> gOx = new ArrayList<>();
    private Map<String, Long> gOy = new HashMap();
    private final Runnable fTw = new Runnable() { // from class: com.baidu.tieba.ala.view.h.1
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.gNK <= 0) {
                h.this.gNK = 0L;
            } else {
                if (h.this.gNK == 300 && h.this.gOr != null && !h.this.gOx.contains(h.this.gOr.Jp())) {
                    h.this.gOx.add(h.this.gOr.Jp());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                h.d(h.this);
            }
            if (h.this.gNK <= 1) {
                h.this.resetData();
            }
            for (Map.Entry entry : h.this.gOy.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    h.this.gOp = BdUniqueId.gen();
                    h.this.gOq.a(h.this.mUserId, (String) entry.getKey(), 1, 1, h.this.gOp);
                }
            }
            h.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.h.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            h.this.Er("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(h.this.aNP, h.this.gOw, h.this.otherParams);
        }
    };
    private k fKT = new k() { // from class: com.baidu.tieba.ala.view.h.3
        @Override // com.baidu.tieba.ala.f.k
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                n bNN = alaGetHourRankListResponseMessage.bNN();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == h.this.gOp) {
                    h.this.d(bNN);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == h.this.aZB) {
                    h.this.e(bNN);
                }
                h.this.gOl = bNN.bzX();
                h.this.gOt = bNN.bzY();
            }
            if (!h.this.gOs && h.this.gOz != null) {
                h.this.mHandler.removeCallbacks(h.this.gOz);
                h.this.mHandler.postDelayed(h.this.gOz, h.this.gOl);
            }
        }
    };
    private Runnable gOz = new Runnable() { // from class: com.baidu.tieba.ala.view.h.4
        @Override // java.lang.Runnable
        public void run() {
            if (h.this.gOq != null) {
                h.this.gOq.i(h.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aZB = BdUniqueId.gen();

    static /* synthetic */ long d(h hVar) {
        long j = hVar.gNK;
        hVar.gNK = j - 1;
        return j;
    }

    public h(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.azs = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aNP = str4;
        this.fkg = j2;
        this.otherParams = str3;
        initView();
        this.gOq = new j(this.aZB, this.fKT);
        this.gOq.i(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.fTw);
            this.mHandler.postDelayed(this.fTw, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar) {
        if (nVar != null && nVar.getList() != null && nVar.getList().size() > 0 && nVar.getList().get(0).fJr != null && nVar.getList().get(0).fJr.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = nVar.getList().get(0).getName_show();
            if (nVar.getList().get(0).dSD == 1) {
                alaBroadcastGiftToastData.live_id = nVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = nVar.getList().get(0).fJr.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aNP;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        if (nVar != null) {
            this.gOy.put(nVar.Jp(), Long.valueOf(nVar.bAa()));
            if (a(this.gOr, nVar)) {
                this.gOu = System.currentTimeMillis();
                dT(f(nVar), b(this.gOr, nVar));
                this.gOr = nVar;
            } else {
                this.gOr = nVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(nVar));
                    this.mRootView.setVisibility(0);
                    this.gtn = BdUtilHelper.getTextWidth(this.mPaint, f(nVar));
                } else if (nVar.bAb() != null && !this.gOv) {
                    b(this.mTextView, f(nVar));
                }
            }
            this.gNK = nVar.bzZ();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.gOu = System.currentTimeMillis();
        this.gOr = null;
    }

    private boolean a(n nVar, n nVar2) {
        if (nVar2 == null || System.currentTimeMillis() - this.gOu < this.gOt * 1000 || nVar == null || nVar.bAb() == null) {
            return false;
        }
        if (nVar.bAb().fJJ > 0 || nVar2.bAb().fJJ <= 0) {
            return (nVar.bAb().fJJ > 0 || nVar2.bAb().fJJ > 0) ? true : true;
        }
        return false;
    }

    private String f(n nVar) {
        if (nVar.bAb().fJJ < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(nVar.bAb().fJJ) + "");
    }

    private String b(n nVar, n nVar2) {
        if (nVar.bAb().fJJ == nVar2.bAb().fJJ) {
            this.gOw = "change";
            if (nVar2.bAb().fJJ <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (nVar2.bAb().fJJ == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(nVar2.bAb().fJK - nVar2.bAb().fJM) + "");
            } else if (nVar2.bAb().fJJ <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((nVar2.bAb().fJL - nVar2.bAb().fJK) + 1) + "");
            }
        }
        this.gOw = "up_down";
        int i = nVar2.bAb().fJJ - nVar.bAb().fJJ;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setMaxLines(1);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.gOo = (FrameLayout) this.mRootView.findViewById(a.g.fr_entry);
        this.gOm = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_l);
        this.gOn = (ImageView) this.mRootView.findViewById(a.g.hour_entry_scale_hide_r);
        this.gOo.setAlpha(0.7f);
        this.mTextView.setAlpha(0.7f);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.q.c
    public View GI() {
        return this.mRootView;
    }

    @Override // com.baidu.live.q.c
    public com.baidu.live.q.b GJ() {
        return null;
    }

    @Override // com.baidu.live.q.c
    public com.baidu.live.q.b GK() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Er(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(this.mContext, this.azs, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aNP, this.fkg, this.gOr == null ? i.dC(0) : this.gOr.Jp())));
    }

    @Override // com.baidu.live.q.c
    public void GL() {
        this.gOs = false;
        if (this.gOq != null) {
            this.gOq.i(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.q.c
    public void GM() {
        this.gOs = true;
        this.mHandler.removeCallbacks(this.gOz);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Es(String str) {
        this.mTextView.setText(str);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
        if (this.gOo.getLayoutParams() != null) {
            ViewGroup.LayoutParams layoutParams = this.gOo.getLayoutParams();
            layoutParams.width = this.gtn + BdUtilHelper.dip2px(this.mContext, 16.0f);
            this.gOo.setLayoutParams(layoutParams);
        }
        if (this.mTextView.getLayoutParams() != null) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams2.width = (int) (textWidth * 1.2d);
            this.mTextView.setLayoutParams(layoutParams2);
        }
        this.gOm.setVisibility(0);
        this.gOn.setVisibility(0);
        if (textWidth > this.gtn) {
            TranslateAnimation translateAnimation = new TranslateAnimation(2, 0.0f, 2, -(((textWidth - this.gtn) * 1.0f) / this.gtn), 1, 0.0f, 1, 0.0f);
            translateAnimation.setDuration(2800L);
            translateAnimation.setFillAfter(true);
            this.mTextView.startAnimation(translateAnimation);
        }
    }

    private void dT(final String str, final String str2) {
        if (this.aKj == null) {
            this.aKj = new AnimatorSet();
        }
        this.aKj.cancel();
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
                h.this.Es(str2);
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
                h.this.gOm.setVisibility(4);
                h.this.gOn.setVisibility(4);
                h.this.b(h.this.mTextView, str);
                h.this.aKj.cancel();
                h.this.mRootView.clearAnimation();
                ofFloat3.cancel();
                ofFloat4.cancel();
                ofFloat3.removeAllListeners();
                h.this.mTextView.clearAnimation();
                h.this.gOv = false;
                h.this.gOw = "default";
                h.this.gOo.setAlpha(0.7f);
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
        this.aKj.playTogether(this.mAnimators);
        this.aKj.start();
        this.gOv = true;
        this.gOo.setAlpha(1.0f);
        this.mTextView.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            if (this.gOo.getLayoutParams() != null) {
                ViewGroup.LayoutParams layoutParams = this.gOo.getLayoutParams();
                layoutParams.width = BdUtilHelper.dip2px(this.mContext, 16.0f) + textWidth;
                this.gOo.setLayoutParams(layoutParams);
            }
            ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
            layoutParams2.width = BdUtilHelper.dip2px(this.mContext, 6.0f) + textWidth;
            textView.setLayoutParams(layoutParams2);
            textView.setText(str);
            this.gtn = textWidth;
        }
    }

    @Override // com.baidu.live.q.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.gOq != null) {
            this.gOq.destory();
        }
    }
}
