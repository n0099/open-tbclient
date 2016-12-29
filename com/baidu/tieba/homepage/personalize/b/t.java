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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.card.bz;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class t extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.f, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public t(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.f.crS);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: Y */
    public a a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), r.h.interest_guide, null);
        a aVar = new a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.f fVar, a aVar) {
        aVar.c(fVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (fVar != null && fVar.crU != null) {
            bz.OH().a(new at("c10985").ab("obj_name", fVar.crU));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.homepage.personalize.data.f fVar) {
        if (fVar != null && fVar.crT != null && fVar.crT.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.homepage.personalize.data.g gVar : fVar.crT) {
                if (gVar != null && gVar.crV && !StringUtils.isNull(gVar.PR)) {
                    arrayList.add(gVar.PR);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int aib;
        private TextView crg;
        private View crh;
        private GridView cri;
        private s crj;
        private AdapterView.OnItemClickListener crk;

        public a(View view) {
            super(view);
            this.aib = 3;
            this.crj = new s();
            this.crk = new u(this);
            this.crg = (TextView) view.findViewById(r.g.interest_guide_tip);
            this.crh = view.findViewById(r.g.interest_guide_close);
            this.cri = (GridView) view.findViewById(r.g.interest_guide_tags_layout);
            this.cri.setAdapter((ListAdapter) this.crj);
            this.cri.setOnItemClickListener(this.crk);
            this.crh.setOnClickListener(new v(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.aib != i) {
                ar.l(getView(), r.d.cp_bg_line_d);
                ar.j((View) this.crg, r.d.cp_cont_d);
                ar.k(this.crh, r.f.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.homepage.personalize.data.f fVar) {
            this.crj.a(fVar);
        }
    }
}
