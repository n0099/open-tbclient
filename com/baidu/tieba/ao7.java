package com.baidu.tieba;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.adp.BdUniqueId;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tieba.forum.data.ForumTabItem;
import com.baidu.tieba.forum.data.SortItem;
import com.baidu.tieba.forum.data.SubTabItem;
import com.baidu.tieba.forum.viewmodel.ForumViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
/* loaded from: classes5.dex */
public final class ao7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static final ul7 a(FragmentActivity activity, Bundle bundle, BdUniqueId bdUniqueId, zl7 resultCallback) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65536, null, activity, bundle, bdUniqueId, resultCallback)) == null) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(bdUniqueId, "bdUniqueId");
            Intrinsics.checkNotNullParameter(resultCallback, "resultCallback");
            ul7 tl7Var = new tl7();
            ForumTabItem forumTabItem = (ForumTabItem) bundle.getParcelable("forum_tab_info");
            if (forumTabItem == null) {
                return tl7Var;
            }
            si7 si7Var = null;
            if (bundle.getBoolean("forum_tab_current_list", false)) {
                si7Var = ((ForumViewModel) new ViewModelProvider(activity).get(ForumViewModel.class)).a().getValue();
            }
            int netType = forumTabItem.getNetType();
            int i = -1;
            if (netType != 1) {
                if (netType != 2) {
                    if (netType != 3) {
                        ho7.a("Unknown netType!!!");
                    } else {
                        tl7Var = new sl7(new cm7(activity, bdUniqueId, bundle), resultCallback);
                    }
                } else {
                    tl7Var = new sl7(new dm7(activity, bdUniqueId, bundle), resultCallback);
                }
            } else {
                i = SharedPrefHelper.getInstance().getInt("key_forum_last_sort_type", -1);
                tl7Var = new sl7(new em7(activity, bdUniqueId, bundle), resultCallback);
            }
            tl7Var.c(new wl7(b(forumTabItem, i), si7Var));
            return tl7Var;
        }
        return (ul7) invokeLLLL.objValue;
    }

    public static final vl7 b(ForumTabItem forumTabItem, int i) {
        InterceptResult invokeLI;
        boolean z;
        bm7 bm7Var;
        boolean z2;
        int size;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65537, null, forumTabItem, i)) == null) {
            List<SubTabItem> subTabList = forumTabItem.getSubTabList();
            int i2 = 0;
            if (subTabList != null && !subTabList.isEmpty()) {
                z = false;
            } else {
                z = true;
            }
            am7 am7Var = null;
            if (!z && forumTabItem.getSubTabList().size() > 1) {
                bm7Var = new bm7(forumTabItem.getSubTabList(), 0);
            } else {
                bm7Var = null;
            }
            List<SortItem> sortItemList = forumTabItem.getSortItemList();
            if (sortItemList != null && !sortItemList.isEmpty()) {
                z2 = false;
            } else {
                z2 = true;
            }
            if (!z2 && forumTabItem.getSortItemList().size() > 1) {
                if (i != -1 && (size = forumTabItem.getSortItemList().size()) >= 0) {
                    int i3 = 0;
                    while (true) {
                        if (forumTabItem.getSortItemList().get(i3).getId() == i) {
                            i2 = i3;
                            break;
                        } else if (i3 == size) {
                            break;
                        } else {
                            i3++;
                        }
                    }
                }
                am7Var = new am7(forumTabItem.getSortItemList(), i2);
            }
            return new vl7(bm7Var, am7Var);
        }
        return (vl7) invokeLI.objValue;
    }
}
