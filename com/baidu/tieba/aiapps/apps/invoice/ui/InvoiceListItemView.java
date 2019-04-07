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
    private View cUA;
    private ImageView cUB;
    private TextView cUC;
    private ImageView cUD;
    private TextView cUE;
    private PartingLineView cUz;
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
        this.cUz = (PartingLineView) findViewById(d.g.parting_line_view);
        this.cUz.setBgNormalColor(d.C0277d.invoice_bg_normal_color);
        this.cUz.setBgPressedColor(d.C0277d.invoice_bg_pressed_color);
        this.cUz.setBorderColor(d.C0277d.invoice_bg_border_color);
        this.cUz.setDividerLineColor(d.C0277d.invoice_bg_divider_line_color);
        this.cUA = LayoutInflater.from(context).inflate(d.h.invoice_item_bottom_view, (ViewGroup) null);
        this.cUB = (ImageView) this.cUA.findViewById(d.g.invoice_current_use_img);
        this.cUC = (TextView) this.cUA.findViewById(d.g.invoice_current_use_txt);
        this.cUD = (ImageView) this.cUA.findViewById(d.g.invoice_edit_img);
        this.cUE = (TextView) this.cUA.findViewById(d.g.invoice_edit);
        this.cUB.setImageDrawable(getResources().getDrawable(d.f.invoice_default_select));
        this.cUC.setTextColor(getResources().getColor(d.C0277d.invoice_bottom_text));
        this.cUD.setImageDrawable(getResources().getDrawable(d.f.invoice_edit_img));
        this.cUE.setTextColor(getResources().getColor(d.C0277d.invoice_bottom_text));
        this.cUB.setVisibility(4);
        this.cUC.setVisibility(4);
        setClickable(true);
    }

    public void azo() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(d.h.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(d.g.invoice_company_title_txt)).setTextColor(getResources().getColor(d.C0277d.invoice_top_title_color));
        ((TextView) this.mTopView.findViewById(d.g.tax_number_txt)).setTextColor(getResources().getColor(d.C0277d.invoice_top_tax_number_color));
        ((CommonTagView) this.mTopView.findViewById(d.g.common_tag_company)).setTextColor(getResources().getColor(d.C0277d.invoice_top_tag_color));
        if (this.cUz != null) {
            this.cUz.setContentView(this.mTopView, this.cUA);
        }
    }

    public void azp() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(d.h.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(d.g.invoice_personal_title_txt)).setTextColor(getResources().getColor(d.C0277d.invoice_top_title_color));
        ((CommonTagView) this.mTopView.findViewById(d.g.invoice_personal_tag)).setTextColor(getResources().getColor(d.C0277d.invoice_top_tag_color));
        if (this.cUz != null) {
            this.cUz.setContentView(this.mTopView, this.cUA);
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
            if (this.cUE != null) {
                this.cUE.setOnClickListener(onClickListener);
            }
            if (this.cUD != null) {
                this.cUD.setOnClickListener(onClickListener);
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
        if (this.cUB != null) {
            this.cUB.setVisibility(i);
        }
        if (this.cUC != null) {
            this.cUC.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        fW(z);
        super.setPressed(z);
    }

    private void fW(boolean z) {
        if (this.cUz != null) {
            this.cUz.fX(z);
        }
    }
}
