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
public final class BIMLogPb$LogRequest extends GeneratedMessageLite implements MessageLiteOrBuilder {
    public static final int AUTH_INFO_FIELD_NUMBER = 3;
    public static Parser<BIMLogPb$LogRequest> PARSER = new a();
    public static final int PAYLOAD_FIELD_NUMBER = 6;
    public static final int REQUEST_TIMESTAMP_MS_FIELD_NUMBER = 4;
    public static final int SERVICE_NAME_FIELD_NUMBER = 2;
    public static final int SIGN_FIELD_NUMBER = 5;
    public static final int VERSION_FIELD_NUMBER = 1;
    public static final BIMLogPb$LogRequest defaultInstance;
    public static final long serialVersionUID = 0;
    public AuthInfo authInfo;
    public int bitField0;
    public byte memoizedIsInitialized;
    public int memoizedSerializedSize;
    public ByteString payload;
    public long requestTimestampMs;
    public Object serviceName;
    public Object sign;
    public long version;

    /* loaded from: classes4.dex */
    public static final class AuthInfo extends GeneratedMessageLite implements MessageLiteOrBuilder {
        public static Parser<AuthInfo> PARSER = new a();
        public static final int TOKEN_FIELD_NUMBER = 1;
        public static final AuthInfo defaultInstance;
        public static final long serialVersionUID = 0;
        public int bitField0;
        public byte memoizedIsInitialized;
        public int memoizedSerializedSize;
        public Object token;

        /* loaded from: classes4.dex */
        public static class a extends AbstractParser<AuthInfo> {
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: b */
            public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new AuthInfo(codedInputStream, extensionRegistryLite);
            }
        }

        /* loaded from: classes4.dex */
        public static final class b extends GeneratedMessageLite.Builder<AuthInfo, b> implements Object {

            /* renamed from: e  reason: collision with root package name */
            public int f14354e;

            /* renamed from: f  reason: collision with root package name */
            public Object f14355f = "";

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
            public AuthInfo build() {
                AuthInfo buildPartial = buildPartial();
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
            public AuthInfo buildPartial() {
                AuthInfo authInfo = new AuthInfo(this);
                int i = (this.f14354e & 1) != 1 ? 0 : 1;
                authInfo.token = this.f14355f;
                authInfo.bitField0 = i;
                return authInfo;
            }

            public b o() {
                super.clear();
                this.f14355f = "";
                this.f14354e &= -2;
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
            public AuthInfo getDefaultInstanceForType() {
                return AuthInfo.getDefaultInstance();
            }

            public b s(AuthInfo authInfo) {
                if (authInfo != AuthInfo.getDefaultInstance() && authInfo.hasToken()) {
                    this.f14354e |= 1;
                    this.f14355f = authInfo.token;
                }
                return this;
            }

            /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public b t(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                AuthInfo authInfo = null;
                try {
                    try {
                        AuthInfo parsePartialFrom = AuthInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            s(parsePartialFrom);
                        }
                        return this;
                    } catch (InvalidProtocolBufferException e2) {
                        AuthInfo authInfo2 = (AuthInfo) e2.getUnfinishedMessage();
                        try {
                            throw e2;
                        } catch (Throwable th) {
                            th = th;
                            authInfo = authInfo2;
                            if (authInfo != null) {
                                s(authInfo);
                            }
                            throw th;
                        }
                    }
                } catch (Throwable th2) {
                    th = th2;
                    if (authInfo != null) {
                    }
                    throw th;
                }
            }

            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder clear() {
                o();
                return this;
            }

            /* JADX DEBUG: Method arguments types fixed to match base method, original types: [com.google.protobuf.GeneratedMessageLite] */
            /* JADX DEBUG: Return type fixed from 'com.google.protobuf.GeneratedMessageLite$Builder' to match base method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            public /* bridge */ /* synthetic */ b mergeFrom(AuthInfo authInfo) {
                s(authInfo);
                return this;
            }

            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                t(codedInputStream, extensionRegistryLite);
                return this;
            }
        }

