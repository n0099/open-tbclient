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
        super(context, com.baidu.tieba.homepage.personalize.data.h.csw);
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
        aVar.onChangeSkinType(TbadkCoreApplication.m9getInst().getSkinType());
        if (hVar != null && hVar.csy != null) {
            bw.Lg().a(new ay("c10985").ab("obj_name", hVar.csy));
        }
        return aVar.getView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void b(com.baidu.tieba.homepage.personalize.data.h hVar) {
        if (hVar != null && hVar.csx != null && hVar.csx.size() != 0) {
            ArrayList arrayList = new ArrayList();
            for (com.baidu.tieba.homepage.personalize.data.i iVar : hVar.csx) {
                if (iVar != null && iVar.csA && !StringUtils.isNull(iVar.csz)) {
                    arrayList.add(iVar.csz);
                }
            }
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_GUIDE_SET_CACHE));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SET_INTEREST_GUIDE, arrayList));
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_RELOAD_HP_PERSONALIZED));
        }
    }

    /* loaded from: classes.dex */
    public class a extends y.a {
        private int aeK;
        private TextView crJ;
        private View crK;
        private GridView crL;
        private u crM;
        private AdapterView.OnItemClickListener crN;

        public a(View view) {
            super(view);
            this.aeK = 3;
            this.crM = new u();
            this.crN = new w(this);
            this.crJ = (TextView) view.findViewById(u.g.interest_guide_tip);
            this.crK = view.findViewById(u.g.interest_guide_close);
            this.crL = (GridView) view.findViewById(u.g.interest_guide_tags_layout);
            this.crL.setAdapter((ListAdapter) this.crM);
            this.crL.setOnItemClickListener(this.crN);
            this.crK.setOnClickListener(new x(this));
        }

        protected void onChangeSkinType(int i) {
            if (this.aeK != i) {
                av.l(getView(), u.d.cp_bg_line_d);
                av.j((View) this.crJ, u.d.cp_cont_d);
                av.k(this.crK, u.f.icon_x_normal);
            }
        }

        protected void c(com.baidu.tieba.homepage.personalize.data.h hVar) {
            this.crM.a(hVar);
        }
    }
}
