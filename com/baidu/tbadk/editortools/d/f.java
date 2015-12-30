package com.baidu.tbadk.editortools.d;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.n;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements d.a {
    final /* synthetic */ e auv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.auv = eVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void Ck() {
        BaseActivity baseActivity;
        baseActivity = this.auv.aui;
        baseActivity.showToast(n.j.no_network_guide);
        this.auv.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fw(String str) {
        BaseActivity baseActivity;
        baseActivity = this.auv.aui;
        if (StringUtils.isNull(str)) {
            str = this.auv.Bj().getContext().getString(n.j.location_fail);
        }
        baseActivity.showToast(str);
        this.auv.a(0, false, (String) null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.aFS())) {
            fw(null);
        } else {
            this.auv.a(2, true, aVar.aFS());
        }
    }
}