        static {
            AuthInfo authInfo = new AuthInfo(true);
            defaultInstance = authInfo;
            authInfo.initFields();
        }

        public static AuthInfo getDefaultInstance() {
            return defaultInstance;
        }

        private void initFields() {
            this.token = "";
        }

        public static b newBuilder() {
            return b.q();
        }

        public static AuthInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static AuthInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<AuthInfo> getParserForType() {
            return PARSER;
        }

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i != -1) {
                return i;
            }
            int computeBytesSize = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes()) : 0;
            this.memoizedSerializedSize = computeBytesSize;
            return computeBytesSize;
        }

        public String getToken() {
            Object obj = this.token;
            if (obj instanceof String) {
                return (String) obj;
            }
            ByteString byteString = (ByteString) obj;
            String stringUtf8 = byteString.toStringUtf8();
            if (byteString.isValidUtf8()) {
                this.token = stringUtf8;
            }
            return stringUtf8;
        }

        public ByteString getTokenBytes() {
            Object obj = this.token;
            if (obj instanceof String) {
                ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
                this.token = copyFromUtf8;
                return copyFromUtf8;
            }
            return (ByteString) obj;
        }

        public boolean hasToken() {
            return (this.bitField0 & 1) == 1;
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
                codedOutputStream.writeBytes(1, getTokenBytes());
            }
        }

        public static b newBuilder(AuthInfo authInfo) {
            b newBuilder = newBuilder();
            newBuilder.s(authInfo);
            return newBuilder;
        }

        public static AuthInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static AuthInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public AuthInfo getDefaultInstanceForType() {
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

        public AuthInfo(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AuthInfo parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static AuthInfo parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static AuthInfo parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public AuthInfo(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        public static AuthInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static AuthInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static AuthInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public AuthInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        if (readTag != 0) {
                            if (readTag != 10) {
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                }
                            } else {
                                this.bitField0 |= 1;
                                this.token = codedInputStream.readBytes();
                            }
                        }
                        z = true;
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    } catch (IOException e3) {
                        throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }
    }

    /* loaded from: classes4.dex */
    public static class a extends AbstractParser<BIMLogPb$LogRequest> {
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.Parser
        /* renamed from: b */
        public BIMLogPb$LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return new BIMLogPb$LogRequest(codedInputStream, extensionRegistryLite);
        }
    }

    /* loaded from: classes4.dex */
    public static final class b extends GeneratedMessageLite.Builder<BIMLogPb$LogRequest, b> implements Object {

        /* renamed from: e  reason: collision with root package name */
        public int f14356e;

        /* renamed from: f  reason: collision with root package name */
        public long f14357f;
        public long i;

        /* renamed from: g  reason: collision with root package name */
        public Object f14358g = "";

        /* renamed from: h  reason: collision with root package name */
        public AuthInfo f14359h = AuthInfo.getDefaultInstance();
        public Object j = "";
        public ByteString k = ByteString.EMPTY;

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
        public BIMLogPb$LogRequest build() {
            BIMLogPb$LogRequest buildPartial = buildPartial();
            if (buildPartial.isInitialized()) {
                return buildPartial;
            }
            throw AbstractMessageLite.Builder.newUninitializedMessageException(buildPartial);
        }

        public final void maybeForceBuilderInitialization() {
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ AbstractMessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite.Builder
        /* renamed from: n */
        public BIMLogPb$LogRequest buildPartial() {
            BIMLogPb$LogRequest bIMLogPb$LogRequest = new BIMLogPb$LogRequest(this);
            int i = this.f14356e;
            int i2 = (i & 1) != 1 ? 0 : 1;
            bIMLogPb$LogRequest.version = this.f14357f;
            if ((i & 2) == 2) {
                i2 |= 2;
            }
            bIMLogPb$LogRequest.serviceName = this.f14358g;
            if ((i & 4) == 4) {
                i2 |= 4;
            }
            bIMLogPb$LogRequest.authInfo = this.f14359h;
            if ((i & 8) == 8) {
                i2 |= 8;
            }
            bIMLogPb$LogRequest.requestTimestampMs = this.i;
            if ((i & 16) == 16) {
                i2 |= 16;
            }
            bIMLogPb$LogRequest.sign = this.j;
            if ((i & 32) == 32) {
                i2 |= 32;
            }
            bIMLogPb$LogRequest.payload = this.k;
            bIMLogPb$LogRequest.bitField0 = i2;
            return bIMLogPb$LogRequest;
        }

        public b o() {
            super.clear();
            this.f14357f = 0L;
            int i = this.f14356e & (-2);
            this.f14356e = i;
            this.f14358g = "";
            this.f14356e = i & (-3);
            this.f14359h = AuthInfo.getDefaultInstance();
            int i2 = this.f14356e & (-5);
            this.f14356e = i2;
            this.i = 0L;
            int i3 = i2 & (-9);
            this.f14356e = i3;
            this.j = "";
            int i4 = i3 & (-17);
            this.f14356e = i4;
            this.k = ByteString.EMPTY;
            this.f14356e = i4 & (-33);
            return this;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        /* renamed from: p */
        public b clone() {
            b q = q();
            q.t(buildPartial());
            return q;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
        /* renamed from: r */
        public BIMLogPb$LogRequest getDefaultInstanceForType() {
            return BIMLogPb$LogRequest.getDefaultInstance();
        }

        public b s(AuthInfo authInfo) {
            if ((this.f14356e & 4) == 4 && this.f14359h != AuthInfo.getDefaultInstance()) {
                AuthInfo.b newBuilder = AuthInfo.newBuilder(this.f14359h);
                newBuilder.s(authInfo);
                this.f14359h = newBuilder.buildPartial();
            } else {
                this.f14359h = authInfo;
            }
            this.f14356e |= 4;
            return this;
        }

        public b t(BIMLogPb$LogRequest bIMLogPb$LogRequest) {
            if (bIMLogPb$LogRequest == BIMLogPb$LogRequest.getDefaultInstance()) {
                return this;
            }
            if (bIMLogPb$LogRequest.hasVersion()) {
                x(bIMLogPb$LogRequest.getVersion());
            }
            if (bIMLogPb$LogRequest.hasServiceName()) {
                this.f14356e |= 2;
                this.f14358g = bIMLogPb$LogRequest.serviceName;
            }
            if (bIMLogPb$LogRequest.hasAuthInfo()) {
                s(bIMLogPb$LogRequest.getAuthInfo());
            }
            if (bIMLogPb$LogRequest.hasRequestTimestampMs()) {
                w(bIMLogPb$LogRequest.getRequestTimestampMs());
            }
            if (bIMLogPb$LogRequest.hasSign()) {
                this.f14356e |= 16;
                this.j = bIMLogPb$LogRequest.sign;
            }
            if (bIMLogPb$LogRequest.hasPayload()) {
                v(bIMLogPb$LogRequest.getPayload());
            }
            return this;
        }

        /* JADX WARN: Removed duplicated region for block: B:15:0x001d  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
        */
        public b u(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            BIMLogPb$LogRequest bIMLogPb$LogRequest = null;
            try {
                try {
                    BIMLogPb$LogRequest parsePartialFrom = BIMLogPb$LogRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                    if (parsePartialFrom != null) {
                        t(parsePartialFrom);
                    }
                    return this;
                } catch (InvalidProtocolBufferException e2) {
                    BIMLogPb$LogRequest bIMLogPb$LogRequest2 = (BIMLogPb$LogRequest) e2.getUnfinishedMessage();
                    try {
                        throw e2;
                    } catch (Throwable th) {
                        th = th;
                        bIMLogPb$LogRequest = bIMLogPb$LogRequest2;
                        if (bIMLogPb$LogRequest != null) {
                            t(bIMLogPb$LogRequest);
                        }
                        throw th;
                    }
                }
            } catch (Throwable th2) {
                th = th2;
                if (bIMLogPb$LogRequest != null) {
                }
                throw th;
            }
        }

        public b v(ByteString byteString) {
            if (byteString != null) {
                this.f14356e |= 32;
                this.k = byteString;
                return this;
            }
            throw null;
        }

        public b w(long j) {
            this.f14356e |= 8;
            this.i = j;
            return this;
        }

        public b x(long j) {
            this.f14356e |= 1;
            this.f14357f = j;
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
        public /* bridge */ /* synthetic */ b mergeFrom(BIMLogPb$LogRequest bIMLogPb$LogRequest) {
            t(bIMLogPb$LogRequest);
            return this;
        }

        @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
        public /* bridge */ /* synthetic */ MessageLite.Builder mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            u(codedInputStream, extensionRegistryLite);
            return this;
        }
    }

    static {
        BIMLogPb$LogRequest bIMLogPb$LogRequest = new BIMLogPb$LogRequest(true);
        defaultInstance = bIMLogPb$LogRequest;
        bIMLogPb$LogRequest.initFields();
    }

    public static BIMLogPb$LogRequest getDefaultInstance() {
        return defaultInstance;
    }

    private void initFields() {
        this.version = 0L;
        this.serviceName = "";
        this.authInfo = AuthInfo.getDefaultInstance();
        this.requestTimestampMs = 0L;
        this.sign = "";
        this.payload = ByteString.EMPTY;
    }

    public static b newBuilder() {
        return b.q();
    }

    public static BIMLogPb$LogRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream);
    }

    public static BIMLogPb$LogRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString);
    }

    public AuthInfo getAuthInfo() {
        return this.authInfo;
    }

    @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
    public Parser<BIMLogPb$LogRequest> getParserForType() {
        return PARSER;
    }

    public ByteString getPayload() {
        return this.payload;
    }

    public long getRequestTimestampMs() {
        return this.requestTimestampMs;
    }

    @Override // com.google.protobuf.MessageLite
    public int getSerializedSize() {
        int i = this.memoizedSerializedSize;
        if (i != -1) {
            return i;
        }
        int computeInt64Size = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.version) : 0;
        if ((this.bitField0 & 2) == 2) {
            computeInt64Size += CodedOutputStream.computeBytesSize(2, getServiceNameBytes());
        }
        if ((this.bitField0 & 4) == 4) {
            computeInt64Size += CodedOutputStream.computeMessageSize(3, this.authInfo);
        }
        if ((this.bitField0 & 8) == 8) {
            computeInt64Size += CodedOutputStream.computeInt64Size(4, this.requestTimestampMs);
        }
        if ((this.bitField0 & 16) == 16) {
            computeInt64Size += CodedOutputStream.computeBytesSize(5, getSignBytes());
        }
        if ((this.bitField0 & 32) == 32) {
            computeInt64Size += CodedOutputStream.computeBytesSize(6, this.payload);
        }
        this.memoizedSerializedSize = computeInt64Size;
        return computeInt64Size;
    }

    public String getServiceName() {
        Object obj = this.serviceName;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.serviceName = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getServiceNameBytes() {
        Object obj = this.serviceName;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.serviceName = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public String getSign() {
        Object obj = this.sign;
        if (obj instanceof String) {
            return (String) obj;
        }
        ByteString byteString = (ByteString) obj;
        String stringUtf8 = byteString.toStringUtf8();
        if (byteString.isValidUtf8()) {
            this.sign = stringUtf8;
        }
        return stringUtf8;
    }

    public ByteString getSignBytes() {
        Object obj = this.sign;
        if (obj instanceof String) {
            ByteString copyFromUtf8 = ByteString.copyFromUtf8((String) obj);
            this.sign = copyFromUtf8;
            return copyFromUtf8;
        }
        return (ByteString) obj;
    }

    public long getVersion() {
        return this.version;
    }

    public boolean hasAuthInfo() {
        return (this.bitField0 & 4) == 4;
    }

    public boolean hasPayload() {
        return (this.bitField0 & 32) == 32;
    }

    public boolean hasRequestTimestampMs() {
        return (this.bitField0 & 8) == 8;
    }

    public boolean hasServiceName() {
        return (this.bitField0 & 2) == 2;
    }

    public boolean hasSign() {
        return (this.bitField0 & 16) == 16;
    }

    public boolean hasVersion() {
        return (this.bitField0 & 1) == 1;
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
            codedOutputStream.writeInt64(1, this.version);
        }
        if ((this.bitField0 & 2) == 2) {
            codedOutputStream.writeBytes(2, getServiceNameBytes());
        }
        if ((this.bitField0 & 4) == 4) {
            codedOutputStream.writeMessage(3, this.authInfo);
        }
        if ((this.bitField0 & 8) == 8) {
            codedOutputStream.writeInt64(4, this.requestTimestampMs);
        }
        if ((this.bitField0 & 16) == 16) {
            codedOutputStream.writeBytes(5, getSignBytes());
        }
        if ((this.bitField0 & 32) == 32) {
            codedOutputStream.writeBytes(6, this.payload);
        }
    }

    public static b newBuilder(BIMLogPb$LogRequest bIMLogPb$LogRequest) {
        b newBuilder = newBuilder();
        newBuilder.t(bIMLogPb$LogRequest);
        return newBuilder;
    }

    public static BIMLogPb$LogRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
    }

    public static BIMLogPb$LogRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(byteString, extensionRegistryLite);
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.google.protobuf.MessageLiteOrBuilder
    public BIMLogPb$LogRequest getDefaultInstanceForType() {
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

    public BIMLogPb$LogRequest(GeneratedMessageLite.Builder builder) {
        super(builder);
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static BIMLogPb$LogRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr);
    }

    public static BIMLogPb$LogRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        return PARSER.parseFrom(bArr, extensionRegistryLite);
    }

    public static BIMLogPb$LogRequest parseFrom(InputStream inputStream) throws IOException {
        return PARSER.parseFrom(inputStream);
    }

    public BIMLogPb$LogRequest(boolean z) {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
    }

    public static BIMLogPb$LogRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(inputStream, extensionRegistryLite);
    }

    public static BIMLogPb$LogRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
        return PARSER.parseFrom(codedInputStream);
    }

    public static BIMLogPb$LogRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
        return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
    }

    public BIMLogPb$LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
        this.memoizedIsInitialized = (byte) -1;
        this.memoizedSerializedSize = -1;
        initFields();
        boolean z = false;
        while (!z) {
            try {
                try {
                    int readTag = codedInputStream.readTag();
                    if (readTag != 0) {
                        if (readTag == 8) {
                            this.bitField0 |= 1;
                            this.version = codedInputStream.readInt64();
                        } else if (readTag == 18) {
                            this.bitField0 |= 2;
                            this.serviceName = codedInputStream.readBytes();
                        } else if (readTag == 26) {
                            AuthInfo.b builder = (this.bitField0 & 4) == 4 ? this.authInfo.toBuilder() : null;
                            AuthInfo authInfo = (AuthInfo) codedInputStream.readMessage(AuthInfo.PARSER, extensionRegistryLite);
                            this.authInfo = authInfo;
                            if (builder != null) {
                                builder.s(authInfo);
                                this.authInfo = builder.buildPartial();
                            }
                            this.bitField0 |= 4;
                        } else if (readTag == 32) {
                            this.bitField0 |= 8;
                            this.requestTimestampMs = codedInputStream.readInt64();
                        } else if (readTag == 42) {
                            this.bitField0 |= 16;
                            this.sign = codedInputStream.readBytes();
                        } else if (readTag != 50) {
                            if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                            }
                        } else {
                            this.bitField0 |= 32;
                            this.payload = codedInputStream.readBytes();
                        }
                    }
                    z = true;
                } catch (InvalidProtocolBufferException e2) {
                    throw e2.setUnfinishedMessage(this);
                } catch (IOException e3) {
                    throw new InvalidProtocolBufferException(e3.getMessage()).setUnfinishedMessage(this);
                }
            } finally {
                makeExtensionsImmutable();
            }
        }
    }
}
