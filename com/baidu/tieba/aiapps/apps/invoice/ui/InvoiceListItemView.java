package com.baidu.tieba.aiapps.apps.invoice.ui;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.tieba.e;
/* loaded from: classes4.dex */
public class InvoiceListItemView extends FrameLayout {
    private PartingLineView bDW;
    private View bDX;
    private ImageView bDY;
    private TextView bDZ;
    private ImageView bEa;
    private TextView bEb;
    private Context mContext;
    private View mTopView;

    public InvoiceListItemView(Context context) {
        this(context, null);
    }

    public InvoiceListItemView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public InvoiceListItemView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        bJ(context);
    }

    private void bJ(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.invoice_item_view, (ViewGroup) this, true);
        this.bDW = (PartingLineView) findViewById(e.g.parting_line_view);
        this.bDW.setBgNormalColor(e.d.invoice_bg_normal_color);
        this.bDW.setBgPressedColor(e.d.invoice_bg_pressed_color);
        this.bDW.setBorderColor(e.d.invoice_bg_border_color);
        this.bDW.setDividerLineColor(e.d.invoice_bg_divider_line_color);
        this.bDX = LayoutInflater.from(context).inflate(e.h.invoice_item_bottom_view, (ViewGroup) null);
        this.bDY = (ImageView) this.bDX.findViewById(e.g.invoice_current_use_img);
        this.bDZ = (TextView) this.bDX.findViewById(e.g.invoice_current_use_txt);
        this.bEa = (ImageView) this.bDX.findViewById(e.g.invoice_edit_img);
        this.bEb = (TextView) this.bDX.findViewById(e.g.invoice_edit);
        this.bDY.setImageDrawable(getResources().getDrawable(e.f.invoice_default_select));
        this.bDZ.setTextColor(getResources().getColor(e.d.invoice_bottom_text));
        this.bEa.setImageDrawable(getResources().getDrawable(e.f.invoice_edit_img));
        this.bEb.setTextColor(getResources().getColor(e.d.invoice_bottom_text));
        this.bDY.setVisibility(4);
        this.bDZ.setVisibility(4);
        setClickable(true);
    }

    public void Xu() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(e.h.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(e.g.invoice_company_title_txt)).setTextColor(getResources().getColor(e.d.invoice_top_title_color));
        ((TextView) this.mTopView.findViewById(e.g.tax_number_txt)).setTextColor(getResources().getColor(e.d.invoice_top_tax_number_color));
        ((CommonTagView) this.mTopView.findViewById(e.g.common_tag_company)).setTextColor(getResources().getColor(e.d.invoice_top_tag_color));
        if (this.bDW != null) {
            this.bDW.setContentView(this.mTopView, this.bDX);
        }
    }

    public void Xv() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(e.h.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(e.g.invoice_personal_title_txt)).setTextColor(getResources().getColor(e.d.invoice_top_title_color));
        ((CommonTagView) this.mTopView.findViewById(e.g.invoice_personal_tag)).setTextColor(getResources().getColor(e.d.invoice_top_tag_color));
        if (this.bDW != null) {
            this.bDW.setContentView(this.mTopView, this.bDX);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.mTopView != null) {
            TextView textView = (TextView) this.mTopView.findViewById(e.g.invoice_company_title_txt);
            TextView textView2 = (TextView) this.mTopView.findViewById(e.g.tax_number_txt);
            if (textView != null) {
                textView.setText(str);
            }
            if (textView2 != null) {
                textView2.setText(str2);
            }
        }
    }

    public void setPersonageInfo(String str) {
        TextView textView;
        if (this.mTopView != null && (textView = (TextView) this.mTopView.findViewById(e.g.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.bEb != null) {
                this.bEb.setOnClickListener(onClickListener);
            }
            if (this.bEa != null) {
                this.bEa.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void di(boolean z) {
        int i = z ? 0 : 4;
        if (this.bDY != null) {
            this.bDY.setVisibility(i);
        }
        if (this.bDZ != null) {
            this.bDZ.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        dj(z);
        super.setPressed(z);
    }

    private void dj(boolean z) {
        if (this.bDW != null) {
            this.bDW.dk(z);
        }
    }
}
