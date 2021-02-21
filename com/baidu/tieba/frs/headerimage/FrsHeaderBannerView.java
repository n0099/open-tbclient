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
import com.baidu.tbadk.core.util.bf;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class FrsHeaderBannerView extends LinearLayout implements View.OnClickListener {
    private TbImageView jEg;
    private TextView jEh;
    private View jEi;
    private View jEj;
    private String jEk;
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
        this.jEi = inflate.findViewById(R.id.frs_header_title_container);
        this.jEg = (TbImageView) inflate.findViewById(R.id.frs_head_image);
        this.titleText = (TextView) inflate.findViewById(R.id.frs_header_title);
        this.jEh = (TextView) inflate.findViewById(R.id.frs_header_title_lable);
        this.jEj = inflate.findViewById(R.id.frs_image_header_contianer);
        this.jEg.setOnClickListener(this);
        this.jEi.setOnClickListener(this);
        this.jEj.setOnClickListener(this);
        this.jEg.setDefaultResource(0);
        this.jEg.setRadius(l.getDimens(getContext(), R.dimen.tbds20));
        this.jEg.setConrers(15);
        this.jEg.setPlaceHolder(2);
        this.jEh.setText(getContext().getString(R.string.frs_header_image_lable));
        this.mPageContext = getTbPageContext();
    }

    public void setTitle(String str) {
        if (this.titleText != null && this.jEh != null) {
            if (!TextUtils.isEmpty(str)) {
                this.titleText.setText(str);
                this.jEh.setVisibility(0);
                this.titleText.setVisibility(0);
                return;
            }
            this.jEh.setVisibility(8);
            this.titleText.setVisibility(8);
        }
    }

    public void setSchemaUrl(String str) {
        this.jEk = str;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        TbPageContext<?> tbPageContext = getTbPageContext();
        if (!TextUtils.isEmpty(this.jEk) && tbPageContext != null) {
            bf.bsV().a(tbPageContext, new String[]{this.jEk}, true);
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
