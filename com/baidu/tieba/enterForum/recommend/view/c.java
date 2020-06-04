package com.baidu.tieba.enterForum.recommend.view;

import android.view.View;
import android.widget.TextView;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.card.aa;
/* loaded from: classes9.dex */
public class c extends com.baidu.tieba.card.b<com.baidu.tieba.enterForum.recommend.b.d> {
    private TbPageContext dIF;
    private View gER;
    private TextView gUY;
    private TextView gUZ;
    private com.baidu.tieba.enterForum.recommend.b.d gVa;
    private int mSkinType;

    public c(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        this.dIF = tbPageContext;
        initUI();
    }

    private void initUI() {
        View view = getView();
        this.gUY = (TextView) view.findViewById(R.id.recommend_title);
        this.gER = view.findViewById(R.id.top_line);
        this.gUZ = (TextView) view.findViewById(R.id.recommend_update);
        this.gUZ.setOnClickListener(this);
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        this.mSkinType = i;
        am.setViewTextColor(this.gUY, (int) R.color.cp_cont_b);
        am.setBackgroundColor(getView(), R.color.cp_bg_line_e);
    }

    public void mp(boolean z) {
        this.gER.setVisibility(z ? 0 : 8);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.enterForum.recommend.b.d dVar) {
        if (dVar != null) {
            this.gVa = dVar;
            onChangeSkinType(this.dIF, this.mSkinType);
            if (!StringUtils.isNull(dVar.getTitle())) {
                this.gUY.setText(dVar.getTitle());
            }
        }
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.recommend_forum_title_layout;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aa<com.baidu.tieba.enterForum.recommend.b.d> bKU;
        if (view == this.gUZ && (bKU = bKU()) != null && this.gVa.bPA() < this.gVa.getForumList().size()) {
            bKU.a(view, this.gVa);
        }
    }
}
