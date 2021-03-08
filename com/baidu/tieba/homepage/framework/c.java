package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a kbd;
    private final TbPageContext<BaseFragmentActivity> kfo;
    private RecPersonalizePageModel kfp;
    private ConcernNetModel kfq;
    private RecPersonalizePageModel.a kfr = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.kbd != null) {
                c.this.kbd.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aJ(int i, String str) {
            if (c.this.kbd != null) {
                c.this.kbd.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b kfs = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.kbd != null) {
                c.this.kbd.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aJ(int i, String str) {
            if (c.this.kbd != null) {
                c.this.kbd.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a kft = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void sa(boolean z) {
            if (c.this.kbd != null) {
                c.this.kbd.sc(z);
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
        this.kfo = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.kfp = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.kfp.a(this.kfr);
        this.kfq = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.kfq.a(this.kfs);
        this.kfq.a(this.kft);
    }

    public void a(int i, int i2, com.baidu.tbadk.util.c cVar, int i3, int i4) {
        if (this.kfp != null) {
            this.kfp.a(i, i2, cVar, i3, i4);
        }
    }

    public void c(String str, com.baidu.tbadk.util.c cVar) {
        if (this.kfq != null) {
            this.kfq.c(str, cVar);
        }
    }

    public void rZ(boolean z) {
        if (this.kfq != null) {
            this.kfq.rZ(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cPE() {
        return this.kfo;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cPF() {
        return null;
    }

    public void a(a aVar) {
        this.kbd = aVar;
    }

    public a cPG() {
        return this.kbd;
    }
}
