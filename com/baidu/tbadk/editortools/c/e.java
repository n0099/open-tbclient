package com.baidu.tbadk.editortools.c;

import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tieba.i;
import com.baidu.tieba.tbadkCore.location.d;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements d.a {
    final /* synthetic */ d asm;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.asm = dVar;
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void BF() {
        BaseActivity baseActivity;
        baseActivity = this.asm.asb;
        baseActivity.showToast(i.h.no_network_guide);
        this.asm.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void fb(String str) {
        BaseActivity baseActivity;
        baseActivity = this.asm.asb;
        if (StringUtils.isNull(str)) {
            str = this.asm.Ax().getContext().getString(i.h.location_fail);
        }
        baseActivity.showToast(str);
        this.asm.a(0, false, null);
    }

    @Override // com.baidu.tieba.tbadkCore.location.d.a
    public void a(com.baidu.tieba.tbadkCore.location.a aVar) {
        if (aVar == null || StringUtils.isNull(aVar.axi())) {
            fb(null);
        } else {
            this.asm.a(2, true, aVar.axi());
        }
    }
}
