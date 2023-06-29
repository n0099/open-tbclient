package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.tbselector.TBSelector;
import com.baidu.tieba.newinterest.viewholder.InterestedForumStyleAForumViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e69 extends kn<n69, InterestedForumStyleAForumViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public v69 a;

    /* loaded from: classes5.dex */
    public class a implements ho {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e69 a;

        public a(e69 e69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e69Var;
        }

        @Override // com.baidu.tieba.ho
        public void b(View view2, xn xnVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, xnVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(xnVar instanceof n69)) {
                return;
            }
            n69 n69Var = (n69) xnVar;
            n69Var.q(!n69Var.i());
            InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder = (InterestedForumStyleAForumViewHolder) view2.getTag();
            if (interestedForumStyleAForumViewHolder != null) {
                this.a.D(interestedForumStyleAForumViewHolder.h, n69Var.i());
            }
            if (this.a.a != null) {
                this.a.a.a();
            }
            if (!n69Var.i()) {
                return;
            }
            this.a.x(n69Var);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e69(Context context, BdUniqueId bdUniqueId) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.mContext = context;
        this.mType = bdUniqueId;
        setOnAdapterItemClickListener(new a(this));
    }

    public void B(v69 v69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, v69Var) == null) {
            this.a = v69Var;
        }
    }

    public final void x(n69 n69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, n69Var) == null) {
            StatisticItem statisticItem = new StatisticItem("c13682");
            statisticItem.param("obj_type", 2);
            statisticItem.param("obj_locate", 4);
            statisticItem.param("fid", n69Var.c());
            TiebaStatic.log(statisticItem);
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.kn
    /* renamed from: y */
    public InterestedForumStyleAForumViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, viewGroup)) == null) {
            return new InterestedForumStyleAForumViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0454, viewGroup, false));
        }
        return (InterestedForumStyleAForumViewHolder) invokeL.objValue;
    }

    public final void D(ImageView imageView, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048579, this, imageView, z) == null) {
            if (z) {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_checked);
            } else {
                SkinManager.setImageResource(imageView, R.drawable.icon_interest_unchecked);
            }
        }
    }

    public final void A(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder, n69 n69Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, interestedForumStyleAForumViewHolder, n69Var) == null) {
            interestedForumStyleAForumViewHolder.b.setShowOval(true);
            interestedForumStyleAForumViewHolder.b.setAutoChangeStyle(true);
            interestedForumStyleAForumViewHolder.b.setStrokeWith(xi.g(TbadkCoreApplication.getInst(), R.dimen.tbds1));
            interestedForumStyleAForumViewHolder.b.setStrokeColorResId(R.color.CAM_X0401);
            interestedForumStyleAForumViewHolder.b.setScaleType(ImageView.ScaleType.CENTER_CROP);
            interestedForumStyleAForumViewHolder.b.setPlaceHolder(1);
            interestedForumStyleAForumViewHolder.b.N(n69Var.a(), 10, false);
            interestedForumStyleAForumViewHolder.c.setText(n69Var.d() + this.mContext.getString(R.string.obfuscated_res_0x7f0f076a));
            if (!StringUtils.isNull(n69Var.f())) {
                interestedForumStyleAForumViewHolder.d.setText(this.mContext.getString(R.string.obfuscated_res_0x7f0f0ac6, n69Var.f()));
            } else {
                interestedForumStyleAForumViewHolder.d.setText(this.mContext.getString(R.string.obfuscated_res_0x7f0f0aca));
            }
            interestedForumStyleAForumViewHolder.e.setText(String.format(this.mContext.getString(R.string.obfuscated_res_0x7f0f04b2), StringHelper.numberUniformFormatExtraWithRoundInt(n69Var.e())));
            interestedForumStyleAForumViewHolder.f.setText(String.format(this.mContext.getString(R.string.forum_thread_number), StringHelper.numberUniformFormatExtraWithRoundInt(n69Var.h())));
            D(interestedForumStyleAForumViewHolder.h, n69Var.i());
        }
    }

    public final void C(InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, interestedForumStyleAForumViewHolder) == null) {
            s75 d = s75.d(interestedForumStyleAForumViewHolder.c);
            d.x(R.color.CAM_X0105);
            d.C(R.dimen.T_X06);
            s75 d2 = s75.d(interestedForumStyleAForumViewHolder.d);
            d2.x(R.color.CAM_X0109);
            d2.C(R.dimen.T_X09);
            s75 d3 = s75.d(interestedForumStyleAForumViewHolder.e);
            d3.x(R.color.CAM_X0109);
            d3.C(R.dimen.T_X09);
            s75 d4 = s75.d(interestedForumStyleAForumViewHolder.f);
            d4.x(R.color.CAM_X0109);
            d4.C(R.dimen.T_X09);
            TBSelector.setViewBackgroundColorWithPressedState(interestedForumStyleAForumViewHolder.a, R.color.CAM_X0205, R.color.CAM_X0204);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.kn
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, n69 n69Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        z(i, view2, viewGroup, n69Var, interestedForumStyleAForumViewHolder);
        return view2;
    }

    public View z(int i, View view2, ViewGroup viewGroup, n69 n69Var, InterestedForumStyleAForumViewHolder interestedForumStyleAForumViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Integer.valueOf(i), view2, viewGroup, n69Var, interestedForumStyleAForumViewHolder})) == null) {
            if (n69Var == null) {
                return view2;
            }
            C(interestedForumStyleAForumViewHolder);
            A(interestedForumStyleAForumViewHolder, n69Var);
            return view2;
        }
        return (View) invokeCommon.objValue;
    }
}
