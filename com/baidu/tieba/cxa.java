package com.baidu.tieba;

import android.view.View;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.safe.SafeHandler;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AddLinkActivityConfig;
import com.baidu.tbadk.core.dialog.WriteTipBubbleController;
import com.baidu.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.UrlManager;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.editortools.EditorTools;
import com.baidu.tbadk.switchs.AsyncGetClipboardSwitch;
import com.baidu.tieba.write.write.NewWriteActivity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class cxa {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @NonNull
    public final TbPageContext<?> a;
    @NonNull
    public final EditorTools b;
    @Nullable
    public WriteTipBubbleController c;
    public final CustomMessageListener d;
    public final WriteTipBubbleController.b e;

    /* loaded from: classes5.dex */
    public class c implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cxa a;

        /* loaded from: classes5.dex */
        public class a extends kw5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            public a(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.kw5
            public String doInBackground() {
                InterceptResult invokeV;
                Interceptable interceptable = $ic;
                if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
                    return UtilHelper.getClipBoardContent();
                }
                return (String) invokeV.objValue;
            }
        }

        /* loaded from: classes5.dex */
        public class b implements pv5<String> {
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ c a;

            public b(c cVar) {
                Interceptable interceptable = $ic;
                if (interceptable != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {cVar};
                    interceptable.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.a = cVar;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.tieba.pv5
            /* renamed from: a */
            public void onReturnDataInUI(String str) {
                Interceptable interceptable = $ic;
                if (interceptable != null && interceptable.invokeL(1048576, this, str) != null) {
                    return;
                }
                this.a.a.h(str);
            }
        }

        public c(cxa cxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cxaVar;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.a.b.a != null) {
                if (AsyncGetClipboardSwitch.isOn() && TbadkCoreApplication.getInst().isMIUIRom()) {
                    ow5.b(new a(this), new b(this));
                    return;
                }
                this.a.h(UtilHelper.getClipBoardContent());
            }
        }
    }

    /* loaded from: classes5.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cxa a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(cxa cxaVar, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cxaVar, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cxaVar;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof BackgroundSwitchMessage) && !((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue()) {
                this.a.e();
            }
        }
    }

    /* loaded from: classes5.dex */
    public class b implements WriteTipBubbleController.b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ cxa a;

        public b(cxa cxaVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cxaVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = cxaVar;
        }

        @Override // com.baidu.tbadk.core.dialog.WriteTipBubbleController.b
        public void a(View view2, String str) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeLL(1048576, this, view2, str) != null) || this.a.c == null) {
                return;
            }
            TiebaStatic.log("c13802");
            this.a.c.c();
            UtilHelper.clearClipBoard();
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AddLinkActivityConfig(this.a.a.getPageActivity(), 25049, str, false, null)));
        }
    }

    /* loaded from: classes5.dex */
    public class d implements Runnable {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ String a;
        public final /* synthetic */ cxa b;

        public d(cxa cxaVar, String str) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cxaVar, str};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cxaVar;
            this.a = str;
        }

        @Override // java.lang.Runnable
        public void run() {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
                View s = this.b.b.a.s(31);
                WriteTipBubbleController writeTipBubbleController = this.b.c;
                writeTipBubbleController.d(s, this.b.a.getString(R.string.find_new_link) + "\n" + this.a, this.a, WriteTipBubbleController.ANCHOR_VIEW_FROM.FROM_EDITOR_TOOL);
            }
        }
    }

    public cxa(@NonNull TbPageContext<?> tbPageContext, @NonNull EditorTools editorTools) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext, editorTools};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.d = new a(this, 2001011);
        this.e = new b(this);
        this.a = tbPageContext;
        this.b = editorTools;
    }

    public void e() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            this.b.post(new c(this));
        }
    }

    public void f() {
        WriteTipBubbleController writeTipBubbleController;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) && (writeTipBubbleController = this.c) != null) {
            writeTipBubbleController.c();
        }
    }

    public void g() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            this.a.registerListener(this.d);
        }
    }

    public final void h(String str) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048579, this, str) == null) && !bi.isEmpty(str) && UrlManager.getInstance().isUrlValid(str)) {
            int i = 0;
            if ((this.a.getPageActivity() instanceof NewWriteActivity) && ((NewWriteActivity) this.a.getPageActivity()).u1()) {
                i = 5000;
            }
            if (this.c == null) {
                this.c = new WriteTipBubbleController(this.a, this.e);
            }
            SafeHandler.getInst().postDelayed(new d(this, str), i);
        }
    }
}
