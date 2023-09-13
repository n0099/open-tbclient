package com.baidu.tieba.hottopic.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.cn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.Hottopic.RelateForum;
/* loaded from: classes6.dex */
public class RelateForumItemData implements Serializable, cn {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId TYPE_FORUM_CARD;
    public static final long serialVersionUID = 1;
    public transient /* synthetic */ FieldHolder $fh;
    public long followNum;
    public String forumAbstract;
    public String forumAvatar;
    public long forumId;
    public String forumName;
    public boolean isLiked;
    public long postNum;
    public long threadNum;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-398324996, "Lcom/baidu/tieba/hottopic/data/RelateForumItemData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-398324996, "Lcom/baidu/tieba/hottopic/data/RelateForumItemData;");
                return;
            }
        }
        TYPE_FORUM_CARD = BdUniqueId.gen();
    }

    @Override // com.baidu.tieba.cn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TYPE_FORUM_CARD;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public RelateForumItemData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.forumId = 0L;
        this.forumName = null;
        this.forumAvatar = null;
        this.forumAbstract = null;
        this.threadNum = 0L;
        this.postNum = 0L;
        this.followNum = 0L;
        this.isLiked = false;
    }

    public void parserProtobuf(RelateForum relateForum) {
        boolean z;
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, relateForum) != null) || relateForum == null) {
            return;
        }
        this.forumId = relateForum.forum_id.intValue();
        this.forumName = relateForum.forum_name;
        this.forumAvatar = relateForum.avatar;
        this.forumAbstract = relateForum.desc;
        this.threadNum = relateForum.thread_num.intValue();
        this.postNum = relateForum.post_num.intValue();
        this.followNum = relateForum.member_num.intValue();
        if (relateForum.is_liked.intValue() == 0) {
            z = false;
        } else {
            z = true;
        }
        this.isLiked = z;
    }

    public void setIsLiked(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(Constants.METHOD_SEND_USER_MSG, this, z) == null) {
            this.isLiked = z;
        }
    }
}
