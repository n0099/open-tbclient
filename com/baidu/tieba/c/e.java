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
public class e implements a.InterfaceC0136a {
    private static e cOk = null;
    private a cOl;
    private a cOm;
    private ArrayList<TransmitForumData> cOn;
    private ArrayList<TransmitForumData> cOp;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean cOo = false;
    private boolean cOq = false;
    private boolean isLoading = false;

    public static e amB() {
        if (cOk == null) {
            synchronized (e.class) {
                if (cOk == null) {
                    cOk = new e();
                }
            }
        }
        return cOk;
    }

    private e() {
        init();
    }

    private void init() {
        amD();
        amC();
        this.isLoading = false;
    }

    private void amC() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.cOm = (a) runTask.getData();
        }
        if (this.cOm != null) {
            this.cOm.a(this);
        }
    }

    private void amD() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.cOl = (a) runTask.getData();
        }
        if (this.cOl != null) {
            this.cOl.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aJq = amH();
            }
            if (l.lb() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                amE();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    public void amE() {
        this.isLoading = true;
        if (this.cOl != null) {
            this.cOl.amq();
        }
        if (this.cOm != null) {
            this.cOm.amq();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0136a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.cOp = arrayList;
            }
            this.cOq = true;
        } else if (i == 2) {
            if (z) {
                this.cOn = arrayList;
                this.mPrivateThread = i2;
            }
            this.cOo = true;
        }
        amF();
    }

    private void amF() {
        if (this.cOl == null || this.cOo) {
            if (this.cOm == null || this.cOq) {
                this.cOo = false;
                this.cOq = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.z(this.cOn)) {
                    Iterator<TransmitForumData> it = this.cOn.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!bt(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.z(this.cOp)) {
                    Iterator<TransmitForumData> it2 = this.cOp.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!bt(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.cOn = null;
                this.cOp = null;
                amG();
            }
        }
    }

    private void amG() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean bt(long j) {
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

    private Location amH() {
        if (ab.bs(TbadkCoreApplication.getInst())) {
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
