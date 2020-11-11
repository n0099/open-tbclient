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
    private static f iek = null;
    private c iel;
    private c iem;
    private ArrayList<TransmitForumData> ien;
    private ArrayList<TransmitForumData> iep;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean ieo = false;
    private boolean ieq = false;
    private boolean isLoading = false;

    public static f cpv() {
        if (iek == null) {
            synchronized (f.class) {
                if (iek == null) {
                    iek = new f();
                }
            }
        }
        return iek;
    }

    private f() {
        init();
    }

    private void init() {
        cpx();
        cpw();
        this.isLoading = false;
    }

    private void cpw() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.iem = (c) runTask.getData();
        }
        if (this.iem != null) {
            this.iem.a(this);
        }
    }

    private void cpx() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.iel = (c) runTask.getData();
        }
        if (this.iel != null) {
            this.iel.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = cpB();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bxx()) {
                cpy();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void cpy() {
        this.isLoading = true;
        if (this.iel != null) {
            this.iel.cps();
        }
        if (this.iem != null) {
            this.iem.cps();
        }
    }

    @Override // com.baidu.tieba.c.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.iep = arrayList;
            }
            this.ieq = true;
        } else if (i == 2) {
            if (z) {
                this.ien = arrayList;
                this.mPrivateThread = i2;
            }
            this.ieo = true;
        }
        cpz();
    }

    private void cpz() {
        if (this.iel == null || this.ieo) {
            if (this.iem == null || this.ieq) {
                this.ieo = false;
                this.ieq = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.ien)) {
                    Iterator<TransmitForumData> it = this.ien.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!fv(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.iep)) {
                    Iterator<TransmitForumData> it2 = this.iep.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!fv(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.ien = null;
                this.iep = null;
                cpA();
            }
        }
    }

    private void cpA() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean fv(long j) {
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

    private Location cpB() {
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
