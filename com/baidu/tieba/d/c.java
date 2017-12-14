package com.baidu.tieba.d;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.BaseActivity;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.BaseFragmentActivity;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ShareDialogConfig;
import com.baidu.tbadk.core.data.TransmitForumData;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.util.g;
import com.baidu.tieba.d.a;
import java.util.ArrayList;
import java.util.List;
/* loaded from: classes.dex */
public class c implements a.InterfaceC0094a {
    private a ckd;
    private ShareDialogConfig cke;
    private ArrayList<TransmitForumData> mForumList;
    private TbPageContext mPageContext;
    private int mPrivateThread;

    public c(Context context) {
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        adL();
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        adL();
    }

    private void adL() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER, this.mPageContext), a.class);
        if (runTask != null) {
            this.ckd = (a) runTask.getData();
        }
        if (this.ckd != null) {
            this.ckd.setUseCache(false);
            this.ckd.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            this.cke = shareDialogConfig;
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.auF = adM();
            }
            if (TbadkCoreApplication.isLogin() && this.ckd != null && !shareDialogConfig.mIsAlaLive) {
                this.ckd.aK(null, null);
            } else {
                wH();
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0094a
    public void b(List<TransmitForumData> list, boolean z, int i) {
        if (list instanceof ArrayList) {
            this.mForumList = (ArrayList) list;
        }
        this.mPrivateThread = i;
        wH();
    }

    private void wH() {
        if (this.cke != null && this.cke.shareItem != null) {
            this.cke.setIsShowTransmitShare(true);
            this.cke.setTransmitForumList(this.mForumList);
            this.cke.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, this.cke));
        }
    }

    private Location adM() {
        if (ab.aH(this.mPageContext.getPageActivity())) {
            LocationManager locationManager = (LocationManager) this.mPageContext.getPageActivity().getApplication().getSystemService("location");
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
