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
    private int aLC;
    private int bIi;
    private int bIj;
    private int bNC;
    private int fQA;
    private int fQB;
    private int fQC;
    private ValueAnimator fQD;
    private View fQE;
    private a fQF;
    private ValueAnimator fQG;
    private double fQH;
    private double fQI;
    private float fQJ;
    private float fQK;
    private RelativeLayout.LayoutParams fQL;
    private RelativeLayout.LayoutParams fQM;
    private b fQN;
    private ValueAnimator.AnimatorUpdateListener fQO;
    private com.baidu.tieba.homepage.topic.topictab.b.b fQc;
    private TextView fQd;
    private TextView fQe;
    private FrameLayout fQf;
    private FrameLayout fQg;
    private TbImageView fQh;
    private TbImageView fQi;
    private TbImageView fQj;
    private TbImageView fQk;
    private TextView fQl;
    private TextView fQm;
    private ImageView fQn;
    private TextView fQo;
    private TextView fQp;
    private ImageView fQq;
    private ImageView fQr;
    private int fQs;
    private int fQt;
    private int fQu;
    private int fQv;
    private int fQw;
    private int fQx;
    private int fQy;
    private int fQz;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void sD(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fQC = d.C0277d.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.fQO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.fQq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQH) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.fQs - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQf.getX() + (TopicPkView.this.fQs / 2)))));
                    TopicPkView.this.fQq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQI) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.fQq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.fQf.getX() + (TopicPkView.this.fQs / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQf.getX() + (TopicPkView.this.fQs / 2)))));
                    TopicPkView.this.fQq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.fQq.setVisibility(4);
                    TopicPkView.this.fQq.setX(TopicPkView.this.fQJ);
                    TopicPkView.this.fQq.setY(TopicPkView.this.fQK);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fQC = d.C0277d.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.fQO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.fQq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQH) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.fQs - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQf.getX() + (TopicPkView.this.fQs / 2)))));
                    TopicPkView.this.fQq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQI) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.fQq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.fQf.getX() + (TopicPkView.this.fQs / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQf.getX() + (TopicPkView.this.fQs / 2)))));
                    TopicPkView.this.fQq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.fQq.setVisibility(4);
                    TopicPkView.this.fQq.setX(TopicPkView.this.fQJ);
                    TopicPkView.this.fQq.setY(TopicPkView.this.fQK);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fQC = d.C0277d.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.fQO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.fQq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQH) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.fQs - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQf.getX() + (TopicPkView.this.fQs / 2)))));
                    TopicPkView.this.fQq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQI) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.fQq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.fQf.getX() + (TopicPkView.this.fQs / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.fQf.getX() + (TopicPkView.this.fQs / 2)))));
                    TopicPkView.this.fQq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.fQq.setVisibility(4);
                    TopicPkView.this.fQq.setX(TopicPkView.this.fQJ);
                    TopicPkView.this.fQq.setY(TopicPkView.this.fQK);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(d.h.topic_pk_view_layout, (ViewGroup) this, true);
        this.fQd = (TextView) findViewById(d.g.topic_pk_view_agree_user);
        this.fQe = (TextView) findViewById(d.g.topic_pk_view_disagree_user);
        this.fQf = (FrameLayout) findViewById(d.g.topic_pk_view_agree_btn);
        this.fQg = (FrameLayout) findViewById(d.g.topic_pk_view_disagree_btn);
        this.fQh = (TbImageView) findViewById(d.g.topic_pk_view_agree_img);
        this.fQi = (TbImageView) findViewById(d.g.topic_pk_view_disagree_img);
        this.fQj = (TbImageView) findViewById(d.g.topic_pk_view_agree_select_img);
        this.fQk = (TbImageView) findViewById(d.g.topic_pk_view_disagree_select_img);
        this.fQl = (TextView) findViewById(d.g.topic_pk_view_agree_num);
        this.fQm = (TextView) findViewById(d.g.topic_pk_view_disagree_num);
        this.fQn = (ImageView) findViewById(d.g.topic_pk_view_cursor);
        this.fQo = (TextView) findViewById(d.g.topic_pk_view_agree_des);
        this.fQp = (TextView) findViewById(d.g.topic_pk_view_disagree_des);
        this.fQq = (ImageView) findViewById(d.g.topic_pk_view_agree_add);
        this.fQr = (ImageView) findViewById(d.g.topic_pk_view_disagree_add);
        this.fQh.setDefaultBgResource(d.f.btn_topic_agree_white_n);
        this.fQi.setDefaultBgResource(d.f.btn_topic_disagree_white_n);
        this.fQj.setDefaultBgResource(d.f.btn_topic_agree_white_h);
        this.fQk.setDefaultBgResource(d.f.btn_topic_disagree_white_h);
        this.fQf.setOnClickListener(this);
        this.fQg.setOnClickListener(this);
        this.mHeight = l.h(context, d.e.tbds340);
        this.fQz = l.h(context, d.e.tbds78);
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
        if (this.fQc != null) {
            this.fQs = this.fQf.getWidth();
            this.aLC = this.fQf.getHeight();
            this.bNC = this.fQh.getWidth();
            this.fQt = this.fQl.getWidth();
            this.fQu = this.fQm.getWidth();
            this.fQx = this.fQl.getHeight();
            this.fQv = this.fQo.getWidth();
            this.fQw = this.fQp.getWidth();
            this.bIj = this.fQn.getWidth();
            this.bIi = this.fQn.getHeight();
            this.fQy = ((this.mWidth - (this.fQs * 2)) - this.fQt) - this.fQu;
            this.fQB = this.fQq.getWidth();
            if (this.fQc.fPF.fPH == 0 && this.fQc.fPG.fPH == 0) {
                this.fQA = (int) ((0.5d * this.fQy) + this.fQt + this.fQs);
            } else {
                this.fQA = (int) (((((float) this.fQc.fPF.fPH) / ((float) (this.fQc.fPF.fPH + this.fQc.fPG.fPH))) * this.fQy) + this.fQt + this.fQs);
            }
            float y = this.fQf.getY() - ((this.bIi - this.aLC) / 2);
            if (this.fQA + (this.bIj / 2) >= this.fQm.getLeft()) {
                this.fQA = (this.fQm.getLeft() - 10) - (this.bIj / 2);
                this.fQn.layout((this.fQm.getLeft() - 10) - this.bIj, (int) y, this.fQm.getLeft() - 10, ((int) y) + this.bIi);
            } else if (this.fQA - (this.bIj / 2) <= this.fQl.getRight()) {
                this.fQA = this.fQl.getRight() + 10 + (this.bIj / 2);
                this.fQn.layout(this.fQl.getRight() + 10, (int) y, this.fQl.getRight() + 10 + this.bIj, ((int) y) + this.bIi);
            } else {
                this.fQn.layout(this.fQA - (this.bIj / 2), (int) y, this.fQA + (this.bIj / 2), ((int) y) + this.bIi);
            }
            int x = (this.mWidth / 2) - ((int) this.fQh.getX());
            if (this.fQv < this.bNC) {
                int i5 = (this.fQs - this.fQv) / 2;
                this.fQo.layout(i5, (int) this.fQo.getY(), this.fQv + i5, ((int) this.fQo.getY()) + this.fQx);
            } else if (this.fQv <= x) {
                this.fQo.layout((int) this.fQh.getX(), (int) this.fQo.getY(), ((int) this.fQh.getX()) + this.fQv, ((int) this.fQo.getY()) + this.fQx);
            } else {
                ViewGroup.LayoutParams layoutParams = this.fQo.getLayoutParams();
                layoutParams.width = x;
                this.fQo.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.fQw < this.bNC) {
                int x2 = ((int) this.fQg.getX()) + ((this.fQs - this.fQw) / 2);
                this.fQp.layout(x2, (int) this.fQp.getY(), this.fQw + x2, ((int) this.fQp.getY()) + this.fQx);
            } else if (this.fQw <= x) {
                this.fQp.layout((this.mWidth - ((int) this.fQi.getX())) - this.fQw, (int) this.fQp.getY(), this.mWidth - ((int) this.fQi.getX()), ((int) this.fQp.getY()) + this.fQx);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.fQp.getLayoutParams();
                layoutParams2.width = x;
                this.fQp.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.fQs - this.fQB) / 2;
            this.fQq.layout(((int) this.fQf.getX()) + i6, ((int) this.fQf.getY()) + i6, ((int) this.fQf.getX()) + i6 + this.fQB, ((int) this.fQf.getY()) + i6 + this.fQB);
            this.fQr.layout(((int) this.fQg.getX()) + i6, ((int) this.fQg.getY()) + i6, ((int) this.fQg.getX()) + i6 + this.fQB, i6 + ((int) this.fQg.getY()) + this.fQB);
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
        } else if (this.fQD == null || !this.fQD.isRunning()) {
            if (this.fQG == null || !this.fQG.isRunning()) {
                if (this.fQG == null) {
                    this.fQG = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.fQG.setDuration(800L);
                    this.fQG.setInterpolator(new AccelerateInterpolator());
                }
                if (this.fQD == null) {
                    this.fQD = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.fQD.setDuration(800L);
                    this.fQD.setInterpolator(new AccelerateInterpolator());
                    this.fQF = new a();
                    this.fQD.addListener(this.fQF);
                    this.fQD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.fQE.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.fQE.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bno()) {
                    i = 1;
                } else {
                    i = bnp() ? 2 : 0;
                }
                if (view == this.fQf) {
                    ku(1 != i);
                    kv(false);
                    i2 = 1;
                } else if (view == this.fQg) {
                    kv(2 != i);
                    ku(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new am("c13352").T("obj_type", i2).k("topic_id", this.fQc.topicId).T(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.fQc.from));
                if (this.fQN != null) {
                    this.fQN.sD(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.fQc.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.fQc.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.fQc.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.fQc != null) {
            M(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void M(Canvas canvas) {
        float y = this.fQf.getY() + ((this.aLC - this.fQz) / 2);
        this.mPaint.setShader(new LinearGradient(this.fQs / 2, y, this.fQA, y, al.getColor(d.C0277d.topic_pk_agree_bar_start_color), al.getColor(d.C0277d.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.fQs / 2, y, this.fQA, y + this.fQz, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.fQA, y, this.mWidth - (this.fQs / 2), y, al.getColor(d.C0277d.topic_pk_disagree_bar_start_color), al.getColor(d.C0277d.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.fQA, y, this.mWidth - (this.fQs / 2), y + this.fQz, this.mPaint);
    }

    public void setUserColor(int i) {
        this.fQC = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.fPF == null || bVar.fPG == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.fQc = bVar;
        this.fQd.setText(String.format(getContext().getString(d.j.topic_pk_user), bVar.fPF.fPJ));
        this.fQe.setText(String.format(getContext().getString(d.j.topic_pk_user), bVar.fPG.fPJ));
        this.fQl.setText(String.valueOf(bVar.fPF.fPH));
        this.fQm.setText(String.valueOf(bVar.fPG.fPH));
        this.fQL = new RelativeLayout.LayoutParams(-2, -2);
        this.fQL.addRule(12);
        this.fQM = new RelativeLayout.LayoutParams(-2, -2);
        this.fQM.addRule(12);
        this.fQM.addRule(11);
        this.fQo.setLayoutParams(this.fQL);
        this.fQo.setText(bVar.fPF.fPI);
        this.fQp.setLayoutParams(this.fQM);
        this.fQp.setText(bVar.fPG.fPI);
        this.fQh.startLoad(bVar.fPF.fPK, 10, false);
        this.fQi.startLoad(bVar.fPG.fPK, 10, false);
        this.fQj.startLoad(bVar.fPF.fPN, 10, false);
        this.fQk.startLoad(bVar.fPG.fPN, 10, false);
        if (bVar.fPF.fPL) {
            this.fQh.setVisibility(4);
            this.fQj.setVisibility(0);
        } else {
            this.fQh.setVisibility(0);
            this.fQj.setVisibility(4);
        }
        if (bVar.fPG.fPL) {
            this.fQi.setVisibility(4);
            this.fQk.setVisibility(0);
        } else {
            this.fQi.setVisibility(0);
            this.fQk.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        al.j(this.fQd, this.fQC);
        al.j(this.fQe, this.fQC);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.k(this.fQf, d.f.btn_topic_agree_bg_red);
            al.k(this.fQg, d.f.btn_topic_disagree_bg_blue);
            this.fQh.setIsNight(this.mSkinType == 1);
            this.fQi.setIsNight(this.mSkinType == 1);
            this.fQj.setIsNight(this.mSkinType == 1);
            this.fQk.setIsNight(this.mSkinType == 1);
            al.j(this.fQl, d.C0277d.cp_btn_a);
            al.j(this.fQm, d.C0277d.cp_btn_a);
            al.c(this.fQn, d.f.pic_topic_vs_bginone);
            al.j(this.fQo, d.C0277d.topic_agree_des_color);
            al.j(this.fQp, d.C0277d.topic_disagree_des_color);
            al.c(this.fQq, d.f.pic_topic_addone);
            al.c(this.fQr, d.f.pic_topic_addone);
        }
    }

    private void ku(boolean z) {
        if (z) {
            this.fQd.setVisibility(0);
            this.fQd.setText(String.format(getContext().getString(d.j.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.fQc.fPF.fPJ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.fQc.fPF.fPL = true;
            TextView textView = this.fQl;
            b.a aVar = this.fQc.fPF;
            long j = aVar.fPH + 1;
            aVar.fPH = j;
            textView.setText(String.valueOf(j));
            this.fQq.setVisibility(0);
            this.fQE = this.fQj;
            this.fQF.fQQ = this.fQj;
            this.fQF.fQR = this.fQh;
            this.fQq.setVisibility(0);
            this.fQD.start();
            this.fQH = this.fQq.getX();
            this.fQI = this.fQq.getY();
            this.fQJ = this.fQq.getX();
            this.fQK = this.fQq.getY();
            this.fQG.removeAllUpdateListeners();
            this.fQG.addUpdateListener(this.fQO);
            this.fQG.setFloatValues(0.0f, 2.0f);
            this.fQG.start();
            return;
        }
        if (ap.equals(this.fQc.fPF.fPJ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.fQd.setVisibility(4);
        }
        if (this.fQc.fPF.fPL) {
            this.fQc.fPF.fPL = false;
            TextView textView2 = this.fQl;
            b.a aVar2 = this.fQc.fPF;
            long j2 = aVar2.fPH - 1;
            aVar2.fPH = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.fQh.setVisibility(0);
        this.fQj.setVisibility(4);
    }

    private void kv(boolean z) {
        if (z) {
            this.fQe.setText(String.format(getContext().getString(d.j.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.fQe.setVisibility(0);
            this.fQc.fPG.fPJ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.fQr.setVisibility(0);
            this.fQc.fPG.fPL = true;
            TextView textView = this.fQm;
            b.a aVar = this.fQc.fPG;
            long j = aVar.fPH + 1;
            aVar.fPH = j;
            textView.setText(String.valueOf(j));
            this.fQH = this.fQr.getX() - (this.fQB / 2.0f);
            this.fQE = this.fQk;
            this.fQF.fQQ = this.fQk;
            this.fQF.fQR = this.fQi;
            this.fQq.setVisibility(0);
            this.fQD.start();
            this.fQH = this.fQr.getX() - (this.fQB / 2);
            this.fQI = this.fQr.getY();
            this.fQJ = this.fQr.getX();
            this.fQK = this.fQr.getY();
            this.fQG.removeAllUpdateListeners();
            this.fQG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.fQr.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQH) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.fQs) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.fQs / 2)))));
                        TopicPkView.this.fQr.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.fQI) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.fQr.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.fQs / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.fQr.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.fQr.setVisibility(4);
                        TopicPkView.this.fQr.setX(TopicPkView.this.fQJ);
                        TopicPkView.this.fQr.setY(TopicPkView.this.fQK);
                    }
                }
            });
            this.fQG.setFloatValues(0.0f, 2.0f);
            this.fQG.start();
            return;
        }
        if (ap.equals(this.fQc.fPG.fPJ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.fQe.setVisibility(4);
        }
        if (this.fQc.fPG.fPL) {
            this.fQc.fPG.fPL = false;
            TextView textView2 = this.fQm;
            b.a aVar2 = this.fQc.fPG;
            long j2 = aVar2.fPH - 1;
            aVar2.fPH = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.fQr.setVisibility(4);
        this.fQi.setVisibility(0);
        this.fQk.setVisibility(4);
    }

    private boolean bno() {
        return (this.fQc == null || this.fQc.fPF == null || !this.fQc.fPF.fPL) ? false : true;
    }

    private boolean bnp() {
        return (this.fQc == null || this.fQc.fPG == null || !this.fQc.fPG.fPL) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.fQD != null) {
            this.fQD.cancel();
        }
        if (this.fQG != null) {
            this.fQG.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.fQN = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View fQQ;
        private View fQR;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.fQQ != null) {
                this.fQQ.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.fQR != null) {
                this.fQR.setVisibility(8);
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
