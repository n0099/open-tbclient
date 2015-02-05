package com.baidu.tieba.im.floatwindow.view;

import android.text.TextUtils;
import android.view.View;
import android.view.ViewStub;
import android.view.Window;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.data.ImMessageCenterShowItemData;
import com.baidu.tbadk.core.data.UserData;
import com.baidu.tieba.im.chat.CommonPersonalMsglistView;
import com.baidu.tieba.im.chat.MsglistActivity;
import com.baidu.tieba.im.chat.TalkableActivity;
import com.baidu.tieba.im.db.pojo.ImMessageCenterPojo;
import com.baidu.tieba.im.message.MemoryChangedMessage;
import com.baidu.tieba.im.settingcache.PersonalSettingItemData;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/* loaded from: classes.dex */
public class FloatingPersonalChatView extends CommonPersonalMsglistView {
    private com.baidu.adp.lib.g.e aZL;
    private Runnable alf;
    private FloatingPersonalChatActivity bac;
    private LinearLayout bad;
    private i bae;
    private i baf;
    private i bag;
    private i bah;
    private boolean bai;
    private boolean baj;
    private boolean bak;
    private View.OnClickListener bal;
    private as bam;
    private n ban;
    private ap bao;
    private ao bap;
    private int currentIndex;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* JADX INFO: Access modifiers changed from: private */
    public void exit() {
        if (this.bad != null) {
            this.bad.removeCallbacks(this.alf);
        }
        this.bac.finish();
        com.baidu.tieba.im.floatwindow.b.No().Nx();
        com.baidu.tieba.im.floatwindow.b.No().cJ(false);
        com.baidu.tieba.im.floatwindow.b.No().Ns();
    }

    public void Oe() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.ban.gD(userData.getUserName());
            this.ban.fP(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.im.floatwindow.b.No().gB(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.bac.fQ(i);
            Oe();
            Ok();
            Of();
        }
    }

    private void Of() {
        sendGovoiceEvent();
        sendmsgShowText();
        afterSendMsgText();
    }

