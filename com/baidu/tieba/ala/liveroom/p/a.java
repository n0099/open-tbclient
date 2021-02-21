package com.baidu.tieba.ala.liveroom.p;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Paint;
import android.os.Handler;
import android.text.ClipboardManager;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.base.BdBaseApplication;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.adp.framework.message.HttpMessage;
import com.baidu.live.adp.lib.safe.ShowUtil;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.an.c;
import com.baidu.live.gift.ag;
import com.baidu.live.gift.ak;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes11.dex */
public class a implements ag {
    private boolean aYQ;
    private AnimatorSet aZa;
    private TranslateAnimation aZb;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData hLp;
    private int hLr;
    private LinearLayout hLs;
    private TextView hLt;
    private FrameLayout hLu;
    private TextView hLv;
    private TextView hLw;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> hLo = new ArrayList<>();
    private boolean aYP = false;
    private boolean hLq = true;
    private Handler mHandler = new Handler();
    protected boolean hss = false;
    protected boolean hLx = true;
    private boolean isForeground = true;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.a.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.f.confirm) {
                if (a.this.mDialog != null) {
                    a.this.mDialog.dismiss();
                    a.this.mDialog = null;
                }
            } else if (view.getId() == a.f.msg_background) {
                a.this.hLu.setVisibility(4);
                if (a.this.hLp != null) {
                    if (TextUtils.isEmpty(a.this.hLp.url)) {
                        a.this.d(a.this.hLp);
                        return;
                    }
                    c cVar = new c();
                    cVar.url = a.this.hLp.url;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913232, cVar));
                }
            }
        }
    };
    private final Runnable hdO = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.a.5
        @Override // java.lang.Runnable
        public void run() {
            if (!a.this.ct(a.this.hLs)) {
                a.this.mHandler.removeCallbacks(a.this.hdO);
                a.this.FO();
                return;
            }
            a.this.startCountDown();
        }
    };

    public a(ak akVar) {
        if (akVar != null && akVar.pageContext != null) {
            this.mPageContext = akVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.aYQ = akVar.aVn;
            this.hLs = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.official_notice_container, (ViewGroup) null);
            this.hLu = (FrameLayout) this.hLs.findViewById(a.f.msg_background);
            this.hLu.setOnClickListener(this.mOnClickListener);
            this.hLu.setVisibility(4);
            this.hLt = (TextView) this.hLs.findViewById(a.f.msg_content);
            this.hLt.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.hLt.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hLt.getLayoutParams();
                layoutParams.width = i;
                this.hLt.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.hLt.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds8);
            this.hLr = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            KX();
        }
    }

    private void KX() {
        this.aZa = new AnimatorSet();
        this.aZa.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hLs, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hLs, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hLs, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat3.setDuration(9000L);
        ofFloat3.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.ala.liveroom.p.a.1
            @Override // android.animation.TimeInterpolator
            public float getInterpolation(float f) {
                if (f <= 0.11111111f) {
                    return 4.5f * f;
                }
                if (f >= 0.7777778f) {
                    return (4.5f * f) - 3.0f;
                }
                return 0.5f;
            }
        });
        this.mAnimators = new ArrayList<>();
        this.mAnimators.add(ofFloat);
        this.mAnimators.add(ofFloat2);
        this.mAnimators.add(ofFloat3);
        this.aZa.playTogether(this.mAnimators);
        this.aZa.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.p.a.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                a.this.aYP = true;
                a.this.hLu.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                a.this.FP();
                a.this.FO();
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationCancel(Animator animator) {
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationRepeat(Animator animator) {
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FO() {
        if (!this.aYP && !ListUtils.isEmpty(this.hLo)) {
            if (ct(this.hLs)) {
                startCountDown();
                return;
            }
            this.hLp = (OfficialNoticeData) ListUtils.getItem(this.hLo, 0);
            ListUtils.remove(this.hLo, 0);
            b(this.hLp);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FP() {
        this.aYP = false;
        this.hLt.clearAnimation();
        this.hLs.clearAnimation();
        this.hLu.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.hLo.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.hLo.add(officialNoticeData);
            FO();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a2 = a(officialNoticeData, this.aYQ);
            if (a2 != null && a2.length() <= 0) {
                FP();
                FO();
                return;
            }
            this.hLt.setText(a2);
            if (a2 != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a2.toString());
                float f = -(((textWidth - this.hLr) * 1.0f) / this.hLr);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hLt.getLayoutParams();
                if (textWidth - this.hLr < 0) {
                    layoutParams.width = -2;
                    this.hLt.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.hLt.setLayoutParams(layoutParams);
                    this.aZb = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aZb.setStartOffset(4000L);
                    this.aZb.setDuration(1000L);
                    this.aZb.setFillAfter(true);
                    this.hLt.startAnimation(this.aZb);
                }
            }
            this.aZa.start();
            c(officialNoticeData);
            this.hLu.setTag(officialNoticeData);
        }
    }

    private SpannableStringBuilder a(OfficialNoticeData officialNoticeData, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (officialNoticeData != null) {
            spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.h.official_notice_content), officialNoticeData.subCopyTagContent));
        }
        return spannableStringBuilder;
    }

    private void c(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            HttpMessage httpMessage = new HttpMessage(1021184);
            httpMessage.addParam("msg_id", officialNoticeData.id);
            httpMessage.addParam("end_time", officialNoticeData.end_time);
            MessageManager.getInstance().sendMessage(httpMessage);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(final OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null && !TextUtils.isEmpty(officialNoticeData.subCopyTagContent)) {
            if (this.mDialog == null || !this.mDialog.isShowing()) {
                if (this.mDialog == null) {
                    this.mDialog = new BdAlertDialog(this.mPageContext.getPageActivity());
                }
                View inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.g.official_notice_dailog_view, (ViewGroup) null);
                this.mDialog.setContentViewSize(0);
                this.mDialog.setContentView(inflate);
                this.mDialog.create(this.mPageContext);
                this.hLw = (TextView) inflate.findViewById(a.f.content);
                this.hLv = (TextView) inflate.findViewById(a.f.confirm);
                this.hLv.setOnClickListener(this.mOnClickListener);
                SpannableString spannableString = new SpannableString(officialNoticeData.subCopyTagContent);
                if (!TextUtils.isEmpty(officialNoticeData.copyContent)) {
                    spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.ala.liveroom.p.a.4
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            a.this.copyToClipboard(officialNoticeData.copyContent);
                            BdUtilHelper.showToast(a.this.mPageContext.getPageActivity(), "已复制到剪贴板");
                            if (view instanceof TextView) {
                                ((TextView) view).setHighlightColor(a.this.mPageContext.getResources().getColor(17170445));
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(textPaint.linkColor);
                            textPaint.setUnderlineText(false);
                        }
                    }, officialNoticeData.startCopy, officialNoticeData.endCopy - 2, 17);
                    spannableString.setSpan(new ForegroundColorSpan(this.mPageContext.getResources().getColor(a.c.sdk_color_4B78B2)), officialNoticeData.startCopy, officialNoticeData.endCopy - 2, 33);
                    this.hLw.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.hLw.setText(spannableString);
                this.mDialog.show();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void copyToClipboard(String str) {
        if (str == null) {
            str = "";
        }
        try {
            ((ClipboardManager) BdBaseApplication.getInst().getApp().getSystemService("clipboard")).setText(str);
        } catch (Throwable th) {
        }
    }

    @Override // com.baidu.live.gift.ag
    public void onResume() {
        this.isForeground = true;
    }

    @Override // com.baidu.live.gift.ag
    public void onPause() {
        this.isForeground = false;
    }

    @Override // com.baidu.live.gift.ag
    public void onDestroy() {
        this.aYP = false;
        if (this.hLt != null) {
            this.hLt.clearAnimation();
        }
        this.hLo.clear();
        this.mHandler.removeCallbacks(this.hdO);
    }

    @Override // com.baidu.live.gift.ag
    public void bC(boolean z) {
        this.hss = z;
    }

    @Override // com.baidu.live.gift.ag
    public void bD(boolean z) {
        this.hLx = z;
    }

    @Override // com.baidu.live.gift.ag
    public View Fz() {
        return this.hLs;
    }

    public boolean ct(View view) {
        return ShowUtil.windowCount > 0 || this.hss || !this.hLx || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.hdO);
        this.mHandler.postDelayed(this.hdO, 1000L);
    }
}
