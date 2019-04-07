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
import com.baidu.tieba.d;
import tbclient.UserBfbInfo;
/* loaded from: classes6.dex */
public class a {
    private UserBfbInfo bfbInfo;
    private View bub;
    private View eDL;
    private NoNetworkView eUC;
    private CreateBarGuideActivity fFi;
    private NoDataView fFj;
    private TextView fFk;
    private TextView fFl;
    private LinearLayout fFm;
    private TbImageView fFn;
    private TextView ffG;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.fFi = createBarGuideActivity;
        this.bub = LayoutInflater.from(this.fFi.getPageContext().getPageActivity()).inflate(d.h.create_bar_guide_activity, (ViewGroup) null);
        this.fFi.setContentView(this.bub);
        this.eDL = this.bub.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.bub.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.create_bar);
        this.eUC = (NoNetworkView) this.bub.findViewById(d.g.view_no_network);
        this.ffG = (TextView) this.bub.findViewById(d.g.text_forum_name);
        this.fFk = (TextView) this.bub.findViewById(d.g.text_forum_create);
        this.fFn = (TbImageView) this.bub.findViewById(d.g.status_icon);
        this.fFk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.fFi.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fFi.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fFi.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.fFi.finish();
            }
        });
        this.fFl = (TextView) this.bub.findViewById(d.g.text_create_need);
        this.fFm = (LinearLayout) this.bub.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.fFi.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fFi.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void blj() {
        this.eDL.setVisibility(8);
    }

    public void blk() {
        this.eDL.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.fFj == null) {
            int h = l.h(this.fFi.getActivity(), d.e.ds100);
            this.fFj = NoDataViewFactory.a(this.fFi.getPageContext().getPageActivity(), (LinearLayout) this.bub.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, h), null, null);
            this.fFj.setVisibility(0);
            ajX();
        }
        this.ffG.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.fFn.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.fFn.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.fFl.setVisibility(4);
            this.fFm.setVisibility(4);
        }
        this.fFl.setVisibility(8);
        this.fFm.setVisibility(8);
    }

    public void ajX() {
        com.baidu.tbadk.r.a.a(this.fFi.getPageContext(), this.bub);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fFi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eUC != null) {
            this.eUC.onChangeSkinType(this.fFi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fFj != null) {
            this.fFj.onChangeSkinType(this.fFi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.bub;
    }
}
