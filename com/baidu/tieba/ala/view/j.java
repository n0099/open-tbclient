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
    private long gpB;
    private int hLd;
    private long ijf;
    private BdUniqueId iko;
    private m ikp;
    private p ikq;
    private long ikt;
    private boolean iku;
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
    private long ikn = 5000;
    private Handler mHandler = new Handler();
    private boolean gLK = true;
    private boolean ikr = false;
    private long iks = 17;
    private String ikv = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    private ArrayList<String> ikw = new ArrayList<>();
    private Map<String, Long> ikx = new HashMap();
    private final Runnable hdA = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.ijf <= 0) {
                j.this.ijf = 0L;
            } else {
                if (j.this.ijf == 300 && j.this.ikq != null && !j.this.ikw.contains(j.this.ikq.Vn())) {
                    j.this.ikw.add(j.this.ikq.Vn());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.ijf <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.ikx.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.iko = BdUniqueId.gen();
                    j.this.ikp.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.iko);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.IA("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.bdj, j.this.ikv, j.this.otherParams);
        }
    };
    private n gUP = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p clN = alaGetHourRankListResponseMessage.clN();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.iko) {
                    j.this.d(clN);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.aCW) {
                    j.this.e(clN);
                }
                j.this.ikn = clN.bUw();
                j.this.iks = clN.bUx();
            }
            if (!j.this.ikr && j.this.iky != null) {
                j.this.mHandler.removeCallbacks(j.this.iky);
                j.this.mHandler.postDelayed(j.this.iky, j.this.ikn);
            }
        }
    };
    private Runnable iky = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.ikp != null) {
                j.this.ikp.l(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aCW = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.ijf;
        jVar.ijf = j - 1;
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
        this.gpB = j2;
        this.otherParams = str3;
        initView();
        this.ikp = new m(this.aCW, this.gUP);
        this.ikp.l(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.hdA);
            this.mHandler.postDelayed(this.hdA, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gSH != null && pVar.getList().get(0).gSH.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).eRx == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gSH.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.bdj;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.ikx.put(pVar.Vn(), Long.valueOf(pVar.bUz()));
            if (a(this.ikq, pVar)) {
                this.ikt = System.currentTimeMillis();
                eF(f(pVar), b(this.ikq, pVar));
                this.ikq = pVar;
            } else {
                this.ikq = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hLd = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hLd;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bUA() != null && !this.iku) {
                    this.mTextView.setText(f(pVar));
                    this.hLd = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hLd;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.ijf = pVar.bUy();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.ikt = System.currentTimeMillis();
        this.ikq = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.ikt < this.iks * 1000 || pVar == null || pVar.bUA() == null) {
            return false;
        }
        if (pVar.bUA().aGy > 0 || pVar2.bUA().aGy <= 0) {
            return (pVar.bUA().aGy > 0 || pVar2.bUA().aGy > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bUA().aGy < 1) {
            return this.mContext.getString(a.h.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.h.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bUA().aGy) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bUA().aGy == pVar2.bUA().aGy) {
            this.ikv = "change";
            if (pVar2.bUA().aGy <= 0) {
                return this.mContext.getString(a.h.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bUA().aGy == 1) {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bUA().aGz - pVar2.bUA().aGB) + "");
            } else if (pVar2.bUA().aGy <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bUA().aGA - pVar2.bUA().aGz) + 1) + "");
            }
        }
        this.ikv = "up_down";
        int i = pVar2.bUA().aGy - pVar.bUA().aGy;
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
    public void IA(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this.mContext, this.aKa, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.bdj, this.gpB, this.ikq == null ? com.baidu.live.utils.j.fb(0) : this.ikq.Vn())));
    }

    @Override // com.baidu.live.x.c
    public void setCanVisible(boolean z) {
        this.gLK = z;
    }

    @Override // com.baidu.live.x.c
    public void PA() {
        this.ikr = false;
        if (this.ikp != null) {
            this.ikp.l(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.x.c
    public void PB() {
        this.ikr = true;
        this.mHandler.removeCallbacks(this.iky);
    }

    private void eF(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hLd) {
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
            this.hLd = textWidth;
        }
    }

    @Override // com.baidu.live.x.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ikp != null) {
            this.ikp.destory();
        }
    }
}
