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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes21.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int jMA;
    private int jMB;
    private ValueAnimator jMC;
    private View jMD;
    private a jME;
    private ValueAnimator jMF;
    private double jMG;
    private double jMH;
    private float jMI;
    private float jMJ;
    private RelativeLayout.LayoutParams jMK;
    private RelativeLayout.LayoutParams jML;
    private b jMM;
    private ValueAnimator.AnimatorUpdateListener jMN;
    private com.baidu.tieba.homepage.topic.topictab.b.b jMa;
    private TextView jMb;
    private TextView jMc;
    private FrameLayout jMd;
    private FrameLayout jMe;
    private TbImageView jMf;
    private TbImageView jMg;
    private TbImageView jMh;
    private TbImageView jMi;
    private TextView jMj;
    private TextView jMk;
    private ImageView jMl;
    private TextView jMm;
    private TextView jMn;
    private ImageView jMo;
    private ImageView jMp;
    private int jMq;
    private int jMr;
    private int jMs;
    private int jMt;
    private int jMu;
    private int jMv;
    private int jMw;
    private int jMx;
    private int jMy;
    private int jMz;
    private int mBtnHeight;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes21.dex */
    public interface b {
        void Cq(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jMB = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jMN = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jMo.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jMG) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jMq - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jMd.getX() + (TopicPkView.this.jMq / 2)))));
                    TopicPkView.this.jMo.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jMH) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jMo.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jMd.getX() + (TopicPkView.this.jMq / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jMd.getX() + (TopicPkView.this.jMq / 2)))));
                    TopicPkView.this.jMo.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jMo.setVisibility(4);
                    TopicPkView.this.jMo.setX(TopicPkView.this.jMI);
                    TopicPkView.this.jMo.setY(TopicPkView.this.jMJ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.jMB = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jMN = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jMo.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jMG) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jMq - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jMd.getX() + (TopicPkView.this.jMq / 2)))));
                    TopicPkView.this.jMo.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jMH) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jMo.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jMd.getX() + (TopicPkView.this.jMq / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jMd.getX() + (TopicPkView.this.jMq / 2)))));
                    TopicPkView.this.jMo.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jMo.setVisibility(4);
                    TopicPkView.this.jMo.setX(TopicPkView.this.jMI);
                    TopicPkView.this.jMo.setY(TopicPkView.this.jMJ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.jMB = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jMN = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jMo.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jMG) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jMq - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jMd.getX() + (TopicPkView.this.jMq / 2)))));
                    TopicPkView.this.jMo.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jMH) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jMo.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jMd.getX() + (TopicPkView.this.jMq / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jMd.getX() + (TopicPkView.this.jMq / 2)))));
                    TopicPkView.this.jMo.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jMo.setVisibility(4);
                    TopicPkView.this.jMo.setX(TopicPkView.this.jMI);
                    TopicPkView.this.jMo.setY(TopicPkView.this.jMJ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.jMb = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.jMc = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.jMd = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.jMe = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.jMf = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.jMg = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.jMh = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.jMi = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.jMj = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.jMk = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.jMl = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.jMm = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.jMn = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.jMo = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.jMp = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.jMf.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.jMg.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.jMh.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.jMi.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.jMd.setOnClickListener(this);
        this.jMe.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.jMy = l.getDimens(context, R.dimen.tbds62);
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
        if (this.jMa != null) {
            this.jMq = this.jMd.getWidth();
            this.mBtnHeight = this.jMd.getHeight();
            this.jMr = this.jMf.getWidth();
            this.jMs = this.jMj.getWidth();
            this.jMt = this.jMk.getWidth();
            this.jMw = this.jMj.getHeight();
            this.jMu = this.jMm.getWidth();
            this.jMv = this.jMn.getWidth();
            this.mCursorWidth = this.jMl.getWidth();
            this.mCursorHeight = this.jMl.getHeight();
            this.jMx = ((this.mWidth - (this.jMq * 2)) - this.jMs) - this.jMt;
            this.jMA = this.jMo.getWidth();
            if (this.jMa.jLB.jLD == 0 && this.jMa.jLC.jLD == 0) {
                this.jMz = (int) ((0.5d * this.jMx) + this.jMs + this.jMq);
            } else {
                this.jMz = (int) (((((float) this.jMa.jLB.jLD) / ((float) (this.jMa.jLB.jLD + this.jMa.jLC.jLD))) * this.jMx) + this.jMs + this.jMq);
            }
            float y = this.jMd.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.jMz + (this.mCursorWidth / 2) >= this.jMk.getLeft()) {
                this.jMz = (this.jMk.getLeft() - 10) - (this.mCursorWidth / 2);
                this.jMl.layout((this.jMk.getLeft() - 10) - this.mCursorWidth, (int) y, this.jMk.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.jMz - (this.mCursorWidth / 2) <= this.jMj.getRight()) {
                this.jMz = this.jMj.getRight() + 10 + (this.mCursorWidth / 2);
                this.jMl.layout(this.jMj.getRight() + 10, (int) y, this.jMj.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.jMl.layout(this.jMz - (this.mCursorWidth / 2), (int) y, this.jMz + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.jMf.getX());
            if (this.jMu < this.jMr) {
                int i5 = (this.jMq - this.jMu) / 2;
                this.jMm.layout(i5, (int) this.jMm.getY(), this.jMu + i5, ((int) this.jMm.getY()) + this.jMw);
            } else if (this.jMu <= x) {
                this.jMm.layout((int) this.jMf.getX(), (int) this.jMm.getY(), ((int) this.jMf.getX()) + this.jMu, ((int) this.jMm.getY()) + this.jMw);
            } else {
                ViewGroup.LayoutParams layoutParams = this.jMm.getLayoutParams();
                layoutParams.width = x;
                this.jMm.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.jMv < this.jMr) {
                int x2 = ((int) this.jMe.getX()) + ((this.jMq - this.jMv) / 2);
                this.jMn.layout(x2, (int) this.jMn.getY(), this.jMv + x2, ((int) this.jMn.getY()) + this.jMw);
            } else if (this.jMv <= x) {
                this.jMn.layout((this.mWidth - ((int) this.jMg.getX())) - this.jMv, (int) this.jMn.getY(), this.mWidth - ((int) this.jMg.getX()), ((int) this.jMn.getY()) + this.jMw);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.jMn.getLayoutParams();
                layoutParams2.width = x;
                this.jMn.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.jMq - this.jMA) / 2;
            this.jMo.layout(((int) this.jMd.getX()) + i6, ((int) this.jMd.getY()) + i6, ((int) this.jMd.getX()) + i6 + this.jMA, ((int) this.jMd.getY()) + i6 + this.jMA);
            this.jMp.layout(((int) this.jMe.getX()) + i6, ((int) this.jMe.getY()) + i6, ((int) this.jMe.getX()) + i6 + this.jMA, i6 + ((int) this.jMe.getY()) + this.jMA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.jMa.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.jMC == null || !this.jMC.isRunning()) {
            if (this.jMF == null || !this.jMF.isRunning()) {
                if (this.jMF == null) {
                    this.jMF = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.jMF.setDuration(800L);
                    this.jMF.setInterpolator(new AccelerateInterpolator());
                }
                if (this.jMC == null) {
                    this.jMC = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.jMC.setDuration(800L);
                    this.jMC.setInterpolator(new AccelerateInterpolator());
                    this.jME = new a();
                    this.jMC.addListener(this.jME);
                    this.jMC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.jMD.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.jMD.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cLQ()) {
                    i = 1;
                } else {
                    i = cLR() ? 2 : 0;
                }
                if (view == this.jMd) {
                    rl(1 != i);
                    rm(false);
                    i2 = 1;
                } else if (view == this.jMe) {
                    rm(2 != i);
                    rl(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new ar("c13352").ak("obj_type", i2).w("topic_id", this.jMa.topicId).ak("obj_source", this.jMa.from));
                if (this.jMM != null) {
                    this.jMM.Cq(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.jMa.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.jMa.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.jMa.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jMa != null) {
            Z(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void Z(Canvas canvas) {
        float y = this.jMd.getY() + ((this.mBtnHeight - this.jMy) / 2);
        this.mPaint.setShader(new LinearGradient(this.jMq / 2, y, this.jMz, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jMq / 2, y, this.jMz, y + this.jMy, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.jMz, y, this.mWidth - (this.jMq / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jMz, y, this.mWidth - (this.jMq / 2), y + this.jMy, this.mPaint);
    }

    public void setUserColor(int i) {
        this.jMB = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.jLB == null || bVar.jLC == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jMa = bVar;
        this.jMj.setText(String.valueOf(bVar.jLB.jLD));
        this.jMk.setText(String.valueOf(bVar.jLC.jLD));
        this.jMK = new RelativeLayout.LayoutParams(-2, -2);
        this.jMK.addRule(12);
        this.jML = new RelativeLayout.LayoutParams(-2, -2);
        this.jML.addRule(12);
        this.jML.addRule(11);
        this.jMm.setLayoutParams(this.jMK);
        this.jMn.setLayoutParams(this.jML);
        if (bVar.from == 3) {
            this.jMm.setText(StringUtils.isNull(bVar.jLB.jLE) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.jLB.jLE);
            this.jMn.setText(StringUtils.isNull(bVar.jLC.jLE) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.jLC.jLE);
            if (StringUtils.isNull(bVar.jLB.jLF)) {
                this.jMb.setVisibility(4);
            } else {
                this.jMb.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jLB.jLF));
            }
            if (StringUtils.isNull(bVar.jLC.jLF)) {
                this.jMc.setVisibility(4);
            } else {
                this.jMc.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jLC.jLF));
            }
        } else {
            this.jMm.setText(bVar.jLB.jLE);
            this.jMn.setText(bVar.jLC.jLE);
            this.jMb.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jLB.jLF));
            this.jMc.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jLC.jLF));
        }
        this.jMf.startLoad(bVar.jLB.jLG, 10, false);
        this.jMg.startLoad(bVar.jLC.jLG, 10, false);
        this.jMh.startLoad(bVar.jLB.jLJ, 10, false);
        this.jMi.startLoad(bVar.jLC.jLJ, 10, false);
        if (bVar.jLB.jLH) {
            this.jMf.setVisibility(4);
            this.jMh.setVisibility(0);
        } else {
            this.jMf.setVisibility(0);
            this.jMh.setVisibility(4);
        }
        if (bVar.jLC.jLH) {
            this.jMg.setVisibility(4);
            this.jMi.setVisibility(0);
        } else {
            this.jMg.setVisibility(0);
            this.jMi.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jMb, this.jMB);
        ap.setViewTextColor(this.jMc, this.jMB);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.jMf.setIsNight(this.mSkinType == 1);
            this.jMg.setIsNight(this.mSkinType == 1);
            this.jMh.setIsNight(this.mSkinType == 1);
            this.jMi.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.jMd, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.jMe, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.jMo, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jMp, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jMl, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.jMj, R.color.CAM_X0101);
            ap.setViewTextColor(this.jMk, R.color.CAM_X0101);
            ap.setViewTextColor(this.jMm, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.jMn, R.color.topic_disagree_des_color);
        }
    }

    private void rl(boolean z) {
        if (z) {
            this.jMb.setVisibility(0);
            this.jMb.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jMa.jLB.jLF = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jMa.jLB.jLH = true;
            TextView textView = this.jMj;
            b.a aVar = this.jMa.jLB;
            long j = aVar.jLD + 1;
            aVar.jLD = j;
            textView.setText(String.valueOf(j));
            this.jMo.setVisibility(0);
            this.jMD = this.jMh;
            this.jME.jMP = this.jMh;
            this.jME.jMQ = this.jMf;
            this.jMo.setVisibility(0);
            this.jMC.start();
            this.jMG = this.jMo.getX();
            this.jMH = this.jMo.getY();
            this.jMI = this.jMo.getX();
            this.jMJ = this.jMo.getY();
            this.jMF.removeAllUpdateListeners();
            this.jMF.addUpdateListener(this.jMN);
            this.jMF.setFloatValues(0.0f, 2.0f);
            this.jMF.start();
            return;
        }
        if (au.equals(this.jMa.jLB.jLF, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jMb.setVisibility(4);
        }
        if (this.jMa.jLB.jLH) {
            this.jMa.jLB.jLH = false;
            TextView textView2 = this.jMj;
            b.a aVar2 = this.jMa.jLB;
            long j2 = aVar2.jLD - 1;
            aVar2.jLD = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jMf.setVisibility(0);
        this.jMh.setVisibility(4);
    }

    private void rm(boolean z) {
        if (z) {
            this.jMc.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jMc.setVisibility(0);
            this.jMa.jLC.jLF = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jMp.setVisibility(0);
            this.jMa.jLC.jLH = true;
            TextView textView = this.jMk;
            b.a aVar = this.jMa.jLC;
            long j = aVar.jLD + 1;
            aVar.jLD = j;
            textView.setText(String.valueOf(j));
            this.jMG = this.jMp.getX() - (this.jMA / 2.0f);
            this.jMD = this.jMi;
            this.jME.jMP = this.jMi;
            this.jME.jMQ = this.jMg;
            this.jMo.setVisibility(0);
            this.jMC.start();
            this.jMG = this.jMp.getX() - (this.jMA / 2);
            this.jMH = this.jMp.getY();
            this.jMI = this.jMp.getX();
            this.jMJ = this.jMp.getY();
            this.jMF.removeAllUpdateListeners();
            this.jMF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.jMp.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jMG) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.jMq) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jMq / 2)))));
                        TopicPkView.this.jMp.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jMH) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.jMp.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jMq / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.jMp.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.jMp.setVisibility(4);
                        TopicPkView.this.jMp.setX(TopicPkView.this.jMI);
                        TopicPkView.this.jMp.setY(TopicPkView.this.jMJ);
                    }
                }
            });
            this.jMF.setFloatValues(0.0f, 2.0f);
            this.jMF.start();
            return;
        }
        if (au.equals(this.jMa.jLC.jLF, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jMc.setVisibility(4);
        }
        if (this.jMa.jLC.jLH) {
            this.jMa.jLC.jLH = false;
            TextView textView2 = this.jMk;
            b.a aVar2 = this.jMa.jLC;
            long j2 = aVar2.jLD - 1;
            aVar2.jLD = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jMp.setVisibility(4);
        this.jMg.setVisibility(0);
        this.jMi.setVisibility(4);
    }

    private boolean cLQ() {
        return (this.jMa == null || this.jMa.jLB == null || !this.jMa.jLB.jLH) ? false : true;
    }

    private boolean cLR() {
        return (this.jMa == null || this.jMa.jLC == null || !this.jMa.jLC.jLH) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.jMC != null) {
            this.jMC.cancel();
        }
        if (this.jMF != null) {
            this.jMF.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.jMM = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a implements Animator.AnimatorListener {
        private View jMP;
        private View jMQ;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.jMP != null) {
                this.jMP.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.jMQ != null) {
                this.jMQ.setVisibility(8);
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
