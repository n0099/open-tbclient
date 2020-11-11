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
    private ActiveCenterData est;
    private ImageView evk;
    private ImageView jGV;
    private TextView jGW;
    private RoundRelativeLayout jGX;
    private FrameLayout jGY;
    private TextView jGZ;
    private TextView jHa;
    private MaxSignItemView jHb;
    private RoundRelativeLayout jHc;
    private TextView jHd;
    private TextView jHe;
    private TBSpecificationBtn jHf;
    private TextView jHg;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        init(getView());
    }

    private void init(View view) {
        this.jGV = (ImageView) view.findViewById(R.id.header_logo);
        this.jGW = (TextView) view.findViewById(R.id.header_title);
        this.evk = (ImageView) view.findViewById(R.id.header_close);
        this.jGX = (RoundRelativeLayout) view.findViewById(R.id.card_body);
        this.jGX.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds10));
        this.jGY = (FrameLayout) view.findViewById(R.id.body_desc);
        this.jGZ = (TextView) view.findViewById(R.id.text_left);
        this.jHa = (TextView) view.findViewById(R.id.text_right);
        this.jHb = (MaxSignItemView) view.findViewById(R.id.sign_view);
        this.jHc = (RoundRelativeLayout) view.findViewById(R.id.bottom_action_layout);
        this.jHc.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds21));
        this.jHd = (TextView) view.findViewById(R.id.bottom_title);
        this.jHe = (TextView) view.findViewById(R.id.bottom_detail);
        this.jHf = (TBSpecificationBtn) view.findViewById(R.id.bottom_btn);
        this.jHg = (TextView) view.findViewById(R.id.bottom_btn_text);
        this.evk.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13742").al("obj_source", 3).al("obj_type", 3));
                q.bgM().io(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921461));
            }
        });
        this.jHb.setItemClickListener(new MaxSignItemView.a() { // from class: com.baidu.tieba.homepage.personalize.view.e.2
            @Override // com.baidu.tbadk.widget.mission.MaxSignItemView.a
            public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
                e.this.d(activeCenterStatusData);
            }
        });
        this.jHf.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13742").al("obj_source", 3).al("obj_type", 2));
                q.bgM().c(e.this.mTbPageContext);
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bsD();
        }
        this.mSkinType = i;
    }

    private void bsD() {
        SvgManager.brn().a(this.jGV, R.drawable.ic_pic_mask_taskcenter_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.jGW, R.color.cp_cont_b);
        ap.setBackgroundColor(this.jGX, R.color.cp_other_g);
        ap.setBackgroundColor(this.jGY, R.color.cp_other_h);
        ap.setViewTextColor(this.jGZ, R.color.cp_btn_a);
        ap.setViewTextColor(this.jHa, R.color.cp_btn_a);
        ap.setBackgroundColor(this.jHc, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.jHd, R.color.cp_cont_b);
        ap.setViewTextColor(this.jHe, R.color.cp_cont_d);
        ap.setViewTextColor(this.jHg, R.color.cp_cont_d);
        this.jHb.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SvgManager.brn().a(this.evk, R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.layout_home_page_item_mission_entrance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
        this.est = gVar.bgP();
        if (this.est != null) {
            this.jGW.setText(R.string.mission_entrance_header_title);
            this.jGZ.setText(at.cutChineseAndEnglishWithSuffix(this.est.win_title, 14, StringHelper.STRING_MORE));
            this.jHa.setText(at.cutChineseAndEnglishWithSuffix(this.est.win_desc, 30, StringHelper.STRING_MORE));
            this.jHb.setData(this.est);
            d(this.est.getTodayMissionStatus());
            bsD();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.est != null && this.est.mission != null && activeCenterStatusData != null) {
            this.jHc.setAllCornerRound(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.jHd;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.jHe;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.jHf.setVisibility(0);
                this.jHg.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.jHf.setText("已完成");
                    this.jHf.setClickable(false);
                    this.jHf.setEnabled(false);
                } else {
                    this.jHf.setText("已过期");
                    this.jHf.setClickable(false);
                    this.jHf.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.jHf.setVisibility(0);
                this.jHg.setVisibility(8);
                if (this.est.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.jHf.setText("去领取");
                        this.jHf.setClickable(true);
                        this.jHf.setEnabled(true);
                    } else {
                        this.jHf.setText("未达标");
                        this.jHf.setClickable(false);
                        this.jHf.setEnabled(false);
                    }
                } else {
                    if (this.est.mission.task_type == 6) {
                        if (q.bgM().bgV().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.jHf.setText("已完成");
                        this.jHf.setClickable(false);
                        this.jHf.setEnabled(false);
                    } else {
                        this.jHf.setText("去完成");
                        this.jHf.setClickable(true);
                        this.jHf.setEnabled(true);
                    }
                }
            } else {
                this.jHf.setVisibility(8);
                this.jHg.setVisibility(0);
                this.jHg.setText("未开始");
            }
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.qi(R.color.cp_cont_h);
            aVar.qf(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.jHf.setConfig(aVar);
            this.jHf.setTextSize(R.dimen.tbds34);
        }
    }
}
