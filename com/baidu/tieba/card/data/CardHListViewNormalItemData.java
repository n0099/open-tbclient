package com.baidu.tieba.card.data;

import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.yn;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import tbclient.GuessLikeThreadInfo;
/* loaded from: classes5.dex */
public class CardHListViewNormalItemData implements yn, Serializable {
    public static /* synthetic */ Interceptable $ic = null;
    public static final BdUniqueId TYPE;
    public static final long serialVersionUID = 9123181123453164969L;
    public transient /* synthetic */ FieldHolder $fh;
    public long forumId;
    public String forumName;
    public String recomCover;
    public String recomReason;
    public long replyNum;
    public long threadId;
    public String title;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(2046102672, "Lcom/baidu/tieba/card/data/CardHListViewNormalItemData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(2046102672, "Lcom/baidu/tieba/card/data/CardHListViewNormalItemData;");
                return;
            }
        }
        TYPE = BdUniqueId.gen();
    }

    public CardHListViewNormalItemData() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
            }
        }
    }

    @Override // com.baidu.tieba.yn
    public BdUniqueId getType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return TYPE;
        }
        return (BdUniqueId) invokeV.objValue;
    }

    public void parseProtobuf(GuessLikeThreadInfo guessLikeThreadInfo) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, guessLikeThreadInfo) != null) || guessLikeThreadInfo == null) {
            return;
        }
        this.title = guessLikeThreadInfo.title;
        this.forumId = guessLikeThreadInfo.forum_id.longValue();
        this.threadId = guessLikeThreadInfo.thread_id.longValue();
        this.replyNum = guessLikeThreadInfo.reply_num.longValue();
        this.forumName = guessLikeThreadInfo.forum_name;
        this.recomCover = guessLikeThreadInfo.recom_cover;
        this.recomReason = guessLikeThreadInfo.recom_reason;
    }
}
