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
    private UserBfbInfo bfbInfo;
    private TextView fDr;
    private View faC;
    private String forumName;
    private NoNetworkView frZ;
    private CreateBarGuideActivity gdM;
    private NoDataView gdN;
    private TextView gdO;
    private TextView gdP;
    private LinearLayout gdQ;
    private TbImageView gdR;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.gdM = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.gdM.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.gdM.setContentView(this.mRoot);
        this.faC = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.frZ = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.fDr = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.gdO = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.gdR = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.gdO.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.gdM.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.gdM.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.gdM.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.gdM.finish();
            }
        });
        this.gdP = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.gdQ = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.gdM.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.gdM.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void bvK() {
        this.faC.setVisibility(8);
    }

    public void bvL() {
        this.faC.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.gdN == null) {
            int g = l.g(this.gdM.getActivity(), R.dimen.ds100);
            this.gdN = NoDataViewFactory.a(this.gdM.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, g), null, null);
            this.gdN.setVisibility(0);
            aqs();
        }
        this.fDr.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.gdR.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.gdR.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.gdP.setVisibility(4);
            this.gdQ.setVisibility(4);
        }
        this.gdP.setVisibility(8);
        this.gdQ.setVisibility(8);
    }

    public void aqs() {
        com.baidu.tbadk.s.a.a(this.gdM.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gdM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.frZ != null) {
            this.frZ.onChangeSkinType(this.gdM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gdN != null) {
            this.gdN.onChangeSkinType(this.gdM.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
