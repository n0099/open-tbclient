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
/* loaded from: classes21.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private com.baidu.tieba.homepage.topic.topictab.b.b jdT;
    private TextView jdU;
    private TextView jdV;
    private FrameLayout jdW;
    private FrameLayout jdX;
    private TbImageView jdY;
    private TbImageView jdZ;
    private double jeA;
    private float jeB;
    private float jeC;
    private RelativeLayout.LayoutParams jeD;
    private RelativeLayout.LayoutParams jeE;
    private b jeF;
    private ValueAnimator.AnimatorUpdateListener jeG;
    private TbImageView jea;
    private TbImageView jeb;
    private TextView jec;
    private TextView jed;
    private ImageView jee;
    private TextView jef;
    private TextView jeg;
    private ImageView jeh;
    private ImageView jei;
    private int jej;
    private int jek;
    private int jel;
    private int jem;
    private int jen;
    private int jeo;
    private int jep;
    private int jeq;
    private int jer;
    private int jes;
    private int jet;
    private int jeu;
    private ValueAnimator jev;
    private View jew;
    private a jex;
    private ValueAnimator jey;
    private double jez;
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
        void AG(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jeu = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jeG = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jeh.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jez) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jej - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jdW.getX() + (TopicPkView.this.jej / 2)))));
                    TopicPkView.this.jeh.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jeA) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jeh.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jdW.getX() + (TopicPkView.this.jej / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jdW.getX() + (TopicPkView.this.jej / 2)))));
                    TopicPkView.this.jeh.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jeh.setVisibility(4);
                    TopicPkView.this.jeh.setX(TopicPkView.this.jeB);
                    TopicPkView.this.jeh.setY(TopicPkView.this.jeC);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.jeu = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jeG = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jeh.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jez) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jej - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jdW.getX() + (TopicPkView.this.jej / 2)))));
                    TopicPkView.this.jeh.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jeA) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jeh.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jdW.getX() + (TopicPkView.this.jej / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jdW.getX() + (TopicPkView.this.jej / 2)))));
                    TopicPkView.this.jeh.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jeh.setVisibility(4);
                    TopicPkView.this.jeh.setX(TopicPkView.this.jeB);
                    TopicPkView.this.jeh.setY(TopicPkView.this.jeC);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.jeu = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jeG = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jeh.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jez) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jej - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jdW.getX() + (TopicPkView.this.jej / 2)))));
                    TopicPkView.this.jeh.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jeA) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jeh.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jdW.getX() + (TopicPkView.this.jej / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jdW.getX() + (TopicPkView.this.jej / 2)))));
                    TopicPkView.this.jeh.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jeh.setVisibility(4);
                    TopicPkView.this.jeh.setX(TopicPkView.this.jeB);
                    TopicPkView.this.jeh.setY(TopicPkView.this.jeC);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.jdU = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.jdV = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.jdW = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.jdX = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.jdY = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.jdZ = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.jea = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.jeb = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.jec = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.jed = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.jee = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.jef = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.jeg = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.jeh = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.jei = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.jdY.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.jdZ.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.jea.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.jeb.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.jdW.setOnClickListener(this);
        this.jdX.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.jer = l.getDimens(context, R.dimen.tbds62);
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
        if (this.jdT != null) {
            this.jej = this.jdW.getWidth();
            this.mBtnHeight = this.jdW.getHeight();
            this.jek = this.jdY.getWidth();
            this.jel = this.jec.getWidth();
            this.jem = this.jed.getWidth();
            this.jep = this.jec.getHeight();
            this.jen = this.jef.getWidth();
            this.jeo = this.jeg.getWidth();
            this.mCursorWidth = this.jee.getWidth();
            this.mCursorHeight = this.jee.getHeight();
            this.jeq = ((this.mWidth - (this.jej * 2)) - this.jel) - this.jem;
            this.jet = this.jeh.getWidth();
            if (this.jdT.jdt.jdv == 0 && this.jdT.jdu.jdv == 0) {
                this.jes = (int) ((0.5d * this.jeq) + this.jel + this.jej);
            } else {
                this.jes = (int) (((((float) this.jdT.jdt.jdv) / ((float) (this.jdT.jdt.jdv + this.jdT.jdu.jdv))) * this.jeq) + this.jel + this.jej);
            }
            float y = this.jdW.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.jes + (this.mCursorWidth / 2) >= this.jed.getLeft()) {
                this.jes = (this.jed.getLeft() - 10) - (this.mCursorWidth / 2);
                this.jee.layout((this.jed.getLeft() - 10) - this.mCursorWidth, (int) y, this.jed.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.jes - (this.mCursorWidth / 2) <= this.jec.getRight()) {
                this.jes = this.jec.getRight() + 10 + (this.mCursorWidth / 2);
                this.jee.layout(this.jec.getRight() + 10, (int) y, this.jec.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.jee.layout(this.jes - (this.mCursorWidth / 2), (int) y, this.jes + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.jdY.getX());
            if (this.jen < this.jek) {
                int i5 = (this.jej - this.jen) / 2;
                this.jef.layout(i5, (int) this.jef.getY(), this.jen + i5, ((int) this.jef.getY()) + this.jep);
            } else if (this.jen <= x) {
                this.jef.layout((int) this.jdY.getX(), (int) this.jef.getY(), ((int) this.jdY.getX()) + this.jen, ((int) this.jef.getY()) + this.jep);
            } else {
                ViewGroup.LayoutParams layoutParams = this.jef.getLayoutParams();
                layoutParams.width = x;
                this.jef.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.jeo < this.jek) {
                int x2 = ((int) this.jdX.getX()) + ((this.jej - this.jeo) / 2);
                this.jeg.layout(x2, (int) this.jeg.getY(), this.jeo + x2, ((int) this.jeg.getY()) + this.jep);
            } else if (this.jeo <= x) {
                this.jeg.layout((this.mWidth - ((int) this.jdZ.getX())) - this.jeo, (int) this.jeg.getY(), this.mWidth - ((int) this.jdZ.getX()), ((int) this.jeg.getY()) + this.jep);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.jeg.getLayoutParams();
                layoutParams2.width = x;
                this.jeg.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.jej - this.jet) / 2;
            this.jeh.layout(((int) this.jdW.getX()) + i6, ((int) this.jdW.getY()) + i6, ((int) this.jdW.getX()) + i6 + this.jet, ((int) this.jdW.getY()) + i6 + this.jet);
            this.jei.layout(((int) this.jdX.getX()) + i6, ((int) this.jdX.getY()) + i6, ((int) this.jdX.getX()) + i6 + this.jet, i6 + ((int) this.jdX.getY()) + this.jet);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.jdT.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.jev == null || !this.jev.isRunning()) {
            if (this.jey == null || !this.jey.isRunning()) {
                if (this.jey == null) {
                    this.jey = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.jey.setDuration(800L);
                    this.jey.setInterpolator(new AccelerateInterpolator());
                }
                if (this.jev == null) {
                    this.jev = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.jev.setDuration(800L);
                    this.jev.setInterpolator(new AccelerateInterpolator());
                    this.jex = new a();
                    this.jev.addListener(this.jex);
                    this.jev.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.jew.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.jew.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cCS()) {
                    i = 1;
                } else {
                    i = cCT() ? 2 : 0;
                }
                if (view == this.jdW) {
                    qb(1 != i);
                    qc(false);
                    i2 = 1;
                } else if (view == this.jdX) {
                    qc(2 != i);
                    qb(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new aq("c13352").ai("obj_type", i2).u("topic_id", this.jdT.topicId).ai("obj_source", this.jdT.from));
                if (this.jeF != null) {
                    this.jeF.AG(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.jdT.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.jdT.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.jdT.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jdT != null) {
            V(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void V(Canvas canvas) {
        float y = this.jdW.getY() + ((this.mBtnHeight - this.jer) / 2);
        this.mPaint.setShader(new LinearGradient(this.jej / 2, y, this.jes, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jej / 2, y, this.jes, y + this.jer, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.jes, y, this.mWidth - (this.jej / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jes, y, this.mWidth - (this.jej / 2), y + this.jer, this.mPaint);
    }

    public void setUserColor(int i) {
        this.jeu = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.jdt == null || bVar.jdu == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jdT = bVar;
        this.jec.setText(String.valueOf(bVar.jdt.jdv));
        this.jed.setText(String.valueOf(bVar.jdu.jdv));
        this.jeD = new RelativeLayout.LayoutParams(-2, -2);
        this.jeD.addRule(12);
        this.jeE = new RelativeLayout.LayoutParams(-2, -2);
        this.jeE.addRule(12);
        this.jeE.addRule(11);
        this.jef.setLayoutParams(this.jeD);
        this.jeg.setLayoutParams(this.jeE);
        if (bVar.from == 3) {
            this.jef.setText(StringUtils.isNull(bVar.jdt.jdw) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.jdt.jdw);
            this.jeg.setText(StringUtils.isNull(bVar.jdu.jdw) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.jdu.jdw);
            if (StringUtils.isNull(bVar.jdt.jdx)) {
                this.jdU.setVisibility(4);
            } else {
                this.jdU.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jdt.jdx));
            }
            if (StringUtils.isNull(bVar.jdu.jdx)) {
                this.jdV.setVisibility(4);
            } else {
                this.jdV.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jdu.jdx));
            }
        } else {
            this.jef.setText(bVar.jdt.jdw);
            this.jeg.setText(bVar.jdu.jdw);
            this.jdU.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jdt.jdx));
            this.jdV.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jdu.jdx));
        }
        this.jdY.startLoad(bVar.jdt.jdy, 10, false);
        this.jdZ.startLoad(bVar.jdu.jdy, 10, false);
        this.jea.startLoad(bVar.jdt.jdB, 10, false);
        this.jeb.startLoad(bVar.jdu.jdB, 10, false);
        if (bVar.jdt.jdz) {
            this.jdY.setVisibility(4);
            this.jea.setVisibility(0);
        } else {
            this.jdY.setVisibility(0);
            this.jea.setVisibility(4);
        }
        if (bVar.jdu.jdz) {
            this.jdZ.setVisibility(4);
            this.jeb.setVisibility(0);
        } else {
            this.jdZ.setVisibility(0);
            this.jeb.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jdU, this.jeu);
        ap.setViewTextColor(this.jdV, this.jeu);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.jdY.setIsNight(this.mSkinType == 1);
            this.jdZ.setIsNight(this.mSkinType == 1);
            this.jea.setIsNight(this.mSkinType == 1);
            this.jeb.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.jdW, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.jdX, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.jeh, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jei, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jee, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.jec, R.color.cp_cont_a);
            ap.setViewTextColor(this.jed, R.color.cp_cont_a);
            ap.setViewTextColor(this.jef, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.jeg, R.color.topic_disagree_des_color);
        }
    }

    private void qb(boolean z) {
        if (z) {
            this.jdU.setVisibility(0);
            this.jdU.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jdT.jdt.jdx = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jdT.jdt.jdz = true;
            TextView textView = this.jec;
            b.a aVar = this.jdT.jdt;
            long j = aVar.jdv + 1;
            aVar.jdv = j;
            textView.setText(String.valueOf(j));
            this.jeh.setVisibility(0);
            this.jew = this.jea;
            this.jex.jeI = this.jea;
            this.jex.jeJ = this.jdY;
            this.jeh.setVisibility(0);
            this.jev.start();
            this.jez = this.jeh.getX();
            this.jeA = this.jeh.getY();
            this.jeB = this.jeh.getX();
            this.jeC = this.jeh.getY();
            this.jey.removeAllUpdateListeners();
            this.jey.addUpdateListener(this.jeG);
            this.jey.setFloatValues(0.0f, 2.0f);
            this.jey.start();
            return;
        }
        if (at.equals(this.jdT.jdt.jdx, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jdU.setVisibility(4);
        }
        if (this.jdT.jdt.jdz) {
            this.jdT.jdt.jdz = false;
            TextView textView2 = this.jec;
            b.a aVar2 = this.jdT.jdt;
            long j2 = aVar2.jdv - 1;
            aVar2.jdv = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jdY.setVisibility(0);
        this.jea.setVisibility(4);
    }

    private void qc(boolean z) {
        if (z) {
            this.jdV.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jdV.setVisibility(0);
            this.jdT.jdu.jdx = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jei.setVisibility(0);
            this.jdT.jdu.jdz = true;
            TextView textView = this.jed;
            b.a aVar = this.jdT.jdu;
            long j = aVar.jdv + 1;
            aVar.jdv = j;
            textView.setText(String.valueOf(j));
            this.jez = this.jei.getX() - (this.jet / 2.0f);
            this.jew = this.jeb;
            this.jex.jeI = this.jeb;
            this.jex.jeJ = this.jdZ;
            this.jeh.setVisibility(0);
            this.jev.start();
            this.jez = this.jei.getX() - (this.jet / 2);
            this.jeA = this.jei.getY();
            this.jeB = this.jei.getX();
            this.jeC = this.jei.getY();
            this.jey.removeAllUpdateListeners();
            this.jey.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.jei.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jez) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.jej) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jej / 2)))));
                        TopicPkView.this.jei.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jeA) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.jei.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jej / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.jei.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.jei.setVisibility(4);
                        TopicPkView.this.jei.setX(TopicPkView.this.jeB);
                        TopicPkView.this.jei.setY(TopicPkView.this.jeC);
                    }
                }
            });
            this.jey.setFloatValues(0.0f, 2.0f);
            this.jey.start();
            return;
        }
        if (at.equals(this.jdT.jdu.jdx, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jdV.setVisibility(4);
        }
        if (this.jdT.jdu.jdz) {
            this.jdT.jdu.jdz = false;
            TextView textView2 = this.jed;
            b.a aVar2 = this.jdT.jdu;
            long j2 = aVar2.jdv - 1;
            aVar2.jdv = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jei.setVisibility(4);
        this.jdZ.setVisibility(0);
        this.jeb.setVisibility(4);
    }

    private boolean cCS() {
        return (this.jdT == null || this.jdT.jdt == null || !this.jdT.jdt.jdz) ? false : true;
    }

    private boolean cCT() {
        return (this.jdT == null || this.jdT.jdu == null || !this.jdT.jdu.jdz) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.jev != null) {
            this.jev.cancel();
        }
        if (this.jey != null) {
            this.jey.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.jeF = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes21.dex */
    public static class a implements Animator.AnimatorListener {
        private View jeI;
        private View jeJ;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.jeI != null) {
                this.jeI.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.jeJ != null) {
                this.jeJ.setVisibility(8);
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
