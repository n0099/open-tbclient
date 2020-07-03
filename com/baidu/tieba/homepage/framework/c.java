package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes9.dex */
public class c {
    private a ils;
    private final TbPageContext<BaseFragmentActivity> iod;
    private RecPersonalizePageModel ioe;
    private ConcernNetModel iof;
    private RecPersonalizePageModel.a iog = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.ils != null) {
                c.this.ils.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void an(int i, String str) {
            if (c.this.ils != null) {
                c.this.ils.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b ioh = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.ils != null) {
                c.this.ils.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void an(int i, String str) {
            if (c.this.ils != null) {
                c.this.ils.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a ioi = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void or(boolean z) {
            if (c.this.ils != null) {
                c.this.ils.os(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes9.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void os(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.iod = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.ioe = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.ioe.a(this.iog);
        this.iof = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.iof.a(this.ioh);
        this.iof.a(this.ioi);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.ioe != null) {
            this.ioe.e(i, i2, i3, i4, i5);
        }
    }

    public void FZ(String str) {
        if (this.iof != null) {
            this.iof.FZ(str);
        }
    }

    public void oq(boolean z) {
        if (this.iof != null) {
            this.iof.oq(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cii() {
        return this.iod;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cij() {
        return null;
    }

    public void a(a aVar) {
        this.ils = aVar;
    }

    public a cik() {
        return this.ils;
    }
}
