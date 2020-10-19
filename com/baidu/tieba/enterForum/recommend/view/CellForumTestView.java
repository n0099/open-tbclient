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
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.core.view.commonBtn.TBSpecificationBtn;
import com.baidu.tbadk.widget.TbCornersImageView;
import com.baidu.tbadk.widget.TbImageView;
import com.baidu.tieba.R;
import com.baidu.tieba.enterForum.recommend.b.f;
import com.baidu.tieba.enterForum.recommend.message.RequestTestCloseMessage;
/* loaded from: classes22.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int fAS;
    private TbImageView hUT;
    private TbCornersImageView hUU;
    private ImageView hUV;
    private TextView hUW;
    private TBSpecificationBtn hUX;
    private f hUY;
    private boolean hUZ;
    private float hVa;
    private float hVb;
    private float hVc;
    private float hVd;
    private float hVe;
    private float hVf;
    private float hVg;
    private float hVh;
    private int hVi;
    private boolean hVj;
    private a hVk;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hUZ = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hUZ = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hUZ = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.hUT = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.hUU = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.hUV = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.hUW = (TextView) findViewById(R.id.cell_forum_test_des);
        this.hUX = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.hUX.setTextSize(R.dimen.tbds42);
        this.hUX.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.hUU.setCornerTopLeftRadius(dimens);
        this.hUT.setRadius(dimens);
        this.hUT.setConrers(3);
        this.hUT.setPlaceHolder(3);
        this.hUT.setDrawCorner(true);
        this.fAS = l.getDimens(context, R.dimen.tbds262);
        this.hUV.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.hVj) {
            this.hUT.getLayoutParams().height = this.mHeight - this.fAS;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.hUV.setVisibility(0);
        } else {
            this.hUV.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.hVi = i;
    }

    public int getDataIndex() {
        return this.hVi;
    }

    public void setViewLeft(float f) {
        this.hVa = f;
    }

    public float getViewLeft() {
        return this.hVa;
    }

    public void setViewTop(float f) {
        this.hVb = f;
    }

    public float getViewTop() {
        return this.hVb;
    }

    public void setViewRight(float f) {
        this.hVc = f;
    }

    public float getViewRight() {
        return this.hVc;
    }

    public void setViewBottom(float f) {
        this.hVd = f;
    }

    public float getViewBottom() {
        return this.hVd;
    }

    public void setMoveLeft(float f) {
        this.hVe = f;
    }

    public float getMoveLeft() {
        return this.hVe;
    }

    public void setMoveTop(float f) {
        this.hVf = f;
    }

    public float getMoveTop() {
        return this.hVf;
    }

    public void setMoveRight(float f) {
        this.hVg = f;
    }

    public float getMoveRight() {
        return this.hVg;
    }

    public void setMoveBottom(float f) {
        this.hVh = f;
    }

    public float getMoveBottom() {
        return this.hVh;
    }

    public void setIsScale(boolean z) {
        this.hVj = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.hVk = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.hUY = fVar;
            this.hUT.startLoad(fVar.hUP ? fVar.hUQ : fVar.imageUrl, 10, false);
            this.hUZ = false;
            String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("enter_forum_test_id_list", "");
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
                        this.hUZ = true;
                        break;
                    }
                }
            }
            this.hUU.setVisibility(this.hUZ ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.hUW.setText(R.string.cell_forum_test_title_default);
            } else {
                this.hUW.setText(fVar.title);
            }
            this.hUX.setText(getResources().getString(fVar.hUP ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.hUY;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq a2;
        if (this.hUV == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new aq("c13373").u("uid", TbadkCoreApplication.getCurrentAccountId()).u("obj_id", this.hUY.testId));
                if (this.hVk != null) {
                    this.hVk.xl(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.hUY.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bg.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new aq("c13372").u("uid", TbadkCoreApplication.getCurrentAccountId()).u("obj_id", this.hUY.testId));
            int i = this.hVi;
            f fVar = this.hUY;
            if (this.hUY != null && i >= 0 && (a2 = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dDn().b(this.mPageId, a2);
            }
            if (!this.hUZ) {
                String string = com.baidu.tbadk.core.sharedPref.b.blO().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.hUY.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.blO().putString("enter_forum_test_id_list", sb.toString());
            }
            this.hUU.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.hUY.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hUT != null) {
                this.hUT.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.hUX != null) {
                this.hUX.bok();
            }
            SvgManager.bmU().a(this.hUU, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.hUW.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.bnv().ab(dimens).aa(dimens).oP(R.color.cp_bg_line_h).bf(this.hUW);
            } else {
                ((ViewGroup.MarginLayoutParams) this.hUW.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.bnu().pe(R.color.cp_bg_line_h).oZ(l.getDimens(getContext(), R.dimen.tbds10)).pa(R.color.cp_shadow_a_alpha16).oY(4353).pb(l.getDimens(getContext(), R.dimen.tbds10)).pc(0).pd(l.getDimens(getContext(), R.dimen.tbds5)).bf(this.hUW);
            }
            ap.setImageResource(this.hUV, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.hUW, R.color.cp_cont_b);
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
