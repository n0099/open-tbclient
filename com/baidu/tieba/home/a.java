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
    private TextView fBR;
    private View fcw;
    private String forumName;
    private NoNetworkView fqt;
    private CreateBarGuideActivity gct;
    private NoDataView gcu;
    private TextView gcv;
    private TextView gcw;
    private LinearLayout gcx;
    private TbImageView gcy;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.gct = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.gct.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.gct.setContentView(this.mRoot);
        this.fcw = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.fqt = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.fBR = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.gcv = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.gcy = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.gcv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.gct.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.gct.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.gct.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.gct.finish();
            }
        });
        this.gcw = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.gcx = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.gct.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.gct.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void bsN() {
        this.fcw.setVisibility(8);
    }

    public void bsO() {
        this.fcw.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.gcu == null) {
            int dimens = l.getDimens(this.gct.getActivity(), R.dimen.ds100);
            this.gcu = NoDataViewFactory.a(this.gct.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.gcu.setVisibility(0);
            ask();
        }
        this.fBR.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.gcy.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.gcy.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.gcw.setVisibility(4);
            this.gcx.setVisibility(4);
        }
        this.gcw.setVisibility(8);
        this.gcx.setVisibility(8);
    }

    public void ask() {
        com.baidu.tbadk.s.a.a(this.gct.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gct.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fqt != null) {
            this.fqt.onChangeSkinType(this.gct.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gcu != null) {
            this.gcu.onChangeSkinType(this.gct.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
