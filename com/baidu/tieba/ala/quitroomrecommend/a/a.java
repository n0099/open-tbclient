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
/* loaded from: classes11.dex */
public class a implements View.OnClickListener, b {
    private int aLZ;
    private x aMh;
    private TbPageContext bFa;
    private int igA;
    private String igB;
    private long igC;
    private long igD;
    private boolean igE;
    private View igt;
    private com.baidu.live.y.a igu;
    private com.baidu.tieba.ala.quitroomrecommend.a igv;
    private BdListView igw;
    private boolean igx;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitleView;
    private View rootView;
    private long igy = System.currentTimeMillis();
    private long igz = 0;
    private HttpMessageListener igF = new HttpMessageListener(1021226) { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021226 && (httpResponsedMessage instanceof AlaQuitRoomRecommendResponseMessage)) {
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    a.this.crD();
                } else {
                    a.this.a((AlaQuitRoomRecommendResponseMessage) httpResponsedMessage);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.igA = 1;
        this.igC = 7000L;
        this.igD = 3L;
        this.igE = false;
        this.bFa = tbPageContext;
        this.mContext = this.bFa.getPageActivity();
        an anVar = com.baidu.live.af.a.SE().bwi;
        if (anVar != null && anVar.aPr != null) {
            this.igA = anVar.aPr.aLZ;
            this.igB = anVar.aPr.aLY;
            this.igC = anVar.aPr.aLX;
            this.igD = anVar.aPr.aMa;
            this.igE = anVar.aPr.aMb;
        }
    }

    @Override // com.baidu.live.y.b
    public void a(x xVar, com.baidu.live.y.a aVar) {
        this.aMh = xVar;
        this.igu = aVar;
        this.igz = System.currentTimeMillis();
    }

    @Override // com.baidu.live.y.b
    public void el(int i) {
        if (this.mContext != null && this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    private void crz() {
        if (this.mDialog == null) {
            crA();
            this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_quit_room_recommend_dialog, (ViewGroup) null);
            this.mTitleView = (TextView) this.rootView.findViewById(a.f.sdk_ala_quit_tv_title);
            if (!TextUtils.isEmpty(this.igB)) {
                this.mTitleView.setText(this.igB);
            }
            this.igw = (BdListView) this.rootView.findViewById(a.f.sdk_ala_recommend_bdlist);
            this.igv = new com.baidu.tieba.ala.quitroomrecommend.a(this.mContext);
            this.igw.setAdapter((ListAdapter) this.igv);
            this.igt = this.rootView.findViewById(a.f.sdk_ala_tv_exit);
            this.igt.setOnClickListener(this);
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

    private void crA() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quitreco_show").setContentExt(null, "quit_reco", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaQuitRoomRecommendResponseMessage alaQuitRoomRecommendResponseMessage) {
        if (alaQuitRoomRecommendResponseMessage == null || alaQuitRoomRecommendResponseMessage.igK == null || alaQuitRoomRecommendResponseMessage.igK.isEmpty()) {
            crB();
            return;
        }
        crz();
        if (this.igv != null) {
            this.igv.setData(alaQuitRoomRecommendResponseMessage.igK);
        }
    }

    private void crB() {
        crC();
    }

    private void crC() {
        if (this.igu != null) {
            this.igu.RR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void crD() {
        crC();
    }

    private void bIm() {
        if (this.aMh != null && this.aMh.mLiveInfo != null) {
            if (!this.igx) {
                this.igx = true;
                MessageManager.getInstance().registerListener(this.igF);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.igy >= 1800000) {
                this.igy = currentTimeMillis;
            }
            com.baidu.tieba.ala.quitroomrecommend.data.b bVar = new com.baidu.tieba.ala.quitroomrecommend.data.b();
            int i = this.aLZ;
            this.aLZ = i + 1;
            bVar.igJ = i;
            bVar.roomId = this.aMh.mLiveInfo.room_id;
            bVar.igy = this.igy;
            bVar.setParams();
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.y.b
    public void onDestroy() {
        this.igx = false;
        MessageManager.getInstance().unRegisterListener(this.igF);
    }

    @Override // com.baidu.live.y.b
    public boolean RS() {
        if (this.igE && TbadkCoreApplication.isLogin() && System.currentTimeMillis() - this.igz >= this.igC && SharedPrefHelper.getInstance().getInt("KEY_QUITROOMRECOMMEND_CLICK_EXIT_COUNT", 0) < this.igD && !crE()) {
            bIm();
            return true;
        }
        return false;
    }

    private boolean crE() {
        int i;
        String b2 = k.b(new Date());
        String string = SharedPrefHelper.getInstance().getString("KEY_QUITROOMRECOMMEND_COUNT", "");
        if (string.contains(",")) {
            String[] split = string.split(",");
            if (b2.equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
                if (i >= this.igA) {
                    return true;
                }
                this.aLZ = i;
                SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b2 + "," + (i + 1));
                return false;
            }
        }
        i = 0;
        this.aLZ = i;
        SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b2 + "," + (i + 1));
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.igt == view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quitlive_click").setContentExt(null, "quit_reco", null));
            if (this.mDialog != null && this.mDialog.isShowing()) {
                this.mDialog.dismiss();
            }
            crC();
        }
    }
}
