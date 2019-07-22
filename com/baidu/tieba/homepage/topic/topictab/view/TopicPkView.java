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
    private int bQU;
    private int bQV;
    private int bWq;
    private com.baidu.tieba.homepage.topic.topictab.b.b gnE;
    private TextView gnF;
    private TextView gnG;
    private FrameLayout gnH;
    private FrameLayout gnI;
    private TbImageView gnJ;
    private TbImageView gnK;
    private TbImageView gnL;
    private TbImageView gnM;
    private TextView gnN;
    private TextView gnO;
    private ImageView gnP;
    private TextView gnQ;
    private TextView gnR;
    private ImageView gnS;
    private ImageView gnT;
    private int gnU;
    private int gnV;
    private int gnW;
    private int gnX;
    private int gnY;
    private int gnZ;
    private int goa;
    private int gob;
    private int goc;
    private int god;
    private int goe;
    private ValueAnimator gof;
    private View gog;
    private a goh;
    private ValueAnimator goi;
    private double goj;
    private double gok;
    private float gol;
    private float gom;
    private RelativeLayout.LayoutParams gon;
    private RelativeLayout.LayoutParams goo;
    private b gop;
    private ValueAnimator.AnimatorUpdateListener goq;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes4.dex */
    public interface b {
        void ui(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.goe = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.goq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gnS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.goj) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gnU - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gnH.getX() + (TopicPkView.this.gnU / 2)))));
                    TopicPkView.this.gnS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gok) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gnS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.gnH.getX() + (TopicPkView.this.gnU / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gnH.getX() + (TopicPkView.this.gnU / 2)))));
                    TopicPkView.this.gnS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gnS.setVisibility(4);
                    TopicPkView.this.gnS.setX(TopicPkView.this.gol);
                    TopicPkView.this.gnS.setY(TopicPkView.this.gom);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.goe = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.goq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gnS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.goj) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gnU - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gnH.getX() + (TopicPkView.this.gnU / 2)))));
                    TopicPkView.this.gnS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gok) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gnS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.gnH.getX() + (TopicPkView.this.gnU / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gnH.getX() + (TopicPkView.this.gnU / 2)))));
                    TopicPkView.this.gnS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gnS.setVisibility(4);
                    TopicPkView.this.gnS.setX(TopicPkView.this.gol);
                    TopicPkView.this.gnS.setY(TopicPkView.this.gom);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.goe = R.color.cp_btn_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.goq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.gnS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.goj) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.gnU - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gnH.getX() + (TopicPkView.this.gnU / 2)))));
                    TopicPkView.this.gnS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gok) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.gnS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.gnH.getX() + (TopicPkView.this.gnU / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.gnH.getX() + (TopicPkView.this.gnU / 2)))));
                    TopicPkView.this.gnS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.gnS.setVisibility(4);
                    TopicPkView.this.gnS.setX(TopicPkView.this.gol);
                    TopicPkView.this.gnS.setY(TopicPkView.this.gom);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.gnF = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.gnG = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.gnH = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.gnI = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.gnJ = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.gnK = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.gnL = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.gnM = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.gnN = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.gnO = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.gnP = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.gnQ = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.gnR = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.gnS = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.gnT = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.gnJ.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.gnK.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.gnL.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.gnM.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.gnH.setOnClickListener(this);
        this.gnI.setOnClickListener(this);
        this.mHeight = l.g(context, R.dimen.tbds340);
        this.gob = l.g(context, R.dimen.tbds78);
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
        if (this.gnE != null) {
            this.gnU = this.gnH.getWidth();
            this.aOf = this.gnH.getHeight();
            this.bWq = this.gnJ.getWidth();
            this.gnV = this.gnN.getWidth();
            this.gnW = this.gnO.getWidth();
            this.gnZ = this.gnN.getHeight();
            this.gnX = this.gnQ.getWidth();
            this.gnY = this.gnR.getWidth();
            this.bQV = this.gnP.getWidth();
            this.bQU = this.gnP.getHeight();
            this.goa = ((this.mWidth - (this.gnU * 2)) - this.gnV) - this.gnW;
            this.god = this.gnS.getWidth();
            if (this.gnE.gnd.gnf == 0 && this.gnE.gne.gnf == 0) {
                this.goc = (int) ((0.5d * this.goa) + this.gnV + this.gnU);
            } else {
                this.goc = (int) (((((float) this.gnE.gnd.gnf) / ((float) (this.gnE.gnd.gnf + this.gnE.gne.gnf))) * this.goa) + this.gnV + this.gnU);
            }
            float y = this.gnH.getY() - ((this.bQU - this.aOf) / 2);
            if (this.goc + (this.bQV / 2) >= this.gnO.getLeft()) {
                this.goc = (this.gnO.getLeft() - 10) - (this.bQV / 2);
                this.gnP.layout((this.gnO.getLeft() - 10) - this.bQV, (int) y, this.gnO.getLeft() - 10, ((int) y) + this.bQU);
            } else if (this.goc - (this.bQV / 2) <= this.gnN.getRight()) {
                this.goc = this.gnN.getRight() + 10 + (this.bQV / 2);
                this.gnP.layout(this.gnN.getRight() + 10, (int) y, this.gnN.getRight() + 10 + this.bQV, ((int) y) + this.bQU);
            } else {
                this.gnP.layout(this.goc - (this.bQV / 2), (int) y, this.goc + (this.bQV / 2), ((int) y) + this.bQU);
            }
            int x = (this.mWidth / 2) - ((int) this.gnJ.getX());
            if (this.gnX < this.bWq) {
                int i5 = (this.gnU - this.gnX) / 2;
                this.gnQ.layout(i5, (int) this.gnQ.getY(), this.gnX + i5, ((int) this.gnQ.getY()) + this.gnZ);
            } else if (this.gnX <= x) {
                this.gnQ.layout((int) this.gnJ.getX(), (int) this.gnQ.getY(), ((int) this.gnJ.getX()) + this.gnX, ((int) this.gnQ.getY()) + this.gnZ);
            } else {
                ViewGroup.LayoutParams layoutParams = this.gnQ.getLayoutParams();
                layoutParams.width = x;
                this.gnQ.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.gnY < this.bWq) {
                int x2 = ((int) this.gnI.getX()) + ((this.gnU - this.gnY) / 2);
                this.gnR.layout(x2, (int) this.gnR.getY(), this.gnY + x2, ((int) this.gnR.getY()) + this.gnZ);
            } else if (this.gnY <= x) {
                this.gnR.layout((this.mWidth - ((int) this.gnK.getX())) - this.gnY, (int) this.gnR.getY(), this.mWidth - ((int) this.gnK.getX()), ((int) this.gnR.getY()) + this.gnZ);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.gnR.getLayoutParams();
                layoutParams2.width = x;
                this.gnR.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.gnU - this.god) / 2;
            this.gnS.layout(((int) this.gnH.getX()) + i6, ((int) this.gnH.getY()) + i6, ((int) this.gnH.getX()) + i6 + this.god, ((int) this.gnH.getY()) + i6 + this.god);
            this.gnT.layout(((int) this.gnI.getX()) + i6, ((int) this.gnI.getY()) + i6, ((int) this.gnI.getX()) + i6 + this.god, i6 + ((int) this.gnI.getY()) + this.god);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.gnE.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>(2002001, loginActivityConfig));
        } else if (this.gof == null || !this.gof.isRunning()) {
            if (this.goi == null || !this.goi.isRunning()) {
                if (this.goi == null) {
                    this.goi = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.goi.setDuration(800L);
                    this.goi.setInterpolator(new AccelerateInterpolator());
                }
                if (this.gof == null) {
                    this.gof = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.gof.setDuration(800L);
                    this.gof.setInterpolator(new AccelerateInterpolator());
                    this.goh = new a();
                    this.gof.addListener(this.goh);
                    this.gof.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.gog.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.gog.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bxA()) {
                    i = 1;
                } else {
                    i = bxB() ? 2 : 0;
                }
                if (view == this.gnH) {
                    lz(1 != i);
                    lA(false);
                    i2 = 1;
                } else if (view == this.gnI) {
                    lA(2 != i);
                    lz(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").P("obj_type", i2).l("topic_id", this.gnE.topicId).P(ChannelHomeActivityConfig.PARAM_OBJ_SOURCE, this.gnE.from));
                if (this.gop != null) {
                    this.gop.ui(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.gnE.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.gnE.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.gnE.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.gnE != null) {
            N(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void N(Canvas canvas) {
        float y = this.gnH.getY() + ((this.aOf - this.gob) / 2);
        this.mPaint.setShader(new LinearGradient(this.gnU / 2, y, this.goc, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.gnU / 2, y, this.goc, y + this.gob, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.goc, y, this.mWidth - (this.gnU / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.goc, y, this.mWidth - (this.gnU / 2), y + this.gob, this.mPaint);
    }

    public void setUserColor(int i) {
        this.goe = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.gnd == null || bVar.gne == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.gnE = bVar;
        this.gnN.setText(String.valueOf(bVar.gnd.gnf));
        this.gnO.setText(String.valueOf(bVar.gne.gnf));
        this.gon = new RelativeLayout.LayoutParams(-2, -2);
        this.gon.addRule(12);
        this.goo = new RelativeLayout.LayoutParams(-2, -2);
        this.goo.addRule(12);
        this.goo.addRule(11);
        this.gnQ.setLayoutParams(this.gon);
        this.gnR.setLayoutParams(this.goo);
        if (bVar.from == 3) {
            this.gnQ.setText(StringUtils.isNull(bVar.gnd.gng) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.gnd.gng);
            this.gnR.setText(StringUtils.isNull(bVar.gne.gng) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.gne.gng);
            if (StringUtils.isNull(bVar.gnd.gnh)) {
                this.gnF.setVisibility(4);
            } else {
                this.gnF.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gnd.gnh));
            }
            if (StringUtils.isNull(bVar.gne.gnh)) {
                this.gnG.setVisibility(4);
            } else {
                this.gnG.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gne.gnh));
            }
        } else {
            this.gnQ.setText(bVar.gnd.gng);
            this.gnR.setText(bVar.gne.gng);
            this.gnF.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gnd.gnh));
            this.gnG.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.gne.gnh));
        }
        this.gnJ.startLoad(bVar.gnd.gni, 10, false);
        this.gnK.startLoad(bVar.gne.gni, 10, false);
        this.gnL.startLoad(bVar.gnd.gnl, 10, false);
        this.gnM.startLoad(bVar.gne.gnl, 10, false);
        if (bVar.gnd.gnj) {
            this.gnJ.setVisibility(4);
            this.gnL.setVisibility(0);
        } else {
            this.gnJ.setVisibility(0);
            this.gnL.setVisibility(4);
        }
        if (bVar.gne.gnj) {
            this.gnK.setVisibility(4);
            this.gnM.setVisibility(0);
        } else {
            this.gnK.setVisibility(0);
            this.gnM.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.j(this.gnF, this.goe);
        am.j(this.gnG, this.goe);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            am.k(this.gnH, R.drawable.btn_topic_agree_bg_red);
            am.k(this.gnI, R.drawable.btn_topic_disagree_bg_blue);
            this.gnJ.setIsNight(this.mSkinType == 1);
            this.gnK.setIsNight(this.mSkinType == 1);
            this.gnL.setIsNight(this.mSkinType == 1);
            this.gnM.setIsNight(this.mSkinType == 1);
            am.j(this.gnN, R.color.cp_btn_a);
            am.j(this.gnO, R.color.cp_btn_a);
            am.c(this.gnP, (int) R.drawable.pic_topic_vs_bginone);
            am.j(this.gnQ, R.color.topic_agree_des_color);
            am.j(this.gnR, R.color.topic_disagree_des_color);
            am.c(this.gnS, (int) R.drawable.pic_topic_addone);
            am.c(this.gnT, (int) R.drawable.pic_topic_addone);
        }
    }

    private void lz(boolean z) {
        if (z) {
            this.gnF.setVisibility(0);
            this.gnF.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.gnE.gnd.gnh = TbadkCoreApplication.getCurrentAccountNameShow();
            this.gnE.gnd.gnj = true;
            TextView textView = this.gnN;
            b.a aVar = this.gnE.gnd;
            long j = aVar.gnf + 1;
            aVar.gnf = j;
            textView.setText(String.valueOf(j));
            this.gnS.setVisibility(0);
            this.gog = this.gnL;
            this.goh.gos = this.gnL;
            this.goh.got = this.gnJ;
            this.gnS.setVisibility(0);
            this.gof.start();
            this.goj = this.gnS.getX();
            this.gok = this.gnS.getY();
            this.gol = this.gnS.getX();
            this.gom = this.gnS.getY();
            this.goi.removeAllUpdateListeners();
            this.goi.addUpdateListener(this.goq);
            this.goi.setFloatValues(0.0f, 2.0f);
            this.goi.start();
            return;
        }
        if (aq.bV(this.gnE.gnd.gnh, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.gnF.setVisibility(4);
        }
        if (this.gnE.gnd.gnj) {
            this.gnE.gnd.gnj = false;
            TextView textView2 = this.gnN;
            b.a aVar2 = this.gnE.gnd;
            long j2 = aVar2.gnf - 1;
            aVar2.gnf = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.gnJ.setVisibility(0);
        this.gnL.setVisibility(4);
    }

    private void lA(boolean z) {
        if (z) {
            this.gnG.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.gnG.setVisibility(0);
            this.gnE.gne.gnh = TbadkCoreApplication.getCurrentAccountNameShow();
            this.gnT.setVisibility(0);
            this.gnE.gne.gnj = true;
            TextView textView = this.gnO;
            b.a aVar = this.gnE.gne;
            long j = aVar.gnf + 1;
            aVar.gnf = j;
            textView.setText(String.valueOf(j));
            this.goj = this.gnT.getX() - (this.god / 2.0f);
            this.gog = this.gnM;
            this.goh.gos = this.gnM;
            this.goh.got = this.gnK;
            this.gnS.setVisibility(0);
            this.gof.start();
            this.goj = this.gnT.getX() - (this.god / 2);
            this.gok = this.gnT.getY();
            this.gol = this.gnT.getX();
            this.gom = this.gnT.getY();
            this.goi.removeAllUpdateListeners();
            this.goi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.gnT.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.goj) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.gnU) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.gnU / 2)))));
                        TopicPkView.this.gnT.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.gok) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.gnT.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.gnU / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.gnT.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.gnT.setVisibility(4);
                        TopicPkView.this.gnT.setX(TopicPkView.this.gol);
                        TopicPkView.this.gnT.setY(TopicPkView.this.gom);
                    }
                }
            });
            this.goi.setFloatValues(0.0f, 2.0f);
            this.goi.start();
            return;
        }
        if (aq.bV(this.gnE.gne.gnh, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.gnG.setVisibility(4);
        }
        if (this.gnE.gne.gnj) {
            this.gnE.gne.gnj = false;
            TextView textView2 = this.gnO;
            b.a aVar2 = this.gnE.gne;
            long j2 = aVar2.gnf - 1;
            aVar2.gnf = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.gnT.setVisibility(4);
        this.gnK.setVisibility(0);
        this.gnM.setVisibility(4);
    }

    private boolean bxA() {
        return (this.gnE == null || this.gnE.gnd == null || !this.gnE.gnd.gnj) ? false : true;
    }

    private boolean bxB() {
        return (this.gnE == null || this.gnE.gne == null || !this.gnE.gne.gnj) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.gof != null) {
            this.gof.cancel();
        }
        if (this.goi != null) {
            this.goi.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.gop = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes4.dex */
    public static class a implements Animator.AnimatorListener {
        private View gos;
        private View got;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.gos != null) {
                this.gos.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.got != null) {
                this.got.setVisibility(8);
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
