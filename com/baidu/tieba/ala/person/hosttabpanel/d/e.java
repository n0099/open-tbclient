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
/* loaded from: classes7.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout gQD;
    private LinearLayout gQE;
    private TbImageView gQF;
    private TbImageView gQG;
    private TextView gQH;
    private TextView gQI;
    private TextView gQJ;
    private TextView gQK;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gQD = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.gQE = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.gQD);
        b(this.gQE);
        this.gQD.setOnClickListener(this);
        this.gQE.setOnClickListener(this);
        this.gQF = (TbImageView) this.gQD.findViewById(a.g.replay_cover);
        this.gQF.setDefaultErrorResource(0);
        this.gQF.setAutoChangeStyle(false);
        this.gQF.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gQH = (TextView) this.gQD.findViewById(a.g.replay_title);
        this.gQJ = (TextView) this.gQD.findViewById(a.g.replay_info);
        this.gQG = (TbImageView) this.gQE.findViewById(a.g.replay_cover);
        this.gQG.setDefaultErrorResource(0);
        this.gQG.setAutoChangeStyle(false);
        this.gQG.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gQI = (TextView) this.gQE.findViewById(a.g.replay_title);
        this.gQK = (TextView) this.gQE.findViewById(a.g.replay_info);
    }

    private void b(LinearLayout linearLayout) {
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
        if (dVar.gPF != null) {
            this.gQD.setVisibility(0);
            this.gQF.startLoad(StringUtils.isNull(dVar.gPF.getMedia_pic()) ? dVar.gPF.getLiveCover() : dVar.gPF.getMedia_pic(), 10, false);
            this.gQJ.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.en(dVar.gPF.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gPF.end_time));
            this.gQH.setText(dVar.gPF.getLiveTitle());
            this.gQD.setTag(dVar.gPF);
        } else {
            this.gQD.setVisibility(4);
        }
        if (dVar.gPG != null) {
            this.gQE.setVisibility(0);
            this.gQG.startLoad(StringUtils.isNull(dVar.gPG.getMedia_pic()) ? dVar.gPG.getLiveCover() : dVar.gPG.getMedia_pic(), 10, false);
            this.gQK.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.en(dVar.gPG.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gPG.end_time));
            this.gQI.setText(dVar.gPG.getLiveTitle());
            this.gQE.setTag(dVar.gPG);
            return;
        }
        this.gQE.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gQD) {
            aA(this.gQD.getTag());
        } else if (view == this.gQE) {
            aA(this.gQE.getTag());
        }
    }

    private void aA(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes7.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e gQL;

        public a(e eVar) {
            super(eVar.getView());
            this.gQL = eVar;
        }
    }
}
