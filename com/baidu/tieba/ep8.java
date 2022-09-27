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
/* loaded from: classes3.dex */
public class ep8 implements NewWriteModel.d {
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

    /* loaded from: classes3.dex */
    public class a implements NewWriteModel.d {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ep8 a;

        /* renamed from: com.baidu.tieba.ep8$a$a  reason: collision with other inner class name */
        /* loaded from: classes3.dex */
        public class RunnableC0239a implements Runnable {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ WriteData a;
            public final /* synthetic */ PostWriteCallBackData b;
            public final /* synthetic */ a c;

            public RunnableC0239a(a aVar, WriteData writeData, PostWriteCallBackData postWriteCallBackData) {
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
                    if ((!dj.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) || (this.a.getVideoInfo() != null && this.a.getVideoInfo().hasUpload())) {
                        new gp8().q(this.b);
                    } else {
                        new gp8().p(this.b, this.a);
                    }
                    this.c.a.f();
                    this.c.a.g();
                    if (!dj.isEmpty(this.b.getVideoid()) && this.a.getVideoInfo() != null) {
                        this.b.mVideoMd5 = this.a.getVideoInfo().getVideoMd5();
                        if (!dj.isEmpty(this.a.getForumName())) {
                            this.b.mFrom = 2;
                        }
                    }
                    this.c.a.u();
                }
            }
        }

        public a(ep8 ep8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ep8Var;
        }

