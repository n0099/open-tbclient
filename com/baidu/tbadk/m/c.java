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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    Rect apc;
    private LinearLayout cBY;
    private NestedScrollView cJO;
    protected TbImageView cJP;
    protected TextView cJQ;
    private LinearLayout cJR;
    private int cJS;
    protected TextView refreshButton;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.cJS = 0;
        this.apc = new Rect();
        this.cJO = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.cBY = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.cJP = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.cJQ = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.cJR = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.refreshButton = (TextView) this.attachedView.findViewById(R.id.net_refresh_button);
        this.refreshButton.setOnClickListener(onClickListener);
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
            this.cJQ.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.refreshButton.setText(str);
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
        this.cJP.setImageResource(0);
    }

    public void showRefreshButton() {
        this.refreshButton.setVisibility(0);
        this.cJQ.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.cJP, R.drawable.new_pic_emotion_gray_09);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.cJQ, R.color.cp_cont_j, 1, skinType);
        am.setViewTextColor(this.refreshButton, R.color.cp_link_tip_a, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void jZ(int i) {
        if (this.cJS <= 0) {
            this.cJS = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.cJO != null) {
            if (i == 0) {
                this.cJO.post(new Runnable() { // from class: com.baidu.tbadk.m.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.jZ(-1);
                    }
                });
            }
            if (this.cJO.getLocalVisibleRect(this.apc)) {
                int i2 = this.apc.bottom;
                int abs = Math.abs(this.cBY.getTop());
                int abs2 = i2 - Math.abs(this.cBY.getBottom());
                ViewGroup.LayoutParams layoutParams = this.cBY.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.cJS) {
                        marginLayoutParams.topMargin = this.cJS;
                        this.cBY.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.cJS) {
                        if (abs2 > this.cJS) {
                            marginLayoutParams.topMargin = ((abs2 - this.cJS) / 2) + this.cJS;
                            this.cBY.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.cJS) {
                        if (abs2 < this.cJS) {
                            marginLayoutParams.topMargin = this.cJS;
                        } else if (abs2 == this.cJS) {
                            marginLayoutParams.topMargin = this.cJS;
                        } else if (abs2 > this.cJS) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.cBY.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
