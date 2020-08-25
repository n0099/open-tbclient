package com.baidu.tieba.homepage.personalize.view;

import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.tbadk.BdToken.activeConfig.ActiveCenterData;
import com.baidu.tbadk.BdToken.q;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.mission.MaxSignItemView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.g> {
    private ActiveCenterData dPQ;
    private ImageView dSD;
    private ImageView iQM;
    private TextView iQN;
    private RoundRelativeLayout iQO;
    private FrameLayout iQP;
    private TextView iQQ;
    private TextView iQR;
    private MaxSignItemView iQS;
    private RoundRelativeLayout iQT;
    private TextView iQU;
    private TextView iQV;
    private TBSpecificationBtn iQW;
    private TextView iQX;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        init(getView());
    }

    private void init(View view) {
        this.iQM = (ImageView) view.findViewById(R.id.header_logo);
        this.iQN = (TextView) view.findViewById(R.id.header_title);
        this.dSD = (ImageView) view.findViewById(R.id.header_close);
        this.iQO = (RoundRelativeLayout) view.findViewById(R.id.card_body);
        this.iQO.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds10));
        this.iQP = (FrameLayout) view.findViewById(R.id.body_desc);
        this.iQQ = (TextView) view.findViewById(R.id.text_left);
        this.iQR = (TextView) view.findViewById(R.id.text_right);
        this.iQS = (MaxSignItemView) view.findViewById(R.id.sign_view);
        this.iQT = (RoundRelativeLayout) view.findViewById(R.id.bottom_action_layout);
        this.iQT.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds21));
        this.iQU = (TextView) view.findViewById(R.id.bottom_title);
        this.iQV = (TextView) view.findViewById(R.id.bottom_detail);
        this.iQW = (TBSpecificationBtn) view.findViewById(R.id.bottom_btn);
        this.iQX = (TextView) view.findViewById(R.id.bottom_btn_text);
        this.dSD.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13742").ai("obj_source", 3).ai("obj_type", 3));
                q.aYY().hy(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921461));
            }
        });
        this.iQS.setItemClickListener(new MaxSignItemView.a() { // from class: com.baidu.tieba.homepage.personalize.view.e.2
            @Override // com.baidu.tbadk.widget.mission.MaxSignItemView.a
            public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
                e.this.d(activeCenterStatusData);
            }
        });
        this.iQW.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13742").ai("obj_source", 3).ai("obj_type", 2));
                q.aYY().c(e.this.mTbPageContext);
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bkF();
        }
        this.mSkinType = i;
    }

    private void bkF() {
        SvgManager.bjq().a(this.iQM, R.drawable.ic_pic_mask_taskcenter_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.iQN, R.color.cp_cont_b);
        ap.setBackgroundColor(this.iQO, R.color.cp_other_g);
        ap.setBackgroundColor(this.iQP, R.color.cp_other_h);
        ap.setViewTextColor(this.iQQ, R.color.cp_btn_a);
        ap.setViewTextColor(this.iQR, R.color.cp_btn_a);
        ap.setBackgroundColor(this.iQT, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.iQU, R.color.cp_cont_b);
        ap.setViewTextColor(this.iQV, R.color.cp_cont_d);
        ap.setViewTextColor(this.iQX, R.color.cp_cont_d);
        this.iQS.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SvgManager.bjq().a(this.dSD, R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.layout_home_page_item_mission_entrance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
        this.dPQ = gVar.aZb();
        if (this.dPQ != null) {
            this.iQN.setText(R.string.mission_entrance_header_title);
            this.iQQ.setText(at.cutChineseAndEnglishWithSuffix(this.dPQ.win_title, 14, StringHelper.STRING_MORE));
            this.iQR.setText(at.cutChineseAndEnglishWithSuffix(this.dPQ.win_desc, 30, StringHelper.STRING_MORE));
            this.iQS.setData(this.dPQ);
            d(this.dPQ.getTodayMissionStatus());
            bkF();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.dPQ != null && this.dPQ.mission != null && activeCenterStatusData != null) {
            this.iQT.setAllCornerRound(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.iQU;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.iQV;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.iQW.setVisibility(0);
                this.iQX.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.iQW.setText("已完成");
                    this.iQW.setClickable(false);
                    this.iQW.setEnabled(false);
                } else {
                    this.iQW.setText("已过期");
                    this.iQW.setClickable(false);
                    this.iQW.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.iQW.setVisibility(0);
                this.iQX.setVisibility(8);
                if (this.dPQ.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.iQW.setText("去领取");
                        this.iQW.setClickable(true);
                        this.iQW.setEnabled(true);
                    } else {
                        this.iQW.setText("未达标");
                        this.iQW.setClickable(false);
                        this.iQW.setEnabled(false);
                    }
                } else {
                    if (this.dPQ.mission.task_type == 6) {
                        if (q.aYY().aZh().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.iQW.setText("已完成");
                        this.iQW.setClickable(false);
                        this.iQW.setEnabled(false);
                    } else {
                        this.iQW.setText("去完成");
                        this.iQW.setClickable(true);
                        this.iQW.setEnabled(true);
                    }
                }
            } else {
                this.iQW.setVisibility(8);
                this.iQX.setVisibility(0);
                this.iQX.setText("未开始");
            }
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.pb(R.color.cp_cont_h);
            aVar.oZ(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.iQW.setConfig(aVar);
            this.iQW.setTextSize(R.dimen.tbds34);
        }
    }
}
