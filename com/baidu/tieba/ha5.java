package com.baidu.tieba;

import android.text.TextUtils;
import androidx.annotation.WorkerThread;
import androidx.core.view.InputDeviceCompat;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.adp.lib.safe.JavaTypesHelper;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.tbadk.TbSingleton;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.sharedPref.SharedPrefHelper;
import com.baidu.tbadk.core.util.ListUtils;
import com.baidu.tbadk.coreExtra.messageCenter.NewsRemindMessage;
import com.baidu.tbadk.data.NewsNotifyMessage;
import com.baidu.tieba.eoc;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.message.MemoryInitCompleteMessage;
import com.baidu.tieba.im.message.RequestMemoryListMessage;
import com.baidu.tieba.im.message.ResponsedGroupChatListCompleteMessage;
import com.baidu.tieba.im.settingcache.OfficialSettingCache;
import com.baidu.tieba.im.settingcache.OfficialSettingItemData;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Triple;
import rx.schedulers.Schedulers;
/* loaded from: classes6.dex */
public class ha5 {
    public static /* synthetic */ Interceptable $ic;
    public static volatile ha5 m;
    public transient /* synthetic */ FieldHolder $fh;
    public final Map<String, ImMessageCenterPojo> a;
    public int b;
    public int c;
    public int d;
    public int e;
    public int f;
    public boolean g;
    public int h;
    public boolean i;
    public int j;
    public int k;
    public final CustomMessageListener l;

    /* loaded from: classes6.dex */
    public class a extends CustomMessageListener {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha5 a;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(ha5 ha5Var, int i) {
            super(i);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha5Var, Integer.valueOf(i)};
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super(((Integer) newInitContext.callArgs[0]).intValue());
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            Interceptable interceptable = $ic;
            if ((interceptable != null && interceptable.invokeL(1048576, this, customResponsedMessage) != null) || customResponsedMessage == null) {
                return;
            }
            if (customResponsedMessage.getCmd() == 2001120) {
                this.a.D(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016002) {
                this.a.C(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016004) {
                this.a.A(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() == 2016001) {
                this.a.B(customResponsedMessage);
            } else if (customResponsedMessage.getCmd() != 2016010) {
                if (customResponsedMessage.getCmd() != 2016011) {
                    if (customResponsedMessage.getCmd() != 2008024) {
                        if (customResponsedMessage.getCmd() == 2921767) {
                            this.a.z(customResponsedMessage);
                            return;
                        }
                        return;
                    }
                    this.a.E();
                    return;
                }
                this.a.F();
            } else {
                this.a.G();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class b implements soc<Triple<Integer, Integer, Boolean>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ ha5 a;

        public b(ha5 ha5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha5Var};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = ha5Var;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(Triple<Integer, Integer, Boolean> triple) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, triple) == null) {
                this.a.h = triple.getFirst().intValue();
                this.a.k = triple.getSecond().intValue();
                this.a.i = triple.getThird().booleanValue();
                this.a.I();
            }
        }
    }

