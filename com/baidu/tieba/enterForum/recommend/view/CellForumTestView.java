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
    private int gdL;
    private float iMA;
    private float iMB;
    private float iMC;
    private float iMD;
    private int iME;
    private boolean iMF;
    private a iMG;
    private TbImageView iMp;
    private TbCornersImageView iMq;
    private ImageView iMr;
    private TextView iMs;
    private TBSpecificationBtn iMt;
    private f iMu;
    private boolean iMv;
    private float iMw;
    private float iMx;
    private float iMy;
    private float iMz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iMv = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iMv = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iMv = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.iMp = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.iMq = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.iMr = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.iMs = (TextView) findViewById(R.id.cell_forum_test_des);
        this.iMt = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.iMt.setTextSize(R.dimen.tbds42);
        this.iMt.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.iMq.setCornerTopLeftRadius(dimens);
        this.iMp.setRadius(dimens);
        this.iMp.setConrers(3);
        this.iMp.setPlaceHolder(3);
        this.iMp.setDrawCorner(true);
        this.gdL = l.getDimens(context, R.dimen.tbds262);
        this.iMr.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.iMF) {
            this.iMp.getLayoutParams().height = this.mHeight - this.gdL;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.iMr.setVisibility(0);
        } else {
            this.iMr.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.iME = i;
    }

    public int getDataIndex() {
        return this.iME;
    }

    public void setViewLeft(float f) {
        this.iMw = f;
    }

    public float getViewLeft() {
        return this.iMw;
    }

    public void setViewTop(float f) {
        this.iMx = f;
    }

    public float getViewTop() {
        return this.iMx;
    }

    public void setViewRight(float f) {
        this.iMy = f;
    }

    public float getViewRight() {
        return this.iMy;
    }

    public void setViewBottom(float f) {
        this.iMz = f;
    }

    public float getViewBottom() {
        return this.iMz;
    }

    public void setMoveLeft(float f) {
        this.iMA = f;
    }

    public float getMoveLeft() {
        return this.iMA;
    }

    public void setMoveTop(float f) {
        this.iMB = f;
    }

    public float getMoveTop() {
        return this.iMB;
    }

    public void setMoveRight(float f) {
        this.iMC = f;
    }

    public float getMoveRight() {
        return this.iMC;
    }

    public void setMoveBottom(float f) {
        this.iMD = f;
    }

    public float getMoveBottom() {
        return this.iMD;
    }

    public void setIsScale(boolean z) {
        this.iMF = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.iMG = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.iMu = fVar;
            this.iMp.startLoad(fVar.iMl ? fVar.iMm : fVar.imageUrl, 10, false);
            this.iMv = false;
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
                        this.iMv = true;
                        break;
                    }
                }
            }
            this.iMq.setVisibility(this.iMv ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.iMs.setText(R.string.cell_forum_test_title_default);
            } else {
                this.iMs.setText(fVar.title);
            }
            this.iMt.setText(getResources().getString(fVar.iMl ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.iMu;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar a2;
        if (this.iMr == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new ar("c13373").v("uid", TbadkCoreApplication.getCurrentAccountId()).v("obj_id", this.iMu.testId));
                if (this.iMG != null) {
                    this.iMG.xL(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.iMu.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bh.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new ar("c13372").v("uid", TbadkCoreApplication.getCurrentAccountId()).v("obj_id", this.iMu.testId));
            int i = this.iME;
            f fVar = this.iMu;
            if (this.iMu != null && i >= 0 && (a2 = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dMr().b(this.mPageId, a2);
            }
            if (!this.iMv) {
                String string = com.baidu.tbadk.core.sharedPref.b.brQ().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.iMu.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
            this.iMq.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.iMu.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iMp != null) {
                this.iMp.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.iMt != null) {
                this.iMt.bup();
            }
            SvgManager.bsR().a(this.iMq, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.iMs.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.f.a.btv().aj(dimens).ai(dimens).oP(R.color.CAM_X0207).bv(this.iMs);
            } else {
                ((ViewGroup.MarginLayoutParams) this.iMs.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.f.a.btu().pg(R.color.CAM_X0207).pb(l.getDimens(getContext(), R.dimen.tbds10)).pc(R.color.CAM_X0804).pa(4353).pd(l.getDimens(getContext(), R.dimen.tbds10)).pe(0).pf(l.getDimens(getContext(), R.dimen.tbds5)).bv(this.iMs);
            }
            ap.setImageResource(this.iMr, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.iMs, R.color.CAM_X0105);
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
