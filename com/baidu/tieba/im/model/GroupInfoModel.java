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
        LocalViewSize.ImageSize De = LocalViewSize.Dc().De();
        LocalViewSize.ImageSize Df = LocalViewSize.Dc().Df();
        requestGroupInfoMessage.setBigHeight(Df.height);
        requestGroupInfoMessage.setBigWidth(Df.width);
        requestGroupInfoMessage.setSmallHeight(De.height);
        requestGroupInfoMessage.setSmallWidth(De.width);
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
        LocalViewSize.ImageSize De = LocalViewSize.Dc().De();
        LocalViewSize.ImageSize Df = LocalViewSize.Dc().Df();
        requestGroupInfoLocalMessage.setBigHeight(Df.height);
        requestGroupInfoLocalMessage.setBigWidth(Df.width);
        requestGroupInfoLocalMessage.setSmallHeight(De.height);
        requestGroupInfoLocalMessage.setSmallWidth(De.width);
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
        if (this.mData == null || this.mData.aTd() == null || this.mData.aTd().size() <= 0) {
            return null;
        }
        ArrayList<String> arrayList = new ArrayList<>();
        for (PhotoUrlData photoUrlData : this.mData.aTd()) {
            if (photoUrlData != null) {
                arrayList.add(photoUrlData.getBigurl());
            }
        }
        return arrayList;
    }

    public HashMap<String, ImageUrlData> getAssistUrls() {
        HashMap<String, ImageUrlData> hashMap = new HashMap<>();
        if (this.mData != null && this.mData.aTd() != null && this.mData.aTd().size() > 0) {
            for (PhotoUrlData photoUrlData : this.mData.aTd()) {
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
        if (this.mData != null && this.mData.aTd() != null && this.mData.aTd().size() > 0) {
            int size = this.mData.aTd().size();
            List<PhotoUrlData> aTd = this.mData.aTd();
            for (int i = 1; i < size; i++) {
                if (aTd.get(i) != null && !picId.equals(aTd.get(i).getPicId())) {
                    sb.append(aTd.get(i).getPicId());
                    if (i != size - 1) {
                        sb.append(",");
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
        if (this.mData != null && this.mData.aTd() != null && this.mData.aTd().size() > 0) {
            List<PhotoUrlData> aTd = this.mData.aTd();
            int size = aTd.size();
            for (int i = 1; i < size; i++) {
                if (aTd.get(i) != null) {
                    sb.append(aTd.get(i).getPicId());
                    sb.append(",");
                }
            }
            sb.append(picId);
        } else {
            sb.append(picId);
        }
        return sb.toString();
    }

    public void delePhotoData() {
        if (this.mData != null && this.mData.aTd() != null && this.mData.aTd().size() > 0 && this.mChangePhotoUrlData != null) {
            for (PhotoUrlData photoUrlData : this.mData.aTd()) {
                if (photoUrlData != null && photoUrlData.getPicId().equals(this.mChangePhotoUrlData.getPicId())) {
                    this.mData.aTd().remove(photoUrlData);
                    return;
                }
            }
        }
    }

    public void addPhotoData() {
        if (this.mData != null && this.mChangePhotoUrlData != null) {
            if (this.mData.aTd() == null) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(this.mChangePhotoUrlData);
                this.mData.cL(arrayList);
                return;
            }
            if (this.mData.aTd().size() > 0 && this.mData.aTd().get(0) != null && TextUtils.isEmpty(this.mData.aTd().get(0).getPicId())) {
                this.mData.aTd().remove(0);
            }
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.mChangePhotoUrlData.getBigurl());
            photoUrlData.setPicId(this.mChangePhotoUrlData.getPicId());
            photoUrlData.setSmallurl(this.mChangePhotoUrlData.getSmallurl());
            this.mData.aTd().add(photoUrlData);
        }
    }

    public void updataPortraitData() {
        if (this.mData != null && this.mData.aTd() != null && this.mData.aTd().size() > 0 && this.mChangePhotoUrlData != null) {
            int i = 0;
            while (true) {
                if (i >= this.mData.aTd().size()) {
                    i = -1;
                    break;
                } else if (this.mData.aTd().get(i) == null || this.mData.aTd().get(i).getPicId() == null || !this.mData.aTd().get(i).getPicId().equals(this.mChangePhotoUrlData.getPicId())) {
                    i++;
                } else {
                    this.mData.aTd().remove(i);
                    break;
                }
            }
            if (this.mData.aTd().size() > 0 && this.mData.aTd().get(0) != null && TextUtils.isEmpty(this.mData.aTd().get(0).getPicId())) {
                this.mData.aTd().remove(0);
            }
            this.mData.aTd().add(i, this.mData.aTd().get(0));
            this.mData.aTd().remove(0);
            PhotoUrlData photoUrlData = new PhotoUrlData();
            photoUrlData.setBigurl(this.mChangePhotoUrlData.getBigurl());
            photoUrlData.setPicId(this.mChangePhotoUrlData.getPicId());
            photoUrlData.setSmallurl(this.mChangePhotoUrlData.getSmallurl());
            this.mData.aTd().add(0, photoUrlData);
        }
    }

    public void sendLocalMessage(long j, int i) {
        if (this.mLocalSendMessage == null) {
            this.mLocalSendMessage = createLocalMessage(j, i);
        }
        super.sendMessage(this.mLocalSendMessage);
    }

    public boolean removeMemberByUid(String str) {
        if (str != null && this.mData != null && this.mData.aTc() != null && this.mData.aTc().size() > 0) {
            for (MemberData memberData : this.mData.aTc()) {
                if (str.equals(String.valueOf(memberData.getUserId()))) {
                    this.mData.aTc().remove(memberData);
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
