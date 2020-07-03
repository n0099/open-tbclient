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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.mission.MaxSignItemView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes9.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.g> {
    private ActiveCenterData dAN;
    private ImageView dDy;
    private ImageView ivO;
    private TextView ivP;
    private RoundRelativeLayout ivQ;
    private FrameLayout ivR;
    private TextView ivS;
    private TextView ivT;
    private MaxSignItemView ivU;
    private RoundRelativeLayout ivV;
    private TextView ivW;
    private TextView ivX;
    private TBSpecificationBtn ivY;
    private TextView ivZ;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        init(getView());
    }

    private void init(View view) {
        this.ivO = (ImageView) view.findViewById(R.id.header_logo);
        this.ivP = (TextView) view.findViewById(R.id.header_title);
        this.dDy = (ImageView) view.findViewById(R.id.header_close);
        this.ivQ = (RoundRelativeLayout) view.findViewById(R.id.card_body);
        this.ivQ.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds10));
        this.ivR = (FrameLayout) view.findViewById(R.id.body_desc);
        this.ivS = (TextView) view.findViewById(R.id.text_left);
        this.ivT = (TextView) view.findViewById(R.id.text_right);
        this.ivU = (MaxSignItemView) view.findViewById(R.id.sign_view);
        this.ivV = (RoundRelativeLayout) view.findViewById(R.id.bottom_action_layout);
        this.ivV.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds21));
        this.ivW = (TextView) view.findViewById(R.id.bottom_title);
        this.ivX = (TextView) view.findViewById(R.id.bottom_detail);
        this.ivY = (TBSpecificationBtn) view.findViewById(R.id.bottom_btn);
        this.ivZ = (TextView) view.findViewById(R.id.bottom_btn_text);
        this.dDy.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ao("c13742").ag("obj_source", 3).ag("obj_type", 3));
                q.aMU().gH(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921461));
            }
        });
        this.ivU.setItemClickListener(new MaxSignItemView.a() { // from class: com.baidu.tieba.homepage.personalize.view.e.2
            @Override // com.baidu.tbadk.widget.mission.MaxSignItemView.a
            public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
                e.this.d(activeCenterStatusData);
            }
        });
        this.ivY.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ao("c13742").ag("obj_source", 3).ag("obj_type", 2));
                q.aMU().c(e.this.mTbPageContext);
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            aYj();
        }
        this.mSkinType = i;
    }

    private void aYj() {
        SvgManager.aWQ().a(this.ivO, R.drawable.ic_pic_mask_taskcenter_svg, SvgManager.SvgResourceStateType.NORMAL);
        an.setViewTextColor(this.ivP, (int) R.color.cp_cont_b);
        an.setBackgroundColor(this.ivQ, R.color.cp_other_g);
        an.setBackgroundColor(this.ivR, R.color.cp_other_h);
        an.setViewTextColor(this.ivS, (int) R.color.cp_btn_a);
        an.setViewTextColor(this.ivT, (int) R.color.cp_btn_a);
        an.setBackgroundColor(this.ivV, R.color.cp_bg_line_k);
        an.setViewTextColor(this.ivW, (int) R.color.cp_cont_b);
        an.setViewTextColor(this.ivX, (int) R.color.cp_cont_d);
        an.setViewTextColor(this.ivZ, (int) R.color.cp_cont_d);
        this.ivU.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SvgManager.aWQ().a(this.dDy, R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.layout_home_page_item_mission_entrance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
        this.dAN = gVar.aMX();
        if (this.dAN != null) {
            this.ivP.setText(R.string.mission_entrance_header_title);
            this.ivS.setText(ar.cutChineseAndEnglishWithSuffix(this.dAN.win_title, 14, StringHelper.STRING_MORE));
            this.ivT.setText(ar.cutChineseAndEnglishWithSuffix(this.dAN.win_desc, 30, StringHelper.STRING_MORE));
            this.ivU.setData(this.dAN);
            d(this.dAN.getTodayMissionStatus());
            aYj();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.dAN != null && this.dAN.mission != null && activeCenterStatusData != null) {
            this.ivV.setAllCornerRound(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.ivW;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.ivX;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.ivY.setVisibility(0);
                this.ivZ.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.ivY.setText("已完成");
                    this.ivY.setClickable(false);
                    this.ivY.setEnabled(false);
                } else {
                    this.ivY.setText("已过期");
                    this.ivY.setClickable(false);
                    this.ivY.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.ivY.setVisibility(0);
                this.ivZ.setVisibility(8);
                if (this.dAN.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.ivY.setText("去领取");
                        this.ivY.setClickable(true);
                        this.ivY.setEnabled(true);
                    } else {
                        this.ivY.setText("未达标");
                        this.ivY.setClickable(false);
                        this.ivY.setEnabled(false);
                    }
                } else {
                    if (this.dAN.mission.task_type == 6) {
                        if (q.aMU().aNd().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.ivY.setText("已完成");
                        this.ivY.setClickable(false);
                        this.ivY.setEnabled(false);
                    } else {
                        this.ivY.setText("去完成");
                        this.ivY.setClickable(true);
                        this.ivY.setEnabled(true);
                    }
                }
            } else {
                this.ivY.setVisibility(8);
                this.ivZ.setVisibility(0);
                this.ivZ.setText("未开始");
            }
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.mC(R.color.cp_cont_h);
            bVar.mA(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.ivY.setConfig(bVar);
            this.ivY.setTextSize(R.dimen.tbds34);
        }
    }
}
