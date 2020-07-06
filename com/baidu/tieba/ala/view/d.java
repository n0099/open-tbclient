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
import com.baidu.tieba.ala.data.g;
import com.baidu.tieba.ala.data.m;
import com.baidu.tieba.ala.data.n;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes3.dex */
public class d {
    private int ayf;
    private LinearLayout baM;
    private CommonEmptyView baR;
    private a fFz;
    private long ffd;
    private String fff;
    private boolean ffg;
    private AlaLastLiveroomInfo fgP = new AlaLastLiveroomInfo();
    private TbPageContext<BaseFragmentActivity> gHM;
    private BdListView gIn;
    private com.baidu.tieba.ala.adapter.b gIo;
    private com.baidu.tieba.ala.view.a gIp;
    private c gIq;
    private b gIr;
    private AlaRankListHeaderView gIs;
    private LinearLayout gIt;
    private n gIu;
    private ArrayList<g> gIv;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes3.dex */
    public interface a {
        void g(View view, String str);
    }

    public d(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.gHM = tbPageContext;
        this.mContext = this.gHM.getPageActivity();
        this.fFz = aVar;
        this.ffg = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.ayf = i;
        this.mPortrait = str3;
        this.ffd = j2;
        this.fgP.setLastAnchorPortrait(str3);
        this.fgP.setLastAnchorUname(str2);
        this.fgP.setLastAnchorUid(String.valueOf(j));
        this.fgP.setLastLiveId(this.ffd);
        this.fgP.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        DF(str);
    }

    private void DF(String str) {
        this.fff = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.h.ala_rank_fragment_layout, (ViewGroup) null);
        this.gIn = (BdListView) this.mRootView.findViewById(a.g.ala_rank_list_view);
        this.gIo = new com.baidu.tieba.ala.adapter.b(this.mContext, str, this.ffd, this.ffg, this.fgP);
        this.gIn.setAdapter((ListAdapter) this.gIo);
        this.gIs = new AlaRankListHeaderView(this.gHM.getPageActivity(), this.ffd, this.ffg, this.fgP);
        this.gIs.a(this.gHM, str, 0L);
        this.gIn.addHeaderView(this.gIs);
        if (TextUtils.equals("hour", this.fff) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.gIt = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.h.hour_rank_list_footer_view, (ViewGroup) null);
            this.gIn.addFooterView(this.gIt);
            this.gIt.setVisibility(0);
        } else if (this.gIt != null) {
            this.gIt.setVisibility(8);
        }
        this.baM = (LinearLayout) this.mRootView.findViewById(a.g.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.gIp = new com.baidu.tieba.ala.view.a(this.mContext, str, this.ffg);
            this.gIp.a(this.fFz);
            this.baM.addView(this.gIp.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.gIq = new c(this.mContext, str, this.ffg, this.mUserId, this.ayf, this.mPortrait);
            this.baM.addView(this.gIq.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.gIr = new b(this.mContext, str, this.ffg, this.mPortrait);
            this.baM.addView(this.gIr.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.e.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.gIp = new com.baidu.tieba.ala.view.a(this.mContext, str, this.ffg);
            this.gIp.a(this.fFz);
            this.baM.addView(this.gIp.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.baR = (CommonEmptyView) this.mRootView.findViewById(a.g.ala_rank_list_empty);
        this.gIn.setEmptyView(this.baR);
    }

    public void yA() {
        if (this.gIp != null) {
            this.gIp.yA();
        }
    }

    public void setDatas(ArrayList<g> arrayList) {
        if (this.gIo != null) {
            this.gIo.setData(arrayList);
            this.gIv = arrayList;
        }
    }

    public void a(ArrayList<g> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.gIs.setCountDownCallback(aVar);
        this.gIs.a(this.gHM, this.fff, j);
    }

    public ArrayList<g> bkP() {
        return this.gIv;
    }

    public void c(m mVar) {
        this.gIs.b(mVar);
    }

    public void sw(int i) {
        if (this.gIs != null) {
            this.gIs.setHourHeaderInfoVisible(i);
        }
    }

    public void sx(int i) {
        if (this.gIt != null) {
            this.gIt.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.gIs != null) {
            this.gIs.setRankListCallback(bVar);
        }
    }

    public void sy(int i) {
        this.gIn.setVisibility(i);
    }

    public n bMS() {
        return this.gIu;
    }

    public void c(final n nVar) {
        if (nVar == null) {
            if (this.gIp != null) {
                this.gIp.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!nVar.isValid()) {
            nVar.userName = this.mUserName;
            nVar.fEs = this.mPortrait;
        }
        this.gIu = nVar;
        View view = null;
        if (this.gIp != null) {
            this.gIp.b(nVar);
            this.gIp.getView().setVisibility(0);
            view = this.gIp.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.d.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (nVar != null && (d.this.mContext instanceof Activity)) {
                        Intent intent = ((Activity) d.this.mContext).getIntent();
                        long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                        String stringExtra = intent.getStringExtra("group_id");
                        String stringExtra2 = intent.getStringExtra("live_id");
                        boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                        String stringExtra3 = intent.getStringExtra("live_owner_uid");
                        if (longExtra == nVar.userId) {
                            stringExtra3 = longExtra + "";
                        }
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(d.this.mContext, nVar.userId + "", nVar.userName, nVar.fEs, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, nVar.getNameShow(), "");
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void bMT() {
        if (this.gIp != null) {
            this.gIp.getView().setVisibility(8);
        }
        if (this.gIq != null) {
            this.gIq.getView().setVisibility(8);
        }
        if (this.gIr != null) {
            this.gIr.getView().setVisibility(8);
        }
    }

    public void l(View.OnClickListener onClickListener) {
        this.baR.reset();
        this.baR.setTitle(a.i.sdk_net_fail_tip_rank);
        this.baR.setRefreshButton(a.i.sdk_click_refresh_net_text, onClickListener);
        this.baR.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.baR.setVisibility(0);
    }

    public void btO() {
        this.baR.setVisibility(8);
    }

    public void jS(boolean z) {
        if (z) {
            this.baR.reset();
            this.baR.setTitle(a.i.rank_empty_text);
            this.baR.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.baR.setVisibility(0);
            return;
        }
        this.baR.setVisibility(8);
    }

    public void release() {
        if (this.gIs != null) {
            this.gIs.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
