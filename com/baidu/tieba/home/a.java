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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.CreateBarActivityConfig;
import com.baidu.tbadk.core.atomData.CreateForumActivityConfig;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.view.NavigationBar;
import com.baidu.tbadk.core.view.NoDataView;
import com.baidu.tbadk.core.view.NoDataViewFactory;
import com.baidu.tbadk.core.view.NoNetworkView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import tbclient.UserBfbInfo;
/* loaded from: classes24.dex */
public class a {
    private UserBfbInfo bfbInfo;
    private NoNetworkView fjl;
    private String forumName;
    private TextView ixw;
    private CreateBarGuideActivity jbQ;
    private View jbR;
    private NoDataView jbS;
    private TextView jbT;
    private TextView jbU;
    private LinearLayout jbV;
    private TbImageView jbW;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.jbQ = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.jbQ.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.jbQ.setContentView(this.mRoot);
        this.jbR = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.fjl = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.ixw = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.jbT = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.jbW = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.jbT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.jbQ.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jbQ.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jbQ.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.jbQ.finish();
            }
        });
        this.jbU = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.jbV = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.jbQ.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jbQ.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void cCL() {
        this.jbR.setVisibility(8);
    }

    public void cCM() {
        this.jbR.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.jbS == null) {
            int dimens = l.getDimens(this.jbQ.getActivity(), R.dimen.ds100);
            this.jbS = NoDataViewFactory.a(this.jbQ.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.jbS.setVisibility(0);
            btm();
        }
        this.ixw.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.jbW.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.jbW.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.jbU.setVisibility(4);
            this.jbV.setVisibility(4);
        }
        this.jbU.setVisibility(8);
        this.jbV.setVisibility(8);
    }

    public void btm() {
        com.baidu.tbadk.r.a.a(this.jbQ.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jbQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fjl != null) {
            this.fjl.onChangeSkinType(this.jbQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.jbS != null) {
            this.jbS.onChangeSkinType(this.jbQ.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
