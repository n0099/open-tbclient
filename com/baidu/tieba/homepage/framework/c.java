package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a ebh;
    private ConcernNetModel edA;
    private RecPersonalizePageModel.a edB = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.ebh != null) {
                c.this.ebh.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.ebh != null) {
                c.this.ebh.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b edC = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.ebh != null) {
                c.this.ebh.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.ebh != null) {
                c.this.ebh.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a edD = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gB(boolean z) {
            if (c.this.ebh != null) {
                c.this.ebh.gC(z);
            }
        }
    };
    private final TbPageContext<BaseFragmentActivity> edy;
    private RecPersonalizePageModel edz;
    private final BdUniqueId uniqueId;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void gC(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.edy = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.edz = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.edz.a(this.edB);
        this.edA = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.edA.a(this.edC);
        this.edA.a(this.edD);
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.edz != null) {
            this.edz.y(i, i2, i3, i4);
        }
    }

    public void mu(String str) {
        if (this.edA != null) {
            this.edA.mu(str);
        }
    }

    public void gA(boolean z) {
        if (this.edA != null) {
            this.edA.gA(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aBc() {
        return this.edy;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aBd() {
        return null;
    }

    public void a(a aVar) {
        this.ebh = aVar;
    }

    public a aBe() {
        return this.ebh;
    }
}
