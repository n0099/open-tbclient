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
/* loaded from: classes10.dex */
public class a implements View.OnClickListener, b {
    private int aLr;
    private ab aLz;
    private TbPageContext bFu;
    private View iid;
    private com.baidu.live.w.a iie;
    private com.baidu.tieba.ala.quitroomrecommend.a iif;
    private BdListView iig;
    private boolean iih;
    private int iik;
    private String iil;
    private long iim;
    private long iin;
    private boolean iio;
    private Context mContext;
    private Dialog mDialog;
    private TextView mTitleView;
    private View rootView;
    private long iii = System.currentTimeMillis();
    private long iij = 0;
    private HttpMessageListener iip = new HttpMessageListener(1021226) { // from class: com.baidu.tieba.ala.quitroomrecommend.a.a.2
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(HttpResponsedMessage httpResponsedMessage) {
            if (httpResponsedMessage != null && httpResponsedMessage.getCmd() == 1021226 && (httpResponsedMessage instanceof AlaQuitRoomRecommendResponseMessage)) {
                if (httpResponsedMessage.hasError() || httpResponsedMessage.getError() != 0) {
                    a.this.coX();
                } else {
                    a.this.a((AlaQuitRoomRecommendResponseMessage) httpResponsedMessage);
                }
            }
        }
    };

    public a(TbPageContext tbPageContext) {
        this.iik = 1;
        this.iim = 7000L;
        this.iin = 3L;
        this.iio = false;
        this.bFu = tbPageContext;
        this.mContext = this.bFu.getPageActivity();
        ar arVar = com.baidu.live.ae.a.Qm().bwx;
        if (arVar != null && arVar.aOU != null) {
            this.iik = arVar.aOU.aLr;
            this.iil = arVar.aOU.aLq;
            this.iim = arVar.aOU.aLp;
            this.iin = arVar.aOU.aLs;
            this.iio = arVar.aOU.aLt;
        }
    }

    @Override // com.baidu.live.w.b
    public void a(ab abVar, com.baidu.live.w.a aVar) {
        this.aLz = abVar;
        this.iie = aVar;
        this.iij = System.currentTimeMillis();
    }

    @Override // com.baidu.live.w.b
    public void cL(int i) {
        if (this.mContext != null && this.mDialog != null && this.mDialog.isShowing()) {
            this.mDialog.dismiss();
        }
    }

    private void coT() {
        if (this.mDialog == null) {
            coU();
            this.rootView = LayoutInflater.from(this.mContext).inflate(a.g.sdk_ala_quit_room_recommend_dialog, (ViewGroup) null);
            this.mTitleView = (TextView) this.rootView.findViewById(a.f.sdk_ala_quit_tv_title);
            if (!TextUtils.isEmpty(this.iil)) {
                this.mTitleView.setText(this.iil);
            }
            this.iig = (BdListView) this.rootView.findViewById(a.f.sdk_ala_recommend_bdlist);
            this.iif = new com.baidu.tieba.ala.quitroomrecommend.a(this.mContext);
            this.iig.setAdapter((ListAdapter) this.iif);
            this.iid = this.rootView.findViewById(a.f.sdk_ala_tv_exit);
            this.iid.setOnClickListener(this);
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

    private void coU() {
        UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1394, "display", "liveroom", "quitreco_show").setContentExt(null, "quit_reco", null));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(AlaQuitRoomRecommendResponseMessage alaQuitRoomRecommendResponseMessage) {
        if (alaQuitRoomRecommendResponseMessage == null || alaQuitRoomRecommendResponseMessage.iiu == null || alaQuitRoomRecommendResponseMessage.iiu.isEmpty()) {
            coV();
            return;
        }
        coT();
        if (this.iif != null) {
            this.iif.setData(alaQuitRoomRecommendResponseMessage.iiu);
        }
    }

    private void coV() {
        coW();
    }

    private void coW() {
        if (this.iie != null) {
            this.iie.Py();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void coX() {
        coW();
    }

    private void bER() {
        if (this.aLz != null && this.aLz.mLiveInfo != null) {
            if (!this.iih) {
                this.iih = true;
                MessageManager.getInstance().registerListener(this.iip);
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.iii >= 1800000) {
                this.iii = currentTimeMillis;
            }
            com.baidu.tieba.ala.quitroomrecommend.data.b bVar = new com.baidu.tieba.ala.quitroomrecommend.data.b();
            int i = this.aLr;
            this.aLr = i + 1;
            bVar.iit = i;
            bVar.roomId = this.aLz.mLiveInfo.room_id;
            bVar.iii = this.iii;
            bVar.setParams();
            MessageManager.getInstance().sendMessage(bVar);
        }
    }

    @Override // com.baidu.live.w.b
    public void onDestroy() {
        this.iih = false;
        MessageManager.getInstance().unRegisterListener(this.iip);
    }

    @Override // com.baidu.live.w.b
    public boolean Pz() {
        if (this.iio && TbadkCoreApplication.isLogin() && System.currentTimeMillis() - this.iij >= this.iim && SharedPrefHelper.getInstance().getInt("KEY_QUITROOMRECOMMEND_CLICK_EXIT_COUNT", 0) < this.iin && !coY()) {
            bER();
            return true;
        }
        return false;
    }

    private boolean coY() {
        int i;
        String b = k.b(new Date());
        String string = SharedPrefHelper.getInstance().getString("KEY_QUITROOMRECOMMEND_COUNT", "");
        if (string.contains(",")) {
            String[] split = string.split(",");
            if (b.equals(split[0])) {
                i = Integer.valueOf(split[1]).intValue();
                if (i >= this.iik) {
                    return true;
                }
                this.aLr = i;
                SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b + "," + (i + 1));
                return false;
            }
        }
        i = 0;
        this.aLr = i;
        SharedPrefHelper.getInstance().putString("KEY_QUITROOMRECOMMEND_COUNT", b + "," + (i + 1));
        return false;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.iid == view) {
            UbcStatisticManager.getInstance().logEvent(new UbcStatisticItem(UbcStatisticLiveKey.KEY_ID_1396, "click", "liveroom", "quitlive_click").setContentExt(null, "quit_reco", null));
            if (this.mDialog != null && this.mDialog.isShowing()) {
                this.mDialog.dismiss();
            }
            coW();
        }
    }
}
