package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a jYN;
    private final TbPageContext<BaseFragmentActivity> kcX;
    private RecPersonalizePageModel kcY;
    private ConcernNetModel kcZ;
    private RecPersonalizePageModel.a kda = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.jYN != null) {
                c.this.jYN.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aJ(int i, String str) {
            if (c.this.jYN != null) {
                c.this.jYN.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b kdb = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.jYN != null) {
                c.this.jYN.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aJ(int i, String str) {
            if (c.this.jYN != null) {
                c.this.jYN.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a kdc = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void sa(boolean z) {
            if (c.this.jYN != null) {
                c.this.jYN.sc(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void sc(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.kcX = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.kcY = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.kcY.a(this.kda);
        this.kcZ = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.kcZ.a(this.kdb);
        this.kcZ.a(this.kdc);
    }

    public void a(int i, int i2, com.baidu.tbadk.util.c cVar, int i3, int i4) {
        if (this.kcY != null) {
            this.kcY.a(i, i2, cVar, i3, i4);
        }
    }

    public void c(String str, com.baidu.tbadk.util.c cVar) {
        if (this.kcZ != null) {
            this.kcZ.c(str, cVar);
        }
    }

    public void rZ(boolean z) {
        if (this.kcZ != null) {
            this.kcZ.rZ(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cPq() {
        return this.kcX;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cPr() {
        return null;
    }

    public void a(a aVar) {
        this.jYN = aVar;
    }

    public a cPs() {
        return this.jYN;
    }
}
