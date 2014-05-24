package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.coreExtra.data.LiveChatRoomEventData;
import com.baidu.tbadk.coreExtra.message.LiveChatRoomEventResponseMessage;
/* loaded from: classes.dex */
class ad extends CustomMessageListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ad(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveChatRoomEventData parseFromEventContent;
        LiveRoomChatView z;
        LiveRoomChatView z2;
        LiveRoomChatView z3;
        LiveRoomChatView z4;
        LiveRoomChatView z5;
        LiveRoomChatView z6;
        LiveRoomChatView z7;
        LiveRoomChatView z8;
        LiveRoomChatView z9;
        LiveRoomChatView z10;
        LiveRoomChatView z11;
        LiveRoomChatView z12;
        LiveRoomChatView z13;
        LiveRoomChatView z14;
        if (customResponsedMessage.getCmd() == 2003166 && (customResponsedMessage instanceof LiveChatRoomEventResponseMessage)) {
            String data = ((LiveChatRoomEventResponseMessage) customResponsedMessage).getData();
            if (!TextUtils.isEmpty(data) && (parseFromEventContent = LiveChatRoomEventData.parseFromEventContent(data)) != null) {
                if (parseFromEventContent.mEventId != null) {
                    BdLog.d("crs:mEventId" + parseFromEventContent.mEventId);
                }
                if ("302".equals(parseFromEventContent.mEventId)) {
                    if (parseFromEventContent.mListeners != this.a.x().h) {
                        this.a.x().h = parseFromEventContent.mListeners;
                        z14 = this.a.z();
                        z14.R().setUserCount(this.a.x().h);
                    }
                    this.a.x().i = parseFromEventContent.mLikers;
                    this.a.x().d = parseFromEventContent.mLikeUserList;
                    z13 = this.a.z();
                    z13.a(this.a.x().d, this.a.x().i, this.a.x().g);
                } else if ("306".equals(parseFromEventContent.mEventId)) {
                    if (!TextUtils.isEmpty(parseFromEventContent.mPortrait) && !parseFromEventContent.mPortrait.equals(this.a.x().m)) {
                        this.a.x().m = parseFromEventContent.mPortrait;
                    }
                    if (!TextUtils.isEmpty(parseFromEventContent.mName) && !parseFromEventContent.mName.equals(this.a.x().j)) {
                        this.a.x().j = parseFromEventContent.mName;
                        z12 = this.a.z();
                        z12.d(this.a.x().j);
                        if (!LiveRoomChatActivity.a) {
                            this.a.b(com.baidu.tieba.y.live_room_notify);
                        }
                    }
                    if (!TextUtils.isEmpty(parseFromEventContent.mIntro) && !parseFromEventContent.mIntro.equals(this.a.x().k)) {
                        this.a.x().k = parseFromEventContent.mIntro;
                        z11 = this.a.z();
                        z11.R().setNoteText(this.a.x().k);
                    }
                } else if ("310".equals(parseFromEventContent.mEventId)) {
                    if (this.a.x().b != null && this.a.x().b.groupId.intValue() == parseFromEventContent.mGroupId && !this.a.x().r) {
                        com.baidu.tieba.im.live.b.b().s();
                        this.a.showToast(com.baidu.tieba.y.live_group_is_dismiss, false);
                        z10 = this.a.z();
                        z10.d(6);
                        this.a.finish();
                    }
                } else if ("307".equals(parseFromEventContent.mEventId)) {
                    if (this.a.x().r || this.a.x().b == null) {
                        return;
                    }
                    this.a.b(this.a.x().b.streamId, String.valueOf(this.a.x().b.groupId), String.valueOf(this.a.x().b.deviceId), this.a.x().b.playUrl, true);
                    z9 = this.a.z();
                    z9.d(3);
                } else if ("308".equals(parseFromEventContent.mEventId)) {
                    z7 = this.a.z();
                    if (z7.T() != 5 && !this.a.x().r && this.a.x().b != null) {
                        z8 = this.a.z();
                        z8.d(5);
                    }
                } else if ("318".equals(parseFromEventContent.mEventId)) {
                    z5 = this.a.z();
                    if (z5.T() != 3 && !this.a.x().r && this.a.x().b != null) {
                        z6 = this.a.z();
                        z6.d(3);
                    }
                } else if ("309".equals(parseFromEventContent.mEventId)) {
                    z3 = this.a.z();
                    if (z3.T() != 6) {
                        com.baidu.tieba.im.live.b.b().s();
                        z4 = this.a.z();
                        z4.d(6);
                    }
                } else if ("304".equals(parseFromEventContent.mEventId)) {
                    z = this.a.z();
                    if (z.T() != 1 && !this.a.x().r) {
                        z2 = this.a.z();
                        z2.d(1);
                    }
                }
            }
        }
    }
}
