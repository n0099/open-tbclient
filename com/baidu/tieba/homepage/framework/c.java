package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {
    private a gbu;
    private final TbPageContext<BaseFragmentActivity> geR;
    private RecPersonalizePageModel geS;
    private ConcernNetModel geT;
    private RecPersonalizePageModel.a geU = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.gbu != null) {
                c.this.gbu.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void M(int i, String str) {
            if (c.this.gbu != null) {
                c.this.gbu.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b geV = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.gbu != null) {
                c.this.gbu.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void M(int i, String str) {
            if (c.this.gbu != null) {
                c.this.gbu.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a geW = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void li(boolean z) {
            if (c.this.gbu != null) {
                c.this.gbu.lk(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void lk(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.geR = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.geS = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.geS.a(this.geU);
        this.geT = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.geT.a(this.geV);
        this.geT.a(this.geW);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.geS != null) {
            this.geS.d(i, i2, i3, i4, i5);
        }
    }

    public void xX(String str) {
        if (this.geT != null) {
            this.geT.xX(str);
        }
    }

    public void lh(boolean z) {
        if (this.geT != null) {
            this.geT.lh(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bvs() {
        return this.geR;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a bvt() {
        return null;
    }

    public void a(a aVar) {
        this.gbu = aVar;
    }

    public a bvu() {
        return this.gbu;
    }
}
