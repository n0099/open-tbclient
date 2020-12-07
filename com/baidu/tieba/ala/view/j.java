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
    private long ggZ;
    private long hWq;
    private BdUniqueId hXF;
    private m hXG;
    private p hXH;
    private long hXK;
    private boolean hXL;
    private int hzi;
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
    private long hXE = 5000;
    private Handler mHandler = new Handler();
    private boolean gBW = true;
    private boolean hXI = false;
    private long hXJ = 17;
    private String hXM = "default";
    private ArrayList<String> hXN = new ArrayList<>();
    private Map<String, Long> hXO = new HashMap();
    private final Runnable gTH = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hWq <= 0) {
                j.this.hWq = 0L;
            } else {
                if (j.this.hWq == 300 && j.this.hXH != null && !j.this.hXN.contains(j.this.hXH.Wu())) {
                    j.this.hXN.add(j.this.hXH.Wu());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.hWq <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.hXO.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.hXF = BdUniqueId.gen();
                    j.this.hXG.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.hXF);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.Ji("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.bdh, j.this.hXM, j.this.otherParams);
        }
    };
    private n gKX = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p clO = alaGetHourRankListResponseMessage.clO();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.hXF) {
                    j.this.d(clO);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.brR) {
                    j.this.e(clO);
                }
                j.this.hXE = clO.bVc();
                j.this.hXJ = clO.bVd();
            }
            if (!j.this.hXI && j.this.hXP != null) {
                j.this.mHandler.removeCallbacks(j.this.hXP);
                j.this.mHandler.postDelayed(j.this.hXP, j.this.hXE);
            }
        }
    };
    private Runnable hXP = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hXG != null) {
                j.this.hXG.l(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId brR = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.hWq;
        jVar.hWq = j - 1;
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
        this.ggZ = j2;
        this.otherParams = str3;
        initView();
        this.hXG = new m(this.brR, this.gKX);
        this.hXG.l(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.gTH);
            this.mHandler.postDelayed(this.gTH, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gIP != null && pVar.getList().get(0).gIP.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).eKc == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gIP.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.bdh;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.hXO.put(pVar.Wu(), Long.valueOf(pVar.bVf()));
            if (a(this.hXH, pVar)) {
                this.hXK = System.currentTimeMillis();
                eG(f(pVar), b(this.hXH, pVar));
                this.hXH = pVar;
            } else {
                this.hXH = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hzi = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hzi;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bVg() != null && !this.hXL) {
                    this.mTextView.setText(f(pVar));
                    this.hzi = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hzi;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.hWq = pVar.bVe();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hXK = System.currentTimeMillis();
        this.hXH = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.hXK < this.hXJ * 1000 || pVar == null || pVar.bVg() == null) {
            return false;
        }
        if (pVar.bVg().aJa > 0 || pVar2.bVg().aJa <= 0) {
            return (pVar.bVg().aJa > 0 || pVar2.bVg().aJa > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bVg().aJa < 1) {
            return this.mContext.getString(a.h.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.h.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bVg().aJa) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bVg().aJa == pVar2.bVg().aJa) {
            this.hXM = "change";
            if (pVar2.bVg().aJa <= 0) {
                return this.mContext.getString(a.h.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bVg().aJa == 1) {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bVg().aJb - pVar2.bVg().aJd) + "");
            } else if (pVar2.bVg().aJa <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bVg().aJc - pVar2.bVg().aJb) + 1) + "");
            }
        }
        this.hXM = "up_down";
        int i = pVar2.bVg().aJa - pVar.bVg().aJa;
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
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this.mContext, this.aLE, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.bdh, this.ggZ, this.hXH == null ? com.baidu.live.utils.j.gD(0) : this.hXH.Wu())));
    }

    @Override // com.baidu.live.y.c
    public void setCanVisible(boolean z) {
        this.gBW = z;
    }

    @Override // com.baidu.live.y.c
    public void QT() {
        this.hXI = false;
        if (this.hXG != null) {
            this.hXG.l(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.y.c
    public void QU() {
        this.hXI = true;
        this.mHandler.removeCallbacks(this.hXP);
    }

    private void eG(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hzi) {
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
            this.hzi = textWidth;
        }
    }

    @Override // com.baidu.live.y.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hXG != null) {
            this.hXG.destory();
        }
    }
}
