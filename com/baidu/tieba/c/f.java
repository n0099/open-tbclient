package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.y;
import com.baidu.tbadk.util.l;
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f iFp = null;
    private c iFq;
    private c iFr;
    private ArrayList<TransmitForumData> iFs;
    private ArrayList<TransmitForumData> iFu;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean iFt = false;
    private boolean iFv = false;
    private boolean isLoading = false;

    public static f ctM() {
        if (iFp == null) {
            synchronized (f.class) {
                if (iFp == null) {
                    iFp = new f();
                }
            }
        }
        return iFp;
    }

    private f() {
        init();
    }

    private void init() {
        ctO();
        ctN();
        this.isLoading = false;
    }

    private void ctN() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.iFr = (c) runTask.getData();
        }
        if (this.iFr != null) {
            this.iFr.a(this);
        }
    }

    private void ctO() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.iFq = (c) runTask.getData();
        }
        if (this.iFq != null) {
            this.iFq.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = ctS();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bzj()) {
                ctP();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void ctP() {
        this.isLoading = true;
        if (this.iFq != null) {
            this.iFq.ctJ();
        }
        if (this.iFr != null) {
            this.iFr.ctJ();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.iFu = arrayList;
            }
            this.iFv = true;
        } else if (i == 2) {
            if (z) {
                this.iFs = arrayList;
                this.mPrivateThread = i2;
            }
            this.iFt = true;
        }
        ctQ();
    }

    private void ctQ() {
        if (this.iFq == null || this.iFt) {
            if (this.iFr == null || this.iFv) {
                this.iFt = false;
                this.iFv = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.iFs)) {
                    Iterator<TransmitForumData> it = this.iFs.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!gh(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.iFu)) {
                    Iterator<TransmitForumData> it2 = this.iFu.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!gh(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.iFs = null;
                this.iFu = null;
                ctR();
            }
        }
    }

    private void ctR() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean gh(long j) {
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

    private Location ctS() {
        if (ae.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
