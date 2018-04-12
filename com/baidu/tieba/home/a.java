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
/* loaded from: classes3.dex */
public class a {
    private View Tl;
    private UserBfbInfo bfbInfo;
    private View cIM;
    private NoNetworkView cTA;
    private CreateBarGuideActivity dzN;
    private NoDataView dzO;
    private TextView dzP;
    private TextView dzQ;
    private TextView dzR;
    private LinearLayout dzS;
    private TbImageView dzT;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.dzN = createBarGuideActivity;
        this.Tl = LayoutInflater.from(this.dzN.getPageContext().getPageActivity()).inflate(d.i.create_bar_guide_activity, (ViewGroup) null);
        this.dzN.setContentView(this.Tl);
        this.cIM = this.Tl.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.create_bar);
        this.cTA = (NoNetworkView) this.Tl.findViewById(d.g.view_no_network);
        this.dzQ = (TextView) this.Tl.findViewById(d.g.text_forum_name);
        this.dzP = (TextView) this.Tl.findViewById(d.g.text_forum_create);
        this.dzT = (TbImageView) this.Tl.findViewById(d.g.status_icon);
        this.dzP.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dzN.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dzN.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dzN.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.dzN.finish();
            }
        });
        this.dzR = (TextView) this.Tl.findViewById(d.g.text_create_need);
        this.dzS = (LinearLayout) this.Tl.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dzN.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dzN.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void awV() {
        this.cIM.setVisibility(8);
    }

    public void awW() {
        this.cIM.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.dzO == null) {
            int e = l.e(this.dzN.getActivity(), d.e.ds100);
            this.dzO = NoDataViewFactory.a(this.dzN.getPageContext().getPageActivity(), (LinearLayout) this.Tl.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, e), null, null);
            this.dzO.setVisibility(0);
            BR();
        }
        this.dzQ.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.dzT.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.dzT.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.dzR.setVisibility(4);
            this.dzS.setVisibility(4);
        }
        this.dzR.setVisibility(8);
        this.dzS.setVisibility(8);
    }

    public void BR() {
        com.baidu.tbadk.n.a.a(this.dzN.getPageContext(), this.Tl);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dzN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cTA != null) {
            this.cTA.onChangeSkinType(this.dzN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dzO != null) {
            this.dzO.onChangeSkinType(this.dzN.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.Tl;
    }
}
