package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {
    private a fWv;
    private final TbPageContext<BaseFragmentActivity> fZR;
    private RecPersonalizePageModel fZS;
    private ConcernNetModel fZT;
    private RecPersonalizePageModel.a fZU = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.fWv != null) {
                c.this.fWv.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void M(int i, String str) {
            if (c.this.fWv != null) {
                c.this.fWv.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b fZV = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.fWv != null) {
                c.this.fWv.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void M(int i, String str) {
            if (c.this.fWv != null) {
                c.this.fWv.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a fZW = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void kX(boolean z) {
            if (c.this.fWv != null) {
                c.this.fWv.kZ(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void kZ(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.fZR = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.fZS = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.fZS.a(this.fZU);
        this.fZT = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.fZT.a(this.fZV);
        this.fZT.a(this.fZW);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.fZS != null) {
            this.fZS.d(i, i2, i3, i4, i5);
        }
    }

    public void xq(String str) {
        if (this.fZT != null) {
            this.fZT.xq(str);
        }
    }

    public void kW(boolean z) {
        if (this.fZT != null) {
            this.fZT.kW(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> btp() {
        return this.fZR;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a btq() {
        return null;
    }

    public void a(a aVar) {
        this.fWv = aVar;
    }

    public a btr() {
        return this.fWv;
    }
}
