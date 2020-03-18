package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.v;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
/* loaded from: classes3.dex */
public class b extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View cVI;
    private AlaBannerRecyclerView epq;
    private com.baidu.tieba.ala.alasquare.widget.banner.a epr;
    private int eps;
    private int ept;
    private int[] epu;
    private boolean epv;
    private com.baidu.tieba.ala.alasquare.widget.banner.c epw;
    private View mDivider;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.epv = false;
        this.epw = new com.baidu.tieba.ala.alasquare.widget.banner.c() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.c
            public com.baidu.tieba.ala.alasquare.widget.banner.b m(ViewGroup viewGroup2, int i) {
                return new com.baidu.tieba.ala.alasquare.widget.banner.b<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private TabLiveStageLiveView epA;
                    private int epB;
                    private int epC;
                    private View epy;
                    private View epz;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    protected void initView(View view) {
                        this.epA = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.epy = view.findViewById(R.id.recom_live_item_left_space);
                        this.epz = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    /* renamed from: a */
                    public void h(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.epA.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epy.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.epz.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.epv) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.epz.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.epz.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.epr.getItemCount() - 1 == i2) {
                                this.epz.setVisibility(0);
                            } else {
                                this.epz.setVisibility(8);
                            }
                        }
                        this.epy.setLayoutParams(layoutParams);
                        this.epz.setLayoutParams(layoutParams2);
                        bcZ();
                        an anVar = new an("c13558");
                        anVar.cx("entryname", "推荐");
                        TiebaStatic.log(anVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.b
                    public void onChangeSkinType(int i2) {
                        this.epA.onChangeSkinType();
                    }

                    private void bcZ() {
                        this.epB = b.this.getRealWidth();
                        this.epC = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epA.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.epB, this.epC);
                        } else {
                            layoutParams.width = this.epB;
                            layoutParams.height = this.epC;
                        }
                        layoutParams.gravity = 1;
                        this.epA.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.epv = false;
        this.eps = (int) (com.baidu.adp.lib.util.l.getEquipmentWidth(getContext()) * 0.76d);
        this.ept = (int) ((this.eps * 9.0d) / 16.0d);
        this.epu = com.baidu.tieba.ala.alasquare.live_tab.c.eE(this.mContext);
        initView();
    }

    private void initView() {
        this.mDivider = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.cVI = getView().findViewById(R.id.recom_live_bottom_divider);
        this.epq = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.epq.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bcY();
        this.epr = new com.baidu.tieba.ala.alasquare.widget.banner.a(getContext(), this.epw, false);
        this.epq.setAdapter(this.epr);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.epv ? this.epu[0] : this.eps;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.epv ? this.epu[1] : this.ept;
    }

    private void bcY() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.epq.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.epq.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        am.setBackgroundColor(getView(), R.color.cp_bg_line_d);
        am.setBackgroundColor(this.mDivider, R.color.cp_bg_line_c);
        am.setBackgroundColor(this.cVI, R.color.cp_bg_line_c);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_b);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.eml != null) {
            this.epv = v.getCount(cVar.eml.emj) == 1;
            bcY();
            this.epr.setData(cVar.eml.emj);
            this.epr.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
