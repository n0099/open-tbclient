package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes4.dex */
public class c extends com.baidu.tieba.card.a<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext ceu;
    private TextView feK;
    private TextView feL;
    private com.baidu.tieba.enterForum.recommend.b.d feM;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.ceu = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.feK = (TextView) view.findViewById(R.id.recommend_title);
        this.feL = (TextView) view.findViewById(R.id.recommend_update);
        this.feL.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.feK, (int) R.color.cp_cont_j);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.feM = dVar;
            onChangeSkinType(this.ceu, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.feK.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> aZV;
        if (view == this.feL && (aZV = aZV()) != null && this.feM.beX() < this.feM.getForumList().size()) {
            aZV.a(view, this.feM);
        }
    }
}
