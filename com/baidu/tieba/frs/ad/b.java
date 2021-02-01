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
    protected ConstrainImageGroup iwX;
    private TbImageView jmm;
    private TextView jmn;
    private TextView jmo;
    private c jmq;
    private RelativeLayout mContainer;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.jmm = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.jmn = (TextView) view.findViewById(R.id.ad_title);
        this.jmo = (TextView) view.findViewById(R.id.ad_desc);
        this.iwX = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.dBb = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jmn, R.color.CAM_X0105);
            ap.setViewTextColor(this.jmo, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.iwX.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.iwX != null) {
            this.iwX.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iwX != null) {
            this.iwX.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iwX != null) {
            this.iwX.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.jmq = cVar;
            this.jmm.setPlaceHolder(1);
            this.jmm.startLoad(cVar.cFa(), 10, false);
            this.jmm.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.jmm.setDrawerType(1);
            this.jmm.setDrawBorder(true);
            this.jmm.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jmm.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.jmm.setDefaultResource(R.drawable.transparent_bg);
            this.jmm.setDefaultBgResource(R.drawable.transparent_bg);
            this.jmn.setText(cVar.cFb());
            this.jmo.setText(cVar.cFc());
            ap.setViewTextColor(this.jmn, R.color.CAM_X0105);
            ap.setViewTextColor(this.jmo, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.cFd()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.r(1.0d);
                this.iwX.setVisibility(0);
                this.iwX.setFromCDN(true);
                this.iwX.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.iwX.setImageProcessor(fVar);
                this.iwX.setImageMediaList(cVar.cFd());
                if (!cVar.cFe()) {
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
            this.iwX.setVisibility(8);
            if (!cVar.cFe()) {
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
