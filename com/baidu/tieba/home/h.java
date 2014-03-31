package com.baidu.tieba.home;

import android.view.KeyEvent;
import android.view.View;
import android.widget.ListView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class h implements View.OnKeyListener {
    final /* synthetic */ e a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(e eVar) {
        this.a = eVar;
    }

    @Override // android.view.View.OnKeyListener
    public final boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (view instanceof ListView) {
            ListView listView = (ListView) view;
            if (keyEvent.getAction() == 0) {
                if (i == 21) {
                    if (listView.getSelectedView() == null) {
                        listView.dispatchKeyEvent(new KeyEvent(0, 19));
                        return true;
                    }
                    return false;
                } else if (i == 22 && listView.getSelectedView() == null) {
                    listView.dispatchKeyEvent(new KeyEvent(0, 20));
                    return true;
                } else {
                    return false;
                }
            }
            return false;
        }
        return false;
    }
}
