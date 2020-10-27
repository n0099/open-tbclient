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
public class j implements com.baidu.live.t.c {
    private int aJw;
    private String baa;
    private long fTr;
    private long hFS;
    private BdUniqueId hHh;
    private m hHi;
    private p hHj;
    private long hHm;
    private boolean hHn;
    private int hkg;
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
    private long hHg = 5000;
    private Handler mHandler = new Handler();
    private boolean gnY = true;
    private boolean hHk = false;
    private long hHl = 17;
    private String hHo = "default";
    private ArrayList<String> hHp = new ArrayList<>();
    private Map<String, Long> hHq = new HashMap();
    private final Runnable gFb = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hFS <= 0) {
                j.this.hFS = 0L;
            } else {
                if (j.this.hFS == 300 && j.this.hHj != null && !j.this.hHp.contains(j.this.hHj.RV())) {
                    j.this.hHp.add(j.this.hHj.RV());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.hFS <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.hHq.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.hHh = BdUniqueId.gen();
                    j.this.hHi.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.hHh);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.Iz("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.baa, j.this.hHo, j.this.otherParams);
        }
    };
    private n gwF = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p cfY = alaGetHourRankListResponseMessage.cfY();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.hHh) {
                    j.this.d(cfY);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.bnb) {
                    j.this.e(cfY);
                }
                j.this.hHg = cfY.bPz();
                j.this.hHl = cfY.bPA();
            }
            if (!j.this.hHk && j.this.hHr != null) {
                j.this.mHandler.removeCallbacks(j.this.hHr);
                j.this.mHandler.postDelayed(j.this.hHr, j.this.hHg);
            }
        }
    };
    private Runnable hHr = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hHi != null) {
                j.this.hHi.i(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId bnb = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.hFS;
        jVar.hFS = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aJw = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.baa = str4;
        this.fTr = j2;
        this.otherParams = str3;
        initView();
        this.hHi = new m(this.bnb, this.gwF);
        this.hHi.i(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.gFb);
            this.mHandler.postDelayed(this.gFb, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gux != null && pVar.getList().get(0).gux.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).eyT == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gux.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.baa;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.hHq.put(pVar.RV(), Long.valueOf(pVar.bPC()));
            if (a(this.hHj, pVar)) {
                this.hHm = System.currentTimeMillis();
                eB(f(pVar), b(this.hHj, pVar));
                this.hHj = pVar;
            } else {
                this.hHj = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hkg = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hkg;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bPD() != null && !this.hHn) {
                    this.mTextView.setText(f(pVar));
                    this.hkg = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hkg;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.hFS = pVar.bPB();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.hHm = System.currentTimeMillis();
        this.hHj = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.hHm < this.hHl * 1000 || pVar == null || pVar.bPD() == null) {
            return false;
        }
        if (pVar.bPD().aHl > 0 || pVar2.bPD().aHl <= 0) {
            return (pVar.bPD().aHl > 0 || pVar2.bPD().aHl > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bPD().aHl < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bPD().aHl) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bPD().aHl == pVar2.bPD().aHl) {
            this.hHo = "change";
            if (pVar2.bPD().aHl <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bPD().aHl == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bPD().aHm - pVar2.bPD().aHo) + "");
            } else if (pVar2.bPD().aHl <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bPD().aHn - pVar2.bPD().aHm) + 1) + "");
            }
        }
        this.hHo = "up_down";
        int i = pVar2.bPD().aHl - pVar.bPD().aHl;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.t.c
    public View OF() {
        return this.mRootView;
    }

    @Override // com.baidu.live.t.c
    public com.baidu.live.t.b OG() {
        return null;
    }

    @Override // com.baidu.live.t.c
    public com.baidu.live.t.b OH() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Iz(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new r(this.mContext, this.aJw, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.baa, this.fTr, this.hHj == null ? com.baidu.live.utils.j.fV(0) : this.hHj.RV())));
    }

    @Override // com.baidu.live.t.c
    public void setCanVisible(boolean z) {
        this.gnY = z;
    }

    @Override // com.baidu.live.t.c
    public void OI() {
        this.hHk = false;
        if (this.hHi != null) {
            this.hHi.i(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.t.c
    public void OJ() {
        this.hHk = true;
        this.mHandler.removeCallbacks(this.hHr);
    }

    private void eB(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hkg) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTextView, "translationX", 0.0f, -this.mContext.getResources().getDimensionPixelOffset(a.e.sdk_ds190));
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
            this.hkg = textWidth;
        }
    }

    @Override // com.baidu.live.t.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.hHi != null) {
            this.hHi.destory();
        }
    }
}
