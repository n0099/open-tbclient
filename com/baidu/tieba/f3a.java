package com.baidu.tieba;

import android.content.Context;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.data.AdvertAppInfo;
import com.baidu.tieba.recapp.async.IAdBaseAsyncController;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes5.dex */
public interface f3a {
    pm<?, ?> a(BaseFragmentActivity baseFragmentActivity, BdUniqueId bdUniqueId);

    a3a b();

    void c(AdvertAppInfo advertAppInfo, q39<?> q39Var, String str, String str2, int i, int i2);

    v2a d();

    pm<?, ?> e(e3a e3aVar, BdUniqueId bdUniqueId);

    void f();

    List<AdvertAppInfo> g();

    pm<?, ?> h(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId, String str);

    IAdBaseAsyncController i(@NonNull IAdBaseAsyncController.Type type, @Nullable IAdBaseAsyncController.a aVar);

    c3a j();

    void k(AdvertAppInfo advertAppInfo);

    void l(HashMap<String, String> hashMap, Context context);
}
