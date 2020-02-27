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
    private NestedScrollView dAV;
    protected TbImageView dAW;
    protected TextView dAX;
    protected TBSpecificationBtn dAY;
    private LinearLayout dAZ;
    private int dBa;
    private LinearLayout dtj;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.dBa = 0;
        this.rect = new Rect();
        this.dAV = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.dtj = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.dAW = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dAX = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.dAZ = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.dAY = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dAY.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.dAY.setTextSize(R.dimen.tbds42);
        this.dAY.setConfig(bVar);
        this.dAY.setOnClickListener(onClickListener);
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
            this.dAX.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.dAY.setText(str);
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
        this.dAW.setImageResource(0);
    }

    public void showRefreshButton() {
        this.dAY.setVisibility(0);
        this.dAX.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.dAW, R.drawable.new_pic_emotion_08);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.dAX, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.dAY != null) {
            this.dAY.aHL();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void mD(int i) {
        if (this.dBa <= 0) {
            this.dBa = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.dAV != null) {
            if (i == 0) {
                this.dAV.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.mD(-1);
                    }
                });
            }
            if (this.dAV.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.dtj.getTop());
                int abs2 = i2 - Math.abs(this.dtj.getBottom());
                ViewGroup.LayoutParams layoutParams = this.dtj.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.dBa) {
                        marginLayoutParams.topMargin = this.dBa;
                        this.dtj.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.dBa) {
                        if (abs2 > this.dBa) {
                            marginLayoutParams.topMargin = ((abs2 - this.dBa) / 2) + this.dBa;
                            this.dtj.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.dBa) {
                        if (abs2 < this.dBa) {
                            marginLayoutParams.topMargin = this.dBa;
                        } else if (abs2 == this.dBa) {
                            marginLayoutParams.topMargin = this.dBa;
                        } else if (abs2 > this.dBa) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.dtj.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
