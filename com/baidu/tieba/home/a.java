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
import com.baidu.tieba.e;
import tbclient.UserBfbInfo;
/* loaded from: classes3.dex */
public class a {
    private View amM;
    private UserBfbInfo bfbInfo;
    private NoNetworkView dEf;
    private TextView dOv;
    private View dpt;
    private NoDataView epA;
    private TextView epB;
    private TextView epC;
    private LinearLayout epD;
    private TbImageView epE;
    private CreateBarGuideActivity epz;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.epz = createBarGuideActivity;
        this.amM = LayoutInflater.from(this.epz.getPageContext().getPageActivity()).inflate(e.h.create_bar_guide_activity, (ViewGroup) null);
        this.epz.setContentView(this.amM);
        this.dpt = this.amM.findViewById(e.g.body_view);
        this.mNavigationBar = (NavigationBar) this.amM.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dEf = (NoNetworkView) this.amM.findViewById(e.g.view_no_network);
        this.dOv = (TextView) this.amM.findViewById(e.g.text_forum_name);
        this.epB = (TextView) this.amM.findViewById(e.g.text_forum_create);
        this.epE = (TbImageView) this.amM.findViewById(e.g.status_icon);
        this.epB.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.epz.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.epz.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.epz.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.epz.finish();
            }
        });
        this.epC = (TextView) this.amM.findViewById(e.g.text_create_need);
        this.epD = (LinearLayout) this.amM.findViewById(e.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.epz.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.epz.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aJS() {
        this.dpt.setVisibility(8);
    }

    public void aJT() {
        this.dpt.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.epA == null) {
            int h = l.h(this.epz.getActivity(), e.C0210e.ds100);
            this.epA = NoDataViewFactory.a(this.epz.getPageContext().getPageActivity(), (LinearLayout) this.amM.findViewById(e.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, h), null, null);
            this.epA.setVisibility(0);
            Kn();
        }
        this.dOv.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.epE.setImageResource(e.f.icon_create_attention_n);
            } else {
                this.epE.setImageResource(e.f.icon_create_complete_n);
            }
        } else {
            this.epC.setVisibility(4);
            this.epD.setVisibility(4);
        }
        this.epC.setVisibility(8);
        this.epD.setVisibility(8);
    }

    public void Kn() {
        com.baidu.tbadk.o.a.a(this.epz.getPageContext(), this.amM);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.epz.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dEf != null) {
            this.dEf.onChangeSkinType(this.epz.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.epA != null) {
            this.epA.onChangeSkinType(this.epz.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.amM;
    }
}
