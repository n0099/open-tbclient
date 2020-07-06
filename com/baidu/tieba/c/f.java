package com.baidu.tieba.c;

import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.w;
import com.baidu.tbadk.util.k;
import com.baidu.tieba.c.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f gXk = null;
    private c gXl;
    private c gXm;
    private ArrayList<TransmitForumData> gXn;
    private ArrayList<TransmitForumData> gXp;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean gXo = false;
    private boolean gXq = false;
    private boolean isLoading = false;

    public static f bPE() {
        if (gXk == null) {
            synchronized (f.class) {
                if (gXk == null) {
                    gXk = new f();
                }
            }
        }
        return gXk;
    }

    private f() {
        init();
    }

    private void init() {
        bPG();
        bPF();
        this.isLoading = false;
    }

    private void bPF() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.gXm = (c) runTask.getData();
        }
        if (this.gXm != null) {
            this.gXm.a(this);
        }
    }

    private void bPG() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.gXl = (c) runTask.getData();
        }
        if (this.gXl != null) {
            this.gXl.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !k.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = bPK();
            }
            if (l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading) {
                bPH();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void bPH() {
        this.isLoading = true;
        if (this.gXl != null) {
            this.gXl.bPB();
        }
        if (this.gXm != null) {
            this.gXm.bPB();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.gXp = arrayList;
            }
            this.gXq = true;
        } else if (i == 2) {
            if (z) {
                this.gXn = arrayList;
                this.mPrivateThread = i2;
            }
            this.gXo = true;
        }
        bPI();
    }

    private void bPI() {
        if (this.gXl == null || this.gXo) {
            if (this.gXm == null || this.gXq) {
                this.gXo = false;
                this.gXq = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!w.isEmpty(this.gXn)) {
                    Iterator<TransmitForumData> it = this.gXn.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!dZ(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!w.isEmpty(this.gXp)) {
                    Iterator<TransmitForumData> it2 = this.gXp.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!dZ(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.gXn = null;
                this.gXp = null;
                bPJ();
            }
        }
    }

    private void bPJ() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean dZ(long j) {
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

    private Location bPK() {
        if (ac.checkLocationForGoogle(TbadkCoreApplication.getInst())) {
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
