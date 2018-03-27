package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a efx;
    private final TbPageContext<BaseFragmentActivity> ehO;
    private RecPersonalizePageModel ehP;
    private ConcernNetModel ehQ;
    private RecPersonalizePageModel.a ehR = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.efx != null) {
                c.this.efx.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.efx != null) {
                c.this.efx.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ehS = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.efx != null) {
                c.this.efx.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.efx != null) {
                c.this.efx.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ehT = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gQ(boolean z) {
            if (c.this.efx != null) {
                c.this.efx.gR(z);
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

        void gR(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.ehO = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ehP = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ehP.a(this.ehR);
        this.ehQ = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ehQ.a(this.ehS);
        this.ehQ.a(this.ehT);
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.ehP != null) {
            this.ehP.y(i, i2, i3, i4);
        }
    }

    public void mD(String str) {
        if (this.ehQ != null) {
            this.ehQ.mD(str);
        }
    }

    public void gP(boolean z) {
        if (this.ehQ != null) {
            this.ehQ.gP(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aCw() {
        return this.ehO;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aCx() {
        return null;
    }

    public void a(a aVar) {
        this.efx = aVar;
    }

    public a aCy() {
        return this.efx;
    }
}
