package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a jZb;
    private final TbPageContext<BaseFragmentActivity> kdl;
    private RecPersonalizePageModel kdm;
    private ConcernNetModel kdn;
    private RecPersonalizePageModel.a kdo = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.jZb != null) {
                c.this.jZb.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aJ(int i, String str) {
            if (c.this.jZb != null) {
                c.this.jZb.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b kdp = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.jZb != null) {
                c.this.jZb.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aJ(int i, String str) {
            if (c.this.jZb != null) {
                c.this.jZb.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a kdq = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void sa(boolean z) {
            if (c.this.jZb != null) {
                c.this.jZb.sc(z);
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
        this.kdl = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.kdm = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.kdm.a(this.kdo);
        this.kdn = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.kdn.a(this.kdp);
        this.kdn.a(this.kdq);
    }

    public void a(int i, int i2, com.baidu.tbadk.util.c cVar, int i3, int i4) {
        if (this.kdm != null) {
            this.kdm.a(i, i2, cVar, i3, i4);
        }
    }

    public void c(String str, com.baidu.tbadk.util.c cVar) {
        if (this.kdn != null) {
            this.kdn.c(str, cVar);
        }
    }

    public void rZ(boolean z) {
        if (this.kdn != null) {
            this.kdn.rZ(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cPx() {
        return this.kdl;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cPy() {
        return null;
    }

    public void a(a aVar) {
        this.jZb = aVar;
    }

    public a cPz() {
        return this.jZb;
    }
}
