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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes9.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int iAA;
    private int iAB;
    private int iAC;
    private int iAD;
    private int iAE;
    private ValueAnimator iAF;
    private View iAG;
    private a iAH;
    private ValueAnimator iAI;
    private double iAJ;
    private double iAK;
    private float iAL;
    private float iAM;
    private RelativeLayout.LayoutParams iAN;
    private RelativeLayout.LayoutParams iAO;
    private b iAP;
    private ValueAnimator.AnimatorUpdateListener iAQ;
    private com.baidu.tieba.homepage.topic.topictab.b.b iAd;
    private TextView iAe;
    private TextView iAf;
    private FrameLayout iAg;
    private FrameLayout iAh;
    private TbImageView iAi;
    private TbImageView iAj;
    private TbImageView iAk;
    private TbImageView iAl;
    private TextView iAm;
    private TextView iAn;
    private ImageView iAo;
    private TextView iAp;
    private TextView iAq;
    private ImageView iAr;
    private ImageView iAs;
    private int iAt;
    private int iAu;
    private int iAv;
    private int iAw;
    private int iAx;
    private int iAy;
    private int iAz;
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
        void xt(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iAE = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iAQ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iAr.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iAJ) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iAt - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iAg.getX() + (TopicPkView.this.iAt / 2)))));
                    TopicPkView.this.iAr.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iAK) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iAr.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iAg.getX() + (TopicPkView.this.iAt / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iAg.getX() + (TopicPkView.this.iAt / 2)))));
                    TopicPkView.this.iAr.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iAr.setVisibility(4);
                    TopicPkView.this.iAr.setX(TopicPkView.this.iAL);
                    TopicPkView.this.iAr.setY(TopicPkView.this.iAM);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iAE = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iAQ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iAr.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iAJ) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iAt - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iAg.getX() + (TopicPkView.this.iAt / 2)))));
                    TopicPkView.this.iAr.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iAK) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iAr.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iAg.getX() + (TopicPkView.this.iAt / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iAg.getX() + (TopicPkView.this.iAt / 2)))));
                    TopicPkView.this.iAr.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iAr.setVisibility(4);
                    TopicPkView.this.iAr.setX(TopicPkView.this.iAL);
                    TopicPkView.this.iAr.setY(TopicPkView.this.iAM);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iAE = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iAQ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iAr.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iAJ) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iAt - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iAg.getX() + (TopicPkView.this.iAt / 2)))));
                    TopicPkView.this.iAr.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iAK) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iAr.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iAg.getX() + (TopicPkView.this.iAt / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iAg.getX() + (TopicPkView.this.iAt / 2)))));
                    TopicPkView.this.iAr.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iAr.setVisibility(4);
                    TopicPkView.this.iAr.setX(TopicPkView.this.iAL);
                    TopicPkView.this.iAr.setY(TopicPkView.this.iAM);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.iAe = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.iAf = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.iAg = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.iAh = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.iAi = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.iAj = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.iAk = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.iAl = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.iAm = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.iAn = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.iAo = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.iAp = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.iAq = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.iAr = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.iAs = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.iAi.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.iAj.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.iAk.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.iAl.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.iAg.setOnClickListener(this);
        this.iAh.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.iAB = l.getDimens(context, R.dimen.tbds62);
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
        if (this.iAd != null) {
            this.iAt = this.iAg.getWidth();
            this.mBtnHeight = this.iAg.getHeight();
            this.iAu = this.iAi.getWidth();
            this.iAv = this.iAm.getWidth();
            this.iAw = this.iAn.getWidth();
            this.iAz = this.iAm.getHeight();
            this.iAx = this.iAp.getWidth();
            this.iAy = this.iAq.getWidth();
            this.mCursorWidth = this.iAo.getWidth();
            this.mCursorHeight = this.iAo.getHeight();
            this.iAA = ((this.mWidth - (this.iAt * 2)) - this.iAv) - this.iAw;
            this.iAD = this.iAr.getWidth();
            if (this.iAd.izD.izF == 0 && this.iAd.izE.izF == 0) {
                this.iAC = (int) ((0.5d * this.iAA) + this.iAv + this.iAt);
            } else {
                this.iAC = (int) (((((float) this.iAd.izD.izF) / ((float) (this.iAd.izD.izF + this.iAd.izE.izF))) * this.iAA) + this.iAv + this.iAt);
            }
            float y = this.iAg.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.iAC + (this.mCursorWidth / 2) >= this.iAn.getLeft()) {
                this.iAC = (this.iAn.getLeft() - 10) - (this.mCursorWidth / 2);
                this.iAo.layout((this.iAn.getLeft() - 10) - this.mCursorWidth, (int) y, this.iAn.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.iAC - (this.mCursorWidth / 2) <= this.iAm.getRight()) {
                this.iAC = this.iAm.getRight() + 10 + (this.mCursorWidth / 2);
                this.iAo.layout(this.iAm.getRight() + 10, (int) y, this.iAm.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.iAo.layout(this.iAC - (this.mCursorWidth / 2), (int) y, this.iAC + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.iAi.getX());
            if (this.iAx < this.iAu) {
                int i5 = (this.iAt - this.iAx) / 2;
                this.iAp.layout(i5, (int) this.iAp.getY(), this.iAx + i5, ((int) this.iAp.getY()) + this.iAz);
            } else if (this.iAx <= x) {
                this.iAp.layout((int) this.iAi.getX(), (int) this.iAp.getY(), ((int) this.iAi.getX()) + this.iAx, ((int) this.iAp.getY()) + this.iAz);
            } else {
                ViewGroup.LayoutParams layoutParams = this.iAp.getLayoutParams();
                layoutParams.width = x;
                this.iAp.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.iAy < this.iAu) {
                int x2 = ((int) this.iAh.getX()) + ((this.iAt - this.iAy) / 2);
                this.iAq.layout(x2, (int) this.iAq.getY(), this.iAy + x2, ((int) this.iAq.getY()) + this.iAz);
            } else if (this.iAy <= x) {
                this.iAq.layout((this.mWidth - ((int) this.iAj.getX())) - this.iAy, (int) this.iAq.getY(), this.mWidth - ((int) this.iAj.getX()), ((int) this.iAq.getY()) + this.iAz);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.iAq.getLayoutParams();
                layoutParams2.width = x;
                this.iAq.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.iAt - this.iAD) / 2;
            this.iAr.layout(((int) this.iAg.getX()) + i6, ((int) this.iAg.getY()) + i6, ((int) this.iAg.getX()) + i6 + this.iAD, ((int) this.iAg.getY()) + i6 + this.iAD);
            this.iAs.layout(((int) this.iAh.getX()) + i6, ((int) this.iAh.getY()) + i6, ((int) this.iAh.getX()) + i6 + this.iAD, i6 + ((int) this.iAh.getY()) + this.iAD);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.iAd.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.iAF == null || !this.iAF.isRunning()) {
            if (this.iAI == null || !this.iAI.isRunning()) {
                if (this.iAI == null) {
                    this.iAI = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.iAI.setDuration(800L);
                    this.iAI.setInterpolator(new AccelerateInterpolator());
                }
                if (this.iAF == null) {
                    this.iAF = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.iAF.setDuration(800L);
                    this.iAF.setInterpolator(new AccelerateInterpolator());
                    this.iAH = new a();
                    this.iAF.addListener(this.iAH);
                    this.iAF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.iAG.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.iAG.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (ckQ()) {
                    i = 1;
                } else {
                    i = ckR() ? 2 : 0;
                }
                if (view == this.iAg) {
                    oG(1 != i);
                    oH(false);
                    i2 = 1;
                } else if (view == this.iAh) {
                    oH(2 != i);
                    oG(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new ao("c13352").ag("obj_type", i2).s("topic_id", this.iAd.topicId).ag("obj_source", this.iAd.from));
                if (this.iAP != null) {
                    this.iAP.xt(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.iAd.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.iAd.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.iAd.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iAd != null) {
            O(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void O(Canvas canvas) {
        float y = this.iAg.getY() + ((this.mBtnHeight - this.iAB) / 2);
        this.mPaint.setShader(new LinearGradient(this.iAt / 2, y, this.iAC, y, an.getColor(R.color.topic_pk_agree_bar_start_color), an.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iAt / 2, y, this.iAC, y + this.iAB, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.iAC, y, this.mWidth - (this.iAt / 2), y, an.getColor(R.color.topic_pk_disagree_bar_start_color), an.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iAC, y, this.mWidth - (this.iAt / 2), y + this.iAB, this.mPaint);
    }

    public void setUserColor(int i) {
        this.iAE = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.izD == null || bVar.izE == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iAd = bVar;
        this.iAm.setText(String.valueOf(bVar.izD.izF));
        this.iAn.setText(String.valueOf(bVar.izE.izF));
        this.iAN = new RelativeLayout.LayoutParams(-2, -2);
        this.iAN.addRule(12);
        this.iAO = new RelativeLayout.LayoutParams(-2, -2);
        this.iAO.addRule(12);
        this.iAO.addRule(11);
        this.iAp.setLayoutParams(this.iAN);
        this.iAq.setLayoutParams(this.iAO);
        if (bVar.from == 3) {
            this.iAp.setText(StringUtils.isNull(bVar.izD.izG) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.izD.izG);
            this.iAq.setText(StringUtils.isNull(bVar.izE.izG) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.izE.izG);
            if (StringUtils.isNull(bVar.izD.izH)) {
                this.iAe.setVisibility(4);
            } else {
                this.iAe.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.izD.izH));
            }
            if (StringUtils.isNull(bVar.izE.izH)) {
                this.iAf.setVisibility(4);
            } else {
                this.iAf.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.izE.izH));
            }
        } else {
            this.iAp.setText(bVar.izD.izG);
            this.iAq.setText(bVar.izE.izG);
            this.iAe.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.izD.izH));
            this.iAf.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.izE.izH));
        }
        this.iAi.startLoad(bVar.izD.izI, 10, false);
        this.iAj.startLoad(bVar.izE.izI, 10, false);
        this.iAk.startLoad(bVar.izD.izL, 10, false);
        this.iAl.startLoad(bVar.izE.izL, 10, false);
        if (bVar.izD.izJ) {
            this.iAi.setVisibility(4);
            this.iAk.setVisibility(0);
        } else {
            this.iAi.setVisibility(0);
            this.iAk.setVisibility(4);
        }
        if (bVar.izE.izJ) {
            this.iAj.setVisibility(4);
            this.iAl.setVisibility(0);
        } else {
            this.iAj.setVisibility(0);
            this.iAl.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        an.setViewTextColor(this.iAe, this.iAE);
        an.setViewTextColor(this.iAf, this.iAE);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.iAi.setIsNight(this.mSkinType == 1);
            this.iAj.setIsNight(this.mSkinType == 1);
            this.iAk.setIsNight(this.mSkinType == 1);
            this.iAl.setIsNight(this.mSkinType == 1);
            an.setBackgroundResource(this.iAg, R.drawable.btn_topic_agree_bg_red);
            an.setBackgroundResource(this.iAh, R.drawable.btn_topic_disagree_bg_blue);
            an.setImageResource(this.iAr, R.drawable.pic_topic_addone);
            an.setImageResource(this.iAs, R.drawable.pic_topic_addone);
            an.setImageResource(this.iAo, R.drawable.pic_topic_vs_bginone);
            an.setViewTextColor(this.iAm, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.iAn, (int) R.color.cp_cont_a);
            an.setViewTextColor(this.iAp, (int) R.color.topic_agree_des_color);
            an.setViewTextColor(this.iAq, (int) R.color.topic_disagree_des_color);
        }
    }

    private void oG(boolean z) {
        if (z) {
            this.iAe.setVisibility(0);
            this.iAe.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iAd.izD.izH = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iAd.izD.izJ = true;
            TextView textView = this.iAm;
            b.a aVar = this.iAd.izD;
            long j = aVar.izF + 1;
            aVar.izF = j;
            textView.setText(String.valueOf(j));
            this.iAr.setVisibility(0);
            this.iAG = this.iAk;
            this.iAH.iAS = this.iAk;
            this.iAH.iAT = this.iAi;
            this.iAr.setVisibility(0);
            this.iAF.start();
            this.iAJ = this.iAr.getX();
            this.iAK = this.iAr.getY();
            this.iAL = this.iAr.getX();
            this.iAM = this.iAr.getY();
            this.iAI.removeAllUpdateListeners();
            this.iAI.addUpdateListener(this.iAQ);
            this.iAI.setFloatValues(0.0f, 2.0f);
            this.iAI.start();
            return;
        }
        if (ar.equals(this.iAd.izD.izH, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iAe.setVisibility(4);
        }
        if (this.iAd.izD.izJ) {
            this.iAd.izD.izJ = false;
            TextView textView2 = this.iAm;
            b.a aVar2 = this.iAd.izD;
            long j2 = aVar2.izF - 1;
            aVar2.izF = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iAi.setVisibility(0);
        this.iAk.setVisibility(4);
    }

    private void oH(boolean z) {
        if (z) {
            this.iAf.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iAf.setVisibility(0);
            this.iAd.izE.izH = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iAs.setVisibility(0);
            this.iAd.izE.izJ = true;
            TextView textView = this.iAn;
            b.a aVar = this.iAd.izE;
            long j = aVar.izF + 1;
            aVar.izF = j;
            textView.setText(String.valueOf(j));
            this.iAJ = this.iAs.getX() - (this.iAD / 2.0f);
            this.iAG = this.iAl;
            this.iAH.iAS = this.iAl;
            this.iAH.iAT = this.iAj;
            this.iAr.setVisibility(0);
            this.iAF.start();
            this.iAJ = this.iAs.getX() - (this.iAD / 2);
            this.iAK = this.iAs.getY();
            this.iAL = this.iAs.getX();
            this.iAM = this.iAs.getY();
            this.iAI.removeAllUpdateListeners();
            this.iAI.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.iAs.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iAJ) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.iAt) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iAt / 2)))));
                        TopicPkView.this.iAs.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iAK) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.iAs.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iAt / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.iAs.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.iAs.setVisibility(4);
                        TopicPkView.this.iAs.setX(TopicPkView.this.iAL);
                        TopicPkView.this.iAs.setY(TopicPkView.this.iAM);
                    }
                }
            });
            this.iAI.setFloatValues(0.0f, 2.0f);
            this.iAI.start();
            return;
        }
        if (ar.equals(this.iAd.izE.izH, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iAf.setVisibility(4);
        }
        if (this.iAd.izE.izJ) {
            this.iAd.izE.izJ = false;
            TextView textView2 = this.iAn;
            b.a aVar2 = this.iAd.izE;
            long j2 = aVar2.izF - 1;
            aVar2.izF = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iAs.setVisibility(4);
        this.iAj.setVisibility(0);
        this.iAl.setVisibility(4);
    }

    private boolean ckQ() {
        return (this.iAd == null || this.iAd.izD == null || !this.iAd.izD.izJ) ? false : true;
    }

    private boolean ckR() {
        return (this.iAd == null || this.iAd.izE == null || !this.iAd.izE.izJ) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.iAF != null) {
            this.iAF.cancel();
        }
        if (this.iAI != null) {
            this.iAI.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.iAP = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Animator.AnimatorListener {
        private View iAS;
        private View iAT;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.iAS != null) {
                this.iAS.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.iAT != null) {
                this.iAT.setVisibility(8);
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
