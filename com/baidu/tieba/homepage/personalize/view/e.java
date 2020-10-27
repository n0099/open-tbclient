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
    private ActiveCenterData emy;
    private ImageView epr;
    private ImageView jAY;
    private TextView jAZ;
    private RoundRelativeLayout jBa;
    private FrameLayout jBb;
    private TextView jBc;
    private TextView jBd;
    private MaxSignItemView jBe;
    private RoundRelativeLayout jBf;
    private TextView jBg;
    private TextView jBh;
    private TBSpecificationBtn jBi;
    private TextView jBj;
    private int mSkinType;

    public e(TbPageContext<?> tbPageContext) {
        super(tbPageContext);
        this.mSkinType = 3;
        init(getView());
    }

    private void init(View view) {
        this.jAY = (ImageView) view.findViewById(R.id.header_logo);
        this.jAZ = (TextView) view.findViewById(R.id.header_title);
        this.epr = (ImageView) view.findViewById(R.id.header_close);
        this.jBa = (RoundRelativeLayout) view.findViewById(R.id.card_body);
        this.jBa.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds10));
        this.jBb = (FrameLayout) view.findViewById(R.id.body_desc);
        this.jBc = (TextView) view.findViewById(R.id.text_left);
        this.jBd = (TextView) view.findViewById(R.id.text_right);
        this.jBe = (MaxSignItemView) view.findViewById(R.id.sign_view);
        this.jBf = (RoundRelativeLayout) view.findViewById(R.id.bottom_action_layout);
        this.jBf.setAllCornerRound(l.getDimens(this.mTbPageContext.getPageActivity(), R.dimen.tbds21));
        this.jBg = (TextView) view.findViewById(R.id.bottom_title);
        this.jBh = (TextView) view.findViewById(R.id.bottom_detail);
        this.jBi = (TBSpecificationBtn) view.findViewById(R.id.bottom_btn);
        this.jBj = (TextView) view.findViewById(R.id.bottom_btn_text);
        this.epr.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13742").aj("obj_source", 3).aj("obj_type", 3));
                q.bem().m36if(false);
                MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2921461));
            }
        });
        this.jBe.setItemClickListener(new MaxSignItemView.a() { // from class: com.baidu.tieba.homepage.personalize.view.e.2
            @Override // com.baidu.tbadk.widget.mission.MaxSignItemView.a
            public void b(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
                e.this.d(activeCenterStatusData);
            }
        });
        this.jBi.setOnClickListener(new View.OnClickListener() { // from class: com.baidu.tieba.homepage.personalize.view.e.3
            @Override // android.view.View.OnClickListener
            public void onClick(View view2) {
                TiebaStatic.log(new aq("c13742").aj("obj_source", 3).aj("obj_type", 2));
                q.bem().c(e.this.mTbPageContext);
            }
        });
        onChangeSkinType(this.mTbPageContext, TbadkCoreApplication.getInst().getSkinType());
    }

    @Override // com.baidu.tieba.card.b
    public void onChangeSkinType(TbPageContext<?> tbPageContext, int i) {
        if (this.mSkinType != i) {
            bqd();
        }
        this.mSkinType = i;
    }

    private void bqd() {
        SvgManager.boN().a(this.jAY, R.drawable.ic_pic_mask_taskcenter_svg, SvgManager.SvgResourceStateType.NORMAL);
        ap.setViewTextColor(this.jAZ, R.color.cp_cont_b);
        ap.setBackgroundColor(this.jBa, R.color.cp_other_g);
        ap.setBackgroundColor(this.jBb, R.color.cp_other_h);
        ap.setViewTextColor(this.jBc, R.color.cp_btn_a);
        ap.setViewTextColor(this.jBd, R.color.cp_btn_a);
        ap.setBackgroundColor(this.jBf, R.color.cp_bg_line_k);
        ap.setViewTextColor(this.jBg, R.color.cp_cont_b);
        ap.setViewTextColor(this.jBh, R.color.cp_cont_d);
        ap.setViewTextColor(this.jBj, R.color.cp_cont_d);
        this.jBe.onChangeSkinType(TbadkCoreApplication.getInst().getSkinType());
        SvgManager.boN().a(this.epr, R.drawable.icon_pure_close12_n_svg, R.color.cp_cont_g, SvgManager.SvgResourceStateType.NORMAL_PRESS);
    }

    @Override // com.baidu.tieba.card.b
    public int getLayout() {
        return R.layout.layout_home_page_item_mission_entrance;
    }

    /* JADX DEBUG: Method merged with bridge method */
    @Override // com.baidu.tieba.card.b
    public void a(com.baidu.tieba.homepage.personalize.data.g gVar) {
        this.emy = gVar.bep();
        if (this.emy != null) {
            this.jAZ.setText(R.string.mission_entrance_header_title);
            this.jBc.setText(at.cutChineseAndEnglishWithSuffix(this.emy.win_title, 14, StringHelper.STRING_MORE));
            this.jBd.setText(at.cutChineseAndEnglishWithSuffix(this.emy.win_desc, 30, StringHelper.STRING_MORE));
            this.jBe.setData(this.emy);
            d(this.emy.getTodayMissionStatus());
            bqd();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(ActiveCenterData.ActiveCenterStatusData activeCenterStatusData) {
        if (this.emy != null && this.emy.mission != null && activeCenterStatusData != null) {
            this.jBf.setAllCornerRound(l.getDimens(TbadkCoreApplication.getInst(), R.dimen.tbds21));
            String str = activeCenterStatusData.mission;
            TextView textView = this.jBg;
            if (str == null) {
                str = "";
            }
            textView.setText(str);
            String str2 = activeCenterStatusData.desc;
            TextView textView2 = this.jBh;
            if (str2 == null) {
                str2 = "";
            }
            textView2.setText(str2);
            if (activeCenterStatusData.is_today_mission == 0) {
                this.jBi.setVisibility(0);
                this.jBj.setVisibility(8);
                if (activeCenterStatusData.is_completed) {
                    this.jBi.setText("已完成");
                    this.jBi.setClickable(false);
                    this.jBi.setEnabled(false);
                } else {
                    this.jBi.setText("已过期");
                    this.jBi.setClickable(false);
                    this.jBi.setEnabled(false);
                }
            } else if (activeCenterStatusData.is_today_mission == 1) {
                this.jBi.setVisibility(0);
                this.jBj.setVisibility(8);
                if (this.emy.mission.task_type == 13) {
                    if (activeCenterStatusData.is_completed) {
                        this.jBi.setText("去领取");
                        this.jBi.setClickable(true);
                        this.jBi.setEnabled(true);
                    } else {
                        this.jBi.setText("未达标");
                        this.jBi.setClickable(false);
                        this.jBi.setEnabled(false);
                    }
                } else {
                    if (this.emy.mission.task_type == 6) {
                        if (q.bem().bev().areNotificationsEnabled()) {
                            activeCenterStatusData.is_completed = true;
                        } else {
                            activeCenterStatusData.is_completed = false;
                        }
                    }
                    if (activeCenterStatusData.is_completed) {
                        this.jBi.setText("已完成");
                        this.jBi.setClickable(false);
                        this.jBi.setEnabled(false);
                    } else {
                        this.jBi.setText("去完成");
                        this.jBi.setClickable(true);
                        this.jBi.setEnabled(true);
                    }
                }
            } else {
                this.jBi.setVisibility(8);
                this.jBj.setVisibility(0);
                this.jBj.setText("未开始");
            }
            com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
            aVar.pY(R.color.cp_cont_h);
            aVar.pV(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28));
            this.jBi.setConfig(aVar);
            this.jBi.setTextSize(R.dimen.tbds34);
        }
    }
}
