package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a efh;
    private ConcernNetModel ehA;
    private RecPersonalizePageModel.a ehB = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.efh != null) {
                c.this.efh.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.efh != null) {
                c.this.efh.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ehC = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.efh != null) {
                c.this.efh.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.efh != null) {
                c.this.efh.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ehD = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gL(boolean z) {
            if (c.this.efh != null) {
                c.this.efh.gM(z);
            }
        }
    };
    private final TbPageContext<BaseFragmentActivity> ehy;
    private RecPersonalizePageModel ehz;
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
        this.ehy = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ehz = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ehz.a(this.ehB);
        this.ehA = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ehA.a(this.ehC);
        this.ehA.a(this.ehD);
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.ehz != null) {
            this.ehz.y(i, i2, i3, i4);
        }
    }

    public void mD(String str) {
        if (this.ehA != null) {
            this.ehA.mD(str);
        }
    }

    public void gK(boolean z) {
        if (this.ehA != null) {
            this.ehA.gK(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aCv() {
        return this.ehy;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aCw() {
        return null;
    }

    public void a(a aVar) {
        this.efh = aVar;
    }

    public a aCx() {
        return this.efh;
    }
}
