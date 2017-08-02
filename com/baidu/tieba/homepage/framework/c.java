package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a cNJ;
    private final TbPageContext<BaseFragmentActivity> cQd;
    private RecPersonalizePageModel cQe;
    private ConcernNetModel cQf;
    private RecPersonalizePageModel.a cQg = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.cNJ != null) {
                c.this.cNJ.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void s(int i, String str) {
            if (c.this.cNJ != null) {
                c.this.cNJ.a("", str, i, false, com.baidu.tieba.homepage.framework.indicator.a.cQz);
            }
        }
    };
    private ConcernNetModel.b cQh = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.cNJ != null) {
                c.this.cNJ.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void s(int i, String str) {
            if (c.this.cNJ != null) {
                c.this.cNJ.a("", str, i, false, com.baidu.tieba.homepage.framework.indicator.a.cQy);
            }
        }
    };
    private ConcernNetModel.a cQi = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fD(boolean z) {
            if (c.this.cNJ != null) {
                c.this.cNJ.fE(z);
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

        void fE(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cQd = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cQe = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cQe.a(this.cQg);
        this.cQf = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.cQf.a(this.cQh);
        this.cQf.a(this.cQi);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.cQe != null) {
            this.cQe.d(i, i2, i3, i4, i5);
        }
    }

    public void li(String str) {
        if (this.cQf != null) {
            this.cQf.li(str);
        }
    }

    public void anQ() {
        if (this.cQf != null) {
            this.cQf.anQ();
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> anU() {
        return this.cQd;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a anV() {
        return null;
    }

    public void a(a aVar) {
        this.cNJ = aVar;
    }

    public a anW() {
        return this.cNJ;
    }
}
