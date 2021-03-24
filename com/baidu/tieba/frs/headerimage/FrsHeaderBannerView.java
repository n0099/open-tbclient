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
import d.b.b.e.p.l;
/* loaded from: classes4.dex */
public class FrsHeaderBannerView extends LinearLayout implements View.OnClickListener {

    /* renamed from: e  reason: collision with root package name */
    public TbImageView f16528e;

    /* renamed from: f  reason: collision with root package name */
    public TextView f16529f;

    /* renamed from: g  reason: collision with root package name */
    public TextView f16530g;

    /* renamed from: h  reason: collision with root package name */
    public View f16531h;
    public View i;
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
        this.f16531h = inflate.findViewById(R.id.frs_header_title_container);
        this.f16528e = (TbImageView) inflate.findViewById(R.id.frs_head_image);
        this.f16529f = (TextView) inflate.findViewById(R.id.frs_header_title);
        this.f16530g = (TextView) inflate.findViewById(R.id.frs_header_title_lable);
        this.i = inflate.findViewById(R.id.frs_image_header_contianer);
        this.f16528e.setOnClickListener(this);
        this.f16531h.setOnClickListener(this);
        this.i.setOnClickListener(this);
        this.f16528e.setDefaultResource(0);
        this.f16528e.setRadius(l.g(getContext(), R.dimen.tbds20));
        this.f16528e.setConrers(15);
        this.f16528e.setPlaceHolder(2);
        this.f16530g.setText(getContext().getString(R.string.frs_header_image_lable));
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
        if (this.f16529f == null || this.f16530g == null) {
            return;
        }
        if (!TextUtils.isEmpty(str)) {
            this.f16529f.setText(str);
            this.f16530g.setVisibility(0);
            this.f16529f.setVisibility(0);
            return;
        }
        this.f16530g.setVisibility(8);
        this.f16529f.setVisibility(8);
    }

    public FrsHeaderBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public FrsHeaderBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        a();
    }
}
