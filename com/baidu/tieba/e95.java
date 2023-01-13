package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
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
import com.baidu.tbadk.core.atomData.HotSelectActivityConfig;
import com.baidu.tbadk.core.atomData.LoginActivityConfig;
import com.baidu.tbadk.core.atomData.WriteMulitImageActivityConfig;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class e95 extends b75 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public String b;
    public String c;
    public boolean d;
    public DataModel<?> e;

    /* loaded from: classes4.dex */
    public class a implements a75 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c95 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ e95 c;

        public a(e95 e95Var, c95 c95Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {e95Var, c95Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = e95Var;
            this.a = c95Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.a75
        public void A(z65 z65Var) {
            c95 c95Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, z65Var) != null) || (c95Var = this.a) == null || c95Var.b() == null || z65Var == null) {
                return;
            }
            int i = z65Var.a;
            if (i != 4) {
                if (i != 5) {
                    if (i != 7) {
                        if (i != 8) {
                            if (i != 10) {
                                if (i != 11) {
                                    if (i != 29) {
                                        if (i != 32) {
                                            if (i != 36) {
                                                if (i != 43) {
                                                    if (i != 67) {
                                                        switch (i) {
                                                            case 14:
                                                                AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.getContext().getPageActivity(), this.a.v().toJsonString(), true, true);
                                                                if (!StringUtils.isNull(this.c.c, true)) {
                                                                    albumFloatActivityConfig.getIntent().putExtra("from", this.c.c);
                                                                }
                                                                if (this.c.a != null && !StringUtils.isNull(this.c.a.getId(), true)) {
                                                                    albumFloatActivityConfig.getIntent().putExtra("forum_id", this.c.a.getId());
                                                                }
                                                                albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                                                                if (x85.a().b() == 1) {
                                                                    albumFloatActivityConfig.setRequestFrom(2);
                                                                    if (this.a.v() != null) {
                                                                        this.a.v().setMaxImagesAllowed(1);
                                                                    }
                                                                } else if (this.a.v() != null) {
                                                                    this.a.v().setMaxImagesAllowed(9);
                                                                }
                                                                zi.z(this.a.getContext().getPageActivity(), this.a.getContext().getPageActivity().getCurrentFocus());
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                                                                return;
                                                            case 15:
                                                                int intValue = ((Integer) z65Var.c).intValue();
                                                                if (this.a.v() != null && this.a.v().getChosedFiles() != null && (size = this.a.v().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.getContext().getPageActivity(), 12012, this.a.v(), intValue)));
                                                                    return;
                                                                }
                                                                return;
                                                            case 16:
                                                                if (this.c.d) {
                                                                    this.a.getContext().showToast(R.string.over_limit_tip);
                                                                }
                                                                if (!this.c.k(this.a.getContext(), 11025)) {
                                                                    return;
                                                                }
                                                                AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.getContext().getPageActivity(), 12004, true);
                                                                if (this.a.u() != null) {
                                                                    atListActivityConfig.setSelectedAtList(this.a.u().t());
                                                                }
                                                                if (this.c.e != null) {
                                                                    atListActivityConfig.setFromTid(this.c.e.J());
                                                                    atListActivityConfig.setFromFid(this.c.e.getForumId());
                                                                }
                                                                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                                                                StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                                                                statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                                                                if (this.c.e != null) {
                                                                    statisticItem.addParam("tid", this.c.e.J());
                                                                    statisticItem.addParam("fid", this.c.e.getForumId());
                                                                }
                                                                TiebaStatic.log(statisticItem);
                                                                return;
                                                            default:
                                                                return;
                                                        }
                                                    }
                                                    Object obj = z65Var.c;
                                                    if (obj != null && (obj instanceof Boolean)) {
                                                        this.a.h0(((Boolean) obj).booleanValue());
                                                        return;
                                                    }
                                                    return;
                                                } else if (!ck5.c(this.a.getContext(), true, false)) {
                                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.getContext().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                                                    if (this.c.a != null) {
                                                        hotSelectActivityConfig.setForumExtra(yg.g(this.c.a.getId(), 0L), this.c.a.getFirst_class(), this.c.a.getSecond_class());
                                                    }
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (!this.c.k(this.a.getContext(), 11040)) {
                                                return;
                                            } else {
                                                this.a.S();
                                                return;
                                            }
                                        }
                                        this.a.b().C(new z65(1, 11, null));
                                        return;
                                    }
                                    this.a.b().C(new z65(2, 19, null));
                                    this.a.b().C(new z65(1, 2, null));
                                    this.a.k();
                                    return;
                                }
                                this.a.m0(null);
                                return;
                            }
                            Object obj2 = z65Var.c;
                            if (obj2 instanceof VoiceData.VoiceModel) {
                                this.a.m0((VoiceData.VoiceModel) obj2);
                                this.a.w(true, null);
                                return;
                            }
                            return;
                        } else if (!this.c.k(this.a.getContext(), 11001)) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        } else {
                            this.a.G(null, null);
                            return;
                        }
                    }
                    this.a.getContext().showToast(R.string.over_limit_tip);
                    this.c.d = true;
                    return;
                } else if (!this.b.w()) {
                    TiebaStatic.eventStat(this.b.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
                    return;
                } else {
                    return;
                }
            }
            this.a.e0(z65Var.c.toString());
            Object obj3 = z65Var.c;
            if (obj3 instanceof SpanGroupManager) {
                this.a.j0((SpanGroupManager) obj3);
            }
            this.c.d = false;
        }
    }

    public e95() {
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
        this.b = null;
        this.c = null;
        this.d = false;
    }

    public ForumData l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.a;
        }
        return (ForumData) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.c;
        }
        return (String) invokeV.objValue;
    }

    public DataModel<?> n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.e;
        }
        return (DataModel) invokeV.objValue;
    }

    public void o(ForumData forumData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, forumData) == null) {
            this.a = forumData;
        }
    }

    public void p(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, str) == null) {
            this.b = str;
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, str) == null) {
            this.c = str;
        }
    }

    public void r(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048586, this, dataModel) == null) {
            this.e = dataModel;
        }
    }

    @Override // com.baidu.tieba.b75
    public d75 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.F(false);
            editorTools.setMoreButtonAtEnd(true);
            c95 c95Var = new c95(editorTools);
            c95Var.b0(this.e);
            return c95Var;
        }
        return (d75) invokeL.objValue;
    }

    @Override // com.baidu.tieba.b75
    public void c(d75 d75Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, d75Var) != null) || !(d75Var instanceof c95)) {
            return;
        }
        EditorTools b = d75Var.b();
        a aVar = new a(this, (c95) d75Var, b);
        b.setActionListener(5, aVar);
        b.setActionListener(4, aVar);
        b.setActionListener(7, aVar);
        b.setActionListener(16, aVar);
        b.setActionListener(14, aVar);
        b.setActionListener(15, aVar);
        b.setActionListener(8, aVar);
        b.setActionListener(10, aVar);
        b.setActionListener(11, aVar);
        b.setActionListener(27, aVar);
        b.setActionListener(29, aVar);
        b.setActionListener(36, aVar);
        b.setActionListener(32, aVar);
        b.setActionListener(43, aVar);
        b.setActionListener(45, aVar);
        b.setActionListener(67, aVar);
    }

    @Override // com.baidu.tieba.b75
    public void d(d75 d75Var) {
        CustomResponsedMessage runTask;
        k75 k75Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, d75Var) == null) {
            EditorTools b = d75Var.b();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            b.d(new v75(b.getContext(), 1));
            if (bz8.a() && gw8.a(this.b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, b.getContext()), k75.class)) != null && (k75Var = (k75) runTask.getData()) != null) {
                k75Var.l = 2;
                b.d(k75Var);
            }
            m75 m75Var = new m75(b.getContext(), 4);
            m75Var.i = false;
            b.d(m75Var);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, b.getContext()), k75.class);
            if (runTask2 != null && runTask2.getData() != null) {
                k75 k75Var2 = (k75) runTask2.getData();
                k75Var2.l = 6;
                b.d(k75Var2);
            }
            b.d(new d95(b.getContext(), false, true, 12004));
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, b.getContext()), k75.class);
            if (runTask3 != null && runTask3.getData() != null) {
                k75 k75Var3 = (k75) runTask3.getData();
                k75Var3.l = 7;
                b.d(k75Var3);
            }
            if (!"PbChosenActivity".equals(b.getContext().getClass().getSimpleName())) {
                b.d(new t75(b.getContext(), 5));
            }
            b.h(arrayList);
            k75 p = b.p(5);
            if (p != null) {
                p.l = 3;
            }
            b.f();
        }
    }

    public final boolean k(TbPageContext<?> tbPageContext, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048579, this, tbPageContext, i)) == null) {
            String currentAccount = TbadkCoreApplication.getCurrentAccount();
            if (currentAccount != null && currentAccount.length() > 0) {
                return true;
            }
            TbadkCoreApplication.getInst().login(tbPageContext, new CustomMessage<>(2002001, new LoginActivityConfig(tbPageContext.getPageActivity(), true, i)));
            return false;
        }
        return invokeLI.booleanValue;
    }
}
