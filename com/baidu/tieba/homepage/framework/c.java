package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.concern.message.ConcernNetModel;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes16.dex */
public class c {
    private a irv;
    private final TbPageContext<BaseFragmentActivity> iuf;
    private RecPersonalizePageModel iug;
    private ConcernNetModel iuh;
    private RecPersonalizePageModel.a iui = new RecPersonalizePageModel.a() { // from class: com.baidu.tieba.homepage.framework.c.1
        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void a(DataRes dataRes, boolean z, boolean z2) {
            if (c.this.irv != null) {
                c.this.irv.b(dataRes, z, z2);
            }
        }

        @Override // com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel.a
        public void ao(int i, String str) {
            if (c.this.irv != null) {
                c.this.irv.a("", str, i, false, 1);
            }
        }
    };
    private ConcernNetModel.b iuj = new ConcernNetModel.b() { // from class: com.baidu.tieba.homepage.framework.c.2
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void b(tbclient.Userlike.DataRes dataRes, boolean z) {
            if (c.this.irv != null) {
                c.this.irv.c(dataRes, z);
            }
        }

        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.b
        public void ao(int i, String str) {
            if (c.this.irv != null) {
                c.this.irv.a("", str, i, false, 0);
            }
        }
    };
    private ConcernNetModel.a iuk = new ConcernNetModel.a() { // from class: com.baidu.tieba.homepage.framework.c.3
        @Override // com.baidu.tieba.homepage.concern.message.ConcernNetModel.a
        public void oW(boolean z) {
            if (c.this.irv != null) {
                c.this.irv.oX(z);
            }
        }
    };
    private final BdUniqueId uniqueId;

    /* loaded from: classes16.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z, int i2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);

        void b(DataRes dataRes, boolean z, boolean z2);

        void c(tbclient.Userlike.DataRes dataRes, boolean z);

        void oX(boolean z);
    }

    public c(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.iuf = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.iug = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.iug.a(this.iui);
        this.iuh = new ConcernNetModel(tbPageContext, bdUniqueId);
        this.iuh.a(this.iuj);
        this.iuh.a(this.iuk);
    }

    public void e(int i, int i2, int i3, int i4, int i5) {
        if (this.iug != null) {
            this.iug.e(i, i2, i3, i4, i5);
        }
    }

    public void GL(String str) {
        if (this.iuh != null) {
            this.iuh.GL(str);
        }
    }

    public void oV(boolean z) {
        if (this.iuh != null) {
            this.iuh.oV(z);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> clI() {
        return this.iuf;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a clJ() {
        return null;
    }

    public void a(a aVar) {
        this.irv = aVar;
    }

    public a clK() {
        return this.irv;
    }
}
