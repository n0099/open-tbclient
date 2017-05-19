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
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.ca;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public v(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.f.cws);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: aa */
    public a onCreateViewHolder(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), w.j.interest_guide, null);
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
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (fVar != null && fVar.cwu != null) {
            ca.To().a(new as("c10985").aa("obj_name", fVar.cwu));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.homepage.personalize.data.f fVar) {
        if (fVar != null && fVar.cwt != null && fVar.cwt.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.homepage.personalize.data.g gVar : fVar.cwt) {
                if (gVar != null && gVar.cwv && !StringUtils.isNull(gVar.TP)) {
                    arrayList.add(gVar.TP);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int ane;
        private View blR;
        private TextView cvH;
        private GridView cvI;
        private u cvJ;
        private AdapterView.OnItemClickListener cvK;

        public a(View view) {
            super(view);
            this.ane = 3;
            this.cvJ = new u();
            this.cvK = new w(this);
            this.cvH = (TextView) view.findViewById(w.h.interest_guide_tip);
            this.blR = view.findViewById(w.h.interest_guide_close);
            this.cvI = (GridView) view.findViewById(w.h.interest_guide_tags_layout);
            this.cvI.setAdapter((ListAdapter) this.cvJ);
            this.cvI.setOnItemClickListener(this.cvK);
            this.blR.setOnClickListener(new x(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.ane != i) {
                aq.k(getView(), w.e.cp_bg_line_d);
                aq.i(this.cvH, w.e.cp_cont_d);
                aq.j(this.blR, w.g.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.homepage.personalize.data.f fVar) {
            this.cvJ.a(fVar);
        }
    }
}
