package com.baidu.tieba.gift.giftTab;

import c.a.e.a.f;
import c.a.o0.s.q.j0;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes7.dex */
public class CategoryGiftListModel extends BdBaseModel<GiftTabActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public ArrayList<j0> f51604e;

    /* renamed from: f  reason: collision with root package name */
    public b f51605f;

    /* renamed from: g  reason: collision with root package name */
    public c.a.e.c.g.a f51606g;

    /* loaded from: classes7.dex */
    public class a extends c.a.e.c.g.a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ CategoryGiftListModel f51607a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(CategoryGiftListModel categoryGiftListModel, int i2, int i3) {
            super(i2, i3);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {categoryGiftListModel, Integer.valueOf(i2), Integer.valueOf(i3)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i4 = newInitContext.flag;
                if ((i4 & 1) != 0) {
                    int i5 = i4 & 2;
                    Object[] objArr2 = newInitContext.callArgs;
                    super(((Integer) objArr2[0]).intValue(), ((Integer) objArr2[1]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.f51607a = categoryGiftListModel;
        }

        @Override // c.a.e.c.g.a
        public void onMessage(ResponsedMessage<?> responsedMessage) {
            Interceptable interceptable = $ic;
            if (!(interceptable == null || interceptable.invokeL(1048576, this, responsedMessage) == null) || responsedMessage == null) {
                return;
            }
            boolean z = responsedMessage instanceof CategoryGiftListHttpResponseMessage;
            if (z || (responsedMessage instanceof CategoryGiftListSocketResponseMessage)) {
                int i2 = 0;
                if (z) {
                    CategoryGiftListHttpResponseMessage categoryGiftListHttpResponseMessage = (CategoryGiftListHttpResponseMessage) responsedMessage;
                    this.f51607a.f51604e = categoryGiftListHttpResponseMessage.getGiftList();
                    i2 = categoryGiftListHttpResponseMessage.getCategoryId();
                } else if (responsedMessage instanceof CategoryGiftListSocketResponseMessage) {
                    CategoryGiftListSocketResponseMessage categoryGiftListSocketResponseMessage = (CategoryGiftListSocketResponseMessage) responsedMessage;
                    this.f51607a.f51604e = categoryGiftListSocketResponseMessage.getGiftList();
                    i2 = categoryGiftListSocketResponseMessage.getCategoryId();
                }
                if (this.f51607a.f51605f != null) {
                    this.f51607a.f51605f.a(responsedMessage.getError(), responsedMessage.getErrorString(), i2, this.f51607a.f51604e);
                }
            }
        }
    }

    /* loaded from: classes7.dex */
    public interface b {
        void a(int i2, String str, int i3, ArrayList<j0> arrayList);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CategoryGiftListModel(f<GiftTabActivity> fVar) {
        super(fVar);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {fVar};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.f51606g = new a(this, CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, 309055);
        registerTask();
        registerListener();
    }

    public void A(b bVar) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, bVar) == null) {
            this.f51605f = bVar;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
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

    public final void registerListener() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            registerListener(this.f51606g);
        }
    }

    public final void registerTask() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            c.a.p0.i3.d0.a.h(309055, CategoryGiftListSocketResponseMessage.class, false, false);
            c.a.p0.i3.d0.a.c(309055, CmdConfigHttp.CMD_GIFT_LIST_BY_CATEGORY, TbConfig.GET_GIFT_LIST_BY_CATEGORY, CategoryGiftListHttpResponseMessage.class, false, false, false, false);
        }
    }

    public void z(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            CategoryGiftListRequest categoryGiftListRequest = new CategoryGiftListRequest();
            categoryGiftListRequest.setCategoryId(i2);
            sendMessage(categoryGiftListRequest);
        }
    }
}
