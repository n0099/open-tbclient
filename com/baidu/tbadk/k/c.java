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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    protected TextView aRC;
    private NestedScrollView eEH;
    protected TbImageView eEI;
    protected TBSpecificationBtn eEJ;
    private LinearLayout eEK;
    private int eEL;
    private LinearLayout ewV;
    Rect rect;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.eEL = 0;
        this.rect = new Rect();
        this.eEH = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.ewV = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.eEI = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.aRC = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.eEK = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.eEJ = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.eEJ.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.eEJ.setTextSize(R.dimen.tbds42);
        this.eEJ.setConfig(bVar);
        this.eEJ.setOnClickListener(onClickListener);
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
            this.aRC.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.eEJ.setText(str);
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
        this.eEI.setImageResource(0);
    }

    public void showRefreshButton() {
        this.eEJ.setVisibility(0);
        this.aRC.setVisibility(0);
        ao.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ao.setImageResource(this.eEI, R.drawable.new_pic_emotion_08);
        ao.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ao.setViewTextColor(this.aRC, R.color.cp_cont_j, 1, skinType);
        ao.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.eEJ != null) {
            this.eEJ.bci();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void oh(int i) {
        if (this.eEL <= 0) {
            this.eEL = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.eEH != null) {
            if (i == 0) {
                this.eEH.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.oh(-1);
                    }
                });
            }
            if (this.eEH.getLocalVisibleRect(this.rect)) {
                int i2 = this.rect.bottom;
                int abs = Math.abs(this.ewV.getTop());
                int abs2 = i2 - Math.abs(this.ewV.getBottom());
                ViewGroup.LayoutParams layoutParams = this.ewV.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.eEL) {
                        marginLayoutParams.topMargin = this.eEL;
                        this.ewV.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.eEL) {
                        if (abs2 > this.eEL) {
                            marginLayoutParams.topMargin = ((abs2 - this.eEL) / 2) + this.eEL;
                            this.ewV.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.eEL) {
                        if (abs2 < this.eEL) {
                            marginLayoutParams.topMargin = this.eEL;
                        } else if (abs2 == this.eEL) {
                            marginLayoutParams.topMargin = this.eEL;
                        } else if (abs2 > this.eEL) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.ewV.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