        @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
        public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) || writeData == null) {
                return;
            }
            if (z) {
                WorkPostNotifyFlutterData notifyFlutterPostSucc = WorkPostNotifyFlutterData.notifyFlutterPostSucc(postWriteCallBackData.getVideoid());
                notifyFlutterPostSucc.setForumId(writeData.getForumId());
                notifyFlutterPostSucc.setForumName(writeData.getForumName());
                notifyFlutterPostSucc.setThreadDataByWriteData(writeData);
                notifyFlutterPostSucc.setFlutterPageId(this.a.j());
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, notifyFlutterPostSucc));
                int l = ox4.k().l("key_video_works_progress_bar_waiting_time", 3);
                gh.a().postDelayed(new RunnableC0239a(this, writeData, postWriteCallBackData), ((l > 0 ? l : 3) + 1) * 1000);
                ep8.k().w(null);
                this.a.u();
            } else if (vi5.d(postWriteCallBackData, y15Var, writeData, antiData)) {
            } else {
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921592, WorkPostNotifyFlutterData.notifyFlutterPostFail(postWriteCallBackData != null ? postWriteCallBackData.getErrorString() : "")));
                new gp8().n(postWriteCallBackData, y15Var, writeData, antiData);
                ep8.k().w(null);
                this.a.u();
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ PostWriteCallBackData a;
        public final /* synthetic */ WriteData b;

        public b(ep8 ep8Var, PostWriteCallBackData postWriteCallBackData, WriteData writeData) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ep8Var, postWriteCallBackData, writeData};
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
                if ((!dj.isEmpty(this.a.getVideoid()) && this.b.getVideoInfo() != null) || (this.b.getVideoInfo() != null && this.b.getVideoInfo().hasUpload())) {
                    new gp8().q(this.a);
                    return;
                }
                Activity currentActivity = TbadkCoreApplication.getInst().getCurrentActivity();
                if (currentActivity != null) {
                    boolean areNotificationsEnabled = NotificationManagerCompat.from(currentActivity).areNotificationsEnabled();
                    if (areNotificationsEnabled && k25.d().e && k25.d().f) {
                        new gp8().p(this.a, this.b);
                    } else if ((areNotificationsEnabled && k25.d().e && k25.d().f) || this.a.getToast() != null || this.b.isShareThread()) {
                    } else {
                        if (f35.j(TbadkCoreApplication.getInst().getCurrentActivity(), 2)) {
                            new gp8().o(this.a, 9);
                        } else {
                            new gp8().p(this.a, this.b);
                        }
                    }
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public static class c {
        public static /* synthetic */ Interceptable $ic;
        public static final ep8 a;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-825563491, "Lcom/baidu/tieba/ep8$c;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(-825563491, "Lcom/baidu/tieba/ep8$c;");
                    return;
                }
            }
            a = new ep8(null);
        }
    }

    public /* synthetic */ ep8(a aVar) {
        this();
    }

    public static ep8 k() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65541, null)) == null) {
            fp8.a("AsyncWriteHelper.getInstance()");
            return c.a;
        }
        return (ep8) invokeV.objValue;
    }

    public void A(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048576, this, z) == null) {
            fp8.a("AsyncWriteHelper.setHasImage = " + z);
            this.a.Z(z);
        }
    }

    public void B(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, z) == null) {
            this.a.Y(z);
        }
    }

    public void C(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str) == null) {
            this.g = str;
        }
    }

    public void D(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, str) == null) {
            this.h = str;
        }
    }

    public void E(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            this.i = str;
        }
    }

    public void F(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048581, this, z) == null) {
            this.a.a0(z);
        }
    }

    public void G(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, spanGroupManager) == null) {
            fp8.a("AsyncWriteHelper.setSpanGroupManager()");
            this.a.T();
            this.a.setSpanGroupManager(spanGroupManager);
        }
    }

    public void H(WriteData writeData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, writeData) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.setWriteData = ");
            sb.append(writeData == null ? StringUtil.NULL_STRING : writeData.toDraftString());
            fp8.a(sb.toString());
            this.a.setWriteData(writeData);
            if (writeData != null && writeData.isWork() && this.c == null) {
                this.a.b0(this.j);
            } else {
                this.a.b0(this);
            }
        }
    }

    public boolean I() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            fp8.a("AsyncWriteHelper.startPostWrite()");
            this.a.T();
            boolean d0 = this.a.d0();
            this.b = d0;
            return d0;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
    public void callback(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) || writeData == null) {
            return;
        }
        if (z) {
            PublishProgressData.valueOf(writeData, 100).send(true);
            gh.a().postDelayed(new b(this, postWriteCallBackData, writeData), 200L);
            if (writeData.isRichTextEditorMode()) {
                lz4.b(writeData.getRichContentData().toString(), "2");
            } else {
                lz4.b(writeData.getContentString(), "2");
            }
            f();
            g();
            v(postWriteCallBackData);
            if (!dj.isEmpty(postWriteCallBackData.getVideoid()) && writeData.getVideoInfo() != null) {
                postWriteCallBackData.mVideoMd5 = writeData.getVideoInfo().getVideoMd5();
                if (!dj.isEmpty(writeData.getForumName())) {
                    postWriteCallBackData.mFrom = 2;
                }
            }
            np8.a(o(), postWriteCallBackData.getThreadId());
            PublishProgressData.valueOf(writeData, 100).send(false);
            k().w(null);
            u();
        } else if (vi5.d(postWriteCallBackData, y15Var, writeData, antiData)) {
        } else {
            PublishProgressData.valueOf(writeData, 100).send(false);
            new gp8().n(postWriteCallBackData, y15Var, writeData, antiData);
            k().w(null);
            u();
        }
    }

    public void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            fp8.a("AsyncWriteHelper.cancelLoadData()");
            this.a.cancelLoadData();
        }
    }

    public boolean e() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            fp8.a("AsyncWriteHelper.checkImageNum = " + this.a.Q());
            return this.a.Q();
        }
        return invokeV.booleanValue;
    }

    public final void f() {
        WriteData o;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeV(1048588, this) == null) || (o = o()) == null) {
            return;
        }
        if (o.isAddThread()) {
            if (o.isLocalChannelDynamic()) {
                nm8.v(null);
            } else if (o.isQuestionThread()) {
                nm8.z(o.getForumId(), o, true);
            } else if (o.isEvaluate()) {
                nm8.s(o.getItem_id(), null);
            } else if (TextUtils.isEmpty(o.getTopicId())) {
                nm8.u(o.getForumId(), o, true);
            } else {
                nm8.B(o.getTopicId(), null);
            }
        } else if (o.getType() == 1) {
            nm8.y(o.getThreadId(), null);
        }
    }

    public final void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048589, this) == null) {
            FileHelper.deleteFileOrDir(new File(cv8.f));
            nm8.x("");
        }
    }

    public void h(boolean z, PostWriteCallBackData postWriteCallBackData, y15 y15Var, WriteData writeData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048590, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, y15Var, writeData, antiData}) == null) {
            if (writeData != null && writeData.isWork() && this.c == null) {
                this.j.callback(z, postWriteCallBackData, y15Var, writeData, antiData);
            } else {
                callback(z, postWriteCallBackData, y15Var, writeData, antiData);
            }
        }
    }

    public BdUniqueId i() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) ? this.c : (BdUniqueId) invokeV.objValue;
    }

    public String j() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) ? this.e : (String) invokeV.objValue;
    }

    public String l() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) ? this.g : (String) invokeV.objValue;
    }

    public String m() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) ? this.h : (String) invokeV.objValue;
    }

    public String n() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) ? this.i : (String) invokeV.objValue;
    }

    public WriteData o() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            StringBuilder sb = new StringBuilder();
            sb.append("AsyncWriteHelper.getWriteData = ");
            sb.append(this.a.S() == null ? StringUtil.NULL_STRING : this.a.S().toDraftString());
            fp8.a(sb.toString());
            return this.a.S();
        }
        return (WriteData) invokeV.objValue;
    }

    public void p(@NonNull TbPageContextSupport tbPageContextSupport) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048597, this, tbPageContextSupport) == null) {
            fp8.a("AsyncWriteHelper.initWriteStatus()");
            this.a.c0(tbPageContextSupport.getPageContext());
            this.a.setWriteData(null);
            this.a.Z(false);
        }
    }

    public boolean q() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public boolean r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048599, this)) == null) ? this.d : invokeV.booleanValue;
    }

    public boolean s() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048600, this)) == null) ? this.f == 8 : invokeV.booleanValue;
    }

    public void t() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048601, this) == null) {
            fp8.a("AsyncWriteHelper.onWriteActClose()");
            this.a.c0(null);
            this.a.setSpanGroupManager(null);
        }
    }

    public final void u() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048602, this) == null) {
            NewWriteModel newWriteModel = this.a;
            if (newWriteModel != null) {
                newWriteModel.setWriteData(null);
            }
            this.b = false;
        }
    }

    public final void v(PostWriteCallBackData postWriteCallBackData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048603, this, postWriteCallBackData) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2004510, postWriteCallBackData));
        }
    }

    public void w(BdUniqueId bdUniqueId) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048604, this, bdUniqueId) == null) {
            this.c = bdUniqueId;
        }
    }

    public void x(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048605, this, str) == null) {
            this.e = str;
        }
    }

    public void y(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048606, this, i) == null) {
            this.f = i;
        }
    }

    public void z(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048607, this, z) == null) {
            this.d = z;
        }
    }

    public ep8() {
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
        newWriteModel.b0(this);
    }
}
