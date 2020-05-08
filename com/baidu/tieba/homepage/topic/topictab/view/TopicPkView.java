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
    private com.baidu.tieba.homepage.topic.topictab.b.b hTD;
    private TextView hTE;
    private TextView hTF;
    private FrameLayout hTG;
    private FrameLayout hTH;
    private TbImageView hTI;
    private TbImageView hTJ;
    private TbImageView hTK;
    private TbImageView hTL;
    private TextView hTM;
    private TextView hTN;
    private ImageView hTO;
    private TextView hTP;
    private TextView hTQ;
    private ImageView hTR;
    private ImageView hTS;
    private int hTT;
    private int hTU;
    private int hTV;
    private int hTW;
    private int hTX;
    private int hTY;
    private int hTZ;
    private int hUa;
    private int hUb;
    private int hUc;
    private int hUd;
    private int hUe;
    private ValueAnimator hUf;
    private View hUg;
    private a hUh;
    private ValueAnimator hUi;
    private double hUj;
    private double hUk;
    private float hUl;
    private float hUm;
    private RelativeLayout.LayoutParams hUn;
    private RelativeLayout.LayoutParams hUo;
    private b hUp;
    private ValueAnimator.AnimatorUpdateListener hUq;
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
        void wb(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hUe = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hUq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hTR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUj) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hTT - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTG.getX() + (TopicPkView.this.hTT / 2)))));
                    TopicPkView.this.hTR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUk) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hTR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hTG.getX() + (TopicPkView.this.hTT / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTG.getX() + (TopicPkView.this.hTT / 2)))));
                    TopicPkView.this.hTR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hTR.setVisibility(4);
                    TopicPkView.this.hTR.setX(TopicPkView.this.hUl);
                    TopicPkView.this.hTR.setY(TopicPkView.this.hUm);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hUe = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hUq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hTR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUj) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hTT - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTG.getX() + (TopicPkView.this.hTT / 2)))));
                    TopicPkView.this.hTR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUk) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hTR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hTG.getX() + (TopicPkView.this.hTT / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTG.getX() + (TopicPkView.this.hTT / 2)))));
                    TopicPkView.this.hTR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hTR.setVisibility(4);
                    TopicPkView.this.hTR.setX(TopicPkView.this.hUl);
                    TopicPkView.this.hTR.setY(TopicPkView.this.hUm);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hUe = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hUq = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hTR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUj) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hTT - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTG.getX() + (TopicPkView.this.hTT / 2)))));
                    TopicPkView.this.hTR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUk) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hTR.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hTG.getX() + (TopicPkView.this.hTT / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTG.getX() + (TopicPkView.this.hTT / 2)))));
                    TopicPkView.this.hTR.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hTR.setVisibility(4);
                    TopicPkView.this.hTR.setX(TopicPkView.this.hUl);
                    TopicPkView.this.hTR.setY(TopicPkView.this.hUm);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.hTE = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.hTF = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.hTG = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.hTH = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.hTI = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.hTJ = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.hTK = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.hTL = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.hTM = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.hTN = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.hTO = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.hTP = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.hTQ = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.hTR = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.hTS = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.hTI.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.hTJ.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.hTK.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.hTL.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.hTG.setOnClickListener(this);
        this.hTH.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.hUb = l.getDimens(context, R.dimen.tbds62);
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
        if (this.hTD != null) {
            this.hTT = this.hTG.getWidth();
            this.mBtnHeight = this.hTG.getHeight();
            this.hTU = this.hTI.getWidth();
            this.hTV = this.hTM.getWidth();
            this.hTW = this.hTN.getWidth();
            this.hTZ = this.hTM.getHeight();
            this.hTX = this.hTP.getWidth();
            this.hTY = this.hTQ.getWidth();
            this.mCursorWidth = this.hTO.getWidth();
            this.mCursorHeight = this.hTO.getHeight();
            this.hUa = ((this.mWidth - (this.hTT * 2)) - this.hTV) - this.hTW;
            this.hUd = this.hTR.getWidth();
            if (this.hTD.hTc.hTe == 0 && this.hTD.hTd.hTe == 0) {
                this.hUc = (int) ((0.5d * this.hUa) + this.hTV + this.hTT);
            } else {
                this.hUc = (int) (((((float) this.hTD.hTc.hTe) / ((float) (this.hTD.hTc.hTe + this.hTD.hTd.hTe))) * this.hUa) + this.hTV + this.hTT);
            }
            float y = this.hTG.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.hUc + (this.mCursorWidth / 2) >= this.hTN.getLeft()) {
                this.hUc = (this.hTN.getLeft() - 10) - (this.mCursorWidth / 2);
                this.hTO.layout((this.hTN.getLeft() - 10) - this.mCursorWidth, (int) y, this.hTN.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.hUc - (this.mCursorWidth / 2) <= this.hTM.getRight()) {
                this.hUc = this.hTM.getRight() + 10 + (this.mCursorWidth / 2);
                this.hTO.layout(this.hTM.getRight() + 10, (int) y, this.hTM.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.hTO.layout(this.hUc - (this.mCursorWidth / 2), (int) y, this.hUc + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.hTI.getX());
            if (this.hTX < this.hTU) {
                int i5 = (this.hTT - this.hTX) / 2;
                this.hTP.layout(i5, (int) this.hTP.getY(), this.hTX + i5, ((int) this.hTP.getY()) + this.hTZ);
            } else if (this.hTX <= x) {
                this.hTP.layout((int) this.hTI.getX(), (int) this.hTP.getY(), ((int) this.hTI.getX()) + this.hTX, ((int) this.hTP.getY()) + this.hTZ);
            } else {
                ViewGroup.LayoutParams layoutParams = this.hTP.getLayoutParams();
                layoutParams.width = x;
                this.hTP.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.hTY < this.hTU) {
                int x2 = ((int) this.hTH.getX()) + ((this.hTT - this.hTY) / 2);
                this.hTQ.layout(x2, (int) this.hTQ.getY(), this.hTY + x2, ((int) this.hTQ.getY()) + this.hTZ);
            } else if (this.hTY <= x) {
                this.hTQ.layout((this.mWidth - ((int) this.hTJ.getX())) - this.hTY, (int) this.hTQ.getY(), this.mWidth - ((int) this.hTJ.getX()), ((int) this.hTQ.getY()) + this.hTZ);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.hTQ.getLayoutParams();
                layoutParams2.width = x;
                this.hTQ.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.hTT - this.hUd) / 2;
            this.hTR.layout(((int) this.hTG.getX()) + i6, ((int) this.hTG.getY()) + i6, ((int) this.hTG.getX()) + i6 + this.hUd, ((int) this.hTG.getY()) + i6 + this.hUd);
            this.hTS.layout(((int) this.hTH.getX()) + i6, ((int) this.hTH.getY()) + i6, ((int) this.hTH.getX()) + i6 + this.hUd, i6 + ((int) this.hTH.getY()) + this.hUd);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.hTD.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.hUf == null || !this.hUf.isRunning()) {
            if (this.hUi == null || !this.hUi.isRunning()) {
                if (this.hUi == null) {
                    this.hUi = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.hUi.setDuration(800L);
                    this.hUi.setInterpolator(new AccelerateInterpolator());
                }
                if (this.hUf == null) {
                    this.hUf = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.hUf.setDuration(800L);
                    this.hUf.setInterpolator(new AccelerateInterpolator());
                    this.hUh = new a();
                    this.hUf.addListener(this.hUh);
                    this.hUf.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.hUg.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.hUg.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cav()) {
                    i = 1;
                } else {
                    i = caw() ? 2 : 0;
                }
                if (view == this.hTG) {
                    oa(1 != i);
                    ob(false);
                    i2 = 1;
                } else if (view == this.hTH) {
                    ob(2 != i);
                    oa(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").af("obj_type", i2).t("topic_id", this.hTD.topicId).af("obj_source", this.hTD.from));
                if (this.hUp != null) {
                    this.hUp.wb(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.hTD.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.hTD.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.hTD.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.hTD != null) {
            M(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void M(Canvas canvas) {
        float y = this.hTG.getY() + ((this.mBtnHeight - this.hUb) / 2);
        this.mPaint.setShader(new LinearGradient(this.hTT / 2, y, this.hUc, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hTT / 2, y, this.hUc, y + this.hUb, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.hUc, y, this.mWidth - (this.hTT / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hUc, y, this.mWidth - (this.hTT / 2), y + this.hUb, this.mPaint);
    }

    public void setUserColor(int i) {
        this.hUe = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.hTc == null || bVar.hTd == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hTD = bVar;
        this.hTM.setText(String.valueOf(bVar.hTc.hTe));
        this.hTN.setText(String.valueOf(bVar.hTd.hTe));
        this.hUn = new RelativeLayout.LayoutParams(-2, -2);
        this.hUn.addRule(12);
        this.hUo = new RelativeLayout.LayoutParams(-2, -2);
        this.hUo.addRule(12);
        this.hUo.addRule(11);
        this.hTP.setLayoutParams(this.hUn);
        this.hTQ.setLayoutParams(this.hUo);
        if (bVar.from == 3) {
            this.hTP.setText(StringUtils.isNull(bVar.hTc.hTf) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.hTc.hTf);
            this.hTQ.setText(StringUtils.isNull(bVar.hTd.hTf) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.hTd.hTf);
            if (StringUtils.isNull(bVar.hTc.hTg)) {
                this.hTE.setVisibility(4);
            } else {
                this.hTE.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hTc.hTg));
            }
            if (StringUtils.isNull(bVar.hTd.hTg)) {
                this.hTF.setVisibility(4);
            } else {
                this.hTF.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hTd.hTg));
            }
        } else {
            this.hTP.setText(bVar.hTc.hTf);
            this.hTQ.setText(bVar.hTd.hTf);
            this.hTE.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hTc.hTg));
            this.hTF.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hTd.hTg));
        }
        this.hTI.startLoad(bVar.hTc.hTh, 10, false);
        this.hTJ.startLoad(bVar.hTd.hTh, 10, false);
        this.hTK.startLoad(bVar.hTc.hTk, 10, false);
        this.hTL.startLoad(bVar.hTd.hTk, 10, false);
        if (bVar.hTc.hTi) {
            this.hTI.setVisibility(4);
            this.hTK.setVisibility(0);
        } else {
            this.hTI.setVisibility(0);
            this.hTK.setVisibility(4);
        }
        if (bVar.hTd.hTi) {
            this.hTJ.setVisibility(4);
            this.hTL.setVisibility(0);
        } else {
            this.hTJ.setVisibility(0);
            this.hTL.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.hTE, this.hUe);
        am.setViewTextColor(this.hTF, this.hUe);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.hTI.setIsNight(this.mSkinType == 1);
            this.hTJ.setIsNight(this.mSkinType == 1);
            this.hTK.setIsNight(this.mSkinType == 1);
            this.hTL.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.hTG, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.hTH, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.hTR, R.drawable.pic_topic_addone);
            am.setImageResource(this.hTS, R.drawable.pic_topic_addone);
            am.setImageResource(this.hTO, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.hTM, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hTN, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hTP, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.hTQ, (int) R.color.topic_disagree_des_color);
        }
    }

    private void oa(boolean z) {
        if (z) {
            this.hTE.setVisibility(0);
            this.hTE.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hTD.hTc.hTg = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hTD.hTc.hTi = true;
            TextView textView = this.hTM;
            b.a aVar = this.hTD.hTc;
            long j = aVar.hTe + 1;
            aVar.hTe = j;
            textView.setText(String.valueOf(j));
            this.hTR.setVisibility(0);
            this.hUg = this.hTK;
            this.hUh.hUs = this.hTK;
            this.hUh.hUt = this.hTI;
            this.hTR.setVisibility(0);
            this.hUf.start();
            this.hUj = this.hTR.getX();
            this.hUk = this.hTR.getY();
            this.hUl = this.hTR.getX();
            this.hUm = this.hTR.getY();
            this.hUi.removeAllUpdateListeners();
            this.hUi.addUpdateListener(this.hUq);
            this.hUi.setFloatValues(0.0f, 2.0f);
            this.hUi.start();
            return;
        }
        if (aq.equals(this.hTD.hTc.hTg, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hTE.setVisibility(4);
        }
        if (this.hTD.hTc.hTi) {
            this.hTD.hTc.hTi = false;
            TextView textView2 = this.hTM;
            b.a aVar2 = this.hTD.hTc;
            long j2 = aVar2.hTe - 1;
            aVar2.hTe = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hTI.setVisibility(0);
        this.hTK.setVisibility(4);
    }

    private void ob(boolean z) {
        if (z) {
            this.hTF.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hTF.setVisibility(0);
            this.hTD.hTd.hTg = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hTS.setVisibility(0);
            this.hTD.hTd.hTi = true;
            TextView textView = this.hTN;
            b.a aVar = this.hTD.hTd;
            long j = aVar.hTe + 1;
            aVar.hTe = j;
            textView.setText(String.valueOf(j));
            this.hUj = this.hTS.getX() - (this.hUd / 2.0f);
            this.hUg = this.hTL;
            this.hUh.hUs = this.hTL;
            this.hUh.hUt = this.hTJ;
            this.hTR.setVisibility(0);
            this.hUf.start();
            this.hUj = this.hTS.getX() - (this.hUd / 2);
            this.hUk = this.hTS.getY();
            this.hUl = this.hTS.getX();
            this.hUm = this.hTS.getY();
            this.hUi.removeAllUpdateListeners();
            this.hUi.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.hTS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUj) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.hTT) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hTT / 2)))));
                        TopicPkView.this.hTS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUk) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.hTS.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hTT / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.hTS.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.hTS.setVisibility(4);
                        TopicPkView.this.hTS.setX(TopicPkView.this.hUl);
                        TopicPkView.this.hTS.setY(TopicPkView.this.hUm);
                    }
                }
            });
            this.hUi.setFloatValues(0.0f, 2.0f);
            this.hUi.start();
            return;
        }
        if (aq.equals(this.hTD.hTd.hTg, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hTF.setVisibility(4);
        }
        if (this.hTD.hTd.hTi) {
            this.hTD.hTd.hTi = false;
            TextView textView2 = this.hTN;
            b.a aVar2 = this.hTD.hTd;
            long j2 = aVar2.hTe - 1;
            aVar2.hTe = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hTS.setVisibility(4);
        this.hTJ.setVisibility(0);
        this.hTL.setVisibility(4);
    }

    private boolean cav() {
        return (this.hTD == null || this.hTD.hTc == null || !this.hTD.hTc.hTi) ? false : true;
    }

    private boolean caw() {
        return (this.hTD == null || this.hTD.hTd == null || !this.hTD.hTd.hTi) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.hUf != null) {
            this.hUf.cancel();
        }
        if (this.hUi != null) {
            this.hUi.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.hUp = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Animator.AnimatorListener {
        private View hUs;
        private View hUt;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.hUs != null) {
                this.hUs.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.hUt != null) {
                this.hUt.setVisibility(8);
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
