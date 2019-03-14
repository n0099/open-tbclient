package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {
    private a fFJ;
    private final TbPageContext<BaseFragmentActivity> fJh;
    private RecPersonalizePageModel fJi;
    private ConcernNetModel fJj;
    private RecPersonalizePageModel.a fJk = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.fFJ != null) {
                c.this.fFJ.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void J(int i, String str) {
            if (c.this.fFJ != null) {
                c.this.fFJ.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b fJl = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void a(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.fFJ != null) {
                c.this.fFJ.b(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void J(int i, String str) {
            if (c.this.fFJ != null) {
                c.this.fFJ.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a fJm = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void ki(boolean z) {
            if (c.this.fFJ != null) {
                c.this.fFJ.kk(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(tbclient.Userlike.DataRes dataRes, boolean z);

        void kk(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.fJh = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.fJi = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.fJi.a(this.fJk);
        this.fJj = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.fJj.a(this.fJl);
        this.fJj.a(this.fJm);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.fJi != null) {
            this.fJi.d(i, i2, i3, i4, i5);
        }
    }

    public void wc(String str) {
        if (this.fJj != null) {
            this.fJj.wc(str);
        }
    }

    public void kh(boolean z) {
        if (this.fJj != null) {
            this.fJj.kh(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> blT() {
        return this.fJh;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a blU() {
        return null;
    }

    public void a(a aVar) {
        this.fFJ = aVar;
    }

    public a blV() {
        return this.fFJ;
    }
}
