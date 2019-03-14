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
import com.baidu.tieba.d;
import com.baidu.tieba.homepage.daily.b.e;
import com.baidu.tieba.view.NoScrollGridView;
/* loaded from: classes4.dex */
public class b extends com.baidu.tieba.card.a<e> implements AdapterView.OnItemClickListener {
    private TextView fIB;
    private ImageView fIC;
    private NoScrollGridView fID;
    private d fIE;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.fIB = (TextView) view.findViewById(d.g.topic_title_view);
        this.fIC = (ImageView) view.findViewById(d.g.topic_more);
        this.fIC.setOnClickListener(this);
        this.fID = (NoScrollGridView) view.findViewById(d.g.topic_gridview);
        this.fIE = new d(tbPageContext.getPageActivity());
        this.fID.setAdapter((ListAdapter) this.fIE);
        this.fID.setOnItemClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return d.h.daily_topic_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(e eVar) {
        if (eVar != null && eVar.fIl != null) {
            this.fIE.setData(eVar.fIl);
            onChangeSkinType(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.j(this.fIB, d.C0277d.cp_cont_b);
            al.c(this.fIC, d.f.icon_arrow_gray_right_n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.fIC) {
            if (com.baidu.tbadk.plugins.b.fi(true)) {
                new HotRanklistActivityConfig(getContext()).createNormalConfig("hotforum", "all").start();
            } else {
                String blL = this.fIE.blL();
                if (blL != null) {
                    ba.adD().c(this.mTbPageContext, new String[]{blL});
                }
            }
            TiebaStatic.log(new am("c13177").T("obj_locate", 5));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e.a item = this.fIE.getItem(i);
        if (item != null) {
            if (com.baidu.tbadk.plugins.b.fi(true)) {
                new HotTopicActivityConfig(getContext()).createNormalConfig("", item.Ya(), "1").start();
            } else if (item.aaz() != null) {
                ba.adD().c(this.mTbPageContext, new String[]{item.aaz()});
            }
        }
        TiebaStatic.log(new am("c13177").T("obj_locate", i + 1));
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
    }
}
