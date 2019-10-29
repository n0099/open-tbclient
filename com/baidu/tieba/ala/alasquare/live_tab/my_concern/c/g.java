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
    private TextView dyQ;
    private TbImageView dyR;
    private TbImageView dyS;
    private com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a dyT;
    private View mRoot;
    private TextView mTitle;

    public g(TbPageContext tbPageContext, ViewGroup viewGroup) {
        super(tbPageContext, viewGroup);
        this.mRoot = getView();
        this.mTitle = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_title);
        this.dyQ = (TextView) getView().findViewById(R.id.id_tab_live_sub_notification_close_go_to_open);
        this.dyR = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_close_btn);
        this.dyS = (TbImageView) getView().findViewById(R.id.id_tab_live_sub_notification_bg_img);
        this.dyS.setAutoChangeStyle(true);
        this.dyS.setDefaultResource(17170445);
        this.dyS.setDefaultErrorResource(17170445);
        this.dyS.setDefaultBgResource(17170445);
        this.dyR.setOnClickListener(this);
        this.dyQ.setOnClickListener(this);
        onChangeSkinType(tbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        am.setBackgroundResource(this.mRoot, R.color.cp_bg_line_d);
        am.setViewTextColor(this.mTitle, (int) R.color.cp_cont_a);
        am.setViewTextColor(this.dyQ, (int) R.color.cp_cont_a);
        am.setImageResource(this.dyR, R.drawable.icon_tab_live_close_n);
        am.setBackgroundResource(this.dyQ, R.drawable.tab_sub_notification_btn_bg_selecor);
        am.setImageResource(this.dyS, R.drawable.bg_tab_live_notification);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.tab_sub_notification_layout;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.ala.alasquare.live_tab.my_concern.data.a aVar) {
        this.dyT = aVar;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (aZX() != null) {
            aZX().a(view, this.dyT);
        }
    }
}
