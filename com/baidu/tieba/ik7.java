package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tbadk.core.util.tbselector.utils.SelectorHelper;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.ChatBannerViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.ChatItemViewHolder;
import com.baidu.tieba.imMessageCenter.chatgroup.chatbox.adapter.ChatNameViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes4.dex */
public class ik7 implements nk7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public qk7 a;

    public ik7(qk7 qk7Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {qk7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = qk7Var;
    }

    @Override // com.baidu.tieba.nk7
    @Nullable
    public BaseItemViewHolder a(@NonNull ViewGroup viewGroup, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048576, this, viewGroup, i)) == null) {
            if (i == 2) {
                return new ChatItemViewHolder(LayoutInflater.from(SelectorHelper.getContext()).inflate(R.layout.obfuscated_res_0x7f0d038d, (ViewGroup) null, false), this.a);
            }
            if (i == 1) {
                return new ChatNameViewHolder(LayoutInflater.from(SelectorHelper.getContext()).inflate(R.layout.obfuscated_res_0x7f0d038e, (ViewGroup) null, false));
            }
            if (i != 3) {
                return null;
            }
            return new ChatBannerViewHolder(LayoutInflater.from(SelectorHelper.getContext()).inflate(R.layout.obfuscated_res_0x7f0d038b, (ViewGroup) null, false));
        }
        return (BaseItemViewHolder) invokeLI.objValue;
    }
}
