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
import com.baidu.tieba.rva;
import com.baidu.tieba.write.write.WriteImageGridView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes6.dex */
public class gwa extends rwa<hxa> implements uwa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public WriteImageGridView g;
    @Nullable
    public rva h;
    @NonNull
    public final hya i;
    public final rva.b j;

    @Override // com.baidu.tieba.wwa
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements rva.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gwa a;

        public a(gwa gwaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gwaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gwaVar;
        }

        @Override // com.baidu.tieba.rva.b
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b != null) {
                this.a.b.x(new int[]{10, 34});
            }
        }

        @Override // com.baidu.tieba.rva.b
        public void b() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                if (this.a.b != null) {
                    this.a.b.i();
                }
                gwa gwaVar = this.a;
                gwaVar.y(gwaVar.d);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public gwa(TbPageContext<?> tbPageContext, @NonNull hya hyaVar) {
        super(tbPageContext, hxa.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, hyaVar};
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
        this.i = hyaVar;
        hyaVar.c(this);
    }

    @Override // com.baidu.tieba.wwa
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
            this.i.d(writeData);
        }
    }

    @Override // com.baidu.tieba.uwa
    public void i(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            u(str);
        }
    }

    @Override // com.baidu.tieba.uwa
    public void k(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, str) == null) {
            u(str);
        }
    }

    @Override // com.baidu.tieba.wwa
    public void onChangeSkinType(int i) {
        rva rvaVar;
        qva qvaVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (rvaVar = this.h) != null && (qvaVar = rvaVar.d) != null) {
            qvaVar.notifyDataSetChanged();
        }
    }

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public void onSaveInstanceState(Bundle bundle) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, bundle) == null) {
            super.onSaveInstanceState(bundle);
            this.i.o(bundle);
        }
    }

    @Override // com.baidu.tieba.uwa
    public void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048589, this, str) != null) || this.e == null) {
            return;
        }
        F(str);
    }

    @Override // com.baidu.tieba.uwa
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
            hxa hxaVar = (hxa) this.d;
            if (this.h.o().getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            hxaVar.a = z;
            y(this.d);
            this.b.w();
            this.b.i();
        }
    }

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public void r(zi5 zi5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, zi5Var) == null) {
            super.r(zi5Var);
            if (this.b != null && this.e != null && this.h != null && zi5Var.a == 24) {
                Object obj = zi5Var.c;
                if (!(obj instanceof yd5)) {
                    return;
                }
                yd5 yd5Var = (yd5) obj;
                if (EmotionGroupType.isSendAsPic(yd5Var.getType()) && this.i.b(this.b, yd5Var) != null) {
                    this.b.i();
                    this.b.x(new int[]{10, 34});
                    this.h.u(this.i.g(), this.e.getFrom(), this.e.getForumId());
                }
            }
        }
    }

    @Override // com.baidu.tieba.wwa
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
            hxa hxaVar = (hxa) this.d;
            if (this.h.o().getVisibility() == 0) {
                z = true;
            } else {
                z = false;
            }
            hxaVar.a = z;
            y(this.d);
        }
    }

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            this.i.q(this);
            rva rvaVar = this.h;
            if (rvaVar != null) {
                rvaVar.n();
            }
        }
    }

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
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

    @Override // com.baidu.tieba.rwa, com.baidu.tieba.wwa
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048583, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            this.i.m(i, i2, intent);
        }
    }

    @Override // com.baidu.tieba.wwa
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d051d, viewGroup, false);
            this.c = inflate;
            this.g = (WriteImageGridView) inflate.findViewById(R.id.obfuscated_res_0x7f092a2f);
            rva rvaVar = new rva(this.a, this.c);
            this.h = rvaVar;
            rvaVar.r(this.j);
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
