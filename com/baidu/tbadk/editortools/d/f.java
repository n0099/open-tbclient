package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.tbadkCore.location.d;
import com.baidu.tieba.u;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e atr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.atr = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Cl() {
        BaseActivity baseActivity;
        baseActivity = this.atr.ate;
        baseActivity.showToast(u.j.no_network_guide);
        this.atr.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fD(String str) {
        BaseActivity baseActivity;
        baseActivity = this.atr.ate;
        if (StringUtils.isNull(str)) {
            str = this.atr.Bl().getContext().getString(u.j.location_fail);
        }
        baseActivity.showToast(str);
        this.atr.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.getFormatted_address())) {
            fD(null);
        } else {
            this.atr.b(2, true, aVar.getFormatted_address());
        }
    }
}
