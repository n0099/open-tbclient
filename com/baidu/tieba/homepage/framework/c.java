package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class c {
    private a etm;
    private final TbPageContext<BaseFragmentActivity> ewG;
    private RecPersonalizePageModel ewH;
    private ConcernNetModel ewI;
    private RecPersonalizePageModel.a ewJ = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.etm != null) {
                c.this.etm.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void t(int i, String str) {
            if (c.this.etm != null) {
                c.this.etm.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ewK = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.etm != null) {
                c.this.etm.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void t(int i, String str) {
            if (c.this.etm != null) {
                c.this.etm.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ewL = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void hO(boolean z) {
            if (c.this.etm != null) {
                c.this.etm.hQ(z);
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

        void hQ(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.ewG = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ewH = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ewH.a(this.ewJ);
        this.ewI = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ewI.a(this.ewK);
        this.ewI.a(this.ewL);
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (this.ewH != null) {
            this.ewH.c(i, i2, i3, i4, i5);
        }
    }

    public void pA(String str) {
        if (this.ewI != null) {
            this.ewI.pA(str);
        }
    }

    public void hN(boolean z) {
        if (this.ewI != null) {
            this.ewI.hN(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aLR() {
        return this.ewG;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aLS() {
        return null;
    }

    public void a(a aVar) {
        this.etm = aVar;
    }

    public a aLT() {
        return this.etm;
    }
}
