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
    private PartingLineView deH;
    private View deI;
    private ImageView deJ;
    private TextView deK;
    private ImageView deL;
    private TextView deM;
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
        LayoutInflater.from(context).inflate(R.layout.invoice_item_view, (ViewGroup) this, true);
        this.deH = (PartingLineView) findViewById(R.id.parting_line_view);
        this.deH.setBgNormalColor(R.color.invoice_bg_normal_color);
        this.deH.setBgPressedColor(R.color.invoice_bg_pressed_color);
        this.deH.setBorderColor(R.color.invoice_bg_border_color);
        this.deH.setDividerLineColor(R.color.invoice_bg_divider_line_color);
        this.deI = LayoutInflater.from(context).inflate(R.layout.invoice_item_bottom_view, (ViewGroup) null);
        this.deJ = (ImageView) this.deI.findViewById(R.id.invoice_current_use_img);
        this.deK = (TextView) this.deI.findViewById(R.id.invoice_current_use_txt);
        this.deL = (ImageView) this.deI.findViewById(R.id.invoice_edit_img);
        this.deM = (TextView) this.deI.findViewById(R.id.invoice_edit);
        this.deJ.setImageDrawable(getResources().getDrawable(R.drawable.invoice_default_select));
        this.deK.setTextColor(getResources().getColor(R.color.invoice_bottom_text));
        this.deL.setImageDrawable(getResources().getDrawable(R.drawable.invoice_edit_img));
        this.deM.setTextColor(getResources().getColor(R.color.invoice_bottom_text));
        this.deJ.setVisibility(4);
        this.deK.setVisibility(4);
        setClickable(true);
    }

    public void aFZ() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(R.layout.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(R.id.invoice_company_title_txt)).setTextColor(getResources().getColor(R.color.invoice_top_title_color));
        ((TextView) this.mTopView.findViewById(R.id.tax_number_txt)).setTextColor(getResources().getColor(R.color.invoice_top_tax_number_color));
        ((CommonTagView) this.mTopView.findViewById(R.id.common_tag_company)).setTextColor(getResources().getColor(R.color.invoice_top_tag_color));
        if (this.deH != null) {
            this.deH.setContentView(this.mTopView, this.deI);
        }
    }

    public void aGa() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(R.layout.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(R.id.invoice_personal_title_txt)).setTextColor(getResources().getColor(R.color.invoice_top_title_color));
        ((CommonTagView) this.mTopView.findViewById(R.id.invoice_personal_tag)).setTextColor(getResources().getColor(R.color.invoice_top_tag_color));
        if (this.deH != null) {
            this.deH.setContentView(this.mTopView, this.deI);
        }
    }

    public void setCompanyInfo(String str, String str2) {
        if (this.mTopView != null) {
            TextView textView = (TextView) this.mTopView.findViewById(R.id.invoice_company_title_txt);
            TextView textView2 = (TextView) this.mTopView.findViewById(R.id.tax_number_txt);
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
        if (this.mTopView != null && (textView = (TextView) this.mTopView.findViewById(R.id.invoice_personal_title_txt)) != null) {
            textView.setText(str);
        }
    }

    public void setEditClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            if (this.deM != null) {
                this.deM.setOnClickListener(onClickListener);
            }
            if (this.deL != null) {
                this.deL.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void gw(boolean z) {
        int i = z ? 0 : 4;
        if (this.deJ != null) {
            this.deJ.setVisibility(i);
        }
        if (this.deK != null) {
            this.deK.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        gx(z);
        super.setPressed(z);
    }

    private void gx(boolean z) {
        if (this.deH != null) {
            this.deH.gy(z);
        }
    }
}
