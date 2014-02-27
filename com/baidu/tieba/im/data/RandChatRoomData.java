package com.baidu.tieba.im.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tieba.data.UserData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RandChatRoomData implements Parcelable {
    public static final Parcelable.Creator<RandChatRoomData> CREATOR = new j();
    private int a;
    private int b;
    private int c;
    private long d;
    private long e;
    private long f;
    private long g;
    private List<UserData> h;
    private ChatRoomTopicData i;
    private List<ChatRoomTopicData> j;

    public RandChatRoomData() {
        this.h = new ArrayList();
        this.i = null;
        this.j = null;
    }

    public final void a(ChatRoomTopicData chatRoomTopicData) {
        this.i = chatRoomTopicData;
    }

    public final void a(List<ChatRoomTopicData> list) {
        this.j = list;
    }

    public final String a() {
        if (this.i == null) {
            return null;
        }
        return this.i.getTitle();
    }

    public final String b() {
        if (this.i == null) {
            return null;
        }
        return this.i.getContent();
    }

    public final List<ChatRoomTopicData> c() {
        return this.j;
    }

    public final int d() {
        return this.a;
    }

    public final void a(int i) {
        this.a = i;
    }

    public final int e() {
        return this.b;
    }

    public final void b(int i) {
        this.b = i;
    }

    public final int f() {
        return this.c;
    }

    public final void c(int i) {
        this.c = i;
    }

    public final long g() {
        return this.d;
    }

    public final void a(long j) {
        this.d = j;
    }

    public final long h() {
        return this.e;
    }

    public final void b(long j) {
        this.e = j;
    }

    public final long i() {
        return this.f;
    }

    public final void c(long j) {
        this.f = j;
    }

    public final List<UserData> j() {
        return this.h;
    }

    public final void b(List<UserData> list) {
        this.h = list;
    }

    public final long k() {
        return this.g;
    }

    public final void d(long j) {
        this.g = j;
    }

    public String toString() {
        return "RandChatRoomData{groupId=" + this.a + ", userNum=" + this.b + ", maxUserNum=" + this.c + ", durationTime=" + this.d + ", silenceTime=" + this.e + ", averageWaitTime=" + this.f + ", users=" + this.h + '}';
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private RandChatRoomData(Parcel parcel) {
        this.h = new ArrayList();
        this.i = null;
        this.j = null;
        this.a = parcel.readInt();
        this.b = parcel.readInt();
        this.c = parcel.readInt();
        this.d = parcel.readLong();
        this.e = parcel.readLong();
        this.f = parcel.readLong();
        this.g = parcel.readLong();
        this.h = parcel.readArrayList(getClass().getClassLoader());
        this.i = (ChatRoomTopicData) parcel.readSerializable();
        this.j = parcel.readArrayList(getClass().getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ RandChatRoomData(Parcel parcel, byte b) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.a);
        parcel.writeInt(this.b);
        parcel.writeInt(this.c);
        parcel.writeLong(this.d);
        parcel.writeLong(this.e);
        parcel.writeLong(this.f);
        parcel.writeLong(this.g);
        parcel.writeList(this.h);
        parcel.writeSerializable(this.i);
        parcel.writeList(this.j);
    }
}
