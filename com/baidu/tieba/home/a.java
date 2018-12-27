package com.baidu.tieba.home;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.listener.CustomMessageListener;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.CreateForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.e;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class a {
    private View amM;
    private UserBfbInfo bfbInfo;
    private NoNetworkView dGT;
    private TextView dRj;
    private View dsj;
    private CreateBarGuideActivity esq;
    private NoDataView esr;
    private TextView ess;
    private TextView est;
    private LinearLayout esu;
    private TbImageView esv;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.esq = createBarGuideActivity;
        this.amM = LayoutInflater.from(this.esq.getPageContext().getPageActivity()).inflate(e.h.create_bar_guide_activity, (ViewGroup) null);
        this.esq.setContentView(this.amM);
        this.dsj = this.amM.findViewById(e.g.body_view);
        this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dGT = (NoNetworkView) this.amM.findViewById(e.g.view_no_network);
        this.dRj = (TextView) this.amM.findViewById(e.g.text_forum_name);
        this.ess = (TextView) this.amM.findViewById(e.g.text_forum_create);
        this.esv = (TbImageView) this.amM.findViewById(e.g.status_icon);
        this.ess.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.esq.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.esq.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.esq.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.esq.finish();
            }
        });
        this.est = (TextView) this.amM.findViewById(e.g.text_create_need);
        this.esu = (LinearLayout) this.amM.findViewById(e.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.esq.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.esq.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aKH() {
        this.dsj.setVisibility(8);
    }

    public void aKI() {
        this.dsj.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.esr == null) {
            int h = l.h(this.esq.getActivity(), e.C0210e.ds100);
            this.esr = NoDataViewFactory.a(this.esq.getPageContext().getPageActivity(), (LinearLayout) this.amM.findViewById(e.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, h), null, null);
            this.esr.setVisibility(0);
            Ko();
        }
        this.dRj.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.esv.setImageResource(e.f.icon_create_attention_n);
            } else {
                this.esv.setImageResource(e.f.icon_create_complete_n);
            }
        } else {
            this.est.setVisibility(4);
            this.esu.setVisibility(4);
        }
        this.est.setVisibility(8);
        this.esu.setVisibility(8);
    }

    public void Ko() {
        com.baidu.tbadk.o.a.a(this.esq.getPageContext(), this.amM);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.esq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dGT != null) {
            this.dGT.onChangeSkinType(this.esq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.esr != null) {
            this.esr.onChangeSkinType(this.esq.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.amM;
    }
}
