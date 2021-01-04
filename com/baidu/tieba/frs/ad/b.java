package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.b<c> {
    private View dDI;
    protected ConstrainImageGroup iwa;
    private TbImageView jlm;
    private TextView jln;
    private TextView jlo;
    private c jlp;
    private RelativeLayout mContainer;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.jlm = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.jln = (TextView) view.findViewById(R.id.ad_title);
        this.jlo = (TextView) view.findViewById(R.id.ad_desc);
        this.iwa = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.dDI = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.jln, R.color.CAM_X0105);
            ao.setViewTextColor(this.jlo, R.color.CAM_X0109);
            ao.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.iwa.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.iwa != null) {
            this.iwa.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwa != null) {
            this.iwa.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwa != null) {
            this.iwa.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.jlp = cVar;
            this.jlm.setPlaceHolder(1);
            this.jlm.startLoad(cVar.cHF(), 10, false);
            this.jlm.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.jlm.setDrawerType(1);
            this.jlm.setDrawBorder(true);
            this.jlm.setBorderColor(ao.getColor(R.color.black_alpha15));
            this.jlm.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.jlm.setDefaultResource(R.drawable.transparent_bg);
            this.jlm.setDefaultBgResource(R.drawable.transparent_bg);
            this.jln.setText(cVar.cHG());
            this.jlo.setText(cVar.cHH());
            ao.setViewTextColor(this.jln, R.color.CAM_X0105);
            ao.setViewTextColor(this.jlo, R.color.CAM_X0109);
            ao.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (x.getCount(cVar.cHI()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.x(1.0d);
                this.iwa.setVisibility(0);
                this.iwa.setFromCDN(true);
                this.iwa.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.iwa.setImageProcessor(fVar);
                this.iwa.setImageMediaList(cVar.cHI());
                if (!cVar.cHJ()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.dDI.setLayoutParams(layoutParams);
                    ao.setBackgroundColor(this.dDI, R.color.CAM_X0204);
                    this.dDI.setVisibility(0);
                    return;
                }
                this.dDI.setVisibility(8);
                return;
            }
            this.iwa.setVisibility(8);
            if (!cVar.cHJ()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.dDI.setLayoutParams(layoutParams2);
                ao.setBackgroundColor(this.dDI, R.color.CAM_X0204);
                this.dDI.setVisibility(0);
                return;
            }
            this.dDI.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
