package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
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
    private static f hYj = null;
    private c hYk;
    private c hYl;
    private ArrayList<TransmitForumData> hYm;
    private ArrayList<TransmitForumData> hYo;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean hYn = false;
    private boolean hYp = false;
    private boolean isLoading = false;

    public static f cmU() {
        if (hYj == null) {
            synchronized (f.class) {
                if (hYj == null) {
                    hYj = new f();
                }
            }
        }
        return hYj;
    }

    private f() {
        init();
    }

    private void init() {
        cmW();
        cmV();
        this.isLoading = false;
    }

    private void cmV() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.hYl = (c) runTask.getData();
        }
        if (this.hYl != null) {
            this.hYl.a(this);
        }
    }

    private void cmW() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.hYk = (c) runTask.getData();
        }
        if (this.hYk != null) {
            this.hYk.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = cna();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.buY()) {
                cmX();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void cmX() {
        this.isLoading = true;
        if (this.hYk != null) {
            this.hYk.cmR();
        }
        if (this.hYl != null) {
            this.hYl.cmR();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.hYo = arrayList;
            }
            this.hYp = true;
        } else if (i == 2) {
            if (z) {
                this.hYm = arrayList;
                this.mPrivateThread = i2;
            }
            this.hYn = true;
        }
        cmY();
    }

    private void cmY() {
        if (this.hYk == null || this.hYn) {
            if (this.hYl == null || this.hYp) {
                this.hYn = false;
                this.hYp = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.hYm)) {
                    Iterator<TransmitForumData> it = this.hYm.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!eZ(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.hYo)) {
                    Iterator<TransmitForumData> it2 = this.hYo.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!eZ(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.hYm = null;
                this.hYo = null;
                cmZ();
            }
        }
    }

    private void cmZ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean eZ(long j) {
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

    private Location cna() {
        if (ae.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
            LocationManager locationManager = (LocationManager) TbadkCoreApplication.getInst().getSystemService("location");
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
