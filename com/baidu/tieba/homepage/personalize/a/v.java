package com.baidu.tieba.homepage.personalize.a;

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
import com.baidu.tbadk.core.util.av;
import com.baidu.tbadk.core.util.ay;
import com.baidu.tieba.card.bw;
import com.baidu.tieba.u;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class v extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public v(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.cvg);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: as */
    public a a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), u.h.interest_guide, null);
        a aVar = new a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, a aVar) {
        aVar.c(hVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m10getInst().getSkinType());
        if (hVar != null && hVar.cvi != null) {
            bw.Lf().b(new ay("c10985").ab("obj_name", hVar.cvi));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.homepage.personalize.data.h hVar) {
        if (hVar != null && hVar.cvh != null && hVar.cvh.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.homepage.personalize.data.i iVar : hVar.cvh) {
                if (iVar != null && iVar.cvk && !StringUtils.isNull(iVar.cvj)) {
                    arrayList.add(iVar.cvj);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int afy;
        private TextView cut;
        private View cuu;
        private GridView cuv;
        private u cuw;
        private AdapterView.OnItemClickListener cux;

        public a(View view) {
            super(view);
            this.afy = 3;
            this.cuw = new u();
            this.cux = new w(this);
            this.cut = (TextView) view.findViewById(u.g.interest_guide_tip);
            this.cuu = view.findViewById(u.g.interest_guide_close);
            this.cuv = (GridView) view.findViewById(u.g.interest_guide_tags_layout);
            this.cuv.setAdapter((ListAdapter) this.cuw);
            this.cuv.setOnItemClickListener(this.cux);
            this.cuu.setOnClickListener(new x(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.afy != i) {
                av.l(getView(), u.d.cp_bg_line_d);
                av.j((View) this.cut, u.d.cp_cont_d);
                av.k(this.cuu, u.f.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.homepage.personalize.data.h hVar) {
            this.cuw.a(hVar);
        }
    }
}
