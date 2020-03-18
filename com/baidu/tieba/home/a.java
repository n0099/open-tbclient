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
    private CreateBarGuideActivity gXm;
    private View gXn;
    private NoDataView gXo;
    private TextView gXp;
    private TextView gXq;
    private LinearLayout gXr;
    private TbImageView gXs;
    private NoNetworkView gkY;
    private TextView gwf;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.gXm = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.gXm.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.gXm.setContentView(this.mRoot);
        this.gXn = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.gkY = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.gwf = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.gXp = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.gXs = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.gXp.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.gXm.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.gXm.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.gXm.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.gXm.finish();
            }
        });
        this.gXq = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.gXr = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.gXm.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.gXm.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void bNi() {
        this.gXn.setVisibility(8);
    }

    public void bNj() {
        this.gXn.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.gXo == null) {
            int dimens = l.getDimens(this.gXm.getActivity(), R.dimen.ds100);
            this.gXo = NoDataViewFactory.a(this.gXm.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.gXo.setVisibility(0);
            aMG();
        }
        this.gwf.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.gXs.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.gXs.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.gXq.setVisibility(4);
            this.gXr.setVisibility(4);
        }
        this.gXq.setVisibility(8);
        this.gXr.setVisibility(8);
    }

    public void aMG() {
        com.baidu.tbadk.q.a.a(this.gXm.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gXm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gkY != null) {
            this.gkY.onChangeSkinType(this.gXm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gXo != null) {
            this.gXo.onChangeSkinType(this.gXm.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
