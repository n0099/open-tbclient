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
import com.baidu.searchbox.config.DefaultSharedPrefsWrapper;
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.g.m;
import com.baidu.tieba.ala.g.n;
import com.baidu.tieba.ala.message.AlaGetHourRankListResponseMessage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes11.dex */
public class j implements com.baidu.live.x.c {
    private int aKa;
    private String bdj;
    private long gpP;
    private int hLr;
    private long ijt;
    private BdUniqueId ikC;
    private m ikD;
    private p ikE;
    private long ikH;
    private boolean ikI;
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
    private long ikB = 5000;
    private Handler mHandler = new Handler();
    private boolean gLY = true;
    private boolean ikF = false;
    private long ikG = 17;
    private String ikJ = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    private ArrayList<String> ikK = new ArrayList<>();
    private Map<String, Long> ikL = new HashMap();
    private final Runnable hdO = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.ijt <= 0) {
                j.this.ijt = 0L;
            } else {
                if (j.this.ijt == 300 && j.this.ikE != null && !j.this.ikK.contains(j.this.ikE.Vn())) {
                    j.this.ikK.add(j.this.ikE.Vn());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.ijt <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.ikL.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.ikC = BdUniqueId.gen();
                    j.this.ikD.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.ikC);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.IB("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.bdj, j.this.ikJ, j.this.otherParams);
        }
    };
    private n gVd = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p clU = alaGetHourRankListResponseMessage.clU();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.ikC) {
                    j.this.d(clU);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.aCW) {
                    j.this.e(clU);
                }
                j.this.ikB = clU.bUD();
                j.this.ikG = clU.bUE();
            }
            if (!j.this.ikF && j.this.ikM != null) {
                j.this.mHandler.removeCallbacks(j.this.ikM);
                j.this.mHandler.postDelayed(j.this.ikM, j.this.ikB);
            }
        }
    };
    private Runnable ikM = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.ikD != null) {
                j.this.ikD.l(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aCW = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.ijt;
        jVar.ijt = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aKa = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bdj = str4;
        this.gpP = j2;
        this.otherParams = str3;
        initView();
        this.ikD = new m(this.aCW, this.gVd);
        this.ikD.l(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.hdO);
            this.mHandler.postDelayed(this.hdO, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gSV != null && pVar.getList().get(0).gSV.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).eRx == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gSV.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.bdj;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.ikL.put(pVar.Vn(), Long.valueOf(pVar.bUG()));
            if (a(this.ikE, pVar)) {
                this.ikH = System.currentTimeMillis();
                eF(f(pVar), b(this.ikE, pVar));
                this.ikE = pVar;
            } else {
                this.ikE = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hLr = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hLr;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bUH() != null && !this.ikI) {
                    this.mTextView.setText(f(pVar));
                    this.hLr = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hLr;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.ijt = pVar.bUF();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.ikH = System.currentTimeMillis();
        this.ikE = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.ikH < this.ikG * 1000 || pVar == null || pVar.bUH() == null) {
            return false;
        }
        if (pVar.bUH().aGy > 0 || pVar2.bUH().aGy <= 0) {
            return (pVar.bUH().aGy > 0 || pVar2.bUH().aGy > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bUH().aGy < 1) {
            return this.mContext.getString(a.h.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.h.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bUH().aGy) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bUH().aGy == pVar2.bUH().aGy) {
            this.ikJ = "change";
            if (pVar2.bUH().aGy <= 0) {
                return this.mContext.getString(a.h.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bUH().aGy == 1) {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bUH().aGz - pVar2.bUH().aGB) + "");
            } else if (pVar2.bUH().aGy <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bUH().aGA - pVar2.bUH().aGz) + 1) + "");
            }
        }
        this.ikJ = "up_down";
        int i = pVar2.bUH().aGy - pVar.bUH().aGy;
        return i < 0 ? String.format(this.mContext.getString(a.h.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.h.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.f.hour_rank_list_text);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds24));
    }

    @Override // com.baidu.live.x.c
    public View Px() {
        return this.mRootView;
    }

    @Override // com.baidu.live.x.c
    public com.baidu.live.x.b Py() {
        return null;
    }

    @Override // com.baidu.live.x.c
    public com.baidu.live.x.b Pz() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IB(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this.mContext, this.aKa, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.bdj, this.gpP, this.ikE == null ? com.baidu.live.utils.j.fb(0) : this.ikE.Vn())));
    }

    @Override // com.baidu.live.x.c
    public void setCanVisible(boolean z) {
        this.gLY = z;
    }

    @Override // com.baidu.live.x.c
    public void PA() {
        this.ikF = false;
        if (this.ikD != null) {
            this.ikD.l(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.x.c
    public void PB() {
        this.ikF = true;
        this.mHandler.removeCallbacks(this.ikM);
    }

    private void eF(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hLr) {
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.mTextView, "translationX", 0.0f, -this.mContext.getResources().getDimensionPixelOffset(a.d.sdk_ds190));
            ofFloat.setDuration(2800L);
            ofFloat.addListener(new AnimatorListenerAdapter() { // from class: com.baidu.tieba.ala.view.j.5
                @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
                public void onAnimationEnd(Animator animator) {
                    super.onAnimationEnd(animator);
                    j.this.d(j.this.mTextView, str);
                }
            });
            ofFloat.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str);
            textView.setText(str);
            textView.setTranslationX(0.0f);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
            layoutParams.width = textWidth;
            textView.setLayoutParams(layoutParams);
            this.hLr = textWidth;
        }
    }

    @Override // com.baidu.live.x.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ikD != null) {
            this.ikD.destory();
        }
    }
}
