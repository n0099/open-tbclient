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
import com.baidu.live.b.p;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.data.AlaBroadcastGiftToastData;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.log.LogManager;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.g.m;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes4.dex */
public class j implements com.baidu.live.s.c {
    private int aIU;
    private String aYD;
    private long fLa;
    private int gYq;
    private BdUniqueId huK;
    private m huL;
    private n huM;
    private long huP;
    private boolean huQ;
    private long hub;
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
    private long huJ = 5000;
    private Handler mHandler = new Handler();
    private boolean gdU = true;
    private boolean huN = false;
    private long huO = 17;
    private String huR = "default";
    private ArrayList<String> huS = new ArrayList<>();
    private Map<String, Long> huT = new HashMap();
    private final Runnable guX = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.hub <= 0) {
                j.this.hub = 0L;
            } else {
                if (j.this.hub == 300 && j.this.huM != null && !j.this.huS.contains(j.this.huM.QP())) {
                    j.this.huS.add(j.this.huM.QP());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.hub <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.huT.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.huK = BdUniqueId.gen();
                    j.this.huL.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.huK);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.Ia("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.aYD, j.this.huR, j.this.otherParams);
        }
    };
    private com.baidu.tieba.ala.g.n gmA = new com.baidu.tieba.ala.g.n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                n ccT = alaGetHourRankListResponseMessage.ccT();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.huK) {
                    j.this.d(ccT);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.blA) {
                    j.this.e(ccT);
                }
                j.this.huJ = ccT.bMU();
                j.this.huO = ccT.bMV();
            }
            if (!j.this.huN && j.this.huU != null) {
                j.this.mHandler.removeCallbacks(j.this.huU);
                j.this.mHandler.postDelayed(j.this.huU, j.this.huJ);
            }
        }
    };
    private Runnable huU = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.huL != null) {
                j.this.huL.i(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId blA = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.hub;
        jVar.hub = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aIU = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.aYD = str4;
        this.fLa = j2;
        this.otherParams = str3;
        initView();
        this.huL = new m(this.blA, this.gmA);
        this.huL.i(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.guX);
            this.mHandler.postDelayed(this.guX, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(n nVar) {
        if (nVar != null && nVar.getList() != null && nVar.getList().size() > 0 && nVar.getList().get(0).gkt != null && nVar.getList().get(0).gkt.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = nVar.getList().get(0).getName_show();
            if (nVar.getList().get(0).eqs == 1) {
                alaBroadcastGiftToastData.live_id = nVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = nVar.getList().get(0).gkt.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.aYD;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(n nVar) {
        if (nVar != null) {
            this.huT.put(nVar.QP(), Long.valueOf(nVar.bMX()));
            if (a(this.huM, nVar)) {
                this.huP = System.currentTimeMillis();
                ew(f(nVar), b(this.huM, nVar));
                this.huM = nVar;
            } else {
                this.huM = nVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(nVar));
                    this.mRootView.setVisibility(0);
                    this.gYq = BdUtilHelper.getTextWidth(this.mPaint, f(nVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.gYq;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (nVar.bMY() != null && !this.huQ) {
                    this.mTextView.setText(f(nVar));
                    this.gYq = BdUtilHelper.getTextWidth(this.mPaint, f(nVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.gYq;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.hub = nVar.bMW();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.huP = System.currentTimeMillis();
        this.huM = null;
    }

    private boolean a(n nVar, n nVar2) {
        if (nVar2 == null || System.currentTimeMillis() - this.huP < this.huO * 1000 || nVar == null || nVar.bMY() == null) {
            return false;
        }
        if (nVar.bMY().aHa > 0 || nVar2.bMY().aHa <= 0) {
            return (nVar.bMY().aHa > 0 || nVar2.bMY().aHa > 0) ? true : true;
        }
        return false;
    }

    private String f(n nVar) {
        if (nVar.bMY().aHa < 1) {
            return this.mContext.getString(a.i.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.i.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(nVar.bMY().aHa) + "");
    }

    private String b(n nVar, n nVar2) {
        if (nVar.bMY().aHa == nVar2.bMY().aHa) {
            this.huR = "change";
            if (nVar2.bMY().aHa <= 0) {
                return this.mContext.getString(a.i.hour_rank_list_entry_diff_no);
            }
            if (nVar2.bMY().aHa == 1) {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(nVar2.bMY().aHb - nVar2.bMY().aHd) + "");
            } else if (nVar2.bMY().aHa <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.i.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((nVar2.bMY().aHc - nVar2.bMY().aHb) + 1) + "");
            }
        }
        this.huR = "up_down";
        int i = nVar2.bMY().aHa - nVar.bMY().aHa;
        return i < 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.i.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.g.hour_rank_list_text);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds24));
    }

    @Override // com.baidu.live.s.c
    public View Oh() {
        return this.mRootView;
    }

    @Override // com.baidu.live.s.c
    public com.baidu.live.s.b Oi() {
        return null;
    }

    @Override // com.baidu.live.s.c
    public com.baidu.live.s.b Oj() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ia(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new p(this.mContext, this.aIU, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.aYD, this.fLa, this.huM == null ? com.baidu.live.utils.j.fQ(0) : this.huM.QP())));
    }

    @Override // com.baidu.live.s.c
    public void Ok() {
        this.huN = false;
        if (this.huL != null) {
            this.huL.i(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.s.c
    public void Ol() {
        this.huN = true;
        this.mHandler.removeCallbacks(this.huU);
    }

    private void ew(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.gYq) {
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
            this.gYq = textWidth;
        }
    }

    @Override // com.baidu.live.s.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.huL != null) {
            this.huL.destory();
        }
    }
}
