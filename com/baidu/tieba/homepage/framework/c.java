package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a dAa;
    private final TbPageContext<BaseFragmentActivity> dCr;
    private RecPersonalizePageModel dCs;
    private ConcernNetModel dCt;
    private RecPersonalizePageModel.a dCu = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dAa != null) {
                c.this.dAa.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void q(int i, String str) {
            if (c.this.dAa != null) {
                c.this.dAa.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b dCv = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dAa != null) {
                c.this.dAa.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void q(int i, String str) {
            if (c.this.dAa != null) {
                c.this.dAa.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a dCw = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gq(boolean z) {
            if (c.this.dAa != null) {
                c.this.dAa.gr(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void gr(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dCr = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.dCs = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.dCs.a(this.dCu);
        this.dCt = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.dCt.a(this.dCv);
        this.dCt.a(this.dCw);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.dCs != null) {
            this.dCs.r(i, i2, i3, i4);
        }
    }

    public void mG(String str) {
        if (this.dCt != null) {
            this.dCt.mG(str);
        }
    }

    public void gp(boolean z) {
        if (this.dCt != null) {
            this.dCt.gp(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> axt() {
        return this.dCr;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a axu() {
        return null;
    }

    public void a(a aVar) {
        this.dAa = aVar;
    }

    public a axv() {
        return this.dAa;
    }
}
