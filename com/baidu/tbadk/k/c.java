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
    private NestedScrollView dBj;
    protected TbImageView dBk;
    protected TextView dBl;
    protected TBSpecificationBtn dBm;
    private LinearLayout dBn;
    private int dBo;
    private LinearLayout dtx;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.dBo = 0;
        this.rect = new Rect();
        this.dBj = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.dtx = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.dBk = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.dBl = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.dBn = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.dBm = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.dBm.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.dBm.setTextSize(R.dimen.tbds42);
        this.dBm.setConfig(bVar);
        this.dBm.setOnClickListener(onClickListener);
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
            this.dBl.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.dBm.setText(str);
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
        this.dBk.setImageResource(0);
    }

    public void showRefreshButton() {
        this.dBm.setVisibility(0);
        this.dBl.setVisibility(0);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        am.setImageResource(this.dBk, R.drawable.new_pic_emotion_08);
        am.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        am.setViewTextColor(this.dBl, R.color.cp_cont_j, 1, skinType);
        am.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.dBm != null) {
            this.dBm.aHO();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void mD(int i) {
        if (this.dBo <= 0) {
            this.dBo = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.dBj != null) {
            if (i == 0) {
                this.dBj.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.mD(-1);
                    }
                });
            }
            if (this.dBj.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.dtx.getTop());
                int abs2 = i2 - Math.abs(this.dtx.getBottom());
                ViewGroup.LayoutParams layoutParams = this.dtx.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.dBo) {
                        marginLayoutParams.topMargin = this.dBo;
                        this.dtx.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.dBo) {
                        if (abs2 > this.dBo) {
                            marginLayoutParams.topMargin = ((abs2 - this.dBo) / 2) + this.dBo;
                            this.dtx.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.dBo) {
                        if (abs2 < this.dBo) {
                            marginLayoutParams.topMargin = this.dBo;
                        } else if (abs2 == this.dBo) {
                            marginLayoutParams.topMargin = this.dBo;
                        } else if (abs2 > this.dBo) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.dtx.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
