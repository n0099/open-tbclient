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
    private static e gKn = null;
    private a gKo;
    private a gKp;
    private ArrayList<TransmitForumData> gKq;
    private ArrayList<TransmitForumData> gKs;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean gKr = false;
    private boolean gKt = false;
    private boolean isLoading = false;

    public static e bMy() {
        if (gKn == null) {
            synchronized (e.class) {
                if (gKn == null) {
                    gKn = new e();
                }
            }
        }
        return gKn;
    }

    private e() {
        init();
    }

    private void init() {
        bMA();
        bMz();
        this.isLoading = false;
    }

    private void bMz() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.gKp = (a) runTask.getData();
        }
        if (this.gKp != null) {
            this.gKp.a(this);
        }
    }

    private void bMA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.gKo = (a) runTask.getData();
        }
        if (this.gKo != null) {
            this.gKo.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bME();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bMB();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bMB() {
        this.isLoading = true;
        if (this.gKo != null) {
            this.gKo.bMq();
        }
        if (this.gKp != null) {
            this.gKp.bMq();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0596a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.gKs = arrayList;
            }
            this.gKt = true;
        } else if (i == 2) {
            if (z) {
                this.gKq = arrayList;
                this.mPrivateThread = i2;
            }
            this.gKr = true;
        }
        bMC();
    }

    private void bMC() {
        if (this.gKo == null || this.gKr) {
            if (this.gKp == null || this.gKt) {
                this.gKr = false;
                this.gKt = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.gKq)) {
                    Iterator<TransmitForumData> it = this.gKq.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dW(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.gKs)) {
                    Iterator<TransmitForumData> it2 = this.gKs.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dW(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.gKq = null;
                this.gKs = null;
                bMD();
            }
        }
    }

    private void bMD() {
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

    private Location bME() {
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
