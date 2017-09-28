package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a cUE;
    private final TbPageContext<BaseFragmentActivity> cXt;
    private RecPersonalizePageModel cXu;
    private ConcernNetModel cXv;
    private RecPersonalizePageModel.a cXw = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.cUE != null) {
                c.this.cUE.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.cUE != null) {
                c.this.cUE.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b cXx = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.cUE != null) {
                c.this.cUE.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.cUE != null) {
                c.this.cUE.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a cXy = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fB(boolean z) {
            if (c.this.cUE != null) {
                c.this.cUE.fC(z);
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

        void fC(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cXt = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cXu = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cXu.a(this.cXw);
        this.cXv = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.cXv.a(this.cXx);
        this.cXv.a(this.cXy);
    }

    public void o(int i, int i2, int i3, int i4) {
        if (this.cXu != null) {
            this.cXu.o(i, i2, i3, i4);
        }
    }

    public void lq(String str) {
        if (this.cXv != null) {
            this.cXv.lq(str);
        }
    }

    public void apc() {
        if (this.cXv != null) {
            this.cXv.apc();
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> apg() {
        return this.cXt;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aph() {
        return null;
    }

    public void a(a aVar) {
        this.cUE = aVar;
    }

    public a api() {
        return this.cUE;
    }
}
