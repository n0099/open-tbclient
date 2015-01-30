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
    private com.baidu.adp.lib.g.e aZM;
    private Runnable ali;
    private FloatingPersonalChatActivity bad;
    private LinearLayout bae;
    private i baf;
    private i bag;
    private i bah;
    private i bai;
    private boolean baj;
    private boolean bak;
    private boolean bal;
    private View.OnClickListener bam;
    private as ban;
    private n bao;
    private ap bap;
    private ao baq;
    private int currentIndex;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* JADX INFO: Access modifiers changed from: private */
    public void exit() {
        if (this.bae != null) {
            this.bae.removeCallbacks(this.ali);
        }
        this.bad.finish();
        com.baidu.tieba.im.floatwindow.b.Nt().NC();
        com.baidu.tieba.im.floatwindow.b.Nt().cJ(false);
        com.baidu.tieba.im.floatwindow.b.Nt().Nx();
    }

    public void Oj() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.bao.gG(userData.getUserName());
            this.bao.fP(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fR(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.im.floatwindow.b.Nt().gE(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.bad.fQ(i);
            Oj();
            Op();
            Ok();
        }
    }

    private void Ok() {
        sendGovoiceEvent();
        sendmsgShowText();
        afterSendMsgText();
    }

    public FloatingPersonalChatView(FloatingPersonalChatActivity floatingPersonalChatActivity, boolean z, List<UserData> list) {
        super(floatingPersonalChatActivity, z);
        this.mList = new LinkedList<>();
        this.mUserDataList = null;
        this.baj = false;
        this.bak = false;
        this.bal = false;
        this.bam = new ae(this);
        this.ali = new ag(this);
        this.ban = new ah(this);
        this.baq = new ai(this);
        this.aZM = new aj(this);
        this.bad = floatingPersonalChatActivity;
        getListMain().setBackgroundColor(this.bad.getPageContext().getPageActivity().getResources().getColor(com.baidu.tieba.t.float_chat_list_background));
        this.bae = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.w.floating_personal_chat_header_stub)).inflate();
        this.bae.setOnClickListener(new ak(this));
        this.mUserDataList = this.bad.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.bap = new ap();
        this.bap.a(this.ban);
        this.bap.at(this.mUserDataList);
        this.baf = new i((RelativeLayout) this.bae.findViewById(com.baidu.tieba.w.im_floating_head_first), 0);
        this.bag = new i((RelativeLayout) this.bae.findViewById(com.baidu.tieba.w.im_floating_head_second), 1);
        this.bah = new i((RelativeLayout) this.bae.findViewById(com.baidu.tieba.w.im_floating_head_third), 2);
        this.bai = new i((RelativeLayout) this.bae.findViewById(com.baidu.tieba.w.im_floating_head_fourth), 3);
        this.baf.setOnClickListener(this.bam);
        this.bag.setOnClickListener(this.bam);
        this.bah.setOnClickListener(this.bam);
        this.bai.setOnClickListener(this.bam);
        this.baf.a(this.baq);
        this.bag.a(this.baq);
        this.bah.a(this.baq);
        this.bai.a(this.baq);
        this.bao = new n(((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.w.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null && this.mUserDataList.get(this.currentIndex) != null) {
            this.bao.gG(this.mUserDataList.get(this.currentIndex).getUserName());
        }
        if (this.mUserDataList != null) {
            this.bao.fP(this.bap.b(this.mUserDataList.get(this.currentIndex)));
        }
        Op();
        if (this.bae != null) {
            this.bae.post(this.ali);
        }
    }

    public void Ol() {
        this.baj = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.bai.a((com.baidu.adp.lib.g.e) null);
            this.bah.a((com.baidu.adp.lib.g.e) null);
            this.bag.a((com.baidu.adp.lib.g.e) null);
            this.baf.a((com.baidu.adp.lib.g.e) null);
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
    public boolean Om() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public void On() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.bak) {
                    this.bak = true;
                    exit();
                }
            } else if (!this.bal) {
                this.baf.b(this.aZM);
                this.bag.b((com.baidu.adp.lib.g.e) null);
                this.bah.b((com.baidu.adp.lib.g.e) null);
                this.bai.b((com.baidu.adp.lib.g.e) null);
            }
        }
    }

    public void b(long j, int i) {
        this.bap.F(String.valueOf(j), i);
        this.bao.fP(this.bap.gJ(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.f fVar) {
        this.bao.refreshPersonalHeadFooter(str, fVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.bao.w(onClickListener);
    }

    public boolean gH(String str) {
        return this.bap.gH(str);
    }

    public int gI(String str) {
        return this.bap.gJ(str);
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
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.im.floatwindow.b.Nt().gB(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    a(data);
                }
                boolean Oq = Oq();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                Oo();
                if (this.baj) {
                    Op();
                    if (Oq) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        cL(z);
                    }
                }
            }
        }
    }

    private void Oo() {
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
                    com.baidu.tieba.im.floatwindow.b.Nt().gF(remove.getUserId());
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
            this.baf.Oe();
        }
        this.bag.Oe();
        this.bah.Oe();
        this.bai.Oe();
    }

    public void fS(int i) {
        if (i > 0) {
            this.baf.Of();
        }
        if (i > 1) {
            this.bag.Of();
        }
        if (i > 2) {
            this.bah.Of();
        }
    }

    public void Op() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.im.floatwindow.b.Nt().D(userData.getPortrait(), userData.getConcern_num());
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
                this.baf.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.bag.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.bah.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.bai.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean Oq() {
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
                            this.bap.F(userData3.getUserId(), 1);
                        } else {
                            this.bap.F(userData3.getUserId(), 0);
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
            PersonalSettingItemData aG = com.baidu.tieba.im.settingcache.j.Tu().aG(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
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
