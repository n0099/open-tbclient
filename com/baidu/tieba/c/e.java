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
    private static e eHk = null;
    private a eHl;
    private a eHm;
    private ArrayList<TransmitForumData> eHn;
    private ArrayList<TransmitForumData> eHp;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean eHo = false;
    private boolean eHq = false;
    private boolean isLoading = false;

    public static e aZz() {
        if (eHk == null) {
            synchronized (e.class) {
                if (eHk == null) {
                    eHk = new e();
                }
            }
        }
        return eHk;
    }

    private e() {
        init();
    }

    private void init() {
        aZB();
        aZA();
        this.isLoading = false;
    }

    private void aZA() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.eHm = (a) runTask.getData();
        }
        if (this.eHm != null) {
            this.eHm.a(this);
        }
    }

    private void aZB() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.eHl = (a) runTask.getData();
        }
        if (this.eHl != null) {
            this.eHl.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.cjA = aZF();
            }
            if (l.ki() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                aZC();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void aZC() {
        this.isLoading = true;
        if (this.eHl != null) {
            this.eHl.aZp();
        }
        if (this.eHm != null) {
            this.eHm.aZp();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0292a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.eHp = arrayList;
            }
            this.eHq = true;
        } else if (i == 2) {
            if (z) {
                this.eHn = arrayList;
                this.mPrivateThread = i2;
            }
            this.eHo = true;
        }
        aZD();
    }

    private void aZD() {
        if (this.eHl == null || this.eHo) {
            if (this.eHm == null || this.eHq) {
                this.eHo = false;
                this.eHq = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.aa(this.eHn)) {
                    Iterator<TransmitForumData> it = this.eHn.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!cF(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.aa(this.eHp)) {
                    Iterator<TransmitForumData> it2 = this.eHp.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!cF(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.eHn = null;
                this.eHp = null;
                aZE();
            }
        }
    }

    private void aZE() {
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

    private Location aZF() {
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
