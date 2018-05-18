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
    private View Th;
    private UserBfbInfo bfbInfo;
    private View cJS;
    private NoNetworkView cUE;
    private CreateBarGuideActivity dAR;
    private NoDataView dAS;
    private TextView dAT;
    private TextView dAU;
    private TextView dAV;
    private LinearLayout dAW;
    private TbImageView dAX;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.dAR = createBarGuideActivity;
        this.Th = LayoutInflater.from(this.dAR.getPageContext().getPageActivity()).inflate(d.i.create_bar_guide_activity, (ViewGroup) null);
        this.dAR.setContentView(this.Th);
        this.cJS = this.Th.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.Th.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.create_bar);
        this.cUE = (NoNetworkView) this.Th.findViewById(d.g.view_no_network);
        this.dAU = (TextView) this.Th.findViewById(d.g.text_forum_name);
        this.dAT = (TextView) this.Th.findViewById(d.g.text_forum_create);
        this.dAX = (TbImageView) this.Th.findViewById(d.g.status_icon);
        this.dAT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dAR.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dAR.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dAR.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.dAR.finish();
            }
        });
        this.dAV = (TextView) this.Th.findViewById(d.g.text_create_need);
        this.dAW = (LinearLayout) this.Th.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dAR.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dAR.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void awU() {
        this.cJS.setVisibility(8);
    }

    public void awV() {
        this.cJS.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.dAS == null) {
            int e = l.e(this.dAR.getActivity(), d.e.ds100);
            this.dAS = NoDataViewFactory.a(this.dAR.getPageContext().getPageActivity(), (LinearLayout) this.Th.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, e), null, null);
            this.dAS.setVisibility(0);
            BP();
        }
        this.dAU.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.dAX.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.dAX.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.dAV.setVisibility(4);
            this.dAW.setVisibility(4);
        }
        this.dAV.setVisibility(8);
        this.dAW.setVisibility(8);
    }

    public void BP() {
        com.baidu.tbadk.n.a.a(this.dAR.getPageContext(), this.Th);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dAR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cUE != null) {
            this.cUE.onChangeSkinType(this.dAR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dAS != null) {
            this.dAS.onChangeSkinType(this.dAR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.Th;
    }
}
