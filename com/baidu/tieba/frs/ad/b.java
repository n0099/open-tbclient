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
/* loaded from: classes16.dex */
public class b extends com.baidu.tieba.card.b<c> {
    protected ConstrainImageGroup gWS;
    private TbImageView hKO;
    private TextView hKP;
    private TextView hKQ;
    private c hKR;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.hKO = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.hKP = (TextView) view.findViewById(R.id.ad_title);
        this.hKQ = (TextView) view.findViewById(R.id.ad_desc);
        this.gWS = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            ao.setViewTextColor(this.hKP, R.color.cp_cont_b);
            ao.setViewTextColor(this.hKQ, R.color.cp_cont_d);
            ao.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.gWS.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.gWS != null) {
            this.gWS.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gWS != null) {
            this.gWS.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gWS != null) {
            this.gWS.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.hKR = cVar;
            this.hKO.setPlaceHolder(1);
            this.hKO.startLoad(cVar.cdS(), 10, false);
            this.hKO.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.hKO.setDrawerType(1);
            this.hKO.setDrawBorder(true);
            this.hKO.setBorderColor(ao.getColor(R.color.black_alpha15));
            this.hKO.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.hKO.setDefaultResource(R.drawable.transparent_bg);
            this.hKO.setDefaultBgResource(R.drawable.transparent_bg);
            this.hKP.setText(cVar.cdT());
            this.hKQ.setText(cVar.cdU());
            ao.setViewTextColor(this.hKP, R.color.cp_cont_b);
            ao.setViewTextColor(this.hKQ, R.color.cp_cont_d);
            ao.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (x.getCount(cVar.cdV()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.o(1.0d);
                this.gWS.setVisibility(0);
                this.gWS.setFromCDN(true);
                this.gWS.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.gWS.setImageProcessor(fVar);
                this.gWS.setImageMediaList(cVar.cdV());
                if (!cVar.cdW()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.gWS.setVisibility(8);
            if (!cVar.cdW()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.mDivider.setLayoutParams(layoutParams2);
                ao.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
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
