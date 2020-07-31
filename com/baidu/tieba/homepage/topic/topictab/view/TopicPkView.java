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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes16.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int iGA;
    private int iGB;
    private int iGC;
    private int iGD;
    private int iGE;
    private int iGF;
    private int iGG;
    private int iGH;
    private int iGI;
    private ValueAnimator iGJ;
    private View iGK;
    private a iGL;
    private ValueAnimator iGM;
    private double iGN;
    private double iGO;
    private float iGP;
    private float iGQ;
    private RelativeLayout.LayoutParams iGR;
    private RelativeLayout.LayoutParams iGS;
    private b iGT;
    private ValueAnimator.AnimatorUpdateListener iGU;
    private com.baidu.tieba.homepage.topic.topictab.b.b iGh;
    private TextView iGi;
    private TextView iGj;
    private FrameLayout iGk;
    private FrameLayout iGl;
    private TbImageView iGm;
    private TbImageView iGn;
    private TbImageView iGo;
    private TbImageView iGp;
    private TextView iGq;
    private TextView iGr;
    private ImageView iGs;
    private TextView iGt;
    private TextView iGu;
    private ImageView iGv;
    private ImageView iGw;
    private int iGx;
    private int iGy;
    private int iGz;
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
        void xL(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iGI = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iGU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iGv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGN) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iGx - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGk.getX() + (TopicPkView.this.iGx / 2)))));
                    TopicPkView.this.iGv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGO) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iGv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iGk.getX() + (TopicPkView.this.iGx / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGk.getX() + (TopicPkView.this.iGx / 2)))));
                    TopicPkView.this.iGv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iGv.setVisibility(4);
                    TopicPkView.this.iGv.setX(TopicPkView.this.iGP);
                    TopicPkView.this.iGv.setY(TopicPkView.this.iGQ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iGI = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iGU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iGv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGN) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iGx - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGk.getX() + (TopicPkView.this.iGx / 2)))));
                    TopicPkView.this.iGv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGO) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iGv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iGk.getX() + (TopicPkView.this.iGx / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGk.getX() + (TopicPkView.this.iGx / 2)))));
                    TopicPkView.this.iGv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iGv.setVisibility(4);
                    TopicPkView.this.iGv.setX(TopicPkView.this.iGP);
                    TopicPkView.this.iGv.setY(TopicPkView.this.iGQ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iGI = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iGU = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iGv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGN) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iGx - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGk.getX() + (TopicPkView.this.iGx / 2)))));
                    TopicPkView.this.iGv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGO) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iGv.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iGk.getX() + (TopicPkView.this.iGx / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGk.getX() + (TopicPkView.this.iGx / 2)))));
                    TopicPkView.this.iGv.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iGv.setVisibility(4);
                    TopicPkView.this.iGv.setX(TopicPkView.this.iGP);
                    TopicPkView.this.iGv.setY(TopicPkView.this.iGQ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.iGi = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.iGj = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.iGk = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.iGl = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.iGm = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.iGn = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.iGo = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.iGp = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.iGq = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.iGr = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.iGs = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.iGt = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.iGu = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.iGv = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.iGw = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.iGm.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.iGn.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.iGo.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.iGp.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.iGk.setOnClickListener(this);
        this.iGl.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.iGF = l.getDimens(context, R.dimen.tbds62);
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
        if (this.iGh != null) {
            this.iGx = this.iGk.getWidth();
            this.mBtnHeight = this.iGk.getHeight();
            this.iGy = this.iGm.getWidth();
            this.iGz = this.iGq.getWidth();
            this.iGA = this.iGr.getWidth();
            this.iGD = this.iGq.getHeight();
            this.iGB = this.iGt.getWidth();
            this.iGC = this.iGu.getWidth();
            this.mCursorWidth = this.iGs.getWidth();
            this.mCursorHeight = this.iGs.getHeight();
            this.iGE = ((this.mWidth - (this.iGx * 2)) - this.iGz) - this.iGA;
            this.iGH = this.iGv.getWidth();
            if (this.iGh.iFH.iFJ == 0 && this.iGh.iFI.iFJ == 0) {
                this.iGG = (int) ((0.5d * this.iGE) + this.iGz + this.iGx);
            } else {
                this.iGG = (int) (((((float) this.iGh.iFH.iFJ) / ((float) (this.iGh.iFH.iFJ + this.iGh.iFI.iFJ))) * this.iGE) + this.iGz + this.iGx);
            }
            float y = this.iGk.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.iGG + (this.mCursorWidth / 2) >= this.iGr.getLeft()) {
                this.iGG = (this.iGr.getLeft() - 10) - (this.mCursorWidth / 2);
                this.iGs.layout((this.iGr.getLeft() - 10) - this.mCursorWidth, (int) y, this.iGr.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.iGG - (this.mCursorWidth / 2) <= this.iGq.getRight()) {
                this.iGG = this.iGq.getRight() + 10 + (this.mCursorWidth / 2);
                this.iGs.layout(this.iGq.getRight() + 10, (int) y, this.iGq.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.iGs.layout(this.iGG - (this.mCursorWidth / 2), (int) y, this.iGG + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.iGm.getX());
            if (this.iGB < this.iGy) {
                int i5 = (this.iGx - this.iGB) / 2;
                this.iGt.layout(i5, (int) this.iGt.getY(), this.iGB + i5, ((int) this.iGt.getY()) + this.iGD);
            } else if (this.iGB <= x) {
                this.iGt.layout((int) this.iGm.getX(), (int) this.iGt.getY(), ((int) this.iGm.getX()) + this.iGB, ((int) this.iGt.getY()) + this.iGD);
            } else {
                ViewGroup.LayoutParams layoutParams = this.iGt.getLayoutParams();
                layoutParams.width = x;
                this.iGt.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.iGC < this.iGy) {
                int x2 = ((int) this.iGl.getX()) + ((this.iGx - this.iGC) / 2);
                this.iGu.layout(x2, (int) this.iGu.getY(), this.iGC + x2, ((int) this.iGu.getY()) + this.iGD);
            } else if (this.iGC <= x) {
                this.iGu.layout((this.mWidth - ((int) this.iGn.getX())) - this.iGC, (int) this.iGu.getY(), this.mWidth - ((int) this.iGn.getX()), ((int) this.iGu.getY()) + this.iGD);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.iGu.getLayoutParams();
                layoutParams2.width = x;
                this.iGu.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.iGx - this.iGH) / 2;
            this.iGv.layout(((int) this.iGk.getX()) + i6, ((int) this.iGk.getY()) + i6, ((int) this.iGk.getX()) + i6 + this.iGH, ((int) this.iGk.getY()) + i6 + this.iGH);
            this.iGw.layout(((int) this.iGl.getX()) + i6, ((int) this.iGl.getY()) + i6, ((int) this.iGl.getX()) + i6 + this.iGH, i6 + ((int) this.iGl.getY()) + this.iGH);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.iGh.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.iGJ == null || !this.iGJ.isRunning()) {
            if (this.iGM == null || !this.iGM.isRunning()) {
                if (this.iGM == null) {
                    this.iGM = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.iGM.setDuration(800L);
                    this.iGM.setInterpolator(new AccelerateInterpolator());
                }
                if (this.iGJ == null) {
                    this.iGJ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.iGJ.setDuration(800L);
                    this.iGJ.setInterpolator(new AccelerateInterpolator());
                    this.iGL = new a();
                    this.iGJ.addListener(this.iGL);
                    this.iGJ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.iGK.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.iGK.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cor()) {
                    i = 1;
                } else {
                    i = cos() ? 2 : 0;
                }
                if (view == this.iGk) {
                    pl(1 != i);
                    pm(false);
                    i2 = 1;
                } else if (view == this.iGl) {
                    pm(2 != i);
                    pl(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new ap("c13352").ah("obj_type", i2).t("topic_id", this.iGh.topicId).ah("obj_source", this.iGh.from));
                if (this.iGT != null) {
                    this.iGT.xL(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.iGh.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.iGh.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.iGh.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iGh != null) {
            O(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void O(Canvas canvas) {
        float y = this.iGk.getY() + ((this.mBtnHeight - this.iGF) / 2);
        this.mPaint.setShader(new LinearGradient(this.iGx / 2, y, this.iGG, y, ao.getColor(R.color.topic_pk_agree_bar_start_color), ao.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iGx / 2, y, this.iGG, y + this.iGF, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.iGG, y, this.mWidth - (this.iGx / 2), y, ao.getColor(R.color.topic_pk_disagree_bar_start_color), ao.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iGG, y, this.mWidth - (this.iGx / 2), y + this.iGF, this.mPaint);
    }

    public void setUserColor(int i) {
        this.iGI = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.iFH == null || bVar.iFI == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iGh = bVar;
        this.iGq.setText(String.valueOf(bVar.iFH.iFJ));
        this.iGr.setText(String.valueOf(bVar.iFI.iFJ));
        this.iGR = new RelativeLayout.LayoutParams(-2, -2);
        this.iGR.addRule(12);
        this.iGS = new RelativeLayout.LayoutParams(-2, -2);
        this.iGS.addRule(12);
        this.iGS.addRule(11);
        this.iGt.setLayoutParams(this.iGR);
        this.iGu.setLayoutParams(this.iGS);
        if (bVar.from == 3) {
            this.iGt.setText(StringUtils.isNull(bVar.iFH.iFK) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.iFH.iFK);
            this.iGu.setText(StringUtils.isNull(bVar.iFI.iFK) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.iFI.iFK);
            if (StringUtils.isNull(bVar.iFH.iFL)) {
                this.iGi.setVisibility(4);
            } else {
                this.iGi.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iFH.iFL));
            }
            if (StringUtils.isNull(bVar.iFI.iFL)) {
                this.iGj.setVisibility(4);
            } else {
                this.iGj.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iFI.iFL));
            }
        } else {
            this.iGt.setText(bVar.iFH.iFK);
            this.iGu.setText(bVar.iFI.iFK);
            this.iGi.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iFH.iFL));
            this.iGj.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iFI.iFL));
        }
        this.iGm.startLoad(bVar.iFH.iFM, 10, false);
        this.iGn.startLoad(bVar.iFI.iFM, 10, false);
        this.iGo.startLoad(bVar.iFH.iFP, 10, false);
        this.iGp.startLoad(bVar.iFI.iFP, 10, false);
        if (bVar.iFH.iFN) {
            this.iGm.setVisibility(4);
            this.iGo.setVisibility(0);
        } else {
            this.iGm.setVisibility(0);
            this.iGo.setVisibility(4);
        }
        if (bVar.iFI.iFN) {
            this.iGn.setVisibility(4);
            this.iGp.setVisibility(0);
        } else {
            this.iGn.setVisibility(0);
            this.iGp.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.iGi, this.iGI);
        ao.setViewTextColor(this.iGj, this.iGI);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.iGm.setIsNight(this.mSkinType == 1);
            this.iGn.setIsNight(this.mSkinType == 1);
            this.iGo.setIsNight(this.mSkinType == 1);
            this.iGp.setIsNight(this.mSkinType == 1);
            ao.setBackgroundResource(this.iGk, R.drawable.btn_topic_agree_bg_red);
            ao.setBackgroundResource(this.iGl, R.drawable.btn_topic_disagree_bg_blue);
            ao.setImageResource(this.iGv, R.drawable.pic_topic_addone);
            ao.setImageResource(this.iGw, R.drawable.pic_topic_addone);
            ao.setImageResource(this.iGs, R.drawable.pic_topic_vs_bginone);
            ao.setViewTextColor(this.iGq, R.color.cp_cont_a);
            ao.setViewTextColor(this.iGr, R.color.cp_cont_a);
            ao.setViewTextColor(this.iGt, R.color.topic_agree_des_color);
            ao.setViewTextColor(this.iGu, R.color.topic_disagree_des_color);
        }
    }

    private void pl(boolean z) {
        if (z) {
            this.iGi.setVisibility(0);
            this.iGi.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iGh.iFH.iFL = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iGh.iFH.iFN = true;
            TextView textView = this.iGq;
            b.a aVar = this.iGh.iFH;
            long j = aVar.iFJ + 1;
            aVar.iFJ = j;
            textView.setText(String.valueOf(j));
            this.iGv.setVisibility(0);
            this.iGK = this.iGo;
            this.iGL.iGW = this.iGo;
            this.iGL.iGX = this.iGm;
            this.iGv.setVisibility(0);
            this.iGJ.start();
            this.iGN = this.iGv.getX();
            this.iGO = this.iGv.getY();
            this.iGP = this.iGv.getX();
            this.iGQ = this.iGv.getY();
            this.iGM.removeAllUpdateListeners();
            this.iGM.addUpdateListener(this.iGU);
            this.iGM.setFloatValues(0.0f, 2.0f);
            this.iGM.start();
            return;
        }
        if (as.equals(this.iGh.iFH.iFL, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iGi.setVisibility(4);
        }
        if (this.iGh.iFH.iFN) {
            this.iGh.iFH.iFN = false;
            TextView textView2 = this.iGq;
            b.a aVar2 = this.iGh.iFH;
            long j2 = aVar2.iFJ - 1;
            aVar2.iFJ = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iGm.setVisibility(0);
        this.iGo.setVisibility(4);
    }

    private void pm(boolean z) {
        if (z) {
            this.iGj.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iGj.setVisibility(0);
            this.iGh.iFI.iFL = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iGw.setVisibility(0);
            this.iGh.iFI.iFN = true;
            TextView textView = this.iGr;
            b.a aVar = this.iGh.iFI;
            long j = aVar.iFJ + 1;
            aVar.iFJ = j;
            textView.setText(String.valueOf(j));
            this.iGN = this.iGw.getX() - (this.iGH / 2.0f);
            this.iGK = this.iGp;
            this.iGL.iGW = this.iGp;
            this.iGL.iGX = this.iGn;
            this.iGv.setVisibility(0);
            this.iGJ.start();
            this.iGN = this.iGw.getX() - (this.iGH / 2);
            this.iGO = this.iGw.getY();
            this.iGP = this.iGw.getX();
            this.iGQ = this.iGw.getY();
            this.iGM.removeAllUpdateListeners();
            this.iGM.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.iGw.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGN) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.iGx) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iGx / 2)))));
                        TopicPkView.this.iGw.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGO) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.iGw.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iGx / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.iGw.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.iGw.setVisibility(4);
                        TopicPkView.this.iGw.setX(TopicPkView.this.iGP);
                        TopicPkView.this.iGw.setY(TopicPkView.this.iGQ);
                    }
                }
            });
            this.iGM.setFloatValues(0.0f, 2.0f);
            this.iGM.start();
            return;
        }
        if (as.equals(this.iGh.iFI.iFL, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iGj.setVisibility(4);
        }
        if (this.iGh.iFI.iFN) {
            this.iGh.iFI.iFN = false;
            TextView textView2 = this.iGr;
            b.a aVar2 = this.iGh.iFI;
            long j2 = aVar2.iFJ - 1;
            aVar2.iFJ = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iGw.setVisibility(4);
        this.iGn.setVisibility(0);
        this.iGp.setVisibility(4);
    }

    private boolean cor() {
        return (this.iGh == null || this.iGh.iFH == null || !this.iGh.iFH.iFN) ? false : true;
    }

    private boolean cos() {
        return (this.iGh == null || this.iGh.iFI == null || !this.iGh.iFI.iFN) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.iGJ != null) {
            this.iGJ.cancel();
        }
        if (this.iGM != null) {
            this.iGM.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.iGT = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a implements Animator.AnimatorListener {
        private View iGW;
        private View iGX;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.iGW != null) {
                this.iGW.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.iGX != null) {
                this.iGX.setVisibility(8);
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
