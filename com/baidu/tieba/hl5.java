package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import android.view.View;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
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
import com.baidu.tieba.bca;
import com.baidu.tieba.p55;
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
public class hl5 extends dj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> b;
    public jl5 c;
    public String d;
    public String e;
    public String f;
    public VoiceData.VoiceModel g;
    public NewWriteModel h;
    public SpanGroupManager i;
    public DataModel<?> j;
    public boolean k;
    public bl5 l;
    public al5 m;
    public NewWriteModel.d n;
    public String o;
    public PbNewEditorTool p;
    public ThreadData q;
    public bca.g r;
    public boolean s;
    public int t;
    public int u;
    public NewWriteModel.d v;
    public AntiHelper.k w;
    public View.OnClickListener x;

    public void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
        }
    }

    /* loaded from: classes6.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hl5 a;

        public a(hl5 hl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl5Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ve5 ve5Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ve5Var, writeData, antiData}) == null) {
                if (this.a.n != null) {
                    this.a.n.callback(z, postWriteCallBackData, ve5Var, writeData, antiData);
                }
                if (z) {
                    this.a.c = null;
                    this.a.d = null;
                    this.a.N(true);
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
                    at5 currentVisiblePageExtra = TbPageExtraHelper.getCurrentVisiblePageExtra(this.a.b.getPageActivity());
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
                        if (dz5.e(str2) > 40) {
                            str2 = dz5.m(str2, 40);
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
                    WriteData l0 = this.a.h.l0();
                    this.a.h.setWriteData(null);
                    this.a.h.r0(false);
                    this.a.g = null;
                    if (l0 != null && l0 != null && l0.getType() == 2) {
                        this.a.j.g0();
                    }
                } else if (i != 230277 && i != 230278 && i != 340016 && i != 1990032 && !AntiHelper.m(i, str)) {
                    if (ve5Var != null && writeData != null && !StringUtils.isNull(ve5Var.c())) {
                        writeData.setVcodeMD5(ve5Var.b());
                        writeData.setVcodeUrl(ve5Var.c());
                        writeData.setVcodeExtra(ve5Var.a());
                        if (this.a.q != null) {
                            writeData.setBaijiahaoData(this.a.q.getBaijiahaoData());
                        }
                        if (vz5.b(ve5Var.d())) {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this.a.getContext().getPageActivity(), 12006, writeData, false, ve5Var.d())));
                        } else {
                            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this.a.getContext().getPageActivity(), writeData, 12006)));
                        }
                    } else if (postWriteCallBackData != null && i == 227001) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this.a.b.getPageActivity(), 12006, writeData, postWriteCallBackData.getAccessState())));
                    } else if (i != 238010 && !vka.d(i)) {
                        this.a.getContext().showToast(str);
                    }
                } else {
                    this.a.h0(i, str);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements AntiHelper.k {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public b(hl5 hl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl5Var};
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
        public void onNavigationButtonClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_NEG_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }

        @Override // com.baidu.tieba.tbadkCore.util.AntiHelper.k
        public void onPositiveButtonClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, p55Var) == null) {
                TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_POS_CLICK).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements bca.g {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hl5 a;

        public c(hl5 hl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl5Var;
        }

        @Override // com.baidu.tieba.bca.g
        public void a(WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, writeData) == null) {
                if (writeData != null && !StringUtils.isNull(writeData.getContent())) {
                    if (this.a.c == null) {
                        this.a.c = new jl5();
                    }
                    this.a.c.a = writeData.getContent();
                    this.a.c.b = writeData.getSubPbReplyPrefix();
                    this.a.c.d = writeData.getPortrait();
                    this.a.c.e = writeData.getName();
                    hl5 hl5Var = this.a;
                    hl5Var.O(hl5Var.c);
                }
                if (this.a.r != null) {
                    this.a.r.a(writeData);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class d implements View.OnClickListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ hl5 a;

        public d(hl5 hl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = hl5Var;
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view2) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, view2) == null) && !TextUtils.isEmpty(this.a.o)) {
                yi.R(this.a.getContext().getPageActivity(), this.a.o);
            }
        }
    }

    /* loaded from: classes6.dex */
    public class e implements p55.e {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public e(hl5 hl5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {hl5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        @Override // com.baidu.tieba.p55.e
        public void onClick(p55 p55Var) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, p55Var) == null) {
                p55Var.dismiss();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public hl5(EditorTools editorTools) {
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

    public void f0(ThreadData threadData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, threadData) == null) {
            this.q = threadData;
            if (b() != null && this.q != null) {
                b().setFid(this.q.getFid());
                b().setTid(this.q.getTid());
                b().D(new zi5(70, -1, String.valueOf(this.q.getFid())));
            }
        }
    }

    public void B(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, tbPageContext) != null) || tbPageContext == null) {
            return;
        }
        NewWriteModel newWriteModel = new NewWriteModel(tbPageContext);
        this.h = newWriteModel;
        newWriteModel.t0(this.v);
        bca.r(this.j.X(), new c(this));
    }

    public final void M(ArrayList<AtSelectData> arrayList) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, arrayList) == null) && b() != null) {
            b().D(new zi5(17, 27, arrayList));
        }
    }

    public final void N(boolean z) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(1048589, this, z) == null) && b() != null) {
            b().D(new zi5(9, -1, Boolean.valueOf(z)));
        }
    }

    public final void O(jl5 jl5Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, jl5Var) == null) && b() != null) {
            b().D(new zi5(6, 27, jl5Var));
        }
    }

    public void P(al5 al5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048591, this, al5Var) == null) {
            this.m = al5Var;
        }
    }

    public void Q(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048592, this, tbPageContext) == null) {
            this.b = tbPageContext;
        }
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048593, this, i) == null) {
            this.t = i;
        }
    }

    public void S(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048594, this, i) == null) {
            this.u = i;
        }
    }

    public void T(NewWriteModel.d dVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048595, this, dVar) == null) {
            this.n = dVar;
        }
    }

    public void U(bca.g gVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048596, this, gVar) == null) {
            this.r = gVar;
        }
    }

    public void V(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, str) == null) {
            if (this.c == null) {
                this.c = new jl5();
            }
            this.c.a = str;
        }
    }

    public void W(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, str) == null) {
            this.e = str;
        }
    }

    public void X(bl5 bl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048599, this, bl5Var) == null) {
            this.l = bl5Var;
        }
    }

    public void Z(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048601, this, str) == null) {
            this.d = str;
        }
    }

    public void a0(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048602, this, z) == null) {
            this.k = z;
        }
    }

    public void b0(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, spanGroupManager) == null) {
            this.i = spanGroupManager;
        }
    }

    public void c0(jl5 jl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, jl5Var) == null) {
            this.c = jl5Var;
        }
    }

    public void d0(DataModel<?> dataModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, dataModel) == null) {
            this.j = dataModel;
            if (dataModel != null) {
                this.e = dataModel.X();
            }
        }
    }

    public void e0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, str) == null) {
            this.f = str;
        }
    }

    public void g0(VoiceData.VoiceModel voiceModel) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048608, this, voiceModel) == null) {
            this.g = voiceModel;
        }
    }

    public final void j0(jl5 jl5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048612, this, jl5Var) == null) {
            a0(true);
            b().j();
            O(jl5Var);
            TiebaStatic.eventStat(getContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public void q(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048617, this, str) == null) && !StringUtils.isNull(str) && b() != null) {
            b().D(new zi5(45, 27, str));
        }
    }

    public void A() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            e0(null);
            a0(false);
            b().q();
        }
    }

    public boolean C() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.k;
        }
        return invokeV.booleanValue;
    }

    public void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            G();
            b().s(27);
        }
    }

    public void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            L();
            this.h.cancelLoadData();
            this.h.u0(null);
        }
    }

    public void K() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            this.h.setWriteData(null);
            this.h.r0(false);
            this.g = null;
        }
    }

    public TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return this.b;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public void i0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048611, this) == null) {
            a0(true);
            b().k(false, false);
            b().A((View) b().o(5));
        }
    }

    public void k0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048613, this) == null) {
            a0(true);
            b().j();
            b().A((View) b().o(2));
        }
    }

    public void m0() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048615, this) == null) {
            a0(true);
            b().j();
        }
    }

    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048618, this) == null) {
            bca.B(this.e, null);
        }
    }

    public PbNewEditorTool u() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048621, this)) == null) {
            if (this.p == null && b() != null) {
                this.p = (PbNewEditorTool) b().p(27);
            }
            return this.p;
        }
        return (PbNewEditorTool) invokeV.objValue;
    }

    public SpanGroupManager v() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048622, this)) == null) {
            return this.i;
        }
        return (SpanGroupManager) invokeV.objValue;
    }

    public void x() {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048624, this) == null) {
            ThreadData threadData = this.q;
            String str2 = "";
            if (threadData == null) {
                str = "";
            } else {
                str = String.valueOf(threadData.getFid());
            }
            jl5 jl5Var = this.c;
            if (jl5Var != null) {
                str2 = jl5Var.a;
            }
            ej5.e(str2, str);
        }
    }

    public boolean y() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048625, this)) == null) {
            jl5 jl5Var = this.c;
            if (jl5Var != null && !xi.isEmpty(jl5Var.a)) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public boolean z() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048626, this)) == null) {
            VoiceData.VoiceModel voiceModel = this.g;
            if (voiceModel == null || TextUtils.isEmpty(voiceModel.getVoiceId()) || this.g.getDuration() <= 0) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void D(WriteData writeData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, writeData) != null) || writeData == null) {
            return;
        }
        if (this.c == null) {
            this.c = new jl5();
        }
        this.c.a = writeData.getContent();
        this.c.b = writeData.getSubPbReplyPrefix();
        this.c.d = writeData.getPortrait();
        this.c.e = writeData.getName();
        O(this.c);
    }

    public void J(AntiData antiData) {
        hj5 o;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048585, this, antiData) == null) && antiData != null) {
            String voice_message = antiData.getVoice_message();
            this.o = voice_message;
            if (!StringUtils.isNull(voice_message) && b() != null && (o = b().o(6)) != null && !TextUtils.isEmpty(this.o)) {
                ((View) o).setOnClickListener(this.x);
            }
        }
    }

    public final void l0(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048614, this, str) == null) {
            p55 p55Var = new p55(getContext().getPageActivity());
            p55Var.setMessage(str);
            p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b3d, new e(this));
            p55Var.create(getContext()).show();
        }
    }

    public void E(int i, int i2, Intent intent) {
        ArrayList<AtSelectData> parcelableArrayListExtra;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIIL(1048580, this, i, i2, intent) == null) {
            PostWriteCallBackData postWriteCallBackData = null;
            if (i2 == -1) {
                if (i != 12005) {
                    if (i == 12006) {
                        if (b() != null) {
                            b().q();
                        }
                        r();
                        N(true);
                        WriteData l0 = this.h.l0();
                        this.h.setWriteData(null);
                        this.h.r0(false);
                        if (l0 != null && l0 != null && l0.getType() == 2) {
                            this.j.g0();
                        }
                    }
                } else if (intent != null && (parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA)) != null) {
                    M(parcelableArrayListExtra);
                }
            } else if (i2 == 0 && i == 12006) {
                if (intent != null && (intent.getSerializableExtra("post_write_callback_data") instanceof PostWriteCallBackData)) {
                    postWriteCallBackData = (PostWriteCallBackData) intent.getSerializableExtra("post_write_callback_data");
                }
                PostWriteCallBackData postWriteCallBackData2 = postWriteCallBackData;
                NewWriteModel.d dVar = this.n;
                if (dVar != null) {
                    dVar.callback(false, postWriteCallBackData2, null, this.h.l0(), null);
                }
            }
        }
    }

    public void I() {
        ThreadData threadData;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            if (this.h.l0() == null) {
                DataModel<?> dataModel = this.j;
                WriteData c0 = dataModel.c0(dataModel.X());
                if (c0 != null && (threadData = this.q) != null) {
                    c0.setBaijiahaoData(threadData.getBaijiahaoData());
                }
                this.h.setWriteData(c0);
            }
            if (this.h.l0() == null) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 20).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            if (this.c != null) {
                this.h.l0().setContent(this.c.a);
                this.h.l0().setSubPbReplyPrefix(this.c.b);
                this.h.l0().setPortrait(this.c.d);
                this.h.l0().setName(this.c.e);
                if (this.q != null) {
                    this.h.l0().setBaijiahaoData(this.q.getBaijiahaoData());
                }
            }
            this.h.l0().setReplyId(this.d);
            if (this.e != null) {
                this.h.l0().setRepostId(this.j.X());
            }
            if (this.f != null) {
                this.h.l0().setReSubPostId(this.f);
            }
            VoiceData.VoiceModel voiceModel = this.g;
            if (voiceModel != null) {
                if (voiceModel.getId() != null) {
                    this.h.l0().setVoice(this.g.getId());
                    this.h.l0().setVoiceDuringTime(this.g.getDuration());
                } else {
                    this.h.l0().setVoice(null);
                    this.h.l0().setVoiceDuringTime(-1);
                }
            } else {
                this.h.l0().setVoice(null);
                this.h.l0().setVoiceDuringTime(-1);
            }
            if (!this.h.j0()) {
                getContext().showToast((int) R.string.write_img_limit);
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 12).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            al5 al5Var = this.m;
            if (al5Var != null && al5Var.a()) {
                TiebaStatic.log(new StatisticItem(CommonStatisticKey.KEY_RD_USE).param("obj_param1", 3).param("obj_locate", 13).param("obj_type", 2).param("obj_source", UtilHelper.getCurrentPageName(TbadkCoreApplication.getInst().getCurrentActivity())));
                return;
            }
            bl5 bl5Var = this.l;
            if (bl5Var != null) {
                bl5Var.a();
            }
            t(this.h.l0());
            s();
            this.h.l0().onPostDataParse(this.i);
            if (!this.h.w0()) {
            }
        }
    }

    public void L() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            WriteData writeData = new WriteData(2);
            jl5 jl5Var = this.c;
            if (jl5Var != null) {
                writeData.setContent(jl5Var.a);
                writeData.setPortrait(this.c.d);
                writeData.setName(this.c.e);
                writeData.setSubPbReplyPrefix(this.c.b);
            }
            writeData.onSaveDrafDataParse(this.i);
            writeData.setReplyId(this.d);
            writeData.setThreadId(this.e);
            bca.B(this.e, writeData);
        }
    }

    public void Y(String str, String str2) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeLL(1048600, this, str, str2) != null) || str == null) {
            return;
        }
        String replace = TbadkCoreApplication.getInst().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
        jl5 jl5Var = this.c;
        if (jl5Var != null) {
            if (TextUtils.isEmpty(jl5Var.b) && TextUtils.isEmpty(this.c.a)) {
                n0(str, str2);
                return;
            } else if (!TextUtils.isEmpty(this.c.b) && this.c.b.equals(replace)) {
                j0(this.c);
                return;
            } else {
                n0(str, str2);
                return;
            }
        }
        n0(str, str2);
    }

    public void h0(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048610, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                if (AntiHelper.w(this.b.getPageActivity(), str, i, this.w) != null) {
                    TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_ANTI_DIALOG_SHOW).param("obj_locate", TbadkCoreStatisticKey.AntiLocateValue.LOCATE_REPLY_SUB_PB));
                }
            } else if (i != 230277 && i != 230278) {
                getContext().showToast(str);
            } else {
                l0(str);
            }
        }
    }

    public void n0(String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048616, this, str, str2) == null) {
            a0(true);
            b().j();
            if (str != null && str.length() != 0) {
                String replace = getContext().getResources().getString(R.string.reply_sub_floor).replace("%s", str);
                jl5 jl5Var = new jl5();
                jl5Var.b = replace;
                jl5Var.d = str2;
                jl5Var.e = str;
                O(jl5Var);
            } else {
                jl5 jl5Var2 = new jl5();
                jl5Var2.a = "";
                O(jl5Var2);
            }
            TiebaStatic.eventStat(getContext().getPageActivity(), "subpb_write", "subpbclick", 1, new Object[0]);
        }
    }

    public final void s() {
        DataModel<?> dataModel;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048619, this) == null) && this.q != null && (dataModel = this.j) != null && dataModel.e0()) {
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
            statisticItem.addParam(TiebaStatic.Params.FID_2, this.j.V());
            statisticItem.addParam("order_id", this.j.a0());
            TiebaStatic.log(statisticItem);
            fw4.a(fw4.f, fw4.c, this.j.a0(), this.j.b0(), this.j.Z(), this.j.W());
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

    public void w(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048623, this, postWriteCallBackData) == null) {
            PbEditorData pbEditorData = new PbEditorData();
            pbEditorData.setEditorType(1);
            jl5 jl5Var = this.c;
            if (jl5Var != null) {
                pbEditorData.setContent(jl5Var.a);
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
}
