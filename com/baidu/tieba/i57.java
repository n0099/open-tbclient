package com.baidu.tieba;

import android.content.Context;
import android.text.InputFilter;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class i57 extends j55 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public boolean a;

    /* loaded from: classes4.dex */
    public class a implements i55 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ h57 a;
        public final /* synthetic */ i57 b;

        public a(i57 i57Var, h57 h57Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {i57Var, h57Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = i57Var;
            this.a = h57Var;
        }

        @Override // com.baidu.tieba.i55
        public void B(h55 h55Var) {
            int size;
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, h55Var) == null) || h55Var == null) {
                return;
            }
            int i = h55Var.a;
            if (i == 4 || i == 6) {
                this.a.H((String) h55Var.c);
                this.b.a = false;
            } else if (i == 7) {
                this.a.getContext().showToast((int) R.string.obfuscated_res_0x7f0f0d37);
                this.b.a = true;
            } else if (i == 8) {
                if (this.b.g(this.a.getContext(), 11001)) {
                    this.a.y();
                    TiebaStatic.log(new StatisticItem("c13363").param("topic_id", String.valueOf(this.a.s())));
                }
            } else if (i != 14) {
                if (i != 15) {
                    return;
                }
                int intValue = ((Integer) h55Var.c).intValue();
                if (this.a.r() != null && this.a.r().getChosedFiles() != null && (size = this.a.r().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.r(), intValue)));
                }
            } else {
                AlbumActivityConfig albumActivityConfig = new AlbumActivityConfig((Context) this.a.getContext().getPageActivity(), this.a.r().toJsonString(), true, true);
                albumActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                if (f75.a().b() == 1) {
                    albumActivityConfig.setRequestFrom(4);
                    if (this.a.r() != null) {
                        this.a.r().setMaxImagesAllowed(1);
                    }
                } else if (this.a.r() != null) {
                    this.a.r().setMaxImagesAllowed(10);
                }
                ej.x(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumActivityConfig));
            }
        }
    }

    public i57() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.j55
    public l55 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(false);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarLauncherType(2);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.D(false);
            return new h57(editorTools);
        }
        return (l55) invokeL.objValue;
    }

    @Override // com.baidu.tieba.j55
    public void c(l55 l55Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, l55Var) == null) || l55Var == null) {
            return;
        }
        EditorTools a2 = l55Var.a();
        a aVar = new a(this, (h57) l55Var);
        a2.setActionListener(5, aVar);
        a2.setActionListener(4, aVar);
        a2.setActionListener(6, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(14, aVar);
        a2.setActionListener(15, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(32, aVar);
        a2.setActionListener(45, aVar);
    }

    @Override // com.baidu.tieba.j55
    public void d(l55 l55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, l55Var) == null) {
            EditorTools a2 = l55Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            a2.h(arrayList);
            s55 n = a2.n(5);
            if (n != null) {
                n.e(false);
                n.l = 1;
            }
            a2.d(new d65(a2.getContext(), 3));
            j57 j57Var = new j57(a2.getContext());
            if (j57Var.g() != null) {
                j57Var.g().setFilters(new InputFilter[]{new InputFilter.LengthFilter(14000)});
            }
            a2.d(j57Var);
            a2.f();
            a2.A(new h55(35, 5, Boolean.FALSE));
            a2.q();
        }
    }

    public final boolean g(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount == null || currentAccount.length() <= 0) {
                TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
                return false;
            }
            return true;
        }
        return invokeLI.booleanValue;
    }
}
