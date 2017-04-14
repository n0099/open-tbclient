package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements LocationModel.a {
    final /* synthetic */ c aBg;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aBg = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Ef() {
        BaseActivity baseActivity;
        baseActivity = this.aBg.mContext;
        baseActivity.showToast(w.l.no_network_guide);
        this.aBg.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fB(String str) {
        BaseActivity baseActivity;
        baseActivity = this.aBg.mContext;
        if (StringUtils.isNull(str)) {
            str = this.aBg.Dn().getContext().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.aBg.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.biQ())) {
            fB(null);
        } else {
            this.aBg.b(2, true, aVar.biQ());
        }
    }
}
