package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigHttp;
import com.baidu.tieba.gift.myGiftList.a;
import java.util.ArrayList;
/* loaded from: classes.dex */
public class j extends com.baidu.adp.base.e<MyGiftListActivity> {
    private String aUo;
    private boolean aWG;
    private com.baidu.adp.framework.listener.a aWh;
    private boolean bwI;
    private boolean bwJ;
    private com.baidu.tieba.gift.myGiftList.a bwK;
    private a bwL;
    private boolean mHasMore;
    private int mPageNum;
    private long mUid;

    /* loaded from: classes.dex */
    public interface a {
        void a(int i, String str, boolean z, com.baidu.tieba.gift.myGiftList.a aVar);
    }

    public j(com.baidu.adp.base.h<MyGiftListActivity> hVar, String str) {
        super(hVar);
        this.bwI = false;
        this.aWG = true;
        this.mUid = 0L;
        this.aWh = new k(this, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, 309052);
        this.bwJ = true;
        this.aUo = str;
        this.aWh.getHttpMessageListener().setSelfListener(true);
        this.aWh.getSocketMessageListener().setSelfListener(true);
        registerListener(this.aWh);
        com.baidu.tieba.tbadkCore.a.a.a(309052, GetPersonalGiftListSocketResponseMessage.class, false, false);
        com.baidu.tieba.tbadkCore.a.a.a(309052, CmdConfigHttp.CMD_GET_PERSONAL_GIFT_LIST, TbConfig.GET_PERSONAL_GIFT_LIST, GetPersonalGiftListHttpResponseMessage.class, false, false, false, false);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        vN();
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private GetPersonalGiftListRequest e(int i, long j) {
        GetPersonalGiftListRequest getPersonalGiftListRequest = new GetPersonalGiftListRequest();
        if (i < 1) {
            i = 1;
        }
        getPersonalGiftListRequest.setPageNumber(i);
        getPersonalGiftListRequest.setUserId(j);
        getPersonalGiftListRequest.setType(this.aUo);
        this.mPageNum = i;
        return getPersonalGiftListRequest;
    }

    private void vN() {
        GetPersonalGiftListRequest e;
        new GetPersonalGiftListRequest();
        if (!this.bwI) {
            e = e(1, this.mUid);
        } else {
            e = e(this.mPageNum + 1, this.mUid);
        }
        sendMessage(e);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(com.baidu.tieba.gift.myGiftList.a aVar) {
        if (aVar != null) {
            if (this.bwK == null) {
                this.bwK = new com.baidu.tieba.gift.myGiftList.a();
            }
            if (this.bwK.Tr() == null) {
                this.bwK.a(new a.b());
            }
            if (this.bwK.Ts() == null) {
                this.bwK.a(new a.c());
            }
            if (this.bwK.getGiftList() == null) {
                this.bwK.I(new ArrayList<>());
            }
            this.bwK.aH(aVar.Tp());
            this.bwK.aI(aVar.Tq());
            this.bwK.a(aVar.Tr());
            this.bwK.a(aVar.Ts());
            if (this.bwK.Tr() != null) {
                this.mPageNum = this.bwK.Tr().bwn;
                this.mHasMore = this.bwK.Tr().hasMore == 1;
            }
            if (aVar.getGiftList() != null && aVar.getGiftList().size() > 0) {
                if (this.bwI) {
                    this.bwK.getGiftList().addAll(aVar.getGiftList());
                    return;
                }
                this.bwK.getGiftList().clear();
                this.bwK.getGiftList().addAll(aVar.getGiftList());
            }
        }
    }

    private void hL(String str) {
        if (str != null && str.length() > 0 && !str.equals("0") && !str.startsWith("-")) {
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
        hL(String.valueOf(this.mUid));
    }

    public void setIsSelf(boolean z) {
        this.bwJ = z;
    }

    public boolean getIsSelf() {
        return this.bwJ;
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void cV(boolean z) {
        this.bwI = z;
    }

    public void a(a aVar) {
        this.bwL = aVar;
    }
}
