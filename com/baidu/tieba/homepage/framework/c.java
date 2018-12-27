package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes6.dex */
public class c {
    private a esF;
    private final TbPageContext<BaseFragmentActivity> evW;
    private RecPersonalizePageModel evX;
    private ConcernNetModel evY;
    private RecPersonalizePageModel.a evZ = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.esF != null) {
                c.this.esF.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.esF != null) {
                c.this.esF.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ewa = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.esF != null) {
                c.this.esF.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.esF != null) {
                c.this.esF.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ewb = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void hO(boolean z) {
            if (c.this.esF != null) {
                c.this.esF.hQ(z);
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
        this.evW = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.evX = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.evX.a(this.evZ);
        this.evY = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.evY.a(this.ewa);
        this.evY.a(this.ewb);
    }

    public void c(int i, int i2, int i3, int i4, int i5) {
        if (this.evX != null) {
            this.evX.c(i, i2, i3, i4, i5);
        }
    }

    public void pk(String str) {
        if (this.evY != null) {
            this.evY.pk(str);
        }
    }

    public void hN(boolean z) {
        if (this.evY != null) {
            this.evY.hN(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aLs() {
        return this.evW;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aLt() {
        return null;
    }

    public void a(a aVar) {
        this.esF = aVar;
    }

    public a aLu() {
        return this.esF;
    }
}
