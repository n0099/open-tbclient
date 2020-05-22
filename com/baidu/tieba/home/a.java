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
    private CreateBarGuideActivity hVV;
    private View hVW;
    private NoDataView hVX;
    private TextView hVY;
    private TextView hVZ;
    private LinearLayout hWa;
    private TbImageView hWb;
    private NoNetworkView hiX;
    private TextView huk;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.hVV = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.hVV.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.hVV.setContentView(this.mRoot);
        this.hVW = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.hiX = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.huk = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.hVY = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.hWb = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.hVY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.hVV.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.hVV.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.hVV.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.hVV.finish();
            }
        });
        this.hVZ = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.hWa = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(CmdConfigCustom.CMD_BIND_CARD_SUCCESS) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateForumActivityConfig(a.this.hVV.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new CreateBarActivityConfig(a.this.hVV.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void ceg() {
        this.hVW.setVisibility(8);
    }

    public void ceh() {
        this.hVW.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.hVX == null) {
            int dimens = l.getDimens(this.hVV.getActivity(), R.dimen.ds100);
            this.hVX = NoDataViewFactory.a(this.hVV.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, dimens), null, null);
            this.hVX.setVisibility(0);
            bbl();
        }
        this.huk.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.hWb.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.hWb.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.hVZ.setVisibility(4);
            this.hWa.setVisibility(4);
        }
        this.hVZ.setVisibility(8);
        this.hWa.setVisibility(8);
    }

    public void bbl() {
        com.baidu.tbadk.q.a.a(this.hVV.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.hVV.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hiX != null) {
            this.hiX.onChangeSkinType(this.hVV.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.hVX != null) {
            this.hVX.onChangeSkinType(this.hVV.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
