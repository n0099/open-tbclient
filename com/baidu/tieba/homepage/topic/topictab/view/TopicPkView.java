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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes4.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int aOf;
    private int bRa;
    private int bRb;
    private int bWw;
    private FrameLayout goA;
    private TbImageView goB;
    private TbImageView goC;
    private TbImageView goD;
    private TbImageView goE;
    private TextView goF;
    private TextView goG;
    private ImageView goH;
    private TextView goI;
    private TextView goJ;
    private ImageView goK;
    private ImageView goL;
    private int goM;
    private int goN;
    private int goO;
    private int goP;
    private int goQ;
    private int goR;
    private int goS;
    private int goT;
    private int goU;
    private int goV;
    private int goW;
    private ValueAnimator goX;
    private View goY;
    private a goZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b gow;
    private TextView gox;
    private TextView goy;
    private FrameLayout goz;
    private ValueAnimator gpa;
    private double gpb;
    private double gpc;
    private float gpd;
    private float gpe;
    private RelativeLayout.LayoutParams gpf;
    private RelativeLayout.LayoutParams gpg;
    private b gph;
    private ValueAnimator.AnimatorUpdateListener gpi;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void uk(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.goW = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gpi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.goK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpb) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.goM - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goz.getX() + (TopicPkView.this.goM / 2)))));
                    TopicPkView.this.goK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpc) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.goK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.goz.getX() + (TopicPkView.this.goM / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goz.getX() + (TopicPkView.this.goM / 2)))));
                    TopicPkView.this.goK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.goK.setVisibility(4);
                    TopicPkView.this.goK.setX(TopicPkView.this.gpd);
                    TopicPkView.this.goK.setY(TopicPkView.this.gpe);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.goW = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gpi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.goK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpb) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.goM - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goz.getX() + (TopicPkView.this.goM / 2)))));
                    TopicPkView.this.goK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpc) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.goK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.goz.getX() + (TopicPkView.this.goM / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goz.getX() + (TopicPkView.this.goM / 2)))));
                    TopicPkView.this.goK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.goK.setVisibility(4);
                    TopicPkView.this.goK.setX(TopicPkView.this.gpd);
                    TopicPkView.this.goK.setY(TopicPkView.this.gpe);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.goW = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.gpi = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.goK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpb) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.goM - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goz.getX() + (TopicPkView.this.goM / 2)))));
                    TopicPkView.this.goK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpc) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.goK.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.goz.getX() + (TopicPkView.this.goM / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.goz.getX() + (TopicPkView.this.goM / 2)))));
                    TopicPkView.this.goK.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.goK.setVisibility(4);
                    TopicPkView.this.goK.setX(TopicPkView.this.gpd);
                    TopicPkView.this.goK.setY(TopicPkView.this.gpe);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.gox = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.goy = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.goz = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.goA = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.goB = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.goC = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.goD = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.goE = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.goF = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.goG = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.goH = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.goI = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.goJ = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.goK = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.goL = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.goB.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.goC.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.goD.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.goE.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.goz.setOnClickListener(this);
        this.goA.setOnClickListener(this);
        this.mHeight = l.g(context, R.dimen.tbds340);
        this.goT = l.g(context, R.dimen.tbds78);
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
        if (this.gow != null) {
            this.goM = this.goz.getWidth();
            this.aOf = this.goz.getHeight();
            this.bWw = this.goB.getWidth();
            this.goN = this.goF.getWidth();
            this.goO = this.goG.getWidth();
            this.goR = this.goF.getHeight();
            this.goP = this.goI.getWidth();
            this.goQ = this.goJ.getWidth();
            this.bRb = this.goH.getWidth();
            this.bRa = this.goH.getHeight();
            this.goS = ((this.mWidth - (this.goM * 2)) - this.goN) - this.goO;
            this.goV = this.goK.getWidth();
            if (this.gow.gnV.gnX == 0 && this.gow.gnW.gnX == 0) {
                this.goU = (int) ((0.5d * this.goS) + this.goN + this.goM);
            } else {
                this.goU = (int) (((((float) this.gow.gnV.gnX) / ((float) (this.gow.gnV.gnX + this.gow.gnW.gnX))) * this.goS) + this.goN + this.goM);
            }
            float y = this.goz.getY() - ((this.bRa - this.aOf) / 2);
            if (this.goU + (this.bRb / 2) >= this.goG.getLeft()) {
                this.goU = (this.goG.getLeft() - 10) - (this.bRb / 2);
                this.goH.layout((this.goG.getLeft() - 10) - this.bRb, (int) y, this.goG.getLeft() - 10, ((int) y) + this.bRa);
            } else if (this.goU - (this.bRb / 2) <= this.goF.getRight()) {
                this.goU = this.goF.getRight() + 10 + (this.bRb / 2);
                this.goH.layout(this.goF.getRight() + 10, (int) y, this.goF.getRight() + 10 + this.bRb, ((int) y) + this.bRa);
            } else {
                this.goH.layout(this.goU - (this.bRb / 2), (int) y, this.goU + (this.bRb / 2), ((int) y) + this.bRa);
            }
            int x = (this.mWidth / 2) - ((int) this.goB.getX());
            if (this.goP < this.bWw) {
                int i5 = (this.goM - this.goP) / 2;
                this.goI.layout(i5, (int) this.goI.getY(), this.goP + i5, ((int) this.goI.getY()) + this.goR);
            } else if (this.goP <= x) {
                this.goI.layout((int) this.goB.getX(), (int) this.goI.getY(), ((int) this.goB.getX()) + this.goP, ((int) this.goI.getY()) + this.goR);
            } else {
                ViewGroup.LayoutParams layoutParams = this.goI.getLayoutParams();
                layoutParams.width = x;
                this.goI.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.goQ < this.bWw) {
                int x2 = ((int) this.goA.getX()) + ((this.goM - this.goQ) / 2);
                this.goJ.layout(x2, (int) this.goJ.getY(), this.goQ + x2, ((int) this.goJ.getY()) + this.goR);
            } else if (this.goQ <= x) {
                this.goJ.layout((this.mWidth - ((int) this.goC.getX())) - this.goQ, (int) this.goJ.getY(), this.mWidth - ((int) this.goC.getX()), ((int) this.goJ.getY()) + this.goR);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.goJ.getLayoutParams();
                layoutParams2.width = x;
                this.goJ.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.goM - this.goV) / 2;
            this.goK.layout(((int) this.goz.getX()) + i6, ((int) this.goz.getY()) + i6, ((int) this.goz.getX()) + i6 + this.goV, ((int) this.goz.getY()) + i6 + this.goV);
            this.goL.layout(((int) this.goA.getX()) + i6, ((int) this.goA.getY()) + i6, ((int) this.goA.getX()) + i6 + this.goV, i6 + ((int) this.goA.getY()) + this.goV);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.gow.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        } else if (this.goX == null || !this.goX.isRunning()) {
            if (this.gpa == null || !this.gpa.isRunning()) {
                if (this.gpa == null) {
                    this.gpa = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.gpa.setDuration(800L);
                    this.gpa.setInterpolator(new AccelerateInterpolator());
                }
                if (this.goX == null) {
                    this.goX = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.goX.setDuration(800L);
                    this.goX.setInterpolator(new AccelerateInterpolator());
                    this.goZ = new a();
                    this.goX.addListener(this.goZ);
                    this.goX.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.goY.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.goY.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bxO()) {
                    i = 1;
                } else {
                    i = bxP() ? 2 : 0;
                }
                if (view == this.goz) {
                    lz(1 != i);
                    lA(false);
                    i2 = 1;
                } else if (view == this.goA) {
                    lA(2 != i);
                    lz(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").P("obj_type", i2).l("topic_id", this.gow.topicId).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.gow.from));
                if (this.gph != null) {
                    this.gph.uk(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.gow.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.gow.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.gow.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.gow != null) {
            N(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void N(Canvas canvas) {
        float y = this.goz.getY() + ((this.aOf - this.goT) / 2);
        this.mPaint.setShader(new LinearGradient(this.goM / 2, y, this.goU, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.goM / 2, y, this.goU, y + this.goT, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.goU, y, this.mWidth - (this.goM / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.goU, y, this.mWidth - (this.goM / 2), y + this.goT, this.mPaint);
    }

    public void setUserColor(int i) {
        this.goW = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.gnV == null || bVar.gnW == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gow = bVar;
        this.goF.setText(String.valueOf(bVar.gnV.gnX));
        this.goG.setText(String.valueOf(bVar.gnW.gnX));
        this.gpf = new RelativeLayout.LayoutParams(-2, -2);
        this.gpf.addRule(12);
        this.gpg = new RelativeLayout.LayoutParams(-2, -2);
        this.gpg.addRule(12);
        this.gpg.addRule(11);
        this.goI.setLayoutParams(this.gpf);
        this.goJ.setLayoutParams(this.gpg);
        if (bVar.from == 3) {
            this.goI.setText(StringUtils.isNull(bVar.gnV.gnY) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.gnV.gnY);
            this.goJ.setText(StringUtils.isNull(bVar.gnW.gnY) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.gnW.gnY);
            if (StringUtils.isNull(bVar.gnV.gnZ)) {
                this.gox.setVisibility(4);
            } else {
                this.gox.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gnV.gnZ));
            }
            if (StringUtils.isNull(bVar.gnW.gnZ)) {
                this.goy.setVisibility(4);
            } else {
                this.goy.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gnW.gnZ));
            }
        } else {
            this.goI.setText(bVar.gnV.gnY);
            this.goJ.setText(bVar.gnW.gnY);
            this.gox.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gnV.gnZ));
            this.goy.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gnW.gnZ));
        }
        this.goB.startLoad(bVar.gnV.goa, 10, false);
        this.goC.startLoad(bVar.gnW.goa, 10, false);
        this.goD.startLoad(bVar.gnV.god, 10, false);
        this.goE.startLoad(bVar.gnW.god, 10, false);
        if (bVar.gnV.gob) {
            this.goB.setVisibility(4);
            this.goD.setVisibility(0);
        } else {
            this.goB.setVisibility(0);
            this.goD.setVisibility(4);
        }
        if (bVar.gnW.gob) {
            this.goC.setVisibility(4);
            this.goE.setVisibility(0);
        } else {
            this.goC.setVisibility(0);
            this.goE.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.j(this.gox, this.goW);
        am.j(this.goy, this.goW);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.k(this.goz, R.drawable.btn_topic_agree_bg_red);
            am.k(this.goA, R.drawable.btn_topic_disagree_bg_blue);
            this.goB.setIsNight(this.mSkinType == 1);
            this.goC.setIsNight(this.mSkinType == 1);
            this.goD.setIsNight(this.mSkinType == 1);
            this.goE.setIsNight(this.mSkinType == 1);
            am.j(this.goF, R.color.cp_btn_a);
            am.j(this.goG, R.color.cp_btn_a);
            am.c(this.goH, (int) R.drawable.pic_topic_vs_bginone);
            am.j(this.goI, R.color.topic_agree_des_color);
            am.j(this.goJ, R.color.topic_disagree_des_color);
            am.c(this.goK, (int) R.drawable.pic_topic_addone);
            am.c(this.goL, (int) R.drawable.pic_topic_addone);
        }
    }

    private void lz(boolean z) {
        if (z) {
            this.gox.setVisibility(0);
            this.gox.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.gow.gnV.gnZ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.gow.gnV.gob = true;
            TextView textView = this.goF;
            b.a aVar = this.gow.gnV;
            long j = aVar.gnX + 1;
            aVar.gnX = j;
            textView.setText(String.valueOf(j));
            this.goK.setVisibility(0);
            this.goY = this.goD;
            this.goZ.gpk = this.goD;
            this.goZ.gpl = this.goB;
            this.goK.setVisibility(0);
            this.goX.start();
            this.gpb = this.goK.getX();
            this.gpc = this.goK.getY();
            this.gpd = this.goK.getX();
            this.gpe = this.goK.getY();
            this.gpa.removeAllUpdateListeners();
            this.gpa.addUpdateListener(this.gpi);
            this.gpa.setFloatValues(0.0f, 2.0f);
            this.gpa.start();
            return;
        }
        if (aq.bV(this.gow.gnV.gnZ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.gox.setVisibility(4);
        }
        if (this.gow.gnV.gob) {
            this.gow.gnV.gob = false;
            TextView textView2 = this.goF;
            b.a aVar2 = this.gow.gnV;
            long j2 = aVar2.gnX - 1;
            aVar2.gnX = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.goB.setVisibility(0);
        this.goD.setVisibility(4);
    }

    private void lA(boolean z) {
        if (z) {
            this.goy.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.goy.setVisibility(0);
            this.gow.gnW.gnZ = TbadkCoreApplication.getCurrentAccountNameShow();
            this.goL.setVisibility(0);
            this.gow.gnW.gob = true;
            TextView textView = this.goG;
            b.a aVar = this.gow.gnW;
            long j = aVar.gnX + 1;
            aVar.gnX = j;
            textView.setText(String.valueOf(j));
            this.gpb = this.goL.getX() - (this.goV / 2.0f);
            this.goY = this.goE;
            this.goZ.gpk = this.goE;
            this.goZ.gpl = this.goC;
            this.goK.setVisibility(0);
            this.goX.start();
            this.gpb = this.goL.getX() - (this.goV / 2);
            this.gpc = this.goL.getY();
            this.gpd = this.goL.getX();
            this.gpe = this.goL.getY();
            this.gpa.removeAllUpdateListeners();
            this.gpa.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.goL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpb) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.goM) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.goM / 2)))));
                        TopicPkView.this.goL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gpc) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.goL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.goM / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.goL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.goL.setVisibility(4);
                        TopicPkView.this.goL.setX(TopicPkView.this.gpd);
                        TopicPkView.this.goL.setY(TopicPkView.this.gpe);
                    }
                }
            });
            this.gpa.setFloatValues(0.0f, 2.0f);
            this.gpa.start();
            return;
        }
        if (aq.bV(this.gow.gnW.gnZ, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.goy.setVisibility(4);
        }
        if (this.gow.gnW.gob) {
            this.gow.gnW.gob = false;
            TextView textView2 = this.goG;
            b.a aVar2 = this.gow.gnW;
            long j2 = aVar2.gnX - 1;
            aVar2.gnX = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.goL.setVisibility(4);
        this.goC.setVisibility(0);
        this.goE.setVisibility(4);
    }

    private boolean bxO() {
        return (this.gow == null || this.gow.gnV == null || !this.gow.gnV.gob) ? false : true;
    }

    private boolean bxP() {
        return (this.gow == null || this.gow.gnW == null || !this.gow.gnW.gob) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.goX != null) {
            this.goX.cancel();
        }
        if (this.gpa != null) {
            this.gpa.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.gph = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View gpk;
        private View gpl;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.gpk != null) {
                this.gpk.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.gpl != null) {
                this.gpl.setVisibility(8);
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
