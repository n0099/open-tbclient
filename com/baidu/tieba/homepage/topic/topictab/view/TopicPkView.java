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
    private FrameLayout hTA;
    private FrameLayout hTB;
    private TbImageView hTC;
    private TbImageView hTD;
    private TbImageView hTE;
    private TbImageView hTF;
    private TextView hTG;
    private TextView hTH;
    private ImageView hTI;
    private TextView hTJ;
    private TextView hTK;
    private ImageView hTL;
    private ImageView hTM;
    private int hTN;
    private int hTO;
    private int hTP;
    private int hTQ;
    private int hTR;
    private int hTS;
    private int hTT;
    private int hTU;
    private int hTV;
    private int hTW;
    private int hTX;
    private int hTY;
    private ValueAnimator hTZ;
    private com.baidu.tieba.homepage.topic.topictab.b.b hTx;
    private TextView hTy;
    private TextView hTz;
    private View hUa;
    private a hUb;
    private ValueAnimator hUc;
    private double hUd;
    private double hUe;
    private float hUf;
    private float hUg;
    private RelativeLayout.LayoutParams hUh;
    private RelativeLayout.LayoutParams hUi;
    private b hUj;
    private ValueAnimator.AnimatorUpdateListener hUk;
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
        this.hTY = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hUk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hTL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUd) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hTN - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTA.getX() + (TopicPkView.this.hTN / 2)))));
                    TopicPkView.this.hTL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUe) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hTL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hTA.getX() + (TopicPkView.this.hTN / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTA.getX() + (TopicPkView.this.hTN / 2)))));
                    TopicPkView.this.hTL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hTL.setVisibility(4);
                    TopicPkView.this.hTL.setX(TopicPkView.this.hUf);
                    TopicPkView.this.hTL.setY(TopicPkView.this.hUg);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hTY = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hUk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hTL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUd) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hTN - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTA.getX() + (TopicPkView.this.hTN / 2)))));
                    TopicPkView.this.hTL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUe) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hTL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hTA.getX() + (TopicPkView.this.hTN / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTA.getX() + (TopicPkView.this.hTN / 2)))));
                    TopicPkView.this.hTL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hTL.setVisibility(4);
                    TopicPkView.this.hTL.setX(TopicPkView.this.hUf);
                    TopicPkView.this.hTL.setY(TopicPkView.this.hUg);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hTY = R.color.cp_cont_a;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.hUk = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.hTL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUd) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.hTN - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTA.getX() + (TopicPkView.this.hTN / 2)))));
                    TopicPkView.this.hTL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUe) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.hTL.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.hTA.getX() + (TopicPkView.this.hTN / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.hTA.getX() + (TopicPkView.this.hTN / 2)))));
                    TopicPkView.this.hTL.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.hTL.setVisibility(4);
                    TopicPkView.this.hTL.setX(TopicPkView.this.hUf);
                    TopicPkView.this.hTL.setY(TopicPkView.this.hUg);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.hTy = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.hTz = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.hTA = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.hTB = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.hTC = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.hTD = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.hTE = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.hTF = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.hTG = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.hTH = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.hTI = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.hTJ = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.hTK = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.hTL = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.hTM = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.hTC.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.hTD.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.hTE.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.hTF.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.hTA.setOnClickListener(this);
        this.hTB.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.hTV = l.getDimens(context, R.dimen.tbds62);
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
        if (this.hTx != null) {
            this.hTN = this.hTA.getWidth();
            this.mBtnHeight = this.hTA.getHeight();
            this.hTO = this.hTC.getWidth();
            this.hTP = this.hTG.getWidth();
            this.hTQ = this.hTH.getWidth();
            this.hTT = this.hTG.getHeight();
            this.hTR = this.hTJ.getWidth();
            this.hTS = this.hTK.getWidth();
            this.mCursorWidth = this.hTI.getWidth();
            this.mCursorHeight = this.hTI.getHeight();
            this.hTU = ((this.mWidth - (this.hTN * 2)) - this.hTP) - this.hTQ;
            this.hTX = this.hTL.getWidth();
            if (this.hTx.hSW.hSY == 0 && this.hTx.hSX.hSY == 0) {
                this.hTW = (int) ((0.5d * this.hTU) + this.hTP + this.hTN);
            } else {
                this.hTW = (int) (((((float) this.hTx.hSW.hSY) / ((float) (this.hTx.hSW.hSY + this.hTx.hSX.hSY))) * this.hTU) + this.hTP + this.hTN);
            }
            float y = this.hTA.getY() - ((this.mCursorHeight - this.mBtnHeight) / 2);
            if (this.hTW + (this.mCursorWidth / 2) >= this.hTH.getLeft()) {
                this.hTW = (this.hTH.getLeft() - 10) - (this.mCursorWidth / 2);
                this.hTI.layout((this.hTH.getLeft() - 10) - this.mCursorWidth, (int) y, this.hTH.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.hTW - (this.mCursorWidth / 2) <= this.hTG.getRight()) {
                this.hTW = this.hTG.getRight() + 10 + (this.mCursorWidth / 2);
                this.hTI.layout(this.hTG.getRight() + 10, (int) y, this.hTG.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.hTI.layout(this.hTW - (this.mCursorWidth / 2), (int) y, this.hTW + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.hTC.getX());
            if (this.hTR < this.hTO) {
                int i5 = (this.hTN - this.hTR) / 2;
                this.hTJ.layout(i5, (int) this.hTJ.getY(), this.hTR + i5, ((int) this.hTJ.getY()) + this.hTT);
            } else if (this.hTR <= x) {
                this.hTJ.layout((int) this.hTC.getX(), (int) this.hTJ.getY(), ((int) this.hTC.getX()) + this.hTR, ((int) this.hTJ.getY()) + this.hTT);
            } else {
                ViewGroup.LayoutParams layoutParams = this.hTJ.getLayoutParams();
                layoutParams.width = x;
                this.hTJ.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.hTS < this.hTO) {
                int x2 = ((int) this.hTB.getX()) + ((this.hTN - this.hTS) / 2);
                this.hTK.layout(x2, (int) this.hTK.getY(), this.hTS + x2, ((int) this.hTK.getY()) + this.hTT);
            } else if (this.hTS <= x) {
                this.hTK.layout((this.mWidth - ((int) this.hTD.getX())) - this.hTS, (int) this.hTK.getY(), this.mWidth - ((int) this.hTD.getX()), ((int) this.hTK.getY()) + this.hTT);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.hTK.getLayoutParams();
                layoutParams2.width = x;
                this.hTK.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.hTN - this.hTX) / 2;
            this.hTL.layout(((int) this.hTA.getX()) + i6, ((int) this.hTA.getY()) + i6, ((int) this.hTA.getX()) + i6 + this.hTX, ((int) this.hTA.getY()) + i6 + this.hTX);
            this.hTM.layout(((int) this.hTB.getX()) + i6, ((int) this.hTB.getY()) + i6, ((int) this.hTB.getX()) + i6 + this.hTX, i6 + ((int) this.hTB.getY()) + this.hTX);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.hTx.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.hTZ == null || !this.hTZ.isRunning()) {
            if (this.hUc == null || !this.hUc.isRunning()) {
                if (this.hUc == null) {
                    this.hUc = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.hUc.setDuration(800L);
                    this.hUc.setInterpolator(new AccelerateInterpolator());
                }
                if (this.hTZ == null) {
                    this.hTZ = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.hTZ.setDuration(800L);
                    this.hTZ.setInterpolator(new AccelerateInterpolator());
                    this.hUb = new a();
                    this.hTZ.addListener(this.hUb);
                    this.hTZ.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.hUa.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.hUa.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cax()) {
                    i = 1;
                } else {
                    i = cay() ? 2 : 0;
                }
                if (view == this.hTA) {
                    oa(1 != i);
                    ob(false);
                    i2 = 1;
                } else if (view == this.hTB) {
                    ob(2 != i);
                    oa(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new an("c13352").af("obj_type", i2).t("topic_id", this.hTx.topicId).af("obj_source", this.hTx.from));
                if (this.hUj != null) {
                    this.hUj.wb(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.hTx.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.hTx.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.hTx.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.hTx != null) {
            M(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void M(Canvas canvas) {
        float y = this.hTA.getY() + ((this.mBtnHeight - this.hTV) / 2);
        this.mPaint.setShader(new LinearGradient(this.hTN / 2, y, this.hTW, y, am.getColor(R.color.topic_pk_agree_bar_start_color), am.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hTN / 2, y, this.hTW, y + this.hTV, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.hTW, y, this.mWidth - (this.hTN / 2), y, am.getColor(R.color.topic_pk_disagree_bar_start_color), am.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.hTW, y, this.mWidth - (this.hTN / 2), y + this.hTV, this.mPaint);
    }

    public void setUserColor(int i) {
        this.hTY = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.hSW == null || bVar.hSX == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.hTx = bVar;
        this.hTG.setText(String.valueOf(bVar.hSW.hSY));
        this.hTH.setText(String.valueOf(bVar.hSX.hSY));
        this.hUh = new RelativeLayout.LayoutParams(-2, -2);
        this.hUh.addRule(12);
        this.hUi = new RelativeLayout.LayoutParams(-2, -2);
        this.hUi.addRule(12);
        this.hUi.addRule(11);
        this.hTJ.setLayoutParams(this.hUh);
        this.hTK.setLayoutParams(this.hUi);
        if (bVar.from == 3) {
            this.hTJ.setText(StringUtils.isNull(bVar.hSW.hSZ) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.hSW.hSZ);
            this.hTK.setText(StringUtils.isNull(bVar.hSX.hSZ) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.hSX.hSZ);
            if (StringUtils.isNull(bVar.hSW.hTa)) {
                this.hTy.setVisibility(4);
            } else {
                this.hTy.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hSW.hTa));
            }
            if (StringUtils.isNull(bVar.hSX.hTa)) {
                this.hTz.setVisibility(4);
            } else {
                this.hTz.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hSX.hTa));
            }
        } else {
            this.hTJ.setText(bVar.hSW.hSZ);
            this.hTK.setText(bVar.hSX.hSZ);
            this.hTy.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hSW.hTa));
            this.hTz.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.hSX.hTa));
        }
        this.hTC.startLoad(bVar.hSW.hTb, 10, false);
        this.hTD.startLoad(bVar.hSX.hTb, 10, false);
        this.hTE.startLoad(bVar.hSW.hTe, 10, false);
        this.hTF.startLoad(bVar.hSX.hTe, 10, false);
        if (bVar.hSW.hTc) {
            this.hTC.setVisibility(4);
            this.hTE.setVisibility(0);
        } else {
            this.hTC.setVisibility(0);
            this.hTE.setVisibility(4);
        }
        if (bVar.hSX.hTc) {
            this.hTD.setVisibility(4);
            this.hTF.setVisibility(0);
        } else {
            this.hTD.setVisibility(0);
            this.hTF.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        am.setViewTextColor(this.hTy, this.hTY);
        am.setViewTextColor(this.hTz, this.hTY);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.hTC.setIsNight(this.mSkinType == 1);
            this.hTD.setIsNight(this.mSkinType == 1);
            this.hTE.setIsNight(this.mSkinType == 1);
            this.hTF.setIsNight(this.mSkinType == 1);
            am.setBackgroundResource(this.hTA, R.drawable.btn_topic_agree_bg_red);
            am.setBackgroundResource(this.hTB, R.drawable.btn_topic_disagree_bg_blue);
            am.setImageResource(this.hTL, R.drawable.pic_topic_addone);
            am.setImageResource(this.hTM, R.drawable.pic_topic_addone);
            am.setImageResource(this.hTI, R.drawable.pic_topic_vs_bginone);
            am.setViewTextColor(this.hTG, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hTH, (int) R.color.cp_cont_a);
            am.setViewTextColor(this.hTJ, (int) R.color.topic_agree_des_color);
            am.setViewTextColor(this.hTK, (int) R.color.topic_disagree_des_color);
        }
    }

    private void oa(boolean z) {
        if (z) {
            this.hTy.setVisibility(0);
            this.hTy.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hTx.hSW.hTa = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hTx.hSW.hTc = true;
            TextView textView = this.hTG;
            b.a aVar = this.hTx.hSW;
            long j = aVar.hSY + 1;
            aVar.hSY = j;
            textView.setText(String.valueOf(j));
            this.hTL.setVisibility(0);
            this.hUa = this.hTE;
            this.hUb.hUm = this.hTE;
            this.hUb.hUn = this.hTC;
            this.hTL.setVisibility(0);
            this.hTZ.start();
            this.hUd = this.hTL.getX();
            this.hUe = this.hTL.getY();
            this.hUf = this.hTL.getX();
            this.hUg = this.hTL.getY();
            this.hUc.removeAllUpdateListeners();
            this.hUc.addUpdateListener(this.hUk);
            this.hUc.setFloatValues(0.0f, 2.0f);
            this.hUc.start();
            return;
        }
        if (aq.equals(this.hTx.hSW.hTa, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hTy.setVisibility(4);
        }
        if (this.hTx.hSW.hTc) {
            this.hTx.hSW.hTc = false;
            TextView textView2 = this.hTG;
            b.a aVar2 = this.hTx.hSW;
            long j2 = aVar2.hSY - 1;
            aVar2.hSY = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hTC.setVisibility(0);
        this.hTE.setVisibility(4);
    }

    private void ob(boolean z) {
        if (z) {
            this.hTz.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.hTz.setVisibility(0);
            this.hTx.hSX.hTa = TbadkCoreApplication.getCurrentAccountNameShow();
            this.hTM.setVisibility(0);
            this.hTx.hSX.hTc = true;
            TextView textView = this.hTH;
            b.a aVar = this.hTx.hSX;
            long j = aVar.hSY + 1;
            aVar.hSY = j;
            textView.setText(String.valueOf(j));
            this.hUd = this.hTM.getX() - (this.hTX / 2.0f);
            this.hUa = this.hTF;
            this.hUb.hUm = this.hTF;
            this.hUb.hUn = this.hTD;
            this.hTL.setVisibility(0);
            this.hTZ.start();
            this.hUd = this.hTM.getX() - (this.hTX / 2);
            this.hUe = this.hTM.getY();
            this.hUf = this.hTM.getX();
            this.hUg = this.hTM.getY();
            this.hUc.removeAllUpdateListeners();
            this.hUc.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.hTM.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUd) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.hTN) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hTN / 2)))));
                        TopicPkView.this.hTM.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.hUe) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.hTM.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.hTN / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.hTM.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.hTM.setVisibility(4);
                        TopicPkView.this.hTM.setX(TopicPkView.this.hUf);
                        TopicPkView.this.hTM.setY(TopicPkView.this.hUg);
                    }
                }
            });
            this.hUc.setFloatValues(0.0f, 2.0f);
            this.hUc.start();
            return;
        }
        if (aq.equals(this.hTx.hSX.hTa, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.hTz.setVisibility(4);
        }
        if (this.hTx.hSX.hTc) {
            this.hTx.hSX.hTc = false;
            TextView textView2 = this.hTH;
            b.a aVar2 = this.hTx.hSX;
            long j2 = aVar2.hSY - 1;
            aVar2.hSY = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.hTM.setVisibility(4);
        this.hTD.setVisibility(0);
        this.hTF.setVisibility(4);
    }

    private boolean cax() {
        return (this.hTx == null || this.hTx.hSW == null || !this.hTx.hSW.hTc) ? false : true;
    }

    private boolean cay() {
        return (this.hTx == null || this.hTx.hSX == null || !this.hTx.hSX.hTc) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.hTZ != null) {
            this.hTZ.cancel();
        }
        if (this.hUc != null) {
            this.hUc.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.hUj = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public static class a implements Animator.AnimatorListener {
        private View hUm;
        private View hUn;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.hUm != null) {
                this.hUm.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.hUn != null) {
                this.hUn.setVisibility(8);
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
