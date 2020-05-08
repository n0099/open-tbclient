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
    protected TextView aHU;
    private LinearLayout dTK;
    private NestedScrollView ebn;
    protected TbImageView ebo;
    protected TBSpecificationBtn ebp;
    private LinearLayout ebq;
    private int ebr;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.ebr = 0;
        this.rect = new Rect();
        this.ebn = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.dTK = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.ebo = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aHU = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.ebq = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.ebp = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.ebp.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.ebp.setTextSize(R.dimen.tbds42);
        this.ebp.setConfig(bVar);
        this.ebp.setOnClickListener(onClickListener);
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
            this.aHU.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.ebp.setText(str);
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
        this.ebo.setImageResource(0);
    }

    public void showRefreshButton() {
        this.ebp.setVisibility(0);
        this.aHU.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.ebo, R.drawable.new_pic_emotion_08);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.aHU, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.ebp != null) {
            this.ebp.aQm();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void mQ(int i) {
        if (this.ebr <= 0) {
            this.ebr = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.ebn != null) {
            if (i == 0) {
                this.ebn.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.mQ(-1);
                    }
                });
            }
            if (this.ebn.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.dTK.getTop());
                int abs2 = i2 - Math.abs(this.dTK.getBottom());
                ViewGroup.LayoutParams layoutParams = this.dTK.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.ebr) {
                        marginLayoutParams.topMargin = this.ebr;
                        this.dTK.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.ebr) {
                        if (abs2 > this.ebr) {
                            marginLayoutParams.topMargin = ((abs2 - this.ebr) / 2) + this.ebr;
                            this.dTK.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.ebr) {
                        if (abs2 < this.ebr) {
                            marginLayoutParams.topMargin = this.ebr;
                        } else if (abs2 == this.ebr) {
                            marginLayoutParams.topMargin = this.ebr;
                        } else if (abs2 > this.ebr) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.dTK.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
