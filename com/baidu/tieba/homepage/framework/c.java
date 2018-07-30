package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a dSu;
    private final TbPageContext<BaseFragmentActivity> dVK;
    private RecPersonalizePageModel dVL;
    private ConcernNetModel dVM;
    private RecPersonalizePageModel.a dVN = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dSu != null) {
                c.this.dSu.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void s(int i, String str) {
            if (c.this.dSu != null) {
                c.this.dSu.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b dVO = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dSu != null) {
                c.this.dSu.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void s(int i, String str) {
            if (c.this.dSu != null) {
                c.this.dSu.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a dVP = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gJ(boolean z) {
            if (c.this.dSu != null) {
                c.this.dSu.gL(z);
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

        void gL(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dVK = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.dVL = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.dVL.a(this.dVN);
        this.dVM = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.dVM.a(this.dVO);
        this.dVM.a(this.dVP);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dVL != null) {
            this.dVL.q(i, i2, i3, i4);
        }
    }

    public void nt(String str) {
        if (this.dVM != null) {
            this.dVM.nt(str);
        }
    }

    public void gI(boolean z) {
        if (this.dVM != null) {
            this.dVM.gI(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aDM() {
        return this.dVK;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aDN() {
        return null;
    }

    public void a(a aVar) {
        this.dSu = aVar;
    }

    public a aDO() {
        return this.dSu;
    }
}
