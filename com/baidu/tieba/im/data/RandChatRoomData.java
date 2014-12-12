package com.baidu.tieba.im.data;

import android.os.Parcel;
import android.os.Parcelable;
import com.baidu.tbadk.core.data.UserData;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class RandChatRoomData implements Parcelable {
    public static final Parcelable.Creator<RandChatRoomData> CREATOR = new e();
    private long averageWaitTime;
    private long durationTime;
    private int groupId;
    private long lastMessageId;
    private ChatRoomTopicData mTopic;
    private List<ChatRoomTopicData> mTopicList;
    private int maxUserNum;
    private long silenceTime;
    private int userNum;
    private List<UserData> users;

    public RandChatRoomData() {
        this.users = new ArrayList();
        this.mTopic = null;
        this.mTopicList = null;
    }

    public void setTopic(ChatRoomTopicData chatRoomTopicData) {
        this.mTopic = chatRoomTopicData;
    }

    public void setTopicList(List<ChatRoomTopicData> list) {
        this.mTopicList = list;
    }

    public String getTopicTitle() {
        if (this.mTopic == null) {
            return null;
        }
        return this.mTopic.getTitle();
    }

    public String getTopicContent() {
        if (this.mTopic == null) {
            return null;
        }
        return this.mTopic.getContent();
    }

    public List<ChatRoomTopicData> getTopicList() {
        return this.mTopicList;
    }

    public int getGroupId() {
        return this.groupId;
    }

    public void setGroupId(int i) {
        this.groupId = i;
    }

    public int getUserNum() {
        return this.userNum;
    }

    public void setUserNum(int i) {
        this.userNum = i;
    }

    public int getMaxUserNum() {
        return this.maxUserNum;
    }

    public void setMaxUserNum(int i) {
        this.maxUserNum = i;
    }

    public long getDurationTime() {
        return this.durationTime;
    }

    public void setDurationTime(long j) {
        this.durationTime = j;
    }

    public long getSilenceTime() {
        return this.silenceTime;
    }

    public void setSilenceTime(long j) {
        this.silenceTime = j;
    }

    public long getAverageWaitTime() {
        return this.averageWaitTime;
    }

    public void setAverageWaitTime(long j) {
        this.averageWaitTime = j;
    }

    public List<UserData> getUsers() {
        return this.users;
    }

    public void setUsers(List<UserData> list) {
        this.users = list;
    }

    public long getLastMessageId() {
        return this.lastMessageId;
    }

    public void setLastMessageId(long j) {
        this.lastMessageId = j;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private RandChatRoomData(Parcel parcel) {
        this.users = new ArrayList();
        this.mTopic = null;
        this.mTopicList = null;
        this.groupId = parcel.readInt();
        this.userNum = parcel.readInt();
        this.maxUserNum = parcel.readInt();
        this.durationTime = parcel.readLong();
        this.silenceTime = parcel.readLong();
        this.averageWaitTime = parcel.readLong();
        this.lastMessageId = parcel.readLong();
        this.users = parcel.readArrayList(getClass().getClassLoader());
        this.mTopic = (ChatRoomTopicData) parcel.readSerializable();
        this.mTopicList = parcel.readArrayList(getClass().getClassLoader());
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ RandChatRoomData(Parcel parcel, RandChatRoomData randChatRoomData) {
        this(parcel);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.groupId);
        parcel.writeInt(this.userNum);
        parcel.writeInt(this.maxUserNum);
        parcel.writeLong(this.durationTime);
        parcel.writeLong(this.silenceTime);
        parcel.writeLong(this.averageWaitTime);
        parcel.writeLong(this.lastMessageId);
        parcel.writeList(this.users);
        parcel.writeSerializable(this.mTopic);
        parcel.writeList(this.mTopicList);
    }
}
