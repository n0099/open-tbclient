package com.baidu.tieba.im.live.room;

import android.text.TextUtils;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.coreExtra.data.LiveChatRoomEventData;
import com.baidu.tbadk.coreExtra.message.LiveChatRoomEventResponseMessage;
/* loaded from: classes.dex */
class ag extends CustomMessageListener {
    final /* synthetic */ LiveRoomChatActivity a;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ag(LiveRoomChatActivity liveRoomChatActivity, int i) {
        super(i);
        this.a = liveRoomChatActivity;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.adp.framework.listener.MessageListener
    /* renamed from: a */
    public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
        LiveChatRoomEventData parseFromEventContent;
        LiveRoomChatView x;
        LiveRoomChatView x2;
        LiveRoomChatView x3;
        LiveRoomChatView x4;
        LiveRoomChatView x5;
        LiveRoomChatView x6;
        LiveRoomChatView x7;
        LiveRoomChatView x8;
        LiveRoomChatView x9;
        LiveRoomChatView x10;
        LiveRoomChatView x11;
        LiveRoomChatView x12;
        LiveRoomChatView x13;
        LiveRoomChatView x14;
        LiveRoomChatView x15;
        if (customResponsedMessage.getCmd() == 2001166 && (customResponsedMessage instanceof LiveChatRoomEventResponseMessage)) {
            String data = ((LiveChatRoomEventResponseMessage) customResponsedMessage).getData();
            if (!TextUtils.isEmpty(data) && (parseFromEventContent = LiveChatRoomEventData.parseFromEventContent(data)) != null) {
                String str = parseFromEventContent.mEventId;
                if (this.a.v().b != null && parseFromEventContent.mGroupId == this.a.v().b.groupId.intValue()) {
                    if ("302".equals(parseFromEventContent.mEventId)) {
                        if (parseFromEventContent.mListeners != this.a.v().h) {
                            this.a.v().h = parseFromEventContent.mListeners;
                            x15 = this.a.x();
                            x15.S().setUserCount(this.a.v().h);
                        }
                        this.a.v().i = parseFromEventContent.mLikers;
                        this.a.v().d = parseFromEventContent.mLikeUserList;
                        x14 = this.a.x();
                        x14.a(this.a.v().d, this.a.v().i, this.a.v().g);
                    } else if ("306".equals(parseFromEventContent.mEventId)) {
                        if (!TextUtils.isEmpty(parseFromEventContent.mPortrait) && !parseFromEventContent.mPortrait.equals(this.a.v().m)) {
                            this.a.v().m = parseFromEventContent.mPortrait;
                            x13 = this.a.x();
                            x13.g(this.a.v().m);
                        }
                        if (!TextUtils.isEmpty(parseFromEventContent.mName) && !parseFromEventContent.mName.equals(this.a.v().j)) {
                            this.a.v().j = parseFromEventContent.mName;
                            x12 = this.a.x();
                            x12.d(this.a.v().j);
                            if (!LiveRoomChatActivity.b) {
                                this.a.b(com.baidu.tieba.x.live_room_notify);
                            }
                        }
                        if (!TextUtils.isEmpty(parseFromEventContent.mIntro) && !parseFromEventContent.mIntro.equals(this.a.v().k)) {
                            this.a.v().k = parseFromEventContent.mIntro;
                            x11 = this.a.x();
                            x11.S().setNoteText(this.a.v().k);
                        }
                    } else if ("310".equals(parseFromEventContent.mEventId)) {
                        if (this.a.v().b != null && this.a.v().b.groupId.intValue() == parseFromEventContent.mGroupId && !this.a.v().r) {
                            com.baidu.tieba.im.live.d.b().s();
                            this.a.showToast(com.baidu.tieba.x.live_group_is_dismiss, false);
                            x10 = this.a.x();
                            x10.d(6);
                            this.a.finish();
                        }
                    } else if ("307".equals(parseFromEventContent.mEventId)) {
                        if (this.a.v().r || this.a.v().b == null) {
                            return;
                        }
                        this.a.b(this.a.v().b.streamId, String.valueOf(this.a.v().b.groupId), String.valueOf(this.a.v().b.deviceId), this.a.v().b.playUrl, true);
                        x9 = this.a.x();
                        x9.d(3);
                    } else if ("308".equals(parseFromEventContent.mEventId)) {
                        x7 = this.a.x();
                        if (x7.U() != 5 && !this.a.v().r && this.a.v().b != null) {
                            x8 = this.a.x();
                            x8.d(5);
                        }
                    } else if ("318".equals(parseFromEventContent.mEventId)) {
                        x5 = this.a.x();
                        if (x5.U() != 3 && !this.a.v().r && this.a.v().b != null) {
                            x6 = this.a.x();
                            x6.d(3);
                        }
                    } else if ("309".equals(parseFromEventContent.mEventId)) {
                        x3 = this.a.x();
                        if (x3.U() != 6) {
                            com.baidu.tieba.im.live.d.b().s();
                            x4 = this.a.x();
                            x4.d(6);
                        }
                    } else if ("304".equals(parseFromEventContent.mEventId)) {
                        x = this.a.x();
                        if (x.U() != 1 && !this.a.v().r) {
                            x2 = this.a.x();
                            x2.d(1);
                        }
                    }
                }
            }
        }
    }
}
