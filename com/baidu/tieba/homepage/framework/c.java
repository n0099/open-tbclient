package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a dmk;
    private RecPersonalizePageModel doA;
    private ConcernNetModel doB;
    private RecPersonalizePageModel.a doC = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dmk != null) {
                c.this.dmk.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void s(int i, String str) {
            if (c.this.dmk != null) {
                c.this.dmk.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b doD = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dmk != null) {
                c.this.dmk.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void s(int i, String str) {
            if (c.this.dmk != null) {
                c.this.dmk.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a doE = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fV(boolean z) {
            if (c.this.dmk != null) {
                c.this.dmk.fW(z);
            }
        }
    };
    private final TbPageContext<BaseFragmentActivity> doz;
    private final BdUniqueId uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void fW(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.doz = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.doA = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.doA.a(this.doC);
        this.doB = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.doB.a(this.doD);
        this.doB.a(this.doE);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.doA != null) {
            this.doA.q(i, i2, i3, i4);
        }
    }

    public void lY(String str) {
        if (this.doB != null) {
            this.doB.lY(str);
        }
    }

    public void fU(boolean z) {
        if (this.doB != null) {
            this.doB.fU(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> atJ() {
        return this.doz;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a atK() {
        return null;
    }

    public void a(a aVar) {
        this.dmk = aVar;
    }

    public a atL() {
        return this.dmk;
    }
}
