package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a eaM;
    private final TbPageContext<BaseFragmentActivity> edd;
    private RecPersonalizePageModel ede;
    private ConcernNetModel edf;
    private RecPersonalizePageModel.a edg = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.eaM != null) {
                c.this.eaM.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.eaM != null) {
                c.this.eaM.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b edh = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.eaM != null) {
                c.this.eaM.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.eaM != null) {
                c.this.eaM.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a edi = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gy(boolean z) {
            if (c.this.eaM != null) {
                c.this.eaM.gz(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes2.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void gz(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.edd = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ede = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ede.a(this.edg);
        this.edf = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.edf.a(this.edh);
        this.edf.a(this.edi);
    }

    public void y(int i, int i2, int i3, int i4) {
        if (this.ede != null) {
            this.ede.y(i, i2, i3, i4);
        }
    }

    public void mm(String str) {
        if (this.edf != null) {
            this.edf.mm(str);
        }
    }

    public void gx(boolean z) {
        if (this.edf != null) {
            this.edf.gx(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aAX() {
        return this.edd;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aAY() {
        return null;
    }

    public void a(a aVar) {
        this.eaM = aVar;
    }

    public a aAZ() {
        return this.eaM;
    }
}
