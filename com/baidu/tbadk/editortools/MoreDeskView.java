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
import com.baidu.tbadk.core.util.CommonStatisticKey;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.editortools.view.CommonTabHost;
import com.baidu.tieba.R;
import com.baidu.tieba.ci5;
import com.baidu.tieba.di5;
import com.baidu.tieba.tg;
import com.baidu.tieba.uh5;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Iterator;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class MoreDeskView extends CommonTabHost {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<ci5> m;
    public SparseIntArray n;
    public CustomMessageListener o;
    public CustomMessageListener p;

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.s();
        }
    }

    /* loaded from: classes4.dex */
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
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.a.s();
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

    /* JADX WARN: Removed duplicated region for block: B:22:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public final void r(uh5 uh5Var) {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, uh5Var) == null) {
            Integer valueOf = Integer.valueOf(this.n.get(uh5Var.b));
            int i2 = 0;
            if (valueOf != null) {
                i = valueOf.intValue();
            } else {
                i = 0;
            }
            Object obj = uh5Var.c;
            if (obj != null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        if (TextUtils.isEmpty(str.trim())) {
                            i = 1;
                        } else {
                            i = tg.e(str, 1);
                        }
                    }
                }
                if (i >= 0) {
                    i2 = i;
                }
                this.n.put(uh5Var.b, i2);
            }
            i = 0;
            if (i >= 0) {
            }
            this.n.put(uh5Var.b, i2);
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

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tieba.vh5
    public void C(uh5 uh5Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, uh5Var) == null) {
            super.C(uh5Var);
            if (uh5Var != null && uh5Var.a == 2 && uh5Var.b != 5) {
                r(uh5Var);
                o();
            }
        }
    }

    public void n(LinkedList<ci5> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048579, this, linkedList) == null) {
            this.m = linkedList;
        }
    }

    public final void q(boolean z) {
        AccountData currentAccountObj;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeZ(InputDeviceCompat.SOURCE_TOUCHPAD, this, z) == null) && (currentAccountObj = TbadkCoreApplication.getCurrentAccountObj()) != null) {
            currentAccountObj.setIsSelectTail(z);
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tieba.hi5
    public void display() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            p();
            super.display();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, com.baidu.tieba.hi5
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            setShowDelete(false);
            di5 di5Var = new di5();
            di5Var.B(this.m);
            h(di5Var);
            s();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.o);
            MessageManager.getInstance().registerListener(this.p);
            s();
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

    public final void o() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            int i = 0;
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                i += this.n.valueAt(i2);
            }
            if (i > 0) {
                H(new uh5(2, 2, " "));
            } else {
                H(new uh5(2, 2, null));
            }
        }
    }

    public void p() {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeV(1048583, this) != null) || ListUtils.isEmpty(this.m)) {
            return;
        }
        Iterator<ci5> it = this.m.iterator();
        while (it.hasNext()) {
            ci5 next = it.next();
            if (next != null) {
                if (next.getToolId() == 12) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.BUBBLE_TOOL_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
                } else if (next.getToolId() == 16) {
                    TiebaStatic.log(new StatisticItem(CommonStatisticKey.TAIL_TOOL_SHOW).param("uid", TbadkCoreApplication.getCurrentAccount()));
                }
            }
        }
    }

    public final void s() {
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            AccountData currentAccountObj = TbadkCoreApplication.getCurrentAccountObj();
            String defaultBubble = TbadkCoreApplication.getInst().getDefaultBubble();
            if (currentAccountObj == null) {
                return;
            }
            if (currentAccountObj.getIsSelectTail()) {
                z = true;
                H(new uh5(2, 2, " "));
                H(new uh5(2, 16, " "));
            } else {
                if (!StringUtils.isNull(defaultBubble)) {
                    H(new uh5(2, 12, " "));
                    H(new uh5(2, 2, " "));
                } else {
                    H(new uh5(2, 2, null));
                }
                z = false;
            }
            q(z);
        }
    }
}
