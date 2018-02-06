package com.baidu.tieba.im.model;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.framework.message.Message;
import com.baidu.tbadk.core.util.LocalViewSize;
import com.baidu.tbadk.coreExtra.data.PhotoUrlData;
import com.baidu.tbadk.coreExtra.view.ImageUrlData;
import com.baidu.tieba.im.data.MemberData;
import com.baidu.tieba.im.groupInfo.GroupInfoActivity;
import com.baidu.tieba.im.message.ClearGroupInfoCacheMessage;
import com.baidu.tieba.im.message.RequestGroupInfoLocalMessage;
import com.baidu.tieba.im.message.RequestGroupInfoMessage;
import com.baidu.tieba.im.message.ResponseGroupInfoLocalMessage;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/* loaded from: classes3.dex */
public class GroupInfoModel extends BdBaseModel<GroupInfoActivity> {
    public static final String ACTION_FROM = "activity_from";
    public static final String DEFAULT_INVITE_MSG = "default_invite_msg";
    public static final String GROUP_ID = "group_id";
    public static final String INVITE_USER_ID = "inviter_user_id";
    public static final String JOIN_TYPE = "join_type";
    private String defaultInviteMsg;
    private long inviteUserId;
    private int joinType;
    private PhotoUrlData mChangePhotoUrlData;
    private ResponseGroupInfoLocalMessage.a mData;
    private int mFrom;
    private long mGroupId;
    private boolean mHasRecentJoin;
    private RequestGroupInfoLocalMessage mLocalSendMessage;
    private RequestGroupInfoMessage mSendMessage;

    public GroupInfoModel(GroupInfoActivity groupInfoActivity) {
        super(groupInfoActivity.getPageContext());
    }

    public PhotoUrlData getChangePhotoUrlData() {
        return this.mChangePhotoUrlData;
    }

    public void setChangePhotoUrlData(PhotoUrlData photoUrlData) {
        this.mChangePhotoUrlData = photoUrlData;
    }

    public int getJoinType() {
        return this.joinType;
    }

    public void setJoinType(int i) {
        this.joinType = i;
    }

    public long getInviteUserId() {
        return this.inviteUserId;
    }

    public void setInviteUserId(long j) {
        this.inviteUserId = j;
    }

    public String getDefaultUserMsg() {
        return this.defaultInviteMsg;
    }

    public void setDefaultUserMsg(String str) {
        this.defaultInviteMsg = str;
    }

    public long getGroupId() {
        return this.mGroupId;
    }

