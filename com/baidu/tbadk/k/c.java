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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes.dex */
public class c extends a {
    protected TextView bcF;
    Rect bvm;
    private LinearLayout eVN;
    private NestedScrollView fel;
    protected TbImageView fem;
    protected TBSpecificationBtn fen;
    private LinearLayout feo;
    private int fep;
    protected TextView subTextView;

    public c(Context context, View.OnClickListener onClickListener) {
        super(LayoutInflater.from(context).inflate(R.layout.frs_net_refresh_view_layout, (ViewGroup) null));
        this.fep = 0;
        this.bvm = new Rect();
        this.fel = (NestedScrollView) this.attachedView.findViewById(R.id.scrollview);
        this.eVN = (LinearLayout) this.attachedView.findViewById(R.id.container);
        this.fem = (TbImageView) this.attachedView.findViewById(R.id.net_refresh_image);
        this.subTextView = (TextView) this.attachedView.findViewById(R.id.net_refresh_desc);
        this.bcF = (TextView) this.attachedView.findViewById(R.id.net_refresh_title);
        this.feo = (LinearLayout) this.attachedView.findViewById(R.id.net_refresh_info_layout);
        this.fen = (TBSpecificationBtn) this.attachedView.findViewById(R.id.net_refresh_button);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.fen.setText(context.getResources().getString(R.string.refresh_view_button_text));
        this.fen.setTextSize(R.dimen.tbds42);
        this.fen.setConfig(aVar);
        this.fen.setOnClickListener(onClickListener);
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
            this.bcF.setText(str);
        }
    }

    public void setButtonText(String str) {
        if (str != null) {
            this.fen.setText(str);
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
        this.fem.setImageResource(0);
    }

    public void showRefreshButton() {
        this.fen.setVisibility(0);
        this.bcF.setVisibility(0);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1);
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        ap.setImageResource(this.fem, R.drawable.new_pic_emotion_08);
        ap.setViewTextColor(this.subTextView, R.color.cp_cont_d, 1, skinType);
        ap.setViewTextColor(this.bcF, R.color.cp_cont_j, 1, skinType);
        ap.setBackgroundColor(this.attachedView, R.color.cp_bg_line_d);
        if (this.fen != null) {
            this.fen.bok();
        }
    }

    public View getAttachedView() {
        return this.attachedView;
    }

    public void rh(int i) {
        if (this.fep <= 0) {
            this.fep = TbadkCoreApplication.getInst().getResources().getDimensionPixelOffset(R.dimen.tbds156);
        }
        if (this.fel != null) {
            if (i == 0) {
                this.fel.post(new Runnable() { // from class: com.baidu.tbadk.k.c.1
                    @Override // java.lang.Runnable
                    public void run() {
                        c.this.rh(-1);
                    }
                });
            }
            if (this.fel.getLocalVisibleRect(this.bvm)) {
                int i2 = this.bvm.bottom;
                int abs = Math.abs(this.eVN.getTop());
                int abs2 = i2 - Math.abs(this.eVN.getBottom());
                ViewGroup.LayoutParams layoutParams = this.eVN.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    if (abs < this.fep) {
                        marginLayoutParams.topMargin = this.fep;
                        this.eVN.setLayoutParams(marginLayoutParams);
                    } else if (abs == this.fep) {
                        if (abs2 > this.fep) {
                            marginLayoutParams.topMargin = ((abs2 - this.fep) / 2) + this.fep;
                            this.eVN.setLayoutParams(marginLayoutParams);
                        }
                    } else if (abs > this.fep) {
                        if (abs2 < this.fep) {
                            marginLayoutParams.topMargin = this.fep;
                        } else if (abs2 == this.fep) {
                            marginLayoutParams.topMargin = this.fep;
                        } else if (abs2 > this.fep) {
                            marginLayoutParams.topMargin = (abs + abs2) / 2;
                        }
                        this.eVN.setLayoutParams(marginLayoutParams);
                    }
                }
            }
        }
    }
}
