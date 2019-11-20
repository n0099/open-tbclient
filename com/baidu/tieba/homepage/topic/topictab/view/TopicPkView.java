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
/* loaded from: classes4.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int bhs;
    private int clC;
    private com.baidu.tieba.homepage.topic.topictab.b.b goV;
    private TextView goW;
    private TextView goX;
    private FrameLayout goY;
    private FrameLayout goZ;
    private double gpA;
    private double gpB;
    private float gpC;
    private float gpD;
    private RelativeLayout.LayoutParams gpE;
    private RelativeLayout.LayoutParams gpF;
    private b gpG;
    private ValueAnimator.AnimatorUpdateListener gpH;
    private TbImageView gpa;
    private TbImageView gpb;
    private TbImageView gpc;
    private TbImageView gpd;
    private TextView gpe;
    private TextView gpf;
    private ImageView gpg;
    private TextView gph;
    private TextView gpi;
    private ImageView gpj;
    private ImageView gpk;
    private int gpl;
    private int gpm;
    private int gpn;
    private int gpo;
    private int gpp;
    private int gpq;
    private int gpr;
    private int gps;
    private int gpt;
    private int gpu;
    private int gpv;
    private ValueAnimator gpw;
    private View gpx;
    private a gpy;
    private ValueAnimator gpz;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void ti(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gpv = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gpH = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gpj.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpA) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gpl - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goY.getX() + (TopicPkView.this.gpl / 2)))));
                    TopicPkView.this.gpj.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpB) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gpj.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.goY.getX() + (TopicPkView.this.gpl / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goY.getX() + (TopicPkView.this.gpl / 2)))));
                    TopicPkView.this.gpj.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gpj.setVisibility(4);
                    TopicPkView.this.gpj.setX(TopicPkView.this.gpC);
                    TopicPkView.this.gpj.setY(TopicPkView.this.gpD);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gpv = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gpH = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gpj.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpA) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gpl - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goY.getX() + (TopicPkView.this.gpl / 2)))));
                    TopicPkView.this.gpj.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpB) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gpj.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.goY.getX() + (TopicPkView.this.gpl / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goY.getX() + (TopicPkView.this.gpl / 2)))));
                    TopicPkView.this.gpj.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gpj.setVisibility(4);
                    TopicPkView.this.gpj.setX(TopicPkView.this.gpC);
                    TopicPkView.this.gpj.setY(TopicPkView.this.gpD);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gpv = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gpH = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gpj.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpA) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gpl - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goY.getX() + (TopicPkView.this.gpl / 2)))));
                    TopicPkView.this.gpj.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpB) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gpj.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.goY.getX() + (TopicPkView.this.gpl / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goY.getX() + (TopicPkView.this.gpl / 2)))));
                    TopicPkView.this.gpj.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gpj.setVisibility(4);
                    TopicPkView.this.gpj.setX(TopicPkView.this.gpC);
                    TopicPkView.this.gpj.setY(TopicPkView.this.gpD);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.goW = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.goX = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.goY = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.goZ = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.gpa = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.gpb = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.gpc = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.gpd = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.gpe = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.gpf = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.gpg = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.gph = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.gpi = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.gpj = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.gpk = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.gpa.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.gpb.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.gpc.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.gpd.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.goY.setOnClickListener(this);
        this.goZ.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.gps = l.getDimens(context, R.dimen.tbds78);
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
        if (this.goV != null) {
            this.gpl = this.goY.getWidth();
            this.bhs = this.goY.getHeight();
            this.clC = this.gpa.getWidth();
            this.gpm = this.gpe.getWidth();
            this.gpn = this.gpf.getWidth();
            this.gpq = this.gpe.getHeight();
            this.gpo = this.gph.getWidth();
            this.gpp = this.gpi.getWidth();
            this.mCursorWidth = this.gpg.getWidth();
            this.mCursorHeight = this.gpg.getHeight();
            this.gpr = ((this.mWidth - (this.gpl * 2)) - this.gpm) - this.gpn;
            this.gpu = this.gpj.getWidth();
            if (this.goV.gou.gow == 0 && this.goV.gov.gow == 0) {
                this.gpt = (int) ((0.5d * this.gpr) + this.gpm + this.gpl);
            } else {
                this.gpt = (int) (((((float) this.goV.gou.gow) / ((float) (this.goV.gou.gow + this.goV.gov.gow))) * this.gpr) + this.gpm + this.gpl);
            }
            float y = this.goY.getY() - ((this.mCursorHeight - this.bhs) / 2);
            if (this.gpt + (this.mCursorWidth / 2) >= this.gpf.getLeft()) {
                this.gpt = (this.gpf.getLeft() - 10) - (this.mCursorWidth / 2);
                this.gpg.layout((this.gpf.getLeft() - 10) - this.mCursorWidth, (int) y, this.gpf.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.gpt - (this.mCursorWidth / 2) <= this.gpe.getRight()) {
                this.gpt = this.gpe.getRight() + 10 + (this.mCursorWidth / 2);
                this.gpg.layout(this.gpe.getRight() + 10, (int) y, this.gpe.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.gpg.layout(this.gpt - (this.mCursorWidth / 2), (int) y, this.gpt + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.gpa.getX());
            if (this.gpo < this.clC) {
                int i5 = (this.gpl - this.gpo) / 2;
                this.gph.layout(i5, (int) this.gph.getY(), this.gpo + i5, ((int) this.gph.getY()) + this.gpq);
            } else if (this.gpo <= x) {
                this.gph.layout((int) this.gpa.getX(), (int) this.gph.getY(), ((int) this.gpa.getX()) + this.gpo, ((int) this.gph.getY()) + this.gpq);
            } else {
                ViewGroup.LayoutParams layoutParams = this.gph.getLayoutParams();
                layoutParams.width = x;
                this.gph.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.gpp < this.clC) {
                int x2 = ((int) this.goZ.getX()) + ((this.gpl - this.gpp) / 2);
                this.gpi.layout(x2, (int) this.gpi.getY(), this.gpp + x2, ((int) this.gpi.getY()) + this.gpq);
            } else if (this.gpp <= x) {
                this.gpi.layout((this.mWidth - ((int) this.gpb.getX())) - this.gpp, (int) this.gpi.getY(), this.mWidth - ((int) this.gpb.getX()), ((int) this.gpi.getY()) + this.gpq);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.gpi.getLayoutParams();
                layoutParams2.width = x;
                this.gpi.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.gpl - this.gpu) / 2;
            this.gpj.layout(((int) this.goY.getX()) + i6, ((int) this.goY.getY()) + i6, ((int) this.goY.getX()) + i6 + this.gpu, ((int) this.goY.getY()) + i6 + this.gpu);
            this.gpk.layout(((int) this.goZ.getX()) + i6, ((int) this.goZ.getY()) + i6, ((int) this.goZ.getX()) + i6 + this.gpu, i6 + ((int) this.goZ.getY()) + this.gpu);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.goV.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.gpw == null || !this.gpw.isRunning()) {
            if (this.gpz == null || !this.gpz.isRunning()) {
                if (this.gpz == null) {
                    this.gpz = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.gpz.setDuration(800L);
                    this.gpz.setInterpolator(new AccelerateInterpolator());
                }
                if (this.gpw == null) {
                    this.gpw = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.gpw.setDuration(800L);
                    this.gpw.setInterpolator(new AccelerateInterpolator());
                    this.gpy = new a();
                    this.gpw.addListener(this.gpy);
                    this.gpw.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.gpx.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.gpx.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bvE()) {
                    i = 1;
                } else {
                    i = bvF() ? 2 : 0;
                }
                if (view == this.goY) {
                    lq(1 != i);
                    lr(false);
                    i2 = 1;
                } else if (view == this.goZ) {
                    lr(2 != i);
                    lq(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").O("obj_type", i2).p("topic_id", this.goV.topicId).O("obj_source", this.goV.from));
                if (this.gpG != null) {
                    this.gpG.ti(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.goV.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.goV.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.goV.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.goV != null) {
            N(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void N(Canvas canvas) {
        float y = this.goY.getY() + ((this.bhs - this.gps) / 2);
        this.mPaint.setShader(new LinearGradient(this.gpl / 2, y, this.gpt, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.gpl / 2, y, this.gpt, y + this.gps, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.gpt, y, this.mWidth - (this.gpl / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.gpt, y, this.mWidth - (this.gpl / 2), y + this.gps, this.mPaint);
    }

    public void setUserColor(int i) {
        this.gpv = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.gou == null || bVar.gov == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.goV = bVar;
        this.gpe.setText(String.valueOf(bVar.gou.gow));
        this.gpf.setText(String.valueOf(bVar.gov.gow));
        this.gpE = new RelativeLayout.LayoutParams(-2, -2);
        this.gpE.addRule(12);
        this.gpF = new RelativeLayout.LayoutParams(-2, -2);
        this.gpF.addRule(12);
        this.gpF.addRule(11);
        this.gph.setLayoutParams(this.gpE);
        this.gpi.setLayoutParams(this.gpF);
        if (bVar.from == 3) {
            this.gph.setText(StringUtils.isNull(bVar.gou.gox) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.gou.gox);
            this.gpi.setText(StringUtils.isNull(bVar.gov.gox) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.gov.gox);
            if (StringUtils.isNull(bVar.gou.goy)) {
                this.goW.setVisibility(4);
            } else {
                this.goW.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gou.goy));
            }
            if (StringUtils.isNull(bVar.gov.goy)) {
                this.goX.setVisibility(4);
            } else {
                this.goX.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gov.goy));
            }
        } else {
            this.gph.setText(bVar.gou.gox);
            this.gpi.setText(bVar.gov.gox);
            this.goW.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gou.goy));
            this.goX.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gov.goy));
        }
        this.gpa.startLoad(bVar.gou.goz, 10, false);
        this.gpb.startLoad(bVar.gov.goz, 10, false);
        this.gpc.startLoad(bVar.gou.goC, 10, false);
        this.gpd.startLoad(bVar.gov.goC, 10, false);
        if (bVar.gou.goA) {
            this.gpa.setVisibility(4);
            this.gpc.setVisibility(0);
        } else {
            this.gpa.setVisibility(0);
            this.gpc.setVisibility(4);
        }
        if (bVar.gov.goA) {
            this.gpb.setVisibility(4);
            this.gpd.setVisibility(0);
        } else {
            this.gpb.setVisibility(0);
            this.gpd.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.goW, this.gpv);
        am.setViewTextColor(this.goX, this.gpv);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundResource(this.goY, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.goZ, R.drawable.btn_topic_disagree_bg_blue);
            this.gpa.setIsNight(this.mSkinType == 1);
            this.gpb.setIsNight(this.mSkinType == 1);
            this.gpc.setIsNight(this.mSkinType == 1);
            this.gpd.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.gpe, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.gpf, (int) R.color.cp_cont_a);
            am.setImageResource(this.gpg, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.gph, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.gpi, (int) R.color.topic_disagree_des_color);
            am.setImageResource(this.gpj, R.drawable.pic_topic_addone);
            am.setImageResource(this.gpk, R.drawable.pic_topic_addone);
        }
    }

    private void lq(boolean z) {
        if (z) {
            this.goW.setVisibility(0);
            this.goW.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.goV.gou.goy = TbadkCoreApplication.getCurrentAccountNameShow();
            this.goV.gou.goA = true;
            TextView textView = this.gpe;
            b.a aVar = this.goV.gou;
            long j = aVar.gow + 1;
            aVar.gow = j;
            textView.setText(String.valueOf(j));
            this.gpj.setVisibility(0);
            this.gpx = this.gpc;
            this.gpy.gpJ = this.gpc;
            this.gpy.gpK = this.gpa;
            this.gpj.setVisibility(0);
            this.gpw.start();
            this.gpA = this.gpj.getX();
            this.gpB = this.gpj.getY();
            this.gpC = this.gpj.getX();
            this.gpD = this.gpj.getY();
            this.gpz.removeAllUpdateListeners();
            this.gpz.addUpdateListener(this.gpH);
            this.gpz.setFloatValues(0.0f, 2.0f);
            this.gpz.start();
            return;
        }
        if (aq.equals(this.goV.gou.goy, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.goW.setVisibility(4);
        }
        if (this.goV.gou.goA) {
            this.goV.gou.goA = false;
            TextView textView2 = this.gpe;
            b.a aVar2 = this.goV.gou;
            long j2 = aVar2.gow - 1;
            aVar2.gow = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.gpa.setVisibility(0);
        this.gpc.setVisibility(4);
    }

    private void lr(boolean z) {
        if (z) {
            this.goX.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.goX.setVisibility(0);
            this.goV.gov.goy = TbadkCoreApplication.getCurrentAccountNameShow();
            this.gpk.setVisibility(0);
            this.goV.gov.goA = true;
            TextView textView = this.gpf;
            b.a aVar = this.goV.gov;
            long j = aVar.gow + 1;
            aVar.gow = j;
            textView.setText(String.valueOf(j));
            this.gpA = this.gpk.getX() - (this.gpu / 2.0f);
            this.gpx = this.gpd;
            this.gpy.gpJ = this.gpd;
            this.gpy.gpK = this.gpb;
            this.gpj.setVisibility(0);
            this.gpw.start();
            this.gpA = this.gpk.getX() - (this.gpu / 2);
            this.gpB = this.gpk.getY();
            this.gpC = this.gpk.getX();
            this.gpD = this.gpk.getY();
            this.gpz.removeAllUpdateListeners();
            this.gpz.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.gpk.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpA) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.gpl) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.gpl / 2)))));
                        TopicPkView.this.gpk.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpB) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.gpk.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.gpl / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.gpk.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.gpk.setVisibility(4);
                        TopicPkView.this.gpk.setX(TopicPkView.this.gpC);
                        TopicPkView.this.gpk.setY(TopicPkView.this.gpD);
                    }
                }
            });
            this.gpz.setFloatValues(0.0f, 2.0f);
            this.gpz.start();
            return;
        }
        if (aq.equals(this.goV.gov.goy, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.goX.setVisibility(4);
        }
        if (this.goV.gov.goA) {
            this.goV.gov.goA = false;
            TextView textView2 = this.gpf;
            b.a aVar2 = this.goV.gov;
            long j2 = aVar2.gow - 1;
            aVar2.gow = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.gpk.setVisibility(4);
        this.gpb.setVisibility(0);
        this.gpd.setVisibility(4);
    }

    private boolean bvE() {
        return (this.goV == null || this.goV.gou == null || !this.goV.gou.goA) ? false : true;
    }

    private boolean bvF() {
        return (this.goV == null || this.goV.gov == null || !this.goV.gov.goA) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gpw != null) {
            this.gpw.cancel();
        }
        if (this.gpz != null) {
            this.gpz.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.gpG = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View gpJ;
        private View gpK;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.gpJ != null) {
                this.gpJ.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.gpK != null) {
                this.gpK.setVisibility(8);
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
