package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class c {
    private a jIE;
    private final TbPageContext<BaseFragmentActivity> jML;
    private RecPersonalizePageModel jMM;
    private ConcernNetModel jMN;
    private RecPersonalizePageModel.a jMO = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.jIE != null) {
                c.this.jIE.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aC(int i, String str) {
            if (c.this.jIE != null) {
                c.this.jIE.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b jMP = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.jIE != null) {
                c.this.jIE.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aC(int i, String str) {
            if (c.this.jIE != null) {
                c.this.jIE.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a jMQ = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void rv(boolean z) {
            if (c.this.jIE != null) {
                c.this.jIE.rx(z);
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
        this.jML = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.jMM = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.jMM.a(this.jMO);
        this.jMN = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.jMN.a(this.jMP);
        this.jMN.a(this.jMQ);
    }

    public void f(int i, int i2, int i3, int i4, int i5) {
        if (this.jMM != null) {
            this.jMM.f(i, i2, i3, i4, i5);
        }
    }

    public void Mq(String str) {
        if (this.jMN != null) {
            this.jMN.Mq(str);
        }
    }

    public void ru(boolean z) {
        if (this.jMN != null) {
            this.jMN.ru(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cOe() {
        return this.jML;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cOf() {
        return null;
    }

    public void a(a aVar) {
        this.jIE = aVar;
    }

    public a cOg() {
        return this.jIE;
    }
}
