package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.t;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e avn;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.avn = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void DA() {
        BaseActivity baseActivity;
        baseActivity = this.avn.ava;
        baseActivity.showToast(t.j.no_network_guide);
        this.avn.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fu(String str) {
        BaseActivity baseActivity;
        baseActivity = this.avn.ava;
        if (StringUtils.isNull(str)) {
            str = this.avn.Cz().getContext().getString(t.j.location_fail);
        }
        baseActivity.showToast(str);
        this.avn.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aMX())) {
            fu(null);
        } else {
            this.avn.a(2, true, aVar.aMX());
        }
    }
}