    /* loaded from: classes6.dex */
    public class c implements xoc<Triple<Integer, Integer, Boolean>, Boolean> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        public c(ha5 ha5Var) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha5Var};
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
        @Override // com.baidu.tieba.xoc
        /* renamed from: a */
        public Boolean call(Triple<Integer, Integer, Boolean> triple) {
            InterceptResult invokeL;
            boolean z;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, triple)) == null) {
                if (triple != null) {
                    z = true;
                } else {
                    z = false;
                }
                return Boolean.valueOf(z);
            }
            return (Boolean) invokeL.objValue;
        }
    }

    /* loaded from: classes6.dex */
    public class d implements eoc.a<Triple<Integer, Integer, Boolean>> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public final /* synthetic */ Map a;

        public d(ha5 ha5Var, Map map) {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {ha5Var, map};
                interceptable.invokeUnInit(65536, newInitContext);
                int i = newInitContext.flag;
                if ((i & 1) != 0) {
                    int i2 = i & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                    return;
                }
            }
            this.a = map;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.tieba.soc
        /* renamed from: a */
        public void call(koc<? super Triple<Integer, Integer, Boolean>> kocVar) {
            Interceptable interceptable = $ic;
            if (interceptable == null || interceptable.invokeL(1048576, this, kocVar) == null) {
                kocVar.onNext(ha5.p(this.a));
                kocVar.onCompleted();
            }
        }
    }

    public ha5() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
                return;
            }
        }
        this.a = new HashMap();
        this.b = 0;
        this.c = 0;
        this.d = 0;
        this.e = 0;
        this.f = 0;
        this.g = false;
        this.h = 0;
        this.i = false;
        this.j = 0;
        this.k = 0;
        this.l = new a(this, 0);
    }

    public final void B(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, customResponsedMessage) == null) {
            this.a.clear();
            n(this.a);
        }
    }

    public final void t(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048589, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 3) {
            String gid = responsedGroupChatListCompleteMessage.getGid();
            if (TextUtils.isEmpty(gid)) {
                return;
            }
            this.a.remove(gid);
            n(this.a);
        }
    }

    public final void u(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048590, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 4) {
            if (responsedGroupChatListCompleteMessage.isHasUnreadMsg()) {
                this.i = true;
            } else {
                this.i = false;
            }
            if (!TbSingleton.getInstance().isChatTabPage()) {
                I();
            }
        }
    }

    public final void v(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048591, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 5) {
            n(this.a);
        }
    }

    @WorkerThread
    public static synchronized Triple<Integer, Integer, Boolean> p(Map<String, ImMessageCenterPojo> map) {
        InterceptResult invokeL;
        Triple<Integer, Integer, Boolean> triple;
        int unread_count;
        int unread_count2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65550, null, map)) == null) {
            synchronized (ha5.class) {
                ea5 ea5Var = (ea5) ServiceManager.getService(ea5.a);
                boolean z = false;
                int i = 0;
                int i2 = 0;
                int i3 = 0;
                boolean z2 = false;
                for (Map.Entry<String, ImMessageCenterPojo> entry : map.entrySet()) {
                    ImMessageCenterPojo value = entry.getValue();
                    if (value != null && !TextUtils.isEmpty(value.getLast_content()) && value.getUnread_count() > 0) {
                        if (value.getCustomGroupType() != -4 && value.getCustomGroupType() != -7) {
                            if (value.getCustomGroupType() == 2) {
                                PersonalSettingItemData setting = gx8.a().getSetting(TbadkCoreApplication.getCurrentAccount(), value.getGid());
                                if (setting != null) {
                                    if (setting.isAcceptNotify()) {
                                        unread_count = value.getUnread_count();
                                    }
                                } else {
                                    unread_count = value.getUnread_count();
                                }
                                i += unread_count;
                            } else if (value.getCustomGroupType() == 4) {
                                if (value.getUserType() == 4) {
                                    if (ea5Var.f() && ga5.P(value.getGid())) {
                                        OfficialSettingItemData setting2 = OfficialSettingCache.getInstance().getSetting(TbadkCoreApplication.getCurrentAccount(), value.getGid());
                                        if (setting2 != null) {
                                            if (setting2.isAcceptNotify()) {
                                                unread_count2 = value.getUnread_count();
                                            }
                                        } else {
                                            unread_count2 = value.getUnread_count();
                                        }
                                        i3 += unread_count2;
                                    } else if (ia5.e().x()) {
                                        OfficialSettingItemData setting3 = OfficialSettingCache.getInstance().getSetting(TbadkCoreApplication.getCurrentAccount(), value.getGid());
                                        if (setting3 != null) {
                                            if (setting3.isAcceptNotify()) {
                                                unread_count = value.getUnread_count();
                                            }
                                        } else {
                                            unread_count = value.getUnread_count();
                                        }
                                        i += unread_count;
                                    }
                                }
                            } else if (value.getCustomGroupType() != -8) {
                                if (value.getCustomGroupType() == 9 && dx8.b().d(Long.valueOf(JavaTypesHelper.toLong(value.getGid(), 0L))) && value.getUnread_count() > 0) {
                                    i2 += value.getUnread_count();
                                }
                            }
                        }
                        z2 = true;
                    }
                }
                if (ia5.e().g() == 0) {
                    i = 0;
                    i2 = 0;
                }
                if (i > 0 || i2 > 0) {
                    z = z2;
                }
                triple = new Triple<>(Integer.valueOf(i), Integer.valueOf(i3), Boolean.valueOf(z));
            }
            return triple;
        }
        return (Triple) invokeL.objValue;
    }

    public static ha5 r() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65551, null)) == null) {
            if (m == null) {
                synchronized (ha5.class) {
                    if (m == null) {
                        m = new ha5();
                    }
                }
            }
            return m;
        }
        return (ha5) invokeV.objValue;
    }

    public final void E() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048580, this) == null) {
            this.j = 0;
            o(this.b, this.c, this.d, this.e, 0);
            n(this.a);
        }
    }

    public final void F() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048581, this) == null) {
            o(this.b, this.c, this.d, this.e, this.j);
            n(this.a);
        }
    }

    public final void G() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048582, this) == null) {
            o(this.b, this.c, this.d, this.e, this.j);
            n(this.a);
        }
    }

    public final void H() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048583, this) == null) {
            this.a.clear();
            this.b = 0;
            this.c = 0;
            this.d = 0;
            this.e = 0;
            this.f = 0;
            this.g = false;
            this.h = 0;
            this.i = false;
            this.j = 0;
        }
    }

    public final void y() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048594, this) == null) {
            MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921764, Boolean.TRUE));
        }
    }

    public final void A(CustomResponsedMessage<?> customResponsedMessage) {
        MemoryChangedMessage memoryChangedMessage;
        ImMessageCenterPojo data;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048576, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryChangedMessage) && (data = (memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage).getData()) != null && !TextUtils.isEmpty(data.getGid())) {
            if (memoryChangedMessage.getType() == 1) {
                this.a.remove(data.getGid());
                if (q(data)) {
                    this.a.put(data.getGid(), data);
                }
            } else if (memoryChangedMessage.getType() == 2) {
                this.a.remove(data.getGid());
            }
            n(this.a);
        }
    }

    public final void C(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(Constants.METHOD_SEND_USER_MSG, this, customResponsedMessage) == null) && (customResponsedMessage instanceof MemoryInitCompleteMessage) && ((MemoryInitCompleteMessage) customResponsedMessage).getData().booleanValue()) {
            MessageManager.getInstance().sendMessage(new RequestMemoryListMessage(1));
        }
    }

    public final void D(ResponsedMessage<?> responsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048579, this, responsedMessage) != null) || responsedMessage == null) {
            return;
        }
        if (!(responsedMessage instanceof NewsNotifyMessage)) {
            BdLog.e("transform error");
            return;
        }
        NewsNotifyMessage newsNotifyMessage = (NewsNotifyMessage) responsedMessage;
        o(newsNotifyMessage.getMsgAgree(), newsNotifyMessage.getMsgAtme(), newsNotifyMessage.getMsgReplyme(), newsNotifyMessage.getMsgFans(), newsNotifyMessage.getMsgInvitation());
        I();
    }

    public final void n(Map<String, ImMessageCenterPojo> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048585, this, map) == null) {
            eoc.d(new d(this, new ConcurrentHashMap(map))).J(Schedulers.computation()).s(ooc.b()).k(new c(this)).x().I(new b(this), new soc() { // from class: com.baidu.tieba.da5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;

                @Override // com.baidu.tieba.soc
                public final void call(Object obj) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, obj) == null) {
                        BdLog.e((Throwable) obj);
                    }
                }
            });
        }
    }

    public final void w(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048592, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 2) {
            String gid = responsedGroupChatListCompleteMessage.getGid();
            if (TextUtils.isEmpty(gid)) {
                return;
            }
            ImMessageCenterPojo imMessageCenterPojo = this.a.get(gid);
            if (imMessageCenterPojo != null) {
                imMessageCenterPojo.setUnread_count(0);
            }
            n(this.a);
        }
    }

    public final void z(CustomResponsedMessage<?> customResponsedMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable != null && interceptable.invokeL(1048595, this, customResponsedMessage) != null) || !(customResponsedMessage instanceof ResponsedGroupChatListCompleteMessage)) {
            return;
        }
        ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage = (ResponsedGroupChatListCompleteMessage) customResponsedMessage;
        int type = responsedGroupChatListCompleteMessage.getType();
        if (type != 1) {
            if (type != 2) {
                if (type != 3) {
                    if (type != 4) {
                        if (type == 5) {
                            v(responsedGroupChatListCompleteMessage);
                            return;
                        }
                        return;
                    }
                    u(responsedGroupChatListCompleteMessage);
                    return;
                }
                t(responsedGroupChatListCompleteMessage);
                return;
            }
            w(responsedGroupChatListCompleteMessage);
            return;
        }
        s(responsedGroupChatListCompleteMessage);
    }

    public final void I() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(InputDeviceCompat.SOURCE_TOUCHPAD, this) == null) {
            NewsRemindMessage newsRemindMessage = new NewsRemindMessage();
            newsRemindMessage.setMsgAgreeCount(this.b);
            newsRemindMessage.setMsgAtCount(this.c);
            newsRemindMessage.setMsgReplyCount(this.d);
            newsRemindMessage.setMsgFansCount(this.e);
            newsRemindMessage.setMsgCount(this.f);
            newsRemindMessage.setHasMsgRemind(this.g);
            newsRemindMessage.setChatCount(this.h);
            newsRemindMessage.setHasChatRemind(this.i);
            newsRemindMessage.setNotificationCount(this.k);
            MessageManager.getInstance().dispatchResponsedMessage(newsRemindMessage);
        }
    }

    public final void o(int i, int i2, int i3, int i4, int i5) {
        boolean z;
        int i6;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048586, this, new Object[]{Integer.valueOf(i), Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)}) == null) {
            boolean z2 = false;
            if (i <= 0 && i2 <= 0 && i3 <= 0 && i4 <= 0 && i5 <= 0) {
                z = false;
            } else {
                z = true;
            }
            if (i > 0) {
                i6 = i + 0;
            } else {
                i6 = 0;
            }
            if (i2 > 0) {
                i6 += i2;
            }
            if (i3 > 0) {
                i6 += i3;
            }
            if (i4 > 0) {
                i6 += i4;
            }
            if (i5 > 0 && !SharedPrefHelper.getInstance().getBoolean("key_question_msg_no_remind", false)) {
                i6 += i5;
            }
            if (ia5.e().g() == 0) {
                i6 = 0;
            }
            if (i6 > 0) {
                z2 = z;
            }
            this.g = z2;
            this.f = i6;
            this.b = i;
            this.c = i2;
            this.d = i3;
            this.e = i4;
            this.j = i5;
        }
    }

    public final boolean q(ImMessageCenterPojo imMessageCenterPojo) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048587, this, imMessageCenterPojo)) == null) {
            if (imMessageCenterPojo != null && imMessageCenterPojo.getIs_hidden() != 1 && ((!TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || !TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) && imMessageCenterPojo.getLast_content_time() != 0)) {
                if (imMessageCenterPojo.getCustomGroupType() == -4) {
                    return true;
                }
                if ((imMessageCenterPojo.getCustomGroupType() == 4 && imMessageCenterPojo.getUserType() == 4) || imMessageCenterPojo.getCustomGroupType() == -8 || imMessageCenterPojo.getCustomGroupType() == -7) {
                    return true;
                }
                if (imMessageCenterPojo.getCustomGroupType() == 2 && (imMessageCenterPojo.getIsFriend() == 1 || imMessageCenterPojo.getIsFriend() == 2 || 1 == imMessageCenterPojo.getShowOutOfStranger())) {
                    if (TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && TextUtils.isEmpty(imMessageCenterPojo.getNameShow())) {
                        return false;
                    }
                    return true;
                } else if (imMessageCenterPojo.getCustomGroupType() == 9 && imMessageCenterPojo.getIs_hidden() == 0 && (!TextUtils.isEmpty(imMessageCenterPojo.getNameShow()) || !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()))) {
                    return true;
                }
            }
            return false;
        }
        return invokeL.booleanValue;
    }

    public final void s(ResponsedGroupChatListCompleteMessage responsedGroupChatListCompleteMessage) {
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeL(1048588, this, responsedGroupChatListCompleteMessage) == null) && responsedGroupChatListCompleteMessage.getType() == 1) {
            List<ImMessageCenterPojo> listInfo = responsedGroupChatListCompleteMessage.getListInfo();
            if (ListUtils.isEmpty(listInfo)) {
                return;
            }
            for (ImMessageCenterPojo imMessageCenterPojo : listInfo) {
                if (imMessageCenterPojo != null) {
                    this.a.remove(imMessageCenterPojo.getGid());
                }
            }
            for (ImMessageCenterPojo imMessageCenterPojo2 : listInfo) {
                if (imMessageCenterPojo2 != null && q(imMessageCenterPojo2)) {
                    this.a.put(imMessageCenterPojo2.getGid(), imMessageCenterPojo2);
                }
            }
            n(this.a);
        }
    }

    public void x() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048593, this) == null) {
            H();
            MessageManager.getInstance().registerStickyMode(2921002);
            MessageManager.getInstance().registerListener(2001120, this.l);
            MessageManager.getInstance().registerListener(2016002, this.l);
            MessageManager.getInstance().registerListener(2016004, this.l);
            MessageManager.getInstance().registerListener(2016001, this.l);
            MessageManager.getInstance().registerListener(2016007, this.l);
            MessageManager.getInstance().registerListener(2016011, this.l);
            MessageManager.getInstance().registerListener(2016010, this.l);
            MessageManager.getInstance().registerListener(2008024, this.l);
            MessageManager.getInstance().registerListener(2921767, this.l);
            y();
        }
    }
}
