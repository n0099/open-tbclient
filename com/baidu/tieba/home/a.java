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
/* loaded from: classes23.dex */
public class a {
    private UserBfbInfo bfbInfo;
    private NoNetworkView eWZ;
    private String forumName;
    private CreateBarGuideActivity iMY;
    private View iMZ;
    private NoDataView iNa;
    private TextView iNb;
    private TextView iNc;
    private LinearLayout iNd;
    private TbImageView iNe;
    private TextView iiz;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.iMY = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.iMY.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.iMY.setContentView(this.mRoot);
        this.iMZ = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.eWZ = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.iiz = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.iNb = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.iNe = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.iNb.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.iMY.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.iMY.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.iMY.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.iMY.finish();
            }
        });
        this.iNc = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.iNd = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.iMY.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.iMY.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void czo() {
        this.iMZ.setVisibility(8);
    }

    public void czp() {
        this.iMZ.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.iNa == null) {
            int dimens = l.getDimens(this.iMY.getActivity(), R.dimen.ds100);
            this.iNa = NoDataViewFactory.a(this.iMY.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.iNa.setVisibility(0);
            bqC();
        }
        this.iiz.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.iNe.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.iNe.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.iNc.setVisibility(4);
            this.iNd.setVisibility(4);
        }
        this.iNc.setVisibility(8);
        this.iNd.setVisibility(8);
    }

    public void bqC() {
        com.baidu.tbadk.r.a.a(this.iMY.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.iMY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eWZ != null) {
            this.eWZ.onChangeSkinType(this.iMY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.iNa != null) {
            this.iNa.onChangeSkinType(this.iMY.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
