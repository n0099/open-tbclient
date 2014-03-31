package com.baidu.tieba.im.chat.officialBar;

import com.baidu.adp.lib.asyncTask.BdAsyncTask;
import com.baidu.adp.widget.BdSwitchView.BdSwitchView;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
final class am extends BdAsyncTask<Void, Void, Void> {
    final /* synthetic */ OfficialBarInfoActivity a;
    private final /* synthetic */ BdSwitchView.SwitchState b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public am(OfficialBarInfoActivity officialBarInfoActivity, BdSwitchView.SwitchState switchState) {
        this.a = officialBarInfoActivity;
        this.b = switchState;
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [java.lang.Object[]] */
    /* JADX DEBUG: Return type fixed from 'java.lang.Object' to match base method */
    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.lib.asyncTask.BdAsyncTask
    public final /* synthetic */ Void a(Void... voidArr) {
        int i;
        int i2;
        if (this.b == BdSwitchView.SwitchState.OFF) {
            bb a = bb.a();
            String E = TbadkApplication.E();
            i2 = this.a.c;
            a.d(E, String.valueOf(i2), false);
            return null;
        }
        bb a2 = bb.a();
        String E2 = TbadkApplication.E();
        i = this.a.c;
        a2.d(E2, String.valueOf(i), true);
        return null;
    }
}
