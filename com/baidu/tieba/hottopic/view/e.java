package com.baidu.tieba.hottopic.view;

import android.graphics.drawable.AnimationDrawable;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes8.dex */
public class e {
    private TbPageContext<HotTopicActivity> dPv;
    private ImageView iHK;
    private LinearLayout iHL;
    private TextView iHM;
    private View iHN;
    private AnimationDrawable iHO;
    private Animation iHP;
    private Animation iHQ;
    private Animation iHR;
    private Animation iHS;
    private boolean iHT = false;
    private boolean iHU = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.dPv = tbPageContext;
        this.iHK = (ImageView) view.findViewById(R.id.gif_image);
        this.iHL = (LinearLayout) view.findViewById(R.id.gif_group);
        this.iHM = (TextView) view.findViewById(R.id.git_desc);
        this.iHN = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.iHT) {
            this.iHL.setVisibility(i);
            if (i != 8) {
                this.iHM.setText(ar.numFormatOverWan(j));
                this.iHU = z;
                if (this.iHU) {
                    if (i2 == 1) {
                        this.iHM.setVisibility(0);
                        an.setImageResource(this.iHK, R.drawable.bless_gif);
                    } else {
                        this.iHM.setVisibility(8);
                        an.setImageResource(this.iHK, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.iHM.getLayoutParams()).setMargins(this.dPv.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.dPv.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    an.setViewTextColor(this.iHM, R.color.topic_bless_text, 1);
                    an.setBackgroundResource(this.iHM, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.iHM.setVisibility(0);
                        an.setImageResource(this.iHK, R.drawable.candle_gif);
                    } else {
                        this.iHM.setVisibility(8);
                        an.setImageResource(this.iHK, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.iHM.getLayoutParams()).setMargins(this.dPv.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.dPv.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    an.setViewTextColor(this.iHM, R.color.topic_candle_text, 1);
                    an.setBackgroundResource(this.iHM, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.iHL.clearAnimation();
                    this.iHO = (AnimationDrawable) this.iHK.getDrawable();
                    this.iHO.start();
                } else {
                    this.iHN.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.iHL.getAnimation() == e.this.iHP) {
                                e.this.iHL.clearAnimation();
                                return;
                            }
                            e.this.iHM.setVisibility(0);
                            e.this.iHM.setText(ar.numFormatOverWan(j + 1));
                            if (e.this.iHU) {
                                an.setImageResource(e.this.iHK, R.drawable.bless_gif);
                            } else {
                                an.setImageResource(e.this.iHK, R.drawable.candle_gif);
                            }
                            e.this.iHO = (AnimationDrawable) e.this.iHK.getDrawable();
                            e.this.iHO.start();
                            e.this.iHL.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.iHL.getAnimation() != e.this.iHR) {
                                        e.this.iHL.startAnimation(e.this.iHR);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.dPv.getOrignalPage()).clm();
                        }
                    });
                    this.iHL.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.iHL.getAnimation() == e.this.iHP) {
                                e.this.iHL.clearAnimation();
                                return;
                            }
                            e.this.iHM.setVisibility(0);
                            e.this.iHM.setText(ar.numFormatOverWan(j + 1));
                            if (e.this.iHU) {
                                an.setImageResource(e.this.iHK, R.drawable.bless_gif);
                            } else {
                                an.setImageResource(e.this.iHK, R.drawable.candle_gif);
                            }
                            e.this.iHO = (AnimationDrawable) e.this.iHK.getDrawable();
                            e.this.iHO.start();
                            e.this.iHL.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.iHL.getAnimation() != e.this.iHR) {
                                        e.this.iHL.startAnimation(e.this.iHR);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.dPv.getOrignalPage()).clm();
                        }
                    });
                }
                this.iHT = true;
                this.iHP = AnimationUtils.loadAnimation(this.dPv.getPageActivity(), R.anim.gifview_rotate);
                this.iHQ = AnimationUtils.loadAnimation(this.dPv.getPageActivity(), R.anim.gifview_rotate_out);
                this.iHR = AnimationUtils.loadAnimation(this.dPv.getPageActivity(), R.anim.gifview_alpha);
                this.iHS = AnimationUtils.loadAnimation(this.dPv.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void xN(int i) {
        if (this.iHT) {
            this.index = i;
            if (this.iHK.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.iHL.getAnimation() != this.iHS) {
                        this.iHL.startAnimation(this.iHS);
                        this.iHO.start();
                    }
                } else if (this.iHL.getAnimation() != this.iHR) {
                    this.iHL.startAnimation(this.iHR);
                    this.iHO.stop();
                }
            } else if (this.index >= 2) {
                if (this.iHL.getAnimation() != this.iHP) {
                    this.iHL.startAnimation(this.iHP);
                }
            } else if (this.iHL.getAnimation() == this.iHP) {
                this.iHL.startAnimation(this.iHQ);
            }
        }
    }

    public void clearAnimation() {
        this.iHK.clearAnimation();
        this.iHL.clearAnimation();
        if (this.iHP != null) {
            this.iHP.cancel();
        }
        if (this.iHQ != null) {
            this.iHQ.cancel();
        }
        if (this.iHR != null) {
            this.iHR.cancel();
        }
        if (this.iHS != null) {
            this.iHS.cancel();
        }
        if (this.iHO != null) {
            this.iHO.stop();
        }
    }
}
