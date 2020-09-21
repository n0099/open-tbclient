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
/* loaded from: classes20.dex */
public class e {
    private TbPageContext<HotTopicActivity> ehG;
    private ImageView jlA;
    private LinearLayout jlB;
    private TextView jlC;
    private View jlD;
    private AnimationDrawable jlE;
    private Animation jlF;
    private Animation jlG;
    private Animation jlH;
    private Animation jlI;
    private boolean jlJ = false;
    private boolean jlK = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.ehG = tbPageContext;
        this.jlA = (ImageView) view.findViewById(R.id.gif_image);
        this.jlB = (LinearLayout) view.findViewById(R.id.gif_group);
        this.jlC = (TextView) view.findViewById(R.id.git_desc);
        this.jlD = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.jlJ) {
            this.jlB.setVisibility(i);
            if (i != 8) {
                this.jlC.setText(at.numFormatOverWan(j));
                this.jlK = z;
                if (this.jlK) {
                    if (i2 == 1) {
                        this.jlC.setVisibility(0);
                        ap.setImageResource(this.jlA, R.drawable.bless_gif);
                    } else {
                        this.jlC.setVisibility(8);
                        ap.setImageResource(this.jlA, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.jlC.getLayoutParams()).setMargins(this.ehG.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.ehG.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.jlC, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.jlC, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.jlC.setVisibility(0);
                        ap.setImageResource(this.jlA, R.drawable.candle_gif);
                    } else {
                        this.jlC.setVisibility(8);
                        ap.setImageResource(this.jlA, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.jlC.getLayoutParams()).setMargins(this.ehG.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.ehG.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.jlC, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.jlC, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.jlB.clearAnimation();
                    this.jlE = (AnimationDrawable) this.jlA.getDrawable();
                    this.jlE.start();
                } else {
                    this.jlD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jlB.getAnimation() == e.this.jlF) {
                                e.this.jlB.clearAnimation();
                                return;
                            }
                            e.this.jlC.setVisibility(0);
                            e.this.jlC.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jlK) {
                                ap.setImageResource(e.this.jlA, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jlA, R.drawable.candle_gif);
                            }
                            e.this.jlE = (AnimationDrawable) e.this.jlA.getDrawable();
                            e.this.jlE.start();
                            e.this.jlB.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jlB.getAnimation() != e.this.jlH) {
                                        e.this.jlB.startAnimation(e.this.jlH);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.ehG.getOrignalPage()).cDo();
                        }
                    });
                    this.jlB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jlB.getAnimation() == e.this.jlF) {
                                e.this.jlB.clearAnimation();
                                return;
                            }
                            e.this.jlC.setVisibility(0);
                            e.this.jlC.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jlK) {
                                ap.setImageResource(e.this.jlA, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jlA, R.drawable.candle_gif);
                            }
                            e.this.jlE = (AnimationDrawable) e.this.jlA.getDrawable();
                            e.this.jlE.start();
                            e.this.jlB.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jlB.getAnimation() != e.this.jlH) {
                                        e.this.jlB.startAnimation(e.this.jlH);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.ehG.getOrignalPage()).cDo();
                        }
                    });
                }
                this.jlJ = true;
                this.jlF = AnimationUtils.loadAnimation(this.ehG.getPageActivity(), R.anim.gifview_rotate);
                this.jlG = AnimationUtils.loadAnimation(this.ehG.getPageActivity(), R.anim.gifview_rotate_out);
                this.jlH = AnimationUtils.loadAnimation(this.ehG.getPageActivity(), R.anim.gifview_alpha);
                this.jlI = AnimationUtils.loadAnimation(this.ehG.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void Ba(int i) {
        if (this.jlJ) {
            this.index = i;
            if (this.jlA.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.jlB.getAnimation() != this.jlI) {
                        this.jlB.startAnimation(this.jlI);
                        this.jlE.start();
                    }
                } else if (this.jlB.getAnimation() != this.jlH) {
                    this.jlB.startAnimation(this.jlH);
                    this.jlE.stop();
                }
            } else if (this.index >= 2) {
                if (this.jlB.getAnimation() != this.jlF) {
                    this.jlB.startAnimation(this.jlF);
                }
            } else if (this.jlB.getAnimation() == this.jlF) {
                this.jlB.startAnimation(this.jlG);
            }
        }
    }

    public void clearAnimation() {
        this.jlA.clearAnimation();
        this.jlB.clearAnimation();
        if (this.jlF != null) {
            this.jlF.cancel();
        }
        if (this.jlG != null) {
            this.jlG.cancel();
        }
        if (this.jlH != null) {
            this.jlH.cancel();
        }
        if (this.jlI != null) {
            this.jlI.cancel();
        }
        if (this.jlE != null) {
            this.jlE.stop();
        }
    }
}
