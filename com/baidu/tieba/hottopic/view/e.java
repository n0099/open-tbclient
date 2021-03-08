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
/* loaded from: classes7.dex */
public class e {
    private TbPageContext<HotTopicActivity> eWx;
    private ImageView kAo;
    private LinearLayout kAp;
    private TextView kAq;
    private View kAr;
    private AnimationDrawable kAs;
    private Animation kAt;
    private Animation kAu;
    private Animation kAv;
    private Animation kAw;
    private boolean kAx = false;
    private boolean kAy = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eWx = tbPageContext;
        this.kAo = (ImageView) view.findViewById(R.id.gif_image);
        this.kAp = (LinearLayout) view.findViewById(R.id.gif_group);
        this.kAq = (TextView) view.findViewById(R.id.git_desc);
        this.kAr = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.kAx) {
            this.kAp.setVisibility(i);
            if (i != 8) {
                this.kAq.setText(au.numFormatOverWan(j));
                this.kAy = z;
                if (this.kAy) {
                    if (i2 == 1) {
                        this.kAq.setVisibility(0);
                        ap.setImageResource(this.kAo, R.drawable.bless_gif);
                    } else {
                        this.kAq.setVisibility(8);
                        ap.setImageResource(this.kAo, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.kAq.getLayoutParams()).setMargins(this.eWx.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eWx.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.kAq, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.kAq, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.kAq.setVisibility(0);
                        ap.setImageResource(this.kAo, R.drawable.candle_gif);
                    } else {
                        this.kAq.setVisibility(8);
                        ap.setImageResource(this.kAo, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.kAq.getLayoutParams()).setMargins(this.eWx.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eWx.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.kAq, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.kAq, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.kAp.clearAnimation();
                    this.kAs = (AnimationDrawable) this.kAo.getDrawable();
                    this.kAs.start();
                } else {
                    this.kAr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kAp.getAnimation() == e.this.kAt) {
                                e.this.kAp.clearAnimation();
                                return;
                            }
                            e.this.kAq.setVisibility(0);
                            e.this.kAq.setText(au.numFormatOverWan(j + 1));
                            if (e.this.kAy) {
                                ap.setImageResource(e.this.kAo, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.kAo, R.drawable.candle_gif);
                            }
                            e.this.kAs = (AnimationDrawable) e.this.kAo.getDrawable();
                            e.this.kAs.start();
                            e.this.kAp.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kAp.getAnimation() != e.this.kAv) {
                                        e.this.kAp.startAnimation(e.this.kAv);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eWx.getOrignalPage()).cTd();
                        }
                    });
                    this.kAp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kAp.getAnimation() == e.this.kAt) {
                                e.this.kAp.clearAnimation();
                                return;
                            }
                            e.this.kAq.setVisibility(0);
                            e.this.kAq.setText(au.numFormatOverWan(j + 1));
                            if (e.this.kAy) {
                                ap.setImageResource(e.this.kAo, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.kAo, R.drawable.candle_gif);
                            }
                            e.this.kAs = (AnimationDrawable) e.this.kAo.getDrawable();
                            e.this.kAs.start();
                            e.this.kAp.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kAp.getAnimation() != e.this.kAv) {
                                        e.this.kAp.startAnimation(e.this.kAv);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eWx.getOrignalPage()).cTd();
                        }
                    });
                }
                this.kAx = true;
                this.kAt = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.gifview_rotate);
                this.kAu = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.gifview_rotate_out);
                this.kAv = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.gifview_alpha);
                this.kAw = AnimationUtils.loadAnimation(this.eWx.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void CB(int i) {
        if (this.kAx) {
            this.index = i;
            if (this.kAo.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.kAp.getAnimation() != this.kAw) {
                        this.kAp.startAnimation(this.kAw);
                        this.kAs.start();
                    }
                } else if (this.kAp.getAnimation() != this.kAv) {
                    this.kAp.startAnimation(this.kAv);
                    this.kAs.stop();
                }
            } else if (this.index >= 2) {
                if (this.kAp.getAnimation() != this.kAt) {
                    this.kAp.startAnimation(this.kAt);
                }
            } else if (this.kAp.getAnimation() == this.kAt) {
                this.kAp.startAnimation(this.kAu);
            }
        }
    }

    public void clearAnimation() {
        this.kAo.clearAnimation();
        this.kAp.clearAnimation();
        if (this.kAt != null) {
            this.kAt.cancel();
        }
        if (this.kAu != null) {
            this.kAu.cancel();
        }
        if (this.kAv != null) {
            this.kAv.cancel();
        }
        if (this.kAw != null) {
            this.kAw.cancel();
        }
        if (this.kAs != null) {
            this.kAs.stop();
        }
    }
}
