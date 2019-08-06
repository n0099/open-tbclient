package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes4.dex */
public class c {
    private a gck;
    private final TbPageContext<BaseFragmentActivity> gfH;
    private RecPersonalizePageModel gfI;
    private ConcernNetModel gfJ;
    private RecPersonalizePageModel.a gfK = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void b(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.gck != null) {
                c.this.gck.a(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void M(int i, String str) {
            if (c.this.gck != null) {
                c.this.gck.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b gfL = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.gck != null) {
                c.this.gck.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void M(int i, String str) {
            if (c.this.gck != null) {
                c.this.gck.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a gfM = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void li(boolean z) {
            if (c.this.gck != null) {
                c.this.gck.lk(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes4.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void lk(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.gfH = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.gfI = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.gfI.a(this.gfK);
        this.gfJ = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.gfJ.a(this.gfL);
        this.gfJ.a(this.gfM);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.gfI != null) {
            this.gfI.d(i, i2, i3, i4, i5);
        }
    }

    public void xY(String str) {
        if (this.gfJ != null) {
            this.gfJ.xY(str);
        }
    }

    public void lh(boolean z) {
        if (this.gfJ != null) {
            this.gfJ.lh(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> bvF() {
        return this.gfH;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a bvG() {
        return null;
    }

    public void a(a aVar) {
        this.gck = aVar;
    }

    public a bvH() {
        return this.gck;
    }
}
