package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements LocationModel.a {
    final /* synthetic */ c aAT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aAT = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Dd() {
        BaseActivity baseActivity;
        baseActivity = this.aAT.mContext;
        baseActivity.showToast(w.l.no_network_guide);
        this.aAT.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fw(String str) {
        BaseActivity baseActivity;
        baseActivity = this.aAT.mContext;
        if (StringUtils.isNull(str)) {
            str = this.aAT.Cm().getContext().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.aAT.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.biI())) {
            fw(null);
        } else {
            this.aAT.b(2, true, aVar.biI());
        }
    }
}
