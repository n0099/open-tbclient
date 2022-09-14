package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import com.baidu.tbadk.coreExtra.data.WriteData;
/* loaded from: classes3.dex */
public interface d49<D> {
    void b(WriteData writeData);

    void c();

    void d(@NonNull WriteData writeData);

    boolean f();

    void h(@NonNull f49 f49Var);

    void k(@NonNull WriteData writeData);

    void l(Bundle bundle, Intent intent, @NonNull WriteData writeData);

    boolean n();

    void onActivityResult(int i, int i2, Intent intent);

    void onChangeSkinType(int i);

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void p(u45 u45Var);

    View q(@NonNull ViewGroup viewGroup);

    boolean r();
}
