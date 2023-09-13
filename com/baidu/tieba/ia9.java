package com.baidu.tieba;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.browser.BrowserHelper;
import com.baidu.tbadk.core.atomData.AvatarPendantActivityConfig;
import com.baidu.tbadk.core.atomData.BubbleGroupActivityConfig;
import com.baidu.tbadk.core.atomData.SignAllForumActivityConfig;
import com.baidu.tbadk.core.elementsMaven.EMManager;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.UrlSchemaHelper;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.memberCenter.memberpay.MemberPayResult;
import com.baidu.tieba.memberCenter.memberprivilege.MemberCenterStatic;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.List;
/* loaded from: classes6.dex */
public class ia9 extends BaseAdapter {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public List<MemberPayResult.VipPayPrivilegeData> a;
    public LayoutInflater b;
    public Context c;
    public b d;

    /* loaded from: classes6.dex */
    public interface b {
        void a(String str);
    }

    /* loaded from: classes6.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MemberPayResult.VipPayPrivilegeData a;
        public final /* synthetic */ c b;
        public final /* synthetic */ k59 c;
        public final /* synthetic */ ia9 d;

        public a(ia9 ia9Var, MemberPayResult.VipPayPrivilegeData vipPayPrivilegeData, c cVar, k59 k59Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia9Var, vipPayPrivilegeData, cVar, k59Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.d = ia9Var;
            this.a = vipPayPrivilegeData;
            this.b = cVar;
            this.c = k59Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                String str = this.a.mLinkUrl;
                if (!str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_POST_BUBBLE) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PENDANT_LIST) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_BG) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL) && !str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_ONE_KEY_SIGN)) {
                    BrowserHelper.startWebActivity(this.d.b.getContext(), str);
                } else {
                    if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_POST_BUBBLE)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new BubbleGroupActivityConfig(this.d.c)));
                    }
                    if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PENDANT_LIST)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AvatarPendantActivityConfig(this.d.c)));
                    }
                    if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_BG) || str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_PERSONAL_CARD_DETAIL)) {
                        MemberCenterStatic.a((TbPageContext) m9.a(this.d.c), new String[]{str});
                    }
                    if (str.contains(UrlSchemaHelper.SCHEMA_TYPE_GOTO_ONE_KEY_SIGN)) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SignAllForumActivityConfig(this.d.c)));
                    }
                }
                if (this.d.d != null) {
                    this.d.d.a(this.a.mEquityId);
                }
                if (!TextUtils.equals("click", this.a.getDynamicDisappear())) {
                    return;
                }
                this.d.e(this.b.d, this.c);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public TbImageView a;
        public TextView b;
        public RelativeLayout c;
        public final TextView d;

        public c(ia9 ia9Var, View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ia9Var, view2};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = (RelativeLayout) view2.findViewById(R.id.obfuscated_res_0x7f091740);
            this.a = (TbImageView) view2.findViewById(R.id.obfuscated_res_0x7f091744);
            this.b = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091743);
            this.d = (TextView) view2.findViewById(R.id.obfuscated_res_0x7f091742);
        }
    }

    public ia9(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = LayoutInflater.from(context);
        this.c = context;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // android.widget.Adapter
    /* renamed from: f */
    public MemberPayResult.VipPayPrivilegeData getItem(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i)) == null) {
            List<MemberPayResult.VipPayPrivilegeData> list = this.a;
            if (list == null) {
                return null;
            }
            return list.get(i);
        }
        return (MemberPayResult.VipPayPrivilegeData) invokeI.objValue;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048581, this, i)) == null) {
            if (this.a == null) {
                return 0L;
            }
            return i;
        }
        return invokeI.longValue;
    }

    public void h(List<MemberPayResult.VipPayPrivilegeData> list) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, list) == null) {
            this.a = list;
        }
    }

    public void i(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, bVar) == null) {
            this.d = bVar;
        }
    }

    public final void e(View view2, k59 k59Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048576, this, view2, k59Var) == null) {
            if (view2 != null) {
                view2.setVisibility(8);
            }
            if (k59Var != null) {
                k59Var.i();
            }
        }
    }

    public final void g(MemberPayResult.VipPayPrivilegeData vipPayPrivilegeData, c cVar) {
        k59 k59Var;
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, vipPayPrivilegeData, cVar) != null) || vipPayPrivilegeData == null) {
            return;
        }
        cVar.b.setText(vipPayPrivilegeData.mTitle);
        SkinManager.setViewTextColor(cVar.b, (int) R.color.CAM_X0105);
        j59 j59Var = null;
        if (TextUtils.equals("click", vipPayPrivilegeData.getDynamicDisappear())) {
            k59 k59Var2 = new k59("pay_panel_member_privilege_bubble_" + vipPayPrivilegeData.mTitle);
            j59 j59Var2 = new j59("pay_panel_member_privilege_bubble_" + vipPayPrivilegeData.mTitle);
            z = k59Var2.g(j59Var2.f(vipPayPrivilegeData.getDynamicText()));
            j59Var = j59Var2;
            k59Var = k59Var2;
        } else {
            k59Var = null;
            z = false;
        }
        if (!TextUtils.isEmpty(vipPayPrivilegeData.getDynamicText()) && !z) {
            cVar.d.setText(vipPayPrivilegeData.getDynamicText());
            if (j59Var != null) {
                j59Var.update(vipPayPrivilegeData.getDynamicText());
            }
            cVar.d.setTextColor(SkinManager.getColor(R.color.CAM_X0101));
            EMManager.from(cVar.d).setBorderWidth(R.dimen.tbds3).setBorderColor(R.color.CAM_X0402).setCorner(R.string.J_X01).setBackGroundRealColor(vipPayPrivilegeData.getDynamicColor());
            cVar.d.setVisibility(0);
        } else {
            cVar.d.setVisibility(8);
        }
        cVar.a.startLoad(vipPayPrivilegeData.mIconUrl, 10, false);
        cVar.c.setOnClickListener(new a(this, vipPayPrivilegeData, cVar, k59Var));
    }

    @Override // android.widget.Adapter
    public int getCount() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            List<MemberPayResult.VipPayPrivilegeData> list = this.a;
            if (list == null) {
                return 0;
            }
            return list.size();
        }
        return invokeV.intValue;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view2, ViewGroup viewGroup) {
        InterceptResult invokeILL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeILL = interceptable.invokeILL(1048582, this, i, view2, viewGroup)) == null) {
            if (view2 == null) {
                view2 = this.b.inflate(R.layout.obfuscated_res_0x7f0d061f, (ViewGroup) null);
                view2.setTag(new c(this, view2));
            }
            g(getItem(i), (c) view2.getTag());
            return view2;
        }
        return (View) invokeILL.objValue;
    }
}
