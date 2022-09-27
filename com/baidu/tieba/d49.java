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
import com.baidu.tieba.s39;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class d49 extends n49<b59> implements q49 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public WriteImageGridView g;
    @Nullable
    public s39 h;
    @NonNull
    public final x59 i;
    public final s39.b j;

    /* loaded from: classes3.dex */
    public class a implements s39.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ d49 a;

        public a(d49 d49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {d49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = d49Var;
        }

        @Override // com.baidu.tieba.s39.b
        public void a() {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeV(1048576, this) == null) || this.a.b == null) {
                return;
            }
            this.a.b.x(new int[]{10, 34});
        }

        @Override // com.baidu.tieba.s39.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.b != null) {
                    this.a.b.h();
                }
                d49 d49Var = this.a;
                d49Var.w(d49Var.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d49(TbPageContext<?> tbPageContext, @NonNull x59 x59Var) {
        super(tbPageContext, b59.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, x59Var};
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
        this.i = x59Var;
        x59Var.c(this);
    }

    public final void D(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048576, this, str) == null) || str == null || this.b == null || this.h == null || this.e == null) {
            return;
        }
        this.i.f().parseJson(str);
        this.i.f().updateQuality();
        this.h.v(this.i.f(), this.e.getFrom(), this.e.getForumId());
        ((b59) this.d).a = this.h.o().getVisibility() == 0;
        w(this.d);
        this.b.w();
        this.b.h();
    }

    @Override // com.baidu.tieba.s49
    public void b(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
            this.i.d(writeData);
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            this.i.p(this);
            s39 s39Var = this.h;
            if (s39Var != null) {
                s39Var.n();
            }
        }
    }

    @Override // com.baidu.tieba.s49
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.q49
    public void g(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            s(str);
        }
    }

    @Override // com.baidu.tieba.q49
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            s(str);
        }
    }

    @Override // com.baidu.tieba.s49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048582, this, writeData) == null) || this.h == null || writeData.getWriteImagesInfo() == null) {
            return;
        }
        this.i.q(writeData.getWriteImagesInfo());
        WriteData writeData2 = this.e;
        if (writeData2 != null) {
            writeData2.setWriteImagesInfo(writeData.getWriteImagesInfo());
            this.h.v(this.i.f(), this.e.getFrom(), this.e.getForumId());
        }
        ((b59) this.d).a = this.h.o().getVisibility() == 0;
        w(this.d);
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.i.l(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.s49
    public void onChangeSkinType(int i) {
        s39 s39Var;
        r39 r39Var;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) || (s39Var = this.h) == null || (r39Var = s39Var.d) == null) {
            return;
        }
        r39Var.notifyDataSetChanged();
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.i.n(bundle);
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void p(h55 h55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, h55Var) == null) {
            super.p(h55Var);
            if (this.b == null || this.e == null || this.h == null || h55Var.a != 24) {
                return;
            }
            Object obj = h55Var.c;
            if (obj instanceof e15) {
                e15 e15Var = (e15) obj;
                if (!EmotionGroupType.isSendAsPic(e15Var.getType()) || this.i.b(this.b, e15Var) == null) {
                    return;
                }
                this.b.h();
                this.b.x(new int[]{10, 34});
                this.h.v(this.i.f(), this.e.getFrom(), this.e.getForumId());
            }
        }
    }

    @Override // com.baidu.tieba.s49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04a4, viewGroup, false);
            this.c = inflate;
            this.g = (WriteImageGridView) inflate.findViewById(R.id.obfuscated_res_0x7f0926b4);
            s39 s39Var = new s39(this.a, this.c);
            this.h = s39Var;
            s39Var.r(this.j);
            WriteData writeData = this.e;
            if (writeData != null) {
                this.h.q(writeData.getDisableAudioMessage(), this.e.getFirstDir(), this.e.getSecondDir(), this.e.getPrefixData(), this.e.getStatisticFrom(), this.e.isVoiceEnable());
                if (WriteActivityConfig.FROM_FORUM_SHARE.equals(this.e.getFrom())) {
                    this.h.t(false);
                } else {
                    this.h.u(true);
                }
                if (this.e.getType() == 14) {
                    this.h.p(true);
                }
            }
            this.h.v(this.i.f(), this.e.getFrom(), this.e.getForumId());
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            WriteImageGridView writeImageGridView = this.g;
            return writeImageGridView != null && writeImageGridView.getVisibility() == 0 && this.i.f().size() > 0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.q49
    public void s(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048589, this, str) == null) || this.e == null) {
            return;
        }
        D(str);
    }

    @Override // com.baidu.tieba.q49
    public void t(String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048590, this, str) == null) || this.e == null) {
            return;
        }
        D(str);
    }
}
