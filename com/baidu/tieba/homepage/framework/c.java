package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class c {
    private a epO;
    private final TbPageContext<BaseFragmentActivity> etg;
    private RecPersonalizePageModel eth;
    private ConcernNetModel eti;
    private RecPersonalizePageModel.a etj = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.epO != null) {
                c.this.epO.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.epO != null) {
                c.this.epO.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b etk = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.epO != null) {
                c.this.epO.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.epO != null) {
                c.this.epO.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a etl = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void hL(boolean z) {
            if (c.this.epO != null) {
                c.this.epO.hN(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes6.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void hN(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.etg = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.eth = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.eth.a(this.etj);
        this.eti = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.eti.a(this.etk);
        this.eti.a(this.etl);
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (this.eth != null) {
            this.eth.c(i, i2, i3, i4, i5);
        }
    }

    public void ph(String str) {
        if (this.eti != null) {
            this.eti.ph(str);
        }
    }

    public void hK(boolean z) {
        if (this.eti != null) {
            this.eti.hK(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aKD() {
        return this.etg;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aKE() {
        return null;
    }

    public void a(a aVar) {
        this.epO = aVar;
    }

    public a aKF() {
        return this.epO;
    }
}
