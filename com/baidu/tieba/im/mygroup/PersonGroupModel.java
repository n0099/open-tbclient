package com.baidu.tieba.im.mygroup;

import c.a.d.a.f;
import c.a.d.f.p.n;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tieba.im.message.GroupsByUidLocalMessage;
import com.baidu.tieba.im.message.GroupsByUidMessage;
import com.baidu.tieba.im.message.RequestUserPermissionMessage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes12.dex */
public class PersonGroupModel extends BdBaseModel<BaseFragmentActivity> {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* renamed from: e  reason: collision with root package name */
    public RequestUserPermissionMessage f45082e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f45083f;
    public long friendUid;
    public int mImageHeight;
    public int mImageWidth;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonGroupModel(PersonGroupActivity personGroupActivity) {
        super(personGroupActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personGroupActivity};
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
        this.f45083f = false;
        this.mImageWidth = n.d(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = n.d(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = 0L;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
            super.cancelMessage();
            this.f45082e = null;
        }
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean loadData() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public void update() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048579, this) == null) {
            if (this.friendUid == 0) {
                if (this.f45083f) {
                    super.sendMessage(new GroupsByUidMessage(this.mImageWidth, this.mImageHeight));
                    return;
                }
                this.f45083f = true;
                super.sendMessage(new GroupsByUidLocalMessage());
                return;
            }
            super.sendMessage(new GroupsByUidMessage(this.friendUid, this.mImageWidth, this.mImageHeight));
        }
    }

    public final RequestUserPermissionMessage w(long j2) {
        InterceptResult invokeJ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeJ = interceptable.invokeJ(1048580, this, j2)) == null) {
            RequestUserPermissionMessage requestUserPermissionMessage = new RequestUserPermissionMessage();
            requestUserPermissionMessage.setForumId(j2);
            return requestUserPermissionMessage;
        }
        return (RequestUserPermissionMessage) invokeJ.objValue;
    }

    public void x(long j2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048581, this, j2) == null) {
            RequestUserPermissionMessage w = w(j2);
            this.f45082e = w;
            super.sendMessage(w);
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public PersonGroupModel(PersonGroupActivity personGroupActivity, long j2) {
        super(personGroupActivity.getPageContext());
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {personGroupActivity, Long.valueOf(j2)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((f) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.f45083f = false;
        this.mImageWidth = n.d(TbadkApplication.getInst().getContext(), 70.0f);
        this.mImageHeight = n.d(TbadkApplication.getInst().getContext(), 70.0f);
        this.friendUid = j2;
    }
}
