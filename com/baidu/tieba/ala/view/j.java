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
/* loaded from: classes10.dex */
public class j implements com.baidu.live.z.c {
    private int aHv;
    private String bac;
    private long gmS;
    private int hGC;
    private long iel;
    private m ifA;
    private p ifB;
    private long ifE;
    private boolean ifF;
    private BdUniqueId ifz;
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
    private long ify = 5000;
    private Handler mHandler = new Handler();
    private boolean gJe = true;
    private boolean ifC = false;
    private long ifD = 17;
    private String ifG = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    private ArrayList<String> ifH = new ArrayList<>();
    private Map<String, Long> ifI = new HashMap();
    private final Runnable haQ = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.iel <= 0) {
                j.this.iel = 0L;
            } else {
                if (j.this.iel == 300 && j.this.ifB != null && !j.this.ifH.contains(j.this.ifB.TG())) {
                    j.this.ifH.add(j.this.ifB.TG());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.iel <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.ifI.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.ifz = BdUniqueId.gen();
                    j.this.ifA.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.ifz);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.HU("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.bac, j.this.ifG, j.this.otherParams);
        }
    };
    private n gSf = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p ckP = alaGetHourRankListResponseMessage.ckP();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.ifz) {
                    j.this.d(ckP);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.brL) {
                    j.this.e(ckP);
                }
                j.this.ify = ckP.bTR();
                j.this.ifD = ckP.bTS();
            }
            if (!j.this.ifC && j.this.ifJ != null) {
                j.this.mHandler.removeCallbacks(j.this.ifJ);
                j.this.mHandler.postDelayed(j.this.ifJ, j.this.ify);
            }
        }
    };
    private Runnable ifJ = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.ifA != null) {
                j.this.ifA.k(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId brL = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.iel;
        jVar.iel = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aHv = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.bac = str4;
        this.gmS = j2;
        this.otherParams = str3;
        initView();
        this.ifA = new m(this.brL, this.gSf);
        this.ifA.k(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.haQ);
            this.mHandler.postDelayed(this.haQ, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gPX != null && pVar.getList().get(0).gPX.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).ePl == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gPX.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.bac;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.ifI.put(pVar.TG(), Long.valueOf(pVar.bTU()));
            if (a(this.ifB, pVar)) {
                this.ifE = System.currentTimeMillis();
                eG(f(pVar), b(this.ifB, pVar));
                this.ifB = pVar;
            } else {
                this.ifB = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hGC = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hGC;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bTV() != null && !this.ifF) {
                    this.mTextView.setText(f(pVar));
                    this.hGC = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hGC;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.iel = pVar.bTT();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.ifE = System.currentTimeMillis();
        this.ifB = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.ifE < this.ifD * 1000 || pVar == null || pVar.bTV() == null) {
            return false;
        }
        if (pVar.bTV().aEL > 0 || pVar2.bTV().aEL <= 0) {
            return (pVar.bTV().aEL > 0 || pVar2.bTV().aEL > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bTV().aEL < 1) {
            return this.mContext.getString(a.h.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.h.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bTV().aEL) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bTV().aEL == pVar2.bTV().aEL) {
            this.ifG = "change";
            if (pVar2.bTV().aEL <= 0) {
                return this.mContext.getString(a.h.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bTV().aEL == 1) {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bTV().aEM - pVar2.bTV().aEO) + "");
            } else if (pVar2.bTV().aEL <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bTV().aEN - pVar2.bTV().aEM) + 1) + "");
            }
        }
        this.ifG = "up_down";
        int i = pVar2.bTV().aEL - pVar.bTV().aEL;
        return i < 0 ? String.format(this.mContext.getString(a.h.hour_rank_list_entry_updown_up), (-i) + "") : i > 0 ? String.format(this.mContext.getString(a.h.hour_rank_list_entry_updown_down), i + "") : "";
    }

    private void initView() {
        this.mRootView = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_entry_layout, (ViewGroup) null);
        this.mTextView = (TextView) this.mRootView.findViewById(a.f.hour_rank_list_text);
        this.mTextView.setOnClickListener(this.mClickListener);
        this.mPaint = new Paint();
        this.mPaint.setTextSize(this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds24));
    }

    @Override // com.baidu.live.z.c
    public View NY() {
        return this.mRootView;
    }

    @Override // com.baidu.live.z.c
    public com.baidu.live.z.b NZ() {
        return null;
    }

    @Override // com.baidu.live.z.c
    public com.baidu.live.z.b Oa() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void HU(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this.mContext, this.aHv, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.bac, this.gmS, this.ifB == null ? com.baidu.live.utils.j.eX(0) : this.ifB.TG())));
    }

    @Override // com.baidu.live.z.c
    public void setCanVisible(boolean z) {
        this.gJe = z;
    }

    @Override // com.baidu.live.z.c
    public void Ob() {
        this.ifC = false;
        if (this.ifA != null) {
            this.ifA.k(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.z.c
    public void Oc() {
        this.ifC = true;
        this.mHandler.removeCallbacks(this.ifJ);
    }

    private void eG(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hGC) {
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
            this.hGC = textWidth;
        }
    }

    @Override // com.baidu.live.z.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ifA != null) {
            this.ifA.destory();
        }
    }
}
