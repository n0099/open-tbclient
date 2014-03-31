package com.baidu.tieba.im.message;

import android.util.SparseArray;
import com.baidu.tbadk.TbadkApplication;
import com.google.protobuf.MessageLite;
import protobuf.GetGroupMsg.GetGroupMsgReq;
import protobuf.Im;
/* loaded from: classes.dex */
public final class s extends com.baidu.tbadk.message.websockt.d {
    private SparseArray<Long> a;
    private int b;
    private int c;
    private int d;
    private int e;
    private String f;
    private boolean g;

    public s() {
        super(202003);
        this.a = null;
    }

    public final void d(int i) {
        this.b = i;
    }

    public final void e(int i) {
        this.c = i;
    }

    public final void f(int i) {
        this.d = i;
    }

    public final void h(int i) {
        this.e = i;
    }

    public final void a(SparseArray<Long> sparseArray) {
        this.a = sparseArray;
    }

    public final SparseArray<Long> i() {
        return this.a;
    }

    @Override // com.baidu.tbadk.message.websockt.d
    public final MessageLite h() {
        protobuf.GetGroupMsg.b a = GetGroupMsgReq.DataReq.newBuilder().b(this.c).a(this.b).d(this.e).c(this.d).a(this.f);
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 < this.a.size()) {
                int keyAt = this.a.keyAt(i2);
                Long valueAt = this.a.valueAt(i2);
                if (valueAt != null) {
                    a.a(Im.GroupLastId.newBuilder().a(keyAt).a(valueAt.longValue()));
                }
                i = i2 + 1;
            } else {
                return GetGroupMsgReq.GetGroupMsgReqIdl.newBuilder().a(TbadkApplication.y()).a(a.build()).build();
            }
        }
    }

    public final boolean j() {
        return this.g;
    }

    public final void a(boolean z) {
        this.g = z;
    }
}
