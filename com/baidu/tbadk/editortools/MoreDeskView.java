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
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.j15;
import com.repackage.ng;
import com.repackage.q15;
import com.repackage.r15;
import java.util.LinkedList;
/* loaded from: classes3.dex */
public class MoreDeskView extends CommonTabHost {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<q15> m;
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
            this.a.s();
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
                this.a.s();
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

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.repackage.k15
    public void C(j15 j15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, j15Var) == null) {
            super.C(j15Var);
            if (j15Var == null || j15Var.a != 2 || j15Var.b == 5) {
                return;
            }
            q(j15Var);
            o();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.repackage.v15
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setShowDelete(false);
            r15 r15Var = new r15();
            r15Var.D(this.m);
            h(r15Var);
            s();
        }
    }

    public void n(LinkedList<q15> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, linkedList) == null) {
            this.m = linkedList;
        }
    }

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            int i = 0;
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                i += this.n.valueAt(i2);
            }
            if (i > 0) {
                L(new j15(2, 2, " "));
            } else {
                L(new j15(2, 2, null));
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.p);
            s();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.o);
            MessageManager.getInstance().unRegisterListener(this.p);
        }
    }

    public final void p(boolean z) {
        AccountData currentAccountObj;
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeZ(1048582, this, z) == null) || (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) == null) {
            return;
        }
        currentAccountObj.setIsSelectTail(z);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void q(j15 j15Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, j15Var) == null) {
            Integer valueOf = Integer.valueOf(this.n.get(j15Var.b));
            int intValue = valueOf != null ? valueOf.intValue() : 0;
            Object obj = j15Var.c;
            if (obj != null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        intValue = TextUtils.isEmpty(str.trim()) ? 1 : ng.e(str, 1);
                    }
                }
                this.n.put(j15Var.b, intValue >= 0 ? intValue : 0);
            }
            intValue = 0;
            this.n.put(j15Var.b, intValue >= 0 ? intValue : 0);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.repackage.v15
    public void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            super.r();
        }
    }

    public final void s() {
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
                L(new j15(2, 2, " "));
                L(new j15(2, 16, " "));
            } else {
                if (!StringUtils.isNull(defaultBubble)) {
                    L(new j15(2, 12, " "));
                    L(new j15(2, 2, " "));
                } else {
                    L(new j15(2, 2, null));
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
