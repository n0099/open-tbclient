package com.baidu.tieba.frs.live;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.g.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.mapapi.UIMsg;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes4.dex */
public class a {
    private aq dqo;
    private TextView fBl;
    private c fGA;
    private FrameLayout fGt;
    private ImageView fGu;
    private int fGw;
    private String fGx;
    private AlaLiveInfoCoreData fGy;
    private AlaLiveInfoListCoreData fGz;
    private FrsFragment fqI;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fGB = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fGw = frsLiveTipResponseMessage.remindType;
                a.this.fGx = frsLiveTipResponseMessage.remindText;
                a.this.fGy = frsLiveTipResponseMessage.infoCoreData;
                a.this.fGz = frsLiveTipResponseMessage.listCoreData;
                if (a.this.dqo != null) {
                    a.this.dqo.blP();
                }
                if (a.this.fGw != 0) {
                    a.this.boL();
                }
            }
        }
    };
    private Runnable fGC = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fGA != null) {
                a.this.fGA.se(a.this.mForumId);
            }
        }
    };
    private int fGv = boP();

    public a(FrsFragment frsFragment, int i) {
        this.fqI = frsFragment;
        this.mForumId = i;
    }

    public void boK() {
        if (this.fqI != null && this.fqI.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.fqI.bjY() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fGA == null) {
                    this.fGA = new c(this.fGB);
                }
                e.iB().removeCallbacks(this.fGC);
                e.iB().postDelayed(this.fGC, 5000L);
            }
        }
    }

    public void boL() {
        if (!StringUtils.isNull(this.fGx) && this.fGy != null) {
            if (this.fGw != 2 || boP() < 3) {
                initView(this.fqI.getPageContext().getPageActivity());
                if (this.fBl != null) {
                    this.fBl.setText(this.fGx);
                }
                onChangeSkinType();
                aVM();
                saveLastShowTime();
            }
        }
    }

    public void boM() {
        if (this.fqI != null) {
            this.fqI.bjK().sG(49);
        }
    }

    private void onChangeSkinType() {
        al.k(this.fGt, R.drawable.bg_frs_hot_live_tip_selector);
        al.j(this.fBl, R.color.cp_btn_a);
        al.c(this.fGu, (int) R.drawable.icon_home_card_close_white);
        this.fBl.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fGt == null) {
            this.fGt = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.fGt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.boN();
                }
            });
            this.fBl = (TextView) this.fGt.findViewById(R.id.frs_hot_live_tip_content);
            this.fGu = (ImageView) this.fGt.findViewById(R.id.frs_hot_live_tip_close);
            this.fGu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.pk();
                }
            });
            onChangeSkinType();
        }
    }

    private void aVM() {
        k bjM;
        FrameLayout frameLayout;
        if (this.fqI != null && (bjM = this.fqI.bjM()) != null && bjM.getListView() != null && (frameLayout = (FrameLayout) bjM.blb()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.g(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.dqo == null) {
                this.dqo = new aq();
            }
            if (this.fGw == 2) {
                this.dqo.a(this.fGt, frameLayout, layoutParams, UIMsg.m_AppUI.MSG_APP_GPS);
            } else if (this.fGw == 1) {
                this.dqo.a(this.fGt, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void boN() {
        boQ();
        if (this.fGy != null && this.fqI != null && this.fqI.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fGy.userID));
            String str = "";
            if (this.fGw == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.dqo != null) {
                    this.dqo.hideTip();
                }
            } else if (this.fGw == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.fqI.getPageContext().getPageActivity(), this.fGy, this.fGz, str, getUserId(), equals, null, null)));
            if (this.fqI.bkj().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.fqI.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.iB().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.boM();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pk() {
        if (this.fGw == 2) {
            boO();
        }
        if (this.dqo != null) {
            this.dqo.hideTip();
        }
    }

    private void boO() {
        this.fGv++;
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fGv);
    }

    private int boP() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void boQ() {
        this.fGv = 0;
        com.baidu.tbadk.core.sharedPref.b.agM().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fGv);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.agM().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.agM().getLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), 0L);
    }

    private boolean isFirst() {
        return this.isFirst;
    }

    private String getUserId() {
        AccountData currentAccountInfo = TbadkCoreApplication.getCurrentAccountInfo();
        if (currentAccountInfo != null) {
            String id = currentAccountInfo.getID();
            if (!TextUtils.isEmpty(id)) {
                return id;
            }
        }
        return "";
    }

    public void onDestory() {
        if (this.dqo != null) {
            this.dqo.blP();
        }
        e.iB().removeCallbacks(this.fGC);
        if (this.fGA != null) {
            this.fGA.onDestory();
        }
    }
}
