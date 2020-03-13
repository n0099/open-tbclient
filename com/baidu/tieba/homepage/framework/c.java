package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class c {
    private a gWu;
    private final TbPageContext<BaseFragmentActivity> gZo;
    private RecPersonalizePageModel gZp;
    private ConcernNetModel gZq;
    private RecPersonalizePageModel.a gZr = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.gWu != null) {
                c.this.gWu.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void ag(int i, String str) {
            if (c.this.gWu != null) {
                c.this.gWu.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b gZs = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.gWu != null) {
                c.this.gWu.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void ag(int i, String str) {
            if (c.this.gWu != null) {
                c.this.gWu.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a gZt = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void mA(boolean z) {
            if (c.this.gWu != null) {
                c.this.gWu.mB(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void mB(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.gZo = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.gZp = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.gZp.a(this.gZr);
        this.gZq = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.gZq.a(this.gZs);
        this.gZq.a(this.gZt);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.gZp != null) {
            this.gZp.e(i, i2, i3, i4, i5);
        }
    }

    public void Cf(String str) {
        if (this.gZq != null) {
            this.gZq.Cf(str);
        }
    }

    public void mz(boolean z) {
        if (this.gZq != null) {
            this.gZq.mz(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bNw() {
        return this.gZo;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a bNx() {
        return null;
    }

    public void a(a aVar) {
        this.gWu = aVar;
    }

    public a bNy() {
        return this.gWu;
    }
}
