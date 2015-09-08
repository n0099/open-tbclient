package com.baidu.tbadk.editortools.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements d.a {
    final /* synthetic */ d atO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.atO = dVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void BS() {
        BaseActivity baseActivity;
        baseActivity = this.atO.atD;
        baseActivity.showToast(i.h.no_network_guide);
        this.atO.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void eW(String str) {
        BaseActivity baseActivity;
        baseActivity = this.atO.atD;
        if (StringUtils.isNull(str)) {
            str = this.atO.AL().getContext().getString(i.h.location_fail);
        }
        baseActivity.showToast(str);
        this.atO.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.auM())) {
            eW(null);
        } else {
            this.atO.a(2, true, aVar.auM());
        }
    }
}
