package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class c {
    private a etn;
    private final TbPageContext<BaseFragmentActivity> ewH;
    private RecPersonalizePageModel ewI;
    private ConcernNetModel ewJ;
    private RecPersonalizePageModel.a ewK = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.etn != null) {
                c.this.etn.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void t(int i, String str) {
            if (c.this.etn != null) {
                c.this.etn.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ewL = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.etn != null) {
                c.this.etn.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void t(int i, String str) {
            if (c.this.etn != null) {
                c.this.etn.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ewM = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void hO(boolean z) {
            if (c.this.etn != null) {
                c.this.etn.hQ(z);
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
        this.ewH = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ewI = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ewI.a(this.ewK);
        this.ewJ = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ewJ.a(this.ewL);
        this.ewJ.a(this.ewM);
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (this.ewI != null) {
            this.ewI.c(i, i2, i3, i4, i5);
        }
    }

    public void pA(String str) {
        if (this.ewJ != null) {
            this.ewJ.pA(str);
        }
    }

    public void hN(boolean z) {
        if (this.ewJ != null) {
            this.ewJ.hN(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aLR() {
        return this.ewH;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aLS() {
        return null;
    }

    public void a(a aVar) {
        this.etn = aVar;
    }

    public a aLT() {
        return this.etn;
    }
}
