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
/* loaded from: classes8.dex */
public class e {
    private TbPageContext<HotTopicActivity> eUY;
    private ImageView kym;
    private LinearLayout kyn;
    private TextView kyo;
    private View kyp;
    private AnimationDrawable kyq;
    private Animation kyr;
    private Animation kys;
    private Animation kyt;
    private Animation kyu;
    private boolean kyv = false;
    private boolean kyw = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.kym = (ImageView) view.findViewById(R.id.gif_image);
        this.kyn = (LinearLayout) view.findViewById(R.id.gif_group);
        this.kyo = (TextView) view.findViewById(R.id.git_desc);
        this.kyp = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.kyv) {
            this.kyn.setVisibility(i);
            if (i != 8) {
                this.kyo.setText(au.numFormatOverWan(j));
                this.kyw = z;
                if (this.kyw) {
                    if (i2 == 1) {
                        this.kyo.setVisibility(0);
                        ap.setImageResource(this.kym, R.drawable.bless_gif);
                    } else {
                        this.kyo.setVisibility(8);
                        ap.setImageResource(this.kym, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.kyo.getLayoutParams()).setMargins(this.eUY.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eUY.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.kyo, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.kyo, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.kyo.setVisibility(0);
                        ap.setImageResource(this.kym, R.drawable.candle_gif);
                    } else {
                        this.kyo.setVisibility(8);
                        ap.setImageResource(this.kym, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.kyo.getLayoutParams()).setMargins(this.eUY.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eUY.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.kyo, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.kyo, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.kyn.clearAnimation();
                    this.kyq = (AnimationDrawable) this.kym.getDrawable();
                    this.kyq.start();
                } else {
                    this.kyp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kyn.getAnimation() == e.this.kyr) {
                                e.this.kyn.clearAnimation();
                                return;
                            }
                            e.this.kyo.setVisibility(0);
                            e.this.kyo.setText(au.numFormatOverWan(j + 1));
                            if (e.this.kyw) {
                                ap.setImageResource(e.this.kym, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.kym, R.drawable.candle_gif);
                            }
                            e.this.kyq = (AnimationDrawable) e.this.kym.getDrawable();
                            e.this.kyq.start();
                            e.this.kyn.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kyn.getAnimation() != e.this.kyt) {
                                        e.this.kyn.startAnimation(e.this.kyt);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eUY.getOrignalPage()).cSW();
                        }
                    });
                    this.kyn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kyn.getAnimation() == e.this.kyr) {
                                e.this.kyn.clearAnimation();
                                return;
                            }
                            e.this.kyo.setVisibility(0);
                            e.this.kyo.setText(au.numFormatOverWan(j + 1));
                            if (e.this.kyw) {
                                ap.setImageResource(e.this.kym, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.kym, R.drawable.candle_gif);
                            }
                            e.this.kyq = (AnimationDrawable) e.this.kym.getDrawable();
                            e.this.kyq.start();
                            e.this.kyn.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kyn.getAnimation() != e.this.kyt) {
                                        e.this.kyn.startAnimation(e.this.kyt);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eUY.getOrignalPage()).cSW();
                        }
                    });
                }
                this.kyv = true;
                this.kyr = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.gifview_rotate);
                this.kys = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.gifview_rotate_out);
                this.kyt = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.gifview_alpha);
                this.kyu = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void Cy(int i) {
        if (this.kyv) {
            this.index = i;
            if (this.kym.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.kyn.getAnimation() != this.kyu) {
                        this.kyn.startAnimation(this.kyu);
                        this.kyq.start();
                    }
                } else if (this.kyn.getAnimation() != this.kyt) {
                    this.kyn.startAnimation(this.kyt);
                    this.kyq.stop();
                }
            } else if (this.index >= 2) {
                if (this.kyn.getAnimation() != this.kyr) {
                    this.kyn.startAnimation(this.kyr);
                }
            } else if (this.kyn.getAnimation() == this.kyr) {
                this.kyn.startAnimation(this.kys);
            }
        }
    }

    public void clearAnimation() {
        this.kym.clearAnimation();
        this.kyn.clearAnimation();
        if (this.kyr != null) {
            this.kyr.cancel();
        }
        if (this.kys != null) {
            this.kys.cancel();
        }
        if (this.kyt != null) {
            this.kyt.cancel();
        }
        if (this.kyu != null) {
            this.kyu.cancel();
        }
        if (this.kyq != null) {
            this.kyq.stop();
        }
    }
}
