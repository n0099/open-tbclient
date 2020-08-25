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
    private TbPageContext<HotTopicActivity> efn;
    private ImageView jcO;
    private LinearLayout jcP;
    private TextView jcQ;
    private View jcR;
    private AnimationDrawable jcS;
    private Animation jcT;
    private Animation jcU;
    private Animation jcV;
    private Animation jcW;
    private boolean jcX = false;
    private boolean jcY = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.efn = tbPageContext;
        this.jcO = (ImageView) view.findViewById(R.id.gif_image);
        this.jcP = (LinearLayout) view.findViewById(R.id.gif_group);
        this.jcQ = (TextView) view.findViewById(R.id.git_desc);
        this.jcR = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.jcX) {
            this.jcP.setVisibility(i);
            if (i != 8) {
                this.jcQ.setText(at.numFormatOverWan(j));
                this.jcY = z;
                if (this.jcY) {
                    if (i2 == 1) {
                        this.jcQ.setVisibility(0);
                        ap.setImageResource(this.jcO, R.drawable.bless_gif);
                    } else {
                        this.jcQ.setVisibility(8);
                        ap.setImageResource(this.jcO, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.jcQ.getLayoutParams()).setMargins(this.efn.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.efn.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.jcQ, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.jcQ, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.jcQ.setVisibility(0);
                        ap.setImageResource(this.jcO, R.drawable.candle_gif);
                    } else {
                        this.jcQ.setVisibility(8);
                        ap.setImageResource(this.jcO, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.jcQ.getLayoutParams()).setMargins(this.efn.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.efn.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.jcQ, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.jcQ, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.jcP.clearAnimation();
                    this.jcS = (AnimationDrawable) this.jcO.getDrawable();
                    this.jcS.start();
                } else {
                    this.jcR.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jcP.getAnimation() == e.this.jcT) {
                                e.this.jcP.clearAnimation();
                                return;
                            }
                            e.this.jcQ.setVisibility(0);
                            e.this.jcQ.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jcY) {
                                ap.setImageResource(e.this.jcO, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jcO, R.drawable.candle_gif);
                            }
                            e.this.jcS = (AnimationDrawable) e.this.jcO.getDrawable();
                            e.this.jcS.start();
                            e.this.jcP.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jcP.getAnimation() != e.this.jcV) {
                                        e.this.jcP.startAnimation(e.this.jcV);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.efn.getOrignalPage()).czG();
                        }
                    });
                    this.jcP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jcP.getAnimation() == e.this.jcT) {
                                e.this.jcP.clearAnimation();
                                return;
                            }
                            e.this.jcQ.setVisibility(0);
                            e.this.jcQ.setText(at.numFormatOverWan(j + 1));
                            if (e.this.jcY) {
                                ap.setImageResource(e.this.jcO, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jcO, R.drawable.candle_gif);
                            }
                            e.this.jcS = (AnimationDrawable) e.this.jcO.getDrawable();
                            e.this.jcS.start();
                            e.this.jcP.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jcP.getAnimation() != e.this.jcV) {
                                        e.this.jcP.startAnimation(e.this.jcV);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.efn.getOrignalPage()).czG();
                        }
                    });
                }
                this.jcX = true;
                this.jcT = AnimationUtils.loadAnimation(this.efn.getPageActivity(), R.anim.gifview_rotate);
                this.jcU = AnimationUtils.loadAnimation(this.efn.getPageActivity(), R.anim.gifview_rotate_out);
                this.jcV = AnimationUtils.loadAnimation(this.efn.getPageActivity(), R.anim.gifview_alpha);
                this.jcW = AnimationUtils.loadAnimation(this.efn.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void Az(int i) {
        if (this.jcX) {
            this.index = i;
            if (this.jcO.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.jcP.getAnimation() != this.jcW) {
                        this.jcP.startAnimation(this.jcW);
                        this.jcS.start();
                    }
                } else if (this.jcP.getAnimation() != this.jcV) {
                    this.jcP.startAnimation(this.jcV);
                    this.jcS.stop();
                }
            } else if (this.index >= 2) {
                if (this.jcP.getAnimation() != this.jcT) {
                    this.jcP.startAnimation(this.jcT);
                }
            } else if (this.jcP.getAnimation() == this.jcT) {
                this.jcP.startAnimation(this.jcU);
            }
        }
    }

    public void clearAnimation() {
        this.jcO.clearAnimation();
        this.jcP.clearAnimation();
        if (this.jcT != null) {
            this.jcT.cancel();
        }
        if (this.jcU != null) {
            this.jcU.cancel();
        }
        if (this.jcV != null) {
            this.jcV.cancel();
        }
        if (this.jcW != null) {
            this.jcW.cancel();
        }
        if (this.jcS != null) {
            this.jcS.stop();
        }
    }
}
