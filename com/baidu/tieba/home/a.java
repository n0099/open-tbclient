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
/* loaded from: classes6.dex */
public class a {
    private UserBfbInfo bfbInfo;
    private TextView fCI;
    private View fdn;
    private String forumName;
    private NoNetworkView frk;
    private CreateBarGuideActivity gdk;
    private NoDataView gdl;
    private TextView gdm;
    private TextView gdn;
    private LinearLayout gdo;
    private TbImageView gdp;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.gdk = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.gdk.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.gdk.setContentView(this.mRoot);
        this.fdn = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.frk = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.fCI = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.gdm = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.gdp = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.gdm.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.gdk.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.gdk.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.gdk.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.gdk.finish();
            }
        });
        this.gdn = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.gdo = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.gdk.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.gdk.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void bsP() {
        this.fdn.setVisibility(8);
    }

    public void bsQ() {
        this.fdn.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.gdl == null) {
            int dimens = l.getDimens(this.gdk.getActivity(), R.dimen.ds100);
            this.gdl = NoDataViewFactory.a(this.gdk.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.gdl.setVisibility(0);
            asm();
        }
        this.fCI.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.gdp.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.gdp.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.gdn.setVisibility(4);
            this.gdo.setVisibility(4);
        }
        this.gdn.setVisibility(8);
        this.gdo.setVisibility(8);
    }

    public void asm() {
        com.baidu.tbadk.s.a.a(this.gdk.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gdk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.frk != null) {
            this.frk.onChangeSkinType(this.gdk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gdl != null) {
            this.gdl.onChangeSkinType(this.gdk.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
