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
    private com.baidu.tieba.homepage.topic.topictab.b.b hhZ;
    private int hiA;
    private int hiB;
    private ValueAnimator hiC;
    private View hiD;
    private a hiE;
    private ValueAnimator hiF;
    private double hiG;
    private double hiH;
    private float hiI;
    private float hiJ;
    private RelativeLayout.LayoutParams hiK;
    private RelativeLayout.LayoutParams hiL;
    private b hiM;
    private ValueAnimator.AnimatorUpdateListener hiN;
    private TextView hia;
    private TextView hib;
    private FrameLayout hic;
    private FrameLayout hie;
    private TbImageView hif;
    private TbImageView hig;
    private TbImageView hih;
    private TbImageView hii;
    private TextView hij;
    private TextView hik;
    private ImageView hil;
    private TextView him;
    private TextView hin;
    private ImageView hio;
    private ImageView hip;
    private int hiq;
    private int hir;
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
        this.hiB = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hiN = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hio.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiG) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hiq - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hic.getX() + (TopicPkView.this.hiq / 2)))));
                    TopicPkView.this.hio.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiH) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hio.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hic.getX() + (TopicPkView.this.hiq / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hic.getX() + (TopicPkView.this.hiq / 2)))));
                    TopicPkView.this.hio.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hio.setVisibility(4);
                    TopicPkView.this.hio.setX(TopicPkView.this.hiI);
                    TopicPkView.this.hio.setY(TopicPkView.this.hiJ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hiB = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hiN = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hio.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiG) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hiq - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hic.getX() + (TopicPkView.this.hiq / 2)))));
                    TopicPkView.this.hio.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiH) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hio.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hic.getX() + (TopicPkView.this.hiq / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hic.getX() + (TopicPkView.this.hiq / 2)))));
                    TopicPkView.this.hio.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hio.setVisibility(4);
                    TopicPkView.this.hio.setX(TopicPkView.this.hiI);
                    TopicPkView.this.hio.setY(TopicPkView.this.hiJ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hiB = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hiN = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hio.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiG) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hiq - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hic.getX() + (TopicPkView.this.hiq / 2)))));
                    TopicPkView.this.hio.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiH) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hio.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hic.getX() + (TopicPkView.this.hiq / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hic.getX() + (TopicPkView.this.hiq / 2)))));
                    TopicPkView.this.hio.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hio.setVisibility(4);
                    TopicPkView.this.hio.setX(TopicPkView.this.hiI);
                    TopicPkView.this.hio.setY(TopicPkView.this.hiJ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.hia = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.hib = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.hic = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.hie = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.hif = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.hig = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.hih = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.hii = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.hij = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.hik = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.hil = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.him = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.hin = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.hio = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.hip = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.hif.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.hig.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.hih.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.hii.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.hic.setOnClickListener(this);
        this.hie.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.hiy = l.getDimens(context, R.dimen.tbds62);
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
        if (this.hhZ != null) {
            this.hiq = this.hic.getWidth();
            this.mBtnHeight = this.hic.getHeight();
            this.hir = this.hif.getWidth();
            this.his = this.hij.getWidth();
            this.hit = this.hik.getWidth();
            this.hiw = this.hij.getHeight();
            this.hiu = this.him.getWidth();
            this.hiv = this.hin.getWidth();
            this.mCursorWidth = this.hil.getWidth();
            this.mCursorHeight = this.hil.getHeight();
            this.hix = ((this.mWidth - (this.hiq * 2)) - this.his) - this.hit;
            this.hiA = this.hio.getWidth();
            if (this.hhZ.hhy.hhA == 0 && this.hhZ.hhz.hhA == 0) {
                this.hiz = (int) ((0.5d * this.hix) + this.his + this.hiq);
            } else {
                this.hiz = (int) (((((float) this.hhZ.hhy.hhA) / ((float) (this.hhZ.hhy.hhA + this.hhZ.hhz.hhA))) * this.hix) + this.his + this.hiq);
            }
            float y = this.hic.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.hiz + (this.mCursorWidth / 2) >= this.hik.getLeft()) {
                this.hiz = (this.hik.getLeft() - 10) - (this.mCursorWidth / 2);
                this.hil.layout((this.hik.getLeft() - 10) - this.mCursorWidth, (int) y, this.hik.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.hiz - (this.mCursorWidth / 2) <= this.hij.getRight()) {
                this.hiz = this.hij.getRight() + 10 + (this.mCursorWidth / 2);
                this.hil.layout(this.hij.getRight() + 10, (int) y, this.hij.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.hil.layout(this.hiz - (this.mCursorWidth / 2), (int) y, this.hiz + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.hif.getX());
            if (this.hiu < this.hir) {
                int i5 = (this.hiq - this.hiu) / 2;
                this.him.layout(i5, (int) this.him.getY(), this.hiu + i5, ((int) this.him.getY()) + this.hiw);
            } else if (this.hiu <= x) {
                this.him.layout((int) this.hif.getX(), (int) this.him.getY(), ((int) this.hif.getX()) + this.hiu, ((int) this.him.getY()) + this.hiw);
            } else {
                ViewGroup.LayoutParams layoutParams = this.him.getLayoutParams();
                layoutParams.width = x;
                this.him.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.hiv < this.hir) {
                int x2 = ((int) this.hie.getX()) + ((this.hiq - this.hiv) / 2);
                this.hin.layout(x2, (int) this.hin.getY(), this.hiv + x2, ((int) this.hin.getY()) + this.hiw);
            } else if (this.hiv <= x) {
                this.hin.layout((this.mWidth - ((int) this.hig.getX())) - this.hiv, (int) this.hin.getY(), this.mWidth - ((int) this.hig.getX()), ((int) this.hin.getY()) + this.hiw);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.hin.getLayoutParams();
                layoutParams2.width = x;
                this.hin.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.hiq - this.hiA) / 2;
            this.hio.layout(((int) this.hic.getX()) + i6, ((int) this.hic.getY()) + i6, ((int) this.hic.getX()) + i6 + this.hiA, ((int) this.hic.getY()) + i6 + this.hiA);
            this.hip.layout(((int) this.hie.getX()) + i6, ((int) this.hie.getY()) + i6, ((int) this.hie.getX()) + i6 + this.hiA, i6 + ((int) this.hie.getY()) + this.hiA);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.hhZ.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.hiC == null || !this.hiC.isRunning()) {
            if (this.hiF == null || !this.hiF.isRunning()) {
                if (this.hiF == null) {
                    this.hiF = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.hiF.setDuration(800L);
                    this.hiF.setInterpolator(new AccelerateInterpolator());
                }
                if (this.hiC == null) {
                    this.hiC = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.hiC.setDuration(800L);
                    this.hiC.setInterpolator(new AccelerateInterpolator());
                    this.hiE = new a();
                    this.hiC.addListener(this.hiE);
                    this.hiC.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.hiD.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.hiD.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bPC()) {
                    i = 1;
                } else {
                    i = bPD() ? 2 : 0;
                }
                if (view == this.hic) {
                    mQ(1 != i);
                    mR(false);
                    i2 = 1;
                } else if (view == this.hie) {
                    mR(2 != i);
                    mQ(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").X("obj_type", i2).s("topic_id", this.hhZ.topicId).X("obj_source", this.hhZ.from));
                if (this.hiM != null) {
                    this.hiM.vv(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.hhZ.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.hhZ.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.hhZ.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.hhZ != null) {
            K(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void K(Canvas canvas) {
        float y = this.hic.getY() + ((this.mBtnHeight - this.hiy) / 2);
        this.mPaint.setShader(new LinearGradient(this.hiq / 2, y, this.hiz, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hiq / 2, y, this.hiz, y + this.hiy, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.hiz, y, this.mWidth - (this.hiq / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hiz, y, this.mWidth - (this.hiq / 2), y + this.hiy, this.mPaint);
    }

    public void setUserColor(int i) {
        this.hiB = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.hhy == null || bVar.hhz == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hhZ = bVar;
        this.hij.setText(String.valueOf(bVar.hhy.hhA));
        this.hik.setText(String.valueOf(bVar.hhz.hhA));
        this.hiK = new RelativeLayout.LayoutParams(-2, -2);
        this.hiK.addRule(12);
        this.hiL = new RelativeLayout.LayoutParams(-2, -2);
        this.hiL.addRule(12);
        this.hiL.addRule(11);
        this.him.setLayoutParams(this.hiK);
        this.hin.setLayoutParams(this.hiL);
        if (bVar.from == 3) {
            this.him.setText(StringUtils.isNull(bVar.hhy.hhB) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.hhy.hhB);
            this.hin.setText(StringUtils.isNull(bVar.hhz.hhB) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.hhz.hhB);
            if (StringUtils.isNull(bVar.hhy.hhC)) {
                this.hia.setVisibility(4);
            } else {
                this.hia.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhy.hhC));
            }
            if (StringUtils.isNull(bVar.hhz.hhC)) {
                this.hib.setVisibility(4);
            } else {
                this.hib.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhz.hhC));
            }
        } else {
            this.him.setText(bVar.hhy.hhB);
            this.hin.setText(bVar.hhz.hhB);
            this.hia.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhy.hhC));
            this.hib.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhz.hhC));
        }
        this.hif.startLoad(bVar.hhy.hhD, 10, false);
        this.hig.startLoad(bVar.hhz.hhD, 10, false);
        this.hih.startLoad(bVar.hhy.hhG, 10, false);
        this.hii.startLoad(bVar.hhz.hhG, 10, false);
        if (bVar.hhy.hhE) {
            this.hif.setVisibility(4);
            this.hih.setVisibility(0);
        } else {
            this.hif.setVisibility(0);
            this.hih.setVisibility(4);
        }
        if (bVar.hhz.hhE) {
            this.hig.setVisibility(4);
            this.hii.setVisibility(0);
        } else {
            this.hig.setVisibility(0);
            this.hii.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.hia, this.hiB);
        am.setViewTextColor(this.hib, this.hiB);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.hif.setIsNight(this.mSkinType == 1);
            this.hig.setIsNight(this.mSkinType == 1);
            this.hih.setIsNight(this.mSkinType == 1);
            this.hii.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.hic, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.hie, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.hio, R.drawable.pic_topic_addone);
            am.setImageResource(this.hip, R.drawable.pic_topic_addone);
            am.setImageResource(this.hil, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.hij, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hik, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.him, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.hin, (int) R.color.topic_disagree_des_color);
        }
    }

    private void mQ(boolean z) {
        if (z) {
            this.hia.setVisibility(0);
            this.hia.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hhZ.hhy.hhC = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hhZ.hhy.hhE = true;
            TextView textView = this.hij;
            b.a aVar = this.hhZ.hhy;
            long j = aVar.hhA + 1;
            aVar.hhA = j;
            textView.setText(String.valueOf(j));
            this.hio.setVisibility(0);
            this.hiD = this.hih;
            this.hiE.hiP = this.hih;
            this.hiE.hiQ = this.hif;
            this.hio.setVisibility(0);
            this.hiC.start();
            this.hiG = this.hio.getX();
            this.hiH = this.hio.getY();
            this.hiI = this.hio.getX();
            this.hiJ = this.hio.getY();
            this.hiF.removeAllUpdateListeners();
            this.hiF.addUpdateListener(this.hiN);
            this.hiF.setFloatValues(0.0f, 2.0f);
            this.hiF.start();
            return;
        }
        if (aq.equals(this.hhZ.hhy.hhC, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hia.setVisibility(4);
        }
        if (this.hhZ.hhy.hhE) {
            this.hhZ.hhy.hhE = false;
            TextView textView2 = this.hij;
            b.a aVar2 = this.hhZ.hhy;
            long j2 = aVar2.hhA - 1;
            aVar2.hhA = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hif.setVisibility(0);
        this.hih.setVisibility(4);
    }

    private void mR(boolean z) {
        if (z) {
            this.hib.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hib.setVisibility(0);
            this.hhZ.hhz.hhC = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hip.setVisibility(0);
            this.hhZ.hhz.hhE = true;
            TextView textView = this.hik;
            b.a aVar = this.hhZ.hhz;
            long j = aVar.hhA + 1;
            aVar.hhA = j;
            textView.setText(String.valueOf(j));
            this.hiG = this.hip.getX() - (this.hiA / 2.0f);
            this.hiD = this.hii;
            this.hiE.hiP = this.hii;
            this.hiE.hiQ = this.hig;
            this.hio.setVisibility(0);
            this.hiC.start();
            this.hiG = this.hip.getX() - (this.hiA / 2);
            this.hiH = this.hip.getY();
            this.hiI = this.hip.getX();
            this.hiJ = this.hip.getY();
            this.hiF.removeAllUpdateListeners();
            this.hiF.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.hip.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiG) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.hiq) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hiq / 2)))));
                        TopicPkView.this.hip.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiH) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.hip.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hiq / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.hip.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.hip.setVisibility(4);
                        TopicPkView.this.hip.setX(TopicPkView.this.hiI);
                        TopicPkView.this.hip.setY(TopicPkView.this.hiJ);
                    }
                }
            });
            this.hiF.setFloatValues(0.0f, 2.0f);
            this.hiF.start();
            return;
        }
        if (aq.equals(this.hhZ.hhz.hhC, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hib.setVisibility(4);
        }
        if (this.hhZ.hhz.hhE) {
            this.hhZ.hhz.hhE = false;
            TextView textView2 = this.hik;
            b.a aVar2 = this.hhZ.hhz;
            long j2 = aVar2.hhA - 1;
            aVar2.hhA = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hip.setVisibility(4);
        this.hig.setVisibility(0);
        this.hii.setVisibility(4);
    }

    private boolean bPC() {
        return (this.hhZ == null || this.hhZ.hhy == null || !this.hhZ.hhy.hhE) ? false : true;
    }

    private boolean bPD() {
        return (this.hhZ == null || this.hhZ.hhz == null || !this.hhZ.hhz.hhE) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.hiC != null) {
            this.hiC.cancel();
        }
        if (this.hiF != null) {
            this.hiF.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.hiM = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Animator.AnimatorListener {
        private View hiP;
        private View hiQ;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.hiP != null) {
                this.hiP.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.hiQ != null) {
                this.hiQ.setVisibility(8);
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
