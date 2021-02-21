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
    private boolean hlf;
    private boolean iZm;
    private boolean jWO;
    private com.baidu.tieba.gift.myGiftList.a jWP;
    private a jWQ;
    private com.baidu.adp.framework.listener.a jbV;
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
        this.jWO = false;
        this.iZm = true;
        this.mUid = 0L;
        this.jbV = new com.baidu.adp.framework.listener.a(1003051, CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST) { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListModel.1
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
                        if (MyGiftListModel.this.jWQ != null) {
                            MyGiftListModel.this.jWQ.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.iZm, MyGiftListModel.this.jWP);
                        }
                        MyGiftListModel.this.iZm = false;
                    }
                }
            }
        };
        this.hlf = true;
        this.mStType = str;
        this.jbV.getHttpMessageListener().setSelfListener(true);
        this.jbV.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jbV);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, GetPersonalGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, 1003051, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cOj();
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

    private void cOj() {
        GetPersonalGiftListRequest z;
        if (!this.jWO) {
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
            if (this.jWP == null) {
                this.jWP = new com.baidu.tieba.gift.myGiftList.a();
            }
            if (this.jWP.cOe() == null) {
                this.jWP.a(new a.b());
            }
            if (this.jWP.cOf() == null) {
                this.jWP.a(new a.c());
            }
            if (this.jWP.getGiftList() == null) {
                this.jWP.aD(new ArrayList<>());
            }
            this.jWP.gz(aVar.cOc());
            this.jWP.gA(aVar.cOd());
            this.jWP.a(aVar.cOe());
            this.jWP.a(aVar.cOf());
            this.jWP.jWl = aVar.jWl;
            if (aVar.urlTitleData != null) {
                this.jWP.urlTitleData = new aj();
                this.jWP.urlTitleData.eNX = aVar.urlTitleData.eNX;
                this.jWP.urlTitleData.eNY = aVar.urlTitleData.eNY;
            }
            if (this.jWP.cOe() != null) {
                this.mPageNum = this.jWP.cOe().haF;
                this.mHasMore = this.jWP.cOe().jWr == 1;
            }
            if (aVar.getGiftList() != null && aVar.getGiftList().size() > 0) {
                if (this.jWO) {
                    ArrayList<a.C0742a> giftList = aVar.getGiftList();
                    int size = this.jWP.getGiftList().size() + 1;
                    while (true) {
                        int i2 = size;
                        if (i < giftList.size()) {
                            a.C0742a c0742a = giftList.get(i);
                            if (c0742a != null) {
                                c0742a.jWq = i2;
                                size = i2 + 1;
                            } else {
                                size = i2;
                            }
                            i++;
                        } else {
                            this.jWP.getGiftList().addAll(giftList);
                            return;
                        }
                    }
                } else {
                    this.jWP.getGiftList().clear();
                    this.jWP.getGiftList().addAll(aVar.getGiftList());
                }
            }
        }
    }

    private void Ly(String str) {
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
        Ly(String.valueOf(this.mUid));
    }

    public void setIsSelf(boolean z) {
        this.hlf = z;
    }

    public boolean getIsSelf() {
        return this.hlf;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void rT(boolean z) {
        this.jWO = z;
    }

    public void a(a aVar) {
        this.jWQ = aVar;
    }
}
