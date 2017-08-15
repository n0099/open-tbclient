package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a cRb;
    private final TbPageContext<BaseFragmentActivity> cTv;
    private RecPersonalizePageModel cTw;
    private ConcernNetModel cTx;
    private final BdUniqueId uniqueId;
    private RecPersonalizePageModel.a cTy = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.cRb != null) {
                c.this.cRb.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void s(int i, String str) {
            if (c.this.cRb != null) {
                c.this.cRb.a("", str, i, false, com.baidu.tieba.homepage.framework.indicator.a.cTR);
            }
        }
    };
    private ConcernNetModel.b cTz = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.cRb != null) {
                c.this.cRb.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void s(int i, String str) {
            if (c.this.cRb != null) {
                c.this.cRb.a("", str, i, false, com.baidu.tieba.homepage.framework.indicator.a.cTQ);
            }
        }
    };
    private ConcernNetModel.a cTA = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fG(boolean z) {
            if (c.this.cRb != null) {
                c.this.cRb.fH(z);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void fH(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cTv = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cTw = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cTw.a(this.cTy);
        this.cTx = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.cTx.a(this.cTz);
        this.cTx.a(this.cTA);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.cTw != null) {
            this.cTw.d(i, i2, i3, i4, i5);
        }
    }

    public void lq(String str) {
        if (this.cTx != null) {
            this.cTx.lq(str);
        }
    }

    public void aoJ() {
        if (this.cTx != null) {
            this.cTx.aoJ();
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aoN() {
        return this.cTv;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aoO() {
        return null;
    }

    public void a(a aVar) {
        this.cRb = aVar;
    }

    public a aoP() {
        return this.cRb;
    }
}
