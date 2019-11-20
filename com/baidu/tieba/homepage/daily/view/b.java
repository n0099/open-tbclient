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
    private NoScrollGridView gfA;
    private d gfB;
    private TextView gfy;
    private ImageView gfz;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.gfy = (TextView) view.findViewById(R.id.topic_title_view);
        this.gfz = (ImageView) view.findViewById(R.id.topic_more);
        this.gfz.setOnClickListener(this);
        this.gfA = (NoScrollGridView) view.findViewById(R.id.topic_gridview);
        this.gfB = new d(tbPageContext.getPageActivity());
        this.gfA.setAdapter((ListAdapter) this.gfB);
        this.gfA.setOnItemClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return R.layout.daily_topic_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(e eVar) {
        if (eVar != null && eVar.gfi != null) {
            this.gfB.setData(eVar.gfi);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            am.setViewTextColor(this.gfy, (int) R.color.cp_cont_b);
            SvgManager.amL().a(this.gfz, R.drawable.icon_pure_list_arrow16_right_tint_n_svg, R.color.cp_cont_d, SvgManager.SvgResourceStateType.NORMAL);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.gfz) {
            if (com.baidu.tbadk.plugins.b.fA(true)) {
                new HotRanklistActivityConfig(getContext()).createNormalConfig("hotforum", "all").start();
            } else {
                String bto = this.gfB.bto();
                if (bto != null) {
                    ba.amO().b(this.mTbPageContext, new String[]{bto});
                }
            }
            TiebaStatic.log(new an("c13177").O("obj_locate", 5));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e.a item = this.gfB.getItem(i);
        if (item != null) {
            if (com.baidu.tbadk.plugins.b.fA(true)) {
                new HotTopicActivityConfig(getContext()).createNormalConfig("", item.ahN(), "1").start();
            } else if (item.akl() != null) {
                ba.amO().b(this.mTbPageContext, new String[]{item.akl()});
            }
        }
        TiebaStatic.log(new an("c13177").O("obj_locate", i + 1));
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
    }
}
