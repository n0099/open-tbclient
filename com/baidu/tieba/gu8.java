package com.baidu.tieba;

import android.app.Activity;
import android.text.TextUtils;
import androidx.annotation.NonNull;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.android.common.others.lang.StringUtil;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContextSupport;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PublishProgressData;
import com.baidu.tbadk.core.data.WorkPostNotifyFlutterData;
import com.baidu.tbadk.core.util.FileHelper;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.File;
/* loaded from: classes4.dex */
public class gu8 implements NewWriteModel.d {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final NewWriteModel a;
    public boolean b;
    public BdUniqueId c;
    public boolean d;
    public String e;
    public int f;
    public String g;
    public String h;
    public String i;
    public NewWriteModel.d j;

    /* loaded from: classes4.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gu8 a;

        /* renamed from: com.baidu.tieba.gu8$a$a  reason: collision with other inner class name */
        /* loaded from: classes4.dex */
        public class RunnableC0289a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WriteData a;
            public final /* synthetic */ PostWriteCallBackData b;
            public final /* synthetic */ a c;

            public RunnableC0289a(a aVar, WriteData writeData, PostWriteCallBackData postWriteCallBackData) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {aVar, writeData, postWriteCallBackData};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.c = aVar;
                this.a = writeData;
                this.b = postWriteCallBackData;
            }

            @Override // java.lang.Runnable
            public void run() {
                Interceptable interceptable = $ic;
                if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                    PublishProgressData.valueOf(this.a, 100).send(false);
                    if ((!xi.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) || (this.a.getVideoInfo() != null && this.a.getVideoInfo().hasUpload())) {
                        new iu8().q(this.b);
                    } else {
                        new iu8().p(this.b, this.a);
                    }
                    this.c.a.f();
                    this.c.a.g();
                    if (!xi.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) {
                        this.b.mVideoMd5 = this.a.getVideoInfo().getVideoMd5();
                        if (!xi.isEmpty(this.a.getForumName())) {
                            this.b.mFrom = 2;
                        }
                    }
                    this.c.a.v();
                }
            }
        }

        public a(gu8 gu8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gu8Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d35 d35Var, WriteData writeData, AntiData antiData) {
            String str;
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, d35Var, writeData, antiData}) != null) || writeData == null) {
                return;
            }
            if (z) {
                WorkPostNotifyFlutterData notifyFlutterPostSucc = WorkPostNotifyFlutterData.notifyFlutterPostSucc(postWriteCallBackData.getVideoid());
                notifyFlutterPostSucc.setForumId(writeData.getForumId());
                notifyFlutterPostSucc.setForumName(writeData.getForumName());
                notifyFlutterPostSucc.setThreadDataByWriteData(writeData);
                notifyFlutterPostSucc.setFlutterPageId(this.a.j());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, notifyFlutterPostSucc));
                int i = 3;
                int m = ry4.l().m("key_video_works_progress_bar_waiting_time", 3);
                if (m > 0) {
                    i = m;
                }
                ah.a().postDelayed(new RunnableC0289a(this, writeData, postWriteCallBackData), (i + 1) * 1000);
                gu8.k().x(null);
                this.a.v();
            } else if (!dl5.d(postWriteCallBackData, d35Var, writeData, antiData)) {
                if (postWriteCallBackData != null) {
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = "";
                }
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, WorkPostNotifyFlutterData.notifyFlutterPostFail(str)));
                new iu8().n(postWriteCallBackData, d35Var, writeData, antiData);
                gu8.k().x(null);
                this.a.v();
            }
        }
    }

    /* loaded from: classes4.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;
        public final /* synthetic */ WriteData b;

        public b(gu8 gu8Var, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gu8Var, postWriteCallBackData, writeData};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = postWriteCallBackData;
            this.b = writeData;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                if ((!xi.isEmpty(this.a.getVideoid()) && this.b.getVideoInfo() != null) || (this.b.getVideoInfo() != null && this.b.getVideoInfo().hasUpload())) {
                    new iu8().q(this.a);
                    return;
                }
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity != null) {
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(currentActivity).areNotificationsEnabled();
                    if (areNotificationsEnabled && p35.d().e && p35.d().f) {
                        new iu8().p(this.a, this.b);
                    } else if ((!areNotificationsEnabled || !p35.d().e || !p35.d().f) && this.a.getToast() == null && !this.b.isShareThread()) {
                        if (k45.i(TbadkCoreApplication.getInst().getCurrentActivity(), 2)) {
                            new iu8().o(this.a, 9);
                        } else {
                            new iu8().p(this.a, this.b);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final gu8 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-763687584, "Lcom/baidu/tieba/gu8$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-763687584, "Lcom/baidu/tieba/gu8$c;");
                    return;
                }
            }
            a = new gu8(null);
        }
    }

    public gu8() {
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
        this.b = false;
        this.c = null;
        this.j = new a(this);
        NewWriteModel newWriteModel = new NewWriteModel();
        this.a = newWriteModel;
        newWriteModel.h0(this);
    }

    public WriteData o() {
        InterceptResult invokeV;
        String draftString;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            if (this.a.Y() == null) {
                draftString = StringUtil.NULL_STRING;
            } else {
                draftString = this.a.Y().toDraftString();
            }
            sb.append(draftString);
            hu8.a(sb.toString());
            return this.a.Y();
        }
        return (WriteData) invokeV.objValue;
    }

    public /* synthetic */ gu8(a aVar) {
        this();
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            this.d = z;
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            hu8.a("AsyncWriteHelper.setHasImage = " + z);
            this.a.f0(z);
        }
    }

    public void C(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.a.e0(z);
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.g = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.h = str;
        }
    }

    public void F(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, str) == null) {
            this.i = str;
        }
    }

    public void G(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048582, this, z) == null) {
            this.a.g0(z);
        }
    }

    public void H(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, spanGroupManager) == null) {
            hu8.a("AsyncWriteHelper.setSpanGroupManager()");
            this.a.Z();
            this.a.setSpanGroupManager(spanGroupManager);
        }
    }

    public void p(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048598, this, tbPageContextSupport) == null) {
            hu8.a("AsyncWriteHelper.initWriteStatus()");
            this.a.i0(tbPageContextSupport.getPageContext());
            this.a.setWriteData(null);
            this.a.f0(false);
        }
    }

    public void t(@NonNull r9 r9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048602, this, r9Var) == null) {
            hu8.a("AsyncWriteHelper.onWriteActClose()");
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel.e == r9Var) {
                newWriteModel.i0(null);
                this.a.setSpanGroupManager(null);
            }
        }
    }

    public void u(@NonNull r9 r9Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, r9Var) == null) {
            this.a.i0(r9Var);
        }
    }

    public final void w(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void x(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048606, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
        }
    }

    public void y(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048607, this, str) == null) {
            this.e = str;
        }
    }

    public void z(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048608, this, i) == null) {
            this.f = i;
        }
    }

    public static gu8 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            hu8.a("AsyncWriteHelper.getInstance()");
            return c.a;
        }
        return (gu8) invokeV.objValue;
    }

    public boolean J() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            hu8.a("AsyncWriteHelper.startPostWrite()");
            this.a.Z();
            boolean j0 = this.a.j0();
            this.b = j0;
            return j0;
        }
        return invokeV.booleanValue;
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            hu8.a("AsyncWriteHelper.cancelLoadData()");
            this.a.cancelLoadData();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            hu8.a("AsyncWriteHelper.checkImageNum = " + this.a.W());
            return this.a.W();
        }
        return invokeV.booleanValue;
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048590, this) == null) {
            FileHelper.deleteFileOrDir(new File(q09.f));
            or8.x("");
        }
    }

    public BdUniqueId i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return this.c;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return this.e;
        }
        return (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return this.g;
        }
        return (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return this.h;
        }
        return (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return this.i;
        }
        return (String) invokeV.objValue;
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) {
            return this.d;
        }
        return invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            if (this.f == 8) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final void v() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048604, this) == null) {
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.b = false;
        }
    }

    public void I(WriteData writeData) {
        String draftString;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            if (writeData == null) {
                draftString = StringUtil.NULL_STRING;
            } else {
                draftString = writeData.toDraftString();
            }
            sb.append(draftString);
            hu8.a(sb.toString());
            this.a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && this.c == null) {
                this.a.h0(this.j);
            } else {
                this.a.h0(this);
            }
        }
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, d35 d35Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeCommon(1048586, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, d35Var, writeData, antiData}) != null) || writeData == null) {
            return;
        }
        if (z) {
            PublishProgressData.valueOf(writeData, 100).send(true);
            ah.a().postDelayed(new b(this, postWriteCallBackData, writeData), 200L);
            if (writeData.isRichTextEditorMode()) {
                m05.b(writeData.getRichContentData().toString(), "2");
            } else {
                m05.b(writeData.getContentString(), "2");
            }
            f();
            g();
            w(postWriteCallBackData);
            if (!xi.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!xi.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            pu8.a(o(), postWriteCallBackData.getThreadId());
            PublishProgressData.valueOf(writeData, 100).send(false);
            k().x(null);
            v();
        } else if (!dl5.d(postWriteCallBackData, d35Var, writeData, antiData)) {
            PublishProgressData.valueOf(writeData, 100).send(false);
            new iu8().n(postWriteCallBackData, d35Var, writeData, antiData);
            k().x(null);
            v();
        }
    }

    public final void f() {
        WriteData o;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048589, this) != null) || (o = o()) == null) {
            return;
        }
        if (o.isAddThread()) {
            if (o.isLocalChannelDynamic()) {
                or8.v(null);
            } else if (o.isQuestionThread()) {
                or8.z(o.getForumId(), o, true);
            } else if (o.isEvaluate()) {
                or8.s(o.getItem_id(), null);
            } else if (TextUtils.isEmpty(o.getTopicId())) {
                or8.u(o.getForumId(), o, true);
            } else {
                or8.B(o.getTopicId(), null);
            }
        } else if (o.getType() == 1) {
            or8.y(o.getThreadId(), null);
        }
    }

    public void h(boolean z, PostWriteCallBackData postWriteCallBackData, d35 d35Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048591, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, d35Var, writeData, antiData}) == null) {
            if (writeData != null && writeData.isWork() && this.c == null) {
                this.j.callback(z, postWriteCallBackData, d35Var, writeData, antiData);
            } else {
                callback(z, postWriteCallBackData, d35Var, writeData, antiData);
            }
        }
    }
}
