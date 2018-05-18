package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a dBh;
    private RecPersonalizePageModel.a dDA = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dBh != null) {
                c.this.dBh.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void q(int i, String str) {
            if (c.this.dBh != null) {
                c.this.dBh.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b dDB = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dBh != null) {
                c.this.dBh.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void q(int i, String str) {
            if (c.this.dBh != null) {
                c.this.dBh.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a dDC = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gr(boolean z) {
            if (c.this.dBh != null) {
                c.this.dBh.gs(z);
            }
        }
    };
    private final TbPageContext<BaseFragmentActivity> dDx;
    private RecPersonalizePageModel dDy;
    private ConcernNetModel dDz;
    private final BdUniqueId uniqueId;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void gs(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dDx = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.dDy = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.dDy.a(this.dDA);
        this.dDz = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.dDz.a(this.dDB);
        this.dDz.a(this.dDC);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.dDy != null) {
            this.dDy.r(i, i2, i3, i4);
        }
    }

    public void mJ(String str) {
        if (this.dDz != null) {
            this.dDz.mJ(str);
        }
    }

    public void gq(boolean z) {
        if (this.dDz != null) {
            this.dDz.gq(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> axr() {
        return this.dDx;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a axs() {
        return null;
    }

    public void a(a aVar) {
        this.dBh = aVar;
    }

    public a axt() {
        return this.dBh;
    }
}
