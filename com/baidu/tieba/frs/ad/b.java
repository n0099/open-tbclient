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
    private View dyW;
    protected ConstrainImageGroup irt;
    private TbImageView jgF;
    private TextView jgG;
    private TextView jgH;
    private c jgI;
    private RelativeLayout mContainer;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.jgF = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.jgG = (TextView) view.findViewById(R.id.ad_title);
        this.jgH = (TextView) view.findViewById(R.id.ad_desc);
        this.irt = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.dyW = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.jgG, R.color.CAM_X0105);
            ao.setViewTextColor(this.jgH, R.color.CAM_X0109);
            ao.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.irt.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.irt != null) {
            this.irt.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.irt != null) {
            this.irt.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.irt != null) {
            this.irt.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.jgI = cVar;
            this.jgF.setPlaceHolder(1);
            this.jgF.startLoad(cVar.cDO(), 10, false);
            this.jgF.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.jgF.setDrawerType(1);
            this.jgF.setDrawBorder(true);
            this.jgF.setBorderColor(ao.getColor(R.color.black_alpha15));
            this.jgF.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.jgF.setDefaultResource(R.drawable.transparent_bg);
            this.jgF.setDefaultBgResource(R.drawable.transparent_bg);
            this.jgG.setText(cVar.cDP());
            this.jgH.setText(cVar.cDQ());
            ao.setViewTextColor(this.jgG, R.color.CAM_X0105);
            ao.setViewTextColor(this.jgH, R.color.CAM_X0109);
            ao.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (x.getCount(cVar.cDR()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.r(1.0d);
                this.irt.setVisibility(0);
                this.irt.setFromCDN(true);
                this.irt.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.irt.setImageProcessor(fVar);
                this.irt.setImageMediaList(cVar.cDR());
                if (!cVar.cDS()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.dyW.setLayoutParams(layoutParams);
                    ao.setBackgroundColor(this.dyW, R.color.CAM_X0204);
                    this.dyW.setVisibility(0);
                    return;
                }
                this.dyW.setVisibility(8);
                return;
            }
            this.irt.setVisibility(8);
            if (!cVar.cDS()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.dyW.setLayoutParams(layoutParams2);
                ao.setBackgroundColor(this.dyW, R.color.CAM_X0204);
                this.dyW.setVisibility(0);
                return;
            }
            this.dyW.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
