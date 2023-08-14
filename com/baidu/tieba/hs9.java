package com.baidu.tieba;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.viewpager.widget.PagerAdapter;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.DeviceInfoHelper;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.widget.viewpager.ListViewPager;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumCardView;
import com.baidu.tieba.personPolymeric.view.PersonCommonForumItemView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes6.dex */
public class hs9 extends em6<fr9> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> i;
    public int j;
    public fr9 k;
    public b l;
    public ag<PersonCommonForumItemView> m;
    public TextView n;
    public ListViewPager o;

    /* loaded from: classes6.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    @Override // com.baidu.tieba.em6
    public int d() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) ? R.layout.obfuscated_res_0x7f0d07dc : invokeV.intValue;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class b extends PagerAdapter {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hs9 a;

        @Override // androidx.viewpager.widget.PagerAdapter
        public boolean isViewFromObject(View view2, Object obj) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, view2, obj)) == null) ? view2 == obj : invokeLL.booleanValue;
        }

        public b(hs9 hs9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hs9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hs9Var;
        }

        public /* synthetic */ b(hs9 hs9Var, a aVar) {
            this(hs9Var);
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public void destroyItem(ViewGroup viewGroup, int i, Object obj) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeLIL(1048576, this, viewGroup, i, obj) == null) && (obj instanceof PersonCommonForumCardView)) {
                PersonCommonForumCardView personCommonForumCardView = (PersonCommonForumCardView) obj;
                personCommonForumCardView.k();
                viewGroup.removeView(personCommonForumCardView);
            }
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public int getCount() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                if (this.a.k != null && !ListUtils.isEmpty(this.a.k.a)) {
                    if (this.a.k.a.size() % 4 == 0) {
                        return this.a.k.a.size() / 4;
                    }
                    return (this.a.k.a.size() / 4) + 1;
                }
                return 0;
            }
            return invokeV.intValue;
        }

        @Override // androidx.viewpager.widget.PagerAdapter
        public Object instantiateItem(ViewGroup viewGroup, int i) {
            InterceptResult invokeLI;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLI = interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, viewGroup, i)) == null) {
                List<ir9> x = this.a.x(i);
                if (!ListUtils.isEmpty(x)) {
                    PersonCommonForumCardView personCommonForumCardView = new PersonCommonForumCardView(this.a.i.getPageActivity());
                    personCommonForumCardView.setForumItemViewBdObjectPool(this.a.m);
                    personCommonForumCardView.setData(x);
                    personCommonForumCardView.setVerticalSpacing(TbadkCoreApplication.getInst().getContext().getResources().getDimensionPixelSize(R.dimen.tbds42));
                    viewGroup.addView(personCommonForumCardView);
                    return personCommonForumCardView;
                }
                return null;
            }
            return invokeLI.objValue;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hs9(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((TbPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = 3;
        this.l = new b(this, null);
        this.i = tbPageContext;
        View h = h();
        this.n = (TextView) h.findViewById(R.id.obfuscated_res_0x7f09077d);
        this.o = (ListViewPager) h.findViewById(R.id.obfuscated_res_0x7f09077e);
        if ("NX40X".equals(DeviceInfoHelper.getModel())) {
            h.setLayerType(2, null);
            if (h instanceof ViewGroup) {
                ((ViewGroup) h).setClipChildren(true);
            }
        }
        this.o.setOffscreenPageLimit(1);
    }

    public final boolean y(fr9 fr9Var) {
        InterceptResult invokeL;
        fr9 fr9Var2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048582, this, fr9Var)) == null) {
            if (fr9Var == null || ListUtils.isEmpty(fr9Var.a) || fr9Var == (fr9Var2 = this.k)) {
                return false;
            }
            if (fr9Var2 == null || ListUtils.isEmpty(fr9Var2.a)) {
                return true;
            }
            if (!ListUtils.isEmpty(fr9Var.a)) {
                if (fr9Var.a.size() != this.k.a.size()) {
                    return true;
                }
                for (int i = 0; i < fr9Var.a.size(); i++) {
                    if (this.k.a.get(i) == null || fr9Var.a.get(i).a != this.k.a.get(i).a) {
                        return true;
                    }
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public void A(ag<PersonCommonForumItemView> agVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, agVar) == null) {
            this.m = agVar;
        }
    }

    @Override // com.baidu.tieba.em6
    public void j(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(1048579, this, tbPageContext, i) == null) {
            if (this.j != i) {
                SkinManager.setBackgroundResource(h(), R.color.CAM_X0201);
                SkinManager.setViewTextColor(this.n, (int) R.color.CAM_X0109);
                int childCount = this.o.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = this.o.getChildAt(i2);
                    if (childAt instanceof PersonCommonForumCardView) {
                        ((PersonCommonForumCardView) childAt).j();
                    }
                }
            }
            this.j = i;
        }
    }

    public final List<ir9> x(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            fr9 fr9Var = this.k;
            if (fr9Var != null && !ListUtils.isEmpty(fr9Var.a)) {
                ArrayList arrayList = new ArrayList();
                int i2 = i * 4;
                for (int i3 = i2; i3 < i2 + 4; i3++) {
                    ir9 ir9Var = (ir9) ListUtils.getItem(this.k.a, i3);
                    if (ir9Var != null) {
                        arrayList.add(ir9Var);
                    }
                }
                return arrayList;
            }
            return null;
        }
        return (List) invokeI.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.em6
    /* renamed from: z */
    public void i(fr9 fr9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, fr9Var) == null) {
            if (y(fr9Var)) {
                this.k = fr9Var;
                if (ListUtils.getCount(fr9Var.a) <= 2) {
                    this.o.getLayoutParams().height = BdUtilHelper.getDimens(this.i.getPageActivity(), R.dimen.obfuscated_res_0x7f07036f);
                }
                this.o.setAdapter(this.l);
            }
            j(this.i, TbadkCoreApplication.getInst().getSkinType());
        }
    }
}
