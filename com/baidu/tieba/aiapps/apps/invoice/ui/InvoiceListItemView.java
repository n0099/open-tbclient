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
    private PartingLineView bJb;
    private View bJc;
    private ImageView bJd;
    private TextView bJe;
    private ImageView bJf;
    private TextView bJg;
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
        initView(context);
    }

    private void initView(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(e.h.invoice_item_view, (ViewGroup) this, true);
        this.bJb = (PartingLineView) findViewById(e.g.parting_line_view);
        this.bJb.setBgNormalColor(e.d.invoice_bg_normal_color);
        this.bJb.setBgPressedColor(e.d.invoice_bg_pressed_color);
        this.bJb.setBorderColor(e.d.invoice_bg_border_color);
        this.bJb.setDividerLineColor(e.d.invoice_bg_divider_line_color);
        this.bJc = LayoutInflater.from(context).inflate(e.h.invoice_item_bottom_view, (ViewGroup) null);
        this.bJd = (ImageView) this.bJc.findViewById(e.g.invoice_current_use_img);
        this.bJe = (TextView) this.bJc.findViewById(e.g.invoice_current_use_txt);
        this.bJf = (ImageView) this.bJc.findViewById(e.g.invoice_edit_img);
        this.bJg = (TextView) this.bJc.findViewById(e.g.invoice_edit);
        this.bJd.setImageDrawable(getResources().getDrawable(e.f.invoice_default_select));
        this.bJe.setTextColor(getResources().getColor(e.d.invoice_bottom_text));
        this.bJf.setImageDrawable(getResources().getDrawable(e.f.invoice_edit_img));
        this.bJg.setTextColor(getResources().getColor(e.d.invoice_bottom_text));
        this.bJd.setVisibility(4);
        this.bJe.setVisibility(4);
        setClickable(true);
    }

    public void Zh() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(e.h.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(e.g.invoice_company_title_txt)).setTextColor(getResources().getColor(e.d.invoice_top_title_color));
        ((TextView) this.mTopView.findViewById(e.g.tax_number_txt)).setTextColor(getResources().getColor(e.d.invoice_top_tax_number_color));
        ((CommonTagView) this.mTopView.findViewById(e.g.common_tag_company)).setTextColor(getResources().getColor(e.d.invoice_top_tag_color));
        if (this.bJb != null) {
            this.bJb.setContentView(this.mTopView, this.bJc);
        }
    }

    public void Zi() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(e.h.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(e.g.invoice_personal_title_txt)).setTextColor(getResources().getColor(e.d.invoice_top_title_color));
        ((CommonTagView) this.mTopView.findViewById(e.g.invoice_personal_tag)).setTextColor(getResources().getColor(e.d.invoice_top_tag_color));
        if (this.bJb != null) {
            this.bJb.setContentView(this.mTopView, this.bJc);
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
            if (this.bJg != null) {
                this.bJg.setOnClickListener(onClickListener);
            }
            if (this.bJf != null) {
                this.bJf.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void dD(boolean z) {
        int i = z ? 0 : 4;
        if (this.bJd != null) {
            this.bJd.setVisibility(i);
        }
        if (this.bJe != null) {
            this.bJe.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        dE(z);
        super.setPressed(z);
    }

    private void dE(boolean z) {
        if (this.bJb != null) {
            this.bJb.dF(z);
        }
    }
}
