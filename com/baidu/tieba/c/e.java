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
import com.baidu.tbadk.util.g;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0205a {
    private static e det = null;
    private a deu;
    private a dev;
    private ArrayList<TransmitForumData> dew;
    private ArrayList<TransmitForumData> dey;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean dex = false;
    private boolean dez = false;
    private boolean isLoading = false;

    public static e aro() {
        if (det == null) {
            synchronized (e.class) {
                if (det == null) {
                    det = new e();
                }
            }
        }
        return det;
    }

    private e() {
        init();
    }

    private void init() {
        arq();
        arp();
        this.isLoading = false;
    }

    private void arp() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.dev = (a) runTask.getData();
        }
        if (this.dev != null) {
            this.dev.a(this);
        }
    }

    private void arq() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.deu = (a) runTask.getData();
        }
        if (this.deu != null) {
            this.deu.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aSh = aru();
            }
            if (l.ll() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                arr();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void arr() {
        this.isLoading = true;
        if (this.deu != null) {
            this.deu.ard();
        }
        if (this.dev != null) {
            this.dev.ard();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0205a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.dey = arrayList;
            }
            this.dez = true;
        } else if (i == 2) {
            if (z) {
                this.dew = arrayList;
                this.mPrivateThread = i2;
            }
            this.dex = true;
        }
        ars();
    }

    private void ars() {
        if (this.deu == null || this.dex) {
            if (this.dev == null || this.dez) {
                this.dex = false;
                this.dez = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.I(this.dew)) {
                    Iterator<TransmitForumData> it = this.dew.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bD(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.I(this.dey)) {
                    Iterator<TransmitForumData> it2 = this.dey.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bD(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.dew = null;
                this.dey = null;
                art();
            }
        }
    }

    private void art() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bD(long j) {
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

    private Location aru() {
        if (ab.bC(TbadkCoreApplication.getInst())) {
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
