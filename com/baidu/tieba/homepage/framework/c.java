package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class c {
    private a iFS;
    private final TbPageContext<BaseFragmentActivity> iIC;
    private RecPersonalizePageModel iID;
    private ConcernNetModel iIE;
    private RecPersonalizePageModel.a iIF = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.iFS != null) {
                c.this.iFS.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void am(int i, String str) {
            if (c.this.iFS != null) {
                c.this.iFS.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b iIG = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.iFS != null) {
                c.this.iFS.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void am(int i, String str) {
            if (c.this.iFS != null) {
                c.this.iFS.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a iIH = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void pD(boolean z) {
            if (c.this.iFS != null) {
                c.this.iFS.pE(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes16.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void pE(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.iIC = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.iID = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.iID.a(this.iIF);
        this.iIE = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.iIE.a(this.iIG);
        this.iIE.a(this.iIH);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.iID != null) {
            this.iID.e(i, i2, i3, i4, i5);
        }
    }

    public void JC(String str) {
        if (this.iIE != null) {
            this.iIE.JC(str);
        }
    }

    public void pC(boolean z) {
        if (this.iIE != null) {
            this.iIE.pC(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cws() {
        return this.iIC;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cwt() {
        return null;
    }

    public void a(a aVar) {
        this.iFS = aVar;
    }

    public a cwu() {
        return this.iFS;
    }
}
