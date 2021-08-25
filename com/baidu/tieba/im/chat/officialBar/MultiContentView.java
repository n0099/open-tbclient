package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import c.a.e.e.k.b;
import c.a.q0.j1.f.j.c;
import c.a.q0.j1.l.c.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.mobads.container.util.AdIconUtil;
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
/* loaded from: classes7.dex */
public class MultiContentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int TYPE_HISTORY = 2;
    public static final int TYPE_MSG = 1;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public Context f52761e;

    /* renamed from: f  reason: collision with root package name */
    public View f52762f;

    /* renamed from: g  reason: collision with root package name */
    public LinearLayout f52763g;

    /* renamed from: h  reason: collision with root package name */
    public b<MultiImageTextTopView> f52764h;

    /* renamed from: i  reason: collision with root package name */
    public b<MultiImageTextBottomView> f52765i;

    /* renamed from: j  reason: collision with root package name */
    public b<SingleImageTextView> f52766j;
    public c.a.e.e.h.b k;
    public int l;
    public boolean m;
    public String n;
    public int o;

    /* loaded from: classes7.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: e  reason: collision with root package name */
        public final /* synthetic */ MultiContentView f52767e;

        public a(MultiContentView multiContentView) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {multiContentView};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f52767e = multiContentView;
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
                    this.f52767e.f52764h.e((MultiImageTextTopView) view2);
                } else if (view2 instanceof MultiImageTextBottomView) {
                    this.f52767e.f52765i.e((MultiImageTextBottomView) view2);
                } else if (view2 instanceof SingleImageTextView) {
                    this.f52767e.f52766j.e((SingleImageTextView) view2);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.k = null;
        this.m = true;
        this.o = 2;
        this.f52761e = context;
        g();
    }

    private MultiImageTextBottomView getBottomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.AD_TEXT_ID, this)) == null) {
            MultiImageTextBottomView commonBottomView = getCommonBottomView();
            if (commonBottomView == null) {
                return null;
            }
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.m) {
                skinType = 0;
            }
            int i2 = this.o;
            if (i2 == 2) {
                SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
            } else if (i2 == 1) {
                SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_bottom_bg, skinType);
            }
            commonBottomView.onSkinChange(this.m);
            return commonBottomView;
        }
        return (MultiImageTextBottomView) invokeV.objValue;
    }

    private MultiImageTextBottomView getCommonBottomView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(AdIconUtil.BAIDU_LOGO_ID, this)) == null) {
            b<MultiImageTextBottomView> bVar = this.f52765i;
            MultiImageTextBottomView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new MultiImageTextBottomView(this.f52761e);
            }
            b2.setOnItemViewLongClickListener(this.k);
            b2.setPosition(this.l);
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
            if (!this.m) {
                skinType = 0;
            }
            int i2 = this.o;
            if (i2 == 2) {
                SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
            } else if (i2 == 1) {
                SkinManager.setBackgroundResource(commonBottomView, R.drawable.selector_history_multi_mid_bg, skinType);
            }
            commonBottomView.onSkinChange(this.m);
            return commonBottomView;
        }
        return (MultiImageTextBottomView) invokeV.objValue;
    }

    private SingleImageTextView getSingleView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            b<SingleImageTextView> bVar = this.f52766j;
            SingleImageTextView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() == null) {
                b2 = new SingleImageTextView(this.f52761e);
            }
            b2.setOnItemViewLongClickListener(this.k);
            b2.setPosition(this.l);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.m) {
                skinType = 0;
            }
            int i2 = this.o;
            if (i2 == 2) {
                SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_single_bg, skinType);
            } else if (i2 == 1) {
                SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_single_bg, skinType);
            }
            b2.onSkinChange(this.m);
            return b2;
        }
        return (SingleImageTextView) invokeV.objValue;
    }

    private MultiImageTextTopView getTopView() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            b<MultiImageTextTopView> bVar = this.f52764h;
            MultiImageTextTopView b2 = bVar != null ? bVar.b() : null;
            if (b2 == null || b2.getParent() != null) {
                b2 = new MultiImageTextTopView(this.f52761e);
            }
            b2.setOnItemViewLongClickListener(this.k);
            b2.setPosition(this.l);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.m) {
                skinType = 0;
            }
            int i2 = this.o;
            if (i2 == 2) {
                SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_top_bg, skinType);
            } else if (i2 == 1) {
                SkinManager.setBackgroundResource(b2, R.drawable.selector_history_multi_top_bg, skinType);
            }
            b2.onSkinChange(this.m);
            return b2;
        }
        return (MultiImageTextTopView) invokeV.objValue;
    }

    @Override // android.view.ViewGroup
    public void addView(View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view) == null) {
            this.f52763g.addView(view);
        }
    }

    public final void d(TbPageContext<?> tbPageContext, a.C0970a c0970a, MultiImageTextBottomView multiImageTextBottomView, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, c0970a, multiImageTextBottomView, view) == null) || c0970a == null || multiImageTextBottomView == null) {
            return;
        }
        multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.f52761e.getResources().getDimension(R.dimen.ds132)));
        multiImageTextBottomView.setData(tbPageContext, c0970a, view, this.o);
        this.f52763g.addView(multiImageTextBottomView);
    }

    public final void e(TbPageContext<?> tbPageContext, a.C0970a c0970a, SingleImageTextView singleImageTextView, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, c0970a, singleImageTextView, view) == null) || c0970a == null || singleImageTextView == null) {
            return;
        }
        singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        singleImageTextView.setTime(this.n);
        singleImageTextView.setData(tbPageContext, c0970a, view, this.o);
        this.f52763g.addView(singleImageTextView);
    }

    public final void f(TbPageContext<?> tbPageContext, a.C0970a c0970a, MultiImageTextTopView multiImageTextTopView, View view) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048579, this, tbPageContext, c0970a, multiImageTextTopView, view) == null) || c0970a == null || multiImageTextTopView == null) {
            return;
        }
        multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
        multiImageTextTopView.setTime(this.n);
        multiImageTextTopView.setData(tbPageContext, c0970a, view, this.o);
        this.f52763g.addView(multiImageTextTopView);
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = View.inflate(this.f52761e, R.layout.msg_multi_pic_text_content_view, this);
            this.f52762f = inflate;
            this.f52763g = (LinearLayout) inflate.findViewById(R.id.view_container);
            c cVar = new c();
            this.f52764h = cVar.f(this.f52761e);
            this.f52765i = cVar.d(this.f52761e);
            this.f52766j = cVar.e(this.f52761e);
            this.f52763g.setOnHierarchyChangeListener(new a(this));
        }
    }

    public void reset() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            this.f52763g.removeAllViews();
        }
    }

    public void setData(TbPageContext<?> tbPageContext, List<a.C0970a> list, View view) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, tbPageContext, list, view) == null) {
            this.f52763g.removeAllViews();
            if (list == null || list.size() == 0) {
                return;
            }
            int size = list.size();
            if (size == 1) {
                e(tbPageContext, list.get(0), getSingleView(), view);
                return;
            }
            String str = "";
            for (int i2 = 0; i2 < size; i2++) {
                if (i2 == 0) {
                    if (list.get(i2) != null) {
                        str = list.get(i2).f20913f;
                    }
                    f(tbPageContext, list.get(i2), getTopView(), view);
                } else if (i2 == size - 1) {
                    MultiImageTextBottomView bottomView = getBottomView();
                    if (bottomView != null) {
                        bottomView.setStPosition(i2);
                        bottomView.setTaskInfo(str);
                    }
                    d(tbPageContext, list.get(i2), bottomView, view);
                } else {
                    MultiImageTextBottomView midView = getMidView();
                    if (midView != null) {
                        midView.setStPosition(i2);
                        midView.setTaskInfo(str);
                    }
                    d(tbPageContext, list.get(i2), midView, view);
                }
            }
        }
    }

    public void setNeedNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048583, this, z) == null) {
            this.m = z;
        }
    }

    public void setOnItemViewLongClickListener(c.a.e.e.h.b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.k = bVar;
        }
    }

    public void setPosition(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048585, this, i2) == null) {
            this.l = i2;
        }
    }

    public void setTime(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, str) == null) {
            this.n = str;
        }
    }

    public void setType(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048587, this, i2) == null) {
            this.o = i2;
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (AttributeSet) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.k = null;
        this.m = true;
        this.o = 2;
        this.f52761e = context;
        g();
    }
}
