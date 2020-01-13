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
/* loaded from: classes7.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private com.baidu.tieba.homepage.topic.topictab.b.b hfZ;
    private int hgA;
    private ValueAnimator hgB;
    private View hgC;
    private a hgD;
    private ValueAnimator hgE;
    private double hgF;
    private double hgG;
    private float hgH;
    private float hgI;
    private RelativeLayout.LayoutParams hgJ;
    private RelativeLayout.LayoutParams hgK;
    private b hgL;
    private ValueAnimator.AnimatorUpdateListener hgM;
    private TextView hga;
    private TextView hgb;
    private FrameLayout hgc;
    private FrameLayout hgd;
    private TbImageView hge;
    private TbImageView hgf;
    private TbImageView hgg;
    private TbImageView hgh;
    private TextView hgi;
    private TextView hgj;
    private ImageView hgk;
    private TextView hgl;
    private TextView hgm;
    private ImageView hgn;
    private ImageView hgo;
    private int hgp;
    private int hgq;
    private int hgr;
    private int hgs;
    private int hgt;
    private int hgu;
    private int hgv;
    private int hgw;
    private int hgx;
    private int hgy;
    private int hgz;
    private int mBtnHeight;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes7.dex */
    public interface b {
        void vp(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hgA = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hgM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hgn.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hgF) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hgp - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hgc.getX() + (TopicPkView.this.hgp / 2)))));
                    TopicPkView.this.hgn.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hgG) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hgn.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hgc.getX() + (TopicPkView.this.hgp / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hgc.getX() + (TopicPkView.this.hgp / 2)))));
                    TopicPkView.this.hgn.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hgn.setVisibility(4);
                    TopicPkView.this.hgn.setX(TopicPkView.this.hgH);
                    TopicPkView.this.hgn.setY(TopicPkView.this.hgI);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hgA = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hgM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hgn.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hgF) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hgp - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hgc.getX() + (TopicPkView.this.hgp / 2)))));
                    TopicPkView.this.hgn.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hgG) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hgn.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hgc.getX() + (TopicPkView.this.hgp / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hgc.getX() + (TopicPkView.this.hgp / 2)))));
                    TopicPkView.this.hgn.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hgn.setVisibility(4);
                    TopicPkView.this.hgn.setX(TopicPkView.this.hgH);
                    TopicPkView.this.hgn.setY(TopicPkView.this.hgI);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hgA = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hgM = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hgn.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hgF) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hgp - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hgc.getX() + (TopicPkView.this.hgp / 2)))));
                    TopicPkView.this.hgn.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hgG) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hgn.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hgc.getX() + (TopicPkView.this.hgp / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hgc.getX() + (TopicPkView.this.hgp / 2)))));
                    TopicPkView.this.hgn.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hgn.setVisibility(4);
                    TopicPkView.this.hgn.setX(TopicPkView.this.hgH);
                    TopicPkView.this.hgn.setY(TopicPkView.this.hgI);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.hga = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.hgb = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.hgc = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.hgd = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.hge = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.hgf = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.hgg = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.hgh = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.hgi = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.hgj = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.hgk = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.hgl = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.hgm = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.hgn = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.hgo = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.hge.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.hgf.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.hgg.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.hgh.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.hgc.setOnClickListener(this);
        this.hgd.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.hgx = l.getDimens(context, R.dimen.tbds62);
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
        if (this.hfZ != null) {
            this.hgp = this.hgc.getWidth();
            this.mBtnHeight = this.hgc.getHeight();
            this.hgq = this.hge.getWidth();
            this.hgr = this.hgi.getWidth();
            this.hgs = this.hgj.getWidth();
            this.hgv = this.hgi.getHeight();
            this.hgt = this.hgl.getWidth();
            this.hgu = this.hgm.getWidth();
            this.mCursorWidth = this.hgk.getWidth();
            this.mCursorHeight = this.hgk.getHeight();
            this.hgw = ((this.mWidth - (this.hgp * 2)) - this.hgr) - this.hgs;
            this.hgz = this.hgn.getWidth();
            if (this.hfZ.hfy.hfA == 0 && this.hfZ.hfz.hfA == 0) {
                this.hgy = (int) ((0.5d * this.hgw) + this.hgr + this.hgp);
            } else {
                this.hgy = (int) (((((float) this.hfZ.hfy.hfA) / ((float) (this.hfZ.hfy.hfA + this.hfZ.hfz.hfA))) * this.hgw) + this.hgr + this.hgp);
            }
            float y = this.hgc.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.hgy + (this.mCursorWidth / 2) >= this.hgj.getLeft()) {
                this.hgy = (this.hgj.getLeft() - 10) - (this.mCursorWidth / 2);
                this.hgk.layout((this.hgj.getLeft() - 10) - this.mCursorWidth, (int) y, this.hgj.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.hgy - (this.mCursorWidth / 2) <= this.hgi.getRight()) {
                this.hgy = this.hgi.getRight() + 10 + (this.mCursorWidth / 2);
                this.hgk.layout(this.hgi.getRight() + 10, (int) y, this.hgi.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.hgk.layout(this.hgy - (this.mCursorWidth / 2), (int) y, this.hgy + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.hge.getX());
            if (this.hgt < this.hgq) {
                int i5 = (this.hgp - this.hgt) / 2;
                this.hgl.layout(i5, (int) this.hgl.getY(), this.hgt + i5, ((int) this.hgl.getY()) + this.hgv);
            } else if (this.hgt <= x) {
                this.hgl.layout((int) this.hge.getX(), (int) this.hgl.getY(), ((int) this.hge.getX()) + this.hgt, ((int) this.hgl.getY()) + this.hgv);
            } else {
                ViewGroup.LayoutParams layoutParams = this.hgl.getLayoutParams();
                layoutParams.width = x;
                this.hgl.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.hgu < this.hgq) {
                int x2 = ((int) this.hgd.getX()) + ((this.hgp - this.hgu) / 2);
                this.hgm.layout(x2, (int) this.hgm.getY(), this.hgu + x2, ((int) this.hgm.getY()) + this.hgv);
            } else if (this.hgu <= x) {
                this.hgm.layout((this.mWidth - ((int) this.hgf.getX())) - this.hgu, (int) this.hgm.getY(), this.mWidth - ((int) this.hgf.getX()), ((int) this.hgm.getY()) + this.hgv);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.hgm.getLayoutParams();
                layoutParams2.width = x;
                this.hgm.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.hgp - this.hgz) / 2;
            this.hgn.layout(((int) this.hgc.getX()) + i6, ((int) this.hgc.getY()) + i6, ((int) this.hgc.getX()) + i6 + this.hgz, ((int) this.hgc.getY()) + i6 + this.hgz);
            this.hgo.layout(((int) this.hgd.getX()) + i6, ((int) this.hgd.getY()) + i6, ((int) this.hgd.getX()) + i6 + this.hgz, i6 + ((int) this.hgd.getY()) + this.hgz);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.hfZ.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.hgB == null || !this.hgB.isRunning()) {
            if (this.hgE == null || !this.hgE.isRunning()) {
                if (this.hgE == null) {
                    this.hgE = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.hgE.setDuration(800L);
                    this.hgE.setInterpolator(new AccelerateInterpolator());
                }
                if (this.hgB == null) {
                    this.hgB = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.hgB.setDuration(800L);
                    this.hgB.setInterpolator(new AccelerateInterpolator());
                    this.hgD = new a();
                    this.hgB.addListener(this.hgD);
                    this.hgB.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.hgC.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.hgC.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bOa()) {
                    i = 1;
                } else {
                    i = bOb() ? 2 : 0;
                }
                if (view == this.hgc) {
                    mO(1 != i);
                    mP(false);
                    i2 = 1;
                } else if (view == this.hgd) {
                    mP(2 != i);
                    mO(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").Z("obj_type", i2).s("topic_id", this.hfZ.topicId).Z("obj_source", this.hfZ.from));
                if (this.hgL != null) {
                    this.hgL.vp(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.hfZ.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.hfZ.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.hfZ.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.hfZ != null) {
            K(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void K(Canvas canvas) {
        float y = this.hgc.getY() + ((this.mBtnHeight - this.hgx) / 2);
        this.mPaint.setShader(new LinearGradient(this.hgp / 2, y, this.hgy, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hgp / 2, y, this.hgy, y + this.hgx, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.hgy, y, this.mWidth - (this.hgp / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hgy, y, this.mWidth - (this.hgp / 2), y + this.hgx, this.mPaint);
    }

    public void setUserColor(int i) {
        this.hgA = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.hfy == null || bVar.hfz == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hfZ = bVar;
        this.hgi.setText(String.valueOf(bVar.hfy.hfA));
        this.hgj.setText(String.valueOf(bVar.hfz.hfA));
        this.hgJ = new RelativeLayout.LayoutParams(-2, -2);
        this.hgJ.addRule(12);
        this.hgK = new RelativeLayout.LayoutParams(-2, -2);
        this.hgK.addRule(12);
        this.hgK.addRule(11);
        this.hgl.setLayoutParams(this.hgJ);
        this.hgm.setLayoutParams(this.hgK);
        if (bVar.from == 3) {
            this.hgl.setText(StringUtils.isNull(bVar.hfy.hfB) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.hfy.hfB);
            this.hgm.setText(StringUtils.isNull(bVar.hfz.hfB) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.hfz.hfB);
            if (StringUtils.isNull(bVar.hfy.hfC)) {
                this.hga.setVisibility(4);
            } else {
                this.hga.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hfy.hfC));
            }
            if (StringUtils.isNull(bVar.hfz.hfC)) {
                this.hgb.setVisibility(4);
            } else {
                this.hgb.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hfz.hfC));
            }
        } else {
            this.hgl.setText(bVar.hfy.hfB);
            this.hgm.setText(bVar.hfz.hfB);
            this.hga.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hfy.hfC));
            this.hgb.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hfz.hfC));
        }
        this.hge.startLoad(bVar.hfy.hfD, 10, false);
        this.hgf.startLoad(bVar.hfz.hfD, 10, false);
        this.hgg.startLoad(bVar.hfy.hfG, 10, false);
        this.hgh.startLoad(bVar.hfz.hfG, 10, false);
        if (bVar.hfy.hfE) {
            this.hge.setVisibility(4);
            this.hgg.setVisibility(0);
        } else {
            this.hge.setVisibility(0);
            this.hgg.setVisibility(4);
        }
        if (bVar.hfz.hfE) {
            this.hgf.setVisibility(4);
            this.hgh.setVisibility(0);
        } else {
            this.hgf.setVisibility(0);
            this.hgh.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.hga, this.hgA);
        am.setViewTextColor(this.hgb, this.hgA);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.hge.setIsNight(this.mSkinType == 1);
            this.hgf.setIsNight(this.mSkinType == 1);
            this.hgg.setIsNight(this.mSkinType == 1);
            this.hgh.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.hgc, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.hgd, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.hgn, R.drawable.pic_topic_addone);
            am.setImageResource(this.hgo, R.drawable.pic_topic_addone);
            am.setImageResource(this.hgk, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.hgi, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hgj, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hgl, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.hgm, (int) R.color.topic_disagree_des_color);
        }
    }

    private void mO(boolean z) {
        if (z) {
            this.hga.setVisibility(0);
            this.hga.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hfZ.hfy.hfC = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hfZ.hfy.hfE = true;
            TextView textView = this.hgi;
            b.a aVar = this.hfZ.hfy;
            long j = aVar.hfA + 1;
            aVar.hfA = j;
            textView.setText(String.valueOf(j));
            this.hgn.setVisibility(0);
            this.hgC = this.hgg;
            this.hgD.hgO = this.hgg;
            this.hgD.hgP = this.hge;
            this.hgn.setVisibility(0);
            this.hgB.start();
            this.hgF = this.hgn.getX();
            this.hgG = this.hgn.getY();
            this.hgH = this.hgn.getX();
            this.hgI = this.hgn.getY();
            this.hgE.removeAllUpdateListeners();
            this.hgE.addUpdateListener(this.hgM);
            this.hgE.setFloatValues(0.0f, 2.0f);
            this.hgE.start();
            return;
        }
        if (aq.equals(this.hfZ.hfy.hfC, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hga.setVisibility(4);
        }
        if (this.hfZ.hfy.hfE) {
            this.hfZ.hfy.hfE = false;
            TextView textView2 = this.hgi;
            b.a aVar2 = this.hfZ.hfy;
            long j2 = aVar2.hfA - 1;
            aVar2.hfA = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hge.setVisibility(0);
        this.hgg.setVisibility(4);
    }

    private void mP(boolean z) {
        if (z) {
            this.hgb.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hgb.setVisibility(0);
            this.hfZ.hfz.hfC = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hgo.setVisibility(0);
            this.hfZ.hfz.hfE = true;
            TextView textView = this.hgj;
            b.a aVar = this.hfZ.hfz;
            long j = aVar.hfA + 1;
            aVar.hfA = j;
            textView.setText(String.valueOf(j));
            this.hgF = this.hgo.getX() - (this.hgz / 2.0f);
            this.hgC = this.hgh;
            this.hgD.hgO = this.hgh;
            this.hgD.hgP = this.hgf;
            this.hgn.setVisibility(0);
            this.hgB.start();
            this.hgF = this.hgo.getX() - (this.hgz / 2);
            this.hgG = this.hgo.getY();
            this.hgH = this.hgo.getX();
            this.hgI = this.hgo.getY();
            this.hgE.removeAllUpdateListeners();
            this.hgE.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.hgo.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hgF) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.hgp) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hgp / 2)))));
                        TopicPkView.this.hgo.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hgG) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.hgo.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hgp / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.hgo.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.hgo.setVisibility(4);
                        TopicPkView.this.hgo.setX(TopicPkView.this.hgH);
                        TopicPkView.this.hgo.setY(TopicPkView.this.hgI);
                    }
                }
            });
            this.hgE.setFloatValues(0.0f, 2.0f);
            this.hgE.start();
            return;
        }
        if (aq.equals(this.hfZ.hfz.hfC, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hgb.setVisibility(4);
        }
        if (this.hfZ.hfz.hfE) {
            this.hfZ.hfz.hfE = false;
            TextView textView2 = this.hgj;
            b.a aVar2 = this.hfZ.hfz;
            long j2 = aVar2.hfA - 1;
            aVar2.hfA = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hgo.setVisibility(4);
        this.hgf.setVisibility(0);
        this.hgh.setVisibility(4);
    }

    private boolean bOa() {
        return (this.hfZ == null || this.hfZ.hfy == null || !this.hfZ.hfy.hfE) ? false : true;
    }

    private boolean bOb() {
        return (this.hfZ == null || this.hfZ.hfz == null || !this.hfZ.hfz.hfE) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.hgB != null) {
            this.hgB.cancel();
        }
        if (this.hgE != null) {
            this.hgE.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.hgL = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes7.dex */
    public static class a implements Animator.AnimatorListener {
        private View hgO;
        private View hgP;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.hgO != null) {
                this.hgO.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.hgP != null) {
                this.hgP.setVisibility(8);
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
