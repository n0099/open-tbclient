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
    private View hTR;
    private com.baidu.live.x.a hTS;
    private com.baidu.tieba.ala.quitroomrecommend.a hTT;
    private BdListView hTU;
    private boolean hTV;
    private int hTY;
    private String hTZ;
    private long hUa;
    private long hUb;
    private boolean hUc;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitleView;
    private View rootView;
    private long hTW = System.currentTimeMillis();
    private long hTX = 0;
    private HttpMessageListener hUd = new HttpMessageListener(1021226) { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021226 && (httpResponsedMessage instanceof AlaQuitRoomRecommendResponseMessage)) {
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    a.this.coJ();
                } else {
                    a.this.a((AlaQuitRoomRecommendResponseMessage) httpResponsedMessage);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.hTY = 1;
        this.hUa = 7000L;
        this.hUb = 3L;
        this.hUc = false;
        this.bAn = tbPageContext;
        this.mContext = this.bAn.getPageActivity();
        al alVar = com.baidu.live.ae.a.RB().brA;
        if (alVar != null && alVar.aOK != null) {
            this.hTY = alVar.aOK.aLv;
            this.hTZ = alVar.aOK.aLu;
            this.hUa = alVar.aOK.aLt;
            this.hUb = alVar.aOK.aLw;
            this.hUc = alVar.aOK.aLx;
        }
    }

    @Override // com.baidu.live.x.b
    public void a(w wVar, com.baidu.live.x.a aVar) {
        this.aLD = wVar;
        this.hTS = aVar;
        this.hTX = System.currentTimeMillis();
    }

    @Override // com.baidu.live.x.b
    public void en(int i) {
        if (this.mContext != null && this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    private void coF() {
        if (this.mDialog == null) {
            coG();
            this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_quit_room_recommend_dialog, (ViewGroup) null);
            this.mTitleView = (TextView) this.rootView.findViewById(a.f.sdk_ala_quit_tv_title);
            if (!TextUtils.isEmpty(this.hTZ)) {
                this.mTitleView.setText(this.hTZ);
            }
            this.hTU = (BdListView) this.rootView.findViewById(a.f.sdk_ala_recommend_bdlist);
            this.hTT = new com.baidu.tieba.ala.quitroomrecommend.a(this.mContext);
            this.hTU.setAdapter((ListAdapter) this.hTT);
            this.hTR = this.rootView.findViewById(a.f.sdk_ala_tv_exit);
            this.hTR.setOnClickListener(this);
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

    private void coG() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quitreco_show").setContentExt(null, "quit_reco", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaQuitRoomRecommendResponseMessage alaQuitRoomRecommendResponseMessage) {
        if (alaQuitRoomRecommendResponseMessage == null || alaQuitRoomRecommendResponseMessage.hUi == null || alaQuitRoomRecommendResponseMessage.hUi.isEmpty()) {
            coH();
            return;
        }
        coF();
        if (this.hTT != null) {
            this.hTT.setData(alaQuitRoomRecommendResponseMessage.hUi);
        }
    }

    private void coH() {
        coI();
    }

    private void coI() {
        if (this.hTS != null) {
            this.hTS.QO();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coJ() {
        coI();
    }

    private void bFR() {
        if (this.aLD != null && this.aLD.mLiveInfo != null) {
            if (!this.hTV) {
                this.hTV = true;
                MessageManager.getInstance().registerListener(this.hUd);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.hTW >= 1800000) {
                this.hTW = currentTimeMillis;
            }
            com.baidu.tieba.ala.quitroomrecommend.data.b bVar = new com.baidu.tieba.ala.quitroomrecommend.data.b();
            int i = this.aLv;
            this.aLv = i + 1;
            bVar.hUh = i;
            bVar.roomId = this.aLD.mLiveInfo.room_id;
            bVar.hTW = this.hTW;
            bVar.setParams();
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.x.b
    public void onDestroy() {
        this.hTV = false;
        MessageManager.getInstance().unRegisterListener(this.hUd);
    }

    @Override // com.baidu.live.x.b
    public boolean QP() {
        if (this.hUc && TbadkCoreApplication.isLogin() && System.currentTimeMillis() - this.hTX >= this.hUa && SharedPrefHelper.getInstance().getInt("KEY_QUITROOMRECOMMEND_CLICK_EXIT_COUNT", 0) < this.hUb && !coK()) {
            bFR();
            return true;
        }
        return false;
    }

    private boolean coK() {
        int i;
        String b = k.b(new Date());
        String string = SharedPrefHelper.getInstance().getString("KEY_QUITROOMRECOMMEND_COUNT", "");
        if (string.contains(",")) {
            String[] split = string.split(",");
            if (b.equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
                if (i >= this.hTY) {
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
        if (this.hTR == view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quitlive_click").setContentExt(null, "quit_reco", null));
            if (this.mDialog != null && this.mDialog.isShowing()) {
                this.mDialog.dismiss();
            }
            coI();
        }
    }
}
