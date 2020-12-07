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
    private TextView iAq;
    private TextView iAr;
    private com.baidu.tieba.enterForum.recommend.b.d iAs;
    private View ijX;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eNx = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.iAq = (TextView) view.findViewById(R.id.recommend_title);
        this.ijX = view.findViewById(R.id.top_line);
        this.iAr = (TextView) view.findViewById(R.id.recommend_update);
        this.iAr.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.iAq, R.color.CAM_X0105);
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    public void pw(boolean z) {
        this.ijX.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.iAs = dVar;
            onChangeSkinType(this.eNx, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.iAq.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> crI;
        if (view == this.iAr && (crI = crI()) != null && this.iAs.cww() < this.iAs.getForumList().size()) {
            crI.a(view, this.iAs);
        }
    }
}
