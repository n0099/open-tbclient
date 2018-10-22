package com.baidu.tieba.homepage.daily.view;

import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.HotRanklistActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.e;
import com.baidu.tieba.homepage.daily.b.e;
import com.baidu.tieba.view.NoScrollGridView;
/* loaded from: classes6.dex */
public class b extends com.baidu.tieba.card.a<e> implements AdapterView.OnItemClickListener {
    private TextView ekp;
    private ImageView ekq;
    private NoScrollGridView ekr;
    private d eks;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ekp = (TextView) view.findViewById(e.g.topic_title_view);
        this.ekq = (ImageView) view.findViewById(e.g.topic_more);
        this.ekq.setOnClickListener(this);
        this.ekr = (NoScrollGridView) view.findViewById(e.g.topic_gridview);
        this.eks = new d(tbPageContext.getPageActivity());
        this.ekr.setAdapter((ListAdapter) this.eks);
        this.ekr.setOnItemClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.daily_topic_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.daily.b.e eVar) {
        if (eVar != null && eVar.eka != null) {
            this.eks.setData(eVar.eka);
            d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.ekp, e.d.cp_cont_b);
            al.c(this.ekq, e.f.icon_arrow_gray_right_n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ekq) {
            if (com.baidu.tbadk.plugins.b.cx(true)) {
                new HotRanklistActivityConfig(getContext()).createNormalConfig("hotforum", "all").start();
            } else {
                String aJh = this.eks.aJh();
                if (aJh != null) {
                    ay.CU().c(this.mTbPageContext, new String[]{aJh});
                }
            }
            TiebaStatic.log(new am("c13177").x("obj_locate", 5));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e.a item = this.eks.getItem(i);
        if (item != null) {
            if (com.baidu.tbadk.plugins.b.cx(true)) {
                new HotTopicActivityConfig(getContext()).createNormalConfig("", item.xN(), "1").start();
            } else if (item.zV() != null) {
                ay.CU().c(this.mTbPageContext, new String[]{item.zV()});
            }
        }
        TiebaStatic.log(new am("c13177").x("obj_locate", i + 1));
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
    }
}
