package com.baidu.tieba.gift.giftTab;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.BdPageContext;
import com.baidu.adp.framework.listener.NetMessageListener;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.tx4;
import com.baidu.tieba.wva;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class CategoryGiftListModel extends BdBaseModel<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public ArrayList<tx4> a;
    public b b;
    public NetMessageListener c;

    /* loaded from: classes6.dex */
    public interface b {
        void a(int i, String str, int i2, ArrayList<tx4> arrayList);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    /* loaded from: classes6.dex */
    public class a extends NetMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ CategoryGiftListModel a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CategoryGiftListModel categoryGiftListModel, int i, int i2) {
            super(i, i2);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {categoryGiftListModel, Integer.valueOf(i), Integer.valueOf(i2)};
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
            this.a = categoryGiftListModel;
        }

        @Override // com.baidu.adp.framework.listener.NetMessageListener
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, responsedMessage) != null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof CategoryGiftListHttpResponseMessage;
            if (!z && !(responsedMessage instanceof CategoryGiftListSocketResponseMessage)) {
                return;
            }
            int i = 0;
            if (z) {
                CategoryGiftListHttpResponseMessage categoryGiftListHttpResponseMessage = (CategoryGiftListHttpResponseMessage) responsedMessage;
                this.a.a = categoryGiftListHttpResponseMessage.getGiftList();
                i = categoryGiftListHttpResponseMessage.getCategoryId();
            } else if (responsedMessage instanceof CategoryGiftListSocketResponseMessage) {
                CategoryGiftListSocketResponseMessage categoryGiftListSocketResponseMessage = (CategoryGiftListSocketResponseMessage) responsedMessage;
                this.a.a = categoryGiftListSocketResponseMessage.getGiftList();
                i = categoryGiftListSocketResponseMessage.getCategoryId();
            }
            if (this.a.b != null) {
                this.a.b.a(responsedMessage.getError(), responsedMessage.getErrorString(), i, this.a.a);
            }
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryGiftListModel(BdPageContext<GiftTabActivity> bdPageContext) {
        super(bdPageContext);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {bdPageContext};
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
        this.c = new a(this, CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, 309055);
        registerTask();
        registerListener();
    }

    public void R(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048576, this, i) == null) {
            CategoryGiftListRequest categoryGiftListRequest = new CategoryGiftListRequest();
            categoryGiftListRequest.setCategoryId(i);
            sendMessage(categoryGiftListRequest);
        }
    }

    public void S(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, bVar) == null) {
            this.b = bVar;
        }
    }

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            registerListener(this.c);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            wva.h(309055, CategoryGiftListSocketResponseMessage.class, false, false);
            wva.c(309055, CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, TbConfig.GET_GIFT_LIST_BY_CATEGORY, CategoryGiftListHttpResponseMessage.class, false, false, false, false);
        }
    }
}
