package com.baidu.tieba.homepage.personalize.b;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.j;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tieba.card.u;
import com.baidu.tieba.d;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public l(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.f.cTp);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ao */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), d.j.interest_guide, null);
        a aVar = new a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: a */
    public View onFillViewHolder(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.f fVar, a aVar) {
        aVar.c(fVar);
        aVar.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        if (fVar != null && fVar.cTr != null) {
            u.Ww().a(new aj("c10985").aa("obj_name", fVar.cTr));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.homepage.personalize.data.f fVar) {
        if (fVar != null && fVar.cTq != null && fVar.cTq.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.homepage.personalize.data.g gVar : fVar.cTq) {
                if (gVar != null && gVar.isSelect && !StringUtils.isNull(gVar.TL)) {
                    arrayList.add(gVar.TL);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends j.a {
        private int aoR;
        private View buX;
        private TextView cOY;
        private GridView cSF;
        private k cSG;
        private AdapterView.OnItemClickListener cSH;

        public a(View view) {
            super(view);
            this.aoR = 3;
            this.cSG = new k();
            this.cSH = new AdapterView.OnItemClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.l.a.1
                @Override // android.widget.AdapterView.OnItemClickListener
                public void onItemClick(AdapterView<?> adapterView, View view2, int i, long j) {
                    if (!com.baidu.adp.lib.util.i.hh()) {
                        com.baidu.adp.lib.util.k.showToast(l.this.mContext, d.l.neterror);
                        return;
                    }
                    com.baidu.tieba.homepage.personalize.data.g item = a.this.cSG.getItem(i);
                    item.isSelect = !item.isSelect;
                    a.this.cSG.notifyDataSetChanged();
                    l.this.b(a.this.cSG.aow());
                    TiebaStatic.log(new aj("c10986").aa("obj_name", item.TL));
                }
            };
            this.cOY = (TextView) view.findViewById(d.h.interest_guide_tip);
            this.buX = view.findViewById(d.h.interest_guide_close);
            this.cSF = (GridView) view.findViewById(d.h.interest_guide_tags_layout);
            this.cSF.setAdapter((ListAdapter) this.cSG);
            this.cSF.setOnItemClickListener(this.cSH);
            this.buX.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.b.l.a.2
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    TiebaStatic.log("c10983");
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_CLOSE_INTEREST_GUIDE));
                }
            });
        }

        protected void onChangeSkinType(int i) {
            if (this.aoR != i) {
                ai.k(getView(), d.e.cp_bg_line_d);
                ai.i(this.cOY, d.e.cp_cont_d);
                ai.j(this.buX, d.g.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.homepage.personalize.data.f fVar) {
            this.cSG.a(fVar);
        }
    }
}
