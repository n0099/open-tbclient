package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class c {
    private a eiU;
    private final TbPageContext<BaseFragmentActivity> emk;
    private RecPersonalizePageModel eml;
    private ConcernNetModel emm;
    private RecPersonalizePageModel.a emn = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.eiU != null) {
                c.this.eiU.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.eiU != null) {
                c.this.eiU.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b emo = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.eiU != null) {
                c.this.eiU.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.eiU != null) {
                c.this.eiU.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a emp = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void hJ(boolean z) {
            if (c.this.eiU != null) {
                c.this.eiU.hL(z);
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

        void hL(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.emk = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.eml = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.eml.a(this.emn);
        this.emm = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.emm.a(this.emo);
        this.emm.a(this.emp);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.eml != null) {
            this.eml.r(i, i2, i3, i4);
        }
    }

    public void oF(String str) {
        if (this.emm != null) {
            this.emm.oF(str);
        }
    }

    public void hI(boolean z) {
        if (this.emm != null) {
            this.emm.hI(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aIM() {
        return this.emk;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aIN() {
        return null;
    }

    public void a(a aVar) {
        this.eiU = aVar;
    }

    public a aIO() {
        return this.eiU;
    }
}
