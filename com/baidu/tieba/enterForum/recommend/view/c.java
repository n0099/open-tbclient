package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.R;
import com.baidu.tieba.card.ab;
/* loaded from: classes21.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext eGu;
    private View hZa;
    private com.baidu.tieba.enterForum.recommend.b.d ipA;
    private TextView ipy;
    private TextView ipz;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.eGu = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.ipy = (TextView) view.findViewById(R.id.recommend_title);
        this.hZa = view.findViewById(R.id.top_line);
        this.ipz = (TextView) view.findViewById(R.id.recommend_update);
        this.ipz.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        ap.setViewTextColor(this.ipy, R.color.CAM_X0105);
        ap.setBackgroundColor(getView(), R.color.CAM_X0205);
    }

    public void pa(boolean z) {
        this.hZa.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.ipA = dVar;
            onChangeSkinType(this.eGu, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.ipy.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ab<com.baidu.tieba.enterForum.recommend.b.d> cnv;
        if (view == this.ipz && (cnv = cnv()) != null && this.ipA.csh() < this.ipA.getForumList().size()) {
            cnv.a(view, this.ipA);
        }
    }
}
