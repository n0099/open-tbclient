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
    private View eYI;
    private TextView fAQ;
    private String forumName;
    private NoNetworkView fpM;
    private CreateBarGuideActivity gbf;
    private NoDataView gbg;
    private TextView gbh;
    private TextView gbi;
    private LinearLayout gbj;
    private TbImageView gbk;
    private NavigationBar mNavigationBar;
    private View mRoot;

    public a(CreateBarGuideActivity createBarGuideActivity) {
        this.gbf = createBarGuideActivity;
        this.mRoot = LayoutInflater.from(this.gbf.getPageContext().getPageActivity()).inflate(R.layout.create_bar_guide_activity, (ViewGroup) null);
        this.gbf.setContentView(this.mRoot);
        this.eYI = this.mRoot.findViewById(R.id.body_view);
        this.mNavigationBar = (NavigationBar) this.mRoot.findViewById(R.id.view_navigation_bar);
        this.mNavigationBar.addSystemImageButton(NavigationBar.ControlAlign.HORIZONTAL_LEFT, NavigationBar.ControlType.BACK_BUTTON);
        this.mNavigationBar.setTitleText(R.string.create_bar);
        this.fpM = (NoNetworkView) this.mRoot.findViewById(R.id.view_no_network);
        this.fAQ = (TextView) this.mRoot.findViewById(R.id.text_forum_name);
        this.gbh = (TextView) this.mRoot.findViewById(R.id.text_forum_create);
        this.gbk = (TbImageView) this.mRoot.findViewById(R.id.status_icon);
        this.gbh.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.home.a.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.gbf.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.gbf.getActivity(), a.this.forumName, true)));
                    }
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.gbf.getActivity(), a.this.forumName, true)));
                }
                TiebaStatic.log("c11223");
                a.this.gbf.finish();
            }
        });
        this.gbi = (TextView) this.mRoot.findViewById(R.id.text_create_need);
        this.gbj = (LinearLayout) this.mRoot.findViewById(R.id.need_desc_layout);
        MessageManager.getInstance().registerListener(new CustomMessageListener(2016458) { // from class: com.baidu.tieba.home.a.2
            /* JADX DEBUG: Method merged with bridge method */
            @Override // com.baidu.adp.framework.listener.MessageListener
            public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
                if (a.this.bfbInfo != null) {
                    if (a.this.bfbInfo.res_no.intValue() == 9528) {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateForumActivityConfig(a.this.gbf.getActivity(), a.this.forumName, true)));
                    } else {
                        MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new CreateBarActivityConfig(a.this.gbf.getActivity(), a.this.forumName, true)));
                    }
                }
            }
        });
    }

    public void buJ() {
        this.eYI.setVisibility(8);
    }

    public void buK() {
        this.eYI.setVisibility(0);
    }

    public void a(String str, UserBfbInfo userBfbInfo) {
        this.forumName = str;
        this.bfbInfo = userBfbInfo;
        if (this.gbg == null) {
            int g = l.g(this.gbf.getActivity(), R.dimen.ds100);
            this.gbg = NoDataViewFactory.a(this.gbf.getPageContext().getPageActivity(), (LinearLayout) this.mRoot.findViewById(R.id.emotion_layout), NoDataViewFactory.c.a(NoDataViewFactory.ImgType.CREATE, g), null, null);
            this.gbg.setVisibility(0);
            aqe();
        }
        this.fAQ.setText(this.forumName + "吧");
        if (this.bfbInfo != null && this.bfbInfo.res_no.intValue() == 9528) {
            if (this.bfbInfo.activity_status.intValue() == 0) {
                this.gbk.setImageResource(R.drawable.icon_create_attention_n);
            } else {
                this.gbk.setImageResource(R.drawable.icon_create_complete_n);
            }
        } else {
            this.gbi.setVisibility(4);
            this.gbj.setVisibility(4);
        }
        this.gbi.setVisibility(8);
        this.gbj.setVisibility(8);
    }

    public void aqe() {
        com.baidu.tbadk.s.a.a(this.gbf.getPageContext(), this.mRoot);
        if (this.mNavigationBar != null) {
            this.mNavigationBar.onChangeSkinType(this.gbf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.fpM != null) {
            this.fpM.onChangeSkinType(this.gbf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
        if (this.gbg != null) {
            this.gbg.onChangeSkinType(this.gbf.getPageContext(), TbadkCoreApplication.getInst().getSkinType());
        }
    }

    public View getRootView() {
        return this.mRoot;
    }
}
