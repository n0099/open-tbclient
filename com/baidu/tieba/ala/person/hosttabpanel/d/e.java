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
/* loaded from: classes10.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout hRZ;
    private LinearLayout hSa;
    private TbImageView hSb;
    private TbImageView hSc;
    private TextView hSd;
    private TextView hSe;
    private TextView hSf;
    private TextView hSg;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hRZ = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_one);
        this.hSa = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_two);
        b(this.hRZ);
        b(this.hSa);
        this.hRZ.setOnClickListener(this);
        this.hSa.setOnClickListener(this);
        this.hSb = (TbImageView) this.hRZ.findViewById(a.f.replay_cover);
        this.hSb.setDefaultErrorResource(0);
        this.hSb.setAutoChangeStyle(false);
        this.hSb.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hSd = (TextView) this.hRZ.findViewById(a.f.replay_title);
        this.hSf = (TextView) this.hRZ.findViewById(a.f.replay_info);
        this.hSc = (TbImageView) this.hSa.findViewById(a.f.replay_cover);
        this.hSc.setDefaultErrorResource(0);
        this.hSc.setAutoChangeStyle(false);
        this.hSc.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hSe = (TextView) this.hSa.findViewById(a.f.replay_title);
        this.hSg = (TextView) this.hSa.findViewById(a.f.replay_info);
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
        if (dVar.hRb != null) {
            this.hRZ.setVisibility(0);
            this.hSb.startLoad(StringUtils.isNull(dVar.hRb.getMedia_pic()) ? dVar.hRb.getLiveCover() : dVar.hRb.getMedia_pic(), 10, false);
            this.hSf.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bc(dVar.hRb.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hRb.end_time));
            this.hSd.setText(dVar.hRb.getLiveTitle());
            this.hRZ.setTag(dVar.hRb);
        } else {
            this.hRZ.setVisibility(4);
        }
        if (dVar.hRc != null) {
            this.hSa.setVisibility(0);
            this.hSc.startLoad(StringUtils.isNull(dVar.hRc.getMedia_pic()) ? dVar.hRc.getLiveCover() : dVar.hRc.getMedia_pic(), 10, false);
            this.hSg.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bc(dVar.hRc.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hRc.end_time));
            this.hSe.setText(dVar.hRc.getLiveTitle());
            this.hSa.setTag(dVar.hRc);
            return;
        }
        this.hSa.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hRZ) {
            aH(this.hRZ.getTag());
        } else if (view == this.hSa) {
            aH(this.hSa.getTag());
        }
    }

    private void aH(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes10.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hSh;

        public a(e eVar) {
            super(eVar.getView());
            this.hSh = eVar;
        }
    }
}
