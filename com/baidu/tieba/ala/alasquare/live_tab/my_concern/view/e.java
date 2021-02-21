package com.baidu.tieba.ala.alasquare.live_tab.my_concern.view;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes10.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView gDv;
    private TbImageView gDw;
    private TbImageView gDx;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a gDy;
    private View mRoot;
    private TextView mTitle;

    public e(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.gDv = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.gDw = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.gDx = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.gDx.setAutoChangeStyle(true);
        this.gDx.setDefaultResource(17170445);
        this.gDx.setDefaultBgResource(17170445);
        this.gDw.setOnClickListener(this);
        this.gDv.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
        ap.setViewTextColor(this.gDv, R.color.CAM_X0101);
        ap.setImageResource(this.gDw, R.drawable.icon_tab_live_close_n);
        ap.setBackgroundResource(this.gDv, R.drawable.tab_sub_notification_btn_bg_selecor);
        ap.setImageResource(this.gDx, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.gDy = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (csc() != null) {
            csc().a(view, this.gDy);
        }
    }
}
