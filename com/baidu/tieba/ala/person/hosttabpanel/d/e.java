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
/* loaded from: classes11.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout hWI;
    private LinearLayout hWJ;
    private TbImageView hWK;
    private TbImageView hWL;
    private TextView hWM;
    private TextView hWN;
    private TextView hWO;
    private TextView hWP;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hWI = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_one);
        this.hWJ = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_two);
        b(this.hWI);
        b(this.hWJ);
        this.hWI.setOnClickListener(this);
        this.hWJ.setOnClickListener(this);
        this.hWK = (TbImageView) this.hWI.findViewById(a.f.replay_cover);
        this.hWK.setDefaultErrorResource(0);
        this.hWK.setAutoChangeStyle(false);
        this.hWK.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hWM = (TextView) this.hWI.findViewById(a.f.replay_title);
        this.hWO = (TextView) this.hWI.findViewById(a.f.replay_info);
        this.hWL = (TbImageView) this.hWJ.findViewById(a.f.replay_cover);
        this.hWL.setDefaultErrorResource(0);
        this.hWL.setAutoChangeStyle(false);
        this.hWL.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hWN = (TextView) this.hWJ.findViewById(a.f.replay_title);
        this.hWP = (TextView) this.hWJ.findViewById(a.f.replay_info);
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
        if (dVar.hVK != null) {
            this.hWI.setVisibility(0);
            this.hWK.startLoad(StringUtils.isNull(dVar.hVK.getMedia_pic()) ? dVar.hVK.getLiveCover() : dVar.hVK.getMedia_pic(), 10, false);
            this.hWO.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bg(dVar.hVK.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hVK.end_time));
            this.hWM.setText(dVar.hVK.getLiveTitle());
            this.hWI.setTag(dVar.hVK);
        } else {
            this.hWI.setVisibility(4);
        }
        if (dVar.hVL != null) {
            this.hWJ.setVisibility(0);
            this.hWL.startLoad(StringUtils.isNull(dVar.hVL.getMedia_pic()) ? dVar.hVL.getLiveCover() : dVar.hVL.getMedia_pic(), 10, false);
            this.hWP.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bg(dVar.hVL.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hVL.end_time));
            this.hWN.setText(dVar.hVL.getLiveTitle());
            this.hWJ.setTag(dVar.hVL);
            return;
        }
        this.hWJ.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hWI) {
            aH(this.hWI.getTag());
        } else if (view == this.hWJ) {
            aH(this.hWJ.getTag());
        }
    }

    private void aH(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hWQ;

        public a(e eVar) {
            super(eVar.getView());
            this.hWQ = eVar;
        }
    }
}
