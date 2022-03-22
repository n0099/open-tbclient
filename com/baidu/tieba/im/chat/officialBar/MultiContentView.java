package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.d.f.k.b;
import c.a.p0.u1.f.j.c;
import c.a.p0.u1.l.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class MultiContentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    /* renamed from: b  reason: collision with root package name */
    public View f33684b;

    /* renamed from: c  reason: collision with root package name */
    public LinearLayout f33685c;

    /* renamed from: d  reason: collision with root package name */
    public b<MultiImageTextTopView> f33686d;

    /* renamed from: e  reason: collision with root package name */
    public b<MultiImageTextBottomView> f33687e;

    /* renamed from: f  reason: collision with root package name */
    public b<SingleImageTextView> f33688f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.d.f.h.b f33689g;

    /* renamed from: h  reason: collision with root package name */
    public int f33690h;
    public boolean i;
    public String j;
    public int k;

    /* loaded from: classes5.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiContentView a;

        public a(MultiContentView multiContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = multiContentView;
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view, view2) == null) {
            }
        }

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewRemoved(View view, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view, view2) == null) {
                if (view2 instanceof MultiImageTextTopView) {
                    this.a.f33686d.e((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    this.a.f33687e.e((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    this.a.f33688f.e((SingleImageTextView) view2);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiContentView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f33689g = null;
        this.i = true;
        this.k = 2;
        this.a = context;
        g();
    }

    private MultiImageTextBottomView getBottomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, this)) == null) {
            MultiImageTextBottomView commonBottomView = getCommonBottomView();
            if (commonBottomView == null) {
                return null;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.i) {
                skinType = 0;
            }
            int i = this.k;
            if (i == 2) {
                SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
            } else if (i == 1) {
                SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
            }
            commonBottomView.g(this.i);
            return commonBottomView;
        }
        return (MultiImageTextBottomView) invokeV.objValue;
    }

    private MultiImageTextBottomView getCommonBottomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            b<MultiImageTextBottomView> bVar = this.f33687e;
            MultiImageTextBottomView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new MultiImageTextBottomView(this.a);
            }
            b2.setOnItemViewLongClickListener(this.f33689g);
            b2.setPosition(this.f33690h);
            return b2;
        }
        return (MultiImageTextBottomView) invokeV.objValue;
    }

    private MultiImageTextBottomView getMidView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65543, this)) == null) {
            MultiImageTextBottomView commonBottomView = getCommonBottomView();
            if (commonBottomView == null) {
                return null;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.i) {
                skinType = 0;
            }
            int i = this.k;
            if (i == 2) {
                SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
            } else if (i == 1) {
                SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
            }
            commonBottomView.g(this.i);
            return commonBottomView;
        }
        return (MultiImageTextBottomView) invokeV.objValue;
    }

    private SingleImageTextView getSingleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            b<SingleImageTextView> bVar = this.f33688f;
            SingleImageTextView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() == null) {
                b2 = new SingleImageTextView(this.a);
            }
            b2.setOnItemViewLongClickListener(this.f33689g);
            b2.setPosition(this.f33690h);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.i) {
                skinType = 0;
            }
            int i = this.k;
            if (i == 2) {
                SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_single_bg, skinType);
            } else if (i == 1) {
                SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_single_bg, skinType);
            }
            b2.f(this.i);
            return b2;
        }
        return (SingleImageTextView) invokeV.objValue;
    }

    private MultiImageTextTopView getTopView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            b<MultiImageTextTopView> bVar = this.f33686d;
            MultiImageTextTopView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new MultiImageTextTopView(this.a);
            }
            b2.setOnItemViewLongClickListener(this.f33689g);
            b2.setPosition(this.f33690h);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.i) {
                skinType = 0;
            }
            int i = this.k;
            if (i == 2) {
                SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_top_bg, skinType);
            } else if (i == 1) {
                SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_top_bg, skinType);
            }
            b2.e(this.i);
            return b2;
        }
        return (MultiImageTextTopView) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f33685c.addView(view);
        }
    }

    public final void d(TbPageContext<?> tbPageContext, a.C1417a c1417a, MultiImageTextBottomView multiImageTextBottomView, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, c1417a, multiImageTextBottomView, view) == null) || c1417a == null || multiImageTextBottomView == null) {
            return;
        }
        multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f07023c)));
        multiImageTextBottomView.setData(tbPageContext, c1417a, view, this.k);
        this.f33685c.addView(multiImageTextBottomView);
    }

    public final void e(TbPageContext<?> tbPageContext, a.C1417a c1417a, SingleImageTextView singleImageTextView, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, c1417a, singleImageTextView, view) == null) || c1417a == null || singleImageTextView == null) {
            return;
        }
        singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        singleImageTextView.setTime(this.j);
        singleImageTextView.setData(tbPageContext, c1417a, view, this.k);
        this.f33685c.addView(singleImageTextView);
    }

    public final void f(TbPageContext<?> tbPageContext, a.C1417a c1417a, MultiImageTextTopView multiImageTextTopView, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, tbPageContext, c1417a, multiImageTextTopView, view) == null) || c1417a == null || multiImageTextTopView == null) {
            return;
        }
        multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        multiImageTextTopView.setTime(this.j);
        multiImageTextTopView.setData(tbPageContext, c1417a, view, this.k);
        this.f33685c.addView(multiImageTextTopView);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d0565, this);
            this.f33684b = inflate;
            this.f33685c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0923b8);
            c cVar = new c();
            this.f33686d = cVar.f(this.a);
            this.f33687e = cVar.d(this.a);
            this.f33688f = cVar.e(this.a);
            this.f33685c.setOnHierarchyChangeListener(new a(this));
        }
    }

    public void setData(TbPageContext<?> tbPageContext, List<a.C1417a> list, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, tbPageContext, list, view) == null) {
            this.f33685c.removeAllViews();
            if (list == null || list.size() == 0) {
                return;
            }
            int size = list.size();
            if (size == 1) {
                e(tbPageContext, list.get(0), getSingleView(), view);
                return;
            }
            String str = "";
            for (int i = 0; i < size; i++) {
                if (i == 0) {
                    if (list.get(i) != null) {
                        str = list.get(i).f18838f;
                    }
                    f(tbPageContext, list.get(i), getTopView(), view);
                } else if (i == size - 1) {
                    MultiImageTextBottomView bottomView = getBottomView();
                    if (bottomView != null) {
                        bottomView.setStPosition(i);
                        bottomView.setTaskInfo(str);
                    }
                    d(tbPageContext, list.get(i), bottomView, view);
                } else {
                    MultiImageTextBottomView midView = getMidView();
                    if (midView != null) {
                        midView.setStPosition(i);
                        midView.setTaskInfo(str);
                    }
                    d(tbPageContext, list.get(i), midView, view);
                }
            }
        }
    }

    public void setNeedNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.i = z;
        }
    }

    public void setOnItemViewLongClickListener(c.a.d.f.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, bVar) == null) {
            this.f33689g = bVar;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.f33690h = i;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.j = str;
        }
    }

    public void setType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048586, this, i) == null) {
            this.k = i;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MultiContentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, attributeSet};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f33689g = null;
        this.i = true;
        this.k = 2;
        this.a = context;
        g();
    }
}
