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
public class e implements a.InterfaceC0477a {
    private static e fKc = null;
    private a fKd;
    private a fKe;
    private ArrayList<TransmitForumData> fKf;
    private ArrayList<TransmitForumData> fKh;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean fKg = false;
    private boolean fKi = false;
    private boolean isLoading = false;

    public static e btE() {
        if (fKc == null) {
            synchronized (e.class) {
                if (fKc == null) {
                    fKc = new e();
                }
            }
        }
        return fKc;
    }

    private e() {
        init();
    }

    private void init() {
        btG();
        btF();
        this.isLoading = false;
    }

    private void btF() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.fKe = (a) runTask.getData();
        }
        if (this.fKe != null) {
            this.fKe.a(this);
        }
    }

    private void btG() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.fKd = (a) runTask.getData();
        }
        if (this.fKd != null) {
            this.fKd.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = btK();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                btH();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void btH() {
        this.isLoading = true;
        if (this.fKd != null) {
            this.fKd.btx();
        }
        if (this.fKe != null) {
            this.fKe.btx();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0477a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.fKh = arrayList;
            }
            this.fKi = true;
        } else if (i == 2) {
            if (z) {
                this.fKf = arrayList;
                this.mPrivateThread = i2;
            }
            this.fKg = true;
        }
        btI();
    }

    private void btI() {
        if (this.fKd == null || this.fKg) {
            if (this.fKe == null || this.fKi) {
                this.fKg = false;
                this.fKi = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.fKf)) {
                    Iterator<TransmitForumData> it = this.fKf.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dg(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.fKh)) {
                    Iterator<TransmitForumData> it2 = this.fKh.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dg(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.fKf = null;
                this.fKh = null;
                btJ();
            }
        }
    }

    private void btJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean dg(long j) {
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

    private Location btK() {
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
