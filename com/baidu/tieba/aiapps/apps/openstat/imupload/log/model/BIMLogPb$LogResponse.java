package com.baidu.tieba.aiapps.apps.openstat.imupload.log.model;

import com.google.protobuf.AbstractMessageLite;
import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.MessageLite;
import com.google.protobuf.MessageLiteOrBuilder;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes4.dex */
public final class BIMLogPb$LogResponse extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int ERROR_CODE_FIELD_NUMBER = 1;
    public static final int ERROR_MSG_FIELD_NUMBER = 2;
    public static Parser<BIMLogPb$LogResponse> PARSER = new a();
    public static final int PING_INTERVAL_MS_FIELD_NUMBER = 3;
    public static final BIMLogPb$LogResponse defaultInstance;
    public static final long serialVersionUID = 0;
    public int bitField0;
    public int errorCode;
    public Object errorMsg;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public long pingIntervalMs;

    /* loaded from: classes4.dex */
    public static class a extends AbstractParser<BIMLogPb$LogResponse> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public BIMLogPb$LogResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new BIMLogPb$LogResponse(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends GeneratedMessageLite.Builder<BIMLogPb$LogResponse, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f14689e;

        /* renamed from: f  reason: collision with root package name */
        public int f14690f;

        /* renamed from: g  reason: collision with root package name */
        public Object f14691g = "";

        /* renamed from: h  reason: collision with root package name */
        public long f14692h;

        public b() {
            maybeForceBuilderInitialization();
        }

        public static b q() {
            return new b();
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ GeneratedMessageLite.Builder clear() {
            o();
            return this;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            return true;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: m */
        public BIMLogPb$LogResponse build() {
            BIMLogPb$LogResponse buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public BIMLogPb$LogResponse buildPartial() {
            BIMLogPb$LogResponse bIMLogPb$LogResponse = new BIMLogPb$LogResponse(this);
            int i = this.f14689e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            bIMLogPb$LogResponse.errorCode = this.f14690f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bIMLogPb$LogResponse.errorMsg = this.f14691g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            bIMLogPb$LogResponse.pingIntervalMs = this.f14692h;
            bIMLogPb$LogResponse.bitField0 = i2;
            return bIMLogPb$LogResponse;
        }

        public b o() {
            super.clear();
            this.f14690f = 0;
            int i = this.f14689e & (-2);
            this.f14689e = i;
            this.f14691g = "";
            int i2 = i & (-3);
            this.f14689e = i2;
            this.f14692h = 0L;
            this.f14689e = i2 & (-5);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.s(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public BIMLogPb$LogResponse getDefaultInstanceForType() {
            return BIMLogPb$LogResponse.getDefaultInstance();
        }

        public b s(BIMLogPb$LogResponse bIMLogPb$LogResponse) {
            if (bIMLogPb$LogResponse == BIMLogPb$LogResponse.getDefaultInstance()) {
                return this;
            }
            if (bIMLogPb$LogResponse.hasErrorCode()) {
                u(bIMLogPb$LogResponse.getErrorCode());
            }
            if (bIMLogPb$LogResponse.hasErrorMsg()) {
                this.f14689e |= 2;
                this.f14691g = bIMLogPb$LogResponse.errorMsg;
            }
            if (bIMLogPb$LogResponse.hasPingIntervalMs()) {
                v(bIMLogPb$LogResponse.getPingIntervalMs());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            BIMLogPb$LogResponse bIMLogPb$LogResponse = null;
            try {
                try {
                    BIMLogPb$LogResponse parsePartialFrom = BIMLogPb$LogResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        s(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    BIMLogPb$LogResponse bIMLogPb$LogResponse2 = (BIMLogPb$LogResponse) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bIMLogPb$LogResponse = bIMLogPb$LogResponse2;
                        if (bIMLogPb$LogResponse != null) {
                            s(bIMLogPb$LogResponse);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bIMLogPb$LogResponse != null) {
                }
                throw th;
            }
        }

        public b u(int i) {
            this.f14689e |= 1;
            this.f14690f = i;
            return this;
        }

        public b v(long j) {
            this.f14689e |= 4;
            this.f14692h = j;
            return this;
        }

        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
            o();
            return this;
        }

        /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
        /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder
        public /* bridge */ /* synthetic */ b mergeFrom(BIMLogPb$LogResponse bIMLogPb$LogResponse) {
            s(bIMLogPb$LogResponse);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            t(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        BIMLogPb$LogResponse bIMLogPb$LogResponse = new BIMLogPb$LogResponse(true);
        defaultInstance = bIMLogPb$LogResponse;
        bIMLogPb$LogResponse.initFields();
    }

    public static BIMLogPb$LogResponse getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.errorCode = 0;
        this.errorMsg = "";
        this.pingIntervalMs = 0L;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static BIMLogPb$LogResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static BIMLogPb$LogResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public int getErrorCode() {
        return this.errorCode;
    }

    public String getErrorMsg() {
        Object obj = this.errorMsg;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.errorMsg = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getErrorMsgBytes() {
        Object obj = this.errorMsg;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.errorMsg = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<BIMLogPb$LogResponse> getParserForType() {
        return PARSER;
    }

    public long getPingIntervalMs() {
        return this.pingIntervalMs;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeInt32Size = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.errorCode) : 0;
        if ((this.bitField0 & 2) == 2) {
            computeInt32Size += CodedOutputStream.computeBytesSize(2, getErrorMsgBytes());
        }
        if ((this.bitField0 & 4) == 4) {
            computeInt32Size += CodedOutputStream.computeInt64Size(3, this.pingIntervalMs);
        }
        this.memoizedSerializedSize = computeInt32Size;
        return computeInt32Size;
    }

    public boolean hasErrorCode() {
        return (this.bitField0 & 1) == 1;
    }

    public boolean hasErrorMsg() {
        return (this.bitField0 & 2) == 2;
    }

    public boolean hasPingIntervalMs() {
        return (this.bitField0 & 4) == 4;
    }

    @Override // com.google.protobuf.MessageLiteOrBuilder
    public final boolean isInitialized() {
        byte b2 = this.memoizedIsInitialized;
        if (b2 != -1) {
            return b2 == 1;
        }
        this.memoizedIsInitialized = (byte) 1;
        return true;
    }

    @Override // com.google.protobuf.GeneratedMessageLite
    public Object writeReplace() throws ObjectStreamException {
        return super.writeReplace();
    }

    @Override // com.google.protobuf.MessageLite
    public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
        getSerializedSize();
        if ((this.bitField0 & 1) == 1) {
            codedOutputStream.writeInt32(1, this.errorCode);
        }
        if ((this.bitField0 & 2) == 2) {
            codedOutputStream.writeBytes(2, getErrorMsgBytes());
        }
        if ((this.bitField0 & 4) == 4) {
            codedOutputStream.writeInt64(3, this.pingIntervalMs);
        }
    }

    public static b newBuilder(BIMLogPb$LogResponse bIMLogPb$LogResponse) {
        b newBuilder = newBuilder();
        newBuilder.s(bIMLogPb$LogResponse);
        return newBuilder;
    }

    public static BIMLogPb$LogResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BIMLogPb$LogResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public BIMLogPb$LogResponse getDefaultInstanceForType() {
        return defaultInstance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b newBuilderForType() {
        return newBuilder();
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLite
    public b toBuilder() {
        return newBuilder(this);
    }

    public BIMLogPb$LogResponse(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static BIMLogPb$LogResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static BIMLogPb$LogResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static BIMLogPb$LogResponse parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public BIMLogPb$LogResponse(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static BIMLogPb$LogResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BIMLogPb$LogResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static BIMLogPb$LogResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public BIMLogPb$LogResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag == 8) {
                                this.bitField0 |= 1;
                                this.errorCode = codedInputStream.readInt32();
                            } else if (readTag == 18) {
                                this.bitField0 |= 2;
                                this.errorMsg = codedInputStream.readBytes();
                            } else if (readTag != 24) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0 |= 4;
                                this.pingIntervalMs = codedInputStream.readInt64();
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }
}
