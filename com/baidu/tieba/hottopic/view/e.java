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
    private ImageView khk;
    private LinearLayout khl;
    private TextView khm;
    private View khn;
    private AnimationDrawable kho;
    private Animation khp;
    private Animation khq;
    private Animation khr;
    private Animation khs;
    private boolean kht = false;
    private boolean khu = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eNx = tbPageContext;
        this.khk = (ImageView) view.findViewById(R.id.gif_image);
        this.khl = (LinearLayout) view.findViewById(R.id.gif_group);
        this.khm = (TextView) view.findViewById(R.id.git_desc);
        this.khn = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.kht) {
            this.khl.setVisibility(i);
            if (i != 8) {
                this.khm.setText(au.numFormatOverWan(j));
                this.khu = z;
                if (this.khu) {
                    if (i2 == 1) {
                        this.khm.setVisibility(0);
                        ap.setImageResource(this.khk, R.drawable.bless_gif);
                    } else {
                        this.khm.setVisibility(8);
                        ap.setImageResource(this.khk, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.khm.getLayoutParams()).setMargins(this.eNx.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eNx.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.khm, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.khm, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.khm.setVisibility(0);
                        ap.setImageResource(this.khk, R.drawable.candle_gif);
                    } else {
                        this.khm.setVisibility(8);
                        ap.setImageResource(this.khk, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.khm.getLayoutParams()).setMargins(this.eNx.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eNx.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.khm, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.khm, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.khl.clearAnimation();
                    this.kho = (AnimationDrawable) this.khk.getDrawable();
                    this.kho.start();
                } else {
                    this.khn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.khl.getAnimation() == e.this.khp) {
                                e.this.khl.clearAnimation();
                                return;
                            }
                            e.this.khm.setVisibility(0);
                            e.this.khm.setText(au.numFormatOverWan(j + 1));
                            if (e.this.khu) {
                                ap.setImageResource(e.this.khk, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.khk, R.drawable.candle_gif);
                            }
                            e.this.kho = (AnimationDrawable) e.this.khk.getDrawable();
                            e.this.kho.start();
                            e.this.khl.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.khl.getAnimation() != e.this.khr) {
                                        e.this.khl.startAnimation(e.this.khr);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eNx.getOrignalPage()).cRB();
                        }
                    });
                    this.khl.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.khl.getAnimation() == e.this.khp) {
                                e.this.khl.clearAnimation();
                                return;
                            }
                            e.this.khm.setVisibility(0);
                            e.this.khm.setText(au.numFormatOverWan(j + 1));
                            if (e.this.khu) {
                                ap.setImageResource(e.this.khk, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.khk, R.drawable.candle_gif);
                            }
                            e.this.kho = (AnimationDrawable) e.this.khk.getDrawable();
                            e.this.kho.start();
                            e.this.khl.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.khl.getAnimation() != e.this.khr) {
                                        e.this.khl.startAnimation(e.this.khr);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eNx.getOrignalPage()).cRB();
                        }
                    });
                }
                this.kht = true;
                this.khp = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.gifview_rotate);
                this.khq = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.gifview_rotate_out);
                this.khr = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.gifview_alpha);
                this.khs = AnimationUtils.loadAnimation(this.eNx.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void Dz(int i) {
        if (this.kht) {
            this.index = i;
            if (this.khk.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.khl.getAnimation() != this.khs) {
                        this.khl.startAnimation(this.khs);
                        this.kho.start();
                    }
                } else if (this.khl.getAnimation() != this.khr) {
                    this.khl.startAnimation(this.khr);
                    this.kho.stop();
                }
            } else if (this.index >= 2) {
                if (this.khl.getAnimation() != this.khp) {
                    this.khl.startAnimation(this.khp);
                }
            } else if (this.khl.getAnimation() == this.khp) {
                this.khl.startAnimation(this.khq);
            }
        }
    }

    public void clearAnimation() {
        this.khk.clearAnimation();
        this.khl.clearAnimation();
        if (this.khp != null) {
            this.khp.cancel();
        }
        if (this.khq != null) {
            this.khq.cancel();
        }
        if (this.khr != null) {
            this.khr.cancel();
        }
        if (this.khs != null) {
            this.khs.cancel();
        }
        if (this.kho != null) {
            this.kho.stop();
        }
    }
}
