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
    private TextView hKA;
    private TextView hKB;
    private LinearLayout hKu;
    private LinearLayout hKv;
    private TbImageView hKw;
    private TbImageView hKx;
    private TextView hKy;
    private TextView hKz;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hKu = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_one);
        this.hKv = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_two);
        b(this.hKu);
        b(this.hKv);
        this.hKu.setOnClickListener(this);
        this.hKv.setOnClickListener(this);
        this.hKw = (TbImageView) this.hKu.findViewById(a.f.replay_cover);
        this.hKw.setDefaultErrorResource(0);
        this.hKw.setAutoChangeStyle(false);
        this.hKw.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hKy = (TextView) this.hKu.findViewById(a.f.replay_title);
        this.hKA = (TextView) this.hKu.findViewById(a.f.replay_info);
        this.hKx = (TbImageView) this.hKv.findViewById(a.f.replay_cover);
        this.hKx.setDefaultErrorResource(0);
        this.hKx.setAutoChangeStyle(false);
        this.hKx.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hKz = (TextView) this.hKv.findViewById(a.f.replay_title);
        this.hKB = (TextView) this.hKv.findViewById(a.f.replay_info);
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
        if (dVar.hJw != null) {
            this.hKu.setVisibility(0);
            this.hKw.startLoad(StringUtils.isNull(dVar.hJw.getMedia_pic()) ? dVar.hJw.getLiveCover() : dVar.hJw.getMedia_pic(), 10, false);
            this.hKA.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bc(dVar.hJw.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hJw.end_time));
            this.hKy.setText(dVar.hJw.getLiveTitle());
            this.hKu.setTag(dVar.hJw);
        } else {
            this.hKu.setVisibility(4);
        }
        if (dVar.hJx != null) {
            this.hKv.setVisibility(0);
            this.hKx.startLoad(StringUtils.isNull(dVar.hJx.getMedia_pic()) ? dVar.hJx.getLiveCover() : dVar.hJx.getMedia_pic(), 10, false);
            this.hKB.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bc(dVar.hJx.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hJx.end_time));
            this.hKz.setText(dVar.hJx.getLiveTitle());
            this.hKv.setTag(dVar.hJx);
            return;
        }
        this.hKv.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hKu) {
            aG(this.hKu.getTag());
        } else if (view == this.hKv) {
            aG(this.hKv.getTag());
        }
    }

    private void aG(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hKC;

        public a(e eVar) {
            super(eVar.getView());
            this.hKC = eVar;
        }
    }
}
