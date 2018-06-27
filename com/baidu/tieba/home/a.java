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
    private View abt;
    private UserBfbInfo bfbInfo;
    private View cQW;
    private CreateBarGuideActivity dPs;
    private NoDataView dPt;
    private TextView dPu;
    private TextView dPv;
    private LinearLayout dPw;
    private TbImageView dPx;
    private NoNetworkView dfF;
    private TextView dpH;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.dPs = createBarGuideActivity;
        this.abt = LayoutInflater.from(this.dPs.getPageContext().getPageActivity()).inflate(d.i.create_bar_guide_activity, (ViewGroup) null);
        this.dPs.setContentView(this.abt);
        this.cQW = this.abt.findViewById(d.g.body_view);
        this.mNavigationBar = (NavigationBar) this.abt.findViewById(d.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(d.k.create_bar);
        this.dfF = (NoNetworkView) this.abt.findViewById(d.g.view_no_network);
        this.dpH = (TextView) this.abt.findViewById(d.g.text_forum_name);
        this.dPu = (TextView) this.abt.findViewById(d.g.text_forum_create);
        this.dPx = (TbImageView) this.abt.findViewById(d.g.status_icon);
        this.dPu.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dPs.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dPs.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dPs.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.dPs.finish();
            }
        });
        this.dPv = (TextView) this.abt.findViewById(d.g.text_create_need);
        this.dPw = (LinearLayout) this.abt.findViewById(d.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.dPs.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.dPs.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aCs() {
        this.cQW.setVisibility(8);
    }

    public void aCt() {
        this.cQW.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.dPt == null) {
            int e = l.e(this.dPs.getActivity(), d.e.ds100);
            this.dPt = NoDataViewFactory.a(this.dPs.getPageContext().getPageActivity(), (LinearLayout) this.abt.findViewById(d.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, e), null, null);
            this.dPt.setVisibility(0);
            FK();
        }
        this.dpH.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.dPx.setImageResource(d.f.icon_create_attention_n);
            } else {
                this.dPx.setImageResource(d.f.icon_create_complete_n);
            }
        } else {
            this.dPv.setVisibility(4);
            this.dPw.setVisibility(4);
        }
        this.dPv.setVisibility(8);
        this.dPw.setVisibility(8);
    }

    public void FK() {
        com.baidu.tbadk.n.a.a(this.dPs.getPageContext(), this.abt);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.dPs.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dfF != null) {
            this.dfF.onChangeSkinType(this.dPs.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dPt != null) {
            this.dPt.onChangeSkinType(this.dPs.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.abt;
    }
}
