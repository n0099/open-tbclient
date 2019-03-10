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
    private int aLy;
    private int bIf;
    private int bIg;
    private int bNz;
    private ImageView fQA;
    private TextView fQB;
    private TextView fQC;
    private ImageView fQD;
    private ImageView fQE;
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
    private int fQP;
    private ValueAnimator fQQ;
    private View fQR;
    private a fQS;
    private ValueAnimator fQT;
    private double fQU;
    private double fQV;
    private float fQW;
    private float fQX;
    private RelativeLayout.LayoutParams fQY;
    private RelativeLayout.LayoutParams fQZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b fQp;
    private TextView fQq;
    private TextView fQr;
    private FrameLayout fQs;
    private FrameLayout fQt;
    private TbImageView fQu;
    private TbImageView fQv;
    private TbImageView fQw;
    private TbImageView fQx;
    private TextView fQy;
    private TextView fQz;
    private b fRa;
    private ValueAnimator.AnimatorUpdateListener fRb;
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
        this.fQP = d.C0236d.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.fRb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.fQD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQU) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.fQF - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQs.getX() + (TopicPkView.this.fQF / 2)))));
                    TopicPkView.this.fQD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.fQD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.fQs.getX() + (TopicPkView.this.fQF / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQs.getX() + (TopicPkView.this.fQF / 2)))));
                    TopicPkView.this.fQD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.fQD.setVisibility(4);
                    TopicPkView.this.fQD.setX(TopicPkView.this.fQW);
                    TopicPkView.this.fQD.setY(TopicPkView.this.fQX);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fQP = d.C0236d.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.fRb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.fQD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQU) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.fQF - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQs.getX() + (TopicPkView.this.fQF / 2)))));
                    TopicPkView.this.fQD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.fQD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.fQs.getX() + (TopicPkView.this.fQF / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQs.getX() + (TopicPkView.this.fQF / 2)))));
                    TopicPkView.this.fQD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.fQD.setVisibility(4);
                    TopicPkView.this.fQD.setX(TopicPkView.this.fQW);
                    TopicPkView.this.fQD.setY(TopicPkView.this.fQX);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fQP = d.C0236d.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.fRb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.fQD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQU) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.fQF - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQs.getX() + (TopicPkView.this.fQF / 2)))));
                    TopicPkView.this.fQD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.fQD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.fQs.getX() + (TopicPkView.this.fQF / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQs.getX() + (TopicPkView.this.fQF / 2)))));
                    TopicPkView.this.fQD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.fQD.setVisibility(4);
                    TopicPkView.this.fQD.setX(TopicPkView.this.fQW);
                    TopicPkView.this.fQD.setY(TopicPkView.this.fQX);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.topic_pk_view_layout, (ViewGroup) this, true);
        this.fQq = (TextView) findViewById(d.g.topic_pk_view_agree_user);
        this.fQr = (TextView) findViewById(d.g.topic_pk_view_disagree_user);
        this.fQs = (FrameLayout) findViewById(d.g.topic_pk_view_agree_btn);
        this.fQt = (FrameLayout) findViewById(d.g.topic_pk_view_disagree_btn);
        this.fQu = (TbImageView) findViewById(d.g.topic_pk_view_agree_img);
        this.fQv = (TbImageView) findViewById(d.g.topic_pk_view_disagree_img);
        this.fQw = (TbImageView) findViewById(d.g.topic_pk_view_agree_select_img);
        this.fQx = (TbImageView) findViewById(d.g.topic_pk_view_disagree_select_img);
        this.fQy = (TextView) findViewById(d.g.topic_pk_view_agree_num);
        this.fQz = (TextView) findViewById(d.g.topic_pk_view_disagree_num);
        this.fQA = (ImageView) findViewById(d.g.topic_pk_view_cursor);
        this.fQB = (TextView) findViewById(d.g.topic_pk_view_agree_des);
        this.fQC = (TextView) findViewById(d.g.topic_pk_view_disagree_des);
        this.fQD = (ImageView) findViewById(d.g.topic_pk_view_agree_add);
        this.fQE = (ImageView) findViewById(d.g.topic_pk_view_disagree_add);
        this.fQu.setDefaultBgResource(d.f.btn_topic_agree_white_n);
        this.fQv.setDefaultBgResource(d.f.btn_topic_disagree_white_n);
        this.fQw.setDefaultBgResource(d.f.btn_topic_agree_white_h);
        this.fQx.setDefaultBgResource(d.f.btn_topic_disagree_white_h);
        this.fQs.setOnClickListener(this);
        this.fQt.setOnClickListener(this);
        this.mHeight = l.h(context, d.e.tbds340);
        this.fQM = l.h(context, d.e.tbds78);
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
        if (this.fQp != null) {
            this.fQF = this.fQs.getWidth();
            this.aLy = this.fQs.getHeight();
            this.bNz = this.fQu.getWidth();
            this.fQG = this.fQy.getWidth();
            this.fQH = this.fQz.getWidth();
            this.fQK = this.fQy.getHeight();
            this.fQI = this.fQB.getWidth();
            this.fQJ = this.fQC.getWidth();
            this.bIg = this.fQA.getWidth();
            this.bIf = this.fQA.getHeight();
            this.fQL = ((this.mWidth - (this.fQF * 2)) - this.fQG) - this.fQH;
            this.fQO = this.fQD.getWidth();
            if (this.fQp.fPS.fPU == 0 && this.fQp.fPT.fPU == 0) {
                this.fQN = (int) ((0.5d * this.fQL) + this.fQG + this.fQF);
            } else {
                this.fQN = (int) (((((float) this.fQp.fPS.fPU) / ((float) (this.fQp.fPS.fPU + this.fQp.fPT.fPU))) * this.fQL) + this.fQG + this.fQF);
            }
            float y = this.fQs.getY() - ((this.bIf - this.aLy) / 2);
            if (this.fQN + (this.bIg / 2) >= this.fQz.getLeft()) {
                this.fQN = (this.fQz.getLeft() - 10) - (this.bIg / 2);
                this.fQA.layout((this.fQz.getLeft() - 10) - this.bIg, (int) y, this.fQz.getLeft() - 10, ((int) y) + this.bIf);
            } else if (this.fQN - (this.bIg / 2) <= this.fQy.getRight()) {
                this.fQN = this.fQy.getRight() + 10 + (this.bIg / 2);
                this.fQA.layout(this.fQy.getRight() + 10, (int) y, this.fQy.getRight() + 10 + this.bIg, ((int) y) + this.bIf);
            } else {
                this.fQA.layout(this.fQN - (this.bIg / 2), (int) y, this.fQN + (this.bIg / 2), ((int) y) + this.bIf);
            }
            int x = (this.mWidth / 2) - ((int) this.fQu.getX());
            if (this.fQI < this.bNz) {
                int i5 = (this.fQF - this.fQI) / 2;
                this.fQB.layout(i5, (int) this.fQB.getY(), this.fQI + i5, ((int) this.fQB.getY()) + this.fQK);
            } else if (this.fQI <= x) {
                this.fQB.layout((int) this.fQu.getX(), (int) this.fQB.getY(), ((int) this.fQu.getX()) + this.fQI, ((int) this.fQB.getY()) + this.fQK);
            } else {
                ViewGroup.LayoutParams layoutParams = this.fQB.getLayoutParams();
                layoutParams.width = x;
                this.fQB.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.fQJ < this.bNz) {
                int x2 = ((int) this.fQt.getX()) + ((this.fQF - this.fQJ) / 2);
                this.fQC.layout(x2, (int) this.fQC.getY(), this.fQJ + x2, ((int) this.fQC.getY()) + this.fQK);
            } else if (this.fQJ <= x) {
                this.fQC.layout((this.mWidth - ((int) this.fQv.getX())) - this.fQJ, (int) this.fQC.getY(), this.mWidth - ((int) this.fQv.getX()), ((int) this.fQC.getY()) + this.fQK);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.fQC.getLayoutParams();
                layoutParams2.width = x;
                this.fQC.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.fQF - this.fQO) / 2;
            this.fQD.layout(((int) this.fQs.getX()) + i6, ((int) this.fQs.getY()) + i6, ((int) this.fQs.getX()) + i6 + this.fQO, ((int) this.fQs.getY()) + i6 + this.fQO);
            this.fQE.layout(((int) this.fQt.getX()) + i6, ((int) this.fQt.getY()) + i6, ((int) this.fQt.getX()) + i6 + this.fQO, i6 + ((int) this.fQt.getY()) + this.fQO);
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
        } else if (this.fQQ == null || !this.fQQ.isRunning()) {
            if (this.fQT == null || !this.fQT.isRunning()) {
                if (this.fQT == null) {
                    this.fQT = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.fQT.setDuration(800L);
                    this.fQT.setInterpolator(new AccelerateInterpolator());
                }
                if (this.fQQ == null) {
                    this.fQQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.fQQ.setDuration(800L);
                    this.fQQ.setInterpolator(new AccelerateInterpolator());
                    this.fQS = new a();
                    this.fQQ.addListener(this.fQS);
                    this.fQQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.fQR.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.fQR.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bns()) {
                    i = 1;
                } else {
                    i = bnt() ? 2 : 0;
                }
                if (view == this.fQs) {
                    ku(1 != i);
                    kv(false);
                    i2 = 1;
                } else if (view == this.fQt) {
                    kv(2 != i);
                    ku(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new am("c13352").T("obj_type", i2).k("topic_id", this.fQp.topicId).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.fQp.from));
                if (this.fRa != null) {
                    this.fRa.sH(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.fQp.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.fQp.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.fQp.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.fQp != null) {
            M(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void M(Canvas canvas) {
        float y = this.fQs.getY() + ((this.aLy - this.fQM) / 2);
        this.mPaint.setShader(new LinearGradient(this.fQF / 2, y, this.fQN, y, al.getColor(d.C0236d.topic_pk_agree_bar_start_color), al.getColor(d.C0236d.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.fQF / 2, y, this.fQN, y + this.fQM, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.fQN, y, this.mWidth - (this.fQF / 2), y, al.getColor(d.C0236d.topic_pk_disagree_bar_start_color), al.getColor(d.C0236d.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.fQN, y, this.mWidth - (this.fQF / 2), y + this.fQM, this.mPaint);
    }

    public void setUserColor(int i) {
        this.fQP = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.fPS == null || bVar.fPT == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fQp = bVar;
        this.fQq.setText(String.format(getContext().getString(d.j.topic_pk_user), bVar.fPS.fPW));
        this.fQr.setText(String.format(getContext().getString(d.j.topic_pk_user), bVar.fPT.fPW));
        this.fQy.setText(String.valueOf(bVar.fPS.fPU));
        this.fQz.setText(String.valueOf(bVar.fPT.fPU));
        this.fQY = new RelativeLayout.LayoutParams(-2, -2);
        this.fQY.addRule(12);
        this.fQZ = new RelativeLayout.LayoutParams(-2, -2);
        this.fQZ.addRule(12);
        this.fQZ.addRule(11);
        this.fQB.setLayoutParams(this.fQY);
        this.fQB.setText(bVar.fPS.fPV);
        this.fQC.setLayoutParams(this.fQZ);
        this.fQC.setText(bVar.fPT.fPV);
        this.fQu.startLoad(bVar.fPS.fPX, 10, false);
        this.fQv.startLoad(bVar.fPT.fPX, 10, false);
        this.fQw.startLoad(bVar.fPS.fQa, 10, false);
        this.fQx.startLoad(bVar.fPT.fQa, 10, false);
        if (bVar.fPS.fPY) {
            this.fQu.setVisibility(4);
            this.fQw.setVisibility(0);
        } else {
            this.fQu.setVisibility(0);
            this.fQw.setVisibility(4);
        }
        if (bVar.fPT.fPY) {
            this.fQv.setVisibility(4);
            this.fQx.setVisibility(0);
        } else {
            this.fQv.setVisibility(0);
            this.fQx.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        al.j(this.fQq, this.fQP);
        al.j(this.fQr, this.fQP);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.k(this.fQs, d.f.btn_topic_agree_bg_red);
            al.k(this.fQt, d.f.btn_topic_disagree_bg_blue);
            this.fQu.setIsNight(this.mSkinType == 1);
            this.fQv.setIsNight(this.mSkinType == 1);
            this.fQw.setIsNight(this.mSkinType == 1);
            this.fQx.setIsNight(this.mSkinType == 1);
            al.j(this.fQy, d.C0236d.cp_btn_a);
            al.j(this.fQz, d.C0236d.cp_btn_a);
            al.c(this.fQA, d.f.pic_topic_vs_bginone);
            al.j(this.fQB, d.C0236d.topic_agree_des_color);
            al.j(this.fQC, d.C0236d.topic_disagree_des_color);
            al.c(this.fQD, d.f.pic_topic_addone);
            al.c(this.fQE, d.f.pic_topic_addone);
        }
    }

    private void ku(boolean z) {
        if (z) {
            this.fQq.setVisibility(0);
            this.fQq.setText(String.format(getContext().getString(d.j.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.fQp.fPS.fPW = TbadkCoreApplication.getCurrentAccountNameShow();
            this.fQp.fPS.fPY = true;
            TextView textView = this.fQy;
            b.a aVar = this.fQp.fPS;
            long j = aVar.fPU + 1;
            aVar.fPU = j;
            textView.setText(String.valueOf(j));
            this.fQD.setVisibility(0);
            this.fQR = this.fQw;
            this.fQS.fRd = this.fQw;
            this.fQS.fRe = this.fQu;
            this.fQD.setVisibility(0);
            this.fQQ.start();
            this.fQU = this.fQD.getX();
            this.fQV = this.fQD.getY();
            this.fQW = this.fQD.getX();
            this.fQX = this.fQD.getY();
            this.fQT.removeAllUpdateListeners();
            this.fQT.addUpdateListener(this.fRb);
            this.fQT.setFloatValues(0.0f, 2.0f);
            this.fQT.start();
            return;
        }
        if (ap.equals(this.fQp.fPS.fPW, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.fQq.setVisibility(4);
        }
        if (this.fQp.fPS.fPY) {
            this.fQp.fPS.fPY = false;
            TextView textView2 = this.fQy;
            b.a aVar2 = this.fQp.fPS;
            long j2 = aVar2.fPU - 1;
            aVar2.fPU = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.fQu.setVisibility(0);
        this.fQw.setVisibility(4);
    }

    private void kv(boolean z) {
        if (z) {
            this.fQr.setText(String.format(getContext().getString(d.j.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.fQr.setVisibility(0);
            this.fQp.fPT.fPW = TbadkCoreApplication.getCurrentAccountNameShow();
            this.fQE.setVisibility(0);
            this.fQp.fPT.fPY = true;
            TextView textView = this.fQz;
            b.a aVar = this.fQp.fPT;
            long j = aVar.fPU + 1;
            aVar.fPU = j;
            textView.setText(String.valueOf(j));
            this.fQU = this.fQE.getX() - (this.fQO / 2.0f);
            this.fQR = this.fQx;
            this.fQS.fRd = this.fQx;
            this.fQS.fRe = this.fQv;
            this.fQD.setVisibility(0);
            this.fQQ.start();
            this.fQU = this.fQE.getX() - (this.fQO / 2);
            this.fQV = this.fQE.getY();
            this.fQW = this.fQE.getX();
            this.fQX = this.fQE.getY();
            this.fQT.removeAllUpdateListeners();
            this.fQT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.fQE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQU) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.fQF) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.fQF / 2)))));
                        TopicPkView.this.fQE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.fQE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.fQF / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.fQE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.fQE.setVisibility(4);
                        TopicPkView.this.fQE.setX(TopicPkView.this.fQW);
                        TopicPkView.this.fQE.setY(TopicPkView.this.fQX);
                    }
                }
            });
            this.fQT.setFloatValues(0.0f, 2.0f);
            this.fQT.start();
            return;
        }
        if (ap.equals(this.fQp.fPT.fPW, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.fQr.setVisibility(4);
        }
        if (this.fQp.fPT.fPY) {
            this.fQp.fPT.fPY = false;
            TextView textView2 = this.fQz;
            b.a aVar2 = this.fQp.fPT;
            long j2 = aVar2.fPU - 1;
            aVar2.fPU = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.fQE.setVisibility(4);
        this.fQv.setVisibility(0);
        this.fQx.setVisibility(4);
    }

    private boolean bns() {
        return (this.fQp == null || this.fQp.fPS == null || !this.fQp.fPS.fPY) ? false : true;
    }

    private boolean bnt() {
        return (this.fQp == null || this.fQp.fPT == null || !this.fQp.fPT.fPY) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fQQ != null) {
            this.fQQ.cancel();
        }
        if (this.fQT != null) {
            this.fQT.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.fRa = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View fRd;
        private View fRe;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.fRd != null) {
                this.fRd.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.fRe != null) {
                this.fRe.setVisibility(8);
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
