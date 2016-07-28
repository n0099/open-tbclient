package com.baidu.tieba.homepage.personalize.a;

import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.widget.ListView.y;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
/* loaded from: classes.dex */
public class a extends com.baidu.adp.widget.ListView.a<com.baidu.tieba.card.a.d, C0061a> {
    private TbPageContext<?> EA;
    private boolean aav;
    private int mSkinType;

    /* JADX INFO: Access modifiers changed from: protected */
    public a(TbPageContext<?> tbPageContext) {
        super(tbPageContext.getPageActivity(), com.baidu.tieba.card.a.d.aVW);
        this.mSkinType = 3;
        this.aav = false;
        this.EA = tbPageContext;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    /* renamed from: ai */
    public C0061a a(ViewGroup viewGroup) {
        try {
            return new C0061a(new com.baidu.tieba.card.e(this.EA));
        } catch (VerifyError e) {
            BdLog.e(e.toString());
            return new C0061a(new View(this.EA.getPageActivity()));
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.widget.ListView.a
    public View a(int i, View view, ViewGroup viewGroup, com.baidu.tieba.card.a.d dVar, C0061a c0061a) {
        if (c0061a != null && c0061a.ctO == null) {
            return c0061a.getView();
        }
        this.mSkinType = TbadkCoreApplication.m10getInst().getSkinType();
        this.EA.getLayoutMode().af(this.mSkinType == 1);
        this.EA.getLayoutMode().w(view);
        c0061a.ctO.d(this.EA, TbadkCoreApplication.m10getInst().getSkinType());
        c0061a.ctO.setFromCDN(this.aav);
        c0061a.ctO.a(dVar);
        return c0061a.getView();
    }

    public void setFromCDN(boolean z) {
        this.aav = z;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* renamed from: com.baidu.tieba.homepage.personalize.a.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public class C0061a extends y.a {
        public com.baidu.tieba.card.e ctO;

        public C0061a(com.baidu.tieba.card.e eVar) {
            super(eVar.getView());
            this.ctO = eVar;
        }

        public C0061a(View view) {
            super(view);
        }
    }
}
