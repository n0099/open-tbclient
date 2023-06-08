package com.baidu.tieba.im.chat.officialBar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.R;
import com.baidu.tieba.f98;
import com.baidu.tieba.i78;
import com.baidu.tieba.kg;
import com.baidu.tieba.of;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class MultiContentView extends LinearLayout {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public LinearLayout c;
    public kg<MultiImageTextTopView> d;
    public kg<MultiImageTextBottomView> e;
    public kg<SingleImageTextView> f;
    public of g;
    public int h;
    public boolean i;
    public String j;
    public int k;

    /* loaded from: classes6.dex */
    public class a implements ViewGroup.OnHierarchyChangeListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MultiContentView a;

        @Override // android.view.ViewGroup.OnHierarchyChangeListener
        public void onChildViewAdded(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(1048576, this, view2, view3) == null) {
            }
        }

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
        public void onChildViewRemoved(View view2, View view3) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, view2, view3) == null) {
                if (view3 instanceof MultiImageTextTopView) {
                    this.a.d.e((MultiImageTextTopView) view3);
                } else if (view3 instanceof MultiImageTextBottomView) {
                    this.a.e.e((MultiImageTextBottomView) view3);
                } else if (view3 instanceof SingleImageTextView) {
                    this.a.f.e((SingleImageTextView) view3);
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
        this.g = null;
        this.i = true;
        this.k = 2;
        this.a = context;
        g();
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
        this.g = null;
        this.i = true;
        this.k = 2;
        this.a = context;
        g();
    }

    @Override // android.view.ViewGroup
    public void addView(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
            this.c.addView(view2);
        }
    }

    public void setNeedNightMode(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.i = z;
        }
    }

    public void setOnItemViewLongClickListener(of ofVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, ofVar) == null) {
            this.g = ofVar;
        }
    }

    public void setPosition(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) {
            this.h = i;
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
        MultiImageTextBottomView multiImageTextBottomView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65542, this)) == null) {
            kg<MultiImageTextBottomView> kgVar = this.e;
            if (kgVar != null) {
                multiImageTextBottomView = kgVar.b();
            } else {
                multiImageTextBottomView = null;
            }
            if (multiImageTextBottomView == null || multiImageTextBottomView.getParent() != null) {
                multiImageTextBottomView = new MultiImageTextBottomView(this.a);
            }
            multiImageTextBottomView.setOnItemViewLongClickListener(this.g);
            multiImageTextBottomView.setPosition(this.h);
            return multiImageTextBottomView;
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
        SingleImageTextView singleImageTextView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65544, this)) == null) {
            kg<SingleImageTextView> kgVar = this.f;
            if (kgVar != null) {
                singleImageTextView = kgVar.b();
            } else {
                singleImageTextView = null;
            }
            if (singleImageTextView == null || singleImageTextView.getParent() == null) {
                singleImageTextView = new SingleImageTextView(this.a);
            }
            singleImageTextView.setOnItemViewLongClickListener(this.g);
            singleImageTextView.setPosition(this.h);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.i) {
                skinType = 0;
            }
            int i = this.k;
            if (i == 2) {
                SkinManager.setBackgroundResource(singleImageTextView, R.drawable.selector_history_multi_single_bg, skinType);
            } else if (i == 1) {
                SkinManager.setBackgroundResource(singleImageTextView, R.drawable.selector_history_multi_single_bg, skinType);
            }
            singleImageTextView.j(this.i);
            return singleImageTextView;
        }
        return (SingleImageTextView) invokeV.objValue;
    }

    private MultiImageTextTopView getTopView() {
        InterceptResult invokeV;
        MultiImageTextTopView multiImageTextTopView;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65545, this)) == null) {
            kg<MultiImageTextTopView> kgVar = this.d;
            if (kgVar != null) {
                multiImageTextTopView = kgVar.b();
            } else {
                multiImageTextTopView = null;
            }
            if (multiImageTextTopView == null || multiImageTextTopView.getParent() != null) {
                multiImageTextTopView = new MultiImageTextTopView(this.a);
            }
            multiImageTextTopView.setOnItemViewLongClickListener(this.g);
            multiImageTextTopView.setPosition(this.h);
            int skinType = TbadkCoreApplication.getInst().getSkinType();
            if (!this.i) {
                skinType = 0;
            }
            int i = this.k;
            if (i == 2) {
                SkinManager.setBackgroundResource(multiImageTextTopView, R.drawable.selector_history_multi_top_bg, skinType);
            } else if (i == 1) {
                SkinManager.setBackgroundResource(multiImageTextTopView, R.drawable.selector_history_multi_top_bg, skinType);
            }
            multiImageTextTopView.e(this.i);
            return multiImageTextTopView;
        }
        return (MultiImageTextTopView) invokeV.objValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            View inflate = View.inflate(this.a, R.layout.obfuscated_res_0x7f0d061b, this);
            this.b = inflate;
            this.c = (LinearLayout) inflate.findViewById(R.id.obfuscated_res_0x7f092874);
            i78 i78Var = new i78();
            this.d = i78Var.f(this.a);
            this.e = i78Var.d(this.a);
            this.f = i78Var.e(this.a);
            this.c.setOnHierarchyChangeListener(new a(this));
        }
    }

    public final void d(TbPageContext<?> tbPageContext, f98.a aVar, MultiImageTextBottomView multiImageTextBottomView, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, aVar, multiImageTextBottomView, view2) == null) && aVar != null && multiImageTextBottomView != null) {
            multiImageTextBottomView.setLayoutParams(new LinearLayout.LayoutParams(-1, (int) this.a.getResources().getDimension(R.dimen.obfuscated_res_0x7f070365)));
            multiImageTextBottomView.setData(tbPageContext, aVar, view2, this.k);
            this.c.addView(multiImageTextBottomView);
        }
    }

    public final void e(TbPageContext<?> tbPageContext, f98.a aVar, SingleImageTextView singleImageTextView, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext, aVar, singleImageTextView, view2) == null) && aVar != null && singleImageTextView != null) {
            singleImageTextView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            singleImageTextView.setTime(this.j);
            singleImageTextView.setData(tbPageContext, aVar, view2, this.k);
            this.c.addView(singleImageTextView);
        }
    }

    public final void f(TbPageContext<?> tbPageContext, f98.a aVar, MultiImageTextTopView multiImageTextTopView, View view2) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLLLL(1048579, this, tbPageContext, aVar, multiImageTextTopView, view2) == null) && aVar != null && multiImageTextTopView != null) {
            multiImageTextTopView.setLayoutParams(new LinearLayout.LayoutParams(-1, -2));
            multiImageTextTopView.setTime(this.j);
            multiImageTextTopView.setData(tbPageContext, aVar, view2, this.k);
            this.c.addView(multiImageTextTopView);
        }
    }

    public void setData(TbPageContext<?> tbPageContext, List<f98.a> list, View view2, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLI(1048581, this, tbPageContext, list, view2, i) == null) {
            this.c.removeAllViews();
            if (list != null && list.size() != 0) {
                int size = list.size();
                if (size == 1) {
                    SingleImageTextView singleView = getSingleView();
                    f98.a aVar = list.get(0);
                    aVar.o = i;
                    e(tbPageContext, aVar, singleView, view2);
                    return;
                }
                String str = "";
                for (int i2 = 0; i2 < size; i2++) {
                    if (i2 == 0) {
                        if (list.get(i2) != null) {
                            str = list.get(i2).f;
                        }
                        f(tbPageContext, list.get(i2), getTopView(), view2);
                    } else if (i2 == size - 1) {
                        MultiImageTextBottomView bottomView = getBottomView();
                        if (bottomView != null) {
                            bottomView.setStPosition(i2);
                            bottomView.setTaskInfo(str);
                        }
                        d(tbPageContext, list.get(i2), bottomView, view2);
                    } else {
                        MultiImageTextBottomView midView = getMidView();
                        if (midView != null) {
                            midView.setStPosition(i2);
                            midView.setTaskInfo(str);
                        }
                        d(tbPageContext, list.get(i2), midView, view2);
                    }
                }
            }
        }
    }
}
