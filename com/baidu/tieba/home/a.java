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
    private View aId;
    private UserBfbInfo bfbInfo;
    private NoNetworkView dAX;
    private View dqt;
    private CreateBarGuideActivity efd;
    private h efe;
    private TextView eff;
    private TextView efg;
    private TextView efh;
    private LinearLayout efi;
    private TbImageView efj;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.efd = createBarGuideActivity;
        this.aId = LayoutInflater.from(this.efd.getPageContext().getPageActivity()).inflate(d.h.create_bar_guide_activity, (ViewGroup) null);
        this.efd.setContentView(this.aId);
        this.dqt = this.aId.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.aId.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.create_bar);
        this.dAX = (NoNetworkView) this.aId.findViewById(d.g.view_no_network);
        this.efg = (TextView) this.aId.findViewById(d.g.text_forum_name);
        this.eff = (TextView) this.aId.findViewById(d.g.text_forum_create);
        this.efj = (TbImageView) this.aId.findViewById(d.g.status_icon);
        this.eff.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.efd.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.efd.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.efd.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.efd.finish();
            }
        });
        this.efh = (TextView) this.aId.findViewById(d.g.text_create_need);
        this.efi = (LinearLayout) this.aId.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.efd.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.efd.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aBZ() {
        this.dqt.setVisibility(8);
    }

    public void aCa() {
        this.dqt.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.efe == null) {
            int t = l.t(this.efd.getActivity(), d.e.ds100);
            this.efe = NoDataViewFactory.a(this.efd.getPageContext().getPageActivity(), (LinearLayout) this.aId.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, t), null, null);
            this.efe.setVisibility(0);
            Jb();
        }
        this.efg.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.efj.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.efj.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.efh.setVisibility(4);
            this.efi.setVisibility(4);
        }
        this.efh.setVisibility(8);
        this.efi.setVisibility(8);
    }

    public void Jb() {
        com.baidu.tbadk.n.a.a(this.efd.getPageContext(), this.aId);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.efd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dAX != null) {
            this.dAX.onChangeSkinType(this.efd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.efe != null) {
            this.efe.onChangeSkinType(this.efd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.aId;
    }
}
