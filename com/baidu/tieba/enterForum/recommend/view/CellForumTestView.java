package com.baidu.tieba.enterForum.recommend.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.baidu.adp.BdUniqueId;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.util.j;
import com.baidu.adp.lib.util.l;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.ForumTestActivityConfig;
import com.baidu.tbadk.core.util.SvgManager;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.am;
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.bc;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes9.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int euQ;
    private TbImageView gEH;
    private TbCornersImageView gEI;
    private ImageView gEJ;
    private TextView gEK;
    private TBSpecificationBtn gEL;
    private f gEM;
    private boolean gEN;
    private float gEO;
    private float gEP;
    private float gEQ;
    private float gER;
    private float gES;
    private float gET;
    private float gEU;
    private float gEV;
    private int gEW;
    private boolean gEX;
    private a gEY;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gEN = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gEN = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gEN = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.gEH = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.gEI = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.gEJ = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.gEK = (TextView) findViewById(R.id.cell_forum_test_des);
        this.gEL = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.gEL.setTextSize(R.dimen.tbds42);
        this.gEL.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.gEI.setCornerTopLeftRadius(dimens);
        this.gEH.setRadius(dimens);
        this.gEH.setConrers(3);
        this.gEH.setPlaceHolder(3);
        this.gEH.setDrawCorner(true);
        this.euQ = l.getDimens(context, R.dimen.tbds262);
        this.gEJ.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.gEX) {
            this.gEH.getLayoutParams().height = this.mHeight - this.euQ;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.gEJ.setVisibility(0);
        } else {
            this.gEJ.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.gEW = i;
    }

    public int getDataIndex() {
        return this.gEW;
    }

    public void setViewLeft(float f) {
        this.gEO = f;
    }

    public float getViewLeft() {
        return this.gEO;
    }

    public void setViewTop(float f) {
        this.gEP = f;
    }

    public float getViewTop() {
        return this.gEP;
    }

    public void setViewRight(float f) {
        this.gEQ = f;
    }

    public float getViewRight() {
        return this.gEQ;
    }

    public void setViewBottom(float f) {
        this.gER = f;
    }

    public float getViewBottom() {
        return this.gER;
    }

    public void setMoveLeft(float f) {
        this.gES = f;
    }

    public float getMoveLeft() {
        return this.gES;
    }

    public void setMoveTop(float f) {
        this.gET = f;
    }

    public float getMoveTop() {
        return this.gET;
    }

    public void setMoveRight(float f) {
        this.gEU = f;
    }

    public float getMoveRight() {
        return this.gEU;
    }

    public void setMoveBottom(float f) {
        this.gEV = f;
    }

    public float getMoveBottom() {
        return this.gEV;
    }

    public void setIsScale(boolean z) {
        this.gEX = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.gEY = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.gEM = fVar;
            this.gEH.startLoad(fVar.gED ? fVar.gEE : fVar.imageUrl, 10, false);
            this.gEN = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("enter_forum_test_id_list", "");
            String[] split = string.split("[|]");
            if (!StringUtils.isNull(string)) {
                int length = split.length;
                int i = 0;
                while (true) {
                    if (i >= length) {
                        break;
                    }
                    String str = split[i];
                    if (StringUtils.isNull(str) || !str.equals(fVar.testId + "*" + TbadkCoreApplication.getCurrentAccountId())) {
                        i++;
                    } else {
                        this.gEN = true;
                        break;
                    }
                }
            }
            this.gEI.setVisibility(this.gEN ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.gEK.setText(R.string.cell_forum_test_title_default);
            } else {
                this.gEK.setText(fVar.title);
            }
            this.gEL.setText(getResources().getString(fVar.gED ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.gEM;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.gEJ == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").t("uid", TbadkCoreApplication.getCurrentAccountId()).t("obj_id", this.gEM.testId));
                if (this.gEY != null) {
                    this.gEY.sr(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.gEM.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").t("uid", TbadkCoreApplication.getCurrentAccountId()).t("obj_id", this.gEM.testId));
            int i = this.gEW;
            f fVar = this.gEM;
            if (this.gEM != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.cVr().b(this.mPageId, a);
            }
            if (!this.gEN) {
                String string = com.baidu.tbadk.core.sharedPref.b.aNV().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.gEM.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
                StringBuilder sb = new StringBuilder();
                if (split.length < 20) {
                    sb.append(string).append("|").append(str);
                } else {
                    int i2 = 0;
                    for (String str2 : split) {
                        if (i2 != 0) {
                            sb.append(str2).append("|");
                        }
                        i2++;
                    }
                    sb.append(str);
                }
                com.baidu.tbadk.core.sharedPref.b.aNV().putString("enter_forum_test_id_list", sb.toString());
            }
            this.gEI.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.gEM.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gEH != null) {
                this.gEH.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.gEL != null) {
                this.gEL.aQp();
            }
            SvgManager.aOU().a(this.gEI, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.gEK.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.aPu().T(dimens).S(dimens).kM(R.color.cp_bg_line_h).aR(this.gEK);
            } else {
                ((ViewGroup.MarginLayoutParams) this.gEK.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.aPt().lb(R.color.cp_bg_line_h).kW(l.getDimens(getContext(), R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kV(4353).kY(l.getDimens(getContext(), R.dimen.tbds10)).kZ(0).la(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.gEK);
            }
            am.setImageResource(this.gEJ, R.drawable.icon_ba_close);
            am.setViewTextColor(this.gEK, (int) R.color.cp_cont_b);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }

    public void setPageId(BdUniqueId bdUniqueId) {
        this.mPageId = bdUniqueId;
    }
}
