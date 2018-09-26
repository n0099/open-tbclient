package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a dZG;
    private final TbPageContext<BaseFragmentActivity> ecX;
    private RecPersonalizePageModel ecY;
    private ConcernNetModel ecZ;
    private RecPersonalizePageModel.a eda = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dZG != null) {
                c.this.dZG.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void s(int i, String str) {
            if (c.this.dZG != null) {
                c.this.dZG.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b edb = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dZG != null) {
                c.this.dZG.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void s(int i, String str) {
            if (c.this.dZG != null) {
                c.this.dZG.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a edc = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void hh(boolean z) {
            if (c.this.dZG != null) {
                c.this.dZG.hj(z);
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

        void hj(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.ecX = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ecY = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ecY.a(this.eda);
        this.ecZ = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ecZ.a(this.edb);
        this.ecZ.a(this.edc);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.ecY != null) {
            this.ecY.r(i, i2, i3, i4);
        }
    }

    public void oa(String str) {
        if (this.ecZ != null) {
            this.ecZ.oa(str);
        }
    }

    public void hg(boolean z) {
        if (this.ecZ != null) {
            this.ecZ.hg(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aFW() {
        return this.ecX;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aFX() {
        return null;
    }

    public void a(a aVar) {
        this.dZG = aVar;
    }

    public a aFY() {
        return this.dZG;
    }
}
