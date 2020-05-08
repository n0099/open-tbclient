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
    private int euV;
    private TbImageView gEN;
    private TbCornersImageView gEO;
    private ImageView gEP;
    private TextView gEQ;
    private TBSpecificationBtn gER;
    private f gES;
    private boolean gET;
    private float gEU;
    private float gEV;
    private float gEW;
    private float gEX;
    private float gEY;
    private float gEZ;
    private float gFa;
    private float gFb;
    private int gFc;
    private boolean gFd;
    private a gFe;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gET = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gET = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gET = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.gEN = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.gEO = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.gEP = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.gEQ = (TextView) findViewById(R.id.cell_forum_test_des);
        this.gER = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.gER.setTextSize(R.dimen.tbds42);
        this.gER.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.gEO.setCornerTopLeftRadius(dimens);
        this.gEN.setRadius(dimens);
        this.gEN.setConrers(3);
        this.gEN.setPlaceHolder(3);
        this.gEN.setDrawCorner(true);
        this.euV = l.getDimens(context, R.dimen.tbds262);
        this.gEP.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.gFd) {
            this.gEN.getLayoutParams().height = this.mHeight - this.euV;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.gEP.setVisibility(0);
        } else {
            this.gEP.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.gFc = i;
    }

    public int getDataIndex() {
        return this.gFc;
    }

    public void setViewLeft(float f) {
        this.gEU = f;
    }

    public float getViewLeft() {
        return this.gEU;
    }

    public void setViewTop(float f) {
        this.gEV = f;
    }

    public float getViewTop() {
        return this.gEV;
    }

    public void setViewRight(float f) {
        this.gEW = f;
    }

    public float getViewRight() {
        return this.gEW;
    }

    public void setViewBottom(float f) {
        this.gEX = f;
    }

    public float getViewBottom() {
        return this.gEX;
    }

    public void setMoveLeft(float f) {
        this.gEY = f;
    }

    public float getMoveLeft() {
        return this.gEY;
    }

    public void setMoveTop(float f) {
        this.gEZ = f;
    }

    public float getMoveTop() {
        return this.gEZ;
    }

    public void setMoveRight(float f) {
        this.gFa = f;
    }

    public float getMoveRight() {
        return this.gFa;
    }

    public void setMoveBottom(float f) {
        this.gFb = f;
    }

    public float getMoveBottom() {
        return this.gFb;
    }

    public void setIsScale(boolean z) {
        this.gFd = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.gFe = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.gES = fVar;
            this.gEN.startLoad(fVar.gEJ ? fVar.gEK : fVar.imageUrl, 10, false);
            this.gET = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("enter_forum_test_id_list", "");
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
                        this.gET = true;
                        break;
                    }
                }
            }
            this.gEO.setVisibility(this.gET ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.gEQ.setText(R.string.cell_forum_test_title_default);
            } else {
                this.gEQ.setText(fVar.title);
            }
            this.gER.setText(getResources().getString(fVar.gEJ ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.gES;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.gEP == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").t("uid", TbadkCoreApplication.getCurrentAccountId()).t("obj_id", this.gES.testId));
                if (this.gFe != null) {
                    this.gFe.sr(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.gES.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").t("uid", TbadkCoreApplication.getCurrentAccountId()).t("obj_id", this.gES.testId));
            int i = this.gFc;
            f fVar = this.gES;
            if (this.gES != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.cVo().b(this.mPageId, a);
            }
            if (!this.gET) {
                String string = com.baidu.tbadk.core.sharedPref.b.aNT().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.gES.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.aNT().putString("enter_forum_test_id_list", sb.toString());
            }
            this.gEO.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.gES.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gEN != null) {
                this.gEN.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.gER != null) {
                this.gER.aQm();
            }
            SvgManager.aOR().a(this.gEO, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.gEQ.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.aPr().T(dimens).S(dimens).kM(R.color.cp_bg_line_h).aR(this.gEQ);
            } else {
                ((ViewGroup.MarginLayoutParams) this.gEQ.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.aPq().lb(R.color.cp_bg_line_h).kW(l.getDimens(getContext(), R.dimen.tbds10)).kX(R.color.cp_shadow_a_alpha16).kV(4353).kY(l.getDimens(getContext(), R.dimen.tbds10)).kZ(0).la(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.gEQ);
            }
            am.setImageResource(this.gEP, R.drawable.icon_ba_close);
            am.setViewTextColor(this.gEQ, (int) R.color.cp_cont_b);
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
