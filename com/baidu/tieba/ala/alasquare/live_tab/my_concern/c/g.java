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
    private TbImageView ggA;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a ggB;
    private TextView ggy;
    private TbImageView ggz;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.ggy = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.ggz = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.ggA = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.ggA.setAutoChangeStyle(true);
        this.ggA.setDefaultResource(17170445);
        this.ggA.setDefaultErrorResource(17170445);
        this.ggA.setDefaultBgResource(17170445);
        this.ggz.setOnClickListener(this);
        this.ggy.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        ap.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.mTitle, R.color.cp_cont_a);
        ap.setViewTextColor(this.ggy, R.color.cp_cont_a);
        ap.setImageResource(this.ggz, R.drawable.icon_tab_live_close_n);
        ap.setBackgroundResource(this.ggy, R.drawable.tab_sub_notification_btn_bg_selecor);
        ap.setImageResource(this.ggA, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.ggB = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (cls() != null) {
            cls().a(view, this.ggB);
        }
    }
}
