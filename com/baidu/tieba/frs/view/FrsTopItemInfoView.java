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
import com.baidu.searchbox.unitedscheme.SchemeCollecter;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.UniversityEvaluationConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.SerializableItemInfo;
import com.baidu.tieba.view.RoundRelativeLayout;
import java.util.List;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes9.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView eax;
    private ItemInfo hHP;
    private ForumWriteData hLG;
    private TextView ifA;
    private ImageView ifB;
    private double ifC;
    private double ifD;
    private View.OnClickListener ifN;
    private TextView ifr;
    private View ifs;
    private TextView ift;
    private TextView ifu;
    private TextView ifv;
    private ItemTableView ifw;
    private TextView ifx;
    private RoundRelativeLayout ify;
    private HeadImageView ifz;
    private View mBottomLine;
    private Context mContext;
    private static final String ifE = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String ifF = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int ifG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int eNE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12);
    private static final int ifH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds14);
    private static final int ifI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int ifJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int ifK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int ifL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30);
    private static final int gTt = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int ifM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds124);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ifN = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (be.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.hLG);
                    if (FrsTopItemInfoView.this.hHP != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.hHP));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.hHP.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.ifr = (TextView) findViewById(R.id.item_title_name);
        this.ifs = findViewById(R.id.item_split);
        this.ift = (TextView) findViewById(R.id.item_title_value);
        this.ifu = (TextView) findViewById(R.id.big_score);
        this.ifv = (TextView) findViewById(R.id.people_num);
        this.ifw = (ItemTableView) findViewById(R.id.item_table);
        this.ifx = (TextView) findViewById(R.id.time_score);
        this.ify = (RoundRelativeLayout) findViewById(R.id.evaluate_container);
        this.ifz = (HeadImageView) findViewById(R.id.user_head);
        this.ifA = (TextView) findViewById(R.id.click_tip);
        this.eax = (RankStarView) findViewById(R.id.star_view);
        this.ifB = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.ifr.setText(R.string.frs_evaluate_item_title);
        this.ifA.setText(R.string.frs_evaluate_click_tip);
        this.ifu.setTextSize(0, gTt);
        this.ifu.setText(R.string.frs_evaluate_exception);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifu.getLayoutParams();
        layoutParams.topMargin = ifK;
        layoutParams.height = gTt;
        this.ifu.setLayoutParams(layoutParams);
        if (com.baidu.tbadk.core.util.g.aWc()) {
            this.ifu.setPadding(0, -ifG, 0, 0);
        }
        this.ify.setRoundLayoutRadius(new float[]{ifL, ifL, ifL, ifL, ifL, ifL, ifL, ifL});
        this.ifz.setPlaceHolder(1);
        this.eax.setStarSpacing(ifJ);
        this.ify.setOnClickListener(this.ifN);
    }

    public void setData(ItemInfo itemInfo) {
        this.hHP = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.ift.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if (SchemeCollecter.CLASSIFY_ALL.equals(itemPoint.time_intval)) {
                            this.ifC = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.ifD = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.ifz.startLoad(currentPortrait, 12, false);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ifu.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ifv.getLayoutParams();
            if (this.ifC <= 0.0d || this.ifC > 10.0d) {
                this.ifu.setText(R.string.frs_evaluate_exception);
                this.ifu.setTextSize(0, gTt);
                layoutParams.topMargin = ifK;
                layoutParams.height = gTt;
                this.ifu.setLayoutParams(layoutParams);
                layoutParams2.topMargin = ifI;
                layoutParams2.addRule(5, R.id.big_score);
                this.ifv.setGravity(17);
                this.ifv.setLayoutParams(layoutParams2);
                this.ifv.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.eax.setStarCount(0);
                this.ifx.setVisibility(8);
                this.ifw.clear();
                return;
            }
            this.ifu.setText(this.ifC + "");
            this.ifu.setTextSize(0, ifM);
            layoutParams.topMargin = eNE;
            layoutParams.height = ifM;
            this.ifu.setLayoutParams(layoutParams);
            layoutParams2.topMargin = ifH;
            layoutParams2.addRule(5, R.id.big_score);
            this.ifv.setGravity(17);
            this.ifv.setLayoutParams(layoutParams2);
            this.ifv.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{ar.cn(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.eax.setStarCount(itemTable.comment_star.intValue());
            }
            this.ifx.setVisibility(0);
            this.ifx.setText(s(this.ifD), TextView.BufferType.SPANNABLE);
            this.ifw.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder s(double d) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ifF);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(d + ifE);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(an.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void onChangeSkinType() {
        an.setBackgroundColor(this, R.color.cp_bg_line_d);
        an.setViewTextColor(this.ifr, R.color.cp_cont_b, 1);
        an.setBackgroundColor(this.ifs, R.color.cp_cont_d);
        an.setViewTextColor(this.ift, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.ifu, R.color.cp_cont_b, 1);
        an.setViewTextColor(this.ifv, R.color.cp_cont_b, 1);
        this.ifw.onChangeSkinType();
        this.ifx.setText(s(this.ifD));
        an.setBackgroundColor(this.ify, R.color.cp_bg_line_g);
        an.setViewTextColor(this.ifA, R.color.cp_cont_j, 1);
        this.eax.aYW();
        SvgManager.aWQ().a(this.ifB, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        an.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_b);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.hLG = forumWriteData;
    }
}
