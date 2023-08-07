package com.baidu.tbadk.module.frs;

import android.content.Context;
import com.baidu.pyramid.runtime.service.ServiceReference;
import com.baidu.tbadk.TbPageContext;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.util.Map;
import kotlin.Metadata;
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\bf\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J0\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\n0\tH&J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u000b\u001a\u00020\nH&J3\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u0012\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u0013J!\u0010\u0014\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\nH&¢\u0006\u0002\u0010\u0015¨\u0006\u0017"}, d2 = {"Lcom/baidu/tbadk/module/frs/FrsService;", "", "navToVoiceRoom", "", "tbPageContext", "Lcom/baidu/tbadk/TbPageContext;", "roomId", "", "extParams", "", "", "scheme", "navToVoiceRoomList", "context", "Landroid/content/Context;", "from", "Lcom/baidu/tbadk/module/frs/Frs$From;", "fid", "forumName", "(Landroid/content/Context;Lcom/baidu/tbadk/module/frs/Frs$From;Ljava/lang/Long;Ljava/lang/String;)V", "statStartRoomEvent", "(Ljava/lang/Long;Ljava/lang/String;)V", "Companion", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
/* loaded from: classes4.dex */
public interface FrsService {
    public static final Companion Companion = Companion.$$INSTANCE;
    public static final String NAME = "FrsService";

    void navToVoiceRoom(TbPageContext<?> tbPageContext, long j);

    void navToVoiceRoom(TbPageContext<?> tbPageContext, long j, Map<String, String> map);

    void navToVoiceRoom(TbPageContext<?> tbPageContext, String str);

    void navToVoiceRoomList(Context context, Frs$From frs$From, Long l, String str);

    void statStartRoomEvent(Long l, String str);

    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/baidu/tbadk/module/frs/FrsService$Companion;", "", "()V", "NAME", "", "serviceReference", "Lcom/baidu/pyramid/runtime/service/ServiceReference;", "getServiceReference", "()Lcom/baidu/pyramid/runtime/service/ServiceReference;", "tbadkcore_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
    /* loaded from: classes4.dex */
    public static final class Companion {
        public static final /* synthetic */ Companion $$INSTANCE;
        public static /* synthetic */ Interceptable $ic = null;
        public static final String NAME = "FrsService";
        public static final ServiceReference serviceReference;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1531444541, "Lcom/baidu/tbadk/module/frs/FrsService$Companion;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1531444541, "Lcom/baidu/tbadk/module/frs/FrsService$Companion;");
                    return;
                }
            }
            $$INSTANCE = new Companion();
            serviceReference = new ServiceReference("Frs", "FrsService");
        }

        public Companion() {
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

        public final ServiceReference getServiceReference() {
            InterceptResult invokeV;
            Interceptable interceptable = $ic;
            if (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) {
                return serviceReference;
            }
            return (ServiceReference) invokeV.objValue;
        }
    }
}
