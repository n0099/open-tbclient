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
    private PartingLineView cUA;
    private View cUB;
    private ImageView cUC;
    private TextView cUD;
    private ImageView cUE;
    private TextView cUF;
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
        this.cUA = (PartingLineView) findViewById(d.g.parting_line_view);
        this.cUA.setBgNormalColor(d.C0277d.invoice_bg_normal_color);
        this.cUA.setBgPressedColor(d.C0277d.invoice_bg_pressed_color);
        this.cUA.setBorderColor(d.C0277d.invoice_bg_border_color);
        this.cUA.setDividerLineColor(d.C0277d.invoice_bg_divider_line_color);
        this.cUB = LayoutInflater.from(context).inflate(d.h.invoice_item_bottom_view, (ViewGroup) null);
        this.cUC = (ImageView) this.cUB.findViewById(d.g.invoice_current_use_img);
        this.cUD = (TextView) this.cUB.findViewById(d.g.invoice_current_use_txt);
        this.cUE = (ImageView) this.cUB.findViewById(d.g.invoice_edit_img);
        this.cUF = (TextView) this.cUB.findViewById(d.g.invoice_edit);
        this.cUC.setImageDrawable(getResources().getDrawable(d.f.invoice_default_select));
        this.cUD.setTextColor(getResources().getColor(d.C0277d.invoice_bottom_text));
        this.cUE.setImageDrawable(getResources().getDrawable(d.f.invoice_edit_img));
        this.cUF.setTextColor(getResources().getColor(d.C0277d.invoice_bottom_text));
        this.cUC.setVisibility(4);
        this.cUD.setVisibility(4);
        setClickable(true);
    }

    public void azo() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(d.h.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(d.g.invoice_company_title_txt)).setTextColor(getResources().getColor(d.C0277d.invoice_top_title_color));
        ((TextView) this.mTopView.findViewById(d.g.tax_number_txt)).setTextColor(getResources().getColor(d.C0277d.invoice_top_tax_number_color));
        ((CommonTagView) this.mTopView.findViewById(d.g.common_tag_company)).setTextColor(getResources().getColor(d.C0277d.invoice_top_tag_color));
        if (this.cUA != null) {
            this.cUA.setContentView(this.mTopView, this.cUB);
        }
    }

    public void azp() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(d.h.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(d.g.invoice_personal_title_txt)).setTextColor(getResources().getColor(d.C0277d.invoice_top_title_color));
        ((CommonTagView) this.mTopView.findViewById(d.g.invoice_personal_tag)).setTextColor(getResources().getColor(d.C0277d.invoice_top_tag_color));
        if (this.cUA != null) {
            this.cUA.setContentView(this.mTopView, this.cUB);
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
            if (this.cUF != null) {
                this.cUF.setOnClickListener(onClickListener);
            }
            if (this.cUE != null) {
                this.cUE.setOnClickListener(onClickListener);
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
        if (this.cUC != null) {
            this.cUC.setVisibility(i);
        }
        if (this.cUD != null) {
            this.cUD.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        fW(z);
        super.setPressed(z);
    }

    private void fW(boolean z) {
        if (this.cUA != null) {
            this.cUA.fX(z);
        }
    }
}
