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
    private int gfu;
    private float iOA;
    private int iOB;
    private boolean iOC;
    private a iOD;
    private TbImageView iOm;
    private TbCornersImageView iOn;
    private ImageView iOo;
    private TextView iOp;
    private TBSpecificationBtn iOq;
    private f iOr;
    private boolean iOs;
    private float iOt;
    private float iOu;
    private float iOv;
    private float iOw;
    private float iOx;
    private float iOy;
    private float iOz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.iOs = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.iOs = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.iOs = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.iOm = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.iOn = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.iOo = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.iOp = (TextView) findViewById(R.id.cell_forum_test_des);
        this.iOq = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.iOq.setTextSize(R.dimen.tbds42);
        this.iOq.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.iOn.setCornerTopLeftRadius(dimens);
        this.iOm.setRadius(dimens);
        this.iOm.setConrers(3);
        this.iOm.setPlaceHolder(3);
        this.iOm.setDrawCorner(true);
        this.gfu = l.getDimens(context, R.dimen.tbds262);
        this.iOo.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.iOC) {
            this.iOm.getLayoutParams().height = this.mHeight - this.gfu;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.iOo.setVisibility(0);
        } else {
            this.iOo.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.iOB = i;
    }

    public int getDataIndex() {
        return this.iOB;
    }

    public void setViewLeft(float f) {
        this.iOt = f;
    }

    public float getViewLeft() {
        return this.iOt;
    }

    public void setViewTop(float f) {
        this.iOu = f;
    }

    public float getViewTop() {
        return this.iOu;
    }

    public void setViewRight(float f) {
        this.iOv = f;
    }

    public float getViewRight() {
        return this.iOv;
    }

    public void setViewBottom(float f) {
        this.iOw = f;
    }

    public float getViewBottom() {
        return this.iOw;
    }

    public void setMoveLeft(float f) {
        this.iOx = f;
    }

    public float getMoveLeft() {
        return this.iOx;
    }

    public void setMoveTop(float f) {
        this.iOy = f;
    }

    public float getMoveTop() {
        return this.iOy;
    }

    public void setMoveRight(float f) {
        this.iOz = f;
    }

    public float getMoveRight() {
        return this.iOz;
    }

    public void setMoveBottom(float f) {
        this.iOA = f;
    }

    public float getMoveBottom() {
        return this.iOA;
    }

    public void setIsScale(boolean z) {
        this.iOC = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.iOD = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.iOr = fVar;
            this.iOm.startLoad(fVar.iOi ? fVar.iOj : fVar.imageUrl, 10, false);
            this.iOs = false;
            String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("enter_forum_test_id_list", "");
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
                        this.iOs = true;
                        break;
                    }
                }
            }
            this.iOn.setVisibility(this.iOs ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.iOp.setText(R.string.cell_forum_test_title_default);
            } else {
                this.iOp.setText(fVar.title);
            }
            this.iOq.setText(getResources().getString(fVar.iOi ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.iOr;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ar a2;
        if (this.iOo == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new ar("c13373").v("uid", TbadkCoreApplication.getCurrentAccountId()).v("obj_id", this.iOr.testId));
                if (this.iOD != null) {
                    this.iOD.xM(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.iOr.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bh.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new ar("c13372").v("uid", TbadkCoreApplication.getCurrentAccountId()).v("obj_id", this.iOr.testId));
            int i = this.iOB;
            f fVar = this.iOr;
            if (this.iOr != null && i >= 0 && (a2 = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dMH().b(this.mPageId, a2);
            }
            if (!this.iOs) {
                String string = com.baidu.tbadk.core.sharedPref.b.brR().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.iOr.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.brR().putString("enter_forum_test_id_list", sb.toString());
            }
            this.iOn.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.iOr.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.iOm != null) {
                this.iOm.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.iOq != null) {
                this.iOq.bus();
            }
            SvgManager.bsU().a(this.iOn, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.iOp.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.f.a.bty().an(dimens).am(dimens).oQ(R.color.CAM_X0207).bv(this.iOp);
            } else {
                ((ViewGroup.MarginLayoutParams) this.iOp.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.f.a.btx().ph(R.color.CAM_X0207).pc(l.getDimens(getContext(), R.dimen.tbds10)).pd(R.color.CAM_X0804).pb(4353).pe(l.getDimens(getContext(), R.dimen.tbds10)).pf(0).pg(l.getDimens(getContext(), R.dimen.tbds5)).bv(this.iOp);
            }
            ap.setImageResource(this.iOo, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.iOp, R.color.CAM_X0105);
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
