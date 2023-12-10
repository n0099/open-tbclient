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
import com.baidu.tieba.pb.data.PbPostShareData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.ArrayList;
/* loaded from: classes5.dex */
public class c3a {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public TbPageContext a;
    public b b;

    /* loaded from: classes5.dex */
    public interface b {
        void a(aw9 aw9Var, ThreadData threadData, nwa nwaVar, py5 py5Var);
    }

    /* loaded from: classes5.dex */
    public class a implements b {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ c3a a;

        public a(c3a c3aVar) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {c3aVar};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = c3aVar;
        }

        @Override // com.baidu.tieba.c3a.b
        public void a(aw9 aw9Var, ThreadData threadData, nwa nwaVar, py5 py5Var) {
            String e;
            String tid;
            String str;
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeLLLL(1048576, this, aw9Var, threadData, nwaVar, py5Var) == null) {
                if ((aw9Var != null || threadData != null) && nwaVar != null && this.a.a != null) {
                    if (aw9Var != null) {
                        String str2 = aw9Var.P(false)[0];
                        if (!StringUtils.isNull(str2) && str2.startsWith(TbConfig.URL_IMAGE_PREFIX)) {
                            str2 = str2.substring(37);
                        }
                        ThreadData R = aw9Var.R();
                        if (R == null) {
                            return;
                        }
                        String str3 = str2;
                        threadData = R;
                        e = str3;
                    } else {
                        e = this.a.e(threadData);
                    }
                    PbPostShareData pbPostShareData = new PbPostShareData();
                    pbPostShareData.k(threadData.getAbstract());
                    if (!StringUtils.isNull(e)) {
                        pbPostShareData.o(e);
                    }
                    pbPostShareData.p(threadData.getThreadType());
                    pbPostShareData.j(py5Var);
                    pbPostShareData.l(nwaVar);
                    String title = threadData.getTitle();
                    if (StringUtils.isNull(title)) {
                        title = threadData.getAbstract();
                    }
                    pbPostShareData.k(title);
                    if (threadData.isUgcThreadType()) {
                        tid = threadData.getBaijiahaoData().oriUgcTid;
                        str = "?share=9105&fr=dshare&dtype=" + threadData.getBaijiahaoData().oriUgcType + "&dvid=" + threadData.getBaijiahaoData().oriUgcVid + "&nid=" + threadData.getBaijiahaoData().oriUgcNid;
                    } else {
                        tid = threadData.getTid();
                        str = "?share=9105&fr=share";
                    }
                    pbPostShareData.m(this.a.d(TbConfig.HTTPS_PB_PREFIX + tid + (str + "&post_id=" + nwaVar.U() + "&share_from=comment&post_sort=1")));
                    ShareItem shareItem = new ShareItem();
                    shareItem.shareType = 1;
                    shareItem.isFromCommentShare = true;
                    shareItem.extData = tid;
                    shareItem.pid = nwaVar.U();
                    Bundle bundle = new Bundle();
                    bundle.putString("tid", tid);
                    bundle.putString("pid", nwaVar.U());
                    bundle.putInt("source", 1);
                    shareItem.setStats(bundle);
                    PbPostShareDialogConfig pbPostShareDialogConfig = new PbPostShareDialogConfig(this.a.a.getPageActivity(), shareItem, 0, true, pbPostShareData);
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
                        statisticItem.param("post_id", nwaVar.U());
                    }
                    statisticItem.param("obj_locate", 21);
                    TiebaStatic.log(statisticItem);
                }
            }
        }
    }

    public c3a(TbPageContext tbPageContext) {
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
