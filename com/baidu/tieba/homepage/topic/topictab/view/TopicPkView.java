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
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes4.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int aLz;
    private int bIg;
    private int bIh;
    private int bNA;
    private TextView fQA;
    private TextView fQB;
    private ImageView fQC;
    private ImageView fQD;
    private int fQE;
    private int fQF;
    private int fQG;
    private int fQH;
    private int fQI;
    private int fQJ;
    private int fQK;
    private int fQL;
    private int fQM;
    private int fQN;
    private int fQO;
    private ValueAnimator fQP;
    private View fQQ;
    private a fQR;
    private ValueAnimator fQS;
    private double fQT;
    private double fQU;
    private float fQV;
    private float fQW;
    private RelativeLayout.LayoutParams fQX;
    private RelativeLayout.LayoutParams fQY;
    private b fQZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b fQo;
    private TextView fQp;
    private TextView fQq;
    private FrameLayout fQr;
    private FrameLayout fQs;
    private TbImageView fQt;
    private TbImageView fQu;
    private TbImageView fQv;
    private TbImageView fQw;
    private TextView fQx;
    private TextView fQy;
    private ImageView fQz;
    private ValueAnimator.AnimatorUpdateListener fRa;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void sH(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fQO = d.C0277d.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.fRa = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.fQC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.fQE - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQr.getX() + (TopicPkView.this.fQE / 2)))));
                    TopicPkView.this.fQC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.fQC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.fQr.getX() + (TopicPkView.this.fQE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQr.getX() + (TopicPkView.this.fQE / 2)))));
                    TopicPkView.this.fQC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.fQC.setVisibility(4);
                    TopicPkView.this.fQC.setX(TopicPkView.this.fQV);
                    TopicPkView.this.fQC.setY(TopicPkView.this.fQW);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fQO = d.C0277d.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.fRa = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.fQC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.fQE - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQr.getX() + (TopicPkView.this.fQE / 2)))));
                    TopicPkView.this.fQC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.fQC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.fQr.getX() + (TopicPkView.this.fQE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQr.getX() + (TopicPkView.this.fQE / 2)))));
                    TopicPkView.this.fQC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.fQC.setVisibility(4);
                    TopicPkView.this.fQC.setX(TopicPkView.this.fQV);
                    TopicPkView.this.fQC.setY(TopicPkView.this.fQW);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fQO = d.C0277d.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.fRa = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.fQC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.fQE - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQr.getX() + (TopicPkView.this.fQE / 2)))));
                    TopicPkView.this.fQC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.fQC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.fQr.getX() + (TopicPkView.this.fQE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQr.getX() + (TopicPkView.this.fQE / 2)))));
                    TopicPkView.this.fQC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.fQC.setVisibility(4);
                    TopicPkView.this.fQC.setX(TopicPkView.this.fQV);
                    TopicPkView.this.fQC.setY(TopicPkView.this.fQW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.topic_pk_view_layout, (ViewGroup) this, true);
        this.fQp = (TextView) findViewById(d.g.topic_pk_view_agree_user);
        this.fQq = (TextView) findViewById(d.g.topic_pk_view_disagree_user);
        this.fQr = (FrameLayout) findViewById(d.g.topic_pk_view_agree_btn);
        this.fQs = (FrameLayout) findViewById(d.g.topic_pk_view_disagree_btn);
        this.fQt = (TbImageView) findViewById(d.g.topic_pk_view_agree_img);
        this.fQu = (TbImageView) findViewById(d.g.topic_pk_view_disagree_img);
        this.fQv = (TbImageView) findViewById(d.g.topic_pk_view_agree_select_img);
        this.fQw = (TbImageView) findViewById(d.g.topic_pk_view_disagree_select_img);
        this.fQx = (TextView) findViewById(d.g.topic_pk_view_agree_num);
        this.fQy = (TextView) findViewById(d.g.topic_pk_view_disagree_num);
        this.fQz = (ImageView) findViewById(d.g.topic_pk_view_cursor);
        this.fQA = (TextView) findViewById(d.g.topic_pk_view_agree_des);
        this.fQB = (TextView) findViewById(d.g.topic_pk_view_disagree_des);
        this.fQC = (ImageView) findViewById(d.g.topic_pk_view_agree_add);
        this.fQD = (ImageView) findViewById(d.g.topic_pk_view_disagree_add);
        this.fQt.setDefaultBgResource(d.f.btn_topic_agree_white_n);
        this.fQu.setDefaultBgResource(d.f.btn_topic_disagree_white_n);
        this.fQv.setDefaultBgResource(d.f.btn_topic_agree_white_h);
        this.fQw.setDefaultBgResource(d.f.btn_topic_disagree_white_h);
        this.fQr.setOnClickListener(this);
        this.fQs.setOnClickListener(this);
        this.mHeight = l.h(context, d.e.tbds340);
        this.fQL = l.h(context, d.e.tbds78);
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
        if (this.fQo != null) {
            this.fQE = this.fQr.getWidth();
            this.aLz = this.fQr.getHeight();
            this.bNA = this.fQt.getWidth();
            this.fQF = this.fQx.getWidth();
            this.fQG = this.fQy.getWidth();
            this.fQJ = this.fQx.getHeight();
            this.fQH = this.fQA.getWidth();
            this.fQI = this.fQB.getWidth();
            this.bIh = this.fQz.getWidth();
            this.bIg = this.fQz.getHeight();
            this.fQK = ((this.mWidth - (this.fQE * 2)) - this.fQF) - this.fQG;
            this.fQN = this.fQC.getWidth();
            if (this.fQo.fPR.fPT == 0 && this.fQo.fPS.fPT == 0) {
                this.fQM = (int) ((0.5d * this.fQK) + this.fQF + this.fQE);
            } else {
                this.fQM = (int) (((((float) this.fQo.fPR.fPT) / ((float) (this.fQo.fPR.fPT + this.fQo.fPS.fPT))) * this.fQK) + this.fQF + this.fQE);
            }
            float y = this.fQr.getY() - ((this.bIg - this.aLz) / 2);
            if (this.fQM + (this.bIh / 2) >= this.fQy.getLeft()) {
                this.fQM = (this.fQy.getLeft() - 10) - (this.bIh / 2);
                this.fQz.layout((this.fQy.getLeft() - 10) - this.bIh, (int) y, this.fQy.getLeft() - 10, ((int) y) + this.bIg);
            } else if (this.fQM - (this.bIh / 2) <= this.fQx.getRight()) {
                this.fQM = this.fQx.getRight() + 10 + (this.bIh / 2);
                this.fQz.layout(this.fQx.getRight() + 10, (int) y, this.fQx.getRight() + 10 + this.bIh, ((int) y) + this.bIg);
            } else {
                this.fQz.layout(this.fQM - (this.bIh / 2), (int) y, this.fQM + (this.bIh / 2), ((int) y) + this.bIg);
            }
            int x = (this.mWidth / 2) - ((int) this.fQt.getX());
            if (this.fQH < this.bNA) {
                int i5 = (this.fQE - this.fQH) / 2;
                this.fQA.layout(i5, (int) this.fQA.getY(), this.fQH + i5, ((int) this.fQA.getY()) + this.fQJ);
            } else if (this.fQH <= x) {
                this.fQA.layout((int) this.fQt.getX(), (int) this.fQA.getY(), ((int) this.fQt.getX()) + this.fQH, ((int) this.fQA.getY()) + this.fQJ);
            } else {
                ViewGroup.LayoutParams layoutParams = this.fQA.getLayoutParams();
                layoutParams.width = x;
                this.fQA.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.fQI < this.bNA) {
                int x2 = ((int) this.fQs.getX()) + ((this.fQE - this.fQI) / 2);
                this.fQB.layout(x2, (int) this.fQB.getY(), this.fQI + x2, ((int) this.fQB.getY()) + this.fQJ);
            } else if (this.fQI <= x) {
                this.fQB.layout((this.mWidth - ((int) this.fQu.getX())) - this.fQI, (int) this.fQB.getY(), this.mWidth - ((int) this.fQu.getX()), ((int) this.fQB.getY()) + this.fQJ);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.fQB.getLayoutParams();
                layoutParams2.width = x;
                this.fQB.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.fQE - this.fQN) / 2;
            this.fQC.layout(((int) this.fQr.getX()) + i6, ((int) this.fQr.getY()) + i6, ((int) this.fQr.getX()) + i6 + this.fQN, ((int) this.fQr.getY()) + i6 + this.fQN);
            this.fQD.layout(((int) this.fQs.getX()) + i6, ((int) this.fQs.getY()) + i6, ((int) this.fQs.getX()) + i6 + this.fQN, i6 + ((int) this.fQs.getY()) + this.fQN);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", 16);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        } else if (this.fQP == null || !this.fQP.isRunning()) {
            if (this.fQS == null || !this.fQS.isRunning()) {
                if (this.fQS == null) {
                    this.fQS = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.fQS.setDuration(800L);
                    this.fQS.setInterpolator(new AccelerateInterpolator());
                }
                if (this.fQP == null) {
                    this.fQP = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.fQP.setDuration(800L);
                    this.fQP.setInterpolator(new AccelerateInterpolator());
                    this.fQR = new a();
                    this.fQP.addListener(this.fQR);
                    this.fQP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.fQQ.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.fQQ.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bnr()) {
                    i = 1;
                } else {
                    i = bns() ? 2 : 0;
                }
                if (view == this.fQr) {
                    ku(1 != i);
                    kv(false);
                    i2 = 1;
                } else if (view == this.fQs) {
                    kv(2 != i);
                    ku(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new am("c13352").T("obj_type", i2).k("topic_id", this.fQo.topicId).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.fQo.from));
                if (this.fQZ != null) {
                    this.fQZ.sH(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.fQo.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.fQo.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.fQo.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.fQo != null) {
            M(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void M(Canvas canvas) {
        float y = this.fQr.getY() + ((this.aLz - this.fQL) / 2);
        this.mPaint.setShader(new LinearGradient(this.fQE / 2, y, this.fQM, y, al.getColor(d.C0277d.topic_pk_agree_bar_start_color), al.getColor(d.C0277d.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.fQE / 2, y, this.fQM, y + this.fQL, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.fQM, y, this.mWidth - (this.fQE / 2), y, al.getColor(d.C0277d.topic_pk_disagree_bar_start_color), al.getColor(d.C0277d.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.fQM, y, this.mWidth - (this.fQE / 2), y + this.fQL, this.mPaint);
    }

    public void setUserColor(int i) {
        this.fQO = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.fPR == null || bVar.fPS == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fQo = bVar;
        this.fQp.setText(String.format(getContext().getString(d.j.topic_pk_user), bVar.fPR.fPV));
        this.fQq.setText(String.format(getContext().getString(d.j.topic_pk_user), bVar.fPS.fPV));
        this.fQx.setText(String.valueOf(bVar.fPR.fPT));
        this.fQy.setText(String.valueOf(bVar.fPS.fPT));
        this.fQX = new RelativeLayout.LayoutParams(-2, -2);
        this.fQX.addRule(12);
        this.fQY = new RelativeLayout.LayoutParams(-2, -2);
        this.fQY.addRule(12);
        this.fQY.addRule(11);
        this.fQA.setLayoutParams(this.fQX);
        this.fQA.setText(bVar.fPR.fPU);
        this.fQB.setLayoutParams(this.fQY);
        this.fQB.setText(bVar.fPS.fPU);
        this.fQt.startLoad(bVar.fPR.fPW, 10, false);
        this.fQu.startLoad(bVar.fPS.fPW, 10, false);
        this.fQv.startLoad(bVar.fPR.fPZ, 10, false);
        this.fQw.startLoad(bVar.fPS.fPZ, 10, false);
        if (bVar.fPR.fPX) {
            this.fQt.setVisibility(4);
            this.fQv.setVisibility(0);
        } else {
            this.fQt.setVisibility(0);
            this.fQv.setVisibility(4);
        }
        if (bVar.fPS.fPX) {
            this.fQu.setVisibility(4);
            this.fQw.setVisibility(0);
        } else {
            this.fQu.setVisibility(0);
            this.fQw.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        al.j(this.fQp, this.fQO);
        al.j(this.fQq, this.fQO);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.k(this.fQr, d.f.btn_topic_agree_bg_red);
            al.k(this.fQs, d.f.btn_topic_disagree_bg_blue);
            this.fQt.setIsNight(this.mSkinType == 1);
            this.fQu.setIsNight(this.mSkinType == 1);
            this.fQv.setIsNight(this.mSkinType == 1);
            this.fQw.setIsNight(this.mSkinType == 1);
            al.j(this.fQx, d.C0277d.cp_btn_a);
            al.j(this.fQy, d.C0277d.cp_btn_a);
            al.c(this.fQz, d.f.pic_topic_vs_bginone);
            al.j(this.fQA, d.C0277d.topic_agree_des_color);
            al.j(this.fQB, d.C0277d.topic_disagree_des_color);
            al.c(this.fQC, d.f.pic_topic_addone);
            al.c(this.fQD, d.f.pic_topic_addone);
        }
    }

    private void ku(boolean z) {
        if (z) {
            this.fQp.setVisibility(0);
            this.fQp.setText(String.format(getContext().getString(d.j.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.fQo.fPR.fPV = TbadkCoreApplication.getCurrentAccountNameShow();
            this.fQo.fPR.fPX = true;
            TextView textView = this.fQx;
            b.a aVar = this.fQo.fPR;
            long j = aVar.fPT + 1;
            aVar.fPT = j;
            textView.setText(String.valueOf(j));
            this.fQC.setVisibility(0);
            this.fQQ = this.fQv;
            this.fQR.fRc = this.fQv;
            this.fQR.fRd = this.fQt;
            this.fQC.setVisibility(0);
            this.fQP.start();
            this.fQT = this.fQC.getX();
            this.fQU = this.fQC.getY();
            this.fQV = this.fQC.getX();
            this.fQW = this.fQC.getY();
            this.fQS.removeAllUpdateListeners();
            this.fQS.addUpdateListener(this.fRa);
            this.fQS.setFloatValues(0.0f, 2.0f);
            this.fQS.start();
            return;
        }
        if (ap.equals(this.fQo.fPR.fPV, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.fQp.setVisibility(4);
        }
        if (this.fQo.fPR.fPX) {
            this.fQo.fPR.fPX = false;
            TextView textView2 = this.fQx;
            b.a aVar2 = this.fQo.fPR;
            long j2 = aVar2.fPT - 1;
            aVar2.fPT = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.fQt.setVisibility(0);
        this.fQv.setVisibility(4);
    }

    private void kv(boolean z) {
        if (z) {
            this.fQq.setText(String.format(getContext().getString(d.j.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.fQq.setVisibility(0);
            this.fQo.fPS.fPV = TbadkCoreApplication.getCurrentAccountNameShow();
            this.fQD.setVisibility(0);
            this.fQo.fPS.fPX = true;
            TextView textView = this.fQy;
            b.a aVar = this.fQo.fPS;
            long j = aVar.fPT + 1;
            aVar.fPT = j;
            textView.setText(String.valueOf(j));
            this.fQT = this.fQD.getX() - (this.fQN / 2.0f);
            this.fQQ = this.fQw;
            this.fQR.fRc = this.fQw;
            this.fQR.fRd = this.fQu;
            this.fQC.setVisibility(0);
            this.fQP.start();
            this.fQT = this.fQD.getX() - (this.fQN / 2);
            this.fQU = this.fQD.getY();
            this.fQV = this.fQD.getX();
            this.fQW = this.fQD.getY();
            this.fQS.removeAllUpdateListeners();
            this.fQS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.fQD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQT) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.fQE) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.fQE / 2)))));
                        TopicPkView.this.fQD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.fQD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.fQE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.fQD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.fQD.setVisibility(4);
                        TopicPkView.this.fQD.setX(TopicPkView.this.fQV);
                        TopicPkView.this.fQD.setY(TopicPkView.this.fQW);
                    }
                }
            });
            this.fQS.setFloatValues(0.0f, 2.0f);
            this.fQS.start();
            return;
        }
        if (ap.equals(this.fQo.fPS.fPV, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.fQq.setVisibility(4);
        }
        if (this.fQo.fPS.fPX) {
            this.fQo.fPS.fPX = false;
            TextView textView2 = this.fQy;
            b.a aVar2 = this.fQo.fPS;
            long j2 = aVar2.fPT - 1;
            aVar2.fPT = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.fQD.setVisibility(4);
        this.fQu.setVisibility(0);
        this.fQw.setVisibility(4);
    }

    private boolean bnr() {
        return (this.fQo == null || this.fQo.fPR == null || !this.fQo.fPR.fPX) ? false : true;
    }

    private boolean bns() {
        return (this.fQo == null || this.fQo.fPS == null || !this.fQo.fPS.fPX) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fQP != null) {
            this.fQP.cancel();
        }
        if (this.fQS != null) {
            this.fQS.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.fQZ = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View fRc;
        private View fRd;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.fRc != null) {
                this.fRc.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.fRd != null) {
                this.fRd.setVisibility(8);
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
