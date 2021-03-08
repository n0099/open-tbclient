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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes2.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int dDa;
    private com.baidu.tieba.homepage.topic.topictab.b.b ksI;
    private TextView ksJ;
    private TextView ksK;
    private FrameLayout ksL;
    private FrameLayout ksM;
    private TbImageView ksN;
    private TbImageView ksO;
    private TbImageView ksP;
    private TbImageView ksQ;
    private TextView ksR;
    private TextView ksS;
    private ImageView ksT;
    private TextView ksU;
    private TextView ksV;
    private ImageView ksW;
    private ImageView ksX;
    private int ksY;
    private int ksZ;
    private int kta;
    private int ktb;
    private int ktc;
    private int ktd;
    private int kte;
    private int ktf;
    private int ktg;
    private int kth;
    private int kti;
    private int ktj;
    private ValueAnimator ktk;
    private View ktl;
    private a ktm;
    private ValueAnimator ktn;
    private double kto;
    private double ktp;
    private float ktq;
    private float ktr;
    private RelativeLayout.LayoutParams kts;
    private RelativeLayout.LayoutParams ktt;
    private b ktu;
    private ValueAnimator.AnimatorUpdateListener ktv;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void Ch(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ktj = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.ktv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ksW.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kto) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ksY - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ksL.getX() + (TopicPkView.this.ksY / 2)))));
                    TopicPkView.this.ksW.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ktp) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ksW.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ksL.getX() + (TopicPkView.this.ksY / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ksL.getX() + (TopicPkView.this.ksY / 2)))));
                    TopicPkView.this.ksW.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ksW.setVisibility(4);
                    TopicPkView.this.ksW.setX(TopicPkView.this.ktq);
                    TopicPkView.this.ksW.setY(TopicPkView.this.ktr);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ktj = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.ktv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ksW.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kto) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ksY - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ksL.getX() + (TopicPkView.this.ksY / 2)))));
                    TopicPkView.this.ksW.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ktp) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ksW.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ksL.getX() + (TopicPkView.this.ksY / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ksL.getX() + (TopicPkView.this.ksY / 2)))));
                    TopicPkView.this.ksW.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ksW.setVisibility(4);
                    TopicPkView.this.ksW.setX(TopicPkView.this.ktq);
                    TopicPkView.this.ksW.setY(TopicPkView.this.ktr);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ktj = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.ktv = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.ksW.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kto) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.ksY - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ksL.getX() + (TopicPkView.this.ksY / 2)))));
                    TopicPkView.this.ksW.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ktp) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.ksW.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.ksL.getX() + (TopicPkView.this.ksY / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.ksL.getX() + (TopicPkView.this.ksY / 2)))));
                    TopicPkView.this.ksW.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.ksW.setVisibility(4);
                    TopicPkView.this.ksW.setX(TopicPkView.this.ktq);
                    TopicPkView.this.ksW.setY(TopicPkView.this.ktr);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.ksJ = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.ksK = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.ksL = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.ksM = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.ksN = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.ksO = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.ksP = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.ksQ = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.ksR = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.ksS = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.ksT = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.ksU = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.ksV = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.ksW = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.ksX = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.ksN.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.ksO.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.ksP.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.ksQ.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.ksL.setOnClickListener(this);
        this.ksM.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.ktg = l.getDimens(context, R.dimen.tbds62);
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
        if (this.ksI != null) {
            this.ksY = this.ksL.getWidth();
            this.dDa = this.ksL.getHeight();
            this.ksZ = this.ksN.getWidth();
            this.kta = this.ksR.getWidth();
            this.ktb = this.ksS.getWidth();
            this.kte = this.ksR.getHeight();
            this.ktc = this.ksU.getWidth();
            this.ktd = this.ksV.getWidth();
            this.mCursorWidth = this.ksT.getWidth();
            this.mCursorHeight = this.ksT.getHeight();
            this.ktf = ((this.mWidth - (this.ksY * 2)) - this.kta) - this.ktb;
            this.kti = this.ksW.getWidth();
            if (this.ksI.ksj.ksl == 0 && this.ksI.ksk.ksl == 0) {
                this.kth = (int) ((0.5d * this.ktf) + this.kta + this.ksY);
            } else {
                this.kth = (int) (((((float) this.ksI.ksj.ksl) / ((float) (this.ksI.ksj.ksl + this.ksI.ksk.ksl))) * this.ktf) + this.kta + this.ksY);
            }
            float y = this.ksL.getY() - ((this.mCursorHeight - this.dDa) / 2);
            if (this.kth + (this.mCursorWidth / 2) >= this.ksS.getLeft()) {
                this.kth = (this.ksS.getLeft() - 10) - (this.mCursorWidth / 2);
                this.ksT.layout((this.ksS.getLeft() - 10) - this.mCursorWidth, (int) y, this.ksS.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.kth - (this.mCursorWidth / 2) <= this.ksR.getRight()) {
                this.kth = this.ksR.getRight() + 10 + (this.mCursorWidth / 2);
                this.ksT.layout(this.ksR.getRight() + 10, (int) y, this.ksR.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.ksT.layout(this.kth - (this.mCursorWidth / 2), (int) y, this.kth + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.ksN.getX());
            if (this.ktc < this.ksZ) {
                int i5 = (this.ksY - this.ktc) / 2;
                this.ksU.layout(i5, (int) this.ksU.getY(), this.ktc + i5, ((int) this.ksU.getY()) + this.kte);
            } else if (this.ktc <= x) {
                this.ksU.layout((int) this.ksN.getX(), (int) this.ksU.getY(), ((int) this.ksN.getX()) + this.ktc, ((int) this.ksU.getY()) + this.kte);
            } else {
                ViewGroup.LayoutParams layoutParams = this.ksU.getLayoutParams();
                layoutParams.width = x;
                this.ksU.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.ktd < this.ksZ) {
                int x2 = ((int) this.ksM.getX()) + ((this.ksY - this.ktd) / 2);
                this.ksV.layout(x2, (int) this.ksV.getY(), this.ktd + x2, ((int) this.ksV.getY()) + this.kte);
            } else if (this.ktd <= x) {
                this.ksV.layout((this.mWidth - ((int) this.ksO.getX())) - this.ktd, (int) this.ksV.getY(), this.mWidth - ((int) this.ksO.getX()), ((int) this.ksV.getY()) + this.kte);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.ksV.getLayoutParams();
                layoutParams2.width = x;
                this.ksV.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.ksY - this.kti) / 2;
            this.ksW.layout(((int) this.ksL.getX()) + i6, ((int) this.ksL.getY()) + i6, ((int) this.ksL.getX()) + i6 + this.kti, ((int) this.ksL.getY()) + i6 + this.kti);
            this.ksX.layout(((int) this.ksM.getX()) + i6, ((int) this.ksM.getY()) + i6, ((int) this.ksM.getX()) + i6 + this.kti, i6 + ((int) this.ksM.getY()) + this.kti);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.ksI.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.ktk == null || !this.ktk.isRunning()) {
            if (this.ktn == null || !this.ktn.isRunning()) {
                if (this.ktn == null) {
                    this.ktn = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.ktn.setDuration(800L);
                    this.ktn.setInterpolator(new AccelerateInterpolator());
                }
                if (this.ktk == null) {
                    this.ktk = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.ktk.setDuration(800L);
                    this.ktk.setInterpolator(new AccelerateInterpolator());
                    this.ktm = new a();
                    this.ktk.addListener(this.ktm);
                    this.ktk.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.ktl.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.ktl.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cSH()) {
                    i = 1;
                } else {
                    i = cSI() ? 2 : 0;
                }
                if (view == this.ksL) {
                    st(1 != i);
                    su(false);
                    i2 = 1;
                } else if (view == this.ksM) {
                    su(2 != i);
                    st(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new ar("c13352").aq("obj_type", i2).v("topic_id", this.ksI.topicId).aq("obj_source", this.ksI.from));
                if (this.ktu != null) {
                    this.ktu.Ch(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.ksI.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.ksI.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.ksI.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.ksI != null) {
            af(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void af(Canvas canvas) {
        float y = this.ksL.getY() + ((this.dDa - this.ktg) / 2);
        this.mPaint.setShader(new LinearGradient(this.ksY / 2, y, this.kth, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.ksY / 2, y, this.kth, y + this.ktg, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.kth, y, this.mWidth - (this.ksY / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.kth, y, this.mWidth - (this.ksY / 2), y + this.ktg, this.mPaint);
    }

    public void setUserColor(int i) {
        this.ktj = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.ksj == null || bVar.ksk == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.ksI = bVar;
        this.ksR.setText(String.valueOf(bVar.ksj.ksl));
        this.ksS.setText(String.valueOf(bVar.ksk.ksl));
        this.kts = new RelativeLayout.LayoutParams(-2, -2);
        this.kts.addRule(12);
        this.ktt = new RelativeLayout.LayoutParams(-2, -2);
        this.ktt.addRule(12);
        this.ktt.addRule(11);
        this.ksU.setLayoutParams(this.kts);
        this.ksV.setLayoutParams(this.ktt);
        if (bVar.from == 3) {
            this.ksU.setText(StringUtils.isNull(bVar.ksj.ksm) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.ksj.ksm);
            this.ksV.setText(StringUtils.isNull(bVar.ksk.ksm) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.ksk.ksm);
            if (StringUtils.isNull(bVar.ksj.ksn)) {
                this.ksJ.setVisibility(4);
            } else {
                this.ksJ.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ksj.ksn));
            }
            if (StringUtils.isNull(bVar.ksk.ksn)) {
                this.ksK.setVisibility(4);
            } else {
                this.ksK.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ksk.ksn));
            }
        } else {
            this.ksU.setText(bVar.ksj.ksm);
            this.ksV.setText(bVar.ksk.ksm);
            this.ksJ.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ksj.ksn));
            this.ksK.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.ksk.ksn));
        }
        this.ksN.startLoad(bVar.ksj.kso, 10, false);
        this.ksO.startLoad(bVar.ksk.kso, 10, false);
        this.ksP.startLoad(bVar.ksj.ksr, 10, false);
        this.ksQ.startLoad(bVar.ksk.ksr, 10, false);
        if (bVar.ksj.ksp) {
            this.ksN.setVisibility(4);
            this.ksP.setVisibility(0);
        } else {
            this.ksN.setVisibility(0);
            this.ksP.setVisibility(4);
        }
        if (bVar.ksk.ksp) {
            this.ksO.setVisibility(4);
            this.ksQ.setVisibility(0);
        } else {
            this.ksO.setVisibility(0);
            this.ksQ.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.ksJ, this.ktj);
        ap.setViewTextColor(this.ksK, this.ktj);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.ksN.setIsNight(this.mSkinType == 1);
            this.ksO.setIsNight(this.mSkinType == 1);
            this.ksP.setIsNight(this.mSkinType == 1);
            this.ksQ.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.ksL, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.ksM, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.ksW, R.drawable.pic_topic_addone);
            ap.setImageResource(this.ksX, R.drawable.pic_topic_addone);
            ap.setImageResource(this.ksT, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.ksR, R.color.CAM_X0101);
            ap.setViewTextColor(this.ksS, R.color.CAM_X0101);
            ap.setViewTextColor(this.ksU, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.ksV, R.color.topic_disagree_des_color);
        }
    }

    private void st(boolean z) {
        if (z) {
            this.ksJ.setVisibility(0);
            this.ksJ.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.ksI.ksj.ksn = TbadkCoreApplication.getCurrentAccountNameShow();
            this.ksI.ksj.ksp = true;
            TextView textView = this.ksR;
            b.a aVar = this.ksI.ksj;
            long j = aVar.ksl + 1;
            aVar.ksl = j;
            textView.setText(String.valueOf(j));
            this.ksW.setVisibility(0);
            this.ktl = this.ksP;
            this.ktm.ktx = this.ksP;
            this.ktm.kty = this.ksN;
            this.ksW.setVisibility(0);
            this.ktk.start();
            this.kto = this.ksW.getX();
            this.ktp = this.ksW.getY();
            this.ktq = this.ksW.getX();
            this.ktr = this.ksW.getY();
            this.ktn.removeAllUpdateListeners();
            this.ktn.addUpdateListener(this.ktv);
            this.ktn.setFloatValues(0.0f, 2.0f);
            this.ktn.start();
            return;
        }
        if (au.equals(this.ksI.ksj.ksn, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ksJ.setVisibility(4);
        }
        if (this.ksI.ksj.ksp) {
            this.ksI.ksj.ksp = false;
            TextView textView2 = this.ksR;
            b.a aVar2 = this.ksI.ksj;
            long j2 = aVar2.ksl - 1;
            aVar2.ksl = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ksN.setVisibility(0);
        this.ksP.setVisibility(4);
    }

    private void su(boolean z) {
        if (z) {
            this.ksK.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.ksK.setVisibility(0);
            this.ksI.ksk.ksn = TbadkCoreApplication.getCurrentAccountNameShow();
            this.ksX.setVisibility(0);
            this.ksI.ksk.ksp = true;
            TextView textView = this.ksS;
            b.a aVar = this.ksI.ksk;
            long j = aVar.ksl + 1;
            aVar.ksl = j;
            textView.setText(String.valueOf(j));
            this.kto = this.ksX.getX() - (this.kti / 2.0f);
            this.ktl = this.ksQ;
            this.ktm.ktx = this.ksQ;
            this.ktm.kty = this.ksO;
            this.ksW.setVisibility(0);
            this.ktk.start();
            this.kto = this.ksX.getX() - (this.kti / 2);
            this.ktp = this.ksX.getY();
            this.ktq = this.ksX.getX();
            this.ktr = this.ksX.getY();
            this.ktn.removeAllUpdateListeners();
            this.ktn.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.ksX.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kto) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.ksY) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ksY / 2)))));
                        TopicPkView.this.ksX.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.ktp) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.ksX.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.ksY / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.ksX.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.ksX.setVisibility(4);
                        TopicPkView.this.ksX.setX(TopicPkView.this.ktq);
                        TopicPkView.this.ksX.setY(TopicPkView.this.ktr);
                    }
                }
            });
            this.ktn.setFloatValues(0.0f, 2.0f);
            this.ktn.start();
            return;
        }
        if (au.equals(this.ksI.ksk.ksn, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.ksK.setVisibility(4);
        }
        if (this.ksI.ksk.ksp) {
            this.ksI.ksk.ksp = false;
            TextView textView2 = this.ksS;
            b.a aVar2 = this.ksI.ksk;
            long j2 = aVar2.ksl - 1;
            aVar2.ksl = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.ksX.setVisibility(4);
        this.ksO.setVisibility(0);
        this.ksQ.setVisibility(4);
    }

    private boolean cSH() {
        return (this.ksI == null || this.ksI.ksj == null || !this.ksI.ksj.ksp) ? false : true;
    }

    private boolean cSI() {
        return (this.ksI == null || this.ksI.ksk == null || !this.ksI.ksk.ksp) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.ktk != null) {
            this.ktk.cancel();
        }
        if (this.ktn != null) {
            this.ktn.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.ktu = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Animator.AnimatorListener {
        private View ktx;
        private View kty;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.ktx != null) {
                this.ktx.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.kty != null) {
                this.kty.setVisibility(8);
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
