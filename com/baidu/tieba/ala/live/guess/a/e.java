package com.baidu.tieba.ala.live.guess.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes4.dex */
public class e extends Dialog {
    public e(@NonNull Context context) {
        super(context, a.j.guess_theme_dialog);
    }

    @Override // android.app.Dialog
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
    }

    @Override // android.app.Dialog
    public void show() {
        if (UtilHelper.getRealScreenOrientation(getContext()) == 2) {
            getWindow().setFlags(8, 8);
            super.show();
            ad(getWindow().getDecorView());
            getWindow().clearFlags(8);
            return;
        }
        super.show();
    }

    private void ad(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5894);
        }
    }
}
