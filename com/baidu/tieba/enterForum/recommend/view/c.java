package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes22.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext etO;
    private View hGg;
    private TextView hWl;
    private TextView hWm;
    private com.baidu.tieba.enterForum.recommend.b.d hWn;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.etO = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.hWl = (TextView) view.findViewById(R.id.recommend_title);
        this.hGg = view.findViewById(R.id.top_line);
        this.hWm = (TextView) view.findViewById(R.id.recommend_update);
        this.hWm.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.hWl, R.color.cp_cont_b);
        ap.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void ow(boolean z) {
        this.hGg.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.hWn = dVar;
            onChangeSkinType(this.etO, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.hWl.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> cil;
        if (view == this.hWm && (cil = cil()) != null && this.hWn.cmW() < this.hWn.getForumList().size()) {
            cil.a(view, this.hWn);
        }
    }
}
