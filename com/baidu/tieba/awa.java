package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.List;
/* loaded from: classes5.dex */
public interface awa<D> {
    void a(@NonNull WriteData writeData);

    void b(WriteData writeData);

    void c();

    void e(@NonNull WriteData writeData);

    boolean g();

    void h(@Nullable String str, @NonNull WriteData writeData);

    void j(@NonNull cwa cwaVar);

    void m(Bundle bundle, Intent intent, @NonNull WriteData writeData);

    boolean o();

    void onActivityResult(int i, int i2, Intent intent);

    void onChangeSkinType(int i);

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void q(@NonNull List<awa<?>> list);

    void r(lh5 lh5Var);

    View s(@NonNull ViewGroup viewGroup);

    boolean t();
}
