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
/* loaded from: classes22.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private com.baidu.tieba.homepage.topic.topictab.b.b jZD;
    private TextView jZE;
    private TextView jZF;
    private FrameLayout jZG;
    private FrameLayout jZH;
    private TbImageView jZI;
    private TbImageView jZJ;
    private TbImageView jZK;
    private TbImageView jZL;
    private TextView jZM;
    private TextView jZN;
    private ImageView jZO;
    private TextView jZP;
    private TextView jZQ;
    private ImageView jZR;
    private ImageView jZS;
    private int jZT;
    private int jZU;
    private int jZV;
    private int jZW;
    private int jZX;
    private int jZY;
    private int jZZ;
    private int kaa;
    private int kab;
    private int kac;
    private int kad;
    private int kae;
    private ValueAnimator kaf;
    private View kag;
    private a kah;
    private ValueAnimator kai;
    private double kaj;
    private double kak;
    private float kal;
    private float kam;
    private RelativeLayout.LayoutParams kan;
    private RelativeLayout.LayoutParams kao;
    private b kap;
    private ValueAnimator.AnimatorUpdateListener kaq;
    private int mBtnHeight;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes22.dex */
    public interface b {
        void Df(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.kae = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.kaq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jZR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kaj) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jZT - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZG.getX() + (TopicPkView.this.jZT / 2)))));
                    TopicPkView.this.jZR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kak) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jZR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jZG.getX() + (TopicPkView.this.jZT / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZG.getX() + (TopicPkView.this.jZT / 2)))));
                    TopicPkView.this.jZR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jZR.setVisibility(4);
                    TopicPkView.this.jZR.setX(TopicPkView.this.kal);
                    TopicPkView.this.jZR.setY(TopicPkView.this.kam);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.kae = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.kaq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jZR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kaj) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jZT - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZG.getX() + (TopicPkView.this.jZT / 2)))));
                    TopicPkView.this.jZR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kak) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jZR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jZG.getX() + (TopicPkView.this.jZT / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZG.getX() + (TopicPkView.this.jZT / 2)))));
                    TopicPkView.this.jZR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jZR.setVisibility(4);
                    TopicPkView.this.jZR.setX(TopicPkView.this.kal);
                    TopicPkView.this.jZR.setY(TopicPkView.this.kam);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.kae = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.kaq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jZR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kaj) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jZT - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZG.getX() + (TopicPkView.this.jZT / 2)))));
                    TopicPkView.this.jZR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kak) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jZR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jZG.getX() + (TopicPkView.this.jZT / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZG.getX() + (TopicPkView.this.jZT / 2)))));
                    TopicPkView.this.jZR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jZR.setVisibility(4);
                    TopicPkView.this.jZR.setX(TopicPkView.this.kal);
                    TopicPkView.this.jZR.setY(TopicPkView.this.kam);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.jZE = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.jZF = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.jZG = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.jZH = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.jZI = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.jZJ = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.jZK = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.jZL = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.jZM = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.jZN = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.jZO = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.jZP = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.jZQ = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.jZR = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.jZS = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.jZI.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.jZJ.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.jZK.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.jZL.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.jZG.setOnClickListener(this);
        this.jZH.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.kab = l.getDimens(context, R.dimen.tbds62);
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
        if (this.jZD != null) {
            this.jZT = this.jZG.getWidth();
            this.mBtnHeight = this.jZG.getHeight();
            this.jZU = this.jZI.getWidth();
            this.jZV = this.jZM.getWidth();
            this.jZW = this.jZN.getWidth();
            this.jZZ = this.jZM.getHeight();
            this.jZX = this.jZP.getWidth();
            this.jZY = this.jZQ.getWidth();
            this.mCursorWidth = this.jZO.getWidth();
            this.mCursorHeight = this.jZO.getHeight();
            this.kaa = ((this.mWidth - (this.jZT * 2)) - this.jZV) - this.jZW;
            this.kad = this.jZR.getWidth();
            if (this.jZD.jZe.jZg == 0 && this.jZD.jZf.jZg == 0) {
                this.kac = (int) ((0.5d * this.kaa) + this.jZV + this.jZT);
            } else {
                this.kac = (int) (((((float) this.jZD.jZe.jZg) / ((float) (this.jZD.jZe.jZg + this.jZD.jZf.jZg))) * this.kaa) + this.jZV + this.jZT);
            }
            float y = this.jZG.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.kac + (this.mCursorWidth / 2) >= this.jZN.getLeft()) {
                this.kac = (this.jZN.getLeft() - 10) - (this.mCursorWidth / 2);
                this.jZO.layout((this.jZN.getLeft() - 10) - this.mCursorWidth, (int) y, this.jZN.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.kac - (this.mCursorWidth / 2) <= this.jZM.getRight()) {
                this.kac = this.jZM.getRight() + 10 + (this.mCursorWidth / 2);
                this.jZO.layout(this.jZM.getRight() + 10, (int) y, this.jZM.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.jZO.layout(this.kac - (this.mCursorWidth / 2), (int) y, this.kac + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.jZI.getX());
            if (this.jZX < this.jZU) {
                int i5 = (this.jZT - this.jZX) / 2;
                this.jZP.layout(i5, (int) this.jZP.getY(), this.jZX + i5, ((int) this.jZP.getY()) + this.jZZ);
            } else if (this.jZX <= x) {
                this.jZP.layout((int) this.jZI.getX(), (int) this.jZP.getY(), ((int) this.jZI.getX()) + this.jZX, ((int) this.jZP.getY()) + this.jZZ);
            } else {
                ViewGroup.LayoutParams layoutParams = this.jZP.getLayoutParams();
                layoutParams.width = x;
                this.jZP.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.jZY < this.jZU) {
                int x2 = ((int) this.jZH.getX()) + ((this.jZT - this.jZY) / 2);
                this.jZQ.layout(x2, (int) this.jZQ.getY(), this.jZY + x2, ((int) this.jZQ.getY()) + this.jZZ);
            } else if (this.jZY <= x) {
                this.jZQ.layout((this.mWidth - ((int) this.jZJ.getX())) - this.jZY, (int) this.jZQ.getY(), this.mWidth - ((int) this.jZJ.getX()), ((int) this.jZQ.getY()) + this.jZZ);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.jZQ.getLayoutParams();
                layoutParams2.width = x;
                this.jZQ.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.jZT - this.kad) / 2;
            this.jZR.layout(((int) this.jZG.getX()) + i6, ((int) this.jZG.getY()) + i6, ((int) this.jZG.getX()) + i6 + this.kad, ((int) this.jZG.getY()) + i6 + this.kad);
            this.jZS.layout(((int) this.jZH.getX()) + i6, ((int) this.jZH.getY()) + i6, ((int) this.jZH.getX()) + i6 + this.kad, i6 + ((int) this.jZH.getY()) + this.kad);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.jZD.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.kaf == null || !this.kaf.isRunning()) {
            if (this.kai == null || !this.kai.isRunning()) {
                if (this.kai == null) {
                    this.kai = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.kai.setDuration(800L);
                    this.kai.setInterpolator(new AccelerateInterpolator());
                }
                if (this.kaf == null) {
                    this.kaf = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.kaf.setDuration(800L);
                    this.kaf.setInterpolator(new AccelerateInterpolator());
                    this.kah = new a();
                    this.kaf.addListener(this.kah);
                    this.kaf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.kag.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.kag.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cRe()) {
                    i = 1;
                } else {
                    i = cRf() ? 2 : 0;
                }
                if (view == this.jZG) {
                    rN(1 != i);
                    rO(false);
                    i2 = 1;
                } else if (view == this.jZH) {
                    rO(2 != i);
                    rN(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new ar("c13352").al("obj_type", i2).w("topic_id", this.jZD.topicId).al("obj_source", this.jZD.from));
                if (this.kap != null) {
                    this.kap.Df(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.jZD.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.jZD.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.jZD.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jZD != null) {
            Z(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void Z(Canvas canvas) {
        float y = this.jZG.getY() + ((this.mBtnHeight - this.kab) / 2);
        this.mPaint.setShader(new LinearGradient(this.jZT / 2, y, this.kac, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jZT / 2, y, this.kac, y + this.kab, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.kac, y, this.mWidth - (this.jZT / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.kac, y, this.mWidth - (this.jZT / 2), y + this.kab, this.mPaint);
    }

    public void setUserColor(int i) {
        this.kae = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.jZe == null || bVar.jZf == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jZD = bVar;
        this.jZM.setText(String.valueOf(bVar.jZe.jZg));
        this.jZN.setText(String.valueOf(bVar.jZf.jZg));
        this.kan = new RelativeLayout.LayoutParams(-2, -2);
        this.kan.addRule(12);
        this.kao = new RelativeLayout.LayoutParams(-2, -2);
        this.kao.addRule(12);
        this.kao.addRule(11);
        this.jZP.setLayoutParams(this.kan);
        this.jZQ.setLayoutParams(this.kao);
        if (bVar.from == 3) {
            this.jZP.setText(StringUtils.isNull(bVar.jZe.jZh) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.jZe.jZh);
            this.jZQ.setText(StringUtils.isNull(bVar.jZf.jZh) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.jZf.jZh);
            if (StringUtils.isNull(bVar.jZe.jZi)) {
                this.jZE.setVisibility(4);
            } else {
                this.jZE.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jZe.jZi));
            }
            if (StringUtils.isNull(bVar.jZf.jZi)) {
                this.jZF.setVisibility(4);
            } else {
                this.jZF.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jZf.jZi));
            }
        } else {
            this.jZP.setText(bVar.jZe.jZh);
            this.jZQ.setText(bVar.jZf.jZh);
            this.jZE.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jZe.jZi));
            this.jZF.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jZf.jZi));
        }
        this.jZI.startLoad(bVar.jZe.jZj, 10, false);
        this.jZJ.startLoad(bVar.jZf.jZj, 10, false);
        this.jZK.startLoad(bVar.jZe.jZm, 10, false);
        this.jZL.startLoad(bVar.jZf.jZm, 10, false);
        if (bVar.jZe.jZk) {
            this.jZI.setVisibility(4);
            this.jZK.setVisibility(0);
        } else {
            this.jZI.setVisibility(0);
            this.jZK.setVisibility(4);
        }
        if (bVar.jZf.jZk) {
            this.jZJ.setVisibility(4);
            this.jZL.setVisibility(0);
        } else {
            this.jZJ.setVisibility(0);
            this.jZL.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jZE, this.kae);
        ap.setViewTextColor(this.jZF, this.kae);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.jZI.setIsNight(this.mSkinType == 1);
            this.jZJ.setIsNight(this.mSkinType == 1);
            this.jZK.setIsNight(this.mSkinType == 1);
            this.jZL.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.jZG, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.jZH, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.jZR, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jZS, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jZO, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.jZM, R.color.CAM_X0101);
            ap.setViewTextColor(this.jZN, R.color.CAM_X0101);
            ap.setViewTextColor(this.jZP, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.jZQ, R.color.topic_disagree_des_color);
        }
    }

    private void rN(boolean z) {
        if (z) {
            this.jZE.setVisibility(0);
            this.jZE.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jZD.jZe.jZi = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jZD.jZe.jZk = true;
            TextView textView = this.jZM;
            b.a aVar = this.jZD.jZe;
            long j = aVar.jZg + 1;
            aVar.jZg = j;
            textView.setText(String.valueOf(j));
            this.jZR.setVisibility(0);
            this.kag = this.jZK;
            this.kah.kas = this.jZK;
            this.kah.kat = this.jZI;
            this.jZR.setVisibility(0);
            this.kaf.start();
            this.kaj = this.jZR.getX();
            this.kak = this.jZR.getY();
            this.kal = this.jZR.getX();
            this.kam = this.jZR.getY();
            this.kai.removeAllUpdateListeners();
            this.kai.addUpdateListener(this.kaq);
            this.kai.setFloatValues(0.0f, 2.0f);
            this.kai.start();
            return;
        }
        if (au.equals(this.jZD.jZe.jZi, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jZE.setVisibility(4);
        }
        if (this.jZD.jZe.jZk) {
            this.jZD.jZe.jZk = false;
            TextView textView2 = this.jZM;
            b.a aVar2 = this.jZD.jZe;
            long j2 = aVar2.jZg - 1;
            aVar2.jZg = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jZI.setVisibility(0);
        this.jZK.setVisibility(4);
    }

    private void rO(boolean z) {
        if (z) {
            this.jZF.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jZF.setVisibility(0);
            this.jZD.jZf.jZi = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jZS.setVisibility(0);
            this.jZD.jZf.jZk = true;
            TextView textView = this.jZN;
            b.a aVar = this.jZD.jZf;
            long j = aVar.jZg + 1;
            aVar.jZg = j;
            textView.setText(String.valueOf(j));
            this.kaj = this.jZS.getX() - (this.kad / 2.0f);
            this.kag = this.jZL;
            this.kah.kas = this.jZL;
            this.kah.kat = this.jZJ;
            this.jZR.setVisibility(0);
            this.kaf.start();
            this.kaj = this.jZS.getX() - (this.kad / 2);
            this.kak = this.jZS.getY();
            this.kal = this.jZS.getX();
            this.kam = this.jZS.getY();
            this.kai.removeAllUpdateListeners();
            this.kai.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.jZS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kaj) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.jZT) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jZT / 2)))));
                        TopicPkView.this.jZS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kak) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.jZS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jZT / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.jZS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.jZS.setVisibility(4);
                        TopicPkView.this.jZS.setX(TopicPkView.this.kal);
                        TopicPkView.this.jZS.setY(TopicPkView.this.kam);
                    }
                }
            });
            this.kai.setFloatValues(0.0f, 2.0f);
            this.kai.start();
            return;
        }
        if (au.equals(this.jZD.jZf.jZi, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jZF.setVisibility(4);
        }
        if (this.jZD.jZf.jZk) {
            this.jZD.jZf.jZk = false;
            TextView textView2 = this.jZN;
            b.a aVar2 = this.jZD.jZf;
            long j2 = aVar2.jZg - 1;
            aVar2.jZg = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jZS.setVisibility(4);
        this.jZJ.setVisibility(0);
        this.jZL.setVisibility(4);
    }

    private boolean cRe() {
        return (this.jZD == null || this.jZD.jZe == null || !this.jZD.jZe.jZk) ? false : true;
    }

    private boolean cRf() {
        return (this.jZD == null || this.jZD.jZf == null || !this.jZD.jZf.jZk) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.kaf != null) {
            this.kaf.cancel();
        }
        if (this.kai != null) {
            this.kai.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.kap = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a implements Animator.AnimatorListener {
        private View kas;
        private View kat;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.kas != null) {
                this.kas.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.kat != null) {
                this.kat.setVisibility(8);
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
