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
    private int dUo;
    private TbImageView fXi;
    private TbCornersImageView fXj;
    private ImageView fXk;
    private TextView fXl;
    private TBSpecificationBtn fXm;
    private f fXn;
    private boolean fXo;
    private float fXp;
    private float fXq;
    private float fXr;
    private float fXs;
    private float fXt;
    private float fXu;
    private float fXv;
    private float fXw;
    private int fXx;
    private boolean fXy;
    private a fXz;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fXo = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fXo = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fXo = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.fXi = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.fXj = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.fXk = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.fXl = (TextView) findViewById(R.id.cell_forum_test_des);
        this.fXm = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.fXm.setTextSize(R.dimen.tbds42);
        this.fXm.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.fXj.setCornerTopLeftRadius(dimens);
        this.fXi.setRadius(dimens);
        this.fXi.setConrers(3);
        this.fXi.setPlaceHolder(3);
        this.fXi.setDrawCorner(true);
        this.dUo = l.getDimens(context, R.dimen.tbds262);
        this.fXk.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.fXy) {
            this.fXi.getLayoutParams().height = this.mHeight - this.dUo;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.fXk.setVisibility(0);
        } else {
            this.fXk.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.fXx = i;
    }

    public int getDataIndex() {
        return this.fXx;
    }

    public void setViewLeft(float f) {
        this.fXp = f;
    }

    public float getViewLeft() {
        return this.fXp;
    }

    public void setViewTop(float f) {
        this.fXq = f;
    }

    public float getViewTop() {
        return this.fXq;
    }

    public void setViewRight(float f) {
        this.fXr = f;
    }

    public float getViewRight() {
        return this.fXr;
    }

    public void setViewBottom(float f) {
        this.fXs = f;
    }

    public float getViewBottom() {
        return this.fXs;
    }

    public void setMoveLeft(float f) {
        this.fXt = f;
    }

    public float getMoveLeft() {
        return this.fXt;
    }

    public void setMoveTop(float f) {
        this.fXu = f;
    }

    public float getMoveTop() {
        return this.fXu;
    }

    public void setMoveRight(float f) {
        this.fXv = f;
    }

    public float getMoveRight() {
        return this.fXv;
    }

    public void setMoveBottom(float f) {
        this.fXw = f;
    }

    public float getMoveBottom() {
        return this.fXw;
    }

    public void setIsScale(boolean z) {
        this.fXy = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.fXz = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.fXn = fVar;
            this.fXi.startLoad(fVar.fXe ? fVar.fXf : fVar.imageUrl, 10, false);
            this.fXo = false;
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
                        this.fXo = true;
                        break;
                    }
                }
            }
            this.fXj.setVisibility(this.fXo ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.fXl.setText(R.string.cell_forum_test_title_default);
            } else {
                this.fXl.setText(fVar.title);
            }
            this.fXm.setText(getResources().getString(fVar.fXe ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.fXn;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.fXk == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fXn.testId));
                if (this.fXz != null) {
                    this.fXz.rU(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.fXn.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fXn.testId));
            int i = this.fXx;
            f fVar = this.fXn;
            if (this.fXn != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.cKa().b(this.mPageId, a);
            }
            if (!this.fXo) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFD().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.fXn.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
            this.fXj.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.fXn.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fXi != null) {
                this.fXi.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.fXm != null) {
                this.fXm.aHN();
            }
            SvgManager.aGC().a(this.fXj, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.fXl.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.f.a.aHa().aj(dimens).ai(dimens).kC(R.color.cp_bg_line_h).aQ(this.fXl);
            } else {
                ((ViewGroup.MarginLayoutParams) this.fXl.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.f.a.aGZ().kR(R.color.cp_bg_line_h).kM(l.getDimens(getContext(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(getContext(), R.dimen.tbds10)).kP(0).kQ(l.getDimens(getContext(), R.dimen.tbds5)).aQ(this.fXl);
            }
            am.setImageResource(this.fXk, R.drawable.icon_ba_close);
            am.setViewTextColor(this.fXl, (int) R.color.cp_cont_b);
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
