package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class c {
    private a gXB;
    private final TbPageContext<BaseFragmentActivity> haw;
    private RecPersonalizePageModel hax;
    private ConcernNetModel hay;
    private final BdUniqueId uniqueId;
    private RecPersonalizePageModel.a haz = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.gXB != null) {
                c.this.gXB.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void ag(int i, String str) {
            if (c.this.gXB != null) {
                c.this.gXB.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b haA = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.gXB != null) {
                c.this.gXB.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void ag(int i, String str) {
            if (c.this.gXB != null) {
                c.this.gXB.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a haB = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void mG(boolean z) {
            if (c.this.gXB != null) {
                c.this.gXB.mH(z);
            }
        }
    };

    /* loaded from: classes9.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void mH(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.haw = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.hax = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.hax.a(this.haz);
        this.hay = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.hay.a(this.haA);
        this.hay.a(this.haB);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.hax != null) {
            this.hax.e(i, i2, i3, i4, i5);
        }
    }

    public void Cf(String str) {
        if (this.hay != null) {
            this.hay.Cf(str);
        }
    }

    public void mF(boolean z) {
        if (this.hay != null) {
            this.hay.mF(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bNK() {
        return this.haw;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a bNL() {
        return null;
    }

    public void a(a aVar) {
        this.gXB = aVar;
    }

    public a bNM() {
        return this.gXB;
    }
}
