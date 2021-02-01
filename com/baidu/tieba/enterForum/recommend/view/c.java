package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes2.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext eUY;
    private TextView iNF;
    private TextView iNG;
    private com.baidu.tieba.enterForum.recommend.b.d iNH;
    private View ixr;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eUY = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.iNF = (TextView) view.findViewById(R.id.recommend_title);
        this.ixr = view.findViewById(R.id.top_line);
        this.iNG = (TextView) view.findViewById(R.id.recommend_update);
        this.iNG.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.iNF, R.color.CAM_X0105);
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    public void pZ(boolean z) {
        this.ixr.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.iNH = dVar;
            onChangeSkinType(this.eUY, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.iNF.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> crV;
        if (view == this.iNG && (crV = crV()) != null && this.iNH.cwL() < this.iNH.getForumList().size()) {
            crV.a(view, this.iNH);
        }
    }
}
