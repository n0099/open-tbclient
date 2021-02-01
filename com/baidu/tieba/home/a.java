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
/* loaded from: classes8.dex */
public class a {
    private UserBfbInfo bfbInfo;
    private NoNetworkView fLP;
    private String forumName;
    private NoDataView jYA;
    private TextView jYB;
    private TextView jYC;
    private LinearLayout jYD;
    private TbImageView jYE;
    private CreateBarGuideActivity jYy;
    private View jYz;
    private TextView joJ;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.jYy = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.jYy.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.jYy.setContentView(this.mRoot);
        this.jYz = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.fLP = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.joJ = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.jYB = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.jYE = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.jYB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.jYy.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jYy.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jYy.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.jYy.finish();
            }
        });
        this.jYC = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.jYD = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.jYy.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jYy.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void cOz() {
        this.jYz.setVisibility(8);
    }

    public void cOA() {
        this.jYz.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.jYA == null) {
            int dimens = l.getDimens(this.jYy.getActivity(), R.dimen.ds100);
            this.jYA = NoDataViewFactory.a(this.jYy.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.jYA.setVisibility(0);
            bzn();
        }
        this.joJ.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.jYE.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.jYE.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.jYC.setVisibility(4);
            this.jYD.setVisibility(4);
        }
        this.jYC.setVisibility(8);
        this.jYD.setVisibility(8);
    }

    public void bzn() {
        com.baidu.tbadk.r.a.a(this.jYy.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jYy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fLP != null) {
            this.fLP.onChangeSkinType(this.jYy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.jYA != null) {
            this.jYA.onChangeSkinType(this.jYy.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
