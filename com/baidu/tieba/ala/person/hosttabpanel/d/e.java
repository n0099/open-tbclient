package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.q.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout flI;
    private LinearLayout flJ;
    private TbImageView flK;
    private TbImageView flL;
    private TextView flM;
    private TextView flN;
    private TextView flO;
    private TextView flP;
    private final String flQ;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.flQ = " | ";
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.flI = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.flJ = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.flI);
        b(this.flJ);
        this.flI.setOnClickListener(this);
        this.flJ.setOnClickListener(this);
        this.flK = (TbImageView) this.flI.findViewById(a.g.replay_cover);
        this.flK.setDefaultErrorResource(0);
        this.flK.setAutoChangeStyle(false);
        this.flK.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.flM = (TextView) this.flI.findViewById(a.g.replay_title);
        this.flO = (TextView) this.flI.findViewById(a.g.replay_info);
        this.flL = (TbImageView) this.flJ.findViewById(a.g.replay_cover);
        this.flL.setDefaultErrorResource(0);
        this.flL.setAutoChangeStyle(false);
        this.flL.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.flN = (TextView) this.flJ.findViewById(a.g.replay_title);
        this.flP = (TextView) this.flJ.findViewById(a.g.replay_info);
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
        if (dVar.fkJ != null) {
            this.flI.setVisibility(0);
            this.flK.startLoad(StringUtils.isNull(dVar.fkJ.getMedia_pic()) ? dVar.fkJ.getLiveCover() : dVar.fkJ.getMedia_pic(), 10, false);
            this.flO.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.cW(dVar.fkJ.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fkJ.end_time));
            this.flM.setText(dVar.fkJ.getLiveTitle());
            this.flI.setTag(dVar.fkJ);
        } else {
            this.flI.setVisibility(4);
        }
        if (dVar.fkK != null) {
            this.flJ.setVisibility(0);
            this.flL.startLoad(StringUtils.isNull(dVar.fkK.getMedia_pic()) ? dVar.fkK.getLiveCover() : dVar.fkK.getMedia_pic(), 10, false);
            this.flP.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.cW(dVar.fkK.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fkK.end_time));
            this.flN.setText(dVar.fkK.getLiveTitle());
            this.flJ.setTag(dVar.fkK);
            return;
        }
        this.flJ.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.flI) {
            ap(this.flI.getTag());
        } else if (view == this.flJ) {
            ap(this.flJ.getTag());
        }
    }

    private void ap(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e flR;

        public a(e eVar) {
            super(eVar.getView());
            this.flR = eVar;
        }
    }
}
