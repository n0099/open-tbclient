package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class c {
    private a gWi;
    private final TbPageContext<BaseFragmentActivity> gZc;
    private RecPersonalizePageModel gZd;
    private ConcernNetModel gZe;
    private RecPersonalizePageModel.a gZf = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.gWi != null) {
                c.this.gWi.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void ag(int i, String str) {
            if (c.this.gWi != null) {
                c.this.gWi.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b gZg = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.gWi != null) {
                c.this.gWi.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void ag(int i, String str) {
            if (c.this.gWi != null) {
                c.this.gWi.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a gZh = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void mA(boolean z) {
            if (c.this.gWi != null) {
                c.this.gWi.mB(z);
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

        void mB(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.gZc = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.gZd = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.gZd.a(this.gZf);
        this.gZe = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.gZe.a(this.gZg);
        this.gZe.a(this.gZh);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.gZd != null) {
            this.gZd.e(i, i2, i3, i4, i5);
        }
    }

    public void Ce(String str) {
        if (this.gZe != null) {
            this.gZe.Ce(str);
        }
    }

    public void mz(boolean z) {
        if (this.gZe != null) {
            this.gZe.mz(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bNv() {
        return this.gZc;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a bNw() {
        return null;
    }

    public void a(a aVar) {
        this.gWi = aVar;
    }

    public a bNx() {
        return this.gWi;
    }
}
