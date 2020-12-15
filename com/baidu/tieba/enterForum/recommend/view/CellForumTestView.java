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
    private int fWz;
    private TbImageView iza;
    private TbCornersImageView izb;
    private ImageView izc;
    private TextView izd;
    private TBSpecificationBtn ize;
    private f izf;
    private boolean izg;
    private float izh;
    private float izi;
    private float izj;
    private float izk;
    private float izl;
    private float izm;
    private float izn;
    private float izo;
    private int izp;
    private boolean izq;
    private a izr;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.izg = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.izg = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.izg = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.iza = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.izb = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.izc = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.izd = (TextView) findViewById(R.id.cell_forum_test_des);
        this.ize = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.ize.setTextSize(R.dimen.tbds42);
        this.ize.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.izb.setCornerTopLeftRadius(dimens);
        this.iza.setRadius(dimens);
        this.iza.setConrers(3);
        this.iza.setPlaceHolder(3);
        this.iza.setDrawCorner(true);
        this.fWz = l.getDimens(context, R.dimen.tbds262);
        this.izc.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.izq) {
            this.iza.getLayoutParams().height = this.mHeight - this.fWz;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.izc.setVisibility(0);
        } else {
            this.izc.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.izp = i;
    }

    public int getDataIndex() {
        return this.izp;
    }

    public void setViewLeft(float f) {
        this.izh = f;
    }

    public float getViewLeft() {
        return this.izh;
    }

    public void setViewTop(float f) {
        this.izi = f;
    }

    public float getViewTop() {
        return this.izi;
    }

    public void setViewRight(float f) {
        this.izj = f;
    }

    public float getViewRight() {
        return this.izj;
    }

    public void setViewBottom(float f) {
        this.izk = f;
    }

    public float getViewBottom() {
        return this.izk;
    }

    public void setMoveLeft(float f) {
        this.izl = f;
    }

    public float getMoveLeft() {
        return this.izl;
    }

    public void setMoveTop(float f) {
        this.izm = f;
    }

    public float getMoveTop() {
        return this.izm;
    }

    public void setMoveRight(float f) {
        this.izn = f;
    }

    public float getMoveRight() {
        return this.izn;
    }

    public void setMoveBottom(float f) {
        this.izo = f;
    }

    public float getMoveBottom() {
        return this.izo;
    }

    public void setIsScale(boolean z) {
        this.izq = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.izr = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.izf = fVar;
            this.iza.startLoad(fVar.iyW ? fVar.iyX : fVar.imageUrl, 10, false);
            this.izg = false;
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
                        this.izg = true;
                        break;
                    }
                }
            }
            this.izb.setVisibility(this.izg ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.izd.setText(R.string.cell_forum_test_title_default);
            } else {
                this.izd.setText(fVar.title);
            }
            this.ize.setText(getResources().getString(fVar.iyW ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.izf;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar a2;
        if (this.izc == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new ar("c13373").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.izf.testId));
                if (this.izr != null) {
                    this.izr.yU(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.izf.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bh.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new ar("c13372").w("uid", TbadkCoreApplication.getCurrentAccountId()).w("obj_id", this.izf.testId));
            int i = this.izp;
            f fVar = this.izf;
            if (this.izf != null && i >= 0 && (a2 = com.baidu.tieba.t.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.t.c.dOf().b(this.mPageId, a2);
            }
            if (!this.izg) {
                String string = com.baidu.tbadk.core.sharedPref.b.bsO().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.izf.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
            this.izb.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.izf.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iza != null) {
                this.iza.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.ize != null) {
                this.ize.bvt();
            }
            SvgManager.btW().a(this.izb, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.izd.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.buz().ag(dimens).af(dimens).qg(R.color.CAM_X0207).bq(this.izd);
            } else {
                ((ViewGroup.MarginLayoutParams) this.izd.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.buy().qx(R.color.CAM_X0207).qs(l.getDimens(getContext(), R.dimen.tbds10)).qt(R.color.CAM_X0804).qr(4353).qu(l.getDimens(getContext(), R.dimen.tbds10)).qv(0).qw(l.getDimens(getContext(), R.dimen.tbds5)).bq(this.izd);
            }
            ap.setImageResource(this.izc, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.izd, R.color.CAM_X0105);
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
