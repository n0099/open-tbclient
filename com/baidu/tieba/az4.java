package com.baidu.tieba;

import android.content.Intent;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.atomData.AccountAccessActivityConfig;
import com.baidu.tbadk.core.atomData.HotTopicActivityConfig;
import com.baidu.tbadk.core.atomData.NewVcodeActivityConfig;
import com.baidu.tbadk.core.atomData.VcodeActivityConfig;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.view.spanGroup.SpanGroupManager;
import com.baidu.tbadk.coreExtra.data.WriteData;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tieba.bca;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.p55;
import com.baidu.tieba.tbadkCore.util.AntiHelper;
import com.baidu.tieba.tbadkCore.writeModel.NewWriteModel;
import com.baidu.tieba.tbadkCore.writeModel.PostWriteCallBackData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.util.ArrayList;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt__StringsJVMKt;
import org.json.JSONObject;
/* loaded from: classes5.dex */
public final class az4 extends dj5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> b;
    public zy4 c;
    public NewWriteModel d;
    public String e;
    public SpanGroupManager f;
    public String g;
    public String h;
    public String i;
    public final NewWriteModel.d j;
    public bca.g k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947632462, "Lcom/baidu/tieba/az4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947632462, "Lcom/baidu/tieba/az4;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public az4(final EditorTools editorTools) {
        super(editorTools);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {editorTools};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((EditorTools) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(editorTools, "editorTools");
        this.e = "";
        this.g = "none";
        this.h = "";
        this.i = "";
        this.j = new NewWriteModel.d() { // from class: com.baidu.tieba.xy4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public final void callback(boolean z, PostWriteCallBackData postWriteCallBackData, ve5 ve5Var, WriteData writeData, AntiData antiData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, ve5Var, writeData, antiData}) == null) {
                    az4.i(az4.this, z, postWriteCallBackData, ve5Var, writeData, antiData);
                }
            }
        };
        this.k = new bca.g() { // from class: com.baidu.tieba.uy4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.bca.g
            public final void a(WriteData writeData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, writeData) == null) {
                    az4.c(az4.this, editorTools, writeData);
                }
            }
        };
    }

    public static final void c(az4 this$0, EditorTools editorTools, WriteData writeData) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65538, null, this$0, editorTools, writeData) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            Intrinsics.checkNotNullParameter(editorTools, "$editorTools");
            if (writeData != null) {
                str = writeData.getContent();
            } else {
                str = null;
            }
            if (!StringUtils.isNull(str)) {
                String content = writeData.getContent();
                Intrinsics.checkNotNullExpressionValue(content, "draftData.content");
                this$0.e = content;
                editorTools.D(new zi5(6, 40, writeData.getContent()));
            }
        }
    }

    public static final void i(az4 this$0, boolean z, PostWriteCallBackData postWriteCallBackData, ve5 ve5Var, WriteData writeData, AntiData antiData) {
        WriteData writeData2;
        Integer num;
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        String str9;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{this$0, Boolean.valueOf(z), postWriteCallBackData, ve5Var, writeData, antiData}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String str10 = null;
            if (writeData == null) {
                NewWriteModel newWriteModel = this$0.d;
                if (newWriteModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    newWriteModel = null;
                }
                writeData2 = newWriteModel.l0();
            } else {
                writeData2 = writeData;
            }
            if (writeData2 == null) {
                return;
            }
            try {
                JSONObject jSONObject = new JSONObject();
                if (postWriteCallBackData != null) {
                    num = Integer.valueOf(postWriteCallBackData.getErrorCode());
                } else {
                    num = null;
                }
                jSONObject.put("errorCode", num);
                if (postWriteCallBackData != null) {
                    str = postWriteCallBackData.getErrorString();
                } else {
                    str = null;
                }
                jSONObject.put("errorString", str);
                if (postWriteCallBackData != null) {
                    str2 = postWriteCallBackData.getPostId();
                } else {
                    str2 = null;
                }
                jSONObject.put("postId", str2);
                if (postWriteCallBackData != null) {
                    str3 = postWriteCallBackData.getThreadId();
                } else {
                    str3 = null;
                }
                jSONObject.put("threadId", str3);
                if (writeData != null) {
                    str4 = writeData.getContent();
                } else {
                    str4 = null;
                }
                jSONObject.put("content", str4);
                if (writeData != null) {
                    str5 = writeData.getFloor();
                } else {
                    str5 = null;
                }
                jSONObject.put("floor", str5);
                if (writeData != null) {
                    str6 = writeData.getForumId();
                } else {
                    str6 = null;
                }
                jSONObject.put("forumId", str6);
                if (writeData != null) {
                    str7 = writeData.getForumName();
                } else {
                    str7 = null;
                }
                jSONObject.put("forumName", str7);
                if (writeData != null) {
                    str8 = writeData.getReplyId();
                } else {
                    str8 = null;
                }
                jSONObject.put("replyUId", str8);
                if (writeData != null) {
                    str9 = writeData.getRepostId();
                } else {
                    str9 = null;
                }
                jSONObject.put("repostId", str9);
                zy4 zy4Var = this$0.c;
                if (zy4Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mConfig");
                    zy4Var = null;
                }
                jSONObject.put("replyUName", zy4Var.a().get("replyUName"));
                jn6.a().h("webviewPage.replyResult", jSONObject);
            } catch (Exception unused) {
            }
            if (z) {
                this$0.d();
                this$0.o();
                this$0.m();
                return;
            }
            if (ve5Var != null) {
                str10 = ve5Var.d();
            }
            if (!TextUtils.isEmpty(str10)) {
                writeData2.setVcodeMD5(ve5Var.b());
                writeData2.setVcodeUrl(ve5Var.c());
                writeData2.setVcodeExtra(ve5Var.a());
                if (vz5.b(ve5Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this$0.getContext().getPageActivity(), 12006, writeData2, false, ve5Var.d())));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new VcodeActivityConfig(this$0.getContext().getPageActivity(), writeData2, 12006)));
                }
            } else if (postWriteCallBackData == null) {
            } else {
                if (postWriteCallBackData.getErrorCode() == 227001) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AccountAccessActivityConfig(this$0.getContext().getPageActivity(), 12006, writeData2, postWriteCallBackData.getAccessState())));
                } else if (postWriteCallBackData.getErrorCode() == 220015) {
                    this$0.u(postWriteCallBackData.getErrorString());
                } else if (postWriteCallBackData.getErrorCode() != 230277 && postWriteCallBackData.getErrorCode() != 230278 && postWriteCallBackData.getErrorCode() != 340016 && postWriteCallBackData.getErrorCode() != 1990032 && !AntiHelper.l(postWriteCallBackData.getErrorCode())) {
                    this$0.u(postWriteCallBackData.getErrorString());
                } else {
                    int errorCode = postWriteCallBackData.getErrorCode();
                    String errorString = postWriteCallBackData.getErrorString();
                    Intrinsics.checkNotNullExpressionValue(errorString, "data.errorString");
                    this$0.s(errorCode, errorString);
                }
            }
        }
    }

    public static final void t(p55 p55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, p55Var) == null) {
            p55Var.dismiss();
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            zy4 zy4Var = this.c;
            if (zy4Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConfig");
                zy4Var = null;
            }
            Object obj = zy4Var.a().get(str);
            if (!(obj instanceof String)) {
                return null;
            }
            return (String) obj;
        }
        return (String) invokeL.objValue;
    }

    public final void h(TbPageContext<?> context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, context) == null) {
            Intrinsics.checkNotNullParameter(context, "context");
            p(context);
            NewWriteModel newWriteModel = new NewWriteModel(context);
            this.d = newWriteModel;
            if (newWriteModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                newWriteModel = null;
            }
            newWriteModel.t0(this.j);
        }
    }

    public final void p(TbPageContext<?> tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048588, this, tbPageContext) == null) {
            Intrinsics.checkNotNullParameter(tbPageContext, "<set-?>");
            this.b = tbPageContext;
        }
    }

    public final void q(String content) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048589, this, content) == null) {
            Intrinsics.checkNotNullParameter(content, "content");
            this.e = content;
        }
    }

    public final void r(SpanGroupManager spanGroupManager) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, spanGroupManager) == null) {
            this.f = spanGroupManager;
        }
    }

    public final void u(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, str) == null) && !StringUtils.isNull(str)) {
            getContext().showToast(str);
        }
    }

    public final void d() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            if (!TextUtils.isEmpty(this.h)) {
                bca.z(this.h, null);
            } else if (!TextUtils.isEmpty(this.i)) {
                bca.B(this.i, null);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TextUtils.isEmpty(this.h)) {
                bca.p(this.h, this.k);
            } else if (!TextUtils.isEmpty(this.i)) {
                bca.r(this.i, this.k);
            }
        }
    }

    public final SpanGroupManager f() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return this.f;
        }
        return (SpanGroupManager) invokeV.objValue;
    }

    public final TbPageContext<?> getContext() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            TbPageContext<?> tbPageContext = this.b;
            if (tbPageContext != null) {
                return tbPageContext;
            }
            Intrinsics.throwUninitializedPropertyAccessException("context");
            return null;
        }
        return (TbPageContext) invokeV.objValue;
    }

    public final void k() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            NewWriteModel newWriteModel = this.d;
            if (newWriteModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                newWriteModel = null;
            }
            newWriteModel.cancelLoadData();
            n();
        }
    }

    public final void m() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            NewWriteModel newWriteModel = this.d;
            NewWriteModel newWriteModel2 = null;
            if (newWriteModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                newWriteModel = null;
            }
            newWriteModel.setWriteData(null);
            NewWriteModel newWriteModel3 = this.d;
            if (newWriteModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            } else {
                newWriteModel2 = newWriteModel3;
            }
            newWriteModel2.r0(false);
        }
    }

    public void j(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) && i2 == -1) {
            if (i != 12004 && i != 12005) {
                if (i == 25004 && intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (b() != null) {
                        b().D(new zi5(44, 40, stringExtra));
                    }
                }
            } else if (intent != null) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                if (b() != null) {
                    b().D(new zi5(17, 40, parcelableArrayListExtra));
                }
            }
        }
    }

    public final void l() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            WriteData writeData = new WriteData();
            writeData.setForumId(g("forumId"));
            writeData.setForumName(g("forumName"));
            writeData.setThreadId(g("threadId"));
            if (!TextUtils.isEmpty(this.g) && !Intrinsics.areEqual("text", this.g)) {
                if (Intrinsics.areEqual("reply", this.g)) {
                    writeData.setType(1);
                } else if (Intrinsics.areEqual("replyFloor", this.g)) {
                    writeData.setType(2);
                    String g = g("postId");
                    writeData.setFloor(g);
                    writeData.setFloorNum(0);
                    writeData.setReplyId(g("replyUid"));
                    writeData.setRepostId(g);
                    writeData.setPortrait(g("portrait"));
                    writeData.setName(g("name"));
                    writeData.setReSubPostId(g("reSubPostId"));
                    writeData.setSubPbReplyPrefix(g("subPbReplyPrefix"));
                }
            } else {
                writeData.setType(9);
            }
            writeData.setContent(this.e);
            writeData.onPostDataParse(this.f);
            NewWriteModel newWriteModel = this.d;
            NewWriteModel newWriteModel2 = null;
            if (newWriteModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                newWriteModel = null;
            }
            newWriteModel.setWriteData(writeData);
            NewWriteModel newWriteModel3 = this.d;
            if (newWriteModel3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
            } else {
                newWriteModel2 = newWriteModel3;
            }
            newWriteModel2.w0();
        }
    }

    public final void n() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            NewWriteModel newWriteModel = this.d;
            if (newWriteModel == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                newWriteModel = null;
            }
            WriteData l0 = newWriteModel.l0();
            if (l0 == null) {
                l0 = new WriteData();
            }
            l0.setForumId(g("forumId"));
            l0.setForumName(g("forumName"));
            l0.setThreadId(this.h);
            l0.setContent(this.e);
            if (!TextUtils.isEmpty(this.h)) {
                l0.setType(1);
                bca.z(this.h, l0);
            } else if (!TextUtils.isEmpty(this.i)) {
                l0.setType(2);
                l0.setReplyId(g("replyUid"));
                l0.setFloor(this.i);
                l0.setPortrait(g("portrait"));
                l0.setName(g("name"));
                l0.setReSubPostId(g("reSubPostId"));
                l0.setSubPbReplyPrefix(g("subPbReplyPrefix"));
                bca.B(this.i, l0);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && b() != null) {
            b().D(new zi5(9, -1, Boolean.TRUE));
            b().D(new zi5(4, -1, ""));
            b().q();
        }
    }

    public final void s(int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeIL(1048591, this, i, str) == null) {
            if (AntiHelper.m(i, str)) {
                AntiHelper.w(getContext().getPageActivity(), str, i, null);
            } else if (i != 230277 && i != 230278) {
                u(str);
            } else {
                p55 p55Var = new p55(getContext().getPageActivity());
                p55Var.setMessage(str);
                p55Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b3d, new p55.e() { // from class: com.baidu.tieba.vy4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.p55.e
                    public final void onClick(p55 p55Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, p55Var2) == null) {
                            az4.t(p55Var2);
                        }
                    }
                });
                p55Var.create(getContext()).show();
            }
        }
    }

    public final void v(zy4 config) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.c = config;
            lj5 p = b().p(40);
            Intrinsics.checkNotNullExpressionValue(p, "editorTools.findToolById…rToolsID.TOOL_ID_WEBVIEW)");
            if (p instanceof cz4) {
                ((cz4) p).h(config);
                this.e = "";
            }
            String g = g("threadId");
            String g2 = g("postId");
            zy4 zy4Var = this.c;
            if (zy4Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConfig");
                zy4Var = null;
            }
            boolean z2 = true;
            if (!Intrinsics.areEqual(zy4Var.a, this.g)) {
                zy4 zy4Var2 = this.c;
                if (zy4Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mConfig");
                    zy4Var2 = null;
                }
                String str = zy4Var2.a;
                Intrinsics.checkNotNullExpressionValue(str, "mConfig.mPostType");
                this.g = str;
                z = true;
            } else {
                z = false;
            }
            if (Intrinsics.areEqual("reply", this.g) && !TextUtils.isEmpty(g)) {
                if (!StringsKt__StringsJVMKt.equals$default(g, this.h, false, 2, null)) {
                    Intrinsics.checkNotNull(g);
                    this.h = g;
                    this.i = "";
                }
                z2 = z;
            } else {
                if (Intrinsics.areEqual("replyFloor", this.g) && !TextUtils.isEmpty(g2) && !StringsKt__StringsJVMKt.equals$default(g2, this.i, false, 2, null)) {
                    this.h = "";
                    Intrinsics.checkNotNull(g2);
                    this.i = g2;
                }
                z2 = z;
            }
            HybridLog.getInstance().c("WebViewEditor", "updateConfig " + z2 + WebvttCueParser.CHAR_SPACE + this.g + WebvttCueParser.CHAR_SPACE + g + WebvttCueParser.CHAR_SPACE + g2);
            if (z2) {
                this.e = "";
                b().D(new zi5(6, 40, ""));
                e();
            }
        }
    }
}
