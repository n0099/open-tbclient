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
    private int dUB;
    private f fXA;
    private boolean fXB;
    private float fXC;
    private float fXD;
    private float fXE;
    private float fXF;
    private float fXG;
    private float fXH;
    private float fXI;
    private float fXJ;
    private int fXK;
    private boolean fXL;
    private a fXM;
    private TbImageView fXv;
    private TbCornersImageView fXw;
    private ImageView fXx;
    private TextView fXy;
    private TBSpecificationBtn fXz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fXB = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fXB = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fXB = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.fXv = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.fXw = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.fXx = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.fXy = (TextView) findViewById(R.id.cell_forum_test_des);
        this.fXz = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.fXz.setTextSize(R.dimen.tbds42);
        this.fXz.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.fXw.setCornerTopLeftRadius(dimens);
        this.fXv.setRadius(dimens);
        this.fXv.setConrers(3);
        this.fXv.setPlaceHolder(3);
        this.fXv.setDrawCorner(true);
        this.dUB = l.getDimens(context, R.dimen.tbds262);
        this.fXx.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.fXL) {
            this.fXv.getLayoutParams().height = this.mHeight - this.dUB;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.fXx.setVisibility(0);
        } else {
            this.fXx.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.fXK = i;
    }

    public int getDataIndex() {
        return this.fXK;
    }

    public void setViewLeft(float f) {
        this.fXC = f;
    }

    public float getViewLeft() {
        return this.fXC;
    }

    public void setViewTop(float f) {
        this.fXD = f;
    }

    public float getViewTop() {
        return this.fXD;
    }

    public void setViewRight(float f) {
        this.fXE = f;
    }

    public float getViewRight() {
        return this.fXE;
    }

    public void setViewBottom(float f) {
        this.fXF = f;
    }

    public float getViewBottom() {
        return this.fXF;
    }

    public void setMoveLeft(float f) {
        this.fXG = f;
    }

    public float getMoveLeft() {
        return this.fXG;
    }

    public void setMoveTop(float f) {
        this.fXH = f;
    }

    public float getMoveTop() {
        return this.fXH;
    }

    public void setMoveRight(float f) {
        this.fXI = f;
    }

    public float getMoveRight() {
        return this.fXI;
    }

    public void setMoveBottom(float f) {
        this.fXJ = f;
    }

    public float getMoveBottom() {
        return this.fXJ;
    }

    public void setIsScale(boolean z) {
        this.fXL = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.fXM = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.fXA = fVar;
            this.fXv.startLoad(fVar.fXr ? fVar.fXs : fVar.imageUrl, 10, false);
            this.fXB = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("enter_forum_test_id_list", "");
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
                        this.fXB = true;
                        break;
                    }
                }
            }
            this.fXw.setVisibility(this.fXB ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.fXy.setText(R.string.cell_forum_test_title_default);
            } else {
                this.fXy.setText(fVar.title);
            }
            this.fXz.setText(getResources().getString(fVar.fXr ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.fXA;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.fXx == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fXA.testId));
                if (this.fXM != null) {
                    this.fXM.rU(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.fXA.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fXA.testId));
            int i = this.fXK;
            f fVar = this.fXA;
            if (this.fXA != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.cKb().b(this.mPageId, a);
            }
            if (!this.fXB) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.fXA.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.aFD().putString("enter_forum_test_id_list", sb.toString());
            }
            this.fXw.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.fXA.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fXv != null) {
                this.fXv.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.fXz != null) {
                this.fXz.aHO();
            }
            SvgManager.aGC().a(this.fXw, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.fXy.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.aHb().aj(dimens).ai(dimens).kC(R.color.cp_bg_line_h).aQ(this.fXy);
            } else {
                ((ViewGroup.MarginLayoutParams) this.fXy.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.aHa().kR(R.color.cp_bg_line_h).kM(l.getDimens(getContext(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(getContext(), R.dimen.tbds10)).kP(0).kQ(l.getDimens(getContext(), R.dimen.tbds5)).aQ(this.fXy);
            }
            am.setImageResource(this.fXx, R.drawable.icon_ba_close);
            am.setViewTextColor(this.fXy, (int) R.color.cp_cont_b);
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
