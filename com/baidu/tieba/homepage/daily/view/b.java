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
    private TextView esD;
    private ImageView esE;
    private NoScrollGridView esF;
    private d esG;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.esD = (TextView) view.findViewById(e.g.topic_title_view);
        this.esE = (ImageView) view.findViewById(e.g.topic_more);
        this.esE.setOnClickListener(this);
        this.esF = (NoScrollGridView) view.findViewById(e.g.topic_gridview);
        this.esG = new d(tbPageContext.getPageActivity());
        this.esF.setAdapter((ListAdapter) this.esG);
        this.esF.setOnItemClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.daily_topic_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.daily.b.e eVar) {
        if (eVar != null && eVar.esp != null) {
            this.esG.setData(eVar.esp);
            d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.esD, e.d.cp_cont_b);
            al.c(this.esE, e.f.icon_arrow_gray_right_n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.esE) {
            if (com.baidu.tbadk.plugins.b.cP(true)) {
                new HotRanklistActivityConfig(getContext()).createNormalConfig("hotforum", "all").start();
            } else {
                String aKw = this.esG.aKw();
                if (aKw != null) {
                    ay.Ef().c(this.mTbPageContext, new String[]{aKw});
                }
            }
            TiebaStatic.log(new am("c13177").x("obj_locate", 5));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e.a item = this.esG.getItem(i);
        if (item != null) {
            if (com.baidu.tbadk.plugins.b.cP(true)) {
                new HotTopicActivityConfig(getContext()).createNormalConfig("", item.yY(), "1").start();
            } else if (item.Bg() != null) {
                ay.Ef().c(this.mTbPageContext, new String[]{item.Bg()});
            }
        }
        TiebaStatic.log(new am("c13177").x("obj_locate", i + 1));
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
    }
}
