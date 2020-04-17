package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext duG;
    private TextView gFZ;
    private TextView gGa;
    private com.baidu.tieba.enterForum.recommend.b.d gGb;
    private View gpL;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.duG = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.gFZ = (TextView) view.findViewById(R.id.recommend_title);
        this.gpL = view.findViewById(R.id.top_line);
        this.gGa = (TextView) view.findViewById(R.id.recommend_update);
        this.gGa.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.gFZ, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void lU(boolean z) {
        this.gpL.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.gGb = dVar;
            onChangeSkinType(this.duG, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.gFZ.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z<com.baidu.tieba.enterForum.recommend.b.d> bEy;
        if (view == this.gGa && (bEy = bEy()) != null && this.gGb.bJg() < this.gGb.getForumList().size()) {
            bEy.a(view, this.gGb);
        }
    }
}
