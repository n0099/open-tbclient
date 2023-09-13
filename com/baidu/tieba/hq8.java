package com.baidu.tieba;

import android.view.LayoutInflater;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.tieba.immessagecenter.chatgroup.chatbox.adapter.BaseItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotSkillItemViewHolder;
import com.baidu.tieba.immessagecenter.chatgroup.grouppage.inputtool.robotfloor.adapter.RobotSkillRecentlyItemViewHolder;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class hq8 implements yl8 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public fq8 a;

    public hq8(fq8 fq8Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fq8Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = fq8Var;
    }

    @Override // com.baidu.tieba.yl8
    @Nullable
    public BaseItemViewHolder a(@NonNull ViewGroup viewGroup, int i, String str) {
        InterceptResult invokeLIL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLIL = interceptable.invokeLIL(1048576, this, viewGroup, i, str)) == null) {
            if (i == 5) {
                return new RobotSkillItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03eb, viewGroup, false), this.a);
            }
            if (i == 4) {
                return new RobotItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03e9, viewGroup, false));
            }
            if (i == 6) {
                return new RobotSkillRecentlyItemViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.obfuscated_res_0x7f0d03ec, viewGroup, false), this.a);
            }
            return null;
        }
        return (BaseItemViewHolder) invokeLIL.objValue;
    }
}
