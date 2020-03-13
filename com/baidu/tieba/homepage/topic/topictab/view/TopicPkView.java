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
    private TextView hiA;
    private TextView hiB;
    private ImageView hiC;
    private ImageView hiD;
    private int hiE;
    private int hiF;
    private int hiG;
    private int hiH;
    private int hiI;
    private int hiJ;
    private int hiK;
    private int hiL;
    private int hiM;
    private int hiN;
    private int hiO;
    private int hiP;
    private ValueAnimator hiQ;
    private View hiR;
    private a hiS;
    private ValueAnimator hiT;
    private double hiU;
    private double hiV;
    private float hiW;
    private float hiX;
    private RelativeLayout.LayoutParams hiY;
    private RelativeLayout.LayoutParams hiZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b hio;
    private TextView hip;
    private TextView hiq;
    private FrameLayout hir;
    private FrameLayout his;
    private TbImageView hit;
    private TbImageView hiu;
    private TbImageView hiv;
    private TbImageView hiw;
    private TextView hix;
    private TextView hiy;
    private ImageView hiz;
    private b hja;
    private ValueAnimator.AnimatorUpdateListener hjb;
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
        this.hiP = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hjb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hiC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiU) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hiE - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hir.getX() + (TopicPkView.this.hiE / 2)))));
                    TopicPkView.this.hiC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hiC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hir.getX() + (TopicPkView.this.hiE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hir.getX() + (TopicPkView.this.hiE / 2)))));
                    TopicPkView.this.hiC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hiC.setVisibility(4);
                    TopicPkView.this.hiC.setX(TopicPkView.this.hiW);
                    TopicPkView.this.hiC.setY(TopicPkView.this.hiX);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hiP = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hjb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hiC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiU) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hiE - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hir.getX() + (TopicPkView.this.hiE / 2)))));
                    TopicPkView.this.hiC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hiC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hir.getX() + (TopicPkView.this.hiE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hir.getX() + (TopicPkView.this.hiE / 2)))));
                    TopicPkView.this.hiC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hiC.setVisibility(4);
                    TopicPkView.this.hiC.setX(TopicPkView.this.hiW);
                    TopicPkView.this.hiC.setY(TopicPkView.this.hiX);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hiP = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hjb = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hiC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiU) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hiE - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hir.getX() + (TopicPkView.this.hiE / 2)))));
                    TopicPkView.this.hiC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hiC.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hir.getX() + (TopicPkView.this.hiE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hir.getX() + (TopicPkView.this.hiE / 2)))));
                    TopicPkView.this.hiC.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hiC.setVisibility(4);
                    TopicPkView.this.hiC.setX(TopicPkView.this.hiW);
                    TopicPkView.this.hiC.setY(TopicPkView.this.hiX);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.hip = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.hiq = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.hir = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.his = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.hit = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.hiu = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.hiv = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.hiw = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.hix = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.hiy = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.hiz = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.hiA = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.hiB = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.hiC = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.hiD = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.hit.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.hiu.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.hiv.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.hiw.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.hir.setOnClickListener(this);
        this.his.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.hiM = l.getDimens(context, R.dimen.tbds62);
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
        if (this.hio != null) {
            this.hiE = this.hir.getWidth();
            this.mBtnHeight = this.hir.getHeight();
            this.hiF = this.hit.getWidth();
            this.hiG = this.hix.getWidth();
            this.hiH = this.hiy.getWidth();
            this.hiK = this.hix.getHeight();
            this.hiI = this.hiA.getWidth();
            this.hiJ = this.hiB.getWidth();
            this.mCursorWidth = this.hiz.getWidth();
            this.mCursorHeight = this.hiz.getHeight();
            this.hiL = ((this.mWidth - (this.hiE * 2)) - this.hiG) - this.hiH;
            this.hiO = this.hiC.getWidth();
            if (this.hio.hhM.hhO == 0 && this.hio.hhN.hhO == 0) {
                this.hiN = (int) ((0.5d * this.hiL) + this.hiG + this.hiE);
            } else {
                this.hiN = (int) (((((float) this.hio.hhM.hhO) / ((float) (this.hio.hhM.hhO + this.hio.hhN.hhO))) * this.hiL) + this.hiG + this.hiE);
            }
            float y = this.hir.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.hiN + (this.mCursorWidth / 2) >= this.hiy.getLeft()) {
                this.hiN = (this.hiy.getLeft() - 10) - (this.mCursorWidth / 2);
                this.hiz.layout((this.hiy.getLeft() - 10) - this.mCursorWidth, (int) y, this.hiy.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.hiN - (this.mCursorWidth / 2) <= this.hix.getRight()) {
                this.hiN = this.hix.getRight() + 10 + (this.mCursorWidth / 2);
                this.hiz.layout(this.hix.getRight() + 10, (int) y, this.hix.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.hiz.layout(this.hiN - (this.mCursorWidth / 2), (int) y, this.hiN + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.hit.getX());
            if (this.hiI < this.hiF) {
                int i5 = (this.hiE - this.hiI) / 2;
                this.hiA.layout(i5, (int) this.hiA.getY(), this.hiI + i5, ((int) this.hiA.getY()) + this.hiK);
            } else if (this.hiI <= x) {
                this.hiA.layout((int) this.hit.getX(), (int) this.hiA.getY(), ((int) this.hit.getX()) + this.hiI, ((int) this.hiA.getY()) + this.hiK);
            } else {
                ViewGroup.LayoutParams layoutParams = this.hiA.getLayoutParams();
                layoutParams.width = x;
                this.hiA.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.hiJ < this.hiF) {
                int x2 = ((int) this.his.getX()) + ((this.hiE - this.hiJ) / 2);
                this.hiB.layout(x2, (int) this.hiB.getY(), this.hiJ + x2, ((int) this.hiB.getY()) + this.hiK);
            } else if (this.hiJ <= x) {
                this.hiB.layout((this.mWidth - ((int) this.hiu.getX())) - this.hiJ, (int) this.hiB.getY(), this.mWidth - ((int) this.hiu.getX()), ((int) this.hiB.getY()) + this.hiK);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.hiB.getLayoutParams();
                layoutParams2.width = x;
                this.hiB.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.hiE - this.hiO) / 2;
            this.hiC.layout(((int) this.hir.getX()) + i6, ((int) this.hir.getY()) + i6, ((int) this.hir.getX()) + i6 + this.hiO, ((int) this.hir.getY()) + i6 + this.hiO);
            this.hiD.layout(((int) this.his.getX()) + i6, ((int) this.his.getY()) + i6, ((int) this.his.getX()) + i6 + this.hiO, i6 + ((int) this.his.getY()) + this.hiO);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.hio.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.hiQ == null || !this.hiQ.isRunning()) {
            if (this.hiT == null || !this.hiT.isRunning()) {
                if (this.hiT == null) {
                    this.hiT = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.hiT.setDuration(800L);
                    this.hiT.setInterpolator(new AccelerateInterpolator());
                }
                if (this.hiQ == null) {
                    this.hiQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.hiQ.setDuration(800L);
                    this.hiQ.setInterpolator(new AccelerateInterpolator());
                    this.hiS = new a();
                    this.hiQ.addListener(this.hiS);
                    this.hiQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.hiR.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.hiR.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bPF()) {
                    i = 1;
                } else {
                    i = bPG() ? 2 : 0;
                }
                if (view == this.hir) {
                    mQ(1 != i);
                    mR(false);
                    i2 = 1;
                } else if (view == this.his) {
                    mR(2 != i);
                    mQ(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").X("obj_type", i2).s("topic_id", this.hio.topicId).X("obj_source", this.hio.from));
                if (this.hja != null) {
                    this.hja.vv(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.hio.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.hio.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.hio.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.hio != null) {
            K(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void K(Canvas canvas) {
        float y = this.hir.getY() + ((this.mBtnHeight - this.hiM) / 2);
        this.mPaint.setShader(new LinearGradient(this.hiE / 2, y, this.hiN, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hiE / 2, y, this.hiN, y + this.hiM, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.hiN, y, this.mWidth - (this.hiE / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hiN, y, this.mWidth - (this.hiE / 2), y + this.hiM, this.mPaint);
    }

    public void setUserColor(int i) {
        this.hiP = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.hhM == null || bVar.hhN == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hio = bVar;
        this.hix.setText(String.valueOf(bVar.hhM.hhO));
        this.hiy.setText(String.valueOf(bVar.hhN.hhO));
        this.hiY = new RelativeLayout.LayoutParams(-2, -2);
        this.hiY.addRule(12);
        this.hiZ = new RelativeLayout.LayoutParams(-2, -2);
        this.hiZ.addRule(12);
        this.hiZ.addRule(11);
        this.hiA.setLayoutParams(this.hiY);
        this.hiB.setLayoutParams(this.hiZ);
        if (bVar.from == 3) {
            this.hiA.setText(StringUtils.isNull(bVar.hhM.hhP) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.hhM.hhP);
            this.hiB.setText(StringUtils.isNull(bVar.hhN.hhP) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.hhN.hhP);
            if (StringUtils.isNull(bVar.hhM.hhQ)) {
                this.hip.setVisibility(4);
            } else {
                this.hip.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhM.hhQ));
            }
            if (StringUtils.isNull(bVar.hhN.hhQ)) {
                this.hiq.setVisibility(4);
            } else {
                this.hiq.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhN.hhQ));
            }
        } else {
            this.hiA.setText(bVar.hhM.hhP);
            this.hiB.setText(bVar.hhN.hhP);
            this.hip.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhM.hhQ));
            this.hiq.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hhN.hhQ));
        }
        this.hit.startLoad(bVar.hhM.hhR, 10, false);
        this.hiu.startLoad(bVar.hhN.hhR, 10, false);
        this.hiv.startLoad(bVar.hhM.hhU, 10, false);
        this.hiw.startLoad(bVar.hhN.hhU, 10, false);
        if (bVar.hhM.hhS) {
            this.hit.setVisibility(4);
            this.hiv.setVisibility(0);
        } else {
            this.hit.setVisibility(0);
            this.hiv.setVisibility(4);
        }
        if (bVar.hhN.hhS) {
            this.hiu.setVisibility(4);
            this.hiw.setVisibility(0);
        } else {
            this.hiu.setVisibility(0);
            this.hiw.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.hip, this.hiP);
        am.setViewTextColor(this.hiq, this.hiP);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.hit.setIsNight(this.mSkinType == 1);
            this.hiu.setIsNight(this.mSkinType == 1);
            this.hiv.setIsNight(this.mSkinType == 1);
            this.hiw.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.hir, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.his, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.hiC, R.drawable.pic_topic_addone);
            am.setImageResource(this.hiD, R.drawable.pic_topic_addone);
            am.setImageResource(this.hiz, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.hix, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hiy, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hiA, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.hiB, (int) R.color.topic_disagree_des_color);
        }
    }

    private void mQ(boolean z) {
        if (z) {
            this.hip.setVisibility(0);
            this.hip.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hio.hhM.hhQ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hio.hhM.hhS = true;
            TextView textView = this.hix;
            b.a aVar = this.hio.hhM;
            long j = aVar.hhO + 1;
            aVar.hhO = j;
            textView.setText(String.valueOf(j));
            this.hiC.setVisibility(0);
            this.hiR = this.hiv;
            this.hiS.hjd = this.hiv;
            this.hiS.hje = this.hit;
            this.hiC.setVisibility(0);
            this.hiQ.start();
            this.hiU = this.hiC.getX();
            this.hiV = this.hiC.getY();
            this.hiW = this.hiC.getX();
            this.hiX = this.hiC.getY();
            this.hiT.removeAllUpdateListeners();
            this.hiT.addUpdateListener(this.hjb);
            this.hiT.setFloatValues(0.0f, 2.0f);
            this.hiT.start();
            return;
        }
        if (aq.equals(this.hio.hhM.hhQ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hip.setVisibility(4);
        }
        if (this.hio.hhM.hhS) {
            this.hio.hhM.hhS = false;
            TextView textView2 = this.hix;
            b.a aVar2 = this.hio.hhM;
            long j2 = aVar2.hhO - 1;
            aVar2.hhO = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hit.setVisibility(0);
        this.hiv.setVisibility(4);
    }

    private void mR(boolean z) {
        if (z) {
            this.hiq.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hiq.setVisibility(0);
            this.hio.hhN.hhQ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hiD.setVisibility(0);
            this.hio.hhN.hhS = true;
            TextView textView = this.hiy;
            b.a aVar = this.hio.hhN;
            long j = aVar.hhO + 1;
            aVar.hhO = j;
            textView.setText(String.valueOf(j));
            this.hiU = this.hiD.getX() - (this.hiO / 2.0f);
            this.hiR = this.hiw;
            this.hiS.hjd = this.hiw;
            this.hiS.hje = this.hiu;
            this.hiC.setVisibility(0);
            this.hiQ.start();
            this.hiU = this.hiD.getX() - (this.hiO / 2);
            this.hiV = this.hiD.getY();
            this.hiW = this.hiD.getX();
            this.hiX = this.hiD.getY();
            this.hiT.removeAllUpdateListeners();
            this.hiT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.hiD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiU) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.hiE) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hiE / 2)))));
                        TopicPkView.this.hiD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hiV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.hiD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hiE / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.hiD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.hiD.setVisibility(4);
                        TopicPkView.this.hiD.setX(TopicPkView.this.hiW);
                        TopicPkView.this.hiD.setY(TopicPkView.this.hiX);
                    }
                }
            });
            this.hiT.setFloatValues(0.0f, 2.0f);
            this.hiT.start();
            return;
        }
        if (aq.equals(this.hio.hhN.hhQ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hiq.setVisibility(4);
        }
        if (this.hio.hhN.hhS) {
            this.hio.hhN.hhS = false;
            TextView textView2 = this.hiy;
            b.a aVar2 = this.hio.hhN;
            long j2 = aVar2.hhO - 1;
            aVar2.hhO = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hiD.setVisibility(4);
        this.hiu.setVisibility(0);
        this.hiw.setVisibility(4);
    }

    private boolean bPF() {
        return (this.hio == null || this.hio.hhM == null || !this.hio.hhM.hhS) ? false : true;
    }

    private boolean bPG() {
        return (this.hio == null || this.hio.hhN == null || !this.hio.hhN.hhS) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.hiQ != null) {
            this.hiQ.cancel();
        }
        if (this.hiT != null) {
            this.hiT.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.hja = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Animator.AnimatorListener {
        private View hjd;
        private View hje;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.hjd != null) {
                this.hjd.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.hje != null) {
                this.hje.setVisibility(8);
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
