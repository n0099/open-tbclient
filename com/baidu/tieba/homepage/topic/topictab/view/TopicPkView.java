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
    private int ijA;
    private int ijB;
    private int ijC;
    private ValueAnimator ijD;
    private View ijE;
    private a ijF;
    private ValueAnimator ijG;
    private double ijH;
    private double ijI;
    private float ijJ;
    private float ijK;
    private RelativeLayout.LayoutParams ijL;
    private RelativeLayout.LayoutParams ijM;
    private b ijN;
    private ValueAnimator.AnimatorUpdateListener ijO;
    private com.baidu.tieba.homepage.topic.topictab.b.b ija;
    private TextView ijb;
    private TextView ijc;
    private FrameLayout ijd;
    private FrameLayout ije;
    private TbImageView ijf;
    private TbImageView ijg;
    private TbImageView ijh;
    private TbImageView iji;
    private TextView ijj;
    private TextView ijl;
    private ImageView ijm;
    private TextView ijn;
    private TextView ijo;
    private ImageView ijp;
    private ImageView ijq;
    private int ijr;
    private int ijs;
    private int ijt;
    private int iju;
    private int ijv;
    private int ijw;
    private int ijx;
    private int ijy;
    private int ijz;
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
        void wJ(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ijC = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.ijO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ijp.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ijH) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ijr - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ijd.getX() + (TopicPkView.this.ijr / 2)))));
                    TopicPkView.this.ijp.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ijI) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ijp.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ijd.getX() + (TopicPkView.this.ijr / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ijd.getX() + (TopicPkView.this.ijr / 2)))));
                    TopicPkView.this.ijp.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ijp.setVisibility(4);
                    TopicPkView.this.ijp.setX(TopicPkView.this.ijJ);
                    TopicPkView.this.ijp.setY(TopicPkView.this.ijK);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ijC = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.ijO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ijp.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ijH) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ijr - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ijd.getX() + (TopicPkView.this.ijr / 2)))));
                    TopicPkView.this.ijp.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ijI) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ijp.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ijd.getX() + (TopicPkView.this.ijr / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ijd.getX() + (TopicPkView.this.ijr / 2)))));
                    TopicPkView.this.ijp.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ijp.setVisibility(4);
                    TopicPkView.this.ijp.setX(TopicPkView.this.ijJ);
                    TopicPkView.this.ijp.setY(TopicPkView.this.ijK);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ijC = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.ijO = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ijp.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ijH) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ijr - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ijd.getX() + (TopicPkView.this.ijr / 2)))));
                    TopicPkView.this.ijp.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ijI) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ijp.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ijd.getX() + (TopicPkView.this.ijr / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ijd.getX() + (TopicPkView.this.ijr / 2)))));
                    TopicPkView.this.ijp.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ijp.setVisibility(4);
                    TopicPkView.this.ijp.setX(TopicPkView.this.ijJ);
                    TopicPkView.this.ijp.setY(TopicPkView.this.ijK);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.ijb = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.ijc = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.ijd = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.ije = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.ijf = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.ijg = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.ijh = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.iji = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.ijj = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.ijl = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.ijm = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.ijn = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.ijo = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.ijp = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.ijq = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.ijf.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.ijg.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.ijh.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.iji.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.ijd.setOnClickListener(this);
        this.ije.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.ijz = l.getDimens(context, R.dimen.tbds62);
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
        if (this.ija != null) {
            this.ijr = this.ijd.getWidth();
            this.mBtnHeight = this.ijd.getHeight();
            this.ijs = this.ijf.getWidth();
            this.ijt = this.ijj.getWidth();
            this.iju = this.ijl.getWidth();
            this.ijx = this.ijj.getHeight();
            this.ijv = this.ijn.getWidth();
            this.ijw = this.ijo.getWidth();
            this.mCursorWidth = this.ijm.getWidth();
            this.mCursorHeight = this.ijm.getHeight();
            this.ijy = ((this.mWidth - (this.ijr * 2)) - this.ijt) - this.iju;
            this.ijB = this.ijp.getWidth();
            if (this.ija.iiz.iiB == 0 && this.ija.iiA.iiB == 0) {
                this.ijA = (int) ((0.5d * this.ijy) + this.ijt + this.ijr);
            } else {
                this.ijA = (int) (((((float) this.ija.iiz.iiB) / ((float) (this.ija.iiz.iiB + this.ija.iiA.iiB))) * this.ijy) + this.ijt + this.ijr);
            }
            float y = this.ijd.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.ijA + (this.mCursorWidth / 2) >= this.ijl.getLeft()) {
                this.ijA = (this.ijl.getLeft() - 10) - (this.mCursorWidth / 2);
                this.ijm.layout((this.ijl.getLeft() - 10) - this.mCursorWidth, (int) y, this.ijl.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.ijA - (this.mCursorWidth / 2) <= this.ijj.getRight()) {
                this.ijA = this.ijj.getRight() + 10 + (this.mCursorWidth / 2);
                this.ijm.layout(this.ijj.getRight() + 10, (int) y, this.ijj.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.ijm.layout(this.ijA - (this.mCursorWidth / 2), (int) y, this.ijA + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.ijf.getX());
            if (this.ijv < this.ijs) {
                int i5 = (this.ijr - this.ijv) / 2;
                this.ijn.layout(i5, (int) this.ijn.getY(), this.ijv + i5, ((int) this.ijn.getY()) + this.ijx);
            } else if (this.ijv <= x) {
                this.ijn.layout((int) this.ijf.getX(), (int) this.ijn.getY(), ((int) this.ijf.getX()) + this.ijv, ((int) this.ijn.getY()) + this.ijx);
            } else {
                ViewGroup.LayoutParams layoutParams = this.ijn.getLayoutParams();
                layoutParams.width = x;
                this.ijn.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.ijw < this.ijs) {
                int x2 = ((int) this.ije.getX()) + ((this.ijr - this.ijw) / 2);
                this.ijo.layout(x2, (int) this.ijo.getY(), this.ijw + x2, ((int) this.ijo.getY()) + this.ijx);
            } else if (this.ijw <= x) {
                this.ijo.layout((this.mWidth - ((int) this.ijg.getX())) - this.ijw, (int) this.ijo.getY(), this.mWidth - ((int) this.ijg.getX()), ((int) this.ijo.getY()) + this.ijx);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.ijo.getLayoutParams();
                layoutParams2.width = x;
                this.ijo.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.ijr - this.ijB) / 2;
            this.ijp.layout(((int) this.ijd.getX()) + i6, ((int) this.ijd.getY()) + i6, ((int) this.ijd.getX()) + i6 + this.ijB, ((int) this.ijd.getY()) + i6 + this.ijB);
            this.ijq.layout(((int) this.ije.getX()) + i6, ((int) this.ije.getY()) + i6, ((int) this.ije.getX()) + i6 + this.ijB, i6 + ((int) this.ije.getY()) + this.ijB);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.ija.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.ijD == null || !this.ijD.isRunning()) {
            if (this.ijG == null || !this.ijG.isRunning()) {
                if (this.ijG == null) {
                    this.ijG = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.ijG.setDuration(800L);
                    this.ijG.setInterpolator(new AccelerateInterpolator());
                }
                if (this.ijD == null) {
                    this.ijD = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.ijD.setDuration(800L);
                    this.ijD.setInterpolator(new AccelerateInterpolator());
                    this.ijF = new a();
                    this.ijD.addListener(this.ijF);
                    this.ijD.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.ijE.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.ijE.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (che()) {
                    i = 1;
                } else {
                    i = chf() ? 2 : 0;
                }
                if (view == this.ijd) {
                    ow(1 != i);
                    ox(false);
                    i2 = 1;
                } else if (view == this.ije) {
                    ox(2 != i);
                    ow(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").ag("obj_type", i2).s("topic_id", this.ija.topicId).ag("obj_source", this.ija.from));
                if (this.ijN != null) {
                    this.ijN.wJ(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.ija.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.ija.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.ija.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ija != null) {
            N(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void N(Canvas canvas) {
        float y = this.ijd.getY() + ((this.mBtnHeight - this.ijz) / 2);
        this.mPaint.setShader(new LinearGradient(this.ijr / 2, y, this.ijA, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.ijr / 2, y, this.ijA, y + this.ijz, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.ijA, y, this.mWidth - (this.ijr / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.ijA, y, this.mWidth - (this.ijr / 2), y + this.ijz, this.mPaint);
    }

    public void setUserColor(int i) {
        this.ijC = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.iiz == null || bVar.iiA == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ija = bVar;
        this.ijj.setText(String.valueOf(bVar.iiz.iiB));
        this.ijl.setText(String.valueOf(bVar.iiA.iiB));
        this.ijL = new RelativeLayout.LayoutParams(-2, -2);
        this.ijL.addRule(12);
        this.ijM = new RelativeLayout.LayoutParams(-2, -2);
        this.ijM.addRule(12);
        this.ijM.addRule(11);
        this.ijn.setLayoutParams(this.ijL);
        this.ijo.setLayoutParams(this.ijM);
        if (bVar.from == 3) {
            this.ijn.setText(StringUtils.isNull(bVar.iiz.iiC) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.iiz.iiC);
            this.ijo.setText(StringUtils.isNull(bVar.iiA.iiC) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.iiA.iiC);
            if (StringUtils.isNull(bVar.iiz.iiD)) {
                this.ijb.setVisibility(4);
            } else {
                this.ijb.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iiz.iiD));
            }
            if (StringUtils.isNull(bVar.iiA.iiD)) {
                this.ijc.setVisibility(4);
            } else {
                this.ijc.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iiA.iiD));
            }
        } else {
            this.ijn.setText(bVar.iiz.iiC);
            this.ijo.setText(bVar.iiA.iiC);
            this.ijb.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iiz.iiD));
            this.ijc.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iiA.iiD));
        }
        this.ijf.startLoad(bVar.iiz.iiE, 10, false);
        this.ijg.startLoad(bVar.iiA.iiE, 10, false);
        this.ijh.startLoad(bVar.iiz.iiH, 10, false);
        this.iji.startLoad(bVar.iiA.iiH, 10, false);
        if (bVar.iiz.iiF) {
            this.ijf.setVisibility(4);
            this.ijh.setVisibility(0);
        } else {
            this.ijf.setVisibility(0);
            this.ijh.setVisibility(4);
        }
        if (bVar.iiA.iiF) {
            this.ijg.setVisibility(4);
            this.iji.setVisibility(0);
        } else {
            this.ijg.setVisibility(0);
            this.iji.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.ijb, this.ijC);
        am.setViewTextColor(this.ijc, this.ijC);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.ijf.setIsNight(this.mSkinType == 1);
            this.ijg.setIsNight(this.mSkinType == 1);
            this.ijh.setIsNight(this.mSkinType == 1);
            this.iji.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.ijd, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.ije, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.ijp, R.drawable.pic_topic_addone);
            am.setImageResource(this.ijq, R.drawable.pic_topic_addone);
            am.setImageResource(this.ijm, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.ijj, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.ijl, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.ijn, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.ijo, (int) R.color.topic_disagree_des_color);
        }
    }

    private void ow(boolean z) {
        if (z) {
            this.ijb.setVisibility(0);
            this.ijb.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.ija.iiz.iiD = TbadkCoreApplication.getCurrentAccountNameShow();
            this.ija.iiz.iiF = true;
            TextView textView = this.ijj;
            b.a aVar = this.ija.iiz;
            long j = aVar.iiB + 1;
            aVar.iiB = j;
            textView.setText(String.valueOf(j));
            this.ijp.setVisibility(0);
            this.ijE = this.ijh;
            this.ijF.ijQ = this.ijh;
            this.ijF.ijR = this.ijf;
            this.ijp.setVisibility(0);
            this.ijD.start();
            this.ijH = this.ijp.getX();
            this.ijI = this.ijp.getY();
            this.ijJ = this.ijp.getX();
            this.ijK = this.ijp.getY();
            this.ijG.removeAllUpdateListeners();
            this.ijG.addUpdateListener(this.ijO);
            this.ijG.setFloatValues(0.0f, 2.0f);
            this.ijG.start();
            return;
        }
        if (aq.equals(this.ija.iiz.iiD, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ijb.setVisibility(4);
        }
        if (this.ija.iiz.iiF) {
            this.ija.iiz.iiF = false;
            TextView textView2 = this.ijj;
            b.a aVar2 = this.ija.iiz;
            long j2 = aVar2.iiB - 1;
            aVar2.iiB = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ijf.setVisibility(0);
        this.ijh.setVisibility(4);
    }

    private void ox(boolean z) {
        if (z) {
            this.ijc.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.ijc.setVisibility(0);
            this.ija.iiA.iiD = TbadkCoreApplication.getCurrentAccountNameShow();
            this.ijq.setVisibility(0);
            this.ija.iiA.iiF = true;
            TextView textView = this.ijl;
            b.a aVar = this.ija.iiA;
            long j = aVar.iiB + 1;
            aVar.iiB = j;
            textView.setText(String.valueOf(j));
            this.ijH = this.ijq.getX() - (this.ijB / 2.0f);
            this.ijE = this.iji;
            this.ijF.ijQ = this.iji;
            this.ijF.ijR = this.ijg;
            this.ijp.setVisibility(0);
            this.ijD.start();
            this.ijH = this.ijq.getX() - (this.ijB / 2);
            this.ijI = this.ijq.getY();
            this.ijJ = this.ijq.getX();
            this.ijK = this.ijq.getY();
            this.ijG.removeAllUpdateListeners();
            this.ijG.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.ijq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ijH) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.ijr) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ijr / 2)))));
                        TopicPkView.this.ijq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ijI) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.ijq.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ijr / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.ijq.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.ijq.setVisibility(4);
                        TopicPkView.this.ijq.setX(TopicPkView.this.ijJ);
                        TopicPkView.this.ijq.setY(TopicPkView.this.ijK);
                    }
                }
            });
            this.ijG.setFloatValues(0.0f, 2.0f);
            this.ijG.start();
            return;
        }
        if (aq.equals(this.ija.iiA.iiD, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ijc.setVisibility(4);
        }
        if (this.ija.iiA.iiF) {
            this.ija.iiA.iiF = false;
            TextView textView2 = this.ijl;
            b.a aVar2 = this.ija.iiA;
            long j2 = aVar2.iiB - 1;
            aVar2.iiB = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ijq.setVisibility(4);
        this.ijg.setVisibility(0);
        this.iji.setVisibility(4);
    }

    private boolean che() {
        return (this.ija == null || this.ija.iiz == null || !this.ija.iiz.iiF) ? false : true;
    }

    private boolean chf() {
        return (this.ija == null || this.ija.iiA == null || !this.ija.iiA.iiF) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.ijD != null) {
            this.ijD.cancel();
        }
        if (this.ijG != null) {
            this.ijG.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.ijN = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Animator.AnimatorListener {
        private View ijQ;
        private View ijR;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.ijQ != null) {
                this.ijQ.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.ijR != null) {
                this.ijR.setVisibility(8);
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
