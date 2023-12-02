package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.frs.FrsSchoolRecommendItemView;
import com.baidu.tieba.horizonalList.widget.HListView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes5.dex */
public class a88 extends ol6<us7> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public HListView t;
    public ml8 u;
    public FrsSchoolRecommendItemView v;
    public List<nl8> w;
    public View.OnClickListener x;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ a88 a;

        public a(a88 a88Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {a88Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = a88Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && this.a.f() != null) {
                this.a.f().a(view2, null);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public a88(TbPageContext tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
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
        this.x = new a(this);
        HListView hListView = new HListView(c());
        this.t = hListView;
        hListView.setHeaderDividersEnabled(false);
        this.t.setFooterDividersEnabled(false);
        this.t.setSelector(R.drawable.list_selector_transparent);
        this.v = new FrsSchoolRecommendItemView(LayoutInflater.from(tbPageContext.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d03be, (ViewGroup) null), tbPageContext, bdUniqueId);
        ml8 ml8Var = new ml8(c(), R.layout.obfuscated_res_0x7f0d03be, this.v);
        this.u = ml8Var;
        ml8Var.d(this.x);
        this.t.setAdapter((ListAdapter) this.u);
        this.q.addView(this.t);
        this.p.setVisibility(8);
        this.j.setTextSize(0, BdUtilHelper.getDimens(tbPageContext.getPageActivity(), R.dimen.obfuscated_res_0x7f0701f9));
    }

    @Override // com.baidu.tieba.ol6, com.baidu.tieba.nl6
    public void k(TbPageContext<?> tbPageContext, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext, i) == null) {
            super.k(tbPageContext, i);
            if (this.t != null && this.u != null) {
                SkinManager.setViewTextColor(this.j, (int) R.color.CAM_X0109);
                this.u.b(i);
            }
        }
    }

    public final boolean y(List<nl8> list) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, list)) == null) {
            if (ListUtils.isEmpty(list)) {
                return false;
            }
            if (ListUtils.isEmpty(this.w) || ListUtils.getCount(this.w) != ListUtils.getCount(list)) {
                return true;
            }
            for (int i = 0; i < ListUtils.getCount(this.w); i++) {
                nl8 nl8Var = (nl8) ListUtils.getItem(this.w, i);
                nl8 nl8Var2 = (nl8) ListUtils.getItem(list, i);
                if ((nl8Var instanceof bu7) && (nl8Var2 instanceof bu7) && !((bu7) nl8Var).a.getUserId().equals(((bu7) nl8Var2).a.getUserId())) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.nl6
    /* renamed from: z */
    public void j(us7 us7Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, us7Var) == null) {
            super.s(us7Var);
            if (us7Var != null && !ListUtils.isEmpty(us7Var.getDataList())) {
                if (StringUtils.isNull(us7Var.mGroupTitle)) {
                    this.j.setText(c().getResources().getString(R.string.school_recommend));
                } else {
                    this.j.setText(us7Var.mGroupTitle);
                }
                if (y(us7Var.getDataList())) {
                    List<nl8> dataList = us7Var.getDataList();
                    this.w = dataList;
                    this.u.c(dataList);
                    this.u.notifyDataSetChanged();
                }
            }
        }
    }
}
