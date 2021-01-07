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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.topic.topictab.b.b;
import com.baidu.tieba.message.RequestBlessMessage;
/* loaded from: classes2.dex */
public class TopicPkView extends RelativeLayout implements View.OnClickListener {
    private int dEg;
    private com.baidu.tieba.homepage.topic.topictab.b.b kmQ;
    private TextView kmR;
    private TextView kmS;
    private FrameLayout kmT;
    private FrameLayout kmU;
    private TbImageView kmV;
    private TbImageView kmW;
    private TbImageView kmX;
    private TbImageView kmY;
    private TextView kmZ;
    private RelativeLayout.LayoutParams knA;
    private RelativeLayout.LayoutParams knB;
    private b knC;
    private ValueAnimator.AnimatorUpdateListener knD;
    private TextView kna;
    private ImageView knb;
    private TextView knc;
    private TextView knd;
    private ImageView kne;
    private ImageView knf;
    private int kng;
    private int knh;
    private int kni;
    private int knj;
    private int knk;
    private int knl;
    private int knm;
    private int knn;
    private int kno;
    private int knp;
    private int knq;
    private int knr;
    private ValueAnimator kns;
    private View knt;
    private a knu;
    private ValueAnimator knv;
    private double knw;
    private double knx;
    private float kny;
    private float knz;
    private int mCursorHeight;
    private int mCursorWidth;
    private int mHeight;
    private Paint mPaint;
    private Runnable mRunnable;
    private int mSkinType;
    private int mWidth;

    /* loaded from: classes2.dex */
    public interface b {
        void Dt(int i);
    }

