package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.tbadk.coreExtra.data.WriteData;
import java.util.List;
/* loaded from: classes3.dex */
public interface d59 {
    void a(WriteData writeData);

    void c(WriteData writeData);

    void d();

    void e(WriteData writeData);

    boolean g();

    void h(String str, WriteData writeData);

    void j(f59 f59Var);

    void m(Bundle bundle, Intent intent, WriteData writeData);

    boolean o();

    void onActivityResult(int i, int i2, Intent intent);

    void onChangeSkinType(int i);

    void onPause();

    void onResume();

    void onSaveInstanceState(Bundle bundle);

    void q(List list);

    void r(l55 l55Var);

    View s(ViewGroup viewGroup);

    boolean t();
}
