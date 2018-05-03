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
    private View cIJ;
    private NoNetworkView cTx;
    private CreateBarGuideActivity dzK;
    private NoDataView dzL;
    private TextView dzM;
    private TextView dzN;
    private TextView dzO;
    private LinearLayout dzP;
    private TbImageView dzQ;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.dzK = createBarGuideActivity;
        this.Tl = LayoutInflater.from(this.dzK.getPageContext().getPageActivity()).inflate(d.i.create_bar_guide_activity, (ViewGroup) null);
        this.dzK.setContentView(this.Tl);
        this.cIJ = this.Tl.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.Tl.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.create_bar);
        this.cTx = (NoNetworkView) this.Tl.findViewById(d.g.view_no_network);
        this.dzN = (TextView) this.Tl.findViewById(d.g.text_forum_name);
        this.dzM = (TextView) this.Tl.findViewById(d.g.text_forum_create);
        this.dzQ = (TbImageView) this.Tl.findViewById(d.g.status_icon);
        this.dzM.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dzK.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dzK.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dzK.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.dzK.finish();
            }
        });
        this.dzO = (TextView) this.Tl.findViewById(d.g.text_create_need);
        this.dzP = (LinearLayout) this.Tl.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dzK.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dzK.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void awV() {
        this.cIJ.setVisibility(8);
    }

    public void awW() {
        this.cIJ.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.dzL == null) {
            int e = l.e(this.dzK.getActivity(), d.e.ds100);
            this.dzL = NoDataViewFactory.a(this.dzK.getPageContext().getPageActivity(), (LinearLayout) this.Tl.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, e), null, null);
            this.dzL.setVisibility(0);
            BR();
        }
        this.dzN.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.dzQ.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.dzQ.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.dzO.setVisibility(4);
            this.dzP.setVisibility(4);
        }
        this.dzO.setVisibility(8);
        this.dzP.setVisibility(8);
    }

    public void BR() {
        com.baidu.tbadk.n.a.a(this.dzK.getPageContext(), this.Tl);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dzK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.cTx != null) {
            this.cTx.onChangeSkinType(this.dzK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dzL != null) {
            this.dzL.onChangeSkinType(this.dzK.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.Tl;
    }
}
