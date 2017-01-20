package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaAttentionLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.r;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private TextView aNb;
    private HeadImageView bfP;
    private HeadImageView bfQ;
    private HeadImageView bfR;
    private ImageView bfS;
    private View cpW;
    private LinearLayout ctA;
    View.OnClickListener ctB;
    private ArrayList<String> ctx;
    private com.baidu.tieba.homepage.alalivelist.a.c cty;
    private InterfaceC0061a ctz;
    private Context mContext;
    private int mSkinType;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0061a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.c cVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ctB = new b(this);
        this.mContext = context;
        aJ(context);
    }

    private void aJ(Context context) {
        inflate(context, r.j.ala_attention_live_list_layout, this);
        this.aNb = (TextView) findViewById(r.h.ala_attention_tip_title_txt);
        this.bfS = (ImageView) findViewById(r.h.ala_attention_tip_arrow_img);
        this.bfP = (HeadImageView) findViewById(r.h.ala_attention_tip_contribution_img1);
        this.bfQ = (HeadImageView) findViewById(r.h.ala_attention_tip_contribution_img2);
        this.bfR = (HeadImageView) findViewById(r.h.ala_attention_tip_contribution_img3);
        this.ctA = (LinearLayout) findViewById(r.h.ala_attention_tip_linear);
        this.cpW = findViewById(r.h.ala_attention_tip_bottom);
        setOnClickListener(new c(this));
        this.bfP.setOnClickListener(this.ctB);
        this.bfQ.setOnClickListener(this.ctB);
        this.bfR.setOnClickListener(this.ctB);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                jV(forcusUsers.user_name);
            } else if (i == 50) {
                jW(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void jV(String str) {
        TiebaStatic.log(new ar("c11829").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void jW(String str) {
        TiebaStatic.log(new ar("c11830").ab(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ajl() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.aNb != null) {
            this.aNb.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bfS != null) {
            this.bfS.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bfP.setVisibility(0);
                this.bfP.setIsRound(true);
                this.bfP.c(arrayList.get(0), 12, false);
            } else {
                this.bfP.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bfQ.setVisibility(0);
                this.bfQ.setIsRound(true);
                this.bfQ.c(arrayList.get(1), 12, false);
            } else {
                this.bfQ.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bfR.setVisibility(0);
                this.bfR.setIsRound(true);
                this.bfR.c(arrayList.get(2), 12, false);
                return;
            }
            this.bfR.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.c cVar) {
        this.cty = cVar;
        int i = cVar.ctl;
        List<ForcusUsers> list = cVar.ctm;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(r.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(r.l.ala_attention_tip_record));
        }
        if (this.ctx == null) {
            this.ctx = new ArrayList<>();
        }
        this.ctx.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.ctx.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.ctx);
                return;
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ap.k(this.ctA, r.e.cp_bg_line_d);
            ap.i((View) this.aNb, r.e.cp_cont_b);
            ap.k(this.cpW, r.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0061a interfaceC0061a) {
        this.ctz = interfaceC0061a;
    }
}
