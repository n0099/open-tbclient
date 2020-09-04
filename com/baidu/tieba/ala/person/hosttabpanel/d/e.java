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
    private LinearLayout gQH;
    private LinearLayout gQI;
    private TbImageView gQJ;
    private TbImageView gQK;
    private TextView gQL;
    private TextView gQM;
    private TextView gQN;
    private TextView gQO;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gQH = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.gQI = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.gQH);
        b(this.gQI);
        this.gQH.setOnClickListener(this);
        this.gQI.setOnClickListener(this);
        this.gQJ = (TbImageView) this.gQH.findViewById(a.g.replay_cover);
        this.gQJ.setDefaultErrorResource(0);
        this.gQJ.setAutoChangeStyle(false);
        this.gQJ.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gQL = (TextView) this.gQH.findViewById(a.g.replay_title);
        this.gQN = (TextView) this.gQH.findViewById(a.g.replay_info);
        this.gQK = (TbImageView) this.gQI.findViewById(a.g.replay_cover);
        this.gQK.setDefaultErrorResource(0);
        this.gQK.setAutoChangeStyle(false);
        this.gQK.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gQM = (TextView) this.gQI.findViewById(a.g.replay_title);
        this.gQO = (TextView) this.gQI.findViewById(a.g.replay_info);
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
        if (dVar.gPJ != null) {
            this.gQH.setVisibility(0);
            this.gQJ.startLoad(StringUtils.isNull(dVar.gPJ.getMedia_pic()) ? dVar.gPJ.getLiveCover() : dVar.gPJ.getMedia_pic(), 10, false);
            this.gQN.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.en(dVar.gPJ.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gPJ.end_time));
            this.gQL.setText(dVar.gPJ.getLiveTitle());
            this.gQH.setTag(dVar.gPJ);
        } else {
            this.gQH.setVisibility(4);
        }
        if (dVar.gPK != null) {
            this.gQI.setVisibility(0);
            this.gQK.startLoad(StringUtils.isNull(dVar.gPK.getMedia_pic()) ? dVar.gPK.getLiveCover() : dVar.gPK.getMedia_pic(), 10, false);
            this.gQO.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.en(dVar.gPK.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gPK.end_time));
            this.gQM.setText(dVar.gPK.getLiveTitle());
            this.gQI.setTag(dVar.gPK);
            return;
        }
        this.gQI.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gQH) {
            aA(this.gQH.getTag());
        } else if (view == this.gQI) {
            aA(this.gQI.getTag());
        }
    }

    private void aA(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes7.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e gQP;

        public a(e eVar) {
            super(eVar.getView());
            this.gQP = eVar;
        }
    }
}
