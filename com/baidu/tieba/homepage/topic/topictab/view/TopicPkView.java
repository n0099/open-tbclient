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
/* loaded from: classes22.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private com.baidu.tieba.homepage.topic.topictab.b.b jsS;
    private TextView jsT;
    private TextView jsU;
    private FrameLayout jsV;
    private FrameLayout jsW;
    private TbImageView jsX;
    private TbImageView jsY;
    private TbImageView jsZ;
    private float jtA;
    private float jtB;
    private RelativeLayout.LayoutParams jtC;
    private RelativeLayout.LayoutParams jtD;
    private b jtE;
    private ValueAnimator.AnimatorUpdateListener jtF;
    private TbImageView jta;
    private TextView jtb;
    private TextView jtc;
    private ImageView jtd;
    private TextView jte;
    private TextView jtf;
    private ImageView jtg;
    private ImageView jth;
    private int jti;
    private int jtj;
    private int jtk;
    private int jtl;
    private int jtm;
    private int jtn;
    private int jto;
    private int jtp;
    private int jtq;
    private int jtr;
    private int jts;
    private int jtt;
    private ValueAnimator jtu;
    private View jtv;
    private a jtw;
    private ValueAnimator jtx;
    private double jty;
    private double jtz;
    private int mBtnHeight;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface b {
        void Bm(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jtt = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jtF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jtg.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jty) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jti - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jsV.getX() + (TopicPkView.this.jti / 2)))));
                    TopicPkView.this.jtg.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jtz) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jtg.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jsV.getX() + (TopicPkView.this.jti / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jsV.getX() + (TopicPkView.this.jti / 2)))));
                    TopicPkView.this.jtg.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jtg.setVisibility(4);
                    TopicPkView.this.jtg.setX(TopicPkView.this.jtA);
                    TopicPkView.this.jtg.setY(TopicPkView.this.jtB);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.jtt = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jtF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jtg.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jty) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jti - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jsV.getX() + (TopicPkView.this.jti / 2)))));
                    TopicPkView.this.jtg.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jtz) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jtg.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jsV.getX() + (TopicPkView.this.jti / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jsV.getX() + (TopicPkView.this.jti / 2)))));
                    TopicPkView.this.jtg.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jtg.setVisibility(4);
                    TopicPkView.this.jtg.setX(TopicPkView.this.jtA);
                    TopicPkView.this.jtg.setY(TopicPkView.this.jtB);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.jtt = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jtF = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jtg.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jty) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jti - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jsV.getX() + (TopicPkView.this.jti / 2)))));
                    TopicPkView.this.jtg.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jtz) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jtg.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jsV.getX() + (TopicPkView.this.jti / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jsV.getX() + (TopicPkView.this.jti / 2)))));
                    TopicPkView.this.jtg.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jtg.setVisibility(4);
                    TopicPkView.this.jtg.setX(TopicPkView.this.jtA);
                    TopicPkView.this.jtg.setY(TopicPkView.this.jtB);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.jsT = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.jsU = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.jsV = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.jsW = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.jsX = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.jsY = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.jsZ = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.jta = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.jtb = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.jtc = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.jtd = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.jte = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.jtf = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.jtg = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.jth = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.jsX.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.jsY.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.jsZ.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.jta.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.jsV.setOnClickListener(this);
        this.jsW.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.jtq = l.getDimens(context, R.dimen.tbds62);
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
        if (this.jsS != null) {
            this.jti = this.jsV.getWidth();
            this.mBtnHeight = this.jsV.getHeight();
            this.jtj = this.jsX.getWidth();
            this.jtk = this.jtb.getWidth();
            this.jtl = this.jtc.getWidth();
            this.jto = this.jtb.getHeight();
            this.jtm = this.jte.getWidth();
            this.jtn = this.jtf.getWidth();
            this.mCursorWidth = this.jtd.getWidth();
            this.mCursorHeight = this.jtd.getHeight();
            this.jtp = ((this.mWidth - (this.jti * 2)) - this.jtk) - this.jtl;
            this.jts = this.jtg.getWidth();
            if (this.jsS.jss.jsu == 0 && this.jsS.jst.jsu == 0) {
                this.jtr = (int) ((0.5d * this.jtp) + this.jtk + this.jti);
            } else {
                this.jtr = (int) (((((float) this.jsS.jss.jsu) / ((float) (this.jsS.jss.jsu + this.jsS.jst.jsu))) * this.jtp) + this.jtk + this.jti);
            }
            float y = this.jsV.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.jtr + (this.mCursorWidth / 2) >= this.jtc.getLeft()) {
                this.jtr = (this.jtc.getLeft() - 10) - (this.mCursorWidth / 2);
                this.jtd.layout((this.jtc.getLeft() - 10) - this.mCursorWidth, (int) y, this.jtc.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.jtr - (this.mCursorWidth / 2) <= this.jtb.getRight()) {
                this.jtr = this.jtb.getRight() + 10 + (this.mCursorWidth / 2);
                this.jtd.layout(this.jtb.getRight() + 10, (int) y, this.jtb.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.jtd.layout(this.jtr - (this.mCursorWidth / 2), (int) y, this.jtr + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.jsX.getX());
            if (this.jtm < this.jtj) {
                int i5 = (this.jti - this.jtm) / 2;
                this.jte.layout(i5, (int) this.jte.getY(), this.jtm + i5, ((int) this.jte.getY()) + this.jto);
            } else if (this.jtm <= x) {
                this.jte.layout((int) this.jsX.getX(), (int) this.jte.getY(), ((int) this.jsX.getX()) + this.jtm, ((int) this.jte.getY()) + this.jto);
            } else {
                ViewGroup.LayoutParams layoutParams = this.jte.getLayoutParams();
                layoutParams.width = x;
                this.jte.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.jtn < this.jtj) {
                int x2 = ((int) this.jsW.getX()) + ((this.jti - this.jtn) / 2);
                this.jtf.layout(x2, (int) this.jtf.getY(), this.jtn + x2, ((int) this.jtf.getY()) + this.jto);
            } else if (this.jtn <= x) {
                this.jtf.layout((this.mWidth - ((int) this.jsY.getX())) - this.jtn, (int) this.jtf.getY(), this.mWidth - ((int) this.jsY.getX()), ((int) this.jtf.getY()) + this.jto);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.jtf.getLayoutParams();
                layoutParams2.width = x;
                this.jtf.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.jti - this.jts) / 2;
            this.jtg.layout(((int) this.jsV.getX()) + i6, ((int) this.jsV.getY()) + i6, ((int) this.jsV.getX()) + i6 + this.jts, ((int) this.jsV.getY()) + i6 + this.jts);
            this.jth.layout(((int) this.jsW.getX()) + i6, ((int) this.jsW.getY()) + i6, ((int) this.jsW.getX()) + i6 + this.jts, i6 + ((int) this.jsW.getY()) + this.jts);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.jsS.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.jtu == null || !this.jtu.isRunning()) {
            if (this.jtx == null || !this.jtx.isRunning()) {
                if (this.jtx == null) {
                    this.jtx = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.jtx.setDuration(800L);
                    this.jtx.setInterpolator(new AccelerateInterpolator());
                }
                if (this.jtu == null) {
                    this.jtu = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.jtu.setDuration(800L);
                    this.jtu.setInterpolator(new AccelerateInterpolator());
                    this.jtw = new a();
                    this.jtu.addListener(this.jtw);
                    this.jtu.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.jtv.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.jtv.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cGB()) {
                    i = 1;
                } else {
                    i = cGC() ? 2 : 0;
                }
                if (view == this.jsV) {
                    qH(1 != i);
                    qI(false);
                    i2 = 1;
                } else if (view == this.jsW) {
                    qI(2 != i);
                    qH(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new aq("c13352").aj("obj_type", i2).u("topic_id", this.jsS.topicId).aj("obj_source", this.jsS.from));
                if (this.jtE != null) {
                    this.jtE.Bm(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.jsS.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.jsS.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.jsS.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jsS != null) {
            W(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void W(Canvas canvas) {
        float y = this.jsV.getY() + ((this.mBtnHeight - this.jtq) / 2);
        this.mPaint.setShader(new LinearGradient(this.jti / 2, y, this.jtr, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jti / 2, y, this.jtr, y + this.jtq, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.jtr, y, this.mWidth - (this.jti / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jtr, y, this.mWidth - (this.jti / 2), y + this.jtq, this.mPaint);
    }

    public void setUserColor(int i) {
        this.jtt = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.jss == null || bVar.jst == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jsS = bVar;
        this.jtb.setText(String.valueOf(bVar.jss.jsu));
        this.jtc.setText(String.valueOf(bVar.jst.jsu));
        this.jtC = new RelativeLayout.LayoutParams(-2, -2);
        this.jtC.addRule(12);
        this.jtD = new RelativeLayout.LayoutParams(-2, -2);
        this.jtD.addRule(12);
        this.jtD.addRule(11);
        this.jte.setLayoutParams(this.jtC);
        this.jtf.setLayoutParams(this.jtD);
        if (bVar.from == 3) {
            this.jte.setText(StringUtils.isNull(bVar.jss.jsv) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.jss.jsv);
            this.jtf.setText(StringUtils.isNull(bVar.jst.jsv) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.jst.jsv);
            if (StringUtils.isNull(bVar.jss.jsw)) {
                this.jsT.setVisibility(4);
            } else {
                this.jsT.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jss.jsw));
            }
            if (StringUtils.isNull(bVar.jst.jsw)) {
                this.jsU.setVisibility(4);
            } else {
                this.jsU.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jst.jsw));
            }
        } else {
            this.jte.setText(bVar.jss.jsv);
            this.jtf.setText(bVar.jst.jsv);
            this.jsT.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jss.jsw));
            this.jsU.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jst.jsw));
        }
        this.jsX.startLoad(bVar.jss.jsx, 10, false);
        this.jsY.startLoad(bVar.jst.jsx, 10, false);
        this.jsZ.startLoad(bVar.jss.jsA, 10, false);
        this.jta.startLoad(bVar.jst.jsA, 10, false);
        if (bVar.jss.jsy) {
            this.jsX.setVisibility(4);
            this.jsZ.setVisibility(0);
        } else {
            this.jsX.setVisibility(0);
            this.jsZ.setVisibility(4);
        }
        if (bVar.jst.jsy) {
            this.jsY.setVisibility(4);
            this.jta.setVisibility(0);
        } else {
            this.jsY.setVisibility(0);
            this.jta.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jsT, this.jtt);
        ap.setViewTextColor(this.jsU, this.jtt);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.jsX.setIsNight(this.mSkinType == 1);
            this.jsY.setIsNight(this.mSkinType == 1);
            this.jsZ.setIsNight(this.mSkinType == 1);
            this.jta.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.jsV, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.jsW, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.jtg, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jth, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jtd, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.jtb, R.color.cp_cont_a);
            ap.setViewTextColor(this.jtc, R.color.cp_cont_a);
            ap.setViewTextColor(this.jte, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.jtf, R.color.topic_disagree_des_color);
        }
    }

    private void qH(boolean z) {
        if (z) {
            this.jsT.setVisibility(0);
            this.jsT.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jsS.jss.jsw = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jsS.jss.jsy = true;
            TextView textView = this.jtb;
            b.a aVar = this.jsS.jss;
            long j = aVar.jsu + 1;
            aVar.jsu = j;
            textView.setText(String.valueOf(j));
            this.jtg.setVisibility(0);
            this.jtv = this.jsZ;
            this.jtw.jtH = this.jsZ;
            this.jtw.jtI = this.jsX;
            this.jtg.setVisibility(0);
            this.jtu.start();
            this.jty = this.jtg.getX();
            this.jtz = this.jtg.getY();
            this.jtA = this.jtg.getX();
            this.jtB = this.jtg.getY();
            this.jtx.removeAllUpdateListeners();
            this.jtx.addUpdateListener(this.jtF);
            this.jtx.setFloatValues(0.0f, 2.0f);
            this.jtx.start();
            return;
        }
        if (at.equals(this.jsS.jss.jsw, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jsT.setVisibility(4);
        }
        if (this.jsS.jss.jsy) {
            this.jsS.jss.jsy = false;
            TextView textView2 = this.jtb;
            b.a aVar2 = this.jsS.jss;
            long j2 = aVar2.jsu - 1;
            aVar2.jsu = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jsX.setVisibility(0);
        this.jsZ.setVisibility(4);
    }

    private void qI(boolean z) {
        if (z) {
            this.jsU.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jsU.setVisibility(0);
            this.jsS.jst.jsw = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jth.setVisibility(0);
            this.jsS.jst.jsy = true;
            TextView textView = this.jtc;
            b.a aVar = this.jsS.jst;
            long j = aVar.jsu + 1;
            aVar.jsu = j;
            textView.setText(String.valueOf(j));
            this.jty = this.jth.getX() - (this.jts / 2.0f);
            this.jtv = this.jta;
            this.jtw.jtH = this.jta;
            this.jtw.jtI = this.jsY;
            this.jtg.setVisibility(0);
            this.jtu.start();
            this.jty = this.jth.getX() - (this.jts / 2);
            this.jtz = this.jth.getY();
            this.jtA = this.jth.getX();
            this.jtB = this.jth.getY();
            this.jtx.removeAllUpdateListeners();
            this.jtx.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.jth.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jty) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.jti) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jti / 2)))));
                        TopicPkView.this.jth.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jtz) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.jth.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jti / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.jth.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.jth.setVisibility(4);
                        TopicPkView.this.jth.setX(TopicPkView.this.jtA);
                        TopicPkView.this.jth.setY(TopicPkView.this.jtB);
                    }
                }
            });
            this.jtx.setFloatValues(0.0f, 2.0f);
            this.jtx.start();
            return;
        }
        if (at.equals(this.jsS.jst.jsw, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jsU.setVisibility(4);
        }
        if (this.jsS.jst.jsy) {
            this.jsS.jst.jsy = false;
            TextView textView2 = this.jtc;
            b.a aVar2 = this.jsS.jst;
            long j2 = aVar2.jsu - 1;
            aVar2.jsu = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jth.setVisibility(4);
        this.jsY.setVisibility(0);
        this.jta.setVisibility(4);
    }

    private boolean cGB() {
        return (this.jsS == null || this.jsS.jss == null || !this.jsS.jss.jsy) ? false : true;
    }

    private boolean cGC() {
        return (this.jsS == null || this.jsS.jst == null || !this.jsS.jst.jsy) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.jtu != null) {
            this.jtu.cancel();
        }
        if (this.jtx != null) {
            this.jtx.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.jtE = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a implements Animator.AnimatorListener {
        private View jtH;
        private View jtI;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.jtH != null) {
                this.jtH.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.jtI != null) {
                this.jtI.setVisibility(8);
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
