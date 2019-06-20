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
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.daily.b.e;
import com.baidu.tieba.view.NoScrollGridView;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<e> implements AdapterView.OnItemClickListener {
    private TextView fZn;
    private ImageView fZo;
    private NoScrollGridView fZp;
    private d fZq;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fZn = (TextView) view.findViewById(R.id.topic_title_view);
        this.fZo = (ImageView) view.findViewById(R.id.topic_more);
        this.fZo.setOnClickListener(this);
        this.fZp = (NoScrollGridView) view.findViewById(R.id.topic_gridview);
        this.fZq = new d(tbPageContext.getPageActivity());
        this.fZp.setAdapter((ListAdapter) this.fZq);
        this.fZp.setOnItemClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.daily_topic_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(e eVar) {
        if (eVar != null && eVar.fYX != null) {
            this.fZq.setData(eVar.fYX);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.fZn, R.color.cp_cont_b);
            al.c(this.fZo, (int) R.drawable.icon_arrow_gray_right_n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fZo) {
            if (com.baidu.tbadk.plugins.b.fE(true)) {
                new HotRanklistActivityConfig(getContext()).createNormalConfig("hotforum", "all").start();
            } else {
                String bti = this.fZq.bti();
                if (bti != null) {
                    ba.aiz().c(this.mTbPageContext, new String[]{bti});
                }
            }
            TiebaStatic.log(new am("c13177").P("obj_locate", 5));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e.a item = this.fZq.getItem(i);
        if (item != null) {
            if (com.baidu.tbadk.plugins.b.fE(true)) {
                new HotTopicActivityConfig(getContext()).createNormalConfig("", item.acE(), "1").start();
            } else if (item.afd() != null) {
                ba.aiz().c(this.mTbPageContext, new String[]{item.afd()});
            }
        }
        TiebaStatic.log(new am("c13177").P("obj_locate", i + 1));
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
    }
}
