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
    private int hiA;
    private int hiB;
    private int hiC;
    private int hiD;
    private ValueAnimator hiE;
    private View hiF;
    private a hiG;
    private ValueAnimator hiH;
    private double hiI;
    private double hiJ;
    private float hiK;
    private float hiL;
    private RelativeLayout.LayoutParams hiM;
    private RelativeLayout.LayoutParams hiN;
    private b hiO;
    private ValueAnimator.AnimatorUpdateListener hiP;
    private com.baidu.tieba.homepage.topic.topictab.b.b hib;
    private TextView hic;
    private TextView hie;
    private FrameLayout hif;
    private FrameLayout hig;
    private TbImageView hih;
    private TbImageView hii;
    private TbImageView hij;
    private TbImageView hik;
    private TextView hil;
    private TextView him;
    private ImageView hin;
    private TextView hio;
    private TextView hip;
    private ImageView hiq;
    private ImageView hir;
    private int his;
    private int hit;
    private int hiu;
    private int hiv;
    private int hiw;
    private int hix;
    private int hiy;
    private int hiz;
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
        void vv(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hiD = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hiP = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hiq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiI) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.his - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hif.getX() + (TopicPkView.this.his / 2)))));
                    TopicPkView.this.hiq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiJ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hiq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hif.getX() + (TopicPkView.this.his / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hif.getX() + (TopicPkView.this.his / 2)))));
                    TopicPkView.this.hiq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hiq.setVisibility(4);
                    TopicPkView.this.hiq.setX(TopicPkView.this.hiK);
                    TopicPkView.this.hiq.setY(TopicPkView.this.hiL);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hiD = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hiP = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hiq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiI) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.his - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hif.getX() + (TopicPkView.this.his / 2)))));
                    TopicPkView.this.hiq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiJ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hiq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hif.getX() + (TopicPkView.this.his / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hif.getX() + (TopicPkView.this.his / 2)))));
                    TopicPkView.this.hiq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hiq.setVisibility(4);
                    TopicPkView.this.hiq.setX(TopicPkView.this.hiK);
                    TopicPkView.this.hiq.setY(TopicPkView.this.hiL);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hiD = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hiP = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hiq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiI) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.his - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hif.getX() + (TopicPkView.this.his / 2)))));
                    TopicPkView.this.hiq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiJ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hiq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hif.getX() + (TopicPkView.this.his / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hif.getX() + (TopicPkView.this.his / 2)))));
                    TopicPkView.this.hiq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hiq.setVisibility(4);
                    TopicPkView.this.hiq.setX(TopicPkView.this.hiK);
                    TopicPkView.this.hiq.setY(TopicPkView.this.hiL);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.hic = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.hie = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.hif = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.hig = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.hih = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.hii = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.hij = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.hik = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.hil = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.him = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.hin = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.hio = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.hip = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.hiq = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.hir = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.hih.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.hii.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.hij.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.hik.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.hif.setOnClickListener(this);
        this.hig.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.hiA = l.getDimens(context, R.dimen.tbds62);
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
        if (this.hib != null) {
            this.his = this.hif.getWidth();
            this.mBtnHeight = this.hif.getHeight();
            this.hit = this.hih.getWidth();
            this.hiu = this.hil.getWidth();
            this.hiv = this.him.getWidth();
            this.hiy = this.hil.getHeight();
            this.hiw = this.hio.getWidth();
            this.hix = this.hip.getWidth();
            this.mCursorWidth = this.hin.getWidth();
            this.mCursorHeight = this.hin.getHeight();
            this.hiz = ((this.mWidth - (this.his * 2)) - this.hiu) - this.hiv;
            this.hiC = this.hiq.getWidth();
            if (this.hib.hhA.hhC == 0 && this.hib.hhB.hhC == 0) {
                this.hiB = (int) ((0.5d * this.hiz) + this.hiu + this.his);
            } else {
                this.hiB = (int) (((((float) this.hib.hhA.hhC) / ((float) (this.hib.hhA.hhC + this.hib.hhB.hhC))) * this.hiz) + this.hiu + this.his);
            }
            float y = this.hif.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.hiB + (this.mCursorWidth / 2) >= this.him.getLeft()) {
                this.hiB = (this.him.getLeft() - 10) - (this.mCursorWidth / 2);
                this.hin.layout((this.him.getLeft() - 10) - this.mCursorWidth, (int) y, this.him.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.hiB - (this.mCursorWidth / 2) <= this.hil.getRight()) {
                this.hiB = this.hil.getRight() + 10 + (this.mCursorWidth / 2);
                this.hin.layout(this.hil.getRight() + 10, (int) y, this.hil.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.hin.layout(this.hiB - (this.mCursorWidth / 2), (int) y, this.hiB + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.hih.getX());
            if (this.hiw < this.hit) {
                int i5 = (this.his - this.hiw) / 2;
                this.hio.layout(i5, (int) this.hio.getY(), this.hiw + i5, ((int) this.hio.getY()) + this.hiy);
            } else if (this.hiw <= x) {
                this.hio.layout((int) this.hih.getX(), (int) this.hio.getY(), ((int) this.hih.getX()) + this.hiw, ((int) this.hio.getY()) + this.hiy);
            } else {
                ViewGroup.LayoutParams layoutParams = this.hio.getLayoutParams();
                layoutParams.width = x;
                this.hio.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.hix < this.hit) {
                int x2 = ((int) this.hig.getX()) + ((this.his - this.hix) / 2);
                this.hip.layout(x2, (int) this.hip.getY(), this.hix + x2, ((int) this.hip.getY()) + this.hiy);
            } else if (this.hix <= x) {
                this.hip.layout((this.mWidth - ((int) this.hii.getX())) - this.hix, (int) this.hip.getY(), this.mWidth - ((int) this.hii.getX()), ((int) this.hip.getY()) + this.hiy);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.hip.getLayoutParams();
                layoutParams2.width = x;
                this.hip.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.his - this.hiC) / 2;
            this.hiq.layout(((int) this.hif.getX()) + i6, ((int) this.hif.getY()) + i6, ((int) this.hif.getX()) + i6 + this.hiC, ((int) this.hif.getY()) + i6 + this.hiC);
            this.hir.layout(((int) this.hig.getX()) + i6, ((int) this.hig.getY()) + i6, ((int) this.hig.getX()) + i6 + this.hiC, i6 + ((int) this.hig.getY()) + this.hiC);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.hib.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.hiE == null || !this.hiE.isRunning()) {
            if (this.hiH == null || !this.hiH.isRunning()) {
                if (this.hiH == null) {
                    this.hiH = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.hiH.setDuration(800L);
                    this.hiH.setInterpolator(new AccelerateInterpolator());
                }
                if (this.hiE == null) {
                    this.hiE = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.hiE.setDuration(800L);
                    this.hiE.setInterpolator(new AccelerateInterpolator());
                    this.hiG = new a();
                    this.hiE.addListener(this.hiG);
                    this.hiE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.hiF.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.hiF.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bPE()) {
                    i = 1;
                } else {
                    i = bPF() ? 2 : 0;
                }
                if (view == this.hif) {
                    mQ(1 != i);
                    mR(false);
                    i2 = 1;
                } else if (view == this.hig) {
                    mR(2 != i);
                    mQ(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").X("obj_type", i2).s("topic_id", this.hib.topicId).X("obj_source", this.hib.from));
                if (this.hiO != null) {
                    this.hiO.vv(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.hib.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.hib.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.hib.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.hib != null) {
            K(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void K(Canvas canvas) {
        float y = this.hif.getY() + ((this.mBtnHeight - this.hiA) / 2);
        this.mPaint.setShader(new LinearGradient(this.his / 2, y, this.hiB, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.his / 2, y, this.hiB, y + this.hiA, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.hiB, y, this.mWidth - (this.his / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hiB, y, this.mWidth - (this.his / 2), y + this.hiA, this.mPaint);
    }

    public void setUserColor(int i) {
        this.hiD = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.hhA == null || bVar.hhB == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hib = bVar;
        this.hil.setText(String.valueOf(bVar.hhA.hhC));
        this.him.setText(String.valueOf(bVar.hhB.hhC));
        this.hiM = new RelativeLayout.LayoutParams(-2, -2);
        this.hiM.addRule(12);
        this.hiN = new RelativeLayout.LayoutParams(-2, -2);
        this.hiN.addRule(12);
        this.hiN.addRule(11);
        this.hio.setLayoutParams(this.hiM);
        this.hip.setLayoutParams(this.hiN);
        if (bVar.from == 3) {
            this.hio.setText(StringUtils.isNull(bVar.hhA.hhD) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.hhA.hhD);
            this.hip.setText(StringUtils.isNull(bVar.hhB.hhD) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.hhB.hhD);
            if (StringUtils.isNull(bVar.hhA.hhE)) {
                this.hic.setVisibility(4);
            } else {
                this.hic.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhA.hhE));
            }
            if (StringUtils.isNull(bVar.hhB.hhE)) {
                this.hie.setVisibility(4);
            } else {
                this.hie.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhB.hhE));
            }
        } else {
            this.hio.setText(bVar.hhA.hhD);
            this.hip.setText(bVar.hhB.hhD);
            this.hic.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhA.hhE));
            this.hie.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhB.hhE));
        }
        this.hih.startLoad(bVar.hhA.hhF, 10, false);
        this.hii.startLoad(bVar.hhB.hhF, 10, false);
        this.hij.startLoad(bVar.hhA.hhI, 10, false);
        this.hik.startLoad(bVar.hhB.hhI, 10, false);
        if (bVar.hhA.hhG) {
            this.hih.setVisibility(4);
            this.hij.setVisibility(0);
        } else {
            this.hih.setVisibility(0);
            this.hij.setVisibility(4);
        }
        if (bVar.hhB.hhG) {
            this.hii.setVisibility(4);
            this.hik.setVisibility(0);
        } else {
            this.hii.setVisibility(0);
            this.hik.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.hic, this.hiD);
        am.setViewTextColor(this.hie, this.hiD);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.hih.setIsNight(this.mSkinType == 1);
            this.hii.setIsNight(this.mSkinType == 1);
            this.hij.setIsNight(this.mSkinType == 1);
            this.hik.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.hif, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.hig, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.hiq, R.drawable.pic_topic_addone);
            am.setImageResource(this.hir, R.drawable.pic_topic_addone);
            am.setImageResource(this.hin, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.hil, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.him, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hio, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.hip, (int) R.color.topic_disagree_des_color);
        }
    }

    private void mQ(boolean z) {
        if (z) {
            this.hic.setVisibility(0);
            this.hic.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hib.hhA.hhE = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hib.hhA.hhG = true;
            TextView textView = this.hil;
            b.a aVar = this.hib.hhA;
            long j = aVar.hhC + 1;
            aVar.hhC = j;
            textView.setText(String.valueOf(j));
            this.hiq.setVisibility(0);
            this.hiF = this.hij;
            this.hiG.hiR = this.hij;
            this.hiG.hiS = this.hih;
            this.hiq.setVisibility(0);
            this.hiE.start();
            this.hiI = this.hiq.getX();
            this.hiJ = this.hiq.getY();
            this.hiK = this.hiq.getX();
            this.hiL = this.hiq.getY();
            this.hiH.removeAllUpdateListeners();
            this.hiH.addUpdateListener(this.hiP);
            this.hiH.setFloatValues(0.0f, 2.0f);
            this.hiH.start();
            return;
        }
        if (aq.equals(this.hib.hhA.hhE, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hic.setVisibility(4);
        }
        if (this.hib.hhA.hhG) {
            this.hib.hhA.hhG = false;
            TextView textView2 = this.hil;
            b.a aVar2 = this.hib.hhA;
            long j2 = aVar2.hhC - 1;
            aVar2.hhC = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hih.setVisibility(0);
        this.hij.setVisibility(4);
    }

    private void mR(boolean z) {
        if (z) {
            this.hie.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hie.setVisibility(0);
            this.hib.hhB.hhE = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hir.setVisibility(0);
            this.hib.hhB.hhG = true;
            TextView textView = this.him;
            b.a aVar = this.hib.hhB;
            long j = aVar.hhC + 1;
            aVar.hhC = j;
            textView.setText(String.valueOf(j));
            this.hiI = this.hir.getX() - (this.hiC / 2.0f);
            this.hiF = this.hik;
            this.hiG.hiR = this.hik;
            this.hiG.hiS = this.hii;
            this.hiq.setVisibility(0);
            this.hiE.start();
            this.hiI = this.hir.getX() - (this.hiC / 2);
            this.hiJ = this.hir.getY();
            this.hiK = this.hir.getX();
            this.hiL = this.hir.getY();
            this.hiH.removeAllUpdateListeners();
            this.hiH.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.hir.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiI) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.his) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.his / 2)))));
                        TopicPkView.this.hir.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiJ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.hir.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.his / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.hir.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.hir.setVisibility(4);
                        TopicPkView.this.hir.setX(TopicPkView.this.hiK);
                        TopicPkView.this.hir.setY(TopicPkView.this.hiL);
                    }
                }
            });
            this.hiH.setFloatValues(0.0f, 2.0f);
            this.hiH.start();
            return;
        }
        if (aq.equals(this.hib.hhB.hhE, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hie.setVisibility(4);
        }
        if (this.hib.hhB.hhG) {
            this.hib.hhB.hhG = false;
            TextView textView2 = this.him;
            b.a aVar2 = this.hib.hhB;
            long j2 = aVar2.hhC - 1;
            aVar2.hhC = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hir.setVisibility(4);
        this.hii.setVisibility(0);
        this.hik.setVisibility(4);
    }

    private boolean bPE() {
        return (this.hib == null || this.hib.hhA == null || !this.hib.hhA.hhG) ? false : true;
    }

    private boolean bPF() {
        return (this.hib == null || this.hib.hhB == null || !this.hib.hhB.hhG) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.hiE != null) {
            this.hiE.cancel();
        }
        if (this.hiH != null) {
            this.hiH.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.hiO = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Animator.AnimatorListener {
        private View hiR;
        private View hiS;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.hiR != null) {
                this.hiR.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.hiS != null) {
                this.hiS.setVisibility(8);
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
