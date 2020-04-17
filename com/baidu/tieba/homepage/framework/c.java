package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class c {
    private a hHs;
    private final TbPageContext<BaseFragmentActivity> hKl;
    private RecPersonalizePageModel hKm;
    private ConcernNetModel hKn;
    private RecPersonalizePageModel.a hKo = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.hHs != null) {
                c.this.hHs.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void av(int i, String str) {
            if (c.this.hHs != null) {
                c.this.hHs.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b hKp = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.hHs != null) {
                c.this.hHs.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void av(int i, String str) {
            if (c.this.hHs != null) {
                c.this.hHs.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a hKq = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void nK(boolean z) {
            if (c.this.hHs != null) {
                c.this.hHs.nL(z);
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
        this.hKl = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.hKm = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.hKm.a(this.hKo);
        this.hKn = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.hKn.a(this.hKp);
        this.hKn.a(this.hKq);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.hKm != null) {
            this.hKm.e(i, i2, i3, i4, i5);
        }
    }

    public void DN(String str) {
        if (this.hKn != null) {
            this.hKn.DN(str);
        }
    }

    public void nJ(boolean z) {
        if (this.hKn != null) {
            this.hKn.nJ(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bYl() {
        return this.hKl;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a bYm() {
        return null;
    }

    public void a(a aVar) {
        this.hHs = aVar;
    }

    public a bYn() {
        return this.hHs;
    }
}
