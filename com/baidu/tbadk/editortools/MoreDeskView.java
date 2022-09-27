package com.baidu.tbadk.editortools;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseIntArray;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import com.baidu.tieba.dh;
import com.baidu.tieba.h55;
import com.baidu.tieba.o55;
import com.baidu.tieba.p55;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MoreDeskView extends CommonTabHost {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<o55> m;
    public SparseIntArray n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreDeskView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MoreDeskView moreDeskView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreDeskView, Integer.valueOf(i)};
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
            this.a = moreDeskView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.r();
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ MoreDeskView a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MoreDeskView moreDeskView, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreDeskView, Integer.valueOf(i)};
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
            this.a = moreDeskView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.a.r();
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreDeskView(Context context) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.n = new SparseIntArray();
        this.o = new a(this, 2001344);
        this.p = new b(this, 2001353);
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tieba.i55
    public void B(h55 h55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, h55Var) == null) {
            super.B(h55Var);
            if (h55Var == null || h55Var.a != 2 || h55Var.b == 5) {
                return;
            }
            q(h55Var);
            o();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tieba.t55
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.display();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tieba.t55
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setShowDelete(false);
            p55 p55Var = new p55();
            p55Var.C(this.m);
            h(p55Var);
            r();
        }
    }

    public void n(LinkedList<o55> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, linkedList) == null) {
            this.m = linkedList;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i = 0;
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                i += this.n.valueAt(i2);
            }
            if (i > 0) {
                K(new h55(2, 2, " "));
            } else {
                K(new h55(2, 2, null));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.p);
            r();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public final void p(boolean z) {
        AccountData currentAccountObj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048583, this, z) == null) || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null) {
            return;
        }
        currentAccountObj.setIsSelectTail(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(h55 h55Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, h55Var) == null) {
            Integer valueOf = Integer.valueOf(this.n.get(h55Var.b));
            int intValue = valueOf != null ? valueOf.intValue() : 0;
            Object obj = h55Var.c;
            if (obj != null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        intValue = TextUtils.isEmpty(str.trim()) ? 1 : dh.e(str, 1);
                    }
                }
                this.n.put(h55Var.b, intValue >= 0 ? intValue : 0);
            }
            intValue = 0;
            this.n.put(h55Var.b, intValue >= 0 ? intValue : 0);
        }
    }

    public final void r() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048585, this) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            String defaultBubble = TbadkCoreApplication.getInst().getDefaultBubble();
            if (currentAccountObj == null) {
                return;
            }
            if (currentAccountObj.getIsSelectTail()) {
                z = true;
                K(new h55(2, 2, " "));
                K(new h55(2, 16, " "));
            } else {
                if (!StringUtils.isNull(defaultBubble)) {
                    K(new h55(2, 12, " "));
                    K(new h55(2, 2, " "));
                } else {
                    K(new h55(2, 2, null));
                }
                z = false;
            }
            p(z);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public MoreDeskView(Context context, boolean z) {
        super(context);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.n = new SparseIntArray();
        this.o = new a(this, 2001344);
        this.p = new b(this, 2001353);
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
    }
}
