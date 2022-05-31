package com.baidu.tieba.forumSquare.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sofire.mutiprocess.SubProcessManager;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.enterForum.data.ForumSquareSocketResponsedMessage;
import com.baidu.tieba.forumSquare.ForumSquareStatic;
import com.baidu.tieba.forumSquare.message.ForumSquareRequestMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.aj8;
import com.repackage.b9;
import com.repackage.ba6;
import com.repackage.ca6;
import com.repackage.i36;
import com.repackage.jn;
import com.repackage.wa;
import com.repackage.y96;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes3.dex */
public class ForumSquareModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public y96 a;
    public boolean b;
    public final HashMap<String, ca6> c;
    public final List<String> d;
    public CustomMessageListener e;
    public CustomMessageListener f;
    public wa g;

    /* loaded from: classes3.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumSquareModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ForumSquareModel forumSquareModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareModel, Integer.valueOf(i)};
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
            this.a = forumSquareModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof aj8)) {
                aj8 aj8Var = (aj8) customResponsedMessage.getData();
                if (aj8Var.b) {
                    this.a.S(aj8Var.a, true);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class b extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumSquareModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(ForumSquareModel forumSquareModel, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareModel, Integer.valueOf(i)};
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
            this.a = forumSquareModel;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof aj8)) {
                aj8 aj8Var = (aj8) customResponsedMessage.getData();
                if (aj8Var.b) {
                    this.a.S(aj8Var.a, false);
                }
            }
        }
    }

    /* loaded from: classes3.dex */
    public class c extends wa {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ForumSquareModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(ForumSquareModel forumSquareModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {forumSquareModel, Integer.valueOf(i), Integer.valueOf(i2)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i3 = newInitContext.flag;
                if ((i3 & 1) != 0) {
                    int i4 = i3 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = forumSquareModel;
        }

        @Override // com.repackage.wa
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            i36 data;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) {
                this.a.b = false;
                if (responsedMessage == null) {
                    return;
                }
                this.a.mErrorCode = responsedMessage.getError();
                this.a.mErrorString = responsedMessage.getErrorString();
                if (!StringUtils.isNull(this.a.mErrorString)) {
                    str = this.a.mErrorString;
                } else {
                    str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0c33);
                }
                ErrorData errorData = new ErrorData();
                errorData.setError_code(this.a.mErrorCode);
                errorData.setError_msg(str);
                if (responsedMessage instanceof ForumSquareHttpResponsedMessage) {
                    data = ((ForumSquareHttpResponsedMessage) responsedMessage).getData();
                } else {
                    data = responsedMessage instanceof ForumSquareSocketResponsedMessage ? ((ForumSquareSocketResponsedMessage) responsedMessage).getData() : null;
                }
                Object extra = responsedMessage.getOrginalMessage().getExtra();
                String str2 = extra instanceof ForumSquareRequestMessage ? ((ForumSquareRequestMessage) extra).className : null;
                this.a.P(data);
                if (ListUtils.isEmpty(this.a.d)) {
                    if (this.a.a != null) {
                        this.a.a.onNoData(errorData);
                    }
                } else if (this.a.mErrorCode != 0 || data == null) {
                    if (this.a.a != null) {
                        this.a.a.onError(str2, errorData);
                    }
                } else {
                    this.a.Q(data);
                }
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumSquareModel(Context context, y96 y96Var) {
        super(UtilHelper.getTbPageContext(context));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, y96Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((b9) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = new HashMap<>();
        this.d = new ArrayList();
        this.e = new a(this, 2001437);
        this.f = new b(this, 2001438);
        this.g = new c(this, CmdConfigHttp.CMD_FORUM_SQUARE, 309653);
        new ForumSquareStatic();
        this.a = y96Var;
        this.g.getHttpMessageListener().setSelfListener(true);
        this.g.getSocketMessageListener().setSelfListener(true);
        registerListener(this.g);
        registerListener(this.e);
        registerListener(this.f);
    }

    public boolean K(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) ? this.d.contains(str) : invokeL.booleanValue;
    }

    public ca6 L(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return this.c.get(str);
        }
        return (ca6) invokeL.objValue;
    }

    public boolean M(String str) {
        InterceptResult invokeL;
        ca6 ca6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (ca6Var = this.c.get(str)) == null) {
                return false;
            }
            return ca6Var.d;
        }
        return invokeL.booleanValue;
    }

    public boolean N() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) ? this.b : invokeV.booleanValue;
    }

    public void O(String str) {
        ca6 ca6Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048580, this, str) == null) {
            ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
            forumSquareRequestMessage.className = str;
            if (TextUtils.isEmpty(str)) {
                ca6Var = new ca6();
            } else {
                ca6 ca6Var2 = this.c.get(str);
                if (ca6Var2 == null) {
                    ca6Var2 = new ca6();
                    this.c.put(str, ca6Var2);
                }
                ca6Var = ca6Var2;
            }
            forumSquareRequestMessage.pn = ca6Var.e + 1;
            this.b = true;
            sendMessage(forumSquareRequestMessage);
        }
    }

    public final void P(i36 i36Var) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeL(1048581, this, i36Var) == null) || !ListUtils.isEmpty(this.d) || i36Var == null || ListUtils.isEmpty(i36Var.b)) {
            return;
        }
        for (String str : i36Var.b) {
            if (!TextUtils.isEmpty(str) && !this.d.contains(str)) {
                this.d.add(str);
            }
        }
    }

    public final void Q(i36 i36Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, i36Var) == null) {
            String str = i36Var.d;
            if (TextUtils.isEmpty(str)) {
                str = (String) ListUtils.getItem(this.d, 0);
                i36Var.d = str;
            }
            ca6 ca6Var = this.c.get(str);
            if (ca6Var == null) {
                ca6Var = new ca6();
                this.c.put(str, ca6Var);
            }
            ca6Var.b(i36Var);
            y96 y96Var = this.a;
            if (y96Var != null) {
                y96Var.onSucc(str, this.d, ca6Var.a());
            }
        }
    }

    public int R(List<jn> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048583, this, list, i)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= i) {
                return 0;
            }
            int max = Math.max(count + SubProcessManager.PROVIDER_ERROR_UNSUPPORT_OPERATION, 30);
            int i2 = (count - max) / 2;
            int i3 = i2 + max;
            if (i2 <= 20 || i3 >= count - 20) {
                return 0;
            }
            ListUtils.removeSubList(list, i2, i3);
            return max;
        }
        return invokeLI.intValue;
    }

    public final void S(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            for (Map.Entry<String, ca6> entry : this.c.entrySet()) {
                ca6 value = entry.getValue();
                if (value != null && !ListUtils.isEmpty(value.a())) {
                    for (jn jnVar : value.a()) {
                        if (jnVar instanceof ba6) {
                            ba6 ba6Var = (ba6) jnVar;
                            if (ba6Var.a == j) {
                                ba6Var.d = z;
                            }
                        }
                    }
                }
            }
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048586, this) == null) {
            super.cancelMessage();
            this.b = false;
        }
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048587, this) == null) {
            this.d.clear();
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }
}
