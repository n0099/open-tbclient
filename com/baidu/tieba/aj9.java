package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.coreExtra.data.EmotionGroupType;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.li9;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class aj9 extends lj9<bk9> implements oj9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public WriteImageGridView g;
    @Nullable
    public li9 h;
    @NonNull
    public final bl9 i;
    public final li9.b j;

    @Override // com.baidu.tieba.qj9
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    /* loaded from: classes3.dex */
    public class a implements li9.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ aj9 a;

        public a(aj9 aj9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {aj9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = aj9Var;
        }

        @Override // com.baidu.tieba.li9.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.x(new int[]{10, 34});
            }
        }

        @Override // com.baidu.tieba.li9.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.b != null) {
                    this.a.b.i();
                }
                aj9 aj9Var = this.a;
                aj9Var.y(aj9Var.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aj9(TbPageContext<?> tbPageContext, @NonNull bl9 bl9Var) {
        super(tbPageContext, bk9.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, bl9Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                Object[] objArr2 = newInitContext.callArgs;
                super((TbPageContext) objArr2[0], (Class) objArr2[1]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.j = new a(this);
        this.i = bl9Var;
        bl9Var.c(this);
    }

    @Override // com.baidu.tieba.qj9
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
            this.i.d(writeData);
        }
    }

    @Override // com.baidu.tieba.oj9
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            u(str);
        }
    }

    @Override // com.baidu.tieba.oj9
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            u(str);
        }
    }

    @Override // com.baidu.tieba.qj9
    public void onChangeSkinType(int i) {
        li9 li9Var;
        ki9 ki9Var;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (li9Var = this.h) != null && (ki9Var = li9Var.d) != null) {
            ki9Var.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.lj9, com.baidu.tieba.qj9
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.i.o(bundle);
        }
    }

    @Override // com.baidu.tieba.oj9
    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || this.e == null) {
            return;
        }
        F(str);
    }

    @Override // com.baidu.tieba.oj9
    public void v(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048590, this, str) != null) || this.e == null) {
            return;
        }
        F(str);
    }

    public final void F(String str) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, str) == null) && str != null && this.b != null && this.h != null && this.e != null) {
            this.i.g().parseJson(str);
            this.i.g().updateQuality();
            this.h.u(this.i.g(), this.e.getFrom(), this.e.getForumId());
            bk9 bk9Var = (bk9) this.d;
            if (this.h.o().getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            bk9Var.a = z;
            y(this.d);
            this.b.w();
            this.b.i();
        }
    }

    @Override // com.baidu.tieba.lj9, com.baidu.tieba.qj9
    public void r(lb5 lb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, lb5Var) == null) {
            super.r(lb5Var);
            if (this.b != null && this.e != null && this.h != null && lb5Var.a == 24) {
                Object obj = lb5Var.c;
                if (!(obj instanceof e75)) {
                    return;
                }
                e75 e75Var = (e75) obj;
                if (EmotionGroupType.isSendAsPic(e75Var.getType()) && this.i.b(this.b, e75Var) != null) {
                    this.b.i();
                    this.b.x(new int[]{10, 34});
                    this.h.u(this.i.g(), this.e.getFrom(), this.e.getForumId());
                }
            }
        }
    }

    @Override // com.baidu.tieba.qj9
    public void a(@NonNull WriteData writeData) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) && this.h != null && writeData.getWriteImagesInfo() != null) {
            this.i.r(writeData.getWriteImagesInfo());
            WriteData writeData2 = this.e;
            if (writeData2 != null) {
                writeData2.setWriteImagesInfo(writeData.getWriteImagesInfo());
                this.h.u(this.i.g(), this.e.getFrom(), this.e.getForumId());
            }
            bk9 bk9Var = (bk9) this.d;
            if (this.h.o().getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            bk9Var.a = z;
            y(this.d);
        }
    }

    @Override // com.baidu.tieba.lj9, com.baidu.tieba.qj9
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            this.i.q(this);
            li9 li9Var = this.h;
            if (li9Var != null) {
                li9Var.n();
            }
        }
    }

    @Override // com.baidu.tieba.lj9, com.baidu.tieba.qj9
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            WriteImageGridView writeImageGridView = this.g;
            if (writeImageGridView != null && writeImageGridView.getVisibility() == 0 && this.i.g().size() > 0) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.lj9, com.baidu.tieba.qj9
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.i.m(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.qj9
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04c1, viewGroup, false);
            this.c = inflate;
            this.g = (WriteImageGridView) inflate.findViewById(R.id.obfuscated_res_0x7f0927ad);
            li9 li9Var = new li9(this.a, this.c);
            this.h = li9Var;
            li9Var.r(this.j);
            WriteData writeData = this.e;
            if (writeData != null) {
                this.h.q(writeData.getDisableAudioMessage(), this.e.getFirstDir(), this.e.getSecondDir(), this.e.getPrefixData(), this.e.getStatisticFrom(), this.e.isVoiceEnable());
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.e.getFrom())) {
                    this.h.s(false);
                } else {
                    this.h.t(true);
                }
                if (this.e.getType() == 14) {
                    this.h.p(true);
                }
            }
            this.h.u(this.i.g(), this.e.getFrom(), this.e.getForumId());
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
