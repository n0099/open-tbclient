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
    private int dBz;
    private com.baidu.tieba.homepage.topic.topictab.b.b kqG;
    private TextView kqH;
    private TextView kqI;
    private FrameLayout kqJ;
    private FrameLayout kqK;
    private TbImageView kqL;
    private TbImageView kqM;
    private TbImageView kqN;
    private TbImageView kqO;
    private TextView kqP;
    private TextView kqQ;
    private ImageView kqR;
    private TextView kqS;
    private TextView kqT;
    private ImageView kqU;
    private ImageView kqV;
    private int kqW;
    private int kqX;
    private int kqY;
    private int kqZ;
    private int kra;
    private int krb;
    private int krc;
    private int krd;
    private int kre;
    private int krf;
    private int krg;
    private int krh;
    private ValueAnimator kri;
    private View krj;
    private a krk;
    private ValueAnimator krl;
    private double krm;
    private double krn;
    private float kro;
    private float krp;
    private RelativeLayout.LayoutParams krq;
    private RelativeLayout.LayoutParams krr;
    private b krs;
    private ValueAnimator.AnimatorUpdateListener krt;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void Ce(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.krh = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.krt = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kqU.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.krm) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kqW - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqJ.getX() + (TopicPkView.this.kqW / 2)))));
                    TopicPkView.this.kqU.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.krn) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kqU.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kqJ.getX() + (TopicPkView.this.kqW / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqJ.getX() + (TopicPkView.this.kqW / 2)))));
                    TopicPkView.this.kqU.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kqU.setVisibility(4);
                    TopicPkView.this.kqU.setX(TopicPkView.this.kro);
                    TopicPkView.this.kqU.setY(TopicPkView.this.krp);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.krh = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.krt = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kqU.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.krm) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kqW - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqJ.getX() + (TopicPkView.this.kqW / 2)))));
                    TopicPkView.this.kqU.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.krn) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kqU.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kqJ.getX() + (TopicPkView.this.kqW / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqJ.getX() + (TopicPkView.this.kqW / 2)))));
                    TopicPkView.this.kqU.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kqU.setVisibility(4);
                    TopicPkView.this.kqU.setX(TopicPkView.this.kro);
                    TopicPkView.this.kqU.setY(TopicPkView.this.krp);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.krh = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.krt = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kqU.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.krm) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kqW - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqJ.getX() + (TopicPkView.this.kqW / 2)))));
                    TopicPkView.this.kqU.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.krn) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kqU.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kqJ.getX() + (TopicPkView.this.kqW / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kqJ.getX() + (TopicPkView.this.kqW / 2)))));
                    TopicPkView.this.kqU.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kqU.setVisibility(4);
                    TopicPkView.this.kqU.setX(TopicPkView.this.kro);
                    TopicPkView.this.kqU.setY(TopicPkView.this.krp);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.kqH = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.kqI = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.kqJ = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.kqK = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.kqL = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.kqM = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.kqN = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.kqO = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.kqP = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.kqQ = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.kqR = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.kqS = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.kqT = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.kqU = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.kqV = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.kqL.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.kqM.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.kqN.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.kqO.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.kqJ.setOnClickListener(this);
        this.kqK.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.kre = l.getDimens(context, R.dimen.tbds62);
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
        if (this.kqG != null) {
            this.kqW = this.kqJ.getWidth();
            this.dBz = this.kqJ.getHeight();
            this.kqX = this.kqL.getWidth();
            this.kqY = this.kqP.getWidth();
            this.kqZ = this.kqQ.getWidth();
            this.krc = this.kqP.getHeight();
            this.kra = this.kqS.getWidth();
            this.krb = this.kqT.getWidth();
            this.mCursorWidth = this.kqR.getWidth();
            this.mCursorHeight = this.kqR.getHeight();
            this.krd = ((this.mWidth - (this.kqW * 2)) - this.kqY) - this.kqZ;
            this.krg = this.kqU.getWidth();
            if (this.kqG.kqh.kqj == 0 && this.kqG.kqi.kqj == 0) {
                this.krf = (int) ((0.5d * this.krd) + this.kqY + this.kqW);
            } else {
                this.krf = (int) (((((float) this.kqG.kqh.kqj) / ((float) (this.kqG.kqh.kqj + this.kqG.kqi.kqj))) * this.krd) + this.kqY + this.kqW);
            }
            float y = this.kqJ.getY() - ((this.mCursorHeight - this.dBz) / 2);
            if (this.krf + (this.mCursorWidth / 2) >= this.kqQ.getLeft()) {
                this.krf = (this.kqQ.getLeft() - 10) - (this.mCursorWidth / 2);
                this.kqR.layout((this.kqQ.getLeft() - 10) - this.mCursorWidth, (int) y, this.kqQ.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.krf - (this.mCursorWidth / 2) <= this.kqP.getRight()) {
                this.krf = this.kqP.getRight() + 10 + (this.mCursorWidth / 2);
                this.kqR.layout(this.kqP.getRight() + 10, (int) y, this.kqP.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.kqR.layout(this.krf - (this.mCursorWidth / 2), (int) y, this.krf + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.kqL.getX());
            if (this.kra < this.kqX) {
                int i5 = (this.kqW - this.kra) / 2;
                this.kqS.layout(i5, (int) this.kqS.getY(), this.kra + i5, ((int) this.kqS.getY()) + this.krc);
            } else if (this.kra <= x) {
                this.kqS.layout((int) this.kqL.getX(), (int) this.kqS.getY(), ((int) this.kqL.getX()) + this.kra, ((int) this.kqS.getY()) + this.krc);
            } else {
                ViewGroup.LayoutParams layoutParams = this.kqS.getLayoutParams();
                layoutParams.width = x;
                this.kqS.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.krb < this.kqX) {
                int x2 = ((int) this.kqK.getX()) + ((this.kqW - this.krb) / 2);
                this.kqT.layout(x2, (int) this.kqT.getY(), this.krb + x2, ((int) this.kqT.getY()) + this.krc);
            } else if (this.krb <= x) {
                this.kqT.layout((this.mWidth - ((int) this.kqM.getX())) - this.krb, (int) this.kqT.getY(), this.mWidth - ((int) this.kqM.getX()), ((int) this.kqT.getY()) + this.krc);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.kqT.getLayoutParams();
                layoutParams2.width = x;
                this.kqT.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.kqW - this.krg) / 2;
            this.kqU.layout(((int) this.kqJ.getX()) + i6, ((int) this.kqJ.getY()) + i6, ((int) this.kqJ.getX()) + i6 + this.krg, ((int) this.kqJ.getY()) + i6 + this.krg);
            this.kqV.layout(((int) this.kqK.getX()) + i6, ((int) this.kqK.getY()) + i6, ((int) this.kqK.getX()) + i6 + this.krg, i6 + ((int) this.kqK.getY()) + this.krg);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.kqG.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.kri == null || !this.kri.isRunning()) {
            if (this.krl == null || !this.krl.isRunning()) {
                if (this.krl == null) {
                    this.krl = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.krl.setDuration(800L);
                    this.krl.setInterpolator(new AccelerateInterpolator());
                }
                if (this.kri == null) {
                    this.kri = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.kri.setDuration(800L);
                    this.kri.setInterpolator(new AccelerateInterpolator());
                    this.krk = new a();
                    this.kri.addListener(this.krk);
                    this.kri.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.krj.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.krj.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cSA()) {
                    i = 1;
                } else {
                    i = cSB() ? 2 : 0;
                }
                if (view == this.kqJ) {
                    st(1 != i);
                    su(false);
                    i2 = 1;
                } else if (view == this.kqK) {
                    su(2 != i);
                    st(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new ar("c13352").ap("obj_type", i2).v("topic_id", this.kqG.topicId).ap("obj_source", this.kqG.from));
                if (this.krs != null) {
                    this.krs.Ce(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.kqG.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.kqG.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.kqG.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kqG != null) {
            af(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void af(Canvas canvas) {
        float y = this.kqJ.getY() + ((this.dBz - this.kre) / 2);
        this.mPaint.setShader(new LinearGradient(this.kqW / 2, y, this.krf, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.kqW / 2, y, this.krf, y + this.kre, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.krf, y, this.mWidth - (this.kqW / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.krf, y, this.mWidth - (this.kqW / 2), y + this.kre, this.mPaint);
    }

    public void setUserColor(int i) {
        this.krh = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.kqh == null || bVar.kqi == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kqG = bVar;
        this.kqP.setText(String.valueOf(bVar.kqh.kqj));
        this.kqQ.setText(String.valueOf(bVar.kqi.kqj));
        this.krq = new RelativeLayout.LayoutParams(-2, -2);
        this.krq.addRule(12);
        this.krr = new RelativeLayout.LayoutParams(-2, -2);
        this.krr.addRule(12);
        this.krr.addRule(11);
        this.kqS.setLayoutParams(this.krq);
        this.kqT.setLayoutParams(this.krr);
        if (bVar.from == 3) {
            this.kqS.setText(StringUtils.isNull(bVar.kqh.kqk) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.kqh.kqk);
            this.kqT.setText(StringUtils.isNull(bVar.kqi.kqk) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.kqi.kqk);
            if (StringUtils.isNull(bVar.kqh.kql)) {
                this.kqH.setVisibility(4);
            } else {
                this.kqH.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kqh.kql));
            }
            if (StringUtils.isNull(bVar.kqi.kql)) {
                this.kqI.setVisibility(4);
            } else {
                this.kqI.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kqi.kql));
            }
        } else {
            this.kqS.setText(bVar.kqh.kqk);
            this.kqT.setText(bVar.kqi.kqk);
            this.kqH.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kqh.kql));
            this.kqI.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kqi.kql));
        }
        this.kqL.startLoad(bVar.kqh.kqm, 10, false);
        this.kqM.startLoad(bVar.kqi.kqm, 10, false);
        this.kqN.startLoad(bVar.kqh.kqp, 10, false);
        this.kqO.startLoad(bVar.kqi.kqp, 10, false);
        if (bVar.kqh.kqn) {
            this.kqL.setVisibility(4);
            this.kqN.setVisibility(0);
        } else {
            this.kqL.setVisibility(0);
            this.kqN.setVisibility(4);
        }
        if (bVar.kqi.kqn) {
            this.kqM.setVisibility(4);
            this.kqO.setVisibility(0);
        } else {
            this.kqM.setVisibility(0);
            this.kqO.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.kqH, this.krh);
        ap.setViewTextColor(this.kqI, this.krh);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.kqL.setIsNight(this.mSkinType == 1);
            this.kqM.setIsNight(this.mSkinType == 1);
            this.kqN.setIsNight(this.mSkinType == 1);
            this.kqO.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.kqJ, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.kqK, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.kqU, R.drawable.pic_topic_addone);
            ap.setImageResource(this.kqV, R.drawable.pic_topic_addone);
            ap.setImageResource(this.kqR, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.kqP, R.color.CAM_X0101);
            ap.setViewTextColor(this.kqQ, R.color.CAM_X0101);
            ap.setViewTextColor(this.kqS, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.kqT, R.color.topic_disagree_des_color);
        }
    }

    private void st(boolean z) {
        if (z) {
            this.kqH.setVisibility(0);
            this.kqH.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.kqG.kqh.kql = TbadkCoreApplication.getCurrentAccountNameShow();
            this.kqG.kqh.kqn = true;
            TextView textView = this.kqP;
            b.a aVar = this.kqG.kqh;
            long j = aVar.kqj + 1;
            aVar.kqj = j;
            textView.setText(String.valueOf(j));
            this.kqU.setVisibility(0);
            this.krj = this.kqN;
            this.krk.krv = this.kqN;
            this.krk.krw = this.kqL;
            this.kqU.setVisibility(0);
            this.kri.start();
            this.krm = this.kqU.getX();
            this.krn = this.kqU.getY();
            this.kro = this.kqU.getX();
            this.krp = this.kqU.getY();
            this.krl.removeAllUpdateListeners();
            this.krl.addUpdateListener(this.krt);
            this.krl.setFloatValues(0.0f, 2.0f);
            this.krl.start();
            return;
        }
        if (au.equals(this.kqG.kqh.kql, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.kqH.setVisibility(4);
        }
        if (this.kqG.kqh.kqn) {
            this.kqG.kqh.kqn = false;
            TextView textView2 = this.kqP;
            b.a aVar2 = this.kqG.kqh;
            long j2 = aVar2.kqj - 1;
            aVar2.kqj = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.kqL.setVisibility(0);
        this.kqN.setVisibility(4);
    }

    private void su(boolean z) {
        if (z) {
            this.kqI.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.kqI.setVisibility(0);
            this.kqG.kqi.kql = TbadkCoreApplication.getCurrentAccountNameShow();
            this.kqV.setVisibility(0);
            this.kqG.kqi.kqn = true;
            TextView textView = this.kqQ;
            b.a aVar = this.kqG.kqi;
            long j = aVar.kqj + 1;
            aVar.kqj = j;
            textView.setText(String.valueOf(j));
            this.krm = this.kqV.getX() - (this.krg / 2.0f);
            this.krj = this.kqO;
            this.krk.krv = this.kqO;
            this.krk.krw = this.kqM;
            this.kqU.setVisibility(0);
            this.kri.start();
            this.krm = this.kqV.getX() - (this.krg / 2);
            this.krn = this.kqV.getY();
            this.kro = this.kqV.getX();
            this.krp = this.kqV.getY();
            this.krl.removeAllUpdateListeners();
            this.krl.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.kqV.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.krm) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.kqW) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.kqW / 2)))));
                        TopicPkView.this.kqV.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.krn) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.kqV.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.kqW / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.kqV.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.kqV.setVisibility(4);
                        TopicPkView.this.kqV.setX(TopicPkView.this.kro);
                        TopicPkView.this.kqV.setY(TopicPkView.this.krp);
                    }
                }
            });
            this.krl.setFloatValues(0.0f, 2.0f);
            this.krl.start();
            return;
        }
        if (au.equals(this.kqG.kqi.kql, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.kqI.setVisibility(4);
        }
        if (this.kqG.kqi.kqn) {
            this.kqG.kqi.kqn = false;
            TextView textView2 = this.kqQ;
            b.a aVar2 = this.kqG.kqi;
            long j2 = aVar2.kqj - 1;
            aVar2.kqj = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.kqV.setVisibility(4);
        this.kqM.setVisibility(0);
        this.kqO.setVisibility(4);
    }

    private boolean cSA() {
        return (this.kqG == null || this.kqG.kqh == null || !this.kqG.kqh.kqn) ? false : true;
    }

    private boolean cSB() {
        return (this.kqG == null || this.kqG.kqi == null || !this.kqG.kqi.kqn) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.kri != null) {
            this.kri.cancel();
        }
        if (this.krl != null) {
            this.krl.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.krs = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Animator.AnimatorListener {
        private View krv;
        private View krw;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.krv != null) {
                this.krv.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.krw != null) {
                this.krw.setVisibility(8);
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
