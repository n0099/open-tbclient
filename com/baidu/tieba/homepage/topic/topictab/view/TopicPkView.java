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
    private com.baidu.tieba.homepage.topic.topictab.b.b jZF;
    private TextView jZG;
    private TextView jZH;
    private FrameLayout jZI;
    private FrameLayout jZJ;
    private TbImageView jZK;
    private TbImageView jZL;
    private TbImageView jZM;
    private TbImageView jZN;
    private TextView jZO;
    private TextView jZP;
    private ImageView jZQ;
    private TextView jZR;
    private TextView jZS;
    private ImageView jZT;
    private ImageView jZU;
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
    private int kaf;
    private int kag;
    private ValueAnimator kah;
    private View kai;
    private a kaj;
    private ValueAnimator kak;
    private double kal;
    private double kam;
    private float kan;
    private float kao;
    private RelativeLayout.LayoutParams kap;
    private RelativeLayout.LayoutParams kaq;
    private b kar;
    private ValueAnimator.AnimatorUpdateListener kas;
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
        this.kag = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.kas = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jZT.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kal) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jZV - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZI.getX() + (TopicPkView.this.jZV / 2)))));
                    TopicPkView.this.jZT.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kam) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jZT.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jZI.getX() + (TopicPkView.this.jZV / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZI.getX() + (TopicPkView.this.jZV / 2)))));
                    TopicPkView.this.jZT.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jZT.setVisibility(4);
                    TopicPkView.this.jZT.setX(TopicPkView.this.kan);
                    TopicPkView.this.jZT.setY(TopicPkView.this.kao);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.kag = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.kas = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jZT.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kal) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jZV - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZI.getX() + (TopicPkView.this.jZV / 2)))));
                    TopicPkView.this.jZT.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kam) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jZT.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jZI.getX() + (TopicPkView.this.jZV / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZI.getX() + (TopicPkView.this.jZV / 2)))));
                    TopicPkView.this.jZT.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jZT.setVisibility(4);
                    TopicPkView.this.jZT.setX(TopicPkView.this.kan);
                    TopicPkView.this.jZT.setY(TopicPkView.this.kao);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.kag = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.kas = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jZT.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kal) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jZV - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZI.getX() + (TopicPkView.this.jZV / 2)))));
                    TopicPkView.this.jZT.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kam) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jZT.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jZI.getX() + (TopicPkView.this.jZV / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jZI.getX() + (TopicPkView.this.jZV / 2)))));
                    TopicPkView.this.jZT.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jZT.setVisibility(4);
                    TopicPkView.this.jZT.setX(TopicPkView.this.kan);
                    TopicPkView.this.jZT.setY(TopicPkView.this.kao);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.jZG = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.jZH = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.jZI = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.jZJ = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.jZK = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.jZL = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.jZM = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.jZN = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.jZO = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.jZP = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.jZQ = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.jZR = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.jZS = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.jZT = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.jZU = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.jZK.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.jZL.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.jZM.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.jZN.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.jZI.setOnClickListener(this);
        this.jZJ.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.kad = l.getDimens(context, R.dimen.tbds62);
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
        if (this.jZF != null) {
            this.jZV = this.jZI.getWidth();
            this.mBtnHeight = this.jZI.getHeight();
            this.jZW = this.jZK.getWidth();
            this.jZX = this.jZO.getWidth();
            this.jZY = this.jZP.getWidth();
            this.kab = this.jZO.getHeight();
            this.jZZ = this.jZR.getWidth();
            this.kaa = this.jZS.getWidth();
            this.mCursorWidth = this.jZQ.getWidth();
            this.mCursorHeight = this.jZQ.getHeight();
            this.kac = ((this.mWidth - (this.jZV * 2)) - this.jZX) - this.jZY;
            this.kaf = this.jZT.getWidth();
            if (this.jZF.jZg.jZi == 0 && this.jZF.jZh.jZi == 0) {
                this.kae = (int) ((0.5d * this.kac) + this.jZX + this.jZV);
            } else {
                this.kae = (int) (((((float) this.jZF.jZg.jZi) / ((float) (this.jZF.jZg.jZi + this.jZF.jZh.jZi))) * this.kac) + this.jZX + this.jZV);
            }
            float y = this.jZI.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.kae + (this.mCursorWidth / 2) >= this.jZP.getLeft()) {
                this.kae = (this.jZP.getLeft() - 10) - (this.mCursorWidth / 2);
                this.jZQ.layout((this.jZP.getLeft() - 10) - this.mCursorWidth, (int) y, this.jZP.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.kae - (this.mCursorWidth / 2) <= this.jZO.getRight()) {
                this.kae = this.jZO.getRight() + 10 + (this.mCursorWidth / 2);
                this.jZQ.layout(this.jZO.getRight() + 10, (int) y, this.jZO.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.jZQ.layout(this.kae - (this.mCursorWidth / 2), (int) y, this.kae + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.jZK.getX());
            if (this.jZZ < this.jZW) {
                int i5 = (this.jZV - this.jZZ) / 2;
                this.jZR.layout(i5, (int) this.jZR.getY(), this.jZZ + i5, ((int) this.jZR.getY()) + this.kab);
            } else if (this.jZZ <= x) {
                this.jZR.layout((int) this.jZK.getX(), (int) this.jZR.getY(), ((int) this.jZK.getX()) + this.jZZ, ((int) this.jZR.getY()) + this.kab);
            } else {
                ViewGroup.LayoutParams layoutParams = this.jZR.getLayoutParams();
                layoutParams.width = x;
                this.jZR.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.kaa < this.jZW) {
                int x2 = ((int) this.jZJ.getX()) + ((this.jZV - this.kaa) / 2);
                this.jZS.layout(x2, (int) this.jZS.getY(), this.kaa + x2, ((int) this.jZS.getY()) + this.kab);
            } else if (this.kaa <= x) {
                this.jZS.layout((this.mWidth - ((int) this.jZL.getX())) - this.kaa, (int) this.jZS.getY(), this.mWidth - ((int) this.jZL.getX()), ((int) this.jZS.getY()) + this.kab);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.jZS.getLayoutParams();
                layoutParams2.width = x;
                this.jZS.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.jZV - this.kaf) / 2;
            this.jZT.layout(((int) this.jZI.getX()) + i6, ((int) this.jZI.getY()) + i6, ((int) this.jZI.getX()) + i6 + this.kaf, ((int) this.jZI.getY()) + i6 + this.kaf);
            this.jZU.layout(((int) this.jZJ.getX()) + i6, ((int) this.jZJ.getY()) + i6, ((int) this.jZJ.getX()) + i6 + this.kaf, i6 + ((int) this.jZJ.getY()) + this.kaf);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.jZF.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.kah == null || !this.kah.isRunning()) {
            if (this.kak == null || !this.kak.isRunning()) {
                if (this.kak == null) {
                    this.kak = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.kak.setDuration(800L);
                    this.kak.setInterpolator(new AccelerateInterpolator());
                }
                if (this.kah == null) {
                    this.kah = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.kah.setDuration(800L);
                    this.kah.setInterpolator(new AccelerateInterpolator());
                    this.kaj = new a();
                    this.kah.addListener(this.kaj);
                    this.kah.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.kai.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.kai.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cRf()) {
                    i = 1;
                } else {
                    i = cRg() ? 2 : 0;
                }
                if (view == this.jZI) {
                    rN(1 != i);
                    rO(false);
                    i2 = 1;
                } else if (view == this.jZJ) {
                    rO(2 != i);
                    rN(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new ar("c13352").al("obj_type", i2).w("topic_id", this.jZF.topicId).al("obj_source", this.jZF.from));
                if (this.kar != null) {
                    this.kar.Df(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.jZF.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.jZF.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.jZF.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jZF != null) {
            Z(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void Z(Canvas canvas) {
        float y = this.jZI.getY() + ((this.mBtnHeight - this.kad) / 2);
        this.mPaint.setShader(new LinearGradient(this.jZV / 2, y, this.kae, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jZV / 2, y, this.kae, y + this.kad, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.kae, y, this.mWidth - (this.jZV / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.kae, y, this.mWidth - (this.jZV / 2), y + this.kad, this.mPaint);
    }

    public void setUserColor(int i) {
        this.kag = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.jZg == null || bVar.jZh == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jZF = bVar;
        this.jZO.setText(String.valueOf(bVar.jZg.jZi));
        this.jZP.setText(String.valueOf(bVar.jZh.jZi));
        this.kap = new RelativeLayout.LayoutParams(-2, -2);
        this.kap.addRule(12);
        this.kaq = new RelativeLayout.LayoutParams(-2, -2);
        this.kaq.addRule(12);
        this.kaq.addRule(11);
        this.jZR.setLayoutParams(this.kap);
        this.jZS.setLayoutParams(this.kaq);
        if (bVar.from == 3) {
            this.jZR.setText(StringUtils.isNull(bVar.jZg.jZj) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.jZg.jZj);
            this.jZS.setText(StringUtils.isNull(bVar.jZh.jZj) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.jZh.jZj);
            if (StringUtils.isNull(bVar.jZg.jZk)) {
                this.jZG.setVisibility(4);
            } else {
                this.jZG.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jZg.jZk));
            }
            if (StringUtils.isNull(bVar.jZh.jZk)) {
                this.jZH.setVisibility(4);
            } else {
                this.jZH.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jZh.jZk));
            }
        } else {
            this.jZR.setText(bVar.jZg.jZj);
            this.jZS.setText(bVar.jZh.jZj);
            this.jZG.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jZg.jZk));
            this.jZH.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jZh.jZk));
        }
        this.jZK.startLoad(bVar.jZg.jZl, 10, false);
        this.jZL.startLoad(bVar.jZh.jZl, 10, false);
        this.jZM.startLoad(bVar.jZg.jZo, 10, false);
        this.jZN.startLoad(bVar.jZh.jZo, 10, false);
        if (bVar.jZg.jZm) {
            this.jZK.setVisibility(4);
            this.jZM.setVisibility(0);
        } else {
            this.jZK.setVisibility(0);
            this.jZM.setVisibility(4);
        }
        if (bVar.jZh.jZm) {
            this.jZL.setVisibility(4);
            this.jZN.setVisibility(0);
        } else {
            this.jZL.setVisibility(0);
            this.jZN.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jZG, this.kag);
        ap.setViewTextColor(this.jZH, this.kag);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.jZK.setIsNight(this.mSkinType == 1);
            this.jZL.setIsNight(this.mSkinType == 1);
            this.jZM.setIsNight(this.mSkinType == 1);
            this.jZN.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.jZI, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.jZJ, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.jZT, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jZU, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jZQ, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.jZO, R.color.CAM_X0101);
            ap.setViewTextColor(this.jZP, R.color.CAM_X0101);
            ap.setViewTextColor(this.jZR, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.jZS, R.color.topic_disagree_des_color);
        }
    }

    private void rN(boolean z) {
        if (z) {
            this.jZG.setVisibility(0);
            this.jZG.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jZF.jZg.jZk = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jZF.jZg.jZm = true;
            TextView textView = this.jZO;
            b.a aVar = this.jZF.jZg;
            long j = aVar.jZi + 1;
            aVar.jZi = j;
            textView.setText(String.valueOf(j));
            this.jZT.setVisibility(0);
            this.kai = this.jZM;
            this.kaj.kau = this.jZM;
            this.kaj.kav = this.jZK;
            this.jZT.setVisibility(0);
            this.kah.start();
            this.kal = this.jZT.getX();
            this.kam = this.jZT.getY();
            this.kan = this.jZT.getX();
            this.kao = this.jZT.getY();
            this.kak.removeAllUpdateListeners();
            this.kak.addUpdateListener(this.kas);
            this.kak.setFloatValues(0.0f, 2.0f);
            this.kak.start();
            return;
        }
        if (au.equals(this.jZF.jZg.jZk, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jZG.setVisibility(4);
        }
        if (this.jZF.jZg.jZm) {
            this.jZF.jZg.jZm = false;
            TextView textView2 = this.jZO;
            b.a aVar2 = this.jZF.jZg;
            long j2 = aVar2.jZi - 1;
            aVar2.jZi = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jZK.setVisibility(0);
        this.jZM.setVisibility(4);
    }

    private void rO(boolean z) {
        if (z) {
            this.jZH.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jZH.setVisibility(0);
            this.jZF.jZh.jZk = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jZU.setVisibility(0);
            this.jZF.jZh.jZm = true;
            TextView textView = this.jZP;
            b.a aVar = this.jZF.jZh;
            long j = aVar.jZi + 1;
            aVar.jZi = j;
            textView.setText(String.valueOf(j));
            this.kal = this.jZU.getX() - (this.kaf / 2.0f);
            this.kai = this.jZN;
            this.kaj.kau = this.jZN;
            this.kaj.kav = this.jZL;
            this.jZT.setVisibility(0);
            this.kah.start();
            this.kal = this.jZU.getX() - (this.kaf / 2);
            this.kam = this.jZU.getY();
            this.kan = this.jZU.getX();
            this.kao = this.jZU.getY();
            this.kak.removeAllUpdateListeners();
            this.kak.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.jZU.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kal) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.jZV) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jZV / 2)))));
                        TopicPkView.this.jZU.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.kam) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.jZU.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jZV / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.jZU.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.jZU.setVisibility(4);
                        TopicPkView.this.jZU.setX(TopicPkView.this.kan);
                        TopicPkView.this.jZU.setY(TopicPkView.this.kao);
                    }
                }
            });
            this.kak.setFloatValues(0.0f, 2.0f);
            this.kak.start();
            return;
        }
        if (au.equals(this.jZF.jZh.jZk, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jZH.setVisibility(4);
        }
        if (this.jZF.jZh.jZm) {
            this.jZF.jZh.jZm = false;
            TextView textView2 = this.jZP;
            b.a aVar2 = this.jZF.jZh;
            long j2 = aVar2.jZi - 1;
            aVar2.jZi = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jZU.setVisibility(4);
        this.jZL.setVisibility(0);
        this.jZN.setVisibility(4);
    }

    private boolean cRf() {
        return (this.jZF == null || this.jZF.jZg == null || !this.jZF.jZg.jZm) ? false : true;
    }

    private boolean cRg() {
        return (this.jZF == null || this.jZF.jZh == null || !this.jZF.jZh.jZm) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.kah != null) {
            this.kah.cancel();
        }
        if (this.kak != null) {
            this.kak.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.kar = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a implements Animator.AnimatorListener {
        private View kau;
        private View kav;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.kau != null) {
                this.kau.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.kav != null) {
                this.kav.setVisibility(8);
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
