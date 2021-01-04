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
    private LinearLayout hWG;
    private LinearLayout hWH;
    private TbImageView hWI;
    private TbImageView hWJ;
    private TextView hWK;
    private TextView hWL;
    private TextView hWM;
    private TextView hWN;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hWG = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_one);
        this.hWH = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_two);
        b(this.hWG);
        b(this.hWH);
        this.hWG.setOnClickListener(this);
        this.hWH.setOnClickListener(this);
        this.hWI = (TbImageView) this.hWG.findViewById(a.f.replay_cover);
        this.hWI.setDefaultErrorResource(0);
        this.hWI.setAutoChangeStyle(false);
        this.hWI.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hWK = (TextView) this.hWG.findViewById(a.f.replay_title);
        this.hWM = (TextView) this.hWG.findViewById(a.f.replay_info);
        this.hWJ = (TbImageView) this.hWH.findViewById(a.f.replay_cover);
        this.hWJ.setDefaultErrorResource(0);
        this.hWJ.setAutoChangeStyle(false);
        this.hWJ.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hWL = (TextView) this.hWH.findViewById(a.f.replay_title);
        this.hWN = (TextView) this.hWH.findViewById(a.f.replay_info);
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
        if (dVar.hVI != null) {
            this.hWG.setVisibility(0);
            this.hWI.startLoad(StringUtils.isNull(dVar.hVI.getMedia_pic()) ? dVar.hVI.getLiveCover() : dVar.hVI.getMedia_pic(), 10, false);
            this.hWM.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bc(dVar.hVI.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hVI.end_time));
            this.hWK.setText(dVar.hVI.getLiveTitle());
            this.hWG.setTag(dVar.hVI);
        } else {
            this.hWG.setVisibility(4);
        }
        if (dVar.hVJ != null) {
            this.hWH.setVisibility(0);
            this.hWJ.startLoad(StringUtils.isNull(dVar.hVJ.getMedia_pic()) ? dVar.hVJ.getLiveCover() : dVar.hVJ.getMedia_pic(), 10, false);
            this.hWN.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bc(dVar.hVJ.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hVJ.end_time));
            this.hWL.setText(dVar.hVJ.getLiveTitle());
            this.hWH.setTag(dVar.hVJ);
            return;
        }
        this.hWH.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hWG) {
            aH(this.hWG.getTag());
        } else if (view == this.hWH) {
            aH(this.hWH.getTag());
        }
    }

    private void aH(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hWO;

        public a(e eVar) {
            super(eVar.getView());
            this.hWO = eVar;
        }
    }
}
