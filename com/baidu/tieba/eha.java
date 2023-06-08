package com.baidu.tieba;

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
import com.baidu.tbadk.core.view.NormalItemCell;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.xia;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class eha extends mha<fia> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public NormalItemCell g;
    @Nullable
    public xia h;
    public final xia.b i;

    @Override // com.baidu.tieba.rha
    public void a(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.rha
    public void c(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.rha
    public void e(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
        }
    }

    /* loaded from: classes5.dex */
    public class a implements xia.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ eha a;

        public a(eha ehaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ehaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ehaVar;
        }

        @Override // com.baidu.tieba.xia.b
        public void a(@NonNull SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) {
                if (this.a.e != null) {
                    this.a.e.setForumId(selectForumData.forumId);
                    this.a.e.setForumName(selectForumData.forumName);
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
        public final /* synthetic */ eha a;

        public b(eha ehaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ehaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ehaVar;
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
    public eha(TbPageContext<?> tbPageContext) {
        super(tbPageContext, fia.class);
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

    @Override // com.baidu.tieba.mha, com.baidu.tieba.rha
    public void j(@NonNull tha thaVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, thaVar) == null) {
            super.j(thaVar);
            if (this.h == null) {
                xia xiaVar = new xia();
                this.h = xiaVar;
                xiaVar.c(this.i);
            }
            this.h.b(this.a.getUniqueId());
        }
    }

    @Override // com.baidu.tieba.rha
    public void onChangeSkinType(int i) {
        NormalItemCell normalItemCell;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048583, this, i) == null) && (normalItemCell = this.g) != null) {
            normalItemCell.d();
        }
    }

    public final boolean F() {
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

    @Override // com.baidu.tieba.mha, com.baidu.tieba.rha
    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.d();
            xia xiaVar = this.h;
            if (xiaVar != null) {
                xiaVar.d();
            }
        }
    }

    @Override // com.baidu.tieba.mha, com.baidu.tieba.rha
    public boolean o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (F()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a.getPageActivity())));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.rha
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d0538, viewGroup, false);
            this.c = inflate;
            this.g = (NormalItemCell) inflate.findViewById(R.id.obfuscated_res_0x7f091d53);
            NormalItemCell.a aVar = new NormalItemCell.a();
            aVar.a = R.color.CAM_X0206;
            aVar.c = R.drawable.icon_pure_ba16;
            aVar.b = 1;
            aVar.f = this.a.getString(R.string.obfuscated_res_0x7f0f0438);
            aVar.e = this.a.getString(R.string.obfuscated_res_0x7f0f0436);
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
