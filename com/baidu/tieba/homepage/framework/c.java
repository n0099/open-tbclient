package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class c {
    private a ehz;
    private final TbPageContext<BaseFragmentActivity> ekQ;
    private RecPersonalizePageModel ekR;
    private ConcernNetModel ekS;
    private RecPersonalizePageModel.a ekT = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.ehz != null) {
                c.this.ehz.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void s(int i, String str) {
            if (c.this.ehz != null) {
                c.this.ehz.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ekU = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.ehz != null) {
                c.this.ehz.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void s(int i, String str) {
            if (c.this.ehz != null) {
                c.this.ehz.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ekV = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void hz(boolean z) {
            if (c.this.ehz != null) {
                c.this.ehz.hB(z);
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

        void hB(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.ekQ = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ekR = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ekR.a(this.ekT);
        this.ekS = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ekS.a(this.ekU);
        this.ekS.a(this.ekV);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.ekR != null) {
            this.ekR.r(i, i2, i3, i4);
        }
    }

    public void oE(String str) {
        if (this.ekS != null) {
            this.ekS.oE(str);
        }
    }

    public void hy(boolean z) {
        if (this.ekS != null) {
            this.ekS.hy(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aJo() {
        return this.ekQ;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aJp() {
        return null;
    }

    public void a(a aVar) {
        this.ehz = aVar;
    }

    public a aJq() {
        return this.ehz;
    }
}
