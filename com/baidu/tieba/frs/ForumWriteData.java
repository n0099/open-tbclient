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
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
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

    public void setCategoryId(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2) == null) {
            this.categoryId = i2;
        }
    }

    public void setDefaultZone(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(Constants.METHOD_SEND_USER_MSG, this, i2) == null) {
            this.defaultZone = i2;
        }
    }

    public void setForumLevel(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048579, this, i2) == null) {
            this.forumLevel = i2;
        }
    }

    public void setMem_type(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048580, this, i2) == null) {
            this.mem_type = i2;
        }
    }

    public void setPrivateThread(int i2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048581, this, i2) == null) {
            this.privateThread = i2;
        }
    }

    public void setTopicData(PostTopicData postTopicData) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, postTopicData) == null) {
            this.topicData = postTopicData;
        }
    }
}
