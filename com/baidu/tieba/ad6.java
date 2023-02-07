package com.baidu.tieba;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LowFlowsActivityConfig;
import com.baidu.tbadk.core.elementsMaven.view.EMTextView;
import com.baidu.tbadk.core.util.SkinManager;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tieba.tbadkCore.data.FlutterOpenData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
/* loaded from: classes3.dex */
public class ad6 implements View.OnClickListener {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;
    public View b;
    public View c;
    public ImageView d;
    public View e;
    public EMTextView f;
    public ImageView g;
    public int h;
    public String i;

    public ad6(Context context) {
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
        this.h = 3;
        this.a = context;
        c(context);
    }

    public ImageView a() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return this.g;
        }
        return (ImageView) invokeV.objValue;
    }

    public View b() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return this.b;
        }
        return (View) invokeV.objValue;
    }

    public final void c(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.obfuscated_res_0x7f0d01a4, (ViewGroup) null);
            this.b = inflate;
            View findViewById = inflate.findViewById(R.id.obfuscated_res_0x7f091d75);
            this.c = findViewById;
            findViewById.setOnClickListener(this);
            this.d = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090feb);
            this.e = this.b.findViewById(R.id.obfuscated_res_0x7f0926c6);
            this.f = (EMTextView) this.b.findViewById(R.id.obfuscated_res_0x7f092324);
            ImageView imageView = (ImageView) this.b.findViewById(R.id.obfuscated_res_0x7f090689);
            this.g = imageView;
            imageView.setClickable(true);
            d(TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public void d(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            if (this.h != i) {
                p15 d = p15.d(this.c);
                d.n(R.string.J_X06);
                d.f(R.color.CAM_X0201);
                p15 d2 = p15.d(this.e);
                d2.n(R.string.J_X03);
                d2.f(R.color.CAM_X0110);
                p15.d(this.f).v(R.color.CAM_X0108);
                this.g.setImageDrawable(WebPManager.getPureDrawable(R.drawable.icon_pure_card_close22, SkinManager.getColor(R.color.CAM_X0111), WebPManager.ResourceStateType.NORMAL_PRESS));
                if (i == 4) {
                    WebPManager.setMaskDrawable(this.d, R.drawable.obfuscated_res_0x7f081002, WebPManager.ResourceStateType.NORMAL);
                } else if (i == 1) {
                    WebPManager.setMaskDrawable(this.d, R.drawable.obfuscated_res_0x7f081001, WebPManager.ResourceStateType.NORMAL);
                } else {
                    WebPManager.setMaskDrawable(this.d, R.drawable.obfuscated_res_0x7f081000, WebPManager.ResourceStateType.NORMAL);
                }
            }
            this.h = i;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, view2) == null) {
            HashMap hashMap = new HashMap();
            String str = "0";
            if ("from_personaize".equals(this.i)) {
                hashMap.put(LowFlowsActivityConfig.LF_USER, TbSingleton.getInstance().getLFUser());
                hashMap.put(LowFlowsActivityConfig.LF_USER_TASKID, TbSingleton.getInstance().getLFUserTaskId());
                if (!StringUtils.isNull(TbSingleton.getInstance().getLFUserTaskId())) {
                    str = TbSingleton.getInstance().getLFUserTaskId();
                }
                dc7.a("c14080", str, "1");
            } else {
                hashMap.put(LowFlowsActivityConfig.LF_USER, "1");
                dc7.a("c14080", "0", "2");
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002015, new FlutterOpenData(this.a, "TreasureTrovePage", hashMap)));
        }
    }

    public void setFrom(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.i = str;
        }
    }
}
