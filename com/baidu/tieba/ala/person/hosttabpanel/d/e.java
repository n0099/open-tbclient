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
/* loaded from: classes3.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout gyC;
    private LinearLayout gyD;
    private TbImageView gyE;
    private TbImageView gyF;
    private TextView gyG;
    private TextView gyH;
    private TextView gyI;
    private TextView gyJ;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gyC = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.gyD = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.gyC);
        b(this.gyD);
        this.gyC.setOnClickListener(this);
        this.gyD.setOnClickListener(this);
        this.gyE = (TbImageView) this.gyC.findViewById(a.g.replay_cover);
        this.gyE.setDefaultErrorResource(0);
        this.gyE.setAutoChangeStyle(false);
        this.gyE.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gyG = (TextView) this.gyC.findViewById(a.g.replay_title);
        this.gyI = (TextView) this.gyC.findViewById(a.g.replay_info);
        this.gyF = (TbImageView) this.gyD.findViewById(a.g.replay_cover);
        this.gyF.setDefaultErrorResource(0);
        this.gyF.setAutoChangeStyle(false);
        this.gyF.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gyH = (TextView) this.gyD.findViewById(a.g.replay_title);
        this.gyJ = (TextView) this.gyD.findViewById(a.g.replay_info);
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
        if (dVar.gxF != null) {
            this.gyC.setVisibility(0);
            this.gyE.startLoad(StringUtils.isNull(dVar.gxF.getMedia_pic()) ? dVar.gxF.getLiveCover() : dVar.gxF.getMedia_pic(), 10, false);
            this.gyI.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dP(dVar.gxF.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gxF.end_time));
            this.gyG.setText(dVar.gxF.getLiveTitle());
            this.gyC.setTag(dVar.gxF);
        } else {
            this.gyC.setVisibility(4);
        }
        if (dVar.gxG != null) {
            this.gyD.setVisibility(0);
            this.gyF.startLoad(StringUtils.isNull(dVar.gxG.getMedia_pic()) ? dVar.gxG.getLiveCover() : dVar.gxG.getMedia_pic(), 10, false);
            this.gyJ.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dP(dVar.gxG.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gxG.end_time));
            this.gyH.setText(dVar.gxG.getLiveTitle());
            this.gyD.setTag(dVar.gxG);
            return;
        }
        this.gyD.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gyC) {
            ay(this.gyC.getTag());
        } else if (view == this.gyD) {
            ay(this.gyD.getTag());
        }
    }

    private void ay(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e gyK;

        public a(e eVar) {
            super(eVar.getView());
            this.gyK = eVar;
        }
    }
}
