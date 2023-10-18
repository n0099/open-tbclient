package com.baidu.tieba.im.base.core.uilist;

import androidx.annotation.CallSuper;
import androidx.core.view.InputDeviceCompat;
import androidx.recyclerview.widget.DiffUtil;
import com.baidu.adp.BdUniqueId;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.tieba.im.lib.socket.msg.TbBaseMsg;
import com.baidu.tieba.im.lib.socket.msg.data.AbilityEffectItem;
import com.baidu.tieba.im.lib.socket.msg.data.EmojiData;
import com.baidu.tieba.ja8;
import com.baidu.tieba.of8;
import com.baidu.tieba.yh;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt__LazyJVMKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0000\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u0000 .*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\u00020\u00042\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u00000\u0005:\u0001.B\u0005¢\u0006\u0002\u0010\u0006J\u0013\u0010\u001e\u001a\u00020\b2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0096\u0002J\u001a\u0010!\u001a\u0004\u0018\u00010 2\u000e\u0010\"\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000H\u0017J\u000b\u0010#\u001a\u00028\u0000¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0016H\u0016J\u000e\u0010&\u001a\u00020'2\u0006\u0010\u001c\u001a\u00020\u0002J\u0018\u0010(\u001a\u00020\b2\u000e\u0010)\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000H\u0017J\b\u0010*\u001a\u00020\bH\u0016J\n\u0010+\u001a\u0004\u0018\u00010,H\u0016J\u0012\u0010-\u001a\f\u0012\u0006\b\u0001\u0012\u00020\u0002\u0018\u00010\u0000H\u0016R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0007\u0010\tR\u001a\u0010\f\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\t\"\u0004\b\r\u0010\u000eR,\u0010\u000f\u001a\u0014\u0012\u000e\b\u0001\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00020\u0000\u0018\u00010\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R \u0010\u0015\u001a\u00020\u0016X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0017\u0010\u0006\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u0010\u0010\u001c\u001a\u00028\u0000X\u0082.¢\u0006\u0004\n\u0002\u0010\u001d¨\u0006/"}, d2 = {"Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "TbMsg", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "Lcom/baidu/adp/widget/ListView/IAdapterData;", "Ljava/io/Serializable;", "Lcom/baidu/tieba/im/lib/socket/listener/ShallowClone;", "()V", "isLeft", "", "()Z", "isLeft$delegate", "Lkotlin/Lazy;", "isShowLocatedColor", "setShowLocatedColor", "(Z)V", "itemEventCallback", "Lcom/baidu/tieba/im/base/core/uilist/ItemEventCallback;", "getItemEventCallback", "()Lcom/baidu/tieba/im/base/core/uilist/ItemEventCallback;", "setItemEventCallback", "(Lcom/baidu/tieba/im/base/core/uilist/ItemEventCallback;)V", "sendStatus", "", "getSendStatus$annotations", "getSendStatus", "()I", "setSendStatus", "(I)V", "tbMsg", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "equals", "other", "", "getChangePayload", "newMsg", "getTbMsg", "()Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "hashCode", "injectTbMsg", "", "isContentChanged", "newItem", "needBubbleInfo", "provideAction", "Lcom/baidu/tieba/im/base/core/uilist/Action;", "shallowClone", "Companion", "im-base-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes6.dex */
public abstract class BaseItem<TbMsg extends TbBaseMsg> implements yh, Serializable, Object<BaseItem<? extends TbBaseMsg>> {
    public static /* synthetic */ Interceptable $ic;
    public static final Comparator<BaseItem<?>> COMPARATOR;
    public static final Companion Companion;
    public static final DiffUtil.ItemCallback<BaseItem<? extends TbBaseMsg>> DIFF_ITEM_CALLBACK;
    public static final BdUniqueId NON_TYPE;
    public transient /* synthetic */ FieldHolder $fh;
    public final Lazy isLeft$delegate;
    public boolean isShowLocatedColor;
    public ja8<? extends BaseItem<? extends TbBaseMsg>> itemEventCallback;
    public int sendStatus;
    public TbMsg tbMsg;

    public static final DiffUtil.ItemCallback<BaseItem<? extends TbBaseMsg>> getDIFF_ITEM_CALLBACK() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65542, null)) == null) ? Companion.c() : (DiffUtil.ItemCallback) invokeV.objValue;
    }

    public static /* synthetic */ void getSendStatus$annotations() {
    }

    @Override // com.baidu.tieba.yh
    public abstract /* synthetic */ BdUniqueId getType();

    public boolean needBubbleInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return false;
        }
        return invokeV.booleanValue;
    }

    public Action provideAction() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return null;
        }
        return (Action) invokeV.objValue;
    }

    @Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0013\u001a\n\u0012\u0006\b\u0001\u0012\u00020\f0\u00052\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017R/\u0010\u0003\u001a\u001a\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u0004j\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u0005`\u0006¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\tR*\u0010\n\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\f0\u00050\u000b8\u0006X\u0087\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0010\u001a\n \u0012*\u0004\u0018\u00010\u00110\u0011X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/baidu/tieba/im/base/core/uilist/BaseItem$Companion;", "", "()V", "COMPARATOR", "Ljava/util/Comparator;", "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;", "Lkotlin/Comparator;", "getCOMPARATOR$annotations", "getCOMPARATOR", "()Ljava/util/Comparator;", "DIFF_ITEM_CALLBACK", "Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "Lcom/baidu/tieba/im/lib/socket/msg/TbBaseMsg;", "getDIFF_ITEM_CALLBACK$annotations", "getDIFF_ITEM_CALLBACK", "()Landroidx/recyclerview/widget/DiffUtil$ItemCallback;", "NON_TYPE", "Lcom/baidu/adp/BdUniqueId;", "kotlin.jvm.PlatformType", "createShadowMsg", "msgId", "", "msgKey", "", "im-base-core_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes6.dex */
    public static final class Companion {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public Companion() {
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

        public final Comparator<BaseItem<?>> b() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                return (Comparator) invokeV.objValue;
            }
            return BaseItem.COMPARATOR;
        }

        public final DiffUtil.ItemCallback<BaseItem<? extends TbBaseMsg>> c() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable != null && (invokeV = interceptable.invokeV(Constants.METHOD_SEND_USER_MSG, this)) != null) {
                return (DiffUtil.ItemCallback) invokeV.objValue;
            }
            return BaseItem.DIFF_ITEM_CALLBACK;
        }

        public final BaseItem<? extends TbBaseMsg> a(long j, String msgKey) {
            InterceptResult invokeJL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeJL = interceptable.invokeJL(1048576, this, j, msgKey)) == null) {
                Intrinsics.checkNotNullParameter(msgKey, "msgKey");
                TbBaseMsg tbBaseMsg = new TbBaseMsg() { // from class: com.baidu.tieba.im.base.core.uilist.BaseItem$Companion$createShadowMsg$tbMsg$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.tieba.im.lib.socket.msg.TbBaseMsg
                    public String getThumbnailText() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        return (interceptable2 == null || (invokeV = interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this)) == null) ? "" : (String) invokeV.objValue;
                    }

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.baidu.tieba.im.lib.socket.msg.TbBaseMsg, java.lang.Object
                    public Object clone() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return super.clone();
                        }
                        return invokeV.objValue;
                    }
                };
                tbBaseMsg.setMsgId(j);
                tbBaseMsg.setMsgKey(msgKey);
                BaseItem<TbBaseMsg> baseItem = new BaseItem<TbBaseMsg>() { // from class: com.baidu.tieba.im.base.core.uilist.BaseItem$Companion$createShadowMsg$1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                            }
                        }
                    }

                    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem, java.lang.Object
                    public Object clone() {
                        InterceptResult invokeV;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                            return super.clone();
                        }
                        return invokeV.objValue;
                    }

                    @Override // com.baidu.tieba.im.base.core.uilist.BaseItem, com.baidu.tieba.yh
                    public BdUniqueId getType() {
                        InterceptResult invokeV;
                        BdUniqueId bdUniqueId;
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null && (invokeV = interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) != null) {
                            return (BdUniqueId) invokeV.objValue;
                        }
                        bdUniqueId = BaseItem.NON_TYPE;
                        return bdUniqueId;
                    }
                };
                baseItem.injectTbMsg(tbBaseMsg);
                return baseItem;
            }
            return (BaseItem) invokeJL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public static final class a implements Comparator<BaseItem<?>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public a() {
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

        /* JADX DEBUG: Method merged with bridge method */
        @Override // java.util.Comparator
        /* renamed from: a */
        public int compare(BaseItem<?> o1, BaseItem<?> o2) {
            InterceptResult invokeLL;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeLL = interceptable.invokeLL(1048576, this, o1, o2)) == null) {
                Intrinsics.checkNotNullParameter(o1, "o1");
                Intrinsics.checkNotNullParameter(o2, "o2");
                Comparator<TbBaseMsg> comparator = TbBaseMsg.COMPARATOR;
                TbBaseMsg tbBaseMsg = o1.tbMsg;
                TbBaseMsg tbBaseMsg2 = null;
                if (tbBaseMsg == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                    tbBaseMsg = null;
                }
                TbBaseMsg tbBaseMsg3 = o2.tbMsg;
                if (tbBaseMsg3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                } else {
                    tbBaseMsg2 = tbBaseMsg3;
                }
                return comparator.compare(tbBaseMsg, tbBaseMsg2);
            }
            return invokeLL.intValue;
        }
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(-1816448279, "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(-1816448279, "Lcom/baidu/tieba/im/base/core/uilist/BaseItem;");
                return;
            }
        }
        Companion = new Companion(null);
        COMPARATOR = new a();
        DIFF_ITEM_CALLBACK = new DiffUtil.ItemCallback<BaseItem<? extends TbBaseMsg>>() { // from class: com.baidu.tieba.im.base.core.uilist.BaseItem$Companion$DIFF_ITEM_CALLBACK$1
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                    }
                }
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: a */
            public boolean areContentsTheSame(BaseItem<? extends TbBaseMsg> oldItem, BaseItem<? extends TbBaseMsg> newItem) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048576, this, oldItem, newItem)) == null) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    if (oldItem.getSendStatus() == newItem.getSendStatus() && !oldItem.isContentChanged(newItem)) {
                        return true;
                    }
                    return false;
                }
                return invokeLL.booleanValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: b */
            public boolean areItemsTheSame(BaseItem<? extends TbBaseMsg> oldItem, BaseItem<? extends TbBaseMsg> newItem) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048579, this, oldItem, newItem)) == null) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    return Intrinsics.areEqual(oldItem, newItem);
                }
                return invokeLL.booleanValue;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // androidx.recyclerview.widget.DiffUtil.ItemCallback
            /* renamed from: c */
            public Object getChangePayload(BaseItem<? extends TbBaseMsg> oldItem, BaseItem<? extends TbBaseMsg> newItem) {
                InterceptResult invokeLL;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeLL = interceptable2.invokeLL(1048580, this, oldItem, newItem)) == null) {
                    Intrinsics.checkNotNullParameter(oldItem, "oldItem");
                    Intrinsics.checkNotNullParameter(newItem, "newItem");
                    return oldItem.getChangePayload(newItem);
                }
                return invokeLL.objValue;
            }
        };
        NON_TYPE = BdUniqueId.gen();
    }

    public final TbMsg getTbMsg() {
        InterceptResult invokeV;
        boolean z;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048581, this)) == null) {
            if (this.tbMsg != null) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                TbMsg tbmsg = this.tbMsg;
                if (tbmsg == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                    return null;
                }
                return tbmsg;
            }
            throw new IllegalArgumentException("Failed requirement.".toString());
        }
        return (TbMsg) invokeV.objValue;
    }

    /* JADX DEBUG: Method merged with bridge method */
    /* renamed from: shallowClone */
    public BaseItem<? extends TbBaseMsg> m137shallowClone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            try {
                BaseItem<? extends TbBaseMsg> baseItem = (BaseItem) clone();
                TbMsg tbmsg = baseItem.tbMsg;
                if (tbmsg == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                    tbmsg = null;
                }
                TbBaseMsg m138shallowClone = tbmsg.m138shallowClone();
                Intrinsics.checkNotNull(m138shallowClone);
                baseItem.injectTbMsg(m138shallowClone);
                return baseItem;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }
        return (BaseItem) invokeV.objValue;
    }

    public BaseItem() {
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
        this.sendStatus = 5;
        this.isLeft$delegate = LazyKt__LazyJVMKt.lazy(new Function0<Boolean>(this) { // from class: com.baidu.tieba.im.base.core.uilist.BaseItem$isLeft$2
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ BaseItem<TbMsg> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext2 = TitanRuntime.newInitContext();
                    newInitContext2.initArgs = r2;
                    Object[] objArr = {this};
                    interceptable2.invokeUnInit(65536, newInitContext2);
                    int i3 = newInitContext2.flag;
                    if ((i3 & 1) != 0) {
                        int i4 = i3 & 2;
                        super(((Integer) newInitContext2.callArgs[0]).intValue());
                        newInitContext2.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext2);
                        return;
                    }
                }
                this.this$0 = this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Boolean invoke() {
                InterceptResult invokeV;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || (invokeV = interceptable2.invokeV(1048576, this)) == null) {
                    return Boolean.valueOf(!of8.c(this.this$0.getTbMsg().getUserId()));
                }
                return (Boolean) invokeV.objValue;
            }
        });
    }

    @Override // java.lang.Object
    public Object clone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
            return super.clone();
        }
        return invokeV.objValue;
    }

    public final ja8<? extends BaseItem<? extends TbBaseMsg>> getItemEventCallback() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            return this.itemEventCallback;
        }
        return (ja8) invokeV.objValue;
    }

    public final int getSendStatus() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) {
            return this.sendStatus;
        }
        return invokeV.intValue;
    }

    @Override // java.lang.Object
    public int hashCode() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048583, this)) == null) {
            TbMsg tbmsg = this.tbMsg;
            if (tbmsg == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                tbmsg = null;
            }
            return tbmsg.hashCode();
        }
        return invokeV.intValue;
    }

    public final boolean isLeft() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048586, this)) == null) {
            return ((Boolean) this.isLeft$delegate.getValue()).booleanValue();
        }
        return invokeV.booleanValue;
    }

    public final boolean isShowLocatedColor() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return this.isShowLocatedColor;
        }
        return invokeV.booleanValue;
    }

    /* JADX DEBUG: Multi-variable search result rejected for r5v0, resolved type: com.baidu.tieba.im.lib.socket.msg.TbBaseMsg */
    /* JADX WARN: Multi-variable type inference failed */
    public final void injectTbMsg(TbBaseMsg tbMsg) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(InputDeviceCompat.SOURCE_TOUCHPAD, this, tbMsg) == null) {
            Intrinsics.checkNotNullParameter(tbMsg, "tbMsg");
            this.tbMsg = tbMsg;
        }
    }

    public final void setItemEventCallback(ja8<? extends BaseItem<? extends TbBaseMsg>> ja8Var) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048590, this, ja8Var) == null) {
            this.itemEventCallback = ja8Var;
        }
    }

    public final void setSendStatus(int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeI(1048591, this, i) == null) {
            this.sendStatus = i;
        }
    }

    public final void setShowLocatedColor(boolean z) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeZ(1048592, this, z) == null) {
            this.isShowLocatedColor = z;
        }
    }

    @Override // java.lang.Object
    public boolean equals(Object obj) {
        InterceptResult invokeL;
        Class<?> cls;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, obj)) == null) {
            if (this == obj) {
                return true;
            }
            Class<?> cls2 = getClass();
            TbMsg tbmsg = null;
            if (obj != null) {
                cls = obj.getClass();
            } else {
                cls = null;
            }
            if (!Intrinsics.areEqual(cls2, cls)) {
                return false;
            }
            if (obj != null) {
                BaseItem baseItem = (BaseItem) obj;
                TbMsg tbmsg2 = this.tbMsg;
                if (tbmsg2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                    tbmsg2 = null;
                }
                TbMsg tbmsg3 = baseItem.tbMsg;
                if (tbmsg3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                } else {
                    tbmsg = tbmsg3;
                }
                if (Intrinsics.areEqual(tbmsg2, tbmsg)) {
                    return true;
                }
                return false;
            }
            throw new NullPointerException("null cannot be cast to non-null type com.baidu.tieba.im.base.core.uilist.BaseItem<*>");
        }
        return invokeL.booleanValue;
    }

    @CallSuper
    public Object getChangePayload(BaseItem<? extends TbBaseMsg> newMsg) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, newMsg)) == null) {
            Intrinsics.checkNotNullParameter(newMsg, "newMsg");
            if (!isContentChanged(newMsg)) {
                return null;
            }
            List<EmojiData> emojiList = getTbMsg().getEmojiList();
            TbMsg tbmsg = newMsg.tbMsg;
            if (tbmsg == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                tbmsg = null;
            }
            if (!Intrinsics.areEqual(emojiList, tbmsg.getEmojiList())) {
                return 1;
            }
            AbilityEffectItem abilityEffectItem = getTbMsg().getAbilityEffectItem();
            TbMsg tbmsg2 = newMsg.tbMsg;
            if (tbmsg2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                tbmsg2 = null;
            }
            if (Intrinsics.areEqual(abilityEffectItem, tbmsg2.getAbilityEffectItem())) {
                return null;
            }
            return 2;
        }
        return invokeL.objValue;
    }

    @CallSuper
    public boolean isContentChanged(BaseItem<? extends TbBaseMsg> newItem) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048585, this, newItem)) == null) {
            Intrinsics.checkNotNullParameter(newItem, "newItem");
            List<EmojiData> emojiList = getTbMsg().getEmojiList();
            TbMsg tbmsg = newItem.tbMsg;
            TbMsg tbmsg2 = null;
            if (tbmsg == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                tbmsg = null;
            }
            if (Intrinsics.areEqual(emojiList, tbmsg.getEmojiList())) {
                AbilityEffectItem abilityEffectItem = getTbMsg().getAbilityEffectItem();
                TbMsg tbmsg3 = newItem.tbMsg;
                if (tbmsg3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tbMsg");
                } else {
                    tbmsg2 = tbmsg3;
                }
                if (Intrinsics.areEqual(abilityEffectItem, tbmsg2.getAbilityEffectItem())) {
                    return false;
                }
            }
            return true;
        }
        return invokeL.booleanValue;
    }
}
