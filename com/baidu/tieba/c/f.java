package com.baidu.tieba.c;

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
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f hwR = null;
    private c hwS;
    private c hwT;
    private ArrayList<TransmitForumData> hwU;
    private ArrayList<TransmitForumData> hwW;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean hwV = false;
    private boolean hwX = false;
    private boolean isLoading = false;

    public static f cgr() {
        if (hwR == null) {
            synchronized (f.class) {
                if (hwR == null) {
                    hwR = new f();
                }
            }
        }
        return hwR;
    }

    private f() {
        init();
    }

    private void init() {
        cgt();
        cgs();
        this.isLoading = false;
    }

    private void cgs() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.hwT = (c) runTask.getData();
        }
        if (this.hwT != null) {
            this.hwT.a(this);
        }
    }

    private void cgt() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.hwS = (c) runTask.getData();
        }
        if (this.hwS != null) {
            this.hwS.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = cgx();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bqv()) {
                cgu();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void cgu() {
        this.isLoading = true;
        if (this.hwS != null) {
            this.hwS.cgo();
        }
        if (this.hwT != null) {
            this.hwT.cgo();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.hwW = arrayList;
            }
            this.hwX = true;
        } else if (i == 2) {
            if (z) {
                this.hwU = arrayList;
                this.mPrivateThread = i2;
            }
            this.hwV = true;
        }
        cgv();
    }

    private void cgv() {
        if (this.hwS == null || this.hwV) {
            if (this.hwT == null || this.hwX) {
                this.hwV = false;
                this.hwX = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.hwU)) {
                    Iterator<TransmitForumData> it = this.hwU.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!eH(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.hwW)) {
                    Iterator<TransmitForumData> it2 = this.hwW.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!eH(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.hwU = null;
                this.hwW = null;
                cgw();
            }
        }
    }

    private void cgw() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean eH(long j) {
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

    private Location cgx() {
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
