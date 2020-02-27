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
    private TextView frA;
    private TextView frB;
    private TextView frC;
    private TextView frD;
    private LinearLayout frw;
    private LinearLayout frx;
    private TbImageView fry;
    private TbImageView frz;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.frw = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.frx = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.frw);
        b(this.frx);
        this.frw.setOnClickListener(this);
        this.frx.setOnClickListener(this);
        this.fry = (TbImageView) this.frw.findViewById(a.g.replay_cover);
        this.fry.setDefaultErrorResource(0);
        this.fry.setAutoChangeStyle(false);
        this.fry.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.frA = (TextView) this.frw.findViewById(a.g.replay_title);
        this.frC = (TextView) this.frw.findViewById(a.g.replay_info);
        this.frz = (TbImageView) this.frx.findViewById(a.g.replay_cover);
        this.frz.setDefaultErrorResource(0);
        this.frz.setAutoChangeStyle(false);
        this.frz.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.frB = (TextView) this.frx.findViewById(a.g.replay_title);
        this.frD = (TextView) this.frx.findViewById(a.g.replay_info);
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
        if (dVar.fqx != null) {
            this.frw.setVisibility(0);
            this.fry.startLoad(StringUtils.isNull(dVar.fqx.getMedia_pic()) ? dVar.fqx.getLiveCover() : dVar.fqx.getMedia_pic(), 10, false);
            this.frC.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(dVar.fqx.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fqx.end_time));
            this.frA.setText(dVar.fqx.getLiveTitle());
            this.frw.setTag(dVar.fqx);
        } else {
            this.frw.setVisibility(4);
        }
        if (dVar.fqy != null) {
            this.frx.setVisibility(0);
            this.frz.startLoad(StringUtils.isNull(dVar.fqy.getMedia_pic()) ? dVar.fqy.getLiveCover() : dVar.fqy.getMedia_pic(), 10, false);
            this.frD.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(dVar.fqy.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fqy.end_time));
            this.frB.setText(dVar.fqy.getLiveTitle());
            this.frx.setTag(dVar.fqy);
            return;
        }
        this.frx.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.frw) {
            ar(this.frw.getTag());
        } else if (view == this.frx) {
            ar(this.frx.getTag());
        }
    }

    private void ar(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e frE;

        public a(e eVar) {
            super(eVar.getView());
            this.frE = eVar;
        }
    }
}
