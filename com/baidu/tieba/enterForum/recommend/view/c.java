package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext dIF;
    private View gEG;
    private TextView gUN;
    private TextView gUO;
    private com.baidu.tieba.enterForum.recommend.b.d gUP;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dIF = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.gUN = (TextView) view.findViewById(R.id.recommend_title);
        this.gEG = view.findViewById(R.id.top_line);
        this.gUO = (TextView) view.findViewById(R.id.recommend_update);
        this.gUO.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.gUN, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void mp(boolean z) {
        this.gEG.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.gUP = dVar;
            onChangeSkinType(this.dIF, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.gUN.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> bKS;
        if (view == this.gUO && (bKS = bKS()) != null && this.gUP.bPy() < this.gUP.getForumList().size()) {
            bKS.a(view, this.gUP);
        }
    }
}
