package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PersonChangeActivityConfig;
import com.baidu.tbadk.core.atomData.PersonPolymericActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.nearby.viewholder.NearbyForumFriendItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class hm9 extends bi<uc5, NearbyForumFriendItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public int b;
    public boolean c;

    public final int z(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i)) == null) {
            if (i != 1) {
                return i != 2 ? -1 : 1;
            }
            return 0;
        }
        return invokeI.intValue;
    }

    /* loaded from: classes6.dex */
    public class a implements yi {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hm9 a;

        public a(hm9 hm9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hm9Var;
        }

        @Override // com.baidu.tieba.yi
        public void b(View view2, oi oiVar, BdUniqueId bdUniqueId, ViewGroup viewGroup, int i, long j) {
            boolean z;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{view2, oiVar, bdUniqueId, viewGroup, Integer.valueOf(i), Long.valueOf(j)}) != null) || !(oiVar instanceof uc5)) {
                return;
            }
            uc5 uc5Var = (uc5) oiVar;
            String str = uc5Var.a;
            if (!TextUtils.isEmpty(TbadkCoreApplication.getCurrentAccount()) && TbadkCoreApplication.getCurrentAccount().equals(str)) {
                z = true;
            } else {
                z = false;
            }
            zf8.i(i + 1, this.a.b, 2, uc5Var.a);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PersonPolymericActivityConfig(this.a.a).createNormalConfig(JavaTypesHelper.toLong(str, 0L), z, false)));
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ViewGroup a;
        public final /* synthetic */ uc5 b;
        public final /* synthetic */ int c;
        public final /* synthetic */ hm9 d;

        public b(hm9 hm9Var, ViewGroup viewGroup, uc5 uc5Var, int i) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hm9Var, viewGroup, uc5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = hm9Var;
            this.a = viewGroup;
            this.b = uc5Var;
            this.c = i;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (this.d.c) {
                    PersonChangeActivityConfig personChangeActivityConfig = new PersonChangeActivityConfig(this.a.getContext());
                    personChangeActivityConfig.setIsCompleteLocalInfo(true);
                    personChangeActivityConfig.start();
                } else {
                    uc5 uc5Var = this.b;
                    hm9 hm9Var = this.d;
                    MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921654, new ef5(uc5Var, hm9Var.z(hm9Var.b))));
                }
                zf8.i(this.c + 1, this.d.b, 1, this.b.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hm9(Context context, BdUniqueId bdUniqueId, int i) {
        super(context, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, bdUniqueId, Integer.valueOf(i)};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((Context) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = context;
        this.b = i;
        setOnAdapterItemClickListener(new a(this));
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.bi
    /* renamed from: A */
    public NearbyForumFriendItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return new NearbyForumFriendItemViewHolder(LayoutInflater.from(this.a).inflate(R.layout.obfuscated_res_0x7f0d070b, viewGroup, false), this.a);
        }
        return (NearbyForumFriendItemViewHolder) invokeL.objValue;
    }

    public void E(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048580, this, z) == null) {
            this.c = z;
        }
    }

    public View B(int i, View view2, ViewGroup viewGroup, uc5 uc5Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, uc5Var, nearbyForumFriendItemViewHolder})) == null) {
            if (uc5Var != null && nearbyForumFriendItemViewHolder != null) {
                F(uc5Var, nearbyForumFriendItemViewHolder);
                D(uc5Var, nearbyForumFriendItemViewHolder);
                zf8.p(i + 1, this.b);
                nearbyForumFriendItemViewHolder.k.setOnClickListener(new b(this, viewGroup, uc5Var, i));
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void C(NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLI(Constants.METHOD_SEND_USER_MSG, this, nearbyForumFriendItemViewHolder, i) == null) {
            nearbyForumFriendItemViewHolder.p.setVisibility(0);
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        nearbyForumFriendItemViewHolder.p.setVisibility(8);
                        nearbyForumFriendItemViewHolder.c.setShowActiveStatus(false);
                        return;
                    }
                    nearbyForumFriendItemViewHolder.p.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0e55));
                    nearbyForumFriendItemViewHolder.c.setShowActiveStatus(false);
                    return;
                }
                nearbyForumFriendItemViewHolder.p.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0e54));
                nearbyForumFriendItemViewHolder.c.setShowActiveStatus(true);
                return;
            }
            nearbyForumFriendItemViewHolder.p.setText(this.a.getString(R.string.obfuscated_res_0x7f0f0e56));
            nearbyForumFriendItemViewHolder.c.setShowActiveStatus(true);
        }
    }

    public final void D(uc5 uc5Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, uc5Var, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.c.startLoad(uc5Var.c, 25, false);
            nearbyForumFriendItemViewHolder.d.setText(uc5Var.b);
            int i = uc5Var.d;
            boolean z2 = true;
            if ((i != 1 && i != 2) || uc5Var.e <= 0) {
                nearbyForumFriendItemViewHolder.e.setVisibility(8);
                z = false;
            } else {
                nearbyForumFriendItemViewHolder.e.setVisibility(0);
                nearbyForumFriendItemViewHolder.g.setText(String.valueOf(uc5Var.e));
                z = true;
            }
            if (StringUtils.isNull(uc5Var.f)) {
                nearbyForumFriendItemViewHolder.h.setVisibility(8);
            } else {
                nearbyForumFriendItemViewHolder.h.setVisibility(0);
                nearbyForumFriendItemViewHolder.h.setText(uc5Var.f);
                z = true;
            }
            if (StringUtils.isNull(uc5Var.g)) {
                nearbyForumFriendItemViewHolder.i.setVisibility(8);
                z2 = z;
            } else {
                nearbyForumFriendItemViewHolder.i.setVisibility(0);
                nearbyForumFriendItemViewHolder.i.setText(uc5Var.g);
            }
            C(nearbyForumFriendItemViewHolder, uc5Var.k);
            if (z2 && nearbyForumFriendItemViewHolder.p.getVisibility() == 0) {
                nearbyForumFriendItemViewHolder.o.setVisibility(0);
            } else {
                nearbyForumFriendItemViewHolder.o.setVisibility(8);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f07a8));
            if (!ListUtils.isEmpty(uc5Var.h)) {
                List<tc5> list = uc5Var.h;
                for (int i2 = 0; i2 < list.size(); i2++) {
                    if (i2 > 0) {
                        sb.append("/");
                    }
                    sb.append(list.get(i2).a);
                    sb.append(this.a.getResources().getString(R.string.obfuscated_res_0x7f0f0787));
                }
            }
            nearbyForumFriendItemViewHolder.j.setText(sb);
            nearbyForumFriendItemViewHolder.n.setText(uc5Var.i);
        }
    }

    public final void F(uc5 uc5Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, uc5Var, nearbyForumFriendItemViewHolder) == null) {
            nearbyForumFriendItemViewHolder.c.setBorderColor(SkinManager.getColor(R.color.CAM_X0401));
            EMManager.from(nearbyForumFriendItemViewHolder.d).setTextColor(R.color.CAM_X0105);
            int i = uc5Var.d;
            if (i == 1) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f, R.drawable.obfuscated_res_0x7f0809c5, R.color.CAM_X0330, null);
                EMManager.from(nearbyForumFriendItemViewHolder.g).setTextColor(R.color.CAM_X0330);
                EMManager.from(nearbyForumFriendItemViewHolder.e).setAlpha(R.string.A_X11).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0330);
            } else if (i == 2) {
                WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.f, R.drawable.obfuscated_res_0x7f0809e7, R.color.CAM_X0308, null);
                EMManager.from(nearbyForumFriendItemViewHolder.g).setTextColor(R.color.CAM_X0308);
                EMManager.from(nearbyForumFriendItemViewHolder.e).setAlpha(R.string.A_X11).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0308);
            }
            EMManager.from(nearbyForumFriendItemViewHolder.h).setCorner(R.string.J_X01).setTextColor(R.color.CAM_X0107).setBackGroundColor(R.color.CAM_X0202);
            EMManager.from(nearbyForumFriendItemViewHolder.i).setTextColor(R.color.CAM_X0109);
            EMManager.from(nearbyForumFriendItemViewHolder.o).setTextColor(R.color.CAM_X0109);
            EMManager.from(nearbyForumFriendItemViewHolder.p).setTextColor(R.color.CAM_X0109);
            WebPManager.setPureDrawable(nearbyForumFriendItemViewHolder.l, R.drawable.obfuscated_res_0x7f080c04, R.color.CAM_X0302, null);
            EMManager.from(nearbyForumFriendItemViewHolder.m).setTextColor(R.color.CAM_X0302);
            EMManager.from(nearbyForumFriendItemViewHolder.k).setCorner(R.string.J_X01).setBackGroundColor(R.color.CAM_X0905);
            EMManager.from(nearbyForumFriendItemViewHolder.j).setTextColor(R.color.CAM_X0109);
            EMManager.from(nearbyForumFriendItemViewHolder.n).setTextColor(R.color.CAM_X0107);
        }
    }

    /* JADX DEBUG: Method arguments types fixed to match base method, original types: [int, android.view.View, android.view.ViewGroup, java.lang.Object, com.baidu.adp.widget.ListView.TypeAdapter$ViewHolder] */
    @Override // com.baidu.tieba.bi
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, uc5 uc5Var, NearbyForumFriendItemViewHolder nearbyForumFriendItemViewHolder) {
        B(i, view2, viewGroup, uc5Var, nearbyForumFriendItemViewHolder);
        return view2;
    }
}
