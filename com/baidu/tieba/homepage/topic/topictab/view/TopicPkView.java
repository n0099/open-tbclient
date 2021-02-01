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
/* loaded from: classes2.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int dBz;
    private TbImageView kqA;
    private TextView kqB;
    private TextView kqC;
    private ImageView kqD;
    private TextView kqE;
    private TextView kqF;
    private ImageView kqG;
    private ImageView kqH;
    private int kqI;
    private int kqJ;
    private int kqK;
    private int kqL;
    private int kqM;
    private int kqN;
    private int kqO;
    private int kqP;
    private int kqQ;
    private int kqR;
    private int kqS;
    private int kqT;
    private ValueAnimator kqU;
    private View kqV;
    private a kqW;
    private ValueAnimator kqX;
    private double kqY;
    private double kqZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b kqs;
    private TextView kqt;
    private TextView kqu;
    private FrameLayout kqv;
    private FrameLayout kqw;
    private TbImageView kqx;
    private TbImageView kqy;
    private TbImageView kqz;
    private float kra;
    private float krb;
    private RelativeLayout.LayoutParams krc;
    private RelativeLayout.LayoutParams krd;
    private b kre;
    private ValueAnimator.AnimatorUpdateListener krf;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void Ce(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.kqT = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.krf = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kqG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kqY) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kqI - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqv.getX() + (TopicPkView.this.kqI / 2)))));
                    TopicPkView.this.kqG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kqZ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kqG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kqv.getX() + (TopicPkView.this.kqI / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqv.getX() + (TopicPkView.this.kqI / 2)))));
                    TopicPkView.this.kqG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kqG.setVisibility(4);
                    TopicPkView.this.kqG.setX(TopicPkView.this.kra);
                    TopicPkView.this.kqG.setY(TopicPkView.this.krb);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.kqT = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.krf = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kqG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kqY) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kqI - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqv.getX() + (TopicPkView.this.kqI / 2)))));
                    TopicPkView.this.kqG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kqZ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kqG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kqv.getX() + (TopicPkView.this.kqI / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqv.getX() + (TopicPkView.this.kqI / 2)))));
                    TopicPkView.this.kqG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kqG.setVisibility(4);
                    TopicPkView.this.kqG.setX(TopicPkView.this.kra);
                    TopicPkView.this.kqG.setY(TopicPkView.this.krb);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.kqT = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.krf = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kqG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kqY) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kqI - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqv.getX() + (TopicPkView.this.kqI / 2)))));
                    TopicPkView.this.kqG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kqZ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kqG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kqv.getX() + (TopicPkView.this.kqI / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqv.getX() + (TopicPkView.this.kqI / 2)))));
                    TopicPkView.this.kqG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kqG.setVisibility(4);
                    TopicPkView.this.kqG.setX(TopicPkView.this.kra);
                    TopicPkView.this.kqG.setY(TopicPkView.this.krb);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.kqt = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.kqu = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.kqv = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.kqw = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.kqx = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.kqy = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.kqz = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.kqA = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.kqB = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.kqC = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.kqD = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.kqE = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.kqF = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.kqG = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.kqH = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.kqx.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.kqy.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.kqz.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.kqA.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.kqv.setOnClickListener(this);
        this.kqw.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.kqQ = l.getDimens(context, R.dimen.tbds62);
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
        if (this.kqs != null) {
            this.kqI = this.kqv.getWidth();
            this.dBz = this.kqv.getHeight();
            this.kqJ = this.kqx.getWidth();
            this.kqK = this.kqB.getWidth();
            this.kqL = this.kqC.getWidth();
            this.kqO = this.kqB.getHeight();
            this.kqM = this.kqE.getWidth();
            this.kqN = this.kqF.getWidth();
            this.mCursorWidth = this.kqD.getWidth();
            this.mCursorHeight = this.kqD.getHeight();
            this.kqP = ((this.mWidth - (this.kqI * 2)) - this.kqK) - this.kqL;
            this.kqS = this.kqG.getWidth();
            if (this.kqs.kpT.kpV == 0 && this.kqs.kpU.kpV == 0) {
                this.kqR = (int) ((0.5d * this.kqP) + this.kqK + this.kqI);
            } else {
                this.kqR = (int) (((((float) this.kqs.kpT.kpV) / ((float) (this.kqs.kpT.kpV + this.kqs.kpU.kpV))) * this.kqP) + this.kqK + this.kqI);
            }
            float y = this.kqv.getY() - ((this.mCursorHeight - this.dBz) / 2);
            if (this.kqR + (this.mCursorWidth / 2) >= this.kqC.getLeft()) {
                this.kqR = (this.kqC.getLeft() - 10) - (this.mCursorWidth / 2);
                this.kqD.layout((this.kqC.getLeft() - 10) - this.mCursorWidth, (int) y, this.kqC.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.kqR - (this.mCursorWidth / 2) <= this.kqB.getRight()) {
                this.kqR = this.kqB.getRight() + 10 + (this.mCursorWidth / 2);
                this.kqD.layout(this.kqB.getRight() + 10, (int) y, this.kqB.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.kqD.layout(this.kqR - (this.mCursorWidth / 2), (int) y, this.kqR + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.kqx.getX());
            if (this.kqM < this.kqJ) {
                int i5 = (this.kqI - this.kqM) / 2;
                this.kqE.layout(i5, (int) this.kqE.getY(), this.kqM + i5, ((int) this.kqE.getY()) + this.kqO);
            } else if (this.kqM <= x) {
                this.kqE.layout((int) this.kqx.getX(), (int) this.kqE.getY(), ((int) this.kqx.getX()) + this.kqM, ((int) this.kqE.getY()) + this.kqO);
            } else {
                ViewGroup.LayoutParams layoutParams = this.kqE.getLayoutParams();
                layoutParams.width = x;
                this.kqE.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.kqN < this.kqJ) {
                int x2 = ((int) this.kqw.getX()) + ((this.kqI - this.kqN) / 2);
                this.kqF.layout(x2, (int) this.kqF.getY(), this.kqN + x2, ((int) this.kqF.getY()) + this.kqO);
            } else if (this.kqN <= x) {
                this.kqF.layout((this.mWidth - ((int) this.kqy.getX())) - this.kqN, (int) this.kqF.getY(), this.mWidth - ((int) this.kqy.getX()), ((int) this.kqF.getY()) + this.kqO);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.kqF.getLayoutParams();
                layoutParams2.width = x;
                this.kqF.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.kqI - this.kqS) / 2;
            this.kqG.layout(((int) this.kqv.getX()) + i6, ((int) this.kqv.getY()) + i6, ((int) this.kqv.getX()) + i6 + this.kqS, ((int) this.kqv.getY()) + i6 + this.kqS);
            this.kqH.layout(((int) this.kqw.getX()) + i6, ((int) this.kqw.getY()) + i6, ((int) this.kqw.getX()) + i6 + this.kqS, i6 + ((int) this.kqw.getY()) + this.kqS);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.kqs.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.kqU == null || !this.kqU.isRunning()) {
            if (this.kqX == null || !this.kqX.isRunning()) {
                if (this.kqX == null) {
                    this.kqX = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.kqX.setDuration(800L);
                    this.kqX.setInterpolator(new AccelerateInterpolator());
                }
                if (this.kqU == null) {
                    this.kqU = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.kqU.setDuration(800L);
                    this.kqU.setInterpolator(new AccelerateInterpolator());
                    this.kqW = new a();
                    this.kqU.addListener(this.kqW);
                    this.kqU.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.kqV.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.kqV.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cSt()) {
                    i = 1;
                } else {
                    i = cSu() ? 2 : 0;
                }
                if (view == this.kqv) {
                    st(1 != i);
                    su(false);
                    i2 = 1;
                } else if (view == this.kqw) {
                    su(2 != i);
                    st(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new ar("c13352").ap("obj_type", i2).v("topic_id", this.kqs.topicId).ap("obj_source", this.kqs.from));
                if (this.kre != null) {
                    this.kre.Ce(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.kqs.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.kqs.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.kqs.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kqs != null) {
            af(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void af(Canvas canvas) {
        float y = this.kqv.getY() + ((this.dBz - this.kqQ) / 2);
        this.mPaint.setShader(new LinearGradient(this.kqI / 2, y, this.kqR, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.kqI / 2, y, this.kqR, y + this.kqQ, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.kqR, y, this.mWidth - (this.kqI / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.kqR, y, this.mWidth - (this.kqI / 2), y + this.kqQ, this.mPaint);
    }

    public void setUserColor(int i) {
        this.kqT = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.kpT == null || bVar.kpU == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kqs = bVar;
        this.kqB.setText(String.valueOf(bVar.kpT.kpV));
        this.kqC.setText(String.valueOf(bVar.kpU.kpV));
        this.krc = new RelativeLayout.LayoutParams(-2, -2);
        this.krc.addRule(12);
        this.krd = new RelativeLayout.LayoutParams(-2, -2);
        this.krd.addRule(12);
        this.krd.addRule(11);
        this.kqE.setLayoutParams(this.krc);
        this.kqF.setLayoutParams(this.krd);
        if (bVar.from == 3) {
            this.kqE.setText(StringUtils.isNull(bVar.kpT.kpW) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.kpT.kpW);
            this.kqF.setText(StringUtils.isNull(bVar.kpU.kpW) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.kpU.kpW);
            if (StringUtils.isNull(bVar.kpT.kpX)) {
                this.kqt.setVisibility(4);
            } else {
                this.kqt.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kpT.kpX));
            }
            if (StringUtils.isNull(bVar.kpU.kpX)) {
                this.kqu.setVisibility(4);
            } else {
                this.kqu.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kpU.kpX));
            }
        } else {
            this.kqE.setText(bVar.kpT.kpW);
            this.kqF.setText(bVar.kpU.kpW);
            this.kqt.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kpT.kpX));
            this.kqu.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kpU.kpX));
        }
        this.kqx.startLoad(bVar.kpT.kpY, 10, false);
        this.kqy.startLoad(bVar.kpU.kpY, 10, false);
        this.kqz.startLoad(bVar.kpT.kqb, 10, false);
        this.kqA.startLoad(bVar.kpU.kqb, 10, false);
        if (bVar.kpT.kpZ) {
            this.kqx.setVisibility(4);
            this.kqz.setVisibility(0);
        } else {
            this.kqx.setVisibility(0);
            this.kqz.setVisibility(4);
        }
        if (bVar.kpU.kpZ) {
            this.kqy.setVisibility(4);
            this.kqA.setVisibility(0);
        } else {
            this.kqy.setVisibility(0);
            this.kqA.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.kqt, this.kqT);
        ap.setViewTextColor(this.kqu, this.kqT);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.kqx.setIsNight(this.mSkinType == 1);
            this.kqy.setIsNight(this.mSkinType == 1);
            this.kqz.setIsNight(this.mSkinType == 1);
            this.kqA.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.kqv, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.kqw, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.kqG, R.drawable.pic_topic_addone);
            ap.setImageResource(this.kqH, R.drawable.pic_topic_addone);
            ap.setImageResource(this.kqD, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.kqB, R.color.CAM_X0101);
            ap.setViewTextColor(this.kqC, R.color.CAM_X0101);
            ap.setViewTextColor(this.kqE, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.kqF, R.color.topic_disagree_des_color);
        }
    }

    private void st(boolean z) {
        if (z) {
            this.kqt.setVisibility(0);
            this.kqt.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.kqs.kpT.kpX = TbadkCoreApplication.getCurrentAccountNameShow();
            this.kqs.kpT.kpZ = true;
            TextView textView = this.kqB;
            b.a aVar = this.kqs.kpT;
            long j = aVar.kpV + 1;
            aVar.kpV = j;
            textView.setText(String.valueOf(j));
            this.kqG.setVisibility(0);
            this.kqV = this.kqz;
            this.kqW.krh = this.kqz;
            this.kqW.kri = this.kqx;
            this.kqG.setVisibility(0);
            this.kqU.start();
            this.kqY = this.kqG.getX();
            this.kqZ = this.kqG.getY();
            this.kra = this.kqG.getX();
            this.krb = this.kqG.getY();
            this.kqX.removeAllUpdateListeners();
            this.kqX.addUpdateListener(this.krf);
            this.kqX.setFloatValues(0.0f, 2.0f);
            this.kqX.start();
            return;
        }
        if (au.equals(this.kqs.kpT.kpX, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.kqt.setVisibility(4);
        }
        if (this.kqs.kpT.kpZ) {
            this.kqs.kpT.kpZ = false;
            TextView textView2 = this.kqB;
            b.a aVar2 = this.kqs.kpT;
            long j2 = aVar2.kpV - 1;
            aVar2.kpV = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.kqx.setVisibility(0);
        this.kqz.setVisibility(4);
    }

    private void su(boolean z) {
        if (z) {
            this.kqu.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.kqu.setVisibility(0);
            this.kqs.kpU.kpX = TbadkCoreApplication.getCurrentAccountNameShow();
            this.kqH.setVisibility(0);
            this.kqs.kpU.kpZ = true;
            TextView textView = this.kqC;
            b.a aVar = this.kqs.kpU;
            long j = aVar.kpV + 1;
            aVar.kpV = j;
            textView.setText(String.valueOf(j));
            this.kqY = this.kqH.getX() - (this.kqS / 2.0f);
            this.kqV = this.kqA;
            this.kqW.krh = this.kqA;
            this.kqW.kri = this.kqy;
            this.kqG.setVisibility(0);
            this.kqU.start();
            this.kqY = this.kqH.getX() - (this.kqS / 2);
            this.kqZ = this.kqH.getY();
            this.kra = this.kqH.getX();
            this.krb = this.kqH.getY();
            this.kqX.removeAllUpdateListeners();
            this.kqX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.kqH.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kqY) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.kqI) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.kqI / 2)))));
                        TopicPkView.this.kqH.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kqZ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.kqH.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.kqI / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.kqH.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.kqH.setVisibility(4);
                        TopicPkView.this.kqH.setX(TopicPkView.this.kra);
                        TopicPkView.this.kqH.setY(TopicPkView.this.krb);
                    }
                }
            });
            this.kqX.setFloatValues(0.0f, 2.0f);
            this.kqX.start();
            return;
        }
        if (au.equals(this.kqs.kpU.kpX, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.kqu.setVisibility(4);
        }
        if (this.kqs.kpU.kpZ) {
            this.kqs.kpU.kpZ = false;
            TextView textView2 = this.kqC;
            b.a aVar2 = this.kqs.kpU;
            long j2 = aVar2.kpV - 1;
            aVar2.kpV = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.kqH.setVisibility(4);
        this.kqy.setVisibility(0);
        this.kqA.setVisibility(4);
    }

    private boolean cSt() {
        return (this.kqs == null || this.kqs.kpT == null || !this.kqs.kpT.kpZ) ? false : true;
    }

    private boolean cSu() {
        return (this.kqs == null || this.kqs.kpU == null || !this.kqs.kpU.kpZ) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.kqU != null) {
            this.kqU.cancel();
        }
        if (this.kqX != null) {
            this.kqX.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.kre = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Animator.AnimatorListener {
        private View krh;
        private View kri;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.krh != null) {
                this.krh.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.kri != null) {
                this.kri.setVisibility(8);
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
