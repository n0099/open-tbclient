package com.baidu.tieba;

import android.content.Context;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlbumFloatActivityConfig;
import com.baidu.tbadk.core.atomData.AtListActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class dk7 extends o65 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public String a;
    public String b;
    public String c;
    public boolean d;
    public boolean e;

    /* loaded from: classes4.dex */
    public class a implements n65 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ck7 a;
        public final /* synthetic */ dk7 b;

        public a(dk7 dk7Var, ck7 ck7Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {dk7Var, ck7Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = dk7Var;
            this.a = ck7Var;
        }

        @Override // com.baidu.tieba.n65
        public void A(m65 m65Var) {
            ck7 ck7Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, m65Var) != null) || (ck7Var = this.a) == null || ck7Var.b() == null || m65Var == null) {
                return;
            }
            int i = m65Var.a;
            if (i != 4) {
                if (i != 32) {
                    if (i != 36) {
                        if (i != 7) {
                            if (i != 8) {
                                if (i != 10) {
                                    if (i != 11) {
                                        switch (i) {
                                            case 14:
                                                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getContext().getPageActivity(), this.a.v().toJsonString(), true, true);
                                                if (!StringUtils.isNull(this.b.b, true)) {
                                                    albumFloatActivityConfig.getIntent().putExtra("forum_id", this.b.b);
                                                }
                                                albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                                                if (k85.a().b() == 1) {
                                                    albumFloatActivityConfig.setRequestFrom(2);
                                                    if (this.a.v() != null) {
                                                        this.a.v().setMaxImagesAllowed(1);
                                                    }
                                                } else if (this.a.v() != null) {
                                                    this.a.v().setMaxImagesAllowed(9);
                                                }
                                                yi.z(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                                                return;
                                            case 15:
                                                int intValue = ((Integer) m65Var.c).intValue();
                                                if (this.a.v() != null && this.a.v().getChosedFiles() != null && (size = this.a.v().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.v(), intValue)));
                                                    return;
                                                }
                                                return;
                                            case 16:
                                                if (this.b.d) {
                                                    yi.P(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                                                }
                                                if (!this.b.j(this.a.getContext(), 11025)) {
                                                    return;
                                                }
                                                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12004, true);
                                                if (this.a.u() != null) {
                                                    atListActivityConfig.setSelectedAtList(this.a.u().t());
                                                }
                                                atListActivityConfig.setFromTid(this.b.c);
                                                atListActivityConfig.setFromFid(this.b.b);
                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                                                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                                                statisticItem.addParam("tid", this.b.c);
                                                statisticItem.addParam("fid", this.b.b);
                                                TiebaStatic.log(statisticItem);
                                                return;
                                            default:
                                                return;
                                        }
                                    }
                                    this.a.m0(null);
                                    return;
                                }
                                Object obj = m65Var.c;
                                if (obj instanceof VoiceData.VoiceModel) {
                                    this.a.m0((VoiceData.VoiceModel) obj);
                                    this.a.w(true, null);
                                    return;
                                }
                                return;
                            } else if (!this.b.j(this.a.getContext(), 11001)) {
                                return;
                            } else {
                                this.a.G(null, null);
                                return;
                            }
                        }
                        yi.P(TbadkCoreApplication.getInst().getContext(), R.string.over_limit_tip);
                        this.b.d = true;
                        return;
                    } else if (!this.b.j(this.a.getContext(), 11040)) {
                        return;
                    } else {
                        this.a.S();
                        return;
                    }
                }
                this.a.b().B(new m65(1, 11, null));
                return;
            }
            this.a.e0(m65Var.c.toString());
            Object obj2 = m65Var.c;
            if (obj2 instanceof SpanGroupManager) {
                this.a.j0((SpanGroupManager) obj2);
            }
            this.b.d = false;
        }
    }

    public dk7() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = false;
    }

    public void l(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.c = str;
        }
    }

    public void k(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048580, this, str, str2) == null) {
            this.a = str;
            this.b = str2;
        }
    }

    @Override // com.baidu.tieba.o65
    public q65 b(Context context) {
        InterceptResult invokeL;
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setBarMaxLauCount(5);
            if (this.e) {
                i = 2;
            } else {
                i = 3;
            }
            editorTools.setBarLauncherType(i);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.setDeskBackgroundColorId(R.color.CAM_X0207);
            editorTools.E(false);
            editorTools.setMoreButtonAtEnd(true);
            editorTools.setHideBigEmotion(this.e);
            return new ck7(editorTools);
        }
        return (q65) invokeL.objValue;
    }

    @Override // com.baidu.tieba.o65
    public void c(q65 q65Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, q65Var) != null) || !(q65Var instanceof ck7)) {
            return;
        }
        EditorTools b = q65Var.b();
        a aVar = new a(this, (ck7) q65Var);
        b.setActionListener(5, aVar);
        b.setActionListener(4, aVar);
        b.setActionListener(7, aVar);
        b.setActionListener(16, aVar);
        b.setActionListener(14, aVar);
        b.setActionListener(15, aVar);
        b.setActionListener(8, aVar);
        b.setActionListener(10, aVar);
        b.setActionListener(11, aVar);
        b.setActionListener(36, aVar);
        b.setActionListener(32, aVar);
    }

    @Override // com.baidu.tieba.o65
    public void d(q65 q65Var) {
        int i;
        CustomResponsedMessage runTask;
        x65 x65Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, q65Var) == null) {
            EditorTools b = q65Var.b();
            if (eu8.a() && jr8.a(this.a, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), x65.class)) != null && (x65Var = (x65) runTask.getData()) != null) {
                x65Var.l = 2;
                b.d(x65Var);
            }
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            b.h(arrayList);
            x65 o = b.o(5);
            if (o != null) {
                o.e(!this.e);
                o.f(!this.e);
                if (this.e) {
                    i = 1;
                } else {
                    i = 3;
                }
                o.l = i;
            }
            z65 z65Var = new z65(b.getContext(), 4);
            z65Var.i = false;
            b.d(z65Var);
            if (!this.e) {
                b.d(new i75(b.getContext(), 1));
                CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, b.getContext()), x65.class);
                if (runTask2 != null && runTask2.getData() != null) {
                    x65 x65Var2 = (x65) runTask2.getData();
                    x65Var2.l = 6;
                    b.d(x65Var2);
                }
                b.d(new p85(b.getContext(), false, true, 12004));
                CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, b.getContext()), x65.class);
                if (runTask3 != null && runTask3.getData() != null) {
                    x65 x65Var3 = (x65) runTask3.getData();
                    x65Var3.l = 7;
                    b.d(x65Var3);
                }
                b.d(new g75(b.getContext(), 5));
            } else {
                b.d(new p85(b.getContext(), false, false, 12004));
            }
            b.f();
        }
    }

    public final boolean j(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            if (kc5.k()) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
