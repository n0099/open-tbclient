package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes7.dex */
public class c {
    private a gUf;
    private final TbPageContext<BaseFragmentActivity> gWZ;
    private RecPersonalizePageModel gXa;
    private ConcernNetModel gXb;
    private RecPersonalizePageModel.a gXc = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.gUf != null) {
                c.this.gUf.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void af(int i, String str) {
            if (c.this.gUf != null) {
                c.this.gUf.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b gXd = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.gUf != null) {
                c.this.gUf.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void af(int i, String str) {
            if (c.this.gUf != null) {
                c.this.gUf.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a gXe = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void my(boolean z) {
            if (c.this.gUf != null) {
                c.this.gUf.mz(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes7.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void mz(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.gWZ = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.gXa = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.gXa.a(this.gXc);
        this.gXb = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.gXb.a(this.gXd);
        this.gXb.a(this.gXe);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.gXa != null) {
            this.gXa.e(i, i2, i3, i4, i5);
        }
    }

    public void BO(String str) {
        if (this.gXb != null) {
            this.gXb.BO(str);
        }
    }

    public void mx(boolean z) {
        if (this.gXb != null) {
            this.gXb.mx(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bLQ() {
        return this.gWZ;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a bLR() {
        return null;
    }

    public void a(a aVar) {
        this.gUf = aVar;
    }

    public a bLS() {
        return this.gUf;
    }
}
