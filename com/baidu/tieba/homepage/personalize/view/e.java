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
/* loaded from: classes22.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.g> {
    private ActiveCenterData eec;
    private ImageView egT;
    private RoundRelativeLayout joA;
    private FrameLayout joB;
    private TextView joC;
    private TextView joD;
    private MaxSignItemView joE;
    private RoundRelativeLayout joF;
    private TextView joG;
    private TextView joH;
    private TBSpecificationBtn joI;
    private TextView joJ;
    private ImageView joy;
    private TextView joz;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        init(getView());
    }

    private void init(View view) {
        this.joy = (ImageView) view.findViewById(R.id.header_logo);
        this.joz = (TextView) view.findViewById(R.id.header_title);
        this.egT = (ImageView) view.findViewById(R.id.header_close);
        this.joA = (RoundRelativeLayout) view.findViewById(R.id.card_body);
        this.joA.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds10));
        this.joB = (FrameLayout) view.findViewById(R.id.body_desc);
        this.joC = (TextView) view.findViewById(R.id.text_left);
        this.joD = (TextView) view.findViewById(R.id.text_right);
        this.joE = (MaxSignItemView) view.findViewById(R.id.sign_view);
        this.joF = (RoundRelativeLayout) view.findViewById(R.id.bottom_action_layout);
        this.joF.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds21));
        this.joG = (TextView) view.findViewById(R.id.bottom_title);
        this.joH = (TextView) view.findViewById(R.id.bottom_detail);
        this.joI = (TBSpecificationBtn) view.findViewById(R.id.bottom_btn);
        this.joJ = (TextView) view.findViewById(R.id.bottom_btn_text);
        this.egT.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13742").aj("obj_source", 3).aj("obj_type", 3));
                q.bct().hS(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921461));
            }
        });
        this.joE.setItemClickListener(new MaxSignItemView.a() { // from class: com.baidu.tieba.homepage.personalize.view.e.2
            @Override // com.baidu.tbadk.widget.mission.MaxSignItemView.a
            public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
                e.this.d(activeCenterStatusData);
            }
        });
        this.joI.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13742").aj("obj_source", 3).aj("obj_type", 2));
                q.bct().c(e.this.mTbPageContext);
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bok();
        }
        this.mSkinType = i;
    }

    private void bok() {
        SvgManager.bmU().a(this.joy, R.drawable.ic_pic_mask_taskcenter_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.joz, R.color.cp_cont_b);
        ap.setBackgroundColor(this.joA, R.color.cp_other_g);
        ap.setBackgroundColor(this.joB, R.color.cp_other_h);
        ap.setViewTextColor(this.joC, R.color.cp_btn_a);
        ap.setViewTextColor(this.joD, R.color.cp_btn_a);
        ap.setBackgroundColor(this.joF, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.joG, R.color.cp_cont_b);
        ap.setViewTextColor(this.joH, R.color.cp_cont_d);
        ap.setViewTextColor(this.joJ, R.color.cp_cont_d);
        this.joE.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SvgManager.bmU().a(this.egT, R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.layout_home_page_item_mission_entrance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
        this.eec = gVar.bcw();
        if (this.eec != null) {
            this.joz.setText(R.string.mission_entrance_header_title);
            this.joC.setText(at.cutChineseAndEnglishWithSuffix(this.eec.win_title, 14, StringHelper.STRING_MORE));
            this.joD.setText(at.cutChineseAndEnglishWithSuffix(this.eec.win_desc, 30, StringHelper.STRING_MORE));
            this.joE.setData(this.eec);
            d(this.eec.getTodayMissionStatus());
            bok();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.eec != null && this.eec.mission != null && activeCenterStatusData != null) {
            this.joF.setAllCornerRound(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.joG;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.joH;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.joI.setVisibility(0);
                this.joJ.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.joI.setText("已完成");
                    this.joI.setClickable(false);
                    this.joI.setEnabled(false);
                } else {
                    this.joI.setText("已过期");
                    this.joI.setClickable(false);
                    this.joI.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.joI.setVisibility(0);
                this.joJ.setVisibility(8);
                if (this.eec.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.joI.setText("去领取");
                        this.joI.setClickable(true);
                        this.joI.setEnabled(true);
                    } else {
                        this.joI.setText("未达标");
                        this.joI.setClickable(false);
                        this.joI.setEnabled(false);
                    }
                } else {
                    if (this.eec.mission.task_type == 6) {
                        if (q.bct().bcC().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.joI.setText("已完成");
                        this.joI.setClickable(false);
                        this.joI.setEnabled(false);
                    } else {
                        this.joI.setText("去完成");
                        this.joI.setClickable(true);
                        this.joI.setEnabled(true);
                    }
                }
            } else {
                this.joI.setVisibility(8);
                this.joJ.setVisibility(0);
                this.joJ.setText("未开始");
            }
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.pN(R.color.cp_cont_h);
            aVar.pK(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.joI.setConfig(aVar);
            this.joI.setTextSize(R.dimen.tbds34);
        }
    }
}
