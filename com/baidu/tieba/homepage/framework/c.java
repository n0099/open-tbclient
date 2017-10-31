package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a ddk;
    private RecPersonalizePageModel dfA;
    private ConcernNetModel dfB;
    private RecPersonalizePageModel.a dfC = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.ddk != null) {
                c.this.ddk.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.ddk != null) {
                c.this.ddk.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b dfD = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.ddk != null) {
                c.this.ddk.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.ddk != null) {
                c.this.ddk.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a dfE = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fx(boolean z) {
            if (c.this.ddk != null) {
                c.this.ddk.fy(z);
            }
        }
    };
    private final TbPageContext<BaseFragmentActivity> dfz;
    private final BdUniqueId uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void fy(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dfz = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.dfA = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.dfA.a(this.dfC);
        this.dfB = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.dfB.a(this.dfD);
        this.dfB.a(this.dfE);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dfA != null) {
            this.dfA.q(i, i2, i3, i4);
        }
    }

    public void lN(String str) {
        if (this.dfB != null) {
            this.dfB.lN(str);
        }
    }

    public void arw() {
        if (this.dfB != null) {
            this.dfB.arw();
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> arA() {
        return this.dfz;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a arB() {
        return null;
    }

    public void a(a aVar) {
        this.ddk = aVar;
    }

    public a arC() {
        return this.ddk;
    }
}
