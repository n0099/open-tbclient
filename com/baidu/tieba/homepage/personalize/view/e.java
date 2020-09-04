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
    private ActiveCenterData dPU;
    private ImageView dSH;
    private ImageView iQS;
    private TextView iQT;
    private RoundRelativeLayout iQU;
    private FrameLayout iQV;
    private TextView iQW;
    private TextView iQX;
    private MaxSignItemView iQY;
    private RoundRelativeLayout iQZ;
    private TextView iRa;
    private TextView iRb;
    private TBSpecificationBtn iRc;
    private TextView iRd;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        init(getView());
    }

    private void init(View view) {
        this.iQS = (ImageView) view.findViewById(R.id.header_logo);
        this.iQT = (TextView) view.findViewById(R.id.header_title);
        this.dSH = (ImageView) view.findViewById(R.id.header_close);
        this.iQU = (RoundRelativeLayout) view.findViewById(R.id.card_body);
        this.iQU.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds10));
        this.iQV = (FrameLayout) view.findViewById(R.id.body_desc);
        this.iQW = (TextView) view.findViewById(R.id.text_left);
        this.iQX = (TextView) view.findViewById(R.id.text_right);
        this.iQY = (MaxSignItemView) view.findViewById(R.id.sign_view);
        this.iQZ = (RoundRelativeLayout) view.findViewById(R.id.bottom_action_layout);
        this.iQZ.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds21));
        this.iRa = (TextView) view.findViewById(R.id.bottom_title);
        this.iRb = (TextView) view.findViewById(R.id.bottom_detail);
        this.iRc = (TBSpecificationBtn) view.findViewById(R.id.bottom_btn);
        this.iRd = (TextView) view.findViewById(R.id.bottom_btn_text);
        this.dSH.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13742").ai("obj_source", 3).ai("obj_type", 3));
                q.aYY().hz(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921461));
            }
        });
        this.iQY.setItemClickListener(new MaxSignItemView.a() { // from class: com.baidu.tieba.homepage.personalize.view.e.2
            @Override // com.baidu.tbadk.widget.mission.MaxSignItemView.a
            public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
                e.this.d(activeCenterStatusData);
            }
        });
        this.iRc.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.3
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
        SvgManager.bjq().a(this.iQS, R.drawable.ic_pic_mask_taskcenter_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.iQT, R.color.cp_cont_b);
        ap.setBackgroundColor(this.iQU, R.color.cp_other_g);
        ap.setBackgroundColor(this.iQV, R.color.cp_other_h);
        ap.setViewTextColor(this.iQW, R.color.cp_btn_a);
        ap.setViewTextColor(this.iQX, R.color.cp_btn_a);
        ap.setBackgroundColor(this.iQZ, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.iRa, R.color.cp_cont_b);
        ap.setViewTextColor(this.iRb, R.color.cp_cont_d);
        ap.setViewTextColor(this.iRd, R.color.cp_cont_d);
        this.iQY.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SvgManager.bjq().a(this.dSH, R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.layout_home_page_item_mission_entrance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
        this.dPU = gVar.aZb();
        if (this.dPU != null) {
            this.iQT.setText(R.string.mission_entrance_header_title);
            this.iQW.setText(at.cutChineseAndEnglishWithSuffix(this.dPU.win_title, 14, StringHelper.STRING_MORE));
            this.iQX.setText(at.cutChineseAndEnglishWithSuffix(this.dPU.win_desc, 30, StringHelper.STRING_MORE));
            this.iQY.setData(this.dPU);
            d(this.dPU.getTodayMissionStatus());
            bkF();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.dPU != null && this.dPU.mission != null && activeCenterStatusData != null) {
            this.iQZ.setAllCornerRound(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.iRa;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.iRb;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.iRc.setVisibility(0);
                this.iRd.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.iRc.setText("已完成");
                    this.iRc.setClickable(false);
                    this.iRc.setEnabled(false);
                } else {
                    this.iRc.setText("已过期");
                    this.iRc.setClickable(false);
                    this.iRc.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.iRc.setVisibility(0);
                this.iRd.setVisibility(8);
                if (this.dPU.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.iRc.setText("去领取");
                        this.iRc.setClickable(true);
                        this.iRc.setEnabled(true);
                    } else {
                        this.iRc.setText("未达标");
                        this.iRc.setClickable(false);
                        this.iRc.setEnabled(false);
                    }
                } else {
                    if (this.dPU.mission.task_type == 6) {
                        if (q.aYY().aZh().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.iRc.setText("已完成");
                        this.iRc.setClickable(false);
                        this.iRc.setEnabled(false);
                    } else {
                        this.iRc.setText("去完成");
                        this.iRc.setClickable(true);
                        this.iRc.setEnabled(true);
                    }
                }
            } else {
                this.iRc.setVisibility(8);
                this.iRd.setVisibility(0);
                this.iRd.setText("未开始");
            }
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.pb(R.color.cp_cont_h);
            aVar.oZ(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.iRc.setConfig(aVar);
            this.iRc.setTextSize(R.dimen.tbds34);
        }
    }
}
