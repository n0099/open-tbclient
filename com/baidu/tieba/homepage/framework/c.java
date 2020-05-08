package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class c {
    private a hHy;
    private final TbPageContext<BaseFragmentActivity> hKr;
    private RecPersonalizePageModel hKs;
    private ConcernNetModel hKt;
    private RecPersonalizePageModel.a hKu = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.hHy != null) {
                c.this.hHy.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void av(int i, String str) {
            if (c.this.hHy != null) {
                c.this.hHy.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b hKv = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.hHy != null) {
                c.this.hHy.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void av(int i, String str) {
            if (c.this.hHy != null) {
                c.this.hHy.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a hKw = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void nK(boolean z) {
            if (c.this.hHy != null) {
                c.this.hHy.nL(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void nL(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.hKr = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.hKs = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.hKs.a(this.hKu);
        this.hKt = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.hKt.a(this.hKv);
        this.hKt.a(this.hKw);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.hKs != null) {
            this.hKs.e(i, i2, i3, i4, i5);
        }
    }

    public void DQ(String str) {
        if (this.hKt != null) {
            this.hKt.DQ(str);
        }
    }

    public void nJ(boolean z) {
        if (this.hKt != null) {
            this.hKt.nJ(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bYj() {
        return this.hKr;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a bYk() {
        return null;
    }

    public void a(a aVar) {
        this.hHy = aVar;
    }

    public a bYl() {
        return this.hHy;
    }
}
