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
    private ImageView kxY;
    private LinearLayout kxZ;
    private TextView kya;
    private View kyb;
    private AnimationDrawable kyc;
    private Animation kyd;
    private Animation kye;
    private Animation kyf;
    private Animation kyg;
    private boolean kyh = false;
    private boolean kyi = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eUY = tbPageContext;
        this.kxY = (ImageView) view.findViewById(R.id.gif_image);
        this.kxZ = (LinearLayout) view.findViewById(R.id.gif_group);
        this.kya = (TextView) view.findViewById(R.id.git_desc);
        this.kyb = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.kyh) {
            this.kxZ.setVisibility(i);
            if (i != 8) {
                this.kya.setText(au.numFormatOverWan(j));
                this.kyi = z;
                if (this.kyi) {
                    if (i2 == 1) {
                        this.kya.setVisibility(0);
                        ap.setImageResource(this.kxY, R.drawable.bless_gif);
                    } else {
                        this.kya.setVisibility(8);
                        ap.setImageResource(this.kxY, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.kya.getLayoutParams()).setMargins(this.eUY.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eUY.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.kya, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.kya, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.kya.setVisibility(0);
                        ap.setImageResource(this.kxY, R.drawable.candle_gif);
                    } else {
                        this.kya.setVisibility(8);
                        ap.setImageResource(this.kxY, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.kya.getLayoutParams()).setMargins(this.eUY.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eUY.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.kya, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.kya, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.kxZ.clearAnimation();
                    this.kyc = (AnimationDrawable) this.kxY.getDrawable();
                    this.kyc.start();
                } else {
                    this.kyb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kxZ.getAnimation() == e.this.kyd) {
                                e.this.kxZ.clearAnimation();
                                return;
                            }
                            e.this.kya.setVisibility(0);
                            e.this.kya.setText(au.numFormatOverWan(j + 1));
                            if (e.this.kyi) {
                                ap.setImageResource(e.this.kxY, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.kxY, R.drawable.candle_gif);
                            }
                            e.this.kyc = (AnimationDrawable) e.this.kxY.getDrawable();
                            e.this.kyc.start();
                            e.this.kxZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kxZ.getAnimation() != e.this.kyf) {
                                        e.this.kxZ.startAnimation(e.this.kyf);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eUY.getOrignalPage()).cSP();
                        }
                    });
                    this.kxZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.kxZ.getAnimation() == e.this.kyd) {
                                e.this.kxZ.clearAnimation();
                                return;
                            }
                            e.this.kya.setVisibility(0);
                            e.this.kya.setText(au.numFormatOverWan(j + 1));
                            if (e.this.kyi) {
                                ap.setImageResource(e.this.kxY, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.kxY, R.drawable.candle_gif);
                            }
                            e.this.kyc = (AnimationDrawable) e.this.kxY.getDrawable();
                            e.this.kyc.start();
                            e.this.kxZ.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.kxZ.getAnimation() != e.this.kyf) {
                                        e.this.kxZ.startAnimation(e.this.kyf);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eUY.getOrignalPage()).cSP();
                        }
                    });
                }
                this.kyh = true;
                this.kyd = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.gifview_rotate);
                this.kye = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.gifview_rotate_out);
                this.kyf = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.gifview_alpha);
                this.kyg = AnimationUtils.loadAnimation(this.eUY.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void Cy(int i) {
        if (this.kyh) {
            this.index = i;
            if (this.kxY.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.kxZ.getAnimation() != this.kyg) {
                        this.kxZ.startAnimation(this.kyg);
                        this.kyc.start();
                    }
                } else if (this.kxZ.getAnimation() != this.kyf) {
                    this.kxZ.startAnimation(this.kyf);
                    this.kyc.stop();
                }
            } else if (this.index >= 2) {
                if (this.kxZ.getAnimation() != this.kyd) {
                    this.kxZ.startAnimation(this.kyd);
                }
            } else if (this.kxZ.getAnimation() == this.kyd) {
                this.kxZ.startAnimation(this.kye);
            }
        }
    }

    public void clearAnimation() {
        this.kxY.clearAnimation();
        this.kxZ.clearAnimation();
        if (this.kyd != null) {
            this.kyd.cancel();
        }
        if (this.kye != null) {
            this.kye.cancel();
        }
        if (this.kyf != null) {
            this.kyf.cancel();
        }
        if (this.kyg != null) {
            this.kyg.cancel();
        }
        if (this.kyc != null) {
            this.kyc.stop();
        }
    }
}
