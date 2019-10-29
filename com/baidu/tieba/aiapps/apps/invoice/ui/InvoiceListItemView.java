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
    private PartingLineView dpN;
    private View dpO;
    private View dpP;
    private ImageView dpQ;
    private TextView dpR;
    private ImageView dpS;
    private TextView dpT;
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
        this.dpN = (PartingLineView) findViewById(R.id.parting_line_view);
        this.dpN.setBgNormalColor(R.color.invoice_bg_normal_color);
        this.dpN.setBgPressedColor(R.color.invoice_bg_pressed_color);
        this.dpN.setBorderColor(R.color.invoice_bg_border_color);
        this.dpN.setDividerLineColor(R.color.invoice_bg_divider_line_color);
        this.dpP = LayoutInflater.from(context).inflate(R.layout.invoice_item_bottom_view, (ViewGroup) null);
        this.dpQ = (ImageView) this.dpP.findViewById(R.id.invoice_current_use_img);
        this.dpR = (TextView) this.dpP.findViewById(R.id.invoice_current_use_txt);
        this.dpS = (ImageView) this.dpP.findViewById(R.id.invoice_edit_img);
        this.dpT = (TextView) this.dpP.findViewById(R.id.invoice_edit);
        this.dpQ.setImageDrawable(getResources().getDrawable(R.drawable.invoice_default_select));
        this.dpR.setTextColor(getResources().getColor(R.color.invoice_bottom_text));
        this.dpS.setImageDrawable(getResources().getDrawable(R.drawable.invoice_edit_img));
        this.dpT.setTextColor(getResources().getColor(R.color.invoice_bottom_text));
        this.dpQ.setVisibility(4);
        this.dpR.setVisibility(4);
        setClickable(true);
    }

    public void aGQ() {
        this.dpO = LayoutInflater.from(this.mContext).inflate(R.layout.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.dpO.findViewById(R.id.invoice_company_title_txt)).setTextColor(getResources().getColor(R.color.invoice_top_title_color));
        ((TextView) this.dpO.findViewById(R.id.tax_number_txt)).setTextColor(getResources().getColor(R.color.invoice_top_tax_number_color));
        ((CommonTagView) this.dpO.findViewById(R.id.common_tag_company)).setTextColor(getResources().getColor(R.color.invoice_top_tag_color));
        if (this.dpN != null) {
            this.dpN.setContentView(this.dpO, this.dpP);
        }
    }

    public void aGR() {
        this.dpO = LayoutInflater.from(this.mContext).inflate(R.layout.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.dpO.findViewById(R.id.invoice_personal_title_txt)).setTextColor(getResources().getColor(R.color.invoice_top_title_color));
        ((CommonTagView) this.dpO.findViewById(R.id.invoice_personal_tag)).setTextColor(getResources().getColor(R.color.invoice_top_tag_color));
        if (this.dpN != null) {
            this.dpN.setContentView(this.dpO, this.dpP);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.dpO != null) {
            TextView textView = (TextView) this.dpO.findViewById(R.id.invoice_company_title_txt);
            TextView textView2 = (TextView) this.dpO.findViewById(R.id.tax_number_txt);
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
        if (this.dpO != null && (textView = (TextView) this.dpO.findViewById(R.id.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.dpT != null) {
                this.dpT.setOnClickListener(onClickListener);
            }
            if (this.dpS != null) {
                this.dpS.setOnClickListener(onClickListener);
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
        if (this.dpQ != null) {
            this.dpQ.setVisibility(i);
        }
        if (this.dpR != null) {
            this.dpR.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        gp(z);
        super.setPressed(z);
    }

    private void gp(boolean z) {
        if (this.dpN != null) {
            this.dpN.gq(z);
        }
    }
}
