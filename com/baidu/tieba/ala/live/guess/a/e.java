package com.baidu.tieba.ala.live.guess.a;

import android.app.Dialog;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.NonNull;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.core.util.UtilHelper;
/* loaded from: classes10.dex */
public class e extends Dialog {
    public e(@NonNull Context context) {
        super(context, a.i.guess_theme_dialog);
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
            ah(getWindow().getDecorView());
            getWindow().clearFlags(8);
            return;
        }
        super.show();
    }

    private void ah(View view) {
        if (Build.VERSION.SDK_INT >= 19) {
            view.setSystemUiVisibility(5894);
        }
    }
}
