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
    private LinearLayout hAN;
    private LinearLayout hAO;
    private TbImageView hAP;
    private TbImageView hAQ;
    private TextView hAR;
    private TextView hAS;
    private TextView hAT;
    private TextView hAU;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hAN = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_one);
        this.hAO = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_two);
        b(this.hAN);
        b(this.hAO);
        this.hAN.setOnClickListener(this);
        this.hAO.setOnClickListener(this);
        this.hAP = (TbImageView) this.hAN.findViewById(a.f.replay_cover);
        this.hAP.setDefaultErrorResource(0);
        this.hAP.setAutoChangeStyle(false);
        this.hAP.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hAR = (TextView) this.hAN.findViewById(a.f.replay_title);
        this.hAT = (TextView) this.hAN.findViewById(a.f.replay_info);
        this.hAQ = (TbImageView) this.hAO.findViewById(a.f.replay_cover);
        this.hAQ.setDefaultErrorResource(0);
        this.hAQ.setAutoChangeStyle(false);
        this.hAQ.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hAS = (TextView) this.hAO.findViewById(a.f.replay_title);
        this.hAU = (TextView) this.hAO.findViewById(a.f.replay_info);
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
        if (dVar.hzP != null) {
            this.hAN.setVisibility(0);
            this.hAP.startLoad(StringUtils.isNull(dVar.hzP.getMedia_pic()) ? dVar.hzP.getLiveCover() : dVar.hzP.getMedia_pic(), 10, false);
            this.hAT.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.aE(dVar.hzP.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hzP.end_time));
            this.hAR.setText(dVar.hzP.getLiveTitle());
            this.hAN.setTag(dVar.hzP);
        } else {
            this.hAN.setVisibility(4);
        }
        if (dVar.hzQ != null) {
            this.hAO.setVisibility(0);
            this.hAQ.startLoad(StringUtils.isNull(dVar.hzQ.getMedia_pic()) ? dVar.hzQ.getLiveCover() : dVar.hzQ.getMedia_pic(), 10, false);
            this.hAU.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.aE(dVar.hzQ.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hzQ.end_time));
            this.hAS.setText(dVar.hzQ.getLiveTitle());
            this.hAO.setTag(dVar.hzQ);
            return;
        }
        this.hAO.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hAN) {
            aG(this.hAN.getTag());
        } else if (view == this.hAO) {
            aG(this.hAO.getTag());
        }
    }

    private void aG(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hAV;

        public a(e eVar) {
            super(eVar.getView());
            this.hAV = eVar;
        }
    }
}
