package com.baidu.tieba.homepage.topic.topictab.view;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes22.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private TbImageView jFA;
    private TextView jFB;
    private TextView jFC;
    private ImageView jFD;
    private TextView jFE;
    private TextView jFF;
    private ImageView jFG;
    private ImageView jFH;
    private int jFI;
    private int jFJ;
    private int jFK;
    private int jFL;
    private int jFM;
    private int jFN;
    private int jFO;
    private int jFP;
    private int jFQ;
    private int jFR;
    private int jFS;
    private int jFT;
    private ValueAnimator jFU;
    private View jFV;
    private a jFW;
    private ValueAnimator jFX;
    private double jFY;
    private double jFZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b jFs;
    private TextView jFt;
    private TextView jFu;
    private FrameLayout jFv;
    private FrameLayout jFw;
    private TbImageView jFx;
    private TbImageView jFy;
    private TbImageView jFz;
    private float jGa;
    private float jGb;
    private RelativeLayout.LayoutParams jGc;
    private RelativeLayout.LayoutParams jGd;
    private b jGe;
    private ValueAnimator.AnimatorUpdateListener jGf;
    private int mBtnHeight;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface b {
        void BF(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jFT = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jGf = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jFG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jFY) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jFI - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jFv.getX() + (TopicPkView.this.jFI / 2)))));
                    TopicPkView.this.jFG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jFZ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jFG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jFv.getX() + (TopicPkView.this.jFI / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jFv.getX() + (TopicPkView.this.jFI / 2)))));
                    TopicPkView.this.jFG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jFG.setVisibility(4);
                    TopicPkView.this.jFG.setX(TopicPkView.this.jGa);
                    TopicPkView.this.jFG.setY(TopicPkView.this.jGb);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.jFT = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jGf = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jFG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jFY) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jFI - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jFv.getX() + (TopicPkView.this.jFI / 2)))));
                    TopicPkView.this.jFG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jFZ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jFG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jFv.getX() + (TopicPkView.this.jFI / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jFv.getX() + (TopicPkView.this.jFI / 2)))));
                    TopicPkView.this.jFG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jFG.setVisibility(4);
                    TopicPkView.this.jFG.setX(TopicPkView.this.jGa);
                    TopicPkView.this.jFG.setY(TopicPkView.this.jGb);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.jFT = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jGf = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jFG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jFY) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jFI - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jFv.getX() + (TopicPkView.this.jFI / 2)))));
                    TopicPkView.this.jFG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jFZ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jFG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jFv.getX() + (TopicPkView.this.jFI / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jFv.getX() + (TopicPkView.this.jFI / 2)))));
                    TopicPkView.this.jFG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jFG.setVisibility(4);
                    TopicPkView.this.jFG.setX(TopicPkView.this.jGa);
                    TopicPkView.this.jFG.setY(TopicPkView.this.jGb);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.jFt = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.jFu = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.jFv = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.jFw = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.jFx = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.jFy = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.jFz = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.jFA = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.jFB = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.jFC = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.jFD = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.jFE = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.jFF = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.jFG = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.jFH = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.jFx.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.jFy.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.jFz.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.jFA.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.jFv.setOnClickListener(this);
        this.jFw.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.jFQ = l.getDimens(context, R.dimen.tbds62);
        this.mPaint = new Paint();
        this.mPaint.setAntiAlias(true);
        this.mPaint.setDither(true);
        this.mPaint.setFilterBitmap(true);
        onChangeSkinType();
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    @Override // android.widget.RelativeLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.jFs != null) {
            this.jFI = this.jFv.getWidth();
            this.mBtnHeight = this.jFv.getHeight();
            this.jFJ = this.jFx.getWidth();
            this.jFK = this.jFB.getWidth();
            this.jFL = this.jFC.getWidth();
            this.jFO = this.jFB.getHeight();
            this.jFM = this.jFE.getWidth();
            this.jFN = this.jFF.getWidth();
            this.mCursorWidth = this.jFD.getWidth();
            this.mCursorHeight = this.jFD.getHeight();
            this.jFP = ((this.mWidth - (this.jFI * 2)) - this.jFK) - this.jFL;
            this.jFS = this.jFG.getWidth();
            if (this.jFs.jES.jEU == 0 && this.jFs.jET.jEU == 0) {
                this.jFR = (int) ((0.5d * this.jFP) + this.jFK + this.jFI);
            } else {
                this.jFR = (int) (((((float) this.jFs.jES.jEU) / ((float) (this.jFs.jES.jEU + this.jFs.jET.jEU))) * this.jFP) + this.jFK + this.jFI);
            }
            float y = this.jFv.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.jFR + (this.mCursorWidth / 2) >= this.jFC.getLeft()) {
                this.jFR = (this.jFC.getLeft() - 10) - (this.mCursorWidth / 2);
                this.jFD.layout((this.jFC.getLeft() - 10) - this.mCursorWidth, (int) y, this.jFC.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.jFR - (this.mCursorWidth / 2) <= this.jFB.getRight()) {
                this.jFR = this.jFB.getRight() + 10 + (this.mCursorWidth / 2);
                this.jFD.layout(this.jFB.getRight() + 10, (int) y, this.jFB.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.jFD.layout(this.jFR - (this.mCursorWidth / 2), (int) y, this.jFR + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.jFx.getX());
            if (this.jFM < this.jFJ) {
                int i5 = (this.jFI - this.jFM) / 2;
                this.jFE.layout(i5, (int) this.jFE.getY(), this.jFM + i5, ((int) this.jFE.getY()) + this.jFO);
            } else if (this.jFM <= x) {
                this.jFE.layout((int) this.jFx.getX(), (int) this.jFE.getY(), ((int) this.jFx.getX()) + this.jFM, ((int) this.jFE.getY()) + this.jFO);
            } else {
                ViewGroup.LayoutParams layoutParams = this.jFE.getLayoutParams();
                layoutParams.width = x;
                this.jFE.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.jFN < this.jFJ) {
                int x2 = ((int) this.jFw.getX()) + ((this.jFI - this.jFN) / 2);
                this.jFF.layout(x2, (int) this.jFF.getY(), this.jFN + x2, ((int) this.jFF.getY()) + this.jFO);
            } else if (this.jFN <= x) {
                this.jFF.layout((this.mWidth - ((int) this.jFy.getX())) - this.jFN, (int) this.jFF.getY(), this.mWidth - ((int) this.jFy.getX()), ((int) this.jFF.getY()) + this.jFO);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.jFF.getLayoutParams();
                layoutParams2.width = x;
                this.jFF.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.jFI - this.jFS) / 2;
            this.jFG.layout(((int) this.jFv.getX()) + i6, ((int) this.jFv.getY()) + i6, ((int) this.jFv.getX()) + i6 + this.jFS, ((int) this.jFv.getY()) + i6 + this.jFS);
            this.jFH.layout(((int) this.jFw.getX()) + i6, ((int) this.jFw.getY()) + i6, ((int) this.jFw.getX()) + i6 + this.jFS, i6 + ((int) this.jFw.getY()) + this.jFS);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.jFs.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.jFU == null || !this.jFU.isRunning()) {
            if (this.jFX == null || !this.jFX.isRunning()) {
                if (this.jFX == null) {
                    this.jFX = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.jFX.setDuration(800L);
                    this.jFX.setInterpolator(new AccelerateInterpolator());
                }
                if (this.jFU == null) {
                    this.jFU = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.jFU.setDuration(800L);
                    this.jFU.setInterpolator(new AccelerateInterpolator());
                    this.jFW = new a();
                    this.jFU.addListener(this.jFW);
                    this.jFU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.jFV.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.jFV.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cJI()) {
                    i = 1;
                } else {
                    i = cJJ() ? 2 : 0;
                }
                if (view == this.jFv) {
                    qZ(1 != i);
                    ra(false);
                    i2 = 1;
                } else if (view == this.jFw) {
                    ra(2 != i);
                    qZ(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new aq("c13352").aj("obj_type", i2).w("topic_id", this.jFs.topicId).aj("obj_source", this.jFs.from));
                if (this.jGe != null) {
                    this.jGe.BF(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.jFs.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.jFs.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.jFs.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jFs != null) {
            W(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void W(Canvas canvas) {
        float y = this.jFv.getY() + ((this.mBtnHeight - this.jFQ) / 2);
        this.mPaint.setShader(new LinearGradient(this.jFI / 2, y, this.jFR, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jFI / 2, y, this.jFR, y + this.jFQ, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.jFR, y, this.mWidth - (this.jFI / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jFR, y, this.mWidth - (this.jFI / 2), y + this.jFQ, this.mPaint);
    }

    public void setUserColor(int i) {
        this.jFT = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.jES == null || bVar.jET == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jFs = bVar;
        this.jFB.setText(String.valueOf(bVar.jES.jEU));
        this.jFC.setText(String.valueOf(bVar.jET.jEU));
        this.jGc = new RelativeLayout.LayoutParams(-2, -2);
        this.jGc.addRule(12);
        this.jGd = new RelativeLayout.LayoutParams(-2, -2);
        this.jGd.addRule(12);
        this.jGd.addRule(11);
        this.jFE.setLayoutParams(this.jGc);
        this.jFF.setLayoutParams(this.jGd);
        if (bVar.from == 3) {
            this.jFE.setText(StringUtils.isNull(bVar.jES.jEV) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.jES.jEV);
            this.jFF.setText(StringUtils.isNull(bVar.jET.jEV) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.jET.jEV);
            if (StringUtils.isNull(bVar.jES.jEW)) {
                this.jFt.setVisibility(4);
            } else {
                this.jFt.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jES.jEW));
            }
            if (StringUtils.isNull(bVar.jET.jEW)) {
                this.jFu.setVisibility(4);
            } else {
                this.jFu.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jET.jEW));
            }
        } else {
            this.jFE.setText(bVar.jES.jEV);
            this.jFF.setText(bVar.jET.jEV);
            this.jFt.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jES.jEW));
            this.jFu.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jET.jEW));
        }
        this.jFx.startLoad(bVar.jES.jEX, 10, false);
        this.jFy.startLoad(bVar.jET.jEX, 10, false);
        this.jFz.startLoad(bVar.jES.jFa, 10, false);
        this.jFA.startLoad(bVar.jET.jFa, 10, false);
        if (bVar.jES.jEY) {
            this.jFx.setVisibility(4);
            this.jFz.setVisibility(0);
        } else {
            this.jFx.setVisibility(0);
            this.jFz.setVisibility(4);
        }
        if (bVar.jET.jEY) {
            this.jFy.setVisibility(4);
            this.jFA.setVisibility(0);
        } else {
            this.jFy.setVisibility(0);
            this.jFA.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jFt, this.jFT);
        ap.setViewTextColor(this.jFu, this.jFT);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.jFx.setIsNight(this.mSkinType == 1);
            this.jFy.setIsNight(this.mSkinType == 1);
            this.jFz.setIsNight(this.mSkinType == 1);
            this.jFA.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.jFv, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.jFw, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.jFG, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jFH, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jFD, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.jFB, R.color.cp_cont_a);
            ap.setViewTextColor(this.jFC, R.color.cp_cont_a);
            ap.setViewTextColor(this.jFE, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.jFF, R.color.topic_disagree_des_color);
        }
    }

    private void qZ(boolean z) {
        if (z) {
            this.jFt.setVisibility(0);
            this.jFt.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jFs.jES.jEW = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jFs.jES.jEY = true;
            TextView textView = this.jFB;
            b.a aVar = this.jFs.jES;
            long j = aVar.jEU + 1;
            aVar.jEU = j;
            textView.setText(String.valueOf(j));
            this.jFG.setVisibility(0);
            this.jFV = this.jFz;
            this.jFW.jGh = this.jFz;
            this.jFW.jGi = this.jFx;
            this.jFG.setVisibility(0);
            this.jFU.start();
            this.jFY = this.jFG.getX();
            this.jFZ = this.jFG.getY();
            this.jGa = this.jFG.getX();
            this.jGb = this.jFG.getY();
            this.jFX.removeAllUpdateListeners();
            this.jFX.addUpdateListener(this.jGf);
            this.jFX.setFloatValues(0.0f, 2.0f);
            this.jFX.start();
            return;
        }
        if (at.equals(this.jFs.jES.jEW, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jFt.setVisibility(4);
        }
        if (this.jFs.jES.jEY) {
            this.jFs.jES.jEY = false;
            TextView textView2 = this.jFB;
            b.a aVar2 = this.jFs.jES;
            long j2 = aVar2.jEU - 1;
            aVar2.jEU = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jFx.setVisibility(0);
        this.jFz.setVisibility(4);
    }

    private void ra(boolean z) {
        if (z) {
            this.jFu.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jFu.setVisibility(0);
            this.jFs.jET.jEW = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jFH.setVisibility(0);
            this.jFs.jET.jEY = true;
            TextView textView = this.jFC;
            b.a aVar = this.jFs.jET;
            long j = aVar.jEU + 1;
            aVar.jEU = j;
            textView.setText(String.valueOf(j));
            this.jFY = this.jFH.getX() - (this.jFS / 2.0f);
            this.jFV = this.jFA;
            this.jFW.jGh = this.jFA;
            this.jFW.jGi = this.jFy;
            this.jFG.setVisibility(0);
            this.jFU.start();
            this.jFY = this.jFH.getX() - (this.jFS / 2);
            this.jFZ = this.jFH.getY();
            this.jGa = this.jFH.getX();
            this.jGb = this.jFH.getY();
            this.jFX.removeAllUpdateListeners();
            this.jFX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.jFH.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jFY) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.jFI) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jFI / 2)))));
                        TopicPkView.this.jFH.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jFZ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.jFH.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jFI / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.jFH.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.jFH.setVisibility(4);
                        TopicPkView.this.jFH.setX(TopicPkView.this.jGa);
                        TopicPkView.this.jFH.setY(TopicPkView.this.jGb);
                    }
                }
            });
            this.jFX.setFloatValues(0.0f, 2.0f);
            this.jFX.start();
            return;
        }
        if (at.equals(this.jFs.jET.jEW, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jFu.setVisibility(4);
        }
        if (this.jFs.jET.jEY) {
            this.jFs.jET.jEY = false;
            TextView textView2 = this.jFC;
            b.a aVar2 = this.jFs.jET;
            long j2 = aVar2.jEU - 1;
            aVar2.jEU = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jFH.setVisibility(4);
        this.jFy.setVisibility(0);
        this.jFA.setVisibility(4);
    }

    private boolean cJI() {
        return (this.jFs == null || this.jFs.jES == null || !this.jFs.jES.jEY) ? false : true;
    }

    private boolean cJJ() {
        return (this.jFs == null || this.jFs.jET == null || !this.jFs.jET.jEY) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.jFU != null) {
            this.jFU.cancel();
        }
        if (this.jFX != null) {
            this.jFX.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.jGe = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a implements Animator.AnimatorListener {
        private View jGh;
        private View jGi;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.jGh != null) {
                this.jGh.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.jGi != null) {
                this.jGi.setVisibility(8);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator animator) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationRepeat(Animator animator) {
        }
    }
}
