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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes4.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int aOD;
    private int bRB;
    private int bRC;
    private int bXp;
    private TextView gqA;
    private ImageView gqB;
    private ImageView gqC;
    private int gqD;
    private int gqE;
    private int gqF;
    private int gqG;
    private int gqH;
    private int gqI;
    private int gqJ;
    private int gqK;
    private int gqL;
    private int gqM;
    private int gqN;
    private ValueAnimator gqO;
    private View gqP;
    private a gqQ;
    private ValueAnimator gqR;
    private double gqS;
    private double gqT;
    private float gqU;
    private float gqV;
    private RelativeLayout.LayoutParams gqW;
    private RelativeLayout.LayoutParams gqX;
    private b gqY;
    private ValueAnimator.AnimatorUpdateListener gqZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b gqn;
    private TextView gqo;
    private TextView gqp;
    private FrameLayout gqq;
    private FrameLayout gqr;
    private TbImageView gqs;
    private TbImageView gqt;
    private TbImageView gqu;
    private TbImageView gqv;
    private TextView gqw;
    private TextView gqx;
    private ImageView gqy;
    private TextView gqz;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void uo(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gqN = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gqZ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gqB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqS) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gqD - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gqq.getX() + (TopicPkView.this.gqD / 2)))));
                    TopicPkView.this.gqB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqT) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gqB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.gqq.getX() + (TopicPkView.this.gqD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gqq.getX() + (TopicPkView.this.gqD / 2)))));
                    TopicPkView.this.gqB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gqB.setVisibility(4);
                    TopicPkView.this.gqB.setX(TopicPkView.this.gqU);
                    TopicPkView.this.gqB.setY(TopicPkView.this.gqV);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gqN = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gqZ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gqB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqS) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gqD - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gqq.getX() + (TopicPkView.this.gqD / 2)))));
                    TopicPkView.this.gqB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqT) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gqB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.gqq.getX() + (TopicPkView.this.gqD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gqq.getX() + (TopicPkView.this.gqD / 2)))));
                    TopicPkView.this.gqB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gqB.setVisibility(4);
                    TopicPkView.this.gqB.setX(TopicPkView.this.gqU);
                    TopicPkView.this.gqB.setY(TopicPkView.this.gqV);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gqN = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gqZ = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gqB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqS) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gqD - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gqq.getX() + (TopicPkView.this.gqD / 2)))));
                    TopicPkView.this.gqB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqT) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gqB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.gqq.getX() + (TopicPkView.this.gqD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gqq.getX() + (TopicPkView.this.gqD / 2)))));
                    TopicPkView.this.gqB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gqB.setVisibility(4);
                    TopicPkView.this.gqB.setX(TopicPkView.this.gqU);
                    TopicPkView.this.gqB.setY(TopicPkView.this.gqV);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.gqo = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.gqp = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.gqq = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.gqr = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.gqs = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.gqt = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.gqu = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.gqv = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.gqw = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.gqx = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.gqy = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.gqz = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.gqA = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.gqB = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.gqC = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.gqs.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.gqt.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.gqu.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.gqv.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.gqq.setOnClickListener(this);
        this.gqr.setOnClickListener(this);
        this.mHeight = l.g(context, R.dimen.tbds340);
        this.gqK = l.g(context, R.dimen.tbds78);
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
        if (this.gqn != null) {
            this.gqD = this.gqq.getWidth();
            this.aOD = this.gqq.getHeight();
            this.bXp = this.gqs.getWidth();
            this.gqE = this.gqw.getWidth();
            this.gqF = this.gqx.getWidth();
            this.gqI = this.gqw.getHeight();
            this.gqG = this.gqz.getWidth();
            this.gqH = this.gqA.getWidth();
            this.bRC = this.gqy.getWidth();
            this.bRB = this.gqy.getHeight();
            this.gqJ = ((this.mWidth - (this.gqD * 2)) - this.gqE) - this.gqF;
            this.gqM = this.gqB.getWidth();
            if (this.gqn.gpM.gpO == 0 && this.gqn.gpN.gpO == 0) {
                this.gqL = (int) ((0.5d * this.gqJ) + this.gqE + this.gqD);
            } else {
                this.gqL = (int) (((((float) this.gqn.gpM.gpO) / ((float) (this.gqn.gpM.gpO + this.gqn.gpN.gpO))) * this.gqJ) + this.gqE + this.gqD);
            }
            float y = this.gqq.getY() - ((this.bRB - this.aOD) / 2);
            if (this.gqL + (this.bRC / 2) >= this.gqx.getLeft()) {
                this.gqL = (this.gqx.getLeft() - 10) - (this.bRC / 2);
                this.gqy.layout((this.gqx.getLeft() - 10) - this.bRC, (int) y, this.gqx.getLeft() - 10, ((int) y) + this.bRB);
            } else if (this.gqL - (this.bRC / 2) <= this.gqw.getRight()) {
                this.gqL = this.gqw.getRight() + 10 + (this.bRC / 2);
                this.gqy.layout(this.gqw.getRight() + 10, (int) y, this.gqw.getRight() + 10 + this.bRC, ((int) y) + this.bRB);
            } else {
                this.gqy.layout(this.gqL - (this.bRC / 2), (int) y, this.gqL + (this.bRC / 2), ((int) y) + this.bRB);
            }
            int x = (this.mWidth / 2) - ((int) this.gqs.getX());
            if (this.gqG < this.bXp) {
                int i5 = (this.gqD - this.gqG) / 2;
                this.gqz.layout(i5, (int) this.gqz.getY(), this.gqG + i5, ((int) this.gqz.getY()) + this.gqI);
            } else if (this.gqG <= x) {
                this.gqz.layout((int) this.gqs.getX(), (int) this.gqz.getY(), ((int) this.gqs.getX()) + this.gqG, ((int) this.gqz.getY()) + this.gqI);
            } else {
                ViewGroup.LayoutParams layoutParams = this.gqz.getLayoutParams();
                layoutParams.width = x;
                this.gqz.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.gqH < this.bXp) {
                int x2 = ((int) this.gqr.getX()) + ((this.gqD - this.gqH) / 2);
                this.gqA.layout(x2, (int) this.gqA.getY(), this.gqH + x2, ((int) this.gqA.getY()) + this.gqI);
            } else if (this.gqH <= x) {
                this.gqA.layout((this.mWidth - ((int) this.gqt.getX())) - this.gqH, (int) this.gqA.getY(), this.mWidth - ((int) this.gqt.getX()), ((int) this.gqA.getY()) + this.gqI);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.gqA.getLayoutParams();
                layoutParams2.width = x;
                this.gqA.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.gqD - this.gqM) / 2;
            this.gqB.layout(((int) this.gqq.getX()) + i6, ((int) this.gqq.getY()) + i6, ((int) this.gqq.getX()) + i6 + this.gqM, ((int) this.gqq.getY()) + i6 + this.gqM);
            this.gqC.layout(((int) this.gqr.getX()) + i6, ((int) this.gqr.getY()) + i6, ((int) this.gqr.getX()) + i6 + this.gqM, i6 + ((int) this.gqr.getY()) + this.gqM);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.gqn.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        } else if (this.gqO == null || !this.gqO.isRunning()) {
            if (this.gqR == null || !this.gqR.isRunning()) {
                if (this.gqR == null) {
                    this.gqR = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.gqR.setDuration(800L);
                    this.gqR.setInterpolator(new AccelerateInterpolator());
                }
                if (this.gqO == null) {
                    this.gqO = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.gqO.setDuration(800L);
                    this.gqO.setInterpolator(new AccelerateInterpolator());
                    this.gqQ = new a();
                    this.gqO.addListener(this.gqQ);
                    this.gqO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.gqP.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.gqP.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (byC()) {
                    i = 1;
                } else {
                    i = byD() ? 2 : 0;
                }
                if (view == this.gqq) {
                    lC(1 != i);
                    lD(false);
                    i2 = 1;
                } else if (view == this.gqr) {
                    lD(2 != i);
                    lC(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").P("obj_type", i2).n("topic_id", this.gqn.topicId).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.gqn.from));
                if (this.gqY != null) {
                    this.gqY.uo(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.gqn.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.gqn.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.gqn.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.gqn != null) {
            P(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void P(Canvas canvas) {
        float y = this.gqq.getY() + ((this.aOD - this.gqK) / 2);
        this.mPaint.setShader(new LinearGradient(this.gqD / 2, y, this.gqL, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.gqD / 2, y, this.gqL, y + this.gqK, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.gqL, y, this.mWidth - (this.gqD / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.gqL, y, this.mWidth - (this.gqD / 2), y + this.gqK, this.mPaint);
    }

    public void setUserColor(int i) {
        this.gqN = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.gpM == null || bVar.gpN == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gqn = bVar;
        this.gqw.setText(String.valueOf(bVar.gpM.gpO));
        this.gqx.setText(String.valueOf(bVar.gpN.gpO));
        this.gqW = new RelativeLayout.LayoutParams(-2, -2);
        this.gqW.addRule(12);
        this.gqX = new RelativeLayout.LayoutParams(-2, -2);
        this.gqX.addRule(12);
        this.gqX.addRule(11);
        this.gqz.setLayoutParams(this.gqW);
        this.gqA.setLayoutParams(this.gqX);
        if (bVar.from == 3) {
            this.gqz.setText(StringUtils.isNull(bVar.gpM.gpP) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.gpM.gpP);
            this.gqA.setText(StringUtils.isNull(bVar.gpN.gpP) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.gpN.gpP);
            if (StringUtils.isNull(bVar.gpM.gpQ)) {
                this.gqo.setVisibility(4);
            } else {
                this.gqo.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gpM.gpQ));
            }
            if (StringUtils.isNull(bVar.gpN.gpQ)) {
                this.gqp.setVisibility(4);
            } else {
                this.gqp.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gpN.gpQ));
            }
        } else {
            this.gqz.setText(bVar.gpM.gpP);
            this.gqA.setText(bVar.gpN.gpP);
            this.gqo.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gpM.gpQ));
            this.gqp.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gpN.gpQ));
        }
        this.gqs.startLoad(bVar.gpM.gpR, 10, false);
        this.gqt.startLoad(bVar.gpN.gpR, 10, false);
        this.gqu.startLoad(bVar.gpM.gpU, 10, false);
        this.gqv.startLoad(bVar.gpN.gpU, 10, false);
        if (bVar.gpM.gpS) {
            this.gqs.setVisibility(4);
            this.gqu.setVisibility(0);
        } else {
            this.gqs.setVisibility(0);
            this.gqu.setVisibility(4);
        }
        if (bVar.gpN.gpS) {
            this.gqt.setVisibility(4);
            this.gqv.setVisibility(0);
        } else {
            this.gqt.setVisibility(0);
            this.gqv.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.j(this.gqo, this.gqN);
        am.j(this.gqp, this.gqN);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.k(this.gqq, R.drawable.btn_topic_agree_bg_red);
            am.k(this.gqr, R.drawable.btn_topic_disagree_bg_blue);
            this.gqs.setIsNight(this.mSkinType == 1);
            this.gqt.setIsNight(this.mSkinType == 1);
            this.gqu.setIsNight(this.mSkinType == 1);
            this.gqv.setIsNight(this.mSkinType == 1);
            am.j(this.gqw, R.color.cp_cont_a);
            am.j(this.gqx, R.color.cp_cont_a);
            am.c(this.gqy, (int) R.drawable.pic_topic_vs_bginone);
            am.j(this.gqz, R.color.topic_agree_des_color);
            am.j(this.gqA, R.color.topic_disagree_des_color);
            am.c(this.gqB, (int) R.drawable.pic_topic_addone);
            am.c(this.gqC, (int) R.drawable.pic_topic_addone);
        }
    }

    private void lC(boolean z) {
        if (z) {
            this.gqo.setVisibility(0);
            this.gqo.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.gqn.gpM.gpQ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.gqn.gpM.gpS = true;
            TextView textView = this.gqw;
            b.a aVar = this.gqn.gpM;
            long j = aVar.gpO + 1;
            aVar.gpO = j;
            textView.setText(String.valueOf(j));
            this.gqB.setVisibility(0);
            this.gqP = this.gqu;
            this.gqQ.grb = this.gqu;
            this.gqQ.grc = this.gqs;
            this.gqB.setVisibility(0);
            this.gqO.start();
            this.gqS = this.gqB.getX();
            this.gqT = this.gqB.getY();
            this.gqU = this.gqB.getX();
            this.gqV = this.gqB.getY();
            this.gqR.removeAllUpdateListeners();
            this.gqR.addUpdateListener(this.gqZ);
            this.gqR.setFloatValues(0.0f, 2.0f);
            this.gqR.start();
            return;
        }
        if (aq.bV(this.gqn.gpM.gpQ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.gqo.setVisibility(4);
        }
        if (this.gqn.gpM.gpS) {
            this.gqn.gpM.gpS = false;
            TextView textView2 = this.gqw;
            b.a aVar2 = this.gqn.gpM;
            long j2 = aVar2.gpO - 1;
            aVar2.gpO = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.gqs.setVisibility(0);
        this.gqu.setVisibility(4);
    }

    private void lD(boolean z) {
        if (z) {
            this.gqp.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.gqp.setVisibility(0);
            this.gqn.gpN.gpQ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.gqC.setVisibility(0);
            this.gqn.gpN.gpS = true;
            TextView textView = this.gqx;
            b.a aVar = this.gqn.gpN;
            long j = aVar.gpO + 1;
            aVar.gpO = j;
            textView.setText(String.valueOf(j));
            this.gqS = this.gqC.getX() - (this.gqM / 2.0f);
            this.gqP = this.gqv;
            this.gqQ.grb = this.gqv;
            this.gqQ.grc = this.gqt;
            this.gqB.setVisibility(0);
            this.gqO.start();
            this.gqS = this.gqC.getX() - (this.gqM / 2);
            this.gqT = this.gqC.getY();
            this.gqU = this.gqC.getX();
            this.gqV = this.gqC.getY();
            this.gqR.removeAllUpdateListeners();
            this.gqR.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.gqC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqS) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.gqD) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.gqD / 2)))));
                        TopicPkView.this.gqC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqT) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.gqC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.gqD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.gqC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.gqC.setVisibility(4);
                        TopicPkView.this.gqC.setX(TopicPkView.this.gqU);
                        TopicPkView.this.gqC.setY(TopicPkView.this.gqV);
                    }
                }
            });
            this.gqR.setFloatValues(0.0f, 2.0f);
            this.gqR.start();
            return;
        }
        if (aq.bV(this.gqn.gpN.gpQ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.gqp.setVisibility(4);
        }
        if (this.gqn.gpN.gpS) {
            this.gqn.gpN.gpS = false;
            TextView textView2 = this.gqx;
            b.a aVar2 = this.gqn.gpN;
            long j2 = aVar2.gpO - 1;
            aVar2.gpO = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.gqC.setVisibility(4);
        this.gqt.setVisibility(0);
        this.gqv.setVisibility(4);
    }

    private boolean byC() {
        return (this.gqn == null || this.gqn.gpM == null || !this.gqn.gpM.gpS) ? false : true;
    }

    private boolean byD() {
        return (this.gqn == null || this.gqn.gpN == null || !this.gqn.gpN.gpS) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gqO != null) {
            this.gqO.cancel();
        }
        if (this.gqR != null) {
            this.gqR.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.gqY = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View grb;
        private View grc;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.grb != null) {
                this.grb.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.grc != null) {
                this.grc.setVisibility(8);
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
