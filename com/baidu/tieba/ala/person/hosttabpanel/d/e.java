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
    private LinearLayout glD;
    private LinearLayout glE;
    private TbImageView glF;
    private TbImageView glG;
    private TextView glH;
    private TextView glI;
    private TextView glJ;
    private TextView glK;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.glD = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.glE = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.glD);
        b(this.glE);
        this.glD.setOnClickListener(this);
        this.glE.setOnClickListener(this);
        this.glF = (TbImageView) this.glD.findViewById(a.g.replay_cover);
        this.glF.setDefaultErrorResource(0);
        this.glF.setAutoChangeStyle(false);
        this.glF.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.glH = (TextView) this.glD.findViewById(a.g.replay_title);
        this.glJ = (TextView) this.glD.findViewById(a.g.replay_info);
        this.glG = (TbImageView) this.glE.findViewById(a.g.replay_cover);
        this.glG.setDefaultErrorResource(0);
        this.glG.setAutoChangeStyle(false);
        this.glG.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.glI = (TextView) this.glE.findViewById(a.g.replay_title);
        this.glK = (TextView) this.glE.findViewById(a.g.replay_info);
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
        if (dVar.gkG != null) {
            this.glD.setVisibility(0);
            this.glF.startLoad(StringUtils.isNull(dVar.gkG.getMedia_pic()) ? dVar.gkG.getLiveCover() : dVar.gkG.getMedia_pic(), 10, false);
            this.glJ.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dM(dVar.gkG.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gkG.end_time));
            this.glH.setText(dVar.gkG.getLiveTitle());
            this.glD.setTag(dVar.gkG);
        } else {
            this.glD.setVisibility(4);
        }
        if (dVar.gkH != null) {
            this.glE.setVisibility(0);
            this.glG.startLoad(StringUtils.isNull(dVar.gkH.getMedia_pic()) ? dVar.gkH.getLiveCover() : dVar.gkH.getMedia_pic(), 10, false);
            this.glK.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dM(dVar.gkH.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gkH.end_time));
            this.glI.setText(dVar.gkH.getLiveTitle());
            this.glE.setTag(dVar.gkH);
            return;
        }
        this.glE.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.glD) {
            ax(this.glD.getTag());
        } else if (view == this.glE) {
            ax(this.glE.getTag());
        }
    }

    private void ax(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e glL;

        public a(e eVar) {
            super(eVar.getView());
            this.glL = eVar;
        }
    }
}
