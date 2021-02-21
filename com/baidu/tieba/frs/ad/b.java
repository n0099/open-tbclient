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
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.b<c> {
    private View dBb;
    protected ConstrainImageGroup ixl;
    private TbImageView jmB;
    private TextView jmC;
    private TextView jmD;
    private c jmE;
    private RelativeLayout mContainer;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.jmB = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.jmC = (TextView) view.findViewById(R.id.ad_title);
        this.jmD = (TextView) view.findViewById(R.id.ad_desc);
        this.ixl = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.dBb = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jmC, R.color.CAM_X0105);
            ap.setViewTextColor(this.jmD, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.ixl.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.ixl != null) {
            this.ixl.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.ixl != null) {
            this.ixl.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.ixl != null) {
            this.ixl.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.jmE = cVar;
            this.jmB.setPlaceHolder(1);
            this.jmB.startLoad(cVar.cFh(), 10, false);
            this.jmB.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.jmB.setDrawerType(1);
            this.jmB.setDrawBorder(true);
            this.jmB.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jmB.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.jmB.setDefaultResource(R.drawable.transparent_bg);
            this.jmB.setDefaultBgResource(R.drawable.transparent_bg);
            this.jmC.setText(cVar.cFi());
            this.jmD.setText(cVar.cFj());
            ap.setViewTextColor(this.jmC, R.color.CAM_X0105);
            ap.setViewTextColor(this.jmD, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.cFk()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.r(1.0d);
                this.ixl.setVisibility(0);
                this.ixl.setFromCDN(true);
                this.ixl.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.ixl.setImageProcessor(fVar);
                this.ixl.setImageMediaList(cVar.cFk());
                if (!cVar.cFl()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.dBb.setLayoutParams(layoutParams);
                    ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
                    this.dBb.setVisibility(0);
                    return;
                }
                this.dBb.setVisibility(8);
                return;
            }
            this.ixl.setVisibility(8);
            if (!cVar.cFl()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.dBb.setLayoutParams(layoutParams2);
                ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
                this.dBb.setVisibility(0);
                return;
            }
            this.dBb.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
