package com.baidu.tieba;

import android.content.Context;
import android.os.Bundle;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.tieba.sharesdk.ShareHandlerActivity;
import com.baidu.tieba.sharesdk.bean.ShareEntity;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
/* loaded from: classes5.dex */
public class boa implements hb5 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public Context a;

    public boa(Context context, gb5 gb5Var) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, gb5Var};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = null;
        this.a = context;
    }

    @Override // com.baidu.tieba.hb5
    public void a(ShareItem shareItem, int i, boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048576, this, new Object[]{shareItem, Integer.valueOf(i), Boolean.valueOf(z)}) == null) {
            b(shareItem, i);
        }
    }

    public final void b(ShareItem shareItem, int i) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeLI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, shareItem, i) == null) && this.a != null && shareItem != null) {
            IntentConfig intentConfig = new IntentConfig(this.a);
            ShareEntity shareEntity = new ShareEntity();
            shareEntity.setTitle(shareItem.title);
            shareEntity.setContent(shareItem.content);
            shareEntity.setReadCount(shareItem.readCount);
            int i2 = shareItem.obj_type;
            if (i2 != 2 && i2 != 6 && i2 != 8) {
                z = false;
            } else {
                z = true;
            }
            shareEntity.setIsVideoThread(z);
            shareEntity.setFestivalTaskTid(shareItem.festivalTaskTid);
            shareEntity.setFestivalTaskType(shareItem.festivalTaskType);
            shareEntity.setImageUri(shareItem.imageUri);
            shareEntity.canShareBySmartApp = shareItem.canShareBySmartApp;
            String str = shareItem.linkUrl;
            if (i == 6 && !StringUtils.isNull(shareItem.spareLinkUrl)) {
                str = shareItem.spareLinkUrl;
            }
            shareEntity.setLinkUrl(str);
            shareEntity.setLocalFile(shareItem.localFile);
            shareEntity.setLocation(shareItem.location);
            shareEntity.setShareTo(i);
            shareEntity.setStats(shareItem.getStats());
            shareEntity.setPreferImageToLink(shareItem.shareType);
            shareEntity.setTid(shareItem.tid);
            shareEntity.setFloorAuthorUid(shareItem.floorAuthorUid);
            shareEntity.setfName(shareItem.fName);
            shareEntity.setTypeShareToSmallApp(shareItem.typeShareToSmallApp);
            shareEntity.topic = shareItem.topic;
            if (i == 6 && !StringUtils.isNull(shareItem.wbcontent)) {
                shareEntity.topic = shareItem.wbtitle + shareItem.wbcontent;
                shareEntity.setContent("");
            }
            shareEntity.taskCompleteId = shareItem.taskCompleteId;
            shareEntity.diskPicOperate = shareItem.diskPicOperate;
            shareEntity.setExtLiveInfo(shareItem.extLiveInfo);
            shareEntity.setFromDuXiaoMan(shareItem.isFromDuXiaoMan);
            shareEntity.setTopicId(shareItem.topicId);
            shareEntity.groupData = shareItem.groupData;
            shareEntity.shareMediaType = shareItem.shareMediaType;
            Bundle bundle = new Bundle();
            bundle.putParcelable("extra_share_data", shareEntity);
            bundle.putInt("extra_skin", TbadkCoreApplication.getInst().getSkinType());
            intentConfig.getIntent().putExtras(bundle);
            shareItem.setShowShare(true);
            intentConfig.startActivityForResult(24007, ShareHandlerActivity.class);
        }
    }
}
