package com.baidu.tieba.frs.ad;

import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tbadk.widget.layout.ConstrainImageGroup;
import com.baidu.tbadk.widget.layout.ConstrainImageLayout;
import com.baidu.tieba.R;
/* loaded from: classes9.dex */
public class b extends com.baidu.tieba.card.a<c> {
    protected ConstrainImageGroup gpx;
    private TbImageView hdb;
    private TextView hdc;
    private TextView hdd;
    private c hde;
    private RelativeLayout mContainer;
    private View mDivider;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        View view = getView();
        this.hdb = (TbImageView) view.findViewById(R.id.ad_portrait);
        this.hdc = (TextView) view.findViewById(R.id.ad_title);
        this.hdd = (TextView) view.findViewById(R.id.ad_desc);
        this.gpx = (ConstrainImageGroup) view.findViewById(R.id.ad_img_layout);
        this.mDivider = view.findViewById(R.id.item_divider);
        this.mContainer = (RelativeLayout) view.findViewById(R.id.frs_ad_list_item_view);
        view.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.hdc, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hdd, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            this.gpx.onChangeSkinType();
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.frs_ad_list_item_view;
    }

    public void setSingleImageRatio(double d) {
        if (this.gpx != null) {
            this.gpx.setSingleImageRatio(d);
        }
    }

    public void setConstrainLayoutPool(com.baidu.adp.lib.d.b<ConstrainImageLayout> bVar) {
        if (this.gpx != null) {
            this.gpx.setConstrainLayoutPool(bVar);
        }
    }

    public void setConstrainImagePool(com.baidu.adp.lib.d.b<TbImageView> bVar) {
        if (this.gpx != null) {
            this.gpx.setImageViewPool(bVar);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(c cVar) {
        if (cVar != null) {
            this.hde = cVar;
            this.hdb.setPlaceHolder(1);
            this.hdb.startLoad(cVar.bQJ(), 10, false);
            this.hdb.setRadius(l.getDimens(getContext(), R.dimen.tbds26));
            this.hdb.setDrawerType(1);
            this.hdb.setDrawBorder(true);
            this.hdb.setBorderColor(am.getColor(R.color.black_alpha15));
            this.hdb.setBorderWidth(l.getDimens(getContext(), R.dimen.tbds1));
            this.hdb.setDefaultResource(R.drawable.transparent_bg);
            this.hdb.setDefaultBgResource(R.drawable.transparent_bg);
            this.hdc.setText(cVar.bQK());
            this.hdd.setText(cVar.bQL());
            am.setViewTextColor(this.hdc, (int) R.color.cp_cont_b);
            am.setViewTextColor(this.hdd, (int) R.color.cp_cont_d);
            am.setBackgroundResource(this.mContainer, R.drawable.ad_list_item_bg);
            if (v.getCount(cVar.bQM()) > 0) {
                com.baidu.tbadk.widget.layout.f fVar = new com.baidu.tbadk.widget.layout.f(3);
                fVar.n(1.0d);
                this.gpx.setVisibility(0);
                this.gpx.setFromCDN(true);
                this.gpx.setImageMargin(TbadkCoreApplication.getInst().getResources().getDimensionPixelSize(R.dimen.tbds20));
                this.gpx.setImageProcessor(fVar);
                this.gpx.setImageMediaList(cVar.bQM());
                if (!cVar.bQN()) {
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds16));
                    layoutParams.addRule(12);
                    this.mDivider.setLayoutParams(layoutParams);
                    am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
                    this.mDivider.setVisibility(0);
                    return;
                }
                this.mDivider.setVisibility(8);
                return;
            }
            this.gpx.setVisibility(8);
            if (!cVar.bQN()) {
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, l.getDimens(getContext(), R.dimen.tbds1));
                layoutParams2.addRule(12);
                this.mDivider.setLayoutParams(layoutParams2);
                am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
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
