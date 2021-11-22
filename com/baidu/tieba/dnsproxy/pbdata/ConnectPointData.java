package com.baidu.tieba.dnsproxy.pbdata;

import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes8.dex */
public final class ConnectPointData extends Message {
    public static /* synthetic */ Interceptable $ic = null;
    public static final List<DnsIpData> DEFAULT_DNS_IP_CONNECT_RATE;
    public static final List<DnsIpData> DEFAULT_DNS_IP_SPEED_DATA;
    public static final Long DEFAULT_LAST_CONNECT_RATE_UPDATE_TIME;
    public static final Long DEFAULT_LAST_SPEED_DATA_UPDATE_TIME;
    public static final String DEFAULT_NAME = "";
    public transient /* synthetic */ FieldHolder $fh;
    @ProtoField(label = Message.Label.REPEATED, tag = 2)
    public final List<DnsIpData> dns_ip_connect_rate;
    @ProtoField(label = Message.Label.REPEATED, tag = 3)
    public final List<DnsIpData> dns_ip_speed_data;
    @ProtoField(tag = 4, type = Message.Datatype.UINT64)
    public final Long last_connect_rate_update_time;
    @ProtoField(tag = 5, type = Message.Datatype.UINT64)
    public final Long last_speed_data_update_time;
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String name;

    /* loaded from: classes8.dex */
    public static final class Builder extends Message.Builder<ConnectPointData> {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
        public List<DnsIpData> dns_ip_connect_rate;
        public List<DnsIpData> dns_ip_speed_data;
        public Long last_connect_rate_update_time;
        public Long last_speed_data_update_time;
        public String name;

        public Builder() {
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                interceptable.invokeUnInit(65536, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65536, newInitContext);
                }
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public Builder(ConnectPointData connectPointData) {
            super(connectPointData);
            Interceptable interceptable = $ic;
            if (interceptable != null) {
                InitContext newInitContext = TitanRuntime.newInitContext();
                newInitContext.initArgs = r2;
                Object[] objArr = {connectPointData};
                interceptable.invokeUnInit(65537, newInitContext);
                int i2 = newInitContext.flag;
                if ((i2 & 1) != 0) {
                    int i3 = i2 & 2;
                    super((Message) newInitContext.callArgs[0]);
                    newInitContext.thisArg = this;
                    interceptable.invokeInitBody(65537, newInitContext);
                    return;
                }
            }
            if (connectPointData == null) {
                return;
            }
            this.name = connectPointData.name;
            this.dns_ip_connect_rate = Message.copyOf(connectPointData.dns_ip_connect_rate);
            this.dns_ip_speed_data = Message.copyOf(connectPointData.dns_ip_speed_data);
            this.last_connect_rate_update_time = connectPointData.last_connect_rate_update_time;
            this.last_speed_data_update_time = connectPointData.last_speed_data_update_time;
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public ConnectPointData build(boolean z) {
            InterceptResult invokeZ;
            Interceptable interceptable = $ic;
            return (interceptable == null || (invokeZ = interceptable.invokeZ(1048576, this, z)) == null) ? new ConnectPointData(this, z, null) : (ConnectPointData) invokeZ.objValue;
        }
    }

    /* loaded from: classes8.dex */
    public static /* synthetic */ class a {
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1657824180, "Lcom/baidu/tieba/dnsproxy/pbdata/ConnectPointData;")) != null) {
            Interceptable interceptable = invokeClinit.interceptor;
            if (interceptable != null) {
                $ic = interceptable;
            }
            if ((invokeClinit.flags & 1) != 0) {
                classClinitInterceptable.invokePostClinit(1657824180, "Lcom/baidu/tieba/dnsproxy/pbdata/ConnectPointData;");
                return;
            }
        }
        DEFAULT_DNS_IP_CONNECT_RATE = Collections.emptyList();
        DEFAULT_DNS_IP_SPEED_DATA = Collections.emptyList();
        DEFAULT_LAST_CONNECT_RATE_UPDATE_TIME = 0L;
        DEFAULT_LAST_SPEED_DATA_UPDATE_TIME = 0L;
    }

    public /* synthetic */ ConnectPointData(Builder builder, boolean z, a aVar) {
        this(builder, z);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ConnectPointData(Builder builder, boolean z) {
        super(builder);
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {builder, Boolean.valueOf(z)};
            interceptable.invokeUnInit(65537, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                super((Message.Builder) newInitContext.callArgs[0]);
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        if (z) {
            String str = builder.name;
            if (str == null) {
                this.name = "";
            } else {
                this.name = str;
            }
            List<DnsIpData> list = builder.dns_ip_connect_rate;
            if (list == null) {
                this.dns_ip_connect_rate = DEFAULT_DNS_IP_CONNECT_RATE;
            } else {
                this.dns_ip_connect_rate = Message.immutableCopyOf(list);
            }
            List<DnsIpData> list2 = builder.dns_ip_speed_data;
            if (list2 == null) {
                this.dns_ip_speed_data = DEFAULT_DNS_IP_SPEED_DATA;
            } else {
                this.dns_ip_speed_data = Message.immutableCopyOf(list2);
            }
            Long l = builder.last_connect_rate_update_time;
            if (l == null) {
                this.last_connect_rate_update_time = DEFAULT_LAST_CONNECT_RATE_UPDATE_TIME;
            } else {
                this.last_connect_rate_update_time = l;
            }
            Long l2 = builder.last_speed_data_update_time;
            if (l2 == null) {
                this.last_speed_data_update_time = DEFAULT_LAST_SPEED_DATA_UPDATE_TIME;
                return;
            } else {
                this.last_speed_data_update_time = l2;
                return;
            }
        }
        this.name = builder.name;
        this.dns_ip_connect_rate = Message.immutableCopyOf(builder.dns_ip_connect_rate);
        this.dns_ip_speed_data = Message.immutableCopyOf(builder.dns_ip_speed_data);
        this.last_connect_rate_update_time = builder.last_connect_rate_update_time;
        this.last_speed_data_update_time = builder.last_speed_data_update_time;
    }
}
