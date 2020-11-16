package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes21.dex */
public class c {
    private a jve;
    private final TbPageContext<BaseFragmentActivity> jzj;
    private RecPersonalizePageModel jzk;
    private ConcernNetModel jzl;
    private RecPersonalizePageModel.a jzm = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.jve != null) {
                c.this.jve.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void aC(int i, String str) {
            if (c.this.jve != null) {
                c.this.jve.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b jzn = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.jve != null) {
                c.this.jve.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void aC(int i, String str) {
            if (c.this.jve != null) {
                c.this.jve.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a jzo = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void qU(boolean z) {
            if (c.this.jve != null) {
                c.this.jve.qW(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes21.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void qW(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.jzj = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.jzk = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.jzk.a(this.jzm);
        this.jzl = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.jzl.a(this.jzn);
        this.jzl.a(this.jzo);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.jzk != null) {
            this.jzk.e(i, i2, i3, i4, i5);
        }
    }

    public void Lj(String str) {
        if (this.jzl != null) {
            this.jzl.Lj(str);
        }
    }

    public void qT(boolean z) {
        if (this.jzl != null) {
            this.jzl.qT(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cIP() {
        return this.jzj;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cIQ() {
        return null;
    }

    public void a(a aVar) {
        this.jve = aVar;
    }

    public a cIR() {
        return this.jve;
    }
}
