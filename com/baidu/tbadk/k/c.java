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
    private NestedScrollView dAW;
    protected TbImageView dAX;
    protected TextView dAY;
    protected TBSpecificationBtn dAZ;
    private LinearLayout dBa;
    private int dBb;
    private LinearLayout dtk;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.dBb = 0;
        this.rect = new Rect();
        this.dAW = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.dtk = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.dAX = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dAY = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.dBa = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.dAZ = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dAZ.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.dAZ.setTextSize(R.dimen.tbds42);
        this.dAZ.setConfig(bVar);
        this.dAZ.setOnClickListener(onClickListener);
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
            this.dAY.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.dAZ.setText(str);
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
        this.dAX.setImageResource(0);
    }

    public void showRefreshButton() {
        this.dAZ.setVisibility(0);
        this.dAY.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.dAX, R.drawable.new_pic_emotion_08);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.dAY, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.dAZ != null) {
            this.dAZ.aHN();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void mD(int i) {
        if (this.dBb <= 0) {
            this.dBb = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.dAW != null) {
            if (i == 0) {
                this.dAW.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.mD(-1);
                    }
                });
            }
            if (this.dAW.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.dtk.getTop());
                int abs2 = i2 - Math.abs(this.dtk.getBottom());
                ViewGroup.LayoutParams layoutParams = this.dtk.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.dBb) {
                        marginLayoutParams.topMargin = this.dBb;
                        this.dtk.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.dBb) {
                        if (abs2 > this.dBb) {
                            marginLayoutParams.topMargin = ((abs2 - this.dBb) / 2) + this.dBb;
                            this.dtk.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.dBb) {
                        if (abs2 < this.dBb) {
                            marginLayoutParams.topMargin = this.dBb;
                        } else if (abs2 == this.dBb) {
                            marginLayoutParams.topMargin = this.dBb;
                        } else if (abs2 > this.dBb) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.dtk.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
