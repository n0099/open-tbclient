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
public class e implements a.InterfaceC0596a {
    private static e gKc = null;
    private a gKd;
    private a gKe;
    private ArrayList<TransmitForumData> gKf;
    private ArrayList<TransmitForumData> gKh;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean gKg = false;
    private boolean gKi = false;
    private boolean isLoading = false;

    public static e bMw() {
        if (gKc == null) {
            synchronized (e.class) {
                if (gKc == null) {
                    gKc = new e();
                }
            }
        }
        return gKc;
    }

    private e() {
        init();
    }

    private void init() {
        bMy();
        bMx();
        this.isLoading = false;
    }

    private void bMx() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.gKe = (a) runTask.getData();
        }
        if (this.gKe != null) {
            this.gKe.a(this);
        }
    }

    private void bMy() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.gKd = (a) runTask.getData();
        }
        if (this.gKd != null) {
            this.gKd.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bMC();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bMz();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bMz() {
        this.isLoading = true;
        if (this.gKd != null) {
            this.gKd.bMo();
        }
        if (this.gKe != null) {
            this.gKe.bMo();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0596a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.gKh = arrayList;
            }
            this.gKi = true;
        } else if (i == 2) {
            if (z) {
                this.gKf = arrayList;
                this.mPrivateThread = i2;
            }
            this.gKg = true;
        }
        bMA();
    }

    private void bMA() {
        if (this.gKd == null || this.gKg) {
            if (this.gKe == null || this.gKi) {
                this.gKg = false;
                this.gKi = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.gKf)) {
                    Iterator<TransmitForumData> it = this.gKf.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dW(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.gKh)) {
                    Iterator<TransmitForumData> it2 = this.gKh.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dW(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.gKf = null;
                this.gKh = null;
                bMB();
            }
        }
    }

    private void bMB() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean dW(long j) {
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

    private Location bMC() {
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
