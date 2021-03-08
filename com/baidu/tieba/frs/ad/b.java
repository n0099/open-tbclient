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
    private View dCC;
    protected ConstrainImageGroup iyU;
    private TbImageView jok;
    private TextView jol;
    private TextView jom;
    private c jon;
    private RelativeLayout mContainer;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.jok = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.jol = (TextView) view.findViewById(R.id.ad_title);
        this.jom = (TextView) view.findViewById(R.id.ad_desc);
        this.iyU = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.dCC = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ap.setViewTextColor(this.jol, R.color.CAM_X0105);
            ap.setViewTextColor(this.jom, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.iyU.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.iyU != null) {
            this.iyU.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.iyU != null) {
            this.iyU.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.iyU != null) {
            this.iyU.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.jon = cVar;
            this.jok.setPlaceHolder(1);
            this.jok.startLoad(cVar.cFn(), 10, false);
            this.jok.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.jok.setDrawerType(1);
            this.jok.setDrawBorder(true);
            this.jok.setBorderColor(ap.getColor(R.color.black_alpha15));
            this.jok.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.jok.setDefaultResource(R.drawable.transparent_bg);
            this.jok.setDefaultBgResource(R.drawable.transparent_bg);
            this.jol.setText(cVar.cFo());
            this.jom.setText(cVar.cFp());
            ap.setViewTextColor(this.jol, R.color.CAM_X0105);
            ap.setViewTextColor(this.jom, R.color.CAM_X0109);
            ap.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (y.getCount(cVar.cFq()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.r(1.0d);
                this.iyU.setVisibility(0);
                this.iyU.setFromCDN(true);
                this.iyU.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.iyU.setImageProcessor(fVar);
                this.iyU.setImageMediaList(cVar.cFq());
                if (!cVar.cFr()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.dCC.setLayoutParams(layoutParams);
                    ap.setBackgroundColor(this.dCC, R.color.CAM_X0204);
                    this.dCC.setVisibility(0);
                    return;
                }
                this.dCC.setVisibility(8);
                return;
            }
            this.iyU.setVisibility(8);
            if (!cVar.cFr()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.dCC.setLayoutParams(layoutParams2);
                ap.setBackgroundColor(this.dCC, R.color.CAM_X0204);
                this.dCC.setVisibility(0);
                return;
            }
            this.dCC.setVisibility(8);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
