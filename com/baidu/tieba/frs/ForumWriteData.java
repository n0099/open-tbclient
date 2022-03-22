package com.baidu.tieba.frs;

import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tbadk.core.data.AntiData;
import com.baidu.tbadk.core.data.PostPrefixData;
import com.baidu.tbadk.core.data.PostTopicData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
/* loaded from: classes5.dex */
public class ForumWriteData implements Serializable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    public final AntiData antiData;
    public String avatar;
    public int categoryId;
    public int defaultZone;
    public String firstDir;
    public final String forumId;
    public int forumLevel;
    public final String forumName;
    public FrsTabInfoData frsTabInfo;
    public String mFrom;
    public int mem_type;
    public final PostPrefixData prefixData;
    public int privateThread;
    public String secondDir;
    public String specialForumType;
    public int statisticFrom;
    public PostTopicData topicData;
    public String writeCallFrom;

    public ForumWriteData(String str, String str2, PostPrefixData postPrefixData, AntiData antiData) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {str, str2, postPrefixData, antiData};
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.categoryId = -1;
        this.forumLevel = -1;
        this.defaultZone = -1;
        this.forumId = str;
        this.forumName = str2;
        this.prefixData = postPrefixData;
        this.antiData = antiData;
    }

    public void setAvatar(String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048576, this, str) == null) {
            this.avatar = str;
        }
    }

    public void setCategoryId(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i) == null) {
            this.categoryId = i;
        }
    }

    public void setDefaultZone(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i) == null) {
            this.defaultZone = i;
        }
    }

    public void setForumLevel(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i) == null) {
            this.forumLevel = i;
        }
    }

    public void setMem_type(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i) == null) {
            this.mem_type = i;
        }
    }

    public void setPrivateThread(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i) == null) {
            this.privateThread = i;
        }
    }

    public void setTopicData(PostTopicData postTopicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, postTopicData) == null) {
            this.topicData = postTopicData;
        }
    }
}
