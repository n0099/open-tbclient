package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.im.base.core.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatBannerViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.ChatNameViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class a29 implements in8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public kn8 a;

    public a29(kn8 kn8Var, String str) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {kn8Var, str};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = kn8Var;
    }

    @Override // com.baidu.tieba.in8
    @Nullable
    public BaseItemViewHolder a(@NonNull ViewGroup viewGroup, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, viewGroup, i, str)) == null) {
            View view2 = null;
            if (i == 2) {
                if (str.equals("frs")) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03ff, viewGroup, false);
                } else if (str.equals("message_tab")) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0678, viewGroup, false);
                }
                return new ChatItemViewHolder(view2, this.a, str);
            } else if (i == 1) {
                if (str.equals("frs")) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0400, viewGroup, false);
                } else if (str.equals("message_tab")) {
                    view2 = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d0679, viewGroup, false);
                }
                return new ChatNameViewHolder(view2, str);
            } else if (i != 3) {
                return null;
            } else {
                return new ChatBannerViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03fd, viewGroup, false), str);
            }
        }
        return (BaseItemViewHolder) invokeLIL.objValue;
    }
}
