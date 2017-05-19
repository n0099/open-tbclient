package com.baidu.tbadk.editortools.pb;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.LocationModel;
import com.baidu.tieba.w;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements LocationModel.a {
    final /* synthetic */ c aBh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(c cVar) {
        this.aBh = cVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void Dj() {
        BaseActivity baseActivity;
        baseActivity = this.aBh.mContext;
        baseActivity.showToast(w.l.no_network_guide);
        this.aBh.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void fy(String str) {
        BaseActivity baseActivity;
        baseActivity = this.aBh.mContext;
        if (StringUtils.isNull(str)) {
            str = this.aBh.Cs().getContext().getString(w.l.location_fail);
        }
        baseActivity.showToast(str);
        this.aBh.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.LocationModel.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bho())) {
            fy(null);
        } else {
            this.aBh.b(2, true, aVar.bho());
        }
    }
}
