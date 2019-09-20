package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.v;
import com.baidu.tbadk.util.i;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0304a {
    private static e eNV = null;
    private a eNW;
    private a eNX;
    private ArrayList<TransmitForumData> eNY;
    private ArrayList<TransmitForumData> eOa;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean eNZ = false;
    private boolean eOb = false;
    private boolean isLoading = false;

    public static e bch() {
        if (eNV == null) {
            synchronized (e.class) {
                if (eNV == null) {
                    eNV = new e();
                }
            }
        }
        return eNV;
    }

    private e() {
        init();
    }

    private void init() {
        bcj();
        bci();
        this.isLoading = false;
    }

    private void bci() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.eNX = (a) runTask.getData();
        }
        if (this.eNX != null) {
            this.eNX.a(this);
        }
    }

    private void bcj() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.eNW = (a) runTask.getData();
        }
        if (this.eNW != null) {
            this.eNW.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.clI = bcn();
            }
            if (l.kt() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bck();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void bck() {
        this.isLoading = true;
        if (this.eNW != null) {
            this.eNW.bbX();
        }
        if (this.eNX != null) {
            this.eNX.bbX();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0304a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.eOa = arrayList;
            }
            this.eOb = true;
        } else if (i == 2) {
            if (z) {
                this.eNY = arrayList;
                this.mPrivateThread = i2;
            }
            this.eNZ = true;
        }
        bcl();
    }

    private void bcl() {
        if (this.eNW == null || this.eNZ) {
            if (this.eNX == null || this.eOb) {
                this.eNZ = false;
                this.eOb = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.aa(this.eNY)) {
                    Iterator<TransmitForumData> it = this.eNY.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!cN(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.aa(this.eOa)) {
                    Iterator<TransmitForumData> it2 = this.eOa.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!cN(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.eNY = null;
                this.eOa = null;
                bcm();
            }
        }
    }

    private void bcm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean cN(long j) {
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

    private Location bcn() {
        if (ab.cx(TbadkCoreApplication.getInst())) {
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
