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
    private View ajk;
    private UserBfbInfo bfbInfo;
    private TextView dHW;
    private View diQ;
    private NoNetworkView dxG;
    private CreateBarGuideActivity eiF;
    private NoDataView eiG;
    private TextView eiH;
    private TextView eiI;
    private LinearLayout eiJ;
    private TbImageView eiK;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.eiF = createBarGuideActivity;
        this.ajk = LayoutInflater.from(this.eiF.getPageContext().getPageActivity()).inflate(e.h.create_bar_guide_activity, (ViewGroup) null);
        this.eiF.setContentView(this.ajk);
        this.diQ = this.ajk.findViewById(e.g.body_view);
        this.mNavigationBar = (NavigationBar) this.ajk.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dxG = (NoNetworkView) this.ajk.findViewById(e.g.view_no_network);
        this.dHW = (TextView) this.ajk.findViewById(e.g.text_forum_name);
        this.eiH = (TextView) this.ajk.findViewById(e.g.text_forum_create);
        this.eiK = (TbImageView) this.ajk.findViewById(e.g.status_icon);
        this.eiH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.eiF.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.eiF.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.eiF.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.eiF.finish();
            }
        });
        this.eiI = (TextView) this.ajk.findViewById(e.g.text_create_need);
        this.eiJ = (LinearLayout) this.ajk.findViewById(e.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.eiF.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.eiF.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aIb() {
        this.diQ.setVisibility(8);
    }

    public void aIc() {
        this.diQ.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.eiG == null) {
            int h = l.h(this.eiF.getActivity(), e.C0200e.ds100);
            this.eiG = NoDataViewFactory.a(this.eiF.getPageContext().getPageActivity(), (LinearLayout) this.ajk.findViewById(e.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, h), null, null);
            this.eiG.setVisibility(0);
            Jj();
        }
        this.dHW.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.eiK.setImageResource(e.f.icon_create_attention_n);
            } else {
                this.eiK.setImageResource(e.f.icon_create_complete_n);
            }
        } else {
            this.eiI.setVisibility(4);
            this.eiJ.setVisibility(4);
        }
        this.eiI.setVisibility(8);
        this.eiJ.setVisibility(8);
    }

    public void Jj() {
        com.baidu.tbadk.o.a.a(this.eiF.getPageContext(), this.ajk);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.eiF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dxG != null) {
            this.dxG.onChangeSkinType(this.eiF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eiG != null) {
            this.eiG.onChangeSkinType(this.eiF.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.ajk;
    }
}
