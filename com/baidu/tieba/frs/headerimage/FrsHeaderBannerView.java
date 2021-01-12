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
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsHeaderBannerView extends LinearLayout implements View.OnClickListener {
    private TbImageView jyn;
    private TextView jyo;
    private View jyp;
    private View jyq;
    private String jyr;
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
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.frs_header_banner, (ViewGroup) this, true);
        this.jyp = inflate.findViewById(R.id.frs_header_title_container);
        this.jyn = (TbImageView) inflate.findViewById(R.id.frs_head_image);
        this.titleText = (TextView) inflate.findViewById(R.id.frs_header_title);
        this.jyo = (TextView) inflate.findViewById(R.id.frs_header_title_lable);
        this.jyq = inflate.findViewById(R.id.frs_image_header_contianer);
        this.jyn.setOnClickListener(this);
        this.jyp.setOnClickListener(this);
        this.jyq.setOnClickListener(this);
        this.jyn.setDefaultResource(0);
        this.jyn.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.jyn.setConrers(15);
        this.jyn.setPlaceHolder(2);
        this.jyo.setText(getContext().getString(R.string.frs_header_image_lable));
        this.mPageContext = getTbPageContext();
    }

    public void setTitle(String str) {
        if (this.titleText != null && this.jyo != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.jyo.setVisibility(0);
                this.titleText.setVisibility(0);
                return;
            }
            this.jyo.setVisibility(8);
            this.titleText.setVisibility(8);
        }
    }

    public void setSchemaUrl(String str) {
        this.jyr = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext = getTbPageContext();
        if (!TextUtils.isEmpty(this.jyr) && tbPageContext != null) {
            be.bsB().a(tbPageContext, new String[]{this.jyr}, true);
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
