package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class c {
    private a joA;
    private final TbPageContext<BaseFragmentActivity> jsv;
    private RecPersonalizePageModel jsw;
    private ConcernNetModel jsx;
    private final BdUniqueId uniqueId;
    private RecPersonalizePageModel.a jsy = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.joA != null) {
                c.this.joA.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aA(int i, String str) {
            if (c.this.joA != null) {
                c.this.joA.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b jsz = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.joA != null) {
                c.this.joA.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aA(int i, String str) {
            if (c.this.joA != null) {
                c.this.joA.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a jsA = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void qI(boolean z) {
            if (c.this.joA != null) {
                c.this.joA.qK(z);
            }
        }
    };

    /* loaded from: classes22.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void qK(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.jsv = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.jsw = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.jsw.a(this.jsy);
        this.jsx = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.jsx.a(this.jsz);
        this.jsx.a(this.jsA);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.jsw != null) {
            this.jsw.e(i, i2, i3, i4, i5);
        }
    }

    public void Lr(String str) {
        if (this.jsx != null) {
            this.jsx.Lr(str);
        }
    }

    public void qH(boolean z) {
        if (this.jsx != null) {
            this.jsx.qH(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cGJ() {
        return this.jsv;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cGK() {
        return null;
    }

    public void a(a aVar) {
        this.joA = aVar;
    }

    public a cGL() {
        return this.joA;
    }
}
