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
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.core.view.h;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.d;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class a {
    private View aHS;
    private UserBfbInfo bfbInfo;
    private NoNetworkView dAL;
    private View dqh;
    private CreateBarGuideActivity eeR;
    private h eeS;
    private TextView eeT;
    private TextView eeU;
    private TextView eeV;
    private LinearLayout eeW;
    private TbImageView eeX;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.eeR = createBarGuideActivity;
        this.aHS = LayoutInflater.from(this.eeR.getPageContext().getPageActivity()).inflate(d.h.create_bar_guide_activity, (ViewGroup) null);
        this.eeR.setContentView(this.aHS);
        this.dqh = this.aHS.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.aHS.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.create_bar);
        this.dAL = (NoNetworkView) this.aHS.findViewById(d.g.view_no_network);
        this.eeU = (TextView) this.aHS.findViewById(d.g.text_forum_name);
        this.eeT = (TextView) this.aHS.findViewById(d.g.text_forum_create);
        this.eeX = (TbImageView) this.aHS.findViewById(d.g.status_icon);
        this.eeT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.eeR.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.eeR.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.eeR.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.eeR.finish();
            }
        });
        this.eeV = (TextView) this.aHS.findViewById(d.g.text_create_need);
        this.eeW = (LinearLayout) this.aHS.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.eeR.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.eeR.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aBY() {
        this.dqh.setVisibility(8);
    }

    public void aBZ() {
        this.dqh.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.eeS == null) {
            int t = l.t(this.eeR.getActivity(), d.e.ds100);
            this.eeS = NoDataViewFactory.a(this.eeR.getPageContext().getPageActivity(), (LinearLayout) this.aHS.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, t), null, null);
            this.eeS.setVisibility(0);
            Ja();
        }
        this.eeU.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.eeX.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.eeX.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.eeV.setVisibility(4);
            this.eeW.setVisibility(4);
        }
        this.eeV.setVisibility(8);
        this.eeW.setVisibility(8);
    }

    public void Ja() {
        com.baidu.tbadk.n.a.a(this.eeR.getPageContext(), this.aHS);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eeR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dAL != null) {
            this.dAL.onChangeSkinType(this.eeR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eeS != null) {
            this.eeS.onChangeSkinType(this.eeR.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.aHS;
    }
}
