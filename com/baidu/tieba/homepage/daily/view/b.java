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
/* loaded from: classes2.dex */
public class b extends com.baidu.tieba.card.a<e> implements AdapterView.OnItemClickListener {
    private TextView ecv;
    private ImageView ecw;
    private NoScrollGridView ecx;
    private d ecy;
    private int mSkinType;

    public b(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        View view = getView();
        this.ecv = (TextView) view.findViewById(e.g.topic_title_view);
        this.ecw = (ImageView) view.findViewById(e.g.topic_more);
        this.ecw.setOnClickListener(this);
        this.ecx = (NoScrollGridView) view.findViewById(e.g.topic_gridview);
        this.ecy = new d(tbPageContext.getPageActivity());
        this.ecx.setAdapter((ListAdapter) this.ecy);
        this.ecx.setOnItemClickListener(this);
    }

    @Override // com.baidu.tieba.card.a
    public int getLayout() {
        return e.h.daily_topic_view;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.a
    public void a(com.baidu.tieba.homepage.daily.b.e eVar) {
        if (eVar != null && eVar.ecg != null) {
            this.ecy.setData(eVar.ecg);
            d(getTbPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    @Override // com.baidu.tieba.card.a
    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            this.mSkinType = i;
            al.h(this.ecv, e.d.cp_cont_b);
            al.c(this.ecw, e.f.icon_arrow_gray_right_n);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view == this.ecw) {
            if (com.baidu.tbadk.plugins.b.co(true)) {
                new HotRanklistActivityConfig(getContext()).createNormalConfig("hotforum", "all").start();
            } else {
                String aFP = this.ecy.aFP();
                if (aFP != null) {
                    ay.AN().c(this.mTbPageContext, new String[]{aFP});
                }
            }
            TiebaStatic.log(new am("c13177").w("obj_locate", 5));
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        e.a item = this.ecy.getItem(i);
        if (item != null) {
            if (com.baidu.tbadk.plugins.b.co(true)) {
                new HotTopicActivityConfig(getContext()).createNormalConfig("", item.vE(), "1").start();
            } else if (item.xM() != null) {
                ay.AN().c(this.mTbPageContext, new String[]{item.xM()});
            }
        }
        TiebaStatic.log(new am("c13177").w("obj_locate", i + 1));
    }

    @Override // com.baidu.tieba.card.a
    public void setTag(BdUniqueId bdUniqueId) {
        super.setTag(bdUniqueId);
    }
}
