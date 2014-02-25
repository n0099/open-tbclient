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

    public void a(ChatRoomTopicData chatRoomTopicData) {
        this.i = chatRoomTopicData;
    }

    public void a(List<ChatRoomTopicData> list) {
        this.j = list;
    }

    public String a() {
        if (this.i == null) {
            return null;
        }
        return this.i.getTitle();
    }

    public String b() {
        if (this.i == null) {
            return null;
        }
        return this.i.getContent();
    }

    public List<ChatRoomTopicData> c() {
        return this.j;
    }

    public int d() {
        return this.a;
    }

    public void a(int i) {
        this.a = i;
    }

    public int e() {
        return this.b;
    }

    public void b(int i) {
        this.b = i;
    }

    public int f() {
        return this.c;
    }

    public void c(int i) {
        this.c = i;
    }

    public long g() {
        return this.d;
    }

    public void a(long j) {
        this.d = j;
    }

    public long h() {
        return this.e;
    }

    public void b(long j) {
        this.e = j;
    }

    public long i() {
        return this.f;
    }

    public void c(long j) {
        this.f = j;
    }

    public List<UserData> j() {
        return this.h;
    }

    public void b(List<UserData> list) {
        this.h = list;
    }

    public long k() {
        return this.g;
    }

    public void d(long j) {
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
    public /* synthetic */ RandChatRoomData(Parcel parcel, RandChatRoomData randChatRoomData) {
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
