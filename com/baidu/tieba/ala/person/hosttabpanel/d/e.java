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
    private LinearLayout hjn;
    private LinearLayout hjo;
    private TbImageView hjp;
    private TbImageView hjq;
    private TextView hjr;
    private TextView hjs;
    private TextView hjt;
    private TextView hju;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hjn = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.hjo = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.hjn);
        b(this.hjo);
        this.hjn.setOnClickListener(this);
        this.hjo.setOnClickListener(this);
        this.hjp = (TbImageView) this.hjn.findViewById(a.g.replay_cover);
        this.hjp.setDefaultErrorResource(0);
        this.hjp.setAutoChangeStyle(false);
        this.hjp.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.hjr = (TextView) this.hjn.findViewById(a.g.replay_title);
        this.hjt = (TextView) this.hjn.findViewById(a.g.replay_info);
        this.hjq = (TbImageView) this.hjo.findViewById(a.g.replay_cover);
        this.hjq.setDefaultErrorResource(0);
        this.hjq.setAutoChangeStyle(false);
        this.hjq.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.hjs = (TextView) this.hjo.findViewById(a.g.replay_title);
        this.hju = (TextView) this.hjo.findViewById(a.g.replay_info);
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
        if (dVar.hip != null) {
            this.hjn.setVisibility(0);
            this.hjp.startLoad(StringUtils.isNull(dVar.hip.getMedia_pic()) ? dVar.hip.getLiveCover() : dVar.hip.getMedia_pic(), 10, false);
            this.hjt.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.eL(dVar.hip.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hip.end_time));
            this.hjr.setText(dVar.hip.getLiveTitle());
            this.hjn.setTag(dVar.hip);
        } else {
            this.hjn.setVisibility(4);
        }
        if (dVar.hiq != null) {
            this.hjo.setVisibility(0);
            this.hjq.startLoad(StringUtils.isNull(dVar.hiq.getMedia_pic()) ? dVar.hiq.getLiveCover() : dVar.hiq.getMedia_pic(), 10, false);
            this.hju.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.eL(dVar.hiq.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hiq.end_time));
            this.hjs.setText(dVar.hiq.getLiveTitle());
            this.hjo.setTag(dVar.hiq);
            return;
        }
        this.hjo.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hjn) {
            aF(this.hjn.getTag());
        } else if (view == this.hjo) {
            aF(this.hjo.getTag());
        }
    }

    private void aF(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hjv;

        public a(e eVar) {
            super(eVar.getView());
            this.hjv = eVar;
        }
    }
}
