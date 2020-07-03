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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    protected TextView aQj;
    private LinearLayout eqD;
    private NestedScrollView eyr;
    protected TbImageView eys;
    protected TBSpecificationBtn eyt;
    private LinearLayout eyu;
    private int eyv;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.eyv = 0;
        this.rect = new Rect();
        this.eyr = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.eqD = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.eys = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aQj = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.eyu = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.eyt = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.eyt.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.eyt.setTextSize(R.dimen.tbds42);
        this.eyt.setConfig(bVar);
        this.eyt.setOnClickListener(onClickListener);
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
            this.aQj.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.eyt.setText(str);
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
        this.eys.setImageResource(0);
    }

    public void showRefreshButton() {
        this.eyt.setVisibility(0);
        this.aQj.setVisibility(0);
        an.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        an.setImageResource(this.eys, R.drawable.new_pic_emotion_08);
        an.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        an.setViewTextColor(this.aQj, R.color.cp_cont_j, 1, skinType);
        an.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.eyt != null) {
            this.eyt.aYj();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void nP(int i) {
        if (this.eyv <= 0) {
            this.eyv = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.eyr != null) {
            if (i == 0) {
                this.eyr.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.nP(-1);
                    }
                });
            }
            if (this.eyr.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.eqD.getTop());
                int abs2 = i2 - Math.abs(this.eqD.getBottom());
                ViewGroup.LayoutParams layoutParams = this.eqD.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.eyv) {
                        marginLayoutParams.topMargin = this.eyv;
                        this.eqD.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.eyv) {
                        if (abs2 > this.eyv) {
                            marginLayoutParams.topMargin = ((abs2 - this.eyv) / 2) + this.eyv;
                            this.eqD.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.eyv) {
                        if (abs2 < this.eyv) {
                            marginLayoutParams.topMargin = this.eyv;
                        } else if (abs2 == this.eyv) {
                            marginLayoutParams.topMargin = this.eyv;
                        } else if (abs2 > this.eyv) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.eqD.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
