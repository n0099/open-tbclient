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
import com.baidu.live.data.ab;
import com.baidu.live.data.ar;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.live.w.b;
import com.baidu.tieba.ala.quitroomrecommend.data.AlaQuitRoomRecommendResponseMessage;
import java.util.Date;
/* loaded from: classes11.dex */
public class a implements View.OnClickListener, b {
    private int aJR;
    private ab aJZ;
    private TbPageContext bDU;
    private int igB;
    private String igC;
    private long igD;
    private long igE;
    private boolean igF;
    private View igu;
    private com.baidu.live.w.a igv;
    private com.baidu.tieba.ala.quitroomrecommend.a igw;
    private BdListView igx;
    private boolean igy;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitleView;
    private View rootView;
    private long igz = System.currentTimeMillis();
    private long igA = 0;
    private HttpMessageListener igG = new HttpMessageListener(1021226) { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021226 && (httpResponsedMessage instanceof AlaQuitRoomRecommendResponseMessage)) {
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    a.this.coR();
                } else {
                    a.this.a((AlaQuitRoomRecommendResponseMessage) httpResponsedMessage);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.igB = 1;
        this.igD = 7000L;
        this.igE = 3L;
        this.igF = false;
        this.bDU = tbPageContext;
        this.mContext = this.bDU.getPageActivity();
        ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar != null && arVar.aNu != null) {
            this.igB = arVar.aNu.aJR;
            this.igC = arVar.aNu.aJQ;
            this.igD = arVar.aNu.aJP;
            this.igE = arVar.aNu.aJS;
            this.igF = arVar.aNu.aJT;
        }
    }

    @Override // com.baidu.live.w.b
    public void a(ab abVar, com.baidu.live.w.a aVar) {
        this.aJZ = abVar;
        this.igv = aVar;
        this.igA = System.currentTimeMillis();
    }

    @Override // com.baidu.live.w.b
    public void cK(int i) {
        if (this.mContext != null && this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    private void coN() {
        if (this.mDialog == null) {
            coO();
            this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_quit_room_recommend_dialog, (ViewGroup) null);
            this.mTitleView = (TextView) this.rootView.findViewById(a.f.sdk_ala_quit_tv_title);
            if (!TextUtils.isEmpty(this.igC)) {
                this.mTitleView.setText(this.igC);
            }
            this.igx = (BdListView) this.rootView.findViewById(a.f.sdk_ala_recommend_bdlist);
            this.igw = new com.baidu.tieba.ala.quitroomrecommend.a(this.mContext);
            this.igx.setAdapter((ListAdapter) this.igw);
            this.igu = this.rootView.findViewById(a.f.sdk_ala_tv_exit);
            this.igu.setOnClickListener(this);
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

    private void coO() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quitreco_show").setContentExt(null, "quit_reco", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaQuitRoomRecommendResponseMessage alaQuitRoomRecommendResponseMessage) {
        if (alaQuitRoomRecommendResponseMessage == null || alaQuitRoomRecommendResponseMessage.igL == null || alaQuitRoomRecommendResponseMessage.igL.isEmpty()) {
            coP();
            return;
        }
        coN();
        if (this.igw != null) {
            this.igw.setData(alaQuitRoomRecommendResponseMessage.igL);
        }
    }

    private void coP() {
        coQ();
    }

    private void coQ() {
        if (this.igv != null) {
            this.igv.Pv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coR() {
        coQ();
    }

    private void bEN() {
        if (this.aJZ != null && this.aJZ.mLiveInfo != null) {
            if (!this.igy) {
                this.igy = true;
                MessageManager.getInstance().registerListener(this.igG);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.igz >= 1800000) {
                this.igz = currentTimeMillis;
            }
            com.baidu.tieba.ala.quitroomrecommend.data.b bVar = new com.baidu.tieba.ala.quitroomrecommend.data.b();
            int i = this.aJR;
            this.aJR = i + 1;
            bVar.igK = i;
            bVar.roomId = this.aJZ.mLiveInfo.room_id;
            bVar.igz = this.igz;
            bVar.setParams();
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.w.b
    public void onDestroy() {
        this.igy = false;
        MessageManager.getInstance().unRegisterListener(this.igG);
    }

    @Override // com.baidu.live.w.b
    public boolean Pw() {
        if (this.igF && TbadkCoreApplication.isLogin() && System.currentTimeMillis() - this.igA >= this.igD && SharedPrefHelper.getInstance().getInt("KEY_QUITROOMRECOMMEND_CLICK_EXIT_COUNT", 0) < this.igE && !coS()) {
            bEN();
            return true;
        }
        return false;
    }

    private boolean coS() {
        int i;
        String b2 = k.b(new Date());
        String string = SharedPrefHelper.getInstance().getString("KEY_QUITROOMRECOMMEND_COUNT", "");
        if (string.contains(",")) {
            String[] split = string.split(",");
            if (b2.equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
                if (i >= this.igB) {
                    return true;
                }
                this.aJR = i;
                SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b2 + "," + (i + 1));
                return false;
            }
        }
        i = 0;
        this.aJR = i;
        SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b2 + "," + (i + 1));
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.igu == view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quitlive_click").setContentExt(null, "quit_reco", null));
            if (this.mDialog != null && this.mDialog.isShowing()) {
                this.mDialog.dismiss();
            }
            coQ();
        }
    }
}
