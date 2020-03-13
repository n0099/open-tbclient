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
    private LinearLayout frK;
    private LinearLayout frL;
    private TbImageView frM;
    private TbImageView frN;
    private TextView frO;
    private TextView frP;
    private TextView frQ;
    private TextView frR;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.frK = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.frL = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.frK);
        b(this.frL);
        this.frK.setOnClickListener(this);
        this.frL.setOnClickListener(this);
        this.frM = (TbImageView) this.frK.findViewById(a.g.replay_cover);
        this.frM.setDefaultErrorResource(0);
        this.frM.setAutoChangeStyle(false);
        this.frM.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.frO = (TextView) this.frK.findViewById(a.g.replay_title);
        this.frQ = (TextView) this.frK.findViewById(a.g.replay_info);
        this.frN = (TbImageView) this.frL.findViewById(a.g.replay_cover);
        this.frN.setDefaultErrorResource(0);
        this.frN.setAutoChangeStyle(false);
        this.frN.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.frP = (TextView) this.frL.findViewById(a.g.replay_title);
        this.frR = (TextView) this.frL.findViewById(a.g.replay_info);
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
        if (dVar.fqL != null) {
            this.frK.setVisibility(0);
            this.frM.startLoad(StringUtils.isNull(dVar.fqL.getMedia_pic()) ? dVar.fqL.getLiveCover() : dVar.fqL.getMedia_pic(), 10, false);
            this.frQ.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(dVar.fqL.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fqL.end_time));
            this.frO.setText(dVar.fqL.getLiveTitle());
            this.frK.setTag(dVar.fqL);
        } else {
            this.frK.setVisibility(4);
        }
        if (dVar.fqM != null) {
            this.frL.setVisibility(0);
            this.frN.startLoad(StringUtils.isNull(dVar.fqM.getMedia_pic()) ? dVar.fqM.getLiveCover() : dVar.fqM.getMedia_pic(), 10, false);
            this.frR.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(dVar.fqM.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fqM.end_time));
            this.frP.setText(dVar.fqM.getLiveTitle());
            this.frL.setTag(dVar.fqM);
            return;
        }
        this.frL.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.frK) {
            ar(this.frK.getTag());
        } else if (view == this.frL) {
            ar(this.frL.getTag());
        }
    }

    private void ar(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e frS;

        public a(e eVar) {
            super(eVar.getView());
            this.frS = eVar;
        }
    }
}
