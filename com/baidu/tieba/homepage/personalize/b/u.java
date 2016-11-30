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
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.av;
import com.baidu.tieba.card.bx;
import com.baidu.tieba.r;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public u(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.cMN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: at */
    public a a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), r.h.interest_guide, null);
        a aVar = new a(inflate);
        inflate.setLayoutParams(new AbsListView.LayoutParams(-1, -1));
        return aVar;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.homepage.personalize.data.h hVar, a aVar) {
        aVar.c(hVar);
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (hVar != null && hVar.cMP != null) {
            bx.Pl().a(new av("c10985").ab("obj_name", hVar.cMP));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.homepage.personalize.data.h hVar) {
        if (hVar != null && hVar.cMO != null && hVar.cMO.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.homepage.personalize.data.i iVar : hVar.cMO) {
                if (iVar != null && iVar.cMQ && !StringUtils.isNull(iVar.PW)) {
                    arrayList.add(iVar.PW);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int aiA;
        private TextView cLW;
        private View cLX;
        private GridView cLY;
        private t cLZ;
        private AdapterView.OnItemClickListener cMa;

        public a(View view) {
            super(view);
            this.aiA = 3;
            this.cLZ = new t();
            this.cMa = new v(this);
            this.cLW = (TextView) view.findViewById(r.g.interest_guide_tip);
            this.cLX = view.findViewById(r.g.interest_guide_close);
            this.cLY = (GridView) view.findViewById(r.g.interest_guide_tags_layout);
            this.cLY.setAdapter((ListAdapter) this.cLZ);
            this.cLY.setOnItemClickListener(this.cMa);
            this.cLX.setOnClickListener(new w(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.aiA != i) {
                at.l(getView(), r.d.cp_bg_line_d);
                at.j((View) this.cLW, r.d.cp_cont_d);
                at.k(this.cLX, r.f.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.homepage.personalize.data.h hVar) {
            this.cLZ.a(hVar);
        }
    }
}
