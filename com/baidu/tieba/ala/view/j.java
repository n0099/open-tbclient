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
import com.baidu.live.b.r;
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
public class j implements com.baidu.live.u.c {
    private int aKw;
    private String bbt;
    private long fZh;
    private long hLP;
    private BdUniqueId hNe;
    private m hNf;
    private p hNg;
    private long hNj;
    private boolean hNk;
    private int hpX;
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
    private long hNd = 5000;
    private Handler mHandler = new Handler();
    private boolean gtL = true;
    private boolean hNh = false;
    private long hNi = 17;
    private String hNl = "default";
    private ArrayList<String> hNm = new ArrayList<>();
    private Map<String, Long> hNn = new HashMap();
    private final Runnable gKO = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hLP <= 0) {
                j.this.hLP = 0L;
            } else {
                if (j.this.hLP == 300 && j.this.hNg != null && !j.this.hNm.contains(j.this.hNg.UD())) {
                    j.this.hNm.add(j.this.hNg.UD());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.hLP <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.hNn.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.hNe = BdUniqueId.gen();
                    j.this.hNf.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.hNe);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.IQ("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.bbt, j.this.hNl, j.this.otherParams);
        }
    };
    private n gCt = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p ciA = alaGetHourRankListResponseMessage.ciA();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.hNe) {
                    j.this.d(ciA);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.bou) {
                    j.this.e(ciA);
                }
                j.this.hNd = ciA.bRZ();
                j.this.hNi = ciA.bSa();
            }
            if (!j.this.hNh && j.this.hNo != null) {
                j.this.mHandler.removeCallbacks(j.this.hNo);
                j.this.mHandler.postDelayed(j.this.hNo, j.this.hNd);
            }
        }
    };
    private Runnable hNo = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hNf != null) {
                j.this.hNf.j(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId bou = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.hLP;
        jVar.hLP = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aKw = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bbt = str4;
        this.fZh = j2;
        this.otherParams = str3;
        initView();
        this.hNf = new m(this.bou, this.gCt);
        this.hNf.j(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.gKO);
            this.mHandler.postDelayed(this.gKO, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gAl != null && pVar.getList().get(0).gAl.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).eEI == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gAl.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.bbt;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.hNn.put(pVar.UD(), Long.valueOf(pVar.bSc()));
            if (a(this.hNg, pVar)) {
                this.hNj = System.currentTimeMillis();
                eB(f(pVar), b(this.hNg, pVar));
                this.hNg = pVar;
            } else {
                this.hNg = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hpX = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hpX;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bSd() != null && !this.hNk) {
                    this.mTextView.setText(f(pVar));
                    this.hpX = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hpX;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.hLP = pVar.bSb();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hNj = System.currentTimeMillis();
        this.hNg = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.hNj < this.hNi * 1000 || pVar == null || pVar.bSd() == null) {
            return false;
        }
        if (pVar.bSd().aIc > 0 || pVar2.bSd().aIc <= 0) {
            return (pVar.bSd().aIc > 0 || pVar2.bSd().aIc > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bSd().aIc < 1) {
            return this.mContext.getString(a.h.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.h.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bSd().aIc) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bSd().aIc == pVar2.bSd().aIc) {
            this.hNl = "change";
            if (pVar2.bSd().aIc <= 0) {
                return this.mContext.getString(a.h.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bSd().aIc == 1) {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bSd().aId - pVar2.bSd().aIf) + "");
            } else if (pVar2.bSd().aIc <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bSd().aIe - pVar2.bSd().aId) + 1) + "");
            }
        }
        this.hNl = "up_down";
        int i = pVar2.bSd().aIc - pVar.bSd().aIc;
        return i < 0 ? String.format(this.mContext.getString(a.h.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.h.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.f.hour_rank_list_text);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds24));
    }

    @Override // com.baidu.live.u.c
    public View Pf() {
        return this.mRootView;
    }

    @Override // com.baidu.live.u.c
    public com.baidu.live.u.b Pg() {
        return null;
    }

    @Override // com.baidu.live.u.c
    public com.baidu.live.u.b Ph() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IQ(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.aKw, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.bbt, this.fZh, this.hNg == null ? com.baidu.live.utils.j.gi(0) : this.hNg.UD())));
    }

    @Override // com.baidu.live.u.c
    public void setCanVisible(boolean z) {
        this.gtL = z;
    }

    @Override // com.baidu.live.u.c
    public void Pi() {
        this.hNh = false;
        if (this.hNf != null) {
            this.hNf.j(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.u.c
    public void Pj() {
        this.hNh = true;
        this.mHandler.removeCallbacks(this.hNo);
    }

    private void eB(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hpX) {
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
            this.hpX = textWidth;
        }
    }

    @Override // com.baidu.live.u.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hNf != null) {
            this.hNf.destory();
        }
    }
}
