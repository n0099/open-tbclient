package com.baidu.tbadk.k;

import android.content.Context;
import android.graphics.Rect;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    protected TextView aND;
    private LinearLayout ehT;
    protected TbImageView epA;
    protected TBSpecificationBtn epB;
    private LinearLayout epC;
    private int epD;
    private NestedScrollView epz;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.epD = 0;
        this.rect = new Rect();
        this.epz = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.ehT = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.epA = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aND = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.epC = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.epB = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.epB.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.epB.setTextSize(R.dimen.tbds42);
        this.epB.setConfig(bVar);
        this.epB.setOnClickListener(onClickListener);
        this.attachedView.setOnClickListener(null);
    }

    public void setSubText(String str) {
        if (str == null) {
            this.subTextView.setVisibility(8);
            return;
        }
        this.subTextView.setVisibility(0);
        this.subTextView.setText(str);
    }

    public void setTitle(String str) {
        if (str != null) {
            this.aND.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.epB.setText(str);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewAttached() {
        super.onViewAttached();
        onChangeSkinType();
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tbadk.k.a
    public void onViewDettached() {
        super.onViewDettached();
        this.epA.setImageResource(0);
    }

    public void showRefreshButton() {
        this.epB.setVisibility(0);
        this.aND.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.epA, R.drawable.new_pic_emotion_08);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.aND, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.epB != null) {
            this.epB.aWr();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void nu(int i) {
        if (this.epD <= 0) {
            this.epD = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.epz != null) {
            if (i == 0) {
                this.epz.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nu(-1);
                    }
                });
            }
            if (this.epz.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.ehT.getTop());
                int abs2 = i2 - Math.abs(this.ehT.getBottom());
                ViewGroup.LayoutParams layoutParams = this.ehT.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.epD) {
                        marginLayoutParams.topMargin = this.epD;
                        this.ehT.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.epD) {
                        if (abs2 > this.epD) {
                            marginLayoutParams.topMargin = ((abs2 - this.epD) / 2) + this.epD;
                            this.ehT.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.epD) {
                        if (abs2 < this.epD) {
                            marginLayoutParams.topMargin = this.epD;
                        } else if (abs2 == this.epD) {
                            marginLayoutParams.topMargin = this.epD;
                        } else if (abs2 > this.epD) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.ehT.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
