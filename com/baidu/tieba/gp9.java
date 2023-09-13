package com.baidu.tieba;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.PbPostShareDialogConfig;
import com.baidu.tbadk.core.data.MediaData;
import com.baidu.tbadk.core.data.ThreadData;
import com.baidu.tbadk.core.util.StatisticItem;
import com.baidu.tbadk.core.util.TbadkCoreStatisticKey;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.coreExtra.share.ShareItem;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes6.dex */
public class gp9 {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public b b;

    /* loaded from: classes6.dex */
    public interface b {
        void a(aj9 aj9Var, ThreadData threadData, tha thaVar, z16 z16Var);
    }

    /* loaded from: classes6.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ gp9 a;

        public a(gp9 gp9Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {gp9Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = gp9Var;
        }

        @Override // com.baidu.tieba.gp9.b
        public void a(aj9 aj9Var, ThreadData threadData, tha thaVar, z16 z16Var) {
            String e;
            String tid;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, aj9Var, threadData, thaVar, z16Var) == null) {
                if ((aj9Var != null || threadData != null) && thaVar != null && this.a.a != null) {
                    if (aj9Var != null) {
                        String str2 = aj9Var.M(false)[0];
                        if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                            str2 = str2.substring(37);
                        }
                        ThreadData O = aj9Var.O();
                        if (O == null) {
                            return;
                        }
                        String str3 = str2;
                        threadData = O;
                        e = str3;
                    } else {
                        e = this.a.e(threadData);
                    }
                    nj9 nj9Var = new nj9();
                    nj9Var.h(threadData.getAbstract());
                    if (!StringUtils.isNull(e)) {
                        nj9Var.k(e);
                    }
                    nj9Var.l(threadData.getThreadType());
                    nj9Var.g(z16Var);
                    nj9Var.i(thaVar);
                    String title = threadData.getTitle();
                    if (StringUtils.isNull(title)) {
                        title = threadData.getAbstract();
                    }
                    nj9Var.h(title);
                    if (threadData.isUgcThreadType()) {
                        tid = threadData.getBaijiahaoData().oriUgcTid;
                        str = "?share=9105&fr=dshare&dtype=" + threadData.getBaijiahaoData().oriUgcType + "&dvid=" + threadData.getBaijiahaoData().oriUgcVid + "&nid=" + threadData.getBaijiahaoData().oriUgcNid;
                    } else {
                        tid = threadData.getTid();
                        str = "?share=9105&fr=share";
                    }
                    nj9Var.j(this.a.d(TbConfig.HTTPS_PB_PREFIX + tid + (str + "&post_id=" + thaVar.U() + "&share_from=comment&post_sort=1")));
                    ShareItem shareItem = new ShareItem();
                    shareItem.shareType = 1;
                    shareItem.isFromCommentShare = true;
                    shareItem.extData = tid;
                    shareItem.pid = thaVar.U();
                    Bundle bundle = new Bundle();
                    bundle.putString("tid", tid);
                    bundle.putString("pid", thaVar.U());
                    bundle.putInt("source", 1);
                    shareItem.setStats(bundle);
                    PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(this.a.a.getPageActivity(), shareItem, true, nj9Var);
                    pbPostShareDialogConfig.setIsCopyLink(false);
                    pbPostShareDialogConfig.setHideMode(pbPostShareDialogConfig.hideMode | 32);
                    this.a.a.sendMessage(new CustomMessage(2001276, pbPostShareDialogConfig));
                    StatisticItem statisticItem = new StatisticItem(TbadkCoreStatisticKey.KEY_SHARE_CLICK);
                    statisticItem.param("tid", tid);
                    statisticItem.param("uid", TbadkCoreApplication.getCurrentAccount());
                    if (threadData.getForumData() != null) {
                        statisticItem.param("fid", threadData.getForumData().a);
                    }
                    if (threadData.getTopAgreePost() != null) {
                        statisticItem.param("post_id", thaVar.U());
                    }
                    statisticItem.param("obj_locate", 21);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    public gp9(TbPageContext tbPageContext) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {tbPageContext};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.b = new a(this);
        this.a = tbPageContext;
    }

    public final Bitmap d(String str) {
        InterceptResult invokeL;
        CustomResponsedMessage runTask;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            if (str == null || str.length() == 0 || (runTask = MessageManager.getInstance().runTask(2921388, Bitmap.class, str)) == null || runTask.getData() == null) {
                return null;
            }
            return (Bitmap) runTask.getData();
        }
        return (Bitmap) invokeL.objValue;
    }

    public final String e(ThreadData threadData) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, threadData)) == null) {
            String str = null;
            if (threadData == null) {
                return null;
            }
            if (threadData.getThreadAlaInfo() != null && !TextUtils.isEmpty(threadData.getThreadAlaInfo().cover)) {
                return threadData.getThreadAlaInfo().cover;
            }
            if (threadData.getMedias() == null) {
                return null;
            }
            ArrayList<MediaData> medias = threadData.getMedias();
            int size = medias.size();
            int i = 0;
            while (true) {
                if (i >= size) {
                    break;
                }
                MediaData mediaData = medias.get(i);
                if (mediaData != null && (mediaData.getType() == 3 || mediaData.getType() == 5)) {
                    if (!StringUtils.isNull(mediaData.getThumbnails_url())) {
                        str = mediaData.getThumbnails_url();
                        break;
                    } else if (!StringUtils.isNull(mediaData.getPicUrl())) {
                        str = mediaData.getPicUrl();
                        break;
                    }
                }
                i++;
            }
            if (str == null && threadData.getThreadVideoInfo() != null && !TextUtils.isEmpty(threadData.getThreadVideoInfo().thumbnail_url)) {
                return threadData.getThreadVideoInfo().thumbnail_url;
            }
            return str;
        }
        return (String) invokeL.objValue;
    }
}
