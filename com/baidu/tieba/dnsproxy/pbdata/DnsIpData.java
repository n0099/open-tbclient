package com.baidu.tieba.dnsproxy.pbdata;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes5.dex */
public final class DnsIpData extends Message {
    public static final String DEFAULT_ADDRESS = "";
    public static final List<Integer> DEFAULT_DATA = Collections.emptyList();
    @ProtoField(tag = 1, type = Message.Datatype.STRING)
    public final String address;
    @ProtoField(label = Message.Label.REPEATED, tag = 2, type = Message.Datatype.UINT32)
    public final List<Integer> data;

    private DnsIpData(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.address == null) {
                this.address = "";
            } else {
                this.address = builder.address;
            }
            if (builder.data == null) {
                this.data = DEFAULT_DATA;
                return;
            } else {
                this.data = immutableCopyOf(builder.data);
                return;
            }
        }
        this.address = builder.address;
        this.data = immutableCopyOf(builder.data);
    }

    /* loaded from: classes5.dex */
    public static final class Builder extends Message.Builder<DnsIpData> {
        public String address;
        public List<Integer> data;

        public Builder() {
        }

        public Builder(DnsIpData dnsIpData) {
            super(dnsIpData);
            if (dnsIpData != null) {
                this.address = dnsIpData.address;
                this.data = DnsIpData.copyOf(dnsIpData.data);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public DnsIpData build(boolean z) {
            return new DnsIpData(this, z);
        }
    }
}
