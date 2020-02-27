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
    private TbPageContext cVg;
    private View fKh;
    private TextView fYx;
    private TextView fYy;
    private com.baidu.tieba.enterForum.recommend.b.d fYz;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVg = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fYx = (TextView) view.findViewById(R.id.recommend_title);
        this.fKh = view.findViewById(R.id.top_line);
        this.fYy = (TextView) view.findViewById(R.id.recommend_update);
        this.fYy.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.fYx, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void kM(boolean z) {
        this.fKh.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.fYz = dVar;
            onChangeSkinType(this.cVg, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.fYx.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z<com.baidu.tieba.enterForum.recommend.b.d> buE;
        if (view == this.fYy && (buE = buE()) != null && this.fYz.byV() < this.fYz.getForumList().size()) {
            buE.a(view, this.fYz);
        }
    }
}
