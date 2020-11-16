package com.baidu.tieba.frs.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.text.SpannableStringBuilder;
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
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.SerializableItemInfo;
import java.util.List;
import java.util.Locale;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes21.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView eRW;
    private ItemInfo iRi;
    private ForumWriteData iUV;
    private TextView joU;
    private View joV;
    private TextView joW;
    private ImageView joX;
    private TextView joY;
    private TextView joZ;
    private ItemTableView jpa;
    private TextView jpb;
    private RelativeLayout jpc;
    private HeadImageView jpd;
    private TextView jpe;
    private ImageView jpf;
    private double jpg;
    private double jph;
    private View.OnClickListener jpn;
    private View.OnClickListener jpo;
    private View mBottomLine;
    private Context mContext;
    private static final String jpi = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jpj = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int jpk = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int jpl = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int jpm = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int iaN = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jpn = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (bh.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    UniversityEvaluationConfig universityEvaluationConfig = new UniversityEvaluationConfig(FrsTopItemInfoView.this.mContext, RequestResponseCode.REQUEST_WRITE_NEW);
                    universityEvaluationConfig.setWriteData(FrsTopItemInfoView.this.iUV);
                    if (FrsTopItemInfoView.this.iRi != null) {
                        universityEvaluationConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.iRi));
                        universityEvaluationConfig.setItemIsSchool(FrsTopItemInfoView.this.iRi.is_school.intValue() == 1);
                    }
                    MessageManager.getInstance().sendMessage(new CustomMessage(2921460, universityEvaluationConfig));
                }
            }
        };
        this.jpo = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.AJ(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).bog();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.joU = (TextView) findViewById(R.id.item_title_name);
        this.joV = findViewById(R.id.item_split);
        this.joW = (TextView) findViewById(R.id.item_title_value);
        this.joX = (ImageView) findViewById(R.id.icon_question);
        this.joX.setOnClickListener(this.jpo);
        this.joY = (TextView) findViewById(R.id.big_score);
        this.joZ = (TextView) findViewById(R.id.people_num);
        this.jpa = (ItemTableView) findViewById(R.id.item_table);
        this.jpb = (TextView) findViewById(R.id.time_score);
        this.jpc = (RelativeLayout) findViewById(R.id.evaluate_container);
        this.jpd = (HeadImageView) findViewById(R.id.user_head);
        this.jpe = (TextView) findViewById(R.id.click_tip);
        this.eRW = (RankStarView) findViewById(R.id.star_view);
        this.jpf = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.joU.setText(R.string.frs_evaluate_item_title);
        this.jpe.setText(R.string.frs_evaluate_click_tip);
        this.joY.setText(R.string.frs_evaluate_exception);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.joY.setPadding(0, -jpk, 0, 0);
        }
        this.jpd.setPlaceHolder(1);
        this.eRW.setStarSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.jpc.setOnClickListener(this.jpn);
    }

    public void setData(ItemInfo itemInfo) {
        this.iRi = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.joW.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jpg = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jph = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jpd.startLoad(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.joY.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.joZ.getLayoutParams();
            if (this.jpg <= 0.0d || this.jpg > 10.0d) {
                this.joY.setText(R.string.frs_evaluate_exception);
                this.joY.setTextSize(0, iaN);
                layoutParams.topMargin = jpm;
                layoutParams.height = iaN;
                this.joY.setLayoutParams(layoutParams);
                layoutParams2.topMargin = jpl;
                this.joZ.setGravity(17);
                this.joZ.setLayoutParams(layoutParams2);
                this.joZ.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.eRW.setStarCount(0.0f);
                this.jpb.setVisibility(8);
                this.joV.setVisibility(8);
                this.jpa.clear();
                return;
            }
            this.joY.setText(String.valueOf(this.jpg));
            this.joZ.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{au.dy(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.eRW.setStarCount(itemTable.comment_star.intValue());
            }
            this.joV.setVisibility(0);
            this.jpb.setVisibility(0);
            this.jpb.setText(C(this.jph), TextView.BufferType.SPANNABLE);
            this.jpa.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder C(double d) {
        return new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", jpj, Double.valueOf(d), jpi));
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.bj(this).pb(com.baidu.tbadk.a.d.bhw() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.joU).oV(R.string.F_X02).oT(R.color.CAM_X0105);
        ap.setBackgroundColor(this.joV, R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.joW).oV(R.string.F_X02).oT(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.joY).oV(R.string.F_X02).oT(R.color.CAM_X0105);
        ap.setViewTextColor(this.joZ, R.color.CAM_X0109, 1);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.jpb).oT(R.color.CAM_X0109).oV(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.bj(this.jpe).oV(R.string.F_X01).oT(R.color.CAM_X0105);
        this.jpa.onChangeSkinType();
        this.eRW.bsE();
        SvgManager.bqB().a(this.jpf, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0210);
        SvgManager.bqB().a(this.joX, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.iUV = forumWriteData;
    }
}
