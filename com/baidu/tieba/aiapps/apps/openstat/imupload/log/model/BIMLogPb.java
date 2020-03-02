package com.baidu.tieba.aiapps.apps.openstat.imupload.log.model;

import com.google.protobuf.AbstractParser;
import com.google.protobuf.ByteString;
import com.google.protobuf.CodedInputStream;
import com.google.protobuf.CodedOutputStream;
import com.google.protobuf.ExtensionRegistryLite;
import com.google.protobuf.GeneratedMessageLite;
import com.google.protobuf.InvalidProtocolBufferException;
import com.google.protobuf.Parser;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectStreamException;
/* loaded from: classes12.dex */
public final class BIMLogPb {

    /* loaded from: classes12.dex */
    public static final class LogRequest extends GeneratedMessageLite implements b {
        public static final int AUTH_INFO_FIELD_NUMBER = 3;
        public static final int PAYLOAD_FIELD_NUMBER = 6;
        public static final int REQUEST_TIMESTAMP_MS_FIELD_NUMBER = 4;
        public static final int SERVICE_NAME_FIELD_NUMBER = 2;
        public static final int SIGN_FIELD_NUMBER = 5;
        public static final int VERSION_FIELD_NUMBER = 1;
        private static final long serialVersionUID = 0;
        private AuthInfo authInfo;
        private int bitField0;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private ByteString payload;
        private long requestTimestampMs;
        private Object serviceName;
        private Object sign;
        private long version;
        public static Parser<LogRequest> PARSER = new AbstractParser<LogRequest>() { // from class: com.baidu.tieba.aiapps.apps.openstat.imupload.log.model.BIMLogPb.LogRequest.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: s */
            public LogRequest parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogRequest(codedInputStream, extensionRegistryLite);
            }
        };
        private static final LogRequest defaultInstance = new LogRequest(true);

        public static LogRequest getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LogRequest getDefaultInstanceForType() {
            return defaultInstance;
        }

