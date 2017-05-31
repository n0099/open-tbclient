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
import com.baidu.adp.widget.ListView.z;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public x(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.f.cCL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ab */
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
        if (fVar != null && fVar.cCN != null) {
            cf.Uw().a(new as("c10985").Z("obj_name", fVar.cCN));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.homepage.personalize.data.f fVar) {
        if (fVar != null && fVar.cCM != null && fVar.cCM.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.homepage.personalize.data.g gVar : fVar.cCM) {
                if (gVar != null && gVar.cCO && !StringUtils.isNull(gVar.TB)) {
                    arrayList.add(gVar.TB);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends z.a {
        private int ana;
        private View bmY;
        private TextView bvI;
        private GridView cCb;
        private w cCc;
        private AdapterView.OnItemClickListener cCd;

        public a(View view) {
            super(view);
            this.ana = 3;
            this.cCc = new w();
            this.cCd = new y(this);
            this.bvI = (TextView) view.findViewById(w.h.interest_guide_tip);
            this.bmY = view.findViewById(w.h.interest_guide_close);
            this.cCb = (GridView) view.findViewById(w.h.interest_guide_tags_layout);
            this.cCb.setAdapter((ListAdapter) this.cCc);
            this.cCb.setOnItemClickListener(this.cCd);
            this.bmY.setOnClickListener(new z(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.ana != i) {
                aq.k(getView(), w.e.cp_bg_line_d);
                aq.i(this.bvI, w.e.cp_cont_d);
                aq.j(this.bmY, w.g.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.homepage.personalize.data.f fVar) {
            this.cCc.a(fVar);
        }
    }
}
