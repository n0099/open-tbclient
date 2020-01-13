package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.r.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes2.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout foR;
    private LinearLayout foS;
    private TbImageView foT;
    private TbImageView foU;
    private TextView foV;
    private TextView foW;
    private TextView foX;
    private TextView foY;
    private final String foZ;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.foZ = " | ";
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.foR = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.foS = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.foR);
        b(this.foS);
        this.foR.setOnClickListener(this);
        this.foS.setOnClickListener(this);
        this.foT = (TbImageView) this.foR.findViewById(a.g.replay_cover);
        this.foT.setDefaultErrorResource(0);
        this.foT.setAutoChangeStyle(false);
        this.foT.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.foV = (TextView) this.foR.findViewById(a.g.replay_title);
        this.foX = (TextView) this.foR.findViewById(a.g.replay_info);
        this.foU = (TbImageView) this.foS.findViewById(a.g.replay_cover);
        this.foU.setDefaultErrorResource(0);
        this.foU.setAutoChangeStyle(false);
        this.foU.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.foW = (TextView) this.foS.findViewById(a.g.replay_title);
        this.foY = (TextView) this.foS.findViewById(a.g.replay_info);
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
        if (dVar.fnT != null) {
            this.foR.setVisibility(0);
            this.foT.startLoad(StringUtils.isNull(dVar.fnT.getMedia_pic()) ? dVar.fnT.getLiveCover() : dVar.fnT.getMedia_pic(), 10, false);
            this.foX.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.db(dVar.fnT.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fnT.end_time));
            this.foV.setText(dVar.fnT.getLiveTitle());
            this.foR.setTag(dVar.fnT);
        } else {
            this.foR.setVisibility(4);
        }
        if (dVar.fnU != null) {
            this.foS.setVisibility(0);
            this.foU.startLoad(StringUtils.isNull(dVar.fnU.getMedia_pic()) ? dVar.fnU.getLiveCover() : dVar.fnU.getMedia_pic(), 10, false);
            this.foY.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.db(dVar.fnU.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fnU.end_time));
            this.foW.setText(dVar.fnU.getLiveTitle());
            this.foS.setTag(dVar.fnU);
            return;
        }
        this.foS.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.foR) {
            ap(this.foR.getTag());
        } else if (view == this.foS) {
            ap(this.foS.getTag());
        }
    }

    private void ap(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes2.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e fpa;

        public a(e eVar) {
            super(eVar.getView());
            this.fpa = eVar;
        }
    }
}
