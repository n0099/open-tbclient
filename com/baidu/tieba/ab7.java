package com.baidu.tieba;

import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.PersonInfoActivityConfig;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.forumMember.manito.ManitoMemberItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ab7 extends id7<bb7, ManitoMemberItemViewHolder> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public View.OnClickListener l;

    /* loaded from: classes4.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ab7 a;

        public a(ab7 ab7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ab7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ab7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                bb7 bb7Var = (bb7) view2.getTag();
                TiebaStatic.log("c10624");
                MessageManager.getInstance().sendMessage(new CustomMessage(2002003, new PersonInfoActivityConfig(this.a.mContext, bb7Var.f(), bb7Var.d(), "")));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ab7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
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
    @Override // com.baidu.tieba.in
    /* renamed from: I */
    public ManitoMemberItemViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, viewGroup)) == null) {
            return new ManitoMemberItemViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d05ed, (ViewGroup) null));
        }
        return (ManitoMemberItemViewHolder) invokeL.objValue;
    }

    public final SpannableStringBuilder H(String str, String[] strArr, int[] iArr) {
        InterceptResult invokeLLL;
        int indexOf;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(1048576, this, str, strArr, iArr)) == null) {
            if (str != null && strArr != null && iArr != null && strArr.length > 0 && iArr.length > 0 && strArr.length == iArr.length) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
                SpannableString spannableString = new SpannableString(str);
                for (int i = 0; i < strArr.length; i++) {
                    if (strArr[i] != null && (indexOf = str.indexOf(strArr[i])) >= 0) {
                        spannableString.setSpan(new ForegroundColorSpan(iArr[i]), indexOf, strArr[i].length() + indexOf, 17);
                    }
                }
                spannableStringBuilder.append((CharSequence) spannableString);
                return spannableStringBuilder;
            }
            return null;
        }
        return (SpannableStringBuilder) invokeLLL.objValue;
    }

    public View J(int i, View view2, ViewGroup viewGroup, bb7 bb7Var, ManitoMemberItemViewHolder manitoMemberItemViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_SEND_USER_MSG, this, new Object[]{Integer.valueOf(i), view2, viewGroup, bb7Var, manitoMemberItemViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) bb7Var, (bb7) manitoMemberItemViewHolder);
            if (bb7Var != null && manitoMemberItemViewHolder != null) {
                if (manitoMemberItemViewHolder.f != this.f) {
                    SkinManager.setBackgroundResource(manitoMemberItemViewHolder.getView(), R.drawable.frs_member_manito_bg);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.b, R.color.CAM_X0106, 1);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.c, R.color.CAM_X0109, 1);
                    SkinManager.setBackgroundColor(manitoMemberItemViewHolder.e, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(manitoMemberItemViewHolder.d, R.color.CAM_X0109, 1);
                }
                manitoMemberItemViewHolder.a.e(bb7Var.b(), 12, false);
                manitoMemberItemViewHolder.b.setText(px5.f(bb7Var.e(), 16));
                if (StringUtils.isNull(bb7Var.c())) {
                    manitoMemberItemViewHolder.c.setText(R.string.god_intro_default);
                } else {
                    manitoMemberItemViewHolder.c.setText(px5.f(bb7Var.c(), 30));
                }
                int color = SkinManager.getColor(R.color.CAM_X0301);
                String numberUniformFormat = StringHelper.numberUniformFormat(bb7Var.a());
                manitoMemberItemViewHolder.d.setText(H(String.format(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f06ff), numberUniformFormat), new String[]{numberUniformFormat}, new int[]{color}));
                manitoMemberItemViewHolder.getView().setTag(bb7Var);
                manitoMemberItemViewHolder.getView().setOnClickListener(this.l);
                manitoMemberItemViewHolder.f = this.f;
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    @Override // com.baidu.tieba.id7, com.baidu.tieba.in
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        J(i, view2, viewGroup, (bb7) obj, (ManitoMemberItemViewHolder) viewHolder);
        return view2;
    }
}
