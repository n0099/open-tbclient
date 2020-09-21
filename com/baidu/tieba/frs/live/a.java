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
import com.baidu.adp.lib.f.e;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
import com.baidu.tbadk.ala.AlaLiveInfoCoreData;
import com.baidu.tbadk.ala.AlaLiveInfoListCoreData;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.data.AccountData;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.be;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.q;
/* loaded from: classes21.dex */
public class a {
    private FrsFragment icq;
    private ImageView ifC;
    private TextView ipD;
    private FrameLayout iva;
    private be ivb;
    private int ivd;
    private String ive;
    private AlaLiveInfoCoreData ivf;
    private AlaLiveInfoListCoreData ivg;
    private c ivh;
    private int mForumId;
    private boolean isFirst = true;
    private c.a ivi = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.ivd = frsLiveTipResponseMessage.remindType;
                a.this.ive = frsLiveTipResponseMessage.remindText;
                a.this.ivf = frsLiveTipResponseMessage.infoCoreData;
                a.this.ivg = frsLiveTipResponseMessage.listCoreData;
                if (a.this.ivb != null) {
                    a.this.ivb.crA();
                }
                if (a.this.ivd != 0) {
                    a.this.cuP();
                }
            }
        }
    };
    private Runnable ivj = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.ivh != null) {
                a.this.ivh.yL(a.this.mForumId);
            }
        }
    };
    private int ivc = cuT();

    public a(FrsFragment frsFragment, int i) {
        this.icq = frsFragment;
        this.mForumId = i;
    }

    public void cuO() {
        if (this.icq != null && this.icq.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.icq.cpw() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.ivh == null) {
                    this.ivh = new c(this.ivi);
                }
                e.mX().removeCallbacks(this.ivj);
                e.mX().postDelayed(this.ivj, 5000L);
            }
        }
    }

    public void cuP() {
        if (!StringUtils.isNull(this.ive) && this.ivf != null) {
            if (this.ivd != 2 || cuT() < 3) {
                dK(this.icq.getPageContext().getPageActivity());
                if (this.ipD != null) {
                    this.ipD.setText(this.ive);
                }
                onChangeSkinType();
                ccj();
                saveLastShowTime();
            }
        }
    }

    public void cuQ() {
        if (this.icq != null) {
            this.icq.cpd().sn(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.iva, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.ipD, R.color.cp_cont_a);
        ap.setImageResource(this.ifC, R.drawable.icon_home_card_close_white);
        this.ipD.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void dK(Context context) {
        if (context != null && this.iva == null) {
            this.iva = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.iva.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cuR();
                }
            });
            this.ipD = (TextView) this.iva.findViewById(R.id.frs_hot_live_tip_content);
            this.ifC = (ImageView) this.iva.findViewById(R.id.frs_hot_live_tip_close);
            this.ifC.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rO();
                }
            });
            onChangeSkinType();
        }
    }

    private void ccj() {
        q cpf;
        FrameLayout frameLayout;
        if (this.icq != null && (cpf = this.icq.cpf()) != null && cpf.getListView() != null && (frameLayout = (FrameLayout) cpf.cqF()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.ivb == null) {
                this.ivb = new be();
            }
            if (this.ivd == 2) {
                this.ivb.a(this.iva, frameLayout, layoutParams, 5000);
            } else if (this.ivd == 1) {
                this.ivb.a(this.iva, frameLayout, layoutParams);
                TiebaStatic.log(new aq("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cuR() {
        cuU();
        if (this.ivf != null && this.icq != null && this.icq.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.ivf.userID));
            String str = "";
            if (this.ivd == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new aq("c12540"));
                if (this.ivb != null) {
                    this.ivb.hideTip();
                }
            } else if (this.ivd == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new aq("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.icq.getPageContext().getPageActivity(), this.ivf, this.ivg, str, getUserId(), equals, null, null)));
            if (this.icq.cpJ().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.icq.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mX().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cuQ();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rO() {
        if (this.ivd == 2) {
            cuS();
        }
        if (this.ivb != null) {
            this.ivb.hideTip();
        }
    }

    private void cuS() {
        this.ivc++;
        com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.ivc);
    }

    private int cuT() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cuU() {
        this.ivc = 0;
        com.baidu.tbadk.core.sharedPref.b.bjf().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.ivc);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.bjf().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.bjf().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.ivb != null) {
            this.ivb.crA();
        }
        e.mX().removeCallbacks(this.ivj);
        if (this.ivh != null) {
            this.ivh.onDestory();
        }
    }
}
