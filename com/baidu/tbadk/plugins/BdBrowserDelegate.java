package com.baidu.tbadk.plugins;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import java.util.Observable;
/* loaded from: classes.dex */
public interface BdBrowserDelegate {

    /* loaded from: classes.dex */
    public interface Callback {
        boolean shouldOverrideUrlLoading(String str);
    }

    void onActivityResult(int i, int i2, Intent intent);

    void onCreate(Bundle bundle);

    void onDestroy();

    boolean onKeyDown(int i, KeyEvent keyEvent);

    boolean onKeyUp(int i, KeyEvent keyEvent);

    void onNewIntent(Intent intent);

    void onPause();

    void onResume();

    void onStop();

    void setActivity(Activity activity);

    void setCallback(Callback callback);

    void update(Observable observable, Object obj);
}
