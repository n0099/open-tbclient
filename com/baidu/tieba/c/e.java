package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0481a {
    private static e fNl = null;
    private a fNm;
    private a fNn;
    private ArrayList<TransmitForumData> fNo;
    private ArrayList<TransmitForumData> fNq;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean fNp = false;
    private boolean fNr = false;
    private boolean isLoading = false;

    public static e buG() {
        if (fNl == null) {
            synchronized (e.class) {
                if (fNl == null) {
                    fNl = new e();
                }
            }
        }
        return fNl;
    }

    private e() {
        init();
    }

    private void init() {
        buI();
        buH();
        this.isLoading = false;
    }

    private void buH() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.fNn = (a) runTask.getData();
        }
        if (this.fNn != null) {
            this.fNn.a(this);
        }
    }

    private void buI() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.fNm = (a) runTask.getData();
        }
        if (this.fNm != null) {
            this.fNm.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = buM();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                buJ();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void buJ() {
        this.isLoading = true;
        if (this.fNm != null) {
            this.fNm.buz();
        }
        if (this.fNn != null) {
            this.fNn.buz();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0481a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.fNq = arrayList;
            }
            this.fNr = true;
        } else if (i == 2) {
            if (z) {
                this.fNo = arrayList;
                this.mPrivateThread = i2;
            }
            this.fNp = true;
        }
        buK();
    }

    private void buK() {
        if (this.fNm == null || this.fNp) {
            if (this.fNn == null || this.fNr) {
                this.fNp = false;
                this.fNr = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.fNo)) {
                    Iterator<TransmitForumData> it = this.fNo.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dl(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.fNq)) {
                    Iterator<TransmitForumData> it2 = this.fNq.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dl(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.fNo = null;
                this.fNq = null;
                buL();
            }
        }
    }

    private void buL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean dl(long j) {
        if (this.mForumList == null) {
            return false;
        }
        Iterator<TransmitForumData> it = this.mForumList.iterator();
        while (it.hasNext()) {
            TransmitForumData next = it.next();
            if (next != null && next.forumId == j) {
                return true;
            }
        }
        return false;
    }

    private Location buM() {
        if (ab.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
            LocationManager locationManager = (LocationManager) TbadkCoreApplication.getInst().getSystemService("location");
            Criteria criteria = new Criteria();
            criteria.setAccuracy(1);
            criteria.setAltitudeRequired(false);
            criteria.setBearingRequired(false);
            criteria.setCostAllowed(true);
            criteria.setPowerRequirement(1);
            try {
                return locationManager.getLastKnownLocation(locationManager.getBestProvider(criteria, false));
            } catch (Exception e) {
                return null;
            }
        }
        return null;
    }
}
