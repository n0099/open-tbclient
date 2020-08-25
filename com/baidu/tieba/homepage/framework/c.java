package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class c {
    private a iFM;
    private final TbPageContext<BaseFragmentActivity> iIw;
    private RecPersonalizePageModel iIx;
    private ConcernNetModel iIy;
    private final BdUniqueId uniqueId;
    private RecPersonalizePageModel.a iIz = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.iFM != null) {
                c.this.iFM.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void am(int i, String str) {
            if (c.this.iFM != null) {
                c.this.iFM.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b iIA = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.iFM != null) {
                c.this.iFM.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void am(int i, String str) {
            if (c.this.iFM != null) {
                c.this.iFM.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a iIB = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void pB(boolean z) {
            if (c.this.iFM != null) {
                c.this.iFM.pC(z);
            }
        }
    };

    /* loaded from: classes16.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void pC(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.iIw = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.iIx = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.iIx.a(this.iIz);
        this.iIy = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.iIy.a(this.iIA);
        this.iIy.a(this.iIB);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.iIx != null) {
            this.iIx.e(i, i2, i3, i4, i5);
        }
    }

    public void JB(String str) {
        if (this.iIy != null) {
            this.iIy.JB(str);
        }
    }

    public void pA(boolean z) {
        if (this.iIy != null) {
            this.iIy.pA(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cwr() {
        return this.iIw;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cws() {
        return null;
    }

    public void a(a aVar) {
        this.iFM = aVar;
    }

    public a cwt() {
        return this.iFM;
    }
}
