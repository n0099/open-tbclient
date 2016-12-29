package com.baidu.tbadk.editortools.e;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.r;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e awr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.awr = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Dt() {
        BaseActivity baseActivity;
        baseActivity = this.awr.awe;
        baseActivity.showToast(r.j.no_network_guide);
        this.awr.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fJ(String str) {
        BaseActivity baseActivity;
        baseActivity = this.awr.awe;
        if (StringUtils.isNull(str)) {
            str = this.awr.CB().getContext().getString(r.j.location_fail);
        }
        baseActivity.showToast(str);
        this.awr.b(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.bgA())) {
            fJ(null);
        } else {
            this.awr.b(2, true, aVar.bgA());
        }
    }
}
