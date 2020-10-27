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
    private LinearLayout hvj;
    private LinearLayout hvk;
    private TbImageView hvl;
    private TbImageView hvm;
    private TextView hvn;
    private TextView hvo;
    private TextView hvp;
    private TextView hvq;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hvj = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.hvk = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.hvj);
        b(this.hvk);
        this.hvj.setOnClickListener(this);
        this.hvk.setOnClickListener(this);
        this.hvl = (TbImageView) this.hvj.findViewById(a.g.replay_cover);
        this.hvl.setDefaultErrorResource(0);
        this.hvl.setAutoChangeStyle(false);
        this.hvl.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.hvn = (TextView) this.hvj.findViewById(a.g.replay_title);
        this.hvp = (TextView) this.hvj.findViewById(a.g.replay_info);
        this.hvm = (TbImageView) this.hvk.findViewById(a.g.replay_cover);
        this.hvm.setDefaultErrorResource(0);
        this.hvm.setAutoChangeStyle(false);
        this.hvm.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.hvo = (TextView) this.hvk.findViewById(a.g.replay_title);
        this.hvq = (TextView) this.hvk.findViewById(a.g.replay_info);
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
        if (dVar.hul != null) {
            this.hvj.setVisibility(0);
            this.hvl.startLoad(StringUtils.isNull(dVar.hul.getMedia_pic()) ? dVar.hul.getLiveCover() : dVar.hul.getMedia_pic(), 10, false);
            this.hvp.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.as(dVar.hul.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hul.end_time));
            this.hvn.setText(dVar.hul.getLiveTitle());
            this.hvj.setTag(dVar.hul);
        } else {
            this.hvj.setVisibility(4);
        }
        if (dVar.hum != null) {
            this.hvk.setVisibility(0);
            this.hvm.startLoad(StringUtils.isNull(dVar.hum.getMedia_pic()) ? dVar.hum.getLiveCover() : dVar.hum.getMedia_pic(), 10, false);
            this.hvq.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.as(dVar.hum.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hum.end_time));
            this.hvo.setText(dVar.hum.getLiveTitle());
            this.hvk.setTag(dVar.hum);
            return;
        }
        this.hvk.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hvj) {
            aG(this.hvj.getTag());
        } else if (view == this.hvk) {
            aG(this.hvk.getTag());
        }
    }

    private void aG(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hvr;

        public a(e eVar) {
            super(eVar.getView());
            this.hvr = eVar;
        }
    }
}
