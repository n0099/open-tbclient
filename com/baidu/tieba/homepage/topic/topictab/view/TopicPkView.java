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
    private com.baidu.tieba.homepage.topic.topictab.b.b hjO;
    private TextView hjP;
    private TextView hjQ;
    private FrameLayout hjR;
    private FrameLayout hjS;
    private TbImageView hjT;
    private TbImageView hjU;
    private TbImageView hjV;
    private TbImageView hjW;
    private TextView hjX;
    private TextView hjY;
    private ImageView hjZ;
    private b hkA;
    private ValueAnimator.AnimatorUpdateListener hkB;
    private TextView hka;
    private TextView hkb;
    private ImageView hkc;
    private ImageView hkd;
    private int hke;
    private int hkf;
    private int hkg;
    private int hkh;
    private int hki;
    private int hkj;
    private int hkk;
    private int hkl;
    private int hkm;
    private int hkn;
    private int hko;
    private int hkp;
    private ValueAnimator hkq;
    private View hkr;
    private a hks;
    private ValueAnimator hkt;
    private double hku;
    private double hkv;
    private float hkw;
    private float hkx;
    private RelativeLayout.LayoutParams hky;
    private RelativeLayout.LayoutParams hkz;
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
        void vD(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hkp = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hkB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hkc.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hku) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hke - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hjR.getX() + (TopicPkView.this.hke / 2)))));
                    TopicPkView.this.hkc.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hkv) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hkc.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hjR.getX() + (TopicPkView.this.hke / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hjR.getX() + (TopicPkView.this.hke / 2)))));
                    TopicPkView.this.hkc.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hkc.setVisibility(4);
                    TopicPkView.this.hkc.setX(TopicPkView.this.hkw);
                    TopicPkView.this.hkc.setY(TopicPkView.this.hkx);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hkp = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hkB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hkc.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hku) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hke - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hjR.getX() + (TopicPkView.this.hke / 2)))));
                    TopicPkView.this.hkc.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hkv) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hkc.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hjR.getX() + (TopicPkView.this.hke / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hjR.getX() + (TopicPkView.this.hke / 2)))));
                    TopicPkView.this.hkc.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hkc.setVisibility(4);
                    TopicPkView.this.hkc.setX(TopicPkView.this.hkw);
                    TopicPkView.this.hkc.setY(TopicPkView.this.hkx);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hkp = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hkB = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hkc.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hku) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hke - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hjR.getX() + (TopicPkView.this.hke / 2)))));
                    TopicPkView.this.hkc.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hkv) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hkc.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hjR.getX() + (TopicPkView.this.hke / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hjR.getX() + (TopicPkView.this.hke / 2)))));
                    TopicPkView.this.hkc.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hkc.setVisibility(4);
                    TopicPkView.this.hkc.setX(TopicPkView.this.hkw);
                    TopicPkView.this.hkc.setY(TopicPkView.this.hkx);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.hjP = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.hjQ = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.hjR = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.hjS = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.hjT = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.hjU = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.hjV = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.hjW = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.hjX = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.hjY = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.hjZ = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.hka = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.hkb = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.hkc = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.hkd = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.hjT.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.hjU.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.hjV.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.hjW.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.hjR.setOnClickListener(this);
        this.hjS.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.hkm = l.getDimens(context, R.dimen.tbds62);
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
        if (this.hjO != null) {
            this.hke = this.hjR.getWidth();
            this.mBtnHeight = this.hjR.getHeight();
            this.hkf = this.hjT.getWidth();
            this.hkg = this.hjX.getWidth();
            this.hkh = this.hjY.getWidth();
            this.hkk = this.hjX.getHeight();
            this.hki = this.hka.getWidth();
            this.hkj = this.hkb.getWidth();
            this.mCursorWidth = this.hjZ.getWidth();
            this.mCursorHeight = this.hjZ.getHeight();
            this.hkl = ((this.mWidth - (this.hke * 2)) - this.hkg) - this.hkh;
            this.hko = this.hkc.getWidth();
            if (this.hjO.hjn.hjp == 0 && this.hjO.hjo.hjp == 0) {
                this.hkn = (int) ((0.5d * this.hkl) + this.hkg + this.hke);
            } else {
                this.hkn = (int) (((((float) this.hjO.hjn.hjp) / ((float) (this.hjO.hjn.hjp + this.hjO.hjo.hjp))) * this.hkl) + this.hkg + this.hke);
            }
            float y = this.hjR.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.hkn + (this.mCursorWidth / 2) >= this.hjY.getLeft()) {
                this.hkn = (this.hjY.getLeft() - 10) - (this.mCursorWidth / 2);
                this.hjZ.layout((this.hjY.getLeft() - 10) - this.mCursorWidth, (int) y, this.hjY.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.hkn - (this.mCursorWidth / 2) <= this.hjX.getRight()) {
                this.hkn = this.hjX.getRight() + 10 + (this.mCursorWidth / 2);
                this.hjZ.layout(this.hjX.getRight() + 10, (int) y, this.hjX.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.hjZ.layout(this.hkn - (this.mCursorWidth / 2), (int) y, this.hkn + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.hjT.getX());
            if (this.hki < this.hkf) {
                int i5 = (this.hke - this.hki) / 2;
                this.hka.layout(i5, (int) this.hka.getY(), this.hki + i5, ((int) this.hka.getY()) + this.hkk);
            } else if (this.hki <= x) {
                this.hka.layout((int) this.hjT.getX(), (int) this.hka.getY(), ((int) this.hjT.getX()) + this.hki, ((int) this.hka.getY()) + this.hkk);
            } else {
                ViewGroup.LayoutParams layoutParams = this.hka.getLayoutParams();
                layoutParams.width = x;
                this.hka.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.hkj < this.hkf) {
                int x2 = ((int) this.hjS.getX()) + ((this.hke - this.hkj) / 2);
                this.hkb.layout(x2, (int) this.hkb.getY(), this.hkj + x2, ((int) this.hkb.getY()) + this.hkk);
            } else if (this.hkj <= x) {
                this.hkb.layout((this.mWidth - ((int) this.hjU.getX())) - this.hkj, (int) this.hkb.getY(), this.mWidth - ((int) this.hjU.getX()), ((int) this.hkb.getY()) + this.hkk);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.hkb.getLayoutParams();
                layoutParams2.width = x;
                this.hkb.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.hke - this.hko) / 2;
            this.hkc.layout(((int) this.hjR.getX()) + i6, ((int) this.hjR.getY()) + i6, ((int) this.hjR.getX()) + i6 + this.hko, ((int) this.hjR.getY()) + i6 + this.hko);
            this.hkd.layout(((int) this.hjS.getX()) + i6, ((int) this.hjS.getY()) + i6, ((int) this.hjS.getX()) + i6 + this.hko, i6 + ((int) this.hjS.getY()) + this.hko);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.hjO.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.hkq == null || !this.hkq.isRunning()) {
            if (this.hkt == null || !this.hkt.isRunning()) {
                if (this.hkt == null) {
                    this.hkt = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.hkt.setDuration(800L);
                    this.hkt.setInterpolator(new AccelerateInterpolator());
                }
                if (this.hkq == null) {
                    this.hkq = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.hkq.setDuration(800L);
                    this.hkq.setInterpolator(new AccelerateInterpolator());
                    this.hks = new a();
                    this.hkq.addListener(this.hks);
                    this.hkq.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.hkr.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.hkr.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (bPX()) {
                    i = 1;
                } else {
                    i = bPY() ? 2 : 0;
                }
                if (view == this.hjR) {
                    mW(1 != i);
                    mX(false);
                    i2 = 1;
                } else if (view == this.hjS) {
                    mX(2 != i);
                    mW(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").X("obj_type", i2).s("topic_id", this.hjO.topicId).X("obj_source", this.hjO.from));
                if (this.hkA != null) {
                    this.hkA.vD(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.hjO.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.hjO.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.hjO.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.hjO != null) {
            L(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void L(Canvas canvas) {
        float y = this.hjR.getY() + ((this.mBtnHeight - this.hkm) / 2);
        this.mPaint.setShader(new LinearGradient(this.hke / 2, y, this.hkn, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hke / 2, y, this.hkn, y + this.hkm, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.hkn, y, this.mWidth - (this.hke / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hkn, y, this.mWidth - (this.hke / 2), y + this.hkm, this.mPaint);
    }

    public void setUserColor(int i) {
        this.hkp = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.hjn == null || bVar.hjo == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hjO = bVar;
        this.hjX.setText(String.valueOf(bVar.hjn.hjp));
        this.hjY.setText(String.valueOf(bVar.hjo.hjp));
        this.hky = new RelativeLayout.LayoutParams(-2, -2);
        this.hky.addRule(12);
        this.hkz = new RelativeLayout.LayoutParams(-2, -2);
        this.hkz.addRule(12);
        this.hkz.addRule(11);
        this.hka.setLayoutParams(this.hky);
        this.hkb.setLayoutParams(this.hkz);
        if (bVar.from == 3) {
            this.hka.setText(StringUtils.isNull(bVar.hjn.hjq) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.hjn.hjq);
            this.hkb.setText(StringUtils.isNull(bVar.hjo.hjq) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.hjo.hjq);
            if (StringUtils.isNull(bVar.hjn.hjr)) {
                this.hjP.setVisibility(4);
            } else {
                this.hjP.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hjn.hjr));
            }
            if (StringUtils.isNull(bVar.hjo.hjr)) {
                this.hjQ.setVisibility(4);
            } else {
                this.hjQ.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hjo.hjr));
            }
        } else {
            this.hka.setText(bVar.hjn.hjq);
            this.hkb.setText(bVar.hjo.hjq);
            this.hjP.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hjn.hjr));
            this.hjQ.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hjo.hjr));
        }
        this.hjT.startLoad(bVar.hjn.hjs, 10, false);
        this.hjU.startLoad(bVar.hjo.hjs, 10, false);
        this.hjV.startLoad(bVar.hjn.hjv, 10, false);
        this.hjW.startLoad(bVar.hjo.hjv, 10, false);
        if (bVar.hjn.hjt) {
            this.hjT.setVisibility(4);
            this.hjV.setVisibility(0);
        } else {
            this.hjT.setVisibility(0);
            this.hjV.setVisibility(4);
        }
        if (bVar.hjo.hjt) {
            this.hjU.setVisibility(4);
            this.hjW.setVisibility(0);
        } else {
            this.hjU.setVisibility(0);
            this.hjW.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.hjP, this.hkp);
        am.setViewTextColor(this.hjQ, this.hkp);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.hjT.setIsNight(this.mSkinType == 1);
            this.hjU.setIsNight(this.mSkinType == 1);
            this.hjV.setIsNight(this.mSkinType == 1);
            this.hjW.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.hjR, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.hjS, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.hkc, R.drawable.pic_topic_addone);
            am.setImageResource(this.hkd, R.drawable.pic_topic_addone);
            am.setImageResource(this.hjZ, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.hjX, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hjY, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hka, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.hkb, (int) R.color.topic_disagree_des_color);
        }
    }

    private void mW(boolean z) {
        if (z) {
            this.hjP.setVisibility(0);
            this.hjP.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hjO.hjn.hjr = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hjO.hjn.hjt = true;
            TextView textView = this.hjX;
            b.a aVar = this.hjO.hjn;
            long j = aVar.hjp + 1;
            aVar.hjp = j;
            textView.setText(String.valueOf(j));
            this.hkc.setVisibility(0);
            this.hkr = this.hjV;
            this.hks.hkD = this.hjV;
            this.hks.hkE = this.hjT;
            this.hkc.setVisibility(0);
            this.hkq.start();
            this.hku = this.hkc.getX();
            this.hkv = this.hkc.getY();
            this.hkw = this.hkc.getX();
            this.hkx = this.hkc.getY();
            this.hkt.removeAllUpdateListeners();
            this.hkt.addUpdateListener(this.hkB);
            this.hkt.setFloatValues(0.0f, 2.0f);
            this.hkt.start();
            return;
        }
        if (aq.equals(this.hjO.hjn.hjr, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hjP.setVisibility(4);
        }
        if (this.hjO.hjn.hjt) {
            this.hjO.hjn.hjt = false;
            TextView textView2 = this.hjX;
            b.a aVar2 = this.hjO.hjn;
            long j2 = aVar2.hjp - 1;
            aVar2.hjp = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hjT.setVisibility(0);
        this.hjV.setVisibility(4);
    }

    private void mX(boolean z) {
        if (z) {
            this.hjQ.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hjQ.setVisibility(0);
            this.hjO.hjo.hjr = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hkd.setVisibility(0);
            this.hjO.hjo.hjt = true;
            TextView textView = this.hjY;
            b.a aVar = this.hjO.hjo;
            long j = aVar.hjp + 1;
            aVar.hjp = j;
            textView.setText(String.valueOf(j));
            this.hku = this.hkd.getX() - (this.hko / 2.0f);
            this.hkr = this.hjW;
            this.hks.hkD = this.hjW;
            this.hks.hkE = this.hjU;
            this.hkc.setVisibility(0);
            this.hkq.start();
            this.hku = this.hkd.getX() - (this.hko / 2);
            this.hkv = this.hkd.getY();
            this.hkw = this.hkd.getX();
            this.hkx = this.hkd.getY();
            this.hkt.removeAllUpdateListeners();
            this.hkt.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.hkd.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hku) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.hke) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hke / 2)))));
                        TopicPkView.this.hkd.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hkv) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.hkd.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hke / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.hkd.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.hkd.setVisibility(4);
                        TopicPkView.this.hkd.setX(TopicPkView.this.hkw);
                        TopicPkView.this.hkd.setY(TopicPkView.this.hkx);
                    }
                }
            });
            this.hkt.setFloatValues(0.0f, 2.0f);
            this.hkt.start();
            return;
        }
        if (aq.equals(this.hjO.hjo.hjr, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hjQ.setVisibility(4);
        }
        if (this.hjO.hjo.hjt) {
            this.hjO.hjo.hjt = false;
            TextView textView2 = this.hjY;
            b.a aVar2 = this.hjO.hjo;
            long j2 = aVar2.hjp - 1;
            aVar2.hjp = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hkd.setVisibility(4);
        this.hjU.setVisibility(0);
        this.hjW.setVisibility(4);
    }

    private boolean bPX() {
        return (this.hjO == null || this.hjO.hjn == null || !this.hjO.hjn.hjt) ? false : true;
    }

    private boolean bPY() {
        return (this.hjO == null || this.hjO.hjo == null || !this.hjO.hjo.hjt) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.hkq != null) {
            this.hkq.cancel();
        }
        if (this.hkt != null) {
            this.hkt.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.hkA = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Animator.AnimatorListener {
        private View hkD;
        private View hkE;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.hkD != null) {
                this.hkD.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.hkE != null) {
                this.hkE.setVisibility(8);
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
