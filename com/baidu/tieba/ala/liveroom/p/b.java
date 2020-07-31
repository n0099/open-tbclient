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
/* loaded from: classes4.dex */
public class b implements y {
    private boolean aKa;
    private AnimatorSet aKj;
    private TranslateAnimation aKk;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData gtl;
    private int gtn;
    private LinearLayout gto;
    private TextView gtp;
    private FrameLayout gtq;
    private TextView gtr;
    private TextView gts;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> gtk = new ArrayList<>();
    private boolean aJZ = false;
    private boolean gtm = true;
    private Handler mHandler = new Handler();
    protected boolean gbS = false;
    protected boolean gtt = true;
    private boolean isForeground = true;
    private View.OnClickListener mOnClickListener = new View.OnClickListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.3
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == a.g.confirm) {
                if (b.this.mDialog != null) {
                    b.this.mDialog.dismiss();
                    b.this.mDialog = null;
                }
            } else if (view.getId() == a.g.msg_background) {
                b.this.gtq.setVisibility(4);
                if (b.this.gtl != null) {
                    if (TextUtils.isEmpty(b.this.gtl.url)) {
                        b.this.d(b.this.gtl);
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913172, b.this.gtl.url));
                    }
                }
            }
        }
    };
    private final Runnable fTw = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.bL(b.this.gto)) {
                b.this.mHandler.removeCallbacks(b.this.fTw);
                b.this.zP();
                return;
            }
            b.this.startCountDown();
        }
    };

    public b(ab abVar) {
        if (abVar != null && abVar.pageContext != null) {
            this.mPageContext = abVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.aKa = abVar.aHx;
            this.gto = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.official_notice_container, (ViewGroup) null);
            this.gtq = (FrameLayout) this.gto.findViewById(a.g.msg_background);
            this.gtq.setOnClickListener(this.mOnClickListener);
            this.gtq.setVisibility(4);
            this.gtp = (TextView) this.gto.findViewById(a.g.msg_content);
            this.gtp.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.gtp.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtp.getLayoutParams();
                layoutParams.width = i;
                this.gtp.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.gtp.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            this.gtn = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            zO();
        }
    }

    private void zO() {
        this.aKj = new AnimatorSet();
        this.aKj.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.gto, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.gto, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.gto, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
        ofFloat3.setDuration(9000L);
        ofFloat3.setInterpolator(new Interpolator() { // from class: com.baidu.tieba.ala.liveroom.p.b.1
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
        this.aKj.playTogether(this.mAnimators);
        this.aKj.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.aJZ = true;
                b.this.gtq.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.zQ();
                b.this.zP();
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
    public void zP() {
        if (!this.aJZ && !ListUtils.isEmpty(this.gtk)) {
            if (bL(this.gto)) {
                startCountDown();
                return;
            }
            this.gtl = (OfficialNoticeData) ListUtils.getItem(this.gtk, 0);
            ListUtils.remove(this.gtk, 0);
            b(this.gtl);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zQ() {
        this.aJZ = false;
        this.gtp.clearAnimation();
        this.gto.clearAnimation();
        this.gtq.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.gtk.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.gtk.add(officialNoticeData);
            zP();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a = a(officialNoticeData, this.aKa);
            if (a != null && a.length() <= 0) {
                zQ();
                zP();
                return;
            }
            this.gtp.setText(a);
            if (a != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a.toString());
                float f = -(((textWidth - this.gtn) * 1.0f) / this.gtn);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gtp.getLayoutParams();
                if (textWidth - this.gtn < 0) {
                    layoutParams.width = -2;
                    this.gtp.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.gtp.setLayoutParams(layoutParams);
                    this.aKk = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.aKk.setStartOffset(4000L);
                    this.aKk.setDuration(1000L);
                    this.aKk.setFillAfter(true);
                    this.gtp.startAnimation(this.aKk);
                }
            }
            this.aKj.start();
            c(officialNoticeData);
            this.gtq.setTag(officialNoticeData);
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
                this.gts = (TextView) inflate.findViewById(a.g.content);
                this.gtr = (TextView) inflate.findViewById(a.g.confirm);
                this.gtr.setOnClickListener(this.mOnClickListener);
                SpannableString spannableString = new SpannableString(officialNoticeData.subCopyTagContent);
                if (!TextUtils.isEmpty(officialNoticeData.copyContent)) {
                    spannableString.setSpan(new ClickableSpan() { // from class: com.baidu.tieba.ala.liveroom.p.b.4
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
                    this.gts.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.gts.setText(spannableString);
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
        this.aJZ = false;
        if (this.gtp != null) {
            this.gtp.clearAnimation();
        }
        this.gtk.clear();
        this.mHandler.removeCallbacks(this.fTw);
    }

    @Override // com.baidu.live.gift.y
    public void bg(boolean z) {
        this.gbS = z;
    }

    @Override // com.baidu.live.gift.y
    public void bh(boolean z) {
        this.gtt = z;
    }

    @Override // com.baidu.live.gift.y
    public View zz() {
        return this.gto;
    }

    public boolean bL(View view) {
        return ShowUtil.windowCount > 0 || this.gbS || !this.gtt || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.fTw);
        this.mHandler.postDelayed(this.fTw, 1000L);
    }
}
