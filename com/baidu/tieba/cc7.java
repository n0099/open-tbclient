package com.baidu.tieba;

import android.content.Context;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ForumData;
import com.baidu.tbadk.core.data.MetaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.ac7;
import com.baidu.tieba.im.share.ImShareDialogView;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes3.dex */
public class cc7 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ImShareDialogView a;
    public ac7 b;
    public bc7 c;
    public ThreadData d;
    public ForumData e;
    public MetaData f;
    public b g;

    /* loaded from: classes3.dex */
    public interface b {
        void a();

        void onCancel();
    }

    /* loaded from: classes3.dex */
    public class a implements bc7 {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Context a;
        public final /* synthetic */ cc7 b;

        public a(cc7 cc7Var, Context context) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {cc7Var, context};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.b = cc7Var;
            this.a = context;
        }

        @Override // com.baidu.tieba.bc7
        public void a() {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeV(1048576, this) == null) && this.b.b != null) {
                fj.x(this.a, this.b.a);
                this.b.b.dismiss();
                if (this.b.g != null) {
                    this.b.g.onCancel();
                }
            }
        }

        @Override // com.baidu.tieba.bc7
        public void b(String str) {
            boolean z;
            boolean z2;
            int i;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str) == null) {
                if (this.b.d != null) {
                    ThreadData threadData = this.b.d;
                    long userIdLong = this.b.f.getUserIdLong();
                    String userName = this.b.f.getUserName();
                    String name_show = this.b.f.getName_show();
                    String portrait = this.b.f.getPortrait();
                    if (this.b.f.getIsMyFriend() == 1) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    ed7.b(threadData, str, userIdLong, userName, name_show, portrait, z2);
                    j35.e(this.b.f.getUserIdLong());
                    if (this.b.d.threadType == 40) {
                        i = 2;
                    } else {
                        i = 1;
                    }
                    cc7 cc7Var = this.b;
                    cc7Var.q(1, 0, i, String.valueOf(cc7Var.f.getUserIdLong()));
                } else if (this.b.e != null) {
                    ForumData forumData = this.b.e;
                    long userIdLong2 = this.b.f.getUserIdLong();
                    String userName2 = this.b.f.getUserName();
                    String name_show2 = this.b.f.getName_show();
                    String portrait2 = this.b.f.getPortrait();
                    if (this.b.f.getIsMyFriend() == 1) {
                        z = true;
                    } else {
                        z = false;
                    }
                    ed7.a(forumData, str, userIdLong2, userName2, name_show2, portrait2, z);
                    cc7 cc7Var2 = this.b;
                    cc7Var2.q(1, 0, 3, String.valueOf(cc7Var2.f.getUserIdLong()));
                }
                if (this.b.b != null) {
                    fj.x(this.a, this.b.a);
                    this.b.b.dismiss();
                    if (this.b.g != null) {
                        this.b.g.a();
                    }
                }
            }
        }
    }

    public cc7(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        i(context);
        j(context);
    }

    public final void i(Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context) == null) {
            this.c = new a(this, context);
        }
    }

    public /* synthetic */ void l(Context context) {
        if (k(context, this.b.getWindow().getDecorView().findViewById(16908290))) {
            fj.x(context, this.a);
        } else {
            this.b.dismiss();
        }
    }

    public void m(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, bVar) == null) {
            this.g = bVar;
        }
    }

    public final boolean h() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            if (this.d == null && this.e == null) {
                return false;
            }
            return true;
        }
        return invokeV.booleanValue;
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) && this.b != null && h()) {
            this.b.show();
        }
    }

    public final void j(final Context context) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, context) == null) {
            ImShareDialogView imShareDialogView = new ImShareDialogView(context);
            this.a = imShareDialogView;
            imShareDialogView.setShareClickCallBack(this.c);
            ac7 ac7Var = new ac7(context, R.style.obfuscated_res_0x7f100107);
            this.b = ac7Var;
            ac7Var.setContentView(this.a);
            this.b.a(new ac7.a() { // from class: com.baidu.tieba.xb7
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.ac7.a
                public final void onClick() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048576, this) == null) {
                        cc7.this.l(context);
                    }
                }
            });
            Window window = this.b.getWindow();
            window.addFlags(512);
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.y = fj.f(TbadkCoreApplication.getInst(), R.dimen._bottom_enter_anim_place_holder_height);
            window.setAttributes(attributes);
            window.setWindowAnimations(R.style.obfuscated_res_0x7f1003f8);
            window.setGravity(80);
            window.setLayout(-1, -2);
        }
    }

    public final boolean k(Context context, View view2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048579, this, context, view2)) == null) {
            if (view2 == null) {
                return false;
            }
            int[] iArr = new int[2];
            view2.getLocationOnScreen(iArr);
            if (iArr[1] >= context.getResources().getDisplayMetrics().heightPixels / 2) {
                return false;
            }
            return true;
        }
        return invokeLL.booleanValue;
    }

    public void n(ForumData forumData, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048582, this, forumData, metaData) == null) {
            this.e = forumData;
            this.f = metaData;
            this.a.l(forumData, metaData);
        }
    }

    public void o(ThreadData threadData, MetaData metaData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048583, this, threadData, metaData) == null) {
            this.d = threadData;
            this.f = metaData;
            this.a.m(threadData, metaData);
        }
    }

    public final void q(int i, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) {
            TiebaStatic.log(new StatisticItem(TbadkCoreStatisticKey.KEY_SEND_MSG).addParam("obj_source", i).addParam("obj_param1", i3).addParam("uid", TbadkCoreApplication.getCurrentAccount()).addParam(TiebaStatic.Params.FRIEND_UID, str));
        }
    }
}
