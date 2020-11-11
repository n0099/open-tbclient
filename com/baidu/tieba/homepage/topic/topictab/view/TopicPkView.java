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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes22.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private TextView jLA;
    private ImageView jLB;
    private TextView jLC;
    private TextView jLD;
    private ImageView jLE;
    private ImageView jLF;
    private int jLG;
    private int jLH;
    private int jLI;
    private int jLJ;
    private int jLK;
    private int jLL;
    private int jLM;
    private int jLN;
    private int jLO;
    private int jLP;
    private int jLQ;
    private int jLR;
    private ValueAnimator jLS;
    private View jLT;
    private a jLU;
    private ValueAnimator jLV;
    private double jLW;
    private double jLX;
    private float jLY;
    private float jLZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b jLq;
    private TextView jLr;
    private TextView jLs;
    private FrameLayout jLt;
    private FrameLayout jLu;
    private TbImageView jLv;
    private TbImageView jLw;
    private TbImageView jLx;
    private TbImageView jLy;
    private TextView jLz;
    private RelativeLayout.LayoutParams jMa;
    private RelativeLayout.LayoutParams jMb;
    private b jMc;
    private ValueAnimator.AnimatorUpdateListener jMd;
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
        void BS(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.jLR = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jMd = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jLE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jLW) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jLG - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jLt.getX() + (TopicPkView.this.jLG / 2)))));
                    TopicPkView.this.jLE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jLX) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jLE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jLt.getX() + (TopicPkView.this.jLG / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jLt.getX() + (TopicPkView.this.jLG / 2)))));
                    TopicPkView.this.jLE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jLE.setVisibility(4);
                    TopicPkView.this.jLE.setX(TopicPkView.this.jLY);
                    TopicPkView.this.jLE.setY(TopicPkView.this.jLZ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.jLR = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jMd = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jLE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jLW) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jLG - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jLt.getX() + (TopicPkView.this.jLG / 2)))));
                    TopicPkView.this.jLE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jLX) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jLE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jLt.getX() + (TopicPkView.this.jLG / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jLt.getX() + (TopicPkView.this.jLG / 2)))));
                    TopicPkView.this.jLE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jLE.setVisibility(4);
                    TopicPkView.this.jLE.setX(TopicPkView.this.jLY);
                    TopicPkView.this.jLE.setY(TopicPkView.this.jLZ);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.jLR = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.jMd = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.jLE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jLW) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.jLG - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jLt.getX() + (TopicPkView.this.jLG / 2)))));
                    TopicPkView.this.jLE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jLX) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.jLE.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.jLt.getX() + (TopicPkView.this.jLG / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.jLt.getX() + (TopicPkView.this.jLG / 2)))));
                    TopicPkView.this.jLE.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.jLE.setVisibility(4);
                    TopicPkView.this.jLE.setX(TopicPkView.this.jLY);
                    TopicPkView.this.jLE.setY(TopicPkView.this.jLZ);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.jLr = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.jLs = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.jLt = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.jLu = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.jLv = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.jLw = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.jLx = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.jLy = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.jLz = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.jLA = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.jLB = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.jLC = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.jLD = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.jLE = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.jLF = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.jLv.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.jLw.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.jLx.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.jLy.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.jLt.setOnClickListener(this);
        this.jLu.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.jLO = l.getDimens(context, R.dimen.tbds62);
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
        if (this.jLq != null) {
            this.jLG = this.jLt.getWidth();
            this.mBtnHeight = this.jLt.getHeight();
            this.jLH = this.jLv.getWidth();
            this.jLI = this.jLz.getWidth();
            this.jLJ = this.jLA.getWidth();
            this.jLM = this.jLz.getHeight();
            this.jLK = this.jLC.getWidth();
            this.jLL = this.jLD.getWidth();
            this.mCursorWidth = this.jLB.getWidth();
            this.mCursorHeight = this.jLB.getHeight();
            this.jLN = ((this.mWidth - (this.jLG * 2)) - this.jLI) - this.jLJ;
            this.jLQ = this.jLE.getWidth();
            if (this.jLq.jKQ.jKS == 0 && this.jLq.jKR.jKS == 0) {
                this.jLP = (int) ((0.5d * this.jLN) + this.jLI + this.jLG);
            } else {
                this.jLP = (int) (((((float) this.jLq.jKQ.jKS) / ((float) (this.jLq.jKQ.jKS + this.jLq.jKR.jKS))) * this.jLN) + this.jLI + this.jLG);
            }
            float y = this.jLt.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.jLP + (this.mCursorWidth / 2) >= this.jLA.getLeft()) {
                this.jLP = (this.jLA.getLeft() - 10) - (this.mCursorWidth / 2);
                this.jLB.layout((this.jLA.getLeft() - 10) - this.mCursorWidth, (int) y, this.jLA.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.jLP - (this.mCursorWidth / 2) <= this.jLz.getRight()) {
                this.jLP = this.jLz.getRight() + 10 + (this.mCursorWidth / 2);
                this.jLB.layout(this.jLz.getRight() + 10, (int) y, this.jLz.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.jLB.layout(this.jLP - (this.mCursorWidth / 2), (int) y, this.jLP + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.jLv.getX());
            if (this.jLK < this.jLH) {
                int i5 = (this.jLG - this.jLK) / 2;
                this.jLC.layout(i5, (int) this.jLC.getY(), this.jLK + i5, ((int) this.jLC.getY()) + this.jLM);
            } else if (this.jLK <= x) {
                this.jLC.layout((int) this.jLv.getX(), (int) this.jLC.getY(), ((int) this.jLv.getX()) + this.jLK, ((int) this.jLC.getY()) + this.jLM);
            } else {
                ViewGroup.LayoutParams layoutParams = this.jLC.getLayoutParams();
                layoutParams.width = x;
                this.jLC.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.jLL < this.jLH) {
                int x2 = ((int) this.jLu.getX()) + ((this.jLG - this.jLL) / 2);
                this.jLD.layout(x2, (int) this.jLD.getY(), this.jLL + x2, ((int) this.jLD.getY()) + this.jLM);
            } else if (this.jLL <= x) {
                this.jLD.layout((this.mWidth - ((int) this.jLw.getX())) - this.jLL, (int) this.jLD.getY(), this.mWidth - ((int) this.jLw.getX()), ((int) this.jLD.getY()) + this.jLM);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.jLD.getLayoutParams();
                layoutParams2.width = x;
                this.jLD.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.jLG - this.jLQ) / 2;
            this.jLE.layout(((int) this.jLt.getX()) + i6, ((int) this.jLt.getY()) + i6, ((int) this.jLt.getX()) + i6 + this.jLQ, ((int) this.jLt.getY()) + i6 + this.jLQ);
            this.jLF.layout(((int) this.jLu.getX()) + i6, ((int) this.jLu.getY()) + i6, ((int) this.jLu.getX()) + i6 + this.jLQ, i6 + ((int) this.jLu.getY()) + this.jLQ);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.jLq.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.jLS == null || !this.jLS.isRunning()) {
            if (this.jLV == null || !this.jLV.isRunning()) {
                if (this.jLV == null) {
                    this.jLV = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.jLV.setDuration(800L);
                    this.jLV.setInterpolator(new AccelerateInterpolator());
                }
                if (this.jLS == null) {
                    this.jLS = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.jLS.setDuration(800L);
                    this.jLS.setInterpolator(new AccelerateInterpolator());
                    this.jLU = new a();
                    this.jLS.addListener(this.jLU);
                    this.jLS.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.jLT.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.jLT.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cMj()) {
                    i = 1;
                } else {
                    i = cMk() ? 2 : 0;
                }
                if (view == this.jLt) {
                    ri(1 != i);
                    rj(false);
                    i2 = 1;
                } else if (view == this.jLu) {
                    rj(2 != i);
                    ri(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new aq("c13352").al("obj_type", i2).w("topic_id", this.jLq.topicId).al("obj_source", this.jLq.from));
                if (this.jMc != null) {
                    this.jMc.BS(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.jLq.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.jLq.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.jLq.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.jLq != null) {
            W(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void W(Canvas canvas) {
        float y = this.jLt.getY() + ((this.mBtnHeight - this.jLO) / 2);
        this.mPaint.setShader(new LinearGradient(this.jLG / 2, y, this.jLP, y, ap.getColor(R.color.topic_pk_agree_bar_start_color), ap.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jLG / 2, y, this.jLP, y + this.jLO, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.jLP, y, this.mWidth - (this.jLG / 2), y, ap.getColor(R.color.topic_pk_disagree_bar_start_color), ap.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.jLP, y, this.mWidth - (this.jLG / 2), y + this.jLO, this.mPaint);
    }

    public void setUserColor(int i) {
        this.jLR = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.jKQ == null || bVar.jKR == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.jLq = bVar;
        this.jLz.setText(String.valueOf(bVar.jKQ.jKS));
        this.jLA.setText(String.valueOf(bVar.jKR.jKS));
        this.jMa = new RelativeLayout.LayoutParams(-2, -2);
        this.jMa.addRule(12);
        this.jMb = new RelativeLayout.LayoutParams(-2, -2);
        this.jMb.addRule(12);
        this.jMb.addRule(11);
        this.jLC.setLayoutParams(this.jMa);
        this.jLD.setLayoutParams(this.jMb);
        if (bVar.from == 3) {
            this.jLC.setText(StringUtils.isNull(bVar.jKQ.jKT) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.jKQ.jKT);
            this.jLD.setText(StringUtils.isNull(bVar.jKR.jKT) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.jKR.jKT);
            if (StringUtils.isNull(bVar.jKQ.jKU)) {
                this.jLr.setVisibility(4);
            } else {
                this.jLr.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jKQ.jKU));
            }
            if (StringUtils.isNull(bVar.jKR.jKU)) {
                this.jLs.setVisibility(4);
            } else {
                this.jLs.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jKR.jKU));
            }
        } else {
            this.jLC.setText(bVar.jKQ.jKT);
            this.jLD.setText(bVar.jKR.jKT);
            this.jLr.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jKQ.jKU));
            this.jLs.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.jKR.jKU));
        }
        this.jLv.startLoad(bVar.jKQ.jKV, 10, false);
        this.jLw.startLoad(bVar.jKR.jKV, 10, false);
        this.jLx.startLoad(bVar.jKQ.jKY, 10, false);
        this.jLy.startLoad(bVar.jKR.jKY, 10, false);
        if (bVar.jKQ.jKW) {
            this.jLv.setVisibility(4);
            this.jLx.setVisibility(0);
        } else {
            this.jLv.setVisibility(0);
            this.jLx.setVisibility(4);
        }
        if (bVar.jKR.jKW) {
            this.jLw.setVisibility(4);
            this.jLy.setVisibility(0);
        } else {
            this.jLw.setVisibility(0);
            this.jLy.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ap.setViewTextColor(this.jLr, this.jLR);
        ap.setViewTextColor(this.jLs, this.jLR);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.jLv.setIsNight(this.mSkinType == 1);
            this.jLw.setIsNight(this.mSkinType == 1);
            this.jLx.setIsNight(this.mSkinType == 1);
            this.jLy.setIsNight(this.mSkinType == 1);
            ap.setBackgroundResource(this.jLt, R.drawable.btn_topic_agree_bg_red);
            ap.setBackgroundResource(this.jLu, R.drawable.btn_topic_disagree_bg_blue);
            ap.setImageResource(this.jLE, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jLF, R.drawable.pic_topic_addone);
            ap.setImageResource(this.jLB, R.drawable.pic_topic_vs_bginone);
            ap.setViewTextColor(this.jLz, R.color.cp_cont_a);
            ap.setViewTextColor(this.jLA, R.color.cp_cont_a);
            ap.setViewTextColor(this.jLC, R.color.topic_agree_des_color);
            ap.setViewTextColor(this.jLD, R.color.topic_disagree_des_color);
        }
    }

    private void ri(boolean z) {
        if (z) {
            this.jLr.setVisibility(0);
            this.jLr.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jLq.jKQ.jKU = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jLq.jKQ.jKW = true;
            TextView textView = this.jLz;
            b.a aVar = this.jLq.jKQ;
            long j = aVar.jKS + 1;
            aVar.jKS = j;
            textView.setText(String.valueOf(j));
            this.jLE.setVisibility(0);
            this.jLT = this.jLx;
            this.jLU.jMf = this.jLx;
            this.jLU.jMg = this.jLv;
            this.jLE.setVisibility(0);
            this.jLS.start();
            this.jLW = this.jLE.getX();
            this.jLX = this.jLE.getY();
            this.jLY = this.jLE.getX();
            this.jLZ = this.jLE.getY();
            this.jLV.removeAllUpdateListeners();
            this.jLV.addUpdateListener(this.jMd);
            this.jLV.setFloatValues(0.0f, 2.0f);
            this.jLV.start();
            return;
        }
        if (at.equals(this.jLq.jKQ.jKU, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jLr.setVisibility(4);
        }
        if (this.jLq.jKQ.jKW) {
            this.jLq.jKQ.jKW = false;
            TextView textView2 = this.jLz;
            b.a aVar2 = this.jLq.jKQ;
            long j2 = aVar2.jKS - 1;
            aVar2.jKS = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jLv.setVisibility(0);
        this.jLx.setVisibility(4);
    }

    private void rj(boolean z) {
        if (z) {
            this.jLs.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.jLs.setVisibility(0);
            this.jLq.jKR.jKU = TbadkCoreApplication.getCurrentAccountNameShow();
            this.jLF.setVisibility(0);
            this.jLq.jKR.jKW = true;
            TextView textView = this.jLA;
            b.a aVar = this.jLq.jKR;
            long j = aVar.jKS + 1;
            aVar.jKS = j;
            textView.setText(String.valueOf(j));
            this.jLW = this.jLF.getX() - (this.jLQ / 2.0f);
            this.jLT = this.jLy;
            this.jLU.jMf = this.jLy;
            this.jLU.jMg = this.jLw;
            this.jLE.setVisibility(0);
            this.jLS.start();
            this.jLW = this.jLF.getX() - (this.jLQ / 2);
            this.jLX = this.jLF.getY();
            this.jLY = this.jLF.getX();
            this.jLZ = this.jLF.getY();
            this.jLV.removeAllUpdateListeners();
            this.jLV.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.jLF.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jLW) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.jLG) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jLG / 2)))));
                        TopicPkView.this.jLF.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.jLX) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.jLF.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.jLG / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.jLF.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.jLF.setVisibility(4);
                        TopicPkView.this.jLF.setX(TopicPkView.this.jLY);
                        TopicPkView.this.jLF.setY(TopicPkView.this.jLZ);
                    }
                }
            });
            this.jLV.setFloatValues(0.0f, 2.0f);
            this.jLV.start();
            return;
        }
        if (at.equals(this.jLq.jKR.jKU, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.jLs.setVisibility(4);
        }
        if (this.jLq.jKR.jKW) {
            this.jLq.jKR.jKW = false;
            TextView textView2 = this.jLA;
            b.a aVar2 = this.jLq.jKR;
            long j2 = aVar2.jKS - 1;
            aVar2.jKS = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.jLF.setVisibility(4);
        this.jLw.setVisibility(0);
        this.jLy.setVisibility(4);
    }

    private boolean cMj() {
        return (this.jLq == null || this.jLq.jKQ == null || !this.jLq.jKQ.jKW) ? false : true;
    }

    private boolean cMk() {
        return (this.jLq == null || this.jLq.jKR == null || !this.jLq.jKR.jKW) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.jLS != null) {
            this.jLS.cancel();
        }
        if (this.jLV != null) {
            this.jLV.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.jMc = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes22.dex */
    public static class a implements Animator.AnimatorListener {
        private View jMf;
        private View jMg;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.jMf != null) {
                this.jMf.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.jMg != null) {
                this.jMg.setVisibility(8);
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
