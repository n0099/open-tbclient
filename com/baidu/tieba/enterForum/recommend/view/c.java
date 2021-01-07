package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext eXu;
    private TextView iME;
    private TextView iMF;
    private com.baidu.tieba.enterForum.recommend.b.d iMG;
    private View iwu;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eXu = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.iME = (TextView) view.findViewById(R.id.recommend_title);
        this.iwu = view.findViewById(R.id.top_line);
        this.iMF = (TextView) view.findViewById(R.id.recommend_update);
        this.iMF.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ao.setViewTextColor(this.iME, R.color.CAM_X0105);
        ao.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    public void pT(boolean z) {
        this.iwu.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.iMG = dVar;
            onChangeSkinType(this.eXu, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.iME.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> cuD;
        if (view == this.iMF && (cuD = cuD()) != null && this.iMG.czr() < this.iMG.getForumList().size()) {
            cuD.a(view, this.iMG);
        }
    }
}
