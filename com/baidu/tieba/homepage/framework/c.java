package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class c {
    private a hWX;
    private final TbPageContext<BaseFragmentActivity> hZC;
    private RecPersonalizePageModel hZD;
    private ConcernNetModel hZE;
    private RecPersonalizePageModel.a hZF = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.hWX != null) {
                c.this.hWX.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void al(int i, String str) {
            if (c.this.hWX != null) {
                c.this.hWX.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b hZG = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.hWX != null) {
                c.this.hWX.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void al(int i, String str) {
            if (c.this.hWX != null) {
                c.this.hWX.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a hZH = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void og(boolean z) {
            if (c.this.hWX != null) {
                c.this.hWX.oh(z);
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
        this.hZC = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.hZD = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.hZD.a(this.hZF);
        this.hZE = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.hZE.a(this.hZG);
        this.hZE.a(this.hZH);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.hZD != null) {
            this.hZD.e(i, i2, i3, i4, i5);
        }
    }

    public void Fz(String str) {
        if (this.hZE != null) {
            this.hZE.Fz(str);
        }
    }

    public void of(boolean z) {
        if (this.hZE != null) {
            this.hZE.of(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> ceN() {
        return this.hZC;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a ceO() {
        return null;
    }

    public void a(a aVar) {
        this.hWX = aVar;
    }

    public a ceP() {
        return this.hWX;
    }
}
