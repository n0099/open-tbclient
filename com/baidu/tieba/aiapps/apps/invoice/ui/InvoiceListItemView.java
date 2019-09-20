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
    private PartingLineView dgs;
    private View dgt;
    private ImageView dgu;
    private TextView dgv;
    private ImageView dgw;
    private TextView dgx;
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
        this.dgs = (PartingLineView) findViewById(R.id.parting_line_view);
        this.dgs.setBgNormalColor(R.color.invoice_bg_normal_color);
        this.dgs.setBgPressedColor(R.color.invoice_bg_pressed_color);
        this.dgs.setBorderColor(R.color.invoice_bg_border_color);
        this.dgs.setDividerLineColor(R.color.invoice_bg_divider_line_color);
        this.dgt = LayoutInflater.from(context).inflate(R.layout.invoice_item_bottom_view, (ViewGroup) null);
        this.dgu = (ImageView) this.dgt.findViewById(R.id.invoice_current_use_img);
        this.dgv = (TextView) this.dgt.findViewById(R.id.invoice_current_use_txt);
        this.dgw = (ImageView) this.dgt.findViewById(R.id.invoice_edit_img);
        this.dgx = (TextView) this.dgt.findViewById(R.id.invoice_edit);
        this.dgu.setImageDrawable(getResources().getDrawable(R.drawable.invoice_default_select));
        this.dgv.setTextColor(getResources().getColor(R.color.invoice_bottom_text));
        this.dgw.setImageDrawable(getResources().getDrawable(R.drawable.invoice_edit_img));
        this.dgx.setTextColor(getResources().getColor(R.color.invoice_bottom_text));
        this.dgu.setVisibility(4);
        this.dgv.setVisibility(4);
        setClickable(true);
    }

    public void aGD() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(R.layout.invoice_item_top_company_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(R.id.invoice_company_title_txt)).setTextColor(getResources().getColor(R.color.invoice_top_title_color));
        ((TextView) this.mTopView.findViewById(R.id.tax_number_txt)).setTextColor(getResources().getColor(R.color.invoice_top_tax_number_color));
        ((CommonTagView) this.mTopView.findViewById(R.id.common_tag_company)).setTextColor(getResources().getColor(R.color.invoice_top_tag_color));
        if (this.dgs != null) {
            this.dgs.setContentView(this.mTopView, this.dgt);
        }
    }

    public void aGE() {
        this.mTopView = LayoutInflater.from(this.mContext).inflate(R.layout.invoice_item_top_personage_view, (ViewGroup) null);
        ((TextView) this.mTopView.findViewById(R.id.invoice_personal_title_txt)).setTextColor(getResources().getColor(R.color.invoice_top_title_color));
        ((CommonTagView) this.mTopView.findViewById(R.id.invoice_personal_tag)).setTextColor(getResources().getColor(R.color.invoice_top_tag_color));
        if (this.dgs != null) {
            this.dgs.setContentView(this.mTopView, this.dgt);
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
            if (this.dgx != null) {
                this.dgx.setOnClickListener(onClickListener);
            }
            if (this.dgw != null) {
                this.dgw.setOnClickListener(onClickListener);
            }
        }
    }

    public void setItemClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            setOnClickListener(onClickListener);
        }
    }

    public void gz(boolean z) {
        int i = z ? 0 : 4;
        if (this.dgu != null) {
            this.dgu.setVisibility(i);
        }
        if (this.dgv != null) {
            this.dgv.setVisibility(i);
        }
    }

    @Override // android.view.View
    public void setPressed(boolean z) {
        gA(z);
        super.setPressed(z);
    }

    private void gA(boolean z) {
        if (this.dgs != null) {
            this.dgs.gB(z);
        }
    }
}
