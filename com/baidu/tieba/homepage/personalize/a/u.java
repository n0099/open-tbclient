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
import com.baidu.tieba.card.cd;
import com.baidu.tieba.t;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.homepage.personalize.data.h, a> {
    /* JADX INFO: Access modifiers changed from: protected */
    public u(Context context) {
        super(context, com.baidu.tieba.homepage.personalize.data.h.cGL);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ak */
    public a a(ViewGroup viewGroup) {
        View inflate = View.inflate(viewGroup.getContext(), t.h.interest_guide, null);
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
        if (hVar != null && hVar.cGN != null) {
            cd.NI().b(new ay("c10985").ab("obj_name", hVar.cGN));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.homepage.personalize.data.h hVar) {
        if (hVar != null && hVar.cGM != null && hVar.cGM.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.homepage.personalize.data.i iVar : hVar.cGM) {
                if (iVar != null && iVar.cGO && !StringUtils.isNull(iVar.PE)) {
                    arrayList.add(iVar.PE);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int ait;
        private TextView cFX;
        private View cFY;
        private GridView cFZ;
        private t cGa;
        private AdapterView.OnItemClickListener cGb;

        public a(View view) {
            super(view);
            this.ait = 3;
            this.cGa = new t();
            this.cGb = new v(this);
            this.cFX = (TextView) view.findViewById(t.g.interest_guide_tip);
            this.cFY = view.findViewById(t.g.interest_guide_close);
            this.cFZ = (GridView) view.findViewById(t.g.interest_guide_tags_layout);
            this.cFZ.setAdapter((ListAdapter) this.cGa);
            this.cFZ.setOnItemClickListener(this.cGb);
            this.cFY.setOnClickListener(new w(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.ait != i) {
                av.l(getView(), t.d.cp_bg_line_d);
                av.j((View) this.cFX, t.d.cp_cont_d);
                av.k(this.cFY, t.f.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.homepage.personalize.data.h hVar) {
            this.cGa.a(hVar);
        }
    }
}
