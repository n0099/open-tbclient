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
    private View anp;
    private UserBfbInfo bfbInfo;
    private NoNetworkView dHD;
    private TextView dRT;
    private View dsT;
    private CreateBarGuideActivity esX;
    private NoDataView esY;
    private TextView esZ;
    private TextView eta;
    private LinearLayout etb;
    private TbImageView etd;
    private String forumName;
    private NavigationBar mNavigationBar;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.esX = createBarGuideActivity;
        this.anp = LayoutInflater.from(this.esX.getPageContext().getPageActivity()).inflate(e.h.create_bar_guide_activity, (ViewGroup) null);
        this.esX.setContentView(this.anp);
        this.dsT = this.anp.findViewById(e.g.body_view);
        this.mNavigationBar = (NavigationBar) this.anp.findViewById(e.g.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(e.j.create_bar);
        this.dHD = (NoNetworkView) this.anp.findViewById(e.g.view_no_network);
        this.dRT = (TextView) this.anp.findViewById(e.g.text_forum_name);
        this.esZ = (TextView) this.anp.findViewById(e.g.text_forum_create);
        this.etd = (TbImageView) this.anp.findViewById(e.g.status_icon);
        this.esZ.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.esX.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.esX.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.esX.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.esX.finish();
            }
        });
        this.eta = (TextView) this.anp.findViewById(e.g.text_create_need);
        this.etb = (LinearLayout) this.anp.findViewById(e.g.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.esX.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.esX.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void aLf() {
        this.dsT.setVisibility(8);
    }

    public void aLg() {
        this.dsT.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.esY == null) {
            int h = l.h(this.esX.getActivity(), e.C0210e.ds100);
            this.esY = NoDataViewFactory.a(this.esX.getPageContext().getPageActivity(), (LinearLayout) this.anp.findViewById(e.g.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, h), null, null);
            this.esY.setVisibility(0);
            KD();
        }
        this.dRT.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.etd.setImageResource(e.f.icon_create_attention_n);
            } else {
                this.etd.setImageResource(e.f.icon_create_complete_n);
            }
        } else {
            this.eta.setVisibility(4);
            this.etb.setVisibility(4);
        }
        this.eta.setVisibility(8);
        this.etb.setVisibility(8);
    }

    public void KD() {
        com.baidu.tbadk.o.a.a(this.esX.getPageContext(), this.anp);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.esX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.dHD != null) {
            this.dHD.onChangeSkinType(this.esX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.esY != null) {
            this.esY.onChangeSkinType(this.esX.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.anp;
    }
}
