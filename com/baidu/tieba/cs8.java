package com.baidu.tieba;

import android.view.View;
import com.baidu.tieba.mainentrance.HotSearchInfoData;
import tbclient.SearchSug.DataRes;
/* loaded from: classes5.dex */
public interface cs8 {
    void a(String str, boolean z, int i);

    void b();

    View c();

    void d(HotSearchInfoData hotSearchInfoData);

    View e();

    void f(DataRes dataRes, String str);

    void onChangeSkinType(int i);

    void onDestroy();

    void onPause();

    void onResume();
}
