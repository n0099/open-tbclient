package com.baidu.tieba.ala.alasquare.live_tab.my_concern.c;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class g extends com.baidu.tieba.card.a<com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a> {
    private TextView dxZ;
    private TbImageView dya;
    private TbImageView dyb;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a dyc;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.dxZ = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.dya = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.dyb = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.dyb.setAutoChangeStyle(true);
        this.dyb.setDefaultResource(17170445);
        this.dyb.setDefaultErrorResource(17170445);
        this.dyb.setDefaultBgResource(17170445);
        this.dya.setOnClickListener(this);
        this.dxZ.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dxZ, (int) R.color.cp_cont_a);
        am.setImageResource(this.dya, R.drawable.icon_tab_live_close_n);
        am.setBackgroundResource(this.dxZ, R.drawable.tab_sub_notification_btn_bg_selecor);
        am.setImageResource(this.dyb, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.dyc = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZV() != null) {
            aZV().a(view, this.dyc);
        }
    }
}
