package com.baidu.tieba.ala.liveroom.o;

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
/* loaded from: classes3.dex */
public class b implements y {
    private boolean aIE;
    private AnimatorSet aIN;
    private TranslateAnimation aIO;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData gok;
    private int gom;
    private LinearLayout gon;
    private TextView goo;
    private FrameLayout gop;
    private TextView goq;
    private TextView gor;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> goj = new ArrayList<>();
    private boolean aID = false;
    private boolean gol = true;
    private Handler mHandler = new Handler();
    protected boolean fWN = false;
    protected boolean gos = true;
    private boolean isForeground = true;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.g.confirm) {
                if (b.this.mDialog != null) {
                    b.this.mDialog.dismiss();
                    b.this.mDialog = null;
                }
            } else if (view.getId() == a.g.msg_background) {
                b.this.gop.setVisibility(4);
                if (b.this.gok != null) {
                    if (TextUtils.isEmpty(b.this.gok.url)) {
                        b.this.d(b.this.gok);
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913172, b.this.gok.url));
                    }
                }
            }
        }
    };
    private final Runnable fOd = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.o.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.bF(b.this.gon)) {
                b.this.mHandler.removeCallbacks(b.this.fOd);
                b.this.zn();
                return;
            }
            b.this.startCountDown();
        }
    };

    public b(ab abVar) {
        if (abVar != null && abVar.pageContext != null) {
            this.mPageContext = abVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.aIE = abVar.aGc;
            this.gon = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.official_notice_container, (ViewGroup) null);
            this.gop = (FrameLayout) this.gon.findViewById(a.g.msg_background);
            this.gop.setOnClickListener(this.mOnClickListener);
            this.gop.setVisibility(4);
            this.goo = (TextView) this.gon.findViewById(a.g.msg_content);
            this.goo.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.goo.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.goo.getLayoutParams();
                layoutParams.width = i;
                this.goo.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.goo.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            this.gom = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            zm();
        }
    }

    private void zm() {
        this.aIN = new AnimatorSet();
        this.aIN.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gon, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gon, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gon, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat3.setDuration(9000L);
        ofFloat3.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.ala.liveroom.o.b.1
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
        this.aIN.playTogether(this.mAnimators);
        this.aIN.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.o.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.aID = true;
                b.this.gop.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.zo();
                b.this.zn();
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
    public void zn() {
        if (!this.aID && !ListUtils.isEmpty(this.goj)) {
            if (bF(this.gon)) {
                startCountDown();
                return;
            }
            this.gok = (OfficialNoticeData) ListUtils.getItem(this.goj, 0);
            ListUtils.remove(this.goj, 0);
            b(this.gok);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zo() {
        this.aID = false;
        this.goo.clearAnimation();
        this.gon.clearAnimation();
        this.gop.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.goj.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.goj.add(officialNoticeData);
            zn();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a = a(officialNoticeData, this.aIE);
            if (a != null && a.length() <= 0) {
                zo();
                zn();
                return;
            }
            this.goo.setText(a);
            if (a != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a.toString());
                float f = -(((textWidth - this.gom) * 1.0f) / this.gom);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.goo.getLayoutParams();
                if (textWidth - this.gom < 0) {
                    layoutParams.width = -2;
                    this.goo.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.goo.setLayoutParams(layoutParams);
                    this.aIO = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aIO.setStartOffset(4000L);
                    this.aIO.setDuration(1000L);
                    this.aIO.setFillAfter(true);
                    this.goo.startAnimation(this.aIO);
                }
            }
            this.aIN.start();
            c(officialNoticeData);
            this.gop.setTag(officialNoticeData);
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
                this.gor = (TextView) inflate.findViewById(a.g.content);
                this.goq = (TextView) inflate.findViewById(a.g.confirm);
                this.goq.setOnClickListener(this.mOnClickListener);
                SpannableString spannableString = new SpannableString(officialNoticeData.subCopyTagContent);
                if (!TextUtils.isEmpty(officialNoticeData.copyContent)) {
                    spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.ala.liveroom.o.b.4
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
                    this.gor.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.gor.setText(spannableString);
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
        this.aID = false;
        if (this.goo != null) {
            this.goo.clearAnimation();
        }
        this.goj.clear();
        this.mHandler.removeCallbacks(this.fOd);
    }

    @Override // com.baidu.live.gift.y
    public void bd(boolean z) {
        this.fWN = z;
    }

    @Override // com.baidu.live.gift.y
    public void be(boolean z) {
        this.gos = z;
    }

    @Override // com.baidu.live.gift.y
    public View yX() {
        return this.gon;
    }

    public boolean bF(View view) {
        return ShowUtil.windowCount > 0 || this.fWN || !this.gos || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fOd);
        this.mHandler.postDelayed(this.fOd, 1000L);
    }
}
