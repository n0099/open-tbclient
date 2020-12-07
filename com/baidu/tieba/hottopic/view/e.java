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
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes21.dex */
public class e {
    private TbPageContext<HotTopicActivity> eNx;
    private ImageView khi;
    private LinearLayout khj;
    private TextView khk;
    private View khl;
    private AnimationDrawable khm;
    private Animation khn;
    private Animation kho;
    private Animation khp;
    private Animation khq;
    private boolean khr = false;
    private boolean khs = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eNx = tbPageContext;
        this.khi = (ImageView) view.findViewById(R.id.gif_image);
        this.khj = (LinearLayout) view.findViewById(R.id.gif_group);
        this.khk = (TextView) view.findViewById(R.id.git_desc);
        this.khl = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.khr) {
            this.khj.setVisibility(i);
            if (i != 8) {
                this.khk.setText(au.numFormatOverWan(j));
                this.khs = z;
                if (this.khs) {
                    if (i2 == 1) {
                        this.khk.setVisibility(0);
                        ap.setImageResource(this.khi, R.drawable.bless_gif);
                    } else {
                        this.khk.setVisibility(8);
                        ap.setImageResource(this.khi, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.khk.getLayoutParams()).setMargins(this.eNx.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eNx.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.khk, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.khk, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.khk.setVisibility(0);
                        ap.setImageResource(this.khi, R.drawable.candle_gif);
                    } else {
                        this.khk.setVisibility(8);
                        ap.setImageResource(this.khi, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.khk.getLayoutParams()).setMargins(this.eNx.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eNx.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.khk, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.khk, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.khj.clearAnimation();
                    this.khm = (AnimationDrawable) this.khi.getDrawable();
                    this.khm.start();
                } else {
                    this.khl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.khj.getAnimation() == e.this.khn) {
                                e.this.khj.clearAnimation();
                                return;
                            }
                            e.this.khk.setVisibility(0);
                            e.this.khk.setText(au.numFormatOverWan(j + 1));
                            if (e.this.khs) {
                                ap.setImageResource(e.this.khi, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.khi, R.drawable.candle_gif);
                            }
                            e.this.khm = (AnimationDrawable) e.this.khi.getDrawable();
                            e.this.khm.start();
                            e.this.khj.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.khj.getAnimation() != e.this.khp) {
                                        e.this.khj.startAnimation(e.this.khp);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eNx.getOrignalPage()).cRA();
                        }
                    });
                    this.khj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.khj.getAnimation() == e.this.khn) {
                                e.this.khj.clearAnimation();
                                return;
                            }
                            e.this.khk.setVisibility(0);
                            e.this.khk.setText(au.numFormatOverWan(j + 1));
                            if (e.this.khs) {
                                ap.setImageResource(e.this.khi, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.khi, R.drawable.candle_gif);
                            }
                            e.this.khm = (AnimationDrawable) e.this.khi.getDrawable();
                            e.this.khm.start();
                            e.this.khj.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.khj.getAnimation() != e.this.khp) {
                                        e.this.khj.startAnimation(e.this.khp);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eNx.getOrignalPage()).cRA();
                        }
                    });
                }
                this.khr = true;
                this.khn = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.gifview_rotate);
                this.kho = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.gifview_rotate_out);
                this.khp = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.gifview_alpha);
                this.khq = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void Dz(int i) {
        if (this.khr) {
            this.index = i;
            if (this.khi.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.khj.getAnimation() != this.khq) {
                        this.khj.startAnimation(this.khq);
                        this.khm.start();
                    }
                } else if (this.khj.getAnimation() != this.khp) {
                    this.khj.startAnimation(this.khp);
                    this.khm.stop();
                }
            } else if (this.index >= 2) {
                if (this.khj.getAnimation() != this.khn) {
                    this.khj.startAnimation(this.khn);
                }
            } else if (this.khj.getAnimation() == this.khn) {
                this.khj.startAnimation(this.kho);
            }
        }
    }

    public void clearAnimation() {
        this.khi.clearAnimation();
        this.khj.clearAnimation();
        if (this.khn != null) {
            this.khn.cancel();
        }
        if (this.kho != null) {
            this.kho.cancel();
        }
        if (this.khp != null) {
            this.khp.cancel();
        }
        if (this.khq != null) {
            this.khq.cancel();
        }
        if (this.khm != null) {
            this.khm.stop();
        }
    }
}
