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
import com.baidu.tbadk.core.util.ar;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class a {
    private TextView jAy;
    private FrameLayout jFW;
    private bb jFX;
    private int jFZ;
    private String jGa;
    private AlaLiveInfoCoreData jGb;
    private AlaLiveInfoListCoreData jGc;
    private c jGd;
    private FrsFragment jkB;
    private ImageView jnJ;
    private int mForumId;
    private boolean isFirst = true;
    private c.a jGe = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.jFZ = frsLiveTipResponseMessage.remindType;
                a.this.jGa = frsLiveTipResponseMessage.remindText;
                a.this.jGb = frsLiveTipResponseMessage.infoCoreData;
                a.this.jGc = frsLiveTipResponseMessage.listCoreData;
                if (a.this.jFX != null) {
                    a.this.jFX.cFd();
                }
                if (a.this.jFZ != 0) {
                    a.this.cJv();
                }
            }
        }
    };
    private Runnable jGf = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jGd != null) {
                a.this.jGd.zZ(a.this.mForumId);
            }
        }
    };
    private int jFY = cJz();

    public a(FrsFragment frsFragment, int i) {
        this.jkB = frsFragment;
        this.mForumId = i;
    }

    public void cJu() {
        if (this.jkB != null && this.jkB.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.jkB.cCY() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.jGd == null) {
                    this.jGd = new c(this.jGe);
                }
                e.mA().removeCallbacks(this.jGf);
                e.mA().postDelayed(this.jGf, 5000L);
            }
        }
    }

    public void cJv() {
        if (!StringUtils.isNull(this.jGa) && this.jGb != null) {
            if (this.jFZ != 2 || cJz() < 3) {
                initView(this.jkB.getPageContext().getPageActivity());
                if (this.jAy != null) {
                    this.jAy.setText(this.jGa);
                }
                onChangeSkinType();
                cpl();
                saveLastShowTime();
            }
        }
    }

    public void cJw() {
        if (this.jkB != null) {
            this.jkB.cCF().sV(49);
        }
    }

    private void onChangeSkinType() {
        ap.setBackgroundResource(this.jFW, R.drawable.bg_frs_hot_live_tip_selector);
        ap.setViewTextColor(this.jAy, R.color.CAM_X0101);
        ap.setImageResource(this.jnJ, R.drawable.icon_home_card_close_white);
        this.jAy.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ap.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.jFW == null) {
            this.jFW = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.jFW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cJx();
                }
            });
            this.jAy = (TextView) this.jFW.findViewById(R.id.frs_hot_live_tip_content);
            this.jnJ = (ImageView) this.jFW.findViewById(R.id.frs_hot_live_tip_close);
            this.jnJ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rp();
                }
            });
            onChangeSkinType();
        }
    }

    private void cpl() {
        q cCH;
        FrameLayout frameLayout;
        if (this.jkB != null && (cCH = this.jkB.cCH()) != null && cCH.getListView() != null && (frameLayout = (FrameLayout) cCH.cEi()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jFX == null) {
                this.jFX = new bb();
            }
            if (this.jFZ == 2) {
                this.jFX.a(this.jFW, frameLayout, layoutParams, 5000);
            } else if (this.jFZ == 1) {
                this.jFX.a(this.jFW, frameLayout, layoutParams);
                TiebaStatic.log(new ar("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJx() {
        cJA();
        if (this.jGb != null && this.jkB != null && this.jkB.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.jGb.userID));
            String str = "";
            if (this.jFZ == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new ar("c12540"));
                if (this.jFX != null) {
                    this.jFX.hideTip();
                }
            } else if (this.jFZ == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new ar("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jkB.getPageContext().getPageActivity(), this.jGb, this.jGc, str, getUserId(), equals, null, null)));
            if (this.jkB.cDm().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.jkB.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mA().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cJw();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp() {
        if (this.jFZ == 2) {
            cJy();
        }
        if (this.jFX != null) {
            this.jFX.hideTip();
        }
    }

    private void cJy() {
        this.jFY++;
        com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jFY);
    }

    private int cJz() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cJA() {
        this.jFY = 0;
        com.baidu.tbadk.core.sharedPref.b.brR().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jFY);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.brR().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.brR().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.jFX != null) {
            this.jFX.cFd();
        }
        e.mA().removeCallbacks(this.jGf);
        if (this.jGd != null) {
            this.jGd.onDestory();
        }
    }
}
