package com.baidu.tieba.homepage.alalivelist.view;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.i;
import com.baidu.adp.lib.util.k;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.AlaAttentionLiveListActivityConfig;
import com.baidu.tbadk.core.atomData.AlaLiveRoomActivityConfig;
import com.baidu.tbadk.core.atomData.PbActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ai;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tieba.d;
import java.util.ArrayList;
import java.util.List;
import tbclient.ForcusUsers;
/* loaded from: classes.dex */
public class a extends LinearLayout {
    private HeadImageView bAe;
    private HeadImageView bAf;
    private HeadImageView bAg;
    private ImageView bAh;
    private View cNX;
    private ArrayList<String> cRq;
    private com.baidu.tieba.homepage.alalivelist.a.b cRr;
    private InterfaceC0088a cRs;
    private LinearLayout cRt;
    View.OnClickListener cRu;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0088a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.b bVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cRu = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cRr != null) {
                    TiebaStatic.log(new aj("c11831").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    if (view == a.this.bAe) {
                        a.this.a(a.this.cRr.cRh, a.this.cRr.cRi.get(0));
                    } else if (view == a.this.bAf) {
                        a.this.a(a.this.cRr.cRh, a.this.cRr.cRi.get(1));
                    } else if (view == a.this.bAg) {
                        a.this.a(a.this.cRr.cRh, a.this.cRr.cRi.get(2));
                    }
                    if (a.this.cRs != null) {
                        a.this.cRs.a(view, a.this.cRr);
                    }
                }
            }
        };
        this.mContext = context;
        bg(context);
    }

    private void bg(Context context) {
        inflate(context, d.j.ala_attention_live_list_layout, this);
        this.mTitle = (TextView) findViewById(d.h.ala_attention_tip_title_txt);
        this.bAh = (ImageView) findViewById(d.h.ala_attention_tip_arrow_img);
        this.bAe = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img1);
        this.bAf = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img2);
        this.bAg = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img3);
        this.cRt = (LinearLayout) findViewById(d.h.ala_attention_tip_linear);
        this.cNX = findViewById(d.h.ala_attention_tip_bottom);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.aos();
            }
        });
        this.bAe.setOnClickListener(this.cRu);
        this.bAf.setOnClickListener(this.cRu);
        this.bAg.setOnClickListener(this.cRu);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                lm(forcusUsers.user_name);
            } else if (i == 50) {
                ln(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void lm(String str) {
        if (!i.hr()) {
            k.showToast(this.mContext, d.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new aj("c11829").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void ln(String str) {
        TiebaStatic.log(new aj("c11830").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aos() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bAh != null) {
            this.bAh.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bAe.setVisibility(0);
                this.bAe.setIsRound(true);
                this.bAe.c(arrayList.get(0), 12, false);
            } else {
                this.bAe.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bAf.setVisibility(0);
                this.bAf.setIsRound(true);
                this.bAf.c(arrayList.get(1), 12, false);
            } else {
                this.bAf.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bAg.setVisibility(0);
                this.bAg.setIsRound(true);
                this.bAg.c(arrayList.get(2), 12, false);
                return;
            }
            this.bAg.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.b bVar) {
        this.cRr = bVar;
        int i = bVar.cRh;
        List<ForcusUsers> list = bVar.cRi;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_record));
        }
        if (this.cRq == null) {
            this.cRq = new ArrayList<>();
        }
        this.cRq.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cRq.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cRq);
                return;
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.k(this.cRt, d.e.cp_bg_line_d);
            ai.i(this.mTitle, d.e.cp_cont_b);
            ai.k(this.cNX, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0088a interfaceC0088a) {
        this.cRs = interfaceC0088a;
    }
}
