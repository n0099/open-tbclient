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
/* loaded from: classes15.dex */
public class e {
    private TbPageContext<HotTopicActivity> efr;
    private ImageView jcU;
    private LinearLayout jcV;
    private TextView jcW;
    private View jcX;
    private AnimationDrawable jcY;
    private Animation jcZ;
    private Animation jda;
    private Animation jdb;
    private Animation jdc;
    private boolean jdd = false;
    private boolean jde = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.efr = tbPageContext;
        this.jcU = (ImageView) view.findViewById(R.id.gif_image);
        this.jcV = (LinearLayout) view.findViewById(R.id.gif_group);
        this.jcW = (TextView) view.findViewById(R.id.git_desc);
        this.jcX = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.jdd) {
            this.jcV.setVisibility(i);
            if (i != 8) {
                this.jcW.setText(at.numFormatOverWan(j));
                this.jde = z;
                if (this.jde) {
                    if (i2 == 1) {
                        this.jcW.setVisibility(0);
                        ap.setImageResource(this.jcU, R.drawable.bless_gif);
                    } else {
                        this.jcW.setVisibility(8);
                        ap.setImageResource(this.jcU, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.jcW.getLayoutParams()).setMargins(this.efr.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.efr.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.jcW, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.jcW, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.jcW.setVisibility(0);
                        ap.setImageResource(this.jcU, R.drawable.candle_gif);
                    } else {
                        this.jcW.setVisibility(8);
                        ap.setImageResource(this.jcU, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.jcW.getLayoutParams()).setMargins(this.efr.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.efr.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.jcW, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.jcW, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.jcV.clearAnimation();
                    this.jcY = (AnimationDrawable) this.jcU.getDrawable();
                    this.jcY.start();
                } else {
                    this.jcX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jcV.getAnimation() == e.this.jcZ) {
                                e.this.jcV.clearAnimation();
                                return;
                            }
                            e.this.jcW.setVisibility(0);
                            e.this.jcW.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jde) {
                                ap.setImageResource(e.this.jcU, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jcU, R.drawable.candle_gif);
                            }
                            e.this.jcY = (AnimationDrawable) e.this.jcU.getDrawable();
                            e.this.jcY.start();
                            e.this.jcV.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jcV.getAnimation() != e.this.jdb) {
                                        e.this.jcV.startAnimation(e.this.jdb);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.efr.getOrignalPage()).czH();
                        }
                    });
                    this.jcV.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jcV.getAnimation() == e.this.jcZ) {
                                e.this.jcV.clearAnimation();
                                return;
                            }
                            e.this.jcW.setVisibility(0);
                            e.this.jcW.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jde) {
                                ap.setImageResource(e.this.jcU, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jcU, R.drawable.candle_gif);
                            }
                            e.this.jcY = (AnimationDrawable) e.this.jcU.getDrawable();
                            e.this.jcY.start();
                            e.this.jcV.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jcV.getAnimation() != e.this.jdb) {
                                        e.this.jcV.startAnimation(e.this.jdb);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.efr.getOrignalPage()).czH();
                        }
                    });
                }
                this.jdd = true;
                this.jcZ = AnimationUtils.loadAnimation(this.efr.getPageActivity(), R.anim.gifview_rotate);
                this.jda = AnimationUtils.loadAnimation(this.efr.getPageActivity(), R.anim.gifview_rotate_out);
                this.jdb = AnimationUtils.loadAnimation(this.efr.getPageActivity(), R.anim.gifview_alpha);
                this.jdc = AnimationUtils.loadAnimation(this.efr.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void Az(int i) {
        if (this.jdd) {
            this.index = i;
            if (this.jcU.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.jcV.getAnimation() != this.jdc) {
                        this.jcV.startAnimation(this.jdc);
                        this.jcY.start();
                    }
                } else if (this.jcV.getAnimation() != this.jdb) {
                    this.jcV.startAnimation(this.jdb);
                    this.jcY.stop();
                }
            } else if (this.index >= 2) {
                if (this.jcV.getAnimation() != this.jcZ) {
                    this.jcV.startAnimation(this.jcZ);
                }
            } else if (this.jcV.getAnimation() == this.jcZ) {
                this.jcV.startAnimation(this.jda);
            }
        }
    }

    public void clearAnimation() {
        this.jcU.clearAnimation();
        this.jcV.clearAnimation();
        if (this.jcZ != null) {
            this.jcZ.cancel();
        }
        if (this.jda != null) {
            this.jda.cancel();
        }
        if (this.jdb != null) {
            this.jdb.cancel();
        }
        if (this.jdc != null) {
            this.jdc.cancel();
        }
        if (this.jcY != null) {
            this.jcY.stop();
        }
    }
}
