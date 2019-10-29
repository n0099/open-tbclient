package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout evd;
    private LinearLayout eve;
    private TbImageView evf;
    private TbImageView evg;
    private TextView evh;
    private TextView evi;
    private TextView evj;
    private TextView evk;
    private final String evl;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.evl = " | ";
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.evd = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.eve = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        c(this.evd);
        c(this.eve);
        this.evd.setOnClickListener(this);
        this.eve.setOnClickListener(this);
        this.evf = (TbImageView) this.evd.findViewById(a.g.replay_cover);
        this.evf.setDefaultErrorResource(0);
        this.evf.setAutoChangeStyle(false);
        this.evf.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.evh = (TextView) this.evd.findViewById(a.g.replay_title);
        this.evj = (TextView) this.evd.findViewById(a.g.replay_info);
        this.evg = (TbImageView) this.eve.findViewById(a.g.replay_cover);
        this.evg.setDefaultErrorResource(0);
        this.evg.setAutoChangeStyle(false);
        this.evg.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.evi = (TextView) this.eve.findViewById(a.g.replay_title);
        this.evk = (TextView) this.eve.findViewById(a.g.replay_info);
    }

    private void c(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds34);
        layoutParams.width = ((BdUtilHelper.getEquipmentWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getResources().getDimensionPixelSize(a.e.sdk_ds16)) - (dimensionPixelSize * 2)) / 2;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.h.ala_new_host_tab_replay_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.d dVar) {
        if (dVar.eue != null) {
            this.evd.setVisibility(0);
            this.evf.startLoad(StringUtils.isNull(dVar.eue.getMedia_pic()) ? dVar.eue.getLiveCover() : dVar.eue.getMedia_pic(), 10, false);
            this.evj.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.cp(dVar.eue.join_count)) + " | " + StringHelper.getTimeInterval(dVar.eue.end_time));
            this.evh.setText(dVar.eue.getLiveTitle());
            this.evd.setTag(dVar.eue);
        } else {
            this.evd.setVisibility(4);
        }
        if (dVar.euf != null) {
            this.eve.setVisibility(0);
            this.evg.startLoad(StringUtils.isNull(dVar.euf.getMedia_pic()) ? dVar.euf.getLiveCover() : dVar.euf.getMedia_pic(), 10, false);
            this.evk.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.cp(dVar.euf.join_count)) + " | " + StringHelper.getTimeInterval(dVar.euf.end_time));
            this.evi.setText(dVar.euf.getLiveTitle());
            this.eve.setTag(dVar.euf);
            return;
        }
        this.eve.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.evd) {
            aj(this.evd.getTag());
        } else if (view == this.eve) {
            aj(this.eve.getTag());
        }
    }

    private void aj(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes6.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e evm;

        public a(e eVar) {
            super(eVar.getView());
            this.evm = eVar;
        }
    }
}
