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
    private View bBg;
    private UserBfbInfo bfbInfo;
    private View eTG;
    private CreateBarGuideActivity fWf;
    private NoDataView fWg;
    private TextView fWh;
    private TextView fWi;
    private LinearLayout fWj;
    private TbImageView fWk;
    private NoNetworkView fkN;
    private String forumName;
    private TextView fvT;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.fWf = createBarGuideActivity;
        this.bBg = LayoutInflater.from(this.fWf.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.fWf.setContentView(this.bBg);
        this.eTG = this.bBg.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.fkN = (NoNetworkView) this.bBg.findViewById(R.id.view_no_network);
        this.fvT = (TextView) this.bBg.findViewById(R.id.text_forum_name);
        this.fWh = (TextView) this.bBg.findViewById(R.id.text_forum_create);
        this.fWk = (TbImageView) this.bBg.findViewById(R.id.status_icon);
        this.fWh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.fWf.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fWf.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fWf.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.fWf.finish();
            }
        });
        this.fWi = (TextView) this.bBg.findViewById(R.id.text_create_need);
        this.fWj = (LinearLayout) this.bBg.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.fWf.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fWf.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void bsD() {
        this.eTG.setVisibility(8);
    }

    public void bsE() {
        this.eTG.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.fWg == null) {
            int g = l.g(this.fWf.getActivity(), R.dimen.ds100);
            this.fWg = NoDataViewFactory.a(this.fWf.getPageContext().getPageActivity(), (LinearLayout) this.bBg.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, g), null, null);
            this.fWg.setVisibility(0);
            aoY();
        }
        this.fvT.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.fWk.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.fWk.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.fWi.setVisibility(4);
            this.fWj.setVisibility(4);
        }
        this.fWi.setVisibility(8);
        this.fWj.setVisibility(8);
    }

    public void aoY() {
        com.baidu.tbadk.s.a.a(this.fWf.getPageContext(), this.bBg);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fWf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fkN != null) {
            this.fkN.onChangeSkinType(this.fWf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fWg != null) {
            this.fWg.onChangeSkinType(this.fWf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.bBg;
    }
}
