package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {
    private a gdy;
    private final TbPageContext<BaseFragmentActivity> ggW;
    private RecPersonalizePageModel ggX;
    private ConcernNetModel ggY;
    private RecPersonalizePageModel.a ggZ = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.gdy != null) {
                c.this.gdy.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void P(int i, String str) {
            if (c.this.gdy != null) {
                c.this.gdy.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b gha = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.gdy != null) {
                c.this.gdy.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void P(int i, String str) {
            if (c.this.gdy != null) {
                c.this.gdy.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ghb = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void kZ(boolean z) {
            if (c.this.gdy != null) {
                c.this.gdy.lb(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void lb(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.ggW = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ggX = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ggX.a(this.ggZ);
        this.ggY = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.ggY.a(this.gha);
        this.ggY.a(this.ghb);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.ggX != null) {
            this.ggX.e(i, i2, i3, i4, i5);
        }
    }

    public void wQ(String str) {
        if (this.ggY != null) {
            this.ggY.wQ(str);
        }
    }

    public void kY(boolean z) {
        if (this.ggY != null) {
            this.ggY.kY(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bty() {
        return this.ggW;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a btz() {
        return null;
    }

    public void a(a aVar) {
        this.gdy = aVar;
    }

    public a btA() {
        return this.gdy;
    }
}
