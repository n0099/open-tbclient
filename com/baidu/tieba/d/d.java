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
public class d implements a.InterfaceC0139a {
    private static d dgn = null;
    private a dgo;
    private a dgp;
    private ArrayList<TransmitForumData> dgq;
    private ArrayList<TransmitForumData> dgs;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean dgr = false;
    private boolean dgt = false;
    private boolean isLoading = false;

    public static d ani() {
        if (dgn == null) {
            synchronized (d.class) {
                if (dgn == null) {
                    dgn = new d();
                }
            }
        }
        return dgn;
    }

    private d() {
        init();
    }

    private void init() {
        ank();
        anj();
        this.isLoading = false;
    }

    private void anj() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.dgp = (a) runTask.getData();
        }
        if (this.dgp != null) {
            this.dgp.a(this);
        }
    }

    private void ank() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.dgo = (a) runTask.getData();
        }
        if (this.dgo != null) {
            this.dgo.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.blp = ann();
            }
            if (l.pa() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                this.isLoading = true;
                if (this.dgo != null) {
                    this.dgo.and();
                }
                if (this.dgp != null) {
                    this.dgp.and();
                }
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0139a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.dgs = arrayList;
            }
            this.dgt = true;
        } else if (i == 2) {
            if (z) {
                this.dgq = arrayList;
                this.mPrivateThread = i2;
            }
            this.dgr = true;
        }
        anl();
    }

    private void anl() {
        if (this.dgo == null || this.dgr) {
            if (this.dgp == null || this.dgt) {
                this.dgr = false;
                this.dgt = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.E(this.dgq)) {
                    Iterator<TransmitForumData> it = this.dgq.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bp(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.E(this.dgs)) {
                    Iterator<TransmitForumData> it2 = this.dgs.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bp(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.dgq = null;
                this.dgs = null;
                anm();
            }
        }
    }

    private void anm() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bp(long j) {
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

    private Location ann() {
        if (ab.aS(TbadkCoreApplication.getInst())) {
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
