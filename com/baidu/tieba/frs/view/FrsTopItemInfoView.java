package com.baidu.tieba.frs.view;

import android.app.Activity;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.WriteActivityConfig;
import com.baidu.tbadk.core.dialog.a;
import com.baidu.tbadk.core.frameworkData.IntentConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.au;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.HeadImageView;
import com.baidu.tbadk.widget.RankStarView;
import com.baidu.tieba.R;
import com.baidu.tieba.frs.ForumWriteData;
import com.baidu.tieba.frs.FrsActivity;
import com.baidu.tieba.frs.FrsTabInfoData;
import com.baidu.tieba.frs.SerializableItemInfo;
import java.util.List;
import java.util.Locale;
import tbclient.ItemInfo;
import tbclient.ItemPoint;
import tbclient.ItemTable;
/* loaded from: classes22.dex */
public class FrsTopItemInfoView extends LinearLayout {
    private RankStarView eZo;
    private TextView jCA;
    private ImageView jCB;
    private TextView jCC;
    private TextView jCD;
    private ItemTableView jCE;
    private TextView jCF;
    private RelativeLayout jCG;
    private HeadImageView jCH;
    private TextView jCI;
    private ImageView jCJ;
    private double jCK;
    private double jCL;
    private View.OnClickListener jCQ;
    private View.OnClickListener jCR;
    private TextView jCy;
    private View jCz;
    private ItemInfo jcc;
    private ForumWriteData jfT;
    private View mBottomLine;
    private Context mContext;
    private static final String jCM = TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_point);
    private static final String jCN = TbadkCoreApplication.getInst().getString(R.string.frs_last_seven_days);
    private static final int jCO = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds8);
    private static final int jhV = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds21);
    private static final int jCP = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds28);
    private static final int ilL = l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds42);

    public FrsTopItemInfoView(Context context) {
        this(context, null);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public FrsTopItemInfoView(Context context, @Nullable AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.jCQ = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                int i2;
                FrsTabInfoData frsTabInfoData;
                if (bh.checkUpIsLogin(FrsTopItemInfoView.this.mContext)) {
                    WriteActivityConfig writeActivityConfig = new WriteActivityConfig((Activity) FrsTopItemInfoView.this.mContext, 9, "0", null, null, null, 0, null, RequestResponseCode.REQUEST_WRITE_NEW, false, false, null, false, false, null, null, null, 0);
                    writeActivityConfig.getIntent().putExtra("from", "frs");
                    writeActivityConfig.getIntent().putExtra(IntentConfig.IS_EVALUATE, true);
                    writeActivityConfig.setCallFrom("2");
                    if (FrsTopItemInfoView.this.jcc != null) {
                        writeActivityConfig.setScoreItemInfo(new SerializableItemInfo(FrsTopItemInfoView.this.jcc));
                        writeActivityConfig.setItemIsSchool(FrsTopItemInfoView.this.jcc.is_school.intValue() == 1);
                        if (FrsTopItemInfoView.this.jcc.score != null) {
                            writeActivityConfig.setStarCount(FrsTopItemInfoView.this.jcc.score.comment_star.intValue());
                        }
                    }
                    writeActivityConfig.setForumLevel(-1);
                    writeActivityConfig.setForumAvatar(null);
                    writeActivityConfig.setPrivateThread(0);
                    writeActivityConfig.setForumDir("", "");
                    if (FrsTopItemInfoView.this.jfT != null) {
                        i2 = FrsTopItemInfoView.this.jfT.defaultZone;
                    } else {
                        i2 = -1;
                    }
                    writeActivityConfig.setProfessionZone(i2);
                    if (FrsTopItemInfoView.this.jfT != null) {
                        frsTabInfoData = FrsTopItemInfoView.this.jfT.frsTabInfo;
                    } else {
                        frsTabInfoData = null;
                    }
                    writeActivityConfig.setFrsTabInfo(frsTabInfoData);
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, writeActivityConfig));
                }
            }
        };
        this.jCR = new View.OnClickListener() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (FrsTopItemInfoView.this.mContext instanceof FrsActivity) {
                    final com.baidu.tbadk.core.dialog.a aVar = new com.baidu.tbadk.core.dialog.a((FrsActivity) FrsTopItemInfoView.this.mContext);
                    aVar.Bq(FrsTopItemInfoView.this.mContext.getString(R.string.comment_tab_dialog_info));
                    aVar.a(R.string.comment_tab_dialog_botton_text, new a.b() { // from class: com.baidu.tieba.frs.view.FrsTopItemInfoView.2.1
                        @Override // com.baidu.tbadk.core.dialog.a.b
                        public void onClick(com.baidu.tbadk.core.dialog.a aVar2) {
                            aVar.dismiss();
                        }
                    });
                    aVar.b(((FrsActivity) FrsTopItemInfoView.this.mContext).getPageContext()).brv();
                }
            }
        };
        initUI(context);
    }

    private void initUI(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.frs_top_item_info_view, this);
        setOrientation(1);
        this.jCy = (TextView) findViewById(R.id.item_title_name);
        this.jCz = findViewById(R.id.item_split);
        this.jCA = (TextView) findViewById(R.id.item_title_value);
        this.jCB = (ImageView) findViewById(R.id.icon_question);
        this.jCB.setOnClickListener(this.jCR);
        this.jCC = (TextView) findViewById(R.id.big_score);
        this.jCD = (TextView) findViewById(R.id.people_num);
        this.jCE = (ItemTableView) findViewById(R.id.item_table);
        this.jCF = (TextView) findViewById(R.id.time_score);
        this.jCG = (RelativeLayout) findViewById(R.id.evaluate_container);
        this.jCH = (HeadImageView) findViewById(R.id.user_head);
        this.jCI = (TextView) findViewById(R.id.click_tip);
        this.eZo = (RankStarView) findViewById(R.id.star_view);
        this.jCJ = (ImageView) findViewById(R.id.right_arrow);
        this.mBottomLine = findViewById(R.id.bottom_line);
        this.jCy.setText(R.string.frs_evaluate_item_title);
        this.jCI.setText(R.string.frs_evaluate_click_tip);
        this.jCC.setText(R.string.frs_evaluate_exception);
        if (com.baidu.tbadk.core.util.g.isXiaoMi()) {
            this.jCC.setPadding(0, -jCO, 0, 0);
        }
        this.jCH.setPlaceHolder(1);
        this.eZo.setStarSpacing(l.getDimens(TbadkCoreApplication.getInst().getContext(), R.dimen.tbds10));
        this.jCG.setOnClickListener(this.jCQ);
    }

    public void setData(ItemInfo itemInfo) {
        this.jcc = itemInfo;
        if (itemInfo != null && itemInfo.score != null) {
            this.jCA.setText(itemInfo.name);
            ItemTable itemTable = itemInfo.score;
            int intValue = itemTable.total_point_num.intValue();
            List<ItemPoint> list = itemTable.item_point;
            if (list != null) {
                for (ItemPoint itemPoint : list) {
                    if (itemPoint != null) {
                        if ("all".equals(itemPoint.time_intval)) {
                            this.jCK = itemPoint.point.doubleValue();
                        } else if ("days".equals(itemPoint.time_intval)) {
                            this.jCL = itemPoint.point.doubleValue();
                        }
                    }
                }
            }
            String currentPortrait = TbadkCoreApplication.getCurrentPortrait();
            if (currentPortrait != null) {
                this.jCH.startLoad(currentPortrait, 12, false);
            }
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.jCC.getLayoutParams();
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.jCD.getLayoutParams();
            if (this.jCK <= 0.0d || this.jCK > 10.0d) {
                this.jCC.setText(R.string.frs_evaluate_exception);
                this.jCC.setTextSize(0, ilL);
                layoutParams.topMargin = jCP;
                layoutParams.height = ilL;
                this.jCC.setLayoutParams(layoutParams);
                layoutParams2.topMargin = jhV;
                this.jCD.setGravity(17);
                this.jCD.setLayoutParams(layoutParams2);
                this.jCD.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{"0"}));
                this.eZo.setStarCount(0.0f);
                this.jCF.setVisibility(8);
                this.jCz.setVisibility(8);
                this.jCE.clear();
                return;
            }
            this.jCC.setText(String.valueOf(this.jCK));
            this.jCD.setText(TbadkCoreApplication.getInst().getString(R.string.frs_evaluate_people, new Object[]{au.dX(intValue)}));
            if (itemTable.is_commented.intValue() == 1 && itemTable.comment_star.intValue() >= 0 && itemTable.comment_star.intValue() <= 5) {
                this.eZo.setStarCount(itemTable.comment_star.intValue());
            }
            this.jCz.setVisibility(0);
            this.jCF.setVisibility(0);
            this.jCF.setText(D(this.jCL), TextView.BufferType.SPANNABLE);
            this.jCE.setData(itemTable.item_plot, intValue);
        }
    }

    private SpannableStringBuilder D(double d) {
        return new SpannableStringBuilder(String.format(Locale.CHINA, "%s %.1f%s", jCN, Double.valueOf(d), jCM));
    }

    public void onChangeSkinType() {
        com.baidu.tbadk.core.elementsMaven.c.bm(this).pA(com.baidu.tbadk.a.d.bkA() ? R.string.J_X02 : R.string.J_X06).setBackGroundColor(R.color.CAM_X0201);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCy).pu(R.string.F_X02).ps(R.color.CAM_X0105);
        ap.setBackgroundColor(this.jCz, R.color.CAM_X0109);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCA).pu(R.string.F_X02).ps(R.color.CAM_X0105);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCC).pu(R.string.F_X02).ps(R.color.CAM_X0105);
        ap.setViewTextColor(this.jCD, R.color.CAM_X0109, 1);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCF).ps(R.color.CAM_X0109).pu(R.string.F_X01);
        com.baidu.tbadk.core.elementsMaven.c.bm(this.jCI).pu(R.string.F_X01).ps(R.color.CAM_X0105);
        this.jCE.onChangeSkinType();
        this.eZo.bwe();
        SvgManager.btW().a(this.jCJ, R.drawable.ic_icon_mybar_pure_list_arrow16_right, R.color.CAM_X0108, SvgManager.SvgResourceStateType.NORMAL);
        ap.setBackgroundColor(this.mBottomLine, R.color.CAM_X0210);
        SvgManager.btW().a(this.jCB, R.drawable.ic_icon_pure_use_unknown_n_svg, R.color.CAM_X0105, SvgManager.SvgResourceStateType.NORMAL);
    }

    public void setForumWriteData(ForumWriteData forumWriteData) {
        this.jfT = forumWriteData;
    }
}
