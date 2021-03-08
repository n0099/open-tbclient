package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes10.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout hYr;
    private LinearLayout hYs;
    private TbImageView hYt;
    private TbImageView hYu;
    private TextView hYv;
    private TextView hYw;
    private TextView hYx;
    private TextView hYy;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hYr = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_one);
        this.hYs = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_two);
        b(this.hYr);
        b(this.hYs);
        this.hYr.setOnClickListener(this);
        this.hYs.setOnClickListener(this);
        this.hYt = (TbImageView) this.hYr.findViewById(a.f.replay_cover);
        this.hYt.setDefaultErrorResource(0);
        this.hYt.setAutoChangeStyle(false);
        this.hYt.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hYv = (TextView) this.hYr.findViewById(a.f.replay_title);
        this.hYx = (TextView) this.hYr.findViewById(a.f.replay_info);
        this.hYu = (TbImageView) this.hYs.findViewById(a.f.replay_cover);
        this.hYu.setDefaultErrorResource(0);
        this.hYu.setAutoChangeStyle(false);
        this.hYu.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hYw = (TextView) this.hYs.findViewById(a.f.replay_title);
        this.hYy = (TextView) this.hYs.findViewById(a.f.replay_info);
    }

    private void b(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds34);
        layoutParams.width = ((BdUtilHelper.getEquipmentWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16)) - (dimensionPixelSize * 2)) / 2;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.ala_new_host_tab_replay_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.d dVar) {
        if (dVar.hXt != null) {
            this.hYr.setVisibility(0);
            this.hYt.startLoad(StringUtils.isNull(dVar.hXt.getMedia_pic()) ? dVar.hXt.getLiveCover() : dVar.hXt.getMedia_pic(), 10, false);
            this.hYx.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bg(dVar.hXt.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hXt.end_time));
            this.hYv.setText(dVar.hXt.getLiveTitle());
            this.hYr.setTag(dVar.hXt);
        } else {
            this.hYr.setVisibility(4);
        }
        if (dVar.hXu != null) {
            this.hYs.setVisibility(0);
            this.hYu.startLoad(StringUtils.isNull(dVar.hXu.getMedia_pic()) ? dVar.hXu.getLiveCover() : dVar.hXu.getMedia_pic(), 10, false);
            this.hYy.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bg(dVar.hXu.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hXu.end_time));
            this.hYw.setText(dVar.hXu.getLiveTitle());
            this.hYs.setTag(dVar.hXu);
            return;
        }
        this.hYs.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hYr) {
            aJ(this.hYr.getTag());
        } else if (view == this.hYs) {
            aJ(this.hYs.getTag());
        }
    }

    private void aJ(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hYz;

        public a(e eVar) {
            super(eVar.getView());
            this.hYz = eVar;
        }
    }
}
