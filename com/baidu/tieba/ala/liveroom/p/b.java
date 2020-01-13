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
import com.baidu.live.gift.u;
import com.baidu.live.gift.v;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.data.OfficialNoticeData;
import com.baidu.live.tbadk.core.dialog.BdAlertDialog;
import com.baidu.live.tbadk.core.util.ListUtils;
import com.baidu.live.tbadk.core.util.UtilHelper;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes2.dex */
public class b implements u {
    private boolean afW;
    private int agb;
    private AnimatorSet agh;
    private TranslateAnimation agi;
    private int ds20;
    private int ds28;
    private int ds8;
    private OfficialNoticeData feJ;
    private LinearLayout feK;
    private TextView feL;
    private FrameLayout feM;
    private TextView feN;
    private TextView feO;
    private ArrayList<Animator> mAnimators;
    private Context mContext;
    private BdAlertDialog mDialog;
    private TbPageContext mPageContext;
    private Paint mPaint;
    private int mScreenWidth;
    private ArrayList<OfficialNoticeData> feI = new ArrayList<>();
    private boolean afV = false;
    private boolean afX = true;
    private Handler mHandler = new Handler();
    protected boolean eOq = false;
    protected boolean feP = true;
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
                b.this.feM.setVisibility(4);
                if (b.this.feJ != null) {
                    if (TextUtils.isEmpty(b.this.feJ.url)) {
                        b.this.d(b.this.feJ);
                    } else {
                        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2913156, b.this.feJ.url));
                    }
                }
            }
        }
    };
    private final Runnable eFV = new Runnable() { // from class: com.baidu.tieba.ala.liveroom.p.b.5
        @Override // java.lang.Runnable
        public void run() {
            if (!b.this.bz(b.this.feK)) {
                b.this.mHandler.removeCallbacks(b.this.eFV);
                b.this.rR();
                return;
            }
            b.this.startCountDown();
        }
    };

    public b(v vVar) {
        if (vVar != null && vVar.pageContext != null) {
            this.mPageContext = vVar.pageContext;
            this.mContext = this.mPageContext.getPageActivity();
            this.afW = vVar.adF;
            this.feK = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.official_notice_container, (ViewGroup) null);
            this.feM = (FrameLayout) this.feK.findViewById(a.g.msg_background);
            this.feM.setOnClickListener(this.mOnClickListener);
            this.feM.setVisibility(4);
            this.feL = (TextView) this.feK.findViewById(a.g.msg_content);
            this.feL.setMaxLines(1);
            int i = BdUtilHelper.getScreenSize((Activity) this.mContext).heightPixels;
            if (this.feL.getLayoutParams() != null) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.feL.getLayoutParams();
                layoutParams.width = i;
                this.feL.setLayoutParams(layoutParams);
            } else {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(i, -2);
                layoutParams2.gravity = 17;
                this.feL.setLayoutParams(layoutParams2);
            }
            this.mScreenWidth = BdUtilHelper.getScreenSize((Activity) this.mContext).widthPixels;
            this.ds28 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds28);
            this.ds20 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds20);
            this.ds8 = this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds8);
            this.agb = (this.mScreenWidth - (this.ds28 * 2)) - (this.ds20 * 2);
            this.mPaint = new Paint();
            this.mPaint.setTextSize(this.ds28);
            rQ();
        }
    }

    private void rQ() {
        this.agh = new AnimatorSet();
        this.agh.setDuration(9000L);
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(this.feK, "alpha", 0.9f, 1.0f);
        ofFloat.setDuration(1000L);
        ofFloat.setStartDelay(0L);
        ofFloat.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(this.feK, "alpha", 1.0f, 0.9f);
        ofFloat2.setDuration(1000L);
        ofFloat2.setStartDelay(1000L);
        ofFloat2.setInterpolator(new LinearInterpolator());
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(this.feK, "TranslationX", this.mScreenWidth, -this.mScreenWidth);
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
        this.agh.playTogether(this.mAnimators);
        this.agh.addListener(new Animator.AnimatorListener() { // from class: com.baidu.tieba.ala.liveroom.p.b.2
            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationStart(Animator animator) {
                b.this.afV = true;
                b.this.feM.setVisibility(0);
            }

            @Override // android.animation.Animator.AnimatorListener
            public void onAnimationEnd(Animator animator) {
                b.this.rS();
                b.this.rR();
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
    public void rR() {
        if (!this.afV && !ListUtils.isEmpty(this.feI)) {
            if (bz(this.feK)) {
                startCountDown();
                return;
            }
            this.feJ = (OfficialNoticeData) ListUtils.getItem(this.feI, 0);
            ListUtils.remove(this.feI, 0);
            b(this.feJ);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rS() {
        this.afV = false;
        this.feL.clearAnimation();
        this.feK.clearAnimation();
        this.feM.setVisibility(4);
    }

    public void a(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            Iterator<OfficialNoticeData> it = this.feI.iterator();
            while (it.hasNext()) {
                if (it.next().id == officialNoticeData.id) {
                    return;
                }
            }
            this.feI.add(officialNoticeData);
            rR();
        }
    }

    private void b(OfficialNoticeData officialNoticeData) {
        if (officialNoticeData != null) {
            SpannableStringBuilder a = a(officialNoticeData, this.afW);
            if (a != null && a.length() <= 0) {
                rS();
                rR();
                return;
            }
            this.feL.setText(a);
            if (a != null) {
                int textWidth = this.ds8 + BdUtilHelper.getTextWidth(this.mPaint, a.toString());
                float f = -(((textWidth - this.agb) * 1.0f) / this.agb);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.feL.getLayoutParams();
                if (textWidth - this.agb < 0) {
                    layoutParams.width = -2;
                    this.feL.setLayoutParams(layoutParams);
                } else {
                    layoutParams.width = textWidth;
                    this.feL.setLayoutParams(layoutParams);
                    this.agi = new TranslateAnimation(2, 0.0f, 2, f, 1, 0.0f, 1, 0.0f);
                    this.agi.setStartOffset(4000L);
                    this.agi.setDuration(1000L);
                    this.agi.setFillAfter(true);
                    this.feL.startAnimation(this.agi);
                }
            }
            this.agh.start();
            c(officialNoticeData);
            this.feM.setTag(officialNoticeData);
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
            HttpMessage httpMessage = new HttpMessage(1021176);
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
                this.feO = (TextView) inflate.findViewById(a.g.content);
                this.feN = (TextView) inflate.findViewById(a.g.confirm);
                this.feN.setOnClickListener(this.mOnClickListener);
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
                    this.feO.setMovementMethod(LinkMovementMethod.getInstance());
                }
                this.feO.setText(spannableString);
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

    @Override // com.baidu.live.gift.u
    public void onResume() {
        this.isForeground = true;
    }

    @Override // com.baidu.live.gift.u
    public void onPause() {
        this.isForeground = false;
    }

    @Override // com.baidu.live.gift.u
    public void onDestroy() {
        this.afV = false;
        if (this.feL != null) {
            this.feL.clearAnimation();
        }
        this.feI.clear();
        this.mHandler.removeCallbacks(this.eFV);
    }

    @Override // com.baidu.live.gift.u
    public void ax(boolean z) {
        this.eOq = z;
    }

    @Override // com.baidu.live.gift.u
    public void ay(boolean z) {
        this.feP = z;
    }

    @Override // com.baidu.live.gift.u
    public View rD() {
        return this.feK;
    }

    public boolean bz(View view) {
        return ShowUtil.windowCount > 0 || this.eOq || !this.feP || !this.isForeground || UtilHelper.getRealScreenOrientation(this.mContext) == 2;
    }

    public void startCountDown() {
        this.mHandler.removeCallbacks(this.eFV);
        this.mHandler.postDelayed(this.eFV, 1000L);
    }
}
