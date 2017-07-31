package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a cPe;
    private final TbPageContext<BaseFragmentActivity> cRw;
    private RecPersonalizePageModel cRx;
    private ConcernNetModel cRy;
    private final BdUniqueId uniqueId;
    private RecPersonalizePageModel.a cRz = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.cPe != null) {
                c.this.cPe.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void s(int i, String str) {
            if (c.this.cPe != null) {
                c.this.cPe.a("", str, i, false, com.baidu.tieba.homepage.framework.indicator.a.cRS);
            }
        }
    };
    private ConcernNetModel.b cRA = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.cPe != null) {
                c.this.cPe.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void s(int i, String str) {
            if (c.this.cPe != null) {
                c.this.cPe.a("", str, i, false, com.baidu.tieba.homepage.framework.indicator.a.cRR);
            }
        }
    };
    private ConcernNetModel.a cRB = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fD(boolean z) {
            if (c.this.cPe != null) {
                c.this.cPe.fE(z);
            }
        }
    };

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void fE(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cRw = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cRx = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cRx.a(this.cRz);
        this.cRy = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.cRy.a(this.cRA);
        this.cRy.a(this.cRB);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.cRx != null) {
            this.cRx.d(i, i2, i3, i4, i5);
        }
    }

    public void lm(String str) {
        if (this.cRy != null) {
            this.cRy.lm(str);
        }
    }

    public void aoc() {
        if (this.cRy != null) {
            this.cRy.aoc();
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aog() {
        return this.cRw;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aoh() {
        return null;
    }

    public void a(a aVar) {
        this.cPe = aVar;
    }

    public a aoi() {
        return this.cPe;
    }
}
