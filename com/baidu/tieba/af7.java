package com.baidu.tieba;

import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.BawuTeamInfoActivityConfig;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.data.SmallTailInfo;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tieba.forumMember.member.FrsMemberTeamViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
import tbclient.BawuRoleInfoPub;
import tbclient.MemberGroupInfo;
/* loaded from: classes5.dex */
public class af7 extends yg7<bf7, FrsMemberTeamViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener l;

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ af7 a;

        public a(af7 af7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {af7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = af7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            bf7 bf7Var;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = "";
                if (view2.getTag() instanceof BawuRoleInfoPub) {
                    BawuRoleInfoPub bawuRoleInfoPub = (BawuRoleInfoPub) view2.getTag();
                    this.a.c.sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, "" + bawuRoleInfoPub.user_id, bawuRoleInfoPub.user_name)));
                } else if (view2.getId() == R.id.obfuscated_res_0x7f0925be) {
                    Object tag = view2.getTag();
                    String[] strArr = null;
                    if (tag instanceof Integer) {
                        Integer num = (Integer) tag;
                        if (this.a.getItem(num.intValue()) instanceof bf7) {
                            bf7Var = (bf7) this.a.getItem(num.intValue());
                            if (bf7Var == null && bf7Var.b() != null) {
                                if (!StringUtils.isNull(bf7Var.b().member_group_type)) {
                                    strArr = bf7Var.b().member_group_type.split("_");
                                }
                                if (strArr != null && strArr.length == 2) {
                                    str = strArr[0];
                                }
                                if (!StringUtils.isNull(str) && str.equalsIgnoreCase("1")) {
                                    this.a.c.sendMessage(new CustomMessage(2002001, new BawuTeamInfoActivityConfig(this.a.mContext, JavaTypesHelper.toLong(bf7Var.a(), 0L))));
                                    return;
                                }
                                return;
                            }
                        }
                    }
                    bf7Var = null;
                    if (bf7Var == null) {
                    }
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public af7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.l = new a(this);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.om
    /* renamed from: K */
    public FrsMemberTeamViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return new FrsMemberTeamViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0308, (ViewGroup) null), this.l);
        }
        return (FrsMemberTeamViewHolder) invokeL.objValue;
    }

    public View L(int i, View view2, ViewGroup viewGroup, bf7 bf7Var, FrsMemberTeamViewHolder frsMemberTeamViewHolder) {
        InterceptResult invokeCommon;
        MemberGroupInfo b;
        List<BawuRoleInfoPub> list;
        String[] strArr;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bf7Var, frsMemberTeamViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) bf7Var, (bf7) frsMemberTeamViewHolder);
            if (bf7Var != null && bf7Var.b() != null && (list = (b = bf7Var.b()).member_group_list) != null && list.size() > 0 && !StringUtils.isNull(b.member_group_type)) {
                frsMemberTeamViewHolder.a.setTag(Integer.valueOf(i));
                if (!StringUtils.isNull(b.member_group_type)) {
                    strArr = b.member_group_type.split("_");
                } else {
                    strArr = null;
                }
                if (strArr != null && strArr.length == 2) {
                    str = strArr[1];
                } else {
                    str = "";
                }
                frsMemberTeamViewHolder.a.setText(str + "(" + b.member_group_num + SmallTailInfo.EMOTION_SUFFIX);
                int i2 = 0;
                for (BawuRoleInfoPub bawuRoleInfoPub : b.member_group_list) {
                    if (i2 > 3) {
                        break;
                    } else if (bawuRoleInfoPub != null) {
                        frsMemberTeamViewHolder.b(bawuRoleInfoPub, i2);
                        i2++;
                    }
                }
                frsMemberTeamViewHolder.c(this.f);
                SkinManager.setBackgroundColor(frsMemberTeamViewHolder.n, R.color.CAM_X0201);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.a, R.color.CAM_X0105, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.j, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.k, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.l, R.color.CAM_X0106, 1);
                SkinManager.setViewTextColor(frsMemberTeamViewHolder.m, R.color.CAM_X0106, 1);
                frsMemberTeamViewHolder.a.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.yg7, com.baidu.tieba.om
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        L(i, view2, viewGroup, (bf7) obj, (FrsMemberTeamViewHolder) viewHolder);
        return view2;
    }
}
