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
/* loaded from: classes16.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private TextView iVA;
    private ImageView iVB;
    private ImageView iVC;
    private int iVD;
    private int iVE;
    private int iVF;
    private int iVG;
    private int iVH;
    private int iVI;
    private int iVJ;
    private int iVK;
    private int iVL;
    private int iVM;
    private int iVN;
    private int iVO;
    private ValueAnimator iVP;
    private View iVQ;
    private a iVR;
    private ValueAnimator iVS;
    private double iVT;
    private double iVU;
    private float iVV;
    private float iVW;
    private RelativeLayout.LayoutParams iVX;
    private RelativeLayout.LayoutParams iVY;
    private b iVZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b iVn;
    private TextView iVo;
    private TextView iVp;
    private FrameLayout iVq;
    private FrameLayout iVr;
    private TbImageView iVs;
    private TbImageView iVt;
    private TbImageView iVu;
    private TbImageView iVv;
    private TextView iVw;
    private TextView iVx;
    private ImageView iVy;
    private TextView iVz;
    private ValueAnimator.AnimatorUpdateListener iWa;
    private int mBtnHeight;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes16.dex */
    public interface b {
        void Af(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iVO = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iWa = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iVB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iVD - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVq.getX() + (TopicPkView.this.iVD / 2)))));
                    TopicPkView.this.iVB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iVB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iVq.getX() + (TopicPkView.this.iVD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVq.getX() + (TopicPkView.this.iVD / 2)))));
                    TopicPkView.this.iVB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iVB.setVisibility(4);
                    TopicPkView.this.iVB.setX(TopicPkView.this.iVV);
                    TopicPkView.this.iVB.setY(TopicPkView.this.iVW);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iVO = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iWa = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iVB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iVD - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVq.getX() + (TopicPkView.this.iVD / 2)))));
                    TopicPkView.this.iVB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iVB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iVq.getX() + (TopicPkView.this.iVD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVq.getX() + (TopicPkView.this.iVD / 2)))));
                    TopicPkView.this.iVB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iVB.setVisibility(4);
                    TopicPkView.this.iVB.setX(TopicPkView.this.iVV);
                    TopicPkView.this.iVB.setY(TopicPkView.this.iVW);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iVO = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iWa = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iVB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVT) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iVD - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVq.getX() + (TopicPkView.this.iVD / 2)))));
                    TopicPkView.this.iVB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iVB.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iVq.getX() + (TopicPkView.this.iVD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVq.getX() + (TopicPkView.this.iVD / 2)))));
                    TopicPkView.this.iVB.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iVB.setVisibility(4);
                    TopicPkView.this.iVB.setX(TopicPkView.this.iVV);
                    TopicPkView.this.iVB.setY(TopicPkView.this.iVW);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.iVo = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.iVp = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.iVq = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.iVr = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.iVs = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.iVt = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.iVu = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.iVv = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.iVw = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.iVx = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.iVy = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.iVz = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.iVA = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.iVB = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.iVC = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.iVs.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.iVt.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.iVu.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.iVv.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.iVq.setOnClickListener(this);
        this.iVr.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.iVL = l.getDimens(context, R.dimen.tbds62);
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
        if (this.iVn != null) {
            this.iVD = this.iVq.getWidth();
            this.mBtnHeight = this.iVq.getHeight();
            this.iVE = this.iVs.getWidth();
            this.iVF = this.iVw.getWidth();
            this.iVG = this.iVx.getWidth();
            this.iVJ = this.iVw.getHeight();
            this.iVH = this.iVz.getWidth();
            this.iVI = this.iVA.getWidth();
            this.mCursorWidth = this.iVy.getWidth();
            this.mCursorHeight = this.iVy.getHeight();
            this.iVK = ((this.mWidth - (this.iVD * 2)) - this.iVF) - this.iVG;
            this.iVN = this.iVB.getWidth();
            if (this.iVn.iUN.iUP == 0 && this.iVn.iUO.iUP == 0) {
                this.iVM = (int) ((0.5d * this.iVK) + this.iVF + this.iVD);
            } else {
                this.iVM = (int) (((((float) this.iVn.iUN.iUP) / ((float) (this.iVn.iUN.iUP + this.iVn.iUO.iUP))) * this.iVK) + this.iVF + this.iVD);
            }
            float y = this.iVq.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.iVM + (this.mCursorWidth / 2) >= this.iVx.getLeft()) {
                this.iVM = (this.iVx.getLeft() - 10) - (this.mCursorWidth / 2);
                this.iVy.layout((this.iVx.getLeft() - 10) - this.mCursorWidth, (int) y, this.iVx.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.iVM - (this.mCursorWidth / 2) <= this.iVw.getRight()) {
                this.iVM = this.iVw.getRight() + 10 + (this.mCursorWidth / 2);
                this.iVy.layout(this.iVw.getRight() + 10, (int) y, this.iVw.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.iVy.layout(this.iVM - (this.mCursorWidth / 2), (int) y, this.iVM + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.iVs.getX());
            if (this.iVH < this.iVE) {
                int i5 = (this.iVD - this.iVH) / 2;
                this.iVz.layout(i5, (int) this.iVz.getY(), this.iVH + i5, ((int) this.iVz.getY()) + this.iVJ);
            } else if (this.iVH <= x) {
                this.iVz.layout((int) this.iVs.getX(), (int) this.iVz.getY(), ((int) this.iVs.getX()) + this.iVH, ((int) this.iVz.getY()) + this.iVJ);
            } else {
                ViewGroup.LayoutParams layoutParams = this.iVz.getLayoutParams();
                layoutParams.width = x;
                this.iVz.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.iVI < this.iVE) {
                int x2 = ((int) this.iVr.getX()) + ((this.iVD - this.iVI) / 2);
                this.iVA.layout(x2, (int) this.iVA.getY(), this.iVI + x2, ((int) this.iVA.getY()) + this.iVJ);
            } else if (this.iVI <= x) {
                this.iVA.layout((this.mWidth - ((int) this.iVt.getX())) - this.iVI, (int) this.iVA.getY(), this.mWidth - ((int) this.iVt.getX()), ((int) this.iVA.getY()) + this.iVJ);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.iVA.getLayoutParams();
                layoutParams2.width = x;
                this.iVA.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.iVD - this.iVN) / 2;
            this.iVB.layout(((int) this.iVq.getX()) + i6, ((int) this.iVq.getY()) + i6, ((int) this.iVq.getX()) + i6 + this.iVN, ((int) this.iVq.getY()) + i6 + this.iVN);
            this.iVC.layout(((int) this.iVr.getX()) + i6, ((int) this.iVr.getY()) + i6, ((int) this.iVr.getX()) + i6 + this.iVN, i6 + ((int) this.iVr.getY()) + this.iVN);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.iVn.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.iVP == null || !this.iVP.isRunning()) {
            if (this.iVS == null || !this.iVS.isRunning()) {
                if (this.iVS == null) {
                    this.iVS = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.iVS.setDuration(800L);
                    this.iVS.setInterpolator(new AccelerateInterpolator());
                }
                if (this.iVP == null) {
                    this.iVP = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.iVP.setDuration(800L);
                    this.iVP.setInterpolator(new AccelerateInterpolator());
                    this.iVR = new a();
                    this.iVP.addListener(this.iVR);
                    this.iVP.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.iVQ.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.iVQ.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (czl()) {
                    i = 1;
                } else {
                    i = czm() ? 2 : 0;
                }
                if (view == this.iVq) {
                    pT(1 != i);
                    pU(false);
                    i2 = 1;
                } else if (view == this.iVr) {
                    pU(2 != i);
                    pT(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new aq("c13352").ai("obj_type", i2).u("topic_id", this.iVn.topicId).ai("obj_source", this.iVn.from));
                if (this.iVZ != null) {
                    this.iVZ.Af(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.iVn.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.iVn.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.iVn.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iVn != null) {
            V(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void V(Canvas canvas) {
        float y = this.iVq.getY() + ((this.mBtnHeight - this.iVL) / 2);
        this.mPaint.setShader(new LinearGradient(this.iVD / 2, y, this.iVM, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iVD / 2, y, this.iVM, y + this.iVL, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.iVM, y, this.mWidth - (this.iVD / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iVM, y, this.mWidth - (this.iVD / 2), y + this.iVL, this.mPaint);
    }

    public void setUserColor(int i) {
        this.iVO = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.iUN == null || bVar.iUO == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iVn = bVar;
        this.iVw.setText(String.valueOf(bVar.iUN.iUP));
        this.iVx.setText(String.valueOf(bVar.iUO.iUP));
        this.iVX = new RelativeLayout.LayoutParams(-2, -2);
        this.iVX.addRule(12);
        this.iVY = new RelativeLayout.LayoutParams(-2, -2);
        this.iVY.addRule(12);
        this.iVY.addRule(11);
        this.iVz.setLayoutParams(this.iVX);
        this.iVA.setLayoutParams(this.iVY);
        if (bVar.from == 3) {
            this.iVz.setText(StringUtils.isNull(bVar.iUN.iUQ) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.iUN.iUQ);
            this.iVA.setText(StringUtils.isNull(bVar.iUO.iUQ) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.iUO.iUQ);
            if (StringUtils.isNull(bVar.iUN.iUR)) {
                this.iVo.setVisibility(4);
            } else {
                this.iVo.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iUN.iUR));
            }
            if (StringUtils.isNull(bVar.iUO.iUR)) {
                this.iVp.setVisibility(4);
            } else {
                this.iVp.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iUO.iUR));
            }
        } else {
            this.iVz.setText(bVar.iUN.iUQ);
            this.iVA.setText(bVar.iUO.iUQ);
            this.iVo.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iUN.iUR));
            this.iVp.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iUO.iUR));
        }
        this.iVs.startLoad(bVar.iUN.iUS, 10, false);
        this.iVt.startLoad(bVar.iUO.iUS, 10, false);
        this.iVu.startLoad(bVar.iUN.iUV, 10, false);
        this.iVv.startLoad(bVar.iUO.iUV, 10, false);
        if (bVar.iUN.iUT) {
            this.iVs.setVisibility(4);
            this.iVu.setVisibility(0);
        } else {
            this.iVs.setVisibility(0);
            this.iVu.setVisibility(4);
        }
        if (bVar.iUO.iUT) {
            this.iVt.setVisibility(4);
            this.iVv.setVisibility(0);
        } else {
            this.iVt.setVisibility(0);
            this.iVv.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iVo, this.iVO);
        ap.setViewTextColor(this.iVp, this.iVO);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.iVs.setIsNight(this.mSkinType == 1);
            this.iVt.setIsNight(this.mSkinType == 1);
            this.iVu.setIsNight(this.mSkinType == 1);
            this.iVv.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.iVq, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.iVr, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.iVB, R.drawable.pic_topic_addone);
            ap.setImageResource(this.iVC, R.drawable.pic_topic_addone);
            ap.setImageResource(this.iVy, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.iVw, R.color.cp_cont_a);
            ap.setViewTextColor(this.iVx, R.color.cp_cont_a);
            ap.setViewTextColor(this.iVz, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.iVA, R.color.topic_disagree_des_color);
        }
    }

    private void pT(boolean z) {
        if (z) {
            this.iVo.setVisibility(0);
            this.iVo.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iVn.iUN.iUR = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iVn.iUN.iUT = true;
            TextView textView = this.iVw;
            b.a aVar = this.iVn.iUN;
            long j = aVar.iUP + 1;
            aVar.iUP = j;
            textView.setText(String.valueOf(j));
            this.iVB.setVisibility(0);
            this.iVQ = this.iVu;
            this.iVR.iWc = this.iVu;
            this.iVR.iWd = this.iVs;
            this.iVB.setVisibility(0);
            this.iVP.start();
            this.iVT = this.iVB.getX();
            this.iVU = this.iVB.getY();
            this.iVV = this.iVB.getX();
            this.iVW = this.iVB.getY();
            this.iVS.removeAllUpdateListeners();
            this.iVS.addUpdateListener(this.iWa);
            this.iVS.setFloatValues(0.0f, 2.0f);
            this.iVS.start();
            return;
        }
        if (at.equals(this.iVn.iUN.iUR, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iVo.setVisibility(4);
        }
        if (this.iVn.iUN.iUT) {
            this.iVn.iUN.iUT = false;
            TextView textView2 = this.iVw;
            b.a aVar2 = this.iVn.iUN;
            long j2 = aVar2.iUP - 1;
            aVar2.iUP = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iVs.setVisibility(0);
        this.iVu.setVisibility(4);
    }

    private void pU(boolean z) {
        if (z) {
            this.iVp.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iVp.setVisibility(0);
            this.iVn.iUO.iUR = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iVC.setVisibility(0);
            this.iVn.iUO.iUT = true;
            TextView textView = this.iVx;
            b.a aVar = this.iVn.iUO;
            long j = aVar.iUP + 1;
            aVar.iUP = j;
            textView.setText(String.valueOf(j));
            this.iVT = this.iVC.getX() - (this.iVN / 2.0f);
            this.iVQ = this.iVv;
            this.iVR.iWc = this.iVv;
            this.iVR.iWd = this.iVt;
            this.iVB.setVisibility(0);
            this.iVP.start();
            this.iVT = this.iVC.getX() - (this.iVN / 2);
            this.iVU = this.iVC.getY();
            this.iVV = this.iVC.getX();
            this.iVW = this.iVC.getY();
            this.iVS.removeAllUpdateListeners();
            this.iVS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.iVC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVT) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.iVD) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iVD / 2)))));
                        TopicPkView.this.iVC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVU) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.iVC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iVD / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.iVC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.iVC.setVisibility(4);
                        TopicPkView.this.iVC.setX(TopicPkView.this.iVV);
                        TopicPkView.this.iVC.setY(TopicPkView.this.iVW);
                    }
                }
            });
            this.iVS.setFloatValues(0.0f, 2.0f);
            this.iVS.start();
            return;
        }
        if (at.equals(this.iVn.iUO.iUR, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iVp.setVisibility(4);
        }
        if (this.iVn.iUO.iUT) {
            this.iVn.iUO.iUT = false;
            TextView textView2 = this.iVx;
            b.a aVar2 = this.iVn.iUO;
            long j2 = aVar2.iUP - 1;
            aVar2.iUP = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iVC.setVisibility(4);
        this.iVt.setVisibility(0);
        this.iVv.setVisibility(4);
    }

    private boolean czl() {
        return (this.iVn == null || this.iVn.iUN == null || !this.iVn.iUN.iUT) ? false : true;
    }

    private boolean czm() {
        return (this.iVn == null || this.iVn.iUO == null || !this.iVn.iUO.iUT) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.iVP != null) {
            this.iVP.cancel();
        }
        if (this.iVS != null) {
            this.iVS.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.iVZ = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a implements Animator.AnimatorListener {
        private View iWc;
        private View iWd;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.iWc != null) {
                this.iWc.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.iWd != null) {
                this.iWd.setVisibility(8);
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
