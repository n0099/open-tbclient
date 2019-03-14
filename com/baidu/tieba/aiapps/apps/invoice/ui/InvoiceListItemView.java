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
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class InvoiceListItemView extends FrameLayout {
    private TextView cUA;
    private ImageView cUB;
    private TextView cUC;
    private PartingLineView cUx;
    private View cUy;
    private ImageView cUz;
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
        LayoutInflater.from(context).inflate(d.h.invoice_item_view, (ViewGroup) this, true);
        this.cUx = (PartingLineView) findViewById(d.g.parting_line_view);
        this.cUx.setBgNormalColor(d.C0277d.invoice_bg_normal_color);
        this.cUx.setBgPressedColor(d.C0277d.invoice_bg_pressed_color);
        this.cUx.setBorderColor(d.C0277d.invoice_bg_border_color);
        this.cUx.setDividerLineColor(d.C0277d.invoice_bg_divider_line_color);
        this.cUy = LayoutInflater.from(context).inflate(d.h.invoice_item_bottom_view, (ViewGroup) null);
        this.cUz = (ImageView) this.cUy.findViewById(d.g.invoice_current_use_img);
        this.cUA = (TextView) this.cUy.findViewById(d.g.invoice_current_use_txt);
        this.cUB = (ImageView) this.cUy.findViewById(d.g.invoice_edit_img);
        this.cUC = (TextView) this.cUy.findViewById(d.g.invoice_edit);
        this.cUz.setImageDrawable(getResources().getDrawable(d.f.invoice_default_select));
        this.cUA.setTextColor(getResources().getColor(d.C0277d.invoice_bottom_text));
        this.cUB.setImageDrawable(getResources().getDrawable(d.f.invoice_edit_img));
        this.cUC.setTextColor(getResources().getColor(d.C0277d.invoice_bottom_text));
        this.cUz.setVisibility(4);
        this.cUA.setVisibility(4);
        setClickable(true);
    }

    public void azr() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(d.h.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(d.g.invoice_company_title_txt)).setTextColor(getResources().getColor(d.C0277d.invoice_top_title_color));
        ((TextView) this.mTopView.findViewById(d.g.tax_number_txt)).setTextColor(getResources().getColor(d.C0277d.invoice_top_tax_number_color));
        ((CommonTagView) this.mTopView.findViewById(d.g.common_tag_company)).setTextColor(getResources().getColor(d.C0277d.invoice_top_tag_color));
        if (this.cUx != null) {
            this.cUx.setContentView(this.mTopView, this.cUy);
        }
    }

    public void azs() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(d.h.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(d.g.invoice_personal_title_txt)).setTextColor(getResources().getColor(d.C0277d.invoice_top_title_color));
        ((CommonTagView) this.mTopView.findViewById(d.g.invoice_personal_tag)).setTextColor(getResources().getColor(d.C0277d.invoice_top_tag_color));
        if (this.cUx != null) {
            this.cUx.setContentView(this.mTopView, this.cUy);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.mTopView != null) {
            TextView textView = (TextView) this.mTopView.findViewById(d.g.invoice_company_title_txt);
            TextView textView2 = (TextView) this.mTopView.findViewById(d.g.tax_number_txt);
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
        if (this.mTopView != null && (textView = (TextView) this.mTopView.findViewById(d.g.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.cUC != null) {
                this.cUC.setOnClickListener(onClickListener);
            }
            if (this.cUB != null) {
                this.cUB.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void fV(boolean z) {
        int i = z ? 0 : 4;
        if (this.cUz != null) {
            this.cUz.setVisibility(i);
        }
        if (this.cUA != null) {
            this.cUA.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        fW(z);
        super.setPressed(z);
    }

    private void fW(boolean z) {
        if (this.cUx != null) {
            this.cUx.fX(z);
        }
    }
}
