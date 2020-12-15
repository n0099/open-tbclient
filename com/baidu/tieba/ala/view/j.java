package com.baidu.tieba.ala.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.d.s;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.g.m;
import com.baidu.tieba.ala.g.n;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class j implements com.baidu.live.y.c {
    private int aLE;
    private String bdh;
    private long ghb;
    private long hWs;
    private BdUniqueId hXH;
    private m hXI;
    private p hXJ;
    private long hXM;
    private boolean hXN;
    private int hzk;
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
    private long hXG = 5000;
    private Handler mHandler = new Handler();
    private boolean gBY = true;
    private boolean hXK = false;
    private long hXL = 17;
    private String hXO = "default";
    private ArrayList<String> hXP = new ArrayList<>();
    private Map<String, Long> hXQ = new HashMap();
    private final Runnable gTJ = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hWs <= 0) {
                j.this.hWs = 0L;
            } else {
                if (j.this.hWs == 300 && j.this.hXJ != null && !j.this.hXP.contains(j.this.hXJ.Wu())) {
                    j.this.hXP.add(j.this.hXJ.Wu());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.hWs <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.hXQ.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.hXH = BdUniqueId.gen();
                    j.this.hXI.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.hXH);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.Ji("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.bdh, j.this.hXO, j.this.otherParams);
        }
    };
    private n gKZ = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p clP = alaGetHourRankListResponseMessage.clP();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.hXH) {
                    j.this.d(clP);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.brR) {
                    j.this.e(clP);
                }
                j.this.hXG = clP.bVd();
                j.this.hXL = clP.bVe();
            }
            if (!j.this.hXK && j.this.hXR != null) {
                j.this.mHandler.removeCallbacks(j.this.hXR);
                j.this.mHandler.postDelayed(j.this.hXR, j.this.hXG);
            }
        }
    };
    private Runnable hXR = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hXI != null) {
                j.this.hXI.l(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId brR = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.hWs;
        jVar.hWs = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aLE = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bdh = str4;
        this.ghb = j2;
        this.otherParams = str3;
        initView();
        this.hXI = new m(this.brR, this.gKZ);
        this.hXI.l(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.gTJ);
            this.mHandler.postDelayed(this.gTJ, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gIR != null && pVar.getList().get(0).gIR.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).eKc == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gIR.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.bdh;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.hXQ.put(pVar.Wu(), Long.valueOf(pVar.bVg()));
            if (a(this.hXJ, pVar)) {
                this.hXM = System.currentTimeMillis();
                eG(f(pVar), b(this.hXJ, pVar));
                this.hXJ = pVar;
            } else {
                this.hXJ = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hzk = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hzk;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bVh() != null && !this.hXN) {
                    this.mTextView.setText(f(pVar));
                    this.hzk = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hzk;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.hWs = pVar.bVf();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hXM = System.currentTimeMillis();
        this.hXJ = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.hXM < this.hXL * 1000 || pVar == null || pVar.bVh() == null) {
            return false;
        }
        if (pVar.bVh().aJa > 0 || pVar2.bVh().aJa <= 0) {
            return (pVar.bVh().aJa > 0 || pVar2.bVh().aJa > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bVh().aJa < 1) {
            return this.mContext.getString(a.h.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.h.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bVh().aJa) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bVh().aJa == pVar2.bVh().aJa) {
            this.hXO = "change";
            if (pVar2.bVh().aJa <= 0) {
                return this.mContext.getString(a.h.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bVh().aJa == 1) {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bVh().aJb - pVar2.bVh().aJd) + "");
            } else if (pVar2.bVh().aJa <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bVh().aJc - pVar2.bVh().aJb) + 1) + "");
            }
        }
        this.hXO = "up_down";
        int i = pVar2.bVh().aJa - pVar.bVh().aJa;
        return i < 0 ? String.format(this.mContext.getString(a.h.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.h.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.f.hour_rank_list_text);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds24));
    }

    @Override // com.baidu.live.y.c
    public View QQ() {
        return this.mRootView;
    }

    @Override // com.baidu.live.y.c
    public com.baidu.live.y.b QR() {
        return null;
    }

    @Override // com.baidu.live.y.c
    public com.baidu.live.y.b QS() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ji(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this.mContext, this.aLE, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.bdh, this.ghb, this.hXJ == null ? com.baidu.live.utils.j.gD(0) : this.hXJ.Wu())));
    }

    @Override // com.baidu.live.y.c
    public void setCanVisible(boolean z) {
        this.gBY = z;
    }

    @Override // com.baidu.live.y.c
    public void QT() {
        this.hXK = false;
        if (this.hXI != null) {
            this.hXI.l(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.y.c
    public void QU() {
        this.hXK = true;
        this.mHandler.removeCallbacks(this.hXR);
    }

    private void eG(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hzk) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTextView, "translationX", 0.0f, -this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds190));
            ofFloat.setDuration(2800L);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.j.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    j.this.c(j.this.mTextView, str);
                }
            });
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            textView.setText(str);
            textView.setTranslationX(0.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams.width = textWidth;
            textView.setLayoutParams(layoutParams);
            this.hzk = textWidth;
        }
    }

    @Override // com.baidu.live.y.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hXI != null) {
            this.hXI.destory();
        }
    }
}
