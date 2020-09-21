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
    private LinearLayout gUp;
    private LinearLayout gUq;
    private TbImageView gUr;
    private TbImageView gUs;
    private TextView gUt;
    private TextView gUu;
    private TextView gUv;
    private TextView gUw;
    private TbPageContext mPageContext;
    private View mRootView;

    public e(TbPageContext tbPageContext) {
        super(tbPageContext);
        this.mPageContext = tbPageContext;
        this.mRootView = getView();
        this.gUp = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_one);
        this.gUq = (LinearLayout) this.mRootView.findViewById(a.g.replay_item_two);
        b(this.gUp);
        b(this.gUq);
        this.gUp.setOnClickListener(this);
        this.gUq.setOnClickListener(this);
        this.gUr = (TbImageView) this.gUp.findViewById(a.g.replay_cover);
        this.gUr.setDefaultErrorResource(0);
        this.gUr.setAutoChangeStyle(false);
        this.gUr.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gUt = (TextView) this.gUp.findViewById(a.g.replay_title);
        this.gUv = (TextView) this.gUp.findViewById(a.g.replay_info);
        this.gUs = (TbImageView) this.gUq.findViewById(a.g.replay_cover);
        this.gUs.setDefaultErrorResource(0);
        this.gUs.setAutoChangeStyle(false);
        this.gUs.setDefaultBgResource(a.f.sdk_pic_bg_video_frs);
        this.gUu = (TextView) this.gUq.findViewById(a.g.replay_title);
        this.gUw = (TextView) this.gUq.findViewById(a.g.replay_info);
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
        if (dVar.gTr != null) {
            this.gUp.setVisibility(0);
            this.gUr.startLoad(StringUtils.isNull(dVar.gTr.getMedia_pic()) ? dVar.gTr.getLiveCover() : dVar.gTr.getMedia_pic(), 10, false);
            this.gUv.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.eu(dVar.gTr.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gTr.end_time));
            this.gUt.setText(dVar.gTr.getLiveTitle());
            this.gUp.setTag(dVar.gTr);
        } else {
            this.gUp.setVisibility(4);
        }
        if (dVar.gTs != null) {
            this.gUq.setVisibility(0);
            this.gUs.startLoad(StringUtils.isNull(dVar.gTs.getMedia_pic()) ? dVar.gTs.getLiveCover() : dVar.gTs.getMedia_pic(), 10, false);
            this.gUw.setText(String.format(this.mPageContext.getString(a.i.ala_person_audience), com.baidu.tieba.ala.person.d.a.eu(dVar.gTs.join_count)) + " | " + StringHelper.getTimeInterval(dVar.gTs.end_time));
            this.gUu.setText(dVar.gTs.getLiveTitle());
            this.gUq.setTag(dVar.gTs);
            return;
        }
        this.gUq.setVisibility(4);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gUp) {
            aC(this.gUp.getTag());
        } else if (view == this.gUq) {
            aC(this.gUq.getTag());
        }
    }

    private void aC(Object obj) {
    }

    @Override // com.baidu.live.tieba.b.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
    }

    /* loaded from: classes4.dex */
    public static class a extends TypeAdapter.ViewHolder {
        public e gUx;

        public a(e eVar) {
            super(eVar.getView());
            this.gUx = eVar;
        }
    }
}
