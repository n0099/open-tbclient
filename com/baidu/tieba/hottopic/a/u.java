package com.baidu.tieba.hottopic.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.widget.ListView.x;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tieba.hottopic.controller.HotTopicActivity;
/* loaded from: classes.dex */
public class u extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.hottopic.data.m, a> {
    public final TbPageContext<?> Nw;
    public boolean aXE;
    private HotTopicActivity bJD;
    private com.baidu.tieba.hottopic.view.a bJN;
    private BdUniqueId mTag;

    public BdUniqueId getTag() {
        return this.mTag;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    public u(HotTopicActivity hotTopicActivity, BdUniqueId bdUniqueId) {
        super(hotTopicActivity.getPageContext().getPageActivity(), bdUniqueId);
        this.aXE = true;
        this.mTag = null;
        this.bJD = hotTopicActivity;
        this.Nw = hotTopicActivity.getPageContext();
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: W */
    public a b(ViewGroup viewGroup) {
        this.bJN = new com.baidu.tieba.hottopic.view.a(this.bJD.getPageContext());
        this.bJN.setTag(getTag());
        this.bJN.setFrom("home");
        this.aXE = true;
        return new a(this.bJN);
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.hottopic.data.m mVar, a aVar) {
        if (aVar.bJO == null) {
            return null;
        }
        if (this.aXE) {
            aVar.bJO.a(mVar);
            this.aXE = false;
        }
        d(aVar.ahU, view);
        return aVar.getView();
    }

    private void d(int i, View view) {
        int skinType = TbadkCoreApplication.m411getInst().getSkinType();
        if (this.bJN != null) {
            this.bJN.d(this.Nw, skinType);
        }
        if (this.bJD != null && i != skinType) {
            this.bJD.getLayoutMode().ac(skinType == 1);
            this.bJD.getLayoutMode().x(view);
        }
    }

    /* loaded from: classes.dex */
    public class a extends x.a {
        public int ahU;
        public com.baidu.tieba.hottopic.view.a bJO;

        public a(com.baidu.tieba.hottopic.view.a aVar) {
            super(aVar.getView());
            this.ahU = 3;
            this.bJO = aVar;
        }
    }
}