        private LogRequest(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private LogRequest(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private LogRequest(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            boolean z;
            AuthInfo.a aVar;
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z2 = false;
            while (!z2) {
                try {
                    try {
                        int readTag = codedInputStream.readTag();
                        switch (readTag) {
                            case 0:
                                z = true;
                                continue;
                                z2 = z;
                            case 8:
                                this.bitField0 |= 1;
                                this.version = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 18:
                                this.bitField0 |= 2;
                                this.serviceName = codedInputStream.readBytes();
                                z = z2;
                                continue;
                                z2 = z;
                            case 26:
                                if ((this.bitField0 & 4) != 4) {
                                    aVar = null;
                                } else {
                                    aVar = this.authInfo.toBuilder();
                                }
                                this.authInfo = (AuthInfo) codedInputStream.readMessage(AuthInfo.PARSER, extensionRegistryLite);
                                if (aVar != null) {
                                    aVar.mergeFrom(this.authInfo);
                                    this.authInfo = aVar.buildPartial();
                                }
                                this.bitField0 |= 4;
                                z = z2;
                                continue;
                                z2 = z;
                            case 32:
                                this.bitField0 |= 8;
                                this.requestTimestampMs = codedInputStream.readInt64();
                                z = z2;
                                continue;
                                z2 = z;
                            case 42:
                                this.bitField0 |= 16;
                                this.sign = codedInputStream.readBytes();
                                z = z2;
                                continue;
                                z2 = z;
                            case 50:
                                this.bitField0 |= 32;
                                this.payload = codedInputStream.readBytes();
                                break;
                            default:
                                if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                    z = true;
                                    continue;
                                    z2 = z;
                                }
                                break;
                        }
                        z = z2;
                        z2 = z;
                    } catch (InvalidProtocolBufferException e) {
                        throw e.setUnfinishedMessage(this);
                    } catch (IOException e2) {
                        throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LogRequest> getParserForType() {
            return PARSER;
        }

        /* loaded from: classes12.dex */
        public static final class AuthInfo extends GeneratedMessageLite implements com.baidu.tieba.aiapps.apps.openstat.imupload.log.model.a {
            public static final int TOKEN_FIELD_NUMBER = 1;
            private static final long serialVersionUID = 0;
            private int bitField0;
            private byte memoizedIsInitialized;
            private int memoizedSerializedSize;
            private Object token;
            public static Parser<AuthInfo> PARSER = new AbstractParser<AuthInfo>() { // from class: com.baidu.tieba.aiapps.apps.openstat.imupload.log.model.BIMLogPb.LogRequest.AuthInfo.1
                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.Parser
                /* renamed from: t */
                public AuthInfo parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                    return new AuthInfo(codedInputStream, extensionRegistryLite);
                }
            };
            private static final AuthInfo defaultInstance = new AuthInfo(true);

            public static AuthInfo getDefaultInstance() {
                return defaultInstance;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLiteOrBuilder
            public AuthInfo getDefaultInstanceForType() {
                return defaultInstance;
            }

            private AuthInfo(GeneratedMessageLite.Builder builder) {
                super(builder);
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            private AuthInfo(boolean z) {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
            }

            private AuthInfo(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                this.memoizedIsInitialized = (byte) -1;
                this.memoizedSerializedSize = -1;
                initFields();
                boolean z = false;
                while (!z) {
                    try {
                        try {
                            try {
                                int readTag = codedInputStream.readTag();
                                switch (readTag) {
                                    case 0:
                                        z = true;
                                        break;
                                    case 10:
                                        this.bitField0 |= 1;
                                        this.token = codedInputStream.readBytes();
                                        break;
                                    default:
                                        if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                            z = true;
                                            break;
                                        } else {
                                            break;
                                        }
                                }
                            } catch (InvalidProtocolBufferException e) {
                                throw e.setUnfinishedMessage(this);
                            }
                        } catch (IOException e2) {
                            throw new InvalidProtocolBufferException(e2.getMessage()).setUnfinishedMessage(this);
                        }
                    } finally {
                        makeExtensionsImmutable();
                    }
                }
            }

            static {
                defaultInstance.initFields();
            }

            @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
            public Parser<AuthInfo> getParserForType() {
                return PARSER;
            }

            public boolean hasToken() {
                return (this.bitField0 & 1) == 1;
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

            private void initFields() {
                this.token = "";
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                byte b = this.memoizedIsInitialized;
                if (b != -1) {
                    return b == 1;
                }
                this.memoizedIsInitialized = (byte) 1;
                return true;
            }

            @Override // com.google.protobuf.MessageLite
            public void writeTo(CodedOutputStream codedOutputStream) throws IOException {
                getSerializedSize();
                if ((this.bitField0 & 1) == 1) {
                    codedOutputStream.writeBytes(1, getTokenBytes());
                }
            }

            @Override // com.google.protobuf.MessageLite
            public int getSerializedSize() {
                int i = this.memoizedSerializedSize;
                if (i == -1) {
                    i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeBytesSize(1, getTokenBytes()) : 0;
                    this.memoizedSerializedSize = i;
                }
                return i;
            }

            /* JADX INFO: Access modifiers changed from: protected */
            @Override // com.google.protobuf.GeneratedMessageLite
            public Object writeReplace() throws ObjectStreamException {
                return super.writeReplace();
            }

            public static AuthInfo parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString);
            }

            public static AuthInfo parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return PARSER.parseFrom(byteString, extensionRegistryLite);
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

            public static AuthInfo parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(inputStream, extensionRegistryLite);
            }

            public static AuthInfo parseFrom(CodedInputStream codedInputStream) throws IOException {
                return PARSER.parseFrom(codedInputStream);
            }

            public static AuthInfo parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
            }

            public static AuthInfo parseDelimitedFrom(InputStream inputStream) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream);
            }

            public static AuthInfo parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
            }

            public static a newBuilder() {
                return a.baK();
            }

