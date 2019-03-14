package com.baidu.tieba.aiapps.apps.media.video.view;

import android.app.Fragment;
import android.content.res.Configuration;
/* loaded from: classes4.dex */
public class ConfigurationChangedListenFragment extends Fragment {
    a cVK = null;

    /* loaded from: classes4.dex */
    public interface a {
        void onConfigurationChanged(Configuration configuration);
    }

    public void a(a aVar) {
        this.cVK = aVar;
    }

    @Override // android.app.Fragment, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (this.cVK != null) {
            this.cVK.onConfigurationChanged(configuration);
        }
    }
}
