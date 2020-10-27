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
    private TbPageContext<HotTopicActivity> eCn;
    private ImageView jMX;
    private LinearLayout jMY;
    private TextView jMZ;
    private View jNa;
    private AnimationDrawable jNb;
    private Animation jNc;
    private Animation jNd;
    private Animation jNe;
    private Animation jNf;
    private boolean jNg = false;
    private boolean jNh = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eCn = tbPageContext;
        this.jMX = (ImageView) view.findViewById(R.id.gif_image);
        this.jMY = (LinearLayout) view.findViewById(R.id.gif_group);
        this.jMZ = (TextView) view.findViewById(R.id.git_desc);
        this.jNa = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.jNg) {
            this.jMY.setVisibility(i);
            if (i != 8) {
                this.jMZ.setText(at.numFormatOverWan(j));
                this.jNh = z;
                if (this.jNh) {
                    if (i2 == 1) {
                        this.jMZ.setVisibility(0);
                        ap.setImageResource(this.jMX, R.drawable.bless_gif);
                    } else {
                        this.jMZ.setVisibility(8);
                        ap.setImageResource(this.jMX, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.jMZ.getLayoutParams()).setMargins(this.eCn.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eCn.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.jMZ, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.jMZ, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.jMZ.setVisibility(0);
                        ap.setImageResource(this.jMX, R.drawable.candle_gif);
                    } else {
                        this.jMZ.setVisibility(8);
                        ap.setImageResource(this.jMX, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.jMZ.getLayoutParams()).setMargins(this.eCn.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eCn.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.jMZ, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.jMZ, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.jMY.clearAnimation();
                    this.jNb = (AnimationDrawable) this.jMX.getDrawable();
                    this.jNb.start();
                } else {
                    this.jNa.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jMY.getAnimation() == e.this.jNc) {
                                e.this.jMY.clearAnimation();
                                return;
                            }
                            e.this.jMZ.setVisibility(0);
                            e.this.jMZ.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jNh) {
                                ap.setImageResource(e.this.jMX, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jMX, R.drawable.candle_gif);
                            }
                            e.this.jNb = (AnimationDrawable) e.this.jMX.getDrawable();
                            e.this.jNb.start();
                            e.this.jMY.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jMY.getAnimation() != e.this.jNe) {
                                        e.this.jMY.startAnimation(e.this.jNe);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eCn.getOrignalPage()).cKe();
                        }
                    });
                    this.jMY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jMY.getAnimation() == e.this.jNc) {
                                e.this.jMY.clearAnimation();
                                return;
                            }
                            e.this.jMZ.setVisibility(0);
                            e.this.jMZ.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jNh) {
                                ap.setImageResource(e.this.jMX, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jMX, R.drawable.candle_gif);
                            }
                            e.this.jNb = (AnimationDrawable) e.this.jMX.getDrawable();
                            e.this.jNb.start();
                            e.this.jMY.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jMY.getAnimation() != e.this.jNe) {
                                        e.this.jMY.startAnimation(e.this.jNe);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eCn.getOrignalPage()).cKe();
                        }
                    });
                }
                this.jNg = true;
                this.jNc = AnimationUtils.loadAnimation(this.eCn.getPageActivity(), R.anim.gifview_rotate);
                this.jNd = AnimationUtils.loadAnimation(this.eCn.getPageActivity(), R.anim.gifview_rotate_out);
                this.jNe = AnimationUtils.loadAnimation(this.eCn.getPageActivity(), R.anim.gifview_alpha);
                this.jNf = AnimationUtils.loadAnimation(this.eCn.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void BZ(int i) {
        if (this.jNg) {
            this.index = i;
            if (this.jMX.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.jMY.getAnimation() != this.jNf) {
                        this.jMY.startAnimation(this.jNf);
                        this.jNb.start();
                    }
                } else if (this.jMY.getAnimation() != this.jNe) {
                    this.jMY.startAnimation(this.jNe);
                    this.jNb.stop();
                }
            } else if (this.index >= 2) {
                if (this.jMY.getAnimation() != this.jNc) {
                    this.jMY.startAnimation(this.jNc);
                }
            } else if (this.jMY.getAnimation() == this.jNc) {
                this.jMY.startAnimation(this.jNd);
            }
        }
    }

    public void clearAnimation() {
        this.jMX.clearAnimation();
        this.jMY.clearAnimation();
        if (this.jNc != null) {
            this.jNc.cancel();
        }
        if (this.jNd != null) {
            this.jNd.cancel();
        }
        if (this.jNe != null) {
            this.jNe.cancel();
        }
        if (this.jNf != null) {
            this.jNf.cancel();
        }
        if (this.jNb != null) {
            this.jNb.stop();
        }
    }
}
