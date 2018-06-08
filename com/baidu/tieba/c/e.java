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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0137a {
    private static e cHV = null;
    private a cHW;
    private a cHX;
    private ArrayList<TransmitForumData> cHY;
    private ArrayList<TransmitForumData> cIa;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean cHZ = false;
    private boolean cIb = false;
    private boolean isLoading = false;

    public static e akV() {
        if (cHV == null) {
            synchronized (e.class) {
                if (cHV == null) {
                    cHV = new e();
                }
            }
        }
        return cHV;
    }

    private e() {
        init();
    }

    private void init() {
        akX();
        akW();
        this.isLoading = false;
    }

    private void akW() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2016562), a.class);
        if (runTask != null) {
            this.cHX = (a) runTask.getData();
        }
        if (this.cHX != null) {
            this.cHX.a(this);
        }
    }

    private void akX() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(2001449), a.class);
        if (runTask != null) {
            this.cHW = (a) runTask.getData();
        }
        if (this.cHW != null) {
            this.cHW.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.aFk = ala();
            }
            if (l.jU() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                this.isLoading = true;
                if (this.cHW != null) {
                    this.cHW.akK();
                }
                if (this.cHX != null) {
                    this.cHX.akK();
                }
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage(2001276, shareDialogConfig));
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0137a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.cIa = arrayList;
            }
            this.cIb = true;
        } else if (i == 2) {
            if (z) {
                this.cHY = arrayList;
                this.mPrivateThread = i2;
            }
            this.cHZ = true;
        }
        akY();
    }

    private void akY() {
        if (this.cHW == null || this.cHZ) {
            if (this.cHX == null || this.cIb) {
                this.cHZ = false;
                this.cIb = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!w.z(this.cHY)) {
                    Iterator<TransmitForumData> it = this.cHY.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!br(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!w.z(this.cIa)) {
                    Iterator<TransmitForumData> it2 = this.cIa.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!br(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.cHY = null;
                this.cIa = null;
                akZ();
            }
        }
    }

    private void akZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2016563, this.mForumList));
    }

    private boolean br(long j) {
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

    private Location ala() {
        if (ac.aM(TbadkCoreApplication.getInst())) {
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
