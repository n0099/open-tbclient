package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a dnt;
    private final TbPageContext<BaseFragmentActivity> dpI;
    private RecPersonalizePageModel dpJ;
    private ConcernNetModel dpK;
    private RecPersonalizePageModel.a dpL = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dnt != null) {
                c.this.dnt.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void s(int i, String str) {
            if (c.this.dnt != null) {
                c.this.dnt.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b dpM = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dnt != null) {
                c.this.dnt.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void s(int i, String str) {
            if (c.this.dnt != null) {
                c.this.dnt.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a dpN = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fW(boolean z) {
            if (c.this.dnt != null) {
                c.this.dnt.fX(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void fX(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dpI = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.dpJ = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.dpJ.a(this.dpL);
        this.dpK = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.dpK.a(this.dpM);
        this.dpK.a(this.dpN);
    }

    public void q(int i, int i2, int i3, int i4) {
        if (this.dpJ != null) {
            this.dpJ.q(i, i2, i3, i4);
        }
    }

    public void lY(String str) {
        if (this.dpK != null) {
            this.dpK.lY(str);
        }
    }

    public void fV(boolean z) {
        if (this.dpK != null) {
            this.dpK.fV(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> atS() {
        return this.dpI;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a atT() {
        return null;
    }

    public void a(a aVar) {
        this.dnt = aVar;
    }

    public a atU() {
        return this.dnt;
    }
}
