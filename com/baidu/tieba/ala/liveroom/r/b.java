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
import com.baidu.live.gift.af;
import com.baidu.live.gift.aj;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes4.dex */
public class b implements af {
    private boolean aVX;
    private AnimatorSet aWg;
    private TranslateAnimation aWh;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData hke;
    private int hkg;
    private LinearLayout hkh;
    private TextView hki;
    private FrameLayout hkj;
    private TextView hkk;
    private TextView hkl;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> hkd = new ArrayList<>();
    private boolean aVW = false;
    private boolean hkf = true;
    private Handler mHandler = new Handler();
    protected boolean gRs = false;
    protected boolean hkm = true;
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
                b.this.hkj.setVisibility(4);
                if (b.this.hke != null) {
                    if (TextUtils.isEmpty(b.this.hke.url)) {
                        b.this.d(b.this.hke);
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913172, b.this.hke.url));
                    }
                }
            }
        }
    };
    private final Runnable gFb = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.r.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.ca(b.this.hkh)) {
                b.this.mHandler.removeCallbacks(b.this.gFb);
                b.this.Hk();
                return;
            }
            b.this.startCountDown();
        }
    };

    public b(aj ajVar) {
        if (ajVar != null && ajVar.pageContext != null) {
            this.mPageContext = ajVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.aVX = ajVar.aSH;
            this.hkh = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.official_notice_container, (ViewGroup) null);
            this.hkj = (FrameLayout) this.hkh.findViewById(a.g.msg_background);
            this.hkj.setOnClickListener(this.mOnClickListener);
            this.hkj.setVisibility(4);
            this.hki = (TextView) this.hkh.findViewById(a.g.msg_content);
            this.hki.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.hki.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hki.getLayoutParams();
                layoutParams.width = i;
                this.hki.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.hki.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            this.hkg = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            Hj();
        }
    }

    private void Hj() {
        this.aWg = new AnimatorSet();
        this.aWg.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.hkh, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.hkh, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.hkh, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.aWg.playTogether(this.mAnimators);
        this.aWg.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.r.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.aVW = true;
                b.this.hkj.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.Hl();
                b.this.Hk();
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
    public void Hk() {
        if (!this.aVW && !ListUtils.isEmpty(this.hkd)) {
            if (ca(this.hkh)) {
                startCountDown();
                return;
            }
            this.hke = (OfficialNoticeData) ListUtils.getItem(this.hkd, 0);
            ListUtils.remove(this.hkd, 0);
            b(this.hke);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Hl() {
        this.aVW = false;
        this.hki.clearAnimation();
        this.hkh.clearAnimation();
        this.hkj.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.hkd.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.hkd.add(officialNoticeData);
            Hk();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a2 = a(officialNoticeData, this.aVX);
            if (a2 != null && a2.length() <= 0) {
                Hl();
                Hk();
                return;
            }
            this.hki.setText(a2);
            if (a2 != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a2.toString());
                float f = -(((textWidth - this.hkg) * 1.0f) / this.hkg);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.hki.getLayoutParams();
                if (textWidth - this.hkg < 0) {
                    layoutParams.width = -2;
                    this.hki.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.hki.setLayoutParams(layoutParams);
                    this.aWh = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aWh.setStartOffset(4000L);
                    this.aWh.setDuration(1000L);
                    this.aWh.setFillAfter(true);
                    this.hki.startAnimation(this.aWh);
                }
            }
            this.aWg.start();
            c(officialNoticeData);
            this.hkj.setTag(officialNoticeData);
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
                this.hkl = (TextView) inflate.findViewById(a.g.content);
                this.hkk = (TextView) inflate.findViewById(a.g.confirm);
                this.hkk.setOnClickListener(this.mOnClickListener);
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
                    this.hkl.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.hkl.setText(spannableString);
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

    @Override // com.baidu.live.gift.af
    public void onResume() {
        this.isForeground = true;
    }

    @Override // com.baidu.live.gift.af
    public void onPause() {
        this.isForeground = false;
    }

    @Override // com.baidu.live.gift.af
    public void onDestroy() {
        this.aVW = false;
        if (this.hki != null) {
            this.hki.clearAnimation();
        }
        this.hkd.clear();
        this.mHandler.removeCallbacks(this.gFb);
    }

    @Override // com.baidu.live.gift.af
    public void br(boolean z) {
        this.gRs = z;
    }

    @Override // com.baidu.live.gift.af
    public void bs(boolean z) {
        this.hkm = z;
    }

    @Override // com.baidu.live.gift.af
    public View GT() {
        return this.hkh;
    }

    public boolean ca(View view) {
        return ShowUtil.windowCount > 0 || this.gRs || !this.hkm || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gFb);
        this.mHandler.postDelayed(this.gFb, 1000L);
    }
}
