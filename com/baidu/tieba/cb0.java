package com.baidu.tieba;

import com.baidu.searchbox.live.interfaces.net.NetResponse;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public interface cb0<T> {
    void onNetResponse(NetResponse netResponse, T t, Map<String, String> map, List<String> list);

    T onParseResponseInBackground(NetResponse netResponse);
}
