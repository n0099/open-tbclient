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
    private int ggf;
    private float iLA;
    private float iLB;
    private int iLC;
    private boolean iLD;
    private a iLE;
    private TbImageView iLn;
    private TbCornersImageView iLo;
    private ImageView iLp;
    private TextView iLq;
    private TBSpecificationBtn iLr;
    private f iLs;
    private boolean iLt;
    private float iLu;
    private float iLv;
    private float iLw;
    private float iLx;
    private float iLy;
    private float iLz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iLt = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iLt = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iLt = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.iLn = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.iLo = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.iLp = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.iLq = (TextView) findViewById(R.id.cell_forum_test_des);
        this.iLr = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.iLr.setTextSize(R.dimen.tbds42);
        this.iLr.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.iLo.setCornerTopLeftRadius(dimens);
        this.iLn.setRadius(dimens);
        this.iLn.setConrers(3);
        this.iLn.setPlaceHolder(3);
        this.iLn.setDrawCorner(true);
        this.ggf = l.getDimens(context, R.dimen.tbds262);
        this.iLp.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.iLD) {
            this.iLn.getLayoutParams().height = this.mHeight - this.ggf;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.iLp.setVisibility(0);
        } else {
            this.iLp.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.iLC = i;
    }

    public int getDataIndex() {
        return this.iLC;
    }

    public void setViewLeft(float f) {
        this.iLu = f;
    }

    public float getViewLeft() {
        return this.iLu;
    }

    public void setViewTop(float f) {
        this.iLv = f;
    }

    public float getViewTop() {
        return this.iLv;
    }

    public void setViewRight(float f) {
        this.iLw = f;
    }

    public float getViewRight() {
        return this.iLw;
    }

    public void setViewBottom(float f) {
        this.iLx = f;
    }

    public float getViewBottom() {
        return this.iLx;
    }

    public void setMoveLeft(float f) {
        this.iLy = f;
    }

    public float getMoveLeft() {
        return this.iLy;
    }

    public void setMoveTop(float f) {
        this.iLz = f;
    }

    public float getMoveTop() {
        return this.iLz;
    }

    public void setMoveRight(float f) {
        this.iLA = f;
    }

    public float getMoveRight() {
        return this.iLA;
    }

    public void setMoveBottom(float f) {
        this.iLB = f;
    }

    public float getMoveBottom() {
        return this.iLB;
    }

    public void setIsScale(boolean z) {
        this.iLD = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.iLE = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.iLs = fVar;
            this.iLn.startLoad(fVar.iLj ? fVar.iLk : fVar.imageUrl, 10, false);
            this.iLt = false;
            String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("enter_forum_test_id_list", "");
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
                        this.iLt = true;
                        break;
                    }
                }
            }
            this.iLo.setVisibility(this.iLt ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.iLq.setText(R.string.cell_forum_test_title_default);
            } else {
                this.iLq.setText(fVar.title);
            }
            this.iLr.setText(getResources().getString(fVar.iLj ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.iLs;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq a2;
        if (this.iLp == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new aq("c13373").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.iLs.testId));
                if (this.iLE != null) {
                    this.iLE.zh(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.iLs.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bg.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new aq("c13372").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.iLs.testId));
            int i = this.iLC;
            f fVar = this.iLs;
            if (this.iLs != null && i >= 0 && (a2 = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dNX().b(this.mPageId, a2);
            }
            if (!this.iLt) {
                String string = com.baidu.tbadk.core.sharedPref.b.bvq().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.iLs.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.bvq().putString("enter_forum_test_id_list", sb.toString());
            }
            this.iLo.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.iLs.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iLn != null) {
                this.iLn.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.iLr != null) {
                this.iLr.bxO();
            }
            SvgManager.bwq().a(this.iLo, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.iLq.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.f.a.bwU().ai(dimens).ah(dimens).qr(R.color.CAM_X0207).bz(this.iLq);
            } else {
                ((ViewGroup.MarginLayoutParams) this.iLq.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.f.a.bwT().qI(R.color.CAM_X0207).qD(l.getDimens(getContext(), R.dimen.tbds10)).qE(R.color.CAM_X0804).qC(4353).qF(l.getDimens(getContext(), R.dimen.tbds10)).qG(0).qH(l.getDimens(getContext(), R.dimen.tbds5)).bz(this.iLq);
            }
            ao.setImageResource(this.iLp, R.drawable.icon_ba_close);
            ao.setViewTextColor(this.iLq, R.color.CAM_X0105);
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
