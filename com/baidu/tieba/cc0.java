package com.baidu.tieba;

import android.content.Context;
import com.baidu.live.business.model.data.LiveSearchResultInfo;
import com.baidu.live.feed.search.model.data.RequestSearchData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.Interceptable;
/* loaded from: classes5.dex */
public interface cc0 {
    void a(Context context, String str);

    void b(Context context);

    void c();

    void d();

    void e(Context context);

    void f(Context context, int i);

    void g(String str, String str2, RequestSearchData requestSearchData);

    void h();

    void i(String str);

    void j(LiveSearchResultInfo liveSearchResultInfo, Context context, int i);

    void onDetach();

    /* loaded from: classes5.dex */
    public static final class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public static /* synthetic */ void a(cc0 cc0Var, String str, String str2, RequestSearchData requestSearchData, int i, Object obj) {
            if (obj == null) {
                if ((i & 4) != 0) {
                    requestSearchData = new RequestSearchData();
                }
                cc0Var.g(str, str2, requestSearchData);
                return;
            }
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: searchWord");
        }
    }
}