    public TopicPkView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.knr = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.knD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kne.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.knw) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kng - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kmT.getX() + (TopicPkView.this.kng / 2)))));
                    TopicPkView.this.kne.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.knx) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kne.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kmT.getX() + (TopicPkView.this.kng / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kmT.getX() + (TopicPkView.this.kng / 2)))));
                    TopicPkView.this.kne.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kne.setVisibility(4);
                    TopicPkView.this.kne.setX(TopicPkView.this.kny);
                    TopicPkView.this.kne.setY(TopicPkView.this.knz);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.knr = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.knD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kne.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.knw) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kng - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kmT.getX() + (TopicPkView.this.kng / 2)))));
                    TopicPkView.this.kne.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.knx) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kne.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kmT.getX() + (TopicPkView.this.kng / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kmT.getX() + (TopicPkView.this.kng / 2)))));
                    TopicPkView.this.kne.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kne.setVisibility(4);
                    TopicPkView.this.kne.setX(TopicPkView.this.kny);
                    TopicPkView.this.kne.setY(TopicPkView.this.knz);
                }
            }
        };
        init(context);
    }

    public TopicPkView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.knr = R.color.CAM_X0101;
        this.mRunnable = new Runnable() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.1
            @Override // java.lang.Runnable
            public void run() {
                TopicPkView.this.requestLayout();
            }
        };
        this.knD = new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.3
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                if (floatValue < 1.0f) {
                    TopicPkView.this.kne.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.knw) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.kng - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kmT.getX() + (TopicPkView.this.kng / 2)))));
                    TopicPkView.this.kne.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.knx) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                } else {
                    floatValue -= 1.0f;
                    TopicPkView.this.kne.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.kmT.getX() + (TopicPkView.this.kng / 2))) + (2.0f * floatValue * (1.0f - floatValue) * 45.0f) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.kmT.getX() + (TopicPkView.this.kng / 2)))));
                    TopicPkView.this.kne.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                }
                if (floatValue == 1.0f) {
                    TopicPkView.this.kne.setVisibility(4);
                    TopicPkView.this.kne.setX(TopicPkView.this.kny);
                    TopicPkView.this.kne.setY(TopicPkView.this.knz);
                }
            }
        };
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.topic_pk_view_layout, (ViewGroup) this, true);
        this.kmR = (TextView) findViewById(R.id.topic_pk_view_agree_user);
        this.kmS = (TextView) findViewById(R.id.topic_pk_view_disagree_user);
        this.kmT = (FrameLayout) findViewById(R.id.topic_pk_view_agree_btn);
        this.kmU = (FrameLayout) findViewById(R.id.topic_pk_view_disagree_btn);
        this.kmV = (TbImageView) findViewById(R.id.topic_pk_view_agree_img);
        this.kmW = (TbImageView) findViewById(R.id.topic_pk_view_disagree_img);
        this.kmX = (TbImageView) findViewById(R.id.topic_pk_view_agree_select_img);
        this.kmY = (TbImageView) findViewById(R.id.topic_pk_view_disagree_select_img);
        this.kmZ = (TextView) findViewById(R.id.topic_pk_view_agree_num);
        this.kna = (TextView) findViewById(R.id.topic_pk_view_disagree_num);
        this.knb = (ImageView) findViewById(R.id.topic_pk_view_cursor);
        this.knc = (TextView) findViewById(R.id.topic_pk_view_agree_des);
        this.knd = (TextView) findViewById(R.id.topic_pk_view_disagree_des);
        this.kne = (ImageView) findViewById(R.id.topic_pk_view_agree_add);
        this.knf = (ImageView) findViewById(R.id.topic_pk_view_disagree_add);
        this.kmV.setDefaultBgResource(R.drawable.btn_topic_agree_white_n);
        this.kmW.setDefaultBgResource(R.drawable.btn_topic_disagree_white_n);
        this.kmX.setDefaultBgResource(R.drawable.btn_topic_agree_white_h);
        this.kmY.setDefaultBgResource(R.drawable.btn_topic_disagree_white_h);
        this.kmT.setOnClickListener(this);
        this.kmU.setOnClickListener(this);
        this.mHeight = l.getDimens(context, R.dimen.tbds340);
        this.kno = l.getDimens(context, R.dimen.tbds62);
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
        if (this.kmQ != null) {
            this.kng = this.kmT.getWidth();
            this.dEg = this.kmT.getHeight();
            this.knh = this.kmV.getWidth();
            this.kni = this.kmZ.getWidth();
            this.knj = this.kna.getWidth();
            this.knm = this.kmZ.getHeight();
            this.knk = this.knc.getWidth();
            this.knl = this.knd.getWidth();
            this.mCursorWidth = this.knb.getWidth();
            this.mCursorHeight = this.knb.getHeight();
            this.knn = ((this.mWidth - (this.kng * 2)) - this.kni) - this.knj;
            this.knq = this.kne.getWidth();
            if (this.kmQ.kmr.kmt == 0 && this.kmQ.kms.kmt == 0) {
                this.knp = (int) ((0.5d * this.knn) + this.kni + this.kng);
            } else {
                this.knp = (int) (((((float) this.kmQ.kmr.kmt) / ((float) (this.kmQ.kmr.kmt + this.kmQ.kms.kmt))) * this.knn) + this.kni + this.kng);
            }
            float y = this.kmT.getY() - ((this.mCursorHeight - this.dEg) / 2);
            if (this.knp + (this.mCursorWidth / 2) >= this.kna.getLeft()) {
                this.knp = (this.kna.getLeft() - 10) - (this.mCursorWidth / 2);
                this.knb.layout((this.kna.getLeft() - 10) - this.mCursorWidth, (int) y, this.kna.getLeft() - 10, ((int) y) + this.mCursorHeight);
            } else if (this.knp - (this.mCursorWidth / 2) <= this.kmZ.getRight()) {
                this.knp = this.kmZ.getRight() + 10 + (this.mCursorWidth / 2);
                this.knb.layout(this.kmZ.getRight() + 10, (int) y, this.kmZ.getRight() + 10 + this.mCursorWidth, ((int) y) + this.mCursorHeight);
            } else {
                this.knb.layout(this.knp - (this.mCursorWidth / 2), (int) y, this.knp + (this.mCursorWidth / 2), ((int) y) + this.mCursorHeight);
            }
            int x = (this.mWidth / 2) - ((int) this.kmV.getX());
            if (this.knk < this.knh) {
                int i5 = (this.kng - this.knk) / 2;
                this.knc.layout(i5, (int) this.knc.getY(), this.knk + i5, ((int) this.knc.getY()) + this.knm);
            } else if (this.knk <= x) {
                this.knc.layout((int) this.kmV.getX(), (int) this.knc.getY(), ((int) this.kmV.getX()) + this.knk, ((int) this.knc.getY()) + this.knm);
            } else {
                ViewGroup.LayoutParams layoutParams = this.knc.getLayoutParams();
                layoutParams.width = x;
                this.knc.setLayoutParams(layoutParams);
                postDelayed(this.mRunnable, 300L);
            }
            if (this.knl < this.knh) {
                int x2 = ((int) this.kmU.getX()) + ((this.kng - this.knl) / 2);
                this.knd.layout(x2, (int) this.knd.getY(), this.knl + x2, ((int) this.knd.getY()) + this.knm);
            } else if (this.knl <= x) {
                this.knd.layout((this.mWidth - ((int) this.kmW.getX())) - this.knl, (int) this.knd.getY(), this.mWidth - ((int) this.kmW.getX()), ((int) this.knd.getY()) + this.knm);
            } else {
                ViewGroup.LayoutParams layoutParams2 = this.knd.getLayoutParams();
                layoutParams2.width = x;
                this.knd.setLayoutParams(layoutParams2);
                postDelayed(this.mRunnable, 300L);
            }
            int i6 = (this.kng - this.knq) / 2;
            this.kne.layout(((int) this.kmT.getX()) + i6, ((int) this.kmT.getY()) + i6, ((int) this.kmT.getX()) + i6 + this.knq, ((int) this.kmT.getY()) + i6 + this.knq);
            this.knf.layout(((int) this.kmU.getX()) + i6, ((int) this.kmU.getY()) + i6, ((int) this.kmU.getX()) + i6 + this.knq, i6 + ((int) this.kmU.getY()) + this.knq);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int i;
        int i2 = 2;
        if (TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount())) {
            LoginActivityConfig loginActivityConfig = new LoginActivityConfig(getContext());
            loginActivityConfig.getIntent().putExtra("locate_type", this.kmQ.from != 3 ? 16 : 0);
            TbadkCoreApplication.getInst().login(null, new CustomMessage<>((int) CmdConfigCustom.START_GO_ACTION, loginActivityConfig));
        } else if (this.kns == null || !this.kns.isRunning()) {
            if (this.knv == null || !this.knv.isRunning()) {
                if (this.knv == null) {
                    this.knv = ValueAnimator.ofFloat(0.0f, 2.0f);
                    this.knv.setDuration(800L);
                    this.knv.setInterpolator(new AccelerateInterpolator());
                }
                if (this.kns == null) {
                    this.kns = ValueAnimator.ofFloat(0.0f, 1.0f);
                    this.kns.setDuration(800L);
                    this.kns.setInterpolator(new AccelerateInterpolator());
                    this.knu = new a();
                    this.kns.addListener(this.knu);
                    this.kns.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.2
                        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                        public void onAnimationUpdate(ValueAnimator valueAnimator) {
                            TopicPkView.this.knt.setScaleX(((Float) valueAnimator.getAnimatedValue()).floatValue());
                            TopicPkView.this.knt.setScaleY(((Float) valueAnimator.getAnimatedValue()).floatValue());
                        }
                    });
                }
                if (cUm()) {
                    i = 1;
                } else {
                    i = cUn() ? 2 : 0;
                }
                if (view == this.kmT) {
                    sk(1 != i);
                    sl(false);
                    i2 = 1;
                } else if (view == this.kmU) {
                    sl(2 != i);
                    sk(false);
                } else {
                    i2 = 0;
                }
                TiebaStatic.log(new aq("c13352").an("obj_type", i2).w("topic_id", this.kmQ.topicId).an("obj_source", this.kmQ.from));
                if (this.knC != null) {
                    this.knC.Dt(i2 == i ? 0 : i2);
                }
                RequestBlessMessage requestBlessMessage = new RequestBlessMessage();
                requestBlessMessage.setPkId(Long.valueOf(this.kmQ.pkId));
                requestBlessMessage.setTopicId(Long.valueOf(this.kmQ.topicId));
                requestBlessMessage.setPkIndex(i2);
                requestBlessMessage.setClickType(i == 0 ? 0 : 1);
                requestBlessMessage.setPkType(0);
                requestBlessMessage.setUserPkId(this.kmQ.userPkId);
                MessageManager.getInstance().sendMessage(requestBlessMessage);
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void dispatchDraw(Canvas canvas) {
        if (this.kmQ != null) {
            af(canvas);
            super.dispatchDraw(canvas);
        }
    }

    private void af(Canvas canvas) {
        float y = this.kmT.getY() + ((this.dEg - this.kno) / 2);
        this.mPaint.setShader(new LinearGradient(this.kng / 2, y, this.knp, y, ao.getColor(R.color.topic_pk_agree_bar_start_color), ao.getColor(R.color.topic_pk_agree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.kng / 2, y, this.knp, y + this.kno, this.mPaint);
        this.mPaint.setShader(new LinearGradient(this.knp, y, this.mWidth - (this.kng / 2), y, ao.getColor(R.color.topic_pk_disagree_bar_start_color), ao.getColor(R.color.topic_pk_disagree_bar_end_color), Shader.TileMode.REPEAT));
        canvas.drawRect(this.knp, y, this.mWidth - (this.kng / 2), y + this.kno, this.mPaint);
    }

    public void setUserColor(int i) {
        this.knr = i;
    }

    public void setData(com.baidu.tieba.homepage.topic.topictab.b.b bVar) {
        if (bVar == null || bVar.kmr == null || bVar.kms == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        this.kmQ = bVar;
        this.kmZ.setText(String.valueOf(bVar.kmr.kmt));
        this.kna.setText(String.valueOf(bVar.kms.kmt));
        this.knA = new RelativeLayout.LayoutParams(-2, -2);
        this.knA.addRule(12);
        this.knB = new RelativeLayout.LayoutParams(-2, -2);
        this.knB.addRule(12);
        this.knB.addRule(11);
        this.knc.setLayoutParams(this.knA);
        this.knd.setLayoutParams(this.knB);
        if (bVar.from == 3) {
            this.knc.setText(StringUtils.isNull(bVar.kmr.kmu) ? getResources().getString(R.string.topic_pk_desc_agree_default) : bVar.kmr.kmu);
            this.knd.setText(StringUtils.isNull(bVar.kms.kmu) ? getResources().getString(R.string.topic_pk_desc_disagree_default) : bVar.kms.kmu);
            if (StringUtils.isNull(bVar.kmr.kmv)) {
                this.kmR.setVisibility(4);
            } else {
                this.kmR.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kmr.kmv));
            }
            if (StringUtils.isNull(bVar.kms.kmv)) {
                this.kmS.setVisibility(4);
            } else {
                this.kmS.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kms.kmv));
            }
        } else {
            this.knc.setText(bVar.kmr.kmu);
            this.knd.setText(bVar.kms.kmu);
            this.kmR.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kmr.kmv));
            this.kmS.setText(String.format(getContext().getString(R.string.topic_pk_user), bVar.kms.kmv));
        }
        this.kmV.startLoad(bVar.kmr.kmw, 10, false);
        this.kmW.startLoad(bVar.kms.kmw, 10, false);
        this.kmX.startLoad(bVar.kmr.kmz, 10, false);
        this.kmY.startLoad(bVar.kms.kmz, 10, false);
        if (bVar.kmr.kmx) {
            this.kmV.setVisibility(4);
            this.kmX.setVisibility(0);
        } else {
            this.kmV.setVisibility(0);
            this.kmX.setVisibility(4);
        }
        if (bVar.kms.kmx) {
            this.kmW.setVisibility(4);
            this.kmY.setVisibility(0);
        } else {
            this.kmW.setVisibility(0);
            this.kmY.setVisibility(4);
        }
        invalidate();
    }

    public void onChangeSkinType() {
        ao.setViewTextColor(this.kmR, this.knr);
        ao.setViewTextColor(this.kmS, this.knr);
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            this.kmV.setIsNight(this.mSkinType == 1);
            this.kmW.setIsNight(this.mSkinType == 1);
            this.kmX.setIsNight(this.mSkinType == 1);
            this.kmY.setIsNight(this.mSkinType == 1);
            ao.setBackgroundResource(this.kmT, R.drawable.btn_topic_agree_bg_red);
            ao.setBackgroundResource(this.kmU, R.drawable.btn_topic_disagree_bg_blue);
            ao.setImageResource(this.kne, R.drawable.pic_topic_addone);
            ao.setImageResource(this.knf, R.drawable.pic_topic_addone);
            ao.setImageResource(this.knb, R.drawable.pic_topic_vs_bginone);
            ao.setViewTextColor(this.kmZ, R.color.CAM_X0101);
            ao.setViewTextColor(this.kna, R.color.CAM_X0101);
            ao.setViewTextColor(this.knc, R.color.topic_agree_des_color);
            ao.setViewTextColor(this.knd, R.color.topic_disagree_des_color);
        }
    }

    private void sk(boolean z) {
        if (z) {
            this.kmR.setVisibility(0);
            this.kmR.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.kmQ.kmr.kmv = TbadkCoreApplication.getCurrentAccountNameShow();
            this.kmQ.kmr.kmx = true;
            TextView textView = this.kmZ;
            b.a aVar = this.kmQ.kmr;
            long j = aVar.kmt + 1;
            aVar.kmt = j;
            textView.setText(String.valueOf(j));
            this.kne.setVisibility(0);
            this.knt = this.kmX;
            this.knu.knF = this.kmX;
            this.knu.knG = this.kmV;
            this.kne.setVisibility(0);
            this.kns.start();
            this.knw = this.kne.getX();
            this.knx = this.kne.getY();
            this.kny = this.kne.getX();
            this.knz = this.kne.getY();
            this.knv.removeAllUpdateListeners();
            this.knv.addUpdateListener(this.knD);
            this.knv.setFloatValues(0.0f, 2.0f);
            this.knv.start();
            return;
        }
        if (at.equals(this.kmQ.kmr.kmv, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.kmR.setVisibility(4);
        }
        if (this.kmQ.kmr.kmx) {
            this.kmQ.kmr.kmx = false;
            TextView textView2 = this.kmZ;
            b.a aVar2 = this.kmQ.kmr;
            long j2 = aVar2.kmt - 1;
            aVar2.kmt = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.kmV.setVisibility(0);
        this.kmX.setVisibility(4);
    }

    private void sl(boolean z) {
        if (z) {
            this.kmS.setText(String.format(getContext().getString(R.string.topic_pk_user), TbadkCoreApplication.getCurrentAccountNameShow()));
            this.kmS.setVisibility(0);
            this.kmQ.kms.kmv = TbadkCoreApplication.getCurrentAccountNameShow();
            this.knf.setVisibility(0);
            this.kmQ.kms.kmx = true;
            TextView textView = this.kna;
            b.a aVar = this.kmQ.kms;
            long j = aVar.kmt + 1;
            aVar.kmt = j;
            textView.setText(String.valueOf(j));
            this.knw = this.knf.getX() - (this.knq / 2.0f);
            this.knt = this.kmY;
            this.knu.knF = this.kmY;
            this.knu.knG = this.kmW;
            this.kne.setVisibility(0);
            this.kns.start();
            this.knw = this.knf.getX() - (this.knq / 2);
            this.knx = this.knf.getY();
            this.kny = this.knf.getX();
            this.knz = this.knf.getY();
            this.knv.removeAllUpdateListeners();
            this.knv.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.baidu.tieba.homepage.topic.topictab.view.TopicPkView.4
                @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                    if (floatValue < 1.0f) {
                        TopicPkView.this.knf.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.knw) + (2.0f * floatValue * (1.0f - floatValue) * ((TopicPkView.this.mWidth - TopicPkView.this.kng) + 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.kng / 2)))));
                        TopicPkView.this.knf.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * TopicPkView.this.knx) + (2.0f * floatValue * (1.0f - floatValue) * 70.0f) + (Math.pow(floatValue, 2.0d) * 60.0d)));
                    } else {
                        floatValue -= 1.0f;
                        TopicPkView.this.knf.setX((float) ((Math.pow(1.0f - floatValue, 2.0d) * (TopicPkView.this.mWidth - (TopicPkView.this.kng / 2))) + (2.0f * floatValue * (1.0f - floatValue) * (TopicPkView.this.mWidth - 45)) + (Math.pow(floatValue, 2.0d) * (TopicPkView.this.mWidth - 120))));
                        TopicPkView.this.knf.setY((float) ((Math.pow(1.0f - floatValue, 2.0d) * 60.0d) + (2.0f * floatValue * (1.0f - floatValue) * 50.0f) + (Math.pow(floatValue, 2.0d) * 40.0d)));
                    }
                    if (floatValue == 1.0f) {
                        TopicPkView.this.knf.setVisibility(4);
                        TopicPkView.this.knf.setX(TopicPkView.this.kny);
                        TopicPkView.this.knf.setY(TopicPkView.this.knz);
                    }
                }
            });
            this.knv.setFloatValues(0.0f, 2.0f);
            this.knv.start();
            return;
        }
        if (at.equals(this.kmQ.kms.kmv, TbadkCoreApplication.getCurrentAccountNameShow())) {
            this.kmS.setVisibility(4);
        }
        if (this.kmQ.kms.kmx) {
            this.kmQ.kms.kmx = false;
            TextView textView2 = this.kna;
            b.a aVar2 = this.kmQ.kms;
            long j2 = aVar2.kmt - 1;
            aVar2.kmt = j2;
            textView2.setText(String.valueOf(j2));
        }
        this.knf.setVisibility(4);
        this.kmW.setVisibility(0);
        this.kmY.setVisibility(4);
    }

    private boolean cUm() {
        return (this.kmQ == null || this.kmQ.kmr == null || !this.kmQ.kmr.kmx) ? false : true;
    }

    private boolean cUn() {
        return (this.kmQ == null || this.kmQ.kms == null || !this.kmQ.kms.kmx) ? false : true;
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        if (this.kns != null) {
            this.kns.cancel();
        }
        if (this.knv != null) {
            this.knv.cancel();
        }
        removeCallbacks(this.mRunnable);
        super.onDetachedFromWindow();
    }

    public void setPkClickListener(b bVar) {
        if (bVar != null) {
            this.knC = bVar;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public static class a implements Animator.AnimatorListener {
        private View knF;
        private View knG;

        private a() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            if (this.knF != null) {
                this.knF.setVisibility(0);
            }
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            if (this.knG != null) {
                this.knG.setVisibility(8);
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
