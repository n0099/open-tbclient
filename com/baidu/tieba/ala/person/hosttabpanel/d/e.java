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
    private TextView hWA;
    private TextView hWB;
    private LinearLayout hWu;
    private LinearLayout hWv;
    private TbImageView hWw;
    private TbImageView hWx;
    private TextView hWy;
    private TextView hWz;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.hWu = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_one);
        this.hWv = (LinearLayout) this.mRootView.findViewById(a.f.replay_item_two);
        b(this.hWu);
        b(this.hWv);
        this.hWu.setOnClickListener(this);
        this.hWv.setOnClickListener(this);
        this.hWw = (TbImageView) this.hWu.findViewById(a.f.replay_cover);
        this.hWw.setDefaultErrorResource(0);
        this.hWw.setAutoChangeStyle(false);
        this.hWw.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hWy = (TextView) this.hWu.findViewById(a.f.replay_title);
        this.hWA = (TextView) this.hWu.findViewById(a.f.replay_info);
        this.hWx = (TbImageView) this.hWv.findViewById(a.f.replay_cover);
        this.hWx.setDefaultErrorResource(0);
        this.hWx.setAutoChangeStyle(false);
        this.hWx.setDefaultBgResource(a.e.sdk_pic_bg_video_frs);
        this.hWz = (TextView) this.hWv.findViewById(a.f.replay_title);
        this.hWB = (TextView) this.hWv.findViewById(a.f.replay_info);
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
        if (dVar.hVw != null) {
            this.hWu.setVisibility(0);
            this.hWw.startLoad(StringUtils.isNull(dVar.hVw.getMedia_pic()) ? dVar.hVw.getLiveCover() : dVar.hVw.getMedia_pic(), 10, false);
            this.hWA.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bg(dVar.hVw.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hVw.end_time));
            this.hWy.setText(dVar.hVw.getLiveTitle());
            this.hWu.setTag(dVar.hVw);
        } else {
            this.hWu.setVisibility(4);
        }
        if (dVar.hVx != null) {
            this.hWv.setVisibility(0);
            this.hWx.startLoad(StringUtils.isNull(dVar.hVx.getMedia_pic()) ? dVar.hVx.getLiveCover() : dVar.hVx.getMedia_pic(), 10, false);
            this.hWB.setText(String.format(this.mPageContext.getString(a.h.ala_person_audience), com.baidu.tieba.ala.person.d.a.bg(dVar.hVx.join_count)) + " | " + StringHelper.getTimeInterval(dVar.hVx.end_time));
            this.hWz.setText(dVar.hVx.getLiveTitle());
            this.hWv.setTag(dVar.hVx);
            return;
        }
        this.hWv.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.hWu) {
            aH(this.hWu.getTag());
        } else if (view == this.hWv) {
            aH(this.hWv.getTag());
        }
    }

    private void aH(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes11.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e hWC;

        public a(e eVar) {
            super(eVar.getView());
            this.hWC = eVar;
        }
    }
}
