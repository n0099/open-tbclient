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
import d.a.r0.w.h;
import d.a.r0.w.i;
import java.util.LinkedList;
/* loaded from: classes4.dex */
public class MoreDeskView extends CommonTabHost {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public LinkedList<h> q;
    public SparseIntArray r;
    public CustomMessageListener s;
    public CustomMessageListener t;

    /* loaded from: classes4.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreDeskView f12982a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(MoreDeskView moreDeskView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreDeskView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12982a = moreDeskView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) || customResponsedMessage == null || customResponsedMessage.getData() == null || !(customResponsedMessage.getData() instanceof Boolean)) {
                return;
            }
            this.f12982a.u();
        }
    }

    /* loaded from: classes4.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ MoreDeskView f12983a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(MoreDeskView moreDeskView, int i2) {
            super(i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {moreDeskView, Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f12983a = moreDeskView;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof Boolean)) {
                this.f12983a.u();
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.r = new SparseIntArray();
        this.s = new a(this, 2001344);
        this.t = new b(this, 2001353);
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.r0.w.n
    public void b() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            super.b();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.r0.w.n
    public void init() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            setShowDelete(false);
            i iVar = new i();
            iVar.E(this.q);
            k(iVar);
            u();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, d.a.r0.w.b
    public void onAction(d.a.r0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, aVar) == null) {
            super.onAction(aVar);
            if (aVar == null || aVar.f56766a != 2 || aVar.f56767b == 5) {
                return;
            }
            t(aVar);
            r();
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public void onAttachedToWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            super.onAttachedToWindow();
            MessageManager.getInstance().registerListener(this.s);
            MessageManager.getInstance().registerListener(this.t);
            u();
        }
    }

    @Override // com.baidu.tbadk.editortools.view.CommonTabHost, android.view.ViewGroup, android.view.View
    public void onDetachedFromWindow() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            super.onDetachedFromWindow();
            MessageManager.getInstance().unRegisterListener(this.s);
            MessageManager.getInstance().unRegisterListener(this.t);
        }
    }

    public void q(LinkedList<h> linkedList) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048581, this, linkedList) == null) {
            this.q = linkedList;
        }
    }

    public final void r() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            int i2 = 0;
            for (int i3 = 0; i3 < this.r.size(); i3++) {
                i2 += this.r.valueAt(i3);
            }
            if (i2 > 0) {
                d(new d.a.r0.w.a(2, 2, " "));
            } else {
                d(new d.a.r0.w.a(2, 2, null));
            }
        }
    }

    public final void s(boolean z) {
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
    public final void t(d.a.r0.w.a aVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, aVar) == null) {
            Integer valueOf = Integer.valueOf(this.r.get(aVar.f56767b));
            int intValue = valueOf != null ? valueOf.intValue() : 0;
            Object obj = aVar.f56768c;
            if (obj != null) {
                if (obj instanceof String) {
                    String str = (String) obj;
                    if (!TextUtils.isEmpty(str)) {
                        intValue = TextUtils.isEmpty(str.trim()) ? 1 : d.a.c.e.m.b.d(str, 1);
                    }
                }
                this.r.put(aVar.f56767b, intValue >= 0 ? intValue : 0);
            }
            intValue = 0;
            this.r.put(aVar.f56767b, intValue >= 0 ? intValue : 0);
        }
    }

    public final void u() {
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
                d(new d.a.r0.w.a(2, 2, " "));
                d(new d.a.r0.w.a(2, 16, " "));
            } else {
                if (!StringUtils.isNull(defaultBubble)) {
                    d(new d.a.r0.w.a(2, 12, " "));
                    d(new d.a.r0.w.a(2, 2, " "));
                } else {
                    d(new d.a.r0.w.a(2, 2, null));
                }
                z = false;
            }
            s(z);
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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Context) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.r = new SparseIntArray();
        this.s = new a(this, 2001344);
        this.t = new b(this, 2001353);
        setBackgroundColorId(R.color.CAM_X0206);
        setToolId(2);
    }
}
