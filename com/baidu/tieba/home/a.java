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
    private View aHT;
    private UserBfbInfo bfbInfo;
    private NoNetworkView dAO;
    private View dqk;
    private CreateBarGuideActivity efh;
    private h efi;
    private TextView efj;
    private TextView efk;
    private TextView efl;
    private LinearLayout efm;
    private TbImageView efn;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.efh = createBarGuideActivity;
        this.aHT = LayoutInflater.from(this.efh.getPageContext().getPageActivity()).inflate(d.h.create_bar_guide_activity, (ViewGroup) null);
        this.efh.setContentView(this.aHT);
        this.dqk = this.aHT.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.aHT.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.create_bar);
        this.dAO = (NoNetworkView) this.aHT.findViewById(d.g.view_no_network);
        this.efk = (TextView) this.aHT.findViewById(d.g.text_forum_name);
        this.efj = (TextView) this.aHT.findViewById(d.g.text_forum_create);
        this.efn = (TbImageView) this.aHT.findViewById(d.g.status_icon);
        this.efj.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.efh.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.efh.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.efh.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.efh.finish();
            }
        });
        this.efl = (TextView) this.aHT.findViewById(d.g.text_create_need);
        this.efm = (LinearLayout) this.aHT.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.efh.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.efh.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aBZ() {
        this.dqk.setVisibility(8);
    }

    public void aCa() {
        this.dqk.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.efi == null) {
            int t = l.t(this.efh.getActivity(), d.e.ds100);
            this.efi = NoDataViewFactory.a(this.efh.getPageContext().getPageActivity(), (LinearLayout) this.aHT.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, t), null, null);
            this.efi.setVisibility(0);
            Jb();
        }
        this.efk.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.efn.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.efn.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.efl.setVisibility(4);
            this.efm.setVisibility(4);
        }
        this.efl.setVisibility(8);
        this.efm.setVisibility(8);
    }

    public void Jb() {
        com.baidu.tbadk.n.a.a(this.efh.getPageContext(), this.aHT);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.efh.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dAO != null) {
            this.dAO.onChangeSkinType(this.efh.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.efi != null) {
            this.efi.onChangeSkinType(this.efh.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.aHT;
    }
}
