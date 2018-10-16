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
    private View aix;
    private UserBfbInfo bfbInfo;
    private TextView dGH;
    private View dhL;
    private NoNetworkView dwo;
    private CreateBarGuideActivity ehk;
    private NoDataView ehl;
    private TextView ehm;
    private TextView ehn;
    private LinearLayout eho;
    private TbImageView ehp;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.ehk = createBarGuideActivity;
        this.aix = LayoutInflater.from(this.ehk.getPageContext().getPageActivity()).inflate(e.h.create_bar_guide_activity, (ViewGroup) null);
        this.ehk.setContentView(this.aix);
        this.dhL = this.aix.findViewById(e.g.body_view);
        this.mNavigationBar = (NavigationBar) this.aix.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dwo = (NoNetworkView) this.aix.findViewById(e.g.view_no_network);
        this.dGH = (TextView) this.aix.findViewById(e.g.text_forum_name);
        this.ehm = (TextView) this.aix.findViewById(e.g.text_forum_create);
        this.ehp = (TbImageView) this.aix.findViewById(e.g.status_icon);
        this.ehm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.ehk.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.ehk.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.ehk.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.ehk.finish();
            }
        });
        this.ehn = (TextView) this.aix.findViewById(e.g.text_create_need);
        this.eho = (LinearLayout) this.aix.findViewById(e.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.ehk.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.ehk.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aID() {
        this.dhL.setVisibility(8);
    }

    public void aIE() {
        this.dhL.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.ehl == null) {
            int h = l.h(this.ehk.getActivity(), e.C0175e.ds100);
            this.ehl = NoDataViewFactory.a(this.ehk.getPageContext().getPageActivity(), (LinearLayout) this.aix.findViewById(e.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, h), null, null);
            this.ehl.setVisibility(0);
            IX();
        }
        this.dGH.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.ehp.setImageResource(e.f.icon_create_attention_n);
            } else {
                this.ehp.setImageResource(e.f.icon_create_complete_n);
            }
        } else {
            this.ehn.setVisibility(4);
            this.eho.setVisibility(4);
        }
        this.ehn.setVisibility(8);
        this.eho.setVisibility(8);
    }

    public void IX() {
        com.baidu.tbadk.o.a.a(this.ehk.getPageContext(), this.aix);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.ehk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dwo != null) {
            this.dwo.onChangeSkinType(this.ehk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.ehl != null) {
            this.ehl.onChangeSkinType(this.ehk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.aix;
    }
}
