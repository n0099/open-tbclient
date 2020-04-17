package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
import com.baidu.live.u.a;
/* loaded from: classes3.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout fWE;
    private LinearLayout fWF;
    private TbImageView fWG;
    private TbImageView fWH;
    private TextView fWI;
    private TextView fWJ;
    private TextView fWK;
    private TextView fWL;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.fWE = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.fWF = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.fWE);
        b(this.fWF);
        this.fWE.setOnClickListener(this);
        this.fWF.setOnClickListener(this);
        this.fWG = (TbImageView) this.fWE.findViewById(a.g.replay_cover);
        this.fWG.setDefaultErrorResource(0);
        this.fWG.setAutoChangeStyle(false);
        this.fWG.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.fWI = (TextView) this.fWE.findViewById(a.g.replay_title);
        this.fWK = (TextView) this.fWE.findViewById(a.g.replay_info);
        this.fWH = (TbImageView) this.fWF.findViewById(a.g.replay_cover);
        this.fWH.setDefaultErrorResource(0);
        this.fWH.setAutoChangeStyle(false);
        this.fWH.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.fWJ = (TextView) this.fWF.findViewById(a.g.replay_title);
        this.fWL = (TextView) this.fWF.findViewById(a.g.replay_info);
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
        if (dVar.fVG != null) {
            this.fWE.setVisibility(0);
            this.fWG.startLoad(StringUtils.isNull(dVar.fVG.getMedia_pic()) ? dVar.fVG.getLiveCover() : dVar.fVG.getMedia_pic(), 10, false);
            this.fWK.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dL(dVar.fVG.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fVG.end_time));
            this.fWI.setText(dVar.fVG.getLiveTitle());
            this.fWE.setTag(dVar.fVG);
        } else {
            this.fWE.setVisibility(4);
        }
        if (dVar.fVH != null) {
            this.fWF.setVisibility(0);
            this.fWH.startLoad(StringUtils.isNull(dVar.fVH.getMedia_pic()) ? dVar.fVH.getLiveCover() : dVar.fVH.getMedia_pic(), 10, false);
            this.fWL.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dL(dVar.fVH.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fVH.end_time));
            this.fWJ.setText(dVar.fVH.getLiveTitle());
            this.fWF.setTag(dVar.fVH);
            return;
        }
        this.fWF.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fWE) {
            at(this.fWE.getTag());
        } else if (view == this.fWF) {
            at(this.fWF.getTag());
        }
    }

    private void at(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e fWM;

        public a(e eVar) {
            super(eVar.getView());
            this.fWM = eVar;
        }
    }
}
