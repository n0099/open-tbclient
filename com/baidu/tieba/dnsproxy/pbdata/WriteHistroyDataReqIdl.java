package com.baidu.tieba.dnsproxy.pbdata;

import com.squareup.wire.Message;
import com.squareup.wire.ProtoField;
import java.util.Collections;
import java.util.List;
/* loaded from: classes13.dex */
public final class WriteHistroyDataReqIdl extends Message {
    public static final List<ConnectPointData> DEFAULT_CONNECT_POINT_LIST = Collections.emptyList();
    @ProtoField(label = Message.Label.REPEATED, tag = 1)
    public final List<ConnectPointData> connect_point_list;

    private WriteHistroyDataReqIdl(Builder builder, boolean z) {
        super(builder);
        if (z) {
            if (builder.connect_point_list == null) {
                this.connect_point_list = DEFAULT_CONNECT_POINT_LIST;
                return;
            } else {
                this.connect_point_list = immutableCopyOf(builder.connect_point_list);
                return;
            }
        }
        this.connect_point_list = immutableCopyOf(builder.connect_point_list);
    }

    /* loaded from: classes13.dex */
    public static final class Builder extends Message.Builder<WriteHistroyDataReqIdl> {
        public List<ConnectPointData> connect_point_list;

        public Builder() {
        }

        public Builder(WriteHistroyDataReqIdl writeHistroyDataReqIdl) {
            super(writeHistroyDataReqIdl);
            if (writeHistroyDataReqIdl != null) {
                this.connect_point_list = WriteHistroyDataReqIdl.copyOf(writeHistroyDataReqIdl.connect_point_list);
            }
        }

        /* JADX DEBUG: Method merged with bridge method */
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.squareup.wire.Message.Builder
        public WriteHistroyDataReqIdl build(boolean z) {
            return new WriteHistroyDataReqIdl(this, z);
        }
    }
}
