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
    private int iGJ;
    private int iGK;
    private ValueAnimator iGL;
    private View iGM;
    private a iGN;
    private ValueAnimator iGO;
    private double iGP;
    private double iGQ;
    private float iGR;
    private float iGS;
    private RelativeLayout.LayoutParams iGT;
    private RelativeLayout.LayoutParams iGU;
    private b iGV;
    private ValueAnimator.AnimatorUpdateListener iGW;
    private com.baidu.tieba.homepage.topic.topictab.b.b iGj;
    private TextView iGk;
    private TextView iGl;
    private FrameLayout iGm;
    private FrameLayout iGn;
    private TbImageView iGo;
    private TbImageView iGp;
    private TbImageView iGq;
    private TbImageView iGr;
    private TextView iGs;
    private TextView iGt;
    private ImageView iGu;
    private TextView iGv;
    private TextView iGw;
    private ImageView iGx;
    private ImageView iGy;
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
        this.iGK = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iGW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iGx.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGP) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iGz - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGm.getX() + (TopicPkView.this.iGz / 2)))));
                    TopicPkView.this.iGx.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGQ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iGx.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iGm.getX() + (TopicPkView.this.iGz / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGm.getX() + (TopicPkView.this.iGz / 2)))));
                    TopicPkView.this.iGx.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iGx.setVisibility(4);
                    TopicPkView.this.iGx.setX(TopicPkView.this.iGR);
                    TopicPkView.this.iGx.setY(TopicPkView.this.iGS);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iGK = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iGW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iGx.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGP) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iGz - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGm.getX() + (TopicPkView.this.iGz / 2)))));
                    TopicPkView.this.iGx.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGQ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iGx.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iGm.getX() + (TopicPkView.this.iGz / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGm.getX() + (TopicPkView.this.iGz / 2)))));
                    TopicPkView.this.iGx.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iGx.setVisibility(4);
                    TopicPkView.this.iGx.setX(TopicPkView.this.iGR);
                    TopicPkView.this.iGx.setY(TopicPkView.this.iGS);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iGK = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.iGW = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.iGx.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGP) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.iGz - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGm.getX() + (TopicPkView.this.iGz / 2)))));
                    TopicPkView.this.iGx.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGQ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.iGx.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.iGm.getX() + (TopicPkView.this.iGz / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.iGm.getX() + (TopicPkView.this.iGz / 2)))));
                    TopicPkView.this.iGx.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.iGx.setVisibility(4);
                    TopicPkView.this.iGx.setX(TopicPkView.this.iGR);
                    TopicPkView.this.iGx.setY(TopicPkView.this.iGS);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.iGk = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.iGl = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.iGm = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.iGn = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.iGo = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.iGp = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.iGq = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.iGr = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.iGs = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.iGt = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.iGu = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.iGv = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.iGw = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.iGx = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.iGy = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.iGo.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.iGp.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.iGq.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.iGr.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.iGm.setOnClickListener(this);
        this.iGn.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.iGH = l.getDimens(context, R.dimen.tbds62);
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
        if (this.iGj != null) {
            this.iGz = this.iGm.getWidth();
            this.mBtnHeight = this.iGm.getHeight();
            this.iGA = this.iGo.getWidth();
            this.iGB = this.iGs.getWidth();
            this.iGC = this.iGt.getWidth();
            this.iGF = this.iGs.getHeight();
            this.iGD = this.iGv.getWidth();
            this.iGE = this.iGw.getWidth();
            this.mCursorWidth = this.iGu.getWidth();
            this.mCursorHeight = this.iGu.getHeight();
            this.iGG = ((this.mWidth - (this.iGz * 2)) - this.iGB) - this.iGC;
            this.iGJ = this.iGx.getWidth();
            if (this.iGj.iFJ.iFL == 0 && this.iGj.iFK.iFL == 0) {
                this.iGI = (int) ((0.5d * this.iGG) + this.iGB + this.iGz);
            } else {
                this.iGI = (int) (((((float) this.iGj.iFJ.iFL) / ((float) (this.iGj.iFJ.iFL + this.iGj.iFK.iFL))) * this.iGG) + this.iGB + this.iGz);
            }
            float y = this.iGm.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.iGI + (this.mCursorWidth / 2) >= this.iGt.getLeft()) {
                this.iGI = (this.iGt.getLeft() - 10) - (this.mCursorWidth / 2);
                this.iGu.layout((this.iGt.getLeft() - 10) - this.mCursorWidth, (int) y, this.iGt.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.iGI - (this.mCursorWidth / 2) <= this.iGs.getRight()) {
                this.iGI = this.iGs.getRight() + 10 + (this.mCursorWidth / 2);
                this.iGu.layout(this.iGs.getRight() + 10, (int) y, this.iGs.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.iGu.layout(this.iGI - (this.mCursorWidth / 2), (int) y, this.iGI + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.iGo.getX());
            if (this.iGD < this.iGA) {
                int i5 = (this.iGz - this.iGD) / 2;
                this.iGv.layout(i5, (int) this.iGv.getY(), this.iGD + i5, ((int) this.iGv.getY()) + this.iGF);
            } else if (this.iGD <= x) {
                this.iGv.layout((int) this.iGo.getX(), (int) this.iGv.getY(), ((int) this.iGo.getX()) + this.iGD, ((int) this.iGv.getY()) + this.iGF);
            } else {
                ViewGroup.LayoutParams layoutParams = this.iGv.getLayoutParams();
                layoutParams.width = x;
                this.iGv.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.iGE < this.iGA) {
                int x2 = ((int) this.iGn.getX()) + ((this.iGz - this.iGE) / 2);
                this.iGw.layout(x2, (int) this.iGw.getY(), this.iGE + x2, ((int) this.iGw.getY()) + this.iGF);
            } else if (this.iGE <= x) {
                this.iGw.layout((this.mWidth - ((int) this.iGp.getX())) - this.iGE, (int) this.iGw.getY(), this.mWidth - ((int) this.iGp.getX()), ((int) this.iGw.getY()) + this.iGF);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.iGw.getLayoutParams();
                layoutParams2.width = x;
                this.iGw.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.iGz - this.iGJ) / 2;
            this.iGx.layout(((int) this.iGm.getX()) + i6, ((int) this.iGm.getY()) + i6, ((int) this.iGm.getX()) + i6 + this.iGJ, ((int) this.iGm.getY()) + i6 + this.iGJ);
            this.iGy.layout(((int) this.iGn.getX()) + i6, ((int) this.iGn.getY()) + i6, ((int) this.iGn.getX()) + i6 + this.iGJ, i6 + ((int) this.iGn.getY()) + this.iGJ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.iGj.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.iGL == null || !this.iGL.isRunning()) {
            if (this.iGO == null || !this.iGO.isRunning()) {
                if (this.iGO == null) {
                    this.iGO = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.iGO.setDuration(800L);
                    this.iGO.setInterpolator(new AccelerateInterpolator());
                }
                if (this.iGL == null) {
                    this.iGL = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.iGL.setDuration(800L);
                    this.iGL.setInterpolator(new AccelerateInterpolator());
                    this.iGN = new a();
                    this.iGL.addListener(this.iGN);
                    this.iGL.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.iGM.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.iGM.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cor()) {
                    i = 1;
                } else {
                    i = cos() ? 2 : 0;
                }
                if (view == this.iGm) {
                    pl(1 != i);
                    pm(false);
                    i2 = 1;
                } else if (view == this.iGn) {
                    pm(2 != i);
                    pl(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new ap("c13352").ah("obj_type", i2).t("topic_id", this.iGj.topicId).ah("obj_source", this.iGj.from));
                if (this.iGV != null) {
                    this.iGV.xL(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.iGj.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.iGj.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.iGj.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.iGj != null) {
            O(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void O(Canvas canvas) {
        float y = this.iGm.getY() + ((this.mBtnHeight - this.iGH) / 2);
        this.mPaint.setShader(new LinearGradient(this.iGz / 2, y, this.iGI, y, ao.getColor(R.color.topic_pk_agree_bar_start_color), ao.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iGz / 2, y, this.iGI, y + this.iGH, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.iGI, y, this.mWidth - (this.iGz / 2), y, ao.getColor(R.color.topic_pk_disagree_bar_start_color), ao.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.iGI, y, this.mWidth - (this.iGz / 2), y + this.iGH, this.mPaint);
    }

    public void setUserColor(int i) {
        this.iGK = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.iFJ == null || bVar.iFK == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.iGj = bVar;
        this.iGs.setText(String.valueOf(bVar.iFJ.iFL));
        this.iGt.setText(String.valueOf(bVar.iFK.iFL));
        this.iGT = new RelativeLayout.LayoutParams(-2, -2);
        this.iGT.addRule(12);
        this.iGU = new RelativeLayout.LayoutParams(-2, -2);
        this.iGU.addRule(12);
        this.iGU.addRule(11);
        this.iGv.setLayoutParams(this.iGT);
        this.iGw.setLayoutParams(this.iGU);
        if (bVar.from == 3) {
            this.iGv.setText(StringUtils.isNull(bVar.iFJ.iFM) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.iFJ.iFM);
            this.iGw.setText(StringUtils.isNull(bVar.iFK.iFM) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.iFK.iFM);
            if (StringUtils.isNull(bVar.iFJ.iFN)) {
                this.iGk.setVisibility(4);
            } else {
                this.iGk.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iFJ.iFN));
            }
            if (StringUtils.isNull(bVar.iFK.iFN)) {
                this.iGl.setVisibility(4);
            } else {
                this.iGl.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iFK.iFN));
            }
        } else {
            this.iGv.setText(bVar.iFJ.iFM);
            this.iGw.setText(bVar.iFK.iFM);
            this.iGk.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iFJ.iFN));
            this.iGl.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.iFK.iFN));
        }
        this.iGo.startLoad(bVar.iFJ.iFO, 10, false);
        this.iGp.startLoad(bVar.iFK.iFO, 10, false);
        this.iGq.startLoad(bVar.iFJ.iFR, 10, false);
        this.iGr.startLoad(bVar.iFK.iFR, 10, false);
        if (bVar.iFJ.iFP) {
            this.iGo.setVisibility(4);
            this.iGq.setVisibility(0);
        } else {
            this.iGo.setVisibility(0);
            this.iGq.setVisibility(4);
        }
        if (bVar.iFK.iFP) {
            this.iGp.setVisibility(4);
            this.iGr.setVisibility(0);
        } else {
            this.iGp.setVisibility(0);
            this.iGr.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.iGk, this.iGK);
        ao.setViewTextColor(this.iGl, this.iGK);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.iGo.setIsNight(this.mSkinType == 1);
            this.iGp.setIsNight(this.mSkinType == 1);
            this.iGq.setIsNight(this.mSkinType == 1);
            this.iGr.setIsNight(this.mSkinType == 1);
            ao.setBackgroundResource(this.iGm, R.drawable.btn_topic_agree_bg_red);
            ao.setBackgroundResource(this.iGn, R.drawable.btn_topic_disagree_bg_blue);
            ao.setImageResource(this.iGx, R.drawable.pic_topic_addone);
            ao.setImageResource(this.iGy, R.drawable.pic_topic_addone);
            ao.setImageResource(this.iGu, R.drawable.pic_topic_vs_bginone);
            ao.setViewTextColor(this.iGs, R.color.cp_cont_a);
            ao.setViewTextColor(this.iGt, R.color.cp_cont_a);
            ao.setViewTextColor(this.iGv, R.color.topic_agree_des_color);
            ao.setViewTextColor(this.iGw, R.color.topic_disagree_des_color);
        }
    }

    private void pl(boolean z) {
        if (z) {
            this.iGk.setVisibility(0);
            this.iGk.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iGj.iFJ.iFN = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iGj.iFJ.iFP = true;
            TextView textView = this.iGs;
            b.a aVar = this.iGj.iFJ;
            long j = aVar.iFL + 1;
            aVar.iFL = j;
            textView.setText(String.valueOf(j));
            this.iGx.setVisibility(0);
            this.iGM = this.iGq;
            this.iGN.iGY = this.iGq;
            this.iGN.iGZ = this.iGo;
            this.iGx.setVisibility(0);
            this.iGL.start();
            this.iGP = this.iGx.getX();
            this.iGQ = this.iGx.getY();
            this.iGR = this.iGx.getX();
            this.iGS = this.iGx.getY();
            this.iGO.removeAllUpdateListeners();
            this.iGO.addUpdateListener(this.iGW);
            this.iGO.setFloatValues(0.0f, 2.0f);
            this.iGO.start();
            return;
        }
        if (as.equals(this.iGj.iFJ.iFN, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iGk.setVisibility(4);
        }
        if (this.iGj.iFJ.iFP) {
            this.iGj.iFJ.iFP = false;
            TextView textView2 = this.iGs;
            b.a aVar2 = this.iGj.iFJ;
            long j2 = aVar2.iFL - 1;
            aVar2.iFL = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iGo.setVisibility(0);
        this.iGq.setVisibility(4);
    }

    private void pm(boolean z) {
        if (z) {
            this.iGl.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.iGl.setVisibility(0);
            this.iGj.iFK.iFN = TbadkCoreApplication.getCurrentAccountNameShow();
            this.iGy.setVisibility(0);
            this.iGj.iFK.iFP = true;
            TextView textView = this.iGt;
            b.a aVar = this.iGj.iFK;
            long j = aVar.iFL + 1;
            aVar.iFL = j;
            textView.setText(String.valueOf(j));
            this.iGP = this.iGy.getX() - (this.iGJ / 2.0f);
            this.iGM = this.iGr;
            this.iGN.iGY = this.iGr;
            this.iGN.iGZ = this.iGp;
            this.iGx.setVisibility(0);
            this.iGL.start();
            this.iGP = this.iGy.getX() - (this.iGJ / 2);
            this.iGQ = this.iGy.getY();
            this.iGR = this.iGy.getX();
            this.iGS = this.iGy.getY();
            this.iGO.removeAllUpdateListeners();
            this.iGO.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.iGy.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGP) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.iGz) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iGz / 2)))));
                        TopicPkView.this.iGy.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.iGQ) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.iGy.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.iGz / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.iGy.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.iGy.setVisibility(4);
                        TopicPkView.this.iGy.setX(TopicPkView.this.iGR);
                        TopicPkView.this.iGy.setY(TopicPkView.this.iGS);
                    }
                }
            });
            this.iGO.setFloatValues(0.0f, 2.0f);
            this.iGO.start();
            return;
        }
        if (as.equals(this.iGj.iFK.iFN, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.iGl.setVisibility(4);
        }
        if (this.iGj.iFK.iFP) {
            this.iGj.iFK.iFP = false;
            TextView textView2 = this.iGt;
            b.a aVar2 = this.iGj.iFK;
            long j2 = aVar2.iFL - 1;
            aVar2.iFL = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.iGy.setVisibility(4);
        this.iGp.setVisibility(0);
        this.iGr.setVisibility(4);
    }

    private boolean cor() {
        return (this.iGj == null || this.iGj.iFJ == null || !this.iGj.iFJ.iFP) ? false : true;
    }

    private boolean cos() {
        return (this.iGj == null || this.iGj.iFK == null || !this.iGj.iFK.iFP) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.iGL != null) {
            this.iGL.cancel();
        }
        if (this.iGO != null) {
            this.iGO.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.iGV = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes16.dex */
    public static class a implements Animator.AnimatorListener {
        private View iGY;
        private View iGZ;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.iGY != null) {
                this.iGY.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.iGZ != null) {
                this.iGZ.setVisibility(8);
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
