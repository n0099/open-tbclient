package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
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
import com.baidu.tbadk.util.i;
import com.baidu.tieba.c.a;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class e implements a.InterfaceC0393a {
    private static e eWm = null;
    private a eWn;
    private a eWo;
    private ArrayList<TransmitForumData> eWp;
    private ArrayList<TransmitForumData> eWr;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean eWq = false;
    private boolean eWs = false;
    private boolean isLoading = false;

    public static e bcj() {
        if (eWm == null) {
            synchronized (e.class) {
                if (eWm == null) {
                    eWm = new e();
                }
            }
        }
        return eWm;
    }

    private e() {
        init();
    }

    private void init() {
        bcl();
        bck();
        this.isLoading = false;
    }

    private void bck() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), a.class);
        if (runTask != null) {
            this.eWo = (a) runTask.getData();
        }
        if (this.eWo != null) {
            this.eWo.a(this);
        }
    }

    private void bcl() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), a.class);
        if (runTask != null) {
            this.eWn = (a) runTask.getData();
        }
        if (this.eWn != null) {
            this.eWn.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !i.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.cyI = bcp();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bcm();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bcm() {
        this.isLoading = true;
        if (this.eWn != null) {
            this.eWn.bcc();
        }
        if (this.eWo != null) {
            this.eWo.bcc();
        }
    }

    @Override // com.baidu.tieba.c.a.InterfaceC0393a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.eWr = arrayList;
            }
            this.eWs = true;
        } else if (i == 2) {
            if (z) {
                this.eWp = arrayList;
                this.mPrivateThread = i2;
            }
            this.eWq = true;
        }
        bcn();
    }

    private void bcn() {
        if (this.eWn == null || this.eWq) {
            if (this.eWo == null || this.eWs) {
                this.eWq = false;
                this.eWs = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!v.isEmpty(this.eWp)) {
                    Iterator<TransmitForumData> it = this.eWp.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!cB(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!v.isEmpty(this.eWr)) {
                    Iterator<TransmitForumData> it2 = this.eWr.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!cB(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.eWp = null;
                this.eWr = null;
                bco();
            }
        }
    }

    private void bco() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean cB(long j) {
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

    private Location bcp() {
        if (ab.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
