package com.baidu.tieba;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.widget.ListView.TypeAdapter;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.StringHelper;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tieba.forumMember.member.PrivateMgrApplyViewHolder;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eb7 extends yc7<fb7, PrivateMgrApplyViewHolder> {
    public static /* synthetic */ Interceptable $ic = null;

    /* renamed from: n */
    public static final int obfuscated = 2131303801;
    public transient /* synthetic */ FieldHolder $fh;
    public bb5 l;
    public View.OnClickListener m;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947728655, "Lcom/baidu/tieba/eb7;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947728655, "Lcom/baidu/tieba/eb7;");
        }
    }

    /* loaded from: classes5.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eb7 a;

        public a(eb7 eb7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {eb7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = eb7Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                if (TbadkCoreApplication.isLogin() && StringUtils.isNull(TbadkCoreApplication.getCurrentAccountName())) {
                    this.a.L(TbadkCoreApplication.getCurrentAccountInfo());
                    return;
                }
                Object tag = view2.getTag(eb7.obfuscated);
                if (tag != null && !tag.toString().equals("")) {
                    UrlManager.getInstance().dealOneLink((TbPageContext) k4.a(this.a.mContext), new String[]{tag.toString()});
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public eb7(TbPageContext<?> tbPageContext, BdUniqueId bdUniqueId) {
        super(tbPageContext, bdUniqueId);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bdUniqueId};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (BdUniqueId) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.m = new a(this);
    }

    public void onDestroy() {
        bb5 bb5Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048580, this) == null) && (bb5Var = this.l) != null) {
            bb5Var.s();
        }
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.lh
    /* renamed from: J */
    public PrivateMgrApplyViewHolder onCreateViewHolder(ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, viewGroup)) == null) {
            return new PrivateMgrApplyViewHolder(LayoutInflater.from(this.mContext).inflate(R.layout.obfuscated_res_0x7f0d0828, (ViewGroup) null));
        }
        return (PrivateMgrApplyViewHolder) invokeL.objValue;
    }

    public View K(int i, View view2, ViewGroup viewGroup, fb7 fb7Var, PrivateMgrApplyViewHolder privateMgrApplyViewHolder) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, new Object[]{Integer.valueOf(i), view2, viewGroup, fb7Var, privateMgrApplyViewHolder})) == null) {
            super.onFillViewHolder(i, view2, viewGroup, (ViewGroup) fb7Var, (fb7) privateMgrApplyViewHolder);
            if (fb7Var != null && !fb7Var.d() && privateMgrApplyViewHolder != null) {
                if (fb7Var.d()) {
                    privateMgrApplyViewHolder.e.setVisibility(8);
                    return view2;
                }
                boolean z = true;
                if (privateMgrApplyViewHolder.f != this.f) {
                    SkinManager.setBackgroundColor(privateMgrApplyViewHolder.d, R.color.CAM_X0204);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.b, R.color.CAM_X0109, 1);
                    SkinManager.setViewTextColor(privateMgrApplyViewHolder.a, R.color.CAM_X0105, 1);
                    SkinManager.setBackgroundResource(privateMgrApplyViewHolder.c, R.drawable.frs_member_manito_bg);
                }
                int a2 = fb7Var.a();
                String string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1648);
                if (a2 == -1) {
                    int c = fb7Var.c();
                    String numberUniformFormat = StringHelper.numberUniformFormat(c);
                    if (c > 0) {
                        string = String.format(this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1642), numberUniformFormat);
                        privateMgrApplyViewHolder.c.setOnClickListener(this.m);
                        privateMgrApplyViewHolder.b.setText(string);
                        privateMgrApplyViewHolder.c.setTag(obfuscated, fb7Var.b());
                        privateMgrApplyViewHolder.c.setEnabled(z);
                        privateMgrApplyViewHolder.c.setClickable(z);
                        privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                        privateMgrApplyViewHolder.f = this.f;
                    }
                    z = false;
                    privateMgrApplyViewHolder.c.setOnClickListener(this.m);
                    privateMgrApplyViewHolder.b.setText(string);
                    privateMgrApplyViewHolder.c.setTag(obfuscated, fb7Var.b());
                    privateMgrApplyViewHolder.c.setEnabled(z);
                    privateMgrApplyViewHolder.c.setClickable(z);
                    privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f = this.f;
                } else {
                    if (a2 == 0) {
                        string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1646);
                    } else if (a2 == 1) {
                        string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1644);
                    } else {
                        if (a2 == 2) {
                            string = this.mContext.getResources().getString(R.string.obfuscated_res_0x7f0f1643);
                        }
                        z = false;
                    }
                    privateMgrApplyViewHolder.c.setOnClickListener(this.m);
                    privateMgrApplyViewHolder.b.setText(string);
                    privateMgrApplyViewHolder.c.setTag(obfuscated, fb7Var.b());
                    privateMgrApplyViewHolder.c.setEnabled(z);
                    privateMgrApplyViewHolder.c.setClickable(z);
                    privateMgrApplyViewHolder.b.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, SkinManager.getDrawable(R.drawable.icon_arrow12_gray66_right), (Drawable) null);
                    privateMgrApplyViewHolder.f = this.f;
                }
            }
            return view2;
        }
        return (View) invokeCommon.objValue;
    }

    public final void L(AccountData accountData) {
        Activity activity;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, accountData) == null) {
            BdPageContext<?> a2 = k4.a(this.mContext);
            if (a2 instanceof TbPageContext) {
                activity = ((TbPageContext) a2).getPageActivity();
            } else {
                activity = null;
            }
            if (this.l == null) {
                this.l = new bb5(activity);
            }
            this.l.p();
            this.l.u(accountData);
            this.l.z(1);
        }
    }

    @Override // com.baidu.tieba.yc7, com.baidu.tieba.lh
    public /* bridge */ /* synthetic */ View onFillViewHolder(int i, View view2, ViewGroup viewGroup, Object obj, TypeAdapter.ViewHolder viewHolder) {
        K(i, view2, viewGroup, (fb7) obj, (PrivateMgrApplyViewHolder) viewHolder);
        return view2;
    }
}
