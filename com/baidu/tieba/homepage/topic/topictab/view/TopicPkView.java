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
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ChannelHomeActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes4.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int aNw;
    private int bPU;
    private int bPV;
    private int bVp;
    private TextView ghA;
    private TextView ghB;
    private ImageView ghC;
    private TextView ghD;
    private TextView ghE;
    private ImageView ghF;
    private ImageView ghG;
    private int ghH;
    private int ghI;
    private int ghJ;
    private int ghK;
    private int ghL;
    private int ghM;
    private int ghN;
    private int ghO;
    private int ghP;
    private int ghQ;
    private int ghR;
    private ValueAnimator ghS;
    private View ghT;
    private a ghU;
    private ValueAnimator ghV;
    private double ghW;
    private double ghX;
    private float ghY;
    private float ghZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b ghr;
    private TextView ghs;
    private TextView ght;
    private FrameLayout ghu;
    private FrameLayout ghv;
    private TbImageView ghw;
    private TbImageView ghx;
    private TbImageView ghy;
    private TbImageView ghz;
    private RelativeLayout.LayoutParams gia;
    private RelativeLayout.LayoutParams gib;
    private b gic;
    private ValueAnimator.AnimatorUpdateListener gie;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void tK(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ghR = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gie = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ghF.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghW) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ghH - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghu.getX() + (TopicPkView.this.ghH / 2)))));
                    TopicPkView.this.ghF.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghX) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ghF.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ghu.getX() + (TopicPkView.this.ghH / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghu.getX() + (TopicPkView.this.ghH / 2)))));
                    TopicPkView.this.ghF.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ghF.setVisibility(4);
                    TopicPkView.this.ghF.setX(TopicPkView.this.ghY);
                    TopicPkView.this.ghF.setY(TopicPkView.this.ghZ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ghR = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gie = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ghF.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghW) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ghH - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghu.getX() + (TopicPkView.this.ghH / 2)))));
                    TopicPkView.this.ghF.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghX) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ghF.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ghu.getX() + (TopicPkView.this.ghH / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghu.getX() + (TopicPkView.this.ghH / 2)))));
                    TopicPkView.this.ghF.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ghF.setVisibility(4);
                    TopicPkView.this.ghF.setX(TopicPkView.this.ghY);
                    TopicPkView.this.ghF.setY(TopicPkView.this.ghZ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ghR = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gie = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ghF.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghW) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ghH - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghu.getX() + (TopicPkView.this.ghH / 2)))));
                    TopicPkView.this.ghF.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghX) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ghF.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ghu.getX() + (TopicPkView.this.ghH / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghu.getX() + (TopicPkView.this.ghH / 2)))));
                    TopicPkView.this.ghF.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ghF.setVisibility(4);
                    TopicPkView.this.ghF.setX(TopicPkView.this.ghY);
                    TopicPkView.this.ghF.setY(TopicPkView.this.ghZ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.ghs = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.ght = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.ghu = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.ghv = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.ghw = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.ghx = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.ghy = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.ghz = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.ghA = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.ghB = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.ghC = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.ghD = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.ghE = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.ghF = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.ghG = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.ghw.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.ghx.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.ghy.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.ghz.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.ghu.setOnClickListener(this);
        this.ghv.setOnClickListener(this);
        this.mHeight = l.g(context, R.dimen.tbds340);
        this.ghO = l.g(context, R.dimen.tbds78);
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
        if (this.ghr != null) {
            this.ghH = this.ghu.getWidth();
            this.aNw = this.ghu.getHeight();
            this.bVp = this.ghw.getWidth();
            this.ghI = this.ghA.getWidth();
            this.ghJ = this.ghB.getWidth();
            this.ghM = this.ghA.getHeight();
            this.ghK = this.ghD.getWidth();
            this.ghL = this.ghE.getWidth();
            this.bPV = this.ghC.getWidth();
            this.bPU = this.ghC.getHeight();
            this.ghN = ((this.mWidth - (this.ghH * 2)) - this.ghI) - this.ghJ;
            this.ghQ = this.ghF.getWidth();
            if (this.ghr.ggQ.ggS == 0 && this.ghr.ggR.ggS == 0) {
                this.ghP = (int) ((0.5d * this.ghN) + this.ghI + this.ghH);
            } else {
                this.ghP = (int) (((((float) this.ghr.ggQ.ggS) / ((float) (this.ghr.ggQ.ggS + this.ghr.ggR.ggS))) * this.ghN) + this.ghI + this.ghH);
            }
            float y = this.ghu.getY() - ((this.bPU - this.aNw) / 2);
            if (this.ghP + (this.bPV / 2) >= this.ghB.getLeft()) {
                this.ghP = (this.ghB.getLeft() - 10) - (this.bPV / 2);
                this.ghC.layout((this.ghB.getLeft() - 10) - this.bPV, (int) y, this.ghB.getLeft() - 10, ((int) y) + this.bPU);
            } else if (this.ghP - (this.bPV / 2) <= this.ghA.getRight()) {
                this.ghP = this.ghA.getRight() + 10 + (this.bPV / 2);
                this.ghC.layout(this.ghA.getRight() + 10, (int) y, this.ghA.getRight() + 10 + this.bPV, ((int) y) + this.bPU);
            } else {
                this.ghC.layout(this.ghP - (this.bPV / 2), (int) y, this.ghP + (this.bPV / 2), ((int) y) + this.bPU);
            }
            int x = (this.mWidth / 2) - ((int) this.ghw.getX());
            if (this.ghK < this.bVp) {
                int i5 = (this.ghH - this.ghK) / 2;
                this.ghD.layout(i5, (int) this.ghD.getY(), this.ghK + i5, ((int) this.ghD.getY()) + this.ghM);
            } else if (this.ghK <= x) {
                this.ghD.layout((int) this.ghw.getX(), (int) this.ghD.getY(), ((int) this.ghw.getX()) + this.ghK, ((int) this.ghD.getY()) + this.ghM);
            } else {
                ViewGroup.LayoutParams layoutParams = this.ghD.getLayoutParams();
                layoutParams.width = x;
                this.ghD.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.ghL < this.bVp) {
                int x2 = ((int) this.ghv.getX()) + ((this.ghH - this.ghL) / 2);
                this.ghE.layout(x2, (int) this.ghE.getY(), this.ghL + x2, ((int) this.ghE.getY()) + this.ghM);
            } else if (this.ghL <= x) {
                this.ghE.layout((this.mWidth - ((int) this.ghx.getX())) - this.ghL, (int) this.ghE.getY(), this.mWidth - ((int) this.ghx.getX()), ((int) this.ghE.getY()) + this.ghM);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.ghE.getLayoutParams();
                layoutParams2.width = x;
                this.ghE.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.ghH - this.ghQ) / 2;
            this.ghF.layout(((int) this.ghu.getX()) + i6, ((int) this.ghu.getY()) + i6, ((int) this.ghu.getX()) + i6 + this.ghQ, ((int) this.ghu.getY()) + i6 + this.ghQ);
            this.ghG.layout(((int) this.ghv.getX()) + i6, ((int) this.ghv.getY()) + i6, ((int) this.ghv.getX()) + i6 + this.ghQ, i6 + ((int) this.ghv.getY()) + this.ghQ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.ghr.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        } else if (this.ghS == null || !this.ghS.isRunning()) {
            if (this.ghV == null || !this.ghV.isRunning()) {
                if (this.ghV == null) {
                    this.ghV = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.ghV.setDuration(800L);
                    this.ghV.setInterpolator(new AccelerateInterpolator());
                }
                if (this.ghS == null) {
                    this.ghS = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.ghS.setDuration(800L);
                    this.ghS.setInterpolator(new AccelerateInterpolator());
                    this.ghU = new a();
                    this.ghS.addListener(this.ghU);
                    this.ghS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.ghT.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.ghT.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (buV()) {
                    i = 1;
                } else {
                    i = buW() ? 2 : 0;
                }
                if (view == this.ghu) {
                    ll(1 != i);
                    lm(false);
                    i2 = 1;
                } else if (view == this.ghv) {
                    lm(2 != i);
                    ll(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new am("c13352").P("obj_type", i2).l("topic_id", this.ghr.topicId).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.ghr.from));
                if (this.gic != null) {
                    this.gic.tK(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.ghr.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.ghr.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.ghr.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ghr != null) {
            N(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void N(Canvas canvas) {
        float y = this.ghu.getY() + ((this.aNw - this.ghO) / 2);
        this.mPaint.setShader(new LinearGradient(this.ghH / 2, y, this.ghP, y, al.getColor(R.color.topic_pk_agree_bar_start_color), al.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.ghH / 2, y, this.ghP, y + this.ghO, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.ghP, y, this.mWidth - (this.ghH / 2), y, al.getColor(R.color.topic_pk_disagree_bar_start_color), al.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.ghP, y, this.mWidth - (this.ghH / 2), y + this.ghO, this.mPaint);
    }

    public void setUserColor(int i) {
        this.ghR = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.ggQ == null || bVar.ggR == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ghr = bVar;
        this.ghA.setText(String.valueOf(bVar.ggQ.ggS));
        this.ghB.setText(String.valueOf(bVar.ggR.ggS));
        this.gia = new RelativeLayout.LayoutParams(-2, -2);
        this.gia.addRule(12);
        this.gib = new RelativeLayout.LayoutParams(-2, -2);
        this.gib.addRule(12);
        this.gib.addRule(11);
        this.ghD.setLayoutParams(this.gia);
        this.ghE.setLayoutParams(this.gib);
        if (bVar.from == 3) {
            this.ghD.setText(StringUtils.isNull(bVar.ggQ.ggT) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.ggQ.ggT);
            this.ghE.setText(StringUtils.isNull(bVar.ggR.ggT) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.ggR.ggT);
            if (StringUtils.isNull(bVar.ggQ.ggU)) {
                this.ghs.setVisibility(4);
            } else {
                this.ghs.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggQ.ggU));
            }
            if (StringUtils.isNull(bVar.ggR.ggU)) {
                this.ght.setVisibility(4);
            } else {
                this.ght.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggR.ggU));
            }
        } else {
            this.ghD.setText(bVar.ggQ.ggT);
            this.ghE.setText(bVar.ggR.ggT);
            this.ghs.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggQ.ggU));
            this.ght.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggR.ggU));
        }
        this.ghw.startLoad(bVar.ggQ.ggV, 10, false);
        this.ghx.startLoad(bVar.ggR.ggV, 10, false);
        this.ghy.startLoad(bVar.ggQ.ggY, 10, false);
        this.ghz.startLoad(bVar.ggR.ggY, 10, false);
        if (bVar.ggQ.ggW) {
            this.ghw.setVisibility(4);
            this.ghy.setVisibility(0);
        } else {
            this.ghw.setVisibility(0);
            this.ghy.setVisibility(4);
        }
        if (bVar.ggR.ggW) {
            this.ghx.setVisibility(4);
            this.ghz.setVisibility(0);
        } else {
            this.ghx.setVisibility(0);
            this.ghz.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        al.j(this.ghs, this.ghR);
        al.j(this.ght, this.ghR);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.k(this.ghu, R.drawable.btn_topic_agree_bg_red);
            al.k(this.ghv, R.drawable.btn_topic_disagree_bg_blue);
            this.ghw.setIsNight(this.mSkinType == 1);
            this.ghx.setIsNight(this.mSkinType == 1);
            this.ghy.setIsNight(this.mSkinType == 1);
            this.ghz.setIsNight(this.mSkinType == 1);
            al.j(this.ghA, R.color.cp_btn_a);
            al.j(this.ghB, R.color.cp_btn_a);
            al.c(this.ghC, (int) R.drawable.pic_topic_vs_bginone);
            al.j(this.ghD, R.color.topic_agree_des_color);
            al.j(this.ghE, R.color.topic_disagree_des_color);
            al.c(this.ghF, (int) R.drawable.pic_topic_addone);
            al.c(this.ghG, (int) R.drawable.pic_topic_addone);
        }
    }

    private void ll(boolean z) {
        if (z) {
            this.ghs.setVisibility(0);
            this.ghs.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.ghr.ggQ.ggU = TbadkCoreApplication.getCurrentAccountNameShow();
            this.ghr.ggQ.ggW = true;
            TextView textView = this.ghA;
            b.a aVar = this.ghr.ggQ;
            long j = aVar.ggS + 1;
            aVar.ggS = j;
            textView.setText(String.valueOf(j));
            this.ghF.setVisibility(0);
            this.ghT = this.ghy;
            this.ghU.gig = this.ghy;
            this.ghU.gih = this.ghw;
            this.ghF.setVisibility(0);
            this.ghS.start();
            this.ghW = this.ghF.getX();
            this.ghX = this.ghF.getY();
            this.ghY = this.ghF.getX();
            this.ghZ = this.ghF.getY();
            this.ghV.removeAllUpdateListeners();
            this.ghV.addUpdateListener(this.gie);
            this.ghV.setFloatValues(0.0f, 2.0f);
            this.ghV.start();
            return;
        }
        if (ap.equals(this.ghr.ggQ.ggU, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ghs.setVisibility(4);
        }
        if (this.ghr.ggQ.ggW) {
            this.ghr.ggQ.ggW = false;
            TextView textView2 = this.ghA;
            b.a aVar2 = this.ghr.ggQ;
            long j2 = aVar2.ggS - 1;
            aVar2.ggS = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ghw.setVisibility(0);
        this.ghy.setVisibility(4);
    }

    private void lm(boolean z) {
        if (z) {
            this.ght.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.ght.setVisibility(0);
            this.ghr.ggR.ggU = TbadkCoreApplication.getCurrentAccountNameShow();
            this.ghG.setVisibility(0);
            this.ghr.ggR.ggW = true;
            TextView textView = this.ghB;
            b.a aVar = this.ghr.ggR;
            long j = aVar.ggS + 1;
            aVar.ggS = j;
            textView.setText(String.valueOf(j));
            this.ghW = this.ghG.getX() - (this.ghQ / 2.0f);
            this.ghT = this.ghz;
            this.ghU.gig = this.ghz;
            this.ghU.gih = this.ghx;
            this.ghF.setVisibility(0);
            this.ghS.start();
            this.ghW = this.ghG.getX() - (this.ghQ / 2);
            this.ghX = this.ghG.getY();
            this.ghY = this.ghG.getX();
            this.ghZ = this.ghG.getY();
            this.ghV.removeAllUpdateListeners();
            this.ghV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.ghG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghW) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.ghH) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ghH / 2)))));
                        TopicPkView.this.ghG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghX) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.ghG.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ghH / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.ghG.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.ghG.setVisibility(4);
                        TopicPkView.this.ghG.setX(TopicPkView.this.ghY);
                        TopicPkView.this.ghG.setY(TopicPkView.this.ghZ);
                    }
                }
            });
            this.ghV.setFloatValues(0.0f, 2.0f);
            this.ghV.start();
            return;
        }
        if (ap.equals(this.ghr.ggR.ggU, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ght.setVisibility(4);
        }
        if (this.ghr.ggR.ggW) {
            this.ghr.ggR.ggW = false;
            TextView textView2 = this.ghB;
            b.a aVar2 = this.ghr.ggR;
            long j2 = aVar2.ggS - 1;
            aVar2.ggS = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ghG.setVisibility(4);
        this.ghx.setVisibility(0);
        this.ghz.setVisibility(4);
    }

    private boolean buV() {
        return (this.ghr == null || this.ghr.ggQ == null || !this.ghr.ggQ.ggW) ? false : true;
    }

    private boolean buW() {
        return (this.ghr == null || this.ghr.ggR == null || !this.ghr.ggR.ggW) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.ghS != null) {
            this.ghS.cancel();
        }
        if (this.ghV != null) {
            this.ghV.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.gic = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View gig;
        private View gih;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.gig != null) {
                this.gig.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.gih != null) {
                this.gih.setVisibility(8);
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