    public int getFrom() {
        return this.mFrom;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    public void initWithIntent(Intent intent) {
        this.mGroupId = intent.getLongExtra("group_id", 0L);
        this.mFrom = intent.getIntExtra("activity_from", 0);
        this.joinType = intent.getIntExtra("join_type", 0);
        this.inviteUserId = intent.getLongExtra("inviter_user_id", 0L);
        this.defaultInviteMsg = intent.getStringExtra("default_invite_msg");
    }

    public void initWithBundle(Bundle bundle) {
        this.mGroupId = bundle.getLong("group_id", 0L);
        this.mFrom = bundle.getInt("activity_from", 0);
        this.joinType = bundle.getInt("join_type");
        this.inviteUserId = bundle.getLong("inviter_user_id");
        this.defaultInviteMsg = bundle.getString("default_invite_msg");
    }

    private RequestGroupInfoMessage createMessage(long j, int i) {
        RequestGroupInfoMessage requestGroupInfoMessage = new RequestGroupInfoMessage();
        requestGroupInfoMessage.setGroupId(j);
        LocalViewSize.ImageSize Cu = LocalViewSize.Cs().Cu();
        LocalViewSize.ImageSize Cv = LocalViewSize.Cs().Cv();
        requestGroupInfoMessage.setBigHeight(Cv.height);
        requestGroupInfoMessage.setBigWidth(Cv.width);
        requestGroupInfoMessage.setSmallHeight(Cu.height);
        requestGroupInfoMessage.setSmallWidth(Cu.width);
        if (i == 4) {
            requestGroupInfoMessage.setFrom("forumgroup_recommend");
        } else if (i == 5) {
            requestGroupInfoMessage.setFrom("forumgroup_hot");
        } else if (i == 6) {
            requestGroupInfoMessage.setFrom("forumgroup_official");
        } else if (i == 3) {
            requestGroupInfoMessage.setFrom("grouptalk");
        } else if (i == 1) {
            requestGroupInfoMessage.setFrom("usergroup");
        } else if (i == 7) {
            requestGroupInfoMessage.setFrom("invitetalk");
        } else {
            requestGroupInfoMessage.setFrom("");
        }
        return requestGroupInfoMessage;
    }

    private RequestGroupInfoLocalMessage createLocalMessage(long j, int i) {
        RequestGroupInfoLocalMessage requestGroupInfoLocalMessage = new RequestGroupInfoLocalMessage();
        requestGroupInfoLocalMessage.setGroupId(j);
        LocalViewSize.ImageSize Cu = LocalViewSize.Cs().Cu();
        LocalViewSize.ImageSize Cv = LocalViewSize.Cs().Cv();
        requestGroupInfoLocalMessage.setBigHeight(Cv.height);
        requestGroupInfoLocalMessage.setBigWidth(Cv.width);
        requestGroupInfoLocalMessage.setSmallHeight(Cu.height);
        requestGroupInfoLocalMessage.setSmallWidth(Cu.width);
        if (i == 4) {
            requestGroupInfoLocalMessage.setFrom("forumgroup_recommend");
        } else if (i == 5) {
            requestGroupInfoLocalMessage.setFrom("forumgroup_hot");
        } else if (i == 6) {
            requestGroupInfoLocalMessage.setFrom("forumgroup_official");
        } else if (i == 3) {
            requestGroupInfoLocalMessage.setFrom("grouptalk");
        } else if (i == 1) {
            requestGroupInfoLocalMessage.setFrom("usergroup");
        } else if (i == 7) {
            requestGroupInfoLocalMessage.setFrom("invitetalk");
        } else {
            requestGroupInfoLocalMessage.setFrom("");
        }
        return requestGroupInfoLocalMessage;
    }

    public void sendMessage(long j, int i) {
        this.mSendMessage = createMessage(j, i);
        super.sendMessage(this.mSendMessage);
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public void cancelMessage() {
        super.cancelMessage();
    }

    public void saveInstance(Bundle bundle) {
        bundle.putLong("group_id", this.mGroupId);
        bundle.putInt("activity_from", this.mFrom);
        bundle.putInt("join_type", this.joinType);
        bundle.putLong("inviter_user_id", this.inviteUserId);
        bundle.putString("default_invite_msg", this.defaultInviteMsg);
    }

    public void setData(ResponseGroupInfoLocalMessage.a aVar) {
        this.mChangePhotoUrlData = null;
        this.mData = aVar;
    }

    public ResponseGroupInfoLocalMessage.a getData() {
        return this.mData;
    }

    public ArrayList<String> getBigUrlList() {
        if (this.mData == null || this.mData.aKS() == null || this.mData.aKS().size() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (PhotoUrlData photoUrlData : this.mData.aKS()) {
            if (photoUrlData != null) {
                arrayList.add(photoUrlData.getBigurl());
            }
        }
        return arrayList;
    }

    public HashMap<String, ImageUrlData> getAssistUrls() {
        HashMap<String, ImageUrlData> hashMap = new HashMap<>();
        if (this.mData != null && this.mData.aKS() != null && this.mData.aKS().size() > 0) {
            for (PhotoUrlData photoUrlData : this.mData.aKS()) {
                if (photoUrlData != null) {
                    String bigurl = photoUrlData.getBigurl();
                    ImageUrlData imageUrlData = new ImageUrlData();
                    imageUrlData.urlType = 10;
                    imageUrlData.imageUrl = photoUrlData.getSmallurl();
                    hashMap.put(bigurl, imageUrlData);
                }
            }
        }
        return hashMap;
    }

    public String generateDeleAlbum(PhotoUrlData photoUrlData) {
        StringBuilder sb = new StringBuilder();
        if (photoUrlData == null) {
            return null;
        }
        String picId = photoUrlData.getPicId();
        if (TextUtils.isEmpty(picId)) {
            return null;
        }
        this.mChangePhotoUrlData = photoUrlData;
        if (this.mData != null && this.mData.aKS() != null && this.mData.aKS().size() > 0) {
            int size = this.mData.aKS().size();
            List<PhotoUrlData> aKS = this.mData.aKS();
            for (int i = 1; i < size; i++) {
                if (aKS.get(i) != null && !picId.equals(aKS.get(i).getPicId())) {
                    sb.append(aKS.get(i).getPicId());
                    if (i != size - 1) {
                        sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    }
                }
            }
        }
        return sb.toString();
    }

    public String generateAddAlbum(PhotoUrlData photoUrlData) {
        StringBuilder sb = new StringBuilder();
        if (photoUrlData == null) {
            return null;
        }
        String picId = photoUrlData.getPicId();
        if (TextUtils.isEmpty(picId)) {
            return null;
        }
        this.mChangePhotoUrlData = photoUrlData;
        if (this.mData != null && this.mData.aKS() != null && this.mData.aKS().size() > 0) {
            List<PhotoUrlData> aKS = this.mData.aKS();
            int size = aKS.size();
            for (int i = 1; i < size; i++) {
                if (aKS.get(i) != null) {
                    sb.append(aKS.get(i).getPicId());
                    sb.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                }
            }
            sb.append(picId);
        } else {
            sb.append(picId);
        }
        return sb.toString();
    }

    public void delePhotoData() {
        if (this.mData != null && this.mData.aKS() != null && this.mData.aKS().size() > 0 && this.mChangePhotoUrlData != null) {
            for (PhotoUrlData photoUrlData : this.mData.aKS()) {
                if (photoUrlData != null && photoUrlData.getPicId().equals(this.mChangePhotoUrlData.getPicId())) {
                    this.mData.aKS().remove(photoUrlData);
                    return;
                }
            }
        }
    }

    public void addPhotoData() {
        if (this.mData != null && this.mChangePhotoUrlData != null) {
            if (this.mData.aKS() == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mChangePhotoUrlData);
                this.mData.co(arrayList);
                return;
            }
            if (this.mData.aKS().size() > 0 && this.mData.aKS().get(0) != null && TextUtils.isEmpty(this.mData.aKS().get(0).getPicId())) {
                this.mData.aKS().remove(0);
            }
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.mChangePhotoUrlData.getBigurl());
            photoUrlData.setPicId(this.mChangePhotoUrlData.getPicId());
            photoUrlData.setSmallurl(this.mChangePhotoUrlData.getSmallurl());
            this.mData.aKS().add(photoUrlData);
        }
    }

    public void updataPortraitData() {
        if (this.mData != null && this.mData.aKS() != null && this.mData.aKS().size() > 0 && this.mChangePhotoUrlData != null) {
            int i = 0;
            while (true) {
                if (i >= this.mData.aKS().size()) {
                    i = -1;
                    break;
                } else if (this.mData.aKS().get(i) == null || this.mData.aKS().get(i).getPicId() == null || !this.mData.aKS().get(i).getPicId().equals(this.mChangePhotoUrlData.getPicId())) {
                    i++;
                } else {
                    this.mData.aKS().remove(i);
                    break;
                }
            }
            if (this.mData.aKS().size() > 0 && this.mData.aKS().get(0) != null && TextUtils.isEmpty(this.mData.aKS().get(0).getPicId())) {
                this.mData.aKS().remove(0);
            }
            this.mData.aKS().add(i, this.mData.aKS().get(0));
            this.mData.aKS().remove(0);
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.mChangePhotoUrlData.getBigurl());
            photoUrlData.setPicId(this.mChangePhotoUrlData.getPicId());
            photoUrlData.setSmallurl(this.mChangePhotoUrlData.getSmallurl());
            this.mData.aKS().add(0, photoUrlData);
        }
    }

    public void sendLocalMessage(long j, int i) {
        if (this.mLocalSendMessage == null) {
            this.mLocalSendMessage = createLocalMessage(j, i);
        }
        super.sendMessage(this.mLocalSendMessage);
    }

    public boolean removeMemberByUid(String str) {
        if (str != null && this.mData != null && this.mData.aKR() != null && this.mData.aKR().size() > 0) {
            for (MemberData memberData : this.mData.aKR()) {
                if (str.equals(String.valueOf(memberData.getUserId()))) {
                    this.mData.aKR().remove(memberData);
                    return true;
                }
            }
        }
        return false;
    }

    public Message<?> getLocalSendMsg() {
        return this.mLocalSendMessage;
    }

    public Message<?> getSendMsg() {
        return this.mSendMessage;
    }

    public boolean hasRecentJoin() {
        return this.mHasRecentJoin;
    }

    public void setHasRecentJoin(boolean z) {
        this.mHasRecentJoin = z;
    }

    public void clearGroupInfoCache(String str) {
        ClearGroupInfoCacheMessage clearGroupInfoCacheMessage = new ClearGroupInfoCacheMessage();
        clearGroupInfoCacheMessage.setData(str);
        super.sendMessage(clearGroupInfoCacheMessage);
    }
}
