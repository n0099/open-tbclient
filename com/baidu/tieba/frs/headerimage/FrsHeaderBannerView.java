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
    private TbImageView fpR;
    private TextView fpS;
    private View fpT;
    private View fpU;
    private String fpV;
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
        this.fpT = inflate.findViewById(d.g.frs_header_title_container);
        this.fpR = (TbImageView) inflate.findViewById(d.g.frs_head_image);
        this.titleText = (TextView) inflate.findViewById(d.g.frs_header_title);
        this.fpS = (TextView) inflate.findViewById(d.g.frs_header_title_lable);
        this.fpU = inflate.findViewById(d.g.frs_image_header_contianer);
        this.fpR.setOnClickListener(this);
        this.fpT.setOnClickListener(this);
        this.fpU.setOnClickListener(this);
        this.fpR.setDefaultResource(0);
        this.fpR.setRadius(l.h(getContext(), d.e.tbds20));
        this.fpR.setConrers(15);
        this.fpR.setDefaultBgResource(e.get());
        this.fpS.setText(getContext().getString(d.j.frs_header_image_lable));
        this.mPageContext = getTbPageContext();
    }

    public void setTitle(String str) {
        if (this.titleText != null && this.fpS != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.fpS.setVisibility(0);
                this.titleText.setVisibility(0);
                return;
            }
            this.fpS.setVisibility(8);
            this.titleText.setVisibility(8);
        }
    }

    public void setSchemaUrl(String str) {
        this.fpV = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext = getTbPageContext();
        if (!TextUtils.isEmpty(this.fpV) && tbPageContext != null) {
            ba.adA().a(tbPageContext, new String[]{this.fpV}, true);
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
