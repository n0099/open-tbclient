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
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.SelectForumData;
import com.baidu.tieba.s59;
import com.baidu.tieba.write.view.ForumSelectedView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class b49 extends n49<z49> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @Nullable
    public ForumSelectedView g;
    @Nullable
    public s59 h;
    @Nullable
    public SelectForumData i;
    public final s59.b j;

    /* loaded from: classes3.dex */
    public class a implements s59.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ b49 a;

        public a(b49 b49Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {b49Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = b49Var;
        }

        @Override // com.baidu.tieba.s59.b
        public void a(@NonNull SelectForumData selectForumData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, selectForumData) == null) {
                this.a.i = selectForumData;
                if (this.a.e != null) {
                    this.a.e.setForumId(selectForumData.forumId);
                    this.a.e.setForumName(selectForumData.forumName);
                }
                if (this.a.g != null) {
                    this.a.g.setSelectedForum(selectForumData.forumName);
                }
                this.a.w(selectForumData);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b49(TbPageContext<?> tbPageContext) {
        super(tbPageContext, z49.class);
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
        this.j = new a(this);
    }

    public final boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            WriteData writeData = this.e;
            if (writeData == null || !"2".equals(writeData.getCallFrom())) {
                return false;
            }
            return TextUtils.isEmpty(this.e.getForumName());
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s49
    public void b(WriteData writeData) {
        SelectForumData selectForumData;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, writeData) == null) || (selectForumData = this.i) == null) {
            return;
        }
        writeData.setForumId(selectForumData.forumId);
        writeData.setForumName(this.i.forumName);
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void c() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.c();
            s59 s59Var = this.h;
            if (s59Var != null) {
                s59Var.d();
            }
        }
    }

    @Override // com.baidu.tieba.s49
    public void d(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public void h(@NonNull u49 u49Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, u49Var) == null) {
            super.h(u49Var);
            if (this.h == null) {
                s59 s59Var = new s59();
                this.h = s59Var;
                s59Var.c(this.j);
            }
            this.h.b(this.a.getUniqueId());
        }
    }

    @Override // com.baidu.tieba.s49
    public void k(@NonNull WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, writeData) == null) {
        }
    }

    @Override // com.baidu.tieba.n49, com.baidu.tieba.s49
    public boolean n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            if (D()) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new SelectForumConfig(this.a.getPageActivity())));
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.s49
    public void onChangeSkinType(int i) {
        ForumSelectedView forumSelectedView;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeI(1048583, this, i) == null) || (forumSelectedView = this.g) == null) {
            return;
        }
        forumSelectedView.c();
    }

    @Override // com.baidu.tieba.s49
    public View q(@NonNull ViewGroup viewGroup) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, viewGroup)) == null) {
            View inflate = LayoutInflater.from(this.a.getPageActivity()).inflate(R.layout.obfuscated_res_0x7f0d04a0, viewGroup, false);
            this.c = inflate;
            ForumSelectedView forumSelectedView = (ForumSelectedView) inflate.findViewById(R.id.obfuscated_res_0x7f091e3e);
            this.g = forumSelectedView;
            WriteData writeData = this.e;
            if (writeData != null && forumSelectedView != null) {
                if ("main_tab".equals(writeData.getFrom()) && !this.e.isFromErrorDialog()) {
                    this.g.setVisibility(0);
                } else if (!TextUtils.isEmpty(this.e.getForumName())) {
                    this.g.setVisibility(0);
                    this.g.setSelectedForum(this.e.getForumName());
                    this.g.a();
                    this.g.setOnClickListener(null);
                } else {
                    this.g.setVisibility(8);
                }
            }
            return this.c;
        }
        return (View) invokeL.objValue;
    }
}
