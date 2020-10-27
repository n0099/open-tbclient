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
    private String forumName;
    private NoNetworkView frK;
    private TextView iJS;
    private CreateBarGuideActivity jol;
    private View jom;
    private NoDataView jon;
    private TextView joo;
    private TextView jop;
    private LinearLayout joq;
    private TbImageView jor;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.jol = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.jol.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.jol.setContentView(this.mRoot);
        this.jom = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.frK = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.iJS = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.joo = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.jor = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.joo.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.jol.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jol.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jol.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.jol.finish();
            }
        });
        this.jop = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.joq = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.jol.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jol.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void cFS() {
        this.jom.setVisibility(8);
    }

    public void cFT() {
        this.jom.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.jon == null) {
            int dimens = l.getDimens(this.jol.getActivity(), R.dimen.ds100);
            this.jon = NoDataViewFactory.a(this.jol.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.jon.setVisibility(0);
            bvf();
        }
        this.iJS.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.jor.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.jor.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.jop.setVisibility(4);
            this.joq.setVisibility(4);
        }
        this.jop.setVisibility(8);
        this.joq.setVisibility(8);
    }

    public void bvf() {
        com.baidu.tbadk.r.a.a(this.jol.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jol.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.frK != null) {
            this.frK.onChangeSkinType(this.jol.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.jon != null) {
            this.jon.onChangeSkinType(this.jol.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
