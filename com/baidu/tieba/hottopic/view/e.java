package com.baidu.tieba.hottopic.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes7.dex */
public class e {
    private TbPageContext<HotTopicActivity> eSJ;
    private ImageView kpR;
    private LinearLayout kpS;
    private TextView kpT;
    private View kpU;
    private AnimationDrawable kpV;
    private Animation kpW;
    private Animation kpX;
    private Animation kpY;
    private Animation kpZ;
    private boolean kqa = false;
    private boolean kqb = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eSJ = tbPageContext;
        this.kpR = (ImageView) view.findViewById(R.id.gif_image);
        this.kpS = (LinearLayout) view.findViewById(R.id.gif_group);
        this.kpT = (TextView) view.findViewById(R.id.git_desc);
        this.kpU = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.kqa) {
            this.kpS.setVisibility(i);
            if (i != 8) {
                this.kpT.setText(at.numFormatOverWan(j));
                this.kqb = z;
                if (this.kqb) {
                    if (i2 == 1) {
                        this.kpT.setVisibility(0);
                        ao.setImageResource(this.kpR, R.drawable.bless_gif);
                    } else {
                        this.kpT.setVisibility(8);
                        ao.setImageResource(this.kpR, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.kpT.getLayoutParams()).setMargins(this.eSJ.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eSJ.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ao.setViewTextColor(this.kpT, R.color.topic_bless_text, 1);
                    ao.setBackgroundResource(this.kpT, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.kpT.setVisibility(0);
                        ao.setImageResource(this.kpR, R.drawable.candle_gif);
                    } else {
                        this.kpT.setVisibility(8);
                        ao.setImageResource(this.kpR, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.kpT.getLayoutParams()).setMargins(this.eSJ.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eSJ.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ao.setViewTextColor(this.kpT, R.color.topic_candle_text, 1);
                    ao.setBackgroundResource(this.kpT, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.kpS.clearAnimation();
                    this.kpV = (AnimationDrawable) this.kpR.getDrawable();
                    this.kpV.start();
                } else {
                    this.kpU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kpS.getAnimation() == e.this.kpW) {
                                e.this.kpS.clearAnimation();
                                return;
                            }
                            e.this.kpT.setVisibility(0);
                            e.this.kpT.setText(at.numFormatOverWan(j + 1));
                            if (e.this.kqb) {
                                ao.setImageResource(e.this.kpR, R.drawable.bless_gif);
                            } else {
                                ao.setImageResource(e.this.kpR, R.drawable.candle_gif);
                            }
                            e.this.kpV = (AnimationDrawable) e.this.kpR.getDrawable();
                            e.this.kpV.start();
                            e.this.kpS.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kpS.getAnimation() != e.this.kpY) {
                                        e.this.kpS.startAnimation(e.this.kpY);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eSJ.getOrignalPage()).cQQ();
                        }
                    });
                    this.kpS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kpS.getAnimation() == e.this.kpW) {
                                e.this.kpS.clearAnimation();
                                return;
                            }
                            e.this.kpT.setVisibility(0);
                            e.this.kpT.setText(at.numFormatOverWan(j + 1));
                            if (e.this.kqb) {
                                ao.setImageResource(e.this.kpR, R.drawable.bless_gif);
                            } else {
                                ao.setImageResource(e.this.kpR, R.drawable.candle_gif);
                            }
                            e.this.kpV = (AnimationDrawable) e.this.kpR.getDrawable();
                            e.this.kpV.start();
                            e.this.kpS.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kpS.getAnimation() != e.this.kpY) {
                                        e.this.kpS.startAnimation(e.this.kpY);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eSJ.getOrignalPage()).cQQ();
                        }
                    });
                }
                this.kqa = true;
                this.kpW = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.gifview_rotate);
                this.kpX = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.gifview_rotate_out);
                this.kpY = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.gifview_alpha);
                this.kpZ = AnimationUtils.loadAnimation(this.eSJ.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void Cg(int i) {
        if (this.kqa) {
            this.index = i;
            if (this.kpR.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.kpS.getAnimation() != this.kpZ) {
                        this.kpS.startAnimation(this.kpZ);
                        this.kpV.start();
                    }
                } else if (this.kpS.getAnimation() != this.kpY) {
                    this.kpS.startAnimation(this.kpY);
                    this.kpV.stop();
                }
            } else if (this.index >= 2) {
                if (this.kpS.getAnimation() != this.kpW) {
                    this.kpS.startAnimation(this.kpW);
                }
            } else if (this.kpS.getAnimation() == this.kpW) {
                this.kpS.startAnimation(this.kpX);
            }
        }
    }

    public void clearAnimation() {
        this.kpR.clearAnimation();
        this.kpS.clearAnimation();
        if (this.kpW != null) {
            this.kpW.cancel();
        }
        if (this.kpX != null) {
            this.kpX.cancel();
        }
        if (this.kpY != null) {
            this.kpY.cancel();
        }
        if (this.kpZ != null) {
            this.kpZ.cancel();
        }
        if (this.kpV != null) {
            this.kpV.stop();
        }
    }
}
