package com.baidu.tieba.dex.wrapper;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import java.util.Observable;
/* loaded from: classes.dex */
public interface BdBrowserDelegate {
    void onActivityResult(int i, int i2, Intent intent);

    void onCreate(Bundle bundle);

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    boolean onKeyUp(int i, KeyEvent keyEvent);

    void onNewIntent(Intent intent);

    void onPause();

    void onResume();

    void onStop();

    void startActivity(Context context, String str, String str2, String str3);

    void update(Observable observable, Object obj);
}
