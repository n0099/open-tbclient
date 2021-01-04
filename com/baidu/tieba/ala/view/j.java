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
/* loaded from: classes11.dex */
public class j implements com.baidu.live.z.c {
    private int aMi;
    private String beS;
    private long grz;
    private int hLi;
    private long iiS;
    private BdUniqueId ikg;
    private m ikh;
    private p iki;
    private long ikl;
    private boolean ikm;
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
    private long ikf = 5000;
    private Handler mHandler = new Handler();
    private boolean gNK = true;
    private boolean ikj = false;
    private long ikk = 17;
    private String ikn = "default";
    private ArrayList<String> iko = new ArrayList<>();
    private Map<String, Long> ikp = new HashMap();
    private final Runnable hfw = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.iiS <= 0) {
                j.this.iiS = 0L;
            } else {
                if (j.this.iiS == 300 && j.this.iki != null && !j.this.iko.contains(j.this.iki.Xy())) {
                    j.this.iko.add(j.this.iki.Xy());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.iiS <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.ikp.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.ikg = BdUniqueId.gen();
                    j.this.ikh.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.ikg);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.Jg("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.beS, j.this.ikn, j.this.otherParams);
        }
    };
    private n gWL = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p coG = alaGetHourRankListResponseMessage.coG();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.ikg) {
                    j.this.d(coG);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.bwz) {
                    j.this.e(coG);
                }
                j.this.ikf = coG.bXI();
                j.this.ikk = coG.bXJ();
            }
            if (!j.this.ikj && j.this.ikq != null) {
                j.this.mHandler.removeCallbacks(j.this.ikq);
                j.this.mHandler.postDelayed(j.this.ikq, j.this.ikf);
            }
        }
    };
    private Runnable ikq = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.ikh != null) {
                j.this.ikh.k(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId bwz = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.iiS;
        jVar.iiS = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aMi = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.beS = str4;
        this.grz = j2;
        this.otherParams = str3;
        initView();
        this.ikh = new m(this.bwz, this.gWL);
        this.ikh.k(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.hfw);
            this.mHandler.postDelayed(this.hfw, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gUD != null && pVar.getList().get(0).gUD.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).eTW == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gUD.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.beS;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.ikp.put(pVar.Xy(), Long.valueOf(pVar.bXL()));
            if (a(this.iki, pVar)) {
                this.ikl = System.currentTimeMillis();
                eH(f(pVar), b(this.iki, pVar));
                this.iki = pVar;
            } else {
                this.iki = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hLi = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hLi;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bXM() != null && !this.ikm) {
                    this.mTextView.setText(f(pVar));
                    this.hLi = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hLi;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.iiS = pVar.bXK();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.ikl = System.currentTimeMillis();
        this.iki = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.ikl < this.ikk * 1000 || pVar == null || pVar.bXM() == null) {
            return false;
        }
        if (pVar.bXM().aJy > 0 || pVar2.bXM().aJy <= 0) {
            return (pVar.bXM().aJy > 0 || pVar2.bXM().aJy > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bXM().aJy < 1) {
            return this.mContext.getString(a.h.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.h.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bXM().aJy) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bXM().aJy == pVar2.bXM().aJy) {
            this.ikn = "change";
            if (pVar2.bXM().aJy <= 0) {
                return this.mContext.getString(a.h.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bXM().aJy == 1) {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bXM().aJz - pVar2.bXM().aJB) + "");
            } else if (pVar2.bXM().aJy <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bXM().aJA - pVar2.bXM().aJz) + 1) + "");
            }
        }
        this.ikn = "up_down";
        int i = pVar2.bXM().aJy - pVar.bXM().aJy;
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
    public View RT() {
        return this.mRootView;
    }

    @Override // com.baidu.live.z.c
    public com.baidu.live.z.b RU() {
        return null;
    }

    @Override // com.baidu.live.z.c
    public com.baidu.live.z.b RV() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jg(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this.mContext, this.aMi, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.beS, this.grz, this.iki == null ? com.baidu.live.utils.j.gE(0) : this.iki.Xy())));
    }

    @Override // com.baidu.live.z.c
    public void setCanVisible(boolean z) {
        this.gNK = z;
    }

    @Override // com.baidu.live.z.c
    public void RW() {
        this.ikj = false;
        if (this.ikh != null) {
            this.ikh.k(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.z.c
    public void RX() {
        this.ikj = true;
        this.mHandler.removeCallbacks(this.ikq);
    }

    private void eH(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hLi) {
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
            this.hLi = textWidth;
        }
    }

    @Override // com.baidu.live.z.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.ikh != null) {
            this.ikh.destory();
        }
    }
}
