package com.baidu.tieba.dnsproxy.pbdata;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes3.dex */
public final class ConnectPointData extends Message {
    public static final List<DnsIpData> DEFAULT_DNS_IP_CONNECT_RATE = Collections.emptyList();
    public static final List<DnsIpData> DEFAULT_DNS_IP_SPEED_DATA = Collections.emptyList();
    public static final Long DEFAULT_LAST_CONNECT_RATE_UPDATE_TIME = 0L;
    public static final Long DEFAULT_LAST_SPEED_DATA_UPDATE_TIME = 0L;
    public static final String DEFAULT_NAME = "";
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

    private ConnectPointData(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.name == null) {
                this.name = "";
            } else {
                this.name = builder.name;
            }
            if (builder.dns_ip_connect_rate == null) {
                this.dns_ip_connect_rate = DEFAULT_DNS_IP_CONNECT_RATE;
            } else {
                this.dns_ip_connect_rate = immutableCopyOf(builder.dns_ip_connect_rate);
            }
            if (builder.dns_ip_speed_data == null) {
                this.dns_ip_speed_data = DEFAULT_DNS_IP_SPEED_DATA;
            } else {
                this.dns_ip_speed_data = immutableCopyOf(builder.dns_ip_speed_data);
            }
            if (builder.last_connect_rate_update_time == null) {
                this.last_connect_rate_update_time = DEFAULT_LAST_CONNECT_RATE_UPDATE_TIME;
            } else {
                this.last_connect_rate_update_time = builder.last_connect_rate_update_time;
            }
            if (builder.last_speed_data_update_time == null) {
                this.last_speed_data_update_time = DEFAULT_LAST_SPEED_DATA_UPDATE_TIME;
                return;
            } else {
                this.last_speed_data_update_time = builder.last_speed_data_update_time;
                return;
            }
        }
        this.name = builder.name;
        this.dns_ip_connect_rate = immutableCopyOf(builder.dns_ip_connect_rate);
        this.dns_ip_speed_data = immutableCopyOf(builder.dns_ip_speed_data);
        this.last_connect_rate_update_time = builder.last_connect_rate_update_time;
        this.last_speed_data_update_time = builder.last_speed_data_update_time;
    }

    /* loaded from: classes3.dex */
    public static final class Builder extends Message.Builder<ConnectPointData> {
        public List<DnsIpData> dns_ip_connect_rate;
        public List<DnsIpData> dns_ip_speed_data;
        public Long last_connect_rate_update_time;
        public Long last_speed_data_update_time;
        public String name;

        public Builder() {
        }

        public Builder(ConnectPointData connectPointData) {
            super(connectPointData);
            if (connectPointData != null) {
                this.name = connectPointData.name;
                this.dns_ip_connect_rate = ConnectPointData.copyOf(connectPointData.dns_ip_connect_rate);
                this.dns_ip_speed_data = ConnectPointData.copyOf(connectPointData.dns_ip_speed_data);
                this.last_connect_rate_update_time = connectPointData.last_connect_rate_update_time;
                this.last_speed_data_update_time = connectPointData.last_speed_data_update_time;
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public ConnectPointData build(boolean z) {
            return new ConnectPointData(this, z);
        }
    }
}
