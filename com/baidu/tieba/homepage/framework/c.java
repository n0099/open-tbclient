package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a dnp;
    private final TbPageContext<BaseFragmentActivity> dpE;
    private RecPersonalizePageModel dpF;
    private ConcernNetModel dpG;
    private RecPersonalizePageModel.a dpH = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dnp != null) {
                c.this.dnp.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void s(int i, String str) {
            if (c.this.dnp != null) {
                c.this.dnp.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b dpI = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dnp != null) {
                c.this.dnp.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void s(int i, String str) {
            if (c.this.dnp != null) {
                c.this.dnp.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a dpJ = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fW(boolean z) {
            if (c.this.dnp != null) {
                c.this.dnp.fX(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void fX(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dpE = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.dpF = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.dpF.a(this.dpH);
        this.dpG = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.dpG.a(this.dpI);
        this.dpG.a(this.dpJ);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dpF != null) {
            this.dpF.q(i, i2, i3, i4);
        }
    }

    public void lY(String str) {
        if (this.dpG != null) {
            this.dpG.lY(str);
        }
    }

    public void fV(boolean z) {
        if (this.dpG != null) {
            this.dpG.fV(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> atR() {
        return this.dpE;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a atS() {
        return null;
    }

    public void a(a aVar) {
        this.dnp = aVar;
    }

    public a atT() {
        return this.dnp;
    }
}
