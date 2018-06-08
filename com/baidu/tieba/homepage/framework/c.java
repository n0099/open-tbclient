package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes2.dex */
public class c {
    private a dMr;
    private final TbPageContext<BaseFragmentActivity> dOH;
    private RecPersonalizePageModel dOI;
    private ConcernNetModel dOJ;
    private RecPersonalizePageModel.a dOK = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.dMr != null) {
                c.this.dMr.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void q(int i, String str) {
            if (c.this.dMr != null) {
                c.this.dMr.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b dOL = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.dMr != null) {
                c.this.dMr.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void q(int i, String str) {
            if (c.this.dMr != null) {
                c.this.dMr.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a dOM = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void gx(boolean z) {
            if (c.this.dMr != null) {
                c.this.dMr.gy(z);
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

        void gy(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.dOH = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.dOI = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.dOI.a(this.dOK);
        this.dOJ = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.dOJ.a(this.dOL);
        this.dOJ.a(this.dOM);
    }

    public void r(int i, int i2, int i3, int i4) {
        if (this.dOI != null) {
            this.dOI.r(i, i2, i3, i4);
        }
    }

    public void nu(String str) {
        if (this.dOJ != null) {
            this.dOJ.nu(str);
        }
    }

    public void gw(boolean z) {
        if (this.dOJ != null) {
            this.dOJ.gw(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aCm() {
        return this.dOH;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aCn() {
        return null;
    }

    public void a(a aVar) {
        this.dMr = aVar;
    }

    public a aCo() {
        return this.dMr;
    }
}
