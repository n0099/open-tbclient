package com.baidu.tieba.ala.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.widget.listview.BdListView;
import com.baidu.live.sdk.a;
import com.baidu.live.tbadk.TbPageContext;
import com.baidu.live.tbadk.ala.AlaLastLiveroomInfo;
import com.baidu.live.tbadk.core.BaseFragmentActivity;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.atomdata.AlaPersonCardActivityConfig;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.TbEnum;
import com.baidu.live.tbadk.statics.SdkStaticKeys;
import com.baidu.live.tbadk.widget.CommonEmptyView;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes4.dex */
public class g {
    private int aIU;
    private LinearLayout bmN;
    private CommonEmptyView bmS;
    private long fLa;
    private String fLc;
    private boolean fLd;
    private AlaLastLiveroomInfo fMS = new AlaLastLiveroomInfo();
    private a gmB;
    private TbPageContext<BaseFragmentActivity> htJ;
    private BdListView huk;
    private com.baidu.tieba.ala.adapter.c hul;
    private d hum;
    private f hun;
    private e huo;
    private AlaRankListHeaderView hup;
    private LinearLayout huq;
    private p hur;
    private ArrayList<com.baidu.tieba.ala.data.h> hus;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes4.dex */
    public interface a {
        void g(View view, String str);
    }

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.htJ = tbPageContext;
        this.mContext = this.htJ.getPageActivity();
        this.gmB = aVar;
        this.fLd = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aIU = i;
        this.mPortrait = str3;
        this.fLa = j2;
        this.fMS.setLastAnchorPortrait(str3);
        this.fMS.setLastAnchorUname(str2);
        this.fMS.setLastAnchorUid(String.valueOf(j));
        this.fMS.setLastLiveId(this.fLa);
        this.fMS.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        HY(str);
    }

    private void HY(String str) {
        this.fLc = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.huk = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.hul = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.fLa, this.fLd, this.fMS);
        this.huk.setAdapter((ListAdapter) this.hul);
        this.hup = new AlaRankListHeaderView(this.htJ.getPageActivity(), this.fLa, this.fLd, this.fMS);
        this.hup.a(this.htJ, str, 0L);
        this.huk.addHeaderView(this.hup);
        if (TextUtils.equals("hour", this.fLc) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.huq = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.huk.addFooterView(this.huq);
            this.huq.setVisibility(0);
        } else if (this.huq != null) {
            this.huq.setVisibility(8);
        }
        this.bmN = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.hum = new d(this.mContext, str, this.fLd);
            this.hum.a(this.gmB);
            this.bmN.addView(this.hum.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.hun = new f(this.mContext, str, this.fLd, this.mUserId, this.aIU, this.mPortrait);
            this.bmN.addView(this.hun.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.huo = new e(this.mContext, str, this.fLd, this.mPortrait);
            this.bmN.addView(this.huo.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.hum = new d(this.mContext, str, this.fLd);
            this.hum.a(this.gmB);
            this.bmN.addView(this.hum.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.bmS = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.huk.setEmptyView(this.bmS);
    }

    public void FS() {
        if (this.hum != null) {
            this.hum.FS();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.hul != null) {
            this.hul.setData(arrayList);
            this.hus = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.hup.setCountDownCallback(aVar);
        this.hup.a(this.htJ, this.fLc, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bBq() {
        return this.hus;
    }

    public void c(n nVar) {
        this.hup.b(nVar);
    }

    public void wb(int i) {
        if (this.hup != null) {
            this.hup.setHourHeaderInfoVisible(i);
        }
    }

    public void wc(int i) {
        if (this.huq != null) {
            this.huq.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.hup != null) {
            this.hup.setRankListCallback(bVar);
        }
    }

    public void wd(int i) {
        this.huk.setVisibility(i);
    }

    public p cgh() {
        return this.hur;
    }

    public void c(final p pVar) {
        if (pVar == null) {
            if (this.hum != null) {
                this.hum.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!pVar.isValid()) {
            pVar.userName = this.mUserName;
            pVar.bdPortrait = this.mPortrait;
        }
        this.hur = pVar;
        View view = null;
        if (this.hum != null) {
            this.hum.b(pVar);
            this.hum.getView().setVisibility(0);
            view = this.hum.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (pVar != null && (g.this.mContext instanceof Activity)) {
                        Intent intent = ((Activity) g.this.mContext).getIntent();
                        long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                        String stringExtra = intent.getStringExtra("group_id");
                        String stringExtra2 = intent.getStringExtra("live_id");
                        boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                        String stringExtra3 = intent.getStringExtra("live_owner_uid");
                        if (longExtra == pVar.userId) {
                            stringExtra3 = longExtra + "";
                        }
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(g.this.mContext, pVar.userId + "", pVar.userName, pVar.bdPortrait, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, pVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void cgi() {
        if (this.hum != null) {
            this.hum.getView().setVisibility(8);
        }
        if (this.hun != null) {
            this.hun.getView().setVisibility(8);
        }
        if (this.huo != null) {
            this.huo.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.bmS.reset();
        this.bmS.setTitle(a.i.sdk_net_fail_tip_rank);
        this.bmS.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.bmS.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bmS.setVisibility(0);
    }

    public void SK() {
        this.bmS.setVisibility(8);
    }

    public void lw(boolean z) {
        if (z) {
            this.bmS.reset();
            this.bmS.setTitle(a.i.rank_empty_text);
            this.bmS.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bmS.setVisibility(0);
            return;
        }
        this.bmS.setVisibility(8);
    }

    public void release() {
        if (this.hup != null) {
            this.hup.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
