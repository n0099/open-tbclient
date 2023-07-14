package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.core.view.InputDeviceCompat;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.GameData;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tieba.attention.AttentionView;
import com.baidu.tieba.lately.LatelyView;
import com.baidu.tieba.related.GameRelatedForumsView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes5.dex */
public class SelectForumPagerAdapter extends PagerAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<SelectForumActivity> a;
    public List<a56> b;
    public int c;

    @Override // androidx.viewpager.widget.PagerAdapter
    public boolean isViewFromObject(@NonNull View view2, @NonNull Object obj) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeLL = interceptable.invokeLL(1048582, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
    }

    public SelectForumPagerAdapter(TbPageContext tbPageContext) {
        GameData gameData;
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.c = -1;
        this.a = tbPageContext;
        this.b = new ArrayList();
        if (tbPageContext.getPageActivity() instanceof y46) {
            gameData = ((y46) tbPageContext.getPageActivity()).h1();
        } else {
            gameData = null;
        }
        if (gameData != null) {
            this.b.add(new GameRelatedForumsView(this.a.getPageActivity()));
            return;
        }
        this.b.add(new LatelyView(this.a.getPageActivity()));
        this.b.add(new AttentionView(this.a.getPageActivity()));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // androidx.viewpager.widget.PagerAdapter
    @NonNull
    /* renamed from: b */
    public a56 instantiateItem(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            a56 a56Var = (a56) ListUtils.getItem(this.b, i);
            if (a56Var instanceof View) {
                View view2 = (View) a56Var;
                if (view2.getParent() != null) {
                    viewGroup.removeView(view2);
                }
                viewGroup.addView(view2);
            }
            return a56Var;
        }
        return (a56) invokeLI.objValue;
    }

    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            for (a56 a56Var : this.b) {
                a56Var.a();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return ListUtils.getCount(this.b);
        }
        return invokeV.intValue;
    }

    public void onDestroy() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            for (a56 a56Var : this.b) {
                a56Var.onDestroy();
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void destroyItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i, obj) == null) {
            super.destroyItem(viewGroup, i, obj);
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public void setPrimaryItem(@NonNull ViewGroup viewGroup, int i, @NonNull Object obj) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup, i, obj) == null) {
            super.setPrimaryItem(viewGroup, i, obj);
            if (this.c == i) {
                return;
            }
            this.c = i;
            a56 a56Var = (a56) ListUtils.getItem(this.b, i);
            if (a56Var != null) {
                a56Var.c(null);
            }
        }
    }

    @Override // androidx.viewpager.widget.PagerAdapter
    public CharSequence getPageTitle(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048580, this, i)) == null) {
            if (ListUtils.getItem(this.b, i) == null) {
                return "";
            }
            return ((a56) ListUtils.getItem(this.b, i)).getTitle();
        }
        return (CharSequence) invokeI.objValue;
    }
}
