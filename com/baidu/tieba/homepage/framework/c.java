package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a cYm;
    private final TbPageContext<BaseFragmentActivity> daU;
    private RecPersonalizePageModel daV;
    private ConcernNetModel daW;
    private RecPersonalizePageModel.a daX = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.cYm != null) {
                c.this.cYm.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.cYm != null) {
                c.this.cYm.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b daY = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.cYm != null) {
                c.this.cYm.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.cYm != null) {
                c.this.cYm.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a daZ = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fP(boolean z) {
            if (c.this.cYm != null) {
                c.this.cYm.fQ(z);
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

        void fQ(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.daU = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.daV = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.daV.a(this.daX);
        this.daW = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.daW.a(this.daY);
        this.daW.a(this.daZ);
    }

    public void b(int i, int i2, int i3, int i4, int i5) {
        if (this.daV != null) {
            this.daV.b(i, i2, i3, i4, i5);
        }
    }

    public void lM(String str) {
        if (this.daW != null) {
            this.daW.lM(str);
        }
    }

    public void aqw() {
        if (this.daW != null) {
            this.daW.aqw();
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aqA() {
        return this.daU;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aqB() {
        return null;
    }

    public void a(a aVar) {
        this.cYm = aVar;
    }

    public a aqC() {
        return this.cYm;
    }
}
