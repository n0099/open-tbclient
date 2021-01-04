package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a jVQ;
    private final TbPageContext<BaseFragmentActivity> kab;
    private RecPersonalizePageModel kac;
    private ConcernNetModel kad;
    private RecPersonalizePageModel.a kae = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.jVQ != null) {
                c.this.jVQ.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aE(int i, String str) {
            if (c.this.jVQ != null) {
                c.this.jVQ.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b kaf = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.jVQ != null) {
                c.this.jVQ.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aE(int i, String str) {
            if (c.this.jVQ != null) {
                c.this.jVQ.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a kag = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void rS(boolean z) {
            if (c.this.jVQ != null) {
                c.this.jVQ.rU(z);
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

        void rU(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.kab = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.kac = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.kac.a(this.kae);
        this.kad = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.kad.a(this.kaf);
        this.kad.a(this.kag);
    }

    public void f(int i, int i2, int i3, int i4, int i5) {
        if (this.kac != null) {
            this.kac.f(i, i2, i3, i4, i5);
        }
    }

    public void Mq(String str) {
        if (this.kad != null) {
            this.kad.Mq(str);
        }
    }

    public void rR(boolean z) {
        if (this.kad != null) {
            this.kad.rR(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cRl() {
        return this.kab;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cRm() {
        return null;
    }

    public void a(a aVar) {
        this.jVQ = aVar;
    }

    public a cRn() {
        return this.jVQ;
    }
}
