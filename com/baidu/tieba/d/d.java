package com.baidu.tieba.d;

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
import com.baidu.tieba.d.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class d implements a.InterfaceC0124a {
    private static d czk = null;
    private a czl;
    private a czm;
    private ArrayList<TransmitForumData> czn;
    private ArrayList<TransmitForumData> czp;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean czo = false;
    private boolean czq = false;
    private boolean isLoading = false;

    public static d ahh() {
        if (czk == null) {
            synchronized (d.class) {
                if (czk == null) {
                    czk = new d();
                }
            }
        }
        return czk;
    }

    private d() {
        init();
    }

    private void init() {
        ahj();
        ahi();
        this.isLoading = false;
    }

    private void ahi() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.czm = (a) runTask.getData();
        }
        if (this.czm != null) {
            this.czm.a(this);
        }
    }

    private void ahj() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.czl = (a) runTask.getData();
        }
        if (this.czl != null) {
            this.czl.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.awX = ahm();
            }
            if (l.hg() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                this.isLoading = true;
                if (this.czl != null) {
                    this.czl.ahc();
                }
                if (this.czm != null) {
                    this.czm.ahc();
                }
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0124a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.czp = arrayList;
            }
            this.czq = true;
        } else if (i == 2) {
            if (z) {
                this.czn = arrayList;
                this.mPrivateThread = i2;
            }
            this.czo = true;
        }
        ahk();
    }

    private void ahk() {
        if (this.czl == null || this.czo) {
            if (this.czm == null || this.czq) {
                this.czo = false;
                this.czq = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.w(this.czn)) {
                    Iterator<TransmitForumData> it = this.czn.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bn(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.w(this.czp)) {
                    Iterator<TransmitForumData> it2 = this.czp.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bn(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.czn = null;
                this.czp = null;
                ahl();
            }
        }
    }

    private void ahl() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bn(long j) {
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

    private Location ahm() {
        if (ab.aC(TbadkCoreApplication.getInst())) {
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
