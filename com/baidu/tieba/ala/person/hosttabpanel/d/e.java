package com.baidu.tieba.ala.person.hosttabpanel.d;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.live.adp.lib.util.BdUtilHelper;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.adp.widget.listview.TypeAdapter;
import com.baidu.live.k.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.widget.TbImageView;
/* loaded from: classes6.dex */
public class e extends com.baidu.live.tieba.b.a<com.baidu.tieba.ala.person.hosttabpanel.b.d> {
    private LinearLayout eum;
    private LinearLayout eun;
    private TbImageView euo;
    private TbImageView eup;
    private TextView euq;
    private TextView eur;
    private TextView eus;
    private TextView eut;
    private final String euu;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.euu = " | ";
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.eum = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.eun = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        c(this.eum);
        c(this.eun);
        this.eum.setOnClickListener(this);
        this.eun.setOnClickListener(this);
        this.euo = (TbImageView) this.eum.findViewById(a.g.replay_cover);
        this.euo.setDefaultErrorResource(0);
        this.euo.setAutoChangeStyle(false);
        this.euo.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.euq = (TextView) this.eum.findViewById(a.g.replay_title);
        this.eus = (TextView) this.eum.findViewById(a.g.replay_info);
        this.eup = (TbImageView) this.eun.findViewById(a.g.replay_cover);
        this.eup.setDefaultErrorResource(0);
        this.eup.setAutoChangeStyle(false);
        this.eup.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.eur = (TextView) this.eun.findViewById(a.g.replay_title);
        this.eut = (TextView) this.eun.findViewById(a.g.replay_info);
    }

    private void c(LinearLayout linearLayout) {
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
        if (dVar.etn != null) {
            this.eum.setVisibility(0);
            this.euo.startLoad(StringUtils.isNull(dVar.etn.getMedia_pic()) ? dVar.etn.getLiveCover() : dVar.etn.getMedia_pic(), 10, false);
            this.eus.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.co(dVar.etn.join_count)) + " | " + StringHelper.getTimeInterval(dVar.etn.end_time));
            this.euq.setText(dVar.etn.getLiveTitle());
            this.eum.setTag(dVar.etn);
        } else {
            this.eum.setVisibility(4);
        }
        if (dVar.eto != null) {
            this.eun.setVisibility(0);
            this.eup.startLoad(StringUtils.isNull(dVar.eto.getMedia_pic()) ? dVar.eto.getLiveCover() : dVar.eto.getMedia_pic(), 10, false);
            this.eut.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.co(dVar.eto.join_count)) + " | " + StringHelper.getTimeInterval(dVar.eto.end_time));
            this.eur.setText(dVar.eto.getLiveTitle());
            this.eun.setTag(dVar.eto);
            return;
        }
        this.eun.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.eum) {
            aj(this.eum.getTag());
        } else if (view == this.eun) {
            aj(this.eun.getTag());
        }
    }

    private void aj(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes6.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e euv;

        public a(e eVar) {
            super(eVar.getView());
            this.euv = eVar;
        }
    }
}
