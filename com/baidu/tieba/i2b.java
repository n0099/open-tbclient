package com.baidu.tieba;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.WriteVoteActivityConfig;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.coreExtra.data.WriteVoteData;
import com.baidu.tieba.x4b;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes6.dex */
public class i2b extends k2b<i3b> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public RelativeLayout g;
    @Nullable
    public x4b h;

    /* loaded from: classes6.dex */
    public class a implements x4b.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ i2b a;

        public a(i2b i2bVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i2bVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = i2bVar;
        }

        @Override // com.baidu.tieba.x4b.b
        public void a(WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeVoteData) == null) {
                if (this.a.b != null) {
                    this.a.b.w();
                }
                ((i3b) this.a.d).a = writeVoteData;
                if (this.a.e != null) {
                    this.a.e.setWriteVoteData(writeVoteData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ WriteVoteData a;
        public final /* synthetic */ i2b b;

        public b(i2b i2bVar, WriteVoteData writeVoteData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i2bVar, writeVoteData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i2bVar;
            this.a = writeVoteData;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, view2) != null) {
                return;
            }
            this.b.F(this.a);
            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 3));
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public i2b(TbPageContext<?> tbPageContext) {
        super(tbPageContext, i3b.class);
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

    public final void F(WriteVoteData writeVoteData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, writeVoteData) == null) {
            WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.a.getPageActivity(), 25048);
            if (writeVoteData != null) {
                writeVoteActivityConfig.setExtraData(writeVoteData);
            }
            this.a.sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
        }
    }

    @Override // com.baidu.tieba.p2b
    public void a(WriteData writeData) {
        x4b x4bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, writeData) == null) && (x4bVar = this.h) != null) {
            writeData.setWriteVoteData(x4bVar.c());
        }
    }

    @Override // com.baidu.tieba.p2b
    public void c(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) && this.e != null && writeData.getWriteVoteData() != null) {
            this.e.setWriteVoteData(writeData.getWriteVoteData());
            G();
        }
    }

    @Override // com.baidu.tieba.p2b
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, writeData) == null) {
            writeData.setWriteVoteData(((i3b) this.d).a);
        }
    }

    @Override // com.baidu.tieba.p2b
    public void onChangeSkinType(int i) {
        x4b x4bVar;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeI(1048582, this, i) == null) && (x4bVar = this.h) != null) {
            x4bVar.d(i);
        }
    }

    public final void G() {
        WriteData writeData;
        WriteVoteData writeVoteData;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) != null) || (writeData = this.e) == null || this.h == null) {
            return;
        }
        D d = this.d;
        if (((i3b) d).a != null) {
            writeVoteData = ((i3b) d).a;
            writeData.setWriteVoteData(writeVoteData);
        } else if (writeData.getWriteVoteData() != null) {
            ((i3b) this.d).a = this.e.getWriteVoteData();
            writeVoteData = this.e.getWriteVoteData();
        } else {
            ((i3b) this.d).a = null;
            return;
        }
        b bVar = new b(this, writeVoteData);
        this.h.g(bVar);
        this.h.f(bVar);
        this.h.h(writeVoteData);
        this.h.i(true);
        r2b r2bVar = this.b;
        if (r2bVar != null) {
            r2bVar.j();
        }
    }

    @Override // com.baidu.tieba.k2b, com.baidu.tieba.p2b
    public void onActivityResult(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            super.onActivityResult(i, i2, intent);
            if (i2 != -1 || i != 25048 || intent == null) {
                return;
            }
            Serializable serializableExtra = intent.getSerializableExtra(IntentConfig.WRITE_VOTE_DATA);
            if (serializableExtra instanceof WriteVoteData) {
                ((i3b) this.d).a = (WriteVoteData) serializableExtra;
                G();
            }
        }
    }

    @Override // com.baidu.tieba.k2b, com.baidu.tieba.p2b
    public void r(zh5 zh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, zh5Var) == null) {
            super.r(zh5Var);
            if (zh5Var.a == 22) {
                n1b.b(this.a.getPageActivity(), 10);
                WriteVoteData writeVoteData = null;
                x4b x4bVar = this.h;
                if (x4bVar != null && x4bVar.c() != null) {
                    writeVoteData = this.h.c();
                }
                WriteVoteActivityConfig writeVoteActivityConfig = new WriteVoteActivityConfig(this.a.getPageActivity(), 25048);
                if (writeVoteData != null) {
                    writeVoteActivityConfig.setExtraData(writeVoteData);
                }
                this.a.sendMessage(new CustomMessage(2002001, writeVoteActivityConfig));
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_WRITE_VOTE_VIEW_SHOW).param("obj_source", 2));
                r2b r2bVar = this.b;
                if (r2bVar != null) {
                    r2bVar.D();
                }
            }
        }
    }

    @Override // com.baidu.tieba.p2b
    public View s(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d05a2, viewGroup, false);
            this.c = inflate;
            RelativeLayout relativeLayout = (RelativeLayout) inflate.findViewById(R.id.obfuscated_res_0x7f0929ef);
            this.g = relativeLayout;
            x4b x4bVar = new x4b(this.a, relativeLayout);
            this.h = x4bVar;
            x4bVar.e(new a(this));
            WriteData writeData = this.e;
            if (writeData != null) {
                ((i3b) this.d).a = writeData.getWriteVoteData();
                G();
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }

    @Override // com.baidu.tieba.k2b, com.baidu.tieba.p2b
    public boolean t() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            if (((i3b) this.d).a != null) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }
}
