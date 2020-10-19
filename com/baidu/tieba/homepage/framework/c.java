package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes22.dex */
public class c {
    private a jcf;
    private final TbPageContext<BaseFragmentActivity> jfX;
    private RecPersonalizePageModel jfY;
    private ConcernNetModel jfZ;
    private RecPersonalizePageModel.a jga = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.jcf != null) {
                c.this.jcf.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void ay(int i, String str) {
            if (c.this.jcf != null) {
                c.this.jcf.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b jgb = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.jcf != null) {
                c.this.jcf.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void ay(int i, String str) {
            if (c.this.jcf != null) {
                c.this.jcf.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a jgc = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void qq(boolean z) {
            if (c.this.jcf != null) {
                c.this.jcf.qs(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes22.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void qs(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.jfX = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.jfY = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.jfY.a(this.jga);
        this.jfZ = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.jfZ.a(this.jgb);
        this.jfZ.a(this.jgc);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.jfY != null) {
            this.jfY.e(i, i2, i3, i4, i5);
        }
    }

    public void KT(String str) {
        if (this.jfZ != null) {
            this.jfZ.KT(str);
        }
    }

    public void qp(boolean z) {
        if (this.jfZ != null) {
            this.jfZ.qp(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> cDC() {
        return this.jfX;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a cDD() {
        return null;
    }

    public void a(a aVar) {
        this.jcf = aVar;
    }

    public a cDE() {
        return this.jcf;
    }
}
