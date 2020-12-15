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
    private TbImageView iYZ;
    private TextView iZa;
    private TextView iZb;
    private c iZc;
    protected ConstrainImageGroup ijF;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.iYZ = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.iZa = (TextView) view.findViewById(R.id.ad_title);
        this.iZb = (TextView) view.findViewById(R.id.ad_desc);
        this.ijF = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.iZa, R.color.CAM_X0105);
            ap.setViewTextColor(this.iZb, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.ijF.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.ijF != null) {
            this.ijF.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ijF != null) {
            this.ijF.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ijF != null) {
            this.ijF.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.iZc = cVar;
            this.iYZ.setPlaceHolder(1);
            this.iYZ.startLoad(cVar.cEK(), 10, false);
            this.iYZ.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.iYZ.setDrawerType(1);
            this.iYZ.setDrawBorder(true);
            this.iYZ.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.iYZ.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.iYZ.setDefaultResource(R.drawable.transparent_bg);
            this.iYZ.setDefaultBgResource(R.drawable.transparent_bg);
            this.iZa.setText(cVar.cEL());
            this.iZb.setText(cVar.cEM());
            ap.setViewTextColor(this.iZa, R.color.CAM_X0105);
            ap.setViewTextColor(this.iZb, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.cEN()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.x(1.0d);
                this.ijF.setVisibility(0);
                this.ijF.setFromCDN(true);
                this.ijF.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.ijF.setImageProcessor(fVar);
                this.ijF.setImageMediaList(cVar.cEN());
                if (!cVar.cEO()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.ijF.setVisibility(8);
            if (!cVar.cEO()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.mDivider.setLayoutParams(layoutParams2);
                ap.setBackgroundColor(this.mDivider, R.color.CAM_X0204);
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
