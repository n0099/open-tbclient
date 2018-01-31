package com.baidu.tieba.d;

import android.content.Context;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.net.http.Headers;
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
public class c implements a.InterfaceC0106a {
    private a ddL;
    private ShareDialogConfig ddM;
    private ArrayList<TransmitForumData> mForumList;
    private TbPageContext mPageContext;
    private int mPrivateThread;

    public c(Context context) {
        if (context instanceof BaseActivity) {
            this.mPageContext = ((BaseActivity) context).getPageContext();
        } else if (context instanceof BaseFragmentActivity) {
            this.mPageContext = ((BaseFragmentActivity) context).getPageContext();
        }
        amy();
    }

    public c(TbPageContext tbPageContext) {
        this.mPageContext = tbPageContext;
        amy();
    }

    private void amy() {
        CustomResponsedMessage runTask = MessageManager.getInstance().runTask(new CustomMessage<>((int) CmdConfigCustom.CMD_GET_SELECT_FORUM_CONTROLLER, this.mPageContext), a.class);
        if (runTask != null) {
            this.ddL = (a) runTask.getData();
        }
        if (this.ddL != null) {
            this.ddL.setUseCache(false);
            this.ddL.a(this);
        }
    }

    public void a(ShareDialogConfig shareDialogConfig) {
        if (shareDialogConfig != null && shareDialogConfig.shareItem != null && !g.isFastDoubleClick()) {
            this.ddM = shareDialogConfig;
            if (shareDialogConfig.showLocation) {
                shareDialogConfig.shareItem.bjn = amz();
            }
            if (TbadkCoreApplication.isLogin() && this.ddL != null && !shareDialogConfig.mIsAlaLive) {
                this.ddL.aI(null, null);
            } else {
                DY();
            }
        }
    }

    @Override // com.baidu.tieba.d.a.InterfaceC0106a
    public void b(List<TransmitForumData> list, boolean z, int i) {
        if (list instanceof ArrayList) {
            this.mForumList = (ArrayList) list;
        }
        this.mPrivateThread = i;
        DY();
    }

    private void DY() {
        if (this.ddM != null && this.ddM.shareItem != null) {
            this.ddM.setIsShowTransmitShare(true);
            this.ddM.setTransmitForumList(this.mForumList);
            this.ddM.setPrivateThread(this.mPrivateThread);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_SHARE_DIALOG_SHOW, this.ddM));
        }
    }

    private Location amz() {
        if (ab.aT(this.mPageContext.getPageActivity())) {
            LocationManager locationManager = (LocationManager) this.mPageContext.getPageActivity().getApplication().getSystemService(Headers.LOCATION);
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
