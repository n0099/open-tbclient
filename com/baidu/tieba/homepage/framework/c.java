package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class c {
    private a gQL;
    private final TbPageContext<BaseFragmentActivity> gTF;
    private RecPersonalizePageModel gTG;
    private ConcernNetModel gTH;
    private RecPersonalizePageModel.a gTI = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.gQL != null) {
                c.this.gQL.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void ad(int i, String str) {
            if (c.this.gQL != null) {
                c.this.gQL.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b gTJ = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.gQL != null) {
                c.this.gQL.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void ad(int i, String str) {
            if (c.this.gQL != null) {
                c.this.gQL.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a gTK = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void mn(boolean z) {
            if (c.this.gQL != null) {
                c.this.gQL.mo(z);
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

        void mo(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.gTF = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.gTG = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.gTG.a(this.gTI);
        this.gTH = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.gTH.a(this.gTJ);
        this.gTH.a(this.gTK);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.gTG != null) {
            this.gTG.e(i, i2, i3, i4, i5);
        }
    }

    public void BE(String str) {
        if (this.gTH != null) {
            this.gTH.BE(str);
        }
    }

    public void mm(boolean z) {
        if (this.gTH != null) {
            this.gTH.mm(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bKL() {
        return this.gTF;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a bKM() {
        return null;
    }

    public void a(a aVar) {
        this.gQL = aVar;
    }

    public a bKN() {
        return this.gQL;
    }
}
