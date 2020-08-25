package com.baidu.tieba.ala.liveroom.q;

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
import com.baidu.live.gift.ab;
import com.baidu.live.gift.y;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes7.dex */
public class b implements y {
    private boolean aPn;
    private AnimatorSet aPw;
    private TranslateAnimation aPx;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData gGk;
    private int gGm;
    private LinearLayout gGn;
    private TextView gGo;
    private FrameLayout gGp;
    private TextView gGq;
    private TextView gGr;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> gGj = new ArrayList<>();
    private boolean aPm = false;
    private boolean gGl = true;
    private Handler mHandler = new Handler();
    protected boolean gnV = false;
    protected boolean gGs = true;
    private boolean isForeground = true;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.g.confirm) {
                if (b.this.mDialog != null) {
                    b.this.mDialog.dismiss();
                    b.this.mDialog = null;
                }
            } else if (view.getId() == a.g.msg_background) {
                b.this.gGp.setVisibility(4);
                if (b.this.gGk != null) {
                    if (TextUtils.isEmpty(b.this.gGk.url)) {
                        b.this.d(b.this.gGk);
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913172, b.this.gGk.url));
                    }
                }
            }
        }
    };
    private final Runnable gfv = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.q.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.bN(b.this.gGn)) {
                b.this.mHandler.removeCallbacks(b.this.gfv);
                b.this.Fs();
                return;
            }
            b.this.startCountDown();
        }
    };

    public b(ab abVar) {
        if (abVar != null && abVar.pageContext != null) {
            this.mPageContext = abVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.aPn = abVar.aMH;
            this.gGn = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.official_notice_container, (ViewGroup) null);
            this.gGp = (FrameLayout) this.gGn.findViewById(a.g.msg_background);
            this.gGp.setOnClickListener(this.mOnClickListener);
            this.gGp.setVisibility(4);
            this.gGo = (TextView) this.gGn.findViewById(a.g.msg_content);
            this.gGo.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.gGo.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGo.getLayoutParams();
                layoutParams.width = i;
                this.gGo.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.gGo.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            this.gGm = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            Fr();
        }
    }

    private void Fr() {
        this.aPw = new AnimatorSet();
        this.aPw.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gGn, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gGn, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gGn, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat3.setDuration(9000L);
        ofFloat3.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.ala.liveroom.q.b.1
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
        this.aPw.playTogether(this.mAnimators);
        this.aPw.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.q.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.aPm = true;
                b.this.gGp.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.Ft();
                b.this.Fs();
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
    public void Fs() {
        if (!this.aPm && !ListUtils.isEmpty(this.gGj)) {
            if (bN(this.gGn)) {
                startCountDown();
                return;
            }
            this.gGk = (OfficialNoticeData) ListUtils.getItem(this.gGj, 0);
            ListUtils.remove(this.gGj, 0);
            b(this.gGk);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Ft() {
        this.aPm = false;
        this.gGo.clearAnimation();
        this.gGn.clearAnimation();
        this.gGp.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.gGj.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.gGj.add(officialNoticeData);
            Fs();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a = a(officialNoticeData, this.aPn);
            if (a != null && a.length() <= 0) {
                Ft();
                Fs();
                return;
            }
            this.gGo.setText(a);
            if (a != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a.toString());
                float f = -(((textWidth - this.gGm) * 1.0f) / this.gGm);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gGo.getLayoutParams();
                if (textWidth - this.gGm < 0) {
                    layoutParams.width = -2;
                    this.gGo.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.gGo.setLayoutParams(layoutParams);
                    this.aPx = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aPx.setStartOffset(4000L);
                    this.aPx.setDuration(1000L);
                    this.aPx.setFillAfter(true);
                    this.gGo.startAnimation(this.aPx);
                }
            }
            this.aPw.start();
            c(officialNoticeData);
            this.gGp.setTag(officialNoticeData);
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
                this.gGr = (TextView) inflate.findViewById(a.g.content);
                this.gGq = (TextView) inflate.findViewById(a.g.confirm);
                this.gGq.setOnClickListener(this.mOnClickListener);
                SpannableString spannableString = new SpannableString(officialNoticeData.subCopyTagContent);
                if (!TextUtils.isEmpty(officialNoticeData.copyContent)) {
                    spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.ala.liveroom.q.b.4
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
                    this.gGr.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.gGr.setText(spannableString);
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

    @Override // com.baidu.live.gift.y
    public void onResume() {
        this.isForeground = true;
    }

    @Override // com.baidu.live.gift.y
    public void onPause() {
        this.isForeground = false;
    }

    @Override // com.baidu.live.gift.y
    public void onDestroy() {
        this.aPm = false;
        if (this.gGo != null) {
            this.gGo.clearAnimation();
        }
        this.gGj.clear();
        this.mHandler.removeCallbacks(this.gfv);
    }

    @Override // com.baidu.live.gift.y
    public void bk(boolean z) {
        this.gnV = z;
    }

    @Override // com.baidu.live.gift.y
    public void bl(boolean z) {
        this.gGs = z;
    }

    @Override // com.baidu.live.gift.y
    public View Fc() {
        return this.gGn;
    }

    public boolean bN(View view) {
        return ShowUtil.windowCount > 0 || this.gnV || !this.gGs || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.gfv);
        this.mHandler.postDelayed(this.gfv, 1000L);
    }
}
