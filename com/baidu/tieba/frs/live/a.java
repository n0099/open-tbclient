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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.FrsFragment;
import com.baidu.tieba.frs.bb;
import com.baidu.tieba.frs.live.c;
import com.baidu.tieba.frs.q;
/* loaded from: classes2.dex */
public class a {
    private FrsFragment jcX;
    private ImageView jge;
    private TextView jsV;
    private AlaLiveInfoListCoreData jyA;
    private c jyB;
    private FrameLayout jyu;
    private bb jyv;
    private int jyx;
    private String jyy;
    private AlaLiveInfoCoreData jyz;
    private int mForumId;
    private boolean isFirst = true;
    private c.a jyC = new c.a() { // from class: com.baidu.tieba.frs.live.a.1
        @Override // com.baidu.tieba.frs.live.c.a
        public void a(FrsLiveTipResponseMessage frsLiveTipResponseMessage) {
            if (frsLiveTipResponseMessage != null) {
                a.this.jyx = frsLiveTipResponseMessage.remindType;
                a.this.jyy = frsLiveTipResponseMessage.remindText;
                a.this.jyz = frsLiveTipResponseMessage.infoCoreData;
                a.this.jyA = frsLiveTipResponseMessage.listCoreData;
                if (a.this.jyv != null) {
                    a.this.jyv.cDE();
                }
                if (a.this.jyx != 0) {
                    a.this.cHV();
                }
            }
        }
    };
    private Runnable jyD = new Runnable() { // from class: com.baidu.tieba.frs.live.a.2
        @Override // java.lang.Runnable
        public void run() {
            if (a.this.jyB != null) {
                a.this.jyB.zP(a.this.mForumId);
            }
        }
    };
    private int jyw = cHZ();

    public a(FrsFragment frsFragment, int i) {
        this.jcX = frsFragment;
        this.mForumId = i;
    }

    public void cHU() {
        if (this.jcX != null && this.jcX.isAdded()) {
            if (System.currentTimeMillis() - getLastShowTime() >= 1800000) {
                if (this.jcX.cBz() && isFirst()) {
                    this.isFirst = false;
                    return;
                }
                if (this.jyB == null) {
                    this.jyB = new c(this.jyC);
                }
                e.mB().removeCallbacks(this.jyD);
                e.mB().postDelayed(this.jyD, 5000L);
            }
        }
    }

    public void cHV() {
        if (!StringUtils.isNull(this.jyy) && this.jyz != null) {
            if (this.jyx != 2 || cHZ() < 3) {
                initView(this.jcX.getPageContext().getPageActivity());
                if (this.jsV != null) {
                    this.jsV.setText(this.jyy);
                }
                onChangeSkinType();
                cnT();
                saveLastShowTime();
            }
        }
    }

    public void cHW() {
        if (this.jcX != null) {
            this.jcX.cBg().sO(49);
        }
    }

    private void onChangeSkinType() {
        ao.setBackgroundResource(this.jyu, R.drawable.bg_frs_hot_live_tip_selector);
        ao.setViewTextColor(this.jsV, R.color.CAM_X0101);
        ao.setImageResource(this.jge, R.drawable.icon_home_card_close_white);
        this.jsV.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, ao.getDrawable(R.drawable.icon_arrow_more_white), (Drawable) null);
    }

    private void initView(Context context) {
        if (context != null && this.jyu == null) {
            this.jyu = (FrameLayout) LayoutInflater.from(context).inflate(R.layout.frs_hot_live_tip, (ViewGroup) null);
            this.jyu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.3
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.cHX();
                }
            });
            this.jsV = (TextView) this.jyu.findViewById(R.id.frs_hot_live_tip_content);
            this.jge = (ImageView) this.jyu.findViewById(R.id.frs_hot_live_tip_close);
            this.jge.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.frs.live.a.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    a.this.rr();
                }
            });
            onChangeSkinType();
        }
    }

    private void cnT() {
        q cBi;
        FrameLayout frameLayout;
        if (this.jcX != null && (cBi = this.jcX.cBi()) != null && cBi.getListView() != null && (frameLayout = (FrameLayout) cBi.cCJ()) != null) {
            FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, l.getDimens(TbadkCoreApplication.getInst(), R.dimen.ds56));
            if (this.jyv == null) {
                this.jyv = new bb();
            }
            if (this.jyx == 2) {
                this.jyv.a(this.jyu, frameLayout, layoutParams, 5000);
            } else if (this.jyx == 1) {
                this.jyv.a(this.jyu, frameLayout, layoutParams);
                TiebaStatic.log(new aq("c12539"));
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cHX() {
        cIa();
        if (this.jyz != null && this.jcX != null && this.jcX.isAdded()) {
            boolean equals = TextUtils.equals(getUserId(), String.valueOf(this.jyz.userID));
            String str = "";
            if (this.jyx == 1) {
                str = "frs_followed_live_tip";
                TiebaStatic.log(new aq("c12540"));
                if (this.jyv != null) {
                    this.jyv.hideTip();
                }
            } else if (this.jyx == 2) {
                str = "frs_hot_live_tip";
                TiebaStatic.log(new aq("c12331"));
            }
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.jcX.getPageContext().getPageActivity(), this.jyz, this.jyA, str, getUserId(), equals, null, null)));
            if (this.jcX.cBN().getForum().isGameForumType()) {
                CustomMessage customMessage = new CustomMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customMessage.setTag(this.jcX.getBaseFragmentActivity().getUniqueId());
                CustomResponsedMessage customResponsedMessage = new CustomResponsedMessage(CmdConfigCustom.CMD_GAME_FRS_JUMP_TO_LIVE_TAB);
                customResponsedMessage.setOrginalMessage(customMessage);
                MessageManager.getInstance().dispatchResponsedMessage(customResponsedMessage);
                return;
            }
            e.mB().post(new Runnable() { // from class: com.baidu.tieba.frs.live.a.5
                @Override // java.lang.Runnable
                public void run() {
                    a.this.cHW();
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rr() {
        if (this.jyx == 2) {
            cHY();
        }
        if (this.jyv != null) {
            this.jyv.hideTip();
        }
    }

    private void cHY() {
        this.jyw++;
        com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jyw);
    }

    private int cHZ() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), 0);
    }

    private void cIa() {
        this.jyw = 0;
        com.baidu.tbadk.core.sharedPref.b.brx().putInt(SharedPrefConfig.FRS_HOT_LIVE_TIP_CLOSE_NUM + getUserId(), this.jyw);
    }

    private void saveLastShowTime() {
        com.baidu.tbadk.core.sharedPref.b.brx().putLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), System.currentTimeMillis());
    }

    private long getLastShowTime() {
        return com.baidu.tbadk.core.sharedPref.b.brx().getLong(SharedPrefConfig.FRS_HOT_LIVE_TIP_LAST_SHOWTIME + getUserId(), 0L);
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
        if (this.jyv != null) {
            this.jyv.cDE();
        }
        e.mB().removeCallbacks(this.jyD);
        if (this.jyB != null) {
            this.jyB.onDestory();
        }
    }
}
