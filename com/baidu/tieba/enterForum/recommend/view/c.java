package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.al;
import com.baidu.tieba.card.ab;
import com.baidu.tieba.d;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.d> {
    private TextView eGa;
    private TextView eGb;
    private com.baidu.tieba.enterForum.recommend.b.d eGc;
    private TbPageContext mContext;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.mContext = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.eGa = (TextView) view.findViewById(d.g.recommend_title);
        this.eGb = (TextView) view.findViewById(d.g.recommend_update);
        this.eGb.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        al.j(this.eGa, d.C0277d.cp_cont_j);
        al.l(getView(), d.C0277d.cp_bg_line_c);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.eGc = dVar;
            onChangeSkinType(this.mContext, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.eGa.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> aQf;
        if (view == this.eGb && (aQf = aQf()) != null && this.eGc.aXc() < this.eGc.getForumList().size()) {
            aQf.a(view, this.eGc);
        }
    }
}
