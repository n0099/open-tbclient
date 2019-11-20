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
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class InvoiceListItemView extends FrameLayout {
    private PartingLineView doW;
    private View doX;
    private View doY;
    private ImageView doZ;
    private TextView dpa;
    private ImageView dpb;
    private TextView dpc;
    private Context mContext;

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
        LayoutInflater.from(context).inflate(R.layout.invoice_item_view, (ViewGroup) this, true);
        this.doW = (PartingLineView) findViewById(R.id.parting_line_view);
        this.doW.setBgNormalColor(R.color.invoice_bg_normal_color);
        this.doW.setBgPressedColor(R.color.invoice_bg_pressed_color);
        this.doW.setBorderColor(R.color.invoice_bg_border_color);
        this.doW.setDividerLineColor(R.color.invoice_bg_divider_line_color);
        this.doY = LayoutInflater.from(context).inflate(R.layout.invoice_item_bottom_view, (ViewGroup) null);
        this.doZ = (ImageView) this.doY.findViewById(R.id.invoice_current_use_img);
        this.dpa = (TextView) this.doY.findViewById(R.id.invoice_current_use_txt);
        this.dpb = (ImageView) this.doY.findViewById(R.id.invoice_edit_img);
        this.dpc = (TextView) this.doY.findViewById(R.id.invoice_edit);
        this.doZ.setImageDrawable(getResources().getDrawable(R.drawable.invoice_default_select));
        this.dpa.setTextColor(getResources().getColor(R.color.invoice_bottom_text));
        this.dpb.setImageDrawable(getResources().getDrawable(R.drawable.invoice_edit_img));
        this.dpc.setTextColor(getResources().getColor(R.color.invoice_bottom_text));
        this.doZ.setVisibility(4);
        this.dpa.setVisibility(4);
        setClickable(true);
    }

    public void aGO() {
        this.doX = LayoutInflater.from(this.mContext).inflate(R.layout.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.doX.findViewById(R.id.invoice_company_title_txt)).setTextColor(getResources().getColor(R.color.invoice_top_title_color));
        ((TextView) this.doX.findViewById(R.id.tax_number_txt)).setTextColor(getResources().getColor(R.color.invoice_top_tax_number_color));
        ((CommonTagView) this.doX.findViewById(R.id.common_tag_company)).setTextColor(getResources().getColor(R.color.invoice_top_tag_color));
        if (this.doW != null) {
            this.doW.setContentView(this.doX, this.doY);
        }
    }

    public void aGP() {
        this.doX = LayoutInflater.from(this.mContext).inflate(R.layout.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.doX.findViewById(R.id.invoice_personal_title_txt)).setTextColor(getResources().getColor(R.color.invoice_top_title_color));
        ((CommonTagView) this.doX.findViewById(R.id.invoice_personal_tag)).setTextColor(getResources().getColor(R.color.invoice_top_tag_color));
        if (this.doW != null) {
            this.doW.setContentView(this.doX, this.doY);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.doX != null) {
            TextView textView = (TextView) this.doX.findViewById(R.id.invoice_company_title_txt);
            TextView textView2 = (TextView) this.doX.findViewById(R.id.tax_number_txt);
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
        if (this.doX != null && (textView = (TextView) this.doX.findViewById(R.id.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.dpc != null) {
                this.dpc.setOnClickListener(onClickListener);
            }
            if (this.dpb != null) {
                this.dpb.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void go(boolean z) {
        int i = z ? 0 : 4;
        if (this.doZ != null) {
            this.doZ.setVisibility(i);
        }
        if (this.dpa != null) {
            this.dpa.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        gp(z);
        super.setPressed(z);
    }

    private void gp(boolean z) {
        if (this.doW != null) {
            this.doW.gq(z);
        }
    }
}
