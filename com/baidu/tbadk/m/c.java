package com.baidu.tbadk.m;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    private LinearLayout cmN;
    private NestedScrollView cvG;
    protected TbImageView cvH;
    protected TextView cvI;
    protected TextView cvJ;
    protected TextView cvK;
    private LinearLayout cvL;
    private int cvM;
    Rect rect;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.cvM = 0;
        this.rect = new Rect();
        this.cvG = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.cmN = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.cvH = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cvI = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cvJ = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cvL = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cvK = (TextView) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cvK.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void qx(String str) {
        if (str == null) {
            this.cvI.setVisibility(8);
            return;
        }
        this.cvI.setVisibility(0);
        this.cvI.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.cvJ.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cvK.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.m.a
    public void onViewDettached() {
        super.onViewDettached();
        this.cvH.setImageResource(0);
    }

    public void asB() {
        this.cvK.setVisibility(0);
        this.cvJ.setVisibility(0);
        al.f(this.cvI, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.cvH, (int) R.drawable.new_pic_emotion_gray_09);
        al.c(this.cvI, R.color.cp_cont_d, 1, skinType);
        al.c(this.cvJ, R.color.cp_cont_j, 1, skinType);
        al.c(this.cvK, R.color.cp_link_tip_a, 1, skinType);
        al.l(this.attachedView, R.color.cp_bg_line_d);
    }

    public View asC() {
        return this.attachedView;
    }

    public void kB(int i) {
        if (this.cvM <= 0) {
            this.cvM = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.cvG != null) {
            if (i == 0) {
                this.cvG.post(new Runnable() { // from class: com.baidu.tbadk.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kB(-1);
                    }
                });
            }
            if (this.cvG.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.cmN.getTop());
                int abs2 = i2 - Math.abs(this.cmN.getBottom());
                ViewGroup.LayoutParams layoutParams = this.cmN.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.cvM) {
                        marginLayoutParams.topMargin = this.cvM;
                        this.cmN.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.cvM) {
                        if (abs2 > this.cvM) {
                            marginLayoutParams.topMargin = ((abs2 - this.cvM) / 2) + this.cvM;
                            this.cmN.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.cvM) {
                        if (abs2 < this.cvM) {
                            marginLayoutParams.topMargin = this.cvM;
                        } else if (abs2 == this.cvM) {
                            marginLayoutParams.topMargin = this.cvM;
                        } else if (abs2 > this.cvM) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.cmN.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
