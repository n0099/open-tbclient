package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a dPH;
    private final TbPageContext<BaseFragmentActivity> dRY;
    private RecPersonalizePageModel dRZ;
    private ConcernNetModel dSa;
    private RecPersonalizePageModel.a dSb = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dPH != null) {
                c.this.dPH.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void q(int i, String str) {
            if (c.this.dPH != null) {
                c.this.dPH.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b dSc = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dPH != null) {
                c.this.dPH.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void q(int i, String str) {
            if (c.this.dPH != null) {
                c.this.dPH.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a dSd = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gH(boolean z) {
            if (c.this.dPH != null) {
                c.this.dPH.gI(z);
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

        void gI(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dRY = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.dRZ = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.dRZ.a(this.dSb);
        this.dSa = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.dSa.a(this.dSc);
        this.dSa.a(this.dSd);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.dRZ != null) {
            this.dRZ.r(i, i2, i3, i4);
        }
    }

    public void nv(String str) {
        if (this.dSa != null) {
            this.dSa.nv(str);
        }
    }

    public void gG(boolean z) {
        if (this.dSa != null) {
            this.dSa.gG(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aCQ() {
        return this.dRY;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aCR() {
        return null;
    }

    public void a(a aVar) {
        this.dPH = aVar;
    }

    public a aCS() {
        return this.dPH;
    }
}
