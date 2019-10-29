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
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tieba.R;
import com.baidu.tieba.homepage.daily.b.e;
import com.baidu.tieba.view.NoScrollGridView;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<e> implements AdapterView.OnItemClickListener {
    private TextView ggp;
    private ImageView ggq;
    private NoScrollGridView ggr;
    private d ggs;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ggp = (TextView) view.findViewById(R.id.topic_title_view);
        this.ggq = (ImageView) view.findViewById(R.id.topic_more);
        this.ggq.setOnClickListener(this);
        this.ggr = (NoScrollGridView) view.findViewById(R.id.topic_gridview);
        this.ggs = new d(tbPageContext.getPageActivity());
        this.ggr.setAdapter((ListAdapter) this.ggs);
        this.ggr.setOnItemClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.daily_topic_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(e eVar) {
        if (eVar != null && eVar.gfZ != null) {
            this.ggs.setData(eVar.gfZ);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.ggp, (int) R.color.cp_cont_b);
            SvgManager.amN().a(this.ggq, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ggq) {
            if (com.baidu.tbadk.plugins.b.fA(true)) {
                new HotRanklistActivityConfig(getContext()).createNormalConfig("hotforum", "all").start();
            } else {
                String btq = this.ggs.btq();
                if (btq != null) {
                    ba.amQ().b(this.mTbPageContext, new String[]{btq});
                }
            }
            TiebaStatic.log(new an("c13177").O("obj_locate", 5));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e.a item = this.ggs.getItem(i);
        if (item != null) {
            if (com.baidu.tbadk.plugins.b.fA(true)) {
                new HotTopicActivityConfig(getContext()).createNormalConfig("", item.ahP(), "1").start();
            } else if (item.akn() != null) {
                ba.amQ().b(this.mTbPageContext, new String[]{item.akn()});
            }
        }
        TiebaStatic.log(new an("c13177").O("obj_locate", i + 1));
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
    }
}
