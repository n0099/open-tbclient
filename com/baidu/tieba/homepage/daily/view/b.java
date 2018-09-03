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
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.az;
import com.baidu.tieba.f;
import com.baidu.tieba.homepage.daily.b.e;
import com.baidu.tieba.view.NoScrollGridView;
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<e> implements AdapterView.OnItemClickListener {
    private TextView dVc;
    private ImageView dVd;
    private NoScrollGridView dVe;
    private d dVf;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.dVc = (TextView) view.findViewById(f.g.topic_title_view);
        this.dVd = (ImageView) view.findViewById(f.g.topic_more);
        this.dVd.setOnClickListener(this);
        this.dVe = (NoScrollGridView) view.findViewById(f.g.topic_gridview);
        this.dVf = new d(tbPageContext.getPageActivity());
        this.dVe.setAdapter((ListAdapter) this.dVf);
        this.dVe.setOnItemClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return f.h.daily_topic_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(e eVar) {
        if (eVar != null && eVar.dUN != null) {
            this.dVf.setData(eVar.dUN);
            d(aiB(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.h(this.dVc, f.d.cp_cont_b);
            am.c(this.dVd, f.C0146f.icon_arrow_gray_right_n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.dVd) {
            if (com.baidu.tbadk.plugins.b.cc(true)) {
                new HotRanklistActivityConfig(getContext()).createNormalConfig("hotforum", "all").start();
            } else {
                String aDC = this.dVf.aDC();
                if (aDC != null) {
                    az.zI().c(this.mTbPageContext, new String[]{aDC});
                }
            }
            TiebaStatic.log(new an("c13177").r("obj_locate", 5));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e.a item = this.dVf.getItem(i);
        if (item != null) {
            if (com.baidu.tbadk.plugins.b.cc(true)) {
                new HotTopicActivityConfig(getContext()).createNormalConfig("", item.uB(), "1").start();
            } else if (item.wF() != null) {
                az.zI().c(this.mTbPageContext, new String[]{item.wF()});
            }
        }
        TiebaStatic.log(new an("c13177").r("obj_locate", i + 1));
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
    }
}
