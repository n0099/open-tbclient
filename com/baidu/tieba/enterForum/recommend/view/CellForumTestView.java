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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes2.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int gbw;
    private TbImageView iGG;
    private TbCornersImageView iGH;
    private ImageView iGI;
    private TextView iGJ;
    private TBSpecificationBtn iGK;
    private f iGL;
    private boolean iGM;
    private float iGN;
    private float iGO;
    private float iGP;
    private float iGQ;
    private float iGR;
    private float iGS;
    private float iGT;
    private float iGU;
    private int iGV;
    private boolean iGW;
    private a iGX;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iGM = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iGM = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iGM = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.iGG = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.iGH = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.iGI = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.iGJ = (TextView) findViewById(R.id.cell_forum_test_des);
        this.iGK = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.iGK.setTextSize(R.dimen.tbds42);
        this.iGK.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.iGH.setCornerTopLeftRadius(dimens);
        this.iGG.setRadius(dimens);
        this.iGG.setConrers(3);
        this.iGG.setPlaceHolder(3);
        this.iGG.setDrawCorner(true);
        this.gbw = l.getDimens(context, R.dimen.tbds262);
        this.iGI.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.iGW) {
            this.iGG.getLayoutParams().height = this.mHeight - this.gbw;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.iGI.setVisibility(0);
        } else {
            this.iGI.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.iGV = i;
    }

    public int getDataIndex() {
        return this.iGV;
    }

    public void setViewLeft(float f) {
        this.iGN = f;
    }

    public float getViewLeft() {
        return this.iGN;
    }

    public void setViewTop(float f) {
        this.iGO = f;
    }

    public float getViewTop() {
        return this.iGO;
    }

    public void setViewRight(float f) {
        this.iGP = f;
    }

    public float getViewRight() {
        return this.iGP;
    }

    public void setViewBottom(float f) {
        this.iGQ = f;
    }

    public float getViewBottom() {
        return this.iGQ;
    }

    public void setMoveLeft(float f) {
        this.iGR = f;
    }

    public float getMoveLeft() {
        return this.iGR;
    }

    public void setMoveTop(float f) {
        this.iGS = f;
    }

    public float getMoveTop() {
        return this.iGS;
    }

    public void setMoveRight(float f) {
        this.iGT = f;
    }

    public float getMoveRight() {
        return this.iGT;
    }

    public void setMoveBottom(float f) {
        this.iGU = f;
    }

    public float getMoveBottom() {
        return this.iGU;
    }

    public void setIsScale(boolean z) {
        this.iGW = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.iGX = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.iGL = fVar;
            this.iGG.startLoad(fVar.iGC ? fVar.iGD : fVar.imageUrl, 10, false);
            this.iGM = false;
            String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("enter_forum_test_id_list", "");
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
                        this.iGM = true;
                        break;
                    }
                }
            }
            this.iGH.setVisibility(this.iGM ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.iGJ.setText(R.string.cell_forum_test_title_default);
            } else {
                this.iGJ.setText(fVar.title);
            }
            this.iGK.setText(getResources().getString(fVar.iGC ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.iGL;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq a2;
        if (this.iGI == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new aq("c13373").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.iGL.testId));
                if (this.iGX != null) {
                    this.iGX.xB(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.iGL.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bg.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new aq("c13372").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.iGL.testId));
            int i = this.iGV;
            f fVar = this.iGL;
            if (this.iGL != null && i >= 0 && (a2 = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dKg().b(this.mPageId, a2);
            }
            if (!this.iGM) {
                String string = com.baidu.tbadk.core.sharedPref.b.brx().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.iGL.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.brx().putString("enter_forum_test_id_list", sb.toString());
            }
            this.iGH.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.iGL.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iGG != null) {
                this.iGG.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.iGK != null) {
                this.iGK.btV();
            }
            SvgManager.bsx().a(this.iGH, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.iGJ.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.f.a.btb().ai(dimens).ah(dimens).oK(R.color.CAM_X0207).bz(this.iGJ);
            } else {
                ((ViewGroup.MarginLayoutParams) this.iGJ.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.f.a.bta().pb(R.color.CAM_X0207).oW(l.getDimens(getContext(), R.dimen.tbds10)).oX(R.color.CAM_X0804).oV(4353).oY(l.getDimens(getContext(), R.dimen.tbds10)).oZ(0).pa(l.getDimens(getContext(), R.dimen.tbds5)).bz(this.iGJ);
            }
            ao.setImageResource(this.iGI, R.drawable.icon_ba_close);
            ao.setViewTextColor(this.iGJ, R.color.CAM_X0105);
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
