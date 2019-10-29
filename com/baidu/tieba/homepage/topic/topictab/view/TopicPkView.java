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
    private int bhK;
    private int cmu;
    private com.baidu.tieba.homepage.topic.topictab.b.b gpM;
    private TextView gpN;
    private TextView gpO;
    private FrameLayout gpP;
    private FrameLayout gpQ;
    private TbImageView gpR;
    private TbImageView gpS;
    private TbImageView gpT;
    private TbImageView gpU;
    private TextView gpV;
    private TextView gpW;
    private ImageView gpX;
    private TextView gpY;
    private TextView gpZ;
    private ImageView gqa;
    private ImageView gqb;
    private int gqc;
    private int gqd;
    private int gqe;
    private int gqf;
    private int gqg;
    private int gqh;
    private int gqi;
    private int gqj;
    private int gqk;
    private int gql;
    private int gqm;
    private ValueAnimator gqn;
    private View gqo;
    private a gqp;
    private ValueAnimator gqq;
    private double gqr;
    private double gqs;
    private float gqt;
    private float gqu;
    private RelativeLayout.LayoutParams gqv;
    private RelativeLayout.LayoutParams gqw;
    private b gqx;
    private ValueAnimator.AnimatorUpdateListener gqy;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void tj(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gqm = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gqy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gqa.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqr) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gqc - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gpP.getX() + (TopicPkView.this.gqc / 2)))));
                    TopicPkView.this.gqa.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqs) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gqa.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.gpP.getX() + (TopicPkView.this.gqc / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gpP.getX() + (TopicPkView.this.gqc / 2)))));
                    TopicPkView.this.gqa.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gqa.setVisibility(4);
                    TopicPkView.this.gqa.setX(TopicPkView.this.gqt);
                    TopicPkView.this.gqa.setY(TopicPkView.this.gqu);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gqm = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gqy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gqa.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqr) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gqc - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gpP.getX() + (TopicPkView.this.gqc / 2)))));
                    TopicPkView.this.gqa.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqs) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gqa.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.gpP.getX() + (TopicPkView.this.gqc / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gpP.getX() + (TopicPkView.this.gqc / 2)))));
                    TopicPkView.this.gqa.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gqa.setVisibility(4);
                    TopicPkView.this.gqa.setX(TopicPkView.this.gqt);
                    TopicPkView.this.gqa.setY(TopicPkView.this.gqu);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gqm = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gqy = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gqa.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqr) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gqc - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gpP.getX() + (TopicPkView.this.gqc / 2)))));
                    TopicPkView.this.gqa.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqs) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gqa.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.gpP.getX() + (TopicPkView.this.gqc / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gpP.getX() + (TopicPkView.this.gqc / 2)))));
                    TopicPkView.this.gqa.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gqa.setVisibility(4);
                    TopicPkView.this.gqa.setX(TopicPkView.this.gqt);
                    TopicPkView.this.gqa.setY(TopicPkView.this.gqu);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.gpN = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.gpO = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.gpP = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.gpQ = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.gpR = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.gpS = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.gpT = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.gpU = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.gpV = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.gpW = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.gpX = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.gpY = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.gpZ = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.gqa = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.gqb = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.gpR.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.gpS.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.gpT.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.gpU.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.gpP.setOnClickListener(this);
        this.gpQ.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.gqj = l.getDimens(context, R.dimen.tbds78);
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
        if (this.gpM != null) {
            this.gqc = this.gpP.getWidth();
            this.bhK = this.gpP.getHeight();
            this.cmu = this.gpR.getWidth();
            this.gqd = this.gpV.getWidth();
            this.gqe = this.gpW.getWidth();
            this.gqh = this.gpV.getHeight();
            this.gqf = this.gpY.getWidth();
            this.gqg = this.gpZ.getWidth();
            this.mCursorWidth = this.gpX.getWidth();
            this.mCursorHeight = this.gpX.getHeight();
            this.gqi = ((this.mWidth - (this.gqc * 2)) - this.gqd) - this.gqe;
            this.gql = this.gqa.getWidth();
            if (this.gpM.gpl.gpn == 0 && this.gpM.gpm.gpn == 0) {
                this.gqk = (int) ((0.5d * this.gqi) + this.gqd + this.gqc);
            } else {
                this.gqk = (int) (((((float) this.gpM.gpl.gpn) / ((float) (this.gpM.gpl.gpn + this.gpM.gpm.gpn))) * this.gqi) + this.gqd + this.gqc);
            }
            float y = this.gpP.getY() - ((this.mCursorHeight - this.bhK) / 2);
            if (this.gqk + (this.mCursorWidth / 2) >= this.gpW.getLeft()) {
                this.gqk = (this.gpW.getLeft() - 10) - (this.mCursorWidth / 2);
                this.gpX.layout((this.gpW.getLeft() - 10) - this.mCursorWidth, (int) y, this.gpW.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.gqk - (this.mCursorWidth / 2) <= this.gpV.getRight()) {
                this.gqk = this.gpV.getRight() + 10 + (this.mCursorWidth / 2);
                this.gpX.layout(this.gpV.getRight() + 10, (int) y, this.gpV.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.gpX.layout(this.gqk - (this.mCursorWidth / 2), (int) y, this.gqk + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.gpR.getX());
            if (this.gqf < this.cmu) {
                int i5 = (this.gqc - this.gqf) / 2;
                this.gpY.layout(i5, (int) this.gpY.getY(), this.gqf + i5, ((int) this.gpY.getY()) + this.gqh);
            } else if (this.gqf <= x) {
                this.gpY.layout((int) this.gpR.getX(), (int) this.gpY.getY(), ((int) this.gpR.getX()) + this.gqf, ((int) this.gpY.getY()) + this.gqh);
            } else {
                ViewGroup.LayoutParams layoutParams = this.gpY.getLayoutParams();
                layoutParams.width = x;
                this.gpY.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.gqg < this.cmu) {
                int x2 = ((int) this.gpQ.getX()) + ((this.gqc - this.gqg) / 2);
                this.gpZ.layout(x2, (int) this.gpZ.getY(), this.gqg + x2, ((int) this.gpZ.getY()) + this.gqh);
            } else if (this.gqg <= x) {
                this.gpZ.layout((this.mWidth - ((int) this.gpS.getX())) - this.gqg, (int) this.gpZ.getY(), this.mWidth - ((int) this.gpS.getX()), ((int) this.gpZ.getY()) + this.gqh);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.gpZ.getLayoutParams();
                layoutParams2.width = x;
                this.gpZ.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.gqc - this.gql) / 2;
            this.gqa.layout(((int) this.gpP.getX()) + i6, ((int) this.gpP.getY()) + i6, ((int) this.gpP.getX()) + i6 + this.gql, ((int) this.gpP.getY()) + i6 + this.gql);
            this.gqb.layout(((int) this.gpQ.getX()) + i6, ((int) this.gpQ.getY()) + i6, ((int) this.gpQ.getX()) + i6 + this.gql, i6 + ((int) this.gpQ.getY()) + this.gql);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.gpM.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.gqn == null || !this.gqn.isRunning()) {
            if (this.gqq == null || !this.gqq.isRunning()) {
                if (this.gqq == null) {
                    this.gqq = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.gqq.setDuration(800L);
                    this.gqq.setInterpolator(new AccelerateInterpolator());
                }
                if (this.gqn == null) {
                    this.gqn = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.gqn.setDuration(800L);
                    this.gqn.setInterpolator(new AccelerateInterpolator());
                    this.gqp = new a();
                    this.gqn.addListener(this.gqp);
                    this.gqn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.gqo.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.gqo.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bvG()) {
                    i = 1;
                } else {
                    i = bvH() ? 2 : 0;
                }
                if (view == this.gpP) {
                    lq(1 != i);
                    lr(false);
                    i2 = 1;
                } else if (view == this.gpQ) {
                    lr(2 != i);
                    lq(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").O("obj_type", i2).p("topic_id", this.gpM.topicId).O("obj_source", this.gpM.from));
                if (this.gqx != null) {
                    this.gqx.tj(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.gpM.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.gpM.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.gpM.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.gpM != null) {
            N(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void N(Canvas canvas) {
        float y = this.gpP.getY() + ((this.bhK - this.gqj) / 2);
        this.mPaint.setShader(new LinearGradient(this.gqc / 2, y, this.gqk, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.gqc / 2, y, this.gqk, y + this.gqj, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.gqk, y, this.mWidth - (this.gqc / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.gqk, y, this.mWidth - (this.gqc / 2), y + this.gqj, this.mPaint);
    }

    public void setUserColor(int i) {
        this.gqm = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.gpl == null || bVar.gpm == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gpM = bVar;
        this.gpV.setText(String.valueOf(bVar.gpl.gpn));
        this.gpW.setText(String.valueOf(bVar.gpm.gpn));
        this.gqv = new RelativeLayout.LayoutParams(-2, -2);
        this.gqv.addRule(12);
        this.gqw = new RelativeLayout.LayoutParams(-2, -2);
        this.gqw.addRule(12);
        this.gqw.addRule(11);
        this.gpY.setLayoutParams(this.gqv);
        this.gpZ.setLayoutParams(this.gqw);
        if (bVar.from == 3) {
            this.gpY.setText(StringUtils.isNull(bVar.gpl.gpo) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.gpl.gpo);
            this.gpZ.setText(StringUtils.isNull(bVar.gpm.gpo) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.gpm.gpo);
            if (StringUtils.isNull(bVar.gpl.gpp)) {
                this.gpN.setVisibility(4);
            } else {
                this.gpN.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gpl.gpp));
            }
            if (StringUtils.isNull(bVar.gpm.gpp)) {
                this.gpO.setVisibility(4);
            } else {
                this.gpO.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gpm.gpp));
            }
        } else {
            this.gpY.setText(bVar.gpl.gpo);
            this.gpZ.setText(bVar.gpm.gpo);
            this.gpN.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gpl.gpp));
            this.gpO.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gpm.gpp));
        }
        this.gpR.startLoad(bVar.gpl.gpq, 10, false);
        this.gpS.startLoad(bVar.gpm.gpq, 10, false);
        this.gpT.startLoad(bVar.gpl.gpt, 10, false);
        this.gpU.startLoad(bVar.gpm.gpt, 10, false);
        if (bVar.gpl.gpr) {
            this.gpR.setVisibility(4);
            this.gpT.setVisibility(0);
        } else {
            this.gpR.setVisibility(0);
            this.gpT.setVisibility(4);
        }
        if (bVar.gpm.gpr) {
            this.gpS.setVisibility(4);
            this.gpU.setVisibility(0);
        } else {
            this.gpS.setVisibility(0);
            this.gpU.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.gpN, this.gqm);
        am.setViewTextColor(this.gpO, this.gqm);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.setBackgroundResource(this.gpP, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.gpQ, R.drawable.btn_topic_disagree_bg_blue);
            this.gpR.setIsNight(this.mSkinType == 1);
            this.gpS.setIsNight(this.mSkinType == 1);
            this.gpT.setIsNight(this.mSkinType == 1);
            this.gpU.setIsNight(this.mSkinType == 1);
            am.setViewTextColor(this.gpV, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.gpW, (int) R.color.cp_cont_a);
            am.setImageResource(this.gpX, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.gpY, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.gpZ, (int) R.color.topic_disagree_des_color);
            am.setImageResource(this.gqa, R.drawable.pic_topic_addone);
            am.setImageResource(this.gqb, R.drawable.pic_topic_addone);
        }
    }

    private void lq(boolean z) {
        if (z) {
            this.gpN.setVisibility(0);
            this.gpN.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.gpM.gpl.gpp = TbadkCoreApplication.getCurrentAccountNameShow();
            this.gpM.gpl.gpr = true;
            TextView textView = this.gpV;
            b.a aVar = this.gpM.gpl;
            long j = aVar.gpn + 1;
            aVar.gpn = j;
            textView.setText(String.valueOf(j));
            this.gqa.setVisibility(0);
            this.gqo = this.gpT;
            this.gqp.gqA = this.gpT;
            this.gqp.gqB = this.gpR;
            this.gqa.setVisibility(0);
            this.gqn.start();
            this.gqr = this.gqa.getX();
            this.gqs = this.gqa.getY();
            this.gqt = this.gqa.getX();
            this.gqu = this.gqa.getY();
            this.gqq.removeAllUpdateListeners();
            this.gqq.addUpdateListener(this.gqy);
            this.gqq.setFloatValues(0.0f, 2.0f);
            this.gqq.start();
            return;
        }
        if (aq.equals(this.gpM.gpl.gpp, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.gpN.setVisibility(4);
        }
        if (this.gpM.gpl.gpr) {
            this.gpM.gpl.gpr = false;
            TextView textView2 = this.gpV;
            b.a aVar2 = this.gpM.gpl;
            long j2 = aVar2.gpn - 1;
            aVar2.gpn = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.gpR.setVisibility(0);
        this.gpT.setVisibility(4);
    }

    private void lr(boolean z) {
        if (z) {
            this.gpO.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.gpO.setVisibility(0);
            this.gpM.gpm.gpp = TbadkCoreApplication.getCurrentAccountNameShow();
            this.gqb.setVisibility(0);
            this.gpM.gpm.gpr = true;
            TextView textView = this.gpW;
            b.a aVar = this.gpM.gpm;
            long j = aVar.gpn + 1;
            aVar.gpn = j;
            textView.setText(String.valueOf(j));
            this.gqr = this.gqb.getX() - (this.gql / 2.0f);
            this.gqo = this.gpU;
            this.gqp.gqA = this.gpU;
            this.gqp.gqB = this.gpS;
            this.gqa.setVisibility(0);
            this.gqn.start();
            this.gqr = this.gqb.getX() - (this.gql / 2);
            this.gqs = this.gqb.getY();
            this.gqt = this.gqb.getX();
            this.gqu = this.gqb.getY();
            this.gqq.removeAllUpdateListeners();
            this.gqq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.gqb.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqr) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.gqc) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.gqc / 2)))));
                        TopicPkView.this.gqb.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gqs) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.gqb.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.gqc / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.gqb.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.gqb.setVisibility(4);
                        TopicPkView.this.gqb.setX(TopicPkView.this.gqt);
                        TopicPkView.this.gqb.setY(TopicPkView.this.gqu);
                    }
                }
            });
            this.gqq.setFloatValues(0.0f, 2.0f);
            this.gqq.start();
            return;
        }
        if (aq.equals(this.gpM.gpm.gpp, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.gpO.setVisibility(4);
        }
        if (this.gpM.gpm.gpr) {
            this.gpM.gpm.gpr = false;
            TextView textView2 = this.gpW;
            b.a aVar2 = this.gpM.gpm;
            long j2 = aVar2.gpn - 1;
            aVar2.gpn = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.gqb.setVisibility(4);
        this.gpS.setVisibility(0);
        this.gpU.setVisibility(4);
    }

    private boolean bvG() {
        return (this.gpM == null || this.gpM.gpl == null || !this.gpM.gpl.gpr) ? false : true;
    }

    private boolean bvH() {
        return (this.gpM == null || this.gpM.gpm == null || !this.gpM.gpm.gpr) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gqn != null) {
            this.gqn.cancel();
        }
        if (this.gqq != null) {
            this.gqq.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.gqx = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View gqA;
        private View gqB;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.gqA != null) {
                this.gqA.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.gqB != null) {
                this.gqB.setVisibility(8);
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
