package com.baidu.tieba.hottopic.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes21.dex */
public class e {
    private TbPageContext<HotTopicActivity> eIc;
    private ImageView jSU;
    private LinearLayout jSV;
    private TextView jSW;
    private View jSX;
    private AnimationDrawable jSY;
    private Animation jSZ;
    private Animation jTa;
    private Animation jTb;
    private Animation jTc;
    private boolean jTd = false;
    private boolean jTe = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eIc = tbPageContext;
        this.jSU = (ImageView) view.findViewById(R.id.gif_image);
        this.jSV = (LinearLayout) view.findViewById(R.id.gif_group);
        this.jSW = (TextView) view.findViewById(R.id.git_desc);
        this.jSX = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.jTd) {
            this.jSV.setVisibility(i);
            if (i != 8) {
                this.jSW.setText(at.numFormatOverWan(j));
                this.jTe = z;
                if (this.jTe) {
                    if (i2 == 1) {
                        this.jSW.setVisibility(0);
                        ap.setImageResource(this.jSU, R.drawable.bless_gif);
                    } else {
                        this.jSW.setVisibility(8);
                        ap.setImageResource(this.jSU, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.jSW.getLayoutParams()).setMargins(this.eIc.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eIc.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.jSW, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.jSW, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.jSW.setVisibility(0);
                        ap.setImageResource(this.jSU, R.drawable.candle_gif);
                    } else {
                        this.jSW.setVisibility(8);
                        ap.setImageResource(this.jSU, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.jSW.getLayoutParams()).setMargins(this.eIc.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eIc.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.jSW, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.jSW, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.jSV.clearAnimation();
                    this.jSY = (AnimationDrawable) this.jSU.getDrawable();
                    this.jSY.start();
                } else {
                    this.jSX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jSV.getAnimation() == e.this.jSZ) {
                                e.this.jSV.clearAnimation();
                                return;
                            }
                            e.this.jSW.setVisibility(0);
                            e.this.jSW.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jTe) {
                                ap.setImageResource(e.this.jSU, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jSU, R.drawable.candle_gif);
                            }
                            e.this.jSY = (AnimationDrawable) e.this.jSU.getDrawable();
                            e.this.jSY.start();
                            e.this.jSV.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jSV.getAnimation() != e.this.jTb) {
                                        e.this.jSV.startAnimation(e.this.jTb);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eIc.getOrignalPage()).cMF();
                        }
                    });
                    this.jSV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jSV.getAnimation() == e.this.jSZ) {
                                e.this.jSV.clearAnimation();
                                return;
                            }
                            e.this.jSW.setVisibility(0);
                            e.this.jSW.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jTe) {
                                ap.setImageResource(e.this.jSU, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jSU, R.drawable.candle_gif);
                            }
                            e.this.jSY = (AnimationDrawable) e.this.jSU.getDrawable();
                            e.this.jSY.start();
                            e.this.jSV.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jSV.getAnimation() != e.this.jTb) {
                                        e.this.jSV.startAnimation(e.this.jTb);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eIc.getOrignalPage()).cMF();
                        }
                    });
                }
                this.jTd = true;
                this.jSZ = AnimationUtils.loadAnimation(this.eIc.getPageActivity(), R.anim.gifview_rotate);
                this.jTa = AnimationUtils.loadAnimation(this.eIc.getPageActivity(), R.anim.gifview_rotate_out);
                this.jTb = AnimationUtils.loadAnimation(this.eIc.getPageActivity(), R.anim.gifview_alpha);
                this.jTc = AnimationUtils.loadAnimation(this.eIc.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void Cm(int i) {
        if (this.jTd) {
            this.index = i;
            if (this.jSU.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.jSV.getAnimation() != this.jTc) {
                        this.jSV.startAnimation(this.jTc);
                        this.jSY.start();
                    }
                } else if (this.jSV.getAnimation() != this.jTb) {
                    this.jSV.startAnimation(this.jTb);
                    this.jSY.stop();
                }
            } else if (this.index >= 2) {
                if (this.jSV.getAnimation() != this.jSZ) {
                    this.jSV.startAnimation(this.jSZ);
                }
            } else if (this.jSV.getAnimation() == this.jSZ) {
                this.jSV.startAnimation(this.jTa);
            }
        }
    }

    public void clearAnimation() {
        this.jSU.clearAnimation();
        this.jSV.clearAnimation();
        if (this.jSZ != null) {
            this.jSZ.cancel();
        }
        if (this.jTa != null) {
            this.jTa.cancel();
        }
        if (this.jTb != null) {
            this.jTb.cancel();
        }
        if (this.jTc != null) {
            this.jTc.cancel();
        }
        if (this.jSY != null) {
            this.jSY.stop();
        }
    }
}
