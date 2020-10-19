package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes22.dex */
public class b extends com.baidu.tieba.card.b<c> {
    protected ConstrainImageGroup hFM;
    private TbImageView iva;
    private TextView ivb;
    private TextView ivc;
    private c ivd;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.iva = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.ivb = (TextView) view.findViewById(R.id.ad_title);
        this.ivc = (TextView) view.findViewById(R.id.ad_desc);
        this.hFM = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.ivb, R.color.cp_cont_b);
            ap.setViewTextColor(this.ivc, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.hFM.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.hFM != null) {
            this.hFM.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hFM != null) {
            this.hFM.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hFM != null) {
            this.hFM.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.ivd = cVar;
            this.iva.setPlaceHolder(1);
            this.iva.startLoad(cVar.cvi(), 10, false);
            this.iva.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.iva.setDrawerType(1);
            this.iva.setDrawBorder(true);
            this.iva.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iva.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.iva.setDefaultResource(R.drawable.transparent_bg);
            this.iva.setDefaultBgResource(R.drawable.transparent_bg);
            this.ivb.setText(cVar.cvj());
            this.ivc.setText(cVar.cvk());
            ap.setViewTextColor(this.ivb, R.color.cp_cont_b);
            ap.setViewTextColor(this.ivc, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.cvl()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.x(1.0d);
                this.hFM.setVisibility(0);
                this.hFM.setFromCDN(true);
                this.hFM.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.hFM.setImageProcessor(fVar);
                this.hFM.setImageMediaList(cVar.cvl());
                if (!cVar.cvm()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.hFM.setVisibility(8);
            if (!cVar.cvm()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.mDivider.setLayoutParams(layoutParams2);
                ap.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
                this.mDivider.setVisibility(0);
                return;
            }
            this.mDivider.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
