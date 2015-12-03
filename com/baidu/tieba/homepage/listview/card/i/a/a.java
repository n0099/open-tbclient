package com.baidu.tieba.homepage.listview.card.i.a;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.homepage.listview.card.i.b;
import com.baidu.tieba.homepage.listview.g;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class a extends x.a implements g<b.a> {
    private TextView avJ;
    private View bBR;
    private TbImageView bBS;
    private View bBT;
    private TextView bBU;
    private TbPageContext<?> mPageContext;

    public a(TbPageContext<?> tbPageContext, View view) {
        super(view);
        this.mPageContext = tbPageContext;
        this.bBR = view.findViewById(n.f.hot_video_item_root);
        this.bBS = (TbImageView) view.findViewById(n.f.hot_video_item_img);
        this.bBS.setDrawBorder(true);
        this.bBS.setBorderWidth(1);
        this.bBT = view.findViewById(n.f.hot_video_item_icon);
        this.bBU = (TextView) view.findViewById(n.f.hot_video_item_title);
        this.avJ = (TextView) view.findViewById(n.f.hot_video_item_content);
        this.bBS.setDefaultBgResource(n.e.pic_bg_video_frs);
        this.bBS.setDefaultResource(17170445);
        TX();
    }

    @Override // com.baidu.tieba.homepage.listview.g
    public View TY() {
        return getView();
    }

    private void TX() {
        as.i(this.bBR, n.e.topic_name_selector);
        as.i(this.bBT, n.e.btn_icon_play_video_n);
        as.h((View) this.bBU, n.c.cp_cont_b);
        as.h((View) this.avJ, n.c.cp_cont_d);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.homepage.listview.g
    /* renamed from: a */
    public void D(b.a aVar) {
        this.bBS.d(aVar.bBP, 10, false);
        this.bBU.setText(ax.dw(aVar.title));
        this.avJ.setText(ax.dw(aVar.bBy));
        this.bBR.setOnClickListener(new b(this, aVar));
    }

    public void cZ(int i) {
        TX();
    }
}
