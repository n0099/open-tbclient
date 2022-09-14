package com.baidu.tieba;

import android.util.LongSparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import androidx.annotation.RequiresApi;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.widget.ListView.BdTypeListView;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ca7;
import com.baidu.tieba.im.chat.MsgCommonItemAdapter;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedActivity;
import com.baidu.tieba.im.chat.officialBar.OfficialBarFeedMsglistAdapter;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes4.dex */
public class g87 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<OfficialBarFeedActivity> a;
    public List<da7> b;
    public LongSparseArray<q97> c;
    public OfficialBarFeedMsglistAdapter.c d;
    public BdTypeListView e;
    public boolean f;

    /* loaded from: classes4.dex */
    public class a extends MsgCommonItemAdapter.MsgViewHolder<d87> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(g87 g87Var, View view2, d87 d87Var) {
            super(view2, d87Var);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {g87Var, view2, d87Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super((View) objArr2[0], objArr2[1]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
        }
    }

    public g87(TbPageContext<OfficialBarFeedActivity> tbPageContext, BdTypeListView bdTypeListView, OfficialBarFeedMsglistAdapter.c cVar) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdTypeListView, cVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = null;
        this.c = null;
        this.a = tbPageContext;
        this.d = cVar;
        this.e = bdTypeListView;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: a */
    public da7 getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            List<da7> list = this.b;
            if (list == null || list.size() == 0 || i < 0 || i >= getCount()) {
                return null;
            }
            return this.b.get(i);
        }
        return (da7) invokeI.objValue;
    }

    public final View b(int i, View view2, ViewGroup viewGroup, da7 da7Var, MsgCommonItemAdapter.MsgViewHolder<d87> msgViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, da7Var, msgViewHolder})) == null) {
            d87 a2 = msgViewHolder.a();
            ca7.a d = da7Var.d();
            d.m = da7Var.b();
            LongSparseArray<q97> longSparseArray = this.c;
            a2.p(this.a.getPageActivity().getBaseContext(), d, da7Var.c(), longSparseArray == null ? null : longSparseArray.get(d.h), da7Var.e(), da7Var.f(), i);
            StatisticItem statisticItem = new StatisticItem(this.f ? "c13865" : "c13863");
            statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
            String str = d.n;
            if (str == null) {
                str = "";
            }
            statisticItem.param("tid", str);
            statisticItem.param("fid", d.e);
            TiebaStatic.log(statisticItem);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public void c(List<da7> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list) == null) {
            if (this.b == null) {
                this.b = new LinkedList();
            }
            this.b.clear();
            this.b.addAll(list);
            notifyDataSetChanged();
        }
    }

    public void d(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048579, this, z) == null) {
            this.f = z;
        }
    }

    @RequiresApi(api = 16)
    public void e(LongSparseArray<q97> longSparseArray) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, longSparseArray) == null) {
            if (this.c == null) {
                this.c = new LongSparseArray<>();
            }
            this.c.clear();
            for (int i = 0; i < longSparseArray.size(); i++) {
                this.c.put(longSparseArray.keyAt(i), longSparseArray.valueAt(i));
            }
            notifyDataSetChanged();
        }
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            List<da7> list = this.b;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeI = interceptable.invokeI(1048583, this, i)) == null) ? i : invokeI.longValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        a aVar;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(InputDeviceCompat.SOURCE_TOUCHPAD, this, i, view2, viewGroup)) == null) {
            a aVar2 = view2 != null ? (a) view2.getTag() : null;
            if (aVar2 == null) {
                d87 d87Var = new d87(this.a, this.f);
                d87Var.q(this.d);
                View k = d87Var.k();
                a aVar3 = new a(this, d87Var.k(), d87Var);
                k.setTag(aVar3);
                view2 = k;
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            b(i, view2, viewGroup, getItem(i), aVar);
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
