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
    private TbPageContext cVv;
    private View fLe;
    private TextView fZu;
    private TextView fZv;
    private com.baidu.tieba.enterForum.recommend.b.d fZw;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cVv = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.fZu = (TextView) view.findViewById(R.id.recommend_title);
        this.fLe = view.findViewById(R.id.top_line);
        this.fZv = (TextView) view.findViewById(R.id.recommend_update);
        this.fZv.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.fZu, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void kR(boolean z) {
        this.fLe.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.fZw = dVar;
            onChangeSkinType(this.cVv, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.fZu.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        z<com.baidu.tieba.enterForum.recommend.b.d> buM;
        if (view == this.fZv && (buM = buM()) != null && this.fZw.bze() < this.fZw.getForumList().size()) {
            buM.a(view, this.fZw);
        }
    }
}
