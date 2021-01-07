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
/* loaded from: classes8.dex */
public class e {
    private TbPageContext<HotTopicActivity> eXu;
    private AnimationDrawable kuA;
    private Animation kuB;
    private Animation kuC;
    private Animation kuD;
    private Animation kuE;
    private ImageView kuw;
    private LinearLayout kux;
    private TextView kuy;
    private View kuz;
    private boolean kuF = false;
    private boolean kuG = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eXu = tbPageContext;
        this.kuw = (ImageView) view.findViewById(R.id.gif_image);
        this.kux = (LinearLayout) view.findViewById(R.id.gif_group);
        this.kuy = (TextView) view.findViewById(R.id.git_desc);
        this.kuz = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.kuF) {
            this.kux.setVisibility(i);
            if (i != 8) {
                this.kuy.setText(at.numFormatOverWan(j));
                this.kuG = z;
                if (this.kuG) {
                    if (i2 == 1) {
                        this.kuy.setVisibility(0);
                        ao.setImageResource(this.kuw, R.drawable.bless_gif);
                    } else {
                        this.kuy.setVisibility(8);
                        ao.setImageResource(this.kuw, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.kuy.getLayoutParams()).setMargins(this.eXu.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eXu.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ao.setViewTextColor(this.kuy, R.color.topic_bless_text, 1);
                    ao.setBackgroundResource(this.kuy, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.kuy.setVisibility(0);
                        ao.setImageResource(this.kuw, R.drawable.candle_gif);
                    } else {
                        this.kuy.setVisibility(8);
                        ao.setImageResource(this.kuw, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.kuy.getLayoutParams()).setMargins(this.eXu.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eXu.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ao.setViewTextColor(this.kuy, R.color.topic_candle_text, 1);
                    ao.setBackgroundResource(this.kuy, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.kux.clearAnimation();
                    this.kuA = (AnimationDrawable) this.kuw.getDrawable();
                    this.kuA.start();
                } else {
                    this.kuz.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kux.getAnimation() == e.this.kuB) {
                                e.this.kux.clearAnimation();
                                return;
                            }
                            e.this.kuy.setVisibility(0);
                            e.this.kuy.setText(at.numFormatOverWan(j + 1));
                            if (e.this.kuG) {
                                ao.setImageResource(e.this.kuw, R.drawable.bless_gif);
                            } else {
                                ao.setImageResource(e.this.kuw, R.drawable.candle_gif);
                            }
                            e.this.kuA = (AnimationDrawable) e.this.kuw.getDrawable();
                            e.this.kuA.start();
                            e.this.kux.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kux.getAnimation() != e.this.kuD) {
                                        e.this.kux.startAnimation(e.this.kuD);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eXu.getOrignalPage()).cUI();
                        }
                    });
                    this.kux.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kux.getAnimation() == e.this.kuB) {
                                e.this.kux.clearAnimation();
                                return;
                            }
                            e.this.kuy.setVisibility(0);
                            e.this.kuy.setText(at.numFormatOverWan(j + 1));
                            if (e.this.kuG) {
                                ao.setImageResource(e.this.kuw, R.drawable.bless_gif);
                            } else {
                                ao.setImageResource(e.this.kuw, R.drawable.candle_gif);
                            }
                            e.this.kuA = (AnimationDrawable) e.this.kuw.getDrawable();
                            e.this.kuA.start();
                            e.this.kux.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kux.getAnimation() != e.this.kuD) {
                                        e.this.kux.startAnimation(e.this.kuD);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eXu.getOrignalPage()).cUI();
                        }
                    });
                }
                this.kuF = true;
                this.kuB = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.gifview_rotate);
                this.kuC = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.gifview_rotate_out);
                this.kuD = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.gifview_alpha);
                this.kuE = AnimationUtils.loadAnimation(this.eXu.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void DN(int i) {
        if (this.kuF) {
            this.index = i;
            if (this.kuw.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.kux.getAnimation() != this.kuE) {
                        this.kux.startAnimation(this.kuE);
                        this.kuA.start();
                    }
                } else if (this.kux.getAnimation() != this.kuD) {
                    this.kux.startAnimation(this.kuD);
                    this.kuA.stop();
                }
            } else if (this.index >= 2) {
                if (this.kux.getAnimation() != this.kuB) {
                    this.kux.startAnimation(this.kuB);
                }
            } else if (this.kux.getAnimation() == this.kuB) {
                this.kux.startAnimation(this.kuC);
            }
        }
    }

    public void clearAnimation() {
        this.kuw.clearAnimation();
        this.kux.clearAnimation();
        if (this.kuB != null) {
            this.kuB.cancel();
        }
        if (this.kuC != null) {
            this.kuC.cancel();
        }
        if (this.kuD != null) {
            this.kuD.cancel();
        }
        if (this.kuE != null) {
            this.kuE.cancel();
        }
        if (this.kuA != null) {
            this.kuA.stop();
        }
    }
}
