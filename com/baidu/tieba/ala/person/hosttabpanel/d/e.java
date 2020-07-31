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
/* loaded from: classes4.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout gEd;
    private LinearLayout gEe;
    private TbImageView gEf;
    private TbImageView gEg;
    private TextView gEh;
    private TextView gEi;
    private TextView gEj;
    private TextView gEk;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gEd = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.gEe = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.gEd);
        b(this.gEe);
        this.gEd.setOnClickListener(this);
        this.gEe.setOnClickListener(this);
        this.gEf = (TbImageView) this.gEd.findViewById(a.g.replay_cover);
        this.gEf.setDefaultErrorResource(0);
        this.gEf.setAutoChangeStyle(false);
        this.gEf.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gEh = (TextView) this.gEd.findViewById(a.g.replay_title);
        this.gEj = (TextView) this.gEd.findViewById(a.g.replay_info);
        this.gEg = (TbImageView) this.gEe.findViewById(a.g.replay_cover);
        this.gEg.setDefaultErrorResource(0);
        this.gEg.setAutoChangeStyle(false);
        this.gEg.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gEi = (TextView) this.gEe.findViewById(a.g.replay_title);
        this.gEk = (TextView) this.gEe.findViewById(a.g.replay_info);
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
        if (dVar.gDg != null) {
            this.gEd.setVisibility(0);
            this.gEf.startLoad(StringUtils.isNull(dVar.gDg.getMedia_pic()) ? dVar.gDg.getLiveCover() : dVar.gDg.getMedia_pic(), 10, false);
            this.gEj.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.ec(dVar.gDg.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gDg.end_time));
            this.gEh.setText(dVar.gDg.getLiveTitle());
            this.gEd.setTag(dVar.gDg);
        } else {
            this.gEd.setVisibility(4);
        }
        if (dVar.gDh != null) {
            this.gEe.setVisibility(0);
            this.gEg.startLoad(StringUtils.isNull(dVar.gDh.getMedia_pic()) ? dVar.gDh.getLiveCover() : dVar.gDh.getMedia_pic(), 10, false);
            this.gEk.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.ec(dVar.gDh.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gDh.end_time));
            this.gEi.setText(dVar.gDh.getLiveTitle());
            this.gEe.setTag(dVar.gDh);
            return;
        }
        this.gEe.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gEd) {
            ay(this.gEd.getTag());
        } else if (view == this.gEe) {
            ay(this.gEe.getTag());
        }
    }

    private void ay(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e gEl;

        public a(e eVar) {
            super(eVar.getView());
            this.gEl = eVar;
        }
    }
}
