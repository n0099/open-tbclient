package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.b<c> {
    protected ConstrainImageGroup gRn;
    private TbImageView hEQ;
    private TextView hER;
    private TextView hES;
    private c hET;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.hEQ = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.hER = (TextView) view.findViewById(R.id.ad_title);
        this.hES = (TextView) view.findViewById(R.id.ad_desc);
        this.gRn = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            an.setViewTextColor(this.hER, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.hES, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.gRn.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.gRn != null) {
            this.gRn.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gRn != null) {
            this.gRn.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gRn != null) {
            this.gRn.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(c cVar) {
        if (cVar != null) {
            this.hET = cVar;
            this.hEQ.setPlaceHolder(1);
            this.hEQ.startLoad(cVar.cat(), 10, false);
            this.hEQ.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.hEQ.setDrawerType(1);
            this.hEQ.setDrawBorder(true);
            this.hEQ.setBorderColor(an.getColor(R.color.black_alpha15));
            this.hEQ.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.hEQ.setDefaultResource(R.drawable.transparent_bg);
            this.hEQ.setDefaultBgResource(R.drawable.transparent_bg);
            this.hER.setText(cVar.cau());
            this.hES.setText(cVar.cav());
            an.setViewTextColor(this.hER, (int) R.color.cp_cont_b);
            an.setViewTextColor(this.hES, (int) R.color.cp_cont_d);
            an.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (w.getCount(cVar.caw()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.o(1.0d);
                this.gRn.setVisibility(0);
                this.gRn.setFromCDN(true);
                this.gRn.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.gRn.setImageProcessor(fVar);
                this.gRn.setImageMediaList(cVar.caw());
                if (!cVar.cax()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.gRn.setVisibility(8);
            if (!cVar.cax()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.mDivider.setLayoutParams(layoutParams2);
                an.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
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
