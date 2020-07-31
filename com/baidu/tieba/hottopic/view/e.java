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
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.R;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes15.dex */
public class e {
    private TbPageContext<HotTopicActivity> dVN;
    private ImageView iNP;
    private LinearLayout iNQ;
    private TextView iNR;
    private View iNS;
    private AnimationDrawable iNT;
    private Animation iNU;
    private Animation iNV;
    private Animation iNW;
    private Animation iNX;
    private boolean iNY = false;
    private boolean iNZ = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.dVN = tbPageContext;
        this.iNP = (ImageView) view.findViewById(R.id.gif_image);
        this.iNQ = (LinearLayout) view.findViewById(R.id.gif_group);
        this.iNR = (TextView) view.findViewById(R.id.git_desc);
        this.iNS = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.iNY) {
            this.iNQ.setVisibility(i);
            if (i != 8) {
                this.iNR.setText(as.numFormatOverWan(j));
                this.iNZ = z;
                if (this.iNZ) {
                    if (i2 == 1) {
                        this.iNR.setVisibility(0);
                        ao.setImageResource(this.iNP, R.drawable.bless_gif);
                    } else {
                        this.iNR.setVisibility(8);
                        ao.setImageResource(this.iNP, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.iNR.getLayoutParams()).setMargins(this.dVN.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.dVN.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ao.setViewTextColor(this.iNR, R.color.topic_bless_text, 1);
                    ao.setBackgroundResource(this.iNR, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.iNR.setVisibility(0);
                        ao.setImageResource(this.iNP, R.drawable.candle_gif);
                    } else {
                        this.iNR.setVisibility(8);
                        ao.setImageResource(this.iNP, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.iNR.getLayoutParams()).setMargins(this.dVN.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.dVN.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ao.setViewTextColor(this.iNR, R.color.topic_candle_text, 1);
                    ao.setBackgroundResource(this.iNR, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.iNQ.clearAnimation();
                    this.iNT = (AnimationDrawable) this.iNP.getDrawable();
                    this.iNT.start();
                } else {
                    this.iNS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.iNQ.getAnimation() == e.this.iNU) {
                                e.this.iNQ.clearAnimation();
                                return;
                            }
                            e.this.iNR.setVisibility(0);
                            e.this.iNR.setText(as.numFormatOverWan(j + 1));
                            if (e.this.iNZ) {
                                ao.setImageResource(e.this.iNP, R.drawable.bless_gif);
                            } else {
                                ao.setImageResource(e.this.iNP, R.drawable.candle_gif);
                            }
                            e.this.iNT = (AnimationDrawable) e.this.iNP.getDrawable();
                            e.this.iNT.start();
                            e.this.iNQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.iNQ.getAnimation() != e.this.iNW) {
                                        e.this.iNQ.startAnimation(e.this.iNW);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.dVN.getOrignalPage()).coN();
                        }
                    });
                    this.iNQ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.iNQ.getAnimation() == e.this.iNU) {
                                e.this.iNQ.clearAnimation();
                                return;
                            }
                            e.this.iNR.setVisibility(0);
                            e.this.iNR.setText(as.numFormatOverWan(j + 1));
                            if (e.this.iNZ) {
                                ao.setImageResource(e.this.iNP, R.drawable.bless_gif);
                            } else {
                                ao.setImageResource(e.this.iNP, R.drawable.candle_gif);
                            }
                            e.this.iNT = (AnimationDrawable) e.this.iNP.getDrawable();
                            e.this.iNT.start();
                            e.this.iNQ.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.iNQ.getAnimation() != e.this.iNW) {
                                        e.this.iNQ.startAnimation(e.this.iNW);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.dVN.getOrignalPage()).coN();
                        }
                    });
                }
                this.iNY = true;
                this.iNU = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.gifview_rotate);
                this.iNV = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.gifview_rotate_out);
                this.iNW = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.gifview_alpha);
                this.iNX = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void yf(int i) {
        if (this.iNY) {
            this.index = i;
            if (this.iNP.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.iNQ.getAnimation() != this.iNX) {
                        this.iNQ.startAnimation(this.iNX);
                        this.iNT.start();
                    }
                } else if (this.iNQ.getAnimation() != this.iNW) {
                    this.iNQ.startAnimation(this.iNW);
                    this.iNT.stop();
                }
            } else if (this.index >= 2) {
                if (this.iNQ.getAnimation() != this.iNU) {
                    this.iNQ.startAnimation(this.iNU);
                }
            } else if (this.iNQ.getAnimation() == this.iNU) {
                this.iNQ.startAnimation(this.iNV);
            }
        }
    }

    public void clearAnimation() {
        this.iNP.clearAnimation();
        this.iNQ.clearAnimation();
        if (this.iNU != null) {
            this.iNU.cancel();
        }
        if (this.iNV != null) {
            this.iNV.cancel();
        }
        if (this.iNW != null) {
            this.iNW.cancel();
        }
        if (this.iNX != null) {
            this.iNX.cancel();
        }
        if (this.iNT != null) {
            this.iNT.stop();
        }
    }
}
