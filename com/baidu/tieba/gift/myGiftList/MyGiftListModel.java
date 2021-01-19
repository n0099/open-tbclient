package com.baidu.tieba.gift.myGiftList;

import com.baidu.adp.base.BdBaseModel;
import com.baidu.adp.base.f;
import com.baidu.adp.framework.message.ResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigSocket;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.data.ai;
import com.baidu.tieba.gift.myGiftList.a;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
/* loaded from: classes8.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {
    private boolean hgB;
    private boolean iTr;
    private com.baidu.adp.framework.listener.a iWa;
    private boolean jOY;
    private com.baidu.tieba.gift.myGiftList.a jOZ;
    private a jPa;
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
        this.jOY = false;
        this.iTr = true;
        this.mUid = 0L;
        this.iWa = new com.baidu.adp.framework.listener.a(1003051, CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST) { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListModel.1
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
                        if (MyGiftListModel.this.jPa != null) {
                            MyGiftListModel.this.jPa.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.iTr, MyGiftListModel.this.jOZ);
                        }
                        MyGiftListModel.this.iTr = false;
                    }
                }
            }
        };
        this.hgB = true;
        this.mStType = str;
        this.iWa.getHttpMessageListener().setSelfListener(true);
        this.iWa.getSocketMessageListener().setSelfListener(true);
        registerListener(this.iWa);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, GetPersonalGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, 1003051, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cMf();
        return false;
    }

    @Override // com.baidu.adp.base.BdBaseModel
    public boolean cancelLoadData() {
        return false;
    }

    private GetPersonalGiftListRequest y(int i, long j) {
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

    private void cMf() {
        GetPersonalGiftListRequest y;
        if (!this.jOY) {
            y = y(1, this.mUid);
        } else {
            y = y(this.mPageNum + 1, this.mUid);
        }
        sendMessage(y);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.gift.myGiftList.a aVar) {
        int i = 0;
        if (aVar != null) {
            if (this.jOZ == null) {
                this.jOZ = new com.baidu.tieba.gift.myGiftList.a();
            }
            if (this.jOZ.cMa() == null) {
                this.jOZ.a(new a.b());
            }
            if (this.jOZ.cMb() == null) {
                this.jOZ.a(new a.c());
            }
            if (this.jOZ.getGiftList() == null) {
                this.jOZ.aE(new ArrayList<>());
            }
            this.jOZ.gu(aVar.cLY());
            this.jOZ.gv(aVar.cLZ());
            this.jOZ.a(aVar.cMa());
            this.jOZ.a(aVar.cMb());
            this.jOZ.jOv = aVar.jOv;
            if (aVar.urlTitleData != null) {
                this.jOZ.urlTitleData = new ai();
                this.jOZ.urlTitleData.eLL = aVar.urlTitleData.eLL;
                this.jOZ.urlTitleData.eLM = aVar.urlTitleData.eLM;
            }
            if (this.jOZ.cMa() != null) {
                this.mPageNum = this.jOZ.cMa().gXH;
                this.mHasMore = this.jOZ.cMa().jOB == 1;
            }
            if (aVar.getGiftList() != null && aVar.getGiftList().size() > 0) {
                if (this.jOY) {
                    ArrayList<a.C0740a> giftList = aVar.getGiftList();
                    int size = this.jOZ.getGiftList().size() + 1;
                    while (true) {
                        int i2 = size;
                        if (i < giftList.size()) {
                            a.C0740a c0740a = giftList.get(i);
                            if (c0740a != null) {
                                c0740a.jOA = i2;
                                size = i2 + 1;
                            } else {
                                size = i2;
                            }
                            i++;
                        } else {
                            this.jOZ.getGiftList().addAll(giftList);
                            return;
                        }
                    }
                } else {
                    this.jOZ.getGiftList().clear();
                    this.jOZ.getGiftList().addAll(aVar.getGiftList());
                }
            }
        }
    }

    private void KK(String str) {
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
        KK(String.valueOf(this.mUid));
    }

    public void setIsSelf(boolean z) {
        this.hgB = z;
    }

    public boolean getIsSelf() {
        return this.hgB;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void rI(boolean z) {
        this.jOY = z;
    }

    public void a(a aVar) {
        this.jPa = aVar;
    }
}
