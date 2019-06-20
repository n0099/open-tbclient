package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {
    private a fWx;
    private final TbPageContext<BaseFragmentActivity> fZT;
    private RecPersonalizePageModel fZU;
    private ConcernNetModel fZV;
    private RecPersonalizePageModel.a fZW = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.fWx != null) {
                c.this.fWx.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void M(int i, String str) {
            if (c.this.fWx != null) {
                c.this.fWx.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b fZX = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.fWx != null) {
                c.this.fWx.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void M(int i, String str) {
            if (c.this.fWx != null) {
                c.this.fWx.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a fZY = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void kY(boolean z) {
            if (c.this.fWx != null) {
                c.this.fWx.la(z);
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

        void la(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.fZT = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.fZU = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.fZU.a(this.fZW);
        this.fZV = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.fZV.a(this.fZX);
        this.fZV.a(this.fZY);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.fZU != null) {
            this.fZU.d(i, i2, i3, i4, i5);
        }
    }

    public void xs(String str) {
        if (this.fZV != null) {
            this.fZV.xs(str);
        }
    }

    public void kX(boolean z) {
        if (this.fZV != null) {
            this.fZV.kX(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> btq() {
        return this.fZT;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a btr() {
        return null;
    }

    public void a(a aVar) {
        this.fWx = aVar;
    }

    public a bts() {
        return this.fWx;
    }
}
