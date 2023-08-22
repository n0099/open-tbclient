package com.baidu.tieba.im.lib.socket.msg.data;

import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.bytedance.sdk.openadsdk.downloadnew.core.TTDownloadField;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\u0000\n\u0002\b\u0004\u0018\u00002\u00020\u00012\b\u0012\u0004\u0012\u00020\u00000\u00022\u00020\u0003BE\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\u0007\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000fJ\u0011\u0010 \u001a\u00020\n2\u0006\u0010!\u001a\u00020\u0000H\u0096\u0002J\u0013\u0010\"\u001a\u00020\r2\b\u0010!\u001a\u0004\u0018\u00010#H\u0096\u0002J\u0006\u0010$\u001a\u00020\rJ\b\u0010%\u001a\u00020\nH\u0016J\u0006\u0010&\u001a\u00020\u0000R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0015\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\f\u0010\u0016R\u001e\u0010\u000e\u001a\u0004\u0018\u00010\nX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b\u000e\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\b\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0016\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001d¨\u0006'"}, d2 = {"Lcom/baidu/tieba/im/lib/socket/msg/data/EmojiData;", "Ljava/io/Serializable;", "", "", "content", "", "msgId", "", "msgKey", "allNum", "", "sortTimeUs", "isAdd", "", "isReplied", "(Ljava/lang/String;JLjava/lang/String;IJLjava/lang/Boolean;Ljava/lang/Integer;)V", "getAllNum", "()I", "setAllNum", "(I)V", "getContent", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "()Ljava/lang/Integer;", "setReplied", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getMsgId", "()J", "getMsgKey", "getSortTimeUs", "compareTo", "other", "equals", "", "hasReplied", TTDownloadField.TT_HASHCODE, "shallowClone", "im-lib-socket_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EmojiData implements Serializable, Comparable<EmojiData>, Cloneable {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;
    @SerializedName("reactions_num")
    public int allNum;
    @SerializedName("emoji_content")
    public final String content;
    public final Boolean isAdd;
    public Integer isReplied;
    @SerializedName("msgid")
    public final long msgId;
    @SerializedName("msg_key")
    public final String msgKey;
    @SerializedName("sort_time_us_min")
    public final long sortTimeUs;

    public EmojiData(String content, long j, String msgKey, int i, long j2, Boolean bool, Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {content, Long.valueOf(j), msgKey, Integer.valueOf(i), Long.valueOf(j2), bool, num};
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        Intrinsics.checkNotNullParameter(content, "content");
        Intrinsics.checkNotNullParameter(msgKey, "msgKey");
        this.content = content;
        this.msgId = j;
        this.msgKey = msgKey;
        this.allNum = i;
        this.sortTimeUs = j2;
        this.isAdd = bool;
        this.isReplied = num;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public /* synthetic */ EmojiData(String str, long j, String str2, int i, long j2, Boolean bool, Integer num, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, j, str2, i, j2, r9, r10);
        Boolean bool2;
        Integer num2;
        if ((i2 & 32) != 0) {
            bool2 = Boolean.FALSE;
        } else {
            bool2 = bool;
        }
        if ((i2 & 64) != 0) {
            num2 = 0;
        } else {
            num2 = num;
        }
    }

    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    public final int getAllNum() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.allNum;
        }
        return invokeV.intValue;
    }

    public final String getContent() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            return this.content;
        }
        return (String) invokeV.objValue;
    }

    public final long getMsgId() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048582, this)) == null) {
            return this.msgId;
        }
        return invokeV.longValue;
    }

    public final String getMsgKey() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            return this.msgKey;
        }
        return (String) invokeV.objValue;
    }

    public final long getSortTimeUs() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this)) == null) {
            return this.sortTimeUs;
        }
        return invokeV.longValue;
    }

    public final boolean hasReplied() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048585, this)) == null) {
            Integer num = this.isReplied;
            if (num != null && num.intValue() == 1) {
                return true;
            }
            return false;
        }
        return invokeV.booleanValue;
    }

    public final Boolean isAdd() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.isAdd;
        }
        return (Boolean) invokeV.objValue;
    }

    public final Integer isReplied() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return this.isReplied;
        }
        return (Integer) invokeV.objValue;
    }

    public final EmojiData shallowClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048591, this)) == null) {
            return (EmojiData) clone();
        }
        return (EmojiData) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // java.lang.Comparable
    public int compareTo(EmojiData other) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, other)) == null) {
            Intrinsics.checkNotNullParameter(other, "other");
            return hashCode() - other.hashCode();
        }
        return invokeL.intValue;
    }

    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048579, this, obj)) == null) {
            return super.equals(obj);
        }
        return invokeL.booleanValue;
    }

    public final void setAllNum(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048589, this, i) == null) {
            this.allNum = i;
        }
    }

    public final void setReplied(Integer num) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, num) == null) {
            this.isReplied = num;
        }
    }

    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return (this.content + this.msgId + this.msgKey + this.allNum + this.sortTimeUs + this.isAdd + this.isReplied).hashCode();
        }
        return invokeV.intValue;
    }
}
