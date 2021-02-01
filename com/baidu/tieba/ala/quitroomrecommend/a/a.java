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
    private View igg;
    private com.baidu.live.w.a igh;
    private com.baidu.tieba.ala.quitroomrecommend.a igi;
    private BdListView igj;
    private boolean igk;
    private int ign;
    private String igo;
    private long igp;
    private long igq;
    private boolean igr;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitleView;
    private View rootView;
    private long igl = System.currentTimeMillis();
    private long igm = 0;
    private HttpMessageListener igs = new HttpMessageListener(1021226) { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
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
        this.ign = 1;
        this.igp = 7000L;
        this.igq = 3L;
        this.igr = false;
        this.bDU = tbPageContext;
        this.mContext = this.bDU.getPageActivity();
        ar arVar = com.baidu.live.ae.a.Qj().buX;
        if (arVar != null && arVar.aNu != null) {
            this.ign = arVar.aNu.aJR;
            this.igo = arVar.aNu.aJQ;
            this.igp = arVar.aNu.aJP;
            this.igq = arVar.aNu.aJS;
            this.igr = arVar.aNu.aJT;
        }
    }

    @Override // com.baidu.live.w.b
    public void a(ab abVar, com.baidu.live.w.a aVar) {
        this.aJZ = abVar;
        this.igh = aVar;
        this.igm = System.currentTimeMillis();
    }

    @Override // com.baidu.live.w.b
    public void cK(int i) {
        if (this.mContext != null && this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    private void coG() {
        if (this.mDialog == null) {
            coH();
            this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_quit_room_recommend_dialog, (ViewGroup) null);
            this.mTitleView = (TextView) this.rootView.findViewById(a.f.sdk_ala_quit_tv_title);
            if (!TextUtils.isEmpty(this.igo)) {
                this.mTitleView.setText(this.igo);
            }
            this.igj = (BdListView) this.rootView.findViewById(a.f.sdk_ala_recommend_bdlist);
            this.igi = new com.baidu.tieba.ala.quitroomrecommend.a(this.mContext);
            this.igj.setAdapter((ListAdapter) this.igi);
            this.igg = this.rootView.findViewById(a.f.sdk_ala_tv_exit);
            this.igg.setOnClickListener(this);
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
        if (alaQuitRoomRecommendResponseMessage == null || alaQuitRoomRecommendResponseMessage.igx == null || alaQuitRoomRecommendResponseMessage.igx.isEmpty()) {
            coI();
            return;
        }
        coG();
        if (this.igi != null) {
            this.igi.setData(alaQuitRoomRecommendResponseMessage.igx);
        }
    }

    private void coI() {
        coJ();
    }

    private void coJ() {
        if (this.igh != null) {
            this.igh.Pv();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coK() {
        coJ();
    }

    private void bEN() {
        if (this.aJZ != null && this.aJZ.mLiveInfo != null) {
            if (!this.igk) {
                this.igk = true;
                MessageManager.getInstance().registerListener(this.igs);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.igl >= 1800000) {
                this.igl = currentTimeMillis;
            }
            com.baidu.tieba.ala.quitroomrecommend.data.b bVar = new com.baidu.tieba.ala.quitroomrecommend.data.b();
            int i = this.aJR;
            this.aJR = i + 1;
            bVar.igw = i;
            bVar.roomId = this.aJZ.mLiveInfo.room_id;
            bVar.igl = this.igl;
            bVar.setParams();
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.w.b
    public void onDestroy() {
        this.igk = false;
        MessageManager.getInstance().unRegisterListener(this.igs);
    }

    @Override // com.baidu.live.w.b
    public boolean Pw() {
        if (this.igr && TbadkCoreApplication.isLogin() && System.currentTimeMillis() - this.igm >= this.igp && SharedPrefHelper.getInstance().getInt("KEY_QUITROOMRECOMMEND_CLICK_EXIT_COUNT", 0) < this.igq && !coL()) {
            bEN();
            return true;
        }
        return false;
    }

    private boolean coL() {
        int i;
        String b2 = k.b(new Date());
        String string = SharedPrefHelper.getInstance().getString("KEY_QUITROOMRECOMMEND_COUNT", "");
        if (string.contains(",")) {
            String[] split = string.split(",");
            if (b2.equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
                if (i >= this.ign) {
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
        if (this.igg == view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quitlive_click").setContentExt(null, "quit_reco", null));
            if (this.mDialog != null && this.mDialog.isShowing()) {
                this.mDialog.dismiss();
            }
            coJ();
        }
    }
}
