package com.baidu.tieba.ala.alasquare.live_tab.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.baidu.adp.lib.util.l;
import com.baidu.ala.data.SdkLiveInfoData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.y;
import com.baidu.tieba.R;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerAdapter;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerRecyclerView;
import com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder;
/* loaded from: classes10.dex */
public class b extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.b.c> {
    private View dBb;
    private View eVm;
    private AlaBannerRecyclerView gEk;
    private AlaBannerRecyclerAdapter gEl;
    private int gEm;
    private int gEn;
    private int[] gEo;
    private boolean gEp;
    private com.baidu.tieba.ala.alasquare.widget.banner.a gEq;
    private TextView mTitle;

    public b(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.gEp = false;
        this.gEq = new com.baidu.tieba.ala.alasquare.widget.banner.a() { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1
            @Override // com.baidu.tieba.ala.alasquare.widget.banner.a
            public AlaBannerViewHolder t(ViewGroup viewGroup2, int i) {
                return new AlaBannerViewHolder<SdkLiveInfoData>(LayoutInflater.from(b.this.getContext()).inflate(R.layout.tab_live_official_recom_live_scroll_item_view, viewGroup2, false)) { // from class: com.baidu.tieba.ala.alasquare.live_tab.view.b.1.1
                    private View gEs;
                    private View gEt;
                    private TabLiveStageLiveView gEu;
                    private int gEv;
                    private int gEw;

                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    protected void am(View view) {
                        this.gEu = (TabLiveStageLiveView) view.findViewById(R.id.stage_live_view);
                        this.gEs = view.findViewById(R.id.recom_live_item_left_space);
                        this.gEt = view.findViewById(R.id.recom_live_item_right_space);
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    /* renamed from: a */
                    public void k(int i2, SdkLiveInfoData sdkLiveInfoData) {
                        this.gEu.setData(sdkLiveInfoData, 102);
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEs.getLayoutParams();
                        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.gEt.getLayoutParams();
                        if (i2 == 0) {
                            if (b.this.gEp) {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                layoutParams2.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gEt.setVisibility(0);
                            } else {
                                layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds44);
                                this.gEt.setVisibility(8);
                            }
                        } else {
                            layoutParams.width = b.this.mTbPageContext.getResources().getDimensionPixelSize(R.dimen.tbds12);
                            if (b.this.gEl.getItemCount() - 1 == i2) {
                                this.gEt.setVisibility(0);
                            } else {
                                this.gEt.setVisibility(8);
                            }
                        }
                        this.gEs.setLayoutParams(layoutParams);
                        this.gEt.setLayoutParams(layoutParams2);
                        bRY();
                        ar arVar = new ar("c13558");
                        arVar.dR("entryname", "推荐");
                        TiebaStatic.log(arVar);
                    }

                    /* JADX INFO: Access modifiers changed from: protected */
                    @Override // com.baidu.tieba.ala.alasquare.widget.banner.AlaBannerViewHolder
                    public void onChangeSkinType(int i2) {
                        this.gEu.onChangeSkinType();
                    }

                    private void bRY() {
                        this.gEv = b.this.getRealWidth();
                        this.gEw = b.this.getRealHeight();
                        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEu.getLayoutParams();
                        if (layoutParams == null) {
                            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(this.gEv, this.gEw);
                        } else {
                            layoutParams.width = this.gEv;
                            layoutParams.height = this.gEw;
                        }
                        layoutParams.gravity = 1;
                        this.gEu.setLayoutParams(layoutParams);
                    }
                };
            }
        };
        this.gEp = false;
        this.gEm = (int) (l.getEquipmentWidth(getContext()) * 0.76d);
        this.gEn = (int) ((this.gEm * 9.0d) / 16.0d);
        this.gEo = com.baidu.tieba.ala.alasquare.live_tab.c.fU(this.mContext);
        initView();
    }

    private void initView() {
        this.dBb = getView().findViewById(R.id.recom_live_divider);
        this.mTitle = (TextView) getView().findViewById(R.id.recom_live_title);
        this.eVm = getView().findViewById(R.id.recom_live_bottom_divider);
        this.gEk = (AlaBannerRecyclerView) getView().findViewById(R.id.recycle_view);
        this.gEk.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
        bRX();
        this.gEl = new AlaBannerRecyclerAdapter(getContext(), this.gEq, false);
        this.gEk.setAdapter(this.gEl);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealWidth() {
        return this.gEp ? this.gEo[0] : this.gEm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getRealHeight() {
        return this.gEp ? this.gEo[1] : this.gEn;
    }

    private void bRX() {
        int realHeight = getRealHeight();
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.gEk.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = (LinearLayout.LayoutParams) new ViewGroup.LayoutParams(-1, realHeight);
        } else {
            layoutParams.width = -1;
            layoutParams.height = realHeight;
        }
        this.gEk.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext tbPageContext, int i) {
        ap.setBackgroundColor(this.dBb, R.color.CAM_X0204);
        ap.setBackgroundColor(this.eVm, R.color.CAM_X0204);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0105);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_live_official_recom_live_item_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.b.c cVar) {
        if (cVar != null && cVar.gAY != null) {
            this.gEp = y.getCount(cVar.gAY.gAW) == 1;
            bRX();
            this.gEl.setData(cVar.gAY.gAW);
            this.gEl.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }
}
