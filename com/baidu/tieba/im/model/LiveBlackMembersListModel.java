package com.baidu.tieba.im.model;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.baidu.adp.base.e;
import com.baidu.adp.lib.g.c;
import com.baidu.tbadk.live.message.RequestLiveBlackMembersMessage;
import com.baidu.tbadk.live.message.RequestLiveGroupOwnerGagMessage;
/* loaded from: classes.dex */
public class LiveBlackMembersListModel extends e {
    public static final String GROUP_ID = "group_id";
    public static final int PAGE_LEN = 20;
    private String groupId;
    private boolean hasMore;
    private int pageNum;
    private int start;
    private int totalMembers;

    public LiveBlackMembersListModel(Context context) {
        super(context);
    }

    public int getTotalMembers() {
        return this.totalMembers;
    }

    public void setTotalMembers(int i) {
        this.totalMembers = i;
    }

    public String getGroupId() {
        return this.groupId;
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }

    public int getStart() {
        return this.start;
    }

    public void setStart(int i) {
        this.start = i;
    }

    public int getPageNum() {
        return this.pageNum;
    }

    public void setPageNum(int i) {
        this.pageNum = i;
    }

    public boolean isHasMore() {
        return this.hasMore;
    }

    public void setHasMore(boolean z) {
        this.hasMore = z;
    }

    @Override // com.baidu.adp.base.e
    protected boolean LoadData() {
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    public void saveInstance(Bundle bundle) {
    }

    public void sendMessage(String str, int i, int i2) {
        RequestLiveBlackMembersMessage requestLiveBlackMembersMessage = new RequestLiveBlackMembersMessage();
        requestLiveBlackMembersMessage.setGroupId(c.a(str, 0L));
        requestLiveBlackMembersMessage.setOffset(i);
        requestLiveBlackMembersMessage.setRn(i2);
        super.sendMessage(requestLiveBlackMembersMessage);
    }

    public void sendUnsetUserMessage(String str, int i, String[] strArr, String[] strArr2) {
        if (strArr != null && strArr.length != 0) {
            StringBuilder sb = new StringBuilder();
            for (String str2 : strArr) {
                sb.append(str2).append(",");
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            StringBuilder sb2 = new StringBuilder();
            if (strArr2 != null && strArr2.length > 0) {
                for (String str3 : strArr2) {
                    sb2.append(str3).append(",");
                }
                if (sb2.length() > 0) {
                    sb2.deleteCharAt(sb2.length() - 1);
                }
            }
            RequestLiveGroupOwnerGagMessage requestLiveGroupOwnerGagMessage = new RequestLiveGroupOwnerGagMessage();
            requestLiveGroupOwnerGagMessage.setGroupId(c.f(str, 0));
            requestLiveGroupOwnerGagMessage.setType(i);
            requestLiveGroupOwnerGagMessage.setUserIds(sb.toString());
            requestLiveGroupOwnerGagMessage.setUserNames(sb2.toString());
            sendMessage(requestLiveGroupOwnerGagMessage);
        }
    }

    public void initWithIntent(Intent intent) {
        this.groupId = intent.getStringExtra("group_id");
    }

    public void initWithBundle(Bundle bundle) {
        this.groupId = bundle.getString("group_id");
    }
}
