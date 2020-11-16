package com.baidu.tieba.d;

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
import com.baidu.tieba.d.c;
import java.util.ArrayList;
import java.util.Iterator;
/* loaded from: classes.dex */
public class f implements c.a {
    private static f ieZ = null;
    private c ifa;
    private c ifb;
    private ArrayList<TransmitForumData> ifc;
    private ArrayList<TransmitForumData> ife;
    private int mPrivateThread;
    private ArrayList<TransmitForumData> mForumList = new ArrayList<>();
    private boolean ifd = false;
    private boolean iff = false;
    private boolean isLoading = false;

    public static f coW() {
        if (ieZ == null) {
            synchronized (f.class) {
                if (ieZ == null) {
                    ieZ = new f();
                }
            }
        }
        return ieZ;
    }

    private f() {
        init();
    }

    private void init() {
        coY();
        coX();
        this.isLoading = false;
    }

    private void coX() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_ENTERFORUM_DATA), c.class);
        if (runTask != null) {
            this.ifb = (c) runTask.getData();
        }
        if (this.ifb != null) {
            this.ifb.a(this);
        }
    }

    private void coY() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>(CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER), c.class);
        if (runTask != null) {
            this.ifa = (c) runTask.getData();
        }
        if (this.ifa != null) {
            this.ifa.a(this);
        }
    }

    public void b(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !l.isFastDoubleClick()) {
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.location = cpc();
            }
            if (com.baidu.adp.lib.util.l.isNetOk() && TbadkCoreApplication.isLogin() && !shareDialogConfig.mIsAlaLive && !this.isLoading && !shareDialogConfig.shareItem.bwN()) {
                coZ();
            }
            shareDialogConfig.setIsShowTransmitShare(true);
            shareDialogConfig.setTransmitForumList(this.mForumList);
            shareDialogConfig.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, shareDialogConfig));
        }
    }

    public void coZ() {
        this.isLoading = true;
        if (this.ifa != null) {
            this.ifa.coT();
        }
        if (this.ifb != null) {
            this.ifb.coT();
        }
    }

    @Override // com.baidu.tieba.d.c.a
    public void a(ArrayList<TransmitForumData> arrayList, boolean z, int i, int i2) {
        if (i == 1) {
            if (z) {
                this.ife = arrayList;
            }
            this.iff = true;
        } else if (i == 2) {
            if (z) {
                this.ifc = arrayList;
                this.mPrivateThread = i2;
            }
            this.ifd = true;
        }
        cpa();
    }

    private void cpa() {
        if (this.ifa == null || this.ifd) {
            if (this.ifb == null || this.iff) {
                this.ifd = false;
                this.iff = false;
                this.isLoading = false;
                this.mForumList.clear();
                if (!y.isEmpty(this.ifc)) {
                    Iterator<TransmitForumData> it = this.ifc.iterator();
                    while (it.hasNext()) {
                        TransmitForumData next = it.next();
                        if (!fy(next.forumId)) {
                            this.mForumList.add(next);
                        }
                    }
                }
                if (!y.isEmpty(this.ife)) {
                    Iterator<TransmitForumData> it2 = this.ife.iterator();
                    while (it2.hasNext()) {
                        TransmitForumData next2 = it2.next();
                        if (!fy(next2.forumId)) {
                            this.mForumList.add(next2);
                        }
                    }
                }
                this.ifc = null;
                this.ife = null;
                cpb();
            }
        }
    }

    private void cpb() {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_SHARE_FORUM_DATA_LOADED, this.mForumList));
    }

    private boolean fy(long j) {
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

    private Location cpc() {
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
