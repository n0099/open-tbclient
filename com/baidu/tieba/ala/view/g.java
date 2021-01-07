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
import com.baidu.tieba.ala.data.p;
import com.baidu.tieba.ala.data.r;
import com.baidu.tieba.ala.view.AlaRankListHeaderView;
import java.util.ArrayList;
/* loaded from: classes11.dex */
public class g {
    private int aMi;
    private LinearLayout bxO;
    private CommonEmptyView bxT;
    private LinearLayout ceJ;
    private a gWM;
    private String grB;
    private boolean grC;
    private long grz;
    private AlaLastLiveroomInfo gtp = new AlaLastLiveroomInfo();
    private TbPageContext<BaseFragmentActivity> iiA;
    private BdListView ijb;
    private com.baidu.tieba.ala.adapter.c ijc;
    private d ijd;
    private f ije;
    private e ijf;
    private AlaRankListHeaderView ijg;
    private r ijh;
    private ArrayList<com.baidu.tieba.ala.data.h> iji;
    private Context mContext;
    private String mPortrait;
    private View mRootView;
    private long mUserId;
    private String mUserName;

    /* loaded from: classes11.dex */
    public interface a {
        void g(View view, String str);
    }

    public g(TbPageContext<BaseFragmentActivity> tbPageContext, String str, int i, a aVar, boolean z, long j, String str2, String str3, long j2) {
        this.iiA = tbPageContext;
        this.mContext = this.iiA.getPageActivity();
        this.gWM = aVar;
        this.grC = z;
        this.mUserId = j;
        this.mUserName = str2;
        this.aMi = i;
        this.mPortrait = str3;
        this.grz = j2;
        this.gtp.setLastAnchorPortrait(str3);
        this.gtp.setLastAnchorUname(str2);
        this.gtp.setLastAnchorUid(String.valueOf(j));
        this.gtp.setLastLiveId(this.grz);
        this.gtp.setFrom(AlaLastLiveroomInfo.TYPE_FROM_HOUR_RANK);
        Jd(str);
    }

