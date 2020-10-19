package com.baidu.tieba.ala.liveroom.r;

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
import com.baidu.live.gift.ac;
import com.baidu.live.gift.z;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b implements z {
    private boolean aUC;
    private AnimatorSet aUL;
    private TranslateAnimation aUM;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData gYo;
    private int gYq;
    private LinearLayout gYr;
    private TextView gYs;
    private FrameLayout gYt;
    private TextView gYu;
    private TextView gYv;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> gYn = new ArrayList<>();
    private boolean aUB = false;
    private boolean gYp = true;
    private Handler mHandler = new Handler();
    protected boolean gFD = false;
    protected boolean gYw = true;
    private boolean isForeground = true;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.r.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.g.confirm) {
                if (b.this.mDialog != null) {
                    b.this.mDialog.dismiss();
                    b.this.mDialog = null;
                }
            } else if (view.getId() == a.g.msg_background) {
                b.this.gYt.setVisibility(4);
                if (b.this.gYo != null) {
                    if (TextUtils.isEmpty(b.this.gYo.url)) {
                        b.this.d(b.this.gYo);
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913172, b.this.gYo.url));
                    }
                }
            }
        }
    };
    private final Runnable guX = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.r.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.bW(b.this.gYr)) {
                b.this.mHandler.removeCallbacks(b.this.guX);
                b.this.GO();
                return;
            }
            b.this.startCountDown();
        }
    };

    public b(ac acVar) {
        if (acVar != null && acVar.pageContext != null) {
            this.mPageContext = acVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.aUC = acVar.aRM;
            this.gYr = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.official_notice_container, (ViewGroup) null);
            this.gYt = (FrameLayout) this.gYr.findViewById(a.g.msg_background);
            this.gYt.setOnClickListener(this.mOnClickListener);
            this.gYt.setVisibility(4);
            this.gYs = (TextView) this.gYr.findViewById(a.g.msg_content);
            this.gYs.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.gYs.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gYs.getLayoutParams();
                layoutParams.width = i;
                this.gYs.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.gYs.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            this.gYq = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            GN();
        }
    }

    private void GN() {
        this.aUL = new AnimatorSet();
        this.aUL.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gYr, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gYr, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gYr, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat3.setDuration(9000L);
        ofFloat3.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.ala.liveroom.r.b.1
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
        this.aUL.playTogether(this.mAnimators);
        this.aUL.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.r.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.aUB = true;
                b.this.gYt.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.GP();
                b.this.GO();
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
    public void GO() {
        if (!this.aUB && !ListUtils.isEmpty(this.gYn)) {
            if (bW(this.gYr)) {
                startCountDown();
                return;
            }
            this.gYo = (OfficialNoticeData) ListUtils.getItem(this.gYn, 0);
            ListUtils.remove(this.gYn, 0);
            b(this.gYo);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GP() {
        this.aUB = false;
        this.gYs.clearAnimation();
        this.gYr.clearAnimation();
        this.gYt.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.gYn.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.gYn.add(officialNoticeData);
            GO();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a2 = a(officialNoticeData, this.aUC);
            if (a2 != null && a2.length() <= 0) {
                GP();
                GO();
                return;
            }
            this.gYs.setText(a2);
            if (a2 != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a2.toString());
                float f = -(((textWidth - this.gYq) * 1.0f) / this.gYq);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gYs.getLayoutParams();
                if (textWidth - this.gYq < 0) {
                    layoutParams.width = -2;
                    this.gYs.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.gYs.setLayoutParams(layoutParams);
                    this.aUM = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aUM.setStartOffset(4000L);
                    this.aUM.setDuration(1000L);
                    this.aUM.setFillAfter(true);
                    this.gYs.startAnimation(this.aUM);
                }
            }
            this.aUL.start();
            c(officialNoticeData);
            this.gYt.setTag(officialNoticeData);
        }
    }

    private SpannableStringBuilder a(OfficialNoticeData officialNoticeData, boolean z) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        if (officialNoticeData != null) {
            spannableStringBuilder.append((CharSequence) String.format(this.mContext.getString(a.i.official_notice_content), officialNoticeData.subCopyTagContent));
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
                View inflate = LayoutInflater.from(this.mPageContext.getPageActivity()).inflate(a.h.official_notice_dailog_view, (ViewGroup) null);
                this.mDialog.setContentViewSize(0);
                this.mDialog.setContentView(inflate);
                this.mDialog.create(this.mPageContext);
                this.gYv = (TextView) inflate.findViewById(a.g.content);
                this.gYu = (TextView) inflate.findViewById(a.g.confirm);
                this.gYu.setOnClickListener(this.mOnClickListener);
                SpannableString spannableString = new SpannableString(officialNoticeData.subCopyTagContent);
                if (!TextUtils.isEmpty(officialNoticeData.copyContent)) {
                    spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.ala.liveroom.r.b.4
                        @Override // android.text.style.ClickableSpan
                        public void onClick(View view) {
                            b.this.copyToClipboard(officialNoticeData.copyContent);
                            BdUtilHelper.showToast(b.this.mPageContext.getPageActivity(), "已复制到剪贴板");
                            if (view instanceof TextView) {
                                ((TextView) view).setHighlightColor(b.this.mPageContext.getResources().getColor(17170445));
                            }
                        }

                        @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
                        public void updateDrawState(TextPaint textPaint) {
                            textPaint.setColor(textPaint.linkColor);
                            textPaint.setUnderlineText(false);
                        }
                    }, officialNoticeData.startCopy, officialNoticeData.endCopy - 2, 17);
                    spannableString.setSpan(new ForegroundColorSpan(this.mPageContext.getResources().getColor(a.d.sdk_color_4B78B2)), officialNoticeData.startCopy, officialNoticeData.endCopy - 2, 33);
                    this.gYv.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.gYv.setText(spannableString);
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

    @Override // com.baidu.live.gift.z
    public void onResume() {
        this.isForeground = true;
    }

    @Override // com.baidu.live.gift.z
    public void onPause() {
        this.isForeground = false;
    }

    @Override // com.baidu.live.gift.z
    public void onDestroy() {
        this.aUB = false;
        if (this.gYs != null) {
            this.gYs.clearAnimation();
        }
        this.gYn.clear();
        this.mHandler.removeCallbacks(this.guX);
    }

    @Override // com.baidu.live.gift.z
    public void bp(boolean z) {
        this.gFD = z;
    }

    @Override // com.baidu.live.gift.z
    public void bq(boolean z) {
        this.gYw = z;
    }

    @Override // com.baidu.live.gift.z
    public View Gy() {
        return this.gYr;
    }

    public boolean bW(View view) {
        return ShowUtil.windowCount > 0 || this.gFD || !this.gYw || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.guX);
        this.mHandler.postDelayed(this.guX, 1000L);
    }
}
