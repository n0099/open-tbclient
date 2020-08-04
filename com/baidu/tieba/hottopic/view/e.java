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
    private ImageView iNR;
    private LinearLayout iNS;
    private TextView iNT;
    private View iNU;
    private AnimationDrawable iNV;
    private Animation iNW;
    private Animation iNX;
    private Animation iNY;
    private Animation iNZ;
    private boolean iOa = false;
    private boolean iOb = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.dVN = tbPageContext;
        this.iNR = (ImageView) view.findViewById(R.id.gif_image);
        this.iNS = (LinearLayout) view.findViewById(R.id.gif_group);
        this.iNT = (TextView) view.findViewById(R.id.git_desc);
        this.iNU = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.iOa) {
            this.iNS.setVisibility(i);
            if (i != 8) {
                this.iNT.setText(as.numFormatOverWan(j));
                this.iOb = z;
                if (this.iOb) {
                    if (i2 == 1) {
                        this.iNT.setVisibility(0);
                        ao.setImageResource(this.iNR, R.drawable.bless_gif);
                    } else {
                        this.iNT.setVisibility(8);
                        ao.setImageResource(this.iNR, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.iNT.getLayoutParams()).setMargins(this.dVN.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.dVN.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ao.setViewTextColor(this.iNT, R.color.topic_bless_text, 1);
                    ao.setBackgroundResource(this.iNT, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.iNT.setVisibility(0);
                        ao.setImageResource(this.iNR, R.drawable.candle_gif);
                    } else {
                        this.iNT.setVisibility(8);
                        ao.setImageResource(this.iNR, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.iNT.getLayoutParams()).setMargins(this.dVN.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.dVN.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ao.setViewTextColor(this.iNT, R.color.topic_candle_text, 1);
                    ao.setBackgroundResource(this.iNT, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.iNS.clearAnimation();
                    this.iNV = (AnimationDrawable) this.iNR.getDrawable();
                    this.iNV.start();
                } else {
                    this.iNU.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.iNS.getAnimation() == e.this.iNW) {
                                e.this.iNS.clearAnimation();
                                return;
                            }
                            e.this.iNT.setVisibility(0);
                            e.this.iNT.setText(as.numFormatOverWan(j + 1));
                            if (e.this.iOb) {
                                ao.setImageResource(e.this.iNR, R.drawable.bless_gif);
                            } else {
                                ao.setImageResource(e.this.iNR, R.drawable.candle_gif);
                            }
                            e.this.iNV = (AnimationDrawable) e.this.iNR.getDrawable();
                            e.this.iNV.start();
                            e.this.iNS.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.iNS.getAnimation() != e.this.iNY) {
                                        e.this.iNS.startAnimation(e.this.iNY);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.dVN.getOrignalPage()).coN();
                        }
                    });
                    this.iNS.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.iNS.getAnimation() == e.this.iNW) {
                                e.this.iNS.clearAnimation();
                                return;
                            }
                            e.this.iNT.setVisibility(0);
                            e.this.iNT.setText(as.numFormatOverWan(j + 1));
                            if (e.this.iOb) {
                                ao.setImageResource(e.this.iNR, R.drawable.bless_gif);
                            } else {
                                ao.setImageResource(e.this.iNR, R.drawable.candle_gif);
                            }
                            e.this.iNV = (AnimationDrawable) e.this.iNR.getDrawable();
                            e.this.iNV.start();
                            e.this.iNS.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.iNS.getAnimation() != e.this.iNY) {
                                        e.this.iNS.startAnimation(e.this.iNY);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.dVN.getOrignalPage()).coN();
                        }
                    });
                }
                this.iOa = true;
                this.iNW = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.gifview_rotate);
                this.iNX = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.gifview_rotate_out);
                this.iNY = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.gifview_alpha);
                this.iNZ = AnimationUtils.loadAnimation(this.dVN.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void yf(int i) {
        if (this.iOa) {
            this.index = i;
            if (this.iNR.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.iNS.getAnimation() != this.iNZ) {
                        this.iNS.startAnimation(this.iNZ);
                        this.iNV.start();
                    }
                } else if (this.iNS.getAnimation() != this.iNY) {
                    this.iNS.startAnimation(this.iNY);
                    this.iNV.stop();
                }
            } else if (this.index >= 2) {
                if (this.iNS.getAnimation() != this.iNW) {
                    this.iNS.startAnimation(this.iNW);
                }
            } else if (this.iNS.getAnimation() == this.iNW) {
                this.iNS.startAnimation(this.iNX);
            }
        }
    }

    public void clearAnimation() {
        this.iNR.clearAnimation();
        this.iNS.clearAnimation();
        if (this.iNW != null) {
            this.iNW.cancel();
        }
        if (this.iNX != null) {
            this.iNX.cancel();
        }
        if (this.iNY != null) {
            this.iNY.cancel();
        }
        if (this.iNZ != null) {
            this.iNZ.cancel();
        }
        if (this.iNV != null) {
            this.iNV.stop();
        }
    }
}
