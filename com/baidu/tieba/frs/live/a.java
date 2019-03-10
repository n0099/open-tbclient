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
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.al;
import com.baidu.tbadk.core.util.am;
import com.baidu.tieba.d;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.aq;
import com.baidu.tieba.frs.k;
import com.baidu.tieba.frs.live.c;
/* loaded from: classes4.dex */
public class a {
    private aq dfL;
    private FrsFragment faH;
    private TextView flf;
    private FrameLayout fqn;
    private ImageView fqo;
    private int fqq;
    private String fqr;
    private AlaLiveInfoCoreData fqs;
    private AlaLiveInfoListCoreData fqt;
    private c fqu;
    private int mForumId;
    private boolean isFirst = true;
    private c.a fqv = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.fqq = frsLiveTipResponseMessage.remindType;
                a.this.fqr = frsLiveTipResponseMessage.remindText;
                a.this.fqs = frsLiveTipResponseMessage.infoCoreData;
                a.this.fqt = frsLiveTipResponseMessage.listCoreData;
                if (a.this.dfL != null) {
                    a.this.dfL.beA();
                }
                if (a.this.fqq != 0) {
                    a.this.bhv();
                }
            }
        }
    };
    private Runnable fqw = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.fqu != null) {
                a.this.fqu.ra(a.this.mForumId);
            }
        }
    };
    private int fqp = bhz();

    public a(FrsFragment frsFragment, int i) {
        this.faH = frsFragment;
        this.mForumId = i;
    }

    public void bhu() {
        if (this.faH != null && this.faH.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.faH.bcH() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.fqu == null) {
                    this.fqu = new c(this.fqv);
                }
                e.jH().removeCallbacks(this.fqw);
                e.jH().postDelayed(this.fqw, TbConfig.NOTIFY_SOUND_INTERVAL);
            }
        }
    }

    public void bhv() {
        if (!StringUtils.isNull(this.fqr) && this.fqs != null) {
            if (this.fqq != 2 || bhz() < 3) {
                initView(this.faH.getPageContext().getPageActivity());
                if (this.flf != null) {
                    this.flf.setText(this.fqr);
                }
                onChangeSkinType();
                aPF();
                saveLastShowTime();
            }
        }
    }

    public void bhw() {
        if (this.faH != null) {
            this.faH.bct().rC(49);
        }
    }

    private void onChangeSkinType() {
        al.k(this.fqn, d.f.bg_frs_hot_live_tip_selector);
        al.j(this.flf, d.C0236d.cp_btn_a);
        al.c(this.fqo, d.f.icon_home_card_close_white);
        this.flf.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, al.getDrawable(d.f.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.fqn == null) {
            this.fqn = (FrameLayout) LayoutInflater.from(context).inflate(d.h.frs_hot_live_tip, (ViewGroup) null);
            this.fqn.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.bhx();
                }
            });
            this.flf = (TextView) this.fqn.findViewById(d.g.frs_hot_live_tip_content);
            this.fqo = (ImageView) this.fqn.findViewById(d.g.frs_hot_live_tip_close);
            this.fqo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.qp();
                }
            });
            onChangeSkinType();
        }
    }

    private void aPF() {
        k bcv;
        FrameLayout frameLayout;
        if (this.faH != null && (bcv = this.faH.bcv()) != null && bcv.getListView() != null && (frameLayout = (FrameLayout) bcv.bdN()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.h(TbadkCoreApplication.getInst(), d.e.ds56));
            if (this.dfL == null) {
                this.dfL = new aq();
            }
            if (this.fqq == 2) {
                this.dfL.a(this.fqn, frameLayout, layoutParams, 5000);
            } else if (this.fqq == 1) {
                this.dfL.a(this.fqn, frameLayout, layoutParams);
                TiebaStatic.log(new am("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void bhx() {
        bhA();
        if (this.fqs != null && this.faH != null && this.faH.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.fqs.userID));
            String str = "";
            if (this.fqq == 1) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_FOLLOWED_LIVE_TIP;
                TiebaStatic.log(new am("c12540"));
                if (this.dfL != null) {
                    this.dfL.hideTip();
                }
            } else if (this.fqq == 2) {
                str = AlaLiveRoomActivityConfig.FROM_TYPE_LIVE_FRS_HOT_LIVE_TIP;
                TiebaStatic.log(new am("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new AlaLiveRoomActivityConfig(this.faH.getPageContext().getPageActivity(), this.fqs, this.fqt, str, getUserId(), equals, null, null)));
            if (this.faH.bcS().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(2001622);
                customMessage.setTag(this.faH.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(2001622);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.jH().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.bhw();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void qp() {
        if (this.fqq == 2) {
            bhy();
        }
        if (this.dfL != null) {
            this.dfL.hideTip();
        }
    }

    private void bhy() {
        this.fqp++;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fqp);
    }

    private int bhz() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), 0);
    }

    private void bhA() {
        this.fqp = 0;
        com.baidu.tbadk.core.sharedPref.b.getInstance().putInt("FRS_HOT_LIVE_TIP_CLOSE_NUM" + getUserId(), this.fqp);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.getInstance().putLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.getInstance().getLong("FRS_HOT_LIVE_TIP_LAST_SHOWTIME" + getUserId(), 0L);
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
        if (this.dfL != null) {
            this.dfL.beA();
        }
        e.jH().removeCallbacks(this.fqw);
        if (this.fqu != null) {
            this.fqu.onDestory();
        }
    }
}
