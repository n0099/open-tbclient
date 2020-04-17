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
/* loaded from: classes11.dex */
public class a {
    private UserBfbInfo bfbInfo;
    private String forumName;
    private NoNetworkView gUf;
    private CreateBarGuideActivity hHd;
    private View hHe;
    private NoDataView hHf;
    private TextView hHg;
    private TextView hHh;
    private LinearLayout hHi;
    private TbImageView hHj;
    private TextView hfq;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.hHd = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.hHd.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.hHd.setContentView(this.mRoot);
        this.hHe = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.gUf = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.hfq = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.hHg = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.hHj = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.hHg.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.hHd.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.hHd.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.hHd.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.hHd.finish();
            }
        });
        this.hHh = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.hHi = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.hHd.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.hHd.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void bXJ() {
        this.hHe.setVisibility(8);
    }

    public void bXK() {
        this.hHe.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.hHf == null) {
            int dimens = l.getDimens(this.hHd.getActivity(), R.dimen.ds100);
            this.hHf = NoDataViewFactory.a(this.hHd.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.hHf.setVisibility(0);
            aVd();
        }
        this.hfq.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.hHj.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.hHj.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.hHh.setVisibility(4);
            this.hHi.setVisibility(4);
        }
        this.hHh.setVisibility(8);
        this.hHi.setVisibility(8);
    }

    public void aVd() {
        com.baidu.tbadk.q.a.a(this.hHd.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hHd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gUf != null) {
            this.gUf.onChangeSkinType(this.hHd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hHf != null) {
            this.hHf.onChangeSkinType(this.hHd.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
