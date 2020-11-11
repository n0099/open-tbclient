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
    private NoNetworkView fxC;
    private TextView iPP;
    private CreateBarGuideActivity jui;
    private View juj;
    private NoDataView juk;
    private TextView jul;
    private TextView jum;
    private LinearLayout jun;
    private TbImageView juo;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.jui = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.jui.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.jui.setContentView(this.mRoot);
        this.juj = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.fxC = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.iPP = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.jul = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.juo = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.jul.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.jui.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jui.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jui.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.jui.finish();
            }
        });
        this.jum = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.jun = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.jui.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.jui.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void cIt() {
        this.juj.setVisibility(8);
    }

    public void cIu() {
        this.juj.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.juk == null) {
            int dimens = l.getDimens(this.jui.getActivity(), R.dimen.ds100);
            this.juk = NoDataViewFactory.a(this.jui.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.juk.setVisibility(0);
            bxE();
        }
        this.iPP.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.juo.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.juo.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.jum.setVisibility(4);
            this.jun.setVisibility(4);
        }
        this.jum.setVisibility(8);
        this.jun.setVisibility(8);
    }

    public void bxE() {
        com.baidu.tbadk.r.a.a(this.jui.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.jui.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fxC != null) {
            this.fxC.onChangeSkinType(this.jui.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.juk != null) {
            this.juk.onChangeSkinType(this.jui.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
