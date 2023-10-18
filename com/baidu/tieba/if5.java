package com.baidu.tieba;

import android.content.Context;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.bdtask.model.response.TaskResponseData;
import com.baidu.cyberplayer.sdk.CyberPlayerManager;
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
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class if5 extends ed5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ForumData a;
    public String b;
    public String c;
    public boolean d;
    public DataModel<?> e;
    public PbNewEditorTool.InputShowType f;

    /* loaded from: classes6.dex */
    public class a implements dd5 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hf5 a;
        public final /* synthetic */ EditorTools b;
        public final /* synthetic */ if5 c;

        public a(if5 if5Var, hf5 hf5Var, EditorTools editorTools) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {if5Var, hf5Var, editorTools};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.c = if5Var;
            this.a = hf5Var;
            this.b = editorTools;
        }

        @Override // com.baidu.tieba.dd5
        public void O(cd5 cd5Var) {
            hf5 hf5Var;
            int size;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, cd5Var) != null) || (hf5Var = this.a) == null || hf5Var.a() == null || cd5Var == null) {
                return;
            }
            int i = cd5Var.a;
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
                                                        if (i != 77) {
                                                            switch (i) {
                                                                case 14:
                                                                    AlbumFloatActivityConfig albumFloatActivityConfig = new AlbumFloatActivityConfig(this.a.q().getPageActivity(), this.a.w().toJsonString(), true, true);
                                                                    if (!StringUtils.isNull(this.c.c, true)) {
                                                                        albumFloatActivityConfig.getIntent().putExtra("from", this.c.c);
                                                                    }
                                                                    if (this.c.a != null && !StringUtils.isNull(this.c.a.getId(), true)) {
                                                                        albumFloatActivityConfig.getIntent().putExtra("forum_id", this.c.a.getId());
                                                                    }
                                                                    albumFloatActivityConfig.setRequestCode(TaskResponseData.ERROR_NO_TASK_OFFLINE_03);
                                                                    if (cf5.a().b() == 1) {
                                                                        albumFloatActivityConfig.setRequestFrom(2);
                                                                        if (this.a.w() != null) {
                                                                            this.a.w().setMaxImagesAllowed(1);
                                                                        }
                                                                    } else if (this.a.w() != null) {
                                                                        this.a.w().setMaxImagesAllowed(9);
                                                                    }
                                                                    BdUtilHelper.hideSoftKeyPad(this.a.q().getPageActivity(), this.a.q().getPageActivity().getCurrentFocus());
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, albumFloatActivityConfig));
                                                                    return;
                                                                case 15:
                                                                    int intValue = ((Integer) cd5Var.c).intValue();
                                                                    if (this.a.w() != null && this.a.w().getChosedFiles() != null && (size = this.a.w().getChosedFiles().size()) >= 1 && intValue >= 0 && intValue < size) {
                                                                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new WriteMulitImageActivityConfig(this.a.q().getPageActivity(), CyberPlayerManager.MEDIA_INFO_MEDIA_FILE_PATH, this.a.w(), intValue)));
                                                                        return;
                                                                    }
                                                                    return;
                                                                case 16:
                                                                    if (this.c.d) {
                                                                        this.a.q().showToast(R.string.over_limit_tip);
                                                                    }
                                                                    if (!this.c.k(this.a.q(), 11025)) {
                                                                        return;
                                                                    }
                                                                    AtListActivityConfig atListActivityConfig = new AtListActivityConfig(this.a.q().getPageActivity(), 12004, true);
                                                                    if (this.a.v() != null) {
                                                                        atListActivityConfig.setSelectedAtList(this.a.v().x());
                                                                    }
                                                                    if (this.c.e != null) {
                                                                        atListActivityConfig.setFromTid(this.c.e.Q());
                                                                        atListActivityConfig.setFromFid(this.c.e.getForumId());
                                                                    }
                                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, atListActivityConfig));
                                                                    StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_AT_PANEL_SHOW);
                                                                    statisticItem.addParam("uid", TbadkCoreApplication.getCurrentAccount());
                                                                    if (this.c.e != null) {
                                                                        statisticItem.addParam("tid", this.c.e.Q());
                                                                        statisticItem.addParam("fid", this.c.e.getForumId());
                                                                    }
                                                                    TiebaStatic.log(statisticItem);
                                                                    return;
                                                                default:
                                                                    return;
                                                            }
                                                        }
                                                        this.a.y();
                                                        return;
                                                    }
                                                    Object obj = cd5Var.c;
                                                    if (obj != null && (obj instanceof Boolean)) {
                                                        this.a.j0(((Boolean) obj).booleanValue());
                                                        return;
                                                    }
                                                    return;
                                                } else if (!kr5.c(this.a.q(), true, false)) {
                                                    HotSelectActivityConfig hotSelectActivityConfig = new HotSelectActivityConfig(this.a.q().getPageActivity(), 25004, HotSelectActivityConfig.FROM_PB);
                                                    if (this.c.a != null) {
                                                        hotSelectActivityConfig.setForumExtra(JavaTypesHelper.toLong(this.c.a.getId(), 0L), this.c.a.getFirst_class(), this.c.a.getSecond_class());
                                                    }
                                                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, hotSelectActivityConfig));
                                                    return;
                                                } else {
                                                    return;
                                                }
                                            } else if (!this.c.k(this.a.q(), 11040)) {
                                                return;
                                            } else {
                                                this.a.U();
                                                return;
                                            }
                                        }
                                        this.a.a().D(new cd5(1, 11, null));
                                        return;
                                    }
                                    this.a.a().D(new cd5(2, 19, null));
                                    this.a.a().D(new cd5(1, 2, null));
                                    this.a.k();
                                    return;
                                }
                                this.a.o0(null);
                                return;
                            }
                            Object obj2 = cd5Var.c;
                            if (obj2 instanceof VoiceData.VoiceModel) {
                                this.a.o0((VoiceData.VoiceModel) obj2);
                                this.a.x(true, null);
                                return;
                            }
                            return;
                        } else if (!this.c.k(this.a.q(), 11001)) {
                            TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 2).param("obj_type", 1).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                            return;
                        } else {
                            this.a.I(null, null);
                            return;
                        }
                    }
                    this.a.q().showToast(R.string.over_limit_tip);
                    this.c.d = true;
                    return;
                } else if (!this.b.x()) {
                    TiebaStatic.eventStat(this.b.getContext(), "pb_reply", "pbclick", 1, new Object[0]);
                    return;
                } else {
                    return;
                }
            }
            this.a.g0(cd5Var.c.toString());
            Object obj3 = cd5Var.c;
            if (obj3 instanceof SpanGroupManager) {
                this.a.l0((SpanGroupManager) obj3);
            }
            this.c.d = false;
        }
    }

    public if5() {
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

    public void s(PbNewEditorTool.InputShowType inputShowType) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048587, this, inputShowType) == null) {
            this.f = inputShowType;
        }
    }

    @Override // com.baidu.tieba.ed5
    public gd5 b(Context context) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, context)) == null) {
            EditorTools editorTools = new EditorTools(context);
            editorTools.setIsFromPb(true);
            editorTools.setBarMaxLauCount(5);
            editorTools.setBarLauncherType(3);
            editorTools.setBackgroundColorId(0);
            editorTools.setBarBackgroundColorId(R.color.CAM_X0207);
            editorTools.G(false);
            editorTools.setMoreButtonAtEnd(true);
            hf5 hf5Var = new hf5(editorTools);
            hf5Var.d0(this.e);
            return hf5Var;
        }
        return (gd5) invokeL.objValue;
    }

    @Override // com.baidu.tieba.ed5
    public void c(gd5 gd5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, gd5Var) != null) || !(gd5Var instanceof hf5)) {
            return;
        }
        EditorTools a2 = gd5Var.a();
        a aVar = new a(this, (hf5) gd5Var, a2);
        a2.setActionListener(5, aVar);
        a2.setActionListener(4, aVar);
        a2.setActionListener(7, aVar);
        a2.setActionListener(16, aVar);
        a2.setActionListener(14, aVar);
        a2.setActionListener(15, aVar);
        a2.setActionListener(8, aVar);
        a2.setActionListener(10, aVar);
        a2.setActionListener(11, aVar);
        a2.setActionListener(27, aVar);
        a2.setActionListener(29, aVar);
        a2.setActionListener(36, aVar);
        a2.setActionListener(32, aVar);
        a2.setActionListener(43, aVar);
        a2.setActionListener(45, aVar);
        a2.setActionListener(67, aVar);
        a2.setActionListener(77, aVar);
    }

    @Override // com.baidu.tieba.ed5
    public void d(gd5 gd5Var) {
        String forumId;
        CustomResponsedMessage runTask;
        od5 od5Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, gd5Var) == null) {
            EditorTools a2 = gd5Var.a();
            ArrayList arrayList = new ArrayList();
            arrayList.add(5);
            arrayList.add(6);
            arrayList.add(9);
            a2.d(new zd5(a2.getContext(), 1));
            if (lga.a() && oda.a(this.b, Boolean.TRUE) && (runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001448, a2.getContext()), od5.class)) != null && (od5Var = (od5) runTask.getData()) != null) {
                od5Var.l = 2;
                a2.d(od5Var);
            }
            qd5 qd5Var = new qd5(a2.getContext(), 4);
            qd5Var.i = false;
            a2.d(qd5Var);
            CustomResponsedMessage runTask2 = MessageManager.getInstance().runTask(new CustomMessage<>(2001339, a2.getContext()), od5.class);
            if (runTask2 != null && runTask2.getData() != null) {
                od5 od5Var2 = (od5) runTask2.getData();
                od5Var2.l = 6;
                a2.d(od5Var2);
            }
            PbNewEditorTool pbNewEditorTool = new PbNewEditorTool(a2.getContext(), false, true, 12004);
            pbNewEditorTool.n(this.f);
            a2.d(pbNewEditorTool);
            CustomResponsedMessage runTask3 = MessageManager.getInstance().runTask(new CustomMessage<>(2001342, a2.getContext()), od5.class);
            if (runTask3 != null && runTask3.getData() != null) {
                od5 od5Var3 = (od5) runTask3.getData();
                od5Var3.l = 7;
                a2.d(od5Var3);
            }
            if (!"PbChosenActivity".equals(a2.getContext().getClass().getSimpleName())) {
                a2.d(new xd5(a2.getContext(), 5));
            }
            a2.h(arrayList);
            od5 p = a2.p(5);
            if (p != null) {
                p.l = 3;
            }
            a2.f();
            if (pf5.isOn()) {
                DataModel<?> dataModel = this.e;
                if (dataModel == null) {
                    forumId = null;
                } else {
                    forumId = dataModel.getForumId();
                }
                a2.D(new cd5(76, 27, forumId));
            }
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
