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
    private View ano;
    private UserBfbInfo bfbInfo;
    private NoNetworkView dHC;
    private TextView dRS;
    private View dsS;
    private CreateBarGuideActivity esW;
    private NoDataView esX;
    private TextView esY;
    private TextView esZ;
    private LinearLayout eta;
    private TbImageView etb;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.esW = createBarGuideActivity;
        this.ano = LayoutInflater.from(this.esW.getPageContext().getPageActivity()).inflate(e.h.create_bar_guide_activity, (ViewGroup) null);
        this.esW.setContentView(this.ano);
        this.dsS = this.ano.findViewById(e.g.body_view);
        this.mNavigationBar = (NavigationBar) this.ano.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dHC = (NoNetworkView) this.ano.findViewById(e.g.view_no_network);
        this.dRS = (TextView) this.ano.findViewById(e.g.text_forum_name);
        this.esY = (TextView) this.ano.findViewById(e.g.text_forum_create);
        this.etb = (TbImageView) this.ano.findViewById(e.g.status_icon);
        this.esY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.esW.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.esW.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.esW.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.esW.finish();
            }
        });
        this.esZ = (TextView) this.ano.findViewById(e.g.text_create_need);
        this.eta = (LinearLayout) this.ano.findViewById(e.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.esW.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.esW.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aLf() {
        this.dsS.setVisibility(8);
    }

    public void aLg() {
        this.dsS.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.esX == null) {
            int h = l.h(this.esW.getActivity(), e.C0210e.ds100);
            this.esX = NoDataViewFactory.a(this.esW.getPageContext().getPageActivity(), (LinearLayout) this.ano.findViewById(e.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, h), null, null);
            this.esX.setVisibility(0);
            KD();
        }
        this.dRS.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.etb.setImageResource(e.f.icon_create_attention_n);
            } else {
                this.etb.setImageResource(e.f.icon_create_complete_n);
            }
        } else {
            this.esZ.setVisibility(4);
            this.eta.setVisibility(4);
        }
        this.esZ.setVisibility(8);
        this.eta.setVisibility(8);
    }

    public void KD() {
        com.baidu.tbadk.o.a.a(this.esW.getPageContext(), this.ano);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.esW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dHC != null) {
            this.dHC.onChangeSkinType(this.esW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.esX != null) {
            this.esX.onChangeSkinType(this.esW.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.ano;
    }
}
