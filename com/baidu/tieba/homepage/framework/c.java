package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class c {
    private a hWk;
    private final TbPageContext<BaseFragmentActivity> hYP;
    private RecPersonalizePageModel hYQ;
    private ConcernNetModel hYR;
    private RecPersonalizePageModel.a hYS = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.hWk != null) {
                c.this.hWk.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void al(int i, String str) {
            if (c.this.hWk != null) {
                c.this.hWk.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b hYT = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.hWk != null) {
                c.this.hWk.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void al(int i, String str) {
            if (c.this.hWk != null) {
                c.this.hWk.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a hYU = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void og(boolean z) {
            if (c.this.hWk != null) {
                c.this.hWk.oh(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void oh(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.hYP = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.hYQ = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.hYQ.a(this.hYS);
        this.hYR = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.hYR.a(this.hYT);
        this.hYR.a(this.hYU);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.hYQ != null) {
            this.hYQ.e(i, i2, i3, i4, i5);
        }
    }

    public void Fz(String str) {
        if (this.hYR != null) {
            this.hYR.Fz(str);
        }
    }

    public void of(boolean z) {
        if (this.hYR != null) {
            this.hYR.of(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> ceF() {
        return this.hYP;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a ceG() {
        return null;
    }

    public void a(a aVar) {
        this.hWk = aVar;
    }

    public a ceH() {
        return this.hWk;
    }
}
