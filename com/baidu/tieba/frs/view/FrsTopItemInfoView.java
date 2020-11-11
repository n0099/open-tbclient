package com.baidu.tieba.frs.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.data.RequestResponseCode;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UniversityEvaluationConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.at;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.view.RoundRelativeLayout;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes22.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView eSU;
    private ItemInfo iQv;
    private ForumWriteData iUj;
    private View.OnClickListener joF;
    private View.OnClickListener joG;
    private TextView joi;
    private View joj;
    private TextView jok;
    private ImageView jol;
    private TextView jom;
    private TextView jon;
    private ItemTableView joo;
    private TextView jop;
    private RoundRelativeLayout joq;
    private HeadImageView jor;
    private TextView jos;
    private ImageView jot;
    private double jou;
    private double jov;
    private View mBottomLine;
    private Context mContext;
    private static final String jow = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jox = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int joy = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int ags = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12);
    private static final int joz = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds14);
    private static final int joA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int joB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int joC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int joD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30);
    private static final int iam = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int joE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds124);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.joF = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.iUj);
                    if (FrsTopItemInfoView.this.iQv != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.iQv));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.iQv.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        this.joG = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.Bo(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).bpc();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.joi = (TextView) findViewById(R.id.item_title_name);
        this.joj = findViewById(R.id.item_split);
        this.jok = (TextView) findViewById(R.id.item_title_value);
        this.jol = (ImageView) findViewById(R.id.icon_question);
        this.jol.setOnClickListener(this.joG);
        this.jom = (TextView) findViewById(R.id.big_score);
        this.jon = (TextView) findViewById(R.id.people_num);
        this.joo = (ItemTableView) findViewById(R.id.item_table);
        this.jop = (TextView) findViewById(R.id.time_score);
        this.joq = (RoundRelativeLayout) findViewById(R.id.evaluate_container);
        this.jor = (HeadImageView) findViewById(R.id.user_head);
        this.jos = (TextView) findViewById(R.id.click_tip);
        this.eSU = (RankStarView) findViewById(R.id.star_view);
        this.jot = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.joi.setText(R.string.frs_evaluate_item_title);
        this.jos.setText(R.string.frs_evaluate_click_tip);
        this.jom.setTextSize(0, iam);
        this.jom.setText(R.string.frs_evaluate_exception);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jom.getLayoutParams();
        layoutParams.topMargin = joC;
        layoutParams.height = iam;
        this.jom.setLayoutParams(layoutParams);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.jom.setPadding(0, -joy, 0, 0);
        }
        this.joq.setRoundLayoutRadius(new float[]{joD, joD, joD, joD, joD, joD, joD, joD});
        this.jor.setPlaceHolder(1);
        this.eSU.setStarSpacing(joB);
        this.joq.setOnClickListener(this.joF);
    }

    public void setData(ItemInfo itemInfo) {
        this.iQv = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.jok.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jou = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jov = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jor.startLoad(currentPortrait, 12, false);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jom.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jon.getLayoutParams();
            if (this.jou <= 0.0d || this.jou > 10.0d) {
                this.jom.setText(R.string.frs_evaluate_exception);
                this.jom.setTextSize(0, iam);
                layoutParams.topMargin = joC;
                layoutParams.height = iam;
                this.jom.setLayoutParams(layoutParams);
                layoutParams2.topMargin = joA;
                layoutParams2.addRule(5, R.id.big_score);
                this.jon.setGravity(17);
                this.jon.setLayoutParams(layoutParams2);
                this.jon.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.eSU.setStarCount(0);
                this.jop.setVisibility(8);
                this.joo.clear();
                return;
            }
            this.jom.setText(this.jou + "");
            this.jom.setTextSize(0, joE);
            layoutParams.topMargin = ags;
            layoutParams.height = joE;
            this.jom.setLayoutParams(layoutParams);
            layoutParams2.topMargin = joz;
            layoutParams2.addRule(5, R.id.big_score);
            this.jon.setGravity(17);
            this.jon.setLayoutParams(layoutParams2);
            this.jon.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{at.dy(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.eSU.setStarCount(itemTable.comment_star.intValue());
            }
            this.jop.setVisibility(0);
            this.jop.setText(C(this.jov), TextView.BufferType.SPANNABLE);
            this.joo.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder C(double d) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(jox);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(d + jow);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.joi, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.joj, R.color.cp_cont_d);
        ap.setViewTextColor(this.jok, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.jom, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.jon, R.color.cp_cont_b, 1);
        this.joo.onChangeSkinType();
        this.jop.setText(C(this.jov));
        ap.setBackgroundColor(this.joq, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.jos, R.color.cp_cont_j, 1);
        this.eSU.bto();
        SvgManager.brn().a(this.jot, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_b);
        SvgManager.brn().a(this.jol, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.iUj = forumWriteData;
    }
}
