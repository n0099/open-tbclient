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
import com.baidu.tbadk.core.util.an;
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.be;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes9.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int eTU;
    private float hgA;
    private float hgB;
    private float hgC;
    private float hgD;
    private int hgE;
    private boolean hgF;
    private a hgG;
    private TbImageView hgp;
    private TbCornersImageView hgq;
    private ImageView hgr;
    private TextView hgs;
    private TBSpecificationBtn hgt;
    private f hgu;
    private boolean hgv;
    private float hgw;
    private float hgx;
    private float hgy;
    private float hgz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hgv = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hgv = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hgv = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.hgp = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.hgq = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.hgr = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.hgs = (TextView) findViewById(R.id.cell_forum_test_des);
        this.hgt = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.hgt.setTextSize(R.dimen.tbds42);
        this.hgt.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.hgq.setCornerTopLeftRadius(dimens);
        this.hgp.setRadius(dimens);
        this.hgp.setConrers(3);
        this.hgp.setPlaceHolder(3);
        this.hgp.setDrawCorner(true);
        this.eTU = l.getDimens(context, R.dimen.tbds262);
        this.hgr.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.hgF) {
            this.hgp.getLayoutParams().height = this.mHeight - this.eTU;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.hgr.setVisibility(0);
        } else {
            this.hgr.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.hgE = i;
    }

    public int getDataIndex() {
        return this.hgE;
    }

    public void setViewLeft(float f) {
        this.hgw = f;
    }

    public float getViewLeft() {
        return this.hgw;
    }

    public void setViewTop(float f) {
        this.hgx = f;
    }

    public float getViewTop() {
        return this.hgx;
    }

    public void setViewRight(float f) {
        this.hgy = f;
    }

    public float getViewRight() {
        return this.hgy;
    }

    public void setViewBottom(float f) {
        this.hgz = f;
    }

    public float getViewBottom() {
        return this.hgz;
    }

    public void setMoveLeft(float f) {
        this.hgA = f;
    }

    public float getMoveLeft() {
        return this.hgA;
    }

    public void setMoveTop(float f) {
        this.hgB = f;
    }

    public float getMoveTop() {
        return this.hgB;
    }

    public void setMoveRight(float f) {
        this.hgC = f;
    }

    public float getMoveRight() {
        return this.hgC;
    }

    public void setMoveBottom(float f) {
        this.hgD = f;
    }

    public float getMoveBottom() {
        return this.hgD;
    }

    public void setIsScale(boolean z) {
        this.hgF = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.hgG = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.hgu = fVar;
            this.hgp.startLoad(fVar.hgl ? fVar.hgm : fVar.imageUrl, 10, false);
            this.hgv = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("enter_forum_test_id_list", "");
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
                        this.hgv = true;
                        break;
                    }
                }
            }
            this.hgq.setVisibility(this.hgv ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.hgs.setText(R.string.cell_forum_test_title_default);
            } else {
                this.hgs.setText(fVar.title);
            }
            this.hgt.setText(getResources().getString(fVar.hgl ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.hgu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ao a;
        if (this.hgr == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new ao("c13373").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.hgu.testId));
                if (this.hgG != null) {
                    this.hgG.tz(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.hgu.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (be.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new ao("c13372").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.hgu.testId));
            int i = this.hgE;
            f fVar = this.hgu;
            if (this.hgu != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dgX().b(this.mPageId, a);
            }
            if (!this.hgv) {
                String string = com.baidu.tbadk.core.sharedPref.b.aVP().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.hgu.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.aVP().putString("enter_forum_test_id_list", sb.toString());
            }
            this.hgq.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.hgu.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hgp != null) {
                this.hgp.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.hgt != null) {
                this.hgt.aYj();
            }
            SvgManager.aWQ().a(this.hgq, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.hgs.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.aXq().U(dimens).T(dimens).lH(R.color.cp_bg_line_h).aR(this.hgs);
            } else {
                ((ViewGroup.MarginLayoutParams) this.hgs.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.aXp().lW(R.color.cp_bg_line_h).lR(l.getDimens(getContext(), R.dimen.tbds10)).lS(R.color.cp_shadow_a_alpha16).lQ(4353).lT(l.getDimens(getContext(), R.dimen.tbds10)).lU(0).lV(l.getDimens(getContext(), R.dimen.tbds5)).aR(this.hgs);
            }
            an.setImageResource(this.hgr, R.drawable.icon_ba_close);
            an.setViewTextColor(this.hgs, (int) R.color.cp_cont_b);
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
