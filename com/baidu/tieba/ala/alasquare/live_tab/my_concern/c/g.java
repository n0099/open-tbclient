package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes4.dex */
public class g extends com.baidu.tieba.card.b<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView glT;
    private TbImageView glU;
    private TbImageView glV;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a glW;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.glT = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.glU = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.glV = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.glV.setAutoChangeStyle(true);
        this.glV.setDefaultResource(17170445);
        this.glV.setDefaultErrorResource(17170445);
        this.glV.setDefaultBgResource(17170445);
        this.glU.setOnClickListener(this);
        this.glT.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.CAM_X0201);
        ap.setViewTextColor(this.mTitle, R.color.CAM_X0101);
        ap.setViewTextColor(this.glT, R.color.CAM_X0101);
        ap.setImageResource(this.glU, R.drawable.icon_tab_live_close_n);
        ap.setBackgroundResource(this.glT, R.drawable.tab_sub_notification_btn_bg_selecor);
        ap.setImageResource(this.glV, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.glW = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cnv() != null) {
            cnv().a(view, this.glW);
        }
    }
}
