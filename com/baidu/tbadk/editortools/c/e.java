package com.baidu.tbadk.editortools.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements d.a {
    final /* synthetic */ d asl;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.asl = dVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void BF() {
        BaseActivity baseActivity;
        baseActivity = this.asl.asa;
        baseActivity.showToast(i.h.no_network_guide);
        this.asl.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fb(String str) {
        BaseActivity baseActivity;
        baseActivity = this.asl.asa;
        if (StringUtils.isNull(str)) {
            str = this.asl.Ax().getContext().getString(i.h.location_fail);
        }
        baseActivity.showToast(str);
        this.asl.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.awY())) {
            fb(null);
        } else {
            this.asl.a(2, true, aVar.awY());
        }
    }
}