            public static a newBuilder(AuthInfo authInfo) {
                return newBuilder().mergeFrom(authInfo);
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            public a newBuilderForType() {
                return newBuilder();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite
            public a toBuilder() {
                return newBuilder(this);
            }

            /* loaded from: classes12.dex */
            public static final class a extends GeneratedMessageLite.Builder<AuthInfo, a> implements com.baidu.tieba.aiapps.apps.openstat.imupload.log.model.a {
                private int bitField0;
                private Object token = "";

                private a() {
                    maybeForceBuilderInitialization();
                }

                private void maybeForceBuilderInitialization() {
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static a baK() {
                    return new a();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: baL */
                public a clear() {
                    super.clear();
                    this.token = "";
                    this.bitField0 &= -2;
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: baM */
                public a clone() {
                    return baK().mergeFrom(buildPartial());
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
                public AuthInfo getDefaultInstanceForType() {
                    return AuthInfo.getDefaultInstance();
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: baN */
                public AuthInfo build() {
                    AuthInfo buildPartial = buildPartial();
                    if (!buildPartial.isInitialized()) {
                        throw newUninitializedMessageException(buildPartial);
                    }
                    return buildPartial;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.MessageLite.Builder
                /* renamed from: baO */
                public AuthInfo buildPartial() {
                    AuthInfo authInfo = new AuthInfo(this);
                    int i = (this.bitField0 & 1) != 1 ? 0 : 1;
                    authInfo.token = this.token;
                    authInfo.bitField0 = i;
                    return authInfo;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.google.protobuf.GeneratedMessageLite.Builder
                /* renamed from: a */
                public a mergeFrom(AuthInfo authInfo) {
                    if (authInfo != AuthInfo.getDefaultInstance() && authInfo.hasToken()) {
                        this.bitField0 |= 1;
                        this.token = authInfo.token;
                    }
                    return this;
                }

                /* JADX DEBUG: Method merged with bridge method */
                /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
                @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
                /* renamed from: u */
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                    AuthInfo authInfo;
                    Throwable th;
                    try {
                        try {
                            AuthInfo parsePartialFrom = AuthInfo.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                            if (parsePartialFrom != null) {
                                mergeFrom(parsePartialFrom);
                            }
                            return this;
                        } catch (Throwable th2) {
                            th = th2;
                            authInfo = null;
                            if (authInfo != null) {
                                mergeFrom(authInfo);
                            }
                            throw th;
                        }
                    } catch (InvalidProtocolBufferException e) {
                        AuthInfo authInfo2 = (AuthInfo) e.getUnfinishedMessage();
                        try {
                            throw e;
                        } catch (Throwable th3) {
                            authInfo = authInfo2;
                            th = th3;
                            if (authInfo != null) {
                            }
                            throw th;
                        }
                    }
                }

                @Override // com.google.protobuf.MessageLiteOrBuilder
                public final boolean isInitialized() {
                    return true;
                }
            }
        }

        public boolean hasVersion() {
            return (this.bitField0 & 1) == 1;
        }

        public long getVersion() {
            return this.version;
        }

        public boolean hasServiceName() {
            return (this.bitField0 & 2) == 2;
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

        public boolean hasAuthInfo() {
            return (this.bitField0 & 4) == 4;
        }

        public AuthInfo getAuthInfo() {
            return this.authInfo;
        }

        public boolean hasRequestTimestampMs() {
            return (this.bitField0 & 8) == 8;
        }

        public long getRequestTimestampMs() {
            return this.requestTimestampMs;
        }

        public boolean hasSign() {
            return (this.bitField0 & 16) == 16;
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

        public boolean hasPayload() {
            return (this.bitField0 & 32) == 32;
        }

        public ByteString getPayload() {
            return this.payload;
        }

        private void initFields() {
            this.version = 0L;
            this.serviceName = "";
            this.authInfo = AuthInfo.getDefaultInstance();
            this.requestTimestampMs = 0L;
            this.sign = "";
            this.payload = ByteString.EMPTY;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt64Size(1, this.version) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getServiceNameBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeMessageSize(3, this.authInfo);
                }
                if ((this.bitField0 & 8) == 8) {
                    i += CodedOutputStream.computeInt64Size(4, this.requestTimestampMs);
                }
                if ((this.bitField0 & 16) == 16) {
                    i += CodedOutputStream.computeBytesSize(5, getSignBytes());
                }
                if ((this.bitField0 & 32) == 32) {
                    i += CodedOutputStream.computeBytesSize(6, this.payload);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LogRequest parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LogRequest parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LogRequest parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LogRequest parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LogRequest parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static LogRequest parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LogRequest parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LogRequest parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static LogRequest parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LogRequest parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.baQ();
        }

        public static a newBuilder(LogRequest logRequest) {
            return newBuilder().mergeFrom(logRequest);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes12.dex */
        public static final class a extends GeneratedMessageLite.Builder<LogRequest, a> implements b {
            private int bitField0;
            private long requestTimestampMs;
            private long version;
            private Object serviceName = "";
            private AuthInfo authInfo = AuthInfo.getDefaultInstance();
            private Object sign = "";
            private ByteString payload = ByteString.EMPTY;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a baQ() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: baR */
            public a clear() {
                super.clear();
                this.version = 0L;
                this.bitField0 &= -2;
                this.serviceName = "";
                this.bitField0 &= -3;
                this.authInfo = AuthInfo.getDefaultInstance();
                this.bitField0 &= -5;
                this.requestTimestampMs = 0L;
                this.bitField0 &= -9;
                this.sign = "";
                this.bitField0 &= -17;
                this.payload = ByteString.EMPTY;
                this.bitField0 &= -33;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: baS */
            public a clone() {
                return baQ().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LogRequest getDefaultInstanceForType() {
                return LogRequest.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: baT */
            public LogRequest build() {
                LogRequest buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: baU */
            public LogRequest buildPartial() {
                LogRequest logRequest = new LogRequest(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                logRequest.version = this.version;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                logRequest.serviceName = this.serviceName;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                logRequest.authInfo = this.authInfo;
                if ((i & 8) == 8) {
                    i2 |= 8;
                }
                logRequest.requestTimestampMs = this.requestTimestampMs;
                if ((i & 16) == 16) {
                    i2 |= 16;
                }
                logRequest.sign = this.sign;
                if ((i & 32) == 32) {
                    i2 |= 32;
                }
                logRequest.payload = this.payload;
                logRequest.bitField0 = i2;
                return logRequest;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(LogRequest logRequest) {
                if (logRequest != LogRequest.getDefaultInstance()) {
                    if (logRequest.hasVersion()) {
                        cz(logRequest.getVersion());
                    }
                    if (logRequest.hasServiceName()) {
                        this.bitField0 |= 2;
                        this.serviceName = logRequest.serviceName;
                    }
                    if (logRequest.hasAuthInfo()) {
                        b(logRequest.getAuthInfo());
                    }
                    if (logRequest.hasRequestTimestampMs()) {
                        cA(logRequest.getRequestTimestampMs());
                    }
                    if (logRequest.hasSign()) {
                        this.bitField0 |= 16;
                        this.sign = logRequest.sign;
                    }
                    if (logRequest.hasPayload()) {
                        j(logRequest.getPayload());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: v */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LogRequest logRequest;
                Throwable th;
                try {
                    try {
                        LogRequest parsePartialFrom = LogRequest.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        logRequest = null;
                        if (logRequest != null) {
                            mergeFrom(logRequest);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    LogRequest logRequest2 = (LogRequest) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        logRequest = logRequest2;
                        th = th3;
                        if (logRequest != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public a cz(long j) {
                this.bitField0 |= 1;
                this.version = j;
                return this;
            }

            public a b(AuthInfo authInfo) {
                if ((this.bitField0 & 4) == 4 && this.authInfo != AuthInfo.getDefaultInstance()) {
                    this.authInfo = AuthInfo.newBuilder(this.authInfo).mergeFrom(authInfo).buildPartial();
                } else {
                    this.authInfo = authInfo;
                }
                this.bitField0 |= 4;
                return this;
            }

            public a cA(long j) {
                this.bitField0 |= 8;
                this.requestTimestampMs = j;
                return this;
            }

            public a j(ByteString byteString) {
                if (byteString == null) {
                    throw new NullPointerException();
                }
                this.bitField0 |= 32;
                this.payload = byteString;
                return this;
            }
        }
    }

    /* loaded from: classes12.dex */
    public static final class LogResponse extends GeneratedMessageLite implements c {
        public static final int ERROR_CODE_FIELD_NUMBER = 1;
        public static final int ERROR_MSG_FIELD_NUMBER = 2;
        public static final int PING_INTERVAL_MS_FIELD_NUMBER = 3;
        private static final long serialVersionUID = 0;
        private int bitField0;
        private int errorCode;
        private Object errorMsg;
        private byte memoizedIsInitialized;
        private int memoizedSerializedSize;
        private long pingIntervalMs;
        public static Parser<LogResponse> PARSER = new AbstractParser<LogResponse>() { // from class: com.baidu.tieba.aiapps.apps.openstat.imupload.log.model.BIMLogPb.LogResponse.1
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.Parser
            /* renamed from: w */
            public LogResponse parsePartialFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
                return new LogResponse(codedInputStream, extensionRegistryLite);
            }
        };
        private static final LogResponse defaultInstance = new LogResponse(true);

        public static LogResponse getDefaultInstance() {
            return defaultInstance;
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLiteOrBuilder
        public LogResponse getDefaultInstanceForType() {
            return defaultInstance;
        }

        private LogResponse(GeneratedMessageLite.Builder builder) {
            super(builder);
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private LogResponse(boolean z) {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
        }

        private LogResponse(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            this.memoizedIsInitialized = (byte) -1;
            this.memoizedSerializedSize = -1;
            initFields();
            boolean z = false;
            while (!z) {
                try {
                    try {
                        try {
                            int readTag = codedInputStream.readTag();
                            switch (readTag) {
                                case 0:
                                    z = true;
                                    break;
                                case 8:
                                    this.bitField0 |= 1;
                                    this.errorCode = codedInputStream.readInt32();
                                    break;
                                case 18:
                                    this.bitField0 |= 2;
                                    this.errorMsg = codedInputStream.readBytes();
                                    break;
                                case 24:
                                    this.bitField0 |= 4;
                                    this.pingIntervalMs = codedInputStream.readInt64();
                                    break;
                                default:
                                    if (!parseUnknownField(codedInputStream, extensionRegistryLite, readTag)) {
                                        z = true;
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        } catch (IOException e) {
                            throw new InvalidProtocolBufferException(e.getMessage()).setUnfinishedMessage(this);
                        }
                    } catch (InvalidProtocolBufferException e2) {
                        throw e2.setUnfinishedMessage(this);
                    }
                } finally {
                    makeExtensionsImmutable();
                }
            }
        }

        static {
            defaultInstance.initFields();
        }

        @Override // com.google.protobuf.GeneratedMessageLite, com.google.protobuf.MessageLite
        public Parser<LogResponse> getParserForType() {
            return PARSER;
        }

        public boolean hasErrorCode() {
            return (this.bitField0 & 1) == 1;
        }

        public int getErrorCode() {
            return this.errorCode;
        }

        public boolean hasErrorMsg() {
            return (this.bitField0 & 2) == 2;
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

        public boolean hasPingIntervalMs() {
            return (this.bitField0 & 4) == 4;
        }

        public long getPingIntervalMs() {
            return this.pingIntervalMs;
        }

        private void initFields() {
            this.errorCode = 0;
            this.errorMsg = "";
            this.pingIntervalMs = 0L;
        }

        @Override // com.google.protobuf.MessageLiteOrBuilder
        public final boolean isInitialized() {
            byte b = this.memoizedIsInitialized;
            if (b != -1) {
                return b == 1;
            }
            this.memoizedIsInitialized = (byte) 1;
            return true;
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

        @Override // com.google.protobuf.MessageLite
        public int getSerializedSize() {
            int i = this.memoizedSerializedSize;
            if (i == -1) {
                i = (this.bitField0 & 1) == 1 ? 0 + CodedOutputStream.computeInt32Size(1, this.errorCode) : 0;
                if ((this.bitField0 & 2) == 2) {
                    i += CodedOutputStream.computeBytesSize(2, getErrorMsgBytes());
                }
                if ((this.bitField0 & 4) == 4) {
                    i += CodedOutputStream.computeInt64Size(3, this.pingIntervalMs);
                }
                this.memoizedSerializedSize = i;
            }
            return i;
        }

        /* JADX INFO: Access modifiers changed from: protected */
        @Override // com.google.protobuf.GeneratedMessageLite
        public Object writeReplace() throws ObjectStreamException {
            return super.writeReplace();
        }

        public static LogResponse parseFrom(ByteString byteString) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString);
        }

        public static LogResponse parseFrom(ByteString byteString, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(byteString, extensionRegistryLite);
        }

        public static LogResponse parseFrom(byte[] bArr) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr);
        }

        public static LogResponse parseFrom(byte[] bArr, ExtensionRegistryLite extensionRegistryLite) throws InvalidProtocolBufferException {
            return PARSER.parseFrom(bArr, extensionRegistryLite);
        }

        public static LogResponse parseFrom(InputStream inputStream) throws IOException {
            return PARSER.parseFrom(inputStream);
        }

        public static LogResponse parseFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(inputStream, extensionRegistryLite);
        }

        public static LogResponse parseFrom(CodedInputStream codedInputStream) throws IOException {
            return PARSER.parseFrom(codedInputStream);
        }

        public static LogResponse parseFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseFrom(codedInputStream, extensionRegistryLite);
        }

        public static LogResponse parseDelimitedFrom(InputStream inputStream) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream);
        }

        public static LogResponse parseDelimitedFrom(InputStream inputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
            return PARSER.parseDelimitedFrom(inputStream, extensionRegistryLite);
        }

        public static a newBuilder() {
            return a.baW();
        }

        public static a newBuilder(LogResponse logResponse) {
            return newBuilder().mergeFrom(logResponse);
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a newBuilderForType() {
            return newBuilder();
        }

        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.google.protobuf.MessageLite
        public a toBuilder() {
            return newBuilder(this);
        }

        /* loaded from: classes12.dex */
        public static final class a extends GeneratedMessageLite.Builder<LogResponse, a> implements c {
            private int bitField0;
            private int errorCode;
            private Object errorMsg = "";
            private long pingIntervalMs;

            private a() {
                maybeForceBuilderInitialization();
            }

            private void maybeForceBuilderInitialization() {
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static a baW() {
                return new a();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: baX */
            public a clear() {
                super.clear();
                this.errorCode = 0;
                this.bitField0 &= -2;
                this.errorMsg = "";
                this.bitField0 &= -3;
                this.pingIntervalMs = 0L;
                this.bitField0 &= -5;
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: baY */
            public a clone() {
                return baW().mergeFrom(buildPartial());
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder, com.google.protobuf.MessageLiteOrBuilder
            public LogResponse getDefaultInstanceForType() {
                return LogResponse.getDefaultInstance();
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: baZ */
            public LogResponse build() {
                LogResponse buildPartial = buildPartial();
                if (!buildPartial.isInitialized()) {
                    throw newUninitializedMessageException(buildPartial);
                }
                return buildPartial;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.MessageLite.Builder
            /* renamed from: bba */
            public LogResponse buildPartial() {
                LogResponse logResponse = new LogResponse(this);
                int i = this.bitField0;
                int i2 = (i & 1) != 1 ? 0 : 1;
                logResponse.errorCode = this.errorCode;
                if ((i & 2) == 2) {
                    i2 |= 2;
                }
                logResponse.errorMsg = this.errorMsg;
                if ((i & 4) == 4) {
                    i2 |= 4;
                }
                logResponse.pingIntervalMs = this.pingIntervalMs;
                logResponse.bitField0 = i2;
                return logResponse;
            }

            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.google.protobuf.GeneratedMessageLite.Builder
            /* renamed from: a */
            public a mergeFrom(LogResponse logResponse) {
                if (logResponse != LogResponse.getDefaultInstance()) {
                    if (logResponse.hasErrorCode()) {
                        ox(logResponse.getErrorCode());
                    }
                    if (logResponse.hasErrorMsg()) {
                        this.bitField0 |= 2;
                        this.errorMsg = logResponse.errorMsg;
                    }
                    if (logResponse.hasPingIntervalMs()) {
                        cB(logResponse.getPingIntervalMs());
                    }
                }
                return this;
            }

            /* JADX DEBUG: Method merged with bridge method */
            /* JADX WARN: Removed duplicated region for block: B:14:0x001e  */
            @Override // com.google.protobuf.AbstractMessageLite.Builder, com.google.protobuf.MessageLite.Builder
            /* renamed from: x */
            /*
                Code decompiled incorrectly, please refer to instructions dump.
            */
            public a mergeFrom(CodedInputStream codedInputStream, ExtensionRegistryLite extensionRegistryLite) throws IOException {
                LogResponse logResponse;
                Throwable th;
                try {
                    try {
                        LogResponse parsePartialFrom = LogResponse.PARSER.parsePartialFrom(codedInputStream, extensionRegistryLite);
                        if (parsePartialFrom != null) {
                            mergeFrom(parsePartialFrom);
                        }
                        return this;
                    } catch (Throwable th2) {
                        th = th2;
                        logResponse = null;
                        if (logResponse != null) {
                            mergeFrom(logResponse);
                        }
                        throw th;
                    }
                } catch (InvalidProtocolBufferException e) {
                    LogResponse logResponse2 = (LogResponse) e.getUnfinishedMessage();
                    try {
                        throw e;
                    } catch (Throwable th3) {
                        logResponse = logResponse2;
                        th = th3;
                        if (logResponse != null) {
                        }
                        throw th;
                    }
                }
            }

            @Override // com.google.protobuf.MessageLiteOrBuilder
            public final boolean isInitialized() {
                return true;
            }

            public a ox(int i) {
                this.bitField0 |= 1;
                this.errorCode = i;
                return this;
            }

            public a cB(long j) {
                this.bitField0 |= 4;
                this.pingIntervalMs = j;
                return this;
            }
        }
    }
}
