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
    private LinearLayout fWJ;
    private LinearLayout fWK;
    private TbImageView fWL;
    private TbImageView fWM;
    private TextView fWN;
    private TextView fWO;
    private TextView fWP;
    private TextView fWQ;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.fWJ = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.fWK = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.fWJ);
        b(this.fWK);
        this.fWJ.setOnClickListener(this);
        this.fWK.setOnClickListener(this);
        this.fWL = (TbImageView) this.fWJ.findViewById(a.g.replay_cover);
        this.fWL.setDefaultErrorResource(0);
        this.fWL.setAutoChangeStyle(false);
        this.fWL.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.fWN = (TextView) this.fWJ.findViewById(a.g.replay_title);
        this.fWP = (TextView) this.fWJ.findViewById(a.g.replay_info);
        this.fWM = (TbImageView) this.fWK.findViewById(a.g.replay_cover);
        this.fWM.setDefaultErrorResource(0);
        this.fWM.setAutoChangeStyle(false);
        this.fWM.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.fWO = (TextView) this.fWK.findViewById(a.g.replay_title);
        this.fWQ = (TextView) this.fWK.findViewById(a.g.replay_info);
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
        if (dVar.fVL != null) {
            this.fWJ.setVisibility(0);
            this.fWL.startLoad(StringUtils.isNull(dVar.fVL.getMedia_pic()) ? dVar.fVL.getLiveCover() : dVar.fVL.getMedia_pic(), 10, false);
            this.fWP.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dL(dVar.fVL.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fVL.end_time));
            this.fWN.setText(dVar.fVL.getLiveTitle());
            this.fWJ.setTag(dVar.fVL);
        } else {
            this.fWJ.setVisibility(4);
        }
        if (dVar.fVM != null) {
            this.fWK.setVisibility(0);
            this.fWM.startLoad(StringUtils.isNull(dVar.fVM.getMedia_pic()) ? dVar.fVM.getLiveCover() : dVar.fVM.getMedia_pic(), 10, false);
            this.fWQ.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dL(dVar.fVM.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fVM.end_time));
            this.fWO.setText(dVar.fVM.getLiveTitle());
            this.fWK.setTag(dVar.fVM);
            return;
        }
        this.fWK.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fWJ) {
            au(this.fWJ.getTag());
        } else if (view == this.fWK) {
            au(this.fWK.getTag());
        }
    }

    private void au(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e fWR;

        public a(e eVar) {
            super(eVar.getView());
            this.fWR = eVar;
        }
    }
}
