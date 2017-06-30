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
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private HeadImageView bub;
    private HeadImageView buc;
    private HeadImageView bud;
    private ImageView bue;
    private View cDv;
    private ArrayList<String> cGO;
    private com.baidu.tieba.homepage.alalivelist.a.c cGP;
    private InterfaceC0065a cGQ;
    private LinearLayout cGR;
    View.OnClickListener cGS;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0065a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.c cVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cGS = new b(this);
        this.mContext = context;
        bg(context);
    }

    private void bg(Context context) {
        inflate(context, w.j.ala_attention_live_list_layout, this);
        this.mTitle = (TextView) findViewById(w.h.ala_attention_tip_title_txt);
        this.bue = (ImageView) findViewById(w.h.ala_attention_tip_arrow_img);
        this.bub = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img1);
        this.buc = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img2);
        this.bud = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img3);
        this.cGR = (LinearLayout) findViewById(w.h.ala_attention_tip_linear);
        this.cDv = findViewById(w.h.ala_attention_tip_bottom);
        setOnClickListener(new c(this));
        this.bub.setOnClickListener(this.cGS);
        this.buc.setOnClickListener(this.cGS);
        this.bud.setOnClickListener(this.cGS);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                kR(forcusUsers.user_name);
            } else if (i == 50) {
                kS(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void kR(String str) {
        if (!com.baidu.adp.lib.util.i.hj()) {
            com.baidu.adp.lib.util.k.showToast(this.mContext, w.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new au("c11829").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void kS(String str) {
        TiebaStatic.log(new au("c11830").Z(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ama() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bue != null) {
            this.bue.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bub.setVisibility(0);
                this.bub.setIsRound(true);
                this.bub.c(arrayList.get(0), 12, false);
            } else {
                this.bub.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.buc.setVisibility(0);
                this.buc.setIsRound(true);
                this.buc.c(arrayList.get(1), 12, false);
            } else {
                this.buc.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bud.setVisibility(0);
                this.bud.setIsRound(true);
                this.bud.c(arrayList.get(2), 12, false);
                return;
            }
            this.bud.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.c cVar) {
        this.cGP = cVar;
        int i = cVar.cGF;
        List<ForcusUsers> list = cVar.cGG;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_record));
        }
        if (this.cGO == null) {
            this.cGO = new ArrayList<>();
        }
        this.cGO.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cGO.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cGO);
                return;
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            as.k(this.cGR, w.e.cp_bg_line_d);
            as.i(this.mTitle, w.e.cp_cont_b);
            as.k(this.cDv, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0065a interfaceC0065a) {
        this.cGQ = interfaceC0065a;
    }
}
