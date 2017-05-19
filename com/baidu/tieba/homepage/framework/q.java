package com.baidu.tieba.homepage.framework;

import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.homepage.personalize.model.RecPersonalizePageModel;
import tbclient.Personalized.DataRes;
/* loaded from: classes.dex */
public class q {
    private a csv;
    private final TbPageContext<BaseFragmentActivity> ctr;
    private RecPersonalizePageModel cts;
    private RecPersonalizePageModel.a ctt = new r(this);
    private final BdUniqueId uniqueId;

    /* loaded from: classes.dex */
    public interface a {
        void a(String str, String str2, int i, boolean z);

        void a(DataRes dataRes, boolean z, boolean z2);

        void a(boolean z, com.baidu.tieba.homepage.a.a.a aVar, boolean z2, String str, String str2, boolean z3);
    }

    public q(TbPageContext<BaseFragmentActivity> tbPageContext, BdUniqueId bdUniqueId) {
        this.ctr = tbPageContext;
        this.uniqueId = bdUniqueId;
        this.cts = new RecPersonalizePageModel(tbPageContext, bdUniqueId);
        this.cts.a(this.ctt);
    }

    public void d(int i, int i2, int i3, int i4, int i5) {
        if (this.cts != null) {
            this.cts.d(i, i2, i3, i4, i5);
        }
    }

    public BdUniqueId getUniqueId() {
        return this.uniqueId;
    }

    public TbPageContext<BaseFragmentActivity> ahf() {
        return this.ctr;
    }

    public void a(com.baidu.tieba.lego.model.a aVar) {
    }

    public com.baidu.tieba.lego.model.a ahg() {
        return null;
    }

    public void a(a aVar) {
        this.csv = aVar;
    }

    public a ahh() {
        return this.csv;
    }
}
