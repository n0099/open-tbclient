package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
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
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f iDG = null;
    private c iDH;
    private c iDI;
    private ArrayList<TransmitForumData> iDJ;
    private ArrayList<TransmitForumData> iDL;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean iDK = false;
    private boolean iDM = false;
    private boolean isLoading = false;

    public static f ctG() {
        if (iDG == null) {
            synchronized (f.class) {
                if (iDG == null) {
                    iDG = new f();
                }
            }
        }
        return iDG;
    }

    private f() {
        init();
    }

    private void init() {
        ctI();
        ctH();
        this.isLoading = false;
    }

    private void ctH() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.iDI = (c) runTask.getData();
        }
        if (this.iDI != null) {
            this.iDI.a(this);
        }
    }

    private void ctI() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.iDH = (c) runTask.getData();
        }
        if (this.iDH != null) {
            this.iDH.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = ctM();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bzg()) {
                ctJ();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void ctJ() {
        this.isLoading = true;
        if (this.iDH != null) {
            this.iDH.ctD();
        }
        if (this.iDI != null) {
            this.iDI.ctD();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.iDL = arrayList;
            }
            this.iDM = true;
        } else if (i == 2) {
            if (z) {
                this.iDJ = arrayList;
                this.mPrivateThread = i2;
            }
            this.iDK = true;
        }
        ctK();
    }

    private void ctK() {
        if (this.iDH == null || this.iDK) {
            if (this.iDI == null || this.iDM) {
                this.iDK = false;
                this.iDM = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.iDJ)) {
                    Iterator<TransmitForumData> it = this.iDJ.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!gh(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.iDL)) {
                    Iterator<TransmitForumData> it2 = this.iDL.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!gh(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.iDJ = null;
                this.iDL = null;
                ctL();
            }
        }
    }

    private void ctL() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean gh(long j) {
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

    private Location ctM() {
        if (ae.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
            LocationManager locationManager = (LocationManager) TbadkCoreApplication.getInst().getSystemService(Headers.LOCATION);
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
