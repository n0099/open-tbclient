package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdUtilHelper;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.PbFullScreenEditorActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbPatternsCompat;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.data.AtSelectData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.editortools.pb.DataModel;
import com.baidu.tbadk.editortools.pb.PbEditorData;
import com.baidu.tbadk.editortools.pb.PbNewEditorTool;
import com.baidu.tbadk.img.ImageFileInfo;
import com.baidu.tbadk.pageExtra.TbPageExtraHelper;
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.f05;
import com.baidu.tieba.pb.bot.BotEntranceManager;
import com.baidu.tieba.rva;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class hh5 extends le5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> b;
    public jh5 c;
    public String d;
    public String e;
    public String f;
    public VoiceData.VoiceModel g;
    public NewWriteModel h;
    public SpanGroupManager i;
    public DataModel<?> j;
    public boolean k;
    public bh5 l;
    public ah5 m;
    public NewWriteModel.d n;
    public String o;
    public PbNewEditorTool p;
    public ThreadData q;
    public rva.h r;
    public boolean s;
    public int t;
    public int u;
    public NewWriteModel.d v;
    public AntiHelper.k w;
    public View.OnClickListener x;

    public void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh5 a;

        public a(hh5 hh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh5Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, o95 o95Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, o95Var, writeData, antiData}) == null) {
                if (this.a.n != null) {
                    this.a.n.callback(z, postWriteCallBackData, o95Var, writeData, antiData);
                }
                if (z) {
                    this.a.c = null;
                    this.a.d = null;
                    this.a.O(true);
                    this.a.r();
                }
                int i = -1;
                String str2 = "";
                if (postWriteCallBackData == null) {
                    str = "";
                } else {
                    i = postWriteCallBackData.getErrorCode();
                    str = postWriteCallBackData.getErrorString();
                }
                if (z && this.a.q != null) {
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_PB_REPLY_CLICK);
                    statisticItem.param("tid", this.a.q.getId());
                    statisticItem.param("fid", this.a.q.getFid());
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem.param("obj_type", 2);
                    xo5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.b.getPageActivity());
                    if (currentVisiblePageExtra != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_CUR_PAGE, currentVisiblePageExtra.a());
                    }
                    if (TbPageExtraHelper.getPrePageKey() != null) {
                        statisticItem.param(TiebaStatic.Params.OBJ_PRE_PAGE, TbPageExtraHelper.getPrePageKey());
                    }
                    if (this.a.u == 0) {
                        statisticItem.param("obj_locate", 6);
                    } else if (this.a.u == 1) {
                        statisticItem.param("obj_locate", 4);
                    } else if (this.a.u == 2) {
                        statisticItem.param("obj_locate", 5);
                    } else if (this.a.u == 3) {
                        statisticItem.param("obj_locate", 2);
                    } else if (this.a.u == 4) {
                        statisticItem.param("obj_locate", 3);
                    } else if (this.a.u == 5) {
                        statisticItem.param("obj_locate", 1);
                    } else if (this.a.u == 6) {
                        statisticItem.param("obj_locate", 7);
                    }
                    if (this.a.q.isVideoThreadType()) {
                        if (writeData != null) {
                            str2 = writeData.getContent();
                        }
                        if (uu5.e(str2) > 40) {
                            str2 = uu5.m(str2, 40);
                        }
                        statisticItem.param(TiebaStatic.Params.POST_CONTENT, str2);
                    }
                    TiebaStatic.log(statisticItem);
                }
                if (z && this.a.q != null) {
                    StatisticItem statisticItem2 = new StatisticItem("c14303");
                    statisticItem2.param("tid", this.a.q.getId());
                    statisticItem2.param("fid", this.a.q.getFid());
                    statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccountId());
                    statisticItem2.param("obj_type", 2);
                    if (this.a.u == 1) {
                        statisticItem2.param("obj_locate", 1);
                    } else if (this.a.u == 2) {
                        statisticItem2.param("obj_locate", 2);
                    } else if (this.a.u == 3) {
                        statisticItem2.param("obj_locate", 3);
                    } else if (this.a.u == 4) {
                        statisticItem2.param("obj_locate", 4);
                    }
                    TiebaStatic.log(statisticItem2);
                }
                if (z) {
                    WriteData e0 = this.a.h.e0();
                    this.a.h.setWriteData(null);
                    this.a.h.k0(false);
                    this.a.g = null;
                    if (e0 != null && e0 != null && e0.getType() == 2) {
                        this.a.j.Z();
                    }
                } else if (i != 230277 && i != 230278 && i != 340016 && i != 1990032 && !AntiHelper.m(i, str)) {
                    if (o95Var != null && writeData != null && !StringUtils.isNull(o95Var.c())) {
                        writeData.setVcodeMD5(o95Var.b());
                        writeData.setVcodeUrl(o95Var.c());
                        writeData.setVcodeExtra(o95Var.a());
                        if (this.a.q != null) {
                            writeData.setBaijiahaoData(this.a.q.getBaijiahaoData());
                        }
                        if (VcodeTool.needVcode(o95Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.u().getPageActivity(), 12006, writeData, false, o95Var.d())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.u().getPageActivity(), writeData, 12006)));
                        }
                    } else if (postWriteCallBackData != null && i == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.b.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    } else if (i != 238010 && !e5b.d(i)) {
                        this.a.u().showToast(str);
                    }
                } else {
                    this.a.i0(i, str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(hh5 hh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onNavigationButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, f05Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements rva.h {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh5 a;

        public c(hh5 hh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh5Var;
        }

        @Override // com.baidu.tieba.rva.h
        public void d(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                    if (this.a.c == null) {
                        this.a.c = new jh5();
                    }
                    this.a.c.a = writeData.getContent();
                    this.a.c.b = writeData.getSubPbReplyPrefix();
                    this.a.c.d = writeData.getPortrait();
                    this.a.c.e = writeData.getName();
                    hh5 hh5Var = this.a;
                    hh5Var.P(hh5Var.c);
                }
                if (this.a.r != null) {
                    this.a.r.d(writeData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hh5 a;

        public d(hh5 hh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hh5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.o)) {
                BdUtilHelper.showToast(this.a.u().getPageActivity(), this.a.o);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements f05.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(hh5 hh5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hh5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.f05.e
        public void onClick(f05 f05Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, f05Var) == null) {
                f05Var.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hh5(EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = "";
        this.k = false;
        this.o = null;
        this.t = 0;
        this.u = 0;
        this.v = new a(this);
        this.w = new b(this);
        this.x = new d(this);
    }

    public void C(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.h = newWriteModel;
        newWriteModel.m0(this.v);
        rva.t(this.j.Q(), new c(this));
    }

    public final void N(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, arrayList) == null) && a() != null) {
            a().K(new he5(17, 27, arrayList));
        }
    }

    public final void O(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048590, this, z) == null) && a() != null) {
            a().K(new he5(9, -1, Boolean.valueOf(z)));
        }
    }

    public final void P(jh5 jh5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, jh5Var) == null) && a() != null) {
            a().K(new he5(6, 27, jh5Var));
        }
    }

    public void Q(ah5 ah5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, ah5Var) == null) {
            this.m = ah5Var;
        }
    }

    public void R(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.t = i;
        }
    }

    public void T(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048595, this, i) == null) {
            this.u = i;
        }
    }

    public void U(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void V(rva.h hVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, hVar) == null) {
            this.r = hVar;
        }
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            if (this.c == null) {
                this.c = new jh5();
            }
            this.c.a = str;
        }
    }

    public void X(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, str) == null) {
            this.e = str;
        }
    }

    public void Y(bh5 bh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048600, this, bh5Var) == null) {
            this.l = bh5Var;
        }
    }

    public void a0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, str) == null) {
            this.d = str;
        }
    }

    public void b0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048603, this, z) == null) {
            this.k = z;
        }
    }

    public void c0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, spanGroupManager) == null) {
            this.i = spanGroupManager;
        }
    }

    public void d0(jh5 jh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, jh5Var) == null) {
            this.c = jh5Var;
        }
    }

    public void e0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, dataModel) == null) {
            this.j = dataModel;
            if (dataModel != null) {
                this.e = dataModel.Q();
            }
        }
    }

    public void f0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.f = str;
        }
    }

    public void h0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048609, this, voiceModel) == null) {
            this.g = voiceModel;
        }
    }

    public final void k0(jh5 jh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, jh5Var) == null) {
            b0(true);
            a().m();
            P(jh5Var);
            TiebaStatic.eventStat(u().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, str) == null) && !StringUtils.isNull(str) && a() != null) {
            a().K(new he5(45, 27, str));
        }
    }

    public boolean A() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.g;
            if (voiceModel == null || TextUtils.isEmpty(voiceModel.getVoiceId()) || this.g.getDuration() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void B() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            f0(null);
            b0(false);
            a().v();
        }
    }

    public boolean D() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            H();
            a().x(27);
        }
    }

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            M();
            this.h.cancelLoadData();
            this.h.n0(null);
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.h.setWriteData(null);
            this.h.k0(false);
            this.g = null;
        }
    }

    public void j0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            b0(true);
            a().o(false, false);
            a().G((View) a().t(5));
        }
    }

    public void l0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            b0(true);
            a().m();
            a().G((View) a().t(2));
        }
    }

    public void n0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            b0(true);
            a().m();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            rva.E(this.e, null);
        }
    }

    public TbPageContext<?> u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            return this.b;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public PbNewEditorTool v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            if (this.p == null && a() != null) {
                this.p = (PbNewEditorTool) a().u(27);
            }
            return this.p;
        }
        return (PbNewEditorTool) invokeV.objValue;
    }

    public SpanGroupManager w() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048623, this)) == null) {
            return this.i;
        }
        return (SpanGroupManager) invokeV.objValue;
    }

    public void y() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048625, this) == null) {
            ThreadData threadData = this.q;
            String str2 = "";
            if (threadData == null) {
                str = "";
            } else {
                str = String.valueOf(threadData.getFid());
            }
            jh5 jh5Var = this.c;
            if (jh5Var != null) {
                str2 = jh5Var.a;
            }
            ne5.e(str2, str);
        }
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            jh5 jh5Var = this.c;
            if (jh5Var != null && !rd.isEmpty(jh5Var.a)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public void E(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048580, this, writeData) != null) || writeData == null) {
            return;
        }
        if (this.c == null) {
            this.c = new jh5();
        }
        this.c.a = writeData.getContent();
        this.c.b = writeData.getSubPbReplyPrefix();
        this.c.d = writeData.getPortrait();
        this.c.e = writeData.getName();
        P(this.c);
    }

    public void K(AntiData antiData) {
        qe5 t;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048586, this, antiData) == null) && antiData != null) {
            String voice_message = antiData.getVoice_message();
            this.o = voice_message;
            if (!StringUtils.isNull(voice_message) && a() != null && (t = a().t(6)) != null && !TextUtils.isEmpty(this.o)) {
                ((View) t).setOnClickListener(this.x);
            }
        }
    }

    public final void m0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            f05 f05Var = new f05(u().getPageActivity());
            f05Var.setMessage(str);
            f05Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b86, new e(this));
            f05Var.create(u()).show();
        }
    }

    public void F(int i, int i2, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048581, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i2 == -1) {
                if (i != 12005) {
                    if (i == 12006) {
                        if (a() != null) {
                            a().v();
                        }
                        r();
                        O(true);
                        WriteData e0 = this.h.e0();
                        this.h.setWriteData(null);
                        this.h.k0(false);
                        if (e0 != null && e0 != null && e0.getType() == 2) {
                            this.j.Z();
                        }
                    }
                } else if (intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) != null) {
                    N(parcelableArrayListExtra);
                }
            } else if (i2 == 0 && i == 12006) {
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                }
                PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                NewWriteModel.d dVar = this.n;
                if (dVar != null) {
                    dVar.callback(false, postWriteCallBackData2, null, this.h.e0(), null);
                }
            }
        }
    }

    public void J() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            if (this.h.e0() == null) {
                DataModel<?> dataModel = this.j;
                WriteData V = dataModel.V(dataModel.Q());
                if (V != null && (threadData = this.q) != null) {
                    V.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.h.setWriteData(V);
            }
            if (this.h.e0() == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            if (this.c != null) {
                this.h.e0().setContent(this.c.a);
                this.h.e0().setSubPbReplyPrefix(this.c.b);
                this.h.e0().setPortrait(this.c.d);
                this.h.e0().setName(this.c.e);
                if (this.q != null) {
                    this.h.e0().setBaijiahaoData(this.q.getBaijiahaoData());
                }
            }
            this.h.e0().setBotConfig(BotEntranceManager.g().h());
            this.h.e0().setReplyId(this.d);
            if (this.e != null) {
                this.h.e0().setRepostId(this.j.Q());
            }
            if (this.f != null) {
                this.h.e0().setReSubPostId(this.f);
            }
            VoiceData.VoiceModel voiceModel = this.g;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.h.e0().setVoice(this.g.getId());
                    this.h.e0().setVoiceDuringTime(this.g.getDuration());
                } else {
                    this.h.e0().setVoice(null);
                    this.h.e0().setVoiceDuringTime(-1);
                }
            } else {
                this.h.e0().setVoice(null);
                this.h.e0().setVoiceDuringTime(-1);
            }
            if (!this.h.c0()) {
                u().showToast((int) R.string.write_img_limit);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 12).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            ah5 ah5Var = this.m;
            if (ah5Var != null && ah5Var.a()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 13).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            bh5 bh5Var = this.l;
            if (bh5Var != null) {
                bh5Var.a();
            }
            t(this.h.e0());
            s();
            this.h.e0().onPostDataParse(this.i);
            if (!this.h.p0()) {
            }
        }
    }

    public void M() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048588, this) == null) {
            WriteData writeData = new WriteData(2);
            jh5 jh5Var = this.c;
            if (jh5Var != null) {
                writeData.setContent(jh5Var.a);
                writeData.setPortrait(this.c.d);
                writeData.setName(this.c.e);
                writeData.setSubPbReplyPrefix(this.c.b);
            }
            writeData.onSaveDrafDataParse(this.i);
            writeData.setReplyId(this.d);
            writeData.setThreadId(this.e);
            rva.E(this.e, writeData);
        }
    }

    public void Z(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048601, this, str, str2) != null) || str == null) {
            return;
        }
        String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
        jh5 jh5Var = this.c;
        if (jh5Var != null) {
            if (TextUtils.isEmpty(jh5Var.b) && TextUtils.isEmpty(this.c.a)) {
                o0(str, str2);
                return;
            } else if (!TextUtils.isEmpty(this.c.b) && this.c.b.equals(replace)) {
                k0(this.c);
                return;
            } else {
                o0(str, str2);
                return;
            }
        }
        o0(str, str2);
    }

    public void i0(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048610, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                if (AntiHelper.w(this.b.getPageActivity(), str, i, this.w) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i != 230277 && i != 230278) {
                u().showToast(str);
            } else {
                m0(str);
            }
        }
    }

    public void g0(ThreadData threadData) {
        String forum_name;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, threadData) == null) {
            this.q = threadData;
            if (a() != null && this.q != null) {
                a().setFid(this.q.getFid());
                EditorTools a2 = a();
                String str = "";
                if (StringUtils.isNull(this.q.getForum_name())) {
                    forum_name = "";
                } else {
                    forum_name = this.q.getForum_name();
                }
                a2.setFname(forum_name);
                EditorTools a3 = a();
                if (!StringUtils.isNull(this.q.getTid())) {
                    str = this.q.getTid();
                }
                a3.setTid(str);
                a().K(new he5(70, -1, String.valueOf(this.q.getFid())));
            }
        }
    }

    public void x(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048624, this, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(1);
            jh5 jh5Var = this.c;
            if (jh5Var != null) {
                pbEditorData.setContent(jh5Var.a);
                pbEditorData.setSubPbReplyPrefix(this.c.b);
                pbEditorData.setName(this.c.e);
                pbEditorData.setPortrait(this.c.d);
            }
            pbEditorData.setVoiceModel(this.g);
            pbEditorData.setThreadData(new PbEditorData.ThreadData());
            pbEditorData.setDisableVoiceMessage(this.o);
            pbEditorData.setOpenVoiceRecordButton(true);
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new PbFullScreenEditorActivityConfig(this.b.getPageActivity(), 25035, pbEditorData, postWriteCallBackData)));
        }
    }

    public void o0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, str2) == null) {
            b0(true);
            a().m();
            if (str != null && str.length() != 0) {
                String replace = u().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
                jh5 jh5Var = new jh5();
                jh5Var.b = replace;
                jh5Var.d = str2;
                jh5Var.e = str;
                P(jh5Var);
            } else {
                jh5 jh5Var2 = new jh5();
                jh5Var2.a = "";
                P(jh5Var2);
            }
            TiebaStatic.eventStat(u().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public final void s() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.q != null && (dataModel = this.j) != null && dataModel.X()) {
            StatisticItem statisticItem = new StatisticItem(CommonStatisticKey.KEY_HEATING_THREAD_COMMENT);
            statisticItem.addParam("obj_locate", 2);
            if (this.q.isVideoWorksInfo()) {
                statisticItem.addParam("obj_type", 3);
            } else if (this.q.isVideoThreadType()) {
                statisticItem.addParam("obj_type", 2);
            } else {
                statisticItem.addParam("obj_type", 1);
            }
            statisticItem.addParam("tid", this.q.getTid());
            statisticItem.addParam(TiebaStatic.Params.FID_1, this.q.getFid());
            statisticItem.addParam(TiebaStatic.Params.FID_2, this.j.O());
            statisticItem.addParam("order_id", this.j.T());
            TiebaStatic.log(statisticItem);
            pq4.a(pq4.f, pq4.c, this.j.T(), this.j.U(), this.j.S(), this.j.P());
        }
    }

    public void t(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048620, this, writeData) != null) || writeData == null) {
            return;
        }
        int i = 0;
        if (!TextUtils.isEmpty(writeData.getContent())) {
            int i2 = 0;
            while (TbPatternsCompat.EMOTION_PATTERRN.matcher(writeData.getContent()).find()) {
                i2++;
            }
            if (i2 > 0 && this.t > 0) {
                StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SMALL_EMOTION_NUM);
                statisticItem.param("obj_type", i2);
                statisticItem.param("obj_source", this.t);
                statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem);
            }
        }
        if (writeData.getWriteImagesInfo() != null && !ListUtils.isEmpty(writeData.getWriteImagesInfo().getChosedFiles())) {
            for (ImageFileInfo imageFileInfo : writeData.getWriteImagesInfo().getChosedFiles()) {
                if (imageFileInfo.getImageType() == 1) {
                    i++;
                }
            }
            if (i > 0 && this.t > 0) {
                StatisticItem statisticItem2 = new StatisticItem(TbadkCoreStatisticKey.KEY_BIG_EMOTION_NUM);
                statisticItem2.param("obj_type", i);
                statisticItem2.param("obj_source", this.t);
                statisticItem2.param("uid", TbadkCoreApplication.getCurrentAccount());
                statisticItem2.param("tid", writeData.getThreadId());
                TiebaStatic.log(statisticItem2);
            }
        }
    }
}
