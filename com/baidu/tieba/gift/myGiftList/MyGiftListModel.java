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
/* loaded from: classes9.dex */
public class MyGiftListModel extends BdBaseModel<MyGiftListActivity> {
    private boolean hli;
    private boolean iXY;
    private boolean jTD;
    private com.baidu.tieba.gift.myGiftList.a jTE;
    private a jTF;
    private com.baidu.adp.framework.listener.a jaH;
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
        this.jTD = false;
        this.iXY = true;
        this.mUid = 0L;
        this.jaH = new com.baidu.adp.framework.listener.a(1003051, CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST) { // from class: com.baidu.tieba.gift.myGiftList.MyGiftListModel.1
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
                        if (MyGiftListModel.this.jTF != null) {
                            MyGiftListModel.this.jTF.a(responsedMessage.getError(), responsedMessage.getErrorString(), MyGiftListModel.this.iXY, MyGiftListModel.this.jTE);
                        }
                        MyGiftListModel.this.iXY = false;
                    }
                }
            }
        };
        this.hli = true;
        this.mStType = str;
        this.jaH.getHttpMessageListener().setSelfListener(true);
        this.jaH.getSocketMessageListener().setSelfListener(true);
        registerListener(this.jaH);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, GetPersonalGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(CmdConfigSocket.CMD_GET_PERSONAL_GIFT_LIST, 1003051, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.BdBaseModel
    public boolean LoadData() {
        cPX();
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

    private void cPX() {
        GetPersonalGiftListRequest y;
        if (!this.jTD) {
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
            if (this.jTE == null) {
                this.jTE = new com.baidu.tieba.gift.myGiftList.a();
            }
            if (this.jTE.cPS() == null) {
                this.jTE.a(new a.b());
            }
            if (this.jTE.cPT() == null) {
                this.jTE.a(new a.c());
            }
            if (this.jTE.getGiftList() == null) {
                this.jTE.aJ(new ArrayList<>());
            }
            this.jTE.gu(aVar.cPQ());
            this.jTE.gv(aVar.cPR());
            this.jTE.a(aVar.cPS());
            this.jTE.a(aVar.cPT());
            this.jTE.jTa = aVar.jTa;
            if (aVar.urlTitleData != null) {
                this.jTE.urlTitleData = new ai();
                this.jTE.urlTitleData.eQw = aVar.urlTitleData.eQw;
                this.jTE.urlTitleData.eQx = aVar.urlTitleData.eQx;
            }
            if (this.jTE.cPS() != null) {
                this.mPageNum = this.jTE.cPS().hcn;
                this.mHasMore = this.jTE.cPS().jTg == 1;
            }
            if (aVar.getGiftList() != null && aVar.getGiftList().size() > 0) {
                if (this.jTD) {
                    ArrayList<a.C0757a> giftList = aVar.getGiftList();
                    int size = this.jTE.getGiftList().size() + 1;
                    while (true) {
                        int i2 = size;
                        if (i < giftList.size()) {
                            a.C0757a c0757a = giftList.get(i);
                            if (c0757a != null) {
                                c0757a.jTf = i2;
                                size = i2 + 1;
                            } else {
                                size = i2;
                            }
                            i++;
                        } else {
                            this.jTE.getGiftList().addAll(giftList);
                            return;
                        }
                    }
                } else {
                    this.jTE.getGiftList().clear();
                    this.jTE.getGiftList().addAll(aVar.getGiftList());
                }
            }
        }
    }

    private void LR(String str) {
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
        LR(String.valueOf(this.mUid));
    }

    public void setIsSelf(boolean z) {
        this.hli = z;
    }

    public boolean getIsSelf() {
        return this.hli;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void rM(boolean z) {
        this.jTD = z;
    }

    public void a(a aVar) {
        this.jTF = aVar;
    }
}
