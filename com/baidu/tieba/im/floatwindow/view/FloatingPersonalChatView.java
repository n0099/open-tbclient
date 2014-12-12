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
    private FloatingPersonalChatActivity aYH;
    private LinearLayout aYI;
    private i aYJ;
    private i aYK;
    private i aYL;
    private i aYM;
    private boolean aYN;
    private boolean aYO;
    private boolean aYP;
    private View.OnClickListener aYQ;
    private as aYR;
    private n aYS;
    private ap aYT;
    private ao aYU;
    private com.baidu.adp.lib.g.e aYq;
    private Runnable akA;
    private int currentIndex;
    protected final LinkedList<ImMessageCenterShowItemData> mList;
    private List<UserData> mUserDataList;

    /* JADX INFO: Access modifiers changed from: private */
    public void exit() {
        if (this.aYI != null) {
            this.aYI.removeCallbacks(this.akA);
        }
        this.aYH.finish();
        com.baidu.tieba.im.floatwindow.b.MX().Ng();
        com.baidu.tieba.im.floatwindow.b.MX().cE(false);
        com.baidu.tieba.im.floatwindow.b.MX().Nb();
    }

    public void NN() {
        UserData userData;
        if (this.mUserDataList != null && !this.mUserDataList.isEmpty() && (userData = this.mUserDataList.get(this.currentIndex)) != null) {
            this.aYS.gB(userData.getUserName());
            this.aYS.fK(userData.getIsFriend());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void fM(int i) {
        if (i < this.mUserDataList.size() && i >= 0) {
            this.currentIndex = i;
            if (this.mUserDataList.get(i) != null) {
                com.baidu.tieba.im.floatwindow.b.MX().gz(this.mUserDataList.get(i).getUserId());
                this.mUserDataList.get(i).setConcern_num(0);
            }
            this.aYH.fL(i);
            NN();
            NT();
            NO();
        }
    }

    private void NO() {
        sendGovoiceEvent();
        sendmsgShowText();
        afterSendMsgText();
    }

    public FloatingPersonalChatView(FloatingPersonalChatActivity floatingPersonalChatActivity, boolean z, List<UserData> list) {
        super(floatingPersonalChatActivity, z);
        this.mList = new LinkedList<>();
        this.mUserDataList = null;
        this.aYN = false;
        this.aYO = false;
        this.aYP = false;
        this.aYQ = new ae(this);
        this.akA = new ag(this);
        this.aYR = new ah(this);
        this.aYU = new ai(this);
        this.aYq = new aj(this);
        this.aYH = floatingPersonalChatActivity;
        getListMain().setBackgroundColor(this.aYH.getPageContext().getPageActivity().getResources().getColor(com.baidu.tieba.t.float_chat_list_background));
        this.aYI = (LinearLayout) ((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.w.floating_personal_chat_header_stub)).inflate();
        this.aYI.setOnClickListener(new ak(this));
        this.mUserDataList = this.aYH.getUserDataList();
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            this.currentIndex = this.mUserDataList.size() - 1;
        }
        this.aYT = new ap();
        this.aYT.a(this.aYR);
        this.aYT.ar(this.mUserDataList);
        this.aYJ = new i((RelativeLayout) this.aYI.findViewById(com.baidu.tieba.w.im_floating_head_first), 0);
        this.aYK = new i((RelativeLayout) this.aYI.findViewById(com.baidu.tieba.w.im_floating_head_second), 1);
        this.aYL = new i((RelativeLayout) this.aYI.findViewById(com.baidu.tieba.w.im_floating_head_third), 2);
        this.aYM = new i((RelativeLayout) this.aYI.findViewById(com.baidu.tieba.w.im_floating_head_fourth), 3);
        this.aYJ.setOnClickListener(this.aYQ);
        this.aYK.setOnClickListener(this.aYQ);
        this.aYL.setOnClickListener(this.aYQ);
        this.aYM.setOnClickListener(this.aYQ);
        this.aYJ.a(this.aYU);
        this.aYK.a(this.aYU);
        this.aYL.a(this.aYU);
        this.aYM.a(this.aYU);
        this.aYS = new n(((ViewStub) floatingPersonalChatActivity.findViewById(com.baidu.tieba.w.floating_personal_chat_info_stub)).inflate());
        if (this.mUserDataList != null && this.mUserDataList.get(this.currentIndex) != null) {
            this.aYS.gB(this.mUserDataList.get(this.currentIndex).getUserName());
        }
        if (this.mUserDataList != null) {
            this.aYS.fK(this.aYT.b(this.mUserDataList.get(this.currentIndex)));
        }
        NT();
        if (this.aYI != null) {
            this.aYI.post(this.akA);
        }
    }

    public void NP() {
        this.aYN = true;
        if (this.mUserDataList != null && this.mUserDataList.size() > 1) {
            this.aYM.a((com.baidu.adp.lib.g.e) null);
            this.aYL.a((com.baidu.adp.lib.g.e) null);
            this.aYK.a((com.baidu.adp.lib.g.e) null);
            this.aYJ.a((com.baidu.adp.lib.g.e) null);
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
    public boolean NQ() {
        return this.mUserDataList == null || this.mUserDataList.isEmpty() || this.currentIndex < 0 || this.currentIndex >= this.mUserDataList.size() || this.mUserDataList.get(this.currentIndex) == null;
    }

    public void NR() {
        if (this.mUserDataList != null) {
            if (this.mUserDataList.size() <= 1) {
                if (!this.aYO) {
                    this.aYO = true;
                    exit();
                }
            } else if (!this.aYP) {
                this.aYJ.b(this.aYq);
                this.aYK.b((com.baidu.adp.lib.g.e) null);
                this.aYL.b((com.baidu.adp.lib.g.e) null);
                this.aYM.b((com.baidu.adp.lib.g.e) null);
            }
        }
    }

    public void b(long j, int i) {
        this.aYT.F(String.valueOf(j), i);
        this.aYS.fK(this.aYT.gE(String.valueOf(j)));
    }

    public void a(String str, com.baidu.tbadk.coreExtra.relationship.f fVar) {
        this.aYS.refreshPersonalHeadFooter(str, fVar);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.aYS.v(onClickListener);
    }

    public boolean gC(String str) {
        return this.aYT.gC(str);
    }

    public int gD(String str) {
        return this.aYT.gE(str);
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
            if (data.getCustomGroupType() == 2 && !com.baidu.tieba.im.floatwindow.b.MX().gw(data.getGid())) {
                if (memoryChangedMessage.getType() == 1) {
                    a(data);
                }
                boolean NU = NU();
                boolean z2 = this.currentIndex == 0;
                boolean z3 = this.mUserDataList.size() > 4;
                NS();
                if (this.aYN) {
                    NT();
                    if (NU) {
                        if (!z2 || !z3) {
                            z = false;
                        }
                        cG(z);
                    }
                }
            }
        }
    }

    private void NS() {
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
                    com.baidu.tieba.im.floatwindow.b.MX().gA(remove.getUserId());
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

    private void cG(boolean z) {
        if (!z) {
            this.aYJ.NI();
        }
        this.aYK.NI();
        this.aYL.NI();
        this.aYM.NI();
    }

    public void fN(int i) {
        if (i > 0) {
            this.aYJ.NJ();
        }
        if (i > 1) {
            this.aYK.NJ();
        }
        if (i > 2) {
            this.aYL.NJ();
        }
    }

    public void NT() {
        if (this.mUserDataList != null && this.mUserDataList.size() > 0) {
            int size = this.mUserDataList.size();
            int i = 0;
            while (i < 4) {
                if (i < size) {
                    UserData userData = this.mUserDataList.get(i);
                    if (userData != null) {
                        com.baidu.tieba.im.floatwindow.b.MX().D(userData.getPortrait(), userData.getConcern_num());
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
                this.aYJ.a(z, userData, this.currentIndex);
                return;
            case 1:
                this.aYK.a(z, userData, this.currentIndex);
                return;
            case 2:
                this.aYL.a(z, userData, this.currentIndex);
                return;
            case 3:
                this.aYM.a(z, userData, this.currentIndex);
                return;
            default:
                return;
        }
    }

    @Override // com.baidu.tieba.im.chat.AbsMsglistView
    protected boolean isPersonal() {
        return true;
    }

    private boolean NU() {
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
                            this.aYT.F(userData3.getUserId(), 1);
                        } else {
                            this.aYT.F(userData3.getUserId(), 0);
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
            PersonalSettingItemData aD = com.baidu.tieba.im.settingcache.j.SY().aD(TbadkCoreApplication.getCurrentAccount(), imMessageCenterPojo.getGid());
            if (aD != null) {
                buildNormalItem.setGroupSetting(aD);
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
