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
    private TbImageView frA;
    private TextView frB;
    private TextView frC;
    private TextView frD;
    private TextView frE;
    private LinearLayout frx;
    private LinearLayout fry;
    private TbImageView frz;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.frx = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.fry = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.frx);
        b(this.fry);
        this.frx.setOnClickListener(this);
        this.fry.setOnClickListener(this);
        this.frz = (TbImageView) this.frx.findViewById(a.g.replay_cover);
        this.frz.setDefaultErrorResource(0);
        this.frz.setAutoChangeStyle(false);
        this.frz.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.frB = (TextView) this.frx.findViewById(a.g.replay_title);
        this.frD = (TextView) this.frx.findViewById(a.g.replay_info);
        this.frA = (TbImageView) this.fry.findViewById(a.g.replay_cover);
        this.frA.setDefaultErrorResource(0);
        this.frA.setAutoChangeStyle(false);
        this.frA.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.frC = (TextView) this.fry.findViewById(a.g.replay_title);
        this.frE = (TextView) this.fry.findViewById(a.g.replay_info);
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
        if (dVar.fqy != null) {
            this.frx.setVisibility(0);
            this.frz.startLoad(StringUtils.isNull(dVar.fqy.getMedia_pic()) ? dVar.fqy.getLiveCover() : dVar.fqy.getMedia_pic(), 10, false);
            this.frD.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(dVar.fqy.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fqy.end_time));
            this.frB.setText(dVar.fqy.getLiveTitle());
            this.frx.setTag(dVar.fqy);
        } else {
            this.frx.setVisibility(4);
        }
        if (dVar.fqz != null) {
            this.fry.setVisibility(0);
            this.frA.startLoad(StringUtils.isNull(dVar.fqz.getMedia_pic()) ? dVar.fqz.getLiveCover() : dVar.fqz.getMedia_pic(), 10, false);
            this.frE.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.dd(dVar.fqz.join_count)) + " | " + StringHelper.getTimeInterval(dVar.fqz.end_time));
            this.frC.setText(dVar.fqz.getLiveTitle());
            this.fry.setTag(dVar.fqz);
            return;
        }
        this.fry.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.frx) {
            ar(this.frx.getTag());
        } else if (view == this.fry) {
            ar(this.fry.getTag());
        }
    }

    private void ar(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes3.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e frF;

        public a(e eVar) {
            super(eVar.getView());
            this.frF = eVar;
        }
    }
}
