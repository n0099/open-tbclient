package com.baidu.tieba;

import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.ala.atomdata.AlaSDKShareEmptyActivityConfig;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.searchbox.live.interfaces.service.tb.ShareChannelService;
import com.baidu.searchbox.live.interfaces.sharechennel.IShareCallback;
import com.baidu.searchbox.live.interfaces.sharechennel.IShareChannel;
import com.baidu.searchbox.live.interfaces.sharechennel.ShareEntity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class bv8 implements ShareChannelService {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes5.dex */
    public class a implements IShareChannel {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ bv8 a;

        public a(bv8 bv8Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {bv8Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = bv8Var;
        }

        @Override // com.baidu.searchbox.live.interfaces.sharechennel.IShareChannel
        public void shareToChannel(ShareEntity shareEntity, int i, IShareCallback iShareCallback) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLIL(1048576, this, shareEntity, i, iShareCallback) == null) {
                if (i == 1) {
                    this.a.c(6, shareEntity, iShareCallback);
                } else if (i == 3) {
                    this.a.c(2, shareEntity, iShareCallback);
                } else if (i == 2) {
                    this.a.c(3, shareEntity, iShareCallback);
                } else if (i == 4) {
                    this.a.c(8, shareEntity, iShareCallback);
                }
            }
        }
    }

    public bv8() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    @Override // com.baidu.searchbox.live.interfaces.service.tb.ShareChannelService
    public IShareChannel buildShareChannel() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            return new a(this);
        }
        return (IShareChannel) invokeV.objValue;
    }

    public final boolean b(int i) {
        InterceptResult invokeI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeI = interceptable.invokeI(1048576, this, i)) == null) {
            if (i != 2 && i != 3) {
                if (i != 6) {
                    if (i != 8) {
                        return false;
                    }
                    boolean b = fz9.b(TbadkCoreApplication.getInst(), "com.tencent.mobileqq");
                    if (!b) {
                        wi.Q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f136b));
                        return b;
                    }
                    return b;
                }
                boolean b2 = fz9.b(TbadkCoreApplication.getInst(), "com.sina.weibo");
                if (!b2) {
                    wi.Q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1389));
                    return b2;
                }
                return b2;
            }
            boolean b3 = fz9.b(TbadkCoreApplication.getInst(), "com.tencent.mm");
            if (!b3) {
                wi.Q(TbadkCoreApplication.getInst(), TbadkCoreApplication.getInst().getResources().getString(R.string.obfuscated_res_0x7f0f1390));
                return b3;
            }
            return b3;
        }
        return invokeI.booleanValue;
    }

    public final void c(int i, ShareEntity shareEntity, IShareCallback iShareCallback) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeILL(Constants.METHOD_SEND_USER_MSG, this, i, shareEntity, iShareCallback) != null) || shareEntity == null) {
            return;
        }
        if (!b(i)) {
            if (iShareCallback != null) {
                iShareCallback.onShare(0, 0, "");
                return;
            }
            return;
        }
        ShareItem d = d(shareEntity);
        if (d == null) {
            return;
        }
        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaSDKShareEmptyActivityConfig(TbadkCoreApplication.getInst(), d, i, 2)));
    }

    public final ShareItem d(ShareEntity shareEntity) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, shareEntity)) == null) {
            if (shareEntity != null) {
                ShareItem shareItem = new ShareItem();
                shareItem.v = shareEntity.title;
                shareItem.w = shareEntity.content;
                shareItem.A = shareEntity.imageUrl;
                shareItem.x = shareEntity.linkUrl;
                shareItem.u = String.valueOf(shareEntity.liveId);
                shareItem.A0 = String.valueOf(shareEntity.userId);
                return shareItem;
            }
            return null;
        }
        return (ShareItem) invokeL.objValue;
    }
}
