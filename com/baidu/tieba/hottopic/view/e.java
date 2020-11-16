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
/* loaded from: classes20.dex */
public class e {
    private TbPageContext<HotTopicActivity> eGu;
    private ImageView jTE;
    private LinearLayout jTF;
    private TextView jTG;
    private View jTH;
    private AnimationDrawable jTI;
    private Animation jTJ;
    private Animation jTK;
    private Animation jTL;
    private Animation jTM;
    private boolean jTN = false;
    private boolean jTO = false;
    private int index = -1;

    public e(TbPageContext<HotTopicActivity> tbPageContext, View view) {
        this.eGu = tbPageContext;
        this.jTE = (ImageView) view.findViewById(R.id.gif_image);
        this.jTF = (LinearLayout) view.findViewById(R.id.gif_group);
        this.jTG = (TextView) view.findViewById(R.id.git_desc);
        this.jTH = view.findViewById(R.id.gif_clikc_view);
    }

    public void a(int i, boolean z, final long j, int i2) {
        if (!this.jTN) {
            this.jTF.setVisibility(i);
            if (i != 8) {
                this.jTG.setText(au.numFormatOverWan(j));
                this.jTO = z;
                if (this.jTO) {
                    if (i2 == 1) {
                        this.jTG.setVisibility(0);
                        ap.setImageResource(this.jTE, R.drawable.bless_gif);
                    } else {
                        this.jTG.setVisibility(8);
                        ap.setImageResource(this.jTE, R.drawable.pic_float_zhufu);
                    }
                    ((LinearLayout.LayoutParams) this.jTG.getLayoutParams()).setMargins(this.eGu.getResources().getDimensionPixelSize(R.dimen.bless_magin_left), 0, 0, this.eGu.getResources().getDimensionPixelSize(R.dimen.bless_magin_bottom));
                    ap.setViewTextColor(this.jTG, R.color.topic_bless_text, 1);
                    ap.setBackgroundResource(this.jTG, R.drawable.pic_float_zhufu_num_b);
                } else {
                    if (i2 == 1) {
                        this.jTG.setVisibility(0);
                        ap.setImageResource(this.jTE, R.drawable.candle_gif);
                    } else {
                        this.jTG.setVisibility(8);
                        ap.setImageResource(this.jTE, R.drawable.pic_float_qifu);
                    }
                    ((LinearLayout.LayoutParams) this.jTG.getLayoutParams()).setMargins(this.eGu.getResources().getDimensionPixelSize(R.dimen.candle_magin_left), 0, 0, this.eGu.getResources().getDimensionPixelSize(R.dimen.candle_magin_bottom));
                    ap.setViewTextColor(this.jTG, R.color.topic_candle_text, 1);
                    ap.setBackgroundResource(this.jTG, R.drawable.pic_float_qifu_num_b);
                }
                if (i2 == 1) {
                    this.jTF.clearAnimation();
                    this.jTI = (AnimationDrawable) this.jTE.getDrawable();
                    this.jTI.start();
                } else {
                    this.jTH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.1
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jTF.getAnimation() == e.this.jTJ) {
                                e.this.jTF.clearAnimation();
                                return;
                            }
                            e.this.jTG.setVisibility(0);
                            e.this.jTG.setText(au.numFormatOverWan(j + 1));
                            if (e.this.jTO) {
                                ap.setImageResource(e.this.jTE, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jTE, R.drawable.candle_gif);
                            }
                            e.this.jTI = (AnimationDrawable) e.this.jTE.getDrawable();
                            e.this.jTI.start();
                            e.this.jTF.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.1.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jTF.getAnimation() != e.this.jTL) {
                                        e.this.jTF.startAnimation(e.this.jTL);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eGu.getOrignalPage()).cMm();
                        }
                    });
                    this.jTF.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.hottopic.view.e.2
                        @Override // android.view.View.OnClickListener
                        public void onClick(View view) {
                            if (e.this.jTF.getAnimation() == e.this.jTJ) {
                                e.this.jTF.clearAnimation();
                                return;
                            }
                            e.this.jTG.setVisibility(0);
                            e.this.jTG.setText(au.numFormatOverWan(j + 1));
                            if (e.this.jTO) {
                                ap.setImageResource(e.this.jTE, R.drawable.bless_gif);
                            } else {
                                ap.setImageResource(e.this.jTE, R.drawable.candle_gif);
                            }
                            e.this.jTI = (AnimationDrawable) e.this.jTE.getDrawable();
                            e.this.jTI.start();
                            e.this.jTF.postDelayed(new Runnable() { // from class: com.baidu.tieba.hottopic.view.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    if (e.this.index > 1 && e.this.jTF.getAnimation() != e.this.jTL) {
                                        e.this.jTF.startAnimation(e.this.jTL);
                                    }
                                }
                            }, 2000L);
                            ((HotTopicActivity) e.this.eGu.getOrignalPage()).cMm();
                        }
                    });
                }
                this.jTN = true;
                this.jTJ = AnimationUtils.loadAnimation(this.eGu.getPageActivity(), R.anim.gifview_rotate);
                this.jTK = AnimationUtils.loadAnimation(this.eGu.getPageActivity(), R.anim.gifview_rotate_out);
                this.jTL = AnimationUtils.loadAnimation(this.eGu.getPageActivity(), R.anim.gifview_alpha);
                this.jTM = AnimationUtils.loadAnimation(this.eGu.getPageActivity(), R.anim.gifview_alpha_visible);
            }
        }
    }

    public void CK(int i) {
        if (this.jTN) {
            this.index = i;
            if (this.jTE.getDrawable() instanceof AnimationDrawable) {
                if (this.index <= 1) {
                    if (this.jTF.getAnimation() != this.jTM) {
                        this.jTF.startAnimation(this.jTM);
                        this.jTI.start();
                    }
                } else if (this.jTF.getAnimation() != this.jTL) {
                    this.jTF.startAnimation(this.jTL);
                    this.jTI.stop();
                }
            } else if (this.index >= 2) {
                if (this.jTF.getAnimation() != this.jTJ) {
                    this.jTF.startAnimation(this.jTJ);
                }
            } else if (this.jTF.getAnimation() == this.jTJ) {
                this.jTF.startAnimation(this.jTK);
            }
        }
    }

    public void clearAnimation() {
        this.jTE.clearAnimation();
        this.jTF.clearAnimation();
        if (this.jTJ != null) {
            this.jTJ.cancel();
        }
        if (this.jTK != null) {
            this.jTK.cancel();
        }
        if (this.jTL != null) {
            this.jTL.cancel();
        }
        if (this.jTM != null) {
            this.jTM.cancel();
        }
        if (this.jTI != null) {
            this.jTI.stop();
        }
    }
}
