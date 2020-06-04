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
    private int eJI;
    private TbImageView gTG;
    private TbCornersImageView gTH;
    private ImageView gTI;
    private TextView gTJ;
    private TBSpecificationBtn gTK;
    private f gTL;
    private boolean gTM;
    private float gTN;
    private float gTO;
    private float gTP;
    private float gTQ;
    private float gTR;
    private float gTS;
    private float gTT;
    private float gTU;
    private int gTV;
    private boolean gTW;
    private a gTX;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.gTM = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.gTM = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.gTM = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.gTG = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.gTH = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.gTI = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.gTJ = (TextView) findViewById(R.id.cell_forum_test_des);
        this.gTK = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.gTK.setTextSize(R.dimen.tbds42);
        this.gTK.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.gTH.setCornerTopLeftRadius(dimens);
        this.gTG.setRadius(dimens);
        this.gTG.setConrers(3);
        this.gTG.setPlaceHolder(3);
        this.gTG.setDrawCorner(true);
        this.eJI = l.getDimens(context, R.dimen.tbds262);
        this.gTI.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.gTW) {
            this.gTG.getLayoutParams().height = this.mHeight - this.eJI;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.gTI.setVisibility(0);
        } else {
            this.gTI.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.gTV = i;
    }

    public int getDataIndex() {
        return this.gTV;
    }

    public void setViewLeft(float f) {
        this.gTN = f;
    }

    public float getViewLeft() {
        return this.gTN;
    }

    public void setViewTop(float f) {
        this.gTO = f;
    }

    public float getViewTop() {
        return this.gTO;
    }

    public void setViewRight(float f) {
        this.gTP = f;
    }

    public float getViewRight() {
        return this.gTP;
    }

    public void setViewBottom(float f) {
        this.gTQ = f;
    }

    public float getViewBottom() {
        return this.gTQ;
    }

    public void setMoveLeft(float f) {
        this.gTR = f;
    }

    public float getMoveLeft() {
        return this.gTR;
    }

    public void setMoveTop(float f) {
        this.gTS = f;
    }

    public float getMoveTop() {
        return this.gTS;
    }

    public void setMoveRight(float f) {
        this.gTT = f;
    }

    public float getMoveRight() {
        return this.gTT;
    }

    public void setMoveBottom(float f) {
        this.gTU = f;
    }

    public float getMoveBottom() {
        return this.gTU;
    }

    public void setIsScale(boolean z) {
        this.gTW = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.gTX = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.gTL = fVar;
            this.gTG.startLoad(fVar.gTC ? fVar.gTD : fVar.imageUrl, 10, false);
            this.gTM = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("enter_forum_test_id_list", "");
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
                        this.gTM = true;
                        break;
                    }
                }
            }
            this.gTH.setVisibility(this.gTM ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.gTJ.setText(R.string.cell_forum_test_title_default);
            } else {
                this.gTJ.setText(fVar.title);
            }
            this.gTK.setText(getResources().getString(fVar.gTC ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.gTL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.gTI == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.gTL.testId));
                if (this.gTX != null) {
                    this.gTX.sY(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.gTL.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.gTL.testId));
            int i = this.gTV;
            f fVar = this.gTL;
            if (this.gTL != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dcI().b(this.mPageId, a);
            }
            if (!this.gTM) {
                String string = com.baidu.tbadk.core.sharedPref.b.aTX().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.gTL.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.aTX().putString("enter_forum_test_id_list", sb.toString());
            }
            this.gTH.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.gTL.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.gTG != null) {
                this.gTG.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.gTK != null) {
                this.gTK.aWr();
            }
            SvgManager.aUW().a(this.gTH, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.gTJ.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.aVw().S(dimens).R(dimens).lq(R.color.cp_bg_line_h).aR(this.gTJ);
            } else {
                ((ViewGroup.MarginLayoutParams) this.gTJ.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.aVv().lF(R.color.cp_bg_line_h).lA(l.getDimens(getContext(), R.dimen.tbds10)).lB(R.color.cp_shadow_a_alpha16).lz(4353).lC(l.getDimens(getContext(), R.dimen.tbds10)).lD(0).lE(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.gTJ);
            }
            am.setImageResource(this.gTI, R.drawable.icon_ba_close);
            am.setViewTextColor(this.gTJ, (int) R.color.cp_cont_b);
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
