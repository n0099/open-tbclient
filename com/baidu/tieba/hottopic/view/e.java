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
    private TbPageContext<HotTopicActivity> etO;
    private TextView jAA;
    private View jAB;
    private AnimationDrawable jAC;
    private Animation jAD;
    private Animation jAE;
    private Animation jAF;
    private Animation jAG;
    private ImageView jAy;
    private LinearLayout jAz;
    private boolean jAH = false;
    private boolean jAI = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.etO = tbPageContext;
        this.jAy = (ImageView) view.findViewById(R.id.gif_image);
        this.jAz = (LinearLayout) view.findViewById(R.id.gif_group);
        this.jAA = (TextView) view.findViewById(R.id.git_desc);
        this.jAB = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.jAH) {
            this.jAz.setVisibility(i);
            if (i != 8) {
                this.jAA.setText(at.numFormatOverWan(j));
                this.jAI = z;
                if (this.jAI) {
                    if (i2 == 1) {
                        this.jAA.setVisibility(0);
                        ap.setImageResource(this.jAy, R.drawable.bless_gif);
                    } else {
                        this.jAA.setVisibility(8);
                        ap.setImageResource(this.jAy, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.jAA.getLayoutParams()).setMargins(this.etO.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.etO.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.jAA, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.jAA, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.jAA.setVisibility(0);
                        ap.setImageResource(this.jAy, R.drawable.candle_gif);
                    } else {
                        this.jAA.setVisibility(8);
                        ap.setImageResource(this.jAy, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.jAA.getLayoutParams()).setMargins(this.etO.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.etO.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.jAA, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.jAA, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.jAz.clearAnimation();
                    this.jAC = (AnimationDrawable) this.jAy.getDrawable();
                    this.jAC.start();
                } else {
                    this.jAB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jAz.getAnimation() == e.this.jAD) {
                                e.this.jAz.clearAnimation();
                                return;
                            }
                            e.this.jAA.setVisibility(0);
                            e.this.jAA.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jAI) {
                                ap.setImageResource(e.this.jAy, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jAy, R.drawable.candle_gif);
                            }
                            e.this.jAC = (AnimationDrawable) e.this.jAy.getDrawable();
                            e.this.jAC.start();
                            e.this.jAz.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jAz.getAnimation() != e.this.jAF) {
                                        e.this.jAz.startAnimation(e.this.jAF);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.etO.getOrignalPage()).cGX();
                        }
                    });
                    this.jAz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jAz.getAnimation() == e.this.jAD) {
                                e.this.jAz.clearAnimation();
                                return;
                            }
                            e.this.jAA.setVisibility(0);
                            e.this.jAA.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jAI) {
                                ap.setImageResource(e.this.jAy, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jAy, R.drawable.candle_gif);
                            }
                            e.this.jAC = (AnimationDrawable) e.this.jAy.getDrawable();
                            e.this.jAC.start();
                            e.this.jAz.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jAz.getAnimation() != e.this.jAF) {
                                        e.this.jAz.startAnimation(e.this.jAF);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.etO.getOrignalPage()).cGX();
                        }
                    });
                }
                this.jAH = true;
                this.jAD = AnimationUtils.loadAnimation(this.etO.getPageActivity(), R.anim.gifview_rotate);
                this.jAE = AnimationUtils.loadAnimation(this.etO.getPageActivity(), R.anim.gifview_rotate_out);
                this.jAF = AnimationUtils.loadAnimation(this.etO.getPageActivity(), R.anim.gifview_alpha);
                this.jAG = AnimationUtils.loadAnimation(this.etO.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void BG(int i) {
        if (this.jAH) {
            this.index = i;
            if (this.jAy.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.jAz.getAnimation() != this.jAG) {
                        this.jAz.startAnimation(this.jAG);
                        this.jAC.start();
                    }
                } else if (this.jAz.getAnimation() != this.jAF) {
                    this.jAz.startAnimation(this.jAF);
                    this.jAC.stop();
                }
            } else if (this.index >= 2) {
                if (this.jAz.getAnimation() != this.jAD) {
                    this.jAz.startAnimation(this.jAD);
                }
            } else if (this.jAz.getAnimation() == this.jAD) {
                this.jAz.startAnimation(this.jAE);
            }
        }
    }

    public void clearAnimation() {
        this.jAy.clearAnimation();
        this.jAz.clearAnimation();
        if (this.jAD != null) {
            this.jAD.cancel();
        }
        if (this.jAE != null) {
            this.jAE.cancel();
        }
        if (this.jAF != null) {
            this.jAF.cancel();
        }
        if (this.jAG != null) {
            this.jAG.cancel();
        }
        if (this.jAC != null) {
            this.jAC.stop();
        }
    }
}
