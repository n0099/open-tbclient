package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class c {
    private a jIG;
    private final TbPageContext<BaseFragmentActivity> jMN;
    private RecPersonalizePageModel jMO;
    private ConcernNetModel jMP;
    private RecPersonalizePageModel.a jMQ = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.jIG != null) {
                c.this.jIG.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aC(int i, String str) {
            if (c.this.jIG != null) {
                c.this.jIG.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b jMR = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.jIG != null) {
                c.this.jIG.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aC(int i, String str) {
            if (c.this.jIG != null) {
                c.this.jIG.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a jMS = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void rv(boolean z) {
            if (c.this.jIG != null) {
                c.this.jIG.rx(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes22.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void rx(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.jMN = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.jMO = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.jMO.a(this.jMQ);
        this.jMP = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.jMP.a(this.jMR);
        this.jMP.a(this.jMS);
    }

    public void f(int i, int i2, int i3, int i4, int i5) {
        if (this.jMO != null) {
            this.jMO.f(i, i2, i3, i4, i5);
        }
    }

    public void Mq(String str) {
        if (this.jMP != null) {
            this.jMP.Mq(str);
        }
    }

    public void ru(boolean z) {
        if (this.jMP != null) {
            this.jMP.ru(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cOf() {
        return this.jMN;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cOg() {
        return null;
    }

    public void a(a aVar) {
        this.jIG = aVar;
    }

    public a cOh() {
        return this.jIG;
    }
}
