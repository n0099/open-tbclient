package com.baidu.tbadk.editortools.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e aqO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.aqO = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Bv() {
        BaseActivity baseActivity;
        baseActivity = this.aqO.aqA;
        baseActivity.showToast(i.h.no_network_guide);
        this.aqO.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fd(String str) {
        BaseActivity baseActivity;
        baseActivity = this.aqO.aqA;
        if (StringUtils.isNull(str)) {
            str = this.aqO.Az().getContext().getString(i.h.location_fail);
        }
        baseActivity.showToast(str);
        this.aqO.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.ayn())) {
            fd(null);
        } else {
            this.aqO.a(2, true, aVar.ayn());
        }
    }
}
