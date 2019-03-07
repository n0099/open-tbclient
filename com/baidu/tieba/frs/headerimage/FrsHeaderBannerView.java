package com.baidu.tieba.frs.headerimage;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.util.e;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class FrsHeaderBannerView extends LinearLayout implements View.OnClickListener {
    private TbImageView fqg;
    private TextView fqh;
    private View fqi;
    private View fqj;
    private String fqk;
    private TbPageContext mPageContext;
    private TextView titleText;

    public FrsHeaderBannerView(Context context) {
        super(context);
        init();
    }

    public FrsHeaderBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public FrsHeaderBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init();
    }

    public void init() {
        View inflate = LayoutInflater.from(getContext()).inflate(d.h.frs_header_banner, (ViewGroup) this, true);
        this.fqi = inflate.findViewById(d.g.frs_header_title_container);
        this.fqg = (TbImageView) inflate.findViewById(d.g.frs_head_image);
        this.titleText = (TextView) inflate.findViewById(d.g.frs_header_title);
        this.fqh = (TextView) inflate.findViewById(d.g.frs_header_title_lable);
        this.fqj = inflate.findViewById(d.g.frs_image_header_contianer);
        this.fqg.setOnClickListener(this);
        this.fqi.setOnClickListener(this);
        this.fqj.setOnClickListener(this);
        this.fqg.setDefaultResource(0);
        this.fqg.setRadius(l.h(getContext(), d.e.tbds20));
        this.fqg.setConrers(15);
        this.fqg.setDefaultBgResource(e.get());
        this.fqh.setText(getContext().getString(d.j.frs_header_image_lable));
        this.mPageContext = getTbPageContext();
    }

    public void setTitle(String str) {
        if (this.titleText != null && this.fqh != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.fqh.setVisibility(0);
                this.titleText.setVisibility(0);
                return;
            }
            this.fqh.setVisibility(8);
            this.titleText.setVisibility(8);
        }
    }

    public void setSchemaUrl(String str) {
        this.fqk = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext = getTbPageContext();
        if (!TextUtils.isEmpty(this.fqk) && tbPageContext != null) {
            ba.adD().a(tbPageContext, new String[]{this.fqk}, true);
        }
    }

    private TbPageContext getTbPageContext() {
        if (this.mPageContext != null) {
            return this.mPageContext;
        }
        Context context = getContext();
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        return this.mPageContext;
    }
}
