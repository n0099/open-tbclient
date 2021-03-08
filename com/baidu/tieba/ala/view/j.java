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
public class j implements com.baidu.live.x.c {
    private int aLA;
    private String beL;
    private long gry;
    private int hNa;
    private long ilc;
    private BdUniqueId imm;
    private m imn;
    private p imo;
    private long imr;
    private boolean ims;
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
    private long iml = 5000;
    private Handler mHandler = new Handler();
    private boolean gNH = true;
    private boolean imp = false;
    private long imq = 17;
    private String imt = DefaultSharedPrefsWrapper.SP_FILE_DEFAULT;
    private ArrayList<String> imu = new ArrayList<>();
    private Map<String, Long> imv = new HashMap();
    private final Runnable hfx = new Runnable() { // from class: com.baidu.tieba.ala.view.j.1
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.ilc <= 0) {
                j.this.ilc = 0L;
            } else {
                if (j.this.ilc == 300 && j.this.imo != null && !j.this.imu.contains(j.this.imo.Vq())) {
                    j.this.imu.add(j.this.imo.Vq());
                    AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
                    alaBroadcastGiftToastData.localBroadcastType = 1;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
                }
                j.d(j.this);
            }
            if (j.this.ilc <= 1) {
                j.this.resetData();
            }
            for (Map.Entry entry : j.this.imv.entrySet()) {
                if (System.currentTimeMillis() / 1000 == ((Long) entry.getValue()).longValue()) {
                    j.this.imm = BdUniqueId.gen();
                    j.this.imn.a(j.this.mUserId, (String) entry.getKey(), 1, 1, j.this.imm);
                }
            }
            j.this.startCountDown();
        }
    };
    private View.OnClickListener mClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.j.2
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            j.this.IK("hour");
            LogManager.getCommonLogger().doClickHourRankEntryLog(j.this.beL, j.this.imt, j.this.otherParams);
        }
    };
    private n gWM = new n() { // from class: com.baidu.tieba.ala.view.j.3
        @Override // com.baidu.tieba.ala.g.n
        public void a(int i, String str, Object obj) {
            if (i == 0 && obj != null && (obj instanceof AlaGetHourRankListResponseMessage)) {
                AlaGetHourRankListResponseMessage alaGetHourRankListResponseMessage = (AlaGetHourRankListResponseMessage) obj;
                p cma = alaGetHourRankListResponseMessage.cma();
                if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.imm) {
                    j.this.d(cma);
                } else if (alaGetHourRankListResponseMessage.getOrginalMessage() != null && alaGetHourRankListResponseMessage.getOrginalMessage().getTag() == j.this.aEw) {
                    j.this.e(cma);
                }
                j.this.iml = cma.bUJ();
                j.this.imq = cma.bUK();
            }
            if (!j.this.imp && j.this.imw != null) {
                j.this.mHandler.removeCallbacks(j.this.imw);
                j.this.mHandler.postDelayed(j.this.imw, j.this.iml);
            }
        }
    };
    private Runnable imw = new Runnable() { // from class: com.baidu.tieba.ala.view.j.4
        @Override // java.lang.Runnable
        public void run() {
            if (j.this.imn != null) {
                j.this.imn.l(j.this.mUserId, "");
            }
        }
    };
    private BdUniqueId aEw = BdUniqueId.gen();

    static /* synthetic */ long d(j jVar) {
        long j = jVar.ilc;
        jVar.ilc = j - 1;
        return j;
    }

    public j(Context context, int i, long j, String str, boolean z, String str2, String str3, String str4, long j2) {
        this.otherParams = "";
        this.mContext = context;
        this.aLA = i;
        this.mUserId = j;
        this.mUserName = str;
        this.mIsHost = z;
        this.mPortrait = str2;
        this.beL = str4;
        this.gry = j2;
        this.otherParams = str3;
        initView();
        this.imn = new m(this.aEw, this.gWM);
        this.imn.l(this.mUserId, "");
    }

    public void startCountDown() {
        if (TbadkCoreApplication.sAlaLiveSwitchData == null || !TbadkCoreApplication.sAlaLiveSwitchData.isRankHourUnabled()) {
            this.mHandler.removeCallbacks(this.hfx);
            this.mHandler.postDelayed(this.hfx, 1000L);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(p pVar) {
        if (pVar != null && pVar.getList() != null && pVar.getList().size() > 0 && pVar.getList().get(0).gUE != null && pVar.getList().get(0).gUE.size() > 0) {
            AlaBroadcastGiftToastData alaBroadcastGiftToastData = new AlaBroadcastGiftToastData();
            alaBroadcastGiftToastData.localBroadcastType = 2;
            alaBroadcastGiftToastData.receiver = pVar.getList().get(0).getName_show();
            if (pVar.getList().get(0).eSY == 1) {
                alaBroadcastGiftToastData.live_id = pVar.getList().get(0).live_id;
            } else {
                alaBroadcastGiftToastData.live_id = -1L;
            }
            alaBroadcastGiftToastData.sender = pVar.getList().get(0).gUE.get(0).getName_show();
            alaBroadcastGiftToastData.feed_id = this.beL;
            alaBroadcastGiftToastData.otherParams = this.otherParams;
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913103, alaBroadcastGiftToastData));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void e(p pVar) {
        if (pVar != null) {
            this.imv.put(pVar.Vq(), Long.valueOf(pVar.bUM()));
            if (a(this.imo, pVar)) {
                this.imr = System.currentTimeMillis();
                eF(f(pVar), b(this.imo, pVar));
                this.imo = pVar;
            } else {
                this.imo = pVar;
                if (!this.mHasInited) {
                    this.mHasInited = true;
                    this.mTextView.setText(f(pVar));
                    this.mRootView.setVisibility(0);
                    this.hNa = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams = this.mTextView.getLayoutParams();
                    layoutParams.width = this.hNa;
                    this.mTextView.setLayoutParams(layoutParams);
                } else if (pVar.bUN() != null && !this.ims) {
                    this.mTextView.setText(f(pVar));
                    this.hNa = BdUtilHelper.getTextWidth(this.mPaint, f(pVar));
                    ViewGroup.LayoutParams layoutParams2 = this.mTextView.getLayoutParams();
                    layoutParams2.width = this.hNa;
                    this.mTextView.setLayoutParams(layoutParams2);
                }
            }
            this.ilc = pVar.bUL();
            startCountDown();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetData() {
        this.imr = System.currentTimeMillis();
        this.imo = null;
    }

    private boolean a(p pVar, p pVar2) {
        if (pVar2 == null || System.currentTimeMillis() - this.imr < this.imq * 1000 || pVar == null || pVar.bUN() == null) {
            return false;
        }
        if (pVar.bUN().aHY > 0 || pVar2.bUN().aHY <= 0) {
            return (pVar.bUN().aHY > 0 || pVar2.bUN().aHY > 0) ? true : true;
        }
        return false;
    }

    private String f(p pVar) {
        if (pVar.bUN().aHY < 1) {
            return this.mContext.getString(a.h.hour_rank_list_entry_no);
        }
        return String.format(this.mContext.getString(a.h.hour_rank_list_entry_text_def), StringHelper.formatForHourRankValue(pVar.bUN().aHY) + "");
    }

    private String b(p pVar, p pVar2) {
        if (pVar.bUN().aHY == pVar2.bUN().aHY) {
            this.imt = "change";
            if (pVar2.bUN().aHY <= 0) {
                return this.mContext.getString(a.h.hour_rank_list_entry_diff_no);
            }
            if (pVar2.bUN().aHY == 1) {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_down), StringHelper.formatForHourRankValue(pVar2.bUN().aHZ - pVar2.bUN().aIb) + "");
            } else if (pVar2.bUN().aHY <= 1) {
                return "";
            } else {
                return String.format(this.mContext.getString(a.h.hour_rank_list_entry_diff_up), StringHelper.formatForHourRankValue((pVar2.bUN().aIa - pVar2.bUN().aHZ) + 1) + "");
            }
        }
        this.imt = "up_down";
        int i = pVar2.bUN().aHY - pVar.bUN().aHY;
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
    public View PA() {
        return this.mRootView;
    }

    @Override // com.baidu.live.x.c
    public com.baidu.live.x.b PB() {
        return null;
    }

    @Override // com.baidu.live.x.c
    public com.baidu.live.x.b PC() {
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void IK(String str) {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new s(this.mContext, this.aLA, this.mUserId, this.mUserName, str, RequestResponseCode.REQUEST_RANK_LIST_TO_SHARE, this.mIsHost, this.mPortrait, this.otherParams, this.beL, this.gry, this.imo == null ? com.baidu.live.utils.j.fc(0) : this.imo.Vq())));
    }

    @Override // com.baidu.live.x.c
    public void setCanVisible(boolean z) {
        this.gNH = z;
    }

    @Override // com.baidu.live.x.c
    public void PD() {
        this.imp = false;
        if (this.imn != null) {
            this.imn.l(this.mUserId, "");
        }
    }

    @Override // com.baidu.live.x.c
    public void PE() {
        this.imp = true;
        this.mHandler.removeCallbacks(this.imw);
    }

    private void eF(final String str, String str2) {
        this.mTextView.setText(str2);
        int textWidth = BdUtilHelper.getTextWidth(this.mPaint, str2);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mTextView.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = textWidth;
            this.mTextView.setLayoutParams(layoutParams);
        }
        if (textWidth > this.hNa) {
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
            this.hNa = textWidth;
        }
    }

    @Override // com.baidu.live.x.c
    public void destory() {
        if (this.mHandler != null) {
            this.mHandler.removeCallbacksAndMessages(null);
        }
        if (this.imn != null) {
            this.imn.destory();
        }
    }
}
