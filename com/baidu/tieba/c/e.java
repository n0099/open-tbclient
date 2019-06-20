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
public class e implements a.InterfaceC0292a {
    private static e eHl = null;
    private a eHm;
    private a eHn;
    private ArrayList<TransmitForumData> eHo;
    private ArrayList<TransmitForumData> eHq;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean eHp = false;
    private boolean eHr = false;
    private boolean isLoading = false;

    public static e aZC() {
        if (eHl == null) {
            synchronized (e.class) {
                if (eHl == null) {
                    eHl = new e();
                }
            }
        }
        return eHl;
    }

    private e() {
        init();
    }

    private void init() {
        aZE();
        aZD();
        this.isLoading = false;
    }

    private void aZD() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.eHn = (a) runTask.getData();
        }
        if (this.eHn != null) {
            this.eHn.a(this);
        }
    }

    private void aZE() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.eHm = (a) runTask.getData();
        }
        if (this.eHm != null) {
            this.eHm.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.cjB = aZI();
            }
            if (l.ki() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                aZF();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void aZF() {
        this.isLoading = true;
        if (this.eHm != null) {
            this.eHm.aZs();
        }
        if (this.eHn != null) {
            this.eHn.aZs();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0292a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.eHq = arrayList;
            }
            this.eHr = true;
        } else if (i == 2) {
            if (z) {
                this.eHo = arrayList;
                this.mPrivateThread = i2;
            }
            this.eHp = true;
        }
        aZG();
    }

    private void aZG() {
        if (this.eHm == null || this.eHp) {
            if (this.eHn == null || this.eHr) {
                this.eHp = false;
                this.eHr = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.aa(this.eHo)) {
                    Iterator<TransmitForumData> it = this.eHo.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!cF(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.aa(this.eHq)) {
                    Iterator<TransmitForumData> it2 = this.eHq.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!cF(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.eHo = null;
                this.eHq = null;
                aZH();
            }
        }
    }

    private void aZH() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean cF(long j) {
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

    private Location aZI() {
        if (ab.cw(TbadkCoreApplication.getInst())) {
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
