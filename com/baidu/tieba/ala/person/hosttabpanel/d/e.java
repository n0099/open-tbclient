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
    private LinearLayout hBg;
    private LinearLayout hBh;
    private TbImageView hBi;
    private TbImageView hBj;
    private TextView hBk;
    private TextView hBl;
    private TextView hBm;
    private TextView hBn;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hBg = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_one);
        this.hBh = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_two);
        b(this.hBg);
        b(this.hBh);
        this.hBg.setOnClickListener(this);
        this.hBh.setOnClickListener(this);
        this.hBi = (TbImageView) this.hBg.findViewById(a.f.replay_cover);
        this.hBi.setDefaultErrorResource(0);
        this.hBi.setAutoChangeStyle(false);
        this.hBi.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hBk = (TextView) this.hBg.findViewById(a.f.replay_title);
        this.hBm = (TextView) this.hBg.findViewById(a.f.replay_info);
        this.hBj = (TbImageView) this.hBh.findViewById(a.f.replay_cover);
        this.hBj.setDefaultErrorResource(0);
        this.hBj.setAutoChangeStyle(false);
        this.hBj.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hBl = (TextView) this.hBh.findViewById(a.f.replay_title);
        this.hBn = (TextView) this.hBh.findViewById(a.f.replay_info);
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
        if (dVar.hAi != null) {
            this.hBg.setVisibility(0);
            this.hBi.startLoad(StringUtils.isNull(dVar.hAi.getMedia_pic()) ? dVar.hAi.getLiveCover() : dVar.hAi.getMedia_pic(), 10, false);
            this.hBm.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.aE(dVar.hAi.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hAi.end_time));
            this.hBk.setText(dVar.hAi.getLiveTitle());
            this.hBg.setTag(dVar.hAi);
        } else {
            this.hBg.setVisibility(4);
        }
        if (dVar.hAj != null) {
            this.hBh.setVisibility(0);
            this.hBj.startLoad(StringUtils.isNull(dVar.hAj.getMedia_pic()) ? dVar.hAj.getLiveCover() : dVar.hAj.getMedia_pic(), 10, false);
            this.hBn.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.aE(dVar.hAj.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hAj.end_time));
            this.hBl.setText(dVar.hAj.getLiveTitle());
            this.hBh.setTag(dVar.hAj);
            return;
        }
        this.hBh.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hBg) {
            aG(this.hBg.getTag());
        } else if (view == this.hBh) {
            aG(this.hBh.getTag());
        }
    }

    private void aG(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hBo;

        public a(e eVar) {
            super(eVar.getView());
            this.hBo = eVar;
        }
    }
}
