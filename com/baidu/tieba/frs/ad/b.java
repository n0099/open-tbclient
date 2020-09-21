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
/* loaded from: classes21.dex */
public class b extends com.baidu.tieba.card.b<c> {
    protected ConstrainImageGroup hqS;
    private TbImageView igd;
    private TextView ige;
    private TextView igf;
    private c igg;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.igd = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.ige = (TextView) view.findViewById(R.id.ad_title);
        this.igf = (TextView) view.findViewById(R.id.ad_desc);
        this.hqS = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.ige, R.color.cp_cont_b);
            ap.setViewTextColor(this.igf, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.hqS.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.hqS != null) {
            this.hqS.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.hqS != null) {
            this.hqS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.hqS != null) {
            this.hqS.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.igg = cVar;
            this.igd.setPlaceHolder(1);
            this.igd.startLoad(cVar.crK(), 10, false);
            this.igd.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.igd.setDrawerType(1);
            this.igd.setDrawBorder(true);
            this.igd.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.igd.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.igd.setDefaultResource(R.drawable.transparent_bg);
            this.igd.setDefaultBgResource(R.drawable.transparent_bg);
            this.ige.setText(cVar.crL());
            this.igf.setText(cVar.crM());
            ap.setViewTextColor(this.ige, R.color.cp_cont_b);
            ap.setViewTextColor(this.igf, R.color.cp_cont_d);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.crN()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.u(1.0d);
                this.hqS.setVisibility(0);
                this.hqS.setFromCDN(true);
                this.hqS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.hqS.setImageProcessor(fVar);
                this.hqS.setImageMediaList(cVar.crN());
                if (!cVar.crO()) {
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
            this.hqS.setVisibility(8);
            if (!cVar.crO()) {
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
