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
import com.baidu.tbadk.vcode.VcodeTool;
import com.baidu.tieba.browser.log.HybridLog;
import com.baidu.tieba.dfa;
import com.baidu.tieba.s45;
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
public final class dy4 extends di5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext<?> b;
    public cy4 c;
    public NewWriteModel d;
    public String e;
    public SpanGroupManager f;
    public String g;
    public String h;
    public String i;
    public final NewWriteModel.d j;
    public dfa.h k;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1947720874, "Lcom/baidu/tieba/dy4;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1947720874, "Lcom/baidu/tieba/dy4;");
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public dy4(final EditorTools editorTools) {
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
        this.j = new NewWriteModel.d() { // from class: com.baidu.tieba.ay4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.tbadkCore.writeModel.NewWriteModel.d
            public final void callback(boolean z, PostWriteCallBackData postWriteCallBackData, qd5 qd5Var, WriteData writeData, AntiData antiData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeCommon(1048576, this, new Object[]{Boolean.valueOf(z), postWriteCallBackData, qd5Var, writeData, antiData}) == null) {
                    dy4.i(dy4.this, z, postWriteCallBackData, qd5Var, writeData, antiData);
                }
            }
        };
        this.k = new dfa.h() { // from class: com.baidu.tieba.xx4
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            @Override // com.baidu.tieba.dfa.h
            public final void c(WriteData writeData) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeL(1048576, this, writeData) == null) {
                    dy4.b(dy4.this, editorTools, writeData);
                }
            }
        };
    }

    public static final void b(dy4 this$0, EditorTools editorTools, WriteData writeData) {
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
                editorTools.D(new zh5(6, 40, writeData.getContent()));
            }
        }
    }

    public static final void i(dy4 this$0, boolean z, PostWriteCallBackData postWriteCallBackData, qd5 qd5Var, WriteData writeData, AntiData antiData) {
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
        if (interceptable == null || interceptable.invokeCommon(65539, null, new Object[]{this$0, Boolean.valueOf(z), postWriteCallBackData, qd5Var, writeData, antiData}) == null) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            String str10 = null;
            if (writeData == null) {
                NewWriteModel newWriteModel = this$0.d;
                if (newWriteModel == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mWriteModel");
                    newWriteModel = null;
                }
                writeData2 = newWriteModel.d0();
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
                cy4 cy4Var = this$0.c;
                if (cy4Var == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mConfig");
                    cy4Var = null;
                }
                jSONObject.put("replyUName", cy4Var.a().get("replyUName"));
                wl6.a().h("webviewPage.replyResult", jSONObject);
            } catch (Exception unused) {
            }
            if (z) {
                this$0.d();
                this$0.o();
                this$0.m();
                return;
            }
            if (qd5Var != null) {
                str10 = qd5Var.d();
            }
            if (!TextUtils.isEmpty(str10)) {
                writeData2.setVcodeMD5(qd5Var.b());
                writeData2.setVcodeUrl(qd5Var.c());
                writeData2.setVcodeExtra(qd5Var.a());
                if (VcodeTool.needVcode(qd5Var.d())) {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new NewVcodeActivityConfig(this$0.getContext().getPageActivity(), 12006, writeData2, false, qd5Var.d())));
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

    public static final void t(s45 s45Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TRACKBALL, null, s45Var) == null) {
            s45Var.dismiss();
        }
    }

    public final String g(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, str)) == null) {
            cy4 cy4Var = this.c;
            if (cy4Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConfig");
                cy4Var = null;
            }
            Object obj = cy4Var.a().get(str);
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
            newWriteModel.l0(this.j);
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
                dfa.C(this.h, null);
            } else if (!TextUtils.isEmpty(this.i)) {
                dfa.E(this.i, null);
            }
        }
    }

    public final void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            if (!TextUtils.isEmpty(this.h)) {
                dfa.r(this.h, this.k);
            } else if (!TextUtils.isEmpty(this.i)) {
                dfa.t(this.i, this.k);
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
            newWriteModel2.j0(false);
        }
    }

    public void j(int i, int i2, Intent intent) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIIL(1048582, this, i, i2, intent) == null) && i2 == -1) {
            if (i != 12004 && i != 12005) {
                if (i == 25004 && intent != null) {
                    String stringExtra = intent.getStringExtra(HotTopicActivityConfig.HOT_TOPIC_SELECT_STRING);
                    if (a() != null) {
                        a().D(new zh5(44, 40, stringExtra));
                    }
                }
            } else if (intent != null) {
                ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(IntentConfig.AT_SELECT_LIST_DATA);
                if (a() != null) {
                    a().D(new zh5(17, 40, parcelableArrayListExtra));
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
            newWriteModel2.o0();
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
            WriteData d0 = newWriteModel.d0();
            if (d0 == null) {
                d0 = new WriteData();
            }
            d0.setForumId(g("forumId"));
            d0.setForumName(g("forumName"));
            d0.setThreadId(this.h);
            d0.setContent(this.e);
            if (!TextUtils.isEmpty(this.h)) {
                d0.setType(1);
                dfa.C(this.h, d0);
            } else if (!TextUtils.isEmpty(this.i)) {
                d0.setType(2);
                d0.setReplyId(g("replyUid"));
                d0.setFloor(this.i);
                d0.setPortrait(g("portrait"));
                d0.setName(g("name"));
                d0.setReSubPostId(g("reSubPostId"));
                d0.setSubPbReplyPrefix(g("subPbReplyPrefix"));
                dfa.E(this.i, d0);
            }
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(1048587, this) == null) && a() != null) {
            a().D(new zh5(9, -1, Boolean.TRUE));
            a().D(new zh5(4, -1, ""));
            a().q();
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
                s45 s45Var = new s45(getContext().getPageActivity());
                s45Var.setMessage(str);
                s45Var.setNegativeButton(R.string.obfuscated_res_0x7f0f0b46, new s45.e() { // from class: com.baidu.tieba.yx4
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    @Override // com.baidu.tieba.s45.e
                    public final void onClick(s45 s45Var2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, s45Var2) == null) {
                            dy4.t(s45Var2);
                        }
                    }
                });
                s45Var.create(getContext()).show();
            }
        }
    }

    public final void v(cy4 config) {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048593, this, config) == null) {
            Intrinsics.checkNotNullParameter(config, "config");
            this.c = config;
            li5 p = a().p(40);
            Intrinsics.checkNotNullExpressionValue(p, "editorTools.findToolById…rToolsID.TOOL_ID_WEBVIEW)");
            if (p instanceof fy4) {
                ((fy4) p).h(config);
                this.e = "";
            }
            String g = g("threadId");
            String g2 = g("postId");
            cy4 cy4Var = this.c;
            if (cy4Var == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mConfig");
                cy4Var = null;
            }
            boolean z2 = true;
            if (!Intrinsics.areEqual(cy4Var.a, this.g)) {
                cy4 cy4Var2 = this.c;
                if (cy4Var2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mConfig");
                    cy4Var2 = null;
                }
                String str = cy4Var2.a;
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
            HybridLog.getInstance().i("WebViewEditor", "updateConfig " + z2 + WebvttCueParser.CHAR_SPACE + this.g + WebvttCueParser.CHAR_SPACE + g + WebvttCueParser.CHAR_SPACE + g2);
            if (z2) {
                this.e = "";
                a().D(new zh5(6, 40, ""));
                e();
            }
        }
    }
}
