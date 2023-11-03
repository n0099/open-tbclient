package com.baidu.tieba.forumSquare.model;

import android.content.Context;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ErrorData;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.data.ForumSquareHttpResponsedMessage;
import com.baidu.tieba.forumSquare.ForumSquareStatic;
import com.baidu.tieba.forumSquare.message.ForumSquareRequestMessage;
import com.baidu.tieba.go7;
import com.baidu.tieba.gx6;
import com.baidu.tieba.jo7;
import com.baidu.tieba.ko7;
import com.baidu.tieba.oi;
import com.baidu.tieba.tbadkCore.writeModel.AttentionBarData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.chromium.net.NetError;
/* loaded from: classes6.dex */
public class ForumSquareModel extends BdBaseModel {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public go7 a;
    public boolean b;
    public final HashMap<String, ko7> c;
    public final List<String> d;
    public boolean e;
    public CustomMessageListener f;
    public CustomMessageListener g;
    public NetMessageListener h;

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AttentionBarData)) {
                AttentionBarData attentionBarData = (AttentionBarData) customResponsedMessage.getData();
                if (attentionBarData.isSuccess) {
                    this.a.k0(attentionBarData.forumId, true);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
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
            if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && customResponsedMessage != null && (customResponsedMessage.getData() instanceof AttentionBarData)) {
                AttentionBarData attentionBarData = (AttentionBarData) customResponsedMessage.getData();
                if (attentionBarData.isSuccess) {
                    this.a.k0(attentionBarData.forumId, false);
                }
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c extends NetMessageListener {
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

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            String str;
            gx6 gx6Var;
            Interceptable interceptable = $ic;
            if (interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) {
                return;
            }
            this.a.b = false;
            if (responsedMessage == null) {
                return;
            }
            this.a.mErrorCode = responsedMessage.getError();
            if (responsedMessage.hasError()) {
                if (!this.a.e && responsedMessage.getError() == -100000303 && (responsedMessage.getOrginalMessage().getExtra() instanceof ForumSquareRequestMessage)) {
                    this.a.sendMessage((ForumSquareRequestMessage) responsedMessage.getOrginalMessage().getExtra());
                    this.a.e = true;
                    return;
                }
                return;
            }
            this.a.mErrorString = responsedMessage.getErrorString();
            if (StringUtils.isNull(this.a.mErrorString)) {
                str = TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f0e61);
            } else {
                str = this.a.mErrorString;
            }
            ErrorData errorData = new ErrorData();
            errorData.setError_code(this.a.mErrorCode);
            errorData.setError_msg(str);
            String str2 = null;
            if (responsedMessage instanceof ForumSquareHttpResponsedMessage) {
                gx6Var = ((ForumSquareHttpResponsedMessage) responsedMessage).getData();
            } else {
                gx6Var = null;
            }
            Object extra = responsedMessage.getOrginalMessage().getExtra();
            if (extra instanceof ForumSquareRequestMessage) {
                str2 = ((ForumSquareRequestMessage) extra).className;
            }
            this.a.h0(gx6Var);
            if (ListUtils.isEmpty(this.a.d)) {
                if (this.a.a != null) {
                    this.a.a.onNoData(errorData);
                }
            } else if (this.a.mErrorCode != 0 || gx6Var == null) {
                if (this.a.a != null) {
                    this.a.a.onError(str2, errorData);
                }
            } else {
                this.a.i0(gx6Var);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ForumSquareModel(Context context, go7 go7Var) {
        super(UtilHelper.getTbPageContext(context));
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, go7Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                super((BdPageContext) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = false;
        this.c = new HashMap<>();
        this.d = new ArrayList();
        this.f = new a(this, 2001437);
        this.g = new b(this, 2001438);
        this.h = new c(this, CmdConfigHttp.CMD_FORUM_SQUARE, 309653);
        new ForumSquareStatic();
        this.a = go7Var;
        this.h.getHttpMessageListener().setSelfListener(true);
        this.h.getSocketMessageListener().setSelfListener(true);
        registerListener(this.h);
        registerListener(this.f);
        registerListener(this.g);
    }

    public boolean c0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            return this.d.contains(str);
        }
        return invokeL.booleanValue;
    }

    public ko7 d0(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048580, this, str)) == null) {
            if (str == null) {
                return null;
            }
            return this.c.get(str);
        }
        return (ko7) invokeL.objValue;
    }

    public boolean e0(String str) {
        InterceptResult invokeL;
        ko7 ko7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048581, this, str)) == null) {
            if (TextUtils.isEmpty(str) || (ko7Var = this.c.get(str)) == null) {
                return false;
            }
            return ko7Var.d;
        }
        return invokeL.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            cancelMessage();
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
            super.cancelMessage();
            this.b = false;
        }
    }

    public void clearData() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            this.d.clear();
        }
    }

    public boolean f0() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.b;
        }
        return invokeV.booleanValue;
    }

    public void g0(String str) {
        ko7 ko7Var;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048583, this, str) == null) {
            ForumSquareRequestMessage forumSquareRequestMessage = new ForumSquareRequestMessage();
            forumSquareRequestMessage.className = str;
            if (TextUtils.isEmpty(str)) {
                ko7Var = new ko7();
            } else {
                ko7 ko7Var2 = this.c.get(str);
                if (ko7Var2 == null) {
                    ko7Var2 = new ko7();
                    this.c.put(str, ko7Var2);
                }
                ko7Var = ko7Var2;
            }
            forumSquareRequestMessage.pn = ko7Var.e + 1;
            this.b = true;
            sendMessage(forumSquareRequestMessage);
        }
    }

    public final void h0(gx6 gx6Var) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, gx6Var) == null) && ListUtils.isEmpty(this.d) && gx6Var != null && !ListUtils.isEmpty(gx6Var.b)) {
            for (String str : gx6Var.b) {
                if (!TextUtils.isEmpty(str) && !this.d.contains(str)) {
                    this.d.add(str);
                }
            }
        }
    }

    public final void i0(gx6 gx6Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, gx6Var) == null) {
            String str = gx6Var.d;
            if (TextUtils.isEmpty(str)) {
                str = (String) ListUtils.getItem(this.d, 0);
                gx6Var.d = str;
            }
            ko7 ko7Var = this.c.get(str);
            if (ko7Var == null) {
                ko7Var = new ko7();
                this.c.put(str, ko7Var);
            }
            ko7Var.b(gx6Var);
            go7 go7Var = this.a;
            if (go7Var != null) {
                go7Var.onSucc(str, this.d, ko7Var.a());
            }
        }
    }

    public int j0(List<oi> list, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(1048586, this, list, i)) == null) {
            int count = ListUtils.getCount(list);
            if (count <= i) {
                return 0;
            }
            int max = Math.max(count + NetError.ERR_INVALID_URL, 30);
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

    public final void k0(long j, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048587, this, new Object[]{Long.valueOf(j), Boolean.valueOf(z)}) == null) {
            for (Map.Entry<String, ko7> entry : this.c.entrySet()) {
                ko7 value = entry.getValue();
                if (value != null && !ListUtils.isEmpty(value.a())) {
                    for (oi oiVar : value.a()) {
                        if (oiVar instanceof jo7) {
                            jo7 jo7Var = (jo7) oiVar;
                            if (jo7Var.a == j) {
                                jo7Var.d = z;
                            }
                        }
                    }
                }
            }
        }
    }
}
