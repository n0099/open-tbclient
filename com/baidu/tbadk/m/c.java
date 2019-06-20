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
    private LinearLayout cmO;
    private NestedScrollView cvH;
    protected TbImageView cvI;
    protected TextView cvJ;
    protected TextView cvK;
    protected TextView cvL;
    private LinearLayout cvM;
    private int cvN;
    Rect rect;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.cvN = 0;
        this.rect = new Rect();
        this.cvH = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.cmO = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.cvI = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.cvJ = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cvK = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cvM = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.cvL = (TextView) this.attachedView.findViewById(R.id.net_refresh_button);
        this.cvL.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void qw(String str) {
        if (str == null) {
            this.cvJ.setVisibility(8);
            return;
        }
        this.cvJ.setVisibility(0);
        this.cvJ.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.cvK.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.cvL.setText(str);
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
        this.cvI.setImageResource(0);
    }

    public void asB() {
        this.cvL.setVisibility(0);
        this.cvK.setVisibility(0);
        al.f(this.cvJ, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        al.c(this.cvI, (int) R.drawable.new_pic_emotion_gray_09);
        al.c(this.cvJ, R.color.cp_cont_d, 1, skinType);
        al.c(this.cvK, R.color.cp_cont_j, 1, skinType);
        al.c(this.cvL, R.color.cp_link_tip_a, 1, skinType);
        al.l(this.attachedView, R.color.cp_bg_line_d);
    }

    public View asC() {
        return this.attachedView;
    }

    public void kB(int i) {
        if (this.cvN <= 0) {
            this.cvN = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.cvH != null) {
            if (i == 0) {
                this.cvH.post(new Runnable() { // from class: com.baidu.tbadk.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.kB(-1);
                    }
                });
            }
            if (this.cvH.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.cmO.getTop());
                int abs2 = i2 - Math.abs(this.cmO.getBottom());
                ViewGroup.LayoutParams layoutParams = this.cmO.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.cvN) {
                        marginLayoutParams.topMargin = this.cvN;
                        this.cmO.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.cvN) {
                        if (abs2 > this.cvN) {
                            marginLayoutParams.topMargin = ((abs2 - this.cvN) / 2) + this.cvN;
                            this.cmO.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.cvN) {
                        if (abs2 < this.cvN) {
                            marginLayoutParams.topMargin = this.cvN;
                        } else if (abs2 == this.cvN) {
                            marginLayoutParams.topMargin = this.cvN;
                        } else if (abs2 > this.cvN) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.cmO.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
