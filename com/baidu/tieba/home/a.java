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
import com.baidu.tieba.f;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class a {
    private View aaW;
    private UserBfbInfo bfbInfo;
    private View cTF;
    private CreateBarGuideActivity dSa;
    private NoDataView dSb;
    private TextView dSc;
    private TextView dSd;
    private LinearLayout dSe;
    private TbImageView dSf;
    private NoNetworkView dit;
    private TextView dsr;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.dSa = createBarGuideActivity;
        this.aaW = LayoutInflater.from(this.dSa.getPageContext().getPageActivity()).inflate(f.h.create_bar_guide_activity, (ViewGroup) null);
        this.dSa.setContentView(this.aaW);
        this.cTF = this.aaW.findViewById(f.g.body_view);
        this.mNavigationBar = (NavigationBar) this.aaW.findViewById(f.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(f.j.create_bar);
        this.dit = (NoNetworkView) this.aaW.findViewById(f.g.view_no_network);
        this.dsr = (TextView) this.aaW.findViewById(f.g.text_forum_name);
        this.dSc = (TextView) this.aaW.findViewById(f.g.text_forum_create);
        this.dSf = (TbImageView) this.aaW.findViewById(f.g.status_icon);
        this.dSc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dSa.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dSa.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dSa.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.dSa.finish();
            }
        });
        this.dSd = (TextView) this.aaW.findViewById(f.g.text_create_need);
        this.dSe = (LinearLayout) this.aaW.findViewById(f.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dSa.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dSa.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aCY() {
        this.cTF.setVisibility(8);
    }

    public void aCZ() {
        this.cTF.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.dSb == null) {
            int f = l.f(this.dSa.getActivity(), f.e.ds100);
            this.dSb = NoDataViewFactory.a(this.dSa.getPageContext().getPageActivity(), (LinearLayout) this.aaW.findViewById(f.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, f), null, null);
            this.dSb.setVisibility(0);
            FG();
        }
        this.dsr.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.dSf.setImageResource(f.C0146f.icon_create_attention_n);
            } else {
                this.dSf.setImageResource(f.C0146f.icon_create_complete_n);
            }
        } else {
            this.dSd.setVisibility(4);
            this.dSe.setVisibility(4);
        }
        this.dSd.setVisibility(8);
        this.dSe.setVisibility(8);
    }

    public void FG() {
        com.baidu.tbadk.o.a.a(this.dSa.getPageContext(), this.aaW);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dSa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dit != null) {
            this.dit.onChangeSkinType(this.dSa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dSb != null) {
            this.dSb.onChangeSkinType(this.dSa.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.aaW;
    }
}
