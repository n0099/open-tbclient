package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class c {
    private a cXs;
    private final TbPageContext<BaseFragmentActivity> cZY;
    private RecPersonalizePageModel cZZ;
    private ConcernNetModel daa;
    private RecPersonalizePageModel.a dab = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.cXs != null) {
                c.this.cXs.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void r(int i, String str) {
            if (c.this.cXs != null) {
                c.this.cXs.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b dac = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.cXs != null) {
                c.this.cXs.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void r(int i, String str) {
            if (c.this.cXs != null) {
                c.this.cXs.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a dad = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void fO(boolean z) {
            if (c.this.cXs != null) {
                c.this.cXs.fP(z);
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

        void fP(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.cZY = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cZZ = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cZZ.a(this.dab);
        this.daa = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.daa.a(this.dac);
        this.daa.a(this.dad);
    }

    public void b(int i, int i2, int i3, int i4, int i5) {
        if (this.cZZ != null) {
            this.cZZ.b(i, i2, i3, i4, i5);
        }
    }

    public void lK(String str) {
        if (this.daa != null) {
            this.daa.lK(str);
        }
    }

    public void aql() {
        if (this.daa != null) {
            this.daa.aql();
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> aqp() {
        return this.cZY;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a aqq() {
        return null;
    }

    public void a(a aVar) {
        this.cXs = aVar;
    }

    public a aqr() {
        return this.cXs;
    }
}
