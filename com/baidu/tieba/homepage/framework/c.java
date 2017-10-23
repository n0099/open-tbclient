package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a cUs;
    private final TbPageContext<BaseFragmentActivity> cXh;
    private RecPersonalizePageModel cXi;
    private ConcernNetModel cXj;
    private RecPersonalizePageModel.a cXk = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.cUs != null) {
                c.this.cUs.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.cUs != null) {
                c.this.cUs.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b cXl = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.cUs != null) {
                c.this.cUs.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.cUs != null) {
                c.this.cUs.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a cXm = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fA(boolean z) {
            if (c.this.cUs != null) {
                c.this.cUs.fB(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void fB(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cXh = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cXi = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cXi.a(this.cXk);
        this.cXj = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.cXj.a(this.cXl);
        this.cXj.a(this.cXm);
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.cXi != null) {
            this.cXi.o(i, i2, i3, i4);
        }
    }

    public void lp(String str) {
        if (this.cXj != null) {
            this.cXj.lp(str);
        }
    }

    public void aoX() {
        if (this.cXj != null) {
            this.cXj.aoX();
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> apb() {
        return this.cXh;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a apc() {
        return null;
    }

    public void a(a aVar) {
        this.cUs = aVar;
    }

    public a apd() {
        return this.cUs;
    }
}
