package com.baidu.tieba.ala.quitroomrecommend.a;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.HttpMessageListener;
import com.baidu.live.adp.framework.message.HttpResponsedMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.data.al;
import com.baidu.live.data.w;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.live.x.b;
import com.baidu.tieba.ala.quitroomrecommend.data.AlaQuitRoomRecommendResponseMessage;
import java.util.Date;
/* loaded from: classes4.dex */
public class a implements View.OnClickListener, b {
    private w aLD;
    private int aLv;
    private TbPageContext bAn;
    private View hTT;
    private com.baidu.live.x.a hTU;
    private com.baidu.tieba.ala.quitroomrecommend.a hTV;
    private BdListView hTW;
    private boolean hTX;
    private int hUa;
    private String hUb;
    private long hUc;
    private long hUd;
    private boolean hUe;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitleView;
    private View rootView;
    private long hTY = System.currentTimeMillis();
    private long hTZ = 0;
    private HttpMessageListener hUf = new HttpMessageListener(1021226) { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021226 && (httpResponsedMessage instanceof AlaQuitRoomRecommendResponseMessage)) {
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    a.this.coK();
                } else {
                    a.this.a((AlaQuitRoomRecommendResponseMessage) httpResponsedMessage);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.hUa = 1;
        this.hUc = 7000L;
        this.hUd = 3L;
        this.hUe = false;
        this.bAn = tbPageContext;
        this.mContext = this.bAn.getPageActivity();
        al alVar = com.baidu.live.ae.a.RB().brA;
        if (alVar != null && alVar.aOK != null) {
            this.hUa = alVar.aOK.aLv;
            this.hUb = alVar.aOK.aLu;
            this.hUc = alVar.aOK.aLt;
            this.hUd = alVar.aOK.aLw;
            this.hUe = alVar.aOK.aLx;
        }
    }

    @Override // com.baidu.live.x.b
    public void a(w wVar, com.baidu.live.x.a aVar) {
        this.aLD = wVar;
        this.hTU = aVar;
        this.hTZ = System.currentTimeMillis();
    }

    @Override // com.baidu.live.x.b
    public void en(int i) {
        if (this.mContext != null && this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    private void coG() {
        if (this.mDialog == null) {
            coH();
            this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_quit_room_recommend_dialog, (ViewGroup) null);
            this.mTitleView = (TextView) this.rootView.findViewById(a.f.sdk_ala_quit_tv_title);
            if (!TextUtils.isEmpty(this.hUb)) {
                this.mTitleView.setText(this.hUb);
            }
            this.hTW = (BdListView) this.rootView.findViewById(a.f.sdk_ala_recommend_bdlist);
            this.hTV = new com.baidu.tieba.ala.quitroomrecommend.a(this.mContext);
            this.hTW.setAdapter((ListAdapter) this.hTV);
            this.hTT = this.rootView.findViewById(a.f.sdk_ala_tv_exit);
            this.hTT.setOnClickListener(this);
            this.mDialog = new Dialog(this.mContext, a.i.sdk_TransparentDialog);
            this.mDialog.requestWindowFeature(1);
            this.mDialog.setCancelable(true);
            this.mDialog.setContentView(this.rootView);
            this.mDialog.setCanceledOnTouchOutside(true);
            this.mDialog.setOnDismissListener(new DialogInterface.OnDismissListener() { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.1
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    SharedPrefHelper.getInstance().putInt("KEY_QUITROOMRECOMMEND_CLICK_EXIT_COUNT", SharedPrefHelper.getInstance().getInt("KEY_QUITROOMRECOMMEND_CLICK_EXIT_COUNT", 0) + 1);
                }
            });
            Window window = this.mDialog.getWindow();
            WindowManager.LayoutParams attributes = window.getAttributes();
            window.setWindowAnimations(a.i.sdk_share_dialog_style);
            attributes.gravity = 80;
            attributes.width = -1;
            attributes.height = -2;
            window.setAttributes(attributes);
        }
        if (!this.mDialog.isShowing()) {
            this.mDialog.show();
        }
    }

    private void coH() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quitreco_show").setContentExt(null, "quit_reco", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaQuitRoomRecommendResponseMessage alaQuitRoomRecommendResponseMessage) {
        if (alaQuitRoomRecommendResponseMessage == null || alaQuitRoomRecommendResponseMessage.hUk == null || alaQuitRoomRecommendResponseMessage.hUk.isEmpty()) {
            coI();
            return;
        }
        coG();
        if (this.hTV != null) {
            this.hTV.setData(alaQuitRoomRecommendResponseMessage.hUk);
        }
    }

    private void coI() {
        coJ();
    }

    private void coJ() {
        if (this.hTU != null) {
            this.hTU.QO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coK() {
        coJ();
    }

    private void bFR() {
        if (this.aLD != null && this.aLD.mLiveInfo != null) {
            if (!this.hTX) {
                this.hTX = true;
                MessageManager.getInstance().registerListener(this.hUf);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hTY >= 1800000) {
                this.hTY = currentTimeMillis;
            }
            com.baidu.tieba.ala.quitroomrecommend.data.b bVar = new com.baidu.tieba.ala.quitroomrecommend.data.b();
            int i = this.aLv;
            this.aLv = i + 1;
            bVar.hUj = i;
            bVar.roomId = this.aLD.mLiveInfo.room_id;
            bVar.hTY = this.hTY;
            bVar.setParams();
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        this.hTX = false;
        MessageManager.getInstance().unRegisterListener(this.hUf);
    }

    @Override // com.baidu.live.x.b
    public boolean QP() {
        if (this.hUe && TbadkCoreApplication.isLogin() && System.currentTimeMillis() - this.hTZ >= this.hUc && SharedPrefHelper.getInstance().getInt("KEY_QUITROOMRECOMMEND_CLICK_EXIT_COUNT", 0) < this.hUd && !coL()) {
            bFR();
            return true;
        }
        return false;
    }

    private boolean coL() {
        int i;
        String b = k.b(new Date());
        String string = SharedPrefHelper.getInstance().getString("KEY_QUITROOMRECOMMEND_COUNT", "");
        if (string.contains(",")) {
            String[] split = string.split(",");
            if (b.equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
                if (i >= this.hUa) {
                    return true;
                }
                this.aLv = i;
                SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b + "," + (i + 1));
                return false;
            }
        }
        i = 0;
        this.aLv = i;
        SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b + "," + (i + 1));
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.hTT == view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quitlive_click").setContentExt(null, "quit_reco", null));
            if (this.mDialog != null && this.mDialog.isShowing()) {
                this.mDialog.dismiss();
            }
            coJ();
        }
    }
}
