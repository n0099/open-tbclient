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
    private TbPageContext eCn;
    private View hSD;
    private TextView iiL;
    private TextView iiM;
    private com.baidu.tieba.enterForum.recommend.b.d iiN;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eCn = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.iiL = (TextView) view.findViewById(R.id.recommend_title);
        this.hSD = view.findViewById(R.id.top_line);
        this.iiM = (TextView) view.findViewById(R.id.recommend_update);
        this.iiM.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.iiL, R.color.cp_cont_b);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void oO(boolean z) {
        this.hSD.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.iiN = dVar;
            onChangeSkinType(this.eCn, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.iiL.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> cls;
        if (view == this.iiM && (cls = cls()) != null && this.iiN.cqd() < this.iiN.getForumList().size()) {
            cls.a(view, this.iiN);
        }
    }
}
