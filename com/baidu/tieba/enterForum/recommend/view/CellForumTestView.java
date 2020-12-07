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
/* loaded from: classes22.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int fWx;
    private TbImageView iyY;
    private TbCornersImageView iyZ;
    private ImageView iza;
    private TextView izb;
    private TBSpecificationBtn izc;
    private f izd;
    private boolean ize;
    private float izf;
    private float izg;
    private float izh;
    private float izi;
    private float izj;
    private float izk;
    private float izl;
    private float izm;
    private int izn;
    private boolean izo;
    private a izp;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.ize = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.ize = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.ize = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.iyY = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.iyZ = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.iza = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.izb = (TextView) findViewById(R.id.cell_forum_test_des);
        this.izc = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.izc.setTextSize(R.dimen.tbds42);
        this.izc.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.iyZ.setCornerTopLeftRadius(dimens);
        this.iyY.setRadius(dimens);
        this.iyY.setConrers(3);
        this.iyY.setPlaceHolder(3);
        this.iyY.setDrawCorner(true);
        this.fWx = l.getDimens(context, R.dimen.tbds262);
        this.iza.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.izo) {
            this.iyY.getLayoutParams().height = this.mHeight - this.fWx;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.iza.setVisibility(0);
        } else {
            this.iza.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.izn = i;
    }

    public int getDataIndex() {
        return this.izn;
    }

    public void setViewLeft(float f) {
        this.izf = f;
    }

    public float getViewLeft() {
        return this.izf;
    }

    public void setViewTop(float f) {
        this.izg = f;
    }

    public float getViewTop() {
        return this.izg;
    }

    public void setViewRight(float f) {
        this.izh = f;
    }

    public float getViewRight() {
        return this.izh;
    }

    public void setViewBottom(float f) {
        this.izi = f;
    }

    public float getViewBottom() {
        return this.izi;
    }

    public void setMoveLeft(float f) {
        this.izj = f;
    }

    public float getMoveLeft() {
        return this.izj;
    }

    public void setMoveTop(float f) {
        this.izk = f;
    }

    public float getMoveTop() {
        return this.izk;
    }

    public void setMoveRight(float f) {
        this.izl = f;
    }

    public float getMoveRight() {
        return this.izl;
    }

    public void setMoveBottom(float f) {
        this.izm = f;
    }

    public float getMoveBottom() {
        return this.izm;
    }

    public void setIsScale(boolean z) {
        this.izo = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.izp = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.izd = fVar;
            this.iyY.startLoad(fVar.iyU ? fVar.iyV : fVar.imageUrl, 10, false);
            this.ize = false;
            String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("enter_forum_test_id_list", "");
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
                        this.ize = true;
                        break;
                    }
                }
            }
            this.iyZ.setVisibility(this.ize ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.izb.setText(R.string.cell_forum_test_title_default);
            } else {
                this.izb.setText(fVar.title);
            }
            this.izc.setText(getResources().getString(fVar.iyU ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.izd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar a2;
        if (this.iza == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new ar("c13373").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.izd.testId));
                if (this.izp != null) {
                    this.izp.yU(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.izd.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bh.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new ar("c13372").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.izd.testId));
            int i = this.izn;
            f fVar = this.izd;
            if (this.izd != null && i >= 0 && (a2 = com.baidu.tieba.t.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.t.c.dOe().b(this.mPageId, a2);
            }
            if (!this.ize) {
                String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.izd.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.bsO().putString("enter_forum_test_id_list", sb.toString());
            }
            this.iyZ.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.izd.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iyY != null) {
                this.iyY.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.izc != null) {
                this.izc.bvt();
            }
            SvgManager.btW().a(this.iyZ, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.izb.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.buz().ag(dimens).af(dimens).qg(R.color.CAM_X0207).bq(this.izb);
            } else {
                ((ViewGroup.MarginLayoutParams) this.izb.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0207).qs(l.getDimens(getContext(), R.dimen.tbds10)).qt(R.color.CAM_X0804).qr(4353).qu(l.getDimens(getContext(), R.dimen.tbds10)).qv(0).qw(l.getDimens(getContext(), R.dimen.tbds5)).bq(this.izb);
            }
            ap.setImageResource(this.iza, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.izb, R.color.CAM_X0105);
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
