package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.WebPManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.voice.PlayVoiceBntNew;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class e69 extends h69<e79> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public View g;
    @Nullable
    public PlayVoiceBntNew h;
    @Nullable
    public ImageView i;

    /* loaded from: classes3.dex */
    public class a implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e69 a;

        public a(e69 e69Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e69Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e69Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.a.B();
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e69(TbPageContext<?> tbPageContext) {
        super(tbPageContext, e79.class);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
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
    }

    @Override // com.baidu.tieba.m69
    public void c(WriteData writeData) {
        PlayVoiceBntNew playVoiceBntNew;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, writeData) != null) || (playVoiceBntNew = this.h) == null) {
            return;
        }
        VoiceData.VoiceModel voiceModel = playVoiceBntNew.getVoiceModel();
        writeData.setVoiceModel(voiceModel);
        if (voiceModel != null) {
            if (voiceModel.getId() != null) {
                writeData.setVoice(voiceModel.getId());
                writeData.setVoiceDuringTime(voiceModel.duration);
                return;
            }
            writeData.setVoice(null);
            writeData.setVoiceDuringTime(-1);
            return;
        }
        writeData.setVoice(null);
        writeData.setVoiceDuringTime(-1);
    }

    @Override // com.baidu.tieba.m69
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) && writeData.getVoiceModel() != null) {
            A(writeData.getVoiceModel());
        }
    }

    @Override // com.baidu.tieba.m69
    public void e(@NonNull WriteData writeData) {
        PlayVoiceBntNew playVoiceBntNew;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, writeData) != null) || (playVoiceBntNew = this.h) == null) {
            return;
        }
        writeData.setVoiceModel(playVoiceBntNew.getVoiceModel());
    }

    @Override // com.baidu.tieba.m69
    public void onChangeSkinType(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048582, this, i) == null) {
            WebPManager.setPureDrawable(this.i, R.drawable.obfuscated_res_0x7f080978, R.color.CAM_X0107, null);
            PlayVoiceBntNew playVoiceBntNew = this.h;
            if (playVoiceBntNew != null) {
                playVoiceBntNew.e();
            }
        }
    }

    @Override // com.baidu.tieba.h69, com.baidu.tieba.m69
    public void r(e65 e65Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, e65Var) == null) {
            super.r(e65Var);
            int i = e65Var.a;
            if (i == 10) {
                Object obj = e65Var.c;
                if (obj instanceof VoiceData.VoiceModel) {
                    A((VoiceData.VoiceModel) obj);
                }
            } else if (i == 11) {
                B();
            }
        }
    }

    public final void A(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, voiceModel) == null) && this.g != null && this.h != null && voiceModel != null && this.e != null && !TextUtils.isEmpty(voiceModel.voiceId) && voiceModel.duration > 0) {
            ((e79) this.d).a = voiceModel;
            this.e.setVoiceModel(voiceModel);
            this.g.setVisibility(0);
            this.h.setVoiceModel(voiceModel);
            this.h.o();
            o69 o69Var = this.b;
            if (o69Var != null) {
                o69Var.i();
                this.b.x(new int[]{34});
            }
        }
    }

    @Override // com.baidu.tieba.m69
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0525, viewGroup, false);
            this.g = inflate;
            this.h = (PlayVoiceBntNew) inflate.findViewById(R.id.obfuscated_res_0x7f09046b);
            ImageView imageView = (ImageView) this.g.findViewById(R.id.obfuscated_res_0x7f091031);
            this.i = imageView;
            if (imageView != null) {
                imageView.setOnClickListener(new a(this));
            }
            return this.g;
        }
        return (View) invokeL.objValue;
    }

    public final void B() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || this.g == null || this.h == null || this.e == null) {
            return;
        }
        D d = this.d;
        if (((e79) d).a != null) {
            s05.a(s05.b(((e79) d).a.voiceId));
        }
        ((e79) this.d).a = null;
        this.e.setVoiceModel(null);
        this.g.setVisibility(8);
        this.h.p();
        this.h.setVoiceModel(null);
        o69 o69Var = this.b;
        if (o69Var != null) {
            o69Var.f();
            this.b.i();
            this.b.x(new int[]{34});
        }
    }

    @Override // com.baidu.tieba.h69, com.baidu.tieba.m69
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
        }
    }

    @Override // com.baidu.tieba.h69, com.baidu.tieba.m69
    public boolean t() {
        InterceptResult invokeV;
        PlayVoiceBntNew playVoiceBntNew;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            View view2 = this.g;
            if (view2 == null || view2.getVisibility() != 0 || (playVoiceBntNew = this.h) == null || playVoiceBntNew.getVoiceModel() == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }
}
