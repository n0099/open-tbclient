package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext eNx;
    private TextView iAs;
    private TextView iAt;
    private com.baidu.tieba.enterForum.recommend.b.d iAu;
    private View ijZ;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eNx = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.iAs = (TextView) view.findViewById(R.id.recommend_title);
        this.ijZ = view.findViewById(R.id.top_line);
        this.iAt = (TextView) view.findViewById(R.id.recommend_update);
        this.iAt.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.iAs, R.color.CAM_X0105);
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    public void pw(boolean z) {
        this.ijZ.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.iAu = dVar;
            onChangeSkinType(this.eNx, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.iAs.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> crJ;
        if (view == this.iAt && (crJ = crJ()) != null && this.iAu.cwx() < this.iAu.getForumList().size()) {
            crJ.a(view, this.iAu);
        }
    }
}
