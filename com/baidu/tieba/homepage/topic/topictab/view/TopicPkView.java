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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes4.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int aNw;
    private int bPT;
    private int bPU;
    private int bVo;
    private TextView ghA;
    private TextView ghB;
    private ImageView ghC;
    private ImageView ghD;
    private int ghE;
    private int ghF;
    private int ghG;
    private int ghH;
    private int ghI;
    private int ghJ;
    private int ghK;
    private int ghL;
    private int ghM;
    private int ghN;
    private int ghO;
    private ValueAnimator ghP;
    private View ghQ;
    private a ghR;
    private ValueAnimator ghS;
    private double ghT;
    private double ghU;
    private float ghV;
    private float ghW;
    private RelativeLayout.LayoutParams ghX;
    private RelativeLayout.LayoutParams ghY;
    private b ghZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b gho;
    private TextView ghp;
    private TextView ghq;
    private FrameLayout ghr;
    private FrameLayout ghs;
    private TbImageView ght;
    private TbImageView ghu;
    private TbImageView ghv;
    private TbImageView ghw;
    private TextView ghx;
    private TextView ghy;
    private ImageView ghz;
    private ValueAnimator.AnimatorUpdateListener gia;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void tK(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ghO = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gia = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ghC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ghE - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghr.getX() + (TopicPkView.this.ghE / 2)))));
                    TopicPkView.this.ghC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ghC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ghr.getX() + (TopicPkView.this.ghE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghr.getX() + (TopicPkView.this.ghE / 2)))));
                    TopicPkView.this.ghC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ghC.setVisibility(4);
                    TopicPkView.this.ghC.setX(TopicPkView.this.ghV);
                    TopicPkView.this.ghC.setY(TopicPkView.this.ghW);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ghO = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gia = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ghC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ghE - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghr.getX() + (TopicPkView.this.ghE / 2)))));
                    TopicPkView.this.ghC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ghC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ghr.getX() + (TopicPkView.this.ghE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghr.getX() + (TopicPkView.this.ghE / 2)))));
                    TopicPkView.this.ghC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ghC.setVisibility(4);
                    TopicPkView.this.ghC.setX(TopicPkView.this.ghV);
                    TopicPkView.this.ghC.setY(TopicPkView.this.ghW);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ghO = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gia = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ghC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ghE - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghr.getX() + (TopicPkView.this.ghE / 2)))));
                    TopicPkView.this.ghC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ghC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ghr.getX() + (TopicPkView.this.ghE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghr.getX() + (TopicPkView.this.ghE / 2)))));
                    TopicPkView.this.ghC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ghC.setVisibility(4);
                    TopicPkView.this.ghC.setX(TopicPkView.this.ghV);
                    TopicPkView.this.ghC.setY(TopicPkView.this.ghW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.ghp = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.ghq = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.ghr = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.ghs = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.ght = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.ghu = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.ghv = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.ghw = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.ghx = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.ghy = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.ghz = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.ghA = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.ghB = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.ghC = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.ghD = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.ght.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.ghu.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.ghv.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.ghw.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.ghr.setOnClickListener(this);
        this.ghs.setOnClickListener(this);
        this.mHeight = l.g(context, R.dimen.tbds340);
        this.ghL = l.g(context, R.dimen.tbds78);
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
        if (this.gho != null) {
            this.ghE = this.ghr.getWidth();
            this.aNw = this.ghr.getHeight();
            this.bVo = this.ght.getWidth();
            this.ghF = this.ghx.getWidth();
            this.ghG = this.ghy.getWidth();
            this.ghJ = this.ghx.getHeight();
            this.ghH = this.ghA.getWidth();
            this.ghI = this.ghB.getWidth();
            this.bPU = this.ghz.getWidth();
            this.bPT = this.ghz.getHeight();
            this.ghK = ((this.mWidth - (this.ghE * 2)) - this.ghF) - this.ghG;
            this.ghN = this.ghC.getWidth();
            if (this.gho.ggN.ggP == 0 && this.gho.ggO.ggP == 0) {
                this.ghM = (int) ((0.5d * this.ghK) + this.ghF + this.ghE);
            } else {
                this.ghM = (int) (((((float) this.gho.ggN.ggP) / ((float) (this.gho.ggN.ggP + this.gho.ggO.ggP))) * this.ghK) + this.ghF + this.ghE);
            }
            float y = this.ghr.getY() - ((this.bPT - this.aNw) / 2);
            if (this.ghM + (this.bPU / 2) >= this.ghy.getLeft()) {
                this.ghM = (this.ghy.getLeft() - 10) - (this.bPU / 2);
                this.ghz.layout((this.ghy.getLeft() - 10) - this.bPU, (int) y, this.ghy.getLeft() - 10, ((int) y) + this.bPT);
            } else if (this.ghM - (this.bPU / 2) <= this.ghx.getRight()) {
                this.ghM = this.ghx.getRight() + 10 + (this.bPU / 2);
                this.ghz.layout(this.ghx.getRight() + 10, (int) y, this.ghx.getRight() + 10 + this.bPU, ((int) y) + this.bPT);
            } else {
                this.ghz.layout(this.ghM - (this.bPU / 2), (int) y, this.ghM + (this.bPU / 2), ((int) y) + this.bPT);
            }
            int x = (this.mWidth / 2) - ((int) this.ght.getX());
            if (this.ghH < this.bVo) {
                int i5 = (this.ghE - this.ghH) / 2;
                this.ghA.layout(i5, (int) this.ghA.getY(), this.ghH + i5, ((int) this.ghA.getY()) + this.ghJ);
            } else if (this.ghH <= x) {
                this.ghA.layout((int) this.ght.getX(), (int) this.ghA.getY(), ((int) this.ght.getX()) + this.ghH, ((int) this.ghA.getY()) + this.ghJ);
            } else {
                ViewGroup.LayoutParams layoutParams = this.ghA.getLayoutParams();
                layoutParams.width = x;
                this.ghA.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.ghI < this.bVo) {
                int x2 = ((int) this.ghs.getX()) + ((this.ghE - this.ghI) / 2);
                this.ghB.layout(x2, (int) this.ghB.getY(), this.ghI + x2, ((int) this.ghB.getY()) + this.ghJ);
            } else if (this.ghI <= x) {
                this.ghB.layout((this.mWidth - ((int) this.ghu.getX())) - this.ghI, (int) this.ghB.getY(), this.mWidth - ((int) this.ghu.getX()), ((int) this.ghB.getY()) + this.ghJ);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.ghB.getLayoutParams();
                layoutParams2.width = x;
                this.ghB.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.ghE - this.ghN) / 2;
            this.ghC.layout(((int) this.ghr.getX()) + i6, ((int) this.ghr.getY()) + i6, ((int) this.ghr.getX()) + i6 + this.ghN, ((int) this.ghr.getY()) + i6 + this.ghN);
            this.ghD.layout(((int) this.ghs.getX()) + i6, ((int) this.ghs.getY()) + i6, ((int) this.ghs.getX()) + i6 + this.ghN, i6 + ((int) this.ghs.getY()) + this.ghN);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.gho.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        } else if (this.ghP == null || !this.ghP.isRunning()) {
            if (this.ghS == null || !this.ghS.isRunning()) {
                if (this.ghS == null) {
                    this.ghS = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.ghS.setDuration(800L);
                    this.ghS.setInterpolator(new AccelerateInterpolator());
                }
                if (this.ghP == null) {
                    this.ghP = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.ghP.setDuration(800L);
                    this.ghP.setInterpolator(new AccelerateInterpolator());
                    this.ghR = new a();
                    this.ghP.addListener(this.ghR);
                    this.ghP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.ghQ.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.ghQ.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (buR()) {
                    i = 1;
                } else {
                    i = buS() ? 2 : 0;
                }
                if (view == this.ghr) {
                    lk(1 != i);
                    ll(false);
                    i2 = 1;
                } else if (view == this.ghs) {
                    ll(2 != i);
                    lk(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new am("c13352").P("obj_type", i2).l("topic_id", this.gho.topicId).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.gho.from));
                if (this.ghZ != null) {
                    this.ghZ.tK(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.gho.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.gho.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.gho.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.gho != null) {
            N(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void N(Canvas canvas) {
        float y = this.ghr.getY() + ((this.aNw - this.ghL) / 2);
        this.mPaint.setShader(new LinearGradient(this.ghE / 2, y, this.ghM, y, al.getColor(R.color.topic_pk_agree_bar_start_color), al.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.ghE / 2, y, this.ghM, y + this.ghL, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.ghM, y, this.mWidth - (this.ghE / 2), y, al.getColor(R.color.topic_pk_disagree_bar_start_color), al.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.ghM, y, this.mWidth - (this.ghE / 2), y + this.ghL, this.mPaint);
    }

    public void setUserColor(int i) {
        this.ghO = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.ggN == null || bVar.ggO == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gho = bVar;
        this.ghx.setText(String.valueOf(bVar.ggN.ggP));
        this.ghy.setText(String.valueOf(bVar.ggO.ggP));
        this.ghX = new RelativeLayout.LayoutParams(-2, -2);
        this.ghX.addRule(12);
        this.ghY = new RelativeLayout.LayoutParams(-2, -2);
        this.ghY.addRule(12);
        this.ghY.addRule(11);
        this.ghA.setLayoutParams(this.ghX);
        this.ghB.setLayoutParams(this.ghY);
        if (bVar.from == 3) {
            this.ghA.setText(StringUtils.isNull(bVar.ggN.ggQ) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.ggN.ggQ);
            this.ghB.setText(StringUtils.isNull(bVar.ggO.ggQ) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.ggO.ggQ);
            if (StringUtils.isNull(bVar.ggN.ggR)) {
                this.ghp.setVisibility(4);
            } else {
                this.ghp.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggN.ggR));
            }
            if (StringUtils.isNull(bVar.ggO.ggR)) {
                this.ghq.setVisibility(4);
            } else {
                this.ghq.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggO.ggR));
            }
        } else {
            this.ghA.setText(bVar.ggN.ggQ);
            this.ghB.setText(bVar.ggO.ggQ);
            this.ghp.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggN.ggR));
            this.ghq.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggO.ggR));
        }
        this.ght.startLoad(bVar.ggN.ggS, 10, false);
        this.ghu.startLoad(bVar.ggO.ggS, 10, false);
        this.ghv.startLoad(bVar.ggN.ggV, 10, false);
        this.ghw.startLoad(bVar.ggO.ggV, 10, false);
        if (bVar.ggN.ggT) {
            this.ght.setVisibility(4);
            this.ghv.setVisibility(0);
        } else {
            this.ght.setVisibility(0);
            this.ghv.setVisibility(4);
        }
        if (bVar.ggO.ggT) {
            this.ghu.setVisibility(4);
            this.ghw.setVisibility(0);
        } else {
            this.ghu.setVisibility(0);
            this.ghw.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        al.j(this.ghp, this.ghO);
        al.j(this.ghq, this.ghO);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.k(this.ghr, R.drawable.btn_topic_agree_bg_red);
            al.k(this.ghs, R.drawable.btn_topic_disagree_bg_blue);
            this.ght.setIsNight(this.mSkinType == 1);
            this.ghu.setIsNight(this.mSkinType == 1);
            this.ghv.setIsNight(this.mSkinType == 1);
            this.ghw.setIsNight(this.mSkinType == 1);
            al.j(this.ghx, R.color.cp_btn_a);
            al.j(this.ghy, R.color.cp_btn_a);
            al.c(this.ghz, (int) R.drawable.pic_topic_vs_bginone);
            al.j(this.ghA, R.color.topic_agree_des_color);
            al.j(this.ghB, R.color.topic_disagree_des_color);
            al.c(this.ghC, (int) R.drawable.pic_topic_addone);
            al.c(this.ghD, (int) R.drawable.pic_topic_addone);
        }
    }

    private void lk(boolean z) {
        if (z) {
            this.ghp.setVisibility(0);
            this.ghp.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.gho.ggN.ggR = TbadkCoreApplication.getCurrentAccountNameShow();
            this.gho.ggN.ggT = true;
            TextView textView = this.ghx;
            b.a aVar = this.gho.ggN;
            long j = aVar.ggP + 1;
            aVar.ggP = j;
            textView.setText(String.valueOf(j));
            this.ghC.setVisibility(0);
            this.ghQ = this.ghv;
            this.ghR.gic = this.ghv;
            this.ghR.gie = this.ght;
            this.ghC.setVisibility(0);
            this.ghP.start();
            this.ghT = this.ghC.getX();
            this.ghU = this.ghC.getY();
            this.ghV = this.ghC.getX();
            this.ghW = this.ghC.getY();
            this.ghS.removeAllUpdateListeners();
            this.ghS.addUpdateListener(this.gia);
            this.ghS.setFloatValues(0.0f, 2.0f);
            this.ghS.start();
            return;
        }
        if (ap.equals(this.gho.ggN.ggR, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ghp.setVisibility(4);
        }
        if (this.gho.ggN.ggT) {
            this.gho.ggN.ggT = false;
            TextView textView2 = this.ghx;
            b.a aVar2 = this.gho.ggN;
            long j2 = aVar2.ggP - 1;
            aVar2.ggP = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ght.setVisibility(0);
        this.ghv.setVisibility(4);
    }

    private void ll(boolean z) {
        if (z) {
            this.ghq.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.ghq.setVisibility(0);
            this.gho.ggO.ggR = TbadkCoreApplication.getCurrentAccountNameShow();
            this.ghD.setVisibility(0);
            this.gho.ggO.ggT = true;
            TextView textView = this.ghy;
            b.a aVar = this.gho.ggO;
            long j = aVar.ggP + 1;
            aVar.ggP = j;
            textView.setText(String.valueOf(j));
            this.ghT = this.ghD.getX() - (this.ghN / 2.0f);
            this.ghQ = this.ghw;
            this.ghR.gic = this.ghw;
            this.ghR.gie = this.ghu;
            this.ghC.setVisibility(0);
            this.ghP.start();
            this.ghT = this.ghD.getX() - (this.ghN / 2);
            this.ghU = this.ghD.getY();
            this.ghV = this.ghD.getX();
            this.ghW = this.ghD.getY();
            this.ghS.removeAllUpdateListeners();
            this.ghS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.ghD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghT) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.ghE) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ghE / 2)))));
                        TopicPkView.this.ghD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.ghD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ghE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.ghD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.ghD.setVisibility(4);
                        TopicPkView.this.ghD.setX(TopicPkView.this.ghV);
                        TopicPkView.this.ghD.setY(TopicPkView.this.ghW);
                    }
                }
            });
            this.ghS.setFloatValues(0.0f, 2.0f);
            this.ghS.start();
            return;
        }
        if (ap.equals(this.gho.ggO.ggR, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ghq.setVisibility(4);
        }
        if (this.gho.ggO.ggT) {
            this.gho.ggO.ggT = false;
            TextView textView2 = this.ghy;
            b.a aVar2 = this.gho.ggO;
            long j2 = aVar2.ggP - 1;
            aVar2.ggP = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ghD.setVisibility(4);
        this.ghu.setVisibility(0);
        this.ghw.setVisibility(4);
    }

    private boolean buR() {
        return (this.gho == null || this.gho.ggN == null || !this.gho.ggN.ggT) ? false : true;
    }

    private boolean buS() {
        return (this.gho == null || this.gho.ggO == null || !this.gho.ggO.ggT) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.ghP != null) {
            this.ghP.cancel();
        }
        if (this.ghS != null) {
            this.ghS.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.ghZ = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View gic;
        private View gie;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.gic != null) {
                this.gic.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.gie != null) {
                this.gie.setVisibility(8);
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
