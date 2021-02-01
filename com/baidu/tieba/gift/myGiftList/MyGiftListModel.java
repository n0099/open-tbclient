package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.aj;
import com.baidu.tieba.gift.myGiftList.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes9.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {
    private boolean hkR;
    private boolean iYY;
    private boolean jWA;
    private com.baidu.tieba.gift.myGiftList.a jWB;
    private a jWC;
    private com.baidu.adp.framework.listener.a jbH;
    private boolean mHasMore;
    private int mPageNum;
    private String mStType;
    private long mUid;
    public int mUserType;

    /* loaded from: classes9.dex */
    public interface a {
        void a(int i, String str, boolean z, com.baidu.tieba.gift.myGiftList.a aVar);
    }

    public MyGiftListModel(f<MyGiftListActivity> fVar, String str) {
        super(fVar);
        this.jWA = false;
        this.iYY = true;
        this.mUid = 0L;
        this.jbH = new com.baidu.adp.framework.listener.a(1003051, CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST) { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListModel.1
            @Override // com.baidu.adp.framework.listener.a
            public void onMessage(ResponsedMessage<?> responsedMessage) {
                if (responsedMessage != null) {
                    if ((responsedMessage instanceof GetPersonalGiftListHttpResponseMessage) || (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage)) {
                        if (responsedMessage.getError() == 0) {
                            if (responsedMessage instanceof GetPersonalGiftListHttpResponseMessage) {
                                MyGiftListModel.this.a(((GetPersonalGiftListHttpResponseMessage) responsedMessage).getGiftListData());
                            } else if (responsedMessage instanceof GetPersonalGiftListSocketResponseMessage) {
                                MyGiftListModel.this.a(((GetPersonalGiftListSocketResponseMessage) responsedMessage).getGiftListData());
                            }
                        }
                        if (MyGiftListModel.this.jWC != null) {
                            MyGiftListModel.this.jWC.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.iYY, MyGiftListModel.this.jWB);
                        }
                        MyGiftListModel.this.iYY = false;
                    }
                }
            }
        };
        this.hkR = true;
        this.mStType = str;
        this.jbH.getHttpMessageListener().setSelfListener(true);
        this.jbH.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jbH);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, GetPersonalGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, 1003051, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cOc();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private GetPersonalGiftListRequest z(int i, long j) {
        GetPersonalGiftListRequest getPersonalGiftListRequest = new GetPersonalGiftListRequest();
        if (i < 1) {
            i = 1;
        }
        getPersonalGiftListRequest.setPageNumber(i);
        getPersonalGiftListRequest.setUserId(j);
        getPersonalGiftListRequest.setType(this.mStType);
        getPersonalGiftListRequest.userType = this.mUserType;
        this.mPageNum = i;
        return getPersonalGiftListRequest;
    }

    private void cOc() {
        GetPersonalGiftListRequest z;
        if (!this.jWA) {
            z = z(1, this.mUid);
        } else {
            z = z(this.mPageNum + 1, this.mUid);
        }
        sendMessage(z);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.gift.myGiftList.a aVar) {
        int i = 0;
        if (aVar != null) {
            if (this.jWB == null) {
                this.jWB = new com.baidu.tieba.gift.myGiftList.a();
            }
            if (this.jWB.cNX() == null) {
                this.jWB.a(new a.b());
            }
            if (this.jWB.cNY() == null) {
                this.jWB.a(new a.c());
            }
            if (this.jWB.getGiftList() == null) {
                this.jWB.aD(new ArrayList<>());
            }
            this.jWB.gz(aVar.cNV());
            this.jWB.gA(aVar.cNW());
            this.jWB.a(aVar.cNX());
            this.jWB.a(aVar.cNY());
            this.jWB.jVX = aVar.jVX;
            if (aVar.urlTitleData != null) {
                this.jWB.urlTitleData = new aj();
                this.jWB.urlTitleData.eNX = aVar.urlTitleData.eNX;
                this.jWB.urlTitleData.eNY = aVar.urlTitleData.eNY;
            }
            if (this.jWB.cNX() != null) {
                this.mPageNum = this.jWB.cNX().har;
                this.mHasMore = this.jWB.cNX().jWd == 1;
            }
            if (aVar.getGiftList() != null && aVar.getGiftList().size() > 0) {
                if (this.jWA) {
                    ArrayList<a.C0741a> giftList = aVar.getGiftList();
                    int size = this.jWB.getGiftList().size() + 1;
                    while (true) {
                        int i2 = size;
                        if (i < giftList.size()) {
                            a.C0741a c0741a = giftList.get(i);
                            if (c0741a != null) {
                                c0741a.jWc = i2;
                                size = i2 + 1;
                            } else {
                                size = i2;
                            }
                            i++;
                        } else {
                            this.jWB.getGiftList().addAll(giftList);
                            return;
                        }
                    }
                } else {
                    this.jWB.getGiftList().clear();
                    this.jWB.getGiftList().addAll(aVar.getGiftList());
                }
            }
        }
    }

    private void Lx(String str) {
        if (str != null && str.length() > 0 && !str.equals("0") && !str.startsWith(Constants.ACCEPT_TIME_SEPARATOR_SERVER)) {
            if (TbadkApplication.getCurrentAccount() != null && TbadkApplication.getCurrentAccount().equals(str)) {
                setIsSelf(true);
            } else {
                setIsSelf(false);
            }
        }
    }

    public long getUid() {
        return this.mUid;
    }

    public void setUid(long j) {
        this.mUid = j;
        Lx(String.valueOf(this.mUid));
    }

    public void setIsSelf(boolean z) {
        this.hkR = z;
    }

    public boolean getIsSelf() {
        return this.hkR;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void rT(boolean z) {
        this.jWA = z;
    }

    public void a(a aVar) {
        this.jWC = aVar;
    }
}
