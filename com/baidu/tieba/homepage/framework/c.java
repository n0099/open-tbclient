package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a dZB;
    private final TbPageContext<BaseFragmentActivity> ebS;
    private RecPersonalizePageModel ebT;
    private ConcernNetModel ebU;
    private RecPersonalizePageModel.a ebV = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dZB != null) {
                c.this.dZB.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.dZB != null) {
                c.this.dZB.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ebW = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dZB != null) {
                c.this.dZB.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.dZB != null) {
                c.this.dZB.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ebX = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gv(boolean z) {
            if (c.this.dZB != null) {
                c.this.dZB.gw(z);
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

        void gw(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.ebS = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ebT = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ebT.a(this.ebV);
        this.ebU = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ebU.a(this.ebW);
        this.ebU.a(this.ebX);
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.ebT != null) {
            this.ebT.y(i, i2, i3, i4);
        }
    }

    public void mh(String str) {
        if (this.ebU != null) {
            this.ebU.mh(str);
        }
    }

    public void gu(boolean z) {
        if (this.ebU != null) {
            this.ebU.gu(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aAV() {
        return this.ebS;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aAW() {
        return null;
    }

    public void a(a aVar) {
        this.dZB = aVar;
    }

    public a aAX() {
        return this.dZB;
    }
}
