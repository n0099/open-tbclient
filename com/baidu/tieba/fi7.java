package com.baidu.tieba;

import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.pageStayDuration.PageStayDurationItem;
import com.baidu.tieba.forum.databinding.ActivityForumBinding;
import com.baidu.tieba.forum.viewmodel.BottomViewModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import kotlin.jvm.internal.Intrinsics;
import tbclient.FrsPage.ForumInfo;
/* loaded from: classes5.dex */
public final class fi7 extends sh7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final FragmentActivity b;

    public fi7(FragmentActivity activity) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {activity};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(activity, "activity");
        this.b = activity;
    }

    public static final void p(fi7 this$0, ki7 ki7Var) {
        String str;
        ForumInfo d;
        Long l;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(65537, null, this$0, ki7Var) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentActivity fragmentActivity = this$0.b;
            if (fragmentActivity instanceof BaseFragmentActivity) {
                PageStayDurationItem pageStayDurationItem = ((BaseFragmentActivity) fragmentActivity).getPageStayDurationItem();
                if (ki7Var != null && (d = ki7Var.d()) != null && (l = d.id) != null) {
                    pageStayDurationItem.setFid(l.longValue());
                }
                x75 adAdSense = TbadkCoreApplication.getInst().getAdAdSense();
                if (adAdSense != null) {
                    str = adAdSense.k;
                } else {
                    str = null;
                }
                pageStayDurationItem.setAbTag(str);
            }
        }
    }

    @Override // com.baidu.tieba.sh7
    public void k(Bundle bundle, ActivityForumBinding binding) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, bundle, binding) == null) {
            Intrinsics.checkNotNullParameter(binding, "binding");
            super.k(bundle, binding);
            ((BottomViewModel) new ViewModelProvider(this.b).get(BottomViewModel.class)).a().observe(this.b, new Observer() { // from class: com.baidu.tieba.cg7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // androidx.lifecycle.Observer
                public final void onChanged(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        fi7.p(fi7.this, (ki7) obj);
                    }
                }
            });
        }
    }
}
