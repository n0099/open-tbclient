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
    private LinearLayout dBA;
    private int dBB;
    private NestedScrollView dBw;
    protected TbImageView dBx;
    protected TextView dBy;
    protected TBSpecificationBtn dBz;
    private LinearLayout dtK;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.dBB = 0;
        this.rect = new Rect();
        this.dBw = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.dtK = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.dBx = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dBy = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.dBA = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.dBz = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dBz.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.dBz.setTextSize(R.dimen.tbds42);
        this.dBz.setConfig(bVar);
        this.dBz.setOnClickListener(onClickListener);
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
            this.dBy.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.dBz.setText(str);
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
        this.dBx.setImageResource(0);
    }

    public void showRefreshButton() {
        this.dBz.setVisibility(0);
        this.dBy.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.dBx, R.drawable.new_pic_emotion_08);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.dBy, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.dBz != null) {
            this.dBz.aHS();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void mF(int i) {
        if (this.dBB <= 0) {
            this.dBB = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.dBw != null) {
            if (i == 0) {
                this.dBw.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.mF(-1);
                    }
                });
            }
            if (this.dBw.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.dtK.getTop());
                int abs2 = i2 - Math.abs(this.dtK.getBottom());
                ViewGroup.LayoutParams layoutParams = this.dtK.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.dBB) {
                        marginLayoutParams.topMargin = this.dBB;
                        this.dtK.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.dBB) {
                        if (abs2 > this.dBB) {
                            marginLayoutParams.topMargin = ((abs2 - this.dBB) / 2) + this.dBB;
                            this.dtK.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.dBB) {
                        if (abs2 < this.dBB) {
                            marginLayoutParams.topMargin = this.dBB;
                        } else if (abs2 == this.dBB) {
                            marginLayoutParams.topMargin = this.dBB;
                        } else if (abs2 > this.dBB) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.dtK.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
