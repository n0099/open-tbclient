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
    private AnimatorSet aRA;
    private TranslateAnimation aRB;
    private boolean aRr;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData gJN;
    private int gJP;
    private LinearLayout gJQ;
    private TextView gJR;
    private FrameLayout gJS;
    private TextView gJT;
    private TextView gJU;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> gJM = new ArrayList<>();
    private boolean aRq = false;
    private boolean gJO = true;
    private Handler mHandler = new Handler();
    protected boolean gri = false;
    protected boolean gJV = true;
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
                b.this.gJS.setVisibility(4);
                if (b.this.gJN != null) {
                    if (TextUtils.isEmpty(b.this.gJN.url)) {
                        b.this.d(b.this.gJN);
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913172, b.this.gJN.url));
                    }
                }
            }
        }
    };
    private final Runnable giK = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.r.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.bS(b.this.gJQ)) {
                b.this.mHandler.removeCallbacks(b.this.giK);
                b.this.FS();
                return;
            }
            b.this.startCountDown();
        }
    };

    public b(ac acVar) {
        if (acVar != null && acVar.pageContext != null) {
            this.mPageContext = acVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.aRr = acVar.aOB;
            this.gJQ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.official_notice_container, (ViewGroup) null);
            this.gJS = (FrameLayout) this.gJQ.findViewById(a.g.msg_background);
            this.gJS.setOnClickListener(this.mOnClickListener);
            this.gJS.setVisibility(4);
            this.gJR = (TextView) this.gJQ.findViewById(a.g.msg_content);
            this.gJR.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.gJR.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJR.getLayoutParams();
                layoutParams.width = i;
                this.gJR.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.gJR.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            this.gJP = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            FR();
        }
    }

    private void FR() {
        this.aRA = new AnimatorSet();
        this.aRA.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gJQ, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gJQ, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gJQ, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aRA.playTogether(this.mAnimators);
        this.aRA.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.r.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.aRq = true;
                b.this.gJS.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.FT();
                b.this.FS();
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
    public void FS() {
        if (!this.aRq && !ListUtils.isEmpty(this.gJM)) {
            if (bS(this.gJQ)) {
                startCountDown();
                return;
            }
            this.gJN = (OfficialNoticeData) ListUtils.getItem(this.gJM, 0);
            ListUtils.remove(this.gJM, 0);
            b(this.gJN);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void FT() {
        this.aRq = false;
        this.gJR.clearAnimation();
        this.gJQ.clearAnimation();
        this.gJS.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.gJM.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.gJM.add(officialNoticeData);
            FS();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a = a(officialNoticeData, this.aRr);
            if (a != null && a.length() <= 0) {
                FT();
                FS();
                return;
            }
            this.gJR.setText(a);
            if (a != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a.toString());
                float f = -(((textWidth - this.gJP) * 1.0f) / this.gJP);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gJR.getLayoutParams();
                if (textWidth - this.gJP < 0) {
                    layoutParams.width = -2;
                    this.gJR.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.gJR.setLayoutParams(layoutParams);
                    this.aRB = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aRB.setStartOffset(4000L);
                    this.aRB.setDuration(1000L);
                    this.aRB.setFillAfter(true);
                    this.gJR.startAnimation(this.aRB);
                }
            }
            this.aRA.start();
            c(officialNoticeData);
            this.gJS.setTag(officialNoticeData);
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
                this.gJU = (TextView) inflate.findViewById(a.g.content);
                this.gJT = (TextView) inflate.findViewById(a.g.confirm);
                this.gJT.setOnClickListener(this.mOnClickListener);
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
                    this.gJU.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.gJU.setText(spannableString);
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
        this.aRq = false;
        if (this.gJR != null) {
            this.gJR.clearAnimation();
        }
        this.gJM.clear();
        this.mHandler.removeCallbacks(this.giK);
    }

    @Override // com.baidu.live.gift.z
    public void bl(boolean z) {
        this.gri = z;
    }

    @Override // com.baidu.live.gift.z
    public void bm(boolean z) {
        this.gJV = z;
    }

    @Override // com.baidu.live.gift.z
    public View FC() {
        return this.gJQ;
    }

    public boolean bS(View view) {
        return ShowUtil.windowCount > 0 || this.gri || !this.gJV || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.giK);
        this.mHandler.postDelayed(this.giK, 1000L);
    }
}
