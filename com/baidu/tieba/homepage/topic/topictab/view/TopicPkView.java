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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes9.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private TextView iiA;
    private ImageView iiB;
    private ImageView iiC;
    private int iiD;
    private int iiE;
    private int iiF;
    private int iiG;
    private int iiH;
    private int iiI;
    private int iiJ;
    private int iiK;
    private int iiL;
    private int iiM;
    private int iiN;
    private int iiO;
    private ValueAnimator iiP;
    private View iiQ;
    private a iiR;
    private ValueAnimator iiS;
    private double iiT;
    private double iiU;
    private float iiV;
    private float iiW;
    private RelativeLayout.LayoutParams iiX;
    private RelativeLayout.LayoutParams iiY;
    private b iiZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b iin;
    private TextView iio;
    private TextView iip;
    private FrameLayout iiq;
    private FrameLayout iir;
    private TbImageView iis;
    private TbImageView iit;
    private TbImageView iiu;
    private TbImageView iiv;
    private TextView iiw;
    private TextView iix;
    private ImageView iiy;
    private TextView iiz;
    private ValueAnimator.AnimatorUpdateListener ija;
    private int mBtnHeight;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes9.dex */
    public interface b {
        void wH(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iiO = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.ija = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iiB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iiT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iiD - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iiq.getX() + (TopicPkView.this.iiD / 2)))));
                    TopicPkView.this.iiB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iiU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iiB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iiq.getX() + (TopicPkView.this.iiD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iiq.getX() + (TopicPkView.this.iiD / 2)))));
                    TopicPkView.this.iiB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iiB.setVisibility(4);
                    TopicPkView.this.iiB.setX(TopicPkView.this.iiV);
                    TopicPkView.this.iiB.setY(TopicPkView.this.iiW);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iiO = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.ija = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iiB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iiT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iiD - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iiq.getX() + (TopicPkView.this.iiD / 2)))));
                    TopicPkView.this.iiB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iiU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iiB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iiq.getX() + (TopicPkView.this.iiD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iiq.getX() + (TopicPkView.this.iiD / 2)))));
                    TopicPkView.this.iiB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iiB.setVisibility(4);
                    TopicPkView.this.iiB.setX(TopicPkView.this.iiV);
                    TopicPkView.this.iiB.setY(TopicPkView.this.iiW);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iiO = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.ija = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iiB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iiT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iiD - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iiq.getX() + (TopicPkView.this.iiD / 2)))));
                    TopicPkView.this.iiB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iiU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iiB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iiq.getX() + (TopicPkView.this.iiD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iiq.getX() + (TopicPkView.this.iiD / 2)))));
                    TopicPkView.this.iiB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iiB.setVisibility(4);
                    TopicPkView.this.iiB.setX(TopicPkView.this.iiV);
                    TopicPkView.this.iiB.setY(TopicPkView.this.iiW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.iio = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.iip = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.iiq = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.iir = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.iis = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.iit = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.iiu = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.iiv = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.iiw = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.iix = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.iiy = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.iiz = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.iiA = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.iiB = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.iiC = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.iis.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.iit.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.iiu.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.iiv.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.iiq.setOnClickListener(this);
        this.iir.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.iiL = l.getDimens(context, R.dimen.tbds62);
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
        if (this.iin != null) {
            this.iiD = this.iiq.getWidth();
            this.mBtnHeight = this.iiq.getHeight();
            this.iiE = this.iis.getWidth();
            this.iiF = this.iiw.getWidth();
            this.iiG = this.iix.getWidth();
            this.iiJ = this.iiw.getHeight();
            this.iiH = this.iiz.getWidth();
            this.iiI = this.iiA.getWidth();
            this.mCursorWidth = this.iiy.getWidth();
            this.mCursorHeight = this.iiy.getHeight();
            this.iiK = ((this.mWidth - (this.iiD * 2)) - this.iiF) - this.iiG;
            this.iiN = this.iiB.getWidth();
            if (this.iin.ihM.ihO == 0 && this.iin.ihN.ihO == 0) {
                this.iiM = (int) ((0.5d * this.iiK) + this.iiF + this.iiD);
            } else {
                this.iiM = (int) (((((float) this.iin.ihM.ihO) / ((float) (this.iin.ihM.ihO + this.iin.ihN.ihO))) * this.iiK) + this.iiF + this.iiD);
            }
            float y = this.iiq.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.iiM + (this.mCursorWidth / 2) >= this.iix.getLeft()) {
                this.iiM = (this.iix.getLeft() - 10) - (this.mCursorWidth / 2);
                this.iiy.layout((this.iix.getLeft() - 10) - this.mCursorWidth, (int) y, this.iix.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.iiM - (this.mCursorWidth / 2) <= this.iiw.getRight()) {
                this.iiM = this.iiw.getRight() + 10 + (this.mCursorWidth / 2);
                this.iiy.layout(this.iiw.getRight() + 10, (int) y, this.iiw.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.iiy.layout(this.iiM - (this.mCursorWidth / 2), (int) y, this.iiM + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.iis.getX());
            if (this.iiH < this.iiE) {
                int i5 = (this.iiD - this.iiH) / 2;
                this.iiz.layout(i5, (int) this.iiz.getY(), this.iiH + i5, ((int) this.iiz.getY()) + this.iiJ);
            } else if (this.iiH <= x) {
                this.iiz.layout((int) this.iis.getX(), (int) this.iiz.getY(), ((int) this.iis.getX()) + this.iiH, ((int) this.iiz.getY()) + this.iiJ);
            } else {
                ViewGroup.LayoutParams layoutParams = this.iiz.getLayoutParams();
                layoutParams.width = x;
                this.iiz.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.iiI < this.iiE) {
                int x2 = ((int) this.iir.getX()) + ((this.iiD - this.iiI) / 2);
                this.iiA.layout(x2, (int) this.iiA.getY(), this.iiI + x2, ((int) this.iiA.getY()) + this.iiJ);
            } else if (this.iiI <= x) {
                this.iiA.layout((this.mWidth - ((int) this.iit.getX())) - this.iiI, (int) this.iiA.getY(), this.mWidth - ((int) this.iit.getX()), ((int) this.iiA.getY()) + this.iiJ);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.iiA.getLayoutParams();
                layoutParams2.width = x;
                this.iiA.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.iiD - this.iiN) / 2;
            this.iiB.layout(((int) this.iiq.getX()) + i6, ((int) this.iiq.getY()) + i6, ((int) this.iiq.getX()) + i6 + this.iiN, ((int) this.iiq.getY()) + i6 + this.iiN);
            this.iiC.layout(((int) this.iir.getX()) + i6, ((int) this.iir.getY()) + i6, ((int) this.iir.getX()) + i6 + this.iiN, i6 + ((int) this.iir.getY()) + this.iiN);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.iin.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.iiP == null || !this.iiP.isRunning()) {
            if (this.iiS == null || !this.iiS.isRunning()) {
                if (this.iiS == null) {
                    this.iiS = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.iiS.setDuration(800L);
                    this.iiS.setInterpolator(new AccelerateInterpolator());
                }
                if (this.iiP == null) {
                    this.iiP = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.iiP.setDuration(800L);
                    this.iiP.setInterpolator(new AccelerateInterpolator());
                    this.iiR = new a();
                    this.iiP.addListener(this.iiR);
                    this.iiP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.iiQ.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.iiQ.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cgV()) {
                    i = 1;
                } else {
                    i = cgW() ? 2 : 0;
                }
                if (view == this.iiq) {
                    ow(1 != i);
                    ox(false);
                    i2 = 1;
                } else if (view == this.iir) {
                    ox(2 != i);
                    ow(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").ag("obj_type", i2).s("topic_id", this.iin.topicId).ag("obj_source", this.iin.from));
                if (this.iiZ != null) {
                    this.iiZ.wH(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.iin.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.iin.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.iin.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iin != null) {
            N(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void N(Canvas canvas) {
        float y = this.iiq.getY() + ((this.mBtnHeight - this.iiL) / 2);
        this.mPaint.setShader(new LinearGradient(this.iiD / 2, y, this.iiM, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iiD / 2, y, this.iiM, y + this.iiL, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.iiM, y, this.mWidth - (this.iiD / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iiM, y, this.mWidth - (this.iiD / 2), y + this.iiL, this.mPaint);
    }

    public void setUserColor(int i) {
        this.iiO = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.ihM == null || bVar.ihN == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iin = bVar;
        this.iiw.setText(String.valueOf(bVar.ihM.ihO));
        this.iix.setText(String.valueOf(bVar.ihN.ihO));
        this.iiX = new RelativeLayout.LayoutParams(-2, -2);
        this.iiX.addRule(12);
        this.iiY = new RelativeLayout.LayoutParams(-2, -2);
        this.iiY.addRule(12);
        this.iiY.addRule(11);
        this.iiz.setLayoutParams(this.iiX);
        this.iiA.setLayoutParams(this.iiY);
        if (bVar.from == 3) {
            this.iiz.setText(StringUtils.isNull(bVar.ihM.ihP) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.ihM.ihP);
            this.iiA.setText(StringUtils.isNull(bVar.ihN.ihP) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.ihN.ihP);
            if (StringUtils.isNull(bVar.ihM.ihQ)) {
                this.iio.setVisibility(4);
            } else {
                this.iio.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ihM.ihQ));
            }
            if (StringUtils.isNull(bVar.ihN.ihQ)) {
                this.iip.setVisibility(4);
            } else {
                this.iip.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ihN.ihQ));
            }
        } else {
            this.iiz.setText(bVar.ihM.ihP);
            this.iiA.setText(bVar.ihN.ihP);
            this.iio.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ihM.ihQ));
            this.iip.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ihN.ihQ));
        }
        this.iis.startLoad(bVar.ihM.ihR, 10, false);
        this.iit.startLoad(bVar.ihN.ihR, 10, false);
        this.iiu.startLoad(bVar.ihM.ihU, 10, false);
        this.iiv.startLoad(bVar.ihN.ihU, 10, false);
        if (bVar.ihM.ihS) {
            this.iis.setVisibility(4);
            this.iiu.setVisibility(0);
        } else {
            this.iis.setVisibility(0);
            this.iiu.setVisibility(4);
        }
        if (bVar.ihN.ihS) {
            this.iit.setVisibility(4);
            this.iiv.setVisibility(0);
        } else {
            this.iit.setVisibility(0);
            this.iiv.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.iio, this.iiO);
        am.setViewTextColor(this.iip, this.iiO);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.iis.setIsNight(this.mSkinType == 1);
            this.iit.setIsNight(this.mSkinType == 1);
            this.iiu.setIsNight(this.mSkinType == 1);
            this.iiv.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.iiq, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.iir, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.iiB, R.drawable.pic_topic_addone);
            am.setImageResource(this.iiC, R.drawable.pic_topic_addone);
            am.setImageResource(this.iiy, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.iiw, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.iix, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.iiz, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.iiA, (int) R.color.topic_disagree_des_color);
        }
    }

    private void ow(boolean z) {
        if (z) {
            this.iio.setVisibility(0);
            this.iio.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iin.ihM.ihQ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iin.ihM.ihS = true;
            TextView textView = this.iiw;
            b.a aVar = this.iin.ihM;
            long j = aVar.ihO + 1;
            aVar.ihO = j;
            textView.setText(String.valueOf(j));
            this.iiB.setVisibility(0);
            this.iiQ = this.iiu;
            this.iiR.ijc = this.iiu;
            this.iiR.ijd = this.iis;
            this.iiB.setVisibility(0);
            this.iiP.start();
            this.iiT = this.iiB.getX();
            this.iiU = this.iiB.getY();
            this.iiV = this.iiB.getX();
            this.iiW = this.iiB.getY();
            this.iiS.removeAllUpdateListeners();
            this.iiS.addUpdateListener(this.ija);
            this.iiS.setFloatValues(0.0f, 2.0f);
            this.iiS.start();
            return;
        }
        if (aq.equals(this.iin.ihM.ihQ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iio.setVisibility(4);
        }
        if (this.iin.ihM.ihS) {
            this.iin.ihM.ihS = false;
            TextView textView2 = this.iiw;
            b.a aVar2 = this.iin.ihM;
            long j2 = aVar2.ihO - 1;
            aVar2.ihO = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iis.setVisibility(0);
        this.iiu.setVisibility(4);
    }

    private void ox(boolean z) {
        if (z) {
            this.iip.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iip.setVisibility(0);
            this.iin.ihN.ihQ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iiC.setVisibility(0);
            this.iin.ihN.ihS = true;
            TextView textView = this.iix;
            b.a aVar = this.iin.ihN;
            long j = aVar.ihO + 1;
            aVar.ihO = j;
            textView.setText(String.valueOf(j));
            this.iiT = this.iiC.getX() - (this.iiN / 2.0f);
            this.iiQ = this.iiv;
            this.iiR.ijc = this.iiv;
            this.iiR.ijd = this.iit;
            this.iiB.setVisibility(0);
            this.iiP.start();
            this.iiT = this.iiC.getX() - (this.iiN / 2);
            this.iiU = this.iiC.getY();
            this.iiV = this.iiC.getX();
            this.iiW = this.iiC.getY();
            this.iiS.removeAllUpdateListeners();
            this.iiS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.iiC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iiT) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.iiD) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iiD / 2)))));
                        TopicPkView.this.iiC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iiU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.iiC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iiD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.iiC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.iiC.setVisibility(4);
                        TopicPkView.this.iiC.setX(TopicPkView.this.iiV);
                        TopicPkView.this.iiC.setY(TopicPkView.this.iiW);
                    }
                }
            });
            this.iiS.setFloatValues(0.0f, 2.0f);
            this.iiS.start();
            return;
        }
        if (aq.equals(this.iin.ihN.ihQ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iip.setVisibility(4);
        }
        if (this.iin.ihN.ihS) {
            this.iin.ihN.ihS = false;
            TextView textView2 = this.iix;
            b.a aVar2 = this.iin.ihN;
            long j2 = aVar2.ihO - 1;
            aVar2.ihO = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iiC.setVisibility(4);
        this.iit.setVisibility(0);
        this.iiv.setVisibility(4);
    }

    private boolean cgV() {
        return (this.iin == null || this.iin.ihM == null || !this.iin.ihM.ihS) ? false : true;
    }

    private boolean cgW() {
        return (this.iin == null || this.iin.ihN == null || !this.iin.ihN.ihS) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.iiP != null) {
            this.iiP.cancel();
        }
        if (this.iiS != null) {
            this.iiS.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.iiZ = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Animator.AnimatorListener {
        private View ijc;
        private View ijd;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.ijc != null) {
                this.ijc.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.ijd != null) {
                this.ijd.setVisibility(8);
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
