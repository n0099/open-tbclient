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
    private RankStarView eNf;
    private ItemInfo iKy;
    private ForumWriteData iOm;
    private View.OnClickListener jiH;
    private View.OnClickListener jiI;
    private TextView jik;
    private View jil;
    private TextView jim;
    private ImageView jin;
    private TextView jio;
    private TextView jip;
    private ItemTableView jiq;
    private TextView jir;
    private RoundRelativeLayout jis;
    private HeadImageView jit;
    private TextView jiu;
    private ImageView jiv;
    private double jiw;
    private double jix;
    private View mBottomLine;
    private Context mContext;
    private static final String jiy = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jiz = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int jiA = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int ags = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds12);
    private static final int jiB = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds14);
    private static final int jiC = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int jiD = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds24);
    private static final int jiE = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int jiF = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds30);
    private static final int hUp = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);
    private static final int jiG = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds124);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jiH = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bg.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.iOm);
                    if (FrsTopItemInfoView.this.iKy != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.iKy));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.iKy.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        this.jiI = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.Ba(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).bmC();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.jik = (TextView) findViewById(R.id.item_title_name);
        this.jil = findViewById(R.id.item_split);
        this.jim = (TextView) findViewById(R.id.item_title_value);
        this.jin = (ImageView) findViewById(R.id.icon_question);
        this.jin.setOnClickListener(this.jiI);
        this.jio = (TextView) findViewById(R.id.big_score);
        this.jip = (TextView) findViewById(R.id.people_num);
        this.jiq = (ItemTableView) findViewById(R.id.item_table);
        this.jir = (TextView) findViewById(R.id.time_score);
        this.jis = (RoundRelativeLayout) findViewById(R.id.evaluate_container);
        this.jit = (HeadImageView) findViewById(R.id.user_head);
        this.jiu = (TextView) findViewById(R.id.click_tip);
        this.eNf = (RankStarView) findViewById(R.id.star_view);
        this.jiv = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.jik.setText(R.string.frs_evaluate_item_title);
        this.jiu.setText(R.string.frs_evaluate_click_tip);
        this.jio.setTextSize(0, hUp);
        this.jio.setText(R.string.frs_evaluate_exception);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jio.getLayoutParams();
        layoutParams.topMargin = jiE;
        layoutParams.height = hUp;
        this.jio.setLayoutParams(layoutParams);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.jio.setPadding(0, -jiA, 0, 0);
        }
        this.jis.setRoundLayoutRadius(new float[]{jiF, jiF, jiF, jiF, jiF, jiF, jiF, jiF});
        this.jit.setPlaceHolder(1);
        this.eNf.setStarSpacing(jiD);
        this.jis.setOnClickListener(this.jiH);
    }

    public void setData(ItemInfo itemInfo) {
        this.iKy = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.jim.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jiw = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jix = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jit.startLoad(currentPortrait, 12, false);
            }
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.jio.getLayoutParams();
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.jip.getLayoutParams();
            if (this.jiw <= 0.0d || this.jiw > 10.0d) {
                this.jio.setText(R.string.frs_evaluate_exception);
                this.jio.setTextSize(0, hUp);
                layoutParams.topMargin = jiE;
                layoutParams.height = hUp;
                this.jio.setLayoutParams(layoutParams);
                layoutParams2.topMargin = jiC;
                layoutParams2.addRule(5, R.id.big_score);
                this.jip.setGravity(17);
                this.jip.setLayoutParams(layoutParams2);
                this.jip.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.eNf.setStarCount(0);
                this.jir.setVisibility(8);
                this.jiq.clear();
                return;
            }
            this.jio.setText(this.jiw + "");
            this.jio.setTextSize(0, jiG);
            layoutParams.topMargin = ags;
            layoutParams.height = jiG;
            this.jio.setLayoutParams(layoutParams);
            layoutParams2.topMargin = jiB;
            layoutParams2.addRule(5, R.id.big_score);
            this.jip.setGravity(17);
            this.jip.setLayoutParams(layoutParams2);
            this.jip.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{at.dc(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.eNf.setStarCount(itemTable.comment_star.intValue());
            }
            this.jir.setVisibility(0);
            this.jir.setText(C(this.jix), TextView.BufferType.SPANNABLE);
            this.jiq.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder C(double d) {
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(jiz);
        spannableStringBuilder.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder.length(), 33);
        SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(d + jiy);
        spannableStringBuilder2.setSpan(new ForegroundColorSpan(ap.getColor(R.color.cp_cont_b)), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder2.setSpan(new StyleSpan(1), 0, spannableStringBuilder2.length(), 33);
        spannableStringBuilder.append((CharSequence) spannableStringBuilder2);
        return spannableStringBuilder;
    }

    public void onChangeSkinType() {
        ap.setBackgroundColor(this, R.color.cp_bg_line_d);
        ap.setViewTextColor(this.jik, R.color.cp_cont_b, 1);
        ap.setBackgroundColor(this.jil, R.color.cp_cont_d);
        ap.setViewTextColor(this.jim, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.jio, R.color.cp_cont_b, 1);
        ap.setViewTextColor(this.jip, R.color.cp_cont_b, 1);
        this.jiq.onChangeSkinType();
        this.jir.setText(C(this.jix));
        ap.setBackgroundColor(this.jis, R.color.cp_bg_line_g);
        ap.setViewTextColor(this.jiu, R.color.cp_cont_j, 1);
        this.eNf.bqO();
        SvgManager.boN().a(this.jiv, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.cp_bg_line_b);
        SvgManager.boN().a(this.jin, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.cp_cont_c, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.iOm = forumWriteData;
    }
}
