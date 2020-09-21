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
/* loaded from: classes21.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int foE;
    private TbImageView hFY;
    private TbCornersImageView hFZ;
    private ImageView hGa;
    private TextView hGb;
    private TBSpecificationBtn hGc;
    private f hGd;
    private boolean hGe;
    private float hGf;
    private float hGg;
    private float hGh;
    private float hGi;
    private float hGj;
    private float hGk;
    private float hGl;
    private float hGm;
    private int hGn;
    private boolean hGo;
    private a hGp;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.hGe = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.hGe = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.hGe = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.hFY = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.hFZ = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.hGa = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.hGb = (TextView) findViewById(R.id.cell_forum_test_des);
        this.hGc = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.a aVar = new com.baidu.tbadk.core.view.commonBtn.a();
        this.hGc.setTextSize(R.dimen.tbds42);
        this.hGc.setConfig(aVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.hFZ.setCornerTopLeftRadius(dimens);
        this.hFY.setRadius(dimens);
        this.hFY.setConrers(3);
        this.hFY.setPlaceHolder(3);
        this.hFY.setDrawCorner(true);
        this.foE = l.getDimens(context, R.dimen.tbds262);
        this.hGa.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.hGo) {
            this.hFY.getLayoutParams().height = this.mHeight - this.foE;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.hGa.setVisibility(0);
        } else {
            this.hGa.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.hGn = i;
    }

    public int getDataIndex() {
        return this.hGn;
    }

    public void setViewLeft(float f) {
        this.hGf = f;
    }

    public float getViewLeft() {
        return this.hGf;
    }

    public void setViewTop(float f) {
        this.hGg = f;
    }

    public float getViewTop() {
        return this.hGg;
    }

    public void setViewRight(float f) {
        this.hGh = f;
    }

    public float getViewRight() {
        return this.hGh;
    }

    public void setViewBottom(float f) {
        this.hGi = f;
    }

    public float getViewBottom() {
        return this.hGi;
    }

    public void setMoveLeft(float f) {
        this.hGj = f;
    }

    public float getMoveLeft() {
        return this.hGj;
    }

    public void setMoveTop(float f) {
        this.hGk = f;
    }

    public float getMoveTop() {
        return this.hGk;
    }

    public void setMoveRight(float f) {
        this.hGl = f;
    }

    public float getMoveRight() {
        return this.hGl;
    }

    public void setMoveBottom(float f) {
        this.hGm = f;
    }

    public float getMoveBottom() {
        return this.hGm;
    }

    public void setIsScale(boolean z) {
        this.hGo = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.hGp = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.hGd = fVar;
            this.hFY.startLoad(fVar.hFU ? fVar.hFV : fVar.imageUrl, 10, false);
            this.hGe = false;
            String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("enter_forum_test_id_list", "");
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
                        this.hGe = true;
                        break;
                    }
                }
            }
            this.hFZ.setVisibility(this.hGe ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.hGb.setText(R.string.cell_forum_test_title_default);
            } else {
                this.hGb.setText(fVar.title);
            }
            this.hGc.setText(getResources().getString(fVar.hFU ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.hGd;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        aq a;
        if (this.hGa == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new aq("c13373").u("uid", TbadkCoreApplication.getCurrentAccountId()).u("obj_id", this.hGd.testId));
                if (this.hGp != null) {
                    this.hGp.wF(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.hGd.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bg.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new aq("c13372").u("uid", TbadkCoreApplication.getCurrentAccountId()).u("obj_id", this.hGd.testId));
            int i = this.hGn;
            f fVar = this.hGd;
            if (this.hGd != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.dzC().b(this.mPageId, a);
            }
            if (!this.hGe) {
                String string = com.baidu.tbadk.core.sharedPref.b.bjf().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.hGd.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.bjf().putString("enter_forum_test_id_list", sb.toString());
            }
            this.hFZ.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.hGd.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.hFY != null) {
                this.hFY.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.hGc != null) {
                this.hGc.blA();
            }
            SvgManager.bkl().a(this.hFZ, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.hGb.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.bkL().Z(dimens).Y(dimens).or(R.color.cp_bg_line_h).bb(this.hGb);
            } else {
                ((ViewGroup.MarginLayoutParams) this.hGb.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.bkK().oG(R.color.cp_bg_line_h).oB(l.getDimens(getContext(), R.dimen.tbds10)).oC(R.color.cp_shadow_a_alpha16).oA(4353).oD(l.getDimens(getContext(), R.dimen.tbds10)).oE(0).oF(l.getDimens(getContext(), R.dimen.tbds5)).bb(this.hGb);
            }
            ap.setImageResource(this.hGa, R.drawable.icon_ba_close);
            ap.setViewTextColor(this.hGb, R.color.cp_cont_b);
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
