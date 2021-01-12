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
    private TbPageContext eSJ;
    private TextView iHX;
    private TextView iHY;
    private com.baidu.tieba.enterForum.recommend.b.d iHZ;
    private View irN;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eSJ = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.iHX = (TextView) view.findViewById(R.id.recommend_title);
        this.irN = view.findViewById(R.id.top_line);
        this.iHY = (TextView) view.findViewById(R.id.recommend_update);
        this.iHY.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ao.setViewTextColor(this.iHX, R.color.CAM_X0105);
        ao.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    public void pP(boolean z) {
        this.irN.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.iHZ = dVar;
            onChangeSkinType(this.eSJ, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.iHX.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> cqL;
        if (view == this.iHY && (cqL = cqL()) != null && this.iHZ.cvz() < this.iHZ.getForumList().size()) {
            cqL.a(view, this.iHZ);
        }
    }
}
