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
    private TbPageContext cfl;
    private TextView ffB;
    private TextView ffC;
    private com.baidu.tieba.enterForum.recommend.b.d ffD;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.cfl = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.ffB = (TextView) view.findViewById(R.id.recommend_title);
        this.ffC = (TextView) view.findViewById(R.id.recommend_update);
        this.ffC.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.ffB, (int) R.color.cp_cont_j);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.ffD = dVar;
            onChangeSkinType(this.cfl, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.ffB.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> aZX;
        if (view == this.ffC && (aZX = aZX()) != null && this.ffD.beZ() < this.ffD.getForumList().size()) {
            aZX.a(view, this.ffD);
        }
    }
}
