package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes21.dex */
public class c {
    private a iNn;
    private final TbPageContext<BaseFragmentActivity> iRd;
    private RecPersonalizePageModel iRe;
    private ConcernNetModel iRf;
    private RecPersonalizePageModel.a iRg = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.iNn != null) {
                c.this.iNn.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void an(int i, String str) {
            if (c.this.iNn != null) {
                c.this.iNn.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b iRh = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.iNn != null) {
                c.this.iNn.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void an(int i, String str) {
            if (c.this.iNn != null) {
                c.this.iNn.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a iRi = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void pK(boolean z) {
            if (c.this.iNn != null) {
                c.this.iNn.pM(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes21.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void pM(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.iRd = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.iRe = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.iRe.a(this.iRg);
        this.iRf = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.iRf.a(this.iRh);
        this.iRf.a(this.iRi);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.iRe != null) {
            this.iRe.e(i, i2, i3, i4, i5);
        }
    }

    public void Ke(String str) {
        if (this.iRf != null) {
            this.iRf.Ke(str);
        }
    }

    public void pJ(boolean z) {
        if (this.iRf != null) {
            this.iRf.pJ(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> czY() {
        return this.iRd;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a czZ() {
        return null;
    }

    public void a(a aVar) {
        this.iNn = aVar;
    }

    public a cAa() {
        return this.iNn;
    }
}
