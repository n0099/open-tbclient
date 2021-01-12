package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a jRl;
    private final TbPageContext<BaseFragmentActivity> jVw;
    private RecPersonalizePageModel jVx;
    private ConcernNetModel jVy;
    private final BdUniqueId uniqueId;
    private RecPersonalizePageModel.a jVz = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.jRl != null) {
                c.this.jRl.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aF(int i, String str) {
            if (c.this.jRl != null) {
                c.this.jRl.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b jVA = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.jRl != null) {
                c.this.jRl.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aF(int i, String str) {
            if (c.this.jRl != null) {
                c.this.jRl.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a jVB = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void rO(boolean z) {
            if (c.this.jRl != null) {
                c.this.jRl.rQ(z);
            }
        }
    };

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void rQ(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.jVw = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.jVx = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.jVx.a(this.jVz);
        this.jVy = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.jVy.a(this.jVA);
        this.jVy.a(this.jVB);
    }

    public void f(int i, int i2, int i3, int i4, int i5) {
        if (this.jVx != null) {
            this.jVx.f(i, i2, i3, i4, i5);
        }
    }

    public void Lh(String str) {
        if (this.jVy != null) {
            this.jVy.Lh(str);
        }
    }

    public void rN(boolean z) {
        if (this.jVy != null) {
            this.jVy.rN(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cNu() {
        return this.jVw;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cNv() {
        return null;
    }

    public void a(a aVar) {
        this.jRl = aVar;
    }

    public a cNw() {
        return this.jRl;
    }
}
