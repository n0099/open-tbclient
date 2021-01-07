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
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.x;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f iCp = null;
    private c iCq;
    private c iCr;
    private ArrayList<TransmitForumData> iCs;
    private ArrayList<TransmitForumData> iCu;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean iCt = false;
    private boolean iCv = false;
    private boolean isLoading = false;

    public static f cwf() {
        if (iCp == null) {
            synchronized (f.class) {
                if (iCp == null) {
                    iCp = new f();
                }
            }
        }
        return iCp;
    }

    private f() {
        init();
    }

    private void init() {
        cwh();
        cwg();
        this.isLoading = false;
    }

    private void cwg() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.iCr = (c) runTask.getData();
        }
        if (this.iCr != null) {
            this.iCr.a(this);
        }
    }

    private void cwh() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.iCq = (c) runTask.getData();
        }
        if (this.iCq != null) {
            this.iCq.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = cwl();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bCI()) {
                cwi();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void cwi() {
        this.isLoading = true;
        if (this.iCq != null) {
            this.iCq.cwc();
        }
        if (this.iCr != null) {
            this.iCr.cwc();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.iCu = arrayList;
            }
            this.iCv = true;
        } else if (i == 2) {
            if (z) {
                this.iCs = arrayList;
                this.mPrivateThread = i2;
            }
            this.iCt = true;
        }
        cwj();
    }

    private void cwj() {
        if (this.iCq == null || this.iCt) {
            if (this.iCr == null || this.iCv) {
                this.iCt = false;
                this.iCv = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!x.isEmpty(this.iCs)) {
                    Iterator<TransmitForumData> it = this.iCs.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!gc(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!x.isEmpty(this.iCu)) {
                    Iterator<TransmitForumData> it2 = this.iCu.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!gc(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.iCs = null;
                this.iCu = null;
                cwk();
            }
        }
    }

    private void cwk() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean gc(long j) {
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

    private Location cwl() {
        if (ad.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
