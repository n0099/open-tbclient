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
    private TbPageContext cVi;
    private View fKw;
    private TextView fYM;
    private TextView fYN;
    private com.baidu.tieba.enterForum.recommend.b.d fYO;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVi = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fYM = (TextView) view.findViewById(R.id.recommend_title);
        this.fKw = view.findViewById(R.id.top_line);
        this.fYN = (TextView) view.findViewById(R.id.recommend_update);
        this.fYN.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.fYM, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void kM(boolean z) {
        this.fKw.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.fYO = dVar;
            onChangeSkinType(this.cVi, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.fYM.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z<com.baidu.tieba.enterForum.recommend.b.d> buH;
        if (view == this.fYN && (buH = buH()) != null && this.fYO.byY() < this.fYO.getForumList().size()) {
            buH.a(view, this.fYO);
        }
    }
}
