package com.baidu.tieba;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.SelectForumConfig;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.view.NormalItemCell;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.x3b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class e2b extends m2b<f3b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public NormalItemCell g;
    @Nullable
    public x3b h;
    public final x3b.b i;

    @Override // com.baidu.tieba.r2b
    public void a(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.r2b
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.r2b
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements x3b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2b a;

        public a(e2b e2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e2bVar;
        }

        @Override // com.baidu.tieba.x3b.b
        public void a(@NonNull SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) {
                if (this.a.e != null) {
                    this.a.e.setForumId(selectForumData.forumId);
                    this.a.e.setForumName(selectForumData.forumName);
                    this.a.e.setFirstClass(selectForumData.firstCategory);
                }
                if (this.a.g != null) {
                    this.a.g.setSubTitle(selectForumData.forumName);
                }
                this.a.y(selectForumData);
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ e2b a;

        public b(e2b e2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = e2bVar;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, view2) == null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a.a.getPageActivity())));
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public e2b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, f3b.class);
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
        this.i = new a(this);
    }

    @Override // com.baidu.tieba.m2b, com.baidu.tieba.r2b
    public void j(@NonNull t2b t2bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, t2bVar) == null) {
            super.j(t2bVar);
            if (this.h == null) {
                x3b x3bVar = new x3b();
                this.h = x3bVar;
                x3bVar.c(this.i);
            }
            this.h.b(this.a.getUniqueId());
        }
    }

    @Override // com.baidu.tieba.r2b
    public void onChangeSkinType(int i) {
        NormalItemCell normalItemCell;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(InputDeviceCompat.SOURCE_TOUCHPAD, this, i) == null) && (normalItemCell = this.g) != null) {
            normalItemCell.e();
        }
    }

    public final boolean G() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = this.e;
            if (writeData != null && "2".equals(writeData.getCallFrom())) {
                return TextUtils.isEmpty(this.e.getForumName());
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.m2b, com.baidu.tieba.r2b
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.b();
            x3b x3bVar = this.h;
            if (x3bVar != null) {
                x3bVar.d();
            }
        }
    }

    @Override // com.baidu.tieba.m2b, com.baidu.tieba.r2b
    public void m(Bundle bundle, Intent intent, @NonNull WriteData writeData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048582, this, bundle, intent, writeData) == null) {
            super.m(bundle, intent, writeData);
            if (bundle != null) {
                str = bundle.getString(WriteActivityConfig.FORUM_FIRST_CATEGORY);
            } else if (intent != null) {
                str = intent.getStringExtra(WriteActivityConfig.FORUM_FIRST_CATEGORY);
            } else {
                str = "";
            }
            writeData.setFirstClass(str);
        }
    }

    @Override // com.baidu.tieba.m2b, com.baidu.tieba.r2b
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            if (G()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a.getPageActivity())));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.r2b
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d054f, viewGroup, false);
            this.c = inflate;
            this.g = (NormalItemCell) inflate.findViewById(R.id.obfuscated_res_0x7f091e11);
            NormalItemCell.a aVar = new NormalItemCell.a();
            aVar.a = R.color.CAM_X0206;
            aVar.c = R.drawable.icon_pure_ba16;
            aVar.b = 1;
            aVar.f = this.a.getString(R.string.obfuscated_res_0x7f0f043f);
            aVar.e = this.a.getString(R.string.obfuscated_res_0x7f0f043d);
            NormalItemCell normalItemCell = this.g;
            if (normalItemCell != null) {
                normalItemCell.setConfig(aVar);
                this.g.setOnClickListener(new b(this));
                WriteData writeData = this.e;
                if (writeData != null && "2".equals(writeData.getCallFrom()) && !TextUtils.isEmpty(this.e.getForumName())) {
                    this.g.setSubTitle(this.e.getForumName());
                    this.g.setOnClickListener(null);
                    this.g.a();
                }
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
