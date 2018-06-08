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
/* loaded from: classes3.dex */
public class a {
    private View abp;
    private UserBfbInfo bfbInfo;
    private View cSY;
    private CreateBarGuideActivity dMb;
    private NoDataView dMc;
    private TextView dMd;
    private TextView dMe;
    private TextView dMf;
    private LinearLayout dMg;
    private TbImageView dMh;
    private NoNetworkView ddN;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.dMb = createBarGuideActivity;
        this.abp = LayoutInflater.from(this.dMb.getPageContext().getPageActivity()).inflate(d.i.create_bar_guide_activity, (ViewGroup) null);
        this.dMb.setContentView(this.abp);
        this.cSY = this.abp.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.abp.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.create_bar);
        this.ddN = (NoNetworkView) this.abp.findViewById(d.g.view_no_network);
        this.dMe = (TextView) this.abp.findViewById(d.g.text_forum_name);
        this.dMd = (TextView) this.abp.findViewById(d.g.text_forum_create);
        this.dMh = (TbImageView) this.abp.findViewById(d.g.status_icon);
        this.dMd.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dMb.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dMb.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dMb.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.dMb.finish();
            }
        });
        this.dMf = (TextView) this.abp.findViewById(d.g.text_create_need);
        this.dMg = (LinearLayout) this.abp.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dMb.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dMb.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aBM() {
        this.cSY.setVisibility(8);
    }

    public void aBN() {
        this.cSY.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.dMc == null) {
            int e = l.e(this.dMb.getActivity(), d.e.ds100);
            this.dMc = NoDataViewFactory.a(this.dMb.getPageContext().getPageActivity(), (LinearLayout) this.abp.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, e), null, null);
            this.dMc.setVisibility(0);
            Fs();
        }
        this.dMe.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.dMh.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.dMh.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.dMf.setVisibility(4);
            this.dMg.setVisibility(4);
        }
        this.dMf.setVisibility(8);
        this.dMg.setVisibility(8);
    }

    public void Fs() {
        com.baidu.tbadk.n.a.a(this.dMb.getPageContext(), this.abp);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dMb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.ddN != null) {
            this.ddN.onChangeSkinType(this.dMb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dMc != null) {
            this.dMc.onChangeSkinType(this.dMb.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.abp;
    }
}
