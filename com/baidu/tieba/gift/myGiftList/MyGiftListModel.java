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
/* loaded from: classes8.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {
    private boolean hmO;
    private boolean jYQ;
    private com.baidu.tieba.gift.myGiftList.a jYR;
    private a jYS;
    private boolean jaV;
    private com.baidu.adp.framework.listener.a jdE;
    private boolean mHasMore;
    private int mPageNum;
    private String mStType;
    private long mUid;
    public int mUserType;

    /* loaded from: classes8.dex */
    public interface a {
        void a(int i, String str, boolean z, com.baidu.tieba.gift.myGiftList.a aVar);
    }

    public MyGiftListModel(f<MyGiftListActivity> fVar, String str) {
        super(fVar);
        this.jYQ = false;
        this.jaV = true;
        this.mUid = 0L;
        this.jdE = new com.baidu.adp.framework.listener.a(1003051, CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST) { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListModel.1
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
                        if (MyGiftListModel.this.jYS != null) {
                            MyGiftListModel.this.jYS.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.jaV, MyGiftListModel.this.jYR);
                        }
                        MyGiftListModel.this.jaV = false;
                    }
                }
            }
        };
        this.hmO = true;
        this.mStType = str;
        this.jdE.getHttpMessageListener().setSelfListener(true);
        this.jdE.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jdE);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, GetPersonalGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, 1003051, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cOq();
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

    private void cOq() {
        GetPersonalGiftListRequest z;
        if (!this.jYQ) {
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
            if (this.jYR == null) {
                this.jYR = new com.baidu.tieba.gift.myGiftList.a();
            }
            if (this.jYR.cOl() == null) {
                this.jYR.a(new a.b());
            }
            if (this.jYR.cOm() == null) {
                this.jYR.a(new a.c());
            }
            if (this.jYR.getGiftList() == null) {
                this.jYR.aD(new ArrayList<>());
            }
            this.jYR.gz(aVar.cOj());
            this.jYR.gA(aVar.cOk());
            this.jYR.a(aVar.cOl());
            this.jYR.a(aVar.cOm());
            this.jYR.jYn = aVar.jYn;
            if (aVar.urlTitleData != null) {
                this.jYR.urlTitleData = new aj();
                this.jYR.urlTitleData.ePy = aVar.urlTitleData.ePy;
                this.jYR.urlTitleData.ePz = aVar.urlTitleData.ePz;
            }
            if (this.jYR.cOl() != null) {
                this.mPageNum = this.jYR.cOl().hco;
                this.mHasMore = this.jYR.cOl().jYt == 1;
            }
            if (aVar.getGiftList() != null && aVar.getGiftList().size() > 0) {
                if (this.jYQ) {
                    ArrayList<a.C0748a> giftList = aVar.getGiftList();
                    int size = this.jYR.getGiftList().size() + 1;
                    while (true) {
                        int i2 = size;
                        if (i < giftList.size()) {
                            a.C0748a c0748a = giftList.get(i);
                            if (c0748a != null) {
                                c0748a.jYs = i2;
                                size = i2 + 1;
                            } else {
                                size = i2;
                            }
                            i++;
                        } else {
                            this.jYR.getGiftList().addAll(giftList);
                            return;
                        }
                    }
                } else {
                    this.jYR.getGiftList().clear();
                    this.jYR.getGiftList().addAll(aVar.getGiftList());
                }
            }
        }
    }

    private void LE(String str) {
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
        LE(String.valueOf(this.mUid));
    }

    public void setIsSelf(boolean z) {
        this.hmO = z;
    }

    public boolean getIsSelf() {
        return this.hmO;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void rT(boolean z) {
        this.jYQ = z;
    }

    public void a(a aVar) {
        this.jYS = aVar;
    }
}
