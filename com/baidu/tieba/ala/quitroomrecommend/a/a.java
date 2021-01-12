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
import com.baidu.live.data.an;
import com.baidu.live.data.x;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefHelper;
import com.baidu.live.tbadk.ubc.UbcStatisticItem;
import com.baidu.live.tbadk.ubc.UbcStatisticLiveKey;
import com.baidu.live.tbadk.ubc.UbcStatisticManager;
import com.baidu.live.utils.k;
import com.baidu.live.y.b;
import com.baidu.tieba.ala.quitroomrecommend.data.AlaQuitRoomRecommendResponseMessage;
import java.util.Date;
/* loaded from: classes10.dex */
public class a implements View.OnClickListener, b {
    private int aHm;
    private x aHu;
    private TbPageContext bAo;
    private View ibI;
    private com.baidu.live.y.a ibJ;
    private com.baidu.tieba.ala.quitroomrecommend.a ibK;
    private BdListView ibL;
    private boolean ibM;
    private int ibP;
    private String ibQ;
    private long ibR;
    private long ibS;
    private boolean ibT;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitleView;
    private View rootView;
    private long ibN = System.currentTimeMillis();
    private long ibO = 0;
    private HttpMessageListener ibU = new HttpMessageListener(1021226) { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021226 && (httpResponsedMessage instanceof AlaQuitRoomRecommendResponseMessage)) {
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    a.this.cnM();
                } else {
                    a.this.a((AlaQuitRoomRecommendResponseMessage) httpResponsedMessage);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.ibP = 1;
        this.ibR = 7000L;
        this.ibS = 3L;
        this.ibT = false;
        this.bAo = tbPageContext;
        this.mContext = this.bAo.getPageActivity();
        an anVar = com.baidu.live.af.a.OJ().bru;
        if (anVar != null && anVar.aKE != null) {
            this.ibP = anVar.aKE.aHm;
            this.ibQ = anVar.aKE.aHl;
            this.ibR = anVar.aKE.aHk;
            this.ibS = anVar.aKE.aHn;
            this.ibT = anVar.aKE.aHo;
        }
    }

    @Override // com.baidu.live.y.b
    public void a(x xVar, com.baidu.live.y.a aVar) {
        this.aHu = xVar;
        this.ibJ = aVar;
        this.ibO = System.currentTimeMillis();
    }

    @Override // com.baidu.live.y.b
    public void cF(int i) {
        if (this.mContext != null && this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    private void cnI() {
        if (this.mDialog == null) {
            cnJ();
            this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_quit_room_recommend_dialog, (ViewGroup) null);
            this.mTitleView = (TextView) this.rootView.findViewById(a.f.sdk_ala_quit_tv_title);
            if (!TextUtils.isEmpty(this.ibQ)) {
                this.mTitleView.setText(this.ibQ);
            }
            this.ibL = (BdListView) this.rootView.findViewById(a.f.sdk_ala_recommend_bdlist);
            this.ibK = new com.baidu.tieba.ala.quitroomrecommend.a(this.mContext);
            this.ibL.setAdapter((ListAdapter) this.ibK);
            this.ibI = this.rootView.findViewById(a.f.sdk_ala_tv_exit);
            this.ibI.setOnClickListener(this);
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

    private void cnJ() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quitreco_show").setContentExt(null, "quit_reco", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaQuitRoomRecommendResponseMessage alaQuitRoomRecommendResponseMessage) {
        if (alaQuitRoomRecommendResponseMessage == null || alaQuitRoomRecommendResponseMessage.ibZ == null || alaQuitRoomRecommendResponseMessage.ibZ.isEmpty()) {
            cnK();
            return;
        }
        cnI();
        if (this.ibK != null) {
            this.ibK.setData(alaQuitRoomRecommendResponseMessage.ibZ);
        }
    }

    private void cnK() {
        cnL();
    }

    private void cnL() {
        if (this.ibJ != null) {
            this.ibJ.NW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cnM() {
        cnL();
    }

    private void bEv() {
        if (this.aHu != null && this.aHu.mLiveInfo != null) {
            if (!this.ibM) {
                this.ibM = true;
                MessageManager.getInstance().registerListener(this.ibU);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.ibN >= 1800000) {
                this.ibN = currentTimeMillis;
            }
            com.baidu.tieba.ala.quitroomrecommend.data.b bVar = new com.baidu.tieba.ala.quitroomrecommend.data.b();
            int i = this.aHm;
            this.aHm = i + 1;
            bVar.ibY = i;
            bVar.roomId = this.aHu.mLiveInfo.room_id;
            bVar.ibN = this.ibN;
            bVar.setParams();
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.y.b
    public void onDestroy() {
        this.ibM = false;
        MessageManager.getInstance().unRegisterListener(this.ibU);
    }

    @Override // com.baidu.live.y.b
    public boolean NX() {
        if (this.ibT && TbadkCoreApplication.isLogin() && System.currentTimeMillis() - this.ibO >= this.ibR && SharedPrefHelper.getInstance().getInt("KEY_QUITROOMRECOMMEND_CLICK_EXIT_COUNT", 0) < this.ibS && !cnN()) {
            bEv();
            return true;
        }
        return false;
    }

    private boolean cnN() {
        int i;
        String b2 = k.b(new Date());
        String string = SharedPrefHelper.getInstance().getString("KEY_QUITROOMRECOMMEND_COUNT", "");
        if (string.contains(",")) {
            String[] split = string.split(",");
            if (b2.equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
                if (i >= this.ibP) {
                    return true;
                }
                this.aHm = i;
                SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b2 + "," + (i + 1));
                return false;
            }
        }
        i = 0;
        this.aHm = i;
        SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b2 + "," + (i + 1));
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.ibI == view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quitlive_click").setContentExt(null, "quit_reco", null));
            if (this.mDialog != null && this.mDialog.isShowing()) {
                this.mDialog.dismiss();
            }
            cnL();
        }
    }
}
