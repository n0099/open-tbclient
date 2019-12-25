package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.z;
/* loaded from: classes6.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext cQU;
    private TextView fTn;
    private TextView fTo;
    private com.baidu.tieba.enterForum.recommend.b.d fTp;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cQU = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fTn = (TextView) view.findViewById(R.id.recommend_title);
        this.fTo = (TextView) view.findViewById(R.id.recommend_update);
        this.fTo.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.fTn, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.fTp = dVar;
            onChangeSkinType(this.cQU, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.fTn.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z<com.baidu.tieba.enterForum.recommend.b.d> brY;
        if (view == this.fTo && (brY = brY()) != null && this.fTp.bwr() < this.fTp.getForumList().size()) {
            brY.a(view, this.fTp);
        }
    }
}