    public FloatingPersonalChatView(FloatingPersonalChatActivity floatingPersonalChatActivity, boolean z, List<UserData> list) {
        super(floatingPersonalChatActivity, z);
        this.mList = new LinkedList<>();
        this.mUserDataList = null;
        this.bai = false;
        this.baj = false;
        this.bak = false;
        this.bal = new ae(this);
        this.alf = new ag(this);
        this.bam = new ah(this);
        this.bap = new ai(this);
        this.aZL = new aj(this);
        this.bac = floatingPersonalChatActivity;
        getListMain().setBackgroundColor(this.bac.getPageContext().getPageActivity().getResources().getColor(com.baidu.tieba.t.float_chat_list_background));
        this.bad = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.w.floating_personal_chat_header_stub)).inflate();
        this.bad.setOnClickListener(new ak(this));
        this.mUserDataList = this.bac.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.bao = new ap();
        this.bao.a(this.bam);
        this.bao.at(this.mUserDataList);
        this.bae = new i((RelativeLayout) this.bad.findViewById(com.baidu.tieba.w.im_floating_head_first), 0);
        this.baf = new i((RelativeLayout) this.bad.findViewById(com.baidu.tieba.w.im_floating_head_second), 1);
        this.bag = new i((RelativeLayout) this.bad.findViewById(com.baidu.tieba.w.im_floating_head_third), 2);
        this.bah = new i((RelativeLayout) this.bad.findViewById(com.baidu.tieba.w.im_floating_head_fourth), 3);
        this.bae.setOnClickListener(this.bal);
        this.baf.setOnClickListener(this.bal);
        this.bag.setOnClickListener(this.bal);
        this.bah.setOnClickListener(this.bal);
        this.bae.a(this.bap);
        this.baf.a(this.bap);
        this.bag.a(this.bap);
        this.bah.a(this.bap);
        this.ban = new n(((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.w.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null && this.mUserDataList.get(this.currentIndex) != null) {
            this.ban.gD(this.mUserDataList.get(this.currentIndex).getUserName());
        }
        if (this.mUserDataList != null) {
            this.ban.fP(this.bao.b(this.mUserDataList.get(this.currentIndex)));
        }
        Ok();
        if (this.bad != null) {
            this.bad.post(this.alf);
        }
    }

    public void Og() {
        this.bai = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.bah.a((com.baidu.adp.lib.g.e) null);
            this.bag.a((com.baidu.adp.lib.g.e) null);
            this.baf.a((com.baidu.adp.lib.g.e) null);
            this.bae.a((com.baidu.adp.lib.g.e) null);
        }
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsgsendVoice(MsglistActivity msglistActivity) {
        super.initMsgsendVoice(msglistActivity);
        this.mBtnMsgSendSoftkey.setOnClickListener(new al(this));
        this.mBtnMsgSendMore1.setOnClickListener(new am(this));
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initMsgsendText(TalkableActivity talkableActivity) {
        super.initMsgsendText(talkableActivity);
        this.mBtnMsgSendGovoice.setOnClickListener(new an(this));
        this.mBtnMsgSendMore2.setOnClickListener(new af(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean Oh() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public void Oi() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.baj) {
                    this.baj = true;
                    exit();
                }
            } else if (!this.bak) {
                this.bae.b(this.aZL);
                this.baf.b((com.baidu.adp.lib.g.e) null);
                this.bag.b((com.baidu.adp.lib.g.e) null);
                this.bah.b((com.baidu.adp.lib.g.e) null);
            }
        }
    }

    public void b(long j, int i) {
        this.bao.F(String.valueOf(j), i);
        this.ban.fP(this.bao.gG(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.f fVar) {
        this.ban.refreshPersonalHeadFooter(str, fVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.ban.w(onClickListener);
    }

    public boolean gE(String str) {
        return this.bao.gE(str);
    }

    public int gF(String str) {
        return this.bao.gG(str);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    public void initHeader(TalkableActivity talkableActivity, boolean z) {
        super.initPersonalHeader(talkableActivity, z);
        Window window = talkableActivity.getWindow();
        if (window != null) {
            window.setBackgroundDrawableResource(com.baidu.tieba.t.floating_chat_bg);
        }
        this.mNavigationBar.setVisibility(8);
        this.mRootView.setBackgroundDrawable(null);
    }

    public void f(CustomResponsedMessage<?> customResponsedMessage) {
        boolean z = true;
        if (customResponsedMessage instanceof MemoryChangedMessage) {
            MemoryChangedMessage memoryChangedMessage = (MemoryChangedMessage) customResponsedMessage;
            ImMessageCenterPojo data = memoryChangedMessage.getData();
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.im.floatwindow.b.No().gy(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    a(data);
                }
                boolean Ol = Ol();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                Oj();
                if (this.bai) {
                    Ok();
                    if (Ol) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        cL(z);
                    }
                }
            }
        }
    }

    private void Oj() {
        int i;
        if (this.mUserDataList != null && this.mUserDataList.size() > 4) {
            if (this.currentIndex == 0) {
                i = 1;
            } else {
                this.currentIndex--;
                i = 0;
            }
            while (this.mUserDataList.size() > 4) {
                UserData remove = this.mUserDataList.remove(i);
                if (remove != null) {
                    com.baidu.tieba.im.floatwindow.b.No().gC(remove.getUserId());
                    Iterator<ImMessageCenterShowItemData> it = this.mList.iterator();
                    while (true) {
                        if (!it.hasNext()) {
                            break;
                        }
                        ImMessageCenterShowItemData next = it.next();
                        if (next != null && TextUtils.equals(remove.getUserId(), next.getFriendId())) {
                            this.mList.remove(next);
                            break;
                        }
                    }
                }
            }
        }
    }

    private void cL(boolean z) {
        if (!z) {
            this.bae.NZ();
        }
        this.baf.NZ();
        this.bag.NZ();
        this.bah.NZ();
    }

    public void fS(int i) {
        if (i > 0) {
            this.bae.Oa();
        }
        if (i > 1) {
            this.baf.Oa();
        }
        if (i > 2) {
            this.bag.Oa();
        }
    }

    public void Ok() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.im.floatwindow.b.No().D(userData.getPortrait(), userData.getConcern_num());
                        a(i, true, userData);
                    }
                } else {
                    a(i, false, null);
                }
                i++;
            }
        }
    }

    private void a(int i, boolean z, UserData userData) {
        switch (i) {
            case 0:
                this.bae.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.baf.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.bag.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.bah.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean Ol() {
        if (this.mUserDataList == null) {
            return false;
        }
        int size = this.mUserDataList.size();
        UserData userData = this.mUserDataList.get(this.currentIndex);
        if (userData != null) {
            for (int i = 0; i < this.mList.size(); i++) {
                ImMessageCenterShowItemData imMessageCenterShowItemData = this.mList.get(i);
                if (imMessageCenterShowItemData != null && imMessageCenterShowItemData.getUnReadCount() > 0 && !imMessageCenterShowItemData.getFriendId().equals(userData.getUserId())) {
                    int index = getIndex(imMessageCenterShowItemData.getFriendId());
                    if (index != -1) {
                        UserData userData2 = this.mUserDataList.get(index);
                        if (userData2 != null) {
                            userData2.setConcern_num(imMessageCenterShowItemData.getUnReadCount());
                        }
                    } else {
                        UserData userData3 = new UserData();
                        userData3.setUserId(imMessageCenterShowItemData.getFriendId());
                        userData3.setPortrait(imMessageCenterShowItemData.getFriendPortrait());
                        userData3.setConcern_num(imMessageCenterShowItemData.getUnReadCount());
                        userData3.setIsFriend(imMessageCenterShowItemData.getFriendStatus());
                        if (imMessageCenterShowItemData.getFriendStatus() == 1) {
                            this.bao.F(userData3.getUserId(), 1);
                        } else {
                            this.bao.F(userData3.getUserId(), 0);
                        }
                        userData3.setUserName(imMessageCenterShowItemData.getFriendName());
                        this.mUserDataList.add(userData3);
                    }
                }
            }
            return this.mUserDataList.size() - size > 0;
        }
        return false;
    }

    private int getIndex(String str) {
        if (this.mUserDataList == null || this.mUserDataList.size() <= 0) {
            return -1;
        }
        int i = 0;
        while (true) {
            int i2 = i;
            if (i2 >= this.mUserDataList.size()) {
                return -1;
            }
            if (this.mUserDataList.get(i2) == null || !TextUtils.equals(this.mUserDataList.get(i2).getUserId(), str)) {
                i = i2 + 1;
            } else {
                return i2;
            }
        }
    }

    private void a(ImMessageCenterPojo imMessageCenterPojo) {
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGid()) && isNeed(imMessageCenterPojo)) {
            ImMessageCenterShowItemData removeItem = removeItem(imMessageCenterPojo);
            if (isNeed(imMessageCenterPojo) && imMessageCenterPojo.getCustomGroupType() == 2) {
                processPrivate(imMessageCenterPojo, removeItem);
            }
        }
    }

    private void processPrivate(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        ImMessageCenterShowItemData buildNormalItem;
        if (imMessageCenterPojo != null && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && !TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) && (buildNormalItem = buildNormalItem(imMessageCenterPojo, imMessageCenterShowItemData)) != null) {
            buildNormalItem.setSendStatus(imMessageCenterPojo.getSend_status());
            buildNormalItem.setOwnerName(String.valueOf(4));
            PersonalSettingItemData aG = com.baidu.tieba.im.settingcache.j.Tp().aG(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (aG != null) {
                buildNormalItem.setGroupSetting(aG);
            }
            buildNormalItem.setFriendStatus(imMessageCenterPojo.getIsFriend());
            insertShowData(buildNormalItem, this.mList);
        }
    }

    protected void insertShowData(ImMessageCenterShowItemData imMessageCenterShowItemData, List<ImMessageCenterShowItemData> list) {
        if (imMessageCenterShowItemData != null && list != null) {
            int size = list.size();
            int i = 0;
            while (i < size) {
                ImMessageCenterShowItemData imMessageCenterShowItemData2 = list.get(i);
                if (imMessageCenterShowItemData2 != null && imMessageCenterShowItemData2.getServerTime() < imMessageCenterShowItemData.getServerTime()) {
                    break;
                }
                i++;
            }
            list.add(i, imMessageCenterShowItemData);
        }
    }

    protected ImMessageCenterShowItemData buildNormalItem(ImMessageCenterPojo imMessageCenterPojo, ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterPojo == null) {
            return null;
        }
        if (imMessageCenterPojo.getIs_hidden() == 1 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || imMessageCenterPojo.getLast_content_time() == 0) {
            return null;
        }
        if (imMessageCenterShowItemData == null) {
            imMessageCenterShowItemData = new ImMessageCenterShowItemData();
        }
        imMessageCenterShowItemData.setFriendId(imMessageCenterPojo.getGid());
        imMessageCenterShowItemData.setOwnerId(TbadkCoreApplication.getCurrentAccount());
        imMessageCenterShowItemData.setFriendName(imMessageCenterPojo.getGroup_name());
        imMessageCenterShowItemData.setFriendPortrait(imMessageCenterPojo.getGroup_head());
        imMessageCenterShowItemData.setServerTime(imMessageCenterPojo.getLast_content_time());
        imMessageCenterShowItemData.setUnReadCount(imMessageCenterPojo.getUnread_count());
        if (TextUtils.isEmpty(imMessageCenterPojo.getLast_content())) {
            imMessageCenterPojo.setLast_content("");
            imMessageCenterShowItemData.setUnReadCount(0);
        }
        imMessageCenterShowItemData.setMsgContent(imMessageCenterPojo.getLast_content());
        return imMessageCenterShowItemData;
    }

    private boolean isNeed(ImMessageCenterPojo imMessageCenterPojo) {
        return (imMessageCenterPojo == null || imMessageCenterPojo.getCustomGroupType() != 2 || imMessageCenterPojo.getIsFriend() != 1 || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name()) || TextUtils.isEmpty(imMessageCenterPojo.getGroup_name())) ? false : true;
    }

    private ImMessageCenterShowItemData removeItem(ImMessageCenterPojo imMessageCenterPojo) {
        int size = this.mList.size();
        for (int i = 0; i < size; i++) {
            ImMessageCenterShowItemData imMessageCenterShowItemData = this.mList.get(i);
            if (imMessageCenterPojo.getGid().equals(imMessageCenterShowItemData.getFriendId()) && imMessageCenterPojo.getCustomGroupType() == getCustomGroupType(imMessageCenterShowItemData)) {
                return this.mList.remove(i);
            }
        }
        return null;
    }

    private int getCustomGroupType(ImMessageCenterShowItemData imMessageCenterShowItemData) {
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(1))) {
            return 1;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(3))) {
            return -3;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(2))) {
            return -4;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(6))) {
            return -5;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(5))) {
            return -8;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(8))) {
            return 4;
        }
        if (imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(4))) {
            return 2;
        }
        if (!imMessageCenterShowItemData.getOwnerName().equals(String.valueOf(7))) {
            return 0;
        }
        return -7;
    }
}
