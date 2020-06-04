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
    private LinearLayout glO;
    private LinearLayout glP;
    private TbImageView glQ;
    private TbImageView glR;
    private TextView glS;
    private TextView glT;
    private TextView glU;
    private TextView glV;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.glO = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.glP = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.glO);
        b(this.glP);
        this.glO.setOnClickListener(this);
        this.glP.setOnClickListener(this);
        this.glQ = (TbImageView) this.glO.findViewById(a.g.replay_cover);
        this.glQ.setDefaultErrorResource(0);
        this.glQ.setAutoChangeStyle(false);
        this.glQ.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.glS = (TextView) this.glO.findViewById(a.g.replay_title);
        this.glU = (TextView) this.glO.findViewById(a.g.replay_info);
        this.glR = (TbImageView) this.glP.findViewById(a.g.replay_cover);
        this.glR.setDefaultErrorResource(0);
        this.glR.setAutoChangeStyle(false);
        this.glR.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.glT = (TextView) this.glP.findViewById(a.g.replay_title);
        this.glV = (TextView) this.glP.findViewById(a.g.replay_info);
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
        if (dVar.gkR != null) {
            this.glO.setVisibility(0);
            this.glQ.startLoad(StringUtils.isNull(dVar.gkR.getMedia_pic()) ? dVar.gkR.getLiveCover() : dVar.gkR.getMedia_pic(), 10, false);
            this.glU.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dM(dVar.gkR.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gkR.end_time));
            this.glS.setText(dVar.gkR.getLiveTitle());
            this.glO.setTag(dVar.gkR);
        } else {
            this.glO.setVisibility(4);
        }
        if (dVar.gkS != null) {
            this.glP.setVisibility(0);
            this.glR.startLoad(StringUtils.isNull(dVar.gkS.getMedia_pic()) ? dVar.gkS.getLiveCover() : dVar.gkS.getMedia_pic(), 10, false);
            this.glV.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dM(dVar.gkS.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gkS.end_time));
            this.glT.setText(dVar.gkS.getLiveTitle());
            this.glP.setTag(dVar.gkS);
            return;
        }
        this.glP.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.glO) {
            ax(this.glO.getTag());
        } else if (view == this.glP) {
            ax(this.glP.getTag());
        }
    }

    private void ax(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e glW;

        public a(e eVar) {
            super(eVar.getView());
            this.glW = eVar;
        }
    }
}
