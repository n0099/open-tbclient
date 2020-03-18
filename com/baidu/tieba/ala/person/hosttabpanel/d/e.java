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
    private LinearLayout fsj;
    private LinearLayout fsk;
    private TbImageView fsl;
    private TbImageView fsm;
    private TextView fsn;
    private TextView fso;
    private TextView fsp;
    private TextView fsq;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.fsj = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.fsk = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.fsj);
        b(this.fsk);
        this.fsj.setOnClickListener(this);
        this.fsk.setOnClickListener(this);
        this.fsl = (TbImageView) this.fsj.findViewById(a.g.replay_cover);
        this.fsl.setDefaultErrorResource(0);
        this.fsl.setAutoChangeStyle(false);
        this.fsl.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.fsn = (TextView) this.fsj.findViewById(a.g.replay_title);
        this.fsp = (TextView) this.fsj.findViewById(a.g.replay_info);
        this.fsm = (TbImageView) this.fsk.findViewById(a.g.replay_cover);
        this.fsm.setDefaultErrorResource(0);
        this.fsm.setAutoChangeStyle(false);
        this.fsm.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.fso = (TextView) this.fsk.findViewById(a.g.replay_title);
        this.fsq = (TextView) this.fsk.findViewById(a.g.replay_info);
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
        if (dVar.frk != null) {
            this.fsj.setVisibility(0);
            this.fsl.startLoad(StringUtils.isNull(dVar.frk.getMedia_pic()) ? dVar.frk.getLiveCover() : dVar.frk.getMedia_pic(), 10, false);
            this.fsp.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(dVar.frk.join_count)) + " | " + StringHelper.getTimeInterval(dVar.frk.end_time));
            this.fsn.setText(dVar.frk.getLiveTitle());
            this.fsj.setTag(dVar.frk);
        } else {
            this.fsj.setVisibility(4);
        }
        if (dVar.frl != null) {
            this.fsk.setVisibility(0);
            this.fsm.startLoad(StringUtils.isNull(dVar.frl.getMedia_pic()) ? dVar.frl.getLiveCover() : dVar.frl.getMedia_pic(), 10, false);
            this.fsq.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(dVar.frl.join_count)) + " | " + StringHelper.getTimeInterval(dVar.frl.end_time));
            this.fso.setText(dVar.frl.getLiveTitle());
            this.fsk.setTag(dVar.frl);
            return;
        }
        this.fsk.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fsj) {
            ar(this.fsj.getTag());
        } else if (view == this.fsk) {
            ar(this.fsk.getTag());
        }
    }

    private void ar(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e fsr;

        public a(e eVar) {
            super(eVar.getView());
            this.fsr = eVar;
        }
    }
}
