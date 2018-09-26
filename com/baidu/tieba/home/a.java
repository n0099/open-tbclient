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
    private View adA;
    private UserBfbInfo bfbInfo;
    private View cZw;
    private CreateBarGuideActivity dZr;
    private NoDataView dZs;
    private TextView dZt;
    private TextView dZu;
    private LinearLayout dZv;
    private TbImageView dZw;
    private NoNetworkView dom;
    private TextView dyH;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.dZr = createBarGuideActivity;
        this.adA = LayoutInflater.from(this.dZr.getPageContext().getPageActivity()).inflate(e.h.create_bar_guide_activity, (ViewGroup) null);
        this.dZr.setContentView(this.adA);
        this.cZw = this.adA.findViewById(e.g.body_view);
        this.mNavigationBar = (NavigationBar) this.adA.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dom = (NoNetworkView) this.adA.findViewById(e.g.view_no_network);
        this.dyH = (TextView) this.adA.findViewById(e.g.text_forum_name);
        this.dZt = (TextView) this.adA.findViewById(e.g.text_forum_create);
        this.dZw = (TbImageView) this.adA.findViewById(e.g.status_icon);
        this.dZt.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dZr.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dZr.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dZr.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.dZr.finish();
            }
        });
        this.dZu = (TextView) this.adA.findViewById(e.g.text_create_need);
        this.dZv = (LinearLayout) this.adA.findViewById(e.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dZr.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dZr.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aFl() {
        this.cZw.setVisibility(8);
    }

    public void aFm() {
        this.cZw.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.dZs == null) {
            int h = l.h(this.dZr.getActivity(), e.C0141e.ds100);
            this.dZs = NoDataViewFactory.a(this.dZr.getPageContext().getPageActivity(), (LinearLayout) this.adA.findViewById(e.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, h), null, null);
            this.dZs.setVisibility(0);
            GW();
        }
        this.dyH.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.dZw.setImageResource(e.f.icon_create_attention_n);
            } else {
                this.dZw.setImageResource(e.f.icon_create_complete_n);
            }
        } else {
            this.dZu.setVisibility(4);
            this.dZv.setVisibility(4);
        }
        this.dZu.setVisibility(8);
        this.dZv.setVisibility(8);
    }

    public void GW() {
        com.baidu.tbadk.o.a.a(this.dZr.getPageContext(), this.adA);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dZr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dom != null) {
            this.dom.onChangeSkinType(this.dZr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dZs != null) {
            this.dZs.onChangeSkinType(this.dZr.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.adA;
    }
}
