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
    private View eTH;
    private CreateBarGuideActivity fWi;
    private NoDataView fWj;
    private TextView fWk;
    private TextView fWl;
    private LinearLayout fWm;
    private TbImageView fWn;
    private NoNetworkView fkO;
    private String forumName;
    private TextView fvU;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.fWi = createBarGuideActivity;
        this.bBg = LayoutInflater.from(this.fWi.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.fWi.setContentView(this.bBg);
        this.eTH = this.bBg.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.bBg.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.fkO = (NoNetworkView) this.bBg.findViewById(R.id.view_no_network);
        this.fvU = (TextView) this.bBg.findViewById(R.id.text_forum_name);
        this.fWk = (TextView) this.bBg.findViewById(R.id.text_forum_create);
        this.fWn = (TbImageView) this.bBg.findViewById(R.id.status_icon);
        this.fWk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.fWi.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fWi.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fWi.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.fWi.finish();
            }
        });
        this.fWl = (TextView) this.bBg.findViewById(R.id.text_create_need);
        this.fWm = (LinearLayout) this.bBg.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.fWi.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fWi.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void bsI() {
        this.eTH.setVisibility(8);
    }

    public void bsJ() {
        this.eTH.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.fWj == null) {
            int g = l.g(this.fWi.getActivity(), R.dimen.ds100);
            this.fWj = NoDataViewFactory.a(this.fWi.getPageContext().getPageActivity(), (LinearLayout) this.bBg.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, g), null, null);
            this.fWj.setVisibility(0);
            aoY();
        }
        this.fvU.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.fWn.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.fWn.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.fWl.setVisibility(4);
            this.fWm.setVisibility(4);
        }
        this.fWl.setVisibility(8);
        this.fWm.setVisibility(8);
    }

    public void aoY() {
        com.baidu.tbadk.s.a.a(this.fWi.getPageContext(), this.bBg);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fWi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fkO != null) {
            this.fkO.onChangeSkinType(this.fWi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fWj != null) {
            this.fWj.onChangeSkinType(this.fWi.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.bBg;
    }
}
