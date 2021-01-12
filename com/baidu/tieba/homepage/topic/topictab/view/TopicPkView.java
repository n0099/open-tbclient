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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes2.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int dzu;
    private ImageView kiA;
    private int kiB;
    private int kiC;
    private int kiD;
    private int kiE;
    private int kiF;
    private int kiG;
    private int kiH;
    private int kiI;
    private int kiJ;
    private int kiK;
    private int kiL;
    private int kiM;
    private ValueAnimator kiN;
    private View kiO;
    private a kiP;
    private ValueAnimator kiQ;
    private double kiR;
    private double kiS;
    private float kiT;
    private float kiU;
    private RelativeLayout.LayoutParams kiV;
    private RelativeLayout.LayoutParams kiW;
    private b kiX;
    private ValueAnimator.AnimatorUpdateListener kiY;
    private com.baidu.tieba.homepage.topic.topictab.b.b kil;
    private TextView kim;
    private TextView kin;
    private FrameLayout kio;
    private FrameLayout kip;
    private TbImageView kiq;
    private TbImageView kir;
    private TbImageView kis;
    private TbImageView kit;
    private TextView kiu;
    private TextView kiv;
    private ImageView kiw;
    private TextView kix;
    private TextView kiy;
    private ImageView kiz;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void BN(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.kiM = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.kiY = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kiz.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kiR) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kiB - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kio.getX() + (TopicPkView.this.kiB / 2)))));
                    TopicPkView.this.kiz.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kiS) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kiz.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kio.getX() + (TopicPkView.this.kiB / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kio.getX() + (TopicPkView.this.kiB / 2)))));
                    TopicPkView.this.kiz.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kiz.setVisibility(4);
                    TopicPkView.this.kiz.setX(TopicPkView.this.kiT);
                    TopicPkView.this.kiz.setY(TopicPkView.this.kiU);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.kiM = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.kiY = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kiz.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kiR) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kiB - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kio.getX() + (TopicPkView.this.kiB / 2)))));
                    TopicPkView.this.kiz.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kiS) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kiz.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kio.getX() + (TopicPkView.this.kiB / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kio.getX() + (TopicPkView.this.kiB / 2)))));
                    TopicPkView.this.kiz.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kiz.setVisibility(4);
                    TopicPkView.this.kiz.setX(TopicPkView.this.kiT);
                    TopicPkView.this.kiz.setY(TopicPkView.this.kiU);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.kiM = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.kiY = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kiz.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kiR) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kiB - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kio.getX() + (TopicPkView.this.kiB / 2)))));
                    TopicPkView.this.kiz.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kiS) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kiz.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kio.getX() + (TopicPkView.this.kiB / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kio.getX() + (TopicPkView.this.kiB / 2)))));
                    TopicPkView.this.kiz.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kiz.setVisibility(4);
                    TopicPkView.this.kiz.setX(TopicPkView.this.kiT);
                    TopicPkView.this.kiz.setY(TopicPkView.this.kiU);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.kim = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.kin = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.kio = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.kip = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.kiq = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.kir = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.kis = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.kit = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.kiu = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.kiv = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.kiw = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.kix = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.kiy = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.kiz = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.kiA = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.kiq.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.kir.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.kis.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.kit.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.kio.setOnClickListener(this);
        this.kip.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.kiJ = l.getDimens(context, R.dimen.tbds62);
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
        if (this.kil != null) {
            this.kiB = this.kio.getWidth();
            this.dzu = this.kio.getHeight();
            this.kiC = this.kiq.getWidth();
            this.kiD = this.kiu.getWidth();
            this.kiE = this.kiv.getWidth();
            this.kiH = this.kiu.getHeight();
            this.kiF = this.kix.getWidth();
            this.kiG = this.kiy.getWidth();
            this.mCursorWidth = this.kiw.getWidth();
            this.mCursorHeight = this.kiw.getHeight();
            this.kiI = ((this.mWidth - (this.kiB * 2)) - this.kiD) - this.kiE;
            this.kiL = this.kiz.getWidth();
            if (this.kil.khL.khN == 0 && this.kil.khM.khN == 0) {
                this.kiK = (int) ((0.5d * this.kiI) + this.kiD + this.kiB);
            } else {
                this.kiK = (int) (((((float) this.kil.khL.khN) / ((float) (this.kil.khL.khN + this.kil.khM.khN))) * this.kiI) + this.kiD + this.kiB);
            }
            float y = this.kio.getY() - ((this.mCursorHeight - this.dzu) / 2);
            if (this.kiK + (this.mCursorWidth / 2) >= this.kiv.getLeft()) {
                this.kiK = (this.kiv.getLeft() - 10) - (this.mCursorWidth / 2);
                this.kiw.layout((this.kiv.getLeft() - 10) - this.mCursorWidth, (int) y, this.kiv.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.kiK - (this.mCursorWidth / 2) <= this.kiu.getRight()) {
                this.kiK = this.kiu.getRight() + 10 + (this.mCursorWidth / 2);
                this.kiw.layout(this.kiu.getRight() + 10, (int) y, this.kiu.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.kiw.layout(this.kiK - (this.mCursorWidth / 2), (int) y, this.kiK + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.kiq.getX());
            if (this.kiF < this.kiC) {
                int i5 = (this.kiB - this.kiF) / 2;
                this.kix.layout(i5, (int) this.kix.getY(), this.kiF + i5, ((int) this.kix.getY()) + this.kiH);
            } else if (this.kiF <= x) {
                this.kix.layout((int) this.kiq.getX(), (int) this.kix.getY(), ((int) this.kiq.getX()) + this.kiF, ((int) this.kix.getY()) + this.kiH);
            } else {
                ViewGroup.LayoutParams layoutParams = this.kix.getLayoutParams();
                layoutParams.width = x;
                this.kix.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.kiG < this.kiC) {
                int x2 = ((int) this.kip.getX()) + ((this.kiB - this.kiG) / 2);
                this.kiy.layout(x2, (int) this.kiy.getY(), this.kiG + x2, ((int) this.kiy.getY()) + this.kiH);
            } else if (this.kiG <= x) {
                this.kiy.layout((this.mWidth - ((int) this.kir.getX())) - this.kiG, (int) this.kiy.getY(), this.mWidth - ((int) this.kir.getX()), ((int) this.kiy.getY()) + this.kiH);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.kiy.getLayoutParams();
                layoutParams2.width = x;
                this.kiy.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.kiB - this.kiL) / 2;
            this.kiz.layout(((int) this.kio.getX()) + i6, ((int) this.kio.getY()) + i6, ((int) this.kio.getX()) + i6 + this.kiL, ((int) this.kio.getY()) + i6 + this.kiL);
            this.kiA.layout(((int) this.kip.getX()) + i6, ((int) this.kip.getY()) + i6, ((int) this.kip.getX()) + i6 + this.kiL, i6 + ((int) this.kip.getY()) + this.kiL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.kil.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.kiN == null || !this.kiN.isRunning()) {
            if (this.kiQ == null || !this.kiQ.isRunning()) {
                if (this.kiQ == null) {
                    this.kiQ = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.kiQ.setDuration(800L);
                    this.kiQ.setInterpolator(new AccelerateInterpolator());
                }
                if (this.kiN == null) {
                    this.kiN = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.kiN.setDuration(800L);
                    this.kiN.setInterpolator(new AccelerateInterpolator());
                    this.kiP = new a();
                    this.kiN.addListener(this.kiP);
                    this.kiN.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.kiO.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.kiO.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cQu()) {
                    i = 1;
                } else {
                    i = cQv() ? 2 : 0;
                }
                if (view == this.kio) {
                    sg(1 != i);
                    sh(false);
                    i2 = 1;
                } else if (view == this.kip) {
                    sh(2 != i);
                    sg(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new aq("c13352").an("obj_type", i2).w("topic_id", this.kil.topicId).an("obj_source", this.kil.from));
                if (this.kiX != null) {
                    this.kiX.BN(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.kil.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.kil.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.kil.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kil != null) {
            af(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void af(Canvas canvas) {
        float y = this.kio.getY() + ((this.dzu - this.kiJ) / 2);
        this.mPaint.setShader(new LinearGradient(this.kiB / 2, y, this.kiK, y, ao.getColor(R.color.topic_pk_agree_bar_start_color), ao.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.kiB / 2, y, this.kiK, y + this.kiJ, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.kiK, y, this.mWidth - (this.kiB / 2), y, ao.getColor(R.color.topic_pk_disagree_bar_start_color), ao.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.kiK, y, this.mWidth - (this.kiB / 2), y + this.kiJ, this.mPaint);
    }

    public void setUserColor(int i) {
        this.kiM = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.khL == null || bVar.khM == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kil = bVar;
        this.kiu.setText(String.valueOf(bVar.khL.khN));
        this.kiv.setText(String.valueOf(bVar.khM.khN));
        this.kiV = new RelativeLayout.LayoutParams(-2, -2);
        this.kiV.addRule(12);
        this.kiW = new RelativeLayout.LayoutParams(-2, -2);
        this.kiW.addRule(12);
        this.kiW.addRule(11);
        this.kix.setLayoutParams(this.kiV);
        this.kiy.setLayoutParams(this.kiW);
        if (bVar.from == 3) {
            this.kix.setText(StringUtils.isNull(bVar.khL.khO) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.khL.khO);
            this.kiy.setText(StringUtils.isNull(bVar.khM.khO) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.khM.khO);
            if (StringUtils.isNull(bVar.khL.khP)) {
                this.kim.setVisibility(4);
            } else {
                this.kim.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.khL.khP));
            }
            if (StringUtils.isNull(bVar.khM.khP)) {
                this.kin.setVisibility(4);
            } else {
                this.kin.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.khM.khP));
            }
        } else {
            this.kix.setText(bVar.khL.khO);
            this.kiy.setText(bVar.khM.khO);
            this.kim.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.khL.khP));
            this.kin.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.khM.khP));
        }
        this.kiq.startLoad(bVar.khL.khQ, 10, false);
        this.kir.startLoad(bVar.khM.khQ, 10, false);
        this.kis.startLoad(bVar.khL.khT, 10, false);
        this.kit.startLoad(bVar.khM.khT, 10, false);
        if (bVar.khL.khR) {
            this.kiq.setVisibility(4);
            this.kis.setVisibility(0);
        } else {
            this.kiq.setVisibility(0);
            this.kis.setVisibility(4);
        }
        if (bVar.khM.khR) {
            this.kir.setVisibility(4);
            this.kit.setVisibility(0);
        } else {
            this.kir.setVisibility(0);
            this.kit.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.kim, this.kiM);
        ao.setViewTextColor(this.kin, this.kiM);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.kiq.setIsNight(this.mSkinType == 1);
            this.kir.setIsNight(this.mSkinType == 1);
            this.kis.setIsNight(this.mSkinType == 1);
            this.kit.setIsNight(this.mSkinType == 1);
            ao.setBackgroundResource(this.kio, R.drawable.btn_topic_agree_bg_red);
            ao.setBackgroundResource(this.kip, R.drawable.btn_topic_disagree_bg_blue);
            ao.setImageResource(this.kiz, R.drawable.pic_topic_addone);
            ao.setImageResource(this.kiA, R.drawable.pic_topic_addone);
            ao.setImageResource(this.kiw, R.drawable.pic_topic_vs_bginone);
            ao.setViewTextColor(this.kiu, R.color.CAM_X0101);
            ao.setViewTextColor(this.kiv, R.color.CAM_X0101);
            ao.setViewTextColor(this.kix, R.color.topic_agree_des_color);
            ao.setViewTextColor(this.kiy, R.color.topic_disagree_des_color);
        }
    }

    private void sg(boolean z) {
        if (z) {
            this.kim.setVisibility(0);
            this.kim.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.kil.khL.khP = TbadkCoreApplication.getCurrentAccountNameShow();
            this.kil.khL.khR = true;
            TextView textView = this.kiu;
            b.a aVar = this.kil.khL;
            long j = aVar.khN + 1;
            aVar.khN = j;
            textView.setText(String.valueOf(j));
            this.kiz.setVisibility(0);
            this.kiO = this.kis;
            this.kiP.kja = this.kis;
            this.kiP.kjb = this.kiq;
            this.kiz.setVisibility(0);
            this.kiN.start();
            this.kiR = this.kiz.getX();
            this.kiS = this.kiz.getY();
            this.kiT = this.kiz.getX();
            this.kiU = this.kiz.getY();
            this.kiQ.removeAllUpdateListeners();
            this.kiQ.addUpdateListener(this.kiY);
            this.kiQ.setFloatValues(0.0f, 2.0f);
            this.kiQ.start();
            return;
        }
        if (at.equals(this.kil.khL.khP, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.kim.setVisibility(4);
        }
        if (this.kil.khL.khR) {
            this.kil.khL.khR = false;
            TextView textView2 = this.kiu;
            b.a aVar2 = this.kil.khL;
            long j2 = aVar2.khN - 1;
            aVar2.khN = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.kiq.setVisibility(0);
        this.kis.setVisibility(4);
    }

    private void sh(boolean z) {
        if (z) {
            this.kin.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.kin.setVisibility(0);
            this.kil.khM.khP = TbadkCoreApplication.getCurrentAccountNameShow();
            this.kiA.setVisibility(0);
            this.kil.khM.khR = true;
            TextView textView = this.kiv;
            b.a aVar = this.kil.khM;
            long j = aVar.khN + 1;
            aVar.khN = j;
            textView.setText(String.valueOf(j));
            this.kiR = this.kiA.getX() - (this.kiL / 2.0f);
            this.kiO = this.kit;
            this.kiP.kja = this.kit;
            this.kiP.kjb = this.kir;
            this.kiz.setVisibility(0);
            this.kiN.start();
            this.kiR = this.kiA.getX() - (this.kiL / 2);
            this.kiS = this.kiA.getY();
            this.kiT = this.kiA.getX();
            this.kiU = this.kiA.getY();
            this.kiQ.removeAllUpdateListeners();
            this.kiQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.kiA.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kiR) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.kiB) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.kiB / 2)))));
                        TopicPkView.this.kiA.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kiS) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.kiA.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.kiB / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.kiA.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.kiA.setVisibility(4);
                        TopicPkView.this.kiA.setX(TopicPkView.this.kiT);
                        TopicPkView.this.kiA.setY(TopicPkView.this.kiU);
                    }
                }
            });
            this.kiQ.setFloatValues(0.0f, 2.0f);
            this.kiQ.start();
            return;
        }
        if (at.equals(this.kil.khM.khP, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.kin.setVisibility(4);
        }
        if (this.kil.khM.khR) {
            this.kil.khM.khR = false;
            TextView textView2 = this.kiv;
            b.a aVar2 = this.kil.khM;
            long j2 = aVar2.khN - 1;
            aVar2.khN = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.kiA.setVisibility(4);
        this.kir.setVisibility(0);
        this.kit.setVisibility(4);
    }

    private boolean cQu() {
        return (this.kil == null || this.kil.khL == null || !this.kil.khL.khR) ? false : true;
    }

    private boolean cQv() {
        return (this.kil == null || this.kil.khM == null || !this.kil.khM.khR) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.kiN != null) {
            this.kiN.cancel();
        }
        if (this.kiQ != null) {
            this.kiQ.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.kiX = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Animator.AnimatorListener {
        private View kja;
        private View kjb;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.kja != null) {
                this.kja.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.kjb != null) {
                this.kjb.setVisibility(8);
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
