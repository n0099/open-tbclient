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
import com.baidu.tieba.d;
import tbclient.UserBfbInfo;
/* loaded from: classes6.dex */
public class a {
    private UserBfbInfo bfbInfo;
    private View btY;
    private View eEa;
    private NoNetworkView eUQ;
    private CreateBarGuideActivity fFu;
    private NoDataView fFv;
    private TextView fFw;
    private TextView fFx;
    private LinearLayout fFy;
    private TbImageView fFz;
    private TextView ffT;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.fFu = createBarGuideActivity;
        this.btY = LayoutInflater.from(this.fFu.getPageContext().getPageActivity()).inflate(d.h.create_bar_guide_activity, (ViewGroup) null);
        this.fFu.setContentView(this.btY);
        this.eEa = this.btY.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.btY.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.j.create_bar);
        this.eUQ = (NoNetworkView) this.btY.findViewById(d.g.view_no_network);
        this.ffT = (TextView) this.btY.findViewById(d.g.text_forum_name);
        this.fFw = (TextView) this.btY.findViewById(d.g.text_forum_create);
        this.fFz = (TbImageView) this.btY.findViewById(d.g.status_icon);
        this.fFw.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.fFu.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fFu.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fFu.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.fFu.finish();
            }
        });
        this.fFx = (TextView) this.btY.findViewById(d.g.text_create_need);
        this.fFy = (LinearLayout) this.btY.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.fFu.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.fFu.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void blm() {
        this.eEa.setVisibility(8);
    }

    public void bln() {
        this.eEa.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.fFv == null) {
            int h = l.h(this.fFu.getActivity(), d.e.ds100);
            this.fFv = NoDataViewFactory.a(this.fFu.getPageContext().getPageActivity(), (LinearLayout) this.btY.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, h), null, null);
            this.fFv.setVisibility(0);
            aka();
        }
        this.ffT.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.fFz.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.fFz.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.fFx.setVisibility(4);
            this.fFy.setVisibility(4);
        }
        this.fFx.setVisibility(8);
        this.fFy.setVisibility(8);
    }

    public void aka() {
        com.baidu.tbadk.r.a.a(this.fFu.getPageContext(), this.btY);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.fFu.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.eUQ != null) {
            this.eUQ.onChangeSkinType(this.fFu.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fFv != null) {
            this.fFv.onChangeSkinType(this.fFu.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.btY;
    }
}
