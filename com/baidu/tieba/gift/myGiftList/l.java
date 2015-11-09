package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.e {
    private String aPl;
    private boolean bnN;
    private boolean bnO;
    private boolean mHasMore;
    private int mPageNum;
    private long mUid;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(BaseActivity baseActivity, String str) {
        super(baseActivity.getPageContext());
        this.bnN = false;
        this.mUid = 0L;
        this.bnO = true;
        this.aPl = str;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.baidu.adp.base.e
    public boolean LoadData() {
        sendMessage();
        return false;
    }

    @Override // com.baidu.adp.base.e
    public boolean cancelLoadData() {
        return false;
    }

    private MyGiftListRequestMessage e(int i, long j) {
        MyGiftListRequestMessage myGiftListRequestMessage = new MyGiftListRequestMessage();
        if (i < 1) {
            i = 1;
        }
        myGiftListRequestMessage.setPageNum(i);
        myGiftListRequestMessage.setUid(j);
        myGiftListRequestMessage.setStType(this.aPl);
        return myGiftListRequestMessage;
    }

    private void hr(String str) {
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
        hr(String.valueOf(this.mUid));
    }

    public void setIsSelf(boolean z) {
        this.bnO = z;
    }

    public boolean getIsSelf() {
        return this.bnO;
    }

    public void sendMessage() {
        MyGiftListRequestMessage e;
        if (this.bnO) {
            this.mUid = 0L;
        }
        if (!this.bnN) {
            e = e(1, this.mUid);
        } else {
            e = e(this.mPageNum, this.mUid);
        }
        sendMessage(e);
    }

    public boolean isHasMore() {
        return this.mHasMore;
    }

    public void setHasMore(boolean z) {
        this.mHasMore = z;
    }

    public int getPageNum() {
        return this.mPageNum;
    }

    public void setPageNum(int i) {
        this.mPageNum = i;
    }

    public void cC(boolean z) {
        this.bnN = z;
    }

    public boolean QQ() {
        return this.bnN;
    }
}
