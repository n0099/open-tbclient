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
    private int iVA;
    private int iVB;
    private int iVC;
    private int iVD;
    private int iVE;
    private int iVF;
    private int iVG;
    private int iVH;
    private int iVI;
    private ValueAnimator iVJ;
    private View iVK;
    private a iVL;
    private ValueAnimator iVM;
    private double iVN;
    private double iVO;
    private float iVP;
    private float iVQ;
    private RelativeLayout.LayoutParams iVR;
    private RelativeLayout.LayoutParams iVS;
    private b iVT;
    private ValueAnimator.AnimatorUpdateListener iVU;
    private com.baidu.tieba.homepage.topic.topictab.b.b iVh;
    private TextView iVi;
    private TextView iVj;
    private FrameLayout iVk;
    private FrameLayout iVl;
    private TbImageView iVm;
    private TbImageView iVn;
    private TbImageView iVo;
    private TbImageView iVp;
    private TextView iVq;
    private TextView iVr;
    private ImageView iVs;
    private TextView iVt;
    private TextView iVu;
    private ImageView iVv;
    private ImageView iVw;
    private int iVx;
    private int iVy;
    private int iVz;
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
        this.iVI = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iVU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iVv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVN) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iVx - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVk.getX() + (TopicPkView.this.iVx / 2)))));
                    TopicPkView.this.iVv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVO) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iVv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iVk.getX() + (TopicPkView.this.iVx / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVk.getX() + (TopicPkView.this.iVx / 2)))));
                    TopicPkView.this.iVv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iVv.setVisibility(4);
                    TopicPkView.this.iVv.setX(TopicPkView.this.iVP);
                    TopicPkView.this.iVv.setY(TopicPkView.this.iVQ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iVI = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iVU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iVv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVN) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iVx - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVk.getX() + (TopicPkView.this.iVx / 2)))));
                    TopicPkView.this.iVv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVO) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iVv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iVk.getX() + (TopicPkView.this.iVx / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVk.getX() + (TopicPkView.this.iVx / 2)))));
                    TopicPkView.this.iVv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iVv.setVisibility(4);
                    TopicPkView.this.iVv.setX(TopicPkView.this.iVP);
                    TopicPkView.this.iVv.setY(TopicPkView.this.iVQ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iVI = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iVU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iVv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVN) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iVx - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVk.getX() + (TopicPkView.this.iVx / 2)))));
                    TopicPkView.this.iVv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVO) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iVv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iVk.getX() + (TopicPkView.this.iVx / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iVk.getX() + (TopicPkView.this.iVx / 2)))));
                    TopicPkView.this.iVv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iVv.setVisibility(4);
                    TopicPkView.this.iVv.setX(TopicPkView.this.iVP);
                    TopicPkView.this.iVv.setY(TopicPkView.this.iVQ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.iVi = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.iVj = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.iVk = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.iVl = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.iVm = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.iVn = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.iVo = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.iVp = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.iVq = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.iVr = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.iVs = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.iVt = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.iVu = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.iVv = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.iVw = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.iVm.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.iVn.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.iVo.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.iVp.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.iVk.setOnClickListener(this);
        this.iVl.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.iVF = l.getDimens(context, R.dimen.tbds62);
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
        if (this.iVh != null) {
            this.iVx = this.iVk.getWidth();
            this.mBtnHeight = this.iVk.getHeight();
            this.iVy = this.iVm.getWidth();
            this.iVz = this.iVq.getWidth();
            this.iVA = this.iVr.getWidth();
            this.iVD = this.iVq.getHeight();
            this.iVB = this.iVt.getWidth();
            this.iVC = this.iVu.getWidth();
            this.mCursorWidth = this.iVs.getWidth();
            this.mCursorHeight = this.iVs.getHeight();
            this.iVE = ((this.mWidth - (this.iVx * 2)) - this.iVz) - this.iVA;
            this.iVH = this.iVv.getWidth();
            if (this.iVh.iUH.iUJ == 0 && this.iVh.iUI.iUJ == 0) {
                this.iVG = (int) ((0.5d * this.iVE) + this.iVz + this.iVx);
            } else {
                this.iVG = (int) (((((float) this.iVh.iUH.iUJ) / ((float) (this.iVh.iUH.iUJ + this.iVh.iUI.iUJ))) * this.iVE) + this.iVz + this.iVx);
            }
            float y = this.iVk.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.iVG + (this.mCursorWidth / 2) >= this.iVr.getLeft()) {
                this.iVG = (this.iVr.getLeft() - 10) - (this.mCursorWidth / 2);
                this.iVs.layout((this.iVr.getLeft() - 10) - this.mCursorWidth, (int) y, this.iVr.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.iVG - (this.mCursorWidth / 2) <= this.iVq.getRight()) {
                this.iVG = this.iVq.getRight() + 10 + (this.mCursorWidth / 2);
                this.iVs.layout(this.iVq.getRight() + 10, (int) y, this.iVq.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.iVs.layout(this.iVG - (this.mCursorWidth / 2), (int) y, this.iVG + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.iVm.getX());
            if (this.iVB < this.iVy) {
                int i5 = (this.iVx - this.iVB) / 2;
                this.iVt.layout(i5, (int) this.iVt.getY(), this.iVB + i5, ((int) this.iVt.getY()) + this.iVD);
            } else if (this.iVB <= x) {
                this.iVt.layout((int) this.iVm.getX(), (int) this.iVt.getY(), ((int) this.iVm.getX()) + this.iVB, ((int) this.iVt.getY()) + this.iVD);
            } else {
                ViewGroup.LayoutParams layoutParams = this.iVt.getLayoutParams();
                layoutParams.width = x;
                this.iVt.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.iVC < this.iVy) {
                int x2 = ((int) this.iVl.getX()) + ((this.iVx - this.iVC) / 2);
                this.iVu.layout(x2, (int) this.iVu.getY(), this.iVC + x2, ((int) this.iVu.getY()) + this.iVD);
            } else if (this.iVC <= x) {
                this.iVu.layout((this.mWidth - ((int) this.iVn.getX())) - this.iVC, (int) this.iVu.getY(), this.mWidth - ((int) this.iVn.getX()), ((int) this.iVu.getY()) + this.iVD);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.iVu.getLayoutParams();
                layoutParams2.width = x;
                this.iVu.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.iVx - this.iVH) / 2;
            this.iVv.layout(((int) this.iVk.getX()) + i6, ((int) this.iVk.getY()) + i6, ((int) this.iVk.getX()) + i6 + this.iVH, ((int) this.iVk.getY()) + i6 + this.iVH);
            this.iVw.layout(((int) this.iVl.getX()) + i6, ((int) this.iVl.getY()) + i6, ((int) this.iVl.getX()) + i6 + this.iVH, i6 + ((int) this.iVl.getY()) + this.iVH);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.iVh.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.iVJ == null || !this.iVJ.isRunning()) {
            if (this.iVM == null || !this.iVM.isRunning()) {
                if (this.iVM == null) {
                    this.iVM = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.iVM.setDuration(800L);
                    this.iVM.setInterpolator(new AccelerateInterpolator());
                }
                if (this.iVJ == null) {
                    this.iVJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.iVJ.setDuration(800L);
                    this.iVJ.setInterpolator(new AccelerateInterpolator());
                    this.iVL = new a();
                    this.iVJ.addListener(this.iVL);
                    this.iVJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.iVK.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.iVK.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (czk()) {
                    i = 1;
                } else {
                    i = czl() ? 2 : 0;
                }
                if (view == this.iVk) {
                    pR(1 != i);
                    pS(false);
                    i2 = 1;
                } else if (view == this.iVl) {
                    pS(2 != i);
                    pR(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new aq("c13352").ai("obj_type", i2).u("topic_id", this.iVh.topicId).ai("obj_source", this.iVh.from));
                if (this.iVT != null) {
                    this.iVT.Af(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.iVh.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.iVh.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.iVh.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iVh != null) {
            V(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void V(Canvas canvas) {
        float y = this.iVk.getY() + ((this.mBtnHeight - this.iVF) / 2);
        this.mPaint.setShader(new LinearGradient(this.iVx / 2, y, this.iVG, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iVx / 2, y, this.iVG, y + this.iVF, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.iVG, y, this.mWidth - (this.iVx / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iVG, y, this.mWidth - (this.iVx / 2), y + this.iVF, this.mPaint);
    }

    public void setUserColor(int i) {
        this.iVI = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.iUH == null || bVar.iUI == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iVh = bVar;
        this.iVq.setText(String.valueOf(bVar.iUH.iUJ));
        this.iVr.setText(String.valueOf(bVar.iUI.iUJ));
        this.iVR = new RelativeLayout.LayoutParams(-2, -2);
        this.iVR.addRule(12);
        this.iVS = new RelativeLayout.LayoutParams(-2, -2);
        this.iVS.addRule(12);
        this.iVS.addRule(11);
        this.iVt.setLayoutParams(this.iVR);
        this.iVu.setLayoutParams(this.iVS);
        if (bVar.from == 3) {
            this.iVt.setText(StringUtils.isNull(bVar.iUH.iUK) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.iUH.iUK);
            this.iVu.setText(StringUtils.isNull(bVar.iUI.iUK) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.iUI.iUK);
            if (StringUtils.isNull(bVar.iUH.iUL)) {
                this.iVi.setVisibility(4);
            } else {
                this.iVi.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iUH.iUL));
            }
            if (StringUtils.isNull(bVar.iUI.iUL)) {
                this.iVj.setVisibility(4);
            } else {
                this.iVj.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iUI.iUL));
            }
        } else {
            this.iVt.setText(bVar.iUH.iUK);
            this.iVu.setText(bVar.iUI.iUK);
            this.iVi.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iUH.iUL));
            this.iVj.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iUI.iUL));
        }
        this.iVm.startLoad(bVar.iUH.iUM, 10, false);
        this.iVn.startLoad(bVar.iUI.iUM, 10, false);
        this.iVo.startLoad(bVar.iUH.iUP, 10, false);
        this.iVp.startLoad(bVar.iUI.iUP, 10, false);
        if (bVar.iUH.iUN) {
            this.iVm.setVisibility(4);
            this.iVo.setVisibility(0);
        } else {
            this.iVm.setVisibility(0);
            this.iVo.setVisibility(4);
        }
        if (bVar.iUI.iUN) {
            this.iVn.setVisibility(4);
            this.iVp.setVisibility(0);
        } else {
            this.iVn.setVisibility(0);
            this.iVp.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.iVi, this.iVI);
        ap.setViewTextColor(this.iVj, this.iVI);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.iVm.setIsNight(this.mSkinType == 1);
            this.iVn.setIsNight(this.mSkinType == 1);
            this.iVo.setIsNight(this.mSkinType == 1);
            this.iVp.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.iVk, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.iVl, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.iVv, R.drawable.pic_topic_addone);
            ap.setImageResource(this.iVw, R.drawable.pic_topic_addone);
            ap.setImageResource(this.iVs, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.iVq, R.color.cp_cont_a);
            ap.setViewTextColor(this.iVr, R.color.cp_cont_a);
            ap.setViewTextColor(this.iVt, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.iVu, R.color.topic_disagree_des_color);
        }
    }

    private void pR(boolean z) {
        if (z) {
            this.iVi.setVisibility(0);
            this.iVi.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iVh.iUH.iUL = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iVh.iUH.iUN = true;
            TextView textView = this.iVq;
            b.a aVar = this.iVh.iUH;
            long j = aVar.iUJ + 1;
            aVar.iUJ = j;
            textView.setText(String.valueOf(j));
            this.iVv.setVisibility(0);
            this.iVK = this.iVo;
            this.iVL.iVW = this.iVo;
            this.iVL.iVX = this.iVm;
            this.iVv.setVisibility(0);
            this.iVJ.start();
            this.iVN = this.iVv.getX();
            this.iVO = this.iVv.getY();
            this.iVP = this.iVv.getX();
            this.iVQ = this.iVv.getY();
            this.iVM.removeAllUpdateListeners();
            this.iVM.addUpdateListener(this.iVU);
            this.iVM.setFloatValues(0.0f, 2.0f);
            this.iVM.start();
            return;
        }
        if (at.equals(this.iVh.iUH.iUL, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iVi.setVisibility(4);
        }
        if (this.iVh.iUH.iUN) {
            this.iVh.iUH.iUN = false;
            TextView textView2 = this.iVq;
            b.a aVar2 = this.iVh.iUH;
            long j2 = aVar2.iUJ - 1;
            aVar2.iUJ = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iVm.setVisibility(0);
        this.iVo.setVisibility(4);
    }

    private void pS(boolean z) {
        if (z) {
            this.iVj.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iVj.setVisibility(0);
            this.iVh.iUI.iUL = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iVw.setVisibility(0);
            this.iVh.iUI.iUN = true;
            TextView textView = this.iVr;
            b.a aVar = this.iVh.iUI;
            long j = aVar.iUJ + 1;
            aVar.iUJ = j;
            textView.setText(String.valueOf(j));
            this.iVN = this.iVw.getX() - (this.iVH / 2.0f);
            this.iVK = this.iVp;
            this.iVL.iVW = this.iVp;
            this.iVL.iVX = this.iVn;
            this.iVv.setVisibility(0);
            this.iVJ.start();
            this.iVN = this.iVw.getX() - (this.iVH / 2);
            this.iVO = this.iVw.getY();
            this.iVP = this.iVw.getX();
            this.iVQ = this.iVw.getY();
            this.iVM.removeAllUpdateListeners();
            this.iVM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.iVw.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVN) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.iVx) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iVx / 2)))));
                        TopicPkView.this.iVw.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iVO) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.iVw.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iVx / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.iVw.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.iVw.setVisibility(4);
                        TopicPkView.this.iVw.setX(TopicPkView.this.iVP);
                        TopicPkView.this.iVw.setY(TopicPkView.this.iVQ);
                    }
                }
            });
            this.iVM.setFloatValues(0.0f, 2.0f);
            this.iVM.start();
            return;
        }
        if (at.equals(this.iVh.iUI.iUL, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iVj.setVisibility(4);
        }
        if (this.iVh.iUI.iUN) {
            this.iVh.iUI.iUN = false;
            TextView textView2 = this.iVr;
            b.a aVar2 = this.iVh.iUI;
            long j2 = aVar2.iUJ - 1;
            aVar2.iUJ = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iVw.setVisibility(4);
        this.iVn.setVisibility(0);
        this.iVp.setVisibility(4);
    }

    private boolean czk() {
        return (this.iVh == null || this.iVh.iUH == null || !this.iVh.iUH.iUN) ? false : true;
    }

    private boolean czl() {
        return (this.iVh == null || this.iVh.iUI == null || !this.iVh.iUI.iUN) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.iVJ != null) {
            this.iVJ.cancel();
        }
        if (this.iVM != null) {
            this.iVM.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.iVT = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a implements Animator.AnimatorListener {
        private View iVW;
        private View iVX;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.iVW != null) {
                this.iVW.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.iVX != null) {
                this.iVX.setVisibility(8);
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
