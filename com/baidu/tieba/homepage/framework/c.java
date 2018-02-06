package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a eft;
    private final TbPageContext<BaseFragmentActivity> ehK;
    private RecPersonalizePageModel ehL;
    private ConcernNetModel ehM;
    private RecPersonalizePageModel.a ehN = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.eft != null) {
                c.this.eft.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.eft != null) {
                c.this.eft.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ehO = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.eft != null) {
                c.this.eft.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.eft != null) {
                c.this.eft.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ehP = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gL(boolean z) {
            if (c.this.eft != null) {
                c.this.eft.gM(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void gM(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.ehK = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ehL = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ehL.a(this.ehN);
        this.ehM = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ehM.a(this.ehO);
        this.ehM.a(this.ehP);
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.ehL != null) {
            this.ehL.y(i, i2, i3, i4);
        }
    }

    public void mD(String str) {
        if (this.ehM != null) {
            this.ehM.mD(str);
        }
    }

    public void gK(boolean z) {
        if (this.ehM != null) {
            this.ehM.gK(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aCw() {
        return this.ehK;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aCx() {
        return null;
    }

    public void a(a aVar) {
        this.eft = aVar;
    }

    public a aCy() {
        return this.eft;
    }
}
