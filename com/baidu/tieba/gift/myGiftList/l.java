package com.baidu.tieba.gift.myGiftList;

import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbadkApplication;
/* loaded from: classes.dex */
public class l extends com.baidu.adp.base.e {
    private String aPd;
    private boolean bnj;
    private boolean bnk;
    private boolean mHasMore;
    private int mPageNum;
    private long mUid;

    /* JADX INFO: Access modifiers changed from: protected */
    public l(BaseActivity baseActivity, String str) {
        super(baseActivity.getPageContext());
        this.bnj = false;
        this.mUid = 0L;
        this.bnk = true;
        this.aPd = str;
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

    private MyGiftListRequestMessage f(int i, long j) {
        MyGiftListRequestMessage myGiftListRequestMessage = new MyGiftListRequestMessage();
        if (i < 1) {
            i = 1;
        }
        myGiftListRequestMessage.setPageNum(i);
        myGiftListRequestMessage.setUid(j);
        myGiftListRequestMessage.setStType(this.aPd);
        return myGiftListRequestMessage;
    }

    private void hp(String str) {
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
        hp(String.valueOf(this.mUid));
    }

    public void setIsSelf(boolean z) {
        this.bnk = z;
    }

    public boolean getIsSelf() {
        return this.bnk;
    }

    public void sendMessage() {
        MyGiftListRequestMessage f;
        if (this.bnk) {
            this.mUid = 0L;
        }
        if (!this.bnj) {
            f = f(1, this.mUid);
        } else {
            f = f(this.mPageNum, this.mUid);
        }
        sendMessage(f);
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

    public void cA(boolean z) {
        this.bnj = z;
    }

    public boolean Qy() {
        return this.bnj;
    }
}
