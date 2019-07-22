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
import com.baidu.tbadk.core.util.bb;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.daily.b.e;
import com.baidu.tieba.view.NoScrollGridView;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<e> implements AdapterView.OnItemClickListener {
    private TextView gek;
    private ImageView gel;
    private NoScrollGridView gem;
    private d gen;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gek = (TextView) view.findViewById(R.id.topic_title_view);
        this.gel = (ImageView) view.findViewById(R.id.topic_more);
        this.gel.setOnClickListener(this);
        this.gem = (NoScrollGridView) view.findViewById(R.id.topic_gridview);
        this.gen = new d(tbPageContext.getPageActivity());
        this.gem.setAdapter((ListAdapter) this.gen);
        this.gem.setOnItemClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.daily_topic_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(e eVar) {
        if (eVar != null && eVar.gdU != null) {
            this.gen.setData(eVar.gdU);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.j(this.gek, R.color.cp_cont_b);
            am.c(this.gel, (int) R.drawable.icon_arrow_gray_right_n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gel) {
            if (com.baidu.tbadk.plugins.b.fI(true)) {
                new HotRanklistActivityConfig(getContext()).createNormalConfig("hotforum", "all").start();
            } else {
                String bvk = this.gen.bvk();
                if (bvk != null) {
                    bb.ajC().c(this.mTbPageContext, new String[]{bvk});
                }
            }
            TiebaStatic.log(new an("c13177").P("obj_locate", 5));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e.a item = this.gen.getItem(i);
        if (item != null) {
            if (com.baidu.tbadk.plugins.b.fI(true)) {
                new HotTopicActivityConfig(getContext()).createNormalConfig("", item.adG(), "1").start();
            } else if (item.agf() != null) {
                bb.ajC().c(this.mTbPageContext, new String[]{item.agf()});
            }
        }
        TiebaStatic.log(new an("c13177").P("obj_locate", i + 1));
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
    }
}
