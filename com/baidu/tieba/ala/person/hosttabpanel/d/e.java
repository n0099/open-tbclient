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
    private LinearLayout hKs;
    private LinearLayout hKt;
    private TbImageView hKu;
    private TbImageView hKv;
    private TextView hKw;
    private TextView hKx;
    private TextView hKy;
    private TextView hKz;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hKs = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_one);
        this.hKt = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_two);
        b(this.hKs);
        b(this.hKt);
        this.hKs.setOnClickListener(this);
        this.hKt.setOnClickListener(this);
        this.hKu = (TbImageView) this.hKs.findViewById(a.f.replay_cover);
        this.hKu.setDefaultErrorResource(0);
        this.hKu.setAutoChangeStyle(false);
        this.hKu.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hKw = (TextView) this.hKs.findViewById(a.f.replay_title);
        this.hKy = (TextView) this.hKs.findViewById(a.f.replay_info);
        this.hKv = (TbImageView) this.hKt.findViewById(a.f.replay_cover);
        this.hKv.setDefaultErrorResource(0);
        this.hKv.setAutoChangeStyle(false);
        this.hKv.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hKx = (TextView) this.hKt.findViewById(a.f.replay_title);
        this.hKz = (TextView) this.hKt.findViewById(a.f.replay_info);
    }

    private void b(LinearLayout linearLayout) {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
        int dimensionPixelSize = this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds34);
        layoutParams.width = ((BdUtilHelper.getEquipmentWidth(this.mPageContext.getPageActivity()) - this.mPageContext.getResources().getDimensionPixelSize(a.d.sdk_ds16)) - (dimensionPixelSize * 2)) / 2;
        layoutParams.height = -2;
        linearLayout.setLayoutParams(layoutParams);
    }

    @Override // com.baidu.live.tieba.b.a
    public int getLayout() {
        return a.g.ala_new_host_tab_replay_row;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.live.tieba.b.a
    /* renamed from: a */
    public void onBindDataToView(com.baidu.tieba.ala.person.hosttabpanel.b.d dVar) {
        if (dVar.hJu != null) {
            this.hKs.setVisibility(0);
            this.hKu.startLoad(StringUtils.isNull(dVar.hJu.getMedia_pic()) ? dVar.hJu.getLiveCover() : dVar.hJu.getMedia_pic(), 10, false);
            this.hKy.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bc(dVar.hJu.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hJu.end_time));
            this.hKw.setText(dVar.hJu.getLiveTitle());
            this.hKs.setTag(dVar.hJu);
        } else {
            this.hKs.setVisibility(4);
        }
        if (dVar.hJv != null) {
            this.hKt.setVisibility(0);
            this.hKv.startLoad(StringUtils.isNull(dVar.hJv.getMedia_pic()) ? dVar.hJv.getLiveCover() : dVar.hJv.getMedia_pic(), 10, false);
            this.hKz.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bc(dVar.hJv.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hJv.end_time));
            this.hKx.setText(dVar.hJv.getLiveTitle());
            this.hKt.setTag(dVar.hJv);
            return;
        }
        this.hKt.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hKs) {
            aG(this.hKs.getTag());
        } else if (view == this.hKt) {
            aG(this.hKt.getTag());
        }
    }

    private void aG(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hKA;

        public a(e eVar) {
            super(eVar.getView());
            this.hKA = eVar;
        }
    }
}
