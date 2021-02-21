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
import com.baidu.tbadk.core.util.ap;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.bh;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes2.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int gdQ;
    private TbImageView iMD;
    private TbCornersImageView iME;
    private ImageView iMF;
    private TextView iMG;
    private TBSpecificationBtn iMH;
    private f iMI;
    private boolean iMJ;
    private float iMK;
    private float iML;
    private float iMM;
    private float iMN;
    private float iMO;
    private float iMP;
    private float iMQ;
    private float iMR;
    private int iMS;
    private boolean iMT;
    private a iMU;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iMJ = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iMJ = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iMJ = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.iMD = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.iME = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.iMF = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.iMG = (TextView) findViewById(R.id.cell_forum_test_des);
        this.iMH = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.iMH.setTextSize(R.dimen.tbds42);
        this.iMH.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.iME.setCornerTopLeftRadius(dimens);
        this.iMD.setRadius(dimens);
        this.iMD.setConrers(3);
        this.iMD.setPlaceHolder(3);
        this.iMD.setDrawCorner(true);
        this.gdQ = l.getDimens(context, R.dimen.tbds262);
        this.iMF.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.iMT) {
            this.iMD.getLayoutParams().height = this.mHeight - this.gdQ;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.iMF.setVisibility(0);
        } else {
            this.iMF.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.iMS = i;
    }

    public int getDataIndex() {
        return this.iMS;
    }

    public void setViewLeft(float f) {
        this.iMK = f;
    }

    public float getViewLeft() {
        return this.iMK;
    }

    public void setViewTop(float f) {
        this.iML = f;
    }

    public float getViewTop() {
        return this.iML;
    }

    public void setViewRight(float f) {
        this.iMM = f;
    }

    public float getViewRight() {
        return this.iMM;
    }

    public void setViewBottom(float f) {
        this.iMN = f;
    }

    public float getViewBottom() {
        return this.iMN;
    }

    public void setMoveLeft(float f) {
        this.iMO = f;
    }

    public float getMoveLeft() {
        return this.iMO;
    }

    public void setMoveTop(float f) {
        this.iMP = f;
    }

    public float getMoveTop() {
        return this.iMP;
    }

    public void setMoveRight(float f) {
        this.iMQ = f;
    }

    public float getMoveRight() {
        return this.iMQ;
    }

    public void setMoveBottom(float f) {
        this.iMR = f;
    }

    public float getMoveBottom() {
        return this.iMR;
    }

    public void setIsScale(boolean z) {
        this.iMT = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.iMU = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.iMI = fVar;
            this.iMD.startLoad(fVar.iMz ? fVar.iMA : fVar.imageUrl, 10, false);
            this.iMJ = false;
            String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("enter_forum_test_id_list", "");
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
                        this.iMJ = true;
                        break;
                    }
                }
            }
            this.iME.setVisibility(this.iMJ ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.iMG.setText(R.string.cell_forum_test_title_default);
            } else {
                this.iMG.setText(fVar.title);
            }
            this.iMH.setText(getResources().getString(fVar.iMz ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.iMI;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar a2;
        if (this.iMF == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new ar("c13373").v("uid", TbadkCoreApplication.getCurrentAccountId()).v("obj_id", this.iMI.testId));
                if (this.iMU != null) {
                    this.iMU.xL(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.iMI.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bh.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new ar("c13372").v("uid", TbadkCoreApplication.getCurrentAccountId()).v("obj_id", this.iMI.testId));
            int i = this.iMS;
            f fVar = this.iMI;
            if (this.iMI != null && i >= 0 && (a2 = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dMz().b(this.mPageId, a2);
            }
            if (!this.iMJ) {
                String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.iMI.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.brQ().putString("enter_forum_test_id_list", sb.toString());
            }
            this.iME.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.iMI.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iMD != null) {
                this.iMD.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.iMH != null) {
                this.iMH.bup();
            }
            SvgManager.bsR().a(this.iME, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.iMG.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.f.a.btv().aj(dimens).ai(dimens).oP(R.color.CAM_X0207).bv(this.iMG);
            } else {
                ((ViewGroup.MarginLayoutParams) this.iMG.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0207).pb(l.getDimens(getContext(), R.dimen.tbds10)).pc(R.color.CAM_X0804).pa(4353).pd(l.getDimens(getContext(), R.dimen.tbds10)).pe(0).pf(l.getDimens(getContext(), R.dimen.tbds5)).bv(this.iMG);
            }
            ap.setImageResource(this.iMF, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.iMG, R.color.CAM_X0105);
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
