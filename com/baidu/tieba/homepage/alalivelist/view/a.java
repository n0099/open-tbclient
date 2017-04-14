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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.w;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private HeadImageView bmu;
    private HeadImageView bmv;
    private HeadImageView bmw;
    private ImageView bmx;
    private View cpU;
    View.OnClickListener ctA;
    private ArrayList<String> ctw;
    private com.baidu.tieba.homepage.alalivelist.a.c ctx;
    private InterfaceC0059a cty;
    private LinearLayout ctz;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0059a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.c cVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ctA = new b(this);
        this.mContext = context;
        bc(context);
    }

    private void bc(Context context) {
        inflate(context, w.j.ala_attention_live_list_layout, this);
        this.mTitle = (TextView) findViewById(w.h.ala_attention_tip_title_txt);
        this.bmx = (ImageView) findViewById(w.h.ala_attention_tip_arrow_img);
        this.bmu = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img1);
        this.bmv = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img2);
        this.bmw = (HeadImageView) findViewById(w.h.ala_attention_tip_contribution_img3);
        this.ctz = (LinearLayout) findViewById(w.h.ala_attention_tip_linear);
        this.cpU = findViewById(w.h.ala_attention_tip_bottom);
        setOnClickListener(new c(this));
        this.bmu.setOnClickListener(this.ctA);
        this.bmv.setOnClickListener(this.ctA);
        this.bmw.setOnClickListener(this.ctA);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                jB(forcusUsers.user_name);
            } else if (i == 50) {
                jC(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void jB(String str) {
        TiebaStatic.log(new as("c11829").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void jC(String str) {
        TiebaStatic.log(new as("c11830").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ais() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bmx != null) {
            this.bmx.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bmu.setVisibility(0);
                this.bmu.setIsRound(true);
                this.bmu.c(arrayList.get(0), 12, false);
            } else {
                this.bmu.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bmv.setVisibility(0);
                this.bmv.setIsRound(true);
                this.bmv.c(arrayList.get(1), 12, false);
            } else {
                this.bmv.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bmw.setVisibility(0);
                this.bmw.setIsRound(true);
                this.bmw.c(arrayList.get(2), 12, false);
                return;
            }
            this.bmw.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.c cVar) {
        this.ctx = cVar;
        int i = cVar.ctk;
        List<ForcusUsers> list = cVar.ctl;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(w.l.ala_attention_tip_record));
        }
        if (this.ctw == null) {
            this.ctw = new ArrayList<>();
        }
        this.ctw.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.ctw.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.ctw);
                return;
            }
        }
    }

    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aq.k(this.ctz, w.e.cp_bg_line_d);
            aq.i(this.mTitle, w.e.cp_cont_b);
            aq.k(this.cpU, w.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0059a interfaceC0059a) {
        this.cty = interfaceC0059a;
    }
}
