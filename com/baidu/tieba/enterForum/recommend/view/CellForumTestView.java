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
/* loaded from: classes7.dex */
public class CellForumTestView extends RelativeLayout implements View.OnClickListener {
    private int dQh;
    private TbImageView fVf;
    private TbCornersImageView fVg;
    private ImageView fVh;
    private TextView fVi;
    private TBSpecificationBtn fVj;
    private f fVk;
    private boolean fVl;
    private float fVm;
    private float fVn;
    private float fVo;
    private float fVp;
    private float fVq;
    private float fVr;
    private float fVs;
    private float fVt;
    private int fVu;
    private boolean fVv;
    private a fVw;
    private int mHeight;
    private int mIndex;
    private BdUniqueId mPageId;
    private int mSkinType;
    private int mWidth;

    public CellForumTestView(Context context) {
        super(context);
        this.mSkinType = 3;
        this.fVl = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mSkinType = 3;
        this.fVl = false;
        init(context);
    }

    public CellForumTestView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mSkinType = 3;
        this.fVl = false;
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.cell_forum_test_layout, (ViewGroup) this, true);
        this.fVf = (TbImageView) findViewById(R.id.cell_forum_test_img);
        this.fVg = (TbCornersImageView) findViewById(R.id.cell_forum_test_new);
        this.fVh = (ImageView) findViewById(R.id.cell_forum_test_del);
        this.fVi = (TextView) findViewById(R.id.cell_forum_test_des);
        this.fVj = (TBSpecificationBtn) findViewById(R.id.cell_forum_test_btn);
        com.baidu.tbadk.core.view.commonBtn.b bVar = new com.baidu.tbadk.core.view.commonBtn.b();
        this.fVj.setTextSize(R.dimen.tbds42);
        this.fVj.setConfig(bVar);
        int dimens = l.getDimens(context, R.dimen.tbds10);
        this.fVg.setCornerTopLeftRadius(dimens);
        this.fVf.setRadius(dimens);
        this.fVf.setConrers(3);
        this.fVf.setPlaceHolder(3);
        this.fVf.setDrawCorner(true);
        this.dQh = l.getDimens(context, R.dimen.tbds262);
        this.fVh.setOnClickListener(this);
        setOnClickListener(this);
        onChangeSkinType();
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        this.mWidth = View.MeasureSpec.getSize(i);
        this.mHeight = View.MeasureSpec.getSize(i2);
        if (!this.fVv) {
            this.fVf.getLayoutParams().height = this.mHeight - this.dQh;
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(this.mWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(this.mHeight, 1073741824));
    }

    public void setIndex(int i) {
        this.mIndex = i;
        if (this.mIndex == 1) {
            this.fVh.setVisibility(0);
        } else {
            this.fVh.setVisibility(8);
        }
    }

    public int getIndex() {
        return this.mIndex;
    }

    public void setDataIndex(int i) {
        this.fVu = i;
    }

    public int getDataIndex() {
        return this.fVu;
    }

    public void setViewLeft(float f) {
        this.fVm = f;
    }

    public float getViewLeft() {
        return this.fVm;
    }

    public void setViewTop(float f) {
        this.fVn = f;
    }

    public float getViewTop() {
        return this.fVn;
    }

    public void setViewRight(float f) {
        this.fVo = f;
    }

    public float getViewRight() {
        return this.fVo;
    }

    public void setViewBottom(float f) {
        this.fVp = f;
    }

    public float getViewBottom() {
        return this.fVp;
    }

    public void setMoveLeft(float f) {
        this.fVq = f;
    }

    public float getMoveLeft() {
        return this.fVq;
    }

    public void setMoveTop(float f) {
        this.fVr = f;
    }

    public float getMoveTop() {
        return this.fVr;
    }

    public void setMoveRight(float f) {
        this.fVs = f;
    }

    public float getMoveRight() {
        return this.fVs;
    }

    public void setMoveBottom(float f) {
        this.fVt = f;
    }

    public float getMoveBottom() {
        return this.fVt;
    }

    public void setIsScale(boolean z) {
        this.fVv = z;
    }

    public void setForumTestDelClickListener(a aVar) {
        this.fVw = aVar;
    }

    public void setData(f fVar) {
        if (fVar != null) {
            this.fVk = fVar;
            this.fVf.startLoad(fVar.fVb ? fVar.fVc : fVar.imageUrl, 10, false);
            this.fVl = false;
            String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("enter_forum_test_id_list", "");
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
                        this.fVl = true;
                        break;
                    }
                }
            }
            this.fVg.setVisibility(this.fVl ? 8 : 0);
            if (StringUtils.isNull(fVar.title)) {
                this.fVi.setText(R.string.cell_forum_test_title_default);
            } else {
                this.fVi.setText(fVar.title);
            }
            this.fVj.setText(getResources().getString(fVar.fVb ? R.string.cell_forum_retest_default : R.string.cell_forum_test_default));
        }
    }

    public f getData() {
        return this.fVk;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        an a;
        if (this.fVh == view) {
            if (j.isNetworkAvailableForImmediately() && this.mIndex == 1) {
                TiebaStatic.log(new an("c13373").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fVk.testId));
                if (this.fVw != null) {
                    this.fVw.rO(this.mIndex);
                }
                RequestTestCloseMessage requestTestCloseMessage = new RequestTestCloseMessage();
                requestTestCloseMessage.setTestId(this.fVk.testId);
                requestTestCloseMessage.setFromPage(1L);
                MessageManager.getInstance().sendMessage(requestTestCloseMessage);
            }
        } else if (bc.checkUpIsLogin(getContext())) {
            TiebaStatic.log(new an("c13372").s("uid", TbadkCoreApplication.getCurrentAccountId()).s("obj_id", this.fVk.testId));
            int i = this.fVu;
            f fVar = this.fVk;
            if (this.fVk != null && i >= 0 && (a = com.baidu.tieba.r.a.a(true, "a065", "common_click", i + 1, i + 1, false, (String) null, String.valueOf(fVar.testId), 0)) != null) {
                com.baidu.tieba.r.c.cIs().b(this.mPageId, a);
            }
            if (!this.fVl) {
                String string = com.baidu.tbadk.core.sharedPref.b.aDr().getString("enter_forum_test_id_list", "");
                String[] split = string.split("[|]");
                String str = this.fVk.testId + "*" + TbadkCoreApplication.getCurrentAccountId();
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
                com.baidu.tbadk.core.sharedPref.b.aDr().putString("enter_forum_test_id_list", sb.toString());
            }
            this.fVg.setVisibility(8);
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new ForumTestActivityConfig(getContext(), this.fVk.testId)));
        }
    }

    public void onChangeSkinType() {
        int skinType = TbadkCoreApplication.getInst().getSkinType();
        if (skinType != this.mSkinType) {
            this.mSkinType = skinType;
            if (this.fVf != null) {
                this.fVf.setIsNight(this.mSkinType == 1 || skinType == 4);
            }
            if (this.fVj != null) {
                this.fVj.aFw();
            }
            SvgManager.aEp().a(this.fVg, R.drawable.icon_mask_ba_new30_svg, SvgManager.SvgResourceStateType.NORMAL);
            if (skinType == 1 || skinType == 4) {
                ((ViewGroup.MarginLayoutParams) this.fVi.getLayoutParams()).setMargins(l.getDimens(getContext(), R.dimen.tbds4), 0, l.getDimens(getContext(), R.dimen.tbds9), 0);
                int dimens = l.getDimens(getContext(), R.dimen.tbds10);
                com.baidu.tbadk.core.util.f.a.aEM().ak(dimens).aj(dimens).kl(R.color.cp_bg_line_h).aQ(this.fVi);
            } else {
                ((ViewGroup.MarginLayoutParams) this.fVi.getLayoutParams()).setMargins(0, 0, 0, 0);
                com.baidu.tbadk.core.util.f.a.aEL().kA(R.color.cp_bg_line_h).kv(l.getDimens(getContext(), R.dimen.tbds10)).kw(R.color.cp_shadow_a_alpha16).ku(4353).kx(l.getDimens(getContext(), R.dimen.tbds10)).ky(0).kz(l.getDimens(getContext(), R.dimen.tbds5)).aQ(this.fVi);
            }
            am.setImageResource(this.fVh, R.drawable.icon_ba_close);
            am.setViewTextColor(this.fVi, (int) R.color.cp_cont_b);
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
