package com.baidu.tieba.d;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.d.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f ipT = null;
    private c ipU;
    private c ipV;
    private ArrayList<TransmitForumData> ipW;
    private ArrayList<TransmitForumData> ipY;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean ipX = false;
    private boolean ipZ = false;
    private boolean isLoading = false;

    public static f ctk() {
        if (ipT == null) {
            synchronized (f.class) {
                if (ipT == null) {
                    ipT = new f();
                }
            }
        }
        return ipT;
    }

    private f() {
        init();
    }

    private void init() {
        ctm();
        ctl();
        this.isLoading = false;
    }

    private void ctl() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.ipV = (c) runTask.getData();
        }
        if (this.ipV != null) {
            this.ipV.a(this);
        }
    }

    private void ctm() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.ipU = (c) runTask.getData();
        }
        if (this.ipU != null) {
            this.ipU.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = ctq();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bAn()) {
                ctn();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void ctn() {
        this.isLoading = true;
        if (this.ipU != null) {
            this.ipU.cth();
        }
        if (this.ipV != null) {
            this.ipV.cth();
        }
    }

    @Override // com.baidu.tieba.d.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.ipY = arrayList;
            }
            this.ipZ = true;
        } else if (i == 2) {
            if (z) {
                this.ipW = arrayList;
                this.mPrivateThread = i2;
            }
            this.ipX = true;
        }
        cto();
    }

    private void cto() {
        if (this.ipU == null || this.ipX) {
            if (this.ipV == null || this.ipZ) {
                this.ipX = false;
                this.ipZ = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.ipW)) {
                    Iterator<TransmitForumData> it = this.ipW.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!gc(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.ipY)) {
                    Iterator<TransmitForumData> it2 = this.ipY.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!gc(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.ipW = null;
                this.ipY = null;
                ctp();
            }
        }
    }

    private void ctp() {
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

    private Location ctq() {
        if (ae.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
