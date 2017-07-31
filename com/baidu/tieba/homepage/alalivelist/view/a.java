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
    private HeadImageView bzv;
    private HeadImageView bzw;
    private HeadImageView bzx;
    private ImageView bzy;
    private View cMa;
    private ArrayList<String> cPt;
    private com.baidu.tieba.homepage.alalivelist.a.b cPu;
    private InterfaceC0087a cPv;
    private LinearLayout cPw;
    View.OnClickListener cPx;
    private Context mContext;
    private int mSkinType;
    private TextView mTitle;

    /* renamed from: com.baidu.tieba.homepage.alalivelist.view.a$a  reason: collision with other inner class name */
    /* loaded from: classes.dex */
    public interface InterfaceC0087a {
        void a(View view, com.baidu.tieba.homepage.alalivelist.a.b bVar);
    }

    public a(Context context) {
        super(context);
        this.mSkinType = 3;
        this.cPx = new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.cPu != null) {
                    TiebaStatic.log(new aj("c11831").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
                    if (view == a.this.bzv) {
                        a.this.a(a.this.cPu.cPk, a.this.cPu.cPl.get(0));
                    } else if (view == a.this.bzw) {
                        a.this.a(a.this.cPu.cPk, a.this.cPu.cPl.get(1));
                    } else if (view == a.this.bzx) {
                        a.this.a(a.this.cPu.cPk, a.this.cPu.cPl.get(2));
                    }
                    if (a.this.cPv != null) {
                        a.this.cPv.a(view, a.this.cPu);
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
        this.bzy = (ImageView) findViewById(d.h.ala_attention_tip_arrow_img);
        this.bzv = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img1);
        this.bzw = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img2);
        this.bzx = (HeadImageView) findViewById(d.h.ala_attention_tip_contribution_img3);
        this.cPw = (LinearLayout) findViewById(d.h.ala_attention_tip_linear);
        this.cMa = findViewById(d.h.ala_attention_tip_bottom);
        setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.alalivelist.view.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                a.this.anM();
            }
        });
        this.bzv.setOnClickListener(this.cPx);
        this.bzw.setOnClickListener(this.cPx);
        this.bzx.setOnClickListener(this.cPx);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(int i, ForcusUsers forcusUsers) {
        if (forcusUsers != null) {
            if (i == 49) {
                li(forcusUsers.user_name);
            } else if (i == 50) {
                lj(String.valueOf(forcusUsers.thread_id));
            }
        }
    }

    private void li(String str) {
        if (!i.hr()) {
            k.showToast(this.mContext, d.l.no_network_guide);
            return;
        }
        TiebaStatic.log(new aj("c11829").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new AlaLiveRoomActivityConfig(this.mContext, "", str, AlaLiveRoomActivityConfig.FROM_TYPE_HOME_LIVE_PLAY)));
    }

    private void lj(String str) {
        TiebaStatic.log(new aj("c11830").aa(SapiAccountManager.SESSION_UID, TbadkCoreApplication.getCurrentAccount()));
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_PB_ACTIVITY, new PbActivityConfig(this.mContext).createNormalCfg(str, "", "ala_attention")));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void anM() {
        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_ALA_ATTENTION_LIVE_LIST_START, new AlaAttentionLiveListActivityConfig(getContext())));
    }

    private void setTitle(String str) {
        if (this.mTitle != null) {
            this.mTitle.setText(str);
        }
    }

    public void setNextIconVisibility(int i) {
        if (this.bzy != null) {
            this.bzy.setVisibility(i);
        }
    }

    private void setHeaderImages(ArrayList<String> arrayList) {
        if (arrayList != null && arrayList.size() != 0) {
            if (arrayList.size() >= 1) {
                this.bzv.setVisibility(0);
                this.bzv.setIsRound(true);
                this.bzv.c(arrayList.get(0), 12, false);
            } else {
                this.bzv.setVisibility(8);
            }
            if (arrayList.size() >= 2) {
                this.bzw.setVisibility(0);
                this.bzw.setIsRound(true);
                this.bzw.c(arrayList.get(1), 12, false);
            } else {
                this.bzw.setVisibility(8);
            }
            if (arrayList.size() >= 3) {
                this.bzx.setVisibility(0);
                this.bzx.setIsRound(true);
                this.bzx.c(arrayList.get(2), 12, false);
                return;
            }
            this.bzx.setVisibility(8);
        }
    }

    public void a(com.baidu.tieba.homepage.alalivelist.a.b bVar) {
        this.cPu = bVar;
        int i = bVar.cPk;
        List<ForcusUsers> list = bVar.cPl;
        if (i == 49) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_live));
        } else if (i == 50) {
            setTitle(this.mContext.getResources().getString(d.l.ala_attention_tip_record));
        }
        if (this.cPt == null) {
            this.cPt = new ArrayList<>();
        }
        this.cPt.clear();
        int i2 = 0;
        while (true) {
            int i3 = i2;
            if (i3 < list.size()) {
                this.cPt.add(list.get(i3).portrait);
                i2 = i3 + 1;
            } else {
                setHeaderImages(this.cPt);
                return;
            }
        }
    }

    public void d(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            ai.k(this.cPw, d.e.cp_bg_line_d);
            ai.i(this.mTitle, d.e.cp_cont_b);
            ai.k(this.cMa, d.e.cp_bg_line_c);
        }
        this.mSkinType = i;
    }

    public void setAfterHeadImgOnClickListener(InterfaceC0087a interfaceC0087a) {
        this.cPv = interfaceC0087a;
    }
}
