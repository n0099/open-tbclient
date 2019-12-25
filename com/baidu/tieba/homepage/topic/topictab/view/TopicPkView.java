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
/* loaded from: classes6.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private FrameLayout hcA;
    private TbImageView hcB;
    private TbImageView hcC;
    private TbImageView hcD;
    private TbImageView hcE;
    private TextView hcF;
    private TextView hcG;
    private ImageView hcH;
    private TextView hcI;
    private TextView hcJ;
    private ImageView hcK;
    private ImageView hcL;
    private int hcM;
    private int hcN;
    private int hcO;
    private int hcP;
    private int hcQ;
    private int hcR;
    private int hcS;
    private int hcT;
    private int hcU;
    private int hcV;
    private int hcW;
    private int hcX;
    private ValueAnimator hcY;
    private View hcZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b hcw;
    private TextView hcx;
    private TextView hcy;
    private FrameLayout hcz;
    private a hda;
    private ValueAnimator hdb;
    private double hdc;
    private double hdd;
    private float hde;
    private float hdf;
    private RelativeLayout.LayoutParams hdg;
    private RelativeLayout.LayoutParams hdh;
    private b hdi;
    private ValueAnimator.AnimatorUpdateListener hdj;
    private int mBtnHeight;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes6.dex */
    public interface b {
        void vk(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hcX = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hdj = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hcK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hdc) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hcM - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hcz.getX() + (TopicPkView.this.hcM / 2)))));
                    TopicPkView.this.hcK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hdd) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hcK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hcz.getX() + (TopicPkView.this.hcM / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hcz.getX() + (TopicPkView.this.hcM / 2)))));
                    TopicPkView.this.hcK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hcK.setVisibility(4);
                    TopicPkView.this.hcK.setX(TopicPkView.this.hde);
                    TopicPkView.this.hcK.setY(TopicPkView.this.hdf);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hcX = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hdj = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hcK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hdc) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hcM - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hcz.getX() + (TopicPkView.this.hcM / 2)))));
                    TopicPkView.this.hcK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hdd) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hcK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hcz.getX() + (TopicPkView.this.hcM / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hcz.getX() + (TopicPkView.this.hcM / 2)))));
                    TopicPkView.this.hcK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hcK.setVisibility(4);
                    TopicPkView.this.hcK.setX(TopicPkView.this.hde);
                    TopicPkView.this.hcK.setY(TopicPkView.this.hdf);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hcX = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hdj = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hcK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hdc) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hcM - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hcz.getX() + (TopicPkView.this.hcM / 2)))));
                    TopicPkView.this.hcK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hdd) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hcK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hcz.getX() + (TopicPkView.this.hcM / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hcz.getX() + (TopicPkView.this.hcM / 2)))));
                    TopicPkView.this.hcK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hcK.setVisibility(4);
                    TopicPkView.this.hcK.setX(TopicPkView.this.hde);
                    TopicPkView.this.hcK.setY(TopicPkView.this.hdf);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.hcx = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.hcy = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.hcz = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.hcA = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.hcB = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.hcC = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.hcD = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.hcE = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.hcF = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.hcG = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.hcH = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.hcI = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.hcJ = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.hcK = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.hcL = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.hcB.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.hcC.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.hcD.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.hcE.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.hcz.setOnClickListener(this);
        this.hcA.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.hcU = l.getDimens(context, R.dimen.tbds62);
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
        if (this.hcw != null) {
            this.hcM = this.hcz.getWidth();
            this.mBtnHeight = this.hcz.getHeight();
            this.hcN = this.hcB.getWidth();
            this.hcO = this.hcF.getWidth();
            this.hcP = this.hcG.getWidth();
            this.hcS = this.hcF.getHeight();
            this.hcQ = this.hcI.getWidth();
            this.hcR = this.hcJ.getWidth();
            this.mCursorWidth = this.hcH.getWidth();
            this.mCursorHeight = this.hcH.getHeight();
            this.hcT = ((this.mWidth - (this.hcM * 2)) - this.hcO) - this.hcP;
            this.hcW = this.hcK.getWidth();
            if (this.hcw.hbV.hbX == 0 && this.hcw.hbW.hbX == 0) {
                this.hcV = (int) ((0.5d * this.hcT) + this.hcO + this.hcM);
            } else {
                this.hcV = (int) (((((float) this.hcw.hbV.hbX) / ((float) (this.hcw.hbV.hbX + this.hcw.hbW.hbX))) * this.hcT) + this.hcO + this.hcM);
            }
            float y = this.hcz.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.hcV + (this.mCursorWidth / 2) >= this.hcG.getLeft()) {
                this.hcV = (this.hcG.getLeft() - 10) - (this.mCursorWidth / 2);
                this.hcH.layout((this.hcG.getLeft() - 10) - this.mCursorWidth, (int) y, this.hcG.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.hcV - (this.mCursorWidth / 2) <= this.hcF.getRight()) {
                this.hcV = this.hcF.getRight() + 10 + (this.mCursorWidth / 2);
                this.hcH.layout(this.hcF.getRight() + 10, (int) y, this.hcF.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.hcH.layout(this.hcV - (this.mCursorWidth / 2), (int) y, this.hcV + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.hcB.getX());
            if (this.hcQ < this.hcN) {
                int i5 = (this.hcM - this.hcQ) / 2;
                this.hcI.layout(i5, (int) this.hcI.getY(), this.hcQ + i5, ((int) this.hcI.getY()) + this.hcS);
            } else if (this.hcQ <= x) {
                this.hcI.layout((int) this.hcB.getX(), (int) this.hcI.getY(), ((int) this.hcB.getX()) + this.hcQ, ((int) this.hcI.getY()) + this.hcS);
            } else {
                ViewGroup.LayoutParams layoutParams = this.hcI.getLayoutParams();
                layoutParams.width = x;
                this.hcI.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.hcR < this.hcN) {
                int x2 = ((int) this.hcA.getX()) + ((this.hcM - this.hcR) / 2);
                this.hcJ.layout(x2, (int) this.hcJ.getY(), this.hcR + x2, ((int) this.hcJ.getY()) + this.hcS);
            } else if (this.hcR <= x) {
                this.hcJ.layout((this.mWidth - ((int) this.hcC.getX())) - this.hcR, (int) this.hcJ.getY(), this.mWidth - ((int) this.hcC.getX()), ((int) this.hcJ.getY()) + this.hcS);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.hcJ.getLayoutParams();
                layoutParams2.width = x;
                this.hcJ.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.hcM - this.hcW) / 2;
            this.hcK.layout(((int) this.hcz.getX()) + i6, ((int) this.hcz.getY()) + i6, ((int) this.hcz.getX()) + i6 + this.hcW, ((int) this.hcz.getY()) + i6 + this.hcW);
            this.hcL.layout(((int) this.hcA.getX()) + i6, ((int) this.hcA.getY()) + i6, ((int) this.hcA.getX()) + i6 + this.hcW, i6 + ((int) this.hcA.getY()) + this.hcW);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.hcw.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.hcY == null || !this.hcY.isRunning()) {
            if (this.hdb == null || !this.hdb.isRunning()) {
                if (this.hdb == null) {
                    this.hdb = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.hdb.setDuration(800L);
                    this.hdb.setInterpolator(new AccelerateInterpolator());
                }
                if (this.hcY == null) {
                    this.hcY = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.hcY.setDuration(800L);
                    this.hcY.setInterpolator(new AccelerateInterpolator());
                    this.hda = new a();
                    this.hcY.addListener(this.hda);
                    this.hcY.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.hcZ.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.hcZ.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bMS()) {
                    i = 1;
                } else {
                    i = bMT() ? 2 : 0;
                }
                if (view == this.hcz) {
                    mD(1 != i);
                    mE(false);
                    i2 = 1;
                } else if (view == this.hcA) {
                    mE(2 != i);
                    mD(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").Z("obj_type", i2).s("topic_id", this.hcw.topicId).Z("obj_source", this.hcw.from));
                if (this.hdi != null) {
                    this.hdi.vk(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.hcw.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.hcw.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.hcw.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.hcw != null) {
            K(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void K(Canvas canvas) {
        float y = this.hcz.getY() + ((this.mBtnHeight - this.hcU) / 2);
        this.mPaint.setShader(new LinearGradient(this.hcM / 2, y, this.hcV, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hcM / 2, y, this.hcV, y + this.hcU, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.hcV, y, this.mWidth - (this.hcM / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hcV, y, this.mWidth - (this.hcM / 2), y + this.hcU, this.mPaint);
    }

    public void setUserColor(int i) {
        this.hcX = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.hbV == null || bVar.hbW == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hcw = bVar;
        this.hcF.setText(String.valueOf(bVar.hbV.hbX));
        this.hcG.setText(String.valueOf(bVar.hbW.hbX));
        this.hdg = new RelativeLayout.LayoutParams(-2, -2);
        this.hdg.addRule(12);
        this.hdh = new RelativeLayout.LayoutParams(-2, -2);
        this.hdh.addRule(12);
        this.hdh.addRule(11);
        this.hcI.setLayoutParams(this.hdg);
        this.hcJ.setLayoutParams(this.hdh);
        if (bVar.from == 3) {
            this.hcI.setText(StringUtils.isNull(bVar.hbV.hbY) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.hbV.hbY);
            this.hcJ.setText(StringUtils.isNull(bVar.hbW.hbY) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.hbW.hbY);
            if (StringUtils.isNull(bVar.hbV.hbZ)) {
                this.hcx.setVisibility(4);
            } else {
                this.hcx.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hbV.hbZ));
            }
            if (StringUtils.isNull(bVar.hbW.hbZ)) {
                this.hcy.setVisibility(4);
            } else {
                this.hcy.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hbW.hbZ));
            }
        } else {
            this.hcI.setText(bVar.hbV.hbY);
            this.hcJ.setText(bVar.hbW.hbY);
            this.hcx.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hbV.hbZ));
            this.hcy.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hbW.hbZ));
        }
        this.hcB.startLoad(bVar.hbV.hca, 10, false);
        this.hcC.startLoad(bVar.hbW.hca, 10, false);
        this.hcD.startLoad(bVar.hbV.hcd, 10, false);
        this.hcE.startLoad(bVar.hbW.hcd, 10, false);
        if (bVar.hbV.hcb) {
            this.hcB.setVisibility(4);
            this.hcD.setVisibility(0);
        } else {
            this.hcB.setVisibility(0);
            this.hcD.setVisibility(4);
        }
        if (bVar.hbW.hcb) {
            this.hcC.setVisibility(4);
            this.hcE.setVisibility(0);
        } else {
            this.hcC.setVisibility(0);
            this.hcE.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.hcx, this.hcX);
        am.setViewTextColor(this.hcy, this.hcX);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.hcB.setIsNight(this.mSkinType == 1);
            this.hcC.setIsNight(this.mSkinType == 1);
            this.hcD.setIsNight(this.mSkinType == 1);
            this.hcE.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.hcz, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.hcA, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.hcK, R.drawable.pic_topic_addone);
            am.setImageResource(this.hcL, R.drawable.pic_topic_addone);
            am.setImageResource(this.hcH, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.hcF, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hcG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hcI, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.hcJ, (int) R.color.topic_disagree_des_color);
        }
    }

    private void mD(boolean z) {
        if (z) {
            this.hcx.setVisibility(0);
            this.hcx.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hcw.hbV.hbZ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hcw.hbV.hcb = true;
            TextView textView = this.hcF;
            b.a aVar = this.hcw.hbV;
            long j = aVar.hbX + 1;
            aVar.hbX = j;
            textView.setText(String.valueOf(j));
            this.hcK.setVisibility(0);
            this.hcZ = this.hcD;
            this.hda.hdl = this.hcD;
            this.hda.hdm = this.hcB;
            this.hcK.setVisibility(0);
            this.hcY.start();
            this.hdc = this.hcK.getX();
            this.hdd = this.hcK.getY();
            this.hde = this.hcK.getX();
            this.hdf = this.hcK.getY();
            this.hdb.removeAllUpdateListeners();
            this.hdb.addUpdateListener(this.hdj);
            this.hdb.setFloatValues(0.0f, 2.0f);
            this.hdb.start();
            return;
        }
        if (aq.equals(this.hcw.hbV.hbZ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hcx.setVisibility(4);
        }
        if (this.hcw.hbV.hcb) {
            this.hcw.hbV.hcb = false;
            TextView textView2 = this.hcF;
            b.a aVar2 = this.hcw.hbV;
            long j2 = aVar2.hbX - 1;
            aVar2.hbX = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hcB.setVisibility(0);
        this.hcD.setVisibility(4);
    }

    private void mE(boolean z) {
        if (z) {
            this.hcy.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hcy.setVisibility(0);
            this.hcw.hbW.hbZ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hcL.setVisibility(0);
            this.hcw.hbW.hcb = true;
            TextView textView = this.hcG;
            b.a aVar = this.hcw.hbW;
            long j = aVar.hbX + 1;
            aVar.hbX = j;
            textView.setText(String.valueOf(j));
            this.hdc = this.hcL.getX() - (this.hcW / 2.0f);
            this.hcZ = this.hcE;
            this.hda.hdl = this.hcE;
            this.hda.hdm = this.hcC;
            this.hcK.setVisibility(0);
            this.hcY.start();
            this.hdc = this.hcL.getX() - (this.hcW / 2);
            this.hdd = this.hcL.getY();
            this.hde = this.hcL.getX();
            this.hdf = this.hcL.getY();
            this.hdb.removeAllUpdateListeners();
            this.hdb.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.hcL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hdc) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.hcM) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hcM / 2)))));
                        TopicPkView.this.hcL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hdd) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.hcL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hcM / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.hcL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.hcL.setVisibility(4);
                        TopicPkView.this.hcL.setX(TopicPkView.this.hde);
                        TopicPkView.this.hcL.setY(TopicPkView.this.hdf);
                    }
                }
            });
            this.hdb.setFloatValues(0.0f, 2.0f);
            this.hdb.start();
            return;
        }
        if (aq.equals(this.hcw.hbW.hbZ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hcy.setVisibility(4);
        }
        if (this.hcw.hbW.hcb) {
            this.hcw.hbW.hcb = false;
            TextView textView2 = this.hcG;
            b.a aVar2 = this.hcw.hbW;
            long j2 = aVar2.hbX - 1;
            aVar2.hbX = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hcL.setVisibility(4);
        this.hcC.setVisibility(0);
        this.hcE.setVisibility(4);
    }

    private boolean bMS() {
        return (this.hcw == null || this.hcw.hbV == null || !this.hcw.hbV.hcb) ? false : true;
    }

    private boolean bMT() {
        return (this.hcw == null || this.hcw.hbW == null || !this.hcw.hbW.hcb) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.hcY != null) {
            this.hcY.cancel();
        }
        if (this.hdb != null) {
            this.hdb.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.hdi = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes6.dex */
    public static class a implements Animator.AnimatorListener {
        private View hdl;
        private View hdm;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.hdl != null) {
                this.hdl.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.hdm != null) {
                this.hdm.setVisibility(8);
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
