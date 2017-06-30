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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tieba.card.cf;
import com.baidu.tieba.w;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class x extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public x(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.f.cKJ);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ad */
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
        if (fVar != null && fVar.cKL != null) {
            cf.VN().a(new au("c10985").Z("obj_name", fVar.cKL));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.homepage.personalize.data.f fVar) {
        if (fVar != null && fVar.cKK != null && fVar.cKK.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.homepage.personalize.data.g gVar : fVar.cKK) {
                if (gVar != null && gVar.isSelect && !StringUtils.isNull(gVar.Tw)) {
                    arrayList.add(gVar.Tw);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends z.a {
        private int aoa;
        private View bqP;
        private TextView cJY;
        private GridView cJZ;
        private w cKa;
        private AdapterView.OnItemClickListener cKb;

        public a(View view) {
            super(view);
            this.aoa = 3;
            this.cKa = new w();
            this.cKb = new y(this);
            this.cJY = (TextView) view.findViewById(w.h.interest_guide_tip);
            this.bqP = view.findViewById(w.h.interest_guide_close);
            this.cJZ = (GridView) view.findViewById(w.h.interest_guide_tags_layout);
            this.cJZ.setAdapter((ListAdapter) this.cKa);
            this.cJZ.setOnItemClickListener(this.cKb);
            this.bqP.setOnClickListener(new z(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.aoa != i) {
                as.k(getView(), w.e.cp_bg_line_d);
                as.i(this.cJY, w.e.cp_cont_d);
                as.j(this.bqP, w.g.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.homepage.personalize.data.f fVar) {
            this.cKa.a(fVar);
        }
    }
}
