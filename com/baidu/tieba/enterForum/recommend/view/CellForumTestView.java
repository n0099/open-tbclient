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
    private int dUR;
    private TbImageView fYd;
    private TbCornersImageView fYe;
    private ImageView fYf;
    private TextView fYg;
    private TBSpecificationBtn fYh;
    private f fYi;
    private boolean fYj;
    private float fYk;
    private float fYl;
    private float fYm;
    private float fYn;
    private float fYo;
    private float fYp;
    private float fYq;
    private float fYr;
    private int fYs;
    private boolean fYt;
    private a fYu;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fYj = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fYj = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fYj = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.fYd = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.fYe = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.fYf = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.fYg = (TextView) findViewById(R.id.cell_forum_test_des);
        this.fYh = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.fYh.setTextSize(R.dimen.tbds42);
        this.fYh.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.fYe.setCornerTopLeftRadius(dimens);
        this.fYd.setRadius(dimens);
        this.fYd.setConrers(3);
        this.fYd.setPlaceHolder(3);
        this.fYd.setDrawCorner(true);
        this.dUR = l.getDimens(context, R.dimen.tbds262);
        this.fYf.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.fYt) {
            this.fYd.getLayoutParams().height = this.mHeight - this.dUR;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.fYf.setVisibility(0);
        } else {
            this.fYf.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.fYs = i;
    }

    public int getDataIndex() {
        return this.fYs;
    }

    public void setViewLeft(float f) {
        this.fYk = f;
    }

    public float getViewLeft() {
        return this.fYk;
    }

    public void setViewTop(float f) {
        this.fYl = f;
    }

    public float getViewTop() {
        return this.fYl;
    }

    public void setViewRight(float f) {
        this.fYm = f;
    }

    public float getViewRight() {
        return this.fYm;
    }

    public void setViewBottom(float f) {
        this.fYn = f;
    }

    public float getViewBottom() {
        return this.fYn;
    }

    public void setMoveLeft(float f) {
        this.fYo = f;
    }

    public float getMoveLeft() {
        return this.fYo;
    }

    public void setMoveTop(float f) {
        this.fYp = f;
    }

    public float getMoveTop() {
        return this.fYp;
    }

    public void setMoveRight(float f) {
        this.fYq = f;
    }

    public float getMoveRight() {
        return this.fYq;
    }

    public void setMoveBottom(float f) {
        this.fYr = f;
    }

    public float getMoveBottom() {
        return this.fYr;
    }

    public void setIsScale(boolean z) {
        this.fYt = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.fYu = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.fYi = fVar;
            this.fYd.startLoad(fVar.fXZ ? fVar.fYa : fVar.imageUrl, 10, false);
            this.fYj = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("enter_forum_test_id_list", "");
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
                        this.fYj = true;
                        break;
                    }
                }
            }
            this.fYe.setVisibility(this.fYj ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.fYg.setText(R.string.cell_forum_test_title_default);
            } else {
                this.fYg.setText(fVar.title);
            }
            this.fYh.setText(getResources().getString(fVar.fXZ ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.fYi;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.fYf == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fYi.testId));
                if (this.fYu != null) {
                    this.fYu.rW(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.fYi.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fYi.testId));
            int i = this.fYs;
            f fVar = this.fYi;
            if (this.fYi != null && i >= 0 && (a = com.baidu.tieba.s.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.s.c.cKv().b(this.mPageId, a);
            }
            if (!this.fYj) {
                String string = com.baidu.tbadk.core.sharedPref.b.aFH().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.fYi.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.aFH().putString("enter_forum_test_id_list", sb.toString());
            }
            this.fYe.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.fYi.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fYd != null) {
                this.fYd.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.fYh != null) {
                this.fYh.aHS();
            }
            SvgManager.aGG().a(this.fYe, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.fYg.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.e.a.aHf().aj(dimens).ai(dimens).kC(R.color.cp_bg_line_h).aQ(this.fYg);
            } else {
                ((ViewGroup.MarginLayoutParams) this.fYg.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.e.a.aHe().kR(R.color.cp_bg_line_h).kM(l.getDimens(getContext(), R.dimen.tbds10)).kN(R.color.cp_shadow_a_alpha16).kL(4353).kO(l.getDimens(getContext(), R.dimen.tbds10)).kP(0).kQ(l.getDimens(getContext(), R.dimen.tbds5)).aQ(this.fYg);
            }
            am.setImageResource(this.fYf, R.drawable.icon_ba_close);
            am.setViewTextColor(this.fYg, (int) R.color.cp_cont_b);
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