    private void Jd(String str) {
        this.grB = str;
        this.mRootView = LayoutInflater.from(this.mContext).inflate(a.g.ala_rank_fragment_layout, (ViewGroup) null);
        this.ijb = (BdListView) this.mRootView.findViewById(a.f.ala_rank_list_view);
        this.ijc = new com.baidu.tieba.ala.adapter.c(this.mContext, str, this.grz, this.grC, this.gtp);
        this.ijb.setAdapter((ListAdapter) this.ijc);
        this.ijg = new AlaRankListHeaderView(this.iiA.getPageActivity(), this.grz, this.grC, this.gtp);
        this.ijg.a(this.iiA, str, 0L);
        this.ijb.addHeaderView(this.ijg);
        if (TextUtils.equals("hour", this.grB) && !TbadkCoreApplication.getInst().isTieba() && !TbadkCoreApplication.getInst().isMobileBaidu()) {
            this.ceJ = (LinearLayout) LayoutInflater.from(this.mContext).inflate(a.g.hour_rank_list_footer_view, (ViewGroup) null);
            this.ijb.addFooterView(this.ceJ);
            this.ceJ.setVisibility(0);
        } else if (this.ceJ != null) {
            this.ceJ.setVisibility(8);
        }
        this.bxO = (LinearLayout) this.mRootView.findViewById(a.f.ala_rank_list_bottom_container);
        if ("hot".equals(str) || SdkStaticKeys.RANK_TYPE_FLOWER.equals(str)) {
            this.ijd = new d(this.mContext, str, this.grC);
            this.ijd.a(this.gWM);
            this.bxO.addView(this.ijd.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds124)));
        } else if ("pk".equals(str)) {
            this.ije = new f(this.mContext, str, this.grC, this.mUserId, this.aMi, this.mPortrait);
            this.bxO.addView(this.ije.getView(), new LinearLayout.LayoutParams(-1, -2));
        } else if ("guard".equals(str)) {
            this.ijf = new e(this.mContext, str, this.grC, this.mPortrait);
            this.bxO.addView(this.ijf.getView(), new LinearLayout.LayoutParams(-1, this.mContext.getResources().getDimensionPixelSize(a.d.sdk_ds92)));
        } else if ("challenge_history".equals(str)) {
            Log.d("rankType", "ALA_RANK_LIST_TYPE_CHALLENGE_HISTORY");
        } else {
            this.ijd = new d(this.mContext, str, this.grC);
            this.ijd.a(this.gWM);
            this.bxO.addView(this.ijd.getView(), new LinearLayout.LayoutParams(-1, -2));
        }
        this.bxT = (CommonEmptyView) this.mRootView.findViewById(a.f.ala_rank_list_empty);
        this.ijb.setEmptyView(this.bxT);
    }

    public void Hp() {
        if (this.ijd != null) {
            this.ijd.Hp();
        }
    }

    public void setDatas(ArrayList<com.baidu.tieba.ala.data.h> arrayList) {
        if (this.ijc != null) {
            this.ijc.setData(arrayList);
            this.iji = arrayList;
        }
    }

    public void a(ArrayList<com.baidu.tieba.ala.data.h> arrayList, long j, AlaRankListHeaderView.a aVar) {
        setDatas(arrayList);
        this.ijg.setCountDownCallback(aVar);
        this.ijg.a(this.iiA, this.grB, j);
    }

    public ArrayList<com.baidu.tieba.ala.data.h> bKX() {
        return this.iji;
    }

    public void c(p pVar) {
        this.ijg.b(pVar);
    }

    public void xZ(int i) {
        if (this.ijg != null) {
            this.ijg.setHourHeaderInfoVisible(i);
        }
    }

    public void gW(int i) {
        if (this.ceJ != null) {
            this.ceJ.setVisibility(i);
        }
    }

    public void a(AlaRankListHeaderView.b bVar) {
        if (this.ijg != null) {
            this.ijg.setRankListCallback(bVar);
        }
    }

    public void ya(int i) {
        this.ijb.setVisibility(i);
    }

    public r csm() {
        return this.ijh;
    }

    public void c(final r rVar) {
        if (rVar == null) {
            if (this.ijd != null) {
                this.ijd.getView().setVisibility(8);
                return;
            }
            return;
        }
        if (!rVar.isValid()) {
            rVar.userName = this.mUserName;
            rVar.bdPortrait = this.mPortrait;
        }
        this.ijh = rVar;
        View view = null;
        if (this.ijd != null) {
            this.ijd.b(rVar);
            this.ijd.getView().setVisibility(0);
            view = this.ijd.getView();
        }
        if (TbadkCoreApplication.getInst().isNotMobileBaidu()) {
            view.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.ala.view.g.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view2) {
                    if (rVar != null && (g.this.mContext instanceof Activity)) {
                        Intent intent = ((Activity) g.this.mContext).getIntent();
                        long longExtra = intent.getLongExtra(TbEnum.SystemMessage.KEY_USER_ID, 0L);
                        String stringExtra = intent.getStringExtra("group_id");
                        String stringExtra2 = intent.getStringExtra("live_id");
                        boolean booleanExtra = intent.getBooleanExtra("live_owner_flag", false);
                        String stringExtra3 = intent.getStringExtra("live_owner_uid");
                        if (longExtra == rVar.userId) {
                            stringExtra3 = longExtra + "";
                        }
                        AlaPersonCardActivityConfig alaPersonCardActivityConfig = new AlaPersonCardActivityConfig(g.this.mContext, rVar.userId + "", rVar.userName, rVar.bdPortrait, 0, 0, null, null, 0L, 0L, 0L, 0, stringExtra, stringExtra2, booleanExtra, stringExtra3, null, rVar.getNameShow());
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, alaPersonCardActivityConfig));
                    }
                }
            });
        }
    }

    public void csn() {
        if (this.ijd != null) {
            this.ijd.getView().setVisibility(8);
        }
        if (this.ije != null) {
            this.ije.getView().setVisibility(8);
        }
        if (this.ijf != null) {
            this.ijf.getView().setVisibility(8);
        }
    }

    public void n(View.OnClickListener onClickListener) {
        this.bxT.reset();
        this.bxT.setTitle(a.h.sdk_net_fail_tip_rank);
        this.bxT.setRefreshButton(a.h.sdk_click_refresh_net_text, onClickListener);
        this.bxT.setup(CommonEmptyView.ImgType.NO_NET, CommonEmptyView.StyleType.DARK);
        this.bxT.setVisibility(0);
    }

    public void Zj() {
        this.bxT.setVisibility(8);
    }

    public void dM(boolean z) {
        if (z) {
            this.bxT.reset();
            this.bxT.setTitle(a.h.rank_empty_text);
            this.bxT.setup(CommonEmptyView.ImgType.NO_RANK_LIST, CommonEmptyView.StyleType.DARK);
            this.bxT.setVisibility(0);
            return;
        }
        this.bxT.setVisibility(8);
    }

    public void release() {
        if (this.ijg != null) {
            this.ijg.release();
        }
    }

    public View getView() {
        return this.mRootView;
    }
}
