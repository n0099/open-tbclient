package com.baidu.tieba.frs.headerimage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import d.a.c.e.p.l;
/* loaded from: classes4.dex */
public class FrsHeaderBannerView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f15723e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f15724f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f15725g;

    /* renamed from: h  reason: collision with root package name */
    public View f15726h;

    /* renamed from: i  reason: collision with root package name */
    public View f15727i;
    public String j;
    public TbPageContext k;

    public FrsHeaderBannerView(Context context) {
        super(context);
        a();
    }

    private TbPageContext getTbPageContext() {
        TbPageContext tbPageContext = this.k;
        if (tbPageContext != null) {
            return tbPageContext;
        }
        Context context = getContext();
        if (context instanceof BaseActivity) {
            this.k = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.k = ((BaseFragmentActivity) context).getPageContext();
        }
        return this.k;
    }

    public void a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.frs_header_banner, (ViewGroup) this, true);
        this.f15726h = inflate.findViewById(R.id.frs_header_title_container);
        this.f15723e = (TbImageView) inflate.findViewById(R.id.frs_head_image);
        this.f15724f = (TextView) inflate.findViewById(R.id.frs_header_title);
        this.f15725g = (TextView) inflate.findViewById(R.id.frs_header_title_lable);
        this.f15727i = inflate.findViewById(R.id.frs_image_header_contianer);
        this.f15723e.setOnClickListener(this);
        this.f15726h.setOnClickListener(this);
        this.f15727i.setOnClickListener(this);
        this.f15723e.setDefaultResource(0);
        this.f15723e.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.f15723e.setConrers(15);
        this.f15723e.setPlaceHolder(2);
        this.f15725g.setText(getContext().getString(R.string.frs_header_image_lable));
        this.k = getTbPageContext();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext = getTbPageContext();
        if (TextUtils.isEmpty(this.j) || tbPageContext == null) {
            return;
        }
        UrlManager.getInstance().dealOneLink(tbPageContext, new String[]{this.j}, true);
    }

    public void setSchemaUrl(String str) {
        this.j = str;
    }

    public void setTitle(String str) {
        if (this.f15724f == null || this.f15725g == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f15724f.setText(str);
            this.f15725g.setVisibility(0);
            this.f15724f.setVisibility(0);
            return;
        }
        this.f15725g.setVisibility(8);
        this.f15724f.setVisibility(8);
    }

    public FrsHeaderBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FrsHeaderBannerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }
}
