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
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.as;
import com.baidu.tbadk.core.util.bf;
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
/* loaded from: classes16.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView egI;
    private ItemInfo hNO;
    private ForumWriteData hRF;
    private HeadImageView ilA;
    private TextView ilB;
    private ImageView ilC;
    private double ilD;
    private double ilE;
    private View.OnClickListener ilO;
    private View.OnClickListener ilP;
    private TextView ilr;
    private View ils;
    private TextView ilt;
    private ImageView ilu;
    private TextView ilv;
    private TextView ilw;
    private ItemTableView ilx;
    private TextView ily;
    private RoundRelativeLayout ilz;
    private View mBottomLine;
    private Context mContext;
    private static final String ilF = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String ilG = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int ilH = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int eTZ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12);
    private static final int ilI = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds14);
    private static final int ilJ = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int ilK = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int ilL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int ilM = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30);
    private static final int gYY = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int ilN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds124);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.ilO = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bf.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.hRF);
                    if (FrsTopItemInfoView.this.hNO != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.hNO));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.hNO.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        this.ilP = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.xl(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).aYL();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.ilr = (TextView) findViewById(R.id.item_title_name);
        this.ils = findViewById(R.id.item_split);
        this.ilt = (TextView) findViewById(R.id.item_title_value);
        this.ilu = (ImageView) findViewById(R.id.icon_question);
        this.ilu.setOnClickListener(this.ilP);
        this.ilv = (TextView) findViewById(R.id.big_score);
        this.ilw = (TextView) findViewById(R.id.people_num);
        this.ilx = (ItemTableView) findViewById(R.id.item_table);
        this.ily = (TextView) findViewById(R.id.time_score);
        this.ilz = (RoundRelativeLayout) findViewById(R.id.evaluate_container);
        this.ilA = (HeadImageView) findViewById(R.id.user_head);
        this.ilB = (TextView) findViewById(R.id.click_tip);
        this.egI = (RankStarView) findViewById(R.id.star_view);
        this.ilC = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.ilr.setText(R.string.frs_evaluate_item_title);
        this.ilB.setText(R.string.frs_evaluate_click_tip);
        this.ilv.setTextSize(0, gYY);
        this.ilv.setText(R.string.frs_evaluate_exception);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilv.getLayoutParams();
        layoutParams.topMargin = ilL;
        layoutParams.height = gYY;
        this.ilv.setLayoutParams(layoutParams);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.ilv.setPadding(0, -ilH, 0, 0);
        }
        this.ilz.setRoundLayoutRadius(new float[]{ilM, ilM, ilM, ilM, ilM, ilM, ilM, ilM});
        this.ilA.setPlaceHolder(1);
        this.egI.setStarSpacing(ilK);
        this.ilz.setOnClickListener(this.ilO);
    }

    public void setData(ItemInfo itemInfo) {
        this.hNO = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.ilt.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if (SchemeCollecter.CLASSIFY_ALL.equals(itemPoint.time_intval)) {
                            this.ilD = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.ilE = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.ilA.startLoad(currentPortrait, 12, false);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.ilv.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.ilw.getLayoutParams();
            if (this.ilD <= 0.0d || this.ilD > 10.0d) {
                this.ilv.setText(R.string.frs_evaluate_exception);
                this.ilv.setTextSize(0, gYY);
                layoutParams.topMargin = ilL;
                layoutParams.height = gYY;
                this.ilv.setLayoutParams(layoutParams);
                layoutParams2.topMargin = ilJ;
                layoutParams2.addRule(5, R.id.big_score);
                this.ilw.setGravity(17);
                this.ilw.setLayoutParams(layoutParams2);
                this.ilw.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.egI.setStarCount(0);
                this.ily.setVisibility(8);
                this.ilx.clear();
                return;
            }
            this.ilv.setText(this.ilD + "");
            this.ilv.setTextSize(0, ilN);
            layoutParams.topMargin = eTZ;
            layoutParams.height = ilN;
            this.ilv.setLayoutParams(layoutParams);
            layoutParams2.topMargin = ilI;
            layoutParams2.addRule(5, R.id.big_score);
            this.ilw.setGravity(17);
            this.ilw.setLayoutParams(layoutParams2);
            this.ilw.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{as.cG(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.egI.setStarCount(itemTable.comment_star.intValue());
            }
            this.ily.setVisibility(0);
            this.ily.setText(s(this.ilE), TextView.BufferType.SPANNABLE);
            this.ilx.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder s(double d) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(ilG);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(d + ilF);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ao.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void onChangeSkinType() {
        ao.setBackgroundColor(this, R.color.cp_bg_line_d);
        ao.setViewTextColor(this.ilr, R.color.cp_cont_b, 1);
        ao.setBackgroundColor(this.ils, R.color.cp_cont_d);
        ao.setViewTextColor(this.ilt, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.ilv, R.color.cp_cont_b, 1);
        ao.setViewTextColor(this.ilw, R.color.cp_cont_b, 1);
        this.ilx.onChangeSkinType();
        this.ily.setText(s(this.ilE));
        ao.setBackgroundColor(this.ilz, R.color.cp_bg_line_g);
        ao.setViewTextColor(this.ilB, R.color.cp_cont_j, 1);
        this.egI.bcT();
        SvgManager.baR().a(this.ilC, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ao.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_b);
        SvgManager.baR().a(this.ilu, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.hRF = forumWriteData;
    }
}
