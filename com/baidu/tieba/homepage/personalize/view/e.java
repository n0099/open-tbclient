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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.mission.MaxSignItemView;
import com.baidu.tieba.R;
import com.baidu.tieba.view.RoundRelativeLayout;
/* loaded from: classes16.dex */
public class e extends com.baidu.tieba.card.b<com.baidu.tieba.homepage.personalize.data.g> {
    private ActiveCenterData dGJ;
    private ImageView dJv;
    private ImageView iBU;
    private TextView iBV;
    private RoundRelativeLayout iBW;
    private FrameLayout iBX;
    private TextView iBY;
    private TextView iBZ;
    private MaxSignItemView iCa;
    private RoundRelativeLayout iCb;
    private TextView iCc;
    private TextView iCd;
    private TBSpecificationBtn iCe;
    private TextView iCf;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        init(getView());
    }

    private void init(View view) {
        this.iBU = (ImageView) view.findViewById(R.id.header_logo);
        this.iBV = (TextView) view.findViewById(R.id.header_title);
        this.dJv = (ImageView) view.findViewById(R.id.header_close);
        this.iBW = (RoundRelativeLayout) view.findViewById(R.id.card_body);
        this.iBW.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds10));
        this.iBX = (FrameLayout) view.findViewById(R.id.body_desc);
        this.iBY = (TextView) view.findViewById(R.id.text_left);
        this.iBZ = (TextView) view.findViewById(R.id.text_right);
        this.iCa = (MaxSignItemView) view.findViewById(R.id.sign_view);
        this.iCb = (RoundRelativeLayout) view.findViewById(R.id.bottom_action_layout);
        this.iCb.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds21));
        this.iCc = (TextView) view.findViewById(R.id.bottom_title);
        this.iCd = (TextView) view.findViewById(R.id.bottom_detail);
        this.iCe = (TBSpecificationBtn) view.findViewById(R.id.bottom_btn);
        this.iCf = (TextView) view.findViewById(R.id.bottom_btn_text);
        this.dJv.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ap("c13742").ah("obj_source", 3).ah("obj_type", 3));
                q.aQI().hc(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921461));
            }
        });
        this.iCa.setItemClickListener(new MaxSignItemView.a() { // from class: com.baidu.tieba.homepage.personalize.view.e.2
            @Override // com.baidu.tbadk.widget.mission.MaxSignItemView.a
            public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
                e.this.d(activeCenterStatusData);
            }
        });
        this.iCe.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new ap("c13742").ah("obj_source", 3).ah("obj_type", 2));
                q.aQI().c(e.this.mTbPageContext);
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bci();
        }
        this.mSkinType = i;
    }

    private void bci() {
        SvgManager.baR().a(this.iBU, R.drawable.ic_pic_mask_taskcenter_svg, SvgManager.SvgResourceStateType.NORMAL);
        ao.setViewTextColor(this.iBV, R.color.cp_cont_b);
        ao.setBackgroundColor(this.iBW, R.color.cp_other_g);
        ao.setBackgroundColor(this.iBX, R.color.cp_other_h);
        ao.setViewTextColor(this.iBY, R.color.cp_btn_a);
        ao.setViewTextColor(this.iBZ, R.color.cp_btn_a);
        ao.setBackgroundColor(this.iCb, R.color.cp_bg_line_k);
        ao.setViewTextColor(this.iCc, R.color.cp_cont_b);
        ao.setViewTextColor(this.iCd, R.color.cp_cont_d);
        ao.setViewTextColor(this.iCf, R.color.cp_cont_d);
        this.iCa.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SvgManager.baR().a(this.dJv, R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.layout_home_page_item_mission_entrance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
        this.dGJ = gVar.aQL();
        if (this.dGJ != null) {
            this.iBV.setText(R.string.mission_entrance_header_title);
            this.iBY.setText(as.cutChineseAndEnglishWithSuffix(this.dGJ.win_title, 14, StringHelper.STRING_MORE));
            this.iBZ.setText(as.cutChineseAndEnglishWithSuffix(this.dGJ.win_desc, 30, StringHelper.STRING_MORE));
            this.iCa.setData(this.dGJ);
            d(this.dGJ.getTodayMissionStatus());
            bci();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.dGJ != null && this.dGJ.mission != null && activeCenterStatusData != null) {
            this.iCb.setAllCornerRound(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.iCc;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.iCd;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.iCe.setVisibility(0);
                this.iCf.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.iCe.setText("已完成");
                    this.iCe.setClickable(false);
                    this.iCe.setEnabled(false);
                } else {
                    this.iCe.setText("已过期");
                    this.iCe.setClickable(false);
                    this.iCe.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.iCe.setVisibility(0);
                this.iCf.setVisibility(8);
                if (this.dGJ.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.iCe.setText("去领取");
                        this.iCe.setClickable(true);
                        this.iCe.setEnabled(true);
                    } else {
                        this.iCe.setText("未达标");
                        this.iCe.setClickable(false);
                        this.iCe.setEnabled(false);
                    }
                } else {
                    if (this.dGJ.mission.task_type == 6) {
                        if (q.aQI().aQR().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.iCe.setText("已完成");
                        this.iCe.setClickable(false);
                        this.iCe.setEnabled(false);
                    } else {
                        this.iCe.setText("去完成");
                        this.iCe.setClickable(true);
                        this.iCe.setEnabled(true);
                    }
                }
            } else {
                this.iCe.setVisibility(8);
                this.iCf.setVisibility(0);
                this.iCf.setText("未开始");
            }
            com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
            bVar.mV(R.color.cp_cont_h);
            bVar.mT(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.iCe.setConfig(bVar);
            this.iCe.setTextSize(R.dimen.tbds34);
        }
    }
}
