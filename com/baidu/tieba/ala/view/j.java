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
    private int aIL;
    private String aZH;
    private long fYO;
    private long hLw;
    private BdUniqueId hML;
    private m hMM;
    private p hMN;
    private long hMQ;
    private boolean hMR;
    private int hpE;
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
    private long hMK = 5000;
    private Handler mHandler = new Handler();
    private boolean gts = true;
    private boolean hMO = false;
    private long hMP = 17;
    private String hMS = "default";
    private ArrayList<String> hMT = new ArrayList<>();
    private Map<String, Long> hMU = new HashMap();
    private final Runnable gKv = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hLw <= 0) {
                j.this.hLw = 0L;
            } else {
                if (j.this.hLw == 300 && j.this.hMN != null && !j.this.hMT.contains(j.this.hMN.TU())) {
                    j.this.hMT.add(j.this.hMN.TU());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.hLw <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.hMU.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.hML = BdUniqueId.gen();
                    j.this.hMM.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.hML);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.Ir("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.aZH, j.this.hMS, j.this.otherParams);
        }
    };
    private n gCa = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p chT = alaGetHourRankListResponseMessage.chT();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.hML) {
                    j.this.d(chT);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.bmJ) {
                    j.this.e(chT);
                }
                j.this.hMK = chT.bRs();
                j.this.hMP = chT.bRt();
            }
            if (!j.this.hMO && j.this.hMV != null) {
                j.this.mHandler.removeCallbacks(j.this.hMV);
                j.this.mHandler.postDelayed(j.this.hMV, j.this.hMK);
            }
        }
    };
    private Runnable hMV = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hMM != null) {
                j.this.hMM.j(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId bmJ = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.hLw;
        jVar.hLw = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aIL = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aZH = str4;
        this.fYO = j2;
        this.otherParams = str3;
        initView();
        this.hMM = new m(this.bmJ, this.gCa);
        this.hMM.j(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.gKv);
            this.mHandler.postDelayed(this.gKv, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gzS != null && pVar.getList().get(0).gzS.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).eDa == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gzS.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aZH;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.hMU.put(pVar.TU(), Long.valueOf(pVar.bRv()));
            if (a(this.hMN, pVar)) {
                this.hMQ = System.currentTimeMillis();
                eB(f(pVar), b(this.hMN, pVar));
                this.hMN = pVar;
            } else {
                this.hMN = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hpE = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hpE;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bRw() != null && !this.hMR) {
                    this.mTextView.setText(f(pVar));
                    this.hpE = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hpE;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.hLw = pVar.bRu();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hMQ = System.currentTimeMillis();
        this.hMN = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.hMQ < this.hMP * 1000 || pVar == null || pVar.bRw() == null) {
            return false;
        }
        if (pVar.bRw().aGr > 0 || pVar2.bRw().aGr <= 0) {
            return (pVar.bRw().aGr > 0 || pVar2.bRw().aGr > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bRw().aGr < 1) {
            return this.mContext.getString(a.h.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.h.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bRw().aGr) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bRw().aGr == pVar2.bRw().aGr) {
            this.hMS = "change";
            if (pVar2.bRw().aGr <= 0) {
                return this.mContext.getString(a.h.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bRw().aGr == 1) {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bRw().aGs - pVar2.bRw().aGu) + "");
            } else if (pVar2.bRw().aGr <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bRw().aGt - pVar2.bRw().aGs) + 1) + "");
            }
        }
        this.hMS = "up_down";
        int i = pVar2.bRw().aGr - pVar.bRw().aGr;
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
    public View Ow() {
        return this.mRootView;
    }

    @Override // com.baidu.live.u.c
    public com.baidu.live.u.b Ox() {
        return null;
    }

    @Override // com.baidu.live.u.c
    public com.baidu.live.u.b Oy() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ir(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.aIL, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aZH, this.fYO, this.hMN == null ? com.baidu.live.utils.j.ge(0) : this.hMN.TU())));
    }

    @Override // com.baidu.live.u.c
    public void setCanVisible(boolean z) {
        this.gts = z;
    }

    @Override // com.baidu.live.u.c
    public void Oz() {
        this.hMO = false;
        if (this.hMM != null) {
            this.hMM.j(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.u.c
    public void OA() {
        this.hMO = true;
        this.mHandler.removeCallbacks(this.hMV);
    }

    private void eB(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hpE) {
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
            this.hpE = textWidth;
        }
    }

    @Override // com.baidu.live.u.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hMM != null) {
            this.hMM.destory();
        }
    }
}
