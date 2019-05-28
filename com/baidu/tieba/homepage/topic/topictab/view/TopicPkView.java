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
    private int bPT;
    private int bPU;
    private int bVo;
    private ImageView ghA;
    private TextView ghB;
    private TextView ghC;
    private ImageView ghD;
    private ImageView ghE;
    private int ghF;
    private int ghG;
    private int ghH;
    private int ghI;
    private int ghJ;
    private int ghK;
    private int ghL;
    private int ghM;
    private int ghN;
    private int ghO;
    private int ghP;
    private ValueAnimator ghQ;
    private View ghR;
    private a ghS;
    private ValueAnimator ghT;
    private double ghU;
    private double ghV;
    private float ghW;
    private float ghX;
    private RelativeLayout.LayoutParams ghY;
    private RelativeLayout.LayoutParams ghZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b ghp;
    private TextView ghq;
    private TextView ghr;
    private FrameLayout ghs;
    private FrameLayout ght;
    private TbImageView ghu;
    private TbImageView ghv;
    private TbImageView ghw;
    private TbImageView ghx;
    private TextView ghy;
    private TextView ghz;
    private b gia;
    private ValueAnimator.AnimatorUpdateListener gib;
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
        this.ghP = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gib = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ghD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghU) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ghF - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghs.getX() + (TopicPkView.this.ghF / 2)))));
                    TopicPkView.this.ghD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ghD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ghs.getX() + (TopicPkView.this.ghF / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghs.getX() + (TopicPkView.this.ghF / 2)))));
                    TopicPkView.this.ghD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ghD.setVisibility(4);
                    TopicPkView.this.ghD.setX(TopicPkView.this.ghW);
                    TopicPkView.this.ghD.setY(TopicPkView.this.ghX);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ghP = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gib = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ghD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghU) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ghF - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghs.getX() + (TopicPkView.this.ghF / 2)))));
                    TopicPkView.this.ghD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ghD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ghs.getX() + (TopicPkView.this.ghF / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghs.getX() + (TopicPkView.this.ghF / 2)))));
                    TopicPkView.this.ghD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ghD.setVisibility(4);
                    TopicPkView.this.ghD.setX(TopicPkView.this.ghW);
                    TopicPkView.this.ghD.setY(TopicPkView.this.ghX);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ghP = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gib = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ghD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghU) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ghF - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghs.getX() + (TopicPkView.this.ghF / 2)))));
                    TopicPkView.this.ghD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ghD.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ghs.getX() + (TopicPkView.this.ghF / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ghs.getX() + (TopicPkView.this.ghF / 2)))));
                    TopicPkView.this.ghD.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ghD.setVisibility(4);
                    TopicPkView.this.ghD.setX(TopicPkView.this.ghW);
                    TopicPkView.this.ghD.setY(TopicPkView.this.ghX);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.ghq = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.ghr = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.ghs = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.ght = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.ghu = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.ghv = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.ghw = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.ghx = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.ghy = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.ghz = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.ghA = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.ghB = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.ghC = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.ghD = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.ghE = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.ghu.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.ghv.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.ghw.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.ghx.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.ghs.setOnClickListener(this);
        this.ght.setOnClickListener(this);
        this.mHeight = l.g(context, R.dimen.tbds340);
        this.ghM = l.g(context, R.dimen.tbds78);
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
        if (this.ghp != null) {
            this.ghF = this.ghs.getWidth();
            this.aNw = this.ghs.getHeight();
            this.bVo = this.ghu.getWidth();
            this.ghG = this.ghy.getWidth();
            this.ghH = this.ghz.getWidth();
            this.ghK = this.ghy.getHeight();
            this.ghI = this.ghB.getWidth();
            this.ghJ = this.ghC.getWidth();
            this.bPU = this.ghA.getWidth();
            this.bPT = this.ghA.getHeight();
            this.ghL = ((this.mWidth - (this.ghF * 2)) - this.ghG) - this.ghH;
            this.ghO = this.ghD.getWidth();
            if (this.ghp.ggO.ggQ == 0 && this.ghp.ggP.ggQ == 0) {
                this.ghN = (int) ((0.5d * this.ghL) + this.ghG + this.ghF);
            } else {
                this.ghN = (int) (((((float) this.ghp.ggO.ggQ) / ((float) (this.ghp.ggO.ggQ + this.ghp.ggP.ggQ))) * this.ghL) + this.ghG + this.ghF);
            }
            float y = this.ghs.getY() - ((this.bPT - this.aNw) / 2);
            if (this.ghN + (this.bPU / 2) >= this.ghz.getLeft()) {
                this.ghN = (this.ghz.getLeft() - 10) - (this.bPU / 2);
                this.ghA.layout((this.ghz.getLeft() - 10) - this.bPU, (int) y, this.ghz.getLeft() - 10, ((int) y) + this.bPT);
            } else if (this.ghN - (this.bPU / 2) <= this.ghy.getRight()) {
                this.ghN = this.ghy.getRight() + 10 + (this.bPU / 2);
                this.ghA.layout(this.ghy.getRight() + 10, (int) y, this.ghy.getRight() + 10 + this.bPU, ((int) y) + this.bPT);
            } else {
                this.ghA.layout(this.ghN - (this.bPU / 2), (int) y, this.ghN + (this.bPU / 2), ((int) y) + this.bPT);
            }
            int x = (this.mWidth / 2) - ((int) this.ghu.getX());
            if (this.ghI < this.bVo) {
                int i5 = (this.ghF - this.ghI) / 2;
                this.ghB.layout(i5, (int) this.ghB.getY(), this.ghI + i5, ((int) this.ghB.getY()) + this.ghK);
            } else if (this.ghI <= x) {
                this.ghB.layout((int) this.ghu.getX(), (int) this.ghB.getY(), ((int) this.ghu.getX()) + this.ghI, ((int) this.ghB.getY()) + this.ghK);
            } else {
                ViewGroup.LayoutParams layoutParams = this.ghB.getLayoutParams();
                layoutParams.width = x;
                this.ghB.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.ghJ < this.bVo) {
                int x2 = ((int) this.ght.getX()) + ((this.ghF - this.ghJ) / 2);
                this.ghC.layout(x2, (int) this.ghC.getY(), this.ghJ + x2, ((int) this.ghC.getY()) + this.ghK);
            } else if (this.ghJ <= x) {
                this.ghC.layout((this.mWidth - ((int) this.ghv.getX())) - this.ghJ, (int) this.ghC.getY(), this.mWidth - ((int) this.ghv.getX()), ((int) this.ghC.getY()) + this.ghK);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.ghC.getLayoutParams();
                layoutParams2.width = x;
                this.ghC.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.ghF - this.ghO) / 2;
            this.ghD.layout(((int) this.ghs.getX()) + i6, ((int) this.ghs.getY()) + i6, ((int) this.ghs.getX()) + i6 + this.ghO, ((int) this.ghs.getY()) + i6 + this.ghO);
            this.ghE.layout(((int) this.ght.getX()) + i6, ((int) this.ght.getY()) + i6, ((int) this.ght.getX()) + i6 + this.ghO, i6 + ((int) this.ght.getY()) + this.ghO);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.ghp.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        } else if (this.ghQ == null || !this.ghQ.isRunning()) {
            if (this.ghT == null || !this.ghT.isRunning()) {
                if (this.ghT == null) {
                    this.ghT = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.ghT.setDuration(800L);
                    this.ghT.setInterpolator(new AccelerateInterpolator());
                }
                if (this.ghQ == null) {
                    this.ghQ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.ghQ.setDuration(800L);
                    this.ghQ.setInterpolator(new AccelerateInterpolator());
                    this.ghS = new a();
                    this.ghQ.addListener(this.ghS);
                    this.ghQ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.ghR.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.ghR.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (buU()) {
                    i = 1;
                } else {
                    i = buV() ? 2 : 0;
                }
                if (view == this.ghs) {
                    lk(1 != i);
                    ll(false);
                    i2 = 1;
                } else if (view == this.ght) {
                    ll(2 != i);
                    lk(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new am("c13352").P("obj_type", i2).l("topic_id", this.ghp.topicId).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.ghp.from));
                if (this.gia != null) {
                    this.gia.tK(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.ghp.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.ghp.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.ghp.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ghp != null) {
            N(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void N(Canvas canvas) {
        float y = this.ghs.getY() + ((this.aNw - this.ghM) / 2);
        this.mPaint.setShader(new LinearGradient(this.ghF / 2, y, this.ghN, y, al.getColor(R.color.topic_pk_agree_bar_start_color), al.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.ghF / 2, y, this.ghN, y + this.ghM, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.ghN, y, this.mWidth - (this.ghF / 2), y, al.getColor(R.color.topic_pk_disagree_bar_start_color), al.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.ghN, y, this.mWidth - (this.ghF / 2), y + this.ghM, this.mPaint);
    }

    public void setUserColor(int i) {
        this.ghP = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.ggO == null || bVar.ggP == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ghp = bVar;
        this.ghy.setText(String.valueOf(bVar.ggO.ggQ));
        this.ghz.setText(String.valueOf(bVar.ggP.ggQ));
        this.ghY = new RelativeLayout.LayoutParams(-2, -2);
        this.ghY.addRule(12);
        this.ghZ = new RelativeLayout.LayoutParams(-2, -2);
        this.ghZ.addRule(12);
        this.ghZ.addRule(11);
        this.ghB.setLayoutParams(this.ghY);
        this.ghC.setLayoutParams(this.ghZ);
        if (bVar.from == 3) {
            this.ghB.setText(StringUtils.isNull(bVar.ggO.ggR) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.ggO.ggR);
            this.ghC.setText(StringUtils.isNull(bVar.ggP.ggR) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.ggP.ggR);
            if (StringUtils.isNull(bVar.ggO.ggS)) {
                this.ghq.setVisibility(4);
            } else {
                this.ghq.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggO.ggS));
            }
            if (StringUtils.isNull(bVar.ggP.ggS)) {
                this.ghr.setVisibility(4);
            } else {
                this.ghr.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggP.ggS));
            }
        } else {
            this.ghB.setText(bVar.ggO.ggR);
            this.ghC.setText(bVar.ggP.ggR);
            this.ghq.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggO.ggS));
            this.ghr.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ggP.ggS));
        }
        this.ghu.startLoad(bVar.ggO.ggT, 10, false);
        this.ghv.startLoad(bVar.ggP.ggT, 10, false);
        this.ghw.startLoad(bVar.ggO.ggW, 10, false);
        this.ghx.startLoad(bVar.ggP.ggW, 10, false);
        if (bVar.ggO.ggU) {
            this.ghu.setVisibility(4);
            this.ghw.setVisibility(0);
        } else {
            this.ghu.setVisibility(0);
            this.ghw.setVisibility(4);
        }
        if (bVar.ggP.ggU) {
            this.ghv.setVisibility(4);
            this.ghx.setVisibility(0);
        } else {
            this.ghv.setVisibility(0);
            this.ghx.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        al.j(this.ghq, this.ghP);
        al.j(this.ghr, this.ghP);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            al.k(this.ghs, R.drawable.btn_topic_agree_bg_red);
            al.k(this.ght, R.drawable.btn_topic_disagree_bg_blue);
            this.ghu.setIsNight(this.mSkinType == 1);
            this.ghv.setIsNight(this.mSkinType == 1);
            this.ghw.setIsNight(this.mSkinType == 1);
            this.ghx.setIsNight(this.mSkinType == 1);
            al.j(this.ghy, R.color.cp_btn_a);
            al.j(this.ghz, R.color.cp_btn_a);
            al.c(this.ghA, (int) R.drawable.pic_topic_vs_bginone);
            al.j(this.ghB, R.color.topic_agree_des_color);
            al.j(this.ghC, R.color.topic_disagree_des_color);
            al.c(this.ghD, (int) R.drawable.pic_topic_addone);
            al.c(this.ghE, (int) R.drawable.pic_topic_addone);
        }
    }

    private void lk(boolean z) {
        if (z) {
            this.ghq.setVisibility(0);
            this.ghq.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.ghp.ggO.ggS = TbadkCoreApplication.getCurrentAccountNameShow();
            this.ghp.ggO.ggU = true;
            TextView textView = this.ghy;
            b.a aVar = this.ghp.ggO;
            long j = aVar.ggQ + 1;
            aVar.ggQ = j;
            textView.setText(String.valueOf(j));
            this.ghD.setVisibility(0);
            this.ghR = this.ghw;
            this.ghS.gie = this.ghw;
            this.ghS.gif = this.ghu;
            this.ghD.setVisibility(0);
            this.ghQ.start();
            this.ghU = this.ghD.getX();
            this.ghV = this.ghD.getY();
            this.ghW = this.ghD.getX();
            this.ghX = this.ghD.getY();
            this.ghT.removeAllUpdateListeners();
            this.ghT.addUpdateListener(this.gib);
            this.ghT.setFloatValues(0.0f, 2.0f);
            this.ghT.start();
            return;
        }
        if (ap.equals(this.ghp.ggO.ggS, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ghq.setVisibility(4);
        }
        if (this.ghp.ggO.ggU) {
            this.ghp.ggO.ggU = false;
            TextView textView2 = this.ghy;
            b.a aVar2 = this.ghp.ggO;
            long j2 = aVar2.ggQ - 1;
            aVar2.ggQ = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ghu.setVisibility(0);
        this.ghw.setVisibility(4);
    }

    private void ll(boolean z) {
        if (z) {
            this.ghr.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.ghr.setVisibility(0);
            this.ghp.ggP.ggS = TbadkCoreApplication.getCurrentAccountNameShow();
            this.ghE.setVisibility(0);
            this.ghp.ggP.ggU = true;
            TextView textView = this.ghz;
            b.a aVar = this.ghp.ggP;
            long j = aVar.ggQ + 1;
            aVar.ggQ = j;
            textView.setText(String.valueOf(j));
            this.ghU = this.ghE.getX() - (this.ghO / 2.0f);
            this.ghR = this.ghx;
            this.ghS.gie = this.ghx;
            this.ghS.gif = this.ghv;
            this.ghD.setVisibility(0);
            this.ghQ.start();
            this.ghU = this.ghE.getX() - (this.ghO / 2);
            this.ghV = this.ghE.getY();
            this.ghW = this.ghE.getX();
            this.ghX = this.ghE.getY();
            this.ghT.removeAllUpdateListeners();
            this.ghT.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.ghE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghU) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.ghF) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ghF / 2)))));
                        TopicPkView.this.ghE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ghV) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.ghE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ghF / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.ghE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.ghE.setVisibility(4);
                        TopicPkView.this.ghE.setX(TopicPkView.this.ghW);
                        TopicPkView.this.ghE.setY(TopicPkView.this.ghX);
                    }
                }
            });
            this.ghT.setFloatValues(0.0f, 2.0f);
            this.ghT.start();
            return;
        }
        if (ap.equals(this.ghp.ggP.ggS, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ghr.setVisibility(4);
        }
        if (this.ghp.ggP.ggU) {
            this.ghp.ggP.ggU = false;
            TextView textView2 = this.ghz;
            b.a aVar2 = this.ghp.ggP;
            long j2 = aVar2.ggQ - 1;
            aVar2.ggQ = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ghE.setVisibility(4);
        this.ghv.setVisibility(0);
        this.ghx.setVisibility(4);
    }

    private boolean buU() {
        return (this.ghp == null || this.ghp.ggO == null || !this.ghp.ggO.ggU) ? false : true;
    }

    private boolean buV() {
        return (this.ghp == null || this.ghp.ggP == null || !this.ghp.ggP.ggU) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.ghQ != null) {
            this.ghQ.cancel();
        }
        if (this.ghT != null) {
            this.ghT.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.gia = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View gie;
        private View gif;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.gie != null) {
                this.gie.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.gif != null) {
                this.gif.setVisibility(8);
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
